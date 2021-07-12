package com.feywild.feywild.block;

import com.feywild.feywild.block.entity.MarketMasterEntity;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockReader;

import javax.annotation.Nullable;

public class MarketMaster extends Block {
    public MarketMaster() {
        super(AbstractBlock.Properties.of(Material.BARRIER));
    }

    @Override
    public boolean hasTileEntity(BlockState state) {
        return true;
    }

    @Nullable
    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        return new MarketMasterEntity();
    }
}
