package lexal.cosmic;

import lexal.cosmic.block.ModBlockTags;
import lexal.cosmic.block.ModBlocks;
import lexal.cosmic.crafting.ModCraftingManager;
import lexal.cosmic.entity.ModEntities;
import lexal.cosmic.item.ModItems;
import lexal.cosmic.item.ModItemTags;
import lexal.cosmic.modmodule.SpawnEggsModule;
import lexal.cosmic.world.ModDimensions;
import lexal.cosmic.world.biomes.ModBiomes;
import lexal.cosmic.world.worldType.ModWorldType;
import net.minecraft.core.item.Item;
import net.minecraft.core.block.Block;
import net.minecraft.core.data.tag.Tag;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import turniplabs.halplibe.util.ConfigHandler;
import turniplabs.halplibe.helper.ModVersionHelper;
import turniplabs.halplibe.util.GameStartEntrypoint;
import turniplabs.halplibe.helper.SoundHelper;

import java.util.Properties;

import static net.minecraft.core.item.tool.ItemToolPickaxe.miningLevels;


public class CosmicCraft implements ModInitializer, GameStartEntrypoint {
    public static final String MOD_ID = "cosmic";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
    private void handleConfig() {
        Properties prop = new Properties();
        prop.setProperty("starting_block_id","5600");
        prop.setProperty("starting_item_id","21100");
        //prop.setProperty("starting_spawneggs_item_id","21200");
        ConfigHandler config = new ConfigHandler(MOD_ID,prop);
        UtilIdRegistrar.initIds(
            config.getInt("starting_block_id"),
            config.getInt("starting_item_id"),
            0
            //config.getInt("starting_spawneggs_item_id")
        );
        config.updateConfig();
    }
    //public static final boolean spawnEggsModPresent = ModVersionHelper.isVersionPresent("spawneggs");


    @Override
    public void onInitialize() {}

    @Override
    public void beforeGameStart() {
        LOGGER.info("CosmicCraft loading! beware the skeletons");
        handleConfig();

        ModBlockTags.register();

        ModBlocks.register();
        miningLevels.put(ModBlocks.meteorblock,3);
        miningLevels.put(ModBlocks.meteorore,3);
        miningLevels.put(ModBlocks.starsteelblock,4);
        ModItems.register();

        ModBiomes.register();
        ModWorldType.register();
        ModDimensions.register();

        ModEntities.register();

        SoundHelper.addMusic(MOD_ID, "moon/moon0.wav");
        SoundHelper.addMusic(MOD_ID, "moon/moon1.wav");
        SoundHelper.addMusic(MOD_ID, "moon/moon2.wav");
        SoundHelper.addMusic(MOD_ID, "moon/moon3.wav");
        SoundHelper.addMusic(MOD_ID, "moon/moon4.wav");

        /*if (spawnEggsModPresent){
            SpawnEggsModule.onInitialize();;
        }*/
        LOGGER.info("CosmicCraft loaded successfully!");
    }

    @Override
    public void afterGameStart() {
        Block.glass.asItem().withTags((Tag<Item>[]) new Tag[] {ModItemTags.breathable});
        Block.glassTinted.asItem().withTags(ModItemTags.breathable);
    }
}
