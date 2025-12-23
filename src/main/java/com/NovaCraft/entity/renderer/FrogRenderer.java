package com.NovaCraft.entity.renderer;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.client.model.ModelBase;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;
import com.NovaCraft.entity.EntityFrog;
import com.NovaCraft.entity.misc.EnumFrogType;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.entity.RenderLiving;

@SideOnly(Side.CLIENT)
public class FrogRenderer extends RenderLiving
{
    
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
