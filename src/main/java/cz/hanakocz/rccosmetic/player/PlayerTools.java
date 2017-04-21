package cz.hanakocz.rccosmetic.player;

import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class PlayerTools 
{
	public static boolean consumeItems(IInventory inventory, Item item, int count)
	{
	    boolean flag = false;
	    for (int slot = 0, remain = count; slot < inventory.getSizeInventory(); ++slot)
	    {
		    ItemStack itemstack = inventory.getStackInSlot(slot);
		    if (itemstack != null && itemstack.getItem() == item)
		    {
			    if ((remain -= itemstack.stackSize) <= 0)
			    {
				    flag = true;
				    break;
			    }
		    }
	    }
	    if (flag)
	    {
		    for (int slot = 0; count > 0 && slot < inventory.getSizeInventory(); ++slot)
		    {
			    ItemStack itemstack = inventory.getStackInSlot(slot);
			    if (itemstack != null && itemstack.getItem() == item)
			    {
				    if ((count -= itemstack.stackSize) >= 0)
				    {
					    inventory.setInventorySlotContents(slot, (ItemStack)null);
				    } else {
					    itemstack.stackSize = -count;
				    }
			    }
		    }
	    }
	    return flag;
	}

}
