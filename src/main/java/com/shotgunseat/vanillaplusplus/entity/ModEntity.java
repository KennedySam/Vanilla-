package com.shotgunseat.vanillaplusplus.entity;

import com.shotgunseat.vanillaplusplus.VanillaPlusPlus;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.EntityRegistry;

/**
 * Created by Sam on 22/09/2018.
 */
public class ModEntity {

    public static void registerEntities() {
        registerEntity("snake", EntitySnake.class, 120, 30, 0xDAF7A6, 0xFFC300);
    }

    private static void registerEntity(String name, Class<? extends Entity> entity, int id, int range, int eggPrimary, int eggSecondary) {
        EntityRegistry.registerModEntity(entity, name, id, VanillaPlusPlus.instance, range, 1, true, eggPrimary, eggSecondary);
    }

}
