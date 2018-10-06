package com.shotgunseat.vanillaplusplus.tileentity;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ITickable;

/**
 * Created by Sam on 11/09/2018.
 */
public class TileEntityBarrel extends TileEntity implements ITickable {

    private static final int capacity = 12; //bottles, 3 bottles = 1 bucket

    private int volume;

    public TileEntityBarrel() {
        this.volume = 0;
    }

    @Override
    public void readFromNBT(NBTTagCompound compound) {
        this.volume = compound.getInteger("volume");
        super.readFromNBT(compound);
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound) {
        compound.setInteger("volume", this.volume);
        return super.writeToNBT(compound);
    }

    @Override
    public void update() {
    }
}
