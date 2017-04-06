package cz.hanakocz.rccosmetic.recipes;

import cz.hanakocz.rccosmetic.items.ItemsInit;
import mods.railcraft.common.items.Metal;
import mods.railcraft.common.items.RailcraftItems;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;

public class RecipesItems 
{	
	static ItemStack plateIronRC = Metal.IRON.getStack(Metal.Form.PLATE);
	static Object plating;
	static ItemStack lightbluewool = new ItemStack(Blocks.WOOL, 1, 3);
	static ItemStack graywool = new ItemStack(Blocks.WOOL, 1, 7);
	static ItemStack redwool = new ItemStack(Blocks.WOOL, 1, 14);
	static ItemStack yellowwool = new ItemStack(Blocks.WOOL, 1, 4);
	
	public static final void init()
	{	
		if (plateIronRC != null)
		{
			plating = plateIronRC;
		}
		else
		{
			plating = "ingotIron";
		}
		DoubleRodIron();
		TrainOperatorCap();
		TrainOperatorChest();
		TrainOperatorLegs();
		TrainOperatorBoots();
	
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemsInit.Wheels, 2),
				"x x",
				'x', "ingotIron"));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemsInit.Whistle, 1), 
				"x",
				"x",
				'x', "ingotSilver"));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemsInit.HandDepartSignal, 1),
				"gpb",
				" s ",
				" s ",
				'g', "dyeGreen",
				'p', plating,
				'b', "dyeWhite",
				's', "stickWood"));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemsInit.HandStopSignal, 1),
				"gpb",
				" s ",
				" s ",
				'g', "dyeRed",
				'p', plating,
				'b', "dyeWhite",
				's', "stickWood"));
	}
	private static void TrainOperatorBoots()
	{
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemsInit.TrainOperatorBoots, 1),
				"x x",
				"xsx",
				'x', graywool,
				's', "string"));
	}
	private static void TrainOperatorLegs()
	{
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemsInit.TrainOperatorLegs, 1),
				"xxx",
				"xsx",
				"x x",
				'x', graywool,
				's', "string"));
	}
	
	private static void TrainOperatorChest()
	{
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemsInit.TrainOperatorChest, 1),
				"xsx",
				"xyx",
				"xxx",
				'x', graywool,
				'y', lightbluewool,
				's', "string"));		
	}
	
	private static void TrainOperatorCap()
	{		
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemsInit.TrainOperatorCap, 1), 
				"xxx",
				"ysy",
				'x', graywool,
				'y', yellowwool,
				's', "string"));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemsInit.TrainOperatorRedCap, 1), 
				"xxx",
				"ysy",
				'x', redwool,
				'y', yellowwool,
				's', "string"));
	}
	
	private static void DoubleRodIron()
	{
		if (OreDictionary.doesOreNameExist("stickIron"))
		{
			GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemsInit.DoubleRodIron, 2),
				"xx",
				'x', "stickIron"));
		}
		else
		{
			GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemsInit.DoubleRodIron, 4),
					"xx",
					'x', plating)); //when ingots, it collides with trapdoors!
		}
	}
}
