package cz.hanakocz.rccosmetic.blocks;

import java.util.List;

import javax.annotation.Nullable;

import com.google.common.collect.Lists;

import cz.hanakocz.rccosmetic.RCCosmetic;
import mods.railcraft.api.core.items.ISpikeMaulTarget;
import mods.railcraft.api.tracks.TrackType;
import mods.railcraft.common.blocks.aesthetics.post.BlockPostBase;
import mods.railcraft.common.items.ItemCrowbar;
import mods.railcraft.common.items.ItemSpikeMaul;
import net.minecraft.block.Block;
import net.minecraft.block.BlockBanner;
import net.minecraft.block.BlockFence;
import net.minecraft.block.BlockFenceGate;
import net.minecraft.block.BlockHorizontal;
import net.minecraft.block.BlockRailBase.EnumRailDirection;
import net.minecraft.block.BlockSign;
import net.minecraft.block.BlockStairs;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BlockModelShapes;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.resources.I18n;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemShears;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockPlatform extends Block
{
	
	protected static final AxisAlignedBB PieceCenter = new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.75D, 1.0D);
	
	public static final PropertyDirection FACING = BlockHorizontal.FACING;
	public static final PropertyEnum<BlockPlatform.EnumTop> TOP = PropertyEnum.<BlockPlatform.EnumTop>create("top", BlockPlatform.EnumTop.class);
	public static final PropertyEnum<BlockPlatform.EnumShape> SHAPE = PropertyEnum.<BlockPlatform.EnumShape>create("shape", BlockPlatform.EnumShape.class);

	public BlockPlatform(String unlocalizedName, EnumShape shape)
	{
		super(Material.ROCK);
		this.setDefaultState(getMyBaseState(this.blockState.getBaseState(), shape));
		this.setSoundType(SoundType.STONE);
		setRegistryName(unlocalizedName);
		setUnlocalizedName(unlocalizedName);
		this.setCreativeTab(RCCosmetic.tabRCCos);
		this.setHardness(1.0F);
		this.setResistance(5.0F);
		this.setLightOpacity(30);
		this.setHarvestLevel("pickaxe", 1);

	}
	
	@Override
	public void addInformation(ItemStack stack, EntityPlayer player, List<String> tooltip, boolean advanced)
    {
		tooltip.add(I18n.format("tooltip.platform.crowbar", TextFormatting.GRAY));
    	tooltip.add(I18n.format("tooltip.platform.spikemaul", TextFormatting.GRAY ));
    }
	
	public IBlockState getMyBaseState(IBlockState state, EnumShape shape)
	{
		state = state.withProperty(FACING, EnumFacing.NORTH);
		state = state.withProperty(TOP, EnumTop.NONE);
		state = state.withProperty(SHAPE, shape);
		return state;
	}
	
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
	{
		return PieceCenter;		
	}
	
	@Override
    public boolean canCreatureSpawn(IBlockState state, IBlockAccess world, BlockPos pos, EntityLiving.SpawnPlacementType type) 
	{
        return false;
    }
	
	public IBlockState onBlockPlaced(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer)
    {
        IBlockState iblockstate = super.onBlockPlaced(worldIn, pos, facing, hitX, hitY, hitZ, meta, placer);        
        iblockstate = iblockstate.withProperty(FACING, placer.getHorizontalFacing());        
        return iblockstate;
    }

	public boolean isOpaqueCube(IBlockState state)
    {
        return false;
    }

    public boolean isFullCube(IBlockState state)
    {
        return false;
    }  
    
    public IBlockState getStateFromMeta(int meta)
    {
        IBlockState iblockstate = this.getDefaultState();
        iblockstate = iblockstate.withProperty(FACING, EnumFacing.getFront(5 - (meta & 3)));       
        return iblockstate;
    }

    public int getMetaFromState(IBlockState state)
    {
        int i = 0;
        i = i | 5 - ((EnumFacing)state.getValue(FACING)).getIndex();
        return i;
    }
    
    protected BlockStateContainer createBlockState()
    {
        return new BlockStateContainer(this, new IProperty[] {FACING, TOP, SHAPE});
    }
    
    public static enum EnumTop implements IStringSerializable
    {
    	NONE("none"),
    	FENCE("fence"),
    	WALL("wall");
    	
    	private final String name;

        private EnumTop(String name)
        {
            this.name = name;
        }

        public String toString()
        {
            return this.name;
        }

        public String getName()
        {
            return this.name;
        }
    }
    
    public static enum EnumShape implements IStringSerializable
    {
    	FULL("full"),
    	OUTER("outer"),
    	INNER("inner"),
    	EDGE("edge");

    	private final String name;

        private EnumShape(String name)
        {
            this.name = name;
        }

        public String toString()
        {
            return this.name;
        }

        public String getName()
        {
            return this.name;
        }
    }
  
    public IBlockState getActualState(IBlockState state, IBlockAccess worldIn, BlockPos pos)
    {
       state = state.withProperty(TOP, checkBlockAbove(worldIn, pos.up()));
       return state;
    }    
  
    @SideOnly(Side.CLIENT)
    public void initModel() 
	{
        ModelLoader.setCustomModelResourceLocation(ItemBlock.getItemFromBlock(this), 0, new ModelResourceLocation(getRegistryName(), "inventory"));
    }
    
    public EnumTop checkBlockAbove(IBlockAccess world, BlockPos pos)
	{
		Block block = world.getBlockState(pos).getBlock();
		Block blockAbove = world.getBlockState(pos.up()).getBlock();		
		if ((block instanceof BlockPostBase) && (blockAbove instanceof BlockPostBase)) 
			return EnumTop.FENCE;
		else if (block instanceof BlockFence)
			return EnumTop.FENCE;
		else if (PlatformConnectedList.fenceAllowed.contains(block.getClass().getName()))
			return EnumTop.FENCE;
		else if ((block instanceof BlockSign) && Block.getIdFromBlock(block) == 63) 
			return EnumTop.FENCE;
		else if ((block instanceof BlockBanner) && Block.getIdFromBlock(block) == 176) 
			return EnumTop.FENCE;
		else if (PlatformConnectedList.wallAllowed.contains(block.getClass().getName()))
			return EnumTop.WALL;
		else 
			return EnumTop.NONE;
	}

    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, @Nullable ItemStack heldItem, EnumFacing side, float hitX, float hitY, float hitZ)
    {
    	if(heldItem != null)
		{
    		if(heldItem.getItem() instanceof ItemSpikeMaul)
			{
    			IBlockState stateout;
				switch(state.getValue(SHAPE))
				{
					case FULL: 
					{
						stateout = BlocksInit.PlatformOuter.getDefaultState().withProperty(SHAPE, EnumShape.OUTER); 
						break;
					}
					case OUTER: 
					{
						stateout = BlocksInit.PlatformInner.getDefaultState().withProperty(SHAPE, EnumShape.INNER); 
						break;
					}
					case INNER: 
					{
						stateout = BlocksInit.PlatformEdge.getDefaultState().withProperty(SHAPE, EnumShape.EDGE); 
						break;
					}
					case EDGE: 
					{
						stateout = BlocksInit.PlatformFull.getDefaultState().withProperty(SHAPE, EnumShape.FULL);
						break;					
					}
					default: stateout = state;
				}
				stateout = stateout.withProperty(FACING, state.getValue(FACING)).withProperty(TOP, state.getValue(TOP));				
				worldIn.setBlockState(pos, stateout, 2);				
				heldItem.damageItem(1, playerIn);
				return true;
			}
    		else if (heldItem.getItem() instanceof ItemCrowbar)
    		{
    			IBlockState stateout = state.cycleProperty(FACING);
    			worldIn.setBlockState(pos, stateout, 2);
    			heldItem.damageItem(1, playerIn);
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
    
    public boolean rotateBlock(World world, BlockPos pos, EnumFacing axis)
    {
		return enableStats;
    	
    }
    
    
    //BlockModelShapes modelShapes = Minecraft.getMinecraft().getBlockRendererDispatcher().getBlockModelShapes();
	

}
