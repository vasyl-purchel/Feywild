package com.feywild.feywild.data.worldgen.data;

import com.feywild.feywild.tag.ModBiomeTags;
import io.github.noeppi_noeppi.mods.sandbox.datagen.ext.StructureData;
import net.minecraft.core.Holder;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.levelgen.structure.TerrainAdjustment;
import net.minecraft.world.level.levelgen.structure.pools.StructureTemplatePool;
import net.minecraftforge.common.Tags;

public class FeyStructures extends StructureData {

    private final FeyTemplates templates = this.resolve(FeyTemplates.class);

    public final Holder<Structure> blacksmith = this.singleJigsaw(this.templates.blacksmith)
            .biomes(Tags.Biomes.IS_PLAINS)
            .terrain(TerrainAdjustment.BEARD_THIN)
            .build();

    public final Holder<Structure> library = this.singleJigsaw(this.templates.library)
            .biomes(Tags.Biomes.IS_PLAINS)
            .terrain(TerrainAdjustment.BEARD_THIN)
            .build();

    public final Holder<Structure> dwarvenForge = this.undergroundSingleJigsaw(this.templates.dwarvenForge, -65)
            .biomes(BiomeTags.HAS_MINESHAFT)
            .terrain(TerrainAdjustment.BEARD_THIN)
            .build();


    /*
    public final Holder<Structure> springWorldTree = this.singleJigsaw(this.templates.springWorldTree)
            .biomes(ModBiomeTags.IS_SPRING)
            .terrain(TerrainAdjustment.BEARD_THIN)
            .build();

    public final Holder<Structure> summerWorldTree = this.singleJigsaw(this.templates.summerWorldTree)
            .biomes(ModBiomeTags.IS_SUMMER)
            .terrain(TerrainAdjustment.BEARD_THIN)
            .build();

    public final Holder<Structure> autumnWorldTree = this.singleJigsaw(this.templates.autumnWorldTree)
            .biomes(ModBiomeTags.IS_AUTUMN)
            .terrain(TerrainAdjustment.BEARD_THIN)
            .build();

    public final Holder<Structure> winterWorldTree = this.singleJigsaw(this.templates.winterWorldTree)
            .biomes(ModBiomeTags.IS_WINTER)
            .terrain(TerrainAdjustment.BEARD_THIN)
            .build();
    */
    public final Holder<Structure> beekeep = this.singleJigsaw(this.templates.beekeep)
            .biomes(ModBiomeTags.IS_SUMMER)
            .terrain(TerrainAdjustment.BEARD_THIN)
            .build();

    public final Holder<Structure> feyGeode = this.undergroundSingleJigsaw(this.templates.feyGeode, -65)
            .biomes(ModBiomeTags.IS_FEYWILD_DIMENSION)
            .terrain(TerrainAdjustment.BEARD_THIN)
            .build();


    public FeyStructures(Properties properties) {
        super(properties);
    }

    private StructureSettingsBuilder singleJigsaw(Holder<StructureTemplatePool> pool) {
        return this.jigsaw(pool)
                .height(Heightmap.Types.WORLD_SURFACE_WG)
                .structure()
                .step(GenerationStep.Decoration.SURFACE_STRUCTURES);
    }

    private StructureSettingsBuilder singleJigsaw(Holder<StructureTemplatePool> pool, int start_height) {
        return this.jigsaw(pool)
                .height(Heightmap.Types.WORLD_SURFACE_WG, start_height)
                .structure()
                .step(GenerationStep.Decoration.SURFACE_STRUCTURES);
    }

    private StructureSettingsBuilder undergroundSingleJigsaw(Holder<StructureTemplatePool> pool, int relativeHeight) {
        return this.jigsaw(pool)
                .height(Heightmap.Types.WORLD_SURFACE_WG, relativeHeight)
                .structure()
                .step(GenerationStep.Decoration.UNDERGROUND_DECORATION);
    }
}
