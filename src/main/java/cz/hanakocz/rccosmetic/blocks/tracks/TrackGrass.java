package cz.hanakocz.rccosmetic.blocks.tracks;

import java.util.Random;

import javax.annotation.Nullable;

import mods.railcraft.api.tracks.TrackType;
import mods.railcraft.common.blocks.RailcraftBlocks;
import mods.railcraft.common.blocks.tracks.flex.BlockTrackFlex;
import mods.railcraft.common.plugins.color.ColorPlugin;
import net.minecraft.block.BlockRail;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.color.IBlockColor;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemShears;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ColorizerGrass;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeColorHelper;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class TrackGrass extends BlockTrackFlex implements ColorPlugin.IColoredBlock
{
	public TrackGrass(String unlocalizedName, TrackType trackType) 
	{
		super(trackType);
		setRegistryName(unlocalizedName);
		setUnlocalizedName(unlocalizedName);
        
	}
	
	@SideOnly(Side.CLIENT)
    public void initModel() 
	{
        ModelLoader.setCustomModelResourceLocation(ItemBlock.getItemFromBlock(this), 0, new ModelResourceLocation(getRegistryName(), "inventory"));

	}
	
	@Override
	public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, @Nullable ItemStack heldItem, EnumFacing side, float sideX, float sideY, float sideZ)
    {
		if(heldItem != null)
		{

			if(heldItem.getItem() instanceof ItemShears)
			{
				int rand = new Random().nextInt(20);
				IBlockState stateout;
				if (rand < 1)
				{
					stateout = RailcraftBlocks.TRACK_FLEX_ABANDONED.getDefaultState().withProperty(BlockRail.SHAPE, state.getValue(BlockRail.SHAPE));
				}
				else
				{
					stateout = Blocks.RAIL.getDefaultState().withProperty(BlockRail.SHAPE, state.getValue(BlockRail.SHAPE));
				}				
				world.setBlockState(pos, stateout, 2);
				ItemStack itemstack = new ItemStack(Blocks.TALLGRASS, 1, 1);
				if (!world.isRemote)
				{
					world.spawnEntityInWorld(new EntityItem(world, pos.getX(),pos.getY(), pos.getZ(), itemstack));
				}
				heldItem.damageItem(1, player);
				return true;
			}
			else
			{
				return false;
			}
		}		
		else
		{
			return false;
		}		
    }
	
	@Override
    public IBlockColor colorHandler() 
	{
        return (state, worldIn, pos, tintIndex) -> worldIn != null && pos != null ? BiomeColorHelper.getGrassColorAtPos(worldIn, pos) : ColorizerGrass.getGrassColor(0.5D, 1.0D);
    }
	
	@Override
    public void finalizeDefinition() 
	{
        ColorPlugin.instance.register(this, this);
    }


}

