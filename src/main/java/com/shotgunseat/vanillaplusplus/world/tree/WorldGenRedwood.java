package com.shotgunseat.vanillaplusplus.world.tree;

import com.shotgunseat.vanillaplusplus.block.LogRedwood;
import com.shotgunseat.vanillaplusplus.block.ModBlocks;
import net.minecraft.block.*;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraftforge.common.IPlantable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Created by Sam on 22/09/2018.
 */
public class WorldGenRedwood extends WorldGenAbstractTree {

    private static final IBlockState blockStateWood = ModBlocks.logRedwood.getDefaultState();
    private static final IBlockState blockStateLeaves = Blocks.LEAVES2.getDefaultState().withProperty(BlockNewLeaf.VARIANT, BlockPlanks.EnumType.DARK_OAK).withProperty(BlockLeaves.CHECK_DECAY, Boolean.valueOf(false));
    private final int minTreeHeight = 25;

    public WorldGenRedwood(boolean notify) {
        super(notify);
    }

    @Override
    public boolean generate(World parWorld, Random parRandom, BlockPos parBlockPos)
    {
        int minHeight = parRandom.nextInt(25) + minTreeHeight;

        // Check if tree fits in world
        if (parBlockPos.getY() >= 1 && parBlockPos.getY() + minHeight + 1 <= parWorld.getHeight())
        {
            if (!isSuitableLocation(parWorld, parBlockPos, minHeight))
            {
                return false;
            }
            else
            {
                IBlockState state = parWorld.getBlockState(parBlockPos.down());

                if (state.getBlock().canSustainPlant(state, parWorld, parBlockPos.down(), EnumFacing.UP, (IPlantable) Blocks.SAPLING) && parBlockPos.getY() < parWorld.getHeight() - minHeight - 1)
                {
                    state.getBlock().onPlantGrow(state, parWorld, parBlockPos.down(), parBlockPos);
                    generateLeaves(parWorld, parBlockPos, minHeight, parRandom);
                    generateTrunk(parWorld, parBlockPos, minHeight, parRandom);
                    return true;
                }
                else
                {
                    return false;
                }
            }
        }
        else
        {
            return false;
        }
    }

    private void generateLeaves(World parWorld, BlockPos parBlockPos, int height, Random parRandom)
    {
        for (int foliageY = parBlockPos.getY() - 2 + height; foliageY <= parBlockPos.getY() + height; ++foliageY)
        {
            int foliageLayer = foliageY - (parBlockPos.getY() + height);
            int foliageLayerRadius = 1 - foliageLayer;

            for (int foliageX = parBlockPos.getX() - foliageLayerRadius; foliageX <= parBlockPos.getX() + foliageLayerRadius; ++foliageX)
            {
                int foliageRelativeX = foliageX - parBlockPos.getX();

                for (int foliageZ = parBlockPos.getZ() - foliageLayerRadius; foliageZ <= parBlockPos.getZ() + foliageLayerRadius; ++foliageZ)
                {
                    int foliageRelativeZ = foliageZ - parBlockPos.getZ();

                    // Fill in layer with some randomness
                    if (Math.abs(foliageRelativeX) != foliageLayerRadius || Math.abs(foliageRelativeZ) != foliageLayerRadius || parRandom.nextInt(10) != 0 && foliageLayer != 0)
                    {
                        BlockPos blockPos = new BlockPos(foliageX, foliageY, foliageZ);
                        IBlockState state = parWorld.getBlockState(blockPos);

                        if (isSuitableForTrunk(parWorld, blockPos, state))
                        {
                            setBlockAndNotifyAdequately(parWorld, blockPos, blockStateLeaves);
                        }
                    }
                }
            }
        }
    }

    private void generateTrunk(World parWorld, BlockPos parBlockPos, int minHeight, Random rand)
    {
        for (int height = 0; height < minHeight; ++height) {
            //The trunk of a redwood consists of 12 blocks arranged in a circle (2, 4, 4, 2) and as such I need a position
            //for each of these. Since giving them sensible names would be difficult, they will be generated and put in a list
            //from 0 - 11 where 0 is top left and 11 is bottom right
            List<BlockPos> positions = getTrunkSlicePositionsLower(parBlockPos, height);
            positions.stream().filter(pos -> isSuitableForTrunk(parWorld, pos, parWorld.getBlockState(pos)))
                    .forEach(pos -> setBlockAndNotifyAdequately(parWorld, pos, blockStateWood.withProperty(LogRedwood.LOG_AXIS, LogRedwood.EnumAxis.Y)));
        }
    }

    private List<BlockPos> getTrunkSlicePositionsLower(BlockPos parBlockPos, int height) {
        List<BlockPos> positions = new ArrayList<>();
        //first row
        BlockPos pos0 = parBlockPos.up(height);
        BlockPos pos1 = pos0.east();
        //second row
        BlockPos pos4 = pos1.south();
        BlockPos pos5 = pos4.east();
        BlockPos pos3 = pos4.west();
        BlockPos pos2 = pos3.west();
        //third row
        BlockPos pos6 = pos2.south();
        BlockPos pos7 = pos6.east();
        BlockPos pos8 = pos7.east();
        BlockPos pos9 = pos8.east();
        //fourth row
        BlockPos pos10 = pos7.south();
        BlockPos pos11 = pos8.south();
        Collections.addAll(positions, pos0, pos1, pos2, pos3, pos4, pos5, pos6, pos7, pos8, pos9, pos10, pos11);
        return positions;
    }

    private boolean isSuitableForTrunk(World parWorld, BlockPos upN, IBlockState state) {
        return state.getBlock().isAir(state, parWorld, upN) || state.getBlock().isLeaves(state, parWorld, upN);
    }

    private boolean isSuitableLocation(World parWorld, BlockPos parBlockPos, int minHeight)
    {
        boolean isSuitableLocation = true;

        for (int checkY = parBlockPos.getY(); checkY <= parBlockPos.getY() + 1 + minHeight; ++checkY)
        {
            // Handle increasing space towards top of tree
            int extraSpaceNeeded = 1;
            // Handle base location
            if (checkY == parBlockPos.getY())
            {
                extraSpaceNeeded = 0;
            }
            // Handle top location
            if (checkY >= parBlockPos.getY() + 1 + minHeight - 2)
            {
                extraSpaceNeeded = 2;
            }

            BlockPos.MutableBlockPos blockPos = new BlockPos.MutableBlockPos();

            for (int checkX = parBlockPos.getX() - extraSpaceNeeded; checkX <= parBlockPos.getX() + extraSpaceNeeded && isSuitableLocation; ++checkX)
            {
                for (int checkZ = parBlockPos.getZ() - extraSpaceNeeded; checkZ <= parBlockPos.getZ() + extraSpaceNeeded && isSuitableLocation; ++checkZ)
                {
                    isSuitableLocation = isReplaceable(parWorld,blockPos.setPos(checkX, checkY, checkZ));
                }
            }
        }

        return isSuitableLocation;
    }
}
