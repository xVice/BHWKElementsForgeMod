package de.griefer220.jupemod.datagen.loot;

import de.griefer220.jupemod.init.ModBlocks;
import de.griefer220.jupemod.init.ModItems;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
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
        this.dropSelf(ModBlocks.jupe_grinder.get());
        this.dropSelf(ModBlocks.leon_generator.get());


        this.add(ModBlocks.juber_ore.get(),
                block -> creatOreDrops(ModBlocks.juber_ore.get(), ModItems.juber_raw.get(), UniformGenerator.between(2.0F, 5.0F)));

        this.add(ModBlocks.bool_ore.get(),
                block -> creatOreDrops(ModBlocks.bool_ore.get(), ModItems.bool_ingot.get(), UniformGenerator.between(2.0F, 5.0F)));

        this.add(ModBlocks.jupe_ore.get(),
                block -> creatOreDrops(ModBlocks.jupe_ore.get(), ModItems.raw_jupe.get(), UniformGenerator.between(2.0F, 5.0F)));
    }

    //added alle blocks in ModBlocks automatisch, obendrüber der kack "overwrited" denn gegebenen block.
    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }


    //Man kann davon auch mehr machen, erklärung unter der method
    protected LootTable.Builder creatOreDrops(Block block, Item drop, NumberProvider countProvider) {
        return createSilkTouchDispatchTable(block,
                this.applyExplosionDecay(block,
                        LootItem.lootTableItem(drop)
                                .apply(SetItemCountFunction
                                        .setCount(countProvider))
                                .apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE))));
    }

    //basically irgendeine methode aus:BlockLootSubProvider
    //hier in die klasse kopieren und namen ändern dann in denn args von der methode sachen angeben die
    // "passieren" sollen wie bei createOreDrops der NumberProvider
    //methode um schnell in die klasse zum raus kopieren zu kommen:
    private static void SexSklave(Block block){
        createBeeHiveDrop(block); // rechtsklick -> goto -> implementations, da sind dann ganz viele methoden wie createOreDrops
    }


}
