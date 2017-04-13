package cz.hanakocz.rccosmetic.render;

import org.lwjgl.opengl.GL11;

import cz.hanakocz.rccosmetic.RCCosmetic;
import cz.hanakocz.rccosmetic.entity.carts.EntityModelledCart;
import cz.hanakocz.rccosmetic.entity.carts.EntityModelledTanker;
import cz.hanakocz.rccosmetic.models.carts.ModelCartBase;
import cz.hanakocz.rccosmetic.models.carts.ModelCartCage;
import cz.hanakocz.rccosmetic.models.carts.ModelCartContainer;
import cz.hanakocz.rccosmetic.models.carts.ModelCartFlat;
import cz.hanakocz.rccosmetic.models.carts.ModelCartOpen;
import cz.hanakocz.rccosmetic.models.carts.ModelCartPanzer;
import cz.hanakocz.rccosmetic.models.carts.ModelCartTanker;
import cz.hanakocz.rccosmetic.models.carts.ModelCartTender;
import cz.hanakocz.rccosmetic.models.carts.ModelCartWood;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderMinecart;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityMinecart;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderModelledCart extends Render<EntityMinecart>
{
	private static ResourceLocation minecartOpenTextures[] =
		{	new ResourceLocation(RCCosmetic.MODID, "textures/entities/coscart.open.0.png"),
			new ResourceLocation(RCCosmetic.MODID, "textures/entities/coscart.open.1.png"),
			new ResourceLocation(RCCosmetic.MODID, "textures/entities/coscart.open.2.png"),
			new ResourceLocation(RCCosmetic.MODID, "textures/entities/coscart.open.3.png"),
			new ResourceLocation(RCCosmetic.MODID, "textures/entities/coscart.open.4.png"),
			new ResourceLocation(RCCosmetic.MODID, "textures/entities/coscart.open.5.png"),
			new ResourceLocation(RCCosmetic.MODID, "textures/entities/coscart.open.6.png"),
			new ResourceLocation(RCCosmetic.MODID, "textures/entities/coscart.open.7.png"),
			new ResourceLocation(RCCosmetic.MODID, "textures/entities/coscart.open.8.png")
		};
	private static ResourceLocation minecartTankTextures[] =
		{	new ResourceLocation(RCCosmetic.MODID, "textures/entities/coscart.liquid.0.png"),
			new ResourceLocation(RCCosmetic.MODID, "textures/entities/coscart.liquid.1.png"),
			new ResourceLocation(RCCosmetic.MODID, "textures/entities/coscart.liquid.2.png"),
			new ResourceLocation(RCCosmetic.MODID, "textures/entities/coscart.liquid.3.png"),
			new ResourceLocation(RCCosmetic.MODID, "textures/entities/coscart.liquid.4.png"),
			new ResourceLocation(RCCosmetic.MODID, "textures/entities/coscart.liquid.5.png"),
			new ResourceLocation(RCCosmetic.MODID, "textures/entities/coscart.liquid.6.png"),
			new ResourceLocation(RCCosmetic.MODID, "textures/entities/coscart.liquid.7.png"),
			new ResourceLocation(RCCosmetic.MODID, "textures/entities/coscart.liquid.8.png")
		};
	private static ResourceLocation minecartContainerTextures[] =
		{	new ResourceLocation(RCCosmetic.MODID, "textures/entities/coscart.container.0.png"),
			new ResourceLocation(RCCosmetic.MODID, "textures/entities/coscart.container.1.png"),
			new ResourceLocation(RCCosmetic.MODID, "textures/entities/coscart.container.2.png"),
			new ResourceLocation(RCCosmetic.MODID, "textures/entities/coscart.container.3.png"),
			new ResourceLocation(RCCosmetic.MODID, "textures/entities/coscart.container.4.png"),
			new ResourceLocation(RCCosmetic.MODID, "textures/entities/coscart.container.5.png"),
			new ResourceLocation(RCCosmetic.MODID, "textures/entities/coscart.container.6.png"),
			new ResourceLocation(RCCosmetic.MODID, "textures/entities/coscart.container.7.png"),
			new ResourceLocation(RCCosmetic.MODID, "textures/entities/coscart.container.8.png")
		};
    private static ResourceLocation minecartTextures[] = 
    	{	new ResourceLocation(RCCosmetic.MODID, "textures/entities/coscart.open.0.png"),
    		new ResourceLocation(RCCosmetic.MODID, "textures/entities/coscart.liquid.0.png"),
    		new ResourceLocation(RCCosmetic.MODID, "textures/entities/coscart.woodfull.png"),
    		new ResourceLocation(RCCosmetic.MODID, "textures/entities/coscart.empty.png"),
    		new ResourceLocation(RCCosmetic.MODID, "textures/entities/coscart.panzer.png"),
    		new ResourceLocation(RCCosmetic.MODID, "textures/entities/coscart.container.0.png"),
    		new ResourceLocation(RCCosmetic.MODID, "textures/entities/coscart.tender.png"),
    		new ResourceLocation(RCCosmetic.MODID, "textures/entities/coscart.cage.png")
    	};    
    private ModelCartBase modelMinecart[] = 
    	{	new ModelCartOpen(),
    		new ModelCartTanker(), 
    		new ModelCartWood(),
    		new ModelCartFlat(), 
    		new ModelCartPanzer(), 
    		new ModelCartContainer(),
    		new ModelCartTender(),
    		new ModelCartCage()
    	};


    public RenderModelledCart(RenderManager rm)
    {
    	super(rm);
        shadowSize = 0.5F;          
    }

    public int getCartType(EntityMinecart entity)
    {
    	int cart = 0;
    	if(entity instanceof EntityModelledCart)
    	{
    		cart = ((EntityModelledCart) entity).getCustomCartType();
    	}
    	else if(entity instanceof EntityModelledTanker) 
    	{
    		cart = ((EntityModelledTanker) entity).getCustomCartType();
    	}
    	return cart;
    }
    
    public int getCartItems(EntityMinecart entity)
    {
    	int items = 0;
    	if(entity instanceof EntityModelledCart)
    	{
    		items = ((EntityModelledCart) entity).getItemCount();
    	}
    	else if(entity instanceof EntityModelledTanker) 
    	{
    		items = 0;
    	}
    	return items;
    }
    
    @Override
    public void doRender(EntityMinecart entity, double x, double y, double z, float entityYaw, float partialTicks)
    {
    	y = y + 0.0625F;
        GL11.glPushMatrix();
        int logs = getCartItems(entity);
        this.bindEntityTexture(entity);
        long i = (long)entity.getEntityId() * 493286711L;
        i = i * i * 4392167121L + i * 98761L;
        float f = (((float)(i >> 16 & 7L) + 0.5F) / 8.0F - 0.5F) * 0.004F;
        float f1 = (((float)(i >> 20 & 7L) + 0.5F) / 8.0F - 0.5F) * 0.004F;
        float f2 = (((float)(i >> 24 & 7L) + 0.5F) / 8.0F - 0.5F) * 0.004F;
        GlStateManager.translate(f, f1, f2);
        double d0 = entity.lastTickPosX + (entity.posX - entity.lastTickPosX) * (double)partialTicks;
        double d1 = entity.lastTickPosY + (entity.posY - entity.lastTickPosY) * (double)partialTicks;
        double d2 = entity.lastTickPosZ + (entity.posZ - entity.lastTickPosZ) * (double)partialTicks;
        double d3 = 0.30000001192092896D;
        Vec3d vec3d = entity.getPos(d0, d1, d2);
        float f3 = entity.prevRotationPitch + (entity.rotationPitch - entity.prevRotationPitch) * partialTicks;

        if (vec3d != null)
        {
        	Vec3d vec3d1 = entity.getPosOffset(d0, d1, d2, 0.30000001192092896D);
            Vec3d vec3d2 = entity.getPosOffset(d0, d1, d2, -0.30000001192092896D);

            if (vec3d1 == null)
            {
                vec3d1 = vec3d;
            }

            if (vec3d2 == null)
            {
                vec3d2 = vec3d;
            }

            x += vec3d.xCoord - d0;
            y += (vec3d1.yCoord + vec3d2.yCoord) / 2.0D - d1;
            z += vec3d.zCoord - d2;
            Vec3d vec3d3 = vec3d2.addVector(-vec3d1.xCoord, -vec3d1.yCoord, -vec3d1.zCoord);

            if (vec3d3.lengthVector() != 0.0D)
            {
                vec3d3 = vec3d3.normalize();
                entityYaw = (float)(Math.atan2(vec3d3.zCoord, vec3d3.xCoord) * 180.0D / Math.PI);
                f3 = (float)(Math.atan(vec3d3.yCoord) * 73.0D);
            }
        }

        GlStateManager.translate((float)x, (float)y + 0.375F, (float)z);
        GlStateManager.rotate(180.0F - entityYaw, 0.0F, 1.0F, 0.0F);
        GlStateManager.rotate(-f3, 0.0F, 0.0F, 1.0F);
        float f5 = (float)entity.getRollingAmplitude() - partialTicks;
        float f6 = entity.getDamage() - partialTicks;

        if (f6 < 0.0F)
        {
            f6 = 0.0F;
        }

        if (f5 > 0.0F)
        {
            GlStateManager.rotate(MathHelper.sin(f5) * f5 * f6 / 10.0F * (float)entity.getRollingDirection(), 1.0F, 0.0F, 0.0F);
        }

        int j = entity.getDisplayTileOffset();

        if (this.renderOutlines)
        {
            GlStateManager.enableColorMaterial();
            GlStateManager.enableOutlineMode(this.getTeamColor(entity));
        }


        IBlockState iblockstate = entity.getDisplayTile();

        if (iblockstate.getRenderType() != EnumBlockRenderType.INVISIBLE)
        {
            GlStateManager.pushMatrix();
            this.bindTexture(TextureMap.LOCATION_BLOCKS_TEXTURE);
            float f4 = 0.75F;
            GlStateManager.scale(0.75F, 0.75F, 0.75F);
            GlStateManager.translate(-0.5F, (float)(j - 8) / 16.0F, 0.5F);
            this.renderCartContents(entity, partialTicks, iblockstate);
            GlStateManager.popMatrix();
            GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
            this.bindEntityTexture(entity);
        }
        GlStateManager.scale(-1.0F, -1.0F, 1.0F);
        this.modelMinecart[getCartType(entity)].render(entity, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F, logs);
        GlStateManager.popMatrix();
        if (this.renderOutlines)
        {
            GlStateManager.disableOutlineMode();
            GlStateManager.disableColorMaterial();
        }

        super.doRender(entity, x, y, z, entityYaw, partialTicks);

    }

    protected ResourceLocation getEntityTexture(EntityMinecart entity)
    {
        if (getCartType(entity) == 1 && entity instanceof EntityModelledTanker)
        {
        	return minecartTankTextures[((EntityModelledTanker) entity).getColor()];
        }
        else if (getCartType(entity) == 0 && entity instanceof EntityModelledCart)
        {
        	return minecartOpenTextures[((EntityModelledCart) entity).getColor()];
        }
        else if (getCartType(entity) == 5 && entity instanceof EntityModelledCart)
        {
        	return minecartContainerTextures[((EntityModelledCart) entity).getColor()];
        }
    	return minecartTextures[getCartType(entity)];
    }

    
    protected <T> void renderCartContents(T entity, float partialTicks, IBlockState block)
    {
        GlStateManager.pushMatrix();
        Minecraft.getMinecraft().getBlockRendererDispatcher().renderBlockBrightness(block, ((Entity) entity).getBrightness(partialTicks));
        GlStateManager.popMatrix();
    }
}