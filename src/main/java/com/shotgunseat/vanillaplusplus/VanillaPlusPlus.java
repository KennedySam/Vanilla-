package com.shotgunseat.vanillaplusplus;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

@Mod(modid = VanillaPlusPlus.MODID, version = VanillaPlusPlus.VERSION)
public class VanillaPlusPlus {

    public static final String MODID = "examplemod";
    public static final String VERSION = "1.0";
    public static final String NAME = "Vanilla++";

    @EventHandler
    public void init(FMLInitializationEvent event) {
    }
    
}
