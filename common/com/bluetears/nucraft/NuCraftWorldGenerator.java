package com.bluetears.nucraft;

import java.util.Random;

import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import cpw.mods.fml.common.IWorldGenerator;

public class NuCraftWorldGenerator implements IWorldGenerator{
	
	public static boolean copperFlag,tinFlag,leadFlag,bauxiteFlag,quartzFlag,silverFlag,sulfurFlag,aluminiumFlag;
	
	NuCraftWorldGenerator(boolean copperFlag,boolean tinFlag,boolean leadFlag,boolean bauxiteFlag,boolean quartzFlag,boolean silverFlag,boolean sulfurFlag,boolean aluminiumFlag){
		this.copperFlag = copperFlag;
		this.tinFlag = tinFlag;
		this.leadFlag = leadFlag;
		this.bauxiteFlag = bauxiteFlag;
		this.quartzFlag = quartzFlag;
		this.silverFlag = silverFlag;
		this.sulfurFlag = sulfurFlag;
		this.aluminiumFlag = aluminiumFlag;
	}

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
		
		for(int k = 0; k < 2; k++){
        	int firstBlockXCoord = chunkX + random.nextInt(16);
        	int firstBlockYCoord = random.nextInt(32)+32;
        	int firstBlockZCoord = chunkZ + random.nextInt(16);
        	
        	(new NuCraftEndGenerator(NuCraftCore.oreUnobtainium.blockID, 2)).generate(world, random, firstBlockXCoord, firstBlockYCoord, firstBlockZCoord);
        }
		
	}

	private void generateSurface(World world, Random random, int chunkX, int chunkZ) {
		
		if (sulfurFlag){
			for(int k = 0; k < 8; k++){
	        	int firstBlockXCoord = chunkX + random.nextInt(16);
	        	int firstBlockYCoord = random.nextInt(32);
	        	int firstBlockZCoord = chunkZ + random.nextInt(16);
	        	
	        	(new WorldGenMinable(NuCraftCore.oreSulfur.blockID, 7)).generate(world, random, firstBlockXCoord, firstBlockYCoord, firstBlockZCoord);
	        }
			}
		
		if (tinFlag){
			for(int k = 0; k < 4; k++){
	        	int firstBlockXCoord = chunkX + random.nextInt(16);
	        	int firstBlockYCoord = random.nextInt(38)+16;
	        	int firstBlockZCoord = chunkZ + random.nextInt(16);
	        	
	        	(new WorldGenMinable(NuCraftCore.oreTin.blockID, 7)).generate(world, random, firstBlockXCoord, firstBlockYCoord, firstBlockZCoord);
	        }
			}
		
		if (copperFlag){
		for(int k = 0; k < 4; k++){
        	int firstBlockXCoord = chunkX + random.nextInt(16);
        	int firstBlockYCoord = random.nextInt(38)+32;
        	int firstBlockZCoord = chunkZ + random.nextInt(16);
        	
        	(new WorldGenMinable(NuCraftCore.oreCopper.blockID, 7)).generate(world, random, firstBlockXCoord, firstBlockYCoord, firstBlockZCoord);
        }
		}
		
		if (aluminiumFlag){
			for(int k = 0; k < 3; k++){
	        	int firstBlockXCoord = chunkX + random.nextInt(16);
	        	int firstBlockYCoord = random.nextInt(32)+16;
	        	int firstBlockZCoord = chunkZ + random.nextInt(16);
	        	
	        	(new WorldGenMinable(NuCraftCore.oreAluminium.blockID, 7)).generate(world, random, firstBlockXCoord, firstBlockYCoord, firstBlockZCoord);
	        }
			}
		
		if (bauxiteFlag){
			for(int k = 0; k < 4; k++){
	        	int firstBlockXCoord = chunkX + random.nextInt(16);
	        	int firstBlockYCoord = random.nextInt(48)+16;
	        	int firstBlockZCoord = chunkZ + random.nextInt(16);
	        	
	        	(new WorldGenMinable(NuCraftCore.oreBauxite.blockID, 8)).generate(world, random, firstBlockXCoord, firstBlockYCoord, firstBlockZCoord);
	        }
			}
		
			for(int k = 0; k < 3; k++){
	        	int firstBlockXCoord = chunkX + random.nextInt(16);
	        	int firstBlockYCoord = random.nextInt(48);
	        	int firstBlockZCoord = chunkZ + random.nextInt(16);
	        	
	        	(new WorldGenMinable(NuCraftCore.oreGraphite.blockID, 7)).generate(world, random, firstBlockXCoord, firstBlockYCoord, firstBlockZCoord);
	        }
			
				for(int k = 0; k < 1; k++){
		        	int firstBlockXCoord = chunkX + random.nextInt(16);
		        	int firstBlockYCoord = random.nextInt(5)+13;
		        	int firstBlockZCoord = chunkZ + random.nextInt(16);
		        	
		        	(new WorldGenMinable(NuCraftCore.oreGuiltalium.blockID, 2)).generate(world, random, firstBlockXCoord, firstBlockYCoord, firstBlockZCoord);
		        }
				
				if (leadFlag){
					for(int k = 0; k < 3; k++){
			        	int firstBlockXCoord = chunkX + random.nextInt(16);
			        	int firstBlockYCoord = random.nextInt(32);
			        	int firstBlockZCoord = chunkZ + random.nextInt(16);
			        	
			        	(new WorldGenMinable(NuCraftCore.oreLead.blockID, 7)).generate(world, random, firstBlockXCoord, firstBlockYCoord, firstBlockZCoord);
			        }
					}
				
				if (quartzFlag){
					for(int k = 0; k < 3; k++){
			        	int firstBlockXCoord = chunkX + random.nextInt(16);
			        	int firstBlockYCoord = random.nextInt(48);
			        	int firstBlockZCoord = chunkZ + random.nextInt(16);
			        	
			        	(new WorldGenMinable(NuCraftCore.oreQuartz.blockID, 5)).generate(world, random, firstBlockXCoord, firstBlockYCoord, firstBlockZCoord);
			        }
					}
				
					for(int k = 0; k < 4; k++){
			        	int firstBlockXCoord = chunkX + random.nextInt(16);
			        	int firstBlockYCoord = random.nextInt(48);
			        	int firstBlockZCoord = chunkZ + random.nextInt(16);
			        	
			        	(new WorldGenMinable(NuCraftCore.oreSilicate.blockID, 4)).generate(world, random, firstBlockXCoord, firstBlockYCoord, firstBlockZCoord);
			        }
					
					if (silverFlag){
						for(int k = 0; k < 3; k++){
				        	int firstBlockXCoord = chunkX + random.nextInt(16);
				        	int firstBlockYCoord = random.nextInt(32);
				        	int firstBlockZCoord = chunkZ + random.nextInt(16);
				        	
				        	(new WorldGenMinable(NuCraftCore.oreSilver.blockID, 6)).generate(world, random, firstBlockXCoord, firstBlockYCoord, firstBlockZCoord);
				        }
						}
        
	}

	private void generateNether(World world, Random random, int chunkX, int chunkZ) {
		
		for(int k = 0; k < 4; k++){
        	int firstBlockXCoord = chunkX + random.nextInt(16);
        	int firstBlockYCoord = random.nextInt(96)+16;
        	int firstBlockZCoord = chunkZ + random.nextInt(16);
        	
        	(new NuCraftNetherGenerator(NuCraftCore.oreFafnium.blockID, 4)).generate(world, random, firstBlockXCoord, firstBlockYCoord, firstBlockZCoord);
        }
		
		for(int k = 0; k < 20; k++){
        	int firstBlockXCoord = chunkX + random.nextInt(16);
        	int firstBlockYCoord = random.nextInt(36);
        	int firstBlockZCoord = chunkZ + random.nextInt(16);
        	
        	(new NuCraftNetherGenerator(NuCraftCore.oreOnyxstone.blockID, 12)).generate(world, random, firstBlockXCoord, firstBlockYCoord, firstBlockZCoord);
        }
		
	}

}
