package cz.hanakocz.rccosmetic.inventory;

import javax.annotation.Nullable;

import cz.hanakocz.rccosmetic.entity.carts.EntityCartCouch;
import cz.hanakocz.rccosmetic.entity.carts.EntityCartWood;
import mods.railcraft.common.blocks.charge.CapabilityCartBattery;
import mods.railcraft.common.blocks.charge.ICartBattery;
import mods.railcraft.common.carts.EntityLocomotive;
import mods.railcraft.common.carts.EntityLocomotiveElectric;
import mods.railcraft.common.gui.containers.RailcraftContainer;
import mods.railcraft.common.gui.slots.SlotEnergy;
import mods.railcraft.common.gui.slots.SlotRailcraft;
import mods.railcraft.common.gui.widgets.ChargeIndicator;
import mods.railcraft.common.gui.widgets.IndicatorWidget;
import mods.railcraft.common.plugins.forge.PlayerPlugin;
import mods.railcraft.common.util.inventory.InvTools;
import mods.railcraft.common.util.network.PacketBuilder;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.ClickType;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IContainerListener;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IStringSerializable;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ContainerCartCouch extends RailcraftContainer
{   
	private final EntityCartCouch cart;
	private final ICartBattery chargeHandler;
    private final ChargeIndicator chargeIndicator;
    private double lastCharge;
    
	public ContainerCartCouch(InventoryPlayer playerInventory, EntityCartCouch cart)
    {
		super(cart);
		this.cart = cart;
		this.chargeHandler = cart.getCapability(CapabilityCartBattery.CHARGE_CART_CAPABILITY, null);
        this.chargeIndicator = new ChargeIndicator(EntityCartCouch.MAX_CHARGE);

        defineSlotsAndWidgets();
        addSlot(new SlotDisc(cart, 0, 13, 18));
        addSlot(new SlotEnergy(cart, 1, 53, 18));
        for (int k = 0; k < 7; ++k)
        {
            addSlot(new SlotSelector(cart.getFilterInv(), k , 26 + k * 18 , 47));
        }        
        
        for (int i = 0; i < 3; i++) 
        {
            for (int k = 0; k < 9; k++) 
            {
                addSlot(new Slot(playerInventory, k + i * 9 + 9, 8 + k * 18, 161 - 82 + i * 18));
            }
        }
        for (int j = 0; j < 9; j++) 
        {
            addSlot(new Slot(playerInventory, j, 8 + j * 18, 161 - 24));
        }      
    }
	
	public void defineSlotsAndWidgets() {
        addWidget(new IndicatorWidget(chargeIndicator, 77, 22, 176, 0, 62, 8, false));
    }
	
	@Override
    public void addListener(IContainerListener listener) 
	{
        super.addListener(listener);

        listener.sendProgressBarUpdate(this, 20, (int) Math.round(chargeHandler.getCharge()));
    }
	
	@Override
    public void sendUpdateToClient() {
        super.sendUpdateToClient();

        for (IContainerListener var2 : listeners) {
            if (lastCharge != chargeHandler.getCharge())
                var2.sendProgressBarUpdate(this, 21, (int) Math.round(chargeHandler.getCharge()));
        }
        lastCharge = chargeHandler.getCharge();
    }
	
	@Override
    @SideOnly(Side.CLIENT)
    public void updateProgressBar(int id, int value) {
        super.updateProgressBar(id, value);
        switch (id) {
            case 20:
                chargeIndicator.setCharge(value);
                break;
            case 21:
                chargeIndicator.updateCharge(value);
                break;
        }
    }
	
	@Nullable
    @Override
    public ItemStack slotClick(int slotId, int mouseButton, ClickType clickType, EntityPlayer player) {
        Slot slot = slotId < 0 ? null : inventorySlots.get(slotId);
        if (slot instanceof SlotSelector && ((SlotSelector) slot).isPhantom())
            return slotClickPhantomSelector((SlotSelector) slot, slotId, mouseButton, clickType, player);
        return super.slotClick(slotId, mouseButton, clickType, player);
    }
	
	@Nullable
	private ItemStack slotClickPhantomSelector(SlotSelector slot, int id, int mouseButton, ClickType clickType, EntityPlayer player) {
        ItemStack stack = null;       
        //System.out.println(id);
        Slot slotheat3 = inventorySlots.get(2);
        Slot slotheat2 = inventorySlots.get(3);
        Slot slotheat1 = inventorySlots.get(4);
        Slot slotoff = inventorySlots.get(5);
        Slot slotcool1 = inventorySlots.get(6);
        Slot slotcool2 = inventorySlots.get(7);
        Slot slotcool3 = inventorySlots.get(8);
                              
        if (id == 2 || id == 3 || id == 4 || id == 5 || id == 6 || id == 7 || id == 8)
        {
        	slotheat3.putStack(null);
        	slotheat2.putStack(null);
        	slotheat1.putStack(null);
        	slotoff.putStack(null);
        	slotcool1.putStack(null);
        	slotcool2.putStack(null);
        	slotcool3.putStack(null);
        }
        switch(id)
        {
        	case(2): fillPhantomSlot(slot, EnumHeating.COOLING3.getItem(), mouseButton); break;        	
        	case(3): fillPhantomSlot(slot, EnumHeating.COOLING2.getItem(), mouseButton); break;
        	case(4): fillPhantomSlot(slot, EnumHeating.COOLING1.getItem(), mouseButton); break;
        	case(5): fillPhantomSlot(slot, EnumHeating.OFF.getItem(), mouseButton); break;
        	case(6): fillPhantomSlot(slot, EnumHeating.HEATING1.getItem(), mouseButton); break;
        	case(7): fillPhantomSlot(slot, EnumHeating.HEATING2.getItem(), mouseButton); break;
        	case(8): fillPhantomSlot(slot, EnumHeating.HEATING3.getItem(), mouseButton); break;
        	default: break;
        }
        return stack;
    }
	
	private static enum EnumHeating 
    {
    	HEATING3(new ItemStack(Items.LAVA_BUCKET, 1).setStackDisplayName("Heating +5")),
    	HEATING2(new ItemStack(Items.BLAZE_ROD, 1).setStackDisplayName("Heating +3")),
    	HEATING1(new ItemStack(Items.FIRE_CHARGE, 1).setStackDisplayName("Heating +1")),
    	OFF(new ItemStack(Items.CLOCK, 1).setStackDisplayName("OFF")),
    	COOLING1(new ItemStack(Items.SNOWBALL, 1).setStackDisplayName("Cooling -1")),
    	COOLING2(new ItemStack(Blocks.SNOW, 1).setStackDisplayName("Cooling -3")),
    	COOLING3(new ItemStack(Blocks.PACKED_ICE, 1).setStackDisplayName("Cooling -5"));
    	
    	private final ItemStack item;

        private EnumHeating(ItemStack item)
        {
            this.item = item;
        }

        public ItemStack toItem()
        {
            return this.item;
        }

        public ItemStack getItem()
        {
            return this.item;
        }
    }
	
	private void fillPhantomSlot(SlotRailcraft slot, ItemStack stackHeld, int mouseButton) {
        if (!slot.canAdjustPhantom())
            return;
        int stackSize = mouseButton == 0 ? stackHeld.stackSize : 1;
        if (stackSize > slot.getSlotStackLimit())
            stackSize = slot.getSlotStackLimit();
        ItemStack phantomStack = stackHeld.copy();
        phantomStack.stackSize = stackSize;

        slot.putStack(phantomStack);
    }
	
	

}
