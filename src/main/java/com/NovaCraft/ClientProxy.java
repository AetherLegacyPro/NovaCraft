package com.NovaCraft;

import com.NovaCraft.TileEntity.AncientChestRenderer;
import com.NovaCraft.TileEntity.TileEntityAncientChest;
import com.NovaCraft.TileEntity.TileEntityAncientChestRenderer;
import com.NovaCraft.TileEntity.TileEntityDeepOneEgg;
import com.NovaCraft.TileEntity.TileEntityDeepOneEggActivated;
import com.NovaCraft.TileEntity.TileEntityDeepOneEggActivatedRenderer;
import com.NovaCraft.TileEntity.TileEntityDeepOneEggRenderer;
import com.NovaCraft.TileEntity.TileEntityUnbreakbleAncientChest;
import com.NovaCraft.TileEntity.UnbreakableAncientChestRenderer;
import com.NovaCraft.entity.renderer.DeepOneEggActivatedRenderer;
import com.NovaCraft.entity.renderer.DeepOneEggRenderer;
import com.NovaCraft.entity.renderer.RendersNovaCraft;
import com.NovaCraft.renderer.BlockAetherClusterRenderer;
import com.NovaCraft.renderer.BlockCopartzClusterRenderer;
import com.NovaCraft.renderer.BlockEchoClusterRenderer;
import com.NovaCraft.renderer.BlockEmissiveLayerRenderer;
import com.NovaCraft.renderer.BlockEmissiveLayerRenderer3D;
import com.NovaCraft.renderer.BlockEndiumLogRenderer;
import com.NovaCraft.renderer.BlockEndiumPlantRenderer;
import com.NovaCraft.renderer.BlockLarimarClusterRenderer;
import com.NovaCraft.renderer.BlockLegendaryBeaconRenderer;
import com.NovaCraft.renderer.BlockMoltenCrystalCauldronRenderer;
import com.NovaCraft.renderer.BlockMoltenVaniteCauldronRenderer;
import com.NovaCraft.renderer.BlockNullClusterRenderer;
import com.NovaCraft.renderer.BlockNullcubeSlimeRenderer;
import com.NovaCraft.renderer.BlockSculkSpikeRenderer;
import com.NovaCraft.renderer.BlockSculkTentacleRenderer;
import com.NovaCraft.renderer.BlockTsavorokiteClusterRenderer;
import com.NovaCraft.renderer.BlockVaniteCauldronRenderer;
import com.NovaCraft.renderer.BlockVaniteClusterRenderer;
import com.NovaCraft.renderer.BlockYttrlinsiteClusterRenderer;
import com.NovaCraft.renderer.RenderIDs;
import com.NovaCraftBlocks.NovaCraftBlocks;
import com.NovaCraftBlocks.container.BlockUnbreakableAncientChest;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.EntityRenderer;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.common.MinecraftForge;

public class ClientProxy extends CommonProxy
{	
	
	private static int renderIdDeepOneEgg;
	private static int renderIdDeepOneEggActivated;
	
	@Override
	public void init() {       
		registerEvent(new NovaCraftClientEvents());		
	}
	
	@Override
    public void registerRenderers() {
		RenderingRegistry.registerBlockHandler(new BlockCopartzClusterRenderer());
		RenderingRegistry.registerBlockHandler(new BlockLarimarClusterRenderer());
		RenderingRegistry.registerBlockHandler(new BlockTsavorokiteClusterRenderer());
		RenderingRegistry.registerBlockHandler(new BlockYttrlinsiteClusterRenderer());
		RenderingRegistry.registerBlockHandler(new BlockEchoClusterRenderer());
		RenderingRegistry.registerBlockHandler(new BlockAetherClusterRenderer());
		RenderingRegistry.registerBlockHandler(new BlockNullClusterRenderer());
		
		RenderingRegistry.registerBlockHandler(new BlockSculkTentacleRenderer());
		RenderingRegistry.registerBlockHandler(new BlockSculkSpikeRenderer());
		
		RenderingRegistry.registerBlockHandler(new BlockEndiumLogRenderer());
		RenderingRegistry.registerBlockHandler(new BlockEndiumPlantRenderer());
		
		RenderingRegistry.registerBlockHandler(new BlockNullcubeSlimeRenderer());
		
		RenderingRegistry.registerBlockHandler(new BlockVaniteCauldronRenderer());
		RenderingRegistry.registerBlockHandler(new BlockMoltenVaniteCauldronRenderer());
		RenderingRegistry.registerBlockHandler(new BlockMoltenCrystalCauldronRenderer());
		
		RenderingRegistry.registerBlockHandler(new BlockVaniteClusterRenderer());
		RenderingRegistry.registerBlockHandler(new BlockLegendaryBeaconRenderer());
		
		RenderingRegistry.registerBlockHandler(new BlockEmissiveLayerRenderer(RenderIDs.EMISSIVE_DOUBLE_LAYER));
		RenderingRegistry.registerBlockHandler(new BlockEmissiveLayerRenderer3D(RenderIDs.EMISSIVE_DOUBLE_LAYER_3D));
		
		RendersNovaCraft.initialization();
		
		ClientProxy.renderIdDeepOneEgg = RenderingRegistry.getNextAvailableRenderId();
        ClientRegistry.bindTileEntitySpecialRenderer((Class)TileEntityDeepOneEgg.class, (TileEntitySpecialRenderer)new TileEntityDeepOneEggRenderer());
        RenderingRegistry.registerBlockHandler((ISimpleBlockRenderingHandler)new DeepOneEggRenderer(ClientProxy.renderIdDeepOneEgg));
        
        ClientProxy.renderIdDeepOneEggActivated = RenderingRegistry.getNextAvailableRenderId();
        ClientRegistry.bindTileEntitySpecialRenderer((Class)TileEntityDeepOneEggActivated.class, (TileEntitySpecialRenderer)new TileEntityDeepOneEggActivatedRenderer());
        RenderingRegistry.registerBlockHandler((ISimpleBlockRenderingHandler)new DeepOneEggActivatedRenderer(ClientProxy.renderIdDeepOneEggActivated));
	
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityAncientChest.class, new TileEntityAncientChestRenderer());
        NovaCraftBlocks.AncientChestRenderId = RenderingRegistry.getNextAvailableRenderId();
		RenderingRegistry.registerBlockHandler(new AncientChestRenderer(new TileEntityAncientChest()));
		
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityUnbreakbleAncientChest.class, new TileEntityAncientChestRenderer());
        NovaCraftBlocks.UnbreakableAncientChestRenderId = RenderingRegistry.getNextAvailableRenderId();
		RenderingRegistry.registerBlockHandler(new UnbreakableAncientChestRenderer(new TileEntityUnbreakbleAncientChest()));
	}
	
	@Override
    public int getBlockRender(final Block blockID) {
        if (blockID == NovaCraftBlocks.deep_one_egg) {
            return ClientProxy.renderIdDeepOneEgg;
        }
        if (blockID == NovaCraftBlocks.deep_one_egg_activated) {
            return ClientProxy.renderIdDeepOneEggActivated;
        }
        return -1;
	}
	
	@Override
	public EntityPlayer getPlayer() {
		return Minecraft.getMinecraft().thePlayer;
	}
	
}
