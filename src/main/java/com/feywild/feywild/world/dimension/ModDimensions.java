package com.feywild.feywild.world.dimension;

import com.feywild.feywild.FeywildMod;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;

public class ModDimensions {

    //https://minecraft.fandom.com/wiki/Custom_dimension

    public static RegistryKey<World> Market_Place_Dimension;

    public static void register() {

        Market_Place_Dimension = RegistryKey.create(Registry.DIMENSION_REGISTRY,
                new ResourceLocation(FeywildMod.MOD_ID, "market_place_dimension"));
    }

}
