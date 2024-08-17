package lexal.cosmic.block;

import net.minecraft.core.block.Block;
import net.minecraft.core.block.material.Material;

public class BlockCatwalk extends Block {
    public BlockCatwalk(String key, int id, Material material) {
        super(key, id, material);
        setBlockBounds(0.0f, 0.943f, 0.0f, 1.0f, 1.0f, 1.0f);
    }
    @Override
    public boolean isSolidRender()
    {
        return false;
    }
    @Override
    public boolean renderAsNormalBlock()
    {
        return false;
    }
    @Override
    public int getRenderBlockPass() {
        return 1;
    }
}
