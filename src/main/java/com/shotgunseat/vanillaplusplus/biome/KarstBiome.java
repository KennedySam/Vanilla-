package com.shotgunseat.vanillaplusplus.biome;

import com.shotgunseat.vanillaplusplus.VanillaPlusPlus;
import com.shotgunseat.vanillaplusplus.block.ModBlocks;
import com.shotgunseat.vanillaplusplus.world.WorldGenKarst;
import com.shotgunseat.vanillaplusplus.world.tree.WorldGenAcaciaBush;
import com.shotgunseat.vanillaplusplus.world.tree.WorldGenRedwood;
import net.minecraft.init.Blocks;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomePlains;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraftforge.event.terraingen.DecorateBiomeEvent;

import java.util.Random;

/**
 * Created by Sam on 22/09/2018.
 */
public class KarstBiome extends BiomePlains {

    private WorldGenKarst worldGenKarst = new WorldGenKarst();
    private static final WorldGenRedwood REDWOOD = new WorldGenRedwood(false);

    public KarstBiome(BiomeProperties properties, String name) {
        super(false, properties);
        this.setRegistryName(new ResourceLocation(VanillaPlusPlus.MODID + ":" + name));
        this.topBlock = Blocks.GRASS.getDefaultState();
        this.fillerBlock = ModBlocks.limestone.getDefaultState();
        this.spawnableCreatureList.clear();
        this.theBiomeDecorator.generateLakes = true;
        this.theBiomeDecorator.treesPerChunk = 4;
    }

    @Override
    public WorldGenAbstractTree genBigTreeChance(Random rand) {
        return REDWOOD;
    }


        @Override
    public int getGrassColorAtPos(BlockPos pos) {
        return 0x4ca653;
    }

    @Override
    public void decorate(World worldIn, Random rand, BlockPos pos) {
        if (net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, pos, DecorateBiomeEvent.Decorate.EventType.ICE))
        {
            for (int i = 0; i < 10; ++i)
            {
                int j = rand.nextInt(16) + 8;
                int k = rand.nextInt(16) + 8;
                this.worldGenKarst.generate(worldIn, rand, worldIn.getHeight(pos.add(j, 0, k)));
            }
        }

        super.decorate(worldIn, rand, pos);
    }
}
