package com.shotgunseat.vanillaplusplus.block;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

/**
 * Created by Sam on 07/09/2018.
 */
public class Limestone extends Block {
    public Limestone(Material materialIn, String name) {
        super(materialIn);
        this.setUnlocalizedName(name);
        this.setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
        this.setHardness(2.0F);
        this.setResistance(3.0F);
        this.setSoundType(SoundType.STONE);
    }
}
