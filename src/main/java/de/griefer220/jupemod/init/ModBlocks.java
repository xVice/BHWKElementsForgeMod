package de.griefer220.jupemod.init;

import de.griefer220.jupemod.BHWK;
import de.griefer220.jupemod.custom.jupeblocks.grinderblock.CustomGrinderBaseBlock;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

import static de.griefer220.jupemod.CreativeTabInit.addToTab;


public class ModBlocks {
    //Gott weiß
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, BHWK.MODID);


    //Juber
    public static final RegistryObject<DropExperienceBlock> juber_ore = registerBlock("juber_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.DIAMOND_ORE),
                    UniformInt.of(4,7)));

    public static final RegistryObject<Block> juber_block = registerBlock("juber_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.NETHERITE_BLOCK)));





    //Jupe
    public static final RegistryObject<Block> JUPE_BLOCK = registerBlock("jupe_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.DIAMOND_BLOCK)));

    public static final RegistryObject<DropExperienceBlock> jupe_ore = registerBlock("jupe_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.DIAMOND_ORE),
                    UniformInt.of(4,7)));

    public static final RegistryObject<Block> JUPE_GRINDER = registerBlock("jupe_grinder",
            () -> new CustomGrinderBaseBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.ANVIL).noCollission()));


    //bool
    public static final RegistryObject<DropExperienceBlock> bool_ore = registerBlock("bool_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.DIAMOND_ORE),
                    UniformInt.of(6,9)));

    public static final RegistryObject<Block> bool_block = registerBlock("bool_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.EMERALD_BLOCK)));


    //keiner weiß
    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return addToTab(ModItems.Items.register(name, () -> new BlockItem(block.get(), new Item.Properties())));
    }

    //eventbus diggi
    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);


    }
}
