package cz.hanakocz.rccosmetic.events;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityMinecart;
import net.minecraftforge.event.entity.EntityEvent;

public class CartUpdateEvent  extends EntityEvent
{
	private final EntityMinecart cart;
	
	public CartUpdateEvent(EntityMinecart entity)
	{
		super(entity);
		cart = entity;
	}
	
	public EntityMinecart getEntityMinecart()
	{
		return cart;
	}

}
