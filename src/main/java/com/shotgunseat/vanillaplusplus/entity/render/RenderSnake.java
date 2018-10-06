package com.shotgunseat.vanillaplusplus.entity.render;

import com.shotgunseat.vanillaplusplus.VanillaPlusPlus;
import com.shotgunseat.vanillaplusplus.entity.EntitySnake;
import com.shotgunseat.vanillaplusplus.entity.model.ModelSnake;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

/**
 * Created by Sam on 22/09/2018.
 */
public class RenderSnake extends RenderLiving<EntitySnake> {

    public static final ResourceLocation TEXTURES = new ResourceLocation(VanillaPlusPlus.MODID + ":textures/entity/snake.png");

    public RenderSnake(RenderManager rendermanagerIn) {
        super(rendermanagerIn, new ModelSnake(), 0.1F);
    }

    @Override
    protected ResourceLocation getEntityTexture(EntitySnake entity) {
        return TEXTURES;
    }


}
