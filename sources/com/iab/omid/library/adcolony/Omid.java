package com.iab.omid.library.adcolony;

import android.content.Context;

public final class Omid {

    /* renamed from: a */
    private static C4149b f11106a = new C4149b();

    private Omid() {
    }

    public static void activate(Context context) {
        f11106a.mo28501a(context.getApplicationContext());
    }

    public static String getVersion() {
        return f11106a.mo28500a();
    }

    public static boolean isActive() {
        return f11106a.mo28503b();
    }
}
