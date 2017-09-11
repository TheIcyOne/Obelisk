package com.headfishindustries.obelisk.blocks;

import javax.annotation.Nullable;

import com.headfishindustries.obelisk.Obelisk;

import net.minecraft.block.Block;
import net.minecraft.block.BlockObsidian;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.World;

public class BlockObelisk extends Block{

	public BlockObelisk() {
		super(Material.ROCK);
		setHardness(5f);
		setResistance(-1f);
		setHarvestLevel("pickaxe", 3);
		setRegistryName(Obelisk.MODID + ":spawn_obelisk");
		setUnlocalizedName(Obelisk.MODID + ":spawn_obelisk");
		setCreativeTab(CreativeTabs.DECORATIONS);
	}
	
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, @Nullable ItemStack heldItem, EnumFacing side, float hitX, float hitY, float hitZ)
    { 
		if (!worldIn.isRemote){
				if (worldIn.provider.canRespawnHere())
            	{
            		if (!(worldIn.getBlockState(pos.down()).getBlock() instanceof BlockObsidian) || !(worldIn.getBlockState(pos.down(2)).getBlock() instanceof BlockObsidian)){
            			player.addChatComponentMessage(new TextComponentTranslation("tile.obelisk.noObsidian", new Object[0]));
                        return true;
            		}
            			BlockPos chunkcoords = getSafeSpawnLocation(worldIn,(int) player.posX,(int) player.posY,(int) player.posZ, 0);
            			player.setSpawnChunk(chunkcoords, true, player.dimension);
            			player.addChatComponentMessage(new TextComponentTranslation("tile.obelisk.spawnSet", new Object[0]));
            			return true;
            	}
				player.addChatComponentMessage(new TextComponentTranslation("tile.obelisk.whatTheHell", new Object[0]));
            	return true;
            }
            return true;
    }
	
	public static BlockPos getSafeSpawnLocation(World worldIn, int x, int y, int z, int safeIndex)
    {
		//kthx I'll just do this
        return new BlockPos(x, y, z);
    }
	

}
