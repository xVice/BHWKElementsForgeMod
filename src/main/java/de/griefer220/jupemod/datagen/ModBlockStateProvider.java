package de.griefer220.jupemod.datagen;

import de.griefer220.jupemod.BHWK;
import de.griefer220.jupemod.init.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import net.minecraft.world.level.block.Block;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, BHWK.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.bool_block);
        xpBlockWithItem(ModBlocks.bool_ore);

        blockWithItem(ModBlocks.JUPE_BLOCK);
        xpBlockWithItem(ModBlocks.jupe_ore);

        blockWithItem(ModBlocks.juber_block);
        xpBlockWithItem(ModBlocks.juber_ore);

        simpleBlockWithItem(ModBlocks.jupe_grinder.get(),
                new ModelFile.UncheckedModelFile(modLoc("block/jupe_grinder"))
        );

        simpleBlockWithItem(ModBlocks.leon_generator.get(),
                new ModelFile.UncheckedModelFile(modLoc("block/leon_generator"))
        );
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject){
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }

    private void xpBlockWithItem(RegistryObject<DropExperienceBlock> blockRegistryObject){
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}
