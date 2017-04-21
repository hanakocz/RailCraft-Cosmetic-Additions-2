package cz.hanakocz.rccosmetic.items;

import java.util.Random;

import com.mojang.authlib.GameProfile;

import cz.hanakocz.rccosmetic.RCCosmetic;
import cz.hanakocz.rccosmetic.entity.carts.EntityCartCage;
import cz.hanakocz.rccosmetic.entity.carts.EntityCartContainer;
import cz.hanakocz.rccosmetic.entity.carts.EntityCartFlat;
import cz.hanakocz.rccosmetic.entity.carts.EntityCartOpen;
import cz.hanakocz.rccosmetic.entity.carts.EntityCartPanzer;
import cz.hanakocz.rccosmetic.entity.carts.EntityCartTanker;
import cz.hanakocz.rccosmetic.entity.carts.EntityCartTender;
import cz.hanakocz.rccosmetic.entity.carts.EntityCartWood;
import cz.hanakocz.rccosmetic.entity.carts.EntityModelledCarriage;
import cz.hanakocz.rccosmetic.entity.carts.EntityModelledCart;
import cz.hanakocz.rccosmetic.entity.carts.EntityModelledTanker;
import cz.hanakocz.rccosmetic.player.PlayerTools;
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
       
        if (Game.isHost(world) && !CartToolsAPI.isMinecartAt(world, pos, 0))
        {          
        	pos.offset(EnumFacing.EAST, (int) 0.5);
        	int rand = new Random().nextInt(9);
        	switch(type)
        	{
        		case(0):
        		{
        			EntityCartOpen entityminecart = new EntityCartOpen(world, pos, rand);                        
        			if (item.hasDisplayName())
                    {
                        entityminecart.setCustomNameTag(item.getDisplayName());
                    }
                    world.spawnEntityInWorld(entityminecart);                    
                    if (entityminecart != null) 
        			{
                        item.stackSize--;
                    }
        			return EnumActionResult.SUCCESS;
        		}
        		case(1):
        		{
        			EntityCartTanker entityminecart = new EntityCartTanker(world, pos, rand);                        
        			if (item.hasDisplayName())
                    {
                        entityminecart.setCustomNameTag(item.getDisplayName());
                    }
                    world.spawnEntityInWorld(entityminecart);
                    if (entityminecart != null) 
        			{
                        item.stackSize--;
                    }
                    return EnumActionResult.SUCCESS;
        		}
        		case(2):
        		{        		        			
        			EntityCartWood entityminecart = new EntityCartWood(world, pos, rand);                        
        			if (item.hasDisplayName())
                    {
                        entityminecart.setCustomNameTag(item.getDisplayName());
                    }
                    world.spawnEntityInWorld(entityminecart);
        			if (entityminecart != null) 
        			{
                        item.stackSize--;
                    }
        			return EnumActionResult.SUCCESS;
        		}
        		case(3):
        		{        		        			
        			EntityCartFlat entityminecart = new EntityCartFlat(world, pos, rand);                        
        			if (item.hasDisplayName())
                    {
                        entityminecart.setCustomNameTag(item.getDisplayName());
                    }
                    world.spawnEntityInWorld(entityminecart);
        			if (entityminecart != null) 
        			{
                        item.stackSize--;
                    }
        			return EnumActionResult.SUCCESS;
        		}
        		case(4):
        		{        		        			
        			EntityCartPanzer entityminecart = new EntityCartPanzer(world, pos, rand);                        
        			if (item.hasDisplayName())
                    {
                        entityminecart.setCustomNameTag(item.getDisplayName());
                    }
                    world.spawnEntityInWorld(entityminecart);
        			if (entityminecart != null) 
        			{
                        item.stackSize--;
                    }
        			return EnumActionResult.SUCCESS;
        		}       			
        		case(5):
        		{        		        			
        			EntityCartContainer entityminecart = new EntityCartContainer(world, pos, rand);                        
        			if (item.hasDisplayName())
                    {
                        entityminecart.setCustomNameTag(item.getDisplayName());
                    }
                    world.spawnEntityInWorld(entityminecart);
        			if (entityminecart != null) 
        			{
                        item.stackSize--;
                    }
        			return EnumActionResult.SUCCESS;
        		}
        		case(6):        		
        		{        		        			
        			EntityCartTender entityminecart = new EntityCartTender(world, pos, rand);                        
        			if (item.hasDisplayName())
                    {
                        entityminecart.setCustomNameTag(item.getDisplayName());
                    }
                    world.spawnEntityInWorld(entityminecart);
        			if (entityminecart != null) 
        			{
                        item.stackSize--;
                    }
        			return EnumActionResult.SUCCESS;
        		}
        		
        		case(7):
        		{
        			EntityCartCage entityminecart = new EntityCartCage(world, pos, rand);                        
        			if (item.hasDisplayName())
                    {
                        entityminecart.setCustomNameTag(item.getDisplayName());
                    }
                    world.spawnEntityInWorld(entityminecart);
        			if (entityminecart != null) 
        			{
                        item.stackSize--;
                    }
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
				int rand = new Random().nextInt(9);
				switch(type)
	            {
	        		case(0):
	        		{
	        			EntityCartOpen cart = new EntityCartOpen(world, pos, rand);                        
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
	        			EntityCartTanker cart = new EntityCartTanker(world, pos, rand);                        
	        			if (item.hasDisplayName())
	                    {
	                        cart.setCustomNameTag(item.getDisplayName());
	                    }
	        			CartToolsAPI.setCartOwner(cart, owner);
	                    if (world.spawnEntityInWorld(cart))	                       
	                    	return cart;
	        		}
	        		case(2):
	        		{
	        			EntityCartWood cart = new EntityCartWood(world, pos, rand);                        
	        			if (item.hasDisplayName())
	                    {
	                        cart.setCustomNameTag(item.getDisplayName());
	                    }
	        			CartToolsAPI.setCartOwner(cart, owner);
	                    if (world.spawnEntityInWorld(cart))
	                    	return cart;
	        		}
	        		case(3):
	        		{
	        			EntityCartFlat cart = new EntityCartFlat(world, pos, rand);                        
	        			if (item.hasDisplayName())
	                    {
	                        cart.setCustomNameTag(item.getDisplayName());
	                    }
	        			CartToolsAPI.setCartOwner(cart, owner);
	                    if (world.spawnEntityInWorld(cart))
	                    	return cart;
	        		}
	        		case(4):
	        		{
	        			EntityCartPanzer cart = new EntityCartPanzer(world, pos, rand);                        
	        			if (item.hasDisplayName())
	                    {
	                        cart.setCustomNameTag(item.getDisplayName());
	                    }
	        			CartToolsAPI.setCartOwner(cart, owner);
	                    if (world.spawnEntityInWorld(cart))
	                    	return cart;
	        		}
	        		case(5):
	        		{
	        			EntityCartContainer cart = new EntityCartContainer(world, pos, rand);                        
	        			if (item.hasDisplayName())
	                    {
	                        cart.setCustomNameTag(item.getDisplayName());
	                    }
	        			CartToolsAPI.setCartOwner(cart, owner);
	                    if (world.spawnEntityInWorld(cart))
	                    	return cart;
	        		}
	        		case(6):	        		
	        		{
	        			EntityCartTender cart = new EntityCartTender(world, pos, rand);                        
	        			if (item.hasDisplayName())
	                    {
	                        cart.setCustomNameTag(item.getDisplayName());
	                    }
	        			CartToolsAPI.setCartOwner(cart, owner);
	                    if (world.spawnEntityInWorld(cart))
	                    	return cart;
	        		}	        		
	        		case(7):
	        		{
	        			EntityCartCage cart = new EntityCartCage(world, pos, rand);                        
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
