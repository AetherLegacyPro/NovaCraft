package com.NovaCraft.entity.renderer;

import com.NovaCraft.entity.EntityRelik;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelZombie;
import org.lwjgl.opengl.GL11;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

public class RelikRenderer extends RenderBiped
{
    public static final ResourceLocation texture;
    private float scale;
    protected ModelBiped field_82437_k;
    protected ModelBiped field_82435_l;

    public RelikRenderer() {
        super(new ModelZombie(), 0.4f);
        this.scale = 1.0f;
    }

    @Override
    protected void preRenderCallback(EntityLivingBase par1EntityLiving, float par2) {
        if ((par1EntityLiving instanceof EntityRelik)) {
            GL11.glScalef(this.scale, this.scale, this.scale);
        }
    }

    @Override
    protected ResourceLocation getEntityTexture(final Entity entity) {
        return texture;
    }
    static {
        texture = new ResourceLocation("nova_craft", "textures/entity/relik/relik.png");
    }
}
