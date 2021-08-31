// 
// Decompiled by Procyon v0.5.36
// 

package BLueDD.betterfps;

import java.io.OutputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.FileInputStream;
import java.lang.reflect.Field;
import javax.print.attribute.standard.MediaSize;
import java.util.Properties;
import java.io.File;
import java.util.LinkedHashMap;

public class BetterFpsHelper
{
    public static final String MC_VERSION = "1.8.9";
    public static final String VERSION = "1.2.0";
    public static final LinkedHashMap<String, String> helpers;
    public static final LinkedHashMap<String, String> displayHelpers;
    public static File LOC;
    public static File MCDIR;
    public static Properties CONFIG;
    private static File CONFIG_FILE;
    public static String ALGORITHM_NAME;
    public static String ALGORITHM_CLASS;
    
    static {
        helpers = new LinkedHashMap<String, String>();
        displayHelpers = new LinkedHashMap<String, String>();
        BetterFpsHelper.helpers.put("vanilla", "VanillaMath");
        BetterFpsHelper.helpers.put("rivens", "RivensMath");
        BetterFpsHelper.helpers.put("taylors", "TaylorMath");
        BetterFpsHelper.helpers.put("libgdx", "LibGDXMath");
        BetterFpsHelper.helpers.put("rivens-full", "RivensFullMath");
        BetterFpsHelper.helpers.put("rivens-half", "RivensHalfMath");
        BetterFpsHelper.helpers.put("java", "JavaMath");
        BetterFpsHelper.helpers.put("random", "RandomMath");
        BetterFpsHelper.displayHelpers.put("vanilla", "Vanilla Algorithm");
        BetterFpsHelper.displayHelpers.put("rivens", "Riven's Algorithm");
        BetterFpsHelper.displayHelpers.put("taylors", "Taylor's Algorithm");
        BetterFpsHelper.displayHelpers.put("libgdx", "LibGDX's Algorithm");
        BetterFpsHelper.displayHelpers.put("rivens-full", "Riven's \"Full\" Algorithm");
        BetterFpsHelper.displayHelpers.put("rivens-half", "Riven's \"Half\" Algorithm");
        BetterFpsHelper.displayHelpers.put("java", "Java Math");
        BetterFpsHelper.displayHelpers.put("random", "Random Math");
        BetterFpsHelper.MCDIR = null;
        BetterFpsHelper.CONFIG = null;
        BetterFpsHelper.CONFIG_FILE = null;
    }
    
    public static void init() {
        try {
            Field[] declaredFields;
            for (int length = (declaredFields = MediaSize.NA.class.getDeclaredFields()).length, i = 0; i < length; ++i) {
                final Field f = declaredFields[i];
                final String name = f.getName();
                if (name.equals("SIN_TABLE") || name.equals("b")) {
                    f.setAccessible(true);
                    f.set(null, null);
                }
            }
        }
        catch (Exception ex) {}
    }
    
    public static void loadConfig() {
        if (BetterFpsHelper.MCDIR == null) {
            BetterFpsHelper.CONFIG_FILE = new File("SeaClient/betterfps.txt");
        }
        BetterFpsHelper.CONFIG = new Properties();
        try {
            if (BetterFpsHelper.CONFIG_FILE.exists()) {
                BetterFpsHelper.CONFIG.load(new FileInputStream(BetterFpsHelper.CONFIG_FILE));
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        BetterFpsHelper.ALGORITHM_NAME = BetterFpsHelper.CONFIG.getProperty("algorithm", "rivens-half");
        BetterFpsHelper.ALGORITHM_CLASS = BetterFpsHelper.helpers.get(BetterFpsHelper.ALGORITHM_NAME);
        BetterFpsHelper.CONFIG.setProperty("algorithm", BetterFpsHelper.ALGORITHM_NAME);
        saveConfig();
    }
    
    public static void saveConfig() {
        try {
            if (!BetterFpsHelper.CONFIG_FILE.exists()) {
                BetterFpsHelper.CONFIG_FILE.createNewFile();
            }
            BetterFpsHelper.CONFIG.store(new FileOutputStream(BetterFpsHelper.CONFIG_FILE), "SeaClient/BetterFps Config");
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
