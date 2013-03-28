package com.bluetears.nucraft;




import com.bluetears.nucraft.blocks.CopperOre;
import com.bluetears.nucraft.blocks.SilicateOre;
import com.bluetears.nucraft.blocks.UnobtainiumOre;
import com.bluetears.nucraft.items.Silicate;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;


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
        public final static Block silicateOre = new SilicateOre(501, Material.iron);
        public final static Block unobtainiumOre = new UnobtainiumOre(502, Material.iron);
        public final static Block copperOre = new CopperOre(503, Material.iron);
        
        
        //Below is the code for generating all of the items
        public final static Item silicate = new Silicate(5001).setMaxStackSize(16);
        
        
        // Says where the client and server 'proxy' code is loaded.
        @SidedProxy(clientSide="com.bluetears.nucraft.client.ClientProxy", serverSide="com.bluetears.nucraft.CommonProxy")
        public static CommonProxy proxy;
        
        @PreInit
        public void preInit(FMLPreInitializationEvent event) {
                // Stub Method
        }
        
        @Init
        
        public void load(FMLInitializationEvent event) {
        	
        	addNames();
        	
            MinecraftForge.setBlockHarvestLevel(silicateOre, "pickaxe", 2);
            GameRegistry.registerBlock(silicateOre, "silicateOre");
            
            
            MinecraftForge.setBlockHarvestLevel(unobtainiumOre, "pickaxe", 3);
            GameRegistry.registerBlock(unobtainiumOre, "unobtainiumOre");
            
            MinecraftForge.setBlockHarvestLevel(copperOre, "pickaxe", 2);
            GameRegistry.registerBlock(copperOre, "copperOre");
            
            GameRegistry.registerWorldGenerator(new NuCraftWorldGenerator());
            
                proxy.registerRenderers();
        }
        
        @PostInit
        public void postInit(FMLPostInitializationEvent event) {
                // Stub Method
        }
        
        public static void addNames(){
        	LanguageRegistry.addName(copperOre, "Copper Ore");
        	LanguageRegistry.addName(unobtainiumOre, "Unobtainium Ore");
        	LanguageRegistry.addName(silicateOre, "Silicate Ore");
        	LanguageRegistry.addName(silicate, "Silicate");
        }
}


