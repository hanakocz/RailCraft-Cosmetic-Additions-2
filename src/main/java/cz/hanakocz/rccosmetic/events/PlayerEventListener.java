package cz.hanakocz.rccosmetic.events;

import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
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
}
