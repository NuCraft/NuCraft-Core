package com.bluetears.nucraft.items;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class Silicate extends Item
{


public Silicate(int id)
{
         super(id);
         setCreativeTab(CreativeTabs.tabMisc);
         setMaxStackSize(64);
         setUnlocalizedName("silicate");
}

@Override
public void updateIcons(IconRegister iconRegister)
{
         iconIndex = iconRegister.registerIcon("nucraft:silicate");
}

}
