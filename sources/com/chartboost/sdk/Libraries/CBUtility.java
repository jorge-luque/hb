package com.chartboost.sdk.Libraries;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.view.Display;
import android.view.WindowManager;
import com.chartboost.sdk.C2242k;
import com.chartboost.sdk.Chartboost;
import com.chartboost.sdk.Model.C2093h;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public final class CBUtility {
    private CBUtility() {
    }

    /* renamed from: a */
    public static float m8161a(Context context) {
        return context.getResources().getDisplayMetrics().density;
    }

    /* renamed from: a */
    public static boolean m8166a(int i) {
        return i == 1 || i == 3;
    }

    /* renamed from: b */
    private static boolean m8170b() {
        String[] strArr = {"/sbin/su", "/system/bin/su", "/system/xbin/su", "/data/local/xbin/su", "/data/local/bin/su", "/system/sd/xbin/su", "/system/bin/failsafe/su", "/data/local/su"};
        for (int i = 0; i < 8; i++) {
            if (new File(strArr[i]).exists()) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: b */
    public static boolean m8171b(int i) {
        return i == 0 || i == 2;
    }

    /* renamed from: c */
    private static boolean m8172c() {
        return new File("/system/app/Superuser.apk").exists();
    }

    /* renamed from: d */
    public static String m8173d() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("ZZZZ", Locale.US);
        simpleDateFormat.setTimeZone(TimeZone.getDefault());
        return simpleDateFormat.format(new Date());
    }

    /* renamed from: e */
    public static int m8174e() {
        Context context = C2242k.f7612l;
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        int rotation = defaultDisplay.getRotation();
        boolean z = defaultDisplay.getWidth() != defaultDisplay.getHeight() ? defaultDisplay.getWidth() < defaultDisplay.getHeight() : context.getResources().getConfiguration().orientation != 2;
        if (!(rotation == 0 || rotation == 2)) {
            z = !z;
        }
        if (z) {
            if (rotation == 1) {
                return 1;
            }
            if (rotation == 2) {
                return 2;
            }
            if (rotation != 3) {
                return 0;
            }
            return 3;
        } else if (rotation == 1) {
            return 2;
        } else {
            if (rotation != 2) {
                return rotation != 3 ? 1 : 0;
            }
            return 3;
        }
    }

    /* renamed from: f */
    public static String m8175f() {
        Object[] objArr = new Object[3];
        objArr[0] = "Chartboost-Android-SDK";
        Object obj = C2242k.f7605e;
        if (obj == null) {
            obj = "";
        }
        objArr[1] = obj;
        objArr[2] = "8.0.3";
        return String.format("%s %s %s", objArr);
    }

    /* renamed from: g */
    public static boolean m8176g() {
        return m8165a() || m8172c() || m8170b();
    }

    public static void throwProguardError(Exception exc) {
        if (exc instanceof NoSuchMethodException) {
            CBLogging.m8154b("CBUtility", "Chartboost library error! Have you used proguard on your application? Make sure to add the line '-keep class com.chartboost.sdk.** { *; }' to your proguard config file.");
        } else if (exc == null || exc.getMessage() == null) {
            CBLogging.m8154b("CBUtility", "Unknown Proguard error");
        } else {
            CBLogging.m8154b("CBUtility", exc.getMessage());
        }
    }

    /* renamed from: a */
    public static int m8162a(int i, Context context) {
        return Math.round(((float) i) * m8161a(context));
    }

    /* renamed from: a */
    public static float m8160a(float f, Context context) {
        return f * m8161a(context);
    }

    /* renamed from: b */
    public static void m8169b(Activity activity, int i, C2093h hVar) {
        if (activity != null && !m8167a(activity)) {
            if ((i == 1 && hVar.f7023w && hVar.f7026z) || (i == 0 && hVar.f7005e && hVar.f7008h)) {
                activity.setRequestedOrientation(-1);
            }
        }
    }

    /* renamed from: a */
    private static boolean m8165a() {
        String str = Build.TAGS;
        return str != null && str.contains("test-keys");
    }

    /* renamed from: a */
    public static void m8164a(Activity activity, int i, C2093h hVar) {
        if (activity != null && !m8167a(activity)) {
            if ((i == 1 && hVar.f7023w && hVar.f7026z) || (i == 0 && hVar.f7005e && hVar.f7008h)) {
                int e = m8174e();
                if (e == 0) {
                    activity.setRequestedOrientation(1);
                } else if (e == 2) {
                    activity.setRequestedOrientation(9);
                } else if (e == 1) {
                    activity.setRequestedOrientation(0);
                } else {
                    activity.setRequestedOrientation(8);
                }
            }
        }
    }

    /* renamed from: a */
    public static boolean m8168a(Chartboost.CBFramework cBFramework) {
        Chartboost.CBFramework cBFramework2 = C2242k.f7605e;
        return cBFramework2 != null && cBFramework2 == cBFramework;
    }

    /* renamed from: a */
    public static ArrayList<File> m8163a(File file, boolean z) {
        if (file == null) {
            return null;
        }
        ArrayList<File> arrayList = new ArrayList<>();
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            for (File file2 : listFiles) {
                if (file2.isFile() && !file2.getName().equals(".nomedia")) {
                    arrayList.add(file2);
                } else if (file2.isDirectory() && z) {
                    arrayList.addAll(m8163a(file2, z));
                }
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    public static boolean m8167a(Activity activity) {
        if (activity == null || activity.getWindow() == null || activity.getWindow().getDecorView() == null || activity.getWindow().getDecorView().getBackground() == null) {
            return true;
        }
        if (Build.VERSION.SDK_INT != 26 || activity.getApplicationInfo().targetSdkVersion <= 26 || activity.getWindow().getDecorView().getBackground().getAlpha() == 255) {
            return false;
        }
        return true;
    }
}
