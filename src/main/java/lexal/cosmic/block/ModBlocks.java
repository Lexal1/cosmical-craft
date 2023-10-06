package lexal.cosmic.block;

import lexal.cosmic.CosmicCraft;
import lexal.cosmic.UtilIdRegistrar;
import lexal.cosmic.item.ItemGasLayer;
import net.minecraft.client.render.block.model.BlockModelRenderBlocks;
import net.minecraft.client.sound.block.BlockSound;
import net.minecraft.client.sound.block.BlockSounds;
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
            .setTextures("iron_plating.png")
            .setTags(BlockTags.MINEABLE_BY_PICKAXE)
            .build(new Block("ironplating", UtilIdRegistrar.nextIdBlock(), Material.metal));
    public static final Block goldplating = new BlockBuilder(CosmicCraft.MOD_ID)
            .setHardness(2.0f)
            .setResistance(1.5f)
            .setTextures("gold_plating.png")
            .setTags(BlockTags.MINEABLE_BY_PICKAXE)
            .build(new Block("goldplating", UtilIdRegistrar.nextIdBlock(),Material.metal));
    public static final Block moonturf = new BlockBuilder(CosmicCraft.MOD_ID)
            .setBlockSound(BlockSounds.CLOTH)
            .setHardness(1.5f)
            .setResistance(1.5f)
            .setTextures("moon_turf.png")
            .setTags(BlockTags.MINEABLE_BY_PICKAXE, BlockTags.CAVES_CUT_THROUGH)
            .build(new Block("moonturf", UtilIdRegistrar.nextIdBlock(),Material.stone));
    public static final Block moonstone = new BlockBuilder(CosmicCraft.MOD_ID)
            .setHardness(2.5f)
            .setResistance(2.5f)
            .setTextures("moon_stone.png")
            .setTags(BlockTags.MINEABLE_BY_PICKAXE, BlockTags.CAVES_CUT_THROUGH)
            .build(new BlockMoonstone("moonstone", UtilIdRegistrar.nextIdBlock(),Material.stone));
    public static final Block catwalk = new BlockBuilder(CosmicCraft.MOD_ID)
            .setHardness(1.5f)
            .setResistance(1.5f)
            .setTextures(7,19)
            .setTags(BlockTags.MINEABLE_BY_PICKAXE)
            .build(new BlockCatwalk("catwalk", UtilIdRegistrar.nextIdBlock(),Material.metal));
    public static final Block mooncobblestone = new BlockBuilder(CosmicCraft.MOD_ID)
            .setHardness(3.0f)
            .setResistance(3.0f)
            .setTextures("moon_cobblestone.png")
            .setTags(BlockTags.MINEABLE_BY_PICKAXE)
            .build(new BlockMoonstone("mooncobblestone", UtilIdRegistrar.nextIdBlock(),Material.stone));
    public static final Block cheesewheel = new BlockBuilder(CosmicCraft.MOD_ID)
            .setTextures("cheese_block.png")
            .build(new BlockCheeseWheel("cheesewheel", UtilIdRegistrar.nextIdBlock()));

    public static final Block cheeseore = new BlockBuilder(CosmicCraft.MOD_ID)
            .setHardness(2.5f)
            .setResistance(2.5f)
            .setTextures("cheese_ore.png")
            .setTags(BlockTags.MINEABLE_BY_PICKAXE, BlockTags.CAVES_CUT_THROUGH)
            .build(new BlockCheeseOre("cheeseore", UtilIdRegistrar.nextIdBlock()));
    public static final Block mooniron = new BlockBuilder(CosmicCraft.MOD_ID)
            .setHardness(2.5f)
            .setResistance(2.5f)
            .setTextures("moon_stone_iron.png")
            .setTags(BlockTags.MINEABLE_BY_PICKAXE, BlockTags.CAVES_CUT_THROUGH)
            .build(new BlockOreIron("mooniron", UtilIdRegistrar.nextIdBlock(),Material.stone));
    public static final Block moongold = new BlockBuilder(CosmicCraft.MOD_ID)
            .setHardness(2.5f)
            .setResistance(2.5f)
            .setTextures("moon_stone_gold.png")
            .setTags(BlockTags.MINEABLE_BY_PICKAXE, BlockTags.CAVES_CUT_THROUGH)
            .build(new BlockOreGold("moongold", UtilIdRegistrar.nextIdBlock(), Material.stone));
    public static final Block moonsnow = new BlockBuilder(CosmicCraft.MOD_ID)
            .setHardness(0.1f)
            .setResistance(0.0f)
            .setTextures("moon_turf.png")
            .setBlockSound(BlockSounds.CLOTH)
            .setTags(BlockTags.MINEABLE_BY_SHOVEL, BlockTags.CAVES_CUT_THROUGH, BlockTags.PLACE_OVERWRITES, BlockTags.BROKEN_BY_FLUIDS, ModBlockTags.GAS_DESTROYS)
            .build(new BlockMoonSnow("moonsnow", UtilIdRegistrar.nextIdBlock(), Material.topSnow));

    public static final Block portalmoon = new BlockBuilder(CosmicCraft.MOD_ID)
            .setHardness(-1.0f)
            .setResistance(-1.0f)
            .setTextures("moon_cobblestone.png")
            .setTags(BlockTags.BROKEN_BY_FLUIDS, BlockTags.NOT_IN_CREATIVE_MENU)
            .build(new BlockPortal("portal.moon",UtilIdRegistrar.nextIdBlock(),3, ironplating.id,moonstone.id));

    public static final Block torchUnlit = new BlockBuilder(CosmicCraft.MOD_ID)
            .setHardness(0)
            .setTags(BlockTags.BROKEN_BY_FLUIDS)
            .setTextures("torch_unlit.png")
            .setBlockModel(new BlockModelRenderBlocks(2)) // Torch model
            .build(new BlockTorchUnlit("torch.unlit", UtilIdRegistrar.nextIdBlock())).withDisabledNeighborNotifyOnMetadataChange();
    public static final Block glowstoneTorch = new BlockBuilder(CosmicCraft.MOD_ID)
            .setHardness(0)
            .setTextures("glowstone_torch.png")
            .setLuminance(8)
            .setTags(BlockTags.BROKEN_BY_FLUIDS, BlockTags.PREVENT_MOB_SPAWNS)
            .setBlockModel(new BlockModelRenderBlocks(2))
            .setBlockSound(BlockSounds.WOOD)
            .build(new BlockTorch("torch.glowstone",UtilIdRegistrar.nextIdBlock()));
    public static final Block whitetile = new BlockBuilder(CosmicCraft.MOD_ID)
            .setHardness(2.0f)
            .setResistance(2.0f)
            .setTextures("white_tile.png")
            .setTags(BlockTags.MINEABLE_BY_PICKAXE)
            .build(new Block("whitetile",UtilIdRegistrar.nextIdBlock(),Material.cloth));
    public static final Block blacktile = new BlockBuilder(CosmicCraft.MOD_ID)
            .setHardness(2.5f)
            .setResistance(2.5f)
            .setTextures("black_tile.png")
            .setTags(BlockTags.MINEABLE_BY_PICKAXE)
            .build(new Block("blacktile",UtilIdRegistrar.nextIdBlock(),Material.metal));
    public static final Block starsteelblock = new BlockBuilder(CosmicCraft.MOD_ID)
            .setHardness(3.0f)
            .setResistance(5.0f)
            .setTopTexture("starsteelblock_top.png")
            .setSideTextures("starsteelblock_side.png")
            .setBottomTexture("starsteelblock_bottom.png")
            .setTags(BlockTags.MINEABLE_BY_PICKAXE)
            .build(new Block("starsteelblock",UtilIdRegistrar.nextIdBlock(),Material.metal));
    public static final Block gasAirFlowing = new BlockBuilder(CosmicCraft.MOD_ID)
            .setHardness(0)
            .setTextures(6/*-2*/,12/*-1*/)
            .setTags(BlockTags.BROKEN_BY_FLUIDS, BlockTags.PLACE_OVERWRITES, ModBlockTags.IS_GAS)
            .build(new BlockGasFlowing("gas.air.flowing", UtilIdRegistrar.nextIdBlock()));
    public static final Block gasAirStill = new BlockBuilder(CosmicCraft.MOD_ID)
            .setHardness(0)
            .setTextures(1/*+3*/,3/*+8*/)
            .setTags(BlockTags.BROKEN_BY_FLUIDS, BlockTags.PLACE_OVERWRITES, ModBlockTags.IS_GAS)
            .build(new BlockGasStill("gas.air.still", UtilIdRegistrar.nextIdBlock()));
    public static final Block machinePressurizerIdle = new BlockBuilder(CosmicCraft.MOD_ID)
            .setHardness(3.5f)
            .setNorthTexture("pressurizer_idle.png")
            .setSouthTexture("iron_plating.png")
            .setEastTexture("iron_plating.png")
            .setWestTexture("iron_plating.png")
            .setTopTexture("iron_plating.png")
            .setBottomTexture("iron_plating.png")
            .setTags(BlockTags.MINEABLE_BY_PICKAXE)
            .build(new BlockMachinePressurizer("machine.pressurizer.idle", UtilIdRegistrar.nextIdBlock(), false) {});
    public static final Block machinePressurizerActive = new BlockBuilder(CosmicCraft.MOD_ID)
            .setHardness(3.5f)
            .setNorthTexture("pressurizer_active.png")
            .setSouthTexture("iron_plating.png")
            .setEastTexture("iron_plating.png")
            .setWestTexture("iron_plating.png")
            .setTopTexture("iron_plating.png")
            .setBottomTexture("iron_plating.png")
            .setTags(BlockTags.MINEABLE_BY_PICKAXE)
            .build(new BlockMachinePressurizer("machine.pressurizer.active", UtilIdRegistrar.nextIdBlock(), true) {});
    public static final Block gasSponge = new BlockBuilder(CosmicCraft.MOD_ID)
            .setHardness(0)
            .setTextures(0,3)
            .setTags(BlockTags.MINEABLE_BY_SHEARS)
            .build(new BlockGasSponge("sponge.gas", UtilIdRegistrar.nextIdBlock()));
    public static final Block meteorblock = new BlockBuilder(CosmicCraft.MOD_ID)
            .setHardness(3.0f)
            .setResistance(3.0f)
            .setTextures("meteorrock.png")
            .setTags(BlockTags.MINEABLE_BY_PICKAXE)
            .build(new Block("meteorrock", UtilIdRegistrar.nextIdBlock(),Material.stone));
    public static final Block meteorore = new BlockBuilder(CosmicCraft.MOD_ID)
            .setHardness(3.0f)
            .setResistance(3.0f)
            .setTextures("meteor_ore.png")
            .setTags(BlockTags.MINEABLE_BY_PICKAXE)
            .build(new BlockMeteorOre("meteorore", UtilIdRegistrar.nextIdBlock(),Material.stone));


    static {
        ((BlockLayerBase)moonsnow).setFullBlockID(moonturf.id);
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
