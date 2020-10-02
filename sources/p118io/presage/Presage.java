package p118io.presage;

import android.content.Context;
import p118io.presage.ads.Ads;
import p118io.presage.core.Core;

/* renamed from: io.presage.Presage */
public class Presage {
    public static Presage IIIIIIII;

    public static Presage getInstance() {
        if (IIIIIIII == null) {
            IIIIIIII = new Presage();
        }
        return IIIIIIII;
    }

    public void start(String str, Context context) {
        Ads.initialize(context, str);
        Core.initialize(context, str);
    }
}
