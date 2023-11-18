package de.griefer220.jupemod.datagen.loot;

import de.griefer220.jupemod.item.ModBlocks;
import de.griefer220.jupemod.item.ModItems;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.NumberProvider;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        this.dropSelf(ModBlocks.JUPE_BLOCK.get());
        this.dropSelf(ModBlocks.juber_block.get());
        this.dropSelf(ModBlocks.bool_block.get());

        this.add(ModBlocks.juber_ore.get(),
                block -> creatOreDrops(ModBlocks.juber_ore.get(), ModItems.juber_raw.get(), UniformGenerator.between(2.0F, 5.0F)));

        this.add(ModBlocks.bool_ore.get(),
                block -> creatOreDrops(ModBlocks.bool_ore.get(), ModItems.bool_ore.get(), UniformGenerator.between(2.0F, 5.0F)));

        this.add(ModBlocks.jupe_ore.get(),
                block -> creatOreDrops(ModBlocks.jupe_ore.get(), ModItems.raw_jupe.get(), UniformGenerator.between(2.0F, 5.0F)));
    }

    protected LootTable.Builder creatOreDrops(Block block, Item drop, NumberProvider countProvider) {
        return createSilkTouchDispatchTable(block,
                this.applyExplosionDecay(block,
                        LootItem.lootTableItem(drop)
                                .apply(SetItemCountFunction
                                        .setCount(countProvider))
                                .apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE))));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
