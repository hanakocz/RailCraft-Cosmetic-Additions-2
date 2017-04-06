package cz.hanakocz.rccosmetic.recipes;

import cz.hanakocz.rccosmetic.items.ItemsInit;
import mods.railcraft.common.blocks.machine.beta.EnumMachineBeta;
import mods.railcraft.common.items.Metal;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;

public class RecipesCarts 
{
	static ItemStack cartFlat = new ItemStack(ItemsInit.ModelledCartFlat);
	static ItemStack plateIronRC = Metal.IRON.getStack(Metal.Form.PLATE);
	static ItemStack blockTankRC = new ItemStack(EnumMachineBeta.TANK_IRON_VALVE.block(), 1, 1);
	static Object plating;
	
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
		ModelledCartContainer();
		ModelledCartWood();
		ModelledCartFlat();
		ModelledCartTanker();
		ModelledCartOpen();
	
	}

	private static void ModelledCartContainer() 
	{
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemsInit.ModelledCartContainer, 1),
				"x",
				"y",
				'x', "chestWood",
				'y', cartFlat));
		
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemsInit.ModelledCartContainer, 1),
				" x ",
				"yyy",
				"z z",
				'x', "chestWood",
				'y', plating,
				'z', "minecartWheelsIron"));
	}
	
	private static void ModelledCartWood()
	{
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemsInit.ModelledCartWood, 1), 
				"x x",
				" y ",
				'x', "stickIronSmallDouble",
				'y', cartFlat));		
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemsInit.ModelledCartWood, 1),
				"x x",
				"yyy",
				"z z",
				'x', "stickIronSmallDouble",
				'y', plating,
				'z', "minecartWheelsIron"));				
	}
	
	private static void ModelledCartFlat()
	{
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemsInit.ModelledCartFlat, 1),
				"xxx",
				"y y",
				'x', plating,
				'y', "minecartWheelsIron"));		
	}
	
	private static void ModelledCartTanker()
	{
		if(EnumMachineBeta.TANK_IRON_VALVE.isAvailable())
		{
			GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemsInit.ModelledCartTanker, 1),		
				"x",
				"y",
				'x', blockTankRC,
				'y', cartFlat));
			GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemsInit.ModelledCartTanker, 1),
					" T ",
					"xxx",
					"y y",
					'T', blockTankRC,
					'x', plating,
					'y', "minecartWheelsIron"));		
		}
		else
		{
			GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemsInit.ModelledCartTanker, 1),		
					"xxx",
					"xyx",
					"xxx",
					'x', "blockGlass",
					'y', cartFlat));
		}
		
	}
	
	private static void ModelledCartOpen()
	{
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemsInit.ModelledCartOpen, 1),
				"x",
				"y",
				'x', plating,
				'y', cartFlat));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemsInit.ModelledCartOpen, 1),
				" y ",
				"yyy",
				"z z",
				'y', plating,
				'z', "minecartWheelsIron"));
		
	}

}
