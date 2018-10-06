package com.shotgunseat.vanillaplusplus.proxy;

import com.shotgunseat.vanillaplusplus.biome.ModBiomes;
import com.shotgunseat.vanillaplusplus.block.ModBlocks;
import com.shotgunseat.vanillaplusplus.item.ModItems;
import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.Particle;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

/**
 * Created by Sam on 05/09/2018.
 */
public class ClientProxy extends CommonProxy {

    @Override
    public void preInit(FMLPreInitializationEvent event) {
    }

    @Override
    public void init(FMLInitializationEvent event) {
        ModBlocks.registerRenders();
        ModItems.registerRenders();
        ModBiomes.registerBiome();
    }

    @Override
    public void postInit(FMLPostInitializationEvent event) {
    }
}
