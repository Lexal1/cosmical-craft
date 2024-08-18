package lexal.cosmic.block;

import lexal.cosmic.CosmicCraft;
import lexal.cosmic.UtilIdRegistrar;
import lexal.cosmic.item.ItemGasLayer;
import net.minecraft.client.render.block.model.BlockModelTorch;
import net.minecraft.client.render.block.model.BlockModelCake;
import net.minecraft.core.sound.BlockSound;
import net.minecraft.core.sound.BlockSounds;
import net.minecraft.core.block.*;
import net.minecraft.core.block.material.Material;
import net.minecraft.core.block.tag.BlockTags;
import net.minecraft.core.item.Item;
import net.minecraft.core.item.block.ItemBlockLayer;
import net.minecraft.core.util.helper.Axis;
import net.minecraft.core.util.helper.Side;
import net.minecraft.core.util.helper.Sides;
import net.minecraft.core.world.World;
import turniplabs.halplibe.helper.BlockBuilder;

public class ModBlocks {

    public static final Block ironplating = new BlockBuilder(CosmicCraft.MOD_ID)
            .setHardness(3.0f)
            .setResistance(2.5f)
            .setTextures("cosmic:block/iron_plating")
            .setTags(BlockTags.MINEABLE_BY_PICKAXE)
            .build(new Block("ironplating", UtilIdRegistrar.nextIdBlock(), Material.metal));
    public static final Block goldplating = new BlockBuilder(CosmicCraft.MOD_ID)
            .setHardness(2.0f)
            .setResistance(1.5f)
            .setTextures("cosmic:block/gold_plating")
            .setTags(BlockTags.MINEABLE_BY_PICKAXE)
            .build(new Block("goldplating", UtilIdRegistrar.nextIdBlock(),Material.metal));
    public static final Block moonturf = new BlockBuilder(CosmicCraft.MOD_ID)
            .setBlockSound(BlockSounds.CLOTH)
            .setHardness(1.5f)
            .setResistance(1.5f)
            .setTextures("cosmic:block/moon_turf")
            .setTags(BlockTags.MINEABLE_BY_PICKAXE, BlockTags.CAVES_CUT_THROUGH)
            .build(new Block("moonturf", UtilIdRegistrar.nextIdBlock(),Material.stone));
    public static final Block moonstone = new BlockBuilder(CosmicCraft.MOD_ID)
            .setHardness(2.5f)
            .setResistance(2.5f)
            .setTextures("cosmic:block/moon_stone")
            .setTags(BlockTags.MINEABLE_BY_PICKAXE, BlockTags.CAVES_CUT_THROUGH)
            .build(new BlockMoonstone("moonstone", UtilIdRegistrar.nextIdBlock(),Material.stone));
    public static final Block catwalk = new BlockBuilder(CosmicCraft.MOD_ID)
            .setHardness(1.5f)
            .setResistance(1.5f)
            // TODO: Check this
            .setTextures("minecraft:block/fence_chain_center")
            .setTags(BlockTags.MINEABLE_BY_PICKAXE)
            .build(new BlockCatwalk("catwalk", UtilIdRegistrar.nextIdBlock(),Material.metal));
    public static final Block mooncobblestone = new BlockBuilder(CosmicCraft.MOD_ID)
            .setHardness(3.0f)
            .setResistance(3.0f)
            .setTextures("cosmic:block/moon_cobblestone")
            .setTags(BlockTags.MINEABLE_BY_PICKAXE)
            .build(new BlockMoonstone("mooncobblestone", UtilIdRegistrar.nextIdBlock(),Material.stone));
    public static final Block cheesewheel = new BlockBuilder(CosmicCraft.MOD_ID)
            .setTextures("cosmic:block/cheese_block")
            .setBlockModel(block -> new BlockModelCake(block)
                .withTextures("minecraft:block/cake_top", "minecraft:block/cake_bottom", "cosmic:block/cheese_block")
            )
            .build(new BlockCheeseWheel("cheesewheel", UtilIdRegistrar.nextIdBlock()));

    public static final Block cheeseore = new BlockBuilder(CosmicCraft.MOD_ID)
            .setHardness(2.5f)
            .setResistance(2.5f)
            .setTextures("cosmic:block/cheese_ore")
            .setTags(BlockTags.MINEABLE_BY_PICKAXE, BlockTags.CAVES_CUT_THROUGH)
            .build(new BlockCheeseOre("cheeseore", UtilIdRegistrar.nextIdBlock()));
    public static final Block mooniron = new BlockBuilder(CosmicCraft.MOD_ID)
            .setHardness(2.5f)
            .setResistance(2.5f)
            .setTextures("cosmic:block/moon_stone_iron")
            .setTags(BlockTags.MINEABLE_BY_PICKAXE, BlockTags.CAVES_CUT_THROUGH)
            .build(new BlockOreIron("mooniron", UtilIdRegistrar.nextIdBlock(),Material.stone));
    public static final Block moongold = new BlockBuilder(CosmicCraft.MOD_ID)
            .setHardness(2.5f)
            .setResistance(2.5f)
            .setTextures("cosmic:block/moon_stone_gold")
            .setTags(BlockTags.MINEABLE_BY_PICKAXE, BlockTags.CAVES_CUT_THROUGH)
            .build(new BlockOreGold("moongold", UtilIdRegistrar.nextIdBlock(), Material.stone));
    public static final Block moonsnow = new BlockBuilder(CosmicCraft.MOD_ID)
            .setHardness(0.1f)
            .setResistance(0.0f)
            .setTextures("cosmic:block/moon_turf")
            .setBlockSound(BlockSounds.CLOTH)
            .setTags(BlockTags.MINEABLE_BY_SHOVEL, BlockTags.CAVES_CUT_THROUGH, BlockTags.PLACE_OVERWRITES, BlockTags.BROKEN_BY_FLUIDS, ModBlockTags.GAS_DESTROYS)
            .build(new BlockMoonSnow("moonsnow", UtilIdRegistrar.nextIdBlock(), Material.topSnow));

    public static final Block portalmoon = new BlockBuilder(CosmicCraft.MOD_ID)
            .setHardness(-1.0f)
            .setResistance(-1.0f)
            .setTextures("cosmic:block/moon_cobblestone")
            .setTags(BlockTags.BROKEN_BY_FLUIDS, BlockTags.NOT_IN_CREATIVE_MENU)
            .build(new BlockPortal("portal.moon",UtilIdRegistrar.nextIdBlock(), 4, ironplating.id,moonstone.id));

    public static final Block torchUnlit = new BlockBuilder(CosmicCraft.MOD_ID)
            .setHardness(0)
            .setTags(BlockTags.BROKEN_BY_FLUIDS)
            .setTextures("cosmic:block/torch_unlit")
            .setBlockModel(block -> new BlockModelTorch(block))
            .build(new BlockTorchUnlit("torch.unlit", UtilIdRegistrar.nextIdBlock())).withDisabledNeighborNotifyOnMetadataChange();
    public static final Block glowstoneTorch = new BlockBuilder(CosmicCraft.MOD_ID)
            .setHardness(0)
            .setTextures("cosmic:block/glowstone_torch")
            .setLuminance(8)
            .setTags(BlockTags.BROKEN_BY_FLUIDS, BlockTags.PREVENT_MOB_SPAWNS)
            .setBlockModel(block -> new BlockModelTorch(block))
            .setBlockSound(BlockSounds.WOOD)
            .build(new BlockTorch("torch.glowstone",UtilIdRegistrar.nextIdBlock()));
    public static final Block whitetile = new BlockBuilder(CosmicCraft.MOD_ID)
            .setHardness(2.0f)
            .setResistance(2.0f)
            .setTextures("cosmic:block/white_tile")
            .setTags(BlockTags.MINEABLE_BY_PICKAXE)
            .build(new Block("whitetile",UtilIdRegistrar.nextIdBlock(),Material.cloth));
    public static final Block blacktile = new BlockBuilder(CosmicCraft.MOD_ID)
            .setHardness(2.5f)
            .setResistance(2.5f)
            .setTextures("cosmic:block/black_tile")
            .setTags(BlockTags.MINEABLE_BY_PICKAXE)
            .build(new Block("blacktile",UtilIdRegistrar.nextIdBlock(),Material.metal));
    public static final Block starsteelblock = new BlockBuilder(CosmicCraft.MOD_ID)
            .setHardness(3.0f)
            .setResistance(5.0f)
            .setTopTexture("cosmic:block/starsteelblock_top")
            .setSideTextures("cosmic:block/starsteelblock_side")
            .setBottomTexture("cosmic:block/starsteelblock_bottom")
            .setTags(BlockTags.MINEABLE_BY_PICKAXE)
            .build(new Block("starsteelblock",UtilIdRegistrar.nextIdBlock(),Material.metal));
    public static final Block gasAirFlowing = new BlockBuilder(CosmicCraft.MOD_ID)
            .setHardness(0)
            .setTextures("minecraft:block/glass_tinted")
            .setTags(BlockTags.BROKEN_BY_FLUIDS, BlockTags.PLACE_OVERWRITES, ModBlockTags.IS_GAS)
            .build(new BlockGasFlowing("gas.air.flowing", UtilIdRegistrar.nextIdBlock()));
    public static final Block gasAirStill = new BlockBuilder(CosmicCraft.MOD_ID)
            .setHardness(0)
            .setTextures("minecraft:block/glass")
            .setTags(BlockTags.BROKEN_BY_FLUIDS, BlockTags.PLACE_OVERWRITES, ModBlockTags.IS_GAS)
            .build(new BlockGasStill("gas.air.still", UtilIdRegistrar.nextIdBlock()));
    public static final Block machinePressurizerIdle = new BlockBuilder(CosmicCraft.MOD_ID)
            .setHardness(3.5f)
            .setNorthTexture("cosmic:block/pressurizer_idle")
            .setSouthTexture("cosmic:block/iron_plating")
            .setEastTexture("cosmic:block/iron_plating")
            .setWestTexture("cosmic:block/iron_plating")
            .setTopTexture("cosmic:block/iron_plating")
            .setBottomTexture("cosmic:block/iron_plating")
            .setTags(BlockTags.MINEABLE_BY_PICKAXE)
            .build(new BlockMachinePressurizer("machine.pressurizer.idle", UtilIdRegistrar.nextIdBlock(), false) {});
    public static final Block machinePressurizerActive = new BlockBuilder(CosmicCraft.MOD_ID)
            .setHardness(3.5f)
            .setNorthTexture("cosmic:block/pressurizer_active")
            .setSouthTexture("cosmic:block/iron_plating")
            .setEastTexture("cosmic:block/iron_plating")
            .setWestTexture("cosmic:block/iron_plating")
            .setTopTexture("cosmic:block/iron_plating")
            .setBottomTexture("cosmic:block/iron_plating")
            .setTags(BlockTags.MINEABLE_BY_PICKAXE)
            .build(new BlockMachinePressurizer("machine.pressurizer.active", UtilIdRegistrar.nextIdBlock(), true) {});
    public static final Block gasSponge = new BlockBuilder(CosmicCraft.MOD_ID)
            .setHardness(0)
            .setTextures("minecraft:block/sponge")
            .setTags(BlockTags.MINEABLE_BY_SHEARS)
            .build(new BlockGasSponge("sponge.gas", UtilIdRegistrar.nextIdBlock()));
    public static final Block meteorblock = new BlockBuilder(CosmicCraft.MOD_ID)
            .setHardness(3.0f)
            .setResistance(3.0f)
            .setTextures("cosmic:block/meteorrock")
            .setTags(BlockTags.MINEABLE_BY_PICKAXE)
            .build(new Block("meteorrock", UtilIdRegistrar.nextIdBlock(),Material.stone));
    public static final Block meteorore = new BlockBuilder(CosmicCraft.MOD_ID)
            .setHardness(3.0f)
            .setResistance(3.0f)
            .setTextures("cosmic:block/meteor_ore")
            .setTags(BlockTags.MINEABLE_BY_PICKAXE)
            .build(new BlockMeteorOre("meteorore", UtilIdRegistrar.nextIdBlock(),Material.stone));


    static {
        ((BlockLayerBase)moonsnow).setFullBlockID(() -> moonturf.id);
        Item.itemsList[moonsnow.id] = new ItemBlockLayer(moonsnow);
        Item.itemsList[gasAirStill.id] = new ItemGasLayer(gasAirStill);
        Item.itemsList[gasAirFlowing.id] = new ItemGasLayer(gasAirFlowing);
    }

    public static void register() {}
    static Side[] sides = new Side[]{Side.TOP, Side.BOTTOM, Side.NORTH, Side.EAST, Side.SOUTH, Side.WEST};
    public static boolean doesNeighborBlock(World world, int x, int y, int z, int blockID){
        for (Side side: sides) {
            if (world.getBlockId(x + side.getOffsetX(), y + side.getOffsetY(), z + side.getOffsetZ()) == blockID){
                return true;
            }
        }
        return false;
    }

}
