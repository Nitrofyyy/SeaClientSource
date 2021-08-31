// 
// Decompiled by Procyon v0.5.36
// 

package net.optifine.shaders.config;

import net.optifine.shaders.Shaders;
import net.minecraft.src.Config;
import net.minecraft.util.Util;

public class ShaderMacros
{
    private static String PREFIX_MACRO;
    public static final String MC_VERSION = "MC_VERSION";
    public static final String MC_GL_VERSION = "MC_GL_VERSION";
    public static final String MC_GLSL_VERSION = "MC_GLSL_VERSION";
    public static final String MC_OS_WINDOWS = "MC_OS_WINDOWS";
    public static final String MC_OS_MAC = "MC_OS_MAC";
    public static final String MC_OS_LINUX = "MC_OS_LINUX";
    public static final String MC_OS_OTHER = "MC_OS_OTHER";
    public static final String MC_GL_VENDOR_ATI = "MC_GL_VENDOR_ATI";
    public static final String MC_GL_VENDOR_INTEL = "MC_GL_VENDOR_INTEL";
    public static final String MC_GL_VENDOR_NVIDIA = "MC_GL_VENDOR_NVIDIA";
    public static final String MC_GL_VENDOR_XORG = "MC_GL_VENDOR_XORG";
    public static final String MC_GL_VENDOR_OTHER = "MC_GL_VENDOR_OTHER";
    public static final String MC_GL_RENDERER_RADEON = "MC_GL_RENDERER_RADEON";
    public static final String MC_GL_RENDERER_GEFORCE = "MC_GL_RENDERER_GEFORCE";
    public static final String MC_GL_RENDERER_QUADRO = "MC_GL_RENDERER_QUADRO";
    public static final String MC_GL_RENDERER_INTEL = "MC_GL_RENDERER_INTEL";
    public static final String MC_GL_RENDERER_GALLIUM = "MC_GL_RENDERER_GALLIUM";
    public static final String MC_GL_RENDERER_MESA = "MC_GL_RENDERER_MESA";
    public static final String MC_GL_RENDERER_OTHER = "MC_GL_RENDERER_OTHER";
    public static final String MC_FXAA_LEVEL = "MC_FXAA_LEVEL";
    public static final String MC_NORMAL_MAP = "MC_NORMAL_MAP";
    public static final String MC_SPECULAR_MAP = "MC_SPECULAR_MAP";
    public static final String MC_RENDER_QUALITY = "MC_RENDER_QUALITY";
    public static final String MC_SHADOW_QUALITY = "MC_SHADOW_QUALITY";
    public static final String MC_HAND_DEPTH = "MC_HAND_DEPTH";
    public static final String MC_OLD_HAND_LIGHT = "MC_OLD_HAND_LIGHT";
    public static final String MC_OLD_LIGHTING = "MC_OLD_LIGHTING";
    private static ShaderMacro[] extensionMacros;
    
    static {
        ShaderMacros.PREFIX_MACRO = "MC_";
    }
    
    public static String getOs() {
        final Util.EnumOS util$enumos = Util.getOSType();
        switch (util$enumos) {
            case WINDOWS: {
                return "MC_OS_WINDOWS";
            }
            case OSX: {
                return "MC_OS_MAC";
            }
            case LINUX: {
                return "MC_OS_LINUX";
            }
            default: {
                return "MC_OS_OTHER";
            }
        }
    }
    
    public static String getVendor() {
        String s = Config.openGlVendor;
        if (s == null) {
            return "MC_GL_VENDOR_OTHER";
        }
        s = s.toLowerCase();
        return s.startsWith("ati") ? "MC_GL_VENDOR_ATI" : (s.startsWith("intel") ? "MC_GL_VENDOR_INTEL" : (s.startsWith("nvidia") ? "MC_GL_VENDOR_NVIDIA" : (s.startsWith("x.org") ? "MC_GL_VENDOR_XORG" : "MC_GL_VENDOR_OTHER")));
    }
    
    public static String getRenderer() {
        String s = Config.openGlRenderer;
        if (s == null) {
            return "MC_GL_RENDERER_OTHER";
        }
        s = s.toLowerCase();
        return s.startsWith("amd") ? "MC_GL_RENDERER_RADEON" : (s.startsWith("ati") ? "MC_GL_RENDERER_RADEON" : (s.startsWith("radeon") ? "MC_GL_RENDERER_RADEON" : (s.startsWith("gallium") ? "MC_GL_RENDERER_GALLIUM" : (s.startsWith("intel") ? "MC_GL_RENDERER_INTEL" : (s.startsWith("geforce") ? "MC_GL_RENDERER_GEFORCE" : (s.startsWith("nvidia") ? "MC_GL_RENDERER_GEFORCE" : (s.startsWith("quadro") ? "MC_GL_RENDERER_QUADRO" : (s.startsWith("nvs") ? "MC_GL_RENDERER_QUADRO" : (s.startsWith("mesa") ? "MC_GL_RENDERER_MESA" : "MC_GL_RENDERER_OTHER")))))))));
    }
    
    public static String getPrefixMacro() {
        return ShaderMacros.PREFIX_MACRO;
    }
    
    public static ShaderMacro[] getExtensions() {
        if (ShaderMacros.extensionMacros == null) {
            final String[] astring = Config.getOpenGlExtensions();
            final ShaderMacro[] ashadermacro = new ShaderMacro[astring.length];
            for (int i = 0; i < astring.length; ++i) {
                ashadermacro[i] = new ShaderMacro(String.valueOf(ShaderMacros.PREFIX_MACRO) + astring[i], "");
            }
            ShaderMacros.extensionMacros = ashadermacro;
        }
        return ShaderMacros.extensionMacros;
    }
    
    public static String getFixedMacroLines() {
        final StringBuilder stringbuilder = new StringBuilder();
        addMacroLine(stringbuilder, "MC_VERSION", Config.getMinecraftVersionInt());
        addMacroLine(stringbuilder, "MC_GL_VERSION " + Config.getGlVersion().toInt());
        addMacroLine(stringbuilder, "MC_GLSL_VERSION " + Config.getGlslVersion().toInt());
        addMacroLine(stringbuilder, getOs());
        addMacroLine(stringbuilder, getVendor());
        addMacroLine(stringbuilder, getRenderer());
        return stringbuilder.toString();
    }
    
    public static String getOptionMacroLines() {
        final StringBuilder stringbuilder = new StringBuilder();
        if (Shaders.configAntialiasingLevel > 0) {
            addMacroLine(stringbuilder, "MC_FXAA_LEVEL", Shaders.configAntialiasingLevel);
        }
        if (Shaders.configNormalMap) {
            addMacroLine(stringbuilder, "MC_NORMAL_MAP");
        }
        if (Shaders.configSpecularMap) {
            addMacroLine(stringbuilder, "MC_SPECULAR_MAP");
        }
        addMacroLine(stringbuilder, "MC_RENDER_QUALITY", Shaders.configRenderResMul);
        addMacroLine(stringbuilder, "MC_SHADOW_QUALITY", Shaders.configShadowResMul);
        addMacroLine(stringbuilder, "MC_HAND_DEPTH", Shaders.configHandDepthMul);
        if (Shaders.isOldHandLight()) {
            addMacroLine(stringbuilder, "MC_OLD_HAND_LIGHT");
        }
        if (Shaders.isOldLighting()) {
            addMacroLine(stringbuilder, "MC_OLD_LIGHTING");
        }
        return stringbuilder.toString();
    }
    
    private static void addMacroLine(final StringBuilder sb, final String name, final int value) {
        sb.append("#define ");
        sb.append(name);
        sb.append(" ");
        sb.append(value);
        sb.append("\n");
    }
    
    private static void addMacroLine(final StringBuilder sb, final String name, final float value) {
        sb.append("#define ");
        sb.append(name);
        sb.append(" ");
        sb.append(value);
        sb.append("\n");
    }
    
    private static void addMacroLine(final StringBuilder sb, final String name) {
        sb.append("#define ");
        sb.append(name);
        sb.append("\n");
    }
}
