package com.bluetears.nucraft;

import java.util.Random;

import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import cpw.mods.fml.common.IWorldGenerator;

public class NuCraftWorldGenerator implements IWorldGenerator{

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world,
			IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		switch(world.provider.dimensionId){
		case -1:
		    generateNether(world, random, chunkX * 16, chunkZ * 16);
		    break;
		case 0:
		    generateSurface(world, random, chunkX * 16, chunkZ * 16);
		    break;
		case 1:
		    generateEnd(world, random, chunkX * 16, chunkZ * 16);
		    break;
		}
		
	}
	
	private void generateEnd(World world, Random random, int chunkX, int chunkZ) {
		
		for(int k = 0; k < 10; k++){
        	int firstBlockXCoord = chunkX + random.nextInt(16);
        	int firstBlockYCoord = random.nextInt(64);
        	int firstBlockZCoord = chunkZ + random.nextInt(16);
        	
        	(new WorldGenMinable(NuCraftCore.unobtainiumOre.blockID, 13)).generate(world, random, firstBlockXCoord, firstBlockYCoord, firstBlockZCoord);
        }
		
	}

	private void generateSurface(World world, Random random, int chunkX, int chunkZ) {
		
		for(int k = 0; k < 10; k++){
        	int firstBlockXCoord = chunkX + random.nextInt(16);
        	int firstBlockYCoord = random.nextInt(64);
        	int firstBlockZCoord = chunkZ + random.nextInt(16);
        	
        	(new WorldGenMinable(NuCraftCore.silicateOre.blockID, 3)).generate(world, random, firstBlockXCoord, firstBlockYCoord, firstBlockZCoord);
        }
		
		
		for(int k = 0; k < 10; k++){
        	int firstBlockXCoord = chunkX + random.nextInt(16);
        	int firstBlockYCoord = random.nextInt(64);
        	int firstBlockZCoord = chunkZ + random.nextInt(16);
        	
        	(new WorldGenMinable(NuCraftCore.copperOre.blockID, 7)).generate(world, random, firstBlockXCoord, firstBlockYCoord, firstBlockZCoord);
        }
        
	}

	private void generateNether(World world, Random random, int i, int j) {
		
	}

}
