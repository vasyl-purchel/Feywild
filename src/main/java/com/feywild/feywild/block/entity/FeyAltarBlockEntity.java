package com.feywild.feywild.block.entity;

import com.feywild.feywild.FeywildMod;
import com.feywild.feywild.block.ModBlocks;
import com.feywild.feywild.events.ModRecipes;
import com.feywild.feywild.network.FeywildPacketHandler;
import com.feywild.feywild.network.ItemMessage;
import com.feywild.feywild.network.ParticleMessage;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.NonNullList;
import net.minecraftforge.fml.network.PacketDistributor;

import java.util.*;

public class FeyAltarBlockEntity extends InventoryTile implements ITickableTileEntity {
    private boolean shouldLoad = true;
    private int count = 0, limit;
    Random random = new Random();
    //Items
    NonNullList<ItemStack> stackList = NonNullList.withSize(5, ItemStack.EMPTY);

    public FeyAltarBlockEntity() {
        super(ModBlocks.FEY_ALTAR_ENTITY.get());
    }


    //Read data on world init
    @Override
    public void read(BlockState state, CompoundNBT nbt) {
        for(int i =0; i < getSizeInventory(); i++){
            stackList.set(i,ItemStack.read((CompoundNBT) nbt.get("stacks")));
        }
        super.read(state, nbt);
    }

    //Save data on world close
    @Override
    public CompoundNBT write(CompoundNBT compound) {
        CompoundNBT compoundNBT = new CompoundNBT();
        for (int i = 0; i < getSizeInventory(); i++) {
            stackList.get(i).write(compoundNBT);
        }
        compound.put("stacks",compoundNBT);
        return super.write(compound);
    }

    //gets called every tick
    @Override
    public void tick() {
        if(world.isRemote) return;
        count++;
        if(shouldLoad){
            // initialize limit and loop through all items to sync them with the client
            limit = random.nextInt(20*6);
            updateInventory(-1);
            shouldLoad = true;
        }
        //summon particles randomly (did this here bc for some reason random ticks are killing me today)
        if(count > limit){
            limit = random.nextInt(20*6);
            if(random.nextDouble() > 0.5) {
                // send packet to player to summon particles
                FeywildPacketHandler.sendToPlayersInRange(world, pos, new ParticleMessage(pos.getX()+ random.nextDouble(),pos.getY()+ 0.3+ random.nextDouble(), pos.getZ()+ random.nextDouble(), 0, 0, 0, 1), 32);
            }
            count = 0;
        }
    }

    //order sensitive will require changes
    public void craft(){
        ModRecipes.getAltarRecipes().keySet().forEach(itemStacks -> {
            String recipe = "", string = "";
            StringBuilder builder = new StringBuilder();
            for(ItemStack stack: stackList){
                builder.append(stack.toString());
            }
            string = builder.toString();
            builder = builder.delete(0, builder.length());
            for(ItemStack stack: itemStacks){
                builder.append(stack.toString());
            }
            recipe = builder.toString();
            if(string.equals(recipe)) {
                System.out.println(ModRecipes.getAltarRecipes().get(itemStacks));
                world.addEntity(new ItemEntity(world,pos.getX()+0.5,pos.getY()+1.3,pos.getZ()+0.5,ModRecipes.getAltarRecipes().get(itemStacks)));
                clear();
            }

        });
    }

    @Override
    public int getSizeInventory() {
        return 5;
    }

    @Override
    public List<ItemStack> getItems() {
        return stackList;
    }
}