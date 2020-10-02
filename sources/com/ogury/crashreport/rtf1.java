package com.ogury.crashreport;

import android.content.Context;
import android.content.pm.PackageInfo;

/* compiled from: AppInfo.kt */
public final class rtf1 {

    /* renamed from: a */
    public static final C6851rtf1 f12227a = new C6851rtf1((byte) 0);

    /* renamed from: b */
    private final String f12228b;

    /* renamed from: c */
    private final String f12229c;

    /* renamed from: com.ogury.crashreport.rtf1$rtf1  reason: collision with other inner class name */
    /* compiled from: AppInfo.kt */
    public static final class C6851rtf1 {
        private C6851rtf1() {
        }

        /* renamed from: a */
        public static rtf1 m15316a(Context context) {
            PackageInfo packageInfo;
            String str;
            tx7920.m15333b(context, "context");
            try {
                packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            } catch (Exception e) {
                C4454f0 f0Var = C4454f0.f12201a;
                C4454f0.m15288a(e);
                packageInfo = null;
            }
            if (packageInfo == null || (str = packageInfo.versionName) == null) {
                str = "";
            }
            String packageName = context.getPackageName();
            tx7920.m15330a((Object) packageName, "context.packageName");
            return new rtf1(str, packageName);
        }

        /* renamed from: b */
        private static int m15317b(int i, int i2, int i3) {
            return m15314a(m15314a(i, i3) - m15314a(i2, i3), i3);
        }

        public /* synthetic */ C6851rtf1(byte b) {
            this();
        }

        /* renamed from: a */
        private static int m15314a(int i, int i2) {
            int i3 = i % i2;
            return i3 >= 0 ? i3 : i3 + i2;
        }

        /* renamed from: a */
        public static int m15315a(int i, int i2, int i3) {
            if (i3 > 0) {
                return i >= i2 ? i2 : i2 - m15317b(i2, i, i3);
            }
            if (i3 >= 0) {
                throw new IllegalArgumentException("Step is zero.");
            } else if (i <= i2) {
                return i2;
            } else {
                return i2 + m15317b(i, i2, -i3);
            }
        }
    }

    public rtf1(String str, String str2) {
        tx7920.m15333b(str, "version");
        tx7920.m15333b(str2, "packageName");
        this.f12228b = str;
        this.f12229c = str2;
    }

    /* renamed from: a */
    public final String mo29612a() {
        return this.f12228b;
    }

    /* renamed from: b */
    public final String mo29613b() {
        return this.f12229c;
    }
}
