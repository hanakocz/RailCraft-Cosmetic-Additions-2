package cz.hanakocz.rccosmetic.inventory;

import org.apache.logging.log4j.Level;

import cz.hanakocz.rccosmetic.RCCosmetic;
import cz.hanakocz.rccosmetic.entity.carts.EntityCartCouch;
import cz.hanakocz.rccosmetic.entity.carts.EntityCartOpen;
import cz.hanakocz.rccosmetic.entity.carts.EntityCartWood;
import mods.railcraft.common.util.misc.Game;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.inventory.GuiChest;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class RCCGuiHandler implements IGuiHandler {

  
    public static void openGui(RCCEnumGui gui, EntityPlayer player, World world, Entity entity) 
    {
        if (Game.isHost(world)) 
        {
            if (gui.hasContainer()) 
            {
                player.openGui(RCCosmetic.MODID, gui.ordinal(), world, entity.getEntityId(), -1, 0);
            }
        } 
        
    }

    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        if (y < 0) {
            Entity entity = world.getEntityByID(x);
            if (entity == null) {
                Game.log(Level.WARN, "[Server] Entity not found when opening GUI: {0}", x);
                return null;
            }
            return buildContainer(RCCEnumGui.fromOrdinal(ID), player.inventory, entity, world, x, y, z);
        }
        TileEntity tile = world.getTileEntity(new BlockPos(x, y, z));
        return buildContainer(RCCEnumGui.fromOrdinal(ID), player.inventory, tile, world, x, y, z);
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        if (y < 0) {
            Entity entity = world.getEntityByID(x);
            if (entity == null) {
                Game.log(Level.WARN, "[Client] Entity not found when opening GUI: {0}", x);
                return null;
            }
            return buildGui(RCCEnumGui.fromOrdinal(ID), player.inventory, entity, world, x, y, z);
        }
        TileEntity tile = world.getTileEntity(new BlockPos(x, y, z));
        return buildGui(RCCEnumGui.fromOrdinal(ID), player.inventory, tile, world, x, y, z);
    }
    
    public Container buildContainer(RCCEnumGui gui, InventoryPlayer inv, Object obj, World world, int x, int y, int z)
    {
    	if ( obj == null)
            return null;    	
        switch (gui) 
        {
            case OPEN_CART:
                return new ContainerLoose(inv, (EntityCartOpen) obj);
            case WOOD_CART:
                return new ContainerWood(inv, (EntityCartWood) obj);
            case COUCH_CART:
            	return new ContainerCartCouch(inv, (EntityCartCouch) obj);                	
            default:
                return null;
        }   	
    }
    
    @SideOnly(Side.CLIENT)
    public static GuiScreen buildGui(RCCEnumGui gui, InventoryPlayer inv, Object obj, World world, int x, int y, int z) 
    {
        if (obj == null)
            return null;
        switch (gui) 
        {
        	case OPEN_CART:
        		return new GuiCartOpen(inv, (EntityCartOpen) obj);
        	case WOOD_CART:
        		return new GuiCartWood(inv, (EntityCartWood) obj);
        	case COUCH_CART:
        		return new GuiCartCouch(inv, (EntityCartCouch) obj);                	
        	default:
        		return null;
        }        
    }
}
