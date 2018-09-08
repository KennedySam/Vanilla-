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

    public static Block fossil, limestone, barrelOak, barrelSpruce, barrelAcacia, barrelBigOak, barrelBirch, barrelJungle, beehive;

    public static void preInit() {
        fossil = new Fossil(Material.ROCK, "fossil");
        limestone = new Limestone(Material.ROCK, "limestone");
        barrelOak = new BarrelOak(Material.WOOD, "barrel_oak");
        barrelAcacia = new BarrelAcacia(Material.WOOD, "barrel_acacia");
        barrelSpruce = new BarrelSpruce(Material.WOOD, "barrel_spruce");
        barrelBigOak = new BarrelBigOak(Material.WOOD, "barrel_big_oak");
        barrelBirch = new BarrelBirch(Material.WOOD, "barrel_birch");
        barrelJungle = new BarrelJungle(Material.WOOD, "barrel_jungle");
        beehive = new Beehive(Material.WOOD, "beehive");

        registerBlocks();
    }

    public static void registerBlocks() {
        registerBlock(fossil);
        registerBlock(limestone);
        registerBlock(barrelOak);
        registerBlock(barrelSpruce);
        registerBlock(barrelAcacia);
        registerBlock(barrelBigOak);
        registerBlock(barrelJungle);
        registerBlock(barrelBirch);
        registerBlock(beehive);
    }

    private static void registerBlock(Block block) {
        GameRegistry.register(block, new ResourceLocation(VanillaPlusPlus.MODID, block.getUnlocalizedName().substring(5)));
        GameRegistry.register(new ItemBlock(block), new ResourceLocation(VanillaPlusPlus.MODID, block.getUnlocalizedName().substring(5)));
    }

    public static void registerRenders() {
        registerRender(fossil);
        registerRender(limestone);
        registerRender(barrelOak);
        registerRender(barrelBirch);
        registerRender(barrelJungle);
        registerRender(barrelBigOak);
        registerRender(barrelSpruce);
        registerRender(barrelAcacia);
        registerRender(beehive);
    }

    public static void registerRender(Block block) {
        Item item = Item.getItemFromBlock(block);
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(VanillaPlusPlus.MODID + ":" + item.getUnlocalizedName().substring(5), "inventory"));
    }

}
