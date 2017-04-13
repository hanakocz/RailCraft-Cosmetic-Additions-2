package cz.hanakocz.rccosmetic.blocks;

import cz.hanakocz.rccosmetic.blocks.BlockPlatform.EnumShape;
import cz.hanakocz.rccosmetic.blocks.tracks.TrackCobWeb;
import cz.hanakocz.rccosmetic.blocks.tracks.TrackGrass;
import mods.railcraft.common.blocks.tracks.ItemTrack;
import mods.railcraft.common.blocks.tracks.behaivor.TrackTypes;
import mods.railcraft.common.plugins.color.ColorPlugin;
import net.minecraft.block.Block;
import net.minecraft.block.BlockPlanks;
import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public final class BlocksInit 
{
	public static Block TrackGrass;
	public static Block TrackCobweb;
	public static Block PlatformFull;
	public static Block PlatformInner;
	public static Block PlatformOuter;
	public static Block PlatformEdge;
	
	public static final void init()
	{
		TrackGrass = register(new TrackGrass("track.grass", TrackTypes.ABANDONED.getTrackType()));
		TrackCobweb = register(new TrackCobWeb("track.cobweb", TrackTypes.ABANDONED.getTrackType()));
		PlatformFull = register(new BlockPlatform("platformfull", EnumShape.FULL));		
		PlatformInner = register(new BlockPlatform("platforminner", EnumShape.INNER));		
		PlatformOuter = register(new BlockPlatform("platformouter", EnumShape.OUTER));		
		PlatformEdge = register(new BlockPlatform("platformedge", EnumShape.EDGE));				
	}
	
	public static final void postInit()
	{
		((TrackGrass) TrackGrass).finalizeDefinition();
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
	
	@SideOnly(Side.CLIENT)
	public static void initModels()
	{
		((TrackGrass) TrackGrass).initModel();
		((TrackCobWeb) TrackCobweb).initModel();
		((BlockPlatform) PlatformFull).initModel();
		((BlockPlatform) PlatformInner).initModel();
		((BlockPlatform) PlatformOuter).initModel();
		((BlockPlatform) PlatformEdge).initModel();
	}

}
