package cz.hanakocz.rccosmetic.events;

import cz.hanakocz.rccosmetic.entity.carts.EntityCartCouch;
import cz.hanakocz.rccosmetic.network.CouchCartOpenInv;
import cz.hanakocz.rccosmetic.network.RCCPacketHandler;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;

public class PlayerEventClientListener 
{

	@SubscribeEvent
	public void keyInput(InputEvent.KeyInputEvent event) 
	{
	    Minecraft mc = Minecraft.getMinecraft();
	    EntityPlayer player = mc.thePlayer;
	    if (player.isRiding() && player.getRidingEntity() instanceof EntityCartCouch) 
	    {
	        while (mc.gameSettings.keyBindInventory.isPressed()) 
	        {
	        	RCCPacketHandler.INSTANCE.sendToServer(new CouchCartOpenInv(0));	        	
	        }
	    }
	}
}
