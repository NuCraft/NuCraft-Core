package Machines;

import net.minecraft.world.World;

public class PowerLink {
	
	private World world;
	private int sourceX;
	private int sourceY;
	private int sourceZ;
	private double loss;
	
	public PowerLink(World par1World, int par2, int par3, int par4)
	{
		world = par1World;
		sourceX = par2;
		sourceY = par3;
		sourceZ = par4;
	}
	

}
