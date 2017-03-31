package cz.hanakocz.rccosmetic;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class SoundEffects 
{
	public static SoundEvent whistleSound;
	
	private static SoundEvent registerSound(String soundName) 
	{
		ResourceLocation soundID = new ResourceLocation(RCCosmetic.MODID, soundName);
		return GameRegistry.register(new SoundEvent(soundID).setRegistryName(soundID));
	}
	
	public static void init() 
	{
		whistleSound = registerSound("whistle");

	}

}
