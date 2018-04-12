package cz.hanakocz.rccosmetic.network;

import cz.hanakocz.rccosmetic.entity.carts.EntityCartCouch;
import cz.hanakocz.rccosmetic.events.CartDiscSound;
import net.minecraft.client.Minecraft;
import net.minecraft.item.Item;
import net.minecraft.item.ItemRecord;
import net.minecraft.util.IThreadListener;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class StuffToDo 
{
	public static void doStuff(CouchCartPlayMusic message, MessageContext ctx)
	  {
		  IThreadListener thread = FMLCommonHandler.instance().getWorldThread(ctx.netHandler);
		  thread.addScheduledTask(() -> 
		  {	
			  
			  Item item = Item.getItemById(message.toSend);
			  
			  if (item instanceof ItemRecord)
			  {	
				  Minecraft mc = Minecraft.getMinecraft();
				  if(mc.theWorld.isRemote)
				  {
					  ItemRecord record = (ItemRecord) item;
					  SoundEvent sound = record.getSound();										 
					  mc.getSoundHandler().playSound(new CartDiscSound(sound,(EntityCartCouch) mc.theWorld.getEntityByID(message.entityId)));										 
				  //tryThis(sound, (EntityCartCouch) mc.theWorld.getEntityByID(message.entityId));
				  }
				  
			  }
			  
		  });
	  }
	  
	  public static void tryThis(SoundEvent sound, EntityCartCouch cart)
	  {
		  if(cart.worldObj.isRemote)
		  {
			  Minecraft.getMinecraft().getSoundHandler().playSound(new CartDiscSound(sound, cart));
		  }

	  }

}
