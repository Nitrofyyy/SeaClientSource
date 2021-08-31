// 
// Decompiled by Procyon v0.5.36
// 

package BLueDD.hud.mod.impl;

import net.minecraft.client.renderer.RenderHelper;
import org.lwjgl.opengl.GL11;
import net.minecraft.item.Item;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import BLueDD.hud.mod.HudMod;

public class ArmorStatusMod extends HudMod
{
    public ArmorStatusMod() {
        super("AmorStatusMod", 90, 90);
    }
    
    @Override
    public int getWidth() {
        return 64;
    }
    
    @Override
    public int getHieght() {
        return 64;
    }
    
    @Override
    public void draw() {
        for (int i = 0; i < this.mc.thePlayer.inventory.armorInventory.length; ++i) {
            final ItemStack itemStack = this.mc.thePlayer.inventory.armorInventory[i];
            this.renderItemStack(i, itemStack);
        }
        super.draw();
    }
    
    @Override
    public void renderDummy(final int mouseX, final int mouseY) {
        this.renderItemStack(4, new ItemStack(Items.diamond_helmet));
        this.renderItemStack(3, new ItemStack(Items.diamond_chestplate));
        this.renderItemStack(2, new ItemStack(Items.diamond_leggings));
        this.renderItemStack(1, new ItemStack(Items.diamond_boots));
        for (int i = 1; i < this.mc.thePlayer.inventory.armorInventory.length; ++i) {
            final ItemStack itemStack = this.mc.thePlayer.inventory.armorInventory[i];
            super.renderDummy(mouseX, mouseY);
        }
    }
    
    private void renderItemStack(final int i, final ItemStack is) {
        if (is == null) {
            return;
        }
        GL11.glPushMatrix();
        final int yAdd = -16 * i + 48;
        if (is.getItem().isDamageable()) {
            final double damage = (is.getMaxDamage() - is.getItemDamage()) / (double)is.getMaxDamage() * 100.0;
            this.fr.drawString(String.format("%.2f%%", damage), this.drag.getxPosition() + 20, this.drag.getyPosition() + yAdd + 5, -1);
            if (this.mc.thePlayer != null && is != null) {
                if (is.getItem().isDamageable()) {
                    final double damage2 = (is.getMaxDamage() - is.getItemDamage()) / (double)is.getMaxDamage() * 100.0;
                    this.fr.drawString(String.format("%.2f%%", damage), this.drag.getxPosition() + 20, this.drag.getyPosition() + yAdd + 5, -1);
                }
                if (is.isStackable() && this.mc.thePlayer.getHeldItem().stackSize != 1) {
                    this.fr.drawString(Integer.toString(this.mc.thePlayer.getHeldItem().stackSize), this.drag.getxPosition() + 20, this.drag.getyPosition() + yAdd + 5, -1);
                }
            }
            RenderHelper.enableGUIStandardItemLighting();
            this.mc.getRenderItem().renderItemAndEffectIntoGUI(is, this.drag.getxPosition(), this.drag.getyPosition() + yAdd);
            GL11.glPopMatrix();
        }
    }
}
