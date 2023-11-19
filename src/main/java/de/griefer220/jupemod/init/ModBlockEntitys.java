package de.griefer220.jupemod.init;

import de.griefer220.jupemod.BHWK;
import de.griefer220.jupemod.custom.jupeblocks.grinderblock.CustomGrinderBlockEntity;
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
                            ModBlocks.JUPE_GRINDER.get()).build(null));

    public static void register(IEventBus eventBus){
        BLOCK_ENTITES.register(eventBus);
    }
}
