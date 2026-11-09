package com.NovaCraft.legendarybeacon;

import net.minecraft.client.renderer.Tessellator;

public class BeamSegment
{
    private final float[] colours;
    private int field_177265_b;
    
    public BeamSegment(final float[] colours) {
        this.colours = colours;
        this.field_177265_b = 1;
    }
    
    public void func_177262_a() {
        ++this.field_177265_b;
    }
    
    public float[] color() {
        return this.colours;
    }
    
    public int func_177264_c() {
        return this.field_177265_b;
    }
    
    public void setColor(final Tessellator tessellator) {
        tessellator.setColorRGBA_F(this.colours[0], this.colours[1], this.colours[2], 0.125f);
    }
}
