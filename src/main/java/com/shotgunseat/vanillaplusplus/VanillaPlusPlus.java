package com.shotgunseat.vanillaplusplus;

import com.shotgunseat.vanillaplusplus.block.ModBlocks;
import com.shotgunseat.vanillaplusplus.proxy.CommonProxy;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = VanillaPlusPlus.MODID, version = VanillaPlusPlus.VERSION, name = VanillaPlusPlus.NAME)
public class VanillaPlusPlus {

    public static final String MODID = "vanillaplusplus";
    public static final String VERSION = "1.0";
    public static final String NAME = "Vanilla++";

    @SidedProxy(clientSide = "com.shotgunseat.vanillaplusplus.proxy.ClientProxy", serverSide = "com.shotgunseat.vanillaplusplus.proxy.CommonProxy")
    public static CommonProxy proxy;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        ModBlocks.preInit();
        proxy.preInit(event);
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        proxy.init(event);
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        proxy.postInit(event);
    }
    
}
