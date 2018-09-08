package com.shotgunseat.vanillaplusplus.crafting;

import com.shotgunseat.vanillaplusplus.block.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockPlanks;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;

/**
 * Created by Sam on 08/09/2018.
 */
public class ModCrafting {

    public static void preInit() {
        addRecipe(new ItemStack(ModBlocks.barrelOak, 1), new Object[] {
                "www",
                "i i",
                "www",
                Character.valueOf('w'), new ItemStack(Blocks.PLANKS, 1, 0),
                Character.valueOf('i'), Items.IRON_INGOT
        });
        addRecipe(new ItemStack(ModBlocks.barrelAcacia, 1), new Object[] {
                "www",
                "i i",
                "www",
                Character.valueOf('w'), new ItemStack(Blocks.PLANKS, 1, 4),
                Character.valueOf('i'), Items.IRON_INGOT
        });
        addRecipe(new ItemStack(ModBlocks.barrelBigOak, 1), new Object[] {
                "www",
                "i i",
                "www",
                Character.valueOf('w'), new ItemStack(Blocks.PLANKS, 1, 5),
                Character.valueOf('i'), Items.IRON_INGOT
        });
        addRecipe(new ItemStack(ModBlocks.barrelBirch, 1), new Object[] {
                "www",
                "i i",
                "www",
                Character.valueOf('w'), new ItemStack(Blocks.PLANKS, 1, 2),
                Character.valueOf('i'), Items.IRON_INGOT
        });
        addRecipe(new ItemStack(ModBlocks.barrelJungle, 1), new Object[] {
                "www",
                "i i",
                "www",
                Character.valueOf('w'), new ItemStack(Blocks.PLANKS, 1, 3),
                Character.valueOf('i'), Items.IRON_INGOT
        });
        addRecipe(new ItemStack(ModBlocks.barrelSpruce, 1), new Object[] {
                "www",
                "i i",
                "www",
                Character.valueOf('w'), new ItemStack(Blocks.PLANKS, 1, 1),
                Character.valueOf('i'), Items.IRON_INGOT
        });
    }

    public static final void addRecipe(ItemStack out, Object[] in) {
        GameRegistry.addRecipe(new ShapedOreRecipe(out, in));
    }


}
