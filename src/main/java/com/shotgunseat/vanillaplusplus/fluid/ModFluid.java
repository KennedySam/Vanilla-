package com.shotgunseat.vanillaplusplus.fluid;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.Fluid;

/**
 * Created by Sam on 08/09/2018.
 */
public class ModFluid extends Fluid {

    public ModFluid(String fluidName, ResourceLocation still, ResourceLocation flowing) {
        super(fluidName, still, flowing);
    }
}
