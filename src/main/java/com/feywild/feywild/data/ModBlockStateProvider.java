package com.feywild.feywild.data;

import com.feywild.feywild.FeywildMod;
import com.feywild.feywild.block.ModBlocks;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModBlockStateProvider extends BlockStateProvider {

    public ModBlockStateProvider(DataGenerator gen, ExistingFileHelper exFileHelper) {
        super(gen, FeywildMod.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {

        simpleBlock(ModBlocks.FEY_GEM_BLOCK.get());
        //axisBlock(ModBlocks.SPRING_TREE_LOG.get(), modLoc("block/spring_tree_log_horizontal"));

    }
}
