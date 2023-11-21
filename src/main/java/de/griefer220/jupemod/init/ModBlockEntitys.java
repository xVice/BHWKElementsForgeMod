package de.griefer220.jupemod.init;

import de.griefer220.jupemod.BHWK;
import de.griefer220.jupemod.custom.jupeblocks.grinderblock.CustomGrinderBlockEntity;
import de.griefer220.jupemod.custom.jupeblocks.leongenerator.LeonGeneratorBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockEntitys {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, BHWK.MODID);

    public static final RegistryObject<BlockEntityType<CustomGrinderBlockEntity>> JUPE_GRINDER_BE =
            BLOCK_ENTITES.register("jupe_grinder_be", () ->
                    BlockEntityType.Builder.of(CustomGrinderBlockEntity::new,
                            ModBlocks.jupe_grinder.get()).build(null));

    public static final RegistryObject<BlockEntityType<LeonGeneratorBlockEntity>> LEON_GENERATOR_BE =
            BLOCK_ENTITES.register("leon_generator_be", () ->
                    BlockEntityType.Builder.of(LeonGeneratorBlockEntity::new,
                            ModBlocks.leon_generator.get()).build(null));

    public static void register(IEventBus eventBus){
        BLOCK_ENTITES.register(eventBus);
    }
}
