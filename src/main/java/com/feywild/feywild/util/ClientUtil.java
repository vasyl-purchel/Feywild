package com.feywild.feywild.util;

import com.feywild.feywild.quest.QuestMap;
import com.feywild.feywild.screens.PixieScreen;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.text.StringTextComponent;

public class ClientUtil {

    public static void openQuestScreen(int quest , int lines, boolean canSkip, LivingEntity entity){
        Minecraft.getInstance().setScreen(new PixieScreen(new StringTextComponent("Fey Quest"),quest,lines, canSkip,entity));
    }
}
