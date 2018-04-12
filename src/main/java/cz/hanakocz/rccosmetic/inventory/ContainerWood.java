package cz.hanakocz.rccosmetic.inventory;

import javax.annotation.Nullable;

import cz.hanakocz.rccosmetic.entity.carts.EntityCartWood;
import mods.railcraft.common.carts.EntityCartCargo;
import mods.railcraft.common.gui.containers.RailcraftContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.tileentity.TileEntityFurnace;

public class ContainerWood extends RailcraftContainer
{
    private final int numRows;
    
	public ContainerWood(InventoryPlayer playerInventory, EntityCartWood cart)
    {
		super(cart);

        this.numRows = cart.getSizeInventory() / 9;

        int i = (this.numRows - 4) * 18;

        for (int j = 0; j < this.numRows; ++j)
        {
            for (int k = 0; k < 9; ++k)
            {
                addSlot(new SlotWood(cart, k + j * 9, 8 + k * 18, 18 + j * 18));
            }
        }

        for (int l = 0; l < 3; ++l)
        {
            for (int j1 = 0; j1 < 9; ++j1)
            {
                addSlot(new Slot(playerInventory, j1 + l * 9 + 9, 8 + j1 * 18, 103 + l * 18 + i));
            }
        }

        for (int i1 = 0; i1 < 9; ++i1)
        {
            addSlot(new Slot(playerInventory, i1, 8 + i1 * 18, 161 + i));
        }
    }

}
