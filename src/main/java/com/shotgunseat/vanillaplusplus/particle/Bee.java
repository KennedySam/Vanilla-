package com.shotgunseat.vanillaplusplus.particle;

import com.shotgunseat.vanillaplusplus.VanillaPlusPlus;
import net.minecraft.client.particle.Particle;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

/**
 * Created by Sam on 08/09/2018.
 */
public class Bee extends Particle {

    public ResourceLocation texture = new ResourceLocation(VanillaPlusPlus.MODID + ":" + "particles/bee");

    protected Bee(World worldIn, double posXIn, double posYIn, double posZIn) {
        super(worldIn, posXIn, posYIn, posZIn);
    }
}
