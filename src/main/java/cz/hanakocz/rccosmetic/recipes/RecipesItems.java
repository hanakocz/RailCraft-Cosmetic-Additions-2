package cz.hanakocz.rccosmetic.recipes;

import cz.hanakocz.rccosmetic.items.ItemsInit;
import mods.railcraft.common.items.Metal;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;

public class RecipesItems 
{	
	static ItemStack plateIronRC = Metal.IRON.getStack(Metal.Form.PLATE);
	
	public static final void init()
	{
		ItemStack lightbluewool = new ItemStack(Blocks.WOOL, 1, 3);
		ItemStack graywool = new ItemStack(Blocks.WOOL, 1, 7);
		ItemStack yellowwool = new ItemStack(Blocks.WOOL, 1, 4);
		
		DoubleRodIron();
				
		GameRegistry.addRecipe(new ItemStack(ItemsInit.TrainOperatorCap, 1), 
				"xxx",
				"y y",
				'x', graywool,
				'y', yellowwool);
		GameRegistry.addRecipe(new ItemStack(ItemsInit.TrainOperatorChest, 1),
				"x x",
				"xyx",
				"xxx",
				'x', graywool,
				'y', lightbluewool);
		GameRegistry.addRecipe(new ItemStack(ItemsInit.TrainOperatorLegs, 1),
				"xxx",
				"x x",
				"x x",
				'x', graywool);
		GameRegistry.addRecipe(new ItemStack(ItemsInit.TrainOperatorBoots, 1),
				"x x",
				"x x",
				'x', graywool);
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemsInit.Wheels, 2),
				"x x",
				'x', "ingotIron"));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemsInit.Whistle, 1), 
				"x",
				"x",
				'x', "ingotIron"));		
	}
	
	public static void DoubleRodIron()
	{
		if (OreDictionary.doesOreNameExist("stickIron"))
		{
			GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemsInit.DoubleRodIron, 1),
				"x",
				'x', "stickIron"));
		}
		else
		{
			GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemsInit.DoubleRodIron, 2),
					"x",
					'x', plateIronRC));
		}		
	}
}
