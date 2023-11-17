package de.griefer220.jupemod.item;

import de.griefer220.jupemod.Main;
import net.minecraft.ChatFormatting;
import net.minecraft.client.renderer.EffectInstance;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static de.griefer220.jupemod.CreativeTabInit.addToTab;

public class ModIteminit {
    public static final DeferredRegister<Item> Items = DeferredRegister.create(ForgeRegistries.ITEMS, Main.MODID);



    public static final RegistryObject<Item> jupe_ingot = addToTab(Items.register("jupe_ingot",
            () -> new Item( new Item.Properties()
                    .stacksTo(69)
                    .rarity(Rarity.create("weed", ChatFormatting.DARK_GREEN)))));

    public static final RegistryObject<Item> csharp = addToTab(Items.register("csharp",
            () -> new Item( new Item.Properties()
                    .stacksTo(64)
                    .rarity(Rarity.create("C#", ChatFormatting.LIGHT_PURPLE)))));



    public static final RegistryObject<BlockItem> jupe_ore = addToTab(Items.register("jupe_ore",
            () -> new BlockItem(ModBlocks.jupe_ore.get(),
                  new Item.Properties())));

    public static final RegistryObject<BlockItem> jupe_block = addToTab(Items.register("jupe_block",
            () -> new BlockItem(ModBlocks.JUPE_BLOCK.get(),
                    new Item.Properties())));

    public static final RegistryObject<Item> raw_jupe = addToTab(Items.register("raw_jupe",
            () -> new Item( new Item.Properties()
                    .stacksTo(64)
                    .rarity(Rarity.create("raw_jupe", ChatFormatting.DARK_GREEN)))));

    public static final RegistryObject<Item> oarschi_platte = addToTab(Items.register("oarschi_platte",
            () -> new Item( new Item.Properties()
                    .stacksTo(64)
                    .rarity(Rarity.create("oarschi_platte", ChatFormatting.DARK_RED)))));

    public static final RegistryObject<Item> gelencser_ingot = addToTab(Items.register("gelencser_ingot",
            () -> new Item( new Item.Properties()
                    .stacksTo(64)
                    .rarity(Rarity.create("gelencser_ingot", ChatFormatting.LIGHT_PURPLE)))));


    public static final RegistryObject<Item> bool_ingot = addToTab(Items.register("bool_ingot",
            () -> new Item( new Item.Properties()
                    .stacksTo(64)
                    .rarity(Rarity.create("bool.ingot", ChatFormatting.BLACK)))));

    //Jubers sachen
    public static final RegistryObject<Item> juber_ingot = addToTab(Items.register("juber_ingot",
            () -> new Item(new Item.Properties()
                    .stacksTo(64)
                    .rarity(Rarity.create("Weed energy", ChatFormatting.GREEN)))));

    public static final RegistryObject<SwordItem> juber_sword = addToTab(Items.register("juber_sword",
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
                            .rarity(Rarity.create("Weed energy", ChatFormatting.GREEN)))));
//jubers sachen end





    public static void register(IEventBus eventBus){
        Items.register(eventBus);
     }
}
