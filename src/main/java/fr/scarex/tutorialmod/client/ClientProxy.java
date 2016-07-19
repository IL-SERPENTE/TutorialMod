package fr.scarex.tutorialmod.client;

import java.awt.Desktop;
import java.net.URI;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiMainMenu;
import net.minecraft.client.gui.GuiOptions;
import net.minecraft.client.gui.GuiScreenResourcePacks;
import net.minecraftforge.client.event.GuiOpenEvent;
import net.minecraftforge.client.event.GuiScreenEvent.ActionPerformedEvent;
import net.minecraftforge.client.event.GuiScreenEvent.InitGuiEvent;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.ObfuscationReflectionHelper;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import fr.scarex.tutorialmod.CommonProxy;
import fr.scarex.tutorialmod.TutorialMod;

/**
 * @author SCAREX
 * 
 */
public class ClientProxy extends CommonProxy
{
	public ClientProxy() {
		// registering the PROXY to use events from MinecraftForge
		MinecraftForge.EVENT_BUS.register(this);
		
		TutorialMod.LOGGER.info(Minecraft.getMinecraft().timer.timerSpeed);
		TutorialMod.LOGGER.info(Minecraft.theMinecraft);
		TutorialMod.LOGGER.info(Minecraft.isJvm64bit());
	}

	/**
	 * This function is called when the init method of a GuiScreen is called and
	 * modify the current buttons and the splash text
	 */
	@SubscribeEvent
	public void onInitGuiEvent(InitGuiEvent.Post event) {
		if (event.gui instanceof GuiMainMenu) {
			for (Object b : event.buttonList) {
				if (((GuiButton) b).id == 14) {
					((GuiButton) b).visible = false;
				}
			}
			int i = event.gui.height / 4 + 48;
			event.buttonList.add(new GuiButton(30, event.gui.width / 2 - 100, i + 24 * 2, 100, 20, "Teamspeak") {
				@Override
				public void mouseReleased(int x, int y) {
					if (Desktop.isDesktopSupported()) {
						try {
							Desktop.getDesktop().browse(new URI("ts3server://ts.minecraftforgefrance.fr?port=9987"));
						} catch (Exception e) {
							TutorialMod.LOGGER.warn("Couldn't open teamspeak", e);
						}
					}
				}
			});

			ObfuscationReflectionHelper.setPrivateValue(GuiMainMenu.class, (GuiMainMenu) event.gui, "Bienvenue dans ce tutoriel", "splashText", "field_73975_c");
		}
	}

	/**
	 * This event is called when an action is performed <br />
	 * This method avoid opening the resource packs GUI
	 */
	@SubscribeEvent
	public void onActionPerformed(ActionPerformedEvent.Pre event) {
		if (event.gui instanceof GuiOptions && event.button.id == 105) event.setCanceled(true);
	}

	/**
	 * This event is called when a GUI is opened <br />
	 * This method avoid opening the resource packs GUI
	 */
	@SubscribeEvent
	public void onGuiOpen(GuiOpenEvent event) {
		if (event.gui instanceof GuiScreenResourcePacks) event.setCanceled(true);
	}
}
