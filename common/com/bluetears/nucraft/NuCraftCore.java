package com.bluetears.nucraft;

import Machines.TestMachine;
import Machines.TestWire;

import com.bluetears.nucraft.blocks.OreBauxite;
import com.bluetears.nucraft.blocks.OreCopper;
import com.bluetears.nucraft.blocks.OreFafnium;
import com.bluetears.nucraft.blocks.OreGraphite;
import com.bluetears.nucraft.blocks.OreGuiltalium;
import com.bluetears.nucraft.blocks.OreLead;
import com.bluetears.nucraft.blocks.OreOnyxstone;
import com.bluetears.nucraft.blocks.OreQuartz;
import com.bluetears.nucraft.blocks.OreSilicate;
import com.bluetears.nucraft.blocks.OreSilver;
import com.bluetears.nucraft.blocks.OreSulfur;
import com.bluetears.nucraft.blocks.OreTin;
import com.bluetears.nucraft.blocks.OreUnobtainium;
import com.bluetears.nucraft.items.Graphite;
import com.bluetears.nucraft.items.Quartz;
import com.bluetears.nucraft.items.Silicate;
import com.bluetears.nucraft.items.Sulfur;
import com.bluetears.nucraft.items.ingots.IngotCopper;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.oredict.OreDictionary;


import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid="NuCraftCore", name="NuCraftCore", version="0.0.1")
@NetworkMod(clientSideRequired=true, serverSideRequired=false)
public class NuCraftCore {

        // The instance of your mod that Forge uses.
        @Instance("NuCraftCore")
        public static NuCraftCore instance;
        
        //Below is the code for generating all of the blocks
        
        
        
        // Says where the client and server 'proxy' code is loaded.
        @SidedProxy(clientSide="com.bluetears.nucraft.client.ClientProxy", serverSide="com.bluetears.nucraft.CommonProxy")
        public static CommonProxy proxy;
        
        @PreInit
        public void preInit(FMLPreInitializationEvent event) {
               
        	Configuration config = new Configuration(event.getSuggestedConfigurationFile());

            config.load();

            startBlockId = config.getBlock("Starting Block Id", 500).getInt();

            startItemId = config.getItem("Starting Item Id", 20000).getInt();

            // Config file setup!
            bauxiteFlag = config.get(Configuration.CATEGORY_GENERAL, "Bauxite Ore Generation Flag", false).getBoolean(false);
            copperFlag = config.get(Configuration.CATEGORY_GENERAL, "Copper Ore Generation Flag", false).getBoolean(false);
            leadFlag = config.get(Configuration.CATEGORY_GENERAL, "Lead Ore Generation Flag", false).getBoolean(false);
            quartzFlag = config.get(Configuration.CATEGORY_GENERAL, "Quartz Ore Generation Flag", false).getBoolean(false);
            silverFlag = config.get(Configuration.CATEGORY_GENERAL, "Silver Ore Generation Flag", false).getBoolean(false);
            sulfurFlag = config.get(Configuration.CATEGORY_GENERAL, "Sulfur Ore Generation Flag", false).getBoolean(false);
            tinFlag = config.get(Configuration.CATEGORY_GENERAL, "Tin Ore Generation Flag", false).getBoolean(false);
            
            



            config.save();
        	
        }
        
        @Init
        
        public void load(FMLInitializationEvent event) {
        	
        	createBlocks();
        	createItems();
        	registerBlocks();
        	setHarvestLevel();
        	addNames();
        	oreDictionary();
            
            GameRegistry.registerWorldGenerator(new NuCraftWorldGenerator(copperFlag,tinFlag,leadFlag,bauxiteFlag,quartzFlag,silverFlag,sulfurFlag));
            
                proxy.registerRenderers();
        }
        
        @PostInit
        public void postInit(FMLPostInitializationEvent event) {
                // Stub Method
        }
        
        public static void registerBlocks(){
        	GameRegistry.registerBlock(oreBauxite, "oreBauxite");
        	GameRegistry.registerBlock(oreCopper, "oreCopper");
        	GameRegistry.registerBlock(oreFafnium, "oreFafnium");
        	GameRegistry.registerBlock(oreGraphite, "oreGraphite");
        	GameRegistry.registerBlock(oreGuiltalium, "oreGuiltalium");
        	GameRegistry.registerBlock(oreLead, "oreLead");
        	GameRegistry.registerBlock(oreOnyxstone, "oreOnyxstone");
        	GameRegistry.registerBlock(oreQuartz, "oreQuartz");
        	GameRegistry.registerBlock(oreSilicate, "oreSilicate");
        	GameRegistry.registerBlock(oreSilver, "oreSilver");
        	GameRegistry.registerBlock(oreSulfur, "oreSulfur");
        	GameRegistry.registerBlock(oreTin, "oreTin");
        	GameRegistry.registerBlock(oreUnobtainium, "oreUnobtainium");
        //	GameRegistry.registerBlock(droppableOresMultiBlock, DroppableOresItemBlock.class);
        	
        	GameRegistry.registerBlock(testMachine, "testMachine");
        	GameRegistry.registerBlock(testWire, "testWire");
        }
        
        public static void setHarvestLevel(){
        	MinecraftForge.setBlockHarvestLevel(oreBauxite, "pickaxe", 2);
        	MinecraftForge.setBlockHarvestLevel(oreCopper, "pickaxe", 2);
        	MinecraftForge.setBlockHarvestLevel(oreFafnium, "pickaxe", 2);
        	MinecraftForge.setBlockHarvestLevel(oreGraphite, "pickaxe", 2);
        	MinecraftForge.setBlockHarvestLevel(oreGuiltalium, "pickaxe", 2);
        	MinecraftForge.setBlockHarvestLevel(oreLead, "pickaxe", 2);
        	MinecraftForge.setBlockHarvestLevel(oreOnyxstone, "pickaxe", 2);
        	MinecraftForge.setBlockHarvestLevel(oreQuartz, "pickaxe", 2);
        	MinecraftForge.setBlockHarvestLevel(oreSilicate, "pickaxe", 2);
        	MinecraftForge.setBlockHarvestLevel(oreSilver, "pickaxe", 2);
        	MinecraftForge.setBlockHarvestLevel(oreSulfur, "pickaxe", 2);
        	MinecraftForge.setBlockHarvestLevel(oreTin, "pickaxe", 2);
        	MinecraftForge.setBlockHarvestLevel(oreUnobtainium, "pickaxe", 2);
        	
        }
        
        public static void createBlocks(){
        	oreBauxite = new OreBauxite(startBlockId+1, Material.iron);
        	oreCopper = new OreCopper(startBlockId+2, Material.iron);
        	oreFafnium = new OreFafnium(startBlockId+3, Material.iron);
        	oreGraphite = new OreGraphite(startBlockId+4, Material.iron);
        	oreGuiltalium = new OreGuiltalium(startBlockId+5, Material.iron);
        	oreLead = new OreLead(startBlockId+6, Material.iron);
        	oreOnyxstone = new OreOnyxstone(startBlockId+7, Material.iron);
        	oreQuartz = new OreQuartz(startBlockId+8, Material.iron);
        	oreSilicate = new OreSilicate(startBlockId+9, Material.iron);
        	oreSilver = new OreSilver(startBlockId+10, Material.iron);
        	oreSulfur = new OreSulfur(startBlockId+11, Material.iron);
        	oreTin = new OreTin(startBlockId+12, Material.iron);
        	oreUnobtainium = new OreUnobtainium(startBlockId+13, Material.iron);
        	
        	
        	testMachine = new TestMachine(startBlockId+14, Material.iron);
        	testWire = new TestWire(startBlockId+15, Material.iron);
        	
        	//droppableOresMultiBlock = new DroppableOresMultiBlock(startBlockId);
        }
        
        public static void createItems(){
        	
        	silicate = new Silicate(startItemId);
        	quartz = new Quartz(startItemId+1);
        	graphite = new Graphite(startItemId+2);
        	sulfur = new Sulfur(startItemId+3);
        	ingotCopper = new IngotCopper(startItemId+4);
        	
        }
        
        public static void addNames(){
        	
        	//Adding of names for the Blocks
        	LanguageRegistry.addName(oreBauxite, "Bauxite Ore");
        	LanguageRegistry.addName(oreCopper, "Copper Ore");
        	LanguageRegistry.addName(oreFafnium, "Fafnium Ore");
        	LanguageRegistry.addName(oreGraphite, "Graphite Ore");
        	LanguageRegistry.addName(oreGuiltalium, "Guiltalium Ore");
        	LanguageRegistry.addName(oreLead, "Lead Ore");
        	LanguageRegistry.addName(oreOnyxstone, "Onyxstone Ore");
        	LanguageRegistry.addName(oreQuartz, "Quartz Ore");
        	LanguageRegistry.addName(oreSilicate, "Silicate Ore");
        	LanguageRegistry.addName(oreSilver, "Silver Ore");
        	LanguageRegistry.addName(oreSulfur, "Sulfur Ore");
        	LanguageRegistry.addName(oreTin, "Tin Ore");
        	LanguageRegistry.addName(oreUnobtainium, "Unobtainium Ore");
        	
        	
        	//Adding of Names for the Items
        	LanguageRegistry.addName(silicate, "Silicate");
        	LanguageRegistry.addName(quartz, "Quartz");
        	LanguageRegistry.addName(graphite, "Graphite");
        	LanguageRegistry.addName(sulfur, "Sulfur");
        	LanguageRegistry.addName(ingotCopper,"Copper Ingot");
        	
        	//for (int ix = 0; ix < 9; ix++) {
    		//	ItemStack multiBlockStack = new ItemStack(droppableOresMultiBlock, 1, ix);
    		//	LanguageRegistry.addName(multiBlockStack, droppableOresNames[multiBlockStack.getItemDamage()]);
    		//}
        }
        
        public static void oreDictionary(){
        	
        	OreDictionary.registerOre("copperIngot", new ItemStack(ingotCopper));
        	OreDictionary.registerOre("ingotCopper", new ItemStack(ingotCopper));
        	
        }
        
        public static CreativeTabs nuCraftCoreTab = new CreativeTabs("nuCraftCoreTab") {
            public ItemStack getIconItemStack() {
                    return new ItemStack(oreGuiltalium);
            }
        };
   
        //The following is the creation for the item reservations
        public static Item silicate;
        public static Item quartz;
        public static Item graphite;
        public static Item sulfur;
        public static Item ingotCopper;
        
        //The following is for the creation for the block reservations
        public static Block oreBauxite;
        public static Block oreCopper;
        public static Block oreFafnium;
        public static Block oreGraphite;
        public static Block oreGuiltalium;
        public static Block oreLead;
        public static Block oreOnyxstone;
        public static Block oreQuartz;
        public static Block oreSilicate;
        public static Block oreSilver;
        public static Block oreSulfur;
        public static Block oreTin;
        public static Block oreUnobtainium;
        public static Block droppableOresMultiBlock;
        
        
        public static Block testMachine;
        public static Block testWire;
        
        //Extra Variables that "Drive" the mod
        public static int startItemId = 20000;
        public static int startBlockId = 500;
        public static boolean copperFlag,tinFlag,leadFlag,bauxiteFlag,quartzFlag,silverFlag,sulfurFlag;
        
        //The following is the string for the multi-block that represents the blocks that drop themselves
        public static String[] droppableOresNames = {"Bauxite Ore","Copper Ore","Fafnium Ore","Guiltalium Ore","Lead Ore","Onyxstone Ore","Silver Ore","Tin Ore","Unobtainium Ore"};
   
        
}


