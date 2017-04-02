package cz.hanakocz.rccosmetic;

import cz.hanakocz.rccosmetic.blocks.BlocksInit;
import cz.hanakocz.rccosmetic.events.EventsInit;
import cz.hanakocz.rccosmetic.items.ItemsInit;
import cz.hanakocz.rccosmetic.recipes.RecipesInit;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class CommonProxy 
{
	public void registerRenderers()
	{
		
	}
	
	public void preInit(FMLPreInitializationEvent event)
	{
		BlocksInit.init();
		ItemsInit.init();
		RecipesInit.init();
		EventsInit.init();
		
		//Achievements.init();
	}
	
	public void init(FMLInitializationEvent event)
	{
		SoundEffects.init();
	}
	
	public void postInit(FMLPostInitializationEvent event)
	{
		
	}
	
	public void registerItemRenderer(Item item, int meta, String id) 
	{
	}

}
