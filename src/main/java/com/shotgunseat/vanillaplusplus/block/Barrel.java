package com.shotgunseat.vanillaplusplus.block;

import net.minecraft.block.BlockRotatedPillar;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import javax.annotation.Nullable;

/**
 * Created by Sam on 08/09/2018.
 */
public class Barrel extends BlockRotatedPillar {

    public Barrel(Material materialIn, String name) {
        super(materialIn);
        this.setUnlocalizedName(name);
        this.setCreativeTab(CreativeTabs.BREWING);
        this.setHardness(3.0F);
        this.setResistance(5.0F);
        this.setSoundType(SoundType.WOOD);
    }

    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, @Nullable ItemStack heldItem, EnumFacing side, float hitX, float hitY, float hitZ) {
        worldIn.playSound(playerIn, pos, SoundEvents.BLOCK_CHEST_OPEN, SoundCategory.BLOCKS, 1.0F, 1.0F);
        return true;
    }


}
