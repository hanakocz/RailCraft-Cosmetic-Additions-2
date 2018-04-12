package cz.hanakocz.rccosmetic.inventory;

import mods.railcraft.common.gui.EnumGui;

public enum RCCEnumGui 
{
	OPEN_CART(true),
	WOOD_CART(true),
	COUCH_CART(true);
	
	private static final RCCEnumGui[] VALUES = values();
    private final boolean hasContainer;
	RCCEnumGui(boolean hasContainer) 
	{
        this.hasContainer = hasContainer;
    }

    public boolean hasContainer() 
    {
        return hasContainer;
    }

    public static RCCEnumGui fromOrdinal(int i) 
    {
        if (i < 0 || i >= VALUES.length)
            return null;
        return VALUES[i];
    }

}
