package cz.hanakocz.rccosmetic.blocks.tracks;

import java.util.Random;

import cz.hanakocz.rccosmetic.ClientProxy;
import cz.hanakocz.rccosmetic.RCCosmetic;
import mods.railcraft.api.tracks.TrackType;
import mods.railcraft.common.blocks.tracks.IRailcraftTrack;
import net.minecraft.block.Block;
import net.minecraft.block.BlockRailBase;
import net.minecraft.block.properties.IProperty;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemShears;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class TrackGrass extends BlockRailBase implements IRailcraftTrack
{
	
	

	protected TrackGrass(boolean isPowered) 
	{
		super(isPowered);
	}

	@Override
	public Block getObject() 
	{
		return null;
	}

	@Override
	public TrackType getTrackType(IBlockAccess world, BlockPos pos) 
	{
		return null;
	}

	@Override
	public IProperty<EnumRailDirection> getShapeProperty() 
	{
		return null;
	}
	
	
	
	
	
			
    

}

