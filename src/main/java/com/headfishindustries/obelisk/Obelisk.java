package com.headfishindustries.obelisk;

import com.headfishindustries.obelisk.blocks.BlockObelisk;
import com.headfishindustries.obelisk.proxy.CommonProxy;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.creativetab.CreativeTabs;

@Mod(modid = Obelisk.MODID, name = Obelisk.MODID, version = Obelisk.VERSION, acceptedMinecraftVersions = "[1.7.10, 1.8]")
public class Obelisk {
	public static final String MODID = "obelisk";
	public static final String VERSION = "GRADLE:VERSION";
	
	@SidedProxy(clientSide="com.headfishindustries.obelisk.proxy.ClientProxy", serverSide="com.headfishindustries.obelisk.proxy.CommonProxy")
	public static CommonProxy proxy;
	
	@EventHandler
	public void init(FMLInitializationEvent e){
		proxy.init(e);
	}
	
}
