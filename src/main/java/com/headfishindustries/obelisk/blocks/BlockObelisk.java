package com.headfishindustries.obelisk.blocks;

import com.headfishindustries.obelisk.Obelisk;

import cpw.mods.fml.common.FMLLog;
import net.minecraft.block.Block;
import net.minecraft.block.BlockBed;
import net.minecraft.block.BlockDirectional;
import net.minecraft.block.BlockObsidian;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.world.World;

public class BlockObelisk extends Block{

	public BlockObelisk() {
		super(Material.rock);
		setHardness(5f);
		setResistance(-1f);
		this.setHarvestLevel("pickaxe", 3);
	}
	
	@Override
	public void registerIcons(IIconRegister IIconRegister){
		this.blockIcon = IIconRegister.registerIcon(Obelisk.MODID + ":spawn_obelisk");
}
	
	public boolean onBlockActivated(World worldIn, int x, int y, int z, EntityPlayer player, int side, float subX, float subY, float subZ)
    { 
		if (!worldIn.isRemote){
				if (worldIn.provider.canRespawnHere())
            	{
            		if (!(worldIn.getBlock(x, y-1, z) instanceof BlockObsidian) || !(worldIn.getBlock(x, y-2, z) instanceof BlockObsidian)){
            			player.addChatComponentMessage(new ChatComponentTranslation("tile.obelisk.noObsidian", new Object[0]));
                        return true;
            		}
            			ChunkCoordinates chunkcoords = getSafeSpawnLocation(worldIn,(int) player.posX,(int) player.posY,(int) player.posZ, 0);
            			player.setSpawnChunk(chunkcoords, true);
            			player.addChatComponentMessage(new ChatComponentTranslation("tile.obelisk.spawnSet", new Object[0]));
            			return true;
            	}
				player.addChatComponentMessage(new ChatComponentTranslation("tile.obelisk.whatTheHell", new Object[0]));
            	return true;
            }
            return true;
    }
	
	public static ChunkCoordinates getSafeSpawnLocation(World worldIn, int x, int y, int z, int safeIndex)
    {
		//kthx I'll just do this
        return new ChunkCoordinates(x, y, z);
    }
	

}
