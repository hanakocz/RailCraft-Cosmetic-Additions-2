package cz.hanakocz.rccosmetic.items;

import java.util.Random;

import com.mojang.authlib.GameProfile;

import cz.hanakocz.rccosmetic.RCCosmetic;
import cz.hanakocz.rccosmetic.entity.carts.EntityModelledCart;
import cz.hanakocz.rccosmetic.entity.carts.EntityModelledTanker;
import mods.railcraft.api.carts.CartToolsAPI;
import mods.railcraft.api.core.items.IMinecartItem;
import mods.railcraft.common.blocks.tracks.TrackTools;
import mods.railcraft.common.carts.CartTools;
import mods.railcraft.common.core.RailcraftConfig;
import mods.railcraft.common.util.misc.Game;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.entity.item.EntityMinecart;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemCart extends Item implements IMinecartItem
{
	private int type;    
    public int minecartType;

    public ItemCart(String unlocalizedName, int cartType) 
    {
    	this.type = cartType;
        this.maxStackSize = RailcraftConfig.getMinecartStackSize();
        this.minecartType = -1;
        setCreativeTab(RCCosmetic.tabRCCos);
        setUnlocalizedName(unlocalizedName);
        setRegistryName(unlocalizedName);       
    }
    
    @SideOnly(Side.CLIENT)
    public void initModel() 
	{
        ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(getRegistryName(), "inventory"));
    }
   
    @Override
    public EnumActionResult onItemUse(ItemStack item, EntityPlayer player, World world, BlockPos pos, EnumHand hand, EnumFacing facing, float px, float py, float pz)
    {
    	if (!TrackTools.isRailBlockAt(world, pos))
            return EnumActionResult.FAIL;
       
        if (Game.isHost(world))
        {            	
        	switch(type)
        	{
        		case(0):
        		case(2):
        		case(3):
        		case(4):
        		case(5):
        		case(6):
        		{
        			pos.offset(EnumFacing.EAST, (int) 0.5);
        			int rand = new Random().nextInt(9);
        			EntityModelledCart entityminecart = new EntityModelledCart(world, (double)((float)pos.getX() + 0.5F), (double)((float)pos.getY() + 0.5F), (double)((float)pos.getZ() + 0.5F), type, rand);                        
        			if (item.hasDisplayName())
                    {
                        entityminecart.setCustomNameTag(item.getDisplayName());
                    }
                    world.spawnEntityInWorld(entityminecart);
        			if (entityminecart != null) {
                        item.stackSize--;
                    }
        			return EnumActionResult.SUCCESS;
        		}
        		case(1):
        		{
        			int rand = new Random().nextInt(9);
        			EntityModelledTanker entitytankminecart = new EntityModelledTanker(world, (double)((float)pos.getX() + 0.5F), (double)((float)pos.getY() + 0.5F), (double)((float)pos.getZ() + 0.5F), type, rand);                        
        			if (item.hasDisplayName())
                    {
                        entitytankminecart.setCustomNameTag(item.getDisplayName());
                    }
                    world.spawnEntityInWorld(entitytankminecart);
                    --item.stackSize;
                    return EnumActionResult.SUCCESS;
        		}
        		default:
        		{
        			return EnumActionResult.FAIL;
        		}            			
        	}
        }
		return EnumActionResult.FAIL;               		
    }

	@Override
	public boolean canBePlacedByNonPlayer(ItemStack paramItemStack) 
	{
		return true;
	}

	@Override
	public EntityMinecart placeCart(GameProfile owner, ItemStack item, World world, BlockPos pos) 
	{		
		IBlockState state = world.getBlockState(pos);
		if (TrackTools.isRailBlock(state))
		{
			if (!CartToolsAPI.isMinecartAt(world, pos, 0))
			{
				switch(type)
	            {
	        		case(0):
	        		case(2):
	        		case(3):
	        		case(4):
	        		case(5):
	        		case(6):
	        		{
	        			int rand = new Random().nextInt(9);
	        			EntityModelledCart cart = new EntityModelledCart(world, (double)((float)pos.getX() + 0.5F), (double)((float)pos.getY() + 0.5F), (double)((float)pos.getZ() + 0.5F), type, rand);                        
	        			if (item.hasDisplayName())
	                    {
	                        cart.setCustomNameTag(item.getDisplayName());
	                    }
	        			CartToolsAPI.setCartOwner(cart, owner);
	                    if (world.spawnEntityInWorld(cart))
	                    	return cart;
	        		}
	        		case(1):
	        		{
	        			int rand = new Random().nextInt(9);
	        			EntityModelledTanker cart = new EntityModelledTanker(world, (double)((float)pos.getX() + 0.5F), (double)((float)pos.getY() + 0.5F), (double)((float)pos.getZ() + 0.5F), type, rand);                        
	        			if (item.hasDisplayName())
	                    {
	                        cart.setCustomNameTag(item.getDisplayName());
	                    }
	        			CartToolsAPI.setCartOwner(cart, owner);
	                    if (world.spawnEntityInWorld(cart))	                       
	                    	return cart;
	        		}
	        		default:
	        		{
	        			return null;
	        		}
				
	            }
			}
		}
		return null;
	}

}
