package com.feywild.feywild.item;

import com.feywild.feywild.FeywildMod;
import com.feywild.feywild.world.dimension.MarketPlaceTeleporter;
import com.feywild.feywild.world.dimension.ModDimensions;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.Tags;

import java.util.concurrent.atomic.AtomicInteger;

public class TeleportationScroll extends Item {

    public TeleportationScroll() {super(new Item.Properties().tab(FeywildMod.FEYWILD_TAB)); }



    @Override
    public ActionResult<ItemStack> use(World world, PlayerEntity entity, Hand hand) {
        if (!world.isClientSide) {

            MinecraftServer server = world.getServer();

            BlockPos pos = entity.blockPosition();

            if (server != null) {

                ServerWorld overWorld = server.getLevel(World.OVERWORLD);
                ServerWorld marketWorld = server.getLevel(ModDimensions.MARKET_PLACE_DIMENSION);

                if (world.dimension() == ModDimensions.MARKET_PLACE_DIMENSION) {
                    if (overWorld != null) {
                        AtomicInteger x = new AtomicInteger(0);
                        AtomicInteger y = new AtomicInteger(0);
                        AtomicInteger z = new AtomicInteger(0);
                        entity.getTags().forEach(tag->{
                            switch ("" +tag.charAt(0)){
                                case "x":
                                    x.set(Integer.parseInt(tag.replaceFirst("x", "")));
                                    break;

                                case "y":
                                    y.set(Integer.parseInt(tag.replaceFirst("y", "")));
                                    break;

                                case "z":
                                    z.set(Integer.parseInt(tag.replaceFirst("z", "")));
                                    break;

                            }
                        });

                        entity.getTags().removeIf(s -> s.startsWith("x") || s.startsWith("y") || s.startsWith("z"));
                        entity.changeDimension(overWorld, new MarketPlaceTeleporter(new BlockPos(x.get(),y.get(),z.get()), false));
                    }
                } else {
                    if (marketWorld != null) {
                        entity.addTag("x" + pos.getX());
                        entity.addTag("y" + pos.getY());
                        entity.addTag("z" + pos.getZ());
                        entity.changeDimension(marketWorld, new MarketPlaceTeleporter(new BlockPos(0,0,0), true));

                        if(!entity.level.getBlockState(entity.blockPosition().above(9).west(2).south(1)).equals(Blocks.GOLD_BLOCK.defaultBlockState()))
                        entity.level.setBlock(entity.blockPosition().below(), Blocks.STONE.defaultBlockState(),2);

                    }
                }
                return ActionResult.success(entity.getItemInHand(hand));
            }
        }

        return super.use(world, entity, hand);
    }
}
