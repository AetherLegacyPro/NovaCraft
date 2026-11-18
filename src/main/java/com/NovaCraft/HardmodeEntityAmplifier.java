package com.NovaCraft;

import java.util.UUID;
import com.NovaCraft.config.Configs;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.entity.boss.IBossDisplayData;
import net.minecraft.entity.monster.EntityGiantZombie;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.monster.IMob;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;

public class HardmodeEntityAmplifier {
    private static final String HEALTH_APPLIED = "NovaCraftHardmodeHealthApplied";
    private static final String EXTRAS_APPLIED = "NovaCraftHardmodeExtrasApplied";

    private static final double HEALTH_MULTIPLIER = 2.0D;
    private static final float DAMAGE_MULTIPLIER = 1.5F;

    private static final UUID SPEED_MODIFIER_ID = UUID.fromString("75c4a06a-cf65-42dd-a546-9779c4d24a15");

    private static final Item[][] ARMOR = {
            {Items.leather_boots, Items.leather_leggings, Items.leather_chestplate, Items.leather_helmet},
            {Items.chainmail_boots, Items.chainmail_leggings, Items.chainmail_chestplate, Items.chainmail_helmet},
            {Items.iron_boots, Items.iron_leggings, Items.iron_chestplate, Items.iron_helmet},
            {Items.golden_boots, Items.golden_leggings, Items.golden_chestplate, Items.golden_helmet}
    };

    private static final Item[] WEAPONS = {Items.stone_sword, Items.iron_sword, Items.golden_sword, Items.stone_shovel, Items.iron_shovel, Items.golden_shovel, Items.stone_axe, Items.iron_axe, Items.golden_axe};

    private static final Potion[] POTIONS = {Potion.moveSpeed, Potion.damageBoost, Potion.resistance, Potion.regeneration, Potion.fireResistance};

    @SubscribeEvent
    public void onEntityJoinWorld(EntityJoinWorldEvent event) {
        if (event.world.isRemote || this.isDimensionExcluded(event.world)) {
            return;
        }

        if (!(event.entity instanceof EntityLivingBase)) {
            return;
        }

        EntityLivingBase living = (EntityLivingBase)event.entity;
        if (!this.isEligibleHostile(living)) {
            return;
        }

        if (!Hardmode.get(event.world).getHardmode()) {
            return;
        }

        this.applyHardmodeHealth(living);
        this.applyHardmodeSpeed(living);

        if (living instanceof EntityLiving) {
            this.applyHardmodeExtras((EntityLiving)living);
        }
    }

    @SubscribeEvent
    public void onLivingHurt(LivingHurtEvent event) {
        World world = event.entityLiving.worldObj;
        if (world.isRemote || this.isDimensionExcluded(world)) {
            return;
        }

        Entity attacker = this.getAttackingEntity(event.source);
        if (!(attacker instanceof EntityLivingBase)) {
            return;
        }

        if (!this.isEligibleHostile((EntityLivingBase)attacker)) {
            return;
        }

        if (!Hardmode.get(world).getHardmode()) {
            return;
        }

        event.ammount *= DAMAGE_MULTIPLIER;
    }

    private void applyHardmodeHealth(EntityLivingBase living) {
        NBTTagCompound data = living.getEntityData();
        if (data.getBoolean(HEALTH_APPLIED)) {
            return;
        }

        IAttributeInstance health = living.getEntityAttribute(SharedMonsterAttributes.maxHealth);

        float previousMaximum = living.getMaxHealth();
        float previousHealth = living.getHealth();

        float healthPercentage = previousMaximum > 0.0F ? previousHealth / previousMaximum : 1.0F;
        health.setBaseValue(health.getBaseValue() * HEALTH_MULTIPLIER);

        living.setHealth(living.getMaxHealth() * healthPercentage);

        data.setBoolean(HEALTH_APPLIED, true);
    }

    private void applyHardmodeSpeed(EntityLivingBase living) {
        IAttributeInstance speed = living.getEntityAttribute(SharedMonsterAttributes.movementSpeed);
        if (speed == null || speed.getModifier(SPEED_MODIFIER_ID) != null) {
            return;
        }

        speed.applyModifier(new AttributeModifier(SPEED_MODIFIER_ID, "NovaCraft Hardmode speed", 0.10D, 2));
    }

    private void applyHardmodeExtras(EntityLiving living) {
        NBTTagCompound data = living.getEntityData();
        if (data.getBoolean(EXTRAS_APPLIED)) {
            return;
        }

        if (this.isHumanoid(living)) {
            this.giveRandomEquipment(living);
        }
        else if (living.getRNG().nextInt(5) == 0) {
            this.giveRandomPotionEffect(living);
        }

        data.setBoolean(EXTRAS_APPLIED, true);
    }

    private boolean isHumanoid(EntityLiving living) {
        return living instanceof EntityZombie || living instanceof EntitySkeleton || living instanceof EntityGiantZombie;
    }

    private void giveRandomEquipment(EntityLiving living) {
        boolean nether = living.worldObj.provider.dimensionId == -1;

        boolean fullSet = living.getRNG().nextBoolean();
        int setMaterial = this.chooseArmorMaterial(living, nether);

        for (int slot = 1; slot <= 4; ++slot) {
            if (living.getEquipmentInSlot(slot) != null) {
                continue;
            }

            if (!fullSet && !living.getRNG().nextBoolean()) {
                continue;
            }

            int material = fullSet ? setMaterial : this.chooseArmorMaterial(living, nether);
            living.setCurrentItemOrArmor(slot, new ItemStack(ARMOR[material][slot - 1]));
        }

        if (!(living instanceof EntitySkeleton) && living.getEquipmentInSlot(0) == null && living.getRNG().nextBoolean()) {
            living.setCurrentItemOrArmor(0, new ItemStack(this.chooseWeapon(living, nether)));
        }

        for (int slot = 0; slot <= 4; ++slot) {
            ItemStack stack = living.getEquipmentInSlot(slot);

            if (stack == null || stack.isItemEnchanted() || !stack.isItemEnchantable()) {
                continue;
            }

            int enchantmentChance = nether ? 75 : 20;
            if (living.getRNG().nextInt(100) >= enchantmentChance) {
                continue;
            }

            int enchantmentLevel = nether ? 15 + living.getRNG().nextInt(16) : 5 + living.getRNG().nextInt(11);
            ItemStack enchanted = EnchantmentHelper.addRandomEnchantment(living.getRNG(), stack, enchantmentLevel);
            living.setCurrentItemOrArmor(slot, enchanted);
        }
    }

    private int chooseArmorMaterial(EntityLiving living, boolean nether) {
        if (!nether) {
            return living.getRNG().nextInt(ARMOR.length);
        }

        int armor_type = living.getRNG().nextInt(100);
        if (armor_type < 70) {
            return 3; //Gold
        }

        if (armor_type < 80) {
            return 0; //Leather
        }

        if (armor_type < 90) {
            return 1; //Chainmail
        }

        return 2; //Iron
    }

    private Item chooseWeapon(EntityLiving living, boolean nether) {
        if (!nether) {
            return WEAPONS[living.getRNG().nextInt(WEAPONS.length)];
        }

        int roll = living.getRNG().nextInt(100);
        int materialOffset;

        if (roll < 70) {
            materialOffset = 2; //Gold
        } else if (roll < 85) {
            materialOffset = 0; //Stone
        } else {
            materialOffset = 1; //Iron
        }

        int weaponType = living.getRNG().nextInt(3);
        return WEAPONS[weaponType * 3 + materialOffset];
    }

    private void giveRandomPotionEffect(EntityLiving living) {
        Potion potion = POTIONS[living.getRNG().nextInt(POTIONS.length)];
        living.addPotionEffect(new PotionEffect(potion.id, 60000, 0));
    }

    private boolean isEligibleHostile(EntityLivingBase living) {
        return living instanceof IMob && !(living instanceof IBossDisplayData);
    }

    private Entity getAttackingEntity(DamageSource source) {
        Entity attacker = source.getEntity();
        return attacker != null ? attacker : source.getSourceOfDamage();
    }

    private boolean isDimensionExcluded(World world) {
        int[] excludedDimensions = Configs.hardmodeExcludedDimensions;
        if (excludedDimensions == null) {
            return false;
        }

        int dimension = world.provider.dimensionId;
        for (int excludedDimension : excludedDimensions) {
            if (dimension == excludedDimension) {
                return true;
            }
        }

        return false;
    }
}