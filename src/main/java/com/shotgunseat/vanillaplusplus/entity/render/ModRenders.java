package com.shotgunseat.vanillaplusplus.entity.render;

import com.shotgunseat.vanillaplusplus.entity.EntitySnake;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

/**
 * Created by Sam on 22/09/2018.
 */
public class ModRenders {

    public static void registerEntityRenderers() {
        RenderingRegistry.registerEntityRenderingHandler(EntitySnake.class, RenderSnake::new);
    }
}
