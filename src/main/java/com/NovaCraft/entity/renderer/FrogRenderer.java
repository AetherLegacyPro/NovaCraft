package com.NovaCraft.entity.renderer;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.client.model.ModelBase;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import com.NovaCraft.entity.EntityFrog;
import com.NovaCraft.entity.misc.EnumFrogType;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.entity.RenderLiving;

@SideOnly(Side.CLIENT)
public class FrogRenderer extends RenderLiving
{
	private static final ResourceLocation TEXTURE_GREEN  = new ResourceLocation("textures/entity/frog/GREEN.png");
	private static final ResourceLocation TEXTURE_YELLOW  = new ResourceLocation("textures/entity/frog/YELLOW.png");
	private static final ResourceLocation TEXTURE_BROWN  = new ResourceLocation("textures/entity/frog/BROWN.png");
	private static final ResourceLocation TEXTURE_LIGHT_BLUE  = new ResourceLocation("textures/entity/frog/LIGHT_BLUE.png");
	private static final ResourceLocation TEXTURE_TREE_1  = new ResourceLocation("textures/entity/frog/TREE_1.png");
	private static final ResourceLocation TEXTURE_TREE_2  = new ResourceLocation("textures/entity/frog/TREE_2.png");
	private static final ResourceLocation TEXTURE_TREE_3  = new ResourceLocation("textures/entity/frog/TREE_3.png");
	
	private static final ResourceLocation TEXTURE_POSION_1  = new ResourceLocation("textures/entity/frog/POSION_1.png");
	private static final ResourceLocation TEXTURE_POSION_2  = new ResourceLocation("textures/entity/frog/POSION_2.png");
	private static final ResourceLocation TEXTURE_POSION_3  = new ResourceLocation("textures/entity/frog/POSION_3.png");
	private static final ResourceLocation TEXTURE_POSION_4  = new ResourceLocation("textures/entity/frog/POSION_4.png");
	
	//private static final ResourceLocation TEXTURE_GIANT_1  = new ResourceLocation("textures/entity/frog/GIANT_1.png");
	//private static final ResourceLocation TEXTURE_GIANT_2  = new ResourceLocation("textures/entity/frog/GIANT_2.png");
	//private static final ResourceLocation TEXTURE_GIANT_3  = new ResourceLocation("textures/entity/frog/GIANT_3.png");
    
    public FrogRenderer(final ModelBase par1ModelBase, final float par2) {
        super(par1ModelBase, par2);
    }

    @Override
	protected void preRenderCallback(EntityLivingBase entity, float partialTickTime) {
	  	GL11.glScalef(1.3F, 1.3F, 1.3F);
	  	
	  	EntityFrog frog = ((EntityFrog) entity);
	  	if(frog.getType() == EnumFrogType.POSION_1 || frog.getType() == EnumFrogType.POSION_2 || frog.getType() == EnumFrogType.POSION_3 || frog.getType() == EnumFrogType.POSION_4) {
	  		GL11.glScalef(0.4F, 0.4F, 0.4F);        	
        } else if (frog.getType() == EnumFrogType.TREE_1 || frog.getType() == EnumFrogType.TREE_2 || frog.getType() == EnumFrogType.TREE_3) {
        	GL11.glScalef(0.8F, 0.8F, 0.8F); 
        }
	  	
	  	//EntityFrog frog = ((EntityFrog) entity);
	  	//if(frog.getType() == EnumFrogType.GIANT_1 || frog.getType() == EnumFrogType.GIANT_2 || frog.getType() == EnumFrogType.GIANT_3) {
	  		//GL11.glScalef(3.5F, 3.5F, 3.5F);        	
        //}
	}

	@Override
	protected ResourceLocation getEntityTexture(final Entity entity) {
        return new ResourceLocation("textures/entity/frog/" + ((EntityFrog)entity).getType() + ".png");
    }
	
    public void doRender(Entity p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_)
    {
        this.doRender((EntityFrog)p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
    }
}
