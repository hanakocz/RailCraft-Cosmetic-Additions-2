package cz.hanakocz.rccosmetic.inventory;

import java.io.IOException;

import cz.hanakocz.rccosmetic.entity.carts.EntityCartCouch;
import mods.railcraft.client.gui.EntityGui;
import mods.railcraft.client.gui.GuiTools;
import mods.railcraft.client.gui.buttons.GuiBetterButton;
import mods.railcraft.common.carts.EntityCartCargo;
import mods.railcraft.common.core.RailcraftConstants;
import mods.railcraft.common.gui.containers.ContainerCartCargo;
import mods.railcraft.common.plugins.forge.LocalizationPlugin;
import mods.railcraft.common.util.collections.Streams;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiChest;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.text.translation.I18n;

public class GuiCartCouch extends EntityGui
{
	private final String label;
    private final EntityCartCouch cart;

	public GuiCartCouch(InventoryPlayer inv, EntityCartCouch cart) 
	{
		super(cart, new ContainerCartCouch(inv, cart), "rccosmetic:textures/gui/guiCartCouch.png");
		this.cart = cart;
        label = cart.getName();
        
	}
	
	
	@Override
    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
        GuiTools.drawCenteredString(fontRendererObj, label, 6);
        //GuiTools.drawStringCenteredAtPos(fontRendererObj, LocalizationPlugin.translate("gui.railcraft.filter"), 35, 22);
        fontRendererObj.drawString(I18n.translateToLocal("container.inventory"), 8, (ySize - 100), 0x404040);
    }

}
