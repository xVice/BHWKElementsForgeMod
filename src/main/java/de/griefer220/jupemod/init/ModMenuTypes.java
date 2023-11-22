package de.griefer220.jupemod.init;

import de.griefer220.jupemod.BHWK;
import de.griefer220.jupemod.custom.jupeblocks.bigbench.screen.BigBenchMenu;
import de.griefer220.jupemod.custom.jupeblocks.grinderblock.screen.CustomGrinderMenu;
import de.griefer220.jupemod.custom.jupeblocks.leongenerator.screen.LeonGeneratorMenu;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.network.IContainerFactory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;


public class ModMenuTypes {
    public static final DeferredRegister<MenuType<?>> MENUS =
            DeferredRegister.create(ForgeRegistries.MENU_TYPES, BHWK.MODID);

    public static final RegistryObject<MenuType<CustomGrinderMenu>> JUPE_GRINDER_MENU =
            registerMenuType("jupe_grinder_menu", CustomGrinderMenu::new);

    public static final RegistryObject<MenuType<LeonGeneratorMenu>> LEON_GENERATOR_MENU =
            registerMenuType("leon_generator_menu", LeonGeneratorMenu::new);

    public static final RegistryObject<MenuType<BigBenchMenu>> BIG_BENCH_MENU =
            registerMenuType("big_bench_menu", BigBenchMenu::new);


    private static <T extends AbstractContainerMenu>RegistryObject<MenuType<T>> registerMenuType(String name, IContainerFactory<T> factory) {
        return MENUS.register(name, () -> IForgeMenuType.create(factory));
    }

    public static void register(IEventBus eventBus) {
        MENUS.register(eventBus);
    }
}
