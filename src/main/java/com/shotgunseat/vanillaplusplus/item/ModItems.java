package com.shotgunseat.vanillaplusplus.item;

import com.shotgunseat.vanillaplusplus.VanillaPlusPlus;
import com.shotgunseat.vanillaplusplus.block.ModBlocks;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSeeds;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Created by Sam on 08/09/2018.
 */
public class ModItems {

    public static Item unfiredSmeltingPot, smeltingPot, barleySeeds, grapeSeeds, slimeBucket;

    public static void preInit() {

        unfiredSmeltingPot = new UnfiredSmeltingPot("unfired_smelting_pot");
        smeltingPot = new SmeltingPot("smelting_pot");
        barleySeeds = new BarleySeeds(ModBlocks.barley, Blocks.FARMLAND).setUnlocalizedName("barley_seeds");
        grapeSeeds = new GrapeSeeds(ModBlocks.barley, Blocks.FARMLAND).setUnlocalizedName("grape_seeds");
        slimeBucket = new BucketSlime("bucket_slime");

        registerItems();
    }

    public static void registerItems() {
        registerItem(unfiredSmeltingPot);
        registerItem(smeltingPot);
        registerItem(barleySeeds);
        registerItem(grapeSeeds);
        registerItem(slimeBucket);
    }


    private static void registerItem(Item item) {
        GameRegistry.register(item, new ResourceLocation(VanillaPlusPlus.MODID, item.getUnlocalizedName().substring(5)));
    }

    public static void registerRenders() {
        registerRender(unfiredSmeltingPot);
        registerRender(smeltingPot);
        registerRender(barleySeeds);
        registerRender(grapeSeeds);
        registerRender(slimeBucket);
    }

    public static void registerRender(Item item) {
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(VanillaPlusPlus.MODID + ":" + item.getUnlocalizedName().substring(5), "inventory"));
    }

}
