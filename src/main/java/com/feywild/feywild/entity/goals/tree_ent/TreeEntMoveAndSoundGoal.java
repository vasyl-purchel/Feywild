package com.feywild.feywild.entity.goals.tree_ent;

import com.feywild.feywild.entity.base.TreeEntBase;
import com.feywild.feywild.sound.ModSoundEvents;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;

public class TreeEntMoveAndSoundGoal extends WaterAvoidingRandomStrollGoal {

    protected final TreeEntBase entity;

    public TreeEntMoveAndSoundGoal(TreeEntBase entity, double speedModifier) {
        super(entity, speedModifier);
        this.entity = entity;
    }

    @Override
    public void start() {
        entity.playSound(ModSoundEvents.treeEntWalking, 0.7f, 1);
        super.start();
    }
}
