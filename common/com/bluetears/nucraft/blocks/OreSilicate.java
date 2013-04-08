package com.bluetears.nucraft.blocks;

import java.util.Random;

import com.bluetears.nucraft.NuCraftCore;


import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;

public class OreSilicate extends Block {

        public OreSilicate (int id, Material material) {
                super(id, material);
                setHardness(4.0F); // 33% harder than diamond
                setStepSound(Block.soundStoneFootstep);
                setCreativeTab(NuCraftCore.nuCraftCoreTab);
                setUnlocalizedName("oreSilicate");
        }
        
        public void registerIcons(IconRegister par1IconRegister)
        {
                 this.blockIcon = par1IconRegister.registerIcon("nucraft:oreSilicate");
        }

        
        public int idDropped(int par1, Random random, int par2) {
            return NuCraftCore.silicate.itemID;
    }
        
        public int quantityDropped(Random par1Random){
        	return par1Random.nextInt(3)+1;
        }
        }
