// 
// Decompiled by Procyon v0.5.36
// 

package BLueDD;

import BLueDD.event.EventTarget;
import BLueDD.mod.impl.FullBright;
import net.minecraft.client.gui.GuiScreen;
import BLueDD.hud.mod.HUDConfigScreen;
import BLueDD.event.impl.ClientTick;
import org.lwjgl.opengl.Display;
import javax.swing.ImageIcon;
import net.minecraft.client.renderer.entity.RendererLivingEntity;
import javax.swing.JFrame;
import BLueDD.betterfps.BetterFpsHelper;
import io.prplz.memoryfix.MemoryFix;
import pregenerator.ChunkPregenerator;
import BLueDD.TimeChanger.TimeChanger;
import BLueDD.hud.mod.HudManager;
import BLueDD.mod.ModManager;
import BLueDD.config.util.Config;
import BLueDD.event.EventManager;
import net.minecraft.client.Minecraft;

public class Client
{
    public static String name;
    public static String version;
    public static String author;
    public static String namever;
    public static Client INSTANCE;
    public static Client getInstance;
    public static boolean Skine;
    Minecraft mc;
    public EventManager eventManager;
    public Config config;
    public ModManager modManager;
    public HudManager hudManager;
    public TimeChanger timec;
    public DatabaseUtil data;
    public ChunkPregenerator chunk;
    public MemoryFix emory;
    public BetterFpsHelper fps;
    public JFrame frame;
    public RendererLivingEntity renderenity;
    public ImageIcon image;
    
    static {
        Client.name = "SeaClient";
        Client.version = "Beta2.3";
        Client.author = "BLueDD";
        Client.namever = String.valueOf(Client.name) + " " + Client.version;
        Client.INSTANCE = new Client();
    }
    
    public Client() {
        this.mc = Minecraft.getMinecraft();
        this.frame = new JFrame();
        this.image = new ImageIcon("BLueDD/logo.png");
    }
    
    public static Client getInstance() {
        return Client.INSTANCE;
    }
    
    public void init() {
    }
    
    public void startup() {
        this.frame.setIconImage(this.image.getImage());
        this.emory = new MemoryFix();
        this.data = new DatabaseUtil();
        this.chunk = new ChunkPregenerator();
        (this.config = new Config()).loadModConfig();
        this.eventManager = new EventManager();
        this.modManager = new ModManager();
        this.emory = new MemoryFix();
        this.fps = new BetterFpsHelper();
        this.hudManager = new HudManager();
        System.out.println("Starting " + Client.namever);
        Display.setTitle(Client.namever);
        EventManager.register(this);
    }
    
    public void shutdown() {
        BetterFpsHelper.saveConfig();
        System.out.println("Shutting Down " + Client.namever);
        this.config.saveModConfig();
        this.mc.shutdown();
    }
    
    @EventTarget
    public void onTick(final ClientTick event) {
        if (this.mc.gameSettings.HUD_CONFIG.isPressed()) {
            this.mc.displayGuiScreen(new HUDConfigScreen());
        }
        if (this.mc.gameSettings.CLIENT_PERSPECTIVE.isPressed() && this.hudManager.freelook.isEnabled()) {
            ModManager.getModPerspective().toggle();
        }
        if (this.hudManager.item.isEnabled()) {
            this.modManager.itempsic.toggle();
        }
        if (this.mc.gameSettings.SPRINTING.isPressed() && this.hudManager.sprint.isEnabled()) {
            this.modManager.sprint.toggle();
        }
        if (this.hudManager.fullbright.isEnabled()) {
            final FullBright full = this.modManager.full;
            FullBright.isEnabled();
        }
    }
}
