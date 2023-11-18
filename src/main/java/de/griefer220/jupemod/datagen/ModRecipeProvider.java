package de.griefer220.jupemod.datagen;

import de.griefer220.jupemod.BHWK;
import de.griefer220.jupemod.item.ModBlocks;
import de.griefer220.jupemod.item.ModItems;
import net.minecraft.data.Main;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.ShapelessRecipe;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import java.util.function.Consumer;

import java.util.List;
import java.util.function.Consumer;
public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public static final List<ItemLike> JUBER_SMELTABLES = List.of(ModItems.juber_raw.get(), ModItems.juber_ore.get());
    public static final List<ItemLike> JUPE_SMELTABLES = List.of(ModItems.jupe_ore.get(), ModItems.raw_jupe.get());
    public static final List<ItemLike> BOOL_SMELTABLES = List.of(ModItems.bool_ore.get());

    public ModRecipeProvider(PackOutput p_248933_) {
        super(p_248933_);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> pWriter) {
        oreSmelting(pWriter, JUBER_SMELTABLES, RecipeCategory.MISC, ModItems.juber_ingot.get(), 0.25f, 200, "juber");
        oreBlasting(pWriter, JUBER_SMELTABLES, RecipeCategory.MISC, ModItems.juber_ingot.get(), 0.25f, 100, "juber");

        oreSmelting(pWriter, JUPE_SMELTABLES, RecipeCategory.MISC, ModItems.jupe_ingot.get(), 0.25f, 100, "jupe");
        oreBlasting(pWriter, JUPE_SMELTABLES, RecipeCategory.MISC, ModItems.jupe_ingot.get(), 0.25f, 50, "jupe");

        oreSmelting(pWriter, BOOL_SMELTABLES, RecipeCategory.MISC, ModItems.csharp.get(), 0.25f, 250, "bool");
        oreBlasting(pWriter, BOOL_SMELTABLES, RecipeCategory.MISC, ModItems.csharp.get(), 0.25f, 150, "bool");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.juber_block.get())
                .pattern("JJJ")
                .pattern("JJJ")
                .pattern("JJJ")
                .define('J', ModItems.juber_ingot.get())
                .unlockedBy(getHasName(ModItems.juber_ingot.get()), has(ModItems.juber_ingot.get()))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.juber_ingot.get(), 9)
                .requires(ModBlocks.juber_block.get())
                .unlockedBy(getHasName(ModBlocks.juber_block.get()), has(ModBlocks.juber_block.get()))
                .save(pWriter);
    }

    protected static void oreSmelting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.SMELTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.BLASTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static void oreCooking(Consumer<FinishedRecipe> pFinishedRecipeConsumer, RecipeSerializer<? extends AbstractCookingRecipe> pCookingSerializer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        for(ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult,
                            pExperience, pCookingTime, pCookingSerializer)
                    .group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(pFinishedRecipeConsumer, BHWK.MODID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }
    }
}
