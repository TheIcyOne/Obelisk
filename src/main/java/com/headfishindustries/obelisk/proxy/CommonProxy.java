package com.headfishindustries.obelisk.proxy;

import com.headfishindustries.obelisk.blocks.BlockDefs;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class CommonProxy {
	BlockDefs blocks;
	
	public void preInit(FMLPreInitializationEvent e){
		blocks = new BlockDefs();
		blocks.preInit(); //FEEL THE INUTILITY
		}
	public void init(FMLInitializationEvent e){
		
	}
	
	public void postInit(FMLPostInitializationEvent e){
		
	}
}
