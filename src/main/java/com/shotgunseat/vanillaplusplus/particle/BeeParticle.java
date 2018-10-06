package com.shotgunseat.vanillaplusplus.particle;

import com.shotgunseat.vanillaplusplus.VanillaPlusPlus;
import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.fml.client.FMLClientHandler;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.awt.*;

/**
 * Created by Sam on 08/09/2018. With code stolen from http://www.minecraftforge.net/forum/topic/40662-1102-custom-particles/
 */
@SideOnly(Side.CLIENT)
public class BeeParticle extends Particle {

    private double targetX;
    private double targetY;
    private double targetZ;

    public double colorR = 0;
    public double colorG = 0;
    public double colorB = 0;

    public ResourceLocation texture = new ResourceLocation(VanillaPlusPlus.MODID + ":" + "particles/bee");

    protected BeeParticle(World w, double x, double y, double z, double tx, double ty, double tz, int count, int color, float scale) {
        super(w, x, y, z, 0.0D, 0.0D, 0.0D);

        this.particleRed = (this.particleGreen = this.particleBlue = 0.6F);
        this.particleScale = ((MathHelper.sin(count / 2.0F) * 0.1F + 1.0F) * scale);

        this.targetX = tx;
        this.targetY = ty;
        this.targetZ = tz;
        this.posY += 0.33000001311302185D;
        double dx = tx - this.posX;
        double dy = ty - this.posY;
        double dz = tz - this.posZ;
        int base = (int)(MathHelper.sqrt_double(dx * dx + dy * dy + dz * dz) * 30.0F);
        if (base < 1) {
            base = 1;
        }
        this.particleMaxAge = (base / 2 + this.rand.nextInt(base));

        this.motionX = (MathHelper.sin(count / 4.0F) * 0.015F + this.rand.nextGaussian() * 0.0020000000949949026D);
        this.motionY = (MathHelper.sin(count / 3.0F) * 0.015F + this.rand.nextGaussian() * 0.0020000000949949026D);
        this.motionZ = (MathHelper.sin(count / 2.0F) * 0.015F + this.rand.nextGaussian() * 0.0020000000949949026D);

        if (this.isCollided){
            this.motionX *= 0.699999988079071D;
            this.motionZ *= 0.699999988079071D;
        }

        Color c = new Color(color);
        float mr = c.getRed() / 255.0F * 0.2F;
        float mg = c.getGreen() / 255.0F * 0.2F;
        float mb = c.getBlue() / 255.0F * 0.2F;
        this.particleRed = (c.getRed() / 255.0F - mr + this.rand.nextFloat() * mr) / 2;
        this.particleGreen = (c.getGreen() / 255.0F - mg + this.rand.nextFloat() * mg) / 2;
        this.particleBlue = (c.getBlue() / 255.0F - mb + this.rand.nextFloat() * mb) / 2;

        this.particleGravity = 0.2F;

        TextureAtlasSprite sprite = Minecraft.getMinecraft().getTextureMapBlocks().getAtlasSprite(texture.toString());
        this.setParticleTexture(sprite);

        try
        {
            Entity renderentity = FMLClientHandler.instance().getClient().getRenderViewEntity();
            int visibleDistance = 64;
            if (!FMLClientHandler.instance().getClient().gameSettings.fancyGraphics) {
                visibleDistance = 32;
            }
            if (renderentity.getDistance(this.posX, this.posY, this.posZ) > visibleDistance) {
                this.particleMaxAge = 0;
            }
        }
        catch (Exception e) {}
    }

    public void onUpdate(){

        this.prevPosX = this.posX;
        this.prevPosY = this.posY;
        this.prevPosZ = this.posZ;
        if (this.particleAge++ >= this.particleMaxAge){
            this.setExpired();
            return;
        }
        this.motionY += 0.01D * this.particleGravity;

        moveEntity(this.motionX, this.motionY, this.motionZ);

        this.motionX *= 0.985D;
        this.motionY *= 0.985D;
        this.motionZ *= 0.985D;

        this.motionX = MathHelper.clamp_float((float)this.motionX, -0.05F, 0.05F);
        this.motionY = MathHelper.clamp_float((float)this.motionY, -0.05F, 0.05F);
        this.motionZ = MathHelper.clamp_float((float)this.motionZ, -0.05F, 0.05F);

        double dx = this.targetX - this.posX;
        double dy = this.targetY - this.posY;
        double dz = this.targetZ - this.posZ;
        double d13 = 0.01D;
        double d11 = MathHelper.sqrt_double(dx * dx + dy * dy + dz * dz);
        if (d11 < 2.0D) {
            this.particleScale *= 0.98F;
        }
        if (this.particleScale < 0.2F){
            this.setExpired();
            return;
        }
        dx /= d11;
        dy /= d11;
        dz /= d11;

        this.motionX += dx * (d13 / Math.min(1.0D, d11));
        this.motionY += dy * (d13 / Math.min(1.0D, d11));
        this.motionZ += dz * (d13 / Math.min(1.0D, d11));


        float lifeCoeff = ((float)this.particleMaxAge-(float)this.particleAge)/(float)this.particleMaxAge;
        this.particleRed = Math.min(1.0f, (float)colorR*(1.5f-lifeCoeff)+lifeCoeff / 2);
        this.particleGreen = Math.min(1.0f, (float)colorG*(1.5f-lifeCoeff)+lifeCoeff / 2);
        this.particleBlue = Math.min(1.0f, (float)colorB*(1.5f-lifeCoeff)+lifeCoeff / 2);

    }

    public int getFXLayer(){
        return 1;
    }
}
