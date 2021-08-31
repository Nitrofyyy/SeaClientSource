// 
// Decompiled by Procyon v0.5.36
// 

package BLueDD.hud.mod.impl;

import net.minecraft.util.BlockPos;
import net.optifine.model.BlockModelUtils;
import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.IBlockAccess;
import net.minecraft.block.material.Material;
import net.optifine.shaders.Shaders;
import net.minecraft.src.Config;
import org.lwjgl.opengl.GL11;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.client.multiplayer.WorldClient;
import BLueDD.hud.mod.HudMod;

public class BlockOverlay extends HudMod
{
    public WorldClient theWorld;
    
    public BlockOverlay() {
        super("Block Overlay", 14, 10);
    }
    
    public static void drawSelectionBoundingBox(final AxisAlignedBB boundingBox) {
        final Tessellator tessellator = Tessellator.getInstance();
        final WorldRenderer worldrenderer = tessellator.getWorldRenderer();
        worldrenderer.begin(3, DefaultVertexFormats.POSITION);
        worldrenderer.pos(boundingBox.minX, boundingBox.minY, boundingBox.minZ).endVertex();
        worldrenderer.pos(boundingBox.maxX, boundingBox.minY, boundingBox.minZ).endVertex();
        worldrenderer.pos(boundingBox.maxX, boundingBox.minY, boundingBox.maxZ).endVertex();
        worldrenderer.pos(boundingBox.minX, boundingBox.minY, boundingBox.maxZ).endVertex();
        worldrenderer.pos(boundingBox.minX, boundingBox.minY, boundingBox.minZ).endVertex();
        tessellator.draw();
        worldrenderer.begin(3, DefaultVertexFormats.POSITION);
        worldrenderer.pos(boundingBox.minX, boundingBox.maxY, boundingBox.minZ).endVertex();
        worldrenderer.pos(boundingBox.maxX, boundingBox.maxY, boundingBox.minZ).endVertex();
        worldrenderer.pos(boundingBox.maxX, boundingBox.maxY, boundingBox.maxZ).endVertex();
        worldrenderer.pos(boundingBox.minX, boundingBox.maxY, boundingBox.maxZ).endVertex();
        worldrenderer.pos(boundingBox.minX, boundingBox.maxY, boundingBox.minZ).endVertex();
        tessellator.draw();
        worldrenderer.begin(1, DefaultVertexFormats.POSITION);
        worldrenderer.pos(boundingBox.minX, boundingBox.minY, boundingBox.minZ).endVertex();
        worldrenderer.pos(boundingBox.minX, boundingBox.maxY, boundingBox.minZ).endVertex();
        worldrenderer.pos(boundingBox.maxX, boundingBox.minY, boundingBox.minZ).endVertex();
        worldrenderer.pos(boundingBox.maxX, boundingBox.maxY, boundingBox.minZ).endVertex();
        worldrenderer.pos(boundingBox.maxX, boundingBox.minY, boundingBox.maxZ).endVertex();
        worldrenderer.pos(boundingBox.maxX, boundingBox.maxY, boundingBox.maxZ).endVertex();
        worldrenderer.pos(boundingBox.minX, boundingBox.minY, boundingBox.maxZ).endVertex();
        worldrenderer.pos(boundingBox.minX, boundingBox.maxY, boundingBox.maxZ).endVertex();
        tessellator.draw();
    }
    
    public static void drawOutlinedBoundingBox(final AxisAlignedBB axisAlignedBBIn, final int red, final int green, final int blue, final int alpha) {
        final Tessellator tessellator = Tessellator.getInstance();
        final WorldRenderer worldrenderer = tessellator.getWorldRenderer();
        worldrenderer.begin(5, DefaultVertexFormats.POSITION_COLOR);
        worldrenderer.pos(axisAlignedBBIn.minX, axisAlignedBBIn.minY, axisAlignedBBIn.minZ).color(red, green, blue, alpha).endVertex();
        worldrenderer.pos(axisAlignedBBIn.maxX, axisAlignedBBIn.minY, axisAlignedBBIn.minZ).color(red, green, blue, alpha).endVertex();
        worldrenderer.pos(axisAlignedBBIn.minX, axisAlignedBBIn.minY, axisAlignedBBIn.maxZ).color(red, green, blue, alpha).endVertex();
        worldrenderer.pos(axisAlignedBBIn.maxX, axisAlignedBBIn.minY, axisAlignedBBIn.maxZ).color(red, green, blue, alpha).endVertex();
        tessellator.draw();
        worldrenderer.begin(5, DefaultVertexFormats.POSITION_COLOR);
        worldrenderer.pos(axisAlignedBBIn.minX, axisAlignedBBIn.maxY, axisAlignedBBIn.minZ).color(red, green, blue, alpha).endVertex();
        worldrenderer.pos(axisAlignedBBIn.minX, axisAlignedBBIn.maxY, axisAlignedBBIn.maxZ).color(red, green, blue, alpha).endVertex();
        worldrenderer.pos(axisAlignedBBIn.maxX, axisAlignedBBIn.maxY, axisAlignedBBIn.minZ).color(red, green, blue, alpha).endVertex();
        worldrenderer.pos(axisAlignedBBIn.maxX, axisAlignedBBIn.maxY, axisAlignedBBIn.maxZ).color(red, green, blue, alpha).endVertex();
        tessellator.draw();
        worldrenderer.begin(5, DefaultVertexFormats.POSITION_COLOR);
        worldrenderer.pos(axisAlignedBBIn.minX, axisAlignedBBIn.minY, axisAlignedBBIn.minZ).color(red, green, blue, alpha).endVertex();
        worldrenderer.pos(axisAlignedBBIn.minX, axisAlignedBBIn.maxY, axisAlignedBBIn.minZ).color(red, green, blue, alpha).endVertex();
        worldrenderer.pos(axisAlignedBBIn.maxX, axisAlignedBBIn.minY, axisAlignedBBIn.minZ).color(red, green, blue, alpha).endVertex();
        worldrenderer.pos(axisAlignedBBIn.maxX, axisAlignedBBIn.maxY, axisAlignedBBIn.minZ).color(red, green, blue, alpha).endVertex();
        worldrenderer.pos(axisAlignedBBIn.maxX, axisAlignedBBIn.minY, axisAlignedBBIn.maxZ).color(red, green, blue, alpha).endVertex();
        worldrenderer.pos(axisAlignedBBIn.maxX, axisAlignedBBIn.maxY, axisAlignedBBIn.maxZ).color(red, green, blue, alpha).endVertex();
        worldrenderer.pos(axisAlignedBBIn.minX, axisAlignedBBIn.minY, axisAlignedBBIn.maxZ).color(red, green, blue, alpha).endVertex();
        worldrenderer.pos(axisAlignedBBIn.minX, axisAlignedBBIn.maxY, axisAlignedBBIn.maxZ).color(red, green, blue, alpha).endVertex();
        worldrenderer.pos(axisAlignedBBIn.minX, axisAlignedBBIn.minY, axisAlignedBBIn.minZ).color(red, green, blue, alpha).endVertex();
        worldrenderer.pos(axisAlignedBBIn.minX, axisAlignedBBIn.maxY, axisAlignedBBIn.minZ).color(red, green, blue, alpha).endVertex();
        tessellator.draw();
    }
    
    public void drawSelectionBox(final EntityPlayer player, final MovingObjectPosition movingObjectPositionIn, final int execute, final float partialTicks) {
        if (execute == 0 && movingObjectPositionIn.typeOfHit == MovingObjectPosition.MovingObjectType.BLOCK) {
            GlStateManager.enableBlend();
            GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
            GlStateManager.color(0.0f, 51.0f, 153.0f, 255.0f);
            GL11.glLineWidth(4.0f);
            GlStateManager.disableTexture2D();
            if (Config.isShaders()) {
                Shaders.disableTexture2D();
            }
            GlStateManager.depthMask(false);
            final float f = 0.002f;
            final BlockPos blockpos = movingObjectPositionIn.getBlockPos();
            final Block block = this.theWorld.getBlockState(blockpos).getBlock();
            if (block.getMaterial() != Material.air && this.theWorld.getWorldBorder().contains(blockpos)) {
                block.setBlockBoundsBasedOnState(this.theWorld, blockpos);
                final double d0 = player.lastTickPosX + (player.posX - player.lastTickPosX) * partialTicks;
                final double d2 = player.lastTickPosY + (player.posY - player.lastTickPosY) * partialTicks;
                final double d3 = player.lastTickPosZ + (player.posZ - player.lastTickPosZ) * partialTicks;
                AxisAlignedBB axisalignedbb = block.getSelectedBoundingBox(this.theWorld, blockpos);
                final Block.EnumOffsetType block$enumoffsettype = block.getOffsetType();
                if (block$enumoffsettype != Block.EnumOffsetType.NONE) {
                    axisalignedbb = BlockModelUtils.getOffsetBoundingBox(axisalignedbb, block$enumoffsettype, blockpos);
                }
                drawSelectionBoundingBox(axisalignedbb.expand(0.0020000000949949026, 0.0020000000949949026, 0.0020000000949949026).offset(-d0, -d2, -d3));
            }
            GlStateManager.depthMask(true);
            GlStateManager.enableTexture2D();
            if (Config.isShaders()) {
                Shaders.enableTexture2D();
            }
            GlStateManager.disableBlend();
        }
    }
}
