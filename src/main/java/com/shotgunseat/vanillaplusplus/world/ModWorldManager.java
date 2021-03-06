package com.shotgunseat.vanillaplusplus.world;

import com.shotgunseat.vanillaplusplus.world.structure.WorldGenStructure;
import net.minecraftforge.fml.common.IWorldGenerator;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Created by Sam on 07/09/2018.
 */
public class ModWorldManager {

    public static IWorldGenerator oreGenerator;

    public static void preInit() {
        oreGenerator = new OreManager();

        registerGenerators();
    }

    private static void registerGenerators() {
        GameRegistry.registerWorldGenerator(oreGenerator, 0);
        GameRegistry.registerWorldGenerator(new WorldGenStructure(), 2);
    }
}
