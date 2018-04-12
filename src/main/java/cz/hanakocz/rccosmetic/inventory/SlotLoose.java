package cz.hanakocz.rccosmetic.inventory;

import javax.annotation.Nullable;

import cz.hanakocz.rccosmetic.entity.carts.EntityModelledCart;
import mods.railcraft.common.gui.slots.SlotRailcraft;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class SlotLoose extends SlotRailcraft
{
	public SlotLoose(IInventory inventoryIn, int index, int xPosition, int yPosition) 
	{
		super(inventoryIn, index, xPosition, yPosition);
	}
	
	@Override
	public boolean isItemValid(@Nullable ItemStack stack)
    {
        return EntityModelledCart.isLoose(stack);
    }

}
