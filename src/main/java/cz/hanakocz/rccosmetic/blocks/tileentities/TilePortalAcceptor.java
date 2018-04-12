package cz.hanakocz.rccosmetic.blocks.tileentities;

import java.util.List;

import mods.railcraft.api.carts.CartToolsAPI;
import mods.railcraft.common.blocks.detector.BlockDetector;
import mods.railcraft.common.blocks.detector.TileDetector;
import mods.railcraft.common.blocks.machine.manipulator.TileDispenserCart;
import mods.railcraft.common.carts.CartConstants;
import mods.railcraft.common.plugins.forge.PowerPlugin;
import mods.railcraft.common.plugins.forge.WorldPlugin;
import mods.railcraft.common.util.misc.Game;
import net.minecraft.entity.item.EntityMinecart;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumFacing;

public class TilePortalAcceptor extends TileDetector
{
	EnumFacing facing;
	List<NBTTagCompound> tags;
	DamageSource portal = new DamageSource("portal");
	
	public TilePortalAcceptor()
	{
		
	}

	public void getCartIn()
	{
		List<EntityMinecart> carts = CartToolsAPI.getMinecartsOnSide(getWorld(), pos, SENSITIVITY, facing);


		for (int i = 0; i < carts.size(); i++)
		{
			if (carts.get(i) != null)
			{
				NBTTagCompound tag = carts.get(i).getEntityData();
				tags.add(tag);
				carts.get(i).killMinecart(portal);
			}			
		}		
	}
	
	@Override
    public NBTTagCompound writeToNBT(NBTTagCompound data) 
	{
        super.writeToNBT(data);
        for (int i = 0; i < tags.size(); i++)
        {
        	data.setTag("cart" + i, tags.get(i));
        }
        return data;
    }
	
	@Override
    public void update() 
	{
        super.update();
        if (Game.isClient(getWorld()))
            return;
        if (this.isPowered())
        {
        	getCartIn();
        }
        
    }
	
	
}
