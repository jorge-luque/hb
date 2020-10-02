package p118io.presage.core;

import android.content.ContentResolver;
import android.content.Context;
import android.os.Build;
import android.provider.Settings;

/* renamed from: io.presage.core.g1 */
public class C6305g1 {
    public static boolean IIIIIIII(Context context) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 26) {
            if (IIIIlIll.IIIIIIII(context, "android.permission.REQUEST_INSTALL_PACKAGES")) {
                return context.getPackageManager().canRequestPackageInstalls();
            }
            return false;
        } else if (i >= 21) {
            return Settings.Secure.getInt(context.getContentResolver(), "install_non_market_apps", 0) == 1;
        } else {
            ContentResolver contentResolver = context.getContentResolver();
            return i >= 17 ? Settings.Global.getInt(contentResolver, "install_non_market_apps", 0) == 1 : Settings.Secure.getInt(contentResolver, "install_non_market_apps", 0) == 1;
        }
    }
}
