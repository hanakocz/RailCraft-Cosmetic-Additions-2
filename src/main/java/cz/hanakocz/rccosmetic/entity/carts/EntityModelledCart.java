package cz.hanakocz.rccosmetic.entity.carts;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nonnull;

import com.mojang.authlib.GameProfile;

import cz.hanakocz.rccosmetic.items.ItemsInit;
import mods.railcraft.common.carts.CartTools;
import mods.railcraft.common.gui.containers.FactoryContainer;
import mods.railcraft.common.util.inventory.InvTools;
import mods.railcraft.common.util.misc.Game;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFalling;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.item.EntityMinecart;
import net.minecraft.entity.item.EntityMinecartContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ContainerChest;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.oredict.OreDictionary;

public class EntityModelledCart extends EntityMinecartContainer implements ISidedInventory/*, ILinkableCart*/
{	
    private String entityName;
    private int cart;
    public int colour = 0;
    private static final int[] SLOTS1 = InvTools.buildSlotArray(0, 1);
    private static final int[] SLOTS9 = InvTools.buildSlotArray(0, 9);
    private static final int[] SLOTS36 = InvTools.buildSlotArray(0, 36);
    protected static final DataParameter<Integer> CARTTYPE = EntityDataManager.<Integer>createKey(EntityModelledCart.class, DataSerializers.VARINT);
	protected static final DataParameter<Integer> CARTCOLOR = EntityDataManager.<Integer>createKey(EntityModelledCart.class, DataSerializers.VARINT);
	protected static final DataParameter<Integer> CARTITEMS = EntityDataManager.<Integer>createKey(EntityModelledCart.class, DataSerializers.VARINT);
	

	public EntityModelledCart(World world)
    {
        super(world);
    }

    public EntityModelledCart(World world, double x, double y,double z, int cartType, int color)
    {
        super(world, x, y, z);
        this.setCustomCartType(cartType);
        this.cart = cartType;
        if (cartType == 5 || cartType == 0)
        {
        	this.setColor(color);
        	this.colour = color;
        }
        
    }
    
    public int countItems()
    {
    	int items = 0;
    	if (this != null)
    	{    		
    		for (int i1 = 0; i1 < this.getSizeInventory(); ++i1)
    		{
    			ItemStack itemstack = this.getStackInSlot(i1);
    			if(itemstack != null)
    			{
    				items = items + 1;
    			}
    		}
    	}
    	return items;
    }
    
    @Override
    protected void entityInit() 
    {
    	super.entityInit();
    	this.dataManager.register(CARTTYPE, cart);
    	this.dataManager.register(CARTCOLOR, Integer.valueOf(colour));
    	this.dataManager.register(CARTITEMS, 0);
    }

    @Override
    public void killMinecart(DamageSource par1DamageSource) 
    {
        this.setDead();
                
        if (this.worldObj.getGameRules().getBoolean("doEntityDrops"))
        {
            ItemStack itemstack = new ItemStack(Items.MINECART, 1);
            if (this.getName() != null)
            {
                itemstack.setStackDisplayName(this.getName());
            }
            this.entityDropItem(itemstack, 0.0F);
        }
    }
    
    @Override
    public ItemStack getCartItem()
    {
    	switch(this.getCustomCartType())
        {
	        case(0):
	        	return new ItemStack(ItemsInit.ModelledCartOpen);
	        case(2):
	        	return new ItemStack(ItemsInit.ModelledCartWood);
	        case(3):
	        	return new ItemStack(ItemsInit.ModelledCartFlat);
	        case(4):
	        	return new ItemStack(ItemsInit.ModelledCartPanzer);
	        case(5):
	        	return new ItemStack(ItemsInit.ModelledCartContainer);
	        case(6):
	        	return new ItemStack(ItemsInit.ModelledCartTender);
	        default:
	        	return new ItemStack(ItemsInit.ModelledCartFlat);
        }   	
    }
    
    protected void readEntityFromNBT(NBTTagCompound tag)
    {   int type = tag.getInteger("CustomType");
        this.setCustomCartType(type);
        this.cart = type;
        this.dataManager.set(CARTITEMS, this.countItems());
        if ((type == 5 || type == 0) && tag.hasKey("Colour"))
        {
        	this.setColor(tag.getInteger("Colour"));
        }
        super.readEntityFromNBT(tag);	      
        if (tag.getBoolean("CustomDisplayTile"))
        {
            Block block;

            if (tag.hasKey("DisplayTile", 8))
            {
                block = Block.getBlockFromName(tag.getString("DisplayTile"));
            }
            else
            {
                block = Block.getBlockById(tag.getInteger("DisplayTile"));
            }

            int i = tag.getInteger("DisplayData");
            this.setDisplayTile(block == null ? Blocks.AIR.getDefaultState() : block.getStateFromMeta(i));
            this.setDisplayTileOffset(tag.getInteger("DisplayOffset"));
        }
        if (tag.hasKey("CustomName", 8) && tag.getString("CustomName").length() > 0)
        {
            this.entityName = tag.getString("CustomName");
        }                     
    }
    
    protected void writeEntityToNBT(NBTTagCompound tag)
    {
    	super.writeEntityToNBT(tag);
        if (this.hasDisplayTile())
        {
            tag.setBoolean("CustomDisplayTile", true);
            IBlockState iblockstate = this.getDisplayTile();
            ResourceLocation resourcelocation = (ResourceLocation)Block.REGISTRY.getNameForObject(iblockstate.getBlock());
            tag.setString("DisplayTile", resourcelocation == null ? "" : resourcelocation.toString());
            tag.setInteger("DisplayData", iblockstate.getBlock().getMetaFromState(iblockstate));
            tag.setInteger("DisplayOffset", this.getDisplayTileOffset());         
        }
        if (this.entityName != null && this.entityName.length() > 0)
        {
            tag.setString("CustomName", this.entityName);
        }        
        int type = getCustomCartType();
        tag.setInteger("CustomType", type);
        if (type == 5 || type == 0)
        {
        	tag.setInteger("Colour", getColor());
        }
    }
    
    public int getColor() 
    {
    	return this.dataManager.get(CARTCOLOR);
    }
    
    public void setColor(int color) 
    {
    	this.dataManager.set(CARTCOLOR, Integer.valueOf(color));
    }
    
    @Override
    public int getSizeInventory()
    {
    	switch(this.getCustomCartType())
        {
	        case(0):
	        case(2):
	        case(6):
	        	return 9;
	        case(3):
	        case(4):
	        	return 0;
	        case(5):
	        	return 36;
	        default:
	        	return 9;
        }
    }
 
    public int getMinecartType()
    {
        return -1;
    }
    
    public void setCustomCartType(int cartType) 
    {
    	this.dataManager.set(CARTTYPE, Integer.valueOf(cartType));
    }
    
    public int getCustomCartType() 
    {
    	return this.dataManager.get(CARTTYPE);
    }
    
    public int getItemCount()
    {
    	return this.dataManager.get(CARTITEMS);
    }

    public int getDefaultDisplayTileOffset()
    {
        return 8;
    }
    
    @Override
    public boolean isItemValidForSlot(int slot, ItemStack item)
    {
        switch(this.getCustomCartType())
        {
        
        case(5):
        	return true;
        case(2):
        {
        	if (item != null)
        	{
        		return isWood(item);
        	}
        	return false;       	
        }
        case(6):
        {
        	if (item != null && GameRegistry.getFuelValue(item) > 0)
        	{
        		return true;
        	}
        	return false;
        }
        case(0):
        {
        	if (item != null)
        	{
        		return isLoose(item);
        	}
        	return false;
        }
        case(3):
        case(4):
        {
        	return false;
        }
        default:
        	return true;
        }
    }
    
    public void onUpdate()
    {
    	super.onUpdate();
    	if (Game.isHost(worldObj))
    	{
    		this.dataManager.set(CARTITEMS, this.countItems());
    	}
    }
    
    @Override
	public int[] getSlotsForFace(EnumFacing side) 
    {
    	switch(this.getCustomCartType())
        {
        	case(0):
        	case(2):
        	case(6):
        		return SLOTS9;
        	case(3):
        	case(4):
        		return SLOTS1;
        	case(5):
        		return SLOTS36;
        	default:
        		return SLOTS9;
        }
	}

	@Override
	public boolean canInsertItem(int index, ItemStack itemStackIn, EnumFacing direction) 
	{
		return isItemValidForSlot(index, itemStackIn);
	}

	@Override
	public boolean canExtractItem(int index, ItemStack stack, EnumFacing direction) 
	{
		return true;
	}
	
	@Override
	public String getGuiID() 
	{
		return this.hasCustomName() ? this.entityName :"entity.rccosmetic.cart." + Integer.toString(this.getCustomCartType()) + ".name";	    
	}
	
	public boolean isWood(ItemStack stack)
    {
    	int[] array = OreDictionary.getOreIDs(stack);
    	int size = array.length;
    	List<Integer> arrayore = new ArrayList<Integer>();
    	arrayore.add(OreDictionary.getOreID("logWood"));
    	arrayore.add(OreDictionary.getOreID("logRubber"));
    	boolean isIn = false;
    	if (size > 0)
    	{
    		for (int i = 0; i < size; i++)
	    	{
    			if (arrayore.contains(array[i]))
	    		{
	    			isIn = true;
	    			break;
	    		}
	    	}
    	}    	
    	return isIn;
    }
	
	public boolean isLoose(ItemStack stack)
    {	
		int[] array = OreDictionary.getOreIDs(stack);
		List<Integer> arrayore = new ArrayList<Integer>();
    	int size = array.length;
    	arrayore.add(OreDictionary.getOreID("sand"));
    	arrayore.add(OreDictionary.getOreID("sandstone"));
    	arrayore.add(OreDictionary.getOreID("cobblestone"));
    	arrayore.add(OreDictionary.getOreID("stone"));
    	arrayore.add(OreDictionary.getOreID("gravel"));
    	arrayore.add(OreDictionary.getOreID("dirt"));
  	            
    	boolean isIn = false;
    	if (size > 0)
    	{
    		for (int i = 0; i < size; i++)
	    	{
    			if (arrayore.contains(array[i]))
	    		{
	    			isIn = true;
	    			break;
	    		}
	    	}
    	}    	
    	return isIn;
    }
	
	@Override
    @SideOnly(Side.CLIENT)
    public boolean isInRangeToRenderDist(double distance) {
        return CartTools.isInRangeToRenderDist(this, distance);
    }
	/*
	@Override
	public float getOptimalDistance(EntityMinecart cart)
	{
		switch(this.getCustomCartType())
		{
			case(6):
				return 0.7F;
			default: 
				return 0.9F;
		}
	}

	@Override
	public boolean isLinkable() 
	{
		return true;
	}

	@Override
	public boolean canLinkWithCart(EntityMinecart cart) 
	{
		return true;		
	}

	@Override
	public boolean hasTwoLinks() 
	{
		return true;
	}

	@Override
	public float getLinkageDistance(EntityMinecart paramEntityMinecart) 
	{
		switch(this.getCustomCartType())
		{
			case(6):
				return 1.0F;
			default: 
				return 1.25F;
		}		
	}

	@Override
	public boolean canBeAdjusted(EntityMinecart paramEntityMinecart) 
	{		 
		return false;	
	}

	@Override
	public void onLinkCreated(EntityMinecart paramEntityMinecart) {}

	@Override
	public void onLinkBroken(EntityMinecart paramEntityMinecart) {}	
    */

	@Nonnull
    @Override
    public Container createContainer(@Nonnull InventoryPlayer playerInventory, @Nonnull EntityPlayer playerIn) 
	{
        return new ContainerChest(playerInventory, this, playerIn);
    }


	@Override
	public Type getType() {
		// TODO Auto-generated method stub
		return null;
	}
	
}