package Machines;

import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.world.World;

public class TestMachine extends MachineBase{

	public TestMachine(int par1, Material par2Material) {
		super(par1, par2Material);
		setCreativeTab(CreativeTabs.tabBlock);
	}
	
	
	public void update(World par1World, int par2, int par3, int par4) 
	{
		System.out.println("It made it here");
		super.update(par1World, par2, par3, par4);
	}
	
	@Override
	public void onNeighborBlockChange(World par1World, int par2, int par3, int par4, int par5)
	{
		super.onNeighborBlockChange(par1World, par2, par3, par4, par5);
		update(par1World, par2, par3, par4);
	}
}

