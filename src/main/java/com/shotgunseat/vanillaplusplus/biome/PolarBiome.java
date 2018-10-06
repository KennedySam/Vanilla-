package com.shotgunseat.vanillaplusplus.biome;

import com.shotgunseat.vanillaplusplus.VanillaPlusPlus;
import net.minecraft.init.Blocks;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.BiomeSnow;

/**
 * Created by Sam on 20/09/2018.
 */
public class PolarBiome extends BiomeSnow {

    public PolarBiome(BiomeProperties properties, String name) {
        super(false, properties);
        this.setRegistryName(new ResourceLocation(VanillaPlusPlus.MODID + ":" + name));
        this.topBlock = Blocks.SNOW.getDefaultState();
        this.fillerBlock = Blocks.PACKED_ICE.getDefaultState();
        this.spawnableCreatureList.clear();
        this.theBiomeDecorator.generateLakes = true;
    }
}
