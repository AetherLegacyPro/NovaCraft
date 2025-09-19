package com.NovaCraft.entity.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class DestitumiteNewModel extends ModelBase
{
    private final ModelRenderer head;
    private final ModelRenderer largebody;
    private final ModelRenderer mediumbody;
    private final ModelRenderer lowerbody;
    
    private final ModelRenderer spike1;
    private final ModelRenderer spike2;
    private final ModelRenderer spike3;
    private final ModelRenderer spike4;
    private final ModelRenderer spike5;
    private final ModelRenderer spike6;
    private final ModelRenderer spike7;
    private final ModelRenderer spike8;
    private final ModelRenderer spike9;
    private final ModelRenderer spike10;
    private final ModelRenderer spike11;
    private final ModelRenderer spike12;
    private final ModelRenderer spike13;
    private final ModelRenderer spike14;
    private final ModelRenderer spike15;

    public DestitumiteNewModel()
    {
    	this.head = new ModelRenderer(this, 16,16);
        this.head.setRotationPoint(0.0F, 24.5F, 0.0F);
        this.head.addBox(-2.0F, -3.0F, -6.0F, 4, 2, 2);
        
        this.largebody = new ModelRenderer(this, 16, 16);
        this.largebody.setRotationPoint(0.0F, 24.5F, 0.0F);
        this.largebody.addBox(-3.0F, -4.0F, -4.0F, 6, 4, 4);
        
        this.mediumbody = new ModelRenderer(this, 16, 16);
        this.mediumbody.setRotationPoint(0.0F, 24.5F, 0.0F);
        this.mediumbody.addBox(-2.0F, -2.0F, 0.0F, 4, 2, 3);
        
        this.lowerbody = new ModelRenderer(this, 16, 16);
        this.lowerbody.setRotationPoint(0.0F, 24.5F, 0.0F);
        this.lowerbody.addBox(-1.0F, -1.0F, 3.0F, 2, 1, 2);
        
        this.spike1 = new ModelRenderer(this, 16, 16);
        this.spike1.setRotationPoint(0.0F, 24.5F, 0.0F);
        this.spike1.addBox(-2.0F, -5.0F, -3.0F, 0, 1, 1);
        
        this.spike2 = new ModelRenderer(this, 16, 16);
        this.spike2.setRotationPoint(0.0F, 24.5F, 0.0F);
        this.spike2.addBox(1.0F, -6.0F, -2.0F, 0, 1, 1);
        
        this.spike3 = new ModelRenderer(this, 16, 16);
        this.spike3.setRotationPoint(0.0F, 24.5F, 0.0F);
        this.spike3.addBox(2.0F, -5.0F, -4.0F, 0, 1, 1);
        
        this.spike4 = new ModelRenderer(this, 16, 16);
        this.spike4.setRotationPoint(0.0F, 24.5F, 0.0F);
        this.spike4.addBox(0.0F, -6.0F, -4.0F, 0, 1, 1);
        
        this.spike5 = new ModelRenderer(this, 16, 16);
        this.spike5.setRotationPoint(0.0F, 24.5F, 0.0F);
        this.spike5.addBox(1.0F, -3.0F, 1.0F, 0, 1, 1);
        
        this.spike6 = new ModelRenderer(this, 16, 16);
        this.spike6.setRotationPoint(0.0F, 24.5F, 0.0F);
        this.spike6.addBox(-1.0F, -3.0F, 1.0F, 0, 1, 1);
        
        this.spike7 = new ModelRenderer(this, 16, 16);
        this.spike7.setRotationPoint(0.0F, 24.5F, 0.0F);
        this.spike7.addBox(-1.0F, -5.0F, -1.0F, 0, 1, 1);
        
        this.spike8 = new ModelRenderer(this, 16, 16);
        this.spike8.setRotationPoint(0.0F, 24.5F, 0.0F);
        this.spike8.addBox(3.0F, -3.0F, -3.0F, 1, 0, 1);
        
        this.spike9 = new ModelRenderer(this, 16, 16);
        this.spike9.setRotationPoint(0.0F, 24.5F, 0.0F);
        this.spike9.addBox(3.0F, -2.0F, -2.0F, 1, 0, 1);
        
        this.spike10 = new ModelRenderer(this, 16, 16);
        this.spike10.setRotationPoint(0.0F, 24.5F, 0.0F);
        this.spike10.addBox(3.0F, -1.0F, -3.0F, 1, 0, 1);
        
        this.spike11 = new ModelRenderer(this, 16, 16);
        this.spike11.setRotationPoint(0.0F, 24.5F, 0.0F);
        this.spike11.addBox(-4.0F, -3.0F, -3.0F, 1, 0, 1);
        
        this.spike12 = new ModelRenderer(this, 16, 16);
        this.spike12.setRotationPoint(0.0F, 24.5F, 0.0F);
        this.spike12.addBox(-4.0F, -1.0F, -3.0F, 1, 0, 1);
        
        this.spike13 = new ModelRenderer(this, 16, 16);
        this.spike13.setRotationPoint(0.0F, 24.5F, 0.0F);
        this.spike13.addBox(-4.0F, -2.0F, -2.0F, 1, 0, 1);
        
        this.spike14 = new ModelRenderer(this, 16, 16);
        this.spike14.setRotationPoint(0.0F, 24.5F, 0.0F);
        this.spike14.addBox(2.0F, -1.0F, 1.0F, 1, 0, 1);
        
        this.spike15 = new ModelRenderer(this, 16, 16);
        this.spike15.setRotationPoint(0.0F, 24.5F, 0.0F);
        this.spike15.addBox(-3.0F, -1.0F, 1.0F, 1, 0, 1);
        
        //head.cubeList.add(new ModelBox(head, -2, 0, -2.0F, -3.0F, -6.0F, 4, 2, 2, 0.0F, false));   	
        //largebody.cubeList.add(new ModelBox(largebody, -6, -2, -3.0F, -4.0F, -4.0F, 6, 4, 4, 0.0F, false));
        //mediumbody.cubeList.add(new ModelBox(mediumbody, -3, -1, -2.0F, -2.0F, 0.0F, 4, 2, 3, 0.0F, false));
        //lowerbody.cubeList.add(new ModelBox(lowerbody, 0, 0, -1.0F, -1.0F, 3.0F, 16,16, 2, 0.0F, false));
		
		//spike1.cubeList.add(new ModelBox(spike1, 16,16, -2.0F, -5.0F, -3.0F, 0, 1, 1, 0.0F, false));
        //spike2.cubeList.add(new ModelBox(spike16,166, 0, 1.0F, -6.0F, -2.0F, 0, 16,16, 0.0F, false));
		//spike3.cubeList.add(new ModelBox(spike3, 16,16, 2.0F, -5.0F, -4.0F, 0, 1, 1, 0.0F, false));
		//spike4.cubeList.add(new ModelBox(spike4, 16,16, 0.0F, -6.0F, -4.0F, 0, 16,16, 0.0F, false));
		//spike5.cubeList.add(new ModelBox(spike5, 16,16, 1.0F, -3.0F, 1.0F, 0, 1, 1, 0.0F, false));
        //spike6.cubeList.add(new ModelBox(spike6, 16,16, -1.0F, -3.0F, 1.0F, 0, 1, 1, 0.0F, false));
        //spike7.cubeList.add(new ModelBox(spike7, 16,16, -1.0F, -5.0F, -1.0F, 0, 1, 1, 0.0F, false));
		//spike8.cubeList.add(new ModelBox(spike8, 16,16, 3.0F, -3.0F, -3.0F, 1, 0, 1, 0.0F, false));
        //spike9.cubeList.add(new ModelBox(spike9, 16,16, 3.0F, -2.0F, -2.0F, 1, 0, 1, 0.0F, false));
        //spike10.cubeList.add(new ModelBox(spike10, 16,16, 3.0F, -1.0F, -3.0F, 1, 0, 1, 0.0F, false));
        //spike11.cubeList.add(new ModelBox(spike11, 16,16, -4.0F, -3.0F, -3.0F, 1, 0, 1, 0.0F, false));
        //spike12.cubeList.add(new ModelBox(spike12, 16,16, -4.0F, -1.0F, -3.0F, 1, 0, 1, 0.0F, false));
        //spike13.cubeList.add(new ModelBox(spike13, 16,16, -4.0F, -2.0F, -2.0F, 1, 0, 1, 0.0F, false));
        //spike14.cubeList.add(new ModelBox(spike14, 16,16, 2.0F, -1.0F, 1.0F, 1, 0, 1, 0.0F, false));
        //spike15.cubeList.add(new ModelBox(spike15, 16,16, -3.0F, -1.0F, 1.0F, 1, 0, 1, 0.0F, false));
    }

    @Override
    public void render(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float rotationYaw, float rotationPitch, float scale)
    {
        this.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, rotationYaw, rotationPitch, scale, entity);
        this.head.render(scale);
        this.largebody.render(scale);
        this.mediumbody.render(scale);
        this.lowerbody.render(scale);
        this.spike1.render(scale);
        this.spike2.render(scale);
        this.spike3.render(scale);
        this.spike4.render(scale);
        this.spike5.render(scale);
        this.spike6.render(scale);
        this.spike7.render(scale);
        this.spike8.render(scale);
        this.spike9.render(scale);
        this.spike10.render(scale);
        this.spike11.render(scale);
        this.spike12.render(scale);
        this.spike13.render(scale);
        this.spike14.render(scale);
        this.spike15.render(scale);
    }

    @Override
    public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float rotationYaw, float rotationPitch, float scaleFactor, Entity entityIn)
    {
    	
    }
}
