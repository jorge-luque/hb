package com.tapjoy;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.webkit.WebView;
import com.tapjoy.TapjoyErrorMessage;
import com.tapjoy.internal.C3145gz;
import com.tapjoy.internal.C5139gw;

public class TapjoyLog {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static final String f13277a = "TapjoyLog";

    /* renamed from: b */
    private static int f13278b = 6;

    /* renamed from: c */
    private static int f13279c = 4;

    /* renamed from: d */
    private static int f13280d = 2;

    /* renamed from: e */
    private static boolean f13281e = false;

    /* renamed from: f */
    private static int f13282f = 6;

    /* renamed from: d */
    public static void m16649d(String str, String str2) {
        m16647a(3, str, str2);
    }

    /* renamed from: e */
    public static void m16651e(String str, String str2) {
        m16650e(str, new TapjoyErrorMessage(TapjoyErrorMessage.ErrorType.INTERNAL_ERROR, str2));
    }

    /* renamed from: i */
    public static void m16652i(String str, String str2) {
        m16647a(4, str, str2);
    }

    public static boolean isLoggingEnabled() {
        return f13281e;
    }

    public static void setDebugEnabled(boolean z) {
        boolean z2;
        f13281e = z;
        C3145gz a = C3145gz.m10321a();
        if (C5139gw.f14055a != z) {
            C5139gw.f14055a = z;
            if (z) {
                C5139gw.m17323a("The debug mode has been enabled");
            } else {
                C5139gw.m17323a("The debug mode has been disabled");
            }
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2 && z && a.f8767k) {
            a.f8765i.mo31316a();
        }
        if (f13281e) {
            m16648a(TapjoyConstants.LOG_LEVEL_DEBUG_ON, false);
        } else {
            m16648a(TapjoyConstants.LOG_LEVEL_DEBUG_OFF, false);
        }
    }

    public static void setInternalLogging(boolean z) {
        if (z) {
            m16648a(TapjoyConstants.LOG_LEVEL_INTERNAL, true);
        }
    }

    /* renamed from: v */
    public static void m16653v(String str, String str2) {
        m16647a(2, str, str2);
    }

    /* renamed from: w */
    public static void m16654w(String str, String str2) {
        m16647a(5, str, str2);
    }

    @TargetApi(19)
    /* renamed from: a */
    static void m16648a(String str, boolean z) {
        if (z || TapjoyAppSettings.getInstance() == null || TapjoyAppSettings.getInstance().f13134a == null) {
            if (str.equals(TapjoyConstants.LOG_LEVEL_INTERNAL)) {
                f13282f = f13280d;
                if (Build.VERSION.SDK_INT >= 19) {
                    new Handler(Looper.getMainLooper()).post(new Runnable() {
                        public final void run() {
                            TapjoyLog.m16649d(TapjoyLog.f13277a, "Enabling WebView debugging");
                            WebView.setWebContentsDebuggingEnabled(true);
                        }
                    });
                }
            } else if (str.equals(TapjoyConstants.LOG_LEVEL_DEBUG_ON)) {
                f13282f = f13279c;
            } else if (str.equals(TapjoyConstants.LOG_LEVEL_DEBUG_OFF)) {
                f13282f = f13278b;
            } else {
                String str2 = f13277a;
                m16649d(str2, "unrecognized loggingLevel: " + str);
                f13282f = f13278b;
            }
            String str3 = f13277a;
            m16649d(str3, "logThreshold=" + f13282f);
            return;
        }
        m16649d(f13277a, "setLoggingLevel -- log setting already persisted");
    }

    /* renamed from: e */
    public static void m16650e(String str, TapjoyErrorMessage tapjoyErrorMessage) {
        if (tapjoyErrorMessage == null) {
            return;
        }
        if (f13282f == f13280d || tapjoyErrorMessage.getType() != TapjoyErrorMessage.ErrorType.INTERNAL_ERROR) {
            m16647a(6, str, tapjoyErrorMessage.toString());
        }
    }

    /* renamed from: a */
    private static void m16647a(int i, String str, String str2) {
        String str3 = f13277a + ":" + str;
        if (f13282f > i) {
            return;
        }
        if (str2.length() > 4096) {
            int i2 = 0;
            while (i2 <= str2.length() / CodedOutputStream.DEFAULT_BUFFER_SIZE) {
                int i3 = i2 * CodedOutputStream.DEFAULT_BUFFER_SIZE;
                i2++;
                int i4 = i2 * CodedOutputStream.DEFAULT_BUFFER_SIZE;
                if (i4 > str2.length()) {
                    i4 = str2.length();
                }
                Log.println(i, str3, str2.substring(i3, i4));
            }
            return;
        }
        Log.println(i, str3, str2);
    }
}
