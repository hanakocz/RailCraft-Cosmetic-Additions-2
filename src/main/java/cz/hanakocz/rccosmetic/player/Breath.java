package cz.hanakocz.rccosmetic.player;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;

public class Breath 
{
	public static boolean whistleUsed(EntityPlayer player, Integer potency)
	{
		NBTTagCompound tag = player.getEntityData();
		
		int tagBreath = tag.getInteger("statBreath");		
		if (tagBreath >= potency)
		{
			tag.setInteger("statBreath", tagBreath - potency);
			return true;
		}
		else
		{
			return false;
		}
	}
}
