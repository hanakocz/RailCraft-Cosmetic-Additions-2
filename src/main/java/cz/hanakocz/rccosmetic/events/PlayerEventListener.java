package cz.hanakocz.rccosmetic.events;

import cz.hanakocz.rccosmetic.blocks.BlocksInit;
import net.minecraft.block.Block;
import net.minecraft.block.BlockRail;
import net.minecraft.block.IGrowable;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.event.entity.player.BonemealEvent;
import net.minecraftforge.fml.common.eventhandler.Event.Result;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class PlayerEventListener 
{
	@SubscribeEvent(priority=EventPriority.HIGHEST, receiveCanceled=true)
	public void onLogged(PlayerEvent.PlayerLoggedInEvent event)
	{
		NBTTagCompound tag = event.player.getEntityData();		
		NBTBase tagBreath = tag.getTag("statBreath");
		if (tagBreath == null)
		{
			tag.setInteger("statBreath", 800);
		}			
	}
	
	@SubscribeEvent(priority=EventPriority.HIGHEST, receiveCanceled=true)
	public void onPlayerTick(TickEvent.PlayerTickEvent event)
	{
		NBTTagCompound tag = event.player.getEntityData();
		int tagBreath = tag.getInteger("statBreath");
		if (tagBreath < 800)
		{
			tag.setInteger("statBreath", tagBreath+1);
		}
	}
	
	@SubscribeEvent(priority=EventPriority.HIGHEST, receiveCanceled=true)
	public void bonemealRail(BonemealEvent event)
	{
		IBlockState block = event.getBlock();
		if (block.getBlock() == Blocks.RAIL)
		{	
			IBlockState newblock = BlocksInit.TrackGrass.getDefaultState().withProperty(BlockRail.SHAPE, block.getValue(BlockRail.SHAPE));
			event.getWorld().setBlockState(event.getPos(), newblock, 2);
			Result result = Result.ALLOW;
			event.setResult(result);
		}

	}
}
