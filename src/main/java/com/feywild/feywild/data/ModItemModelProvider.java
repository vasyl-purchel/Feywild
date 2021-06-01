package com.feywild.feywild.data;

import com.feywild.feywild.FeywildMod;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModItemModelProvider extends ItemModelProvider {

    /* We need this for normal items but also block items */

    public ModItemModelProvider(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, FeywildMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {

        /* BLOCKS */
        withExistingParent("fey_gem_block", modLoc("block/fey_gem_block"));

        ModelFile itemGenerated = getExistingFile(mcLoc("item/generated"));

        builder(itemGenerated, "lesser_fey_gem");
        builder(itemGenerated, "greater_fey_gem");
        builder(itemGenerated, "shiny_fey_gem");
        builder(itemGenerated, "brilliant_fey_gem");
        builder(itemGenerated, "feywild_lexicon");
        builder(itemGenerated, "fey_dust");
        builder(itemGenerated, "mandrake");
        builder(itemGenerated, "mandrake_seed");
        builder(itemGenerated, "music_disc_feywild");
        //     builder(itemGenerated, "schematics_001");
        builder(itemGenerated, "summoning_scroll_spring_pixie");
        builder(itemGenerated, "summoning_scroll_summer_pixie");
        builder(itemGenerated, "summoning_scroll_autumn_pixie");
        builder(itemGenerated, "summoning_scroll_winter_pixie");
        builder(itemGenerated, "summoning_scroll_dwarf_blacksmith");

    }

    private ItemModelBuilder builder(ModelFile itemGenerated, String name) {
        return getBuilder(name).parent(itemGenerated).texture("layer0", "item/" + name);
    }

}
