package com.NovaCraft.particles;

import cpw.mods.fml.relauncher.*;
import java.lang.reflect.*;
import java.util.*;
import net.minecraft.crash.*;
import net.minecraft.world.*;
import net.minecraft.client.*;
import net.minecraft.client.particle.*;
import net.minecraft.util.*;
import com.NovaCraft.particles.entity.EntityRandomShapedParticle;
import com.NovaCraft.particles.entity.EntityRandomShapedParticleOld;
import com.NovaCraft.particles.entity.EntitySculkParticle;
import com.NovaCraft.particles.entity.EntityBlazliniteParticle;

@SideOnly(Side.CLIENT)
public enum ParticleHandler
{
	DARK((Class)EntityRandomShapedParticle.class, ParticleData.VX_VY_VZ, new Class[] { Integer.TYPE, Float.TYPE, Integer.TYPE, ResourceLocation.class, Integer.TYPE }) {
        private final ResourceLocation texture;
        
        {
            this.texture = new ResourceLocation("nova_craft:textures/particles/dark_square.png");
        }
        
        @Override
        protected Object[] getAdditionalArgs(final World world, final Object... data) {
            return new Object[] { 0, 0.18f * world.rand.nextFloat(), -1, this.texture, 16 };
        }
	},
	
	VOIDENTITY((Class)EntityRandomShapedParticle.class, ParticleData.VX_VY_VZ, new Class[] { Integer.TYPE, Float.TYPE, Integer.TYPE, ResourceLocation.class, Integer.TYPE }) {
        private final ResourceLocation texture;
        
        {
            this.texture = new ResourceLocation("nova_craft:textures/particles/void_entity_particles.png");
        }
        
        @Override
        protected Object[] getAdditionalArgs(final World world, final Object... data) {
            return new Object[] { 0, 0.06f * world.rand.nextFloat(), -1, this.texture, 16 };
        }
	},
	
	VOID((Class)EntityRandomShapedParticle.class, ParticleData.VX_VY_VZ, new Class[] { Integer.TYPE, Float.TYPE, Integer.TYPE, ResourceLocation.class, Integer.TYPE }) {
        private final ResourceLocation texture;
        
        {
            this.texture = new ResourceLocation("nova_craft:textures/particles/void_particles.png");
        }
        
        @Override
        protected Object[] getAdditionalArgs(final World world, final Object... data) {
            return new Object[] { 0, 0.08f * world.rand.nextFloat(), -1, this.texture, 16 };
        }
	},
	
	VOIDLARGE((Class)EntityRandomShapedParticle.class, ParticleData.VX_VY_VZ, new Class[] { Integer.TYPE, Float.TYPE, Integer.TYPE, ResourceLocation.class, Integer.TYPE }) {
        private final ResourceLocation texture;
        
        {
            this.texture = new ResourceLocation("nova_craft:textures/particles/void_particles.png");
        }
        
        @Override
        protected Object[] getAdditionalArgs(final World world, final Object... data) {
            return new Object[] { 0, 0.18f * world.rand.nextFloat(), -1, this.texture, 16 };
        }
	},
	
	ENDER((Class)EntityRandomShapedParticle.class, ParticleData.VX_VY_VZ, new Class[] { Integer.TYPE, Float.TYPE, Integer.TYPE, ResourceLocation.class, Integer.TYPE }) {
        private final ResourceLocation texture;
        
        {
            this.texture = new ResourceLocation("nova_craft:textures/particles/ender_particles.png");
        }
        
        @Override
        protected Object[] getAdditionalArgs(final World world, final Object... data) {
            return new Object[] { 0, 0.08f * world.rand.nextFloat(), -1, this.texture, 16 };
        }
	},
	
	ENDERLORD((Class)EntityRandomShapedParticle.class, ParticleData.VX_VY_VZ, new Class[] { Integer.TYPE, Float.TYPE, Integer.TYPE, ResourceLocation.class, Integer.TYPE }) {
        private final ResourceLocation texture;
        
        {
            this.texture = new ResourceLocation("nova_craft:textures/particles/enderlord_particle.png");
        }
        
        @Override
        protected Object[] getAdditionalArgs(final World world, final Object... data) {
            return new Object[] { 0, 0.18f * world.rand.nextFloat(), -1, this.texture, 16 };
        }
	},
	
	LUMINANT((Class)EntityRandomShapedParticle.class, ParticleData.VX_VY_VZ, new Class[] { Integer.TYPE, Float.TYPE, Integer.TYPE, ResourceLocation.class, Integer.TYPE }) {
        private final ResourceLocation texture;
        
        {
            this.texture = new ResourceLocation("nova_craft:textures/particles/luminant_particle.png");
        }
        
        @Override
        protected Object[] getAdditionalArgs(final World world, final Object... data) {
            return new Object[] { 0, 0.05f * world.rand.nextFloat(), -1, this.texture, 16 };
        }
	},
	
	REGULARFLAME((Class)EntityRandomShapedParticle.class, ParticleData.VX_VY_VZ, new Class[] { Integer.TYPE, Float.TYPE, Integer.TYPE, ResourceLocation.class, Integer.TYPE }) {
        private final ResourceLocation texture;
        
        {
            this.texture = new ResourceLocation("nova_craft:textures/particles/regular_flame.png");
        }
        
        @Override
        protected Object[] getAdditionalArgs(final World world, final Object... data) {
            return new Object[] { 0, 0.05f * world.rand.nextFloat(), -1, this.texture, 1 };
        }
	},
	
	GLOWSQUID((Class)EntityRandomShapedParticle.class, ParticleData.VX_VY_VZ, new Class[] { Integer.TYPE, Float.TYPE, Integer.TYPE, ResourceLocation.class, Integer.TYPE }) {
        private final ResourceLocation texture;
        
        {
            this.texture = new ResourceLocation("nova_craft:textures/particles/glow_squid_particle.png");
        }
        
        @Override
        protected Object[] getAdditionalArgs(final World world, final Object... data) {
            return new Object[] { 0, 0.18f * world.rand.nextFloat(), -1, this.texture, 16 };
        }
	},
	
	TREASURE((Class)EntitySculkParticle.class, ParticleData.VX_VY_VZ, new Class[] { Integer.TYPE, Float.TYPE, Integer.TYPE, ResourceLocation.class, Integer.TYPE }) {
        private final ResourceLocation texture;
        
        {
            this.texture = new ResourceLocation("nova_craft:textures/particles/treasure_crate_particle.png");
        }
        
        @Override
        protected Object[] getAdditionalArgs(final World world, final Object... data) {
            return new Object[] { 0, 0.28f * world.rand.nextFloat(), -1, this.texture, 1 };
        }
	},
	
	TREASURE_SMALL((Class)EntitySculkParticle.class, ParticleData.VX_VY_VZ, new Class[] { Integer.TYPE, Float.TYPE, Integer.TYPE, ResourceLocation.class, Integer.TYPE }) {
        private final ResourceLocation texture;
        
        {
            this.texture = new ResourceLocation("nova_craft:textures/particles/treasure_crate_particle.png");
        }
        
        @Override
        protected Object[] getAdditionalArgs(final World world, final Object... data) {
            return new Object[] { 0, 0.12f * world.rand.nextFloat(), -1, this.texture, 1 };
        }
	},
	
	AVIS((Class)EntityRandomShapedParticle.class, ParticleData.VX_VY_VZ, new Class[] { Integer.TYPE, Float.TYPE, Integer.TYPE, ResourceLocation.class, Integer.TYPE }) {
        private final ResourceLocation texture;
        
        {
            this.texture = new ResourceLocation("nova_craft:textures/particles/enderavis_particle.png");
        }
        
        @Override
        protected Object[] getAdditionalArgs(final World world, final Object... data) {
            return new Object[] { 0, 0.18f * world.rand.nextFloat(), -1, this.texture, 16 };
        }
	},
	
	VIBRATION((Class)EntityRandomShapedParticle.class, ParticleData.VX_VY_VZ, new Class[] { Integer.TYPE, Float.TYPE, Integer.TYPE, ResourceLocation.class, Integer.TYPE }) {
        private final ResourceLocation texture;
        
        {
            this.texture = new ResourceLocation("nova_craft:textures/particles/vibration.png");
        }
        
        @Override
        protected Object[] getAdditionalArgs(final World world, final Object... data) {
            return new Object[] { 0, 0.18f * world.rand.nextFloat(), -1, this.texture, 16 };
        }
	},
	
	PORTAL_PARTICLE((Class)EntityRandomShapedParticle.class, ParticleData.VX_VY_VZ, new Class[] { Integer.TYPE, Float.TYPE, Integer.TYPE, ResourceLocation.class, Integer.TYPE }) {
        private final ResourceLocation texture;
        
        {
            this.texture = new ResourceLocation("nova_craft:textures/particles/portal_particle.png");
        }
        
        @Override
        protected Object[] getAdditionalArgs(final World world, final Object... data) {
            return new Object[] { 0, 0.12f * world.rand.nextFloat(), -1, this.texture, 6 };
        }
	},
	
	ANCIENT_VIBRATION((Class)EntityRandomShapedParticle.class, ParticleData.VX_VY_VZ, new Class[] { Integer.TYPE, Float.TYPE, Integer.TYPE, ResourceLocation.class, Integer.TYPE }) {
        private final ResourceLocation texture;
        
        {
            this.texture = new ResourceLocation("nova_craft:textures/particles/ancient_vibration.png");
        }
        
        @Override
        protected Object[] getAdditionalArgs(final World world, final Object... data) {
            return new Object[] { 0, 0.18f * world.rand.nextFloat(), -1, this.texture, 16 };
        }
	},
	
	WARDEN((Class)EntityRandomShapedParticle.class, ParticleData.VX_VY_VZ, new Class[] { Integer.TYPE, Float.TYPE, Integer.TYPE, ResourceLocation.class, Integer.TYPE }) {
        private final ResourceLocation texture;
        
        {
            this.texture = new ResourceLocation("nova_craft:textures/particles/warden_particles.png");
        }
        
        @Override
        protected Object[] getAdditionalArgs(final World world, final Object... data) {
            return new Object[] { 0, 0.18f * world.rand.nextFloat(), -1, this.texture, 16 };
        }
	},
	
	FIREFLY((Class)EntityRandomShapedParticleOld.class, ParticleData.VX_VY_VZ, new Class[] { Integer.TYPE, Float.TYPE, Integer.TYPE, ResourceLocation.class, Integer.TYPE }) {
        private final ResourceLocation texture;
        
        {
            this.texture = new ResourceLocation("nova_craft:textures/particles/firefly_glow.png");
        }
        
        @Override
        protected Object[] getAdditionalArgs(final World world, final Object... data) {
            return new Object[] { 0, 0.09f * world.rand.nextFloat(), -1, this.texture, 1 };
        }
	},
	
	SEALED_PORTAL((Class)EntityRandomShapedParticleOld.class, ParticleData.VX_VY_VZ, new Class[] { Integer.TYPE, Float.TYPE, Integer.TYPE, ResourceLocation.class, Integer.TYPE }) {
        private final ResourceLocation texture;
        
        {
            this.texture = new ResourceLocation("nova_craft:textures/particles/sealed_portal_particle.png");
        }
        
        @Override
        protected Object[] getAdditionalArgs(final World world, final Object... data) {
            return new Object[] { 0, 0.09f * world.rand.nextFloat(), -1, this.texture, 1 };
        }
	},
	
	IONFLAME((Class)EntitySculkParticle.class, ParticleData.VX_VY_VZ, new Class[] { Integer.TYPE, Float.TYPE, Integer.TYPE, ResourceLocation.class, Integer.TYPE }) {
        private final ResourceLocation texture;
        
        {
            this.texture = new ResourceLocation("nova_craft:textures/particles/ionizatior_flame.png");
        }
        
        @Override
        protected Object[] getAdditionalArgs(final World world, final Object... data) {
            return new Object[] { 0, 0.12f * world.rand.nextFloat(), -1, this.texture, 1 };
        }
	},
	
	IONFLAMELARGE((Class)EntitySculkParticle.class, ParticleData.VX_VY_VZ, new Class[] { Integer.TYPE, Float.TYPE, Integer.TYPE, ResourceLocation.class, Integer.TYPE }) {
        private final ResourceLocation texture;
        
        {
            this.texture = new ResourceLocation("nova_craft:textures/particles/ionizatior_flame.png");
        }
        
        @Override
        protected Object[] getAdditionalArgs(final World world, final Object... data) {
            return new Object[] { 0, 0.36f * world.rand.nextFloat(), -1, this.texture, 1 };
        }
	},
	
	IONFLAMEHUGE((Class)EntitySculkParticle.class, ParticleData.VX_VY_VZ, new Class[] { Integer.TYPE, Float.TYPE, Integer.TYPE, ResourceLocation.class, Integer.TYPE }) {
        private final ResourceLocation texture;
        
        {
            this.texture = new ResourceLocation("nova_craft:textures/particles/ionizatior_flame.png");
        }
        
        @Override
        protected Object[] getAdditionalArgs(final World world, final Object... data) {
            return new Object[] { 0, 0.60f * world.rand.nextFloat(), -1, this.texture, 1 };
        }
	},
	
	GLOWFLAME((Class)EntitySculkParticle.class, ParticleData.VX_VY_VZ, new Class[] { Integer.TYPE, Float.TYPE, Integer.TYPE, ResourceLocation.class, Integer.TYPE }) {
        private final ResourceLocation texture;
        
        {
            this.texture = new ResourceLocation("nova_craft:textures/particles/glow_flame.png");
        }
        
        @Override
        protected Object[] getAdditionalArgs(final World world, final Object... data) {
            return new Object[] { 0, 0.12f * world.rand.nextFloat(), -1, this.texture, 1 };
        }
	},
	
	SMALLIONFLAME((Class)EntitySculkParticle.class, ParticleData.VX_VY_VZ, new Class[] { Integer.TYPE, Float.TYPE, Integer.TYPE, ResourceLocation.class, Integer.TYPE }) {
        private final ResourceLocation texture;
        
        {
            this.texture = new ResourceLocation("nova_craft:textures/particles/ionizatior_flame.png");
        }
        
        @Override
        protected Object[] getAdditionalArgs(final World world, final Object... data) {
            return new Object[] { 0, 0.08f * world.rand.nextFloat(), -1, this.texture, 1 };
        }
	},
	
	SMALLREDFLAME((Class)EntitySculkParticle.class, ParticleData.VX_VY_VZ, new Class[] { Integer.TYPE, Float.TYPE, Integer.TYPE, ResourceLocation.class, Integer.TYPE }) {
        private final ResourceLocation texture;
        
        {
            this.texture = new ResourceLocation("nova_craft:textures/particles/red_flame.png");
        }
        
        @Override
        protected Object[] getAdditionalArgs(final World world, final Object... data) {
            return new Object[] { 0, 0.08f * world.rand.nextFloat(), -1, this.texture, 1 };
        }
	},
	
	SMALLBLUEFLAME((Class)EntitySculkParticle.class, ParticleData.VX_VY_VZ, new Class[] { Integer.TYPE, Float.TYPE, Integer.TYPE, ResourceLocation.class, Integer.TYPE }) {
        private final ResourceLocation texture;
        
        {
            this.texture = new ResourceLocation("nova_craft:textures/particles/ion_flame.png");
        }
        
        @Override
        protected Object[] getAdditionalArgs(final World world, final Object... data) {
            return new Object[] { 0, 0.08f * world.rand.nextFloat(), -1, this.texture, 1 };
        }
	},

    BLUEFLAME((Class)EntityBlazliniteParticle.class, ParticleData.VX_VY_VZ, new Class[] { Integer.TYPE, Float.TYPE, Integer.TYPE, ResourceLocation.class, Integer.TYPE }) {
        private final ResourceLocation texture;

        {
            this.texture = new ResourceLocation("nova_craft:textures/particles/ion_flame.png");
        }

        @Override
        protected Object[] getAdditionalArgs(final World world, final Object... data) {
            return new Object[] { 0, 0.12f * world.rand.nextFloat(), -1, this.texture, 1 };
        }
    },
	
	BLAZFLAME((Class)EntityBlazliniteParticle.class, ParticleData.VX_VY_VZ, new Class[] { Integer.TYPE, Float.TYPE, Integer.TYPE, ResourceLocation.class, Integer.TYPE }) {
        private final ResourceLocation texture;
        
        {
            this.texture = new ResourceLocation("nova_craft:textures/particles/blazlinite_flame.png");
        }
        
        @Override
        protected Object[] getAdditionalArgs(final World world, final Object... data) {
            return new Object[] { 0, 0.12f * world.rand.nextFloat(), -1, this.texture, 12 };
        }
	},
	
	BLAZSPLASH((Class)EntityBlazliniteParticle.class, ParticleData.VX_VY_VZ, new Class[] { Integer.TYPE, Float.TYPE, Integer.TYPE, ResourceLocation.class, Integer.TYPE }) {
        private final ResourceLocation texture;
        
        {
            this.texture = new ResourceLocation("nova_craft:textures/particles/blazlinite_splash.png");
        }
        
        @Override
        protected Object[] getAdditionalArgs(final World world, final Object... data) {
            return new Object[] { 0, 0.06f * world.rand.nextFloat(), -1, this.texture, 6 };
        }
	},
	
	SCULK((Class)EntitySculkParticle.class, ParticleData.VX_VY_VZ, new Class[] { Integer.TYPE, Float.TYPE, Integer.TYPE, ResourceLocation.class, Integer.TYPE }) {
        private final ResourceLocation texture;
        
        {
            this.texture = new ResourceLocation("nova_craft:textures/particles/sculk_particle.png");
        }
        
        @Override
        protected Object[] getAdditionalArgs(final World world, final Object... data) {
            return new Object[] { 0, 0.18f * world.rand.nextFloat(), -1, this.texture, 16 };	
		}	
      
    }; 
	
	 private static final int REGULAR_ARG_NUM = 4;
	    private Constructor<? extends EntityFX> constructor;
	    private ParticleData args;
	    private Class<?>[] additionalArgTypes;
	    private boolean shouldAssignColor;
	    private float r;
	    private float g;
	    private float b;
	    
	    private ParticleHandler(final Class<? extends EntityFX> fxClass) {
	        this(fxClass, -1.0f, 57005.0f, 49374.0f);
	    }
	    
	    private ParticleHandler(final Class<? extends EntityFX> fxClass, final float r, final float g, final float b) {
	        this(fxClass, r, g, b, ParticleData.VX_VY_VZ, (Class<?>[])new Class[0]);
	    }
	    
	    private ParticleHandler(final Class<? extends EntityFX> fxClass, final ParticleData args, final Class<?>[] additionalArgTypes) {
	        this(fxClass, -1.0f, 57005.0f, 49374.0f, args, additionalArgTypes);
	    }
	    
	    private ParticleHandler(final Class<? extends EntityFX> fxClass, final float r, final float g, final float b, final ParticleData args, final Class<?>[] additionalArgTypes) {
	        this.shouldAssignColor = false;
	        if (r != -1.0f) {
	            this.shouldAssignColor = true;
	            this.r = r;
	            this.g = g;
	            this.b = b;
	        }
	        try {
	            this.constructor = fxClass.getConstructor(getArgumentTypes(args, additionalArgTypes));
	        }
	        catch (Exception e) {
	            final CrashReport crash = CrashReport.makeCrashReport((Throwable)e, "NovaCraft Particle");
	            final CrashReportCategory categoryArguments = crash.makeCategory("Arguments");
	            categoryArguments.addCrashSection("Class", (Object)fxClass);
	            categoryArguments.addCrashSection("Particle Arg Types", (Object)args);
	            categoryArguments.addCrashSection("Additional Arg Types", (Object)Arrays.toString(additionalArgTypes));
	            throw new ReportedException(crash);
	        }
	        this.args = args;
	        this.additionalArgTypes = additionalArgTypes;
	    }
	    
	    private static Class<?>[] getArgumentTypes(final ParticleData args, final Class<?>[] additionalArgTypes) {
	        final Class<?>[] argumentTypes = (Class<?>[])new Class[4 + args.getArgumentCount() + additionalArgTypes.length];
	        argumentTypes[0] = World.class;
	        argumentTypes[1] = Double.TYPE;
	        argumentTypes[2] = Double.TYPE;
	        argumentTypes[3] = Double.TYPE;
	        System.arraycopy(args.getArgumentTypes(), 0, argumentTypes, 4, args.getArgumentCount());
	        System.arraycopy(additionalArgTypes, 0, argumentTypes, 4 + args.getArgumentCount(), additionalArgTypes.length);
	        return argumentTypes;
	    }
	    
	    protected Object[] getAdditionalArgs(final World world, final Object... data) {
	        return new Object[0];
	    }
	    
	    protected void onSpawn(final EntityFX entityFX) {
	    }
	    
	    public final void spawn(final World world, final double x, final double y, final double z) {
	        this.spawn(world, x, y, z, 0.0, 0.0, 0.0, 1.0f, new Object[0]);
	    }
	    
	    public final void spawn(final World world, final double x, final double y, final double z, final double motionX, final double motionY, final double motionZ, final float scale, final Object... data) {
	        final Object[] arguments = this.getArguments(world, x, y, z, motionX, motionY, motionZ, scale, data);
	        try {
	            final EntityFX entityFX = (EntityFX)this.constructor.newInstance(arguments);
	            if (this.shouldAssignColor) {
	                entityFX.setRBGColorF(this.r, this.g, this.b);
	            }
	            this.onSpawn(entityFX);
	            Minecraft.getMinecraft().effectRenderer.addEffect(entityFX);
	        }
	        catch (Exception e) {
	            final CrashReport crash = CrashReport.makeCrashReport((Throwable)e, "Constructing EntityFX");
	            final CrashReportCategory categorySpawnArguments = crash.makeCategory("Spawn Arguments");
	            categorySpawnArguments.addCrashSection("World", (Object)world);
	            categorySpawnArguments.addCrashSection("X", (Object)x);
	            categorySpawnArguments.addCrashSection("Y", (Object)y);
	            categorySpawnArguments.addCrashSection("Z", (Object)z);
	            categorySpawnArguments.addCrashSection("Motion X", (Object)motionX);
	            categorySpawnArguments.addCrashSection("Motion Y", (Object)motionY);
	            categorySpawnArguments.addCrashSection("Motion Z", (Object)motionZ);
	            categorySpawnArguments.addCrashSection("Scale", (Object)scale);
	            categorySpawnArguments.addCrashSection("Data", (Object)Arrays.deepToString(data));
	            final CrashReportCategory categoryNetherliciousParticle = crash.makeCategory("NovaCraftParticle");
	            categoryNetherliciousParticle.addCrashSection("Constructor", (Object)this.constructor);
	            categoryNetherliciousParticle.addCrashSection("Particle Arg Types", (Object)this.args);
	            categoryNetherliciousParticle.addCrashSection("Additional Arg Types", (Object)Arrays.toString(this.additionalArgTypes));
	            final CrashReportCategory categoryArguments = crash.makeCategory("Arguments");
	            categoryArguments.addCrashSection("Arguments", (Object)Arrays.deepToString(arguments));
	            throw new ReportedException(crash);
	        }
	    }
	    
	    private Object[] getArguments(final World world, final double x, final double y, final double z, final double motionX, final double motionY, final double motionZ, final float scale, final Object... data) {
	        final Object[] particleArgs = this.args.getArguments(motionX, motionY, motionZ, scale);
	        final Object[] additionalArgs = this.getAdditionalArgs(world, data);
	        final Object[] arguments = new Object[4 + this.args.getArgumentCount() + additionalArgs.length];
	        arguments[0] = world;
	        arguments[1] = x;
	        arguments[2] = y;
	        arguments[3] = z;
	        System.arraycopy(particleArgs, 0, arguments, 4, this.args.getArgumentCount());
	        System.arraycopy(additionalArgs, 0, arguments, 4 + this.args.getArgumentCount(), additionalArgs.length);
	        return arguments;
	    }
	
}
