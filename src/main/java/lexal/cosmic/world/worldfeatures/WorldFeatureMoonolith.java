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
        for(int chance = 0; chance < 20; ++chance) {
            int width = x + 15;
            int height = y;
            int depth = z + 9;
            if (world.isAirBlock(width, y, width)) {
                int l1 = 2 + random.nextInt(random.nextInt(15) + 13);
                int m1 = 2 + random.nextInt(random.nextInt(15) + 13);
                int n1 = 2 + random.nextInt(random.nextInt(15) + 9);

                for(int i2 = 0; i2 < l1; ++i2) {
                    if (Block.obsidian.canBlockStay(world, width + i2, height, width)) {
                        world.setBlock(width + i2, height, width, Block.obsidian.id);
                    }
                }
                for(int j2 = 0; j2 < m1; ++j2) {
                    if (Block.obsidian.canBlockStay(world, width, height + j2, width)) {
                        world.setBlock(width, height + j2, width, Block.obsidian.id);
                    }
                }
                for(int k2 = 0; k2 < n1; ++k2) {
                    if (Block.obsidian.canBlockStay(world, width, height, width + k2)) {
                        world.setBlock(width, height, width + k2, Block.obsidian.id);
                    }
                }
            }
        }
        return true;
    }
}