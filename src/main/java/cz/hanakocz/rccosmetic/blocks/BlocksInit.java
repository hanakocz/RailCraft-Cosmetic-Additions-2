package cz.hanakocz.rccosmetic.blocks;

import cz.hanakocz.rccosmetic.blocks.tracks.CosmeticTrackGrass;
import mods.railcraft.common.blocks.tracks.ItemTrack;
import mods.railcraft.common.blocks.tracks.behaivor.TrackTypes;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.registry.GameRegistry;

public final class BlocksInit 
{
	//public static Block TrackGrass;
	
	public static final void init()
	{
		//TrackGrass = register(new CosmeticTrackGrass("track.grass", TrackTypes.ABANDONED.getTrackType()));
		//((CosmeticTrackGrass) TrackGrass).initModel();
	}
	
	private static <T extends Block> T register(T block, ItemBlock itemBlock) 
	{
		GameRegistry.register(block);
		GameRegistry.register(itemBlock);
				
		return block;
	}

	private static <T extends Block> T register(T block) 
	{
		ItemBlock itemBlock = new ItemBlock(block);
		itemBlock.setRegistryName(block.getRegistryName());
		
		return register(block, itemBlock);
	}

}
