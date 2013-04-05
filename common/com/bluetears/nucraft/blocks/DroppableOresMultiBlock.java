package com.bluetears.nucraft.blocks;

import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.block.material.Material;

public class DroppableOresMultiBlock extends Block {
	public DroppableOresMultiBlock (int id) {
		super(id, Material.iron);
		setUnlocalizedName("multiBlock");
		setCreativeTab(CreativeTabs.tabBlock);
	}
	
	@Override
	public int getBlockTextureFromSideAndMetadata (int side, int metadata) {
		return 16 + metadata;
	}
	
	@Override
	public String getTextureFile () {
		return CommonProxy.BLOCK_PNG;
	}
	
	@Override
	public int damageDropped (int metadata) {
		return metadata;
	}
	
	
	public void getSubBlocks(int par1, CreativeTabs tab, List subItems) {
		for (int ix = 0; ix < 9; ix++) {
			subItems.add(new ItemStack(this, 1, ix));
		}
	}
}