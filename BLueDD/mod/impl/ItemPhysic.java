// 
// Decompiled by Procyon v0.5.36
// 

package BLueDD.mod.impl;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.client.resources.model.IBakedModel;
import net.minecraft.entity.item.EntityItem;
import BLueDD.mod.Category;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.client.renderer.entity.RenderManager;
import BLueDD.mod.Mod;

public class ItemPhysic extends Mod
{
    private static final RenderManager renderManager;
    
    static {
        renderManager = new RenderManager(null, null);
    }
    
    public ItemPhysic() {
        super("ItemPhysic", "LOLOL", Category.WORLD);
    }
    
    private int func_177077_a(final EntityItem itemIn, final double p_177077_2_, final double p_177077_4_, final double p_177077_6_, final float p_177077_8_, final IBakedModel p_177077_9_) {
        final ItemStack itemstack = itemIn.getEntityItem();
        final Item item = itemstack.getItem();
        if (item == null) {
            return 0;
        }
        final boolean flag = p_177077_9_.isGui3d();
        final int i = this.func_177078_a(itemstack);
        final float f = 0.25f;
        float f2 = -0.125f;
        if (!flag) {
            f2 = -0.175f;
        }
        final float f3 = p_177077_9_.getItemCameraTransforms().getTransform(ItemCameraTransforms.TransformType.GROUND).scale.y;
        GlStateManager.translate((float)p_177077_2_, (float)p_177077_4_ + f2 + 0.25f * f3, (float)p_177077_6_);
        if (flag || ItemPhysic.renderManager.options != null) {
            final float n = ((itemIn.getAge() + p_177077_8_) / 20.0f + itemIn.hoverStart) * 57.295776f;
        }
        if (!flag) {
            final float f4 = -0.0f * (i - 1) * 0.5f;
            final float f5 = -0.0f * (i - 1) * 0.5f;
            final float f6 = -0.046875f * (i - 1) * 0.5f;
            if (itemIn.onGround) {
                GlStateManager.rotate(180.0f, 0.0f, 1.0f, 1.0f);
            }
        }
        final float speed = 10.0f;
        if (!itemIn.onGround) {
            final float rotAmount = itemIn.getAge() * speed % 360.0f;
            GlStateManager.rotate(rotAmount, 1.0f, 0.0f, 1.0f);
        }
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        return i;
    }
    
    private int func_177078_a(final ItemStack stack) {
        int i = 1;
        if (stack.stackSize > 48) {
            i = 5;
        }
        else if (stack.stackSize > 32) {
            i = 4;
        }
        else if (stack.stackSize > 16) {
            i = 3;
        }
        else if (stack.stackSize > 1) {
            i = 2;
        }
        return i;
    }
}
