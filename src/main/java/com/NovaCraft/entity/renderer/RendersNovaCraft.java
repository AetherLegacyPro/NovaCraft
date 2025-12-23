package com.NovaCraft.entity.renderer;

import com.NovaCraft.Items.NovaCraftItems;
import com.NovaCraft.TileEntity.TileEntityAdvancedEnchantmentTable;
import com.NovaCraft.TileEntity.TileEntityAncientChest;
import com.NovaCraft.TileEntity.TileEntityAncientChestRenderer;
import com.NovaCraft.TileEntity.TileEntityLegendaryBeacon;
import com.NovaCraft.TileEntity.TileEntityLegendaryEnchantmentTable;
import com.NovaCraft.config.Configs;
import com.NovaCraft.entity.*;
import com.NovaCraft.entity.DeepoidDragon.EntityDeepoidDragon;
import com.NovaCraft.entity.hardmode.EntityHardmodeCreeper;
import com.NovaCraft.entity.hardmode.EntityHardmodeGhast;
import com.NovaCraft.entity.hardmode.EntityHardmodeMagmaCube;
import com.NovaCraft.entity.hardmode.EntityHardmodeSkeleton;
import com.NovaCraft.entity.hardmode.EntityHardmodeSlime;
import com.NovaCraft.entity.hardmode.EntityHardmodeSpider;
import com.NovaCraft.entity.hardmode.EntityHardmodeZombie;
import com.NovaCraft.entity.illager.EntityIllagerChief;
import com.NovaCraft.entity.illager.EntityIllagerTrader;
import com.NovaCraft.entity.illager.EntityVindicator;
import com.NovaCraft.entity.misc.*;
import com.NovaCraft.entity.models.*;
import com.NovaCraft.entity.models.hardmode.HardmodeMagmaCubeModel;
import com.NovaCraft.entity.models.hardmode.HardmodeSlimeModel;
import com.NovaCraft.entity.renderer.hardmode.HardmodeCreeperRenderer;
import com.NovaCraft.entity.renderer.hardmode.HardmodeGhastRenderer;
import com.NovaCraft.entity.renderer.hardmode.HardmodeMagmaCubeRenderer;
import com.NovaCraft.entity.renderer.hardmode.HardmodeSkeletonRenderer;
import com.NovaCraft.entity.renderer.hardmode.HardmodeSlimeRenderer;
import com.NovaCraft.entity.renderer.hardmode.HardmodeSpiderRenderer;
import com.NovaCraft.entity.renderer.hardmode.HardmodeZombieRenderer;
import com.NovaCraft.entity.renderer.illager.IllagerChiefOverlayRenderer;
import com.NovaCraft.entity.renderer.illager.IllagerChiefRenderer;
import com.NovaCraft.entity.renderer.illager.IllagerTraderOverlayRenderer;
import com.NovaCraft.entity.renderer.illager.IllagerTraderRenderer;
import com.NovaCraft.entity.renderer.staff.*;
import com.NovaCraft.legendarybeacon.LegendaryBeaconRenderer;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.Loader;
import net.minecraft.client.model.ModelSlime;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderArrow;
import net.minecraft.client.renderer.entity.RenderSnowball;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityEnderEye;
import net.minecraft.init.Items;
import net.minecraftforge.client.MinecraftForgeClient;

public class RendersNovaCraft {
	
	public static void initialization() {
	//Misc
	register(EntityPrimedXanciumTNT.class, new PrimedXanciumTNTRenderer());
	register(EntityPrimedPETN.class, new PrimedPETNRenderer());
	register(EntityRayfireball.class, new RayfireballRenderer());
	register(EntityBloviatorProjectile.class, new BloviatorProjectileRenderer());
	register(EntityEnderLordStaffProjectile.class, new EnderLordStaffProjectileRenderer());
	register(EntitySculkHornProjectile.class, new SculkHornProjectileRenderer());
	register(EntityIceSceptorProjectile.class, new IceSceptorProjectileRenderer());
	register(EntityIceProjectile.class, new IceProjectileRenderer());
	register(EntityWardenProjectile.class, new WardenProjectileRenderer());
	register(EntityDiamondFirechargeProjectile.class, new DiamondFirechargeProjectileRenderer((2.0F)));
	register(EntityVaniteFirechargeProjectile.class, new VaniteFirechargeProjectileRenderer((2.0F)));
	register(EntityKlangiteFirechargeProjectile.class, new KlangiteFirechargeProjectileRenderer((2.0F)));	
	register(EntityVaniteTrident.class, new VaniteTridentRenderer());
	register(EntityIonizatiorProjectile.class, new IonizatiorProjectileRenderer(0.5F));
	register(EntityDestituteTentacleProjectile.class, new DestituteTentacleProjectileRenderer());
	register(EntitySculkLaser.class, new SculkLaserRenderer());
	register(EntityPrimevalHornProjectile.class, new PrimevalHornProjectileRenderer());
	register(EntitySculkedMonitorProjectile.class, new SculkedMonitorProjectileRenderer());
	register(KlangiteSwordProjectile.class, new KlangiteSwordProjectileRenderer());
	register(EntityEchoEye.class, new RenderSnowball(NovaCraftItems.echo_eye));
	register(EntityVindicatorEye.class, new RenderSnowball(NovaCraftItems.vindicator_insignia));
	register(EntityOctoqusProjectile.class, new OctoqusProjectileRenderer());
	
	//Passive
	register(EntityGlowSquid.class, new GlowSquidRenderer(new GlowSquidModel(), 0.7F));
	register(EntityEnderAvis.class, new EnderAvisRenderer());
	register(EntityGoat.class, new GoatRenderer(new GoatModel(), 0.7f));
	register(EntityPhoenix.class, new PhoenixRenderer());
	register(EntityFirefly.class, new FireflyRenderer(new FireflyModel(), new FireflyModel(), 0.7F));
	register(EntityFrog.class, new FrogRenderer(new FrogModel(), 0.1f));

	//Hostile
	register(EntityPhantom.class, new PhantomRenderer(new PhantomModel(), new PhantomModel(), 0.0F));
	register(EntityDrifter.class, new DrifterRenderer());
	register(EntityBlazingCharger.class, new BlazingChargerRenderer(new BlazingChargerModel(), 0.6f));
	register(EntityEnderLord.class, new EnderLordRenderer());
	register(EntityEnderRay.class, new EnderRayRenderer());
	register(EntitySculkSymbiote.class, new SculkSymbioteRenderer());
	register(EntityVoidEntity.class, new VoidEntityRenderer(new VoidEntityModel(), 0.5f));
	register(EntityVoidCube.class, new VoidCubeRenderer(new VoidCubeModel(16), new VoidCubeModel(0), 0.25F));
	register(EntityNullifier.class, new VoidiferRenderer());
	register(EntitySculkDweller.class, new SculkDwellerRenderer());
	register(EntityWarden.class, new WardenRenderer());
	register(EntitySculkAbomination.class, new SculkAbominationRenderer(new SculkAbominationModel(), new SculkAbominationModel(), 0.7F));
	register(EntityBlazingSerpent.class, new BlazingSerpentRenderer(new BlazingSerpentModel(), 1.0f));
	register(EntitySculkHunger.class, new SculkHungerRenderer(new SculkHungerModel(), new SculkHungerModel(), 0.8f));
	register(EntitySculkDuplicator.class, new SculkDuplicatorRenderer());
	register(EntityIonizatior.class, new IonizatiorRenderer());
	register(EntityDeepoid.class, new DeepoidRenderer(new DeepoidModel(), 0.4f));
	register(EntityVargouzite.class, new VargouziteRenderer(new VargouziteModel(), 0.4f));
	register(EntityCaveMonitor.class, new CaveMonitorRenderer(new CaveMonitorModel(), 0.6f));
	register(EntitySculkedMonitor.class, new SculkedMonitorRenderer(new SculkedMonitorModel(), 0.6f));
	register(EntitySeaSerpent.class, new SeaSerpentRenderer(new SeaSerpentModel(), 0.5f));
	register(EntityDeepoidDragon.class, new DeepoidDragonRenderer());
	register(EntityCrystalGolem.class, new CrystalGolemRenderer());
	register(EntityBloviator.class, new BloviatorRenderer());
	register(EntityDeathStalker.class, new DeathStalkerRenderer(new DeathStalkerModel(), 0.0f));
	register(EntityRealityDistorter.class, new RealityDistorterRenderer());
	register(EntityDestitumite.class, new DestitumiteRenderer());
	register(EntityDestituteTentacle.class, new DestituteTentacleRenderer());
	register(EntitySculkIncinerator.class, new SculkIncineratorRenderer(new SculkIncineratorModel(), new SculkIncineratorModel(), 0.6f));
	register(EntityPrisoner.class, new PrisonerRenderer());
	register(EntityWardenVessel.class, new WardenVesselRenderer());
	register(EntityNitro.class, new NitroRenderer());
	register(EntityNulk.class, new NulkRenderer());
	register(EntityNuxx.class, new NuxxRenderer());
	register(EntityOutsiderEye.class, new OutsiderEyeRenderer(new OutsiderEyeModel(), new OutsiderEyeModel(), 0.7F));
	register(EntityOutsider.class, new OutsiderRenderer());
	register(EntitySavageSerpent.class, new SavageSerpentRenderer(new SavageSerpentModel(), 1.0f));
	register(EntityBlazingSerpentQueen.class, new BlazingSerpentQueenRenderer(new BlazingSerpentQueenModel(), 1.0f));
	register(EntityCreepyCube.class, new CreepyCubeRenderer(new CreepyCubeModel(), 0.5f));
	register(EntityCreaking.class, new CreakingRenderer());
	register(EntityCrystalSlime.class, new CrystalSlimeRenderer(new CrystalSlimeModel(16), new CrystalSlimeModel(0), 0.25F));
	register(EntitySoloid.class, new SoloidRenderer(new SoloidModel(), 1.0f));
	register(EntityGiantFrog.class, new GiantFrogRenderer(new GiantFrogModel(), 1.0f));
	register(EntityWyrmling.class, new WyrmlingRenderer(new WyrmlingModel(), new WyrmlingModel(), 0.0F));
	register(EntityRavager.class, new RavagerRenderer(new RavagerModel(), 0.6f));
	register(EntityOctoqus.class, new OctoqusRenderer());
	
	register(EntityHardmodeCreeper.class, new HardmodeCreeperRenderer());
	register(EntityHardmodeSpider.class, new HardmodeSpiderRenderer());
	register(EntityHardmodeZombie.class, new HardmodeZombieRenderer());
	register(EntityHardmodeSkeleton.class, new HardmodeSkeletonRenderer());
	register(EntityHardmodeSlime.class, new HardmodeSlimeRenderer(new HardmodeSlimeModel(16), new HardmodeSlimeModel(0), 0.25F));
	register(EntityHardmodeMagmaCube.class, new HardmodeMagmaCubeRenderer());
	register(EntityHardmodeGhast.class, new HardmodeGhastRenderer());
	
	register(EntityVindicator.class, new VindicatorRenderer());
	register(EntityVindicator.class, new VindicatorOverlayRenderer());
	
	register(EntityIllagerTrader.class, new IllagerTraderRenderer());
	register(EntityIllagerTrader.class, new IllagerTraderOverlayRenderer());
	
	register(EntityIllagerChief.class, new IllagerChiefRenderer());
	register(EntityIllagerChief.class, new IllagerChiefOverlayRenderer());
	
	register(EntityIceologer.class, new IceologerRenderer());
	register(EntityIceologer.class, new IceologerOverlayRenderer());

	register(EntityCorruptist.class, new CryologerRenderer());
	register(EntityCorruptist.class, new CorruptistOverlayRenderer());
	
	register(EntitySlaughter.class, new SlaughterRenderer());
	register(EntitySlaughter.class, new SlaughterOverlayRenderer());
	
	MinecraftForgeClient.registerItemRenderer(NovaCraftItems.diamond_bow, new NovaCraftBowRenderer());	
	if (Loader.isModLoaded("etfuturum")) {
	MinecraftForgeClient.registerItemRenderer(NovaCraftItems.netherite_bow, new NovaCraftBowRenderer());
	}
	MinecraftForgeClient.registerItemRenderer(NovaCraftItems.kylazite_bow, new NovaCraftBowRenderer());
	MinecraftForgeClient.registerItemRenderer(NovaCraftItems.ophidian_bow, new NovaCraftBowRenderer());
	MinecraftForgeClient.registerItemRenderer(NovaCraftItems.crystallized_vanite_bow, new NovaCraftBowRenderer());
	MinecraftForgeClient.registerItemRenderer(NovaCraftItems.warden_bow, new NovaCraftBowRenderer());
	MinecraftForgeClient.registerItemRenderer(NovaCraftItems.tophinite_bow, new NovaCraftBowRenderer());
	MinecraftForgeClient.registerItemRenderer(NovaCraftItems.klangite_bow, new NovaCraftBowRenderer());
	MinecraftForgeClient.registerItemRenderer(NovaCraftItems.crystalite_bow, new NovaCraftBowRenderer());
	
	MinecraftForgeClient.registerItemRenderer(NovaCraftItems.goat_horn_admire, new NovaCraftHornRenderer());
	MinecraftForgeClient.registerItemRenderer(NovaCraftItems.goat_horn_call, new NovaCraftHornRenderer());
	MinecraftForgeClient.registerItemRenderer(NovaCraftItems.goat_horn_dream, new NovaCraftHornRenderer());
	MinecraftForgeClient.registerItemRenderer(NovaCraftItems.goat_horn_feel, new NovaCraftHornRenderer());
	MinecraftForgeClient.registerItemRenderer(NovaCraftItems.goat_horn_ponder, new NovaCraftHornRenderer());
	MinecraftForgeClient.registerItemRenderer(NovaCraftItems.goat_horn_seek, new NovaCraftHornRenderer());
	MinecraftForgeClient.registerItemRenderer(NovaCraftItems.goat_horn_sing, new NovaCraftHornRenderer());
	MinecraftForgeClient.registerItemRenderer(NovaCraftItems.goat_horn_yearn, new NovaCraftHornRenderer());
	
	ClientRegistry.bindTileEntitySpecialRenderer(TileEntityLegendaryEnchantmentTable.class, new LegendaryEnchantmentTableRenderer());
	ClientRegistry.bindTileEntitySpecialRenderer(TileEntityAdvancedEnchantmentTable.class, new AdvancedEnchantmentTableRenderer());	
	ClientRegistry.bindTileEntitySpecialRenderer(TileEntityAncientChest.class, new TileEntityAncientChestRenderer());
	
	if (Configs.enableUniqueLegendaryBeaconBeam) {
      	ClientRegistry.bindTileEntitySpecialRenderer(TileEntityLegendaryBeacon.class, (TileEntitySpecialRenderer)new LegendaryBeaconRenderer());          
      	}
		
	}
	
	public static void register(Class<? extends Entity> entityClass, Render render) {
		RenderingRegistry.registerEntityRenderingHandler(entityClass, render);
	}

}
