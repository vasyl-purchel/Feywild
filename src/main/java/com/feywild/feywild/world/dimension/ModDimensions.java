package com.feywild.feywild.world.dimension;

import com.feywild.feywild.FeywildMod;
import net.minecraft.item.Item;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;
import net.minecraftforge.registries.ForgeRegistries;

public class ModDimensions {

    //https://minecraft.fandom.com/wiki/Custom_dimension

    public static RegistryKey<World> MARKET_PLACE_DIMENSION;

    public static void register() {

        MARKET_PLACE_DIMENSION = RegistryKey.create(Registry.DIMENSION_REGISTRY,
                new ResourceLocation(FeywildMod.MOD_ID, "market_place_dimension"));
    }

}
