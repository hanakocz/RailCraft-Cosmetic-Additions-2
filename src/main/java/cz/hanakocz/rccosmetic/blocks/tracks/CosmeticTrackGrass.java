package cz.hanakocz.rccosmetic.blocks.tracks;

import java.util.Random;

import javax.annotation.Nullable;

import cz.hanakocz.rccosmetic.ClientProxy;
import cz.hanakocz.rccosmetic.RCCosmetic;
import mods.railcraft.api.tracks.TrackType;
import mods.railcraft.common.blocks.tracks.BlockTrack;
import mods.railcraft.common.blocks.tracks.IRailcraftTrack;
import mods.railcraft.common.blocks.tracks.flex.BlockTrackFlex;
import net.minecraft.block.Block;
import net.minecraft.block.BlockRailBase;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemShears;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class CosmeticTrackGrass extends BlockTrackFlex
{
	public CosmeticTrackGrass(String unlocalizedName, TrackType trackType) 
	{
		super(trackType);
		setRegistryName(unlocalizedName);
		setUnlocalizedName(unlocalizedName);

	}
	
	@SideOnly(Side.CLIENT)
    public void initModel() 
	{
        ModelLoader.setCustomModelResourceLocation(ItemBlock.getItemFromBlock(this), 0, new ModelResourceLocation(getRegistryName(), "inventory"));
    }
	
	@Override
	public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, @Nullable ItemStack heldItem, EnumFacing side, float sideX, float sideY, float sideZ)
    {
		if(heldItem != null)
		{

			if(heldItem.getItem() instanceof ItemShears)
			{
				
				world.setBlockState(pos, Blocks.RAIL.getActualState(state, world, pos), 2);
				ItemStack itemstack = new ItemStack(Blocks.TALLGRASS, 1, 1);
				player.entityDropItem(itemstack, 0);
				heldItem.damageItem(1, player);
				return true;
			}
			else
			{
				return false;
			}
		}
		
		else
		{
			return false;
		}		
    }




	
	
	
	
	
	
			
    

}

