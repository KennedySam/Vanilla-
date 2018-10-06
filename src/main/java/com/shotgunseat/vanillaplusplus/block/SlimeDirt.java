package com.shotgunseat.vanillaplusplus.block;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

/**
 * Created by Sam on 19/09/2018.
 */
public class SlimeDirt extends Block {

    public SlimeDirt(Material materialIn, String name) {
        super(materialIn);
        this.setUnlocalizedName(name);
        this.setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
        this.setSoundType(SoundType.SLIME);
        this.setHarvestLevel("shovel", 0);
        this.setHardness(1.0F);
        this.setResistance(1.0F);
    }
}
