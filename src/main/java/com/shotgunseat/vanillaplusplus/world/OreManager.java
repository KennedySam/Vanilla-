package com.shotgunseat.vanillaplusplus.world;

import com.shotgunseat.vanillaplusplus.VanillaPlusPlus;
import com.shotgunseat.vanillaplusplus.block.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkGenerator;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.fml.common.IWorldGenerator;

import java.util.Random;

/**
 * Created by Sam on 07/09/2018.
 */
public class OreManager implements IWorldGenerator {
    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
        switch(world.provider.getDimension()){
            case -1: generateNether(world, random, chunkX*16,

                    chunkZ*16);
            case 0: generateSurface(world, random, chunkX*16,

                    chunkZ*16);
            case 1: generateEnd(world, random, chunkX*16,

                    chunkZ*16);
        }

    }

    private void generateSurface(World world, Random random, int x, int y) {
        this.addOreSpawn(ModBlocks.fossil, world, random, x, y, 16, 16, 7, 128, 70, 160);
    }

    private void generateEnd(World world, Random random, int i, int i1) {
    }

    private void generateNether(World world, Random random, int i, int i1) {

    }

    public void addOreSpawn(Block block, World world,
                            Random random, int blockXPos, int blockZPos,
                            int maxX, int maxZ, int maxVeinSize,
                            int chancesToSpawn, int minY, int maxY)
    {
        int maxPossY = minY + (maxY -1);
        int diffBtwnMinMaxY = maxY - minY;
        for(int x = 0; x < chancesToSpawn; x++)
        {
            int posX = blockXPos + random.nextInt(maxX);
            int posY = minY + random.nextInt(diffBtwnMinMaxY);
            int posZ = blockZPos + random.nextInt(maxZ);
            BlockPos pos = new BlockPos(posX, posY, posZ);
            (new WorldGenMinable(block.getDefaultState(),
                    maxVeinSize)).generate(world, random, pos);
        }
    }
}
