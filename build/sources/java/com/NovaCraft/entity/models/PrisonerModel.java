package com.NovaCraft.entity.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

//Credit to mpk1197 for the animation
public class PrisonerModel extends ModelBase {
    private final ModelRenderer portal;
    private final ModelRenderer tentacle_2;
    private final ModelRenderer tentacle_3;
    private final ModelRenderer tentacle_5;
    private final ModelRenderer tentacle_4;
    private final ModelRenderer tentacle_6;
    private final ModelRenderer tentacle_7;
    private final ModelRenderer tentacle_8;
    private final ModelRenderer tentacle_1;
    private final ModelRenderer tentacle_9;
    private final ModelRenderer tentacle_10;
    private final ModelRenderer head;

    private final float ANIM_LENGTH = 3.25f;
    private final float SPEED_MULTIPLIER = 0.5f;

    public PrisonerModel() {
        textureWidth = 128;
        textureHeight = 128;

        portal = new ModelRenderer(this);
        portal.setRotationPoint(0.0F, 24.0F, 0.0F);
        portal.cubeList.add(new ModelBox(portal, 0, 0, 0.0F, -16.0F, -16.0F, 1, 16, 32, 0.0F));

        tentacle_2 = new ModelRenderer(this);
        tentacle_2.setRotationPoint(1.0F, -9.0F, 12.0F);
        portal.addChild(tentacle_2);
        setRotationAngle(tentacle_2, -0.2345F, 0.2546F, 0.1442F);
        tentacle_2.cubeList.add(new ModelBox(tentacle_2, 28, 58, 0.0F, -1.0F, -1.0F, 5, 3, 3, 0.0F));

        tentacle_3 = new ModelRenderer(this);
        tentacle_3.setRotationPoint(0.0F, -1.0F, -8.0F);
        portal.addChild(tentacle_3);
        setRotationAngle(tentacle_3, -0.0101F, -0.1832F, -0.0804F);
        tentacle_3.cubeList.add(new ModelBox(tentacle_3, 24, 61, 1.0F, -3.0F, -1.0F, 4, 3, 3, 0.0F));

        tentacle_5 = new ModelRenderer(this);
        tentacle_5.setRotationPoint(1.0F, -6.0F, -6.0F);
        portal.addChild(tentacle_5);
        setRotationAngle(tentacle_5, 0.1595F, 0.1779F, -0.4093F);
        tentacle_5.cubeList.add(new ModelBox(tentacle_5, 41, 55, 0.0F, -4.0F, -1.0F, 5, 4, 4, 0.0F));

        tentacle_4 = new ModelRenderer(this);
        tentacle_4.setRotationPoint(5.0F, -3.0F, 1.0F);
        tentacle_5.addChild(tentacle_4);
        setRotationAngle(tentacle_4, 0.0692F, -0.0312F, -0.4688F);
        tentacle_4.cubeList.add(new ModelBox(tentacle_4, 23, 62, 0.0F, 0.0F, -1.0F, 4, 2, 2, 0.0F));

        tentacle_6 = new ModelRenderer(this);
        tentacle_6.setRotationPoint(1.0F, -5.0F, -13.0F);
        portal.addChild(tentacle_6);
        setRotationAngle(tentacle_6, -0.2672F, 0.1373F, 0.1157F);
        tentacle_6.cubeList.add(new ModelBox(tentacle_6, 24, 54, 0.0F, -2.0F, -1.0F, 6, 3, 3, 0.0F));

        tentacle_7 = new ModelRenderer(this);
        tentacle_7.setRotationPoint(1.0F, -5.0F, 4.0F);
        portal.addChild(tentacle_7);
        setRotationAngle(tentacle_7, 0.0331F, -0.1464F, 0.3178F);
        tentacle_7.cubeList.add(new ModelBox(tentacle_7, 2, 59, -1.0F, -2.0F, -1.0F, 10, 3, 3, 0.0F));

        tentacle_8 = new ModelRenderer(this);
        tentacle_8.setRotationPoint(1.0F, -13.0F, 10.0F);
        portal.addChild(tentacle_8);
        setRotationAngle(tentacle_8, 0.3278F, -0.3118F, -0.1659F);
        tentacle_8.cubeList.add(new ModelBox(tentacle_8, 48, 59, 0.0F, -2.0F, -2.0F, 4, 4, 4, 0.0F));

        tentacle_1 = new ModelRenderer(this);
        tentacle_1.setRotationPoint(1.0F, 0.0F, -2.0F);
        tentacle_8.addChild(tentacle_1);
        setRotationAngle(tentacle_1, 0.1555F, -0.1296F, -0.0998F);
        tentacle_1.cubeList.add(new ModelBox(tentacle_1, 6, 59, 3.0F, -1.0F, 1.0F, 5, 2, 2, 0.0F));

        tentacle_9 = new ModelRenderer(this);
        tentacle_9.setRotationPoint(1.0F, -4.0F, 9.0F);
        portal.addChild(tentacle_9);
        setRotationAngle(tentacle_9, -0.4835F, -0.1397F, -0.1625F);
        tentacle_9.cubeList.add(new ModelBox(tentacle_9, 29, 58, -1.0F, -1.0F, -1.0F, 6, 3, 3, 0.0F));

        tentacle_10 = new ModelRenderer(this);
        tentacle_10.setRotationPoint(2.0F, -10.0F, -11.0F);
        portal.addChild(tentacle_10);
        setRotationAngle(tentacle_10, -0.0568F, -0.0106F, 0.097F);
        tentacle_10.cubeList.add(new ModelBox(tentacle_10, 7, 58, -1.0F, -2.0F, -1.0F, 8, 3, 3, 0.0F));

        head = new ModelRenderer(this);
        head.setRotationPoint(0.0F, 13.4455F, 0.0F);
        setRotationAngle(head, 0.0F, 0.0F, -0.0296F);
        head.cubeList.add(new ModelBox(head, 0, 0, 1.0F, -5.0F, -3.0F, 2, 7, 7, 0.0F));
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        setRotationAngles(f, f1, entity.ticksExisted + f2, f3, f4, f5, entity);
        portal.render(f5);
        head.render(f5);
    }

    @Override
    public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entity) {
        float time = ((ageInTicks * SPEED_MULTIPLIER) / 20.0f) % ANIM_LENGTH;
        animateTentacle2(time);
        animateTentacle3(time);
        animateTentacle4(time);
        animateTentacle5(time);
        animateTentacle6(time);
        animateTentacle7(time);
        animateTentacle8(time);
        animateTentacle9(time);
        animateTentacle10(time);
        animateHead(time);
        animateTentacle1(time);
    }

    private float interpolate(float t, float t0, float t1, float start, float end) {
        float progress = (t - t0) / (t1 - t0);
        if(progress < 0f) progress = 0f;
        if(progress > 1f) progress = 1f;
        float smoothProgress = progress * progress * (3 - 2 * progress);
        return start + (end - start) * smoothProgress;
    }

    private void animateTentacle2(float t) {
        float x, y, z;
        if (t < 1.2917f) {
            x = interpolate(t, 0.0f, 1.2917f, 0f, -14.12881f);
            y = interpolate(t, 0.0f, 1.2917f, 0f, 14.49083f);
            z = interpolate(t, 0.0f, 1.2917f, 0f, 3.18876f);
        } else if (t < 2.0833f) {
            x = interpolate(t, 1.2917f, 2.0833f, -14.12881f, -38.89691f);
            y = interpolate(t, 1.2917f, 2.0833f, 14.49083f, -8.3689f);
            z = interpolate(t, 1.2917f, 2.0833f, 3.18876f, -4.68784f);
        } else {
            x = interpolate(t, 2.0833f, ANIM_LENGTH, -38.89691f, 0f);
            y = interpolate(t, 2.0833f, ANIM_LENGTH, -8.3689f, 0f);
            z = interpolate(t, 2.0833f, ANIM_LENGTH, -4.68784f, 0f);
        }
        tentacle_2.rotateAngleX = (float)Math.toRadians(x);
        tentacle_2.rotateAngleY = (float)Math.toRadians(y);
        tentacle_2.rotateAngleZ = (float)Math.toRadians(z);
    }

    private void animateTentacle3(float t) {
        float x, y, z;
        if (t < 1.1667f) {
            x = interpolate(t, 0.0f, 1.1667f, 0f, 0f);
            y = interpolate(t, 0.0f, 1.1667f, 0f, -10f);
            z = interpolate(t, 0.0f, 1.1667f, 0f, 0f);
        } else if (t < 2.2917f) {
            x = interpolate(t, 1.1667f, 2.2917f, 0f, -12.7344f);
            y = interpolate(t, 1.1667f, 2.2917f, -10f, -13.60372f);
            z = interpolate(t, 1.1667f, 2.2917f, 0f, 8.72934f);
        } else {
            x = interpolate(t, 2.2917f, 3.2083f, -12.7344f, 0f);
            y = interpolate(t, 2.2917f, 3.2083f, -13.60372f, 0f);
            z = interpolate(t, 2.2917f, 3.2083f, 8.72934f, 0f);
        }
        tentacle_3.rotateAngleX = (float)Math.toRadians(x);
        tentacle_3.rotateAngleY = (float)Math.toRadians(y);
        tentacle_3.rotateAngleZ = (float)Math.toRadians(z);
    }

    private void animateTentacle4(float t) {
        float x, y, z;
        if (t < 1.125f) {
            x = interpolate(t, 0.0f, 1.125f, 0f, -8.90754f);
            y = interpolate(t, 0.0f, 1.125f, 0f, 0.16794f);
            z = interpolate(t, 0.0f, 1.125f, 17.5f, -18.78993f);
        } else if (t < 2.375f) {
            x = interpolate(t, 1.125f, 2.375f, -8.90754f, 2.61407f);
            y = interpolate(t, 1.125f, 2.375f, 0.16794f, -29.40547f);
            z = interpolate(t, 1.125f, 2.375f, -18.78993f, -3.31033f);
        } else {
            x = interpolate(t, 2.375f, ANIM_LENGTH, 2.61407f, 0f);
            y = interpolate(t, 2.375f, ANIM_LENGTH, -29.40547f, 0f);
            z = interpolate(t, 2.375f, ANIM_LENGTH, -3.31033f, 17.5f);
        }
        tentacle_4.rotateAngleX = (float)Math.toRadians(x);
        tentacle_4.rotateAngleY = (float)Math.toRadians(y);
        tentacle_4.rotateAngleZ = (float)Math.toRadians(z);
    }

    private void animateTentacle5(float t) {
        float x, y, z;
        if (t < 1.0f) {
            x = interpolate(t, 0.0f, 1.0f, 0f, -3.11546f);
            y = interpolate(t, 0.0f, 1.0f, 0f, 12.16883f);
            z = interpolate(t, 0.0f, 1.0f, 0f, -14.421f);
        } else if (t < 2.375f) {
            x = interpolate(t, 1.0f, 2.375f, -3.11546f, -3.2468f);
            y = interpolate(t, 1.0f, 2.375f, 12.16883f, -7.57235f);
            z = interpolate(t, 1.0f, 2.375f, -14.421f, -17.64684f);
        } else {
            x = interpolate(t, 2.375f, ANIM_LENGTH, -3.2468f, 0f);
            y = interpolate(t, 2.375f, ANIM_LENGTH, -7.57235f, 0f);
            z = interpolate(t, 2.375f, ANIM_LENGTH, -17.64684f, 0f);
        }
        tentacle_5.rotateAngleX = (float)Math.toRadians(x);
        tentacle_5.rotateAngleY = (float)Math.toRadians(y);
        tentacle_5.rotateAngleZ = (float)Math.toRadians(z);
    }

    private void animateTentacle6(float t) {
        float x, y, z;
        if (t < 1.0f) {
            x = interpolate(t, 0.0f, 1.0f, 0f, -15f);
            y = interpolate(t, 0.0f, 1.0f, 0f, 10f);
            z = interpolate(t, 0.0f, 1.0f, 0f, 10f);
        } else if (t < 2.2083f) {
            x = interpolate(t, 1.0f, 2.2083f, -15f, -9.73422f);
            y = interpolate(t, 1.0f, 2.2083f, 10f, -7.05707f);
            z = interpolate(t, 1.0f, 2.2083f, 10f, 14.73627f);
        } else {
            x = interpolate(t, 2.2083f, ANIM_LENGTH, -9.73422f, 0f);
            y = interpolate(t, 2.2083f, ANIM_LENGTH, -7.05707f, 0f);
            z = interpolate(t, 2.2083f, ANIM_LENGTH, 14.73627f, 0f);
        }
        tentacle_6.rotateAngleX = (float)Math.toRadians(x);
        tentacle_6.rotateAngleY = (float)Math.toRadians(y);
        tentacle_6.rotateAngleZ = (float)Math.toRadians(z);
    }

    private void animateTentacle7(float t) {
        float x, y, z;
        if (t < 1.0f) {
            x = interpolate(t, 0.0f, 1.0f, 0f, -1.31845f);
            y = interpolate(t, 0.0f, 1.0f, 0f, -9.91358f);
            z = interpolate(t, 0.0f, 1.0f, 0f, 7.61435f);
        } else if (t < 2.125f) {
            x = interpolate(t, 1.0f, 2.125f, -1.31845f, 16.19837f);
            y = interpolate(t, 1.0f, 2.125f, -9.91358f, 2.58675f);
            z = interpolate(t, 1.0f, 2.125f, 7.61435f, 7.32403f);
        } else {
            x = interpolate(t, 2.125f, ANIM_LENGTH, 16.19837f, 0f);
            y = interpolate(t, 2.125f, ANIM_LENGTH, 2.58675f, 0f);
            z = interpolate(t, 2.125f, ANIM_LENGTH, 7.32403f, 0f);
        }
        tentacle_7.rotateAngleX = (float)Math.toRadians(x);
        tentacle_7.rotateAngleY = (float)Math.toRadians(y);
        tentacle_7.rotateAngleZ = (float)Math.toRadians(z);
    }

    private void animateTentacle8(float t) {
        float x, y, z;
        if (t < 1.0f) {
            x = interpolate(t, 0.0f, 1.0f, 0f, 18.26859f);
            y = interpolate(t, 0.0f, 1.0f, 0f, -20.03158f);
            z = interpolate(t, 0.0f, 1.0f, 0f, -11.8981f);
        } else if (t < 2.6667f) {
            x = interpolate(t, 1.0f, 2.6667f, 18.26859f, 12.61299f);
            y = interpolate(t, 1.0f, 2.6667f, -20.03158f, 10.30607f);
            z = interpolate(t, 1.0f, 2.6667f, -11.8981f, 37.99744f);
        } else {
            x = interpolate(t, 2.6667f, ANIM_LENGTH, 12.61299f, 0f);
            y = interpolate(t, 2.6667f, ANIM_LENGTH, 10.30607f, 0f);
            z = interpolate(t, 2.6667f, ANIM_LENGTH, 37.99744f, 0f);
        }
        tentacle_8.rotateAngleX = (float)Math.toRadians(x);
        tentacle_8.rotateAngleY = (float)Math.toRadians(y);
        tentacle_8.rotateAngleZ = (float)Math.toRadians(z);
    }

    private void animateTentacle9(float t) {
        float x, y, z;
        if (t < 1.0f) {
            x = interpolate(t, 0.0f, 1.0f, 0f, -20.45314f);
            y = interpolate(t, 0.0f, 1.0f, 0f, -11.06236f);
            z = interpolate(t, 0.0f, 1.0f, 0f, -16.18072f);
        } else if (t < 2.2083f) {
            x = interpolate(t, 1.0f, 2.2083f, -20.45314f, -9.39761f);
            y = interpolate(t, 1.0f, 2.2083f, -11.06236f, 11.84888f);
            z = interpolate(t, 1.0f, 2.2083f, -16.18072f, -12.22287f);
        } else {
            x = interpolate(t, 2.2083f, ANIM_LENGTH, -9.39761f, 0f);
            y = interpolate(t, 2.2083f, ANIM_LENGTH, 11.84888f, 0f);
            z = interpolate(t, 2.2083f, ANIM_LENGTH, -12.22287f, 0f);
        }
        tentacle_9.rotateAngleX = (float)Math.toRadians(x);
        tentacle_9.rotateAngleY = (float)Math.toRadians(y);
        tentacle_9.rotateAngleZ = (float)Math.toRadians(z);
    }

    private void animateTentacle10(float t) {
        float x, y, z;
        if (t < 1.0f) {
            x = interpolate(t, 0.0f, 1.0f, 0f, 3.25307f);
            y = interpolate(t, 0.0f, 1.0f, 0f, 3.82505f);
            z = interpolate(t, 0.0f, 1.0f, 0f, 7.43832f);
        } else if (t < 2.3333f) {
            x = interpolate(t, 1.0f, 2.3333f, 3.25307f, 41.19038f);
            y = interpolate(t, 1.0f, 2.3333f, 3.82505f, -27.31388f);
            z = interpolate(t, 1.0f, 2.3333f, 7.43832f, -8.66462f);
        } else {
            x = interpolate(t, 2.3333f, ANIM_LENGTH, 41.19038f, 0f);
            y = interpolate(t, 2.3333f, ANIM_LENGTH, -27.31388f, 0f);
            z = interpolate(t, 2.3333f, ANIM_LENGTH, -8.66462f, 0f);
        }
        tentacle_10.rotateAngleX = (float)Math.toRadians(x);
        tentacle_10.rotateAngleY = (float)Math.toRadians(y);
        tentacle_10.rotateAngleZ = (float)Math.toRadians(z);
    }

    private void animateHead(float t) {
        float rx, ry, rz;
        if (t < 1.5f) {
            rx = interpolate(t, 0.0f, 1.5f, 0f, 0f);
            ry = interpolate(t, 0.0f, 1.5f, 0f, 0f);
            rz = interpolate(t, 0.0f, 1.5f, 2f, -2f);
        } else {
            rx = interpolate(t, 1.5f, ANIM_LENGTH, 0f, 0f);
            ry = interpolate(t, 1.5f, ANIM_LENGTH, 0f, 0f);
            rz = interpolate(t, 1.5f, ANIM_LENGTH, -2f, 2f);
        }
        head.rotateAngleX = (float)Math.toRadians(rx);
        head.rotateAngleY = (float)Math.toRadians(ry);
        head.rotateAngleZ = (float)Math.toRadians(rz);

        float py;
        if (t < 1.5f) {
            py = interpolate(t, 0.0f, 1.5f, 0f, 0.6f);
        } else {
            py = interpolate(t, 1.5f, ANIM_LENGTH, 0.6f, 0f);
        }
        head.rotationPointY = 13.4455f + py;
    }

    private void animateTentacle1(float t) {
        float x, y, z;
        if (t < 1.0f) {
            x = interpolate(t, 0.0f, 1.0f, 0f, 12.5f);
            y = interpolate(t, 0.0f, 1.0f, 0f, -10f);
            z = interpolate(t, 0.0f, 1.0f, 0f, -6f);
        } else if (t < 2.3333f) {
            x = interpolate(t, 1.0f, 2.3333f, 12.5f, -17.41462f);
            y = interpolate(t, 1.0f, 2.3333f, -10f, 11.97625f);
            z = interpolate(t, 1.0f, 2.3333f, -6f, -1.1429f);
        } else {
            x = interpolate(t, 2.3333f, ANIM_LENGTH, -17.41462f, 0f);
            y = interpolate(t, 2.3333f, ANIM_LENGTH, 11.97625f, 0f);
            z = interpolate(t, 2.3333f, ANIM_LENGTH, -1.1429f, 0f);
        }
        tentacle_1.rotateAngleX = (float)Math.toRadians(x);
        tentacle_1.rotateAngleY = (float)Math.toRadians(y);
        tentacle_1.rotateAngleZ = (float)Math.toRadians(z);
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}


