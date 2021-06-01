package com.feywild.feywild.data;

import com.feywild.feywild.FeywildMod;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.GatherDataEvent;

@Mod.EventBusSubscriber(modid = FeywildMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenerators {

    /* Always runData first when adding something new */

    private DataGenerators() {}

    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {

        DataGenerator generator = event.getGenerator();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();

        /* Block and Items where a complete mess only the Fey_Gem_Block worked */
        generator.addProvider(new ModBlockStateProvider(generator, existingFileHelper));
        generator.addProvider(new ModItemModelProvider(generator, existingFileHelper));

        ModBlockTagsProvider block_tags = new ModBlockTagsProvider(generator, existingFileHelper);

        generator.addProvider(block_tags);
        generator.addProvider(new ModItemTagsProvider(generator, block_tags, existingFileHelper));

    }

}
