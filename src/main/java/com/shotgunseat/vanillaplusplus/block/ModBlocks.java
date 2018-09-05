package com.shotgunseat.vanillaplusplus.block;

import com.shotgunseat.vanillaplusplus.VanillaPlusPlus;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Created by Sam on 05/09/2018.
 */
public class ModBlocks {

    public static Block fossil;

    public static void preInit() {
        fossil = new Fossil(Material.ROCK, "fossil");
        
        registerBlocks();
    }

    public static void registerBlocks() {
        registerBlock(fossil, "fossil");
    }

    private static void registerBlock(Block block, String name) {
        GameRegistry.register(block, new ResourceLocation(VanillaPlusPlus.MODID, name));
        GameRegistry.register(new ItemBlock(block), new ResourceLocation(VanillaPlusPlus.MODID, name));
    }

    public static void registerRenders() {
        registerRender(fossil);
    }

    private static void registerRender(Block block) {
        Item item = Item.getItemFromBlock(block);
        Minecraft.getMinecraft()
                .getRenderItem()
                .getItemModelMesher()
                .register(item, 0, new ModelResourceLocation(
                                VanillaPlusPlus.MODID + ":" + item.getUnlocalizedName().substring(5), "inventory"
                        )
                );
    }

}
