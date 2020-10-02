package com.applovin.impl.sdk.utils;

import android.content.Context;
import android.graphics.Point;
import android.os.Build;
import android.os.StrictMode;
import android.view.Display;
import android.view.WindowManager;

/* renamed from: com.applovin.impl.sdk.utils.g */
public class C1991g {
    /* renamed from: a */
    public static Point m7836a(Context context) {
        Point point = new Point();
        point.x = 480;
        point.y = 320;
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        if (windowManager != null) {
            Display defaultDisplay = windowManager.getDefaultDisplay();
            if (m7839b()) {
                defaultDisplay.getRealSize(point);
            } else {
                defaultDisplay.getSize(point);
            }
        }
        return point;
    }

    /* renamed from: a */
    public static void m7837a() {
        try {
            StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().permitAll().build());
        } catch (Throwable unused) {
        }
    }

    /* renamed from: a */
    public static boolean m7838a(String str, Context context) {
        return context.checkCallingOrSelfPermission(str) == 0;
    }

    /* renamed from: b */
    public static boolean m7839b() {
        return Build.VERSION.SDK_INT >= 17;
    }

    /* renamed from: c */
    public static boolean m7840c() {
        return Build.VERSION.SDK_INT >= 19;
    }

    /* renamed from: d */
    public static boolean m7841d() {
        return Build.VERSION.SDK_INT >= 21;
    }

    /* renamed from: e */
    public static boolean m7842e() {
        return Build.VERSION.SDK_INT >= 23;
    }

    /* renamed from: f */
    public static boolean m7843f() {
        return Build.VERSION.SDK_INT >= 24;
    }

    /* renamed from: g */
    public static boolean m7844g() {
        return Build.VERSION.SDK_INT >= 29;
    }
}
