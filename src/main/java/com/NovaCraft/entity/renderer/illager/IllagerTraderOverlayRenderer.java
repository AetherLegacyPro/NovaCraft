package com.NovaCraft.entity.renderer.illager;

import org.lwjgl.opengl.GL11;

import com.NovaCraft.entity.models.VindicatorModel;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;


public class IllagerTraderOverlayRenderer extends IllagerTraderRenderer {

	public ResourceLocation slaughter_texture = new ResourceLocation("nova_craft", "textures/entity/vindicator_settler/cultist_overlay.png");
	public ModelBiped tutModel;
	
	public IllagerTraderOverlayRenderer() {
		super();
		this.mainModel = new VindicatorModel();
		this.modelBipedMain = (VindicatorModel) this.mainModel;
		this.field_82437_k = new ModelBiped(1.0F); //modelArmourChestplate
		this.field_82435_l = new ModelBiped(0.5F); //modelArmor
		this.tutModel = new ModelBiped(0.5f);
	}
	
	
	@Override
	public void renderModel(EntityLivingBase entity, float par2, float par3, float par4, float par5, float par6, float par7){
		super.renderModel(entity, par2, par3, par4, par5, par6, par7);
		//if(Conditions for the overlay to be rendered){
			ModelBiped modelBiped;
			for (int i = 0; i < 4; ++i)
			{
				modelBiped = this.tutModel;
				
				GL11.glColor4f(1, 1, 1, 1);
				this.bindTexture(slaughter_texture);
				modelBiped.bipedHead.showModel = i == 0;
				modelBiped.bipedHeadwear.showModel = i == 0;
				modelBiped.bipedBody.showModel = i == 1 || i == 2;
				modelBiped.bipedRightArm.showModel = i == 1;
				modelBiped.bipedLeftArm.showModel = i == 1;
				modelBiped.bipedRightLeg.showModel = i == 2 || i == 3;
				modelBiped.bipedLeftLeg.showModel = i == 2 || i == 3;
				modelBiped.onGround = this.mainModel.onGround;
				modelBiped.isRiding = this.mainModel.isRiding;
				modelBiped.isChild = this.mainModel.isChild;
				
				if (this.mainModel instanceof ModelBiped)
				{
					modelBiped.heldItemLeft = ((ModelBiped) this.mainModel).heldItemLeft;
					modelBiped.heldItemRight = ((ModelBiped) this.mainModel).heldItemRight;
					modelBiped.isSneak = ((ModelBiped) this.mainModel).isSneak;
					modelBiped.aimedBow = ((ModelBiped) this.mainModel).aimedBow;
				}
				
				modelBiped.setLivingAnimations(entity, par2, par3, 0.0F);
				modelBiped.render(entity, par2, par3, par4, par5, par6, par7);
				
				// Start alpha render
				GL11.glDisable(GL11.GL_LIGHTING);
				this.bindTexture(slaughter_texture);
				GL11.glEnable(GL11.GL_ALPHA_TEST);
				GL11.glEnable(GL11.GL_BLEND);
				GL11.glAlphaFunc(GL11.GL_GREATER, 0.0F);
				GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
								
				
				modelBiped.render(entity, par2, par3, par4, par5, par6, par7);
				GL11.glDisable(GL11.GL_BLEND);
				GL11.glEnable(GL11.GL_ALPHA_TEST);
				GL11.glColor4f(1, 1, 1, 1);
				GL11.glEnable(GL11.GL_LIGHTING);
				
			}
		//}
	
	}
	
	//@Override
	//protected void preRenderCallback(EntityLivingBase young_zephyr, float partialTickTime) {
	 //   GL11.glScalef(1.25F, 1.25F, 1.25F);
	//}


}
