package cz.hanakocz.rccosmetic.items;

import cz.hanakocz.rccosmetic.ClientProxy;
import cz.hanakocz.rccosmetic.RCCosmetic;
import cz.hanakocz.rccosmetic.SoundEffects;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.entity.item.EntityEnderEye;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemWhistle extends Item
{
	
	public ItemWhistle(String unlocalizedName)
	{
		this.maxStackSize = 1;
        setCreativeTab(RCCosmetic.tabRCCos);
        setUnlocalizedName(unlocalizedName);
        setRegistryName(unlocalizedName);
        //this.setTextureName(RCCosmetic.MODID + ":" + "whistle");

		
	}
	
	@SideOnly(Side.CLIENT)
    public void initModel() 
	{
        ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(getRegistryName(), "inventory"));
    }
	
	@Override
	public EnumActionResult onItemUse(ItemStack stack, EntityPlayer playerIn, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
    {
		
        return EnumActionResult.FAIL;
    }
	

    /*{
		playerIn.setItemInUse(itemStackIn, this.getMaxItemUseDuration(itemStackIn));
		worldIn.playSoundAtEntity(playerIn, RCCosmetic.MODID + ":whistleSound", 1.0F, 1.0F);
        return item;
    }*/
	
	public ActionResult<ItemStack> onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn, EnumHand hand)
    { 
        if (!worldIn.isRemote)
        {
            {
                worldIn.playSound(playerIn, playerIn.posX, playerIn.posY, playerIn.posZ, SoundEffects.whistleSound, SoundCategory.MASTER, 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));
                //worldIn.playEvent((EntityPlayer)null, 1003, new BlockPos(playerIn), 0);

                if (!playerIn.capabilities.isCreativeMode)
                {
                    --itemStackIn.stackSize;
                }

                playerIn.addStat(StatList.getObjectUseStats(this));
                return new ActionResult(EnumActionResult.SUCCESS, itemStackIn);
            }
        }

        return new ActionResult(EnumActionResult.FAIL, itemStackIn);
    
    }
	
	public int getMaxItemUseDuration(ItemStack p_77626_1_)
    {
        return 72000;
    }

}
