package com.NovaCraft.entity.renderer;

import net.minecraft.client.renderer.entity.*;
import net.minecraft.client.model.*;
import net.minecraft.util.*;
import org.lwjgl.opengl.*;

import com.NovaCraft.entity.EntityOutsiderEye;
import com.NovaCraft.entity.models.OutsiderEyeModel;

import net.minecraft.client.renderer.*;
import net.minecraft.entity.*;

public class OutsiderEyeRenderer extends RenderLiving
{
    private static final ResourceLocation EntityTexture;
    private static final ResourceLocation Overlay_1;
    private static final ResourceLocation Overlay_2;
    private static final ResourceLocation Overlay_3;
    
    public OutsiderEyeRenderer(final OutsiderEyeModel mainModel, final OutsiderEyeModel renderPassModel, final float shadowSize) {
        super((ModelBase)mainModel, shadowSize);
        this.setRenderPassModel((ModelBase)renderPassModel);
    }
    
    protected ResourceLocation getEntityTexture(final Entity p_110775_1_) {
        return OutsiderEyeRenderer.EntityTexture;
    }
    
    protected int shouldRenderPass(final EntityLivingBase par1EntityLivingBase, final int par2, final float par3) {
        return this.shouldRenderPass((EntityOutsiderEye)par1EntityLivingBase, par2, par3);
    }
    
    protected int shouldRenderPass(final EntityOutsiderEye nulk, final int par2, final float par3) {
		if (par2 != 0) {
            return -1;
        }
        
        int rand = (int)(1 + Math.random() * 3);
		switch (rand)
        {
          case 1:
        	this.bindTexture(OutsiderEyeRenderer.Overlay_1);
        	break;
          case 2:
          	this.bindTexture(OutsiderEyeRenderer.Overlay_2);
          	break;
          case 3:
          	this.bindTexture(OutsiderEyeRenderer.Overlay_3);
          	break;
        }
        return 1;
    }
    
    @Override
	protected void preRenderCallback(EntityLivingBase mob, float partialTickTime) {
	    GL11.glScalef(1.20F, 1.20F, 1.20F);
	}
    
    static {
        EntityTexture = new ResourceLocation("nova_craft", "textures/entity/outsider/outsider.png");
        Overlay_1 = new ResourceLocation("nova_craft", "textures/entity/outsider/outsider_overlay_1.png");
        Overlay_2 = new ResourceLocation("nova_craft", "textures/entity/outsider/outsider_overlay_2.png");
        Overlay_3 = new ResourceLocation("nova_craft", "textures/entity/outsider/outsider_overlay_3.png");
    }
}
