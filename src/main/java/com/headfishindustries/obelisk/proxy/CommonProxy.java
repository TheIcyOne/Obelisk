package com.headfishindustries.obelisk.proxy;

import com.headfishindustries.obelisk.blocks.BlockObelisk;

import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.creativetab.CreativeTabs;

public class CommonProxy {
public void init(FMLInitializationEvent e){
		BlockObelisk obelisk = (BlockObelisk) new BlockObelisk().setUnlocalizedName("obelisk:spawn_obelisk").setCreativeTab(CreativeTabs.tabDecorations);
		GameRegistry.registerBlock(obelisk, "spawnObelisk");
	}
}
