package com.feywild.feywild.item;

import com.feywild.feywild.FeywildMod;
import com.feywild.feywild.entity.DwarfBlacksmithEntity;
import com.feywild.feywild.entity.ModEntityTypes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

// Ancient's note : so I needed a debug stick, this will only be seen in intelij :)

public class TheStick extends Item {
    public TheStick() {
        super(new Item.Properties().tab(FeywildMod.FEYWILD_TAB));
    }

    @Override
    public ActionResult<ItemStack> use(World world, PlayerEntity entity, Hand hand) {
        if(!world.isClientSide){
            DwarfBlacksmithEntity entity1 = new DwarfBlacksmithEntity(ModEntityTypes.DWARF_BLACKSMITH.get(),world,false,1);
            entity1.setPos(entity.getX(),entity.getY(),entity.getZ());
            world.addFreshEntity(entity1);
        }
        return super.use(world, entity, hand);
    }
}
