package com.feywild.feywild.data;

import com.feywild.feywild.FeywildMod;
import com.feywild.feywild.block.ModBlocks;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.FrameType;
import net.minecraft.advancements.criterion.InventoryChangeTrigger;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TranslationTextComponent;

import java.util.function.Consumer;

public class ModStoryAdvancements implements Consumer<Consumer<FinishedAdvancement>> {

    @Override
    public void accept(Consumer<FinishedAdvancement> consumer) {

/*
        FinishedAdvancement.Builder.builder()
                .advancement(Advancement.Builder.advancement()
                        .parent(new ResourceLocation("adventure/root"))
                        .display(ModItems.LESSER_FEY_GEM.get(),
                                new TranslationTextComponent("advancements.story.dwarf_trade"),
                                new TranslationTextComponent("advancements.story.spring_tree_log.dwarf_trade"),
                                null, FrameType.TASK, true, true, false)
                        .addCriterion("dwarf_trade", VillagerTradeTrigger.Instance.tradedWithVillager()
                                .matches(condition, ModItems.LESSER_FEY_GEM))
                ))
*/

        FinishedAdvancement.Builder.builder()
                .advancement(Advancement.Builder.advancement()
                        .parent(new ResourceLocation("story/iron_tools"))
                        .display(ModBlocks.SPRING_TREE_LOG.get(),
                                new TranslationTextComponent("advancements.story.spring_tree_log"),
                                new TranslationTextComponent("advancements.story.spring_tree_log.discription"),
                                null, FrameType.TASK, true, true, false)
                        .addCriterion("spring_tree_log", InventoryChangeTrigger.Instance.hasItems(ModBlocks.SPRING_TREE_LOG.get())))
                .build(consumer, new ResourceLocation(FeywildMod.MOD_ID, "story/spring_tree_log"));

    }
}
