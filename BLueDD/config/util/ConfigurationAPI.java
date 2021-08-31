// 
// Decompiled by Procyon v0.5.36
// 

package BLueDD.config.util;

import java.io.IOException;
import org.json.JSONObject;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.Charsets;
import java.io.File;

public class ConfigurationAPI
{
    public static Configuration loadExistingConfiguration(final File file) throws IOException {
        final JSONObject jsonObject = new JSONObject(FileUtils.readFileToString(file, Charsets.UTF_8));
        return new Configuration(file, jsonObject.toMap());
    }
    
    public static Configuration newConfiguration(final File file) {
        return new Configuration(file);
    }
}
