package com.headfishindustries.obelisk.blocks;

import com.headfishindustries.obelisk.Obelisk;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockDefs {
	
	public static final Block SPAWN_OBELISK = registerBlock(new BlockObelisk(), "spawn_obelisk");
	
	public void preInit(){
		//Do things later. Not now.
		//Fine, do them now if you want.
		//Seriously though, this class exists for no reason. Its existence just reminds me of my own.
	}
	
private static Block registerBlock(Block block, String name){
		
		if(block.getRegistryName() == null) block.setRegistryName(name);
		GameRegistry.register(block);
		Obelisk.LOGGER.info("Registering block " + block.getRegistryName());
		GameRegistry.register(new ItemBlock(block).setRegistryName(name));
		return block;
}


private static void registerTexture(Block block) {
	ResourceLocation loc = block.getRegistryName();
	Item item = GameRegistry.findRegistry(Item.class).getValue(loc);
	Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, (new ModelResourceLocation(loc, "inventory")));
}

@SideOnly(Side.CLIENT)
public static void initClient() {
	registerTexture(SPAWN_OBELISK);
}
}