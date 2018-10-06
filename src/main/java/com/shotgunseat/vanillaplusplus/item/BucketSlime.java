package com.shotgunseat.vanillaplusplus.item;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

/**
 * Created by Sam on 16/09/2018.
 */
public class BucketSlime extends Item {

    public BucketSlime(String name) {
        this.setUnlocalizedName(name);
        this.setCreativeTab(CreativeTabs.MISC);
        this.maxStackSize = 1;
    }

}
