package com.shotgunseat.vanillaplusplus.sound;

import com.shotgunseat.vanillaplusplus.VanillaPlusPlus;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;

/**
 * Created by Sam on 08/09/2018.
 */
public class ModSoundHandler {

    private static int size = 0;

    public static SoundEvent BEE_BUZZ;

    public static void init() {
        size = SoundEvent.REGISTRY.getKeys().size();

        BEE_BUZZ = register("blocks.beehive.bee_buzz");
    }

    public static SoundEvent register(String name) {
        ResourceLocation location = new ResourceLocation(VanillaPlusPlus.MODID, name);
        SoundEvent event = new SoundEvent(location);

        SoundEvent.REGISTRY.register(size, location, event);
        size++;
        return event;
    }
}
