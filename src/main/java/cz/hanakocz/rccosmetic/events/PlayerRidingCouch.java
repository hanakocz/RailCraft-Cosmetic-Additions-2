package cz.hanakocz.rccosmetic.events;

import cz.hanakocz.rccosmetic.entity.carts.EntityCartCouch;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.PlayerTickEvent;

public class PlayerRidingCouch {
	
	@SubscribeEvent(priority=EventPriority.HIGHEST, receiveCanceled=true)
	public void ridingCouch(PlayerTickEvent event)
	{
		EntityPlayer player = event.player;
		
		if(player != null && player.isRiding() && player.getRidingEntity() instanceof EntityCartCouch)
		{
			
			EntityCartCouch cart = (EntityCartCouch) player.getRidingEntity();
			
			
		}
		
	}

}
