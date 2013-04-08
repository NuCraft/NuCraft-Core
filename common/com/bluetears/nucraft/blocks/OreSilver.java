package com.bluetears.nucraft.blocks;

import com.bluetears.nucraft.NuCraftCore;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;

public class OreSilver extends Block {

        public OreSilver (int id, Material material) {
                super(id, material);
                setHardness(4.0F); // 33% harder than diamond
                setStepSound(Block.soundStoneFootstep);
                setCreativeTab(NuCraftCore.nuCraftCoreTab);
                setUnlocalizedName("oreSilver");
        }
        
        public void registerIcons(IconRegister par1IconRegister)
        {
                 this.blockIcon = par1IconRegister.registerIcon("nucraft:oreSilver");
        }

        
        
}