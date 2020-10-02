package p118io.presage.ads;

import android.content.Context;
import android.util.Log;

/* renamed from: io.presage.ads.Ads */
public class Ads {
    public static void initialize(Context context, String str) {
        try {
            Class.forName("io.presage.common.PresageSdk").getMethod("init", new Class[]{Context.class, String.class}).invoke((Object) null, new Object[]{context, str});
        } catch (Error | Exception e) {
            Log.e("Presage.Ads", "An error occurred while initializing", e);
        }
    }
}
