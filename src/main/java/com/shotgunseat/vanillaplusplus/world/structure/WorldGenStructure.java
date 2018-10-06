package com.shotgunseat.vanillaplusplus.world.structure;

import com.shotgunseat.vanillaplusplus.biome.ModBiomes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunkGenerator;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraftforge.fml.common.IWorldGenerator;

import java.util.Random;

/**
 * Created by Sam on 22/09/2018.
 */
public class WorldGenStructure implements IWorldGenerator {

    private StructureGenerator clayHutGenerator;

    public WorldGenStructure() {
        this.clayHutGenerator = new StructureGenerator("Clay Hut");
    }

    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
        int blockX = chunkX * 16 + random.nextInt(16);
        int blockZ = chunkZ * 16 + random.nextInt(16);
        switch (world.provider.getDimension()) {
            case 0: //overworld
                runGenerator(this.clayHutGenerator, world, blockX, blockZ, 25, random);
                break;
            default:
                break;
        }
    }

    private void runGenerator(StructureGenerator generator, World world, int blockX, int blockZ, int chance, Random random) {
        Biome biomeAtPos = world.getBiome(new BlockPos(blockX, StructureGenerator.getGroundFromAbove(world, blockX, blockZ), blockZ));
        if ((int) (Math.random() * chance) == 0 && (biomeAtPos == ModBiomes.acaciaScrubland || biomeAtPos == ModBiomes.outcroppedAcaciaScrubland)) {
            generator.generate(world, random, new BlockPos(blockX, StructureGenerator.getGroundFromAbove(world, blockX, blockZ), blockZ));
        }
    }
}
