package com.bluetears.nucraft.items.ingots;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class IngotCopper extends Item
{


public IngotCopper(int id)
{
         super(id);
         setCreativeTab(CreativeTabs.tabMisc);
         setMaxStackSize(64);
         setUnlocalizedName("ingotCopper");
}

@Override
public void updateIcons(IconRegister iconRegister)
{
         iconIndex = iconRegister.registerIcon("nucraft:ingotCopper");
}

}
