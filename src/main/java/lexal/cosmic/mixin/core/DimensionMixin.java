package lexal.cosmic.mixin.core;

import net.minecraft.core.world.Dimension;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import lexal.cosmic.world.ModDimensions;
import lexal.cosmic.block.ModBlocks;
import lexal.cosmic.world.worldType.ModWorldType;

import static net.minecraft.core.world.Dimension.registerDimension;

@Mixin(value = Dimension.class, remap = false)
public abstract class DimensionMixin {

	@Inject(method = "<clinit>", at = @At("TAIL"))
	private static void addDimension(CallbackInfo ci){
		ModDimensions.dimensionMoon = new Dimension("the-moon", Dimension.overworld, 3f, ModBlocks.portalmoon.id).setDefaultWorldType(ModWorldType.worldTypeMoon);
		Dimension.registerDimension(3, ModDimensions.dimensionMoon);
	}
}
