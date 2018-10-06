package com.shotgunseat.vanillaplusplus.entity;

import com.shotgunseat.vanillaplusplus.block.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntityRabbit;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

/**
 * Created by Sam on 22/09/2018.
 */
public class EntitySnake extends EntityAnimal {

    //TODO give sounds https://freesound.org/people/columbia23/sounds/395396/

    protected Block spawnableBlock = ModBlocks.redSandySoil;

    public EntitySnake(World worldIn) {
        super(worldIn);
        this.setSize(0.9F, 1.4F);
    }

    @Override
    protected void initEntityAI()
    {
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(1, new EntityAILeapAtTarget(this, 0.2F));
        this.tasks.addTask(2, new EntityAIAttackMelee(this, 1.0D, true));
        this.tasks.addTask(3, new EntityAIFollowParent(this, 1.25D));
        this.tasks.addTask(4, new EntityAIWander(this, 1.0D));
        this.tasks.addTask(5, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
        this.tasks.addTask(6, new EntityAILookIdle(this));
        this.targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntityRabbit.class, true));
    }

    @Override
    public EntitySnake createChild(EntityAgeable ageable) {
        return new EntitySnake(worldObj);
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.ENTITY_SILVERFISH_AMBIENT;
    }

    @Override
    protected SoundEvent getHurtSound() {
        return SoundEvents.ENTITY_SILVERFISH_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_SILVERFISH_DEATH;
    }

    @Override
    public void setAIMoveSpeed(float speedIn) {
        super.setAIMoveSpeed(speedIn);
    }
}


