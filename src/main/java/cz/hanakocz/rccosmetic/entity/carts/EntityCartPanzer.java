package cz.hanakocz.rccosmetic.entity.carts;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class EntityCartPanzer extends EntityModelledCart
{
	public EntityCartPanzer(World world, BlockPos pos, int color) 
	{
		super(world, (double)((float)pos.getX() + 0.5F), (double)((float)pos.getY() + 0.5F), (double)((float)pos.getZ() + 0.5F), 4, color);
	}
	
	public EntityCartPanzer(World world)
    {
        super(world);
    }

	@Override
    protected void entityInit() 
    {
    	super.entityInit();
    }
}
