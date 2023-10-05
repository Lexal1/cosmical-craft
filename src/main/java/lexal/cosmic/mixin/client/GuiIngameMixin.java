package lexal.cosmic.mixin.client;

import lexal.cosmic.block.ModMaterials;
import lexal.cosmic.world.ISpace;
import lexal.cosmic.world.worldType.WorldTypeMoon;
import net.minecraft.client.entity.player.EntityPlayerSP;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiIngame;
import net.minecraft.core.block.material.Material;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(value = GuiIngame.class, remap = false)
public class GuiIngameMixin extends Gui {
    @Redirect(method = "renderGameOverlay(FZII)V", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/entity/player/EntityPlayerSP;isUnderLiquid(Lnet/minecraft/core/block/material/Material;)Z"))
    private boolean renderOnMoon(EntityPlayerSP player, Material material){
        boolean shouldSuffocate = false;
        if (player.world.getWorldType() instanceof ISpace){
            shouldSuffocate = ((ISpace) player.world.getWorldType()).suffocate();
        }
        shouldSuffocate = shouldSuffocate || player.isUnderLiquid(material);
        return (shouldSuffocate) && !player.isUnderLiquid(ModMaterials.gas); // If underwater or on moon without helmet render oxygen overlay
    }
}
