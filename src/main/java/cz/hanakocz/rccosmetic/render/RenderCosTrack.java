package cz.hanakocz.rccosmetic.render;

import net.minecraft.block.Block;
import net.minecraft.block.BlockRailBase;
import net.minecraft.block.BlockSnow;
import net.minecraft.block.BlockTallGrass;
import net.minecraft.block.BlockWeb;
import net.minecraft.init.Blocks;
import net.minecraft.world.ColorizerGrass;
import net.minecraft.world.IBlockAccess;

public class RenderCosTrack 
{	
		/*BlockRailBase rail = (BlockRailBase) Blocks.RAIL;
		BlockSnow snow = (BlockSnow) Blocks.SNOW_LAYER;
		BlockTallGrass grass = new BlockTallGrass() 
		{
			public int getRenderColor(int p_149741_1_)
			{ 
				return ColorizerGrass.getGrassColor(0.5D, 1.0D);
			}
			public int colorMultiplier(IBlockAccess world, int x, int y, int z) 
			{ 
				return world.getBiomeGenForCoords(x, z).getBiomeGrassColor(z, y, z);
			}
			public IIcon getIcon(int a, int b)
			{
				return Blocks.TALLGRASS.getIcon(a, b);
			}
		};
		BlockWeb cobweb = new BlockWeb() {};

		@Override
		public void renderInventoryBlock(Block block, int metadata, int modelId, RenderBlocks renderer) 
		{}

		@Override
		public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z,
				Block block, int modelId, RenderBlocks renderer) 
		{
			if (block instanceof BlockRailcraftCosTrackCobweb)
			{
				renderer.setOverrideBlockTexture(renderer.getBlockIconFromSideAndMetadata(Blocks.web, 0, 1));
				renderer.renderBlockByRenderType(cobweb, x, y, z);
			}
			else if (block instanceof BlockRailcraftCosTrack)
			{
				renderer.setOverrideBlockTexture(renderer.getBlockIconFromSideAndMetadata(Blocks.TALLGRASS, 0, 1));
				renderer.renderBlockByRenderType(grass, x, y, z);
			}
			else if (block instanceof BlockRailcraftCosTrackSnow)
			{
				//it render glitches, we will need probably our own texture than putting two together
				renderer.overrideBlockBounds(0.0, 0.0, 0.0, 1.0, 0.0625, 1.0);
				renderer.setOverrideBlockTexture(renderer.getBlockIconFromSideAndMetadata(Blocks.SNOW_LAYER, 0, 1));
				renderer.renderBlockByRenderType(snow, x, y, z);
				renderer.unlockBlockBounds();
			}
	        
	        renderer.clearOverrideBlockTexture();
			renderer.renderBlockMinecartTrack(rail, x, y, z);
			return true;
		}
*/
	
		
		
	}
