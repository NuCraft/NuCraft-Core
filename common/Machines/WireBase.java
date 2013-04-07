package Machines;

import java.util.ArrayList;

import net.minecraft.block.Block;
import net.minecraft.block.BlockRailBase;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class WireBase extends Block{
	
	private int voltage;
	private int Vmax;
	public ArrayList[] links= new ArrayList[0];
	public boolean cycle= false;

	public WireBase(int par1, Material par2Material) {
		super(par1, Material.circuits);
	}

	public static final boolean isWireBlock(int par0)
    {
        return Block.blocksList[par0] instanceof WireBase;
    }
	
	
	public void onBlockDestroyedByPlayer(World par1World, int par2, int par3, int par4, int par5)
	{
		super.onBlockDestroyedByPlayer(par1World, par2, par3, par4, par5);
		update(par1World, par2, par3, par4);
	}

	public void onBlockAdded(World par1World, int par2, int par3, int par4)
	{
		super.onBlockAdded(par1World, par2, par3, par4);
		update(par1World, par2, par3, par4);
	}

	public void update(World par1World, int par2, int par3, int par4) 
	{
		if( cycle)
		{
			cycle = false;
		}
		else
		{
			cycle = true;
		}
		int x;
		int y;
		int z;
		
		for( z = par4-1; z < par4+2; z++)
		{
			for( y = par3-1; y < par4+2; y++)
			{
				for( x = par2-1; x < par2+2; x++)
				{
					if(isWireBlock(par1World.getBlockId(x, y, z)))
					{
						if( x != par2 && y != par3 && z != par4)
						{
							update(par1World, x, y, z, this.cycle);
						}
					}
					else if (MachineBase.isMachineBlock(par1World.getBlockId(x, y, z)))
					{
						//par1World.
						//MachineBase.update(par1World, x, y, z, this.cycle);
					}
				}
			}
		}
	}
	
	public void update(World par1World, int par2, int par3, int par4, boolean cycle)
	{
		if(this.cycle != cycle)
		{
			this.update(par1World, par2, par3, par4);
		}
	}
	
	
	
	
}
