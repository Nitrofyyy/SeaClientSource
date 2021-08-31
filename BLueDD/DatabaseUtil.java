// 
// Decompiled by Procyon v0.5.36
// 

package BLueDD;

import java.io.IOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.util.Scanner;
import java.net.URL;
import com.google.gson.JsonArray;

public class DatabaseUtil
{
    private static String stringurl;
    private static JsonArray data;
    
    static {
        DatabaseUtil.stringurl = "https://raw.githubusercontent.com/cornly/coscoremod/main/cos.json";
    }
    
    public static void parseData() {
        URL url = null;
        try {
            url = new URL(DatabaseUtil.stringurl);
            final Scanner scanner = new Scanner(url.openStream(), "UTF-8").useDelimiter("\\A");
            final String result = scanner.next();
            final JsonParser parser = new JsonParser();
            DatabaseUtil.data = parser.parse(result).getAsJsonArray();
            scanner.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static boolean getBoolean(final String playerUUID, final String key) throws IOException {
        for (int i = 0; i < DatabaseUtil.data.size(); ++i) {
            final JsonObject jsonObject = DatabaseUtil.data.get(i).getAsJsonObject();
            if (jsonObject.get("uuid").getAsString().equals(playerUUID) && jsonObject.get(key).getAsBoolean()) {
                return true;
            }
        }
        return false;
    }
    
    public static double getDouble(final String playerUUID, final String key) throws IOException {
        for (int i = 0; i < DatabaseUtil.data.size(); ++i) {
            final JsonObject jsonObject = DatabaseUtil.data.get(i).getAsJsonObject();
            if (jsonObject.get("uuid").getAsString().equals(playerUUID)) {
                return jsonObject.get(key).getAsDouble();
            }
        }
        return (double)null;
    }
    
    public static String getString(final String playerUUID, final String key) throws IOException {
        for (int i = 0; i < DatabaseUtil.data.size(); ++i) {
            final JsonObject jsonObject = DatabaseUtil.data.get(i).getAsJsonObject();
            if (jsonObject.get("uuid").getAsString().equals(playerUUID)) {
                return jsonObject.get(key).getAsString();
            }
        }
        return null;
    }
    
    public static Integer getInt(final String playerUUID, final String key) throws IOException {
        for (int i = 0; i < DatabaseUtil.data.size(); ++i) {
            final JsonObject jsonObject = DatabaseUtil.data.get(i).getAsJsonObject();
            if (jsonObject.get("uuid").getAsString().equals(playerUUID)) {
                return jsonObject.get(key).getAsInt();
            }
        }
        return null;
    }
}
