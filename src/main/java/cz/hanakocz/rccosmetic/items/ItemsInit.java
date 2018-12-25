package cz.hanakocz.rccosmetic.items;

import cz.hanakocz.rccosmetic.ClientProxy;
import cz.hanakocz.rccosmetic.RCCosmetic;
import cz.hanakocz.rccosmetic.entity.carts.EntityCartCage;
import cz.hanakocz.rccosmetic.entity.carts.EntityCartContainer;
import cz.hanakocz.rccosmetic.entity.carts.EntityCartCouch;
import cz.hanakocz.rccosmetic.entity.carts.EntityCartFlat;
import cz.hanakocz.rccosmetic.entity.carts.EntityCartOpen;
import cz.hanakocz.rccosmetic.entity.carts.EntityCartPanzer;
import cz.hanakocz.rccosmetic.entity.carts.EntityCartTanker;
import cz.hanakocz.rccosmetic.entity.carts.EntityCartTender;
import cz.hanakocz.rccosmetic.entity.carts.EntityCartWood;
import cz.hanakocz.rccosmetic.entity.carts.EntityModelledCarriage;
import cz.hanakocz.rccosmetic.entity.carts.EntityModelledCart;
import cz.hanakocz.rccosmetic.entity.carts.EntityModelledTanker;
import mods.railcraft.common.items.RailcraftItems;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.oredict.OreDictionary;

public final class ItemsInit 
{
	public static ItemArmor TrainOperatorCap;
	public static ItemArmor TrainOperatorRedCap;
	public static ItemArmor TrainOperatorChest;
	public static ItemArmor TrainOperatorLegs;
	public static ItemArmor TrainOperatorBoots;
	
	public static Item Whistle;
	public static Item Wheels;
	public static Item DoubleRodIron;
	public static Item HandDepartSignal;
	public static Item HandStopSignal;
	
	//Entity Items (Modelled Carts)
	public static ItemCart ModelledCartOpen;
	public static ItemCart ModelledCartTanker;
	public static ItemCart ModelledCartWood;
	public static ItemCart ModelledCartFlat;
	public static ItemCart ModelledCartPanzer;
	public static ItemCart ModelledCartContainer;
	public static ItemCart ModelledCartTender;
	public static ItemCart ModelledCartCage;
	public static ItemCart ModelledCartCouch;
	
	public static ArmorMaterial WOOL = EnumHelper.addArmorMaterial("WOOL_ARMOR", "train_operator", 5, new int[] {1, 3, 2, 1}, 15, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0F);
	
	public static final void init()
	{
		TrainOperatorCap = new ItemTrainOperatorUniform("train_operator_cap", WOOL, EntityEquipmentSlot.HEAD, 0);
		TrainOperatorRedCap = new ItemTrainOperatorUniform("train_operator_red_cap", WOOL, EntityEquipmentSlot.HEAD, 1);
		TrainOperatorChest = new ItemTrainOperatorUniform("train_operator_chest", WOOL, EntityEquipmentSlot.CHEST, 0);
		TrainOperatorLegs = new ItemTrainOperatorUniform("train_operator_legs", WOOL, EntityEquipmentSlot.LEGS, 0);
		TrainOperatorBoots = new ItemTrainOperatorUniform("train_operator_boots", WOOL, EntityEquipmentSlot.FEET, 0);
		ModelledCartOpen = new ItemCart("cart.modelled.open", 0);
		ModelledCartTanker = new ItemCart("cart.modelled.tanker", 1);
		ModelledCartWood = new ItemCart("cart.modelled.wood", 2);
		ModelledCartFlat = new ItemCart("cart.modelled.flat", 3);
		ModelledCartPanzer = new ItemCart("cart.modelled.panzer", 4);
		ModelledCartContainer = new ItemCart("cart.modelled.container", 5);
		ModelledCartTender = new ItemCart("cart.modelled.tender", 6);
		ModelledCartCage = new ItemCart("cart.modelled.cage", 7);
		ModelledCartCouch = new ItemCart("cart.modelled.couch", 8);
		
		Whistle = new ItemWhistle("whistle");
		Wheels = new ItemBase("wheels", 16);
		DoubleRodIron = new ItemBase("double_rod_iron", 64);
		HandDepartSignal = new ItemHandSignal("handdepartsignal", 1);
		HandStopSignal = new ItemHandSignal("handstopsignal", 1);
				
		
		//Register Items With Entities
		EntityRegistry.registerModEntity(EntityCartOpen.class, "cart.0", 0, RCCosmetic.instance, 256, 3, true);
		EntityRegistry.registerModEntity(EntityCartTanker.class, "cart.1", 1, RCCosmetic.instance, 256, 3, true);
		EntityRegistry.registerModEntity(EntityCartWood.class, "cart.2", 2, RCCosmetic.instance, 256, 3, true);
		EntityRegistry.registerModEntity(EntityCartFlat.class, "cart.3", 3, RCCosmetic.instance, 256, 3, true);
		EntityRegistry.registerModEntity(EntityCartPanzer.class, "cart.4", 4, RCCosmetic.instance, 256, 3, true);
		EntityRegistry.registerModEntity(EntityCartContainer.class, "cart.5", 5, RCCosmetic.instance, 256, 3, true);
		EntityRegistry.registerModEntity(EntityCartTender.class, "cart.6", 6, RCCosmetic.instance, 256, 3, true);
		EntityRegistry.registerModEntity(EntityCartCage.class, "cart.7", 7, RCCosmetic.instance, 256, 3, true);
		//EntityRegistry.registerModEntity(EntityCartCouch.class, "cart.8", 8, RCCosmetic.instance, 256, 3, true);
		
		register(ModelledCartOpen);
		register(ModelledCartTanker);
		register(ModelledCartWood);
		register(ModelledCartFlat);
		register(ModelledCartPanzer);
		register(ModelledCartContainer);
		//register(ModelledCartTender);
		register(ModelledCartCage);
		//register(ModelledCartCouch);
		
		register(TrainOperatorCap);
		register(TrainOperatorRedCap);
		register(TrainOperatorChest);
		register(TrainOperatorLegs);
		register(TrainOperatorBoots);
		register(Whistle);
		register(Wheels);
		register(DoubleRodIron);
		register(HandDepartSignal);
		register(HandStopSignal);
				
		OreDictionary.registerOre("minecartWheelsIron", Wheels);
		OreDictionary.registerOre("stickIronSmallDouble", DoubleRodIron);		
		
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
        ((ItemTrainOperatorUniform) TrainOperatorRedCap).initModel();
        ((ItemTrainOperatorUniform) TrainOperatorChest).initModel();
        ((ItemTrainOperatorUniform) TrainOperatorLegs).initModel();
        ((ItemTrainOperatorUniform) TrainOperatorBoots).initModel();
        ModelledCartOpen.initModel();
		ModelledCartTanker.initModel();
		ModelledCartWood.initModel();
		ModelledCartFlat.initModel();
		ModelledCartPanzer.initModel();
		ModelledCartContainer.initModel();
		ModelledCartTender.initModel();
		ModelledCartCage.initModel();
		ModelledCartCouch.initModel();
    }
}
