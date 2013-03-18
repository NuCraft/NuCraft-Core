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
}

@Override
public void func_94581_a(IconRegister iconRegister)
{
         iconIndex = iconRegister.func_94245_a("nucraft:silicate");
}

}