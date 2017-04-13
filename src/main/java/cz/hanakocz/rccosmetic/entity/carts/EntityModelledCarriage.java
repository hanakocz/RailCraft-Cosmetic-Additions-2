package cz.hanakocz.rccosmetic.entity.carts;

import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityMinecart;
import net.minecraft.world.World;

public class EntityModelledCarriage extends EntityModelledCart
{

	public EntityModelledCarriage(World world) 
	{
		super(world);		
	}
	
	public EntityModelledCarriage(World world, double x, double y,double z, int cartType, int color)
    {
        super(world, x, y, z, cartType, color);
        this.setCustomCartType(cartType);
        this.cart = cartType;
        
        
    }
	
	@Override
	public boolean canBeRidden()
    {
        return true;
    }
	
	@Override
	protected boolean canFitPassenger(Entity passenger)
    {
        return this.getPassengers().size() < 1;
    }
	

}
