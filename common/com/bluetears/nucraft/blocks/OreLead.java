package com.bluetears.nucraft.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;

public class OreLead extends Block {

        public OreLead (int id, Material material) {
                super(id, material);
                setHardness(4.0F); // 33% harder than diamond
                setStepSound(Block.soundStoneFootstep);
                setCreativeTab(CreativeTabs.tabBlock);
                setUnlocalizedName("oreLead");
        }
        
        public void registerIcons(IconRegister par1IconRegister)
        {
                 this.blockIcon = par1IconRegister.registerIcon("nucraft:oreLead");
        }

        
        
}