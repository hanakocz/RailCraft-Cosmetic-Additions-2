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
	
	public static final void init()
	{
		ModelledCartContainer();
		ModelledCartWood();
		
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemsInit.ModelledCartFlat, 1),
				"xxx",
				"y y",
				'x', plateIronRC,
				'y', "minecartWheelsIron"));
		GameRegistry.addRecipe(new ItemStack(ItemsInit.ModelledCartTanker, 1),
				"x",
				"y",
				'x', blockTankRC,
				'y', cartFlat);
		
		
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemsInit.ModelledCartOpen, 1),
				"x",
				"y",
				'x', plateIronRC,
				'y', cartFlat));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemsInit.ModelledCartTanker, 1),
				" T ",
				"xxx",
				"y y",
				'T', blockTankRC,
				'x', plateIronRC,
				'y', "minecartWheelsIron"));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemsInit.ModelledCartContainer, 1),
				" x ",
				"yyy",
				"z z",
				'x', "chestWood",
				'y', plateIronRC,
				'z', "minecartWheelsIron"));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemsInit.ModelledCartOpen, 1),
				" y ",
				"yyy",
				"z z",
				'y', plateIronRC,
				'z', "minecartWheelsIron"));
		
		
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
				'y', plateIronRC,
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
				'y', plateIronRC,
				'z', "minecartWheelsIron"));		
	}
	

}
