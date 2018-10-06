package com.shotgunseat.vanillaplusplus.biome;

import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Created by Sam on 19/09/2018.
 */
public class ModBiomes {

    public static Biome slimeBiome, acaciaScrubland, outcroppedAcaciaScrubland, polar, extremePolar, karst;

    public ModBiomes() {
    }

    public static void init() {
        slimeBiome = new SlimeBiome(new Biome.BiomeProperties("Slime"), "biome_slime");
        acaciaScrubland = new AcaciaScrubland(
                false,
                new Biome.BiomeProperties("Acacia Shrubland")
                        .setWaterColor(0x89f8ff)
                        .setHeightVariation(0.01F)
                        .setTemperature(2.5F)
                        .setRainfall(0.0F)
                        .setRainDisabled(),
                "biome_acacia_shrubland"
        );
        outcroppedAcaciaScrubland = new AcaciaScrubland(
                true,
                new Biome.BiomeProperties("Extreme Acacia Shrubland")
                        .setBaseBiome("Acacia Shrubland")
                        .setWaterColor(0x89f8ff)
                        .setHeightVariation(0.01F)
                        .setTemperature(2.5F)
                        .setRainfall(0.0F)
                        .setRainDisabled(),
                "biome_mutated_acacia_shrubland"
        );
        polar = new PolarBiome(
                new Biome.BiomeProperties("Polar")
                    .setWaterColor(0xccecff)
                    .setBaseHeight(0.35F)
                    .setHeightVariation(0.01F)
                    .setTemperature(0.0F)
                    .setRainfall(0.5F)
                    .setSnowEnabled(),
                "biome_polar"
        );
        extremePolar = new PolarBiome(
                new Biome.BiomeProperties("Extreme Polar")
                    .setBaseBiome("Polar")
                    .setWaterColor(0xccecff)
                    .setBaseHeight(0.925F)
                    .setHeightVariation(0.45F)
                    .setTemperature(0.0F)
                    .setRainfall(0.5F)
                    .setSnowEnabled(),
                "biome_mutated_polar"
        );
        karst = new KarstBiome(
                new Biome.BiomeProperties("Karst")
                        .setBaseHeight(0.525F)
                        .setHeightVariation(0.55F)
                        .setTemperature(1.0F)
                        .setRainfall(1.5F),
                "biome_karst"
        );
    }

    public static void registerBiome() {
        BiomeManager.addBiome(BiomeManager.BiomeType.WARM, new BiomeManager.BiomeEntry(slimeBiome, 30));
        GameRegistry.register(slimeBiome);
        BiomeManager.addBiome(BiomeManager.BiomeType.DESERT, new BiomeManager.BiomeEntry(acaciaScrubland, 500));
        GameRegistry.register(acaciaScrubland);
        BiomeManager.addBiome(BiomeManager.BiomeType.DESERT, new BiomeManager.BiomeEntry(outcroppedAcaciaScrubland, 500));
        GameRegistry.register(outcroppedAcaciaScrubland);
        BiomeManager.addBiome(BiomeManager.BiomeType.ICY, new BiomeManager.BiomeEntry(polar, 30));
        GameRegistry.register(polar);
        BiomeManager.addBiome(BiomeManager.BiomeType.ICY, new BiomeManager.BiomeEntry(extremePolar, 15));
        GameRegistry.register(extremePolar);
        BiomeManager.addBiome(BiomeManager.BiomeType.WARM, new BiomeManager.BiomeEntry(karst, 2000));
        GameRegistry.register(karst);
    }

}
