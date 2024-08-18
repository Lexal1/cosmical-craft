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
import net.minecraft.core.data.tag.Tag;
import turniplabs.halplibe.helper.ArmorHelper;
import turniplabs.halplibe.helper.ItemBuilder;

public class ModItems {
    //items
    public static final Item cheese = new ItemBuilder(CosmicCraft.MOD_ID)
        .setIcon("cosmic:item/cheese")
        .build(new ItemFood("cheese", UtilIdRegistrar.nextIdItem(), 5, 10, false, 8));
    public static final Item burger = new ItemBuilder(CosmicCraft.MOD_ID)
        .setIcon("cosmic:item/hamburger")
        .build(new ItemFood("burger", UtilIdRegistrar.nextIdItem(), 20, 6, true, 8));
    public static final Item moondust = new ItemBuilder(CosmicCraft.MOD_ID)
        .setIcon("cosmic:item/moondust")
        .build(new Item("dust.moon", UtilIdRegistrar.nextIdItem()));
    public static final Item starsteel = new ItemBuilder(CosmicCraft.MOD_ID)
        .setIcon("cosmic:item/meteor_ingot")
        .build(new Item("ingot.starsteel", UtilIdRegistrar.nextIdItem()));
    public static final Item crudestarsteel = new ItemBuilder(CosmicCraft.MOD_ID)
        .setIcon("cosmic:item/crude_meteor_ingot")
        .build(new Item("crude.starsteel", UtilIdRegistrar.nextIdItem()));
    public static final Item rawmeteor = new ItemBuilder(CosmicCraft.MOD_ID)
        .setIcon("cosmic:item/raw_meteor_ore")
        .build(new Item("ore.meteor", UtilIdRegistrar.nextIdItem()));

    //armor
    public static final ArmorMaterial armorspacesuit = ArmorHelper.createArmorMaterial(CosmicCraft.MOD_ID, "space", 256, 50.0f, 50.0f, 50.0f, 75.0f);
    public static final Item armorHelmetSpace = new ItemBuilder(CosmicCraft.MOD_ID)
        .setIcon("cosmic:item/space_helmet")
        .build(new ItemArmor("armor.helmet.space", UtilIdRegistrar.nextIdItem(), armorspacesuit, 0))
        .withTags(ModItemTags.breathable);
    public static final Item armorChestplateSpace = new ItemBuilder(CosmicCraft.MOD_ID)
        .setIcon("cosmic:item/space_suit")
        .build(new ItemArmor("armor.chestplate.space", UtilIdRegistrar.nextIdItem(), armorspacesuit, 1))
        .withTags(ModItemTags.breathable);
    public static final Item armorLeggingsSpace = new ItemBuilder(CosmicCraft.MOD_ID)
        .setIcon("cosmic:item/space_pants")
        .build(new ItemArmor("armor.leggings.space", UtilIdRegistrar.nextIdItem(), armorspacesuit, 2))
        .withTags(ModItemTags.breathable);
    public static final Item armorBootsSpace = new ItemBuilder(CosmicCraft.MOD_ID)
        .setIcon("cosmic:item/space_boots")
        .build(new ItemArmor("armor.boots.space", UtilIdRegistrar.nextIdItem(), armorspacesuit, 3))
        .withTags(ModItemTags.breathable);


    public static final ArmorMaterial crashlandingsuit = ArmorHelper.createArmorMaterial(CosmicCraft.MOD_ID, "space", 8, 0.0f, 0.0f, 0.0f, 500.0f);
    public static final Item armorBootsCrash = new ItemBuilder(CosmicCraft.MOD_ID)
        .setIcon("cosmic:item/crash_landing_boots")
        .build(new ItemArmor("armor.boots.crash", UtilIdRegistrar.nextIdItem(), crashlandingsuit, 3))
        .withTags((Tag<Item>[])new Tag[] {ModItemTags.breathable});
    public static final Item bucketAir = new ItemBuilder(CosmicCraft.MOD_ID)
        .setIcon("cosmic:item/air_bucket")
        .build(new ItemBucketGas("airbucket", UtilIdRegistrar.nextIdItem(), ModBlocks.gasAirFlowing.id, 255));

    //tools
    public static final ToolMaterial starsteeltool = new ToolMaterial()
        .setDurability(5068)
        .setEfficiency(10f, 20f)
        .setMiningLevel(4)
        .setBlockHitDelay(3)
        .setDamage(6);
    public static final Item toolSwordStar = new ItemBuilder(CosmicCraft.MOD_ID)
        .setIcon("cosmic:item/meteor_sword")
        .build(new ItemToolSword("tool.sword.star", UtilIdRegistrar.nextIdItem(), starsteeltool));
    public static final Item toolPickaxeStar = new ItemBuilder(CosmicCraft.MOD_ID)
        .setIcon("cosmic:item/meteor_pickaxe")
        .build(new ItemToolPickaxe("tool.pickaxe.star", UtilIdRegistrar.nextIdItem(), starsteeltool));
    public static final Item toolAxeStar = new ItemBuilder(CosmicCraft.MOD_ID)
        .setIcon("cosmic:item/meteor_axe")
        .build(new ItemToolAxe("tool.axe.star", UtilIdRegistrar.nextIdItem(), starsteeltool));
    public static final Item toolShovelStar = new ItemBuilder(CosmicCraft.MOD_ID)
        .setIcon("cosmic:item/meteor_shovel")
        .build(new ItemToolShovel("tool.shovel.star", UtilIdRegistrar.nextIdItem(), starsteeltool));
    public static final Item toolHoeStar = new ItemBuilder(CosmicCraft.MOD_ID)
        .setIcon("cosmic:item/meteor_hoe")
        .build(new ItemToolHoe("tool.hoe.star", UtilIdRegistrar.nextIdItem(), starsteeltool));

    //spawn eggs
    //public static Item spaceZombieSpawnEgg = new ItemBuilder(CosmicCraft.MOD_ID)//.setIcon("spawn.egg.spacezombie", "unknown.png").build(new Item("spawn.egg.spacezombie", UtilIdRegistrar.nextIdSpawnEggItem()));
    //public static Item spaceSkeletonSpawnEgg = new ItemBuilder(CosmicCraft.MOD_ID)//.setIcon("spawn.egg.spaceskeleton", "unknown.png").build(new Item("spawn.egg.spaceskeleton", UtilIdRegistrar.nextIdSpawnEggItem()));

    public static void register() {
    }
}
