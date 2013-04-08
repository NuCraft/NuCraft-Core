package com.bluetears.nucraft.items;

import com.bluetears.nucraft.NuCraftCore;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;

public class Sulfur extends Item
{


public Sulfur(int id)
{
         super(id);
         setCreativeTab(NuCraftCore.nuCraftCoreTab);
         setMaxStackSize(64);
         setUnlocalizedName("sulfur");
}

@Override
public void updateIcons(IconRegister iconRegister)
{
         iconIndex = iconRegister.registerIcon("nucraft:sulfur");
}

}
