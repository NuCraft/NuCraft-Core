package com.bluetears.nucraft.blocks;

import java.util.Random;

import com.bluetears.nucraft.NuCraftCore;


import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;

public class OreGraphite extends Block {

        public OreGraphite (int id, Material material) {
                super(id, material);
                setHardness(4.0F); // 33% harder than diamond
                setStepSound(Block.soundStoneFootstep);
                setCreativeTab(NuCraftCore.nuCraftCoreTab);
                setUnlocalizedName("oreGraphite");
        }
        
        public void registerIcons(IconRegister par1IconRegister)
        {
                 this.blockIcon = par1IconRegister.registerIcon("nucraft:oreGraphite");
        }

        
        public int idDropped(int par1, Random random, int par2) {
            return NuCraftCore.graphite.itemID;
    }
}