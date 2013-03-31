package com.bluetears.nucraft.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;

public class OreUnobtainium extends Block {

        public OreUnobtainium (int id, Material material) {
                super(id, material);
                setHardness(4.0F); // 33% harder than diamond
                setStepSound(Block.soundStoneFootstep);
                setCreativeTab(CreativeTabs.tabBlock);
                setUnlocalizedName("oreUnobtainium");
        }
        
        public void registerIcons(IconRegister par1IconRegister)
        {
                 this.blockIcon = par1IconRegister.registerIcon("nucraft:oreUnobtainium");
        }

        
        
}