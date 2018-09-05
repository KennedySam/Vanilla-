package com.shotgunseat.vanillaplusplus.proxy;

import com.shotgunseat.vanillaplusplus.block.ModBlocks;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

/**
 * Created by Sam on 05/09/2018.
 */
public class CommonProxy {

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {

    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        ModBlocks.registerRenders();
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {

    }

}
