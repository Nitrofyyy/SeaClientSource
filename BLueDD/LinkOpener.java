// 
// Decompiled by Procyon v0.5.36
// 

package BLueDD;

import java.net.URISyntaxException;
import java.io.IOException;
import java.net.URL;
import java.awt.Desktop;

public class LinkOpener
{
    public static void openLink(final String url) {
        final Desktop desktop = Desktop.getDesktop();
        if (desktop != null) {
            try {
                desktop.browse(new URL(url).toURI());
            }
            catch (IOException | URISyntaxException ex2) {
                final Exception ex;
                final Exception e = ex;
                e.printStackTrace();
            }
        }
    }
}
