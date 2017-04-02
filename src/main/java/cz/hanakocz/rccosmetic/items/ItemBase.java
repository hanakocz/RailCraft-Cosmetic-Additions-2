package cz.hanakocz.rccosmetic.items;

import cz.hanakocz.rccosmetic.RCCosmetic;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemBase extends Item 
{

	protected String name;
	protected int meta = 0;

	public ItemBase(String name, int maxstack) 
	{
		this.name = name;
		maxStackSize = maxstack;
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(RCCosmetic.tabRCCos);
	}

	public void registerItemModel() 
	{
		RCCosmetic.proxy.registerItemRenderer(this, meta, name);
	}

	@Override
	public ItemBase setCreativeTab(CreativeTabs tab) 
	{
		super.setCreativeTab(tab);
		return this;
	}

}