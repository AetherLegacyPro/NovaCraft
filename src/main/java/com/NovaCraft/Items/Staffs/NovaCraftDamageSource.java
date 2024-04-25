package com.NovaCraft.Items.Staffs;

import com.NovaCraft.entity.misc.EntityDiamondFirechargeProjectile;
import com.NovaCraft.entity.misc.EntityKlangiteFirechargeProjectile;
import com.NovaCraft.entity.misc.EntityVaniteFirechargeProjectile;
import com.NovaCraft.entity.misc.EntityVaniteTrident;

import net.minecraft.entity.Entity;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EntityDamageSourceIndirect;

public class NovaCraftDamageSource {
	
	public static DamageSource causeDiamondFirechargeDamage(final EntityDiamondFirechargeProjectile par1, final Entity par2) {
        return new EntityDamageSourceIndirect("EntityDiamondFirecharge", (Entity)par1, par2).setProjectile();
    }
	
	public static DamageSource causeVaniteFirechargeDamage(final EntityVaniteFirechargeProjectile par1, final Entity par2) {
        return new EntityDamageSourceIndirect("EntityVaniteFirecharge", (Entity)par1, par2).setProjectile();
    }
	
	public static DamageSource causeKlangiteFirechargeDamage(final EntityKlangiteFirechargeProjectile par1, final Entity par2) {
        return new EntityDamageSourceIndirect("EntityKlangiteFirecharge", (Entity)par1, par2).setProjectile();
    }
	
	//public static DamageSource causeVaniteTridentDamage(final EntityVaniteTrident par1, final Entity par2) {
        //return new EntityDamageSourceIndirect("EntityVaniteTrident", (Entity)par1, par2).setProjectile();
    //}
	
	public static DamageSource causeVaniteTridentDamage(EntityVaniteTrident p_76353_0_, Entity p_76353_1_)
    {
        return (new EntityDamageSourceIndirect("EntityVaniteTrident", p_76353_0_, p_76353_1_)).setProjectile();
    }

}
