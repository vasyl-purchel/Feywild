package com.feywild.feywild.world.dimension;

import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.fluid.Fluids;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.util.ITeleporter;

public class MarketPlaceTeleporter implements ITeleporter {

    public static BlockPos thisPos = BlockPos.ZERO;
    public static boolean insideDimension = true;

    public MarketPlaceTeleporter(BlockPos pos, boolean insideDimension) {

        this.thisPos = pos;
        this.insideDimension = insideDimension;
    }

    public Entity placeEntity(Entity entity, ServerWorld currentWorld, ServerWorld destinationWorld,
                              float yaw, java.util.function.Function<Boolean, Entity> repositionEntity) {

        entity = repositionEntity.apply(false);

        double y = 64;

        if (!insideDimension) {
            y = thisPos.getY();
        }

        BlockPos destinationPos = new BlockPos(thisPos.getX(), y, thisPos.getZ());
        int tries = 0;
        //Trying to find position that is Air.

        while ((destinationWorld.getBlockState(destinationPos).getMaterial() != Material.AIR) &&
                !destinationWorld.getBlockState(destinationPos).canBeReplaced(Fluids.WATER) &&
                destinationWorld.getBlockState(destinationPos.above()).getMaterial() != Material.AIR &&
                !destinationWorld.getBlockState(destinationPos).canBeReplaced(Fluids.WATER) && tries < 25) {

            destinationPos = destinationPos.above(2);
            tries++;
        }

        entity.teleportTo(destinationPos.getX(), destinationPos.getY(), destinationPos.getZ());

        return entity;
    }

}
