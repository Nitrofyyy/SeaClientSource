// 
// Decompiled by Procyon v0.5.36
// 

package BLueDD.Login;

import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.entity.Entity;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.EntityLivingBase;
import java.io.FileWriter;
import java.io.IOException;
import org.lwjgl.input.Keyboard;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.client.gui.Gui;
import BLueDD.config.SessionChanger;
import java.util.Random;
import net.minecraft.client.gui.GuiButton;
import BLueDD.fakeutils.FakePlayer;
import net.minecraft.world.World;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.client.gui.GuiScreen;

public final class GuiAltLogin extends GuiScreen
{
    private PasswordField password;
    private final GuiScreen previousScreen;
    private AltLoginThread thread;
    private GuiTextField username;
    private World world;
    private FakePlayer player;
    public static String Password;
    public static String Email;
    int rotate;
    int s;
    
    static {
        GuiAltLogin.Password = "";
        GuiAltLogin.Email = "";
    }
    
    public GuiAltLogin(final GuiScreen previousScreen) {
        this.rotate = 0;
        this.s = 2;
        this.previousScreen = previousScreen;
    }
    
    @Override
    protected void actionPerformed(final GuiButton button) {
        switch (button.id) {
            case 1: {
                this.mc.displayGuiScreen(this.previousScreen);
                break;
            }
            case 0: {
                (this.thread = new AltLoginThread(this.username.getText(), this.password.getText())).start();
                GuiAltLogin.Email = this.username.getText();
                GuiAltLogin.Password = this.password.getText();
            }
            case 3: {
                final Random random = new Random();
                SessionChanger.getInstance().setUserOffline("User" + random.nextInt(9) + random.nextInt(9) + random.nextInt(9) + random.nextInt(9));
            }
            case 4: {
                (this.thread = new AltLoginThread(GuiAltLogin.Email, GuiAltLogin.Password)).start();
                break;
            }
        }
    }
    
    @Override
    public void drawScreen(final int x2, final int y2, final float z2) {
        this.drawDefaultBackground();
        this.username.drawTextBox();
        this.password.drawTextBox();
        Gui.drawCenteredString(this.mc.fontRendererObj, "Alt Login", (float)(GuiAltLogin.width / 2), 20.0f, -1);
        Gui.drawCenteredString(this.mc.fontRendererObj, (this.thread == null) ? (EnumChatFormatting.GRAY + "Idle...") : this.thread.getStatus(), (float)(GuiAltLogin.width / 2), 29.0f, -1);
        if (this.username.getText().isEmpty()) {
            this.drawString(this.mc.fontRendererObj, "Username / E-Mail", GuiAltLogin.width / 2 - 96, 66, -7829368);
        }
        if (this.password.getText().isEmpty()) {
            this.drawString(this.mc.fontRendererObj, "Password", GuiAltLogin.width / 2 - 96, 106, -7829368);
        }
        super.drawScreen(x2, y2, z2);
    }
    
    @Override
    public void initGui() {
        final int var3 = GuiAltLogin.height / 4 + 24;
        this.buttonList.add(new GuiButton(0, GuiAltLogin.width / 2 - 100, var3 + 72 + 12, "Login"));
        this.buttonList.add(new GuiButton(3, GuiAltLogin.width / 2 - 100, var3 + 72 + 12 + 24 + 24, "Random Login"));
        this.buttonList.add(new GuiButton(4, GuiAltLogin.width / 2 - 100, var3 + 72 + 12 + 24 + 48, "Last Login"));
        this.buttonList.add(new GuiButton(1, GuiAltLogin.width / 2 - 100, var3 + 72 + 12 + 24, "Back"));
        this.username = new GuiTextField(var3, this.mc.fontRendererObj, GuiAltLogin.width / 2 - 100, 60, 200, 20);
        this.password = new PasswordField(this.mc.fontRendererObj, GuiAltLogin.width / 2 - 100, 100, 200, 20);
        this.username.setFocused(true);
        Keyboard.enableRepeatEvents(true);
    }
    
    @Override
    protected void keyTyped(final char character, final int key) {
        try {
            super.keyTyped(character, key);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        if (character == '\t') {
            if (!this.username.isFocused() && !this.password.isFocused()) {
                this.username.setFocused(true);
            }
            else {
                this.username.setFocused(this.password.isFocused());
                this.password.setFocused(!this.username.isFocused());
            }
        }
        if (character == '\r') {
            this.actionPerformed(this.buttonList.get(0));
        }
        this.username.textboxKeyTyped(character, key);
        this.password.textboxKeyTyped(character, key);
    }
    
    @Override
    protected void mouseClicked(final int x2, final int y2, final int button) {
        try {
            super.mouseClicked(x2, y2, button);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        this.username.mouseClicked(x2, y2, button);
        this.password.mouseClicked(x2, y2, button);
    }
    
    @Override
    public void onGuiClosed() {
        Keyboard.enableRepeatEvents(false);
        try {
            final FileWriter myWriter = new FileWriter("BLueDDFolder/Mail.txt");
            myWriter.write(GuiAltLogin.Email);
            myWriter.close();
            final FileWriter myWriter2 = new FileWriter("BLueDDFolder/Pass.txt");
            myWriter2.write(GuiAltLogin.Password);
            myWriter2.close();
            System.out.println("Successfully wrote to the file.");
        }
        catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    
    @Override
    public void updateScreen() {
        this.username.updateCursorCounter();
        this.password.updateCursorCounter();
    }
    
    public static void drawEntityOnScreen(final int posX, final int posY, final float scale, final float yawRotate, final float pitchRotate, final EntityLivingBase ent) {
        GlStateManager.disableBlend();
        GlStateManager.depthMask(true);
        GlStateManager.enableDepth();
        GlStateManager.enableAlpha();
        GlStateManager.enableColorMaterial();
        GlStateManager.pushMatrix();
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        GlStateManager.translate((float)posX, (float)posY, 50.0f);
        GlStateManager.scale(-scale, scale, scale);
        GlStateManager.rotate(pitchRotate, 0.0f, 0.0f, 1.0f);
        GlStateManager.rotate(yawRotate, 0.0f, 1.0f, 0.0f);
        final float f2 = ent.renderYawOffset;
        final float f3 = ent.rotationYaw;
        final float f4 = ent.rotationPitch;
        final float f5 = ent.prevRotationYawHead;
        final float f6 = ent.rotationYawHead;
        RenderHelper.enableStandardItemLighting();
        ent.renderYawOffset = (float)Math.atan(yawRotate / 40.0f);
        ent.rotationYaw = (float)Math.atan(yawRotate / 40.0f);
        ent.rotationPitch = -(float)Math.atan(0.0) * 20.0f;
        ent.rotationYawHead = ent.rotationYaw;
        ent.prevRotationYawHead = ent.rotationYaw;
        GlStateManager.translate(0.0f, 0.0f, 0.0f);
        try {
            final RenderManager rendermanager = Minecraft.getMinecraft().getRenderManager();
            rendermanager.setPlayerViewY(180.0f);
            rendermanager.setRenderShadow(false);
            rendermanager.doRenderEntity(ent, 0.0, 0.0, 0.0, 0.0f, 1.0f, true);
            rendermanager.setRenderShadow(true);
        }
        finally {
            ent.renderYawOffset = f2;
            ent.rotationYaw = f3;
            ent.rotationPitch = f4;
            ent.prevRotationYawHead = f5;
            ent.rotationYawHead = f6;
            GlStateManager.popMatrix();
            RenderHelper.disableStandardItemLighting();
            GlStateManager.disableRescaleNormal();
            GlStateManager.setActiveTexture(OpenGlHelper.lightmapTexUnit);
            GlStateManager.disableTexture2D();
            GlStateManager.setActiveTexture(OpenGlHelper.defaultTexUnit);
            GlStateManager.translate(0.0f, 0.0f, 20.0f);
        }
        ent.renderYawOffset = f2;
        ent.rotationYaw = f3;
        ent.rotationPitch = f4;
        ent.prevRotationYawHead = f5;
        ent.rotationYawHead = f6;
        GlStateManager.popMatrix();
        RenderHelper.disableStandardItemLighting();
        GlStateManager.disableRescaleNormal();
        GlStateManager.setActiveTexture(OpenGlHelper.lightmapTexUnit);
        GlStateManager.disableTexture2D();
        GlStateManager.setActiveTexture(OpenGlHelper.defaultTexUnit);
        GlStateManager.translate(0.0f, 0.0f, 20.0f);
        ent.renderYawOffset = f2;
        ent.rotationYaw = f3;
        ent.rotationPitch = f4;
        ent.prevRotationYawHead = f5;
        ent.rotationYawHead = f6;
        GlStateManager.popMatrix();
        RenderHelper.disableStandardItemLighting();
        GlStateManager.disableRescaleNormal();
        GlStateManager.setActiveTexture(OpenGlHelper.lightmapTexUnit);
        GlStateManager.disableTexture2D();
        GlStateManager.setActiveTexture(OpenGlHelper.defaultTexUnit);
        GlStateManager.translate(0.0f, 0.0f, 20.0f);
    }
}
