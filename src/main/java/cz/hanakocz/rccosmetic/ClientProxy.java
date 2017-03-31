package cz.hanakocz.rccosmetic;

import cz.hanakocz.rccosmetic.items.ItemsInit;
import cz.hanakocz.rccosmetic.models.ModelTrainOperatorCap;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy extends CommonProxy
{
	private static final ModelTrainOperatorCap cap = new ModelTrainOperatorCap(1.0f);
	
	@Override
	public void registerRenderers() 
	{
		
	}
	
	
	@Override
	public void preInit(FMLPreInitializationEvent event)
	{
		super.preInit(event);
		ItemsInit.initModels();
	}
	
	@Override
	public void init(FMLInitializationEvent event)
	{
		super.init(event);
	}
	
	@Override
	public void postInit(FMLPostInitializationEvent event)
	{
		super.postInit(event);
	}
	
	@Override
	public void registerItemRenderer(Item item, int meta, String id) 
	{
		ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(RCCosmetic.MODID + ":" + id, "inventory"));
	}
	
	public static ModelBiped getArmorModel(EntityEquipmentSlot armorSlot)
	{ 	switch (armorSlot) 
		{ 
			case HEAD: return cap; 
			case CHEST: 
			case LEGS:
			case FEET: return null;
			default: return null; 
		}   
	} 
}
