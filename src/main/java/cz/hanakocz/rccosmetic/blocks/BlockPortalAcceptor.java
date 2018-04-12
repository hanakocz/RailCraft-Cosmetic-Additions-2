package cz.hanakocz.rccosmetic.blocks;

import cz.hanakocz.rccosmetic.RCCosmetic;
import cz.hanakocz.rccosmetic.blocks.BlockPlatform.EnumShape;
import cz.hanakocz.rccosmetic.blocks.tileentities.TilePortalAcceptor;
import net.minecraft.block.Block;
import net.minecraft.block.BlockHorizontal;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemBlock;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockPortalAcceptor extends Block
{
protected static final AxisAlignedBB PieceCenter = new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.75D, 1.0D);
	
	public static final PropertyDirection FACING = BlockHorizontal.FACING;
	
	public BlockPortalAcceptor(String unlocalizedName)
	{
		super(Material.ROCK);
		this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH));
		this.setSoundType(SoundType.STONE);
		setRegistryName(unlocalizedName);
		setUnlocalizedName(unlocalizedName);
		this.setCreativeTab(RCCosmetic.tabRCCos);
		this.setHardness(1.0F);
		this.setResistance(5.0F);
		this.setLightOpacity(30);
		this.setHarvestLevel("pickaxe", 1);

	}
	
	public IBlockState onBlockPlaced(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer)
    {
        IBlockState iblockstate = super.onBlockPlaced(worldIn, pos, facing, hitX, hitY, hitZ, meta, placer);        
        iblockstate = iblockstate.withProperty(FACING, placer.getHorizontalFacing());
        createNewTileEntity(worldIn, meta);
        return iblockstate;
    }

	public boolean isOpaqueCube(IBlockState state)
    {
        return true;
    }

    public boolean isFullCube(IBlockState state)
    {
        return true;
    }
    
    @Override
	public boolean hasTileEntity(IBlockState state) 
    {
		return true;
	}
    
    public TilePortalAcceptor getTileEntity(IBlockAccess world, BlockPos pos) 
    {
		return (TilePortalAcceptor) world.getTileEntity(pos);
	}
    
    public TileEntity createNewTileEntity(World worldIn, int meta)
    {
        return new TilePortalAcceptor();
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
        return new BlockStateContainer(this, new IProperty[] {FACING});
    }
	
	public IBlockState getActualState(IBlockState state, IBlockAccess worldIn, BlockPos pos)
    {
       return state;
    }
	
	@SideOnly(Side.CLIENT)
    public void initModel() 
	{
        ModelLoader.setCustomModelResourceLocation(ItemBlock.getItemFromBlock(this), 0, new ModelResourceLocation(getRegistryName(), "inventory"));
    }

}
