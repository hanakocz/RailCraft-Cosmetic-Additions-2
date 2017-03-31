package cz.hanakocz.rccosmetic.items;

import cz.hanakocz.rccosmetic.RCCosmetic;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemBase extends Item 
{

	protected String name;
	protected int meta = 0;

	public ItemBase(String name) 
	{
		this.name = name;
		setUnlocalizedName(name);
		setRegistryName(name);
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