package lexal.cosmic.world.worldfeatures;

import net.minecraft.core.block.Block;
import net.minecraft.core.block.material.Material;
import net.minecraft.core.world.World;
import net.minecraft.core.world.generate.feature.WorldFeature;
import net.minecraft.core.world.generate.feature.WorldFeatureLabyrinth;
import net.minecraft.core.world.generate.feature.WorldFeatureSugarCane;

import java.util.Random;

public class WorldFeatureMoonolith extends WorldFeature {
    @Override
    public boolean generate(World world, Random random, int x, int y, int z) {
        int width = 10 + random.nextInt(5);
        int height = 15 + random.nextInt(20);
        int depth = 10 + random.nextInt(5);
        for (int dy = y - 10; dy <= y + height; dy++) {
            for (int dx = x; dx <= x + width; dx++) {
                for (int dz = z; dz <= z + depth; dz++) {
                    if (Block.obsidian.canBlockStay(world, dx, dy, dz)){
                        world.setBlock(dx,dy,dz, Block.obsidian.id);
                    }
                }
            }
        }
        return true;
    }
}