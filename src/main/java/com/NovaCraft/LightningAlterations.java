package com.NovaCraft;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.EntityRenderer;
import net.minecraftforge.client.event.RenderWorldLastEvent;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import com.NovaCraft.config.Configs;

public class LightningAlterations {

	float gamma = Configs.gammaAlterations; 
	
    @SubscribeEvent
    public void onRenderWorld(RenderWorldLastEvent event) {
        Minecraft mc = Minecraft.getMinecraft();
        if (mc == null || mc.gameSettings == null) return;

        if (mc.gameSettings.gammaSetting != gamma) {
            mc.gameSettings.gammaSetting = gamma;
        }
    }
}