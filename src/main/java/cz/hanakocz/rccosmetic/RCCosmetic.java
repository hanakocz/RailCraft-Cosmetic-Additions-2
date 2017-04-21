package cz.hanakocz.rccosmetic;

import cz.hanakocz.rccosmetic.blocks.BlocksInit;
import cz.hanakocz.rccosmetic.items.ItemsInit;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@Mod(modid = RCCosmetic.MODID, version = RCCosmetic.VERSION, name = RCCosmetic.NAME, dependencies="required-after:Forge@[12.18.2.2107,);required-after:railcraft@[10.1.0,)")
public class RCCosmetic
{
    public static final String MODID = "rccosmetic";
    public static final String VERSION = "3.0.5";
    public static final String NAME = "Railcraft Cosmetic Additions";
    
    public static CreativeTabs tabRCCos= new CreativeTabs("tabRCCos") 
    {

	    @Override
	    @SideOnly(Side.CLIENT)
	    public Item getTabIconItem() 
	    {
	        return ItemsInit.TrainOperatorRedCap;
	    }
	};
	
    @Instance
    public static RCCosmetic instance = new RCCosmetic();
    
    @SidedProxy(clientSide="cz.hanakocz.rccosmetic.ClientProxy", serverSide="cz.hanakocz.rccosmetic.ServerProxy")
    public static CommonProxy proxy;
    
    
    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
    	proxy.preInit(event);   	   	
    }
    
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
    	proxy.init(event);		
    }
    
    @EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
    	proxy.postInit(event);   	
    }

}
