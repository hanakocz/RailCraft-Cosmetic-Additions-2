package cz.hanakocz.rccosmetic.network;

import cz.hanakocz.rccosmetic.network.CouchCartOpenInv.CouchCartOpenInvHandler;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;

public class RCCPacketHandler 
{
	public static final SimpleNetworkWrapper INSTANCE = NetworkRegistry.INSTANCE.newSimpleChannel("rccosmetic");
	private static int id = 0;
	
	public static void init()
	{
		INSTANCE.registerMessage(CouchCartOpenInvHandler.class, CouchCartOpenInv.class, id++, Side.SERVER);
		INSTANCE.registerMessage(CouchCartPlayMusicHandler.class, CouchCartPlayMusic.class, id++, Side.CLIENT);
	}
	
	public static void initClient()
	{
		
	}

}
