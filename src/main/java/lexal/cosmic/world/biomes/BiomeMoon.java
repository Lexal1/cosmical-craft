package lexal.cosmic.world.biomes;

import lexal.cosmic.entity.EntitySpaceSkeleton;
import lexal.cosmic.entity.EntitySpaceZombie;
import net.minecraft.core.entity.SpawnListEntry;
import net.minecraft.core.entity.monster.EntitySkeleton;
import net.minecraft.core.world.biome.Biome;

public class BiomeMoon extends Biome {
    public BiomeMoon(String name) {
        super(name);
        this.spawnableMonsterList.clear();
        this.spawnableCreatureList.clear();
        this.spawnableWaterCreatureList.clear();
        this.spawnableMonsterList.add(new SpawnListEntry(EntitySpaceSkeleton.class, 7));
        this.spawnableMonsterList.add(new SpawnListEntry(EntitySpaceZombie.class, 5));
    }
    @Override
    public int getSkyColor(float temperature) {
        return 0;
    }
}
