package fr.scarex.tutorialmod.item;

import net.minecraft.item.Item;

/**
 * @author SCAREX
 * 
 */
public class TutorialModItems
{
	public static Item ITEM_BACKPACK;
	
	public static final void registerItems() {
		ITEM_BACKPACK = new ItemBackPack();
	}

	public static final void registerItemsCrafts() {}
}
