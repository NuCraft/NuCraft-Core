package com.bluetears.nucraft;




import com.bluetears.nucraft.items.Silicate;

import net.minecraft.item.Item;


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
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid="NuCraftCore", name="NuCraftCore", version="0.0.1")
@NetworkMod(clientSideRequired=true, serverSideRequired=false)
public class NuCraftCore {

        // The instance of your mod that Forge uses.
        @Instance("NuCraftCore")
        public static NuCraftCore instance;
        
        //Below is the code for generating all of the blocks
        public final static Item silicate = new Silicate(5001).setMaxStackSize(16);
        
        
        //Below is the code for generating all of the items
        
        
        
        // Says where the client and server 'proxy' code is loaded.
        @SidedProxy(clientSide="com.bluetears.nucraft.client.ClientProxy", serverSide="com.bluetears.technosorcery.CommonProxy")
        public static CommonProxy proxy;
        
        @PreInit
        public void preInit(FMLPreInitializationEvent event) {
                // Stub Method
        }
        
        @Init
        public void load(FMLInitializationEvent event) {
        	LanguageRegistry.addName(silicate, "Silicate");
                proxy.registerRenderers();
        }
        
        @PostInit
        public void postInit(FMLPostInitializationEvent event) {
                // Stub Method
        }
        
        
}


