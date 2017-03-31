package cz.hanakocz.rccosmetic.items;

import cz.hanakocz.rccosmetic.ClientProxy;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public final class ItemsInit 
{
	public static ItemArmor TrainOperatorCap;
	public static ItemArmor TrainOperatorChest;
	public static ItemArmor TrainOperatorLegs;
	public static ItemArmor TrainOperatorBoots;
	
	public static Item Whistle;
	
	public static ArmorMaterial WOOL = EnumHelper.addArmorMaterial("WOOL_ARMOR", "train_operator", 5, new int[] {1, 3, 2, 1}, 15, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0F);
	
	public static final void init()
	{
		TrainOperatorCap = new ItemTrainOperatorUniform("train_operator_cap", WOOL, "rccosmetic:textures/models/armor/train_operator_cap", EntityEquipmentSlot.HEAD);
		TrainOperatorChest = new ItemTrainOperatorUniform("train_operator_chest", WOOL, "rccosmetic:textures/models/armor/TrainOperator_layer_1", EntityEquipmentSlot.CHEST);
		TrainOperatorLegs = new ItemTrainOperatorUniform("train_operator_legs", WOOL, "rccosmetic:textures/models/armor/TrainOperator_layer_2", EntityEquipmentSlot.LEGS);
		TrainOperatorBoots = new ItemTrainOperatorUniform("train_operator_boots", WOOL, "rccosmetic:textures/models/armor/TrainOperator_layer_1", EntityEquipmentSlot.FEET);
		
		Whistle = new ItemWhistle("whistle");
		
		
		register(TrainOperatorCap);
		register(TrainOperatorChest);
		register(TrainOperatorLegs);
		register(TrainOperatorBoots);
		register(Whistle);
		
	}
	
	private static <T extends Item> T register(T item) 
	{
		GameRegistry.register(item);
		if (item instanceof ItemBase) 
		{
			((ItemBase)item).registerItemModel();
		}
		return item;
	}

	@SideOnly(Side.CLIENT)
    public static void initModels() 
	{
        ((ItemWhistle) Whistle).initModel();
        ((ItemTrainOperatorUniform) TrainOperatorCap).initModel();
        ((ItemTrainOperatorUniform) TrainOperatorChest).initModel();
        ((ItemTrainOperatorUniform) TrainOperatorLegs).initModel();
        ((ItemTrainOperatorUniform) TrainOperatorBoots).initModel();
    }
}
