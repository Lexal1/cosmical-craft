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

@Mixin(value = Entity.class, remap = false)
public class EntityMixin {
    //@Redirect(method = "trySuffocate()V", at = @At(value = "INVOKE", target = "isUnderLiquid"))
    @Inject(method = "isUnderLiquid", at = @At(value = "RETURN"), cancellable = true)
    public void moonSuffocation(Material material, CallbackInfoReturnable<Boolean> cir) {
        if (material == ModMaterials.gas) return;
        if (!((Object) this instanceof EntityLiving)) return;
        EntityLiving living = (EntityLiving) (Object) this;
        if (living.isUnderLiquid(ModMaterials.gas)) { // Can Breath in Air
            cir.setReturnValue(false);
            return;
        }
        boolean shouldSuffocate = false;
        if (living.world.getWorldType() instanceof ISpace){
            shouldSuffocate = ((ISpace) living.world.getWorldType()).suffocate();
        }
        cir.setReturnValue(shouldSuffocate || cir.getReturnValue()); // Suffocate underwater or on moon
    }

    // Gravity is handled by Moon^3
}
