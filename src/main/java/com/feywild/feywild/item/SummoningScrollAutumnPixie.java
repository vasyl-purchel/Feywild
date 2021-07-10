package com.feywild.feywild.item;

import com.feywild.feywild.FeywildMod;
import com.feywild.feywild.entity.AutumnPixieEntity;
import com.feywild.feywild.network.FeywildPacketHandler;
import com.feywild.feywild.network.OpenQuestScreen;
import com.feywild.feywild.network.QuestMessage;
import com.feywild.feywild.quest.QuestMap;
import com.feywild.feywild.sound.ModSoundEvents;
import com.feywild.feywild.util.KeyboardHelper;
import com.feywild.feywild.util.ModUtil;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.scoreboard.Score;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

import java.util.List;
import java.util.Objects;

public class SummoningScrollAutumnPixie extends Item {

    public SummoningScrollAutumnPixie() {
        super(new Item.Properties().tab(FeywildMod.FEYWILD_TAB));
    }

    @Override
    public ActionResultType useOn(ItemUseContext context) {
        if (!context.getLevel().isClientSide) {

            PlayerEntity player = context.getPlayer();

            AutumnPixieEntity entity = new AutumnPixieEntity(context.getLevel(), true, context.getClickedPos());
            entity.setTag(entity);

            entity.setPos(context.getClickLocation().x(), context.getClickLocation().y(), context.getClickLocation().z());
            player.sendMessage(new TranslationTextComponent("autumn_quest_pixie.feywild.summon_message"), player.getUUID());

            context.getLevel().addFreshEntity(entity);
            context.getPlayer().getItemInHand(context.getHand()).shrink(1);

            //entity.playSound(ModSoundEvents.SUMMONING_AUTUMN_PIXIE.get(), 1, 1);


            /* QUEST */

            Score questId = ModUtil.getOrCreatePlayerScore(player.getName().getString(), QuestMap.Scores.FW_Quest.toString(), player.level, 0);

            if (!player.getTags().contains(QuestMap.Courts.AutumnAligned.toString()) && !player.getTags().contains(QuestMap.Courts.SpringAligned.toString()) && !player.getTags().contains(QuestMap.Courts.WinterAligned.toString()) && !player.getTags().contains(QuestMap.Courts.SummerAligned.toString())) {
                questId.setScore(200);
                FeywildPacketHandler.sendToPlayer(new QuestMessage(player.getUUID(), questId.getScore()), player);
                player.sendMessage(new TranslationTextComponent("message.feywild.aligned"), player.getUUID());
                player.addTag(QuestMap.Courts.AutumnAligned.toString());
            }

            if (player.getTags().contains(QuestMap.Courts.AutumnAligned.toString())) {

                if (!QuestMap.getSound(questId.getScore()).equals("NULL"))
                    player.level.playSound(null, player.blockPosition(), Objects.requireNonNull(Registry.SOUND_EVENT.get(new ResourceLocation(QuestMap.getSound(questId.getScore())))), SoundCategory.VOICE, 1, 1);

                FeywildPacketHandler.sendToPlayer(new OpenQuestScreen(questId.getScore(), QuestMap.getLineNumber(questId.getScore()), QuestMap.getCanSkip(questId.getScore()),entity.getId()), player);
            } else {
                entity.playSound(ModSoundEvents.SUMMONING_AUTUMN_PIXIE.get(), 1, 1);
            }
        }
        return ActionResultType.SUCCESS;
    }

    @Override
    public void appendHoverText(ItemStack stack, World world, List<ITextComponent> tooltip, ITooltipFlag flag) {

        if (KeyboardHelper.isHoldingShift()) {

            tooltip.add(new TranslationTextComponent("message.feywild.autumn_pixie"));

        } else {
            tooltip.add(new TranslationTextComponent("message.feywild.itemmessage"));

        }

        super.appendHoverText(stack, world, tooltip, flag);
    }
}
