package com.shotgunseat.vanillaplusplus.crop;

import com.shotgunseat.vanillaplusplus.block.ModBlocks;
import com.shotgunseat.vanillaplusplus.item.ModItems;
import net.minecraft.block.BlockCrops;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import javax.annotation.Nullable;
import java.util.Random;

/**
 * Created by Sam on 07/09/2018.
 */
public class Barley extends BlockCrops {

    public Barley(String name) {
        this.setUnlocalizedName(name);
        this.setCreativeTab(CreativeTabs.FOOD);
    }

    @Override
    protected Item getSeed() {
        return ModItems.barleySeeds;
    }

    @Override
    protected Item getCrop() {
        return Item.getItemFromBlock(ModBlocks.barley);
    }
}
