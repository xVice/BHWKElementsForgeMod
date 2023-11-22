package de.griefer220.jupemod;

import de.griefer220.jupemod.init.ModBlocks;
import de.griefer220.jupemod.init.ModItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.*;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class CreativeTabInit {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, BHWK.MODID);

    public static final RegistryObject<CreativeModeTab> TUTORIAL_TAB = CREATIVE_MODE_TABS.register("example_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.oarschi_platte.get()))
                    .title(Component.translatable("itemGroup.example_tab"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModBlocks.jupe_grinder.get());
                        pOutput.accept(ModBlocks.JUPE_BLOCK.get());
                        pOutput.accept(ModBlocks.bool_block.get());
                        pOutput.accept(ModBlocks.juber_block.get());
                        pOutput.accept(ModBlocks.bool_ore.get());
                        pOutput.accept(ModBlocks.jupe_ore.get());
                        pOutput.accept(ModItems.bool_ingot.get());
                        pOutput.accept(ModItems.oarschi_platte.get());
                        pOutput.accept(ModItems.juber_ingot.get());
                        pOutput.accept(ModItems.juber_axe.get());
                        pOutput.accept(ModItems.juber_raw.get());
                        pOutput.accept(ModItems.juber_axe.get());
                        pOutput.accept(ModItems.juber_pickaxe.get());
                        pOutput.accept(ModItems.juber_nugget.get());
                        pOutput.accept(ModItems.juber_shovel.get());
                        pOutput.accept(ModItems.juber_sword.get());
                        pOutput.accept(ModItems.juber_hoe.get());
                        pOutput.accept(ModItems.jupe_ingot.get());
                        pOutput.accept(ModBlocks.leon_generator.get());
                        pOutput.accept(ModItems.gelencser_ingot.get());
                        pOutput.accept(ModBlocks.big_bench.get());
                    })
                    .build());


    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}