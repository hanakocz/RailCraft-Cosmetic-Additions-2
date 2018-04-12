package cz.hanakocz.rccosmetic.inventory;

import cz.hanakocz.rccosmetic.entity.carts.EntityModelledCart;
import mods.railcraft.common.gui.slots.SlotRailcraft;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;

public class SlotWood extends SlotRailcraft
{
	public SlotWood(IInventory inventoryIn, int index, int xPosition, int yPosition) 
	{
		super(inventoryIn, index, xPosition, yPosition);
	}
	
	@Override
	public boolean isItemValid(ItemStack stack)
    {
        return EntityModelledCart.isWood(stack);
		
    }
}
