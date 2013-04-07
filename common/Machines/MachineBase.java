package Machines;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.world.World;

public class MachineBase extends Block{
	
	public int charge;
	public int Vmax;
	private int voltage;
	public boolean cycle = false;
	

	public MachineBase(int par1, Material par2Material) {
		super(par1, Material.iron);
	}
	
	public static final boolean isMachineBlock(int par0)
    {
        return Block.blocksList[par0] instanceof MachineBase;
    }
	
	public void update(World par1World, int par2, int par3, int par4, boolean cycle)
	{
		if(this.cycle != cycle)
		{
			this.update(par1World, par2, par3, par4);
		}
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
					if(WireBase.isWireBlock(par1World.getBlockId(x, y, z)))
					{
						if( x != par2 && y != par3 && z != par4)
						{
							/* update power link*/
							//update(par1World, x, y, z, this.cycle);
						}
					}
				}
			}
		}
	}

}


