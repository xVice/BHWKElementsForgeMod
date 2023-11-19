package de.griefer220.jupemod.datagen;

import de.griefer220.jupemod.BHWK;
import de.griefer220.jupemod.init.ModBlocks;
import de.griefer220.jupemod.utils.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider {

    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, BHWK.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider p_256380_) {
        this.tag(ModTags.Blocks.METAL_DETECTOR_VALUABLES)
                .add(ModBlocks.juber_ore.get()).addTag(Tags.Blocks.ORES);

        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.juber_ore.get(),
                     ModBlocks.jupe_ore.get(),
                     ModBlocks.bool_ore.get(),
                     ModBlocks.bool_block.get(),
                     ModBlocks.juber_block.get(),
                     ModBlocks.jupe_ore.get()
                );

        this.tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.jupe_ore.get()).addTag(Tags.Blocks.ORES);

        this.tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.juber_ore.get(),
                     ModBlocks.bool_ore.get())
                .addTag(Tags.Blocks.ORES);


    }
}
