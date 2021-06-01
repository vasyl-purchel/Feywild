package com.feywild.feywild.data;

import com.feywild.feywild.FeywildMod;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.LanguageProvider;

public class ModLanguageProvider extends LanguageProvider {

    public ModLanguageProvider(DataGenerator gen, String locale) {
        super(gen, FeywildMod.MOD_ID, locale);
    }

    @Override
    protected void addTranslations() {

        //Tried: languages, Languages, lang
        String locale = this.getName().replace("Languages: ", "");

        switch (locale) {
            case "en_us":
                en_usAdd();
                break;
            default:
                break;
        }

    }

    private void en_usAdd() {

        add("item.feywild.lesser_fey_gem", "Lesser Fey Gem");
        add("item.feywild.greater_fey_gem", "Greater Fey Gem");
        add("item.feywild.shiny_fey_gem", "Shiny Fey Gem");
        add("item.feywild.fey_dust", "Fey Dust");
        add("item.feywild.brilliant_fey_gem", "Brilliant Fey Gem");
        add("item.feywild.feywild_lexicon", "Feywild Lexicon");
        add("item.feywild.music_disc_feywild", "Song of the Seasons");
        add("item.feywild.summoning_scroll_spring_pixie", "Summoning Scroll Spring Pixie");
        add("item.feywild.summoning_scroll_summer_pixie", "Summoning Scroll Summer Pixie");
        add("item.feywild.summoning_scroll_autumn_pixie", "Summoning Scroll Autumn Pixie");
        add("item.feywild.summoning_scroll_winter_pixie", "Summoning Scroll Winter Pixie");
        add("item.feywild.summoning_scroll_dwarf_blacksmith", "Summoning Contract Dwarf Blacksmith");
        add("item.feywild.fey_sheep_droppings", "Sheep Droppings");
        add("item.feywild.fey_shovel", "Fey Shovel");
        add("item.feywild.fey_hoe", "Fey Hoe");
        add("item.feywild.fey_armor_helmet", "Fey Armor Helmet");
        add("item.feywild.fey_armor_chest", "Fey Armor Chest");
        add("item.feywild.fey_armor_leggings", "Fey Armor Leggings");
        add("item.feywild.fey_armor_boots", "Fey Armor Boots");
        add("item.feywild.schematics_001", "Schematics for Gem Transmutation");
        add("block.feywild.mandrake_crop", "Mandrake Seed");
        add("item.feywild.mandrake", "Mandrake");
        add("block.feywild.fey_gem_block", "Fey Gem Block");
        add("block.feywild.dwarven_anvil", "Dwarven Anvil");
        add("block.feywild.fey_altar", "Fey Altar");
        add("block.feywild.autumn_tree_log", "Autumn Tree Log");
        add("block.feywild.autumn_tree_wood", "Autumn Tree Wood");
        add("block.feywild.autumn_tree_leaves", "Autumn Tree Leaves");
        add("block.feywild.autumn_tree_sapling", "Autumn Tree Sapling");
        add("block.feywild.spring_tree_log", "Spring Tree Log");
        add("block.feywild.spring_tree_wood", "Spring Tree Wood");
        add("block.feywild.spring_tree_leaves", "Spring Tree Leaves");
        add("block.feywild.spring_tree_sapling", "Spring Tree Sapling");
        add("block.feywild.summer_tree_log", "Summer Tree Log");
        add("block.feywild.summer_tree_wood", "Summer Tree Wood");
        add("block.feywild.summer_tree_leaves", "Summer Tree Leaves");
        add("block.feywild.summer_tree_sapling", "Summer Tree Sapling");
        add("block.feywild.winter_tree_log", "Winter Tree Log");
        add("block.feywild.winter_tree_wood", "Winter Tree Wood");
        add("block.feywild.winter_tree_leaves", "Winter Tree Leaves");
        add("block.feywild.winter_tree_sapling", "Winter Tree Sapling");
        add("block.feywild.tree_mushroom", "Tree Mushrooms");
        add("enity.feywild.spring_pixie", "Spring Pixie");
        add("enity.feywild.summer_pixie", "Summer Pixie");
        add("enity.feywild.autumn_pixie", "Autumn Pixie");
        add("enity.feywild.winter_pixie", "Winter Pixie");
        add("enity.feywild.dwarf_blacksmith", "Dwarf Blacksmith");
        add("itemGroup.feywildTab", "Feywild Items");
        add("librarian.feywild.initial", "Hello Stranger, welcome to the Feywild, the wonderful land of fey and magic.\nHave you seen a fey yet? They are a bit shy, but some tasty treats might help you gain their trust.\n Talk to me again if you like to know more about the Fey!");
        add("librarian.feywild.borrow", "Ah! Curious about they Fey? You can borrow this book, it contains valuable information on the Fey Courts.");
        add("librarian.feywild.final", "Here to return that book I borrowed you? No worries you can keep it for a while longer. Fair tidings!");
        add("spring_quest_pixie.feywild.summon_message", "Where Am I? Who are you? Are you tasty? Let's go on an adventure! You wanna play? I'm hungry...");
        add("spring_quest_pixie.feywild.quest_01_message_01", "What is that? A Cloud! No Wait, Cotton Candy! Let's make it fly!");
        add("spring_quest_pixie.feywild.quest_01_message_02", "It doesn't taste very sweet...");
        add("spring_quest_pixie.feywild.quest_01_message_03", "hmm! A sheep you say? Its so fluffy I'm gonna die!");
        add("spring_quest_pixie.feywild.quest_01_message_04", "It must be lonely thou with out his friend who are all the way in the sky!");
        add("spring_quest_pixie.feywild.quest_01_message_05", "What!? It cannot fly? Flying is the best thing there is!");
        add("spring_quest_pixie.feywild.quest_01_message_06", "Wish this meep could experience the joy of flying like his friend can.");
        add("spring_quest_pixie.feywild.quest_01_message_07", "We must find away! You're smart ...");
        add("spring_quest_pixie.feywild.quest_01_message_08", "Or maybe you just have a big head.");
        add("spring_quest_pixie.feywild.quest_01_message_09", "Either way I'm sure you will find a way to make this meep fly!");
        add("summer_quest_pixie.feywild.summon_message", "Peasant, bow down in the presence of your superior! How dare you summon me like I am some sort of magician's familiar.");
        add("autumn_quest_pixie.feywild.summon_message", "Darling, what took you so long! I've been waiting for a fine specimen just like you!");
        add("winter_quest_pixie.feywild.summon_message", "Mortal. Summoning me shortens your lifespan. Now State your demand.");
        add("dwarf.feywild.dialogue", "<Dwarf> Beardless friend! Talking is cheap, but ores are priceless. So, let's trade!");
        add("dwarf.feywild.trade", "<Dwarf> Haha, it's always great trading with you!");
        add("dwarf.feywild.scroll", "<Dwarf> Haha, I like your style. Tell me if you need anything.");
        add("message.feywild.itemmessage", "Hold \"SHIFT\" for more information");
        add("message.feywild.feywild_lexicon", "The return date has expired...");
        add("message.feywild.fey_dust", "Think happy thoughts!");
        add("message.feywild.fey_dust_giggling", "You hear giggling.");
        add("message.feywild.mandrake", "It doesn't seem very happy");
        add("message.feywild.dwarf_blacksmith", "Use this scroll on a Dwarven Anvil to summon your Dwarven friend.");
        add("message.feywild.autumn_pixie", "A summoning scroll for a Autumn Pixie");
        add("message.feywild.spring_pixie", "A summoning scroll for a Spring Pixie");
        add("message.feywild.summer_pixie", "A summoning scroll for a Summer Pixie");
        add("message.feywild.winter_pixie", "A summoning scroll for a Winter Pixie");
        add("message.feywild.music_disc_feywild", "Music composed, mixed and mastered by: Davy Habets (IKIGA) - www.ikigamusic.com");
        add("message.feywild.music_disc_feywild_2", "Song of the Seaons Composed, mixed and mastered by: Davy Habets (IKIGA)");
        add("message.feywild.schematics_001", "Schematics for transmuting fey gems");
        add("screen.feywild.dwarven_anvil", "Dwarven Anvil");

    }
}
