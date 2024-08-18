package lexal.cosmic.mixin.core.entity;

import com.mojang.nbt.CompoundTag;
import net.minecraft.core.entity.Entity;
import net.minecraft.core.entity.EntityItem;
import net.minecraft.core.world.World;
import org.objectweb.asm.Opcodes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;
import lexal.cosmic.world.ISpace;

@Mixin(value = EntityItem.class, remap = false)
public class EntityItemMixin extends Entity {
    public EntityItemMixin(World world) {
        super(world);
    }

    @Redirect(method = "tick()V", at = @At(value = "FIELD", target = "Lnet/minecraft/core/entity/EntityItem;yd:D", opcode = Opcodes.PUTFIELD, ordinal = 0))
    private void itemGravity(EntityItem item, double yd){
        double offset = -(yd - this.yd);
        double gravity = 1d;
        if (item.world.getWorldType() instanceof ISpace){
            gravity = ((ISpace)item.world.getWorldType()).getGravityScalar();
        }
        item.yd -= offset * gravity;
    }

    @Override public void readAdditionalSaveData(CompoundTag tag) {};
    @Override public void addAdditionalSaveData(CompoundTag tag) {};
    @Override protected void init() {};
}
