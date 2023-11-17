package de.griefer220.jupemod.item;

import de.griefer220.jupemod.Main;
import net.minecraft.ChatFormatting;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
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
                    .rarity(Rarity.create("C#", ChatFormatting.DARK_GREEN)))));

    public static final RegistryObject<Item> oarschi_platte = addToTab(Items.register("oarschi_platte",
            () -> new Item( new Item.Properties()
                    .stacksTo(64)
                    .rarity(Rarity.create("oarschi_platte", ChatFormatting.DARK_RED)))));



    public static void register(IEventBus eventBus){
        Items.register(eventBus);
     }
}
