package lexal.cosmic.world.biomes;

import lexal.cosmic.block.ModBlocks;
import lexal.cosmic.world.biomes.BiomeMoon;
import net.minecraft.core.world.biome.Biome;
import net.minecraft.core.world.biome.Biomes;

public class ModBiomes {
    public static final Biome biomeMoon = Biomes.register("btb:moon.moon", new BiomeMoon("moon"));
    static
    {
        biomeMoon.topBlock = (short) ModBlocks.moonsnow.id;
        biomeMoon.fillerBlock = (short) ModBlocks.moonturf.id;
    }
    public static void register() {}
}
