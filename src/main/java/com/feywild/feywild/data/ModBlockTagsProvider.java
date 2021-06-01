package com.feywild.feywild.data;

import com.feywild.feywild.FeywildMod;
import net.minecraft.data.BlockTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;

import javax.annotation.Nullable;

public class ModBlockTagsProvider extends BlockTagsProvider {

    public ModBlockTagsProvider(DataGenerator p_i48256_1_, @Nullable ExistingFileHelper existingFileHelper) {
        super(p_i48256_1_, FeywildMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags() {

        super.addTags();
    }
}
