package de.griefer220.jupemod;

import com.mojang.logging.LogUtils;
import de.griefer220.jupemod.custom.jupeblocks.bigbench.screen.BigBenchMenu;
import de.griefer220.jupemod.custom.jupeblocks.bigbench.screen.BigBenchScreen;
import de.griefer220.jupemod.custom.jupeblocks.grinderblock.screen.CustomGrinderScreen;
import de.griefer220.jupemod.custom.jupeblocks.leongenerator.screen.LeonGeneratorScreen;
import de.griefer220.jupemod.init.ModBlockEntitys;
import de.griefer220.jupemod.init.ModItems;
import de.griefer220.jupemod.init.ModBlocks;
import de.griefer220.jupemod.init.ModMenuTypes;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

@Mod(BHWK.MODID)
public class BHWK {

    public static final String MODID = "jupemod";
    private static final Logger LOGGER = LogUtils.getLogger();


    public BHWK() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        modEventBus.addListener(this::commonSetup);

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);
        ModBlockEntitys.register(modEventBus);
        ModMenuTypes.register(modEventBus);

        CreativeTabInit.register(modEventBus);

        MinecraftForge.EVENT_BUS.register(this);
        modEventBus.addListener(this::addCreative);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
    }

    private void addCreative(BuildCreativeModeTabContentsEvent event)
    {
    }
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
    }

    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {

        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            MenuScreens.register(ModMenuTypes.JUPE_GRINDER_MENU.get(), CustomGrinderScreen::new);
            MenuScreens.register(ModMenuTypes.LEON_GENERATOR_MENU.get(), LeonGeneratorScreen::new);
            MenuScreens.register(ModMenuTypes.BIG_BENCH_MENU.get(), BigBenchScreen::new);
        }
    }
}
