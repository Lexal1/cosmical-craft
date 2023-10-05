package lexal.cosmic.mixin.core.block;

import lexal.cosmic.block.ModBlocks;
import lexal.cosmic.world.ISpace;
import lexal.cosmic.world.ModDimensions;
import net.minecraft.core.block.Block;
import net.minecraft.core.block.BlockTorch;
import net.minecraft.core.block.material.Material;
import net.minecraft.core.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Random;

@Mixin(value = BlockTorch.class,remap = false)
public class BlockTorchMixin extends Block{

    public BlockTorchMixin(String key, int id, Material material) {
        super(key, id, material);
    }

    @Inject(method = "updateTick(Lnet/minecraft/core/world/World;IIILjava/util/Random;)V", at = @At("TAIL"), cancellable = true)
    private void burnOut(World world, int x, int y, int z, Random rand, CallbackInfo ci){
        if (world.worldType instanceof ISpace){
            ISpace worldSpace = (ISpace) world;
            if (worldSpace.suffocate() && (this.id == Block.torchCoal.id)){
                world.setBlockWithNotify(x,y,z, ModBlocks.torchUnlit.id);
                ci.cancel();
            }
        }
    }
}
