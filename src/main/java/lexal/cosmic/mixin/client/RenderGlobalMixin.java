package lexal.cosmic.mixin.client;

import lexal.cosmic.world.ISpace;
import lexal.cosmic.world.worldType.WorldTypeMoon;
import net.minecraft.client.render.RenderEngine;
import net.minecraft.client.render.RenderGlobal;
import net.minecraft.core.block.Block;
import net.minecraft.core.block.entity.TileEntity;
import net.minecraft.core.entity.Entity;
import net.minecraft.core.entity.player.EntityPlayer;
import net.minecraft.core.world.LevelListener;
import net.minecraft.core.world.World;
import org.lwjgl.opengl.GL11;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = RenderGlobal.class, remap = false)
public class RenderGlobalMixin {
    @Shadow
    private World worldObj;
    @Shadow
    private RenderEngine renderEngine;

    @Inject(method = "drawSky(F)V",
        at = @At(value = "INVOKE", target = "Lorg/lwjgl/opengl/GL11;glBindTexture(II)V",
            shift = At.Shift.AFTER,
            ordinal = 1))
    private void moonMod_renderEarthAsMoon(float renderPartialTicks, CallbackInfo cbi) {// Replace moon texture
        if (this.worldObj.getWorldType() instanceof ISpace) {
            ISpace worldSpace = (ISpace) worldObj.getWorldType();
            GL11.glBindTexture(3553, this.renderEngine.getTexture(worldSpace.getCelestialMoonTexture()));
        }
    }
}
