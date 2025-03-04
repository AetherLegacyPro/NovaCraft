package com.NovaCraft.entity.renderer;

import com.NovaCraft.Items.NovaCraftItems;
import com.NovaCraft.TileEntity.TileEntityAdvancedEnchantmentTable;
import com.NovaCraft.TileEntity.TileEntityAncientChest;
import com.NovaCraft.TileEntity.TileEntityAncientChestRenderer;
import com.NovaCraft.TileEntity.TileEntityLegendaryBeacon;
import com.NovaCraft.TileEntity.TileEntityLegendaryEnchantmentTable;
import com.NovaCraft.config.Configs;
import com.NovaCraft.entity.EntityBlazingCharger;
import com.NovaCraft.entity.EntityBlazingSerpent;
import com.NovaCraft.entity.EntityBloviator;
import com.NovaCraft.entity.EntityCaveMonitor;
import com.NovaCraft.entity.EntityCrystalGolem;
import com.NovaCraft.entity.EntityDeathStalker;
import com.NovaCraft.entity.EntityDeepoid;
import com.NovaCraft.entity.EntityDestitumite;
import com.NovaCraft.entity.EntityDestituteTentacle;
import com.NovaCraft.entity.EntityDrifter;
import com.NovaCraft.entity.EntityEnderAvis;
import com.NovaCraft.entity.EntityEnderLord;
import com.NovaCraft.entity.EntityEnderLordStaffProjectile;
import com.NovaCraft.entity.EntityEnderRay;
import com.NovaCraft.entity.EntityFirefly;
import com.NovaCraft.entity.EntityGlowSquid;
import com.NovaCraft.entity.EntityGoat;
import com.NovaCraft.entity.EntityIceSceptorProjectile;
import com.NovaCraft.entity.EntityIceologer;
import com.NovaCraft.entity.EntityIonizatior;
import com.NovaCraft.entity.EntityNitro;
import com.NovaCraft.entity.EntityNullifier;
import com.NovaCraft.entity.EntityPhantom;
import com.NovaCraft.entity.EntityPhoenix;
import com.NovaCraft.entity.EntityPrimedPETN;
import com.NovaCraft.entity.EntityPrimedXanciumTNT;
import com.NovaCraft.entity.EntityPrisoner;
import com.NovaCraft.entity.EntityRealityDistorter;
import com.NovaCraft.entity.EntitySculkAbomination;
import com.NovaCraft.entity.EntitySculkDuplicator;
import com.NovaCraft.entity.EntitySculkDweller;
import com.NovaCraft.entity.EntitySculkHunger;
import com.NovaCraft.entity.EntitySculkIncinerator;
import com.NovaCraft.entity.EntitySculkSymbiote;
import com.NovaCraft.entity.EntitySculkedMonitor;
import com.NovaCraft.entity.EntitySeaSerpent;
import com.NovaCraft.entity.EntitySlaughter;
import com.NovaCraft.entity.EntityVargouzite;
import com.NovaCraft.entity.EntityVindicator;
import com.NovaCraft.entity.EntityVoidCube;
import com.NovaCraft.entity.EntityVoidEntity;
import com.NovaCraft.entity.EntityWarden;
import com.NovaCraft.entity.EntityWardenVessel;
import com.NovaCraft.entity.DeepoidDragon.EntityDeepoidDragon;
import com.NovaCraft.entity.illager.EntityIllagerChief;
import com.NovaCraft.entity.illager.EntityIllagerTrader;
import com.NovaCraft.entity.misc.EntityBloviatorProjectile;
import com.NovaCraft.entity.misc.EntityDestituteTentacleProjectile;
import com.NovaCraft.entity.misc.EntityDiamondFirechargeProjectile;
import com.NovaCraft.entity.misc.EntityIceProjectile;
import com.NovaCraft.entity.misc.EntityIonizatiorProjectile;
import com.NovaCraft.entity.misc.EntityKlangiteFirechargeProjectile;
import com.NovaCraft.entity.misc.EntityPrimevalHornProjectile;
import com.NovaCraft.entity.misc.EntityRayfireball;
import com.NovaCraft.entity.misc.EntitySculkHornProjectile;
import com.NovaCraft.entity.misc.EntitySculkLaser;
import com.NovaCraft.entity.misc.EntitySculkedMonitorProjectile;
import com.NovaCraft.entity.misc.EntityVaniteFirechargeProjectile;
import com.NovaCraft.entity.misc.EntityVaniteTrident;
import com.NovaCraft.entity.misc.EntityWardenProjectile;
import com.NovaCraft.entity.misc.KlangiteSwordProjectile;
import com.NovaCraft.entity.models.BlazingChargerModel;
import com.NovaCraft.entity.models.BlazingSerpentModel;
import com.NovaCraft.entity.models.BloviatorModel;
import com.NovaCraft.entity.models.CaveMonitorModel;
import com.NovaCraft.entity.models.DeathStalkerModel;
import com.NovaCraft.entity.models.DeepoidModel;
import com.NovaCraft.entity.models.DrifterModel;
import com.NovaCraft.entity.models.FireflyModel;
import com.NovaCraft.entity.models.GlowSquidModel;
import com.NovaCraft.entity.models.GoatModel;
import com.NovaCraft.entity.models.PhantomModel;
import com.NovaCraft.entity.models.RealityDistorterModel;
import com.NovaCraft.entity.models.SculkAbominationModel;
import com.NovaCraft.entity.models.SculkHungerModel;
import com.NovaCraft.entity.models.SculkIncineratorModel;
import com.NovaCraft.entity.models.SculkedMonitorModel;
import com.NovaCraft.entity.models.SeaSerpentModel;
import com.NovaCraft.entity.models.VargouziteModel;
import com.NovaCraft.entity.models.VoidCubeModel;
import com.NovaCraft.entity.models.VoidEntityModel;
import com.NovaCraft.entity.renderer.illager.IllagerChiefOverlayRenderer;
import com.NovaCraft.entity.renderer.illager.IllagerChiefRenderer;
import com.NovaCraft.entity.renderer.illager.IllagerTraderOverlayRenderer;
import com.NovaCraft.entity.renderer.illager.IllagerTraderRenderer;
import com.NovaCraft.entity.renderer.staff.BloviatorProjectileRenderer;
import com.NovaCraft.entity.renderer.staff.DestituteTentacleProjectileRenderer;
import com.NovaCraft.entity.renderer.staff.DiamondFirechargeProjectileRenderer;
import com.NovaCraft.entity.renderer.staff.EnderLordStaffProjectileRenderer;
import com.NovaCraft.entity.renderer.staff.IceProjectileRenderer;
import com.NovaCraft.entity.renderer.staff.IceSceptorProjectileRenderer;
import com.NovaCraft.entity.renderer.staff.IonizatiorProjectileRenderer;
import com.NovaCraft.entity.renderer.staff.KlangiteFirechargeProjectileRenderer;
import com.NovaCraft.entity.renderer.staff.NovaCraftBowRenderer;
import com.NovaCraft.entity.renderer.staff.NovaCraftHornRenderer;
import com.NovaCraft.entity.renderer.staff.PrimevalHornProjectileRenderer;
import com.NovaCraft.entity.renderer.staff.SculkHornProjectileRenderer;
import com.NovaCraft.entity.renderer.staff.SculkLaserRenderer;
import com.NovaCraft.entity.renderer.staff.SculkedMonitorProjectileRenderer;
import com.NovaCraft.entity.renderer.staff.VaniteFirechargeProjectileRenderer;
import com.NovaCraft.entity.renderer.staff.VaniteTridentRenderer;
import com.NovaCraft.entity.renderer.staff.WardenProjectileRenderer;
import com.NovaCraft.legendarybeacon.LegendaryBeaconRenderer;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.Loader;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderArrow;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
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
	
	//Passive
	register(EntityGlowSquid.class, new GlowSquidRenderer(new GlowSquidModel(), 0.7F));
	register(EntityEnderAvis.class, new EnderAvisRenderer());
	register(EntityGoat.class, new GoatRenderer(new GoatModel(), 0.7f));
	register(EntityPhoenix.class, new PhoenixRenderer());
	register(EntityFirefly.class, new FireflyRenderer(new FireflyModel(), new FireflyModel(), 0.7F));
	
	//Hostile
	register(EntityPhantom.class, new PhantomRenderer(new PhantomModel(), new PhantomModel(), 0.7F));
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
	
	register(EntityVindicator.class, new VindicatorRenderer());
	register(EntityVindicator.class, new VindicatorOverlayRenderer());
	
	register(EntityIllagerTrader.class, new IllagerTraderRenderer());
	register(EntityIllagerTrader.class, new IllagerTraderOverlayRenderer());
	
	register(EntityIllagerChief.class, new IllagerChiefRenderer());
	register(EntityIllagerChief.class, new IllagerChiefOverlayRenderer());
	
	register(EntityIceologer.class, new IceologerRenderer());
	register(EntityIceologer.class, new IceologerOverlayRenderer());
	
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
