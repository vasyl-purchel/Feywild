package com.feywild.feywild.block.entity;

import com.feywild.feywild.block.ModBlocks;
import com.feywild.feywild.entity.util.TraderEntity;
import com.feywild.feywild.world.dimension.MarketPlaceTeleporter;
import com.feywild.feywild.world.dimension.ModDimensions;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.GameType;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

import java.util.concurrent.atomic.AtomicInteger;

public class MarketMasterEntity extends TileEntity implements ITickableTileEntity {
    boolean init = true;
    AxisAlignedBB box;

    public MarketMasterEntity() {
        super(ModBlocks.MARKET_MASTER_ENTITY.get());
    }
    @Override
    public void tick() {
        if(!level.isClientSide) {
            if(init){
                init = false;
                box = new AxisAlignedBB(getBlockPos()).inflate(60);
            }
            if(level.getServer() == null) return;
            ServerWorld overWorld = level.getServer().getLevel(World.OVERWORLD);
            if(overWorld.getDayTime() == 13000){
                level.setBlock(new BlockPos(0,0,0), Blocks.AIR.defaultBlockState(),2);
                level.getEntities(null, box).forEach( entity -> {
                    if(entity instanceof PlayerEntity){
                        entity.sendMessage(new TranslationTextComponent("feywild.market.closed"), entity.getUUID());
                        if (level.dimension() == ModDimensions.MARKET_PLACE_DIMENSION) {
                            AtomicInteger x = new AtomicInteger(0);
                            AtomicInteger y = new AtomicInteger(0);
                            AtomicInteger z = new AtomicInteger(0);
                            entity.getTags().forEach(tag -> {
                                switch ("" + tag.charAt(0)) {
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

                            ((PlayerEntity)entity).setGameMode(GameType.SURVIVAL);

                            entity.getTags().removeIf(s -> s.startsWith("x") || s.startsWith("y") || s.startsWith("z"));
                            entity.changeDimension(overWorld, new MarketPlaceTeleporter(new BlockPos(x.get(), y.get(), z.get()), false));
                        }
                    }else{
                        entity.remove();
                    }
                });
            }
        }
    }
}
