package p118io.presage.core;

import android.app.KeyguardManager;
import android.content.Context;
import android.graphics.Point;
import android.os.Build;
import android.os.PowerManager;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import p118io.presage.core.IIIlllll;

/* renamed from: io.presage.core.llllIIll */
public class llllIIll {
    public static final String IIIIIIII = C6327m.IIIIIIII;
    public static final String IIIIIIIl = C6327m.IIIIIIIl;
    public static final String IIIIIIlI = C6327m.IIIIIIlI;

    public static IIIlllll IIIIIIII(Context context) {
        String str = Build.BRAND;
        String str2 = Build.MANUFACTURER;
        String str3 = Build.MODEL;
        String str4 = Build.VERSION.RELEASE;
        int i = Build.VERSION.SDK_INT;
        String property = System.getProperty(IIIIIIII);
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        Point point = new Point();
        windowManager.getDefaultDisplay().getSize(point);
        return new IIIlllll(str, str2, str3, str4, i, property, new IIIlllll.IIIIIIII(displayMetrics.density, Math.min(point.x, point.y), Math.max(point.x, point.y)), new IIIlllll.IIIIIIIl(System.getProperty(IIIIIIIl), System.getProperty(IIIIIIlI)));
    }

    public static boolean IIIIIIIl(Context context) {
        KeyguardManager keyguardManager = (KeyguardManager) context.getSystemService("keyguard");
        if (Build.VERSION.SDK_INT >= 16) {
            PowerManager powerManager = (PowerManager) context.getSystemService("power");
            if (!(Build.VERSION.SDK_INT >= 20 ? powerManager.isInteractive() : powerManager.isScreenOn()) || keyguardManager.isKeyguardLocked()) {
                return false;
            }
            return true;
        }
        PowerManager powerManager2 = (PowerManager) context.getSystemService("power");
        if (!(Build.VERSION.SDK_INT >= 20 ? powerManager2.isInteractive() : powerManager2.isScreenOn()) || keyguardManager.inKeyguardRestrictedInputMode()) {
            return false;
        }
        return true;
    }
}
