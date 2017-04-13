package cz.hanakocz.rccosmetic.entity.carts;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import cz.hanakocz.rccosmetic.items.ItemsInit;
import mods.railcraft.common.carts.EntityCartTank;
import mods.railcraft.common.carts.IRailcraftCartContainer;
import mods.railcraft.common.carts.RailcraftCarts;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityMinecart;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class EntityModelledTanker extends EntityCartTank
{   
	public int colour;
	protected static final DataParameter<Integer> CARTTYPE = EntityDataManager.<Integer>createKey(EntityModelledTanker.class, DataSerializers.VARINT);
	protected static final DataParameter<Integer> CARTCOLOR = EntityDataManager.<Integer>createKey(EntityModelledTanker.class, DataSerializers.VARINT);
	
    public EntityModelledTanker(World world) 
    {
		super(world);		
	}
    
    public EntityModelledTanker(World world, double x, double y, double z, int cartType, int color)
    {    	
        super(world, x, y, z);
        this.setCustomCartType(cartType);
        this.setColor(color);
        this.colour = color;
    }

    @Override
    public IRailcraftCartContainer getCartType() 
    {
        return RailcraftCarts.TANK;
    }

    @Override
    protected void entityInit() 
    {
    	super.entityInit();
    	this.dataManager.register(CARTTYPE, Integer.valueOf( 1));
    	this.dataManager.register(CARTCOLOR, Integer.valueOf(colour ));
    }
    
    @Nullable
    @Override
	public ItemStack createCartItem(EntityMinecart cart) 
    {
        ItemStack stack = new ItemStack(ItemsInit.ModelledCartTanker);
        if (stack != null && cart.hasCustomName())
            stack.setStackDisplayName(cart.getCustomNameTag());
        return stack;
    }
    
    public void setCustomCartType(int cartType) 
    {
    	this.dataManager.set(CARTTYPE, Integer.valueOf(cartType));
    }
    
    public void setColor(int color) 
    {
    	this.dataManager.set(CARTCOLOR, Integer.valueOf(color));
    }
    
    public int getCustomCartType() 
    {
    	return this.dataManager.get(CARTTYPE);
    } 
    
    public int getColor() 
    {
    	return this.dataManager.get(CARTCOLOR);
    } 
    
    protected void readEntityFromNBT(NBTTagCompound tag)
    {     
    	super.readEntityFromNBT(tag);
    	this.setColor(tag.getInteger("Colour"));
    }
       
    protected void writeEntityToNBT(NBTTagCompound tag)
    {
    	super.writeEntityToNBT(tag);
    	tag.setInteger("Colour", getColor());
    }
    
    @Nonnull
    @Override
    public String getName() {
        return hasCustomName() ? getCustomNameTag() : I18n.format("entity.rccosmetic.cart.1.name");
    }
}
