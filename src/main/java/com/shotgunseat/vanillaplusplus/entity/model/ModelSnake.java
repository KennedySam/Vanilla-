package com.shotgunseat.vanillaplusplus.entity.model;// Cubik Studio 2.9.480 Beta JAVA exporter
// Designed by Br0shaan with Cubik Studio - https://cubik.studio

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelSnake extends ModelBase {

    //fields
    public ModelRenderer e1;
    public ModelRenderer e2;
    public ModelRenderer e3;
    public ModelRenderer e4;
    public ModelRenderer e5;
    public ModelRenderer e6;

    public ModelSnake()
    {
        textureWidth = 64;
        textureHeight = 64;

        e1 = new ModelRenderer(this, 0, 11);
        e1.setRotationPoint(-2F, 23.5F, -8.5F);
        e1.addBox(0F, -1F, 0F, 1, 1, 4);
        e1.setTextureSize(64, 64);
        e1.mirror = false;
        setRotation(e1, 0F, 0.4363323F, 0F);
        e2 = new ModelRenderer(this, 0, 11);
        e2.setRotationPoint(-2F, 23.5F, -12.5F);
        e2.addBox(0F, -1F, 0F, 1, 1, 4);
        e2.setTextureSize(64, 64);
        e2.mirror = false;
        setRotation(e2, 0F, 0F, 0F);
        e3 = new ModelRenderer(this, 0, 11);
        e3.setRotationPoint(-3.5F, 23.5F, -4.5F);
        e3.addBox(0F, -1F, 0F, 1, 1, 4);
        e3.setTextureSize(64, 64);
        e3.mirror = false;
        setRotation(e3, 0F, 5.67232F, 0F);
        e4 = new ModelRenderer(this, 0, 11);
        e4.setRotationPoint(-1.5F, 23.5F, -2F);
        e4.addBox(0F, -1F, 0F, 1, 1, 4);
        e4.setTextureSize(64, 64);
        e4.mirror = false;
        setRotation(e4, 0F, 0.2617994F, 0F);
        e5 = new ModelRenderer(this, 0, 11);
        e5.setRotationPoint(-2F, 23.5F, 1.5F);
        e5.addBox(0F, -1F, 0F, 1, 1, 4);
        e5.setTextureSize(64, 64);
        e5.mirror = false;
        setRotation(e5, 0F, 6.283185F, 0F);
        e6 = new ModelRenderer(this, 0, 8);
        e6.setRotationPoint(-2.5F, 23.5F, 4.5F);
        e6.addBox(0F, -1F, 0F, 2, 1, 2);
        e6.setTextureSize(64, 64);
        e6.mirror = false;
        setRotation(e6, 0F, 0F, 0F);
    }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
    {
        super.render(entity, f, f1, f2, f3, f4, f5);
        setRotationAngles(f, f1, f2, f3, f4, f5, entity);

        e1.render(f5);
        e2.render(f5);
        e3.render(f5);
        e4.render(f5);
        e5.render(f5);
        e6.render(f5);
    }

    private void setRotation(ModelRenderer model, float x, float y, float z)
    {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }
     
    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
    {
        super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    }
 
}