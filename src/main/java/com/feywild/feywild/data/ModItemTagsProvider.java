package com.feywild.feywild.data;

import com.feywild.feywild.FeywildMod;
import net.minecraft.data.BlockTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.ItemTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

import javax.annotation.Nullable;

public class ModItemTagsProvider extends ItemTagsProvider {

    public ModItemTagsProvider(DataGenerator p_i232552_1_, BlockTagsProvider p_i232552_2_, @Nullable ExistingFileHelper existingFileHelper) {
        super(p_i232552_1_, p_i232552_2_, FeywildMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags() {
        super.addTags();
    }
}
