package com.shotgunseat.vanillaplusplus.biome;

import com.shotgunseat.vanillaplusplus.VanillaPlusPlus;
import com.shotgunseat.vanillaplusplus.block.ModBlocks;
import net.minecraft.entity.monster.EntitySlime;
import net.minecraft.init.Blocks;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;

/**
 * Created by Sam on 19/09/2018.
 */
public class SlimeBiome extends Biome {

    public SlimeBiome(BiomeProperties properties, String name) {
        super(properties);
        this.setRegistryName(new ResourceLocation(VanillaPlusPlus.MODID + ":" + name));
        this.spawnableCreatureList.add(new Biome.SpawnListEntry(EntitySlime.class, 8, 4, 4));
        this.topBlock = Blocks.GRASS.getDefaultState();
    }

    @Override
    public int getGrassColorAtPos(BlockPos pos) {
        return 0xff0000;
    }

    @Override
    public int getFoliageColorAtPos(BlockPos pos) {
        return 0xff0000;
    }
}
