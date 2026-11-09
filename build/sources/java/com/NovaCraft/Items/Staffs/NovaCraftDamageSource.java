package com.NovaCraft.Items.Staffs;

import com.NovaCraft.entity.misc.EntityDiamondFirechargeProjectile;
import com.NovaCraft.entity.misc.EntityKlangiteFirechargeProjectile;
import com.NovaCraft.entity.misc.EntityVaniteFirechargeProjectile;
import com.NovaCraft.entity.misc.EntityVaniteTrident;
import com.NovaCraft.entity.misc.KlangiteSwordProjectile;
import net.minecraft.entity.Entity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EntityDamageSourceIndirect;

public class NovaCraftDamageSource {
	
	public static DamageSource causeDiamondFirechargeDamage(final EntityDiamondFirechargeProjectile projectile, final Entity entity) {
        return new EntityDamageSourceIndirect("EntityDiamondFirecharge", (Entity)projectile, entity).setProjectile();
    }
	
	public static DamageSource causeVaniteFirechargeDamage(final EntityVaniteFirechargeProjectile projectile, final Entity entity) {
        return new EntityDamageSourceIndirect("EntityVaniteFirecharge", (Entity)projectile, entity).setProjectile();
    }
	
	public static DamageSource causeKlangiteFirechargeDamage(final EntityKlangiteFirechargeProjectile projectile, final Entity entity) {
        return new EntityDamageSourceIndirect("EntityKlangiteFirecharge", (Entity)projectile, entity).setProjectile();
    }
	
	public static DamageSource causeVaniteTridentDamage(EntityVaniteTrident entityVaniteTrident, Entity entity)
    {
        return (new EntityDamageSourceIndirect("EntityVaniteTrident", entityVaniteTrident, entity)).setProjectile();
    }
	
	public static DamageSource causeKlangiteSwordDamage(KlangiteSwordProjectile projectile, Entity entity)
    {
        return (new EntityDamageSourceIndirect("EntityKlangiteSwordProjectile", projectile, entity)).setProjectile();
    }

}
