package lexal.cosmic.mixin.core.block;

import lexal.cosmic.CosmicCraft;
import lexal.cosmic.block.ModBlocks;
import lexal.cosmic.world.ISpace;
import lexal.cosmic.world.ModDimensions;
import net.minecraft.core.block.Block;
import net.minecraft.core.block.BlockTorch;
import net.minecraft.core.block.material.Material;
import net.minecraft.core.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Random;

@Mixin(value = BlockTorch.class,remap = false)
public abstract class BlockTorchMixin extends Block{

    @Shadow public abstract void updateTick(World world, int x, int y, int z, Random rand);

    public BlockTorchMixin(String key, int id, Material material) {
        super(key, id, material);
    }
    @Inject(method = "updateTick(Lnet/minecraft/core/world/World;IIILjava/util/Random;)V", at = @At("HEAD"), cancellable = true)
    private void burnOut(World world, int x, int y, int z, Random rand, CallbackInfo ci){
        checkBurnout(world, x, y, z);

    }
    @Unique
    private void checkBurnout(World world, int x, int y, int z){
        if (world.getWorldType() instanceof ISpace){
            ISpace worldSpace = (ISpace) world.getWorldType();
            if ((this.id == Block.torchCoal.id)
                    && worldSpace.suffocate()
                    && !(ModBlocks.doesNeighborBlock(world, x, y, z, ModBlocks.gasAirStill.id) || ModBlocks.doesNeighborBlock(world, x, y, z, ModBlocks.gasAirFlowing.id))){
                world.setBlockWithNotify(x,y,z, ModBlocks.torchUnlit.id);
            } else {
                world.scheduleBlockUpdate(x,y,z, this.id,this.tickRate());
            }
        }
    }
    @Inject(method = "onBlockAdded(Lnet/minecraft/core/world/World;III)V", at = @At("TAIL"))
    private void onBlockAdded(World world, int i, int j, int k, CallbackInfo ci){
        checkBurnout(world, i, j, k);
    }
}
