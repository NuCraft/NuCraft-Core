package com.bluetears.nucraft;

import net.minecraft.block.Block;
import net.minecraft.world.gen.feature.WorldGenMinable;

public class AlternateNetherGen extends WorldGenMinable
{
    public AlternateNetherGen(int par1, int par2)
    {
        super(par1, par2, Block.lavaStill.blockID);
    }

    
}
