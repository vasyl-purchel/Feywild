package com.feywild.feywild.data;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.RecipeProvider;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {

    public ModRecipeProvider(DataGenerator p_i48262_1_) {
        super(p_i48262_1_);
    }
/*
    @Override
    protected void buildShapelessRecipes(Consumer<IFinishedRecipe> p_200404_0_) {

        ShapedRecipeBuilder.shaped(ModBlocks.SPRING_TREE_WOOD.get())
                .define("#", Ingredient.of(ModBlocks.SPRING_TREE_LOG.get().asItem()))
                .pattern("## ")
                .pattern("## ")
                .pattern("  ")
                .unlockedBy("spring_tree_wood", has(ModBlocks.SPRING_TREE_WOOD.get()))
                .save(p_200404_0_);
    } */
}
