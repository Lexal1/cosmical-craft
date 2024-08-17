package lexal.cosmic.mixin.core.entity;

import net.minecraft.core.entity.Entity;
import net.minecraft.core.entity.monster.EntityMonster;
import net.minecraft.core.entity.monster.EntityArmoredZombie;
import net.minecraft.core.util.helper.DamageType;
import net.minecraft.core.world.World;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value = EntityArmoredZombie.class, remap = false)
public class EntityArmoredZombieMixin extends EntityMonster {
    public EntityArmoredZombieMixin(World world) {
        super(world);
    }

    @Inject(method = "hurt", at = @At("HEAD"), cancellable = true)
    public void _hurt(Entity attacker, int i, DamageType type, CallbackInfoReturnable<Boolean> cir) {
        if ((EntityArmoredZombie) (Object) this instanceof lexal.cosmic.entity.EntitySpaceZombie) {
            // Don't let space zombies drop chains
            cir.setReturnValue(super.hurt(attacker, i, type));
        }
    }
}
