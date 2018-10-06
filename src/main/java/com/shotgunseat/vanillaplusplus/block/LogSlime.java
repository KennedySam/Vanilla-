package com.shotgunseat.vanillaplusplus.block;

import net.minecraft.block.BlockRotatedPillar;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

/**
 * Created by Sam on 16/09/2018.
 */
public class LogSlime  extends BlockRotatedPillar {

    protected LogSlime(Material materialIn, String name) {
        super(materialIn);
        this.setUnlocalizedName(name);
        this.setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
        this.setSoundType(SoundType.SLIME);
        this.setHarvestLevel("axe", 0);
        this.setHardness(3.0F);
        this.setResistance(5.0F);
    }

}
