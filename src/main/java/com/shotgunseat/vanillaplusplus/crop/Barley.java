package com.shotgunseat.vanillaplusplus.crop;

import net.minecraft.block.BlockCrops;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

import javax.annotation.Nullable;
import java.util.Random;

/**
 * Created by Sam on 07/09/2018.
 */
public class Barley extends BlockCrops {

    public Barley(String name) {
        this.setUnlocalizedName(name);
    }


    @Nullable
    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune) {
        return Items.WHEAT_SEEDS;
    }

}
