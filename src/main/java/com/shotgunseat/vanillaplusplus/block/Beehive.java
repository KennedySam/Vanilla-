package com.shotgunseat.vanillaplusplus.block;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Random;

/**
 * Created by Sam on 08/09/2018.
 */
public class Beehive extends Block {

    private float honeyAmount;
    private int nOfBees;

    public Beehive(Material materialIn, String name) {
        super(materialIn);
        this.setUnlocalizedName(name);
        this.setCreativeTab(CreativeTabs.MISC);
        this.setHardness(2.0F);
        this.setResistance(3.0F);
        this.setSoundType(SoundType.PLANT);
        this.setTickRandomly(true);

        this.nOfBees = 10;
        honeyAmount = 10F;

    }

    public int tickRate(World worldIn)
    {
        return 30;
    }

    @Override
    public void onEntityCollidedWithBlock(World worldIn, BlockPos pos, IBlockState state, Entity entityIn)
    {
        entityIn.attackEntityFrom(DamageSource.cactus, 1.0F);
    }

    @Override
    public void onBlockClicked(World worldIn, BlockPos pos, EntityPlayer playerIn) {
        if (this.nOfBees > 0) {
            playerIn.attackEntityFrom(DamageSource.cactus, 1.0F);
        }
    }

    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, @Nullable ItemStack heldItem, EnumFacing side, float hitX, float hitY, float hitZ) {
        playerIn.attackEntityFrom(DamageSource.cactus, 1.0F);
        if (heldItem == null) {
            return false;
        }
        if (!Items.GLASS_BOTTLE.equals(heldItem.getItem())) {
            return false;
        }
        if (this.honeyAmount < 10F) {
            playerIn.addChatComponentMessage(new TextComponentTranslation("There isn't enough honey in the hive."));
            System.out.println(this.honeyAmount);
            return false;
        }
        playerIn.setHeldItem(hand, new ItemStack(Items.BAKED_POTATO));
        this.honeyAmount = 0F;
        return true;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void randomDisplayTick(IBlockState stateIn, World worldIn, BlockPos pos, Random rand)
    {
        if (this.nOfBees == 0) {
            return;
        }

        if (this.honeyAmount < 10F) {
            this.honeyAmount += 0.001F;
        }

        this.spawnParticles(worldIn, pos);

        List<EntityLivingBase> nearbyEntities = worldIn.getEntitiesWithinAABB(EntityLivingBase.class,
                new AxisAlignedBB(pos.getX()-3.0F, pos.getY()-3.0F, pos.getZ()-3.0F,
                        pos.getX()+3.0F, pos.getY()+3.0F, pos.getZ()+3.0F
                )
        );
        for (EntityLivingBase entity : nearbyEntities) {
            //Doesn't work?
            entity.attackEntityFrom(DamageSource.generic, 1.0F);
        }
    }

    private void spawnParticles(World worldIn, BlockPos pos)
    {
        Random random = worldIn.rand;
        double d0 = 0.0625D;

        for (int i = 0; i < this.nOfBees; ++i)
        {
            double d1 = (double)((float)pos.getX() + random.nextFloat());
            double d2 = (double)((float)pos.getY() + random.nextFloat());
            double d3 = (double)((float)pos.getZ() + random.nextFloat());

            if (i == 0 && !worldIn.getBlockState(pos.up()).isOpaqueCube())
            {
                d2 = (double)pos.getY() + 0.0625D + 1.0D;
            }

            if (i == 1 && !worldIn.getBlockState(pos.down()).isOpaqueCube())
            {
                d2 = (double)pos.getY() - 0.0625D;
            }

            if (i == 2 && !worldIn.getBlockState(pos.south()).isOpaqueCube())
            {
                d3 = (double)pos.getZ() + 0.0625D + 1.0D;
            }

            if (i == 3 && !worldIn.getBlockState(pos.north()).isOpaqueCube())
            {
                d3 = (double)pos.getZ() - 0.0625D;
            }

            if (i == 4 && !worldIn.getBlockState(pos.east()).isOpaqueCube())
            {
                d1 = (double)pos.getX() + 0.0625D + 1.0D;
            }

            if (i == 5 && !worldIn.getBlockState(pos.west()).isOpaqueCube())
            {
                d1 = (double)pos.getX() - 0.0625D;
            }

            if (d1 < (double)pos.getX() || d1 > (double)(pos.getX() + 1) || d2 < 0.0D || d2 > (double)(pos.getY() + 1) || d3 < (double)pos.getZ() || d3 > (double)(pos.getZ() + 1))
            {
                worldIn.spawnParticle(EnumParticleTypes.TOWN_AURA, d1, d2, d3, 0.0D, 0.0D, 0.0D, new int[0]);
            }
        }
    }
}
