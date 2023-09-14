package lexal.cosmic.block;

import lexal.cosmic.item.ModItems;
import net.minecraft.core.block.BlockOreIron;
import net.minecraft.core.block.entity.TileEntity;
import net.minecraft.core.block.material.Material;
import net.minecraft.core.enums.EnumDropCause;
import net.minecraft.core.item.Item;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.world.World;

public class BlockMeteorOre extends BlockOreIron {
    public BlockMeteorOre(String key, int id, Material material) {
        super(key, id, material);
    }
    public ItemStack[] getBreakResult(World world, EnumDropCause dropCause, int x, int y, int z, int meta, TileEntity tileEntity) {
        switch (dropCause) {
            case SILK_TOUCH:
            case PICK_BLOCK:
                return new ItemStack[]{new ItemStack(this)};
            case PROPER_TOOL:
                return new ItemStack[]{new ItemStack(ModItems.rawmeteor)};
            default:
                return null;
        }
    }
}
