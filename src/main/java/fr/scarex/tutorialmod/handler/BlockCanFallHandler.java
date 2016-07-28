package fr.scarex.tutorialmod.handler;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import fr.scarex.tutorialmod.TutorialMod;
import fr.scarex.tutorialmod.core.ICanFall;
import fr.scarex.tutorialmod.core.event.BlockFallingEvent;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;

/**
 * @author SCAREX
 *
 */
public class BlockCanFallHandler
{
	@SubscribeEvent
	public void onPlayerInteract(PlayerInteractEvent event) {
		if (event.action == PlayerInteractEvent.Action.RIGHT_CLICK_BLOCK && event.entityPlayer.getHeldItem() != null && event.entityPlayer.getHeldItem().getItem() == Items.bone) {
			if (event.world.getBlock(event.x, event.y, event.z) instanceof ICanFall) {
				TutorialMod.LOGGER.info(((ICanFall) event.world.getBlock(event.x, event.y, event.z)).canBlockFall(event.world, event.x, event.y, event.z));
			}
		}
	}

	@SubscribeEvent
	public void onBlockFallEvent(BlockFallingEvent event) {
		TutorialMod.LOGGER.info("block falling");
		if (event.world.getBlock(event.x, event.y, event.z) == Blocks.gravel) event.setCanceled(true);
	}
}
