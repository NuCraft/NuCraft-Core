package com.bluetears.nucraft.items;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class Graphite extends Item
{


public Graphite(int id)
{
         super(id);
         setCreativeTab(CreativeTabs.tabMisc);
         setMaxStackSize(64);
}

@Override
public void updateIcons(IconRegister iconRegister)
{
         iconIndex = iconRegister.registerIcon("nucraft:graphite");
}

}
