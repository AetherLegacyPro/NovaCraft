package com.NovaCraftBlocks.potion;

import com.NovaCraftBlocks.NovaCraftBlocks;

import net.minecraftforge.fluids.*;

public class NovaCraftLiquids
{
    public static Fluid blazlinite;
    public static Fluid molten_vanite;
    
    public static void preInit() {
        registerFluids();
    }
    
    public static void init() {
        registerFluidBlocks();
    }
    
    private static void registerFluids() {
    	NovaCraftLiquids.blazlinite = registerFluid((Fluid)new FluidBlazlinite("blazlinite"));
    	NovaCraftLiquids.molten_vanite = registerFluid((Fluid)new FluidBlazlinite("molten_vanite"));
    }
    
    private static void registerFluidBlocks() {
    	NovaCraftLiquids.blazlinite.setBlock(NovaCraftBlocks.blazlinite);
    	NovaCraftLiquids.molten_vanite.setBlock(NovaCraftBlocks.molten_vanite);
    }
    
    public static Fluid registerFluid(final Fluid fluid) {
        FluidRegistry.registerFluid(fluid);
        return fluid;
    }
}
