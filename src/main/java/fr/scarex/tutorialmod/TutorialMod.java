package fr.scarex.tutorialmod;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import fr.scarex.tutorialmod.block.TutorialModBlocks;
import fr.scarex.tutorialmod.item.TutorialModItems;

/**
 * @author SCAREX
 * 
 */
@Mod(modid = TutorialMod.MODID, name = TutorialMod.NAME, version = TutorialMod.VERSION)
public class TutorialMod
{
	public static final String MODID = "stutorialmod";
	public static final String NAME = "SCAREX Tutorial Mod";
	public static final String VERSION = "1.0.0";
	/**
	 * Logger used for debug
	 */
	public static final Logger LOGGER = LogManager.getLogger(NAME);

	public void preInit(FMLPreInitializationEvent event) {
		TutorialModItems.registerItems();
		TutorialModBlocks.registerBlocks();
	}

	public void init(FMLInitializationEvent event) {
		TutorialModItems.registerItemsCrafts();
		TutorialModBlocks.registerBlocksCrafts();
	}

	public void postInit(FMLPostInitializationEvent event) {}
}