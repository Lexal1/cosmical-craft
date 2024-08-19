package lexal.cosmic.mixin.core.entity;

import com.mojang.nbt.CompoundTag;
import lexal.cosmic.block.ModMaterials;
import lexal.cosmic.world.ISpace;
import lexal.cosmic.world.worldType.WorldTypeMoon;
import net.minecraft.core.block.material.Material;
import net.minecraft.core.entity.Entity;
import net.minecraft.core.entity.EntityLiving;
import net.minecraft.core.world.World;
import org.objectweb.asm.Opcodes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.*;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value = EntityLiving.class, remap = false)
public class EntityLivingMixin {
    float gravity = 1.F - 0.45f;

    // This is incompatible with moon-mod and possibly Moon^3
    @Redirect(method = "moveEntityWithHeading(FF)V", at = @At(value = "FIELD", target = "Lnet/minecraft/core/entity/EntityLiving;yd:D", opcode = Opcodes.PUTFIELD))
    private void entityGravity(EntityLiving entity, double yd){ //Probably terrible way of modifying gravity by a scalar
        if (entity.world.getWorldType() instanceof WorldTypeMoon) {
            double offset = -(yd - ((EntityLiving)(Object)this).yd);
            if ((0.021 > offset && offset > 0.019) || (0.081 > offset && offset > 0.079)){ // If falling in water or in air
                entity.yd -= offset * gravity;
            } else if ((-0.251 < yd && yd < -0.249)) { // Terminal velocity
                entity.yd = yd * gravity;
            } else { // Else regular behavior
                entity.yd = yd;
            }
        } else {
            entity.yd = yd;
        }
    }
    @ModifyVariable(method = "causeFallDamage(F)V", at = @At(value = "STORE"), ordinal = 0)
    private int changeFallDamage(int i){
        if (((EntityLiving)(Object)this).world.getWorldType() instanceof WorldTypeMoon){
            return (int)((i * gravity) - (3 / gravity) + 2);
        }
        return i;
    }
}
