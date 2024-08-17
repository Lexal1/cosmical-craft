package lexal.cosmic.crafting;

import lexal.cosmic.CosmicCraft;
import lexal.cosmic.block.ModBlocks;
import lexal.cosmic.item.ModItems;
import net.minecraft.core.block.Block;
import net.minecraft.core.crafting.legacy.CraftingManager;
import net.minecraft.core.item.Item;
import net.minecraft.core.item.ItemStack;
import turniplabs.halplibe.util.RecipeEntrypoint;
import turniplabs.halplibe.helper.RecipeBuilder;
import turniplabs.halplibe.helper.recipeBuilders.RecipeBuilderShaped;

import static lexal.cosmic.CosmicCraft.MOD_ID;

public class ModCraftingManager implements RecipeEntrypoint {
    public void onRecipesReady() {
    //public static void initializeRecipes() {
        //item recipes

        RecipeBuilder.Shapeless(MOD_ID)
            .addInput(Item.foodPorkchopCooked)
            .addInput(Item.foodBread)
            .addInput(Item.foodBread)
            .addInput(ModItems.cheese)
            .create("cc/borgir", new ItemStack(ModItems.burger));

        RecipeBuilder.Shapeless(MOD_ID)
            .addInput(Item.ingotSteel)
            .addInput(ModItems.crudestarsteel)
            .addInput(ModItems.crudestarsteel)
            .addInput(ModItems.crudestarsteel)
            .addInput(ModItems.crudestarsteel)
            .create("cc/starsteel", new ItemStack(ModItems.starsteel));

        //block recipes

        new RecipeBuilderShaped(MOD_ID, "ICI")
            .addInput('C', Item.chainlink)
            .addInput('I', Item.ingotIron)
            .create("cc/catwalk", new ItemStack(ModBlocks.catwalk, 3));

        new RecipeBuilderShaped(MOD_ID, "CC", "CC")
            .addInput('C', ModItems.cheese)
            .create("cc/cheesewheel", new ItemStack(ModBlocks.cheesewheel, 1));

        new RecipeBuilderShaped(MOD_ID, " I ", "ISI", " I ")
            .addInput('S', Block.stonePolished)
            .addInput('I', Item.ingotIron)
            .create("cc/ironplating", new ItemStack(ModBlocks.ironplating, 4));

        new RecipeBuilderShaped(MOD_ID, "MIM", "ISI", "MIM")
            .addInput('S', Block.stonePolished)
            .addInput('I', Item.ingotIron)
            .addInput('M', ModItems.moondust)
            .create("cc/whitetile", new ItemStack(ModBlocks.whitetile, 8));

        new RecipeBuilderShaped(MOD_ID, " I ", "ISI", " I ")
            .addInput('S', Block.stonePolished)
            .addInput('I', Item.ingotGold)
            .create("cc/goldplating", new ItemStack(ModBlocks.goldplating, 4));

        new RecipeBuilderShaped(MOD_ID, " I ", "ISI", " I ")
            .addInput('S', Block.stonePolished)
            .addInput('I', Item.ingotSteelCrude)
            .create("cc/blacktile", new ItemStack(ModBlocks.blacktile, 4));

        new RecipeBuilderShaped(MOD_ID, "G", "S")
            .addInput('S', Item.stick)
            .addInput('G', Item.dustGlowstone)
            .create("cc/glowstonetorch", new ItemStack(ModBlocks.glowstoneTorch, 3));

        new RecipeBuilderShaped(MOD_ID, "III", "III", "III")
            .addInput('I', ModItems.starsteel)
            .create("cc/starsteel_block", new ItemStack(ModBlocks.starsteelblock, 1));

        //smelting recipes
        RecipeBuilder.BlastFurnace(MOD_ID)
            .setInput(ModItems.rawmeteor)
            .create("cc/crudestarsteel", new ItemStack(ModItems.crudestarsteel));

        RecipeBuilder.Furnace(MOD_ID)
            .setInput(ModBlocks.cheeseore)
            .create("cc/cheese", new ItemStack(ModItems.cheese));
        RecipeBuilder.BlastFurnace(MOD_ID)
            .setInput(ModBlocks.cheeseore)
            .create("cc/cheese", new ItemStack(ModItems.cheese));

        RecipeBuilder.Furnace(MOD_ID)
            .setInput(ModBlocks.mooniron)
            .create("cc/iron", new ItemStack(Item.ingotIron));
        RecipeBuilder.BlastFurnace(MOD_ID)
            .setInput(ModBlocks.mooniron)
            .create("cc/iron", new ItemStack(Item.ingotIron));

        RecipeBuilder.Furnace(MOD_ID)
            .setInput(ModBlocks.moongold)
            .create("cc/gold", new ItemStack(Item.ingotGold));
        RecipeBuilder.BlastFurnace(MOD_ID)
            .setInput(ModBlocks.moongold)
            .create("cc/gold", new ItemStack(Item.ingotGold));

        RecipeBuilder.Furnace(MOD_ID)
            .setInput(ModBlocks.mooncobblestone)
            .create("cc/stone", new ItemStack(ModBlocks.moonstone));
        RecipeBuilder.BlastFurnace(MOD_ID)
            .setInput(ModBlocks.mooncobblestone)
            .create("cc/stone", new ItemStack(ModBlocks.moonstone));

        //armor recipes
        new RecipeBuilderShaped(MOD_ID, "CIC", "WLW", "CGC")
                .addInput('I', Item.armorHelmetIron)
                .addInput('L', Item.armorHelmetLeather)
                .addInput('G', Block.glassTinted)
                .addInput('W', Block.wool)
                .addInput('C', Item.cloth)
                .create("cc/armorHelmetSpace", new ItemStack(ModItems.armorHelmetSpace, 1));
        new RecipeBuilderShaped(MOD_ID, "WIW", "WLW", "CCC")
                .addInput('W', Block.wool)
                .addInput('I', Item.armorChestplateIron)
                .addInput('L', Item.armorChestplateLeather)
                .addInput('C', Item.cloth)
                .create("cc/armorChestplateSpace", new ItemStack(ModItems.armorChestplateSpace, 1));
        new RecipeBuilderShaped(MOD_ID, "WWW", "CIC", "CLC")
                .addInput('I', Item.armorLeggingsIron)
                .addInput('L', Item.armorLeggingsLeather)
                .addInput('W', Block.wool)
                .addInput('C', Item.cloth)
                .create("cc/armorLeggingsSpace", new ItemStack(ModItems.armorLeggingsSpace, 1));
        new RecipeBuilderShaped(MOD_ID, "CIC", "WLW")
                .addInput('I', Item.armorBootsIron)
                .addInput('L', Item.armorBootsLeather)
                .addInput('W', Block.wool)
                .addInput('C', Item.cloth)
                .create("cc/armorBootsSpace", new ItemStack(ModItems.armorBootsSpace, 1));
        new RecipeBuilderShaped(MOD_ID, "B", "S", "S")
                .addInput('B', ModItems.armorBootsSpace)
                .addInput('S', Block.spongeDry)
                .create("cc/armorBootsCrash", new ItemStack(ModItems.armorBootsCrash, 1));

        new RecipeBuilderShaped(MOD_ID, " S ", " S ", " I ")
            .addInput('S', ModItems.starsteel)
            .addInput('I', Item.stick)
            .create("cc/starsword", new ItemStack(ModItems.toolSwordStar));
        new RecipeBuilderShaped(MOD_ID, "SSS", " I ", " I ")
            .addInput('S', ModItems.starsteel)
            .addInput('I', Item.stick)
            .create("cc/starpick", new ItemStack(ModItems.toolPickaxeStar));
        new RecipeBuilderShaped(MOD_ID, "SS ", "SI ", " I ")
            .addInput('S', ModItems.starsteel)
            .addInput('I', Item.stick)
            .create("cc/staraxe", new ItemStack(ModItems.toolAxeStar));
        new RecipeBuilderShaped(MOD_ID, " S ", " I ", " I ")
            .addInput('S', ModItems.starsteel)
            .addInput('I', Item.stick)
            .create("cc/starshovel", new ItemStack(ModItems.toolShovelStar));
        new RecipeBuilderShaped(MOD_ID, "SS ", " I ", " I ")
            .addInput('S', ModItems.starsteel)
            .addInput('I', Item.stick)
            .create("cc/starhoe", new ItemStack(ModItems.toolHoeStar));

        CosmicCraft.LOGGER.info("CosmicCraft loaded all recipes successfully!"); //put recipes before this point
    }

    public void initNamespaces() {
        RecipeBuilder.initNameSpace(MOD_ID);
    }

    /*
    0 = stone
    1 = cobblestone
    2 = planksOak
    3 = grass
    4 = dirt
    5 = mossStone
    6 = logOak
    7 = leavesOak
    8 = oreCoalStone
    9 = oreIronStone
    10 = oreGoldStone
    11 = oreLapisStone
    12 = oreRedstoneOre
    13 = chestPlanksOak
    */
    private static void addAlternatives(int index, Block[] alternatives) {
        Block[] current = CraftingManager.blockAlternatives[index];
        Block[] newAlts = new Block[current.length+alternatives.length];
        System.arraycopy(current, 0, newAlts, 0, current.length);
        System.arraycopy(alternatives, 0, newAlts, current.length, alternatives.length);
        CraftingManager.blockAlternatives[index] = newAlts;
    }

    private static void appendAlternatives(Block[] alternatives) {
        Block[][] current = CraftingManager.blockAlternatives;
        Block[][] newAlts = new Block[current.length+1][];
        System.arraycopy(current, 0, newAlts, 0, current.length);
        newAlts[newAlts.length-1] = alternatives;
        CraftingManager.blockAlternatives = newAlts;
    }
}
