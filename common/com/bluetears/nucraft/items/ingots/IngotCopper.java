package com.bluetears.nucraft.items.ingots;

import com.bluetears.nucraft.NuCraftCore;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;

public class IngotCopper extends Item
{


public IngotCopper(int id)
{
         super(id);
         setCreativeTab(NuCraftCore.nuCraftCoreTab);
         setMaxStackSize(64);
         setUnlocalizedName("ingotCopper");
}

@Override
public void updateIcons(IconRegister iconRegister)
{
         iconIndex = iconRegister.registerIcon("nucraft:ingotCopper");
}

}
