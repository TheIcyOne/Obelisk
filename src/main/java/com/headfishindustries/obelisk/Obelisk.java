package com.headfishindustries.obelisk;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.headfishindustries.obelisk.proxy.CommonProxy;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Obelisk.MODID, name = Obelisk.MODID, version = Obelisk.VERSION, acceptedMinecraftVersions = "[1.11, 1.13]")
public class Obelisk {
	public static final String MODID = "obelisk";
	public static final String VERSION = "GRADLE:VERSION";
	
	@Instance(value=Obelisk.MODID)
	public static Obelisk instance;
	public static final Logger LOGGER = LogManager.getLogger(MODID);
	
	@SidedProxy(clientSide="com.headfishindustries.obelisk.proxy.ClientProxy", serverSide="com.headfishindustries.obelisk.proxy.CommonProxy")
	public static CommonProxy proxy;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent e){
		proxy.preInit(e);
	}
	
	@EventHandler
	public void init(FMLInitializationEvent e){
		proxy.init(e);
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent e){
		proxy.postInit(e);
	}
	
}
