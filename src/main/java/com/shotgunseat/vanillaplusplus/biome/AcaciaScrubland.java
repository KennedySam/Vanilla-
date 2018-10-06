package com.shotgunseat.vanillaplusplus.biome;

import com.shotgunseat.vanillaplusplus.VanillaPlusPlus;
import com.shotgunseat.vanillaplusplus.block.ModBlocks;
import com.shotgunseat.vanillaplusplus.entity.EntitySnake;
import com.shotgunseat.vanillaplusplus.world.WorldGenClayOutcrop;
import com.shotgunseat.vanillaplusplus.world.tree.WorldGenAcaciaBush;
import net.minecraft.block.BlockFlower;
import net.minecraft.entity.passive.EntityRabbit;
import net.minecraft.init.Blocks;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.world.gen.feature.WorldGenSavannaTree;
import net.minecraftforge.event.terraingen.DecorateBiomeEvent;

import java.util.Random;

/**
 * Created by Sam on 19/09/2018.
 */
public class AcaciaScrubland extends Biome {

    private static final WorldGenSavannaTree SAVANNA_TREE = new WorldGenSavannaTree(false);
    private static final WorldGenAcaciaBush ACACIA_BUSH = new WorldGenAcaciaBush(false);
    private final WorldGenClayOutcrop outcrop = new WorldGenClayOutcrop();
    private boolean spiky;

    public AcaciaScrubland(boolean spiky, BiomeProperties properties, String name) {
        super(properties);
        this.spiky = spiky;
        this.setRegistryName(new ResourceLocation(VanillaPlusPlus.MODID + ":" + name));
        this.topBlock = ModBlocks.redSandySoil.getDefaultState();
        this.fillerBlock = Blocks.HARDENED_CLAY.getDefaultState();
        this.theBiomeDecorator.treesPerChunk = 2;
        this.theBiomeDecorator.deadBushPerChunk = 8;
        this.theBiomeDecorator.grassPerChunk = 2;
        this.spawnableCreatureList.clear();
        this.spawnableCreatureList.add(new Biome.SpawnListEntry(EntityRabbit.class, 4, 2, 3));
        this.spawnableCreatureList.add(new Biome.SpawnListEntry(EntitySnake.class, 4, 1, 2));
    }

    @Override
    public WorldGenAbstractTree genBigTreeChance(Random rand)
    {
        if (rand.nextFloat() < 0.85) {
            return ACACIA_BUSH;
        } else {
            return SAVANNA_TREE;
        }
    }

    @Override
    public BlockFlower.EnumFlowerType pickRandomFlower(Random rand, BlockPos pos) {
        return super.pickRandomFlower(rand, pos);
    }

    @Override
    public void addDefaultFlowers() {
        super.addDefaultFlowers();
    }

    @Override
    public int getGrassColorAtPos(BlockPos pos) {
        return 0xab5e04;
    }

    @Override
    public void decorate(World worldIn, Random rand, BlockPos pos) {
        boolean generate = rand.nextBoolean();
        if (this.spiky && net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, pos, DecorateBiomeEvent.Decorate.EventType.ICE) && generate)
        {
            for (int i = 0; i < 1; ++i)
            {
                int j = rand.nextInt(16) + 8;
                int k = rand.nextInt(16) + 8;
                this.outcrop.generate(worldIn, rand, worldIn.getHeight(pos.add(j, 0, k)));
            }
        }

        super.decorate(worldIn, rand, pos);
    }
}
