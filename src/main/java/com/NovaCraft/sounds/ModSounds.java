package com.NovaCraft.sounds;

import net.minecraft.block.*;

public class ModSounds
{
    public static final Block.SoundType soundGrimstone;
    public static final Block.SoundType soundGrimstoneBricks;
    public static final Block.SoundType soundMoss;
    public static final Block.SoundType soundSculk;
    public static final Block.SoundType soundSculkVein;
    public static final Block.SoundType soundSculkBricks;
    public static final Block.SoundType soundWarpedSlime;
    public static final Block.SoundType soundNullstone;
    public static final Block.SoundType soundNullstoneBricks;
    public static final Block.SoundType soundCrystal;
    public static final Block.SoundType soundCrystalCluster;
    public static final Block.SoundType soundEtherstone;
    public static final Block.SoundType soundEtherstoneBricks;
    public static final Block.SoundType soundFrontierslate;
    public static final Block.SoundType soundFrontierslateBricks;
    public static final Block.SoundType soundVoid;
    
    static {
        soundGrimstone = new Block.SoundType("Grimstone", 1.5f, 1.5f) {
            public String getBreakSound() {
                return "nova_craft:grimstone.break";
            }
            
            public String getStepResourcePath() {
                return "nova_craft:grimstone.break";
            }
            
            public String func_150496_b() {
                return "nova_craft:grimstone.place";
            }
        };
        
        soundGrimstoneBricks = new Block.SoundType("GrimstoneBricks", 1.5f, 1.5f) {
            public String getBreakSound() {
                return "nova_craft:grimstone_bricks.break";
            }
            
            public String getStepResourcePath() {
                return "nova_craft:grimstone_bricks.break";
            }
            
            public String func_150496_b() {
                return "nova_craft:grimstone_bricks.place";
            }
        };
        
        soundSculk = new Block.SoundType("Sculk", 1.0f, 1.0f) {
            public String getBreakSound() {
                return "nova_craft:sculk.break";
            }
            
            public String getStepResourcePath() {
                return "nova_craft:sculk.break";
            }
            
            public String func_150496_b() {
                return "nova_craft:sculk.place";
            }
        };
        
        soundVoid = new Block.SoundType("Void", 12.0f, 12.0f) {
        	 public String getBreakSound() {
                 return "nova_craft:crystal.break";
             }
             
             public String getStepResourcePath() {
                 return "nova_craft:crystal.break";
             }
             
             public String func_150496_b() {
             	return "nova_craft:crystal.place";
             }
        };
        
        soundSculkVein = new Block.SoundType("SculkVein", 1.0f, 1.0f) {
            public String getBreakSound() {
                return "nova_craft:sculk_vein.break";
            }
            
            public String getStepResourcePath() {
                return "nova_craft:sculk_vein.break";
            }
            
            public String func_150496_b() {
                return "nova_craft:sculk.place";
            }
        };
        
        soundSculkBricks = new Block.SoundType("SculkBricks", 2.0f, 2.0f) {
        	public String getBreakSound() {
                return "nova_craft:grimstone_bricks.break";
            }
            
            public String getStepResourcePath() {
                return "nova_craft:grimstone_bricks.break";
            }
            
            public String func_150496_b() {
                return "nova_craft:grimstone_bricks.place";
            }
        };
        
        soundWarpedSlime = new Block.SoundType("soundWarpedSlime", 0.5f, 0.5f) {
            public String getBreakSound() {
                return "nova_craft:sculk.break";
            }
            
            public String getStepResourcePath() {
                return "nova_craft:sculk.break";
            }
            
            public String func_150496_b() {
                return "nova_craft:sculk.place";
            }
        };
        
        soundMoss = new Block.SoundType("Moss", 1.0f, 1.0f) {
            public String getBreakSound() {
                return "nova_craft:moss.break";
            }
            
            public String getStepResourcePath() {
                return "nova_craft:moss.break";
            }
                 
        };
        
        soundNullstone = new Block.SoundType("Nullstone", 3.0f, 3.0f) {
            public String getBreakSound() {
                return "nova_craft:nullstone.break";
            }
            
            public String getStepResourcePath() {
                return "nova_craft:nullstone.break";
            }
            
            public String func_150496_b() {
                return "nova_craft:grimstone.place";
            }
        };
        
        soundNullstoneBricks = new Block.SoundType("NullstoneBricks", 3.0f, 3.0f) {
            public String getBreakSound() {
                return "nova_craft:nullstone.break";
            }
            
            public String getStepResourcePath() {
                return "nova_craft:nullstone.break";
            }
            
            public String func_150496_b() {
                return "nova_craft:grimstone_bricks.place";
            }
        };
        
        
        soundEtherstone = new Block.SoundType("Etherstone", 0.8f, 0.8f) {
            public String getBreakSound() {
                return "nova_craft:nullstone.break";
            }
            
            public String getStepResourcePath() {
                return "nova_craft:nullstone.break";
            }
            
            public String func_150496_b() {
                return "nova_craft:grimstone.place";
            }
        };
        
        soundEtherstoneBricks = new Block.SoundType("EtherstoneBricks", 0.9f, 0.9f) {
            public String getBreakSound() {
                return "nova_craft:nullstone.break";
            }
            
            public String getStepResourcePath() {
                return "nova_craft:nullstone.break";
            }
            
            public String func_150496_b() {
                return "nova_craft:grimstone.place";
            }
        };
        
        soundFrontierslate = new Block.SoundType("Froniterslate", 2.5f, 2.5f) {
            public String getBreakSound() {
                return "nova_craft:nullstone.break";
            }
            
            public String getStepResourcePath() {
                return "nova_craft:nullstone.break";
            }
            
            public String func_150496_b() {
                return "nova_craft:grimstone.place";
            }
        };
        
        soundFrontierslateBricks = new Block.SoundType("FroniterslateBricks", 2.5f, 2.5f) {
        	public String getBreakSound() {
                return "nova_craft:nullstone.break";
            }
            
            public String getStepResourcePath() {
                return "nova_craft:nullstone.break";
            }
            
            public String func_150496_b() {
                return "nova_craft:grimstone_bricks.place";
            }
        };
             
        soundCrystal = new Block.SoundType("Crystal", 2.0f, 2.0f) {
            public String getBreakSound() {
                return "nova_craft:crystal.break";
            }
            
            public String getStepResourcePath() {
                return "nova_craft:crystal.break";
            }
            
            public String func_150496_b() {
            	return "nova_craft:crystal.place";
            }
        };
        
        soundCrystalCluster = new Block.SoundType("CrystalCluster", 2.0f, 2.0f) {
            public String getBreakSound() {
                return "nova_craft:crystal_cluster.break";
            }
            
            public String getStepResourcePath() {
                return "nova_craft:crystal_cluster.break";
            }
            
            public String func_150496_b() {
            	return "nova_craft:crystal_cluster.place";
            }
        };
    }
    
    private static final class CustomSound extends Block.SoundType
    {
        private final boolean useDefaults;
        
        public CustomSound(final String name, final float volume, final float pitch, final boolean useDefaults) {
            super(name, volume, pitch);
            this.useDefaults = useDefaults;
        }
        
        public CustomSound(final String name) {
            this(name, 1.0f, 1.0f, false);
        }
        
        public String getBreakSound() {
            return this.useDefaults ? super.getBreakSound() : this.soundName;
        }
        
        public String getStepResourcePath() {
            return this.useDefaults ? super.getStepResourcePath() : this.soundName;
        }
    }
}