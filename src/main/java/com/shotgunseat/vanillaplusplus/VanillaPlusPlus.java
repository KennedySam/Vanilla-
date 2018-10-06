package com.shotgunseat.vanillaplusplus;

import com.shotgunseat.vanillaplusplus.biome.ModBiomes;
import com.shotgunseat.vanillaplusplus.block.ModBlocks;
import com.shotgunseat.vanillaplusplus.crafting.ModCrafting;
import com.shotgunseat.vanillaplusplus.entity.ModEntity;
import com.shotgunseat.vanillaplusplus.entity.render.ModRenders;
import com.shotgunseat.vanillaplusplus.item.ModItems;
import com.shotgunseat.vanillaplusplus.proxy.CommonProxy;
import com.shotgunseat.vanillaplusplus.sound.ModSoundHandler;
import com.shotgunseat.vanillaplusplus.world.ModWorldManager;
import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;

@Mod(modid = VanillaPlusPlus.MODID, version = VanillaPlusPlus.VERSION, name = VanillaPlusPlus.NAME)
public class VanillaPlusPlus {

    public static final String MODID = "vanillaplusplus";
    public static final String VERSION = "1.0";
    public static final String NAME = "Vanilla++";

    @SidedProxy(clientSide = "com.shotgunseat.vanillaplusplus.proxy.ClientProxy", serverSide = "com.shotgunseat.vanillaplusplus.proxy.CommonProxy")
    public static CommonProxy proxy;

    @Mod.Instance
    public static VanillaPlusPlus instance;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        ModBlocks.preInit();
        ModItems.preInit();
        ModWorldManager.preInit();
        ModCrafting.preInit();
        ModSoundHandler.init();
        ModBiomes.init();
        ModEntity.registerEntities();
        ModRenders.registerEntityRenderers();
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
