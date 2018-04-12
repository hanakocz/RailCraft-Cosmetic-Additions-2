package cz.hanakocz.rccosmetic.entity.carts;

import java.util.Locale;

import javax.annotation.Nullable;

import cz.hanakocz.rccosmetic.CommonProxy;
import cz.hanakocz.rccosmetic.events.TemperatureChangerCart;
import cz.hanakocz.rccosmetic.inventory.RCCEnumGui;
import cz.hanakocz.rccosmetic.inventory.RCCGuiHandler;
import cz.hanakocz.rccosmetic.network.CouchCartPlayMusic;
import cz.hanakocz.rccosmetic.network.RCCPacketHandler;
import mods.railcraft.common.blocks.charge.CapabilityCartBattery;
import mods.railcraft.common.blocks.charge.ICartBattery;
import mods.railcraft.common.plugins.forge.DataManagerPlugin;
import mods.railcraft.common.util.inventory.PhantomInventory;
import mods.railcraft.common.util.misc.Game;
import mods.railcraft.common.util.misc.MiscTools;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemRecord;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldProvider;
import net.minecraftforge.common.capabilities.Capability;

public class EntityCartCouch extends EntityModelledCarriage
{
	private static final int CHARGE_USE_PER_TICK = 2;
	private static final int FUEL_PER_REQUEST = 1;
    private static final int CHARGE_USE_PER_REQUEST = CHARGE_USE_PER_TICK * FUEL_PER_REQUEST;
	public static final double MAX_CHARGE = 2000.0;
	private final CartCouchBattery cartBattery = new CartCouchBattery(ICartBattery.Type.USER, MAX_CHARGE);
	public int tempMode = 0; 
	private final PhantomInventory invFilter = new PhantomInventory(7, this);
	private int update = MiscTools.RANDOM.nextInt();
	private static final byte FUEL_USE_INTERVAL = 20;
	private static final DataParameter<Byte> CART_MODE = DataManagerPlugin.create(DataSerializers.BYTE);
	private static final DataParameter<Boolean> HAS_FUEL = DataManagerPlugin.create(DataSerializers.BOOLEAN);
	private static final DataParameter<Boolean> IS_PLAYING = DataManagerPlugin.create(DataSerializers.BOOLEAN);
	private static final DataParameter<Boolean> DISC_IN = DataManagerPlugin.create(DataSerializers.BOOLEAN);
	private static final DataParameter<Float> TEMP = DataManagerPlugin.create(DataSerializers.FLOAT);
	private int fuel;
	
	public EntityCartCouch(World world, BlockPos pos, int color) 
	{
		super(world, (double)((float)pos.getX() + 0.5F), (double)((float)pos.getY() + 0.5F), (double)((float)pos.getZ() + 0.5F), 8, color);		
	}
	
	public EntityCartCouch(World world)
    {
        super(world);
    }

	@Override
    protected void entityInit() 
    {
    	super.entityInit();
    	dataManager.register(HAS_FUEL, false);
    	dataManager.register(IS_PLAYING, false);
    	dataManager.register(DISC_IN, false);
    	dataManager.register(CART_MODE, (byte) CouchMode.NONE.ordinal());
    	dataManager.register(TEMP, 0.0F);
    }
	
	@Override
	protected boolean canFitPassenger(Entity passenger)
    {
        return (this.getPassengers().size() < 1 && passenger instanceof EntityPlayer);
    }
	
	@Override
	public double getMountedYOffset()
    {
        return 0.7D;
    }
	
	@Override
	public boolean processInitialInteract(EntityPlayer player, @Nullable ItemStack stack, EnumHand hand)
    {
        if (net.minecraftforge.common.MinecraftForge.EVENT_BUS.post(new net.minecraftforge.event.entity.minecart.MinecartInteractEvent(this, player, stack, hand))) return true;

        if (player.isSneaking())
        {
        	if (!this.worldObj.isRemote)
        	{
        		RCCGuiHandler.openGui(RCCEnumGui.COUCH_CART, player, worldObj, this);
        	}
        	
        	return true;
        }
        else if (this.isBeingRidden())
        {
            return true;
        }
        else
        {
            if (!this.worldObj.isRemote)
            {
                player.startRiding(this);
            }

            return true;
        }
    }
	
	public PhantomInventory getFilterInv() 
	{
        return invFilter;
    }
	
	public void adjustTemperature(int slot)
	{
		switch(slot)
		{
			case(0):
			{
				setTemperature(5); 
				tempMode = 1;
				break;
			}
			case(1): 
			{
				setTemperature(3);
				tempMode = 2;
				break;
			}
			case(2): 
			{
				setTemperature(1); 
				tempMode = 3;
				break;
			}
			case(3): 
			{
				setTemperature(0);
				tempMode = 4;
				break;
			}
			case(4): 
			{
				setTemperature(-1);
				tempMode = 5;
				break;
			}
			case(5):
			{
				setTemperature(-3); 
				tempMode = 6;
				break;
			}
			case(6):
			{
				setTemperature(-5);
				tempMode = 7;
				break;
			}
			default: setTemperature(0); 			
		}
		if (getMode().hasDisc == true)
		{
			switch(tempMode)
			{
				case(1):
				case(7):
					setMode(CouchMode.CLIMA_HIGH_DISC);break;
				case(2):
				case(6):
					setMode(CouchMode.CLIMA_MED_DISC);break;
				case(3):
				case(5):
					setMode(CouchMode.CLIMA_LOW_DISC);break;
				case(4):
				default:
					setMode(CouchMode.DISC);				
			}
		}
		else
		{
			switch(tempMode)
			{
				case(1):
				case(7):
					setMode(CouchMode.CLIMA_HIGH);break;
				case(2):
				case(6):
					setMode(CouchMode.CLIMA_MED);break;
				case(3):
				case(5):
					setMode(CouchMode.CLIMA_LOW);break;
				case(4):
				default:
					setMode(CouchMode.NONE);				
			}
		}
	}
	
	public void setTemperature(int temp)
	{
		
		System.out.println("Temperature adjusted to "+ temp);
		//TODO: temperature hooks
		dataManager.set(TEMP, (float) temp);
		/*if(CommonProxy.tanLoaded)
		{
			Entity entity = this.getControllingPassenger();
			TemperatureChangerCart.changeTemperature(entity, temp);
		}*/
	}
	
	public int getTemperature()
	{
		return dataManager.get(TEMP).intValue();
		
	}
	
	@Override
	protected void readEntityFromNBT(NBTTagCompound tag)
	{		
		super.readEntityFromNBT(tag);
		int temp = tag.getInteger("TempMode");
		this.tempMode = temp == 0 ?  4 : temp;
		invFilter.readFromNBT("invFilter", tag);
		setMode(CouchMode.VALUES[tag.getByte("couchMode")]);
		fuel = tag.getInteger("fuel");
		putDisc(tag.getBoolean("disc"));
        
	}
	
	@Override
	protected void writeEntityToNBT(NBTTagCompound tag)
    {
    	super.writeEntityToNBT(tag);
    	tag.setInteger("TempMode", this.tempMode);
    	invFilter.writeToNBT("invFilter", tag);
    	tag.setByte("couchMode", (byte) getMode().ordinal());
    	tag.setInteger("fuel", fuel);
    	tag.setBoolean("disc", discIn());
    }
	
	public enum CouchMode implements IStringSerializable 
	{
        NONE(false), CLIMA_LOW(false), CLIMA_MED(false), CLIMA_HIGH(false), DISC(true), CLIMA_LOW_DISC(true), CLIMA_MED_DISC(true), CLIMA_HIGH_DISC(true);
        public static final CouchMode[] VALUES = values();

        CouchMode(boolean disc)
        {
        	this.hasDisc = disc;
        }
        @Override
        public String getName() 
        {
            return name().toLowerCase(Locale.ROOT);
        }
        private final boolean hasDisc;
        
        public boolean hasDisc()
        {
        	return hasDisc;
        }
    }
	
	public CouchMode getMode() {
        return DataManagerPlugin.readEnum(dataManager, CART_MODE, CouchMode.VALUES);
    }
	
	public void setMode(CouchMode mode) 
	{        
        if (getMode() != mode)
            DataManagerPlugin.writeEnum(dataManager, CART_MODE, mode);
    }
	
    protected int getIdleFuelUse() {
        return 0;
    }
    
    private int getFuelUse() 
    {
        if (getMode() != CouchMode.NONE) 
        {   CouchMode mode = getMode();         
            switch (mode) 
            {
            	case DISC:
            		return 2;
            	case CLIMA_LOW:
                    return 3;
                case CLIMA_MED:
                    return 9;
                case CLIMA_HIGH:
                    return 15;
                case CLIMA_LOW_DISC:
                	return 5;
                case CLIMA_MED_DISC:
                	return 11;
                case CLIMA_HIGH_DISC:
                	return 17;
                default:
                    return 9;
            }
        } else return getIdleFuelUse();        
    }
    
    public int getMoreGoJuice() {
        if (cartBattery.getCharge() > CHARGE_USE_PER_REQUEST) {
            cartBattery.removeCharge(CHARGE_USE_PER_REQUEST);
            return FUEL_PER_REQUEST;
        }
        return 0;
    }
    
    @Override
    protected void moveAlongTrack(BlockPos pos, IBlockState state) {
        super.moveAlongTrack(pos, state);
        if (Game.isClient(worldObj))
            return;
        cartBattery.tickOnTrack(this, pos);
    }
    
    @Override
    public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
        return capability == CapabilityCartBattery.CHARGE_CART_CAPABILITY || super.hasCapability(capability, facing);
    }
	
	@Override
	public void onUpdate() 
	{
        super.onUpdate();
        /*ItemStack stack = this.getStackInSlot(0);
        if (stack != null && this.discInserted && !this.isPlaying())
        {
        	startPlayRecord(stack.getItem());
        	setPlay(true);
        }*/
        update++;
        if (Game.isClient(worldObj))
            return;
        for (int i = 0; i < 7; i++)
        {
        	if (tempMode != i+1 && this.invFilter.getStackInSlot(i) != null)
	        {        		
	        	adjustTemperature(i);
	        }
        } 
        ItemStack stack = this.getStackInSlot(0);
        if (stack != null && stack.getItem() instanceof ItemRecord )
        {
        	if(getMode().hasDisc == false)
        	{        		
        		putDisc(true);
        		startPlayRecord(stack.getItem());
            	setPlay(true);
        		CouchMode mode = getMode();
        		switch(mode)
        		{       			
        			case CLIMA_LOW:
        				setMode(CouchMode.CLIMA_LOW_DISC);break;
        			case CLIMA_MED:
        				setMode(CouchMode.CLIMA_MED_DISC);break;
        			case CLIMA_HIGH:
        				setMode(CouchMode.CLIMA_HIGH_DISC);break;
        			case NONE:
        			default:
        				setMode(CouchMode.DISC);
        		}
        	}
        }
    	else
    	{
    		if(getMode().hasDisc == true)
    		{	
    			putDisc(false);
    			CouchMode mode = getMode();
	    		switch(mode)
	    		{       			
	    			case CLIMA_LOW_DISC:
	    				setMode(CouchMode.CLIMA_LOW);break;
	    			case CLIMA_MED_DISC:
	    				setMode(CouchMode.CLIMA_MED);break;
	    			case CLIMA_HIGH_DISC:
	    				setMode(CouchMode.CLIMA_HIGH);break;
	    			case DISC:
	    			default:
	    				setMode(CouchMode.NONE);
	    		}
    		}
    	}      
        cartBattery.tick(this);        
    	ItemStack battery = this.getStackInSlot(1);
    	cartBattery.tickBatteryItem(this, battery);
     
        updateFuel();
    }
	
	public void startPlayRecord(Item item)
	{
		if (item != null && item instanceof ItemRecord)
		{   
			ItemRecord record = (ItemRecord) item;
			int id = this.getEntityId();
			RCCPacketHandler.INSTANCE.sendToDimension(new CouchCartPlayMusic(Item.getIdFromItem(record), id), this.dimension);
		}		
	}
	
	protected void updateFuel() {
        if (update % FUEL_USE_INTERVAL == 0 && fuel > 0) {
            fuel -= getFuelUse();
            if (fuel < 0)
                fuel = 0;
        }
        while (fuel <= FUEL_USE_INTERVAL && getMode() != CouchMode.NONE) {
            int newFuel = getMoreGoJuice();
            if (newFuel <= 0)
                break;
            fuel += newFuel;
        }
        setHasFuel(fuel > 0);     
    }
	
	public void setHasFuel(boolean powered) {
        dataManager.set(HAS_FUEL, powered);
    }
	
	public boolean hasFuel() {
        return dataManager.get(HAS_FUEL);
    }
	
	public void setPlay(boolean play) {
        dataManager.set(IS_PLAYING, play);
    }
	
	public boolean isPlaying() {
        return dataManager.get(IS_PLAYING);
    }
	
	public boolean discIn()
	{
		return dataManager.get(DISC_IN);
	}
	
	public void putDisc(boolean disc)
	{
		dataManager.set(DISC_IN, disc);
	}
	
	@SuppressWarnings("unchecked")
    @Override
    public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
        if (capability == CapabilityCartBattery.CHARGE_CART_CAPABILITY)
            return (T) cartBattery;
        return super.getCapability(capability, facing);
    }

}
