package com.NovaCraft.entity.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class PhantomizedModel extends ModelBase {
    private final ModelRenderer bone;
    private final ModelRenderer bb_main;
    private final ModelRenderer right_wing;
    private final ModelRenderer left_wing;
    private final ModelRenderer leg_spike;
    private final ModelRenderer left_side_plate;
    private final ModelRenderer back_plate;
    private final ModelRenderer front_plate;
    private final ModelRenderer right_side_plate;

    public PhantomizedModel() {
        textureWidth = 128;
        textureHeight = 128;

        bone = new ModelRenderer(this);
        bone.setRotationPoint(-4.0F, 17.0F, -2.0F);


        bb_main = new ModelRenderer(this);
        bb_main.setRotationPoint(0.0F, 24.0F, 0.0F);
        bb_main.cubeList.add(new ModelBox(bb_main, 0, 28, -4.0F, -61.0F, -5.0F, 8, 16, 8, 0.0F));
        bb_main.cubeList.add(new ModelBox(bb_main, 0, 0, -6.0F, -45.0F, -4.0F, 12, 18, 6, 0.0F));
        bb_main.cubeList.add(new ModelBox(bb_main, 23, 58, -9.0F, -45.0F, -3.0F, 3, 24, 4, 0.0F));
        bb_main.cubeList.add(new ModelBox(bb_main, 1, 58, 6.0F, -45.0F, -3.0F, 3, 24, 4, 0.0F));
        bb_main.cubeList.add(new ModelBox(bb_main, 0, 56, 1.0F, -27.0F, -3.0F, 4, 27, 4, 0.0F));
        bb_main.cubeList.add(new ModelBox(bb_main, 40, 56, -12.0F, -46.0F, -5.0F, 7, 1, 8, 0.0F));
        bb_main.cubeList.add(new ModelBox(bb_main, 40, 56, 5.0F, -46.0F, -5.0F, 7, 1, 8, 0.0F));
        bb_main.cubeList.add(new ModelBox(bb_main, 37, 37, -1.0F, -63.0F, 3.0F, 2, 12, 1, 0.0F));
        bb_main.cubeList.add(new ModelBox(bb_main, 22, 56, -5.0F, -27.0F, -3.0F, 4, 27, 4, 0.0F));

        right_wing = new ModelRenderer(this);
        right_wing.setRotationPoint(19.0F, -16.0F, -4.0F);
        bb_main.addChild(right_wing);
        setRotationAngle(right_wing, 0.0044F, 0.0F, -0.5236F);
        right_wing.cubeList.add(new ModelBox(right_wing, 82, 0, -11.0F, -32.0F, -1.0F, 12, 32, 0, 0.0F));

        left_wing = new ModelRenderer(this);
        left_wing.setRotationPoint(-10.0F, -11.0F, -4.0F);
        bb_main.addChild(left_wing);
        setRotationAngle(left_wing, 0.0F, 0.0F, 0.5236F);
        left_wing.cubeList.add(new ModelBox(left_wing, 56, 0, -11.0F, -32.0F, -1.0F, 12, 32, 0, 0.0F));

        leg_spike = new ModelRenderer(this);
        leg_spike.setRotationPoint(-4.0F, -9.0F, -1.0F);
        bb_main.addChild(leg_spike);
        setRotationAngle(leg_spike, -0.2182F, 0.0F, 0.0F);
        leg_spike.cubeList.add(new ModelBox(leg_spike, 63, 111, 1.0F, -13.0F, -1.0F, 0, 13, 4, 0.0F));
        leg_spike.cubeList.add(new ModelBox(leg_spike, 49, 111, 7.0F, -13.0F, -1.0F, 0, 13, 4, 0.0F));

        left_side_plate = new ModelRenderer(this);
        left_side_plate.setRotationPoint(-15.0F, -35.0F, -4.0F);
        bb_main.addChild(left_side_plate);
        setRotationAngle(left_side_plate, 0.0F, 0.0F, 1.8326F);
        left_side_plate.cubeList.add(new ModelBox(left_side_plate, 40, 86, -11.0F, -1.0F, -1.0F, 12, 1, 8, 0.0F));

        back_plate = new ModelRenderer(this);
        back_plate.setRotationPoint(-6.0F, -45.0F, -6.0F);
        bb_main.addChild(back_plate);
        setRotationAngle(back_plate, -1.8326F, 0.0F, 0.0F);
        back_plate.cubeList.add(new ModelBox(back_plate, 40, 68, -6.0F, -1.0F, -1.0F, 7, 1, 12, 0.0F));
        back_plate.cubeList.add(new ModelBox(back_plate, 40, 68, 11.0F, -1.0F, -1.0F, 7, 1, 12, 0.0F));

        front_plate = new ModelRenderer(this);
        front_plate.setRotationPoint(-6.0F, -45.0F, 3.0F);
        bb_main.addChild(front_plate);
        setRotationAngle(front_plate, -1.309F, 0.0F, 0.0F);
        front_plate.cubeList.add(new ModelBox(front_plate, 40, 68, -6.0F, -1.0F, -1.0F, 7, 1, 12, 0.0F));
        front_plate.cubeList.add(new ModelBox(front_plate, 40, 68, 11.0F, -1.0F, -1.0F, 7, 1, 12, 0.0F));

        right_side_plate = new ModelRenderer(this);
        right_side_plate.setRotationPoint(14.0F, -35.0F, -4.0F);
        bb_main.addChild(right_side_plate);
        setRotationAngle(right_side_plate, 0.0F, 0.0F, 1.309F);
        right_side_plate.cubeList.add(new ModelBox(right_side_plate, 43, 86, -11.0F, -1.0F, -1.0F, 12, 1, 8, 0.0F));
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        bone.render(f5);
        bb_main.render(f5);
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
