package cz.hanakocz.rccosmetic.events;

import net.minecraftforge.common.MinecraftForge;

public class EventsInit 
{
	public static void init()
	{
		MinecraftForge.EVENT_BUS.register(new PlayerEventListener());
	}
	
	public static void initClient()
	{
		MinecraftForge.EVENT_BUS.register(new PlayerEventClientListener());
	}
	
	public static void initTAN()
	{
		MinecraftForge.EVENT_BUS.register(new TemperatureChangerCart());
	}

}
