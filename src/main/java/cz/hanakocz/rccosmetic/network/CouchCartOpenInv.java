package cz.hanakocz.rccosmetic.network;

import cz.hanakocz.rccosmetic.RCCosmetic;
import cz.hanakocz.rccosmetic.entity.carts.EntityCartCouch;
import cz.hanakocz.rccosmetic.inventory.RCCEnumGui;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.IThreadListener;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class CouchCartOpenInv implements IMessage 
{
	  public CouchCartOpenInv(){}

	  private int toSend;
	  public CouchCartOpenInv(int toSend) 
	  {
	    this.toSend = toSend;
	  }

	  @Override public void toBytes(ByteBuf buf) 
	  {
	    buf.writeInt(toSend);
	  }

	  @Override public void fromBytes(ByteBuf buf) 
	  {
	    toSend = buf.readInt();
	  }
	  
	  public static class CouchCartOpenInvHandler implements IMessageHandler<CouchCartOpenInv, IMessage> 
	  {
		  @Override 
		  public IMessage onMessage(CouchCartOpenInv message, MessageContext ctx) 
		  {			 
			  IThreadListener thread = FMLCommonHandler.instance().getWorldThread(ctx.netHandler);
			  thread.addScheduledTask(() -> 
			  {	
				  EntityPlayerMP player = ctx.getServerHandler().playerEntity;
				  if (player.isRiding() && player.getRidingEntity() instanceof EntityCartCouch)
				  {
					  EntityCartCouch cart = (EntityCartCouch) player.getRidingEntity();
					  player.openGui(RCCosmetic.MODID, RCCEnumGui.COUCH_CART.ordinal(), cart.worldObj, cart.getEntityId(), -1, 0);
			    
				  }
			  });		    
			  return null;
		  }
		}
}
