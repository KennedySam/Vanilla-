package com.shotgunseat.vanillaplusplus.block;

import net.minecraft.block.BlockLog;
import net.minecraft.block.BlockRotatedPillar;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;

/**
 * Created by Sam on 22/09/2018.
 */
public class LogRedwood  extends BlockLog {

    protected LogRedwood(String name) {
        this.setDefaultState(this.blockState.getBaseState().withProperty(LOG_AXIS, BlockLog.EnumAxis.Y));
        this.setUnlocalizedName(name);
        this.setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
        this.setSoundType(SoundType.WOOD);
        this.setHarvestLevel("axe", 0);
        this.setHardness(3.0F);
        this.setResistance(5.0F);
    }

    /**
     * Convert the given metadata into a BlockState for this Block
     */
    public IBlockState getStateFromMeta(int meta)
    {
        IBlockState state = this.getDefaultState();

        switch (meta & 0b1100)
        {
            case 0b0000:
                state = state.withProperty(LOG_AXIS, BlockLog.EnumAxis.Y);
                break;

            case 0b0100:
                state = state.withProperty(LOG_AXIS, BlockLog.EnumAxis.X);
                break;

            case 0b1000:
                state = state.withProperty(LOG_AXIS, BlockLog.EnumAxis.Z);
                break;

            case 0b1100:
                state = state.withProperty(LOG_AXIS, BlockLog.EnumAxis.NONE);
                break;
        }

        return state;
    }

    /**
     * Convert the BlockState into the correct metadata value
     */
    public int getMetaFromState(IBlockState state)
    {
        switch ((BlockLog.EnumAxis)state.getValue(LOG_AXIS))
        {
            case X: return 0b0100;
            case Y: return 0b0000;
            case Z: return 0b1000;
            case NONE: return 0b1100;
            default: return 0b1100;
        }
    }

    protected BlockStateContainer createBlockState()
    {
        return new BlockStateContainer(this, new IProperty[] {LOG_AXIS});
    }
}
