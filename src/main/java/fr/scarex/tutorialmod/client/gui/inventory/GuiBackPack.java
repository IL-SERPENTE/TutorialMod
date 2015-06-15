package fr.scarex.tutorialmod.client.gui.inventory;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import fr.scarex.tutorialmod.inventory.InventoryBackPack;
import fr.scarex.tutorialmod.inventory.container.ContainerBackPack;

/**
 * @author SCAREX
 * 
 */
public class GuiBackPack extends GuiContainer
{
	public static final ResourceLocation texture = new ResourceLocation("textures/gui/container/generic_54.png");
	protected InventoryBackPack inv;
	protected InventoryPlayer playerInv;
	public int rows;

	public GuiBackPack(InventoryPlayer playerInv, InventoryBackPack inv) {
		super(new ContainerBackPack(playerInv, inv));
		this.playerInv = playerInv;
		this.inv = inv;
		this.allowUserInput = false;
		this.rows = inv.getSizeInventory() / 9;
		this.ySize = 114 + this.rows * 18;
	}

	@Override
	protected void drawGuiContainerForegroundLayer(int p_146979_1_, int p_146979_2_) {
		this.fontRendererObj.drawString(I18n.format(this.inv.getInventoryName(), new Object[0]), 8, 6, 4210752);
		this.fontRendererObj.drawString(this.playerInv.hasCustomInventoryName() ? this.playerInv.getInventoryName() : I18n.format(this.playerInv.getInventoryName(), new Object[0]), 8, this.ySize - 96 + 2, 4210752);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float prt, int p_146976_2_, int p_146976_3_) {
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		this.mc.getTextureManager().bindTexture(texture);
		int k = (this.width - this.xSize) / 2;
		int l = (this.height - this.ySize) / 2;
		this.drawTexturedModalRect(k, l, 0, 0, this.xSize, this.rows * 18 + 17);
		this.drawTexturedModalRect(k, l + this.rows * 18 + 17, 0, 126, this.xSize, 96);
	}
}
