package cz.hanakocz.rccosmetic.inventory;

import java.util.function.BooleanSupplier;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import mods.railcraft.common.gui.slots.SlotRailcraft;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;

public class SlotSelector extends SlotRailcraft {

    @Nonnull
    public BooleanSupplier isEnabled = () -> true;

    public SlotSelector(IInventory iinventory, int slotIndex, int posX, int posY) {
        super(iinventory, slotIndex, posX, posY);
        setPhantom();
    }

    public SlotSelector(IInventory iinventory, int slotIndex, int posX, int posY, BooleanSupplier isEnabled) {
        this(iinventory, slotIndex, posX, posY);
        this.isEnabled = isEnabled;
    }

    @Override
    public boolean isItemValid(@Nullable ItemStack stack) {
        return isEnabled.getAsBoolean();
    }
}
