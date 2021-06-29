package com.feywild.feywild.item;

import com.feywild.feywild.FeywildMod;
import com.feywild.feywild.world.dimension.MarketPlaceTeleporter;
import com.feywild.feywild.world.dimension.ModDimensions;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUseContext;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

public class TeleportationScroll extends Item {

    public TeleportationScroll() {super(new Item.Properties().tab(FeywildMod.FEYWILD_TAB)); }

    @Override
    public ActionResultType useOn(ItemUseContext context) {

        if (!context.getLevel().isClientSide) {

            PlayerEntity player = context.getPlayer();
            World worldIn = context.getLevel();
            MinecraftServer server = worldIn.getServer();
            BlockPos pos = context.getClickedPos();

            if (server != null) {

                ServerWorld overWorld = server.getLevel(World.OVERWORLD);
                ServerWorld marketWorld = server.getLevel(ModDimensions.Market_Place_Dimension);

                if (worldIn.dimension() == ModDimensions.Market_Place_Dimension) {
                    if (overWorld != null) {

                        player.changeDimension(overWorld, new MarketPlaceTeleporter(pos, false));
                    }
                } else {
                    if (marketWorld != null) {
                        player.changeDimension(marketWorld, new MarketPlaceTeleporter(pos, true));

                    }
                }
                return ActionResultType.SUCCESS;
            }
        }

        return super.useOn(context);
    }
}
