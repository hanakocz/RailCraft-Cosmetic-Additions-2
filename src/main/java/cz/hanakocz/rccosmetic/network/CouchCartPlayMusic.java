package cz.hanakocz.rccosmetic.network;

import cz.hanakocz.rccosmetic.entity.carts.EntityCartCouch;
import cz.hanakocz.rccosmetic.events.CartDiscSound;
import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemRecord;
import net.minecraft.util.IThreadListener;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class CouchCartPlayMusic implements IMessage 
{
	  public CouchCartPlayMusic(){}

	  public int toSend;
	  public int entityId;
	  public CouchCartPlayMusic(int toSend, int entityId) 
	  {
	    this.toSend = toSend;
	    this.entityId = entityId;
	  }

	  @Override public void toBytes(ByteBuf buf) 
	  {
	    buf.writeInt(toSend);
	    buf.writeInt(entityId);
	  }

	  @Override public void fromBytes(ByteBuf buf) 
	  {
	    toSend = buf.readInt();
	    entityId = buf.readInt();
	  }
	  
	/*  public class CouchCartPlayMusicHandler implements IMessageHandler<CouchCartPlayMusic, IMessage> 
	  {
		  @Override 
		  public IMessage onMessage(CouchCartPlayMusic message, MessageContext ctx) 
		  {				  
			  if (FMLCommonHandler.instance().getEffectiveSide().isClient())
			  {
				  doStuff(message, ctx);
			  }
			  return null;
		  }
	  }
	  
	  @SideOnly(Side.CLIENT)
	  private static void doStuff(CouchCartPlayMusic message, MessageContext ctx)
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
				  System.out.println("Really Playing "+ sound.getSoundName());
				  //EntityPlayer player =  Minecraft.getMinecraft().thePlayer;				  				  
				  //Minecraft.getMinecraft().getSoundHandler().playSound(new CartDiscSound(sound,(EntityCartCouch) player.worldObj.getEntityByID(message.entityId)));										 
				  //mc.getSoundHandler().playSound(new CartDiscSound(sound,(EntityCartCouch) mc.theWorld.getEntityByID(message.entityId)));										 
				  tryThis(sound, (EntityCartCouch) mc.theWorld.getEntityByID(message.entityId));
				  System.out.println("Really Playing "+ sound.getSoundName());
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
		  else
		  {
			  System.out.println("Server Side!!!!");
		  }
	  }*/
}
