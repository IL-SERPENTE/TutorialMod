package fr.scarex.tutorialmod.item;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import cpw.mods.fml.common.registry.GameRegistry;
import fr.scarex.tutorialmod.TutorialMod;

/**
 * @author SCAREX
 * 
 */
public class ItemBackPack extends Item
{
	public static final String NAME = "backpack";

	public ItemBackPack() {
		this.setUnlocalizedName(TutorialMod.MODID + "_" + NAME);
		this.setTextureName(TutorialMod.MODID + ":" + NAME);
		this.setCreativeTab(CreativeTabs.tabTools);
		this.maxStackSize = 1;

		this.register();
	}

	/**
	 * Used to add the item to the game registry
	 */
	public final void register() {
		GameRegistry.registerItem(this, NAME);
	}

	/**
	 * Used to open the gui
	 */
	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
		player.openGui(TutorialMod.INSTANCE, 0, world, (int) player.posX, (int) player.posY, (int) player.posZ);
		return stack;
	}
}
