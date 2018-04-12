package cz.hanakocz.rccosmetic.events;

import cz.hanakocz.rccosmetic.entity.carts.EntityCartCouch;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityMinecart;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Optional;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import toughasnails.api.stat.capability.ITemperature;
import toughasnails.api.temperature.Temperature;
import toughasnails.api.temperature.TemperatureHelper;

public class TemperatureChangerCart 
{

	
	/*@Optional.Method(modid="ToughAsNails")
	public static void changeTemperature(Entity entity, int temp)
	{
		System.out.println("TAN LOADED!");
		Entity vehicle = entity.getRidingEntity();
		if (entity instanceof EntityPlayer && vehicle instanceof EntityCartCouch)
		{
			EntityPlayer player = (EntityPlayer) entity;
			EntityCartCouch cart = (EntityCartCouch) vehicle;
			Temperature temperature = new Temperature(temp);
			TemperatureHandler.modifyTarget(player.worldObj, player, temperature);
			
		}
		
		
	}*/
	
	@Optional.Method(modid="ToughAsNails")
	@SubscribeEvent(priority=EventPriority.NORMAL)
	public void handleTemperature(CartUpdateEvent event)
	{
		System.out.println("Temp....");
		EntityMinecart e = event.getEntityMinecart();
		Entity pass = e.getControllingPassenger();
		System.out.println(e);
		System.out.println(pass);
		if(e instanceof EntityCartCouch && pass != null && pass instanceof EntityPlayer && !e.worldObj.isRemote)
		{
			EntityCartCouch cart = (EntityCartCouch) e;
			EntityPlayer player = (EntityPlayer) pass;
			ITemperature tempData = TemperatureHelper.getTemperatureData(player);
			tempData.applyModifier("clima_cart_couch", cart.getTemperature(), 0, 1);
		}
	}
}
