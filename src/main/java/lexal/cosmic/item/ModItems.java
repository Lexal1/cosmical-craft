package lexal.cosmic.item;

import lexal.cosmic.CosmicCraft;
import lexal.cosmic.UtilIdRegistrar;
import lexal.cosmic.block.ModBlocks;
import net.minecraft.core.block.Block;
import net.minecraft.core.item.Item;
import net.minecraft.core.item.ItemArmor;
import net.minecraft.core.item.ItemFood;
import net.minecraft.core.item.material.ArmorMaterial;
import net.minecraft.core.item.material.ToolMaterial;
import net.minecraft.core.item.tool.*;
import turniplabs.halplibe.helper.ArmorHelper;
import turniplabs.halplibe.helper.ItemHelper;

public class ModItems {
    //items
    public static final Item cheese = ItemHelper.createItem(CosmicCraft.MOD_ID, new ItemFood("cheese",UtilIdRegistrar.nextIdItem(),5,false),"cheese","cheese.png");
    public static final Item burger = ItemHelper.createItem(CosmicCraft.MOD_ID, new ItemFood("burger",UtilIdRegistrar.nextIdItem(),20,true),"burger","hamburger.png");
    public static final Item moondust = ItemHelper.createItem(CosmicCraft.MOD_ID, new Item("dust.moon", UtilIdRegistrar.nextIdItem()),"moondust","moondust.png");
    public static final Item starsteel = ItemHelper.createItem(CosmicCraft.MOD_ID, new Item("ingot.star", UtilIdRegistrar.nextIdItem()), "ingot.starsteel", "meteor_ingot.png");
    public static final Item crudestarsteel = ItemHelper.createItem(CosmicCraft.MOD_ID, new Item("crude.star", UtilIdRegistrar.nextIdItem()), "crude.starsteel", "crude_meteor_ingot.png");
    public static final Item rawmeteor = ItemHelper.createItem(CosmicCraft.MOD_ID, new Item("ore.meteor", UtilIdRegistrar.nextIdItem()), "ore.meteor", "raw_meteor_ore.png");

    //armor
    public static final ArmorMaterial armorspacesuit = ArmorHelper.createArmorMaterial("space",256,50.0f,50.0f,50.0f,75.0f);
    public static final Item armorHelmetSpace = ItemHelper.createItem(CosmicCraft.MOD_ID, new ItemArmor("Space Helmet", UtilIdRegistrar.nextIdItem(), armorspacesuit, 0), "armor.helmet.space", "space_helmet.png").withTags(ModItemTags.breathable);
    public static final Item armorChestplateSpace = ItemHelper.createItem(CosmicCraft.MOD_ID, new ItemArmor("Space Suit", UtilIdRegistrar.nextIdItem(), armorspacesuit, 1), "armor.chestplate.space", "space_suit.png").withTags(ModItemTags.breathable);
    public static final Item armorLeggingsSpace = ItemHelper.createItem(CosmicCraft.MOD_ID, new ItemArmor("Space Leggings", UtilIdRegistrar.nextIdItem(), armorspacesuit, 2), "armor.leggings.space", "space_pants.png").withTags(ModItemTags.breathable);
    public static final Item armorBootsSpace = ItemHelper.createItem(CosmicCraft.MOD_ID, new ItemArmor("Space Boots", UtilIdRegistrar.nextIdItem(), armorspacesuit, 3), "armor.boots.space", "space_boots.png").withTags(ModItemTags.breathable);


    public static final ArmorMaterial crashlandingsuit = ArmorHelper.createArmorMaterial("space",8,0.0f,0.0f,0.0f,500.0f);
    public static final Item armorBootsCrash = ItemHelper.createItem(CosmicCraft.MOD_ID, new ItemArmor("Crash Boots", UtilIdRegistrar.nextIdItem(), crashlandingsuit, 3), "armor.boots.crash", "crash_landing_boots.png").withTags(ModItemTags.breathable);
    public static final Item bucketAir = ItemHelper.createItem(CosmicCraft.MOD_ID, new ItemBucketGas("Air Bucket", UtilIdRegistrar.nextIdItem(), ModBlocks.gasAirFlowing.id, 255), "bucket.air").setIconCoord(10,4);

    //tools
    public static final ToolMaterial starsteeltool = new ToolMaterial().setDurability(5068).setEfficiency(10f, 20f).setMiningLevel(3).setBlockHitDelay(5).setDamage(5);
    public static final Item toolSwordStar = ItemHelper.createItem(CosmicCraft.MOD_ID,new ItemToolSword("starsteelsword",UtilIdRegistrar.nextIdItem(), starsteeltool),"tool.sword.star","meteor_sword.png");
    public static final Item toolPickaxeStar = ItemHelper.createItem(CosmicCraft.MOD_ID,new ItemToolPickaxe("starsteelpick",UtilIdRegistrar.nextIdItem(), starsteeltool),"tool.pickaxe.star","meteor_pickaxe.png");
    public static final Item toolAxeStar = ItemHelper.createItem(CosmicCraft.MOD_ID,new ItemToolAxe("starsteelaxe",UtilIdRegistrar.nextIdItem(), starsteeltool),"tool.axe.star","meteor_axe.png");
    public static final Item toolShovelStar = ItemHelper.createItem(CosmicCraft.MOD_ID,new ItemToolShovel("starsteelshovel",UtilIdRegistrar.nextIdItem(), starsteeltool),"tool.shovel.star","meteor_shovel.png");
    public static final Item toolHoeStar = ItemHelper.createItem(CosmicCraft.MOD_ID,new ItemToolHoe("starsteelhoe",UtilIdRegistrar.nextIdItem(), starsteeltool),"tool.hoe.star","meteor_hoe.png");






    //spawn eggs
    public static Item spaceZombieSpawnEgg = ItemHelper.createItem(CosmicCraft.MOD_ID, new Item("spawn.egg.spacezombie", UtilIdRegistrar.nextIdSpawnEggItem()), "spawn.egg.spacezombie", "unknown.png");
    public static Item spaceSkeletonSpawnEgg = ItemHelper.createItem(CosmicCraft.MOD_ID, new Item("spawn.egg.spaceskeleton", UtilIdRegistrar.nextIdSpawnEggItem()), "spawn.egg.spaceskeleton", "unknown.png");
    public static void register() {
        Block.glass.asItem().withTags(ModItemTags.breathable);
        Block.glassTinted.asItem().withTags(ModItemTags.breathable);
    }
}
