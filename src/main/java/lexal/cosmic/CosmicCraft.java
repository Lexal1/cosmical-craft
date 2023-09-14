package lexal.cosmic;

import lexal.cosmic.block.ModBlockTags;
import lexal.cosmic.block.ModBlocks;
import lexal.cosmic.crafting.ModCraftingManager;
import lexal.cosmic.entity.ModEntities;
import lexal.cosmic.item.ModItems;
import lexal.cosmic.modmodule.SpawnEggsModule;
import lexal.cosmic.world.ModDimensions;
import lexal.cosmic.world.biomes.ModBiomes;
import lexal.cosmic.world.worldType.ModWorldType;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import turniplabs.halplibe.util.ConfigHandler;
import useless.prismaticlibe.helper.ModCheckHelper;
import useless.prismaticlibe.helper.SoundHelper;

import java.util.Properties;

import static net.minecraft.core.item.tool.ItemToolPickaxe.miningLevels;


public class CosmicCraft implements ModInitializer {
    public static final String MOD_ID = "cosmic";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
    private void handleConfig() {
        Properties prop = new Properties();
        prop.setProperty("starting_block_id","3100");
        prop.setProperty("starting_item_id","21100");
        prop.setProperty("starting_spawneggs_item_id","21200");
        ConfigHandler config = new ConfigHandler(MOD_ID,prop);
        UtilIdRegistrar.initIds(
                config.getInt("starting_block_id"),
                config.getInt("starting_item_id"),
                config.getInt("starting_spawneggs_item_id")
                );
        config.updateConfig();
    }
    public static final boolean spawnEggsModPresent = ModCheckHelper.checkForMod("spawneggs", ">=1.1.0");


    @Override
    public void onInitialize() {
        LOGGER.info("CosmicCraft loading! beware the skeletons");
        handleConfig();

        ModBlockTags.register();

        ModBlocks.register();
        miningLevels.put(ModBlocks.meteorblock,3);
        miningLevels.put(ModBlocks.meteorore,3);
        miningLevels.put(ModBlocks.starsteelblock,4);
        ModItems.register();
        ModCraftingManager.register();

        ModBiomes.register();
        ModWorldType.register();
        ModDimensions.register();

        ModEntities.register();

        SoundHelper.addMusic(MOD_ID, "moon0.wav");
        SoundHelper.addMusic(MOD_ID, "moon1.wav");
        SoundHelper.addMusic(MOD_ID, "moon2.wav");
        SoundHelper.addMusic(MOD_ID, "moon3.wav");
        SoundHelper.addMusic(MOD_ID, "moon4.wav");

        if (spawnEggsModPresent){
            SpawnEggsModule.onInitialize();;
        }
        LOGGER.info("CosmicCraft loaded successfully!");
    }
}
