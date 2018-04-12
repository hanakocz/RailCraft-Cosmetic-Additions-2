package cz.hanakocz.rccosmetic.network;

import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class CouchCartPlayMusicHandler implements IMessageHandler<CouchCartPlayMusic, IMessage> 
{
	  @Override 
	  public IMessage onMessage(CouchCartPlayMusic message, MessageContext ctx) 
	  {				  
		  if (FMLCommonHandler.instance().getEffectiveSide().isClient())
		  {
			  StuffToDo.doStuff(message, ctx);
		  }
		  return null;
	  }
}
