package cz.hanakocz.rccosmetic.blocks;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PlatformConnectedList 
{

	public static Set<String> fenceAllowed = new HashSet<String>(); 
	public static Set<String> wallAllowed = new HashSet<String>();
	public static void init()
	{
		fences();
		walls();				
	}
	
	public static void fences()
	{
		List<String> list = Arrays.asList(
				//RCC
				"mods.railcraft_cos.common.blocks.BlockRailcraftSignBasic",
				"mods.railcraft_cos.common.blocks.BlockRailcraftCosSignalBase",
				//RC
				"mods.railcraft.common.blocks.aesthetics.post.BlockPostBase",
				//Vanilla				
				"net.minecraft.block.BlockFence",
				"net.minecraft.block.BlockEndRod");
		fenceAllowed.addAll(list);
	}
	
	public static void walls()
	{
		List<String> list = Arrays.asList(
				//Vanilla
				"net.minecraft.block.BlockWall",
				"net.minecraft.block.BlockSkull",
				//RC
				"mods.railcraft.common.blocks.aesthetics.wall.BlockRailcraftWall");
		wallAllowed.addAll(list);
	}
}
