package cz.hanakocz.rccosmetic;

import cz.hanakocz.rccosmetic.blocks.BlocksInit;
import cz.hanakocz.rccosmetic.blocks.PlatformConnectedList;
import cz.hanakocz.rccosmetic.events.EventsInit;
import cz.hanakocz.rccosmetic.events.TemperatureChangerCart;
import cz.hanakocz.rccosmetic.inventory.RCCGuiHandler;
import cz.hanakocz.rccosmetic.items.ItemsInit;
import cz.hanakocz.rccosmetic.network.CouchCartOpenInv;
import cz.hanakocz.rccosmetic.network.RCCPacketHandler;
import cz.hanakocz.rccosmetic.recipes.RecipesInit;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.relauncher.Side;

public class CommonProxy 
{
	public static boolean tanLoaded;

	public void registerRenderers()
	{
		
	}
	
	public void preInit(FMLPreInitializationEvent event)
	{
		BlocksInit.init();
		ItemsInit.init();
		
		EventsInit.init();
		PlatformConnectedList.init();
		
		//Achievements.init();
	}
	
	public void init(FMLInitializationEvent event)
	{
		SoundEffects.init();
		RecipesInit.init();
		NetworkRegistry.INSTANCE.registerGuiHandler(RCCosmetic.MODID, new RCCGuiHandler());
		RCCPacketHandler.init();
	}
	
	public void postInit(FMLPostInitializationEvent event)
	{
		tanLoaded = Loader.isModLoaded("ToughAsNails");
		if (tanLoaded)
		{
			EventsInit.initTAN();
		}
		
	}
	
	public void registerItemRenderer(Item item, int meta, String id) 
	{
	}

}
