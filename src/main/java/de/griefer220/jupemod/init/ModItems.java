package de.griefer220.jupemod.init;

import de.griefer220.jupemod.BHWK;
import de.griefer220.jupemod.custom.jupeblocks.grinderblock.CustomGrinderBaseBlock;
import net.minecraft.ChatFormatting;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> Items = DeferredRegister.create(ForgeRegistries.ITEMS, BHWK.MODID);



    public static final RegistryObject<Item> jupe_ingot = Items.register("jupe_ingot",
            () -> new Item( new Item.Properties()
                    .stacksTo(69)
                    .rarity(Rarity.create("weed", ChatFormatting.DARK_GREEN))));


    public static final RegistryObject<Item> csharp = Items.register("csharp",
            () -> new Item( new Item.Properties()
                    .stacksTo(64)
                    .rarity(Rarity.create("C#", ChatFormatting.LIGHT_PURPLE))));






    public static final RegistryObject<Item> raw_jupe = Items.register("raw_jupe",
            () -> new Item( new Item.Properties()
                    .stacksTo(64)
                    .rarity(Rarity.create("raw_jupe", ChatFormatting.DARK_GREEN))));

    public static final RegistryObject<Item> oarschi_platte = Items.register("oarschi_platte",
            () -> new Item( new Item.Properties()
                    .stacksTo(64)
                    .rarity(Rarity.create("oarschi_platte", ChatFormatting.DARK_RED))));

    public static final RegistryObject<Item> gelencser_ingot = Items.register("gelencser_ingot",
            () -> new Item( new Item.Properties()
                    .stacksTo(64)
                    .rarity(Rarity.create("gelencser_ingot", ChatFormatting.LIGHT_PURPLE))));


    public static final RegistryObject<Item> bool_ingot = Items.register("bool_ingot",
            () -> new Item( new Item.Properties()
                    .stacksTo(64)
                    .rarity(Rarity.create("bool.ingot", ChatFormatting.BLACK))));

    //Jubers sachen
    public static final RegistryObject<Item> juber_ingot = Items.register("juber_ingot",
            () -> new Item(new Item.Properties()
                    .stacksTo(64)
                    .rarity(Rarity.create("Weed energy", ChatFormatting.GREEN))));

    public static final RegistryObject<Item> juber_raw = Items.register("juber_raw",
            () -> new Item(new Item.Properties()
                    .stacksTo(64)
                    .rarity(Rarity.create("Weed energy", ChatFormatting.GREEN))));
    public static final RegistryObject<Item> juber_nugget = Items.register("juber_nugget",
            () -> new Item(new Item.Properties()
                    .stacksTo(64)
                    .rarity(Rarity.create("Weed energy", ChatFormatting.GREEN))));







    public static final RegistryObject<Item> juber_pickaxe = Items.register("juber_pickaxe",
            () -> new PickaxeItem(Tiers.NETHERITE, 1, 1,new Item.Properties()
                    .stacksTo(1)
                    .food(new FoodProperties.Builder()
                            .nutrition(10) // Amount of hunger restored
                            .saturationMod(5f) // Saturation value
                            .alwaysEat() // Item can be eaten even if the player isn't hungry
                            .build())
                    .durability(69420)
                    .rarity(Rarity.create("Weed energy", ChatFormatting.GREEN))));

    public static final RegistryObject<Item> juber_shovel = Items.register("juber_shovel",
            () -> new ShovelItem(Tiers.NETHERITE, 1, 1,new Item.Properties()
                    .stacksTo(1)
                    .food(new FoodProperties.Builder()
                            .nutrition(10) // Amount of hunger restored
                            .saturationMod(5f) // Saturation value
                            .alwaysEat() // Item can be eaten even if the player isn't hungry
                            .build())
                    .durability(69420)
                    .rarity(Rarity.create("Weed energy", ChatFormatting.GREEN))));

    public static final RegistryObject<Item> juber_axe = Items.register("juber_axe",
            () -> new AxeItem(Tiers.NETHERITE, 1, 1,new Item.Properties()
                    .stacksTo(1)
                    .food(new FoodProperties.Builder()
                            .nutrition(10) // Amount of hunger restored
                            .saturationMod(5f) // Saturation value
                            .alwaysEat() // Item can be eaten even if the player isn't hungry
                            .build())
                    .durability(69420)
                    .rarity(Rarity.create("Weed energy", ChatFormatting.GREEN))));

    public static final RegistryObject<Item> juber_hoe = Items.register("juber_hoe",
            () -> new HoeItem(Tiers.NETHERITE, 1 , 1f,new Item.Properties()
                    .stacksTo(1)
                    .food(new FoodProperties.Builder()
                            .nutrition(10) // Amount of hunger restored
                            .saturationMod(5f) // Saturation value
                            .alwaysEat() // Item can be eaten even if the player isn't hungry
                            .build())
                    .durability(69420)
                    .rarity(Rarity.create("Weed energy", ChatFormatting.GREEN))));

    public static final RegistryObject<SwordItem> juber_sword = Items.register("juber_sword",
            () -> new SwordItem(Tiers.NETHERITE, // Replace YOUR_TIER with the appropriate item tier
                    20, 100, // Replace these values with the appropriate attack damage and attack speed
                    new Item.Properties()
                            .stacksTo(1)
                            .food(new FoodProperties.Builder()
                                    .nutrition(10) // Amount of hunger restored
                                    .saturationMod(5f) // Saturation value
                                    .alwaysEat() // Item can be eaten even if the player isn't hungry
                                    .build())
                            .durability(69420)
                            .rarity(Rarity.create("Weed energy", ChatFormatting.GREEN))));
//jubers sachen end




    public static void register(IEventBus eventBus){
        Items.register(eventBus);
     }
}
