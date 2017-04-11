package cz.hanakocz.rccosmetic.items;

import cz.hanakocz.rccosmetic.ClientProxy;
import cz.hanakocz.rccosmetic.RCCosmetic;
import mods.railcraft.client.render.models.resource.ModelManager;
import mods.railcraft.common.plugins.forge.LocalizationPlugin;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemTrainOperatorUniform extends ItemArmor
{
	public Item customCraftingMaterial = Item.getItemFromBlock(Blocks.WOOL);
	public int variable = 0;

	public ItemTrainOperatorUniform(String unlocalizedName, ArmorMaterial material, EntityEquipmentSlot type, int var) 
	{
	    super(material, 0, type);
	    setUnlocalizedName(unlocalizedName);
	    setCreativeTab(RCCosmetic.tabRCCos);
	    setRegistryName(unlocalizedName);
	    this.variable = var;
	    
	}
	
	@Override
    public String getUnlocalizedName() {
        return LocalizationPlugin.convertTag(super.getUnlocalizedName());
    }

	@SideOnly(Side.CLIENT)
    public void initModel() 
	{
        ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(getRegistryName(), "inventory"));
    }

    @Override
    public String getUnlocalizedName(ItemStack stack) {
        return getUnlocalizedName();
    }

	/*@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type)
	{
	    return RCCosmetic.MODID + ":textures/armor/" + this.textureName + ".png";
	}*/
	
	@Override 
	@SideOnly(Side.CLIENT) 
	public ModelBiped getArmorModel(EntityLivingBase entityLiving, ItemStack itemStack, EntityEquipmentSlot armorSlot, ModelBiped defaultArmor) 
	{
		 ModelBiped armorModel = null; 
		 if(itemStack != null)
		 {  
			 armorModel = ClientProxy.getArmorModel(armorSlot); 			 
			 if(armorModel != null)
			 { 	armorModel.bipedHead.showModel = armorSlot == EntityEquipmentSlot.HEAD; 
			 	armorModel.bipedHeadwear.showModel = armorSlot == EntityEquipmentSlot.HEAD; 
			 	armorModel.bipedBody.showModel = armorSlot == EntityEquipmentSlot.CHEST || armorSlot == EntityEquipmentSlot.LEGS; 
			 	armorModel.bipedRightArm.showModel = armorSlot == EntityEquipmentSlot.CHEST; 
			 	armorModel.bipedLeftArm.showModel = armorSlot == EntityEquipmentSlot.CHEST; 
			 	armorModel.bipedRightLeg.showModel = armorSlot == EntityEquipmentSlot.LEGS || armorSlot == EntityEquipmentSlot.FEET; 
			 	armorModel.bipedLeftLeg.showModel = armorSlot == EntityEquipmentSlot.LEGS || armorSlot == EntityEquipmentSlot.FEET; 
			 	armorModel.isSneak = entityLiving.isSneaking(); 
			 	armorModel.isRiding = entityLiving.isRiding(); 
			 	armorModel.isChild = entityLiving.isChild();
			 	armorModel.rightArmPose = defaultArmor.rightArmPose;
				armorModel.leftArmPose = defaultArmor.leftArmPose;
			 	//armorModel.heldItemRight = ((Object) entityLiving).getEquipmentInSlot(EntityEquipmentSlot.MAINHAND) != null ? 1 :0; 
			 	//if(entityLiving instanceof EntityPlayer)
			 	//{ armorModel.aimedBow =((EntityPlayer)entityLiving).getItemInUseDuration() > 2; 
			 	//} 			  
			 }
		 }
		return armorModel;
	}
	
	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, EntityEquipmentSlot slot, String type)
    {
		String capTexture;
		if (this.variable == 1)
		{
			capTexture = "rccosmetic:textures/models/armor/train_operator_red_cap.png";
		}
		else
		{
			capTexture = "rccosmetic:textures/models/armor/train_operator_cap.png";
		}
		switch (slot) 
		{ 
			case HEAD: return capTexture; 
			case CHEST: 			
			case FEET: return "rccosmetic:textures/models/armor/TrainOperator_layer_1.png";
			case LEGS: return "rccosmetic:textures/models/armor/TrainOperator_layer_2.png";
			default: return null; 
		}
    }

	@Override
	public boolean getIsRepairable(ItemStack item, ItemStack item2)
	{
		return item2.getItem() == Item.getItemFromBlock(Blocks.WOOL) ? true : super.getIsRepairable(item, item2);
		
	}

}



	
	

	

	

	
