package com.iab.omid.library.oguryco;

import android.content.Context;

public final class Omid {
    private static C4200b INSTANCE = new C4200b();

    private Omid() {
    }

    public static void activate(Context context) {
        INSTANCE.mo28714a(context.getApplicationContext());
    }

    public static boolean activateWithOmidApiVersion(String str, Context context) {
        INSTANCE.mo28714a(context.getApplicationContext());
        return true;
    }

    public static String getVersion() {
        return INSTANCE.mo28713a();
    }

    public static boolean isActive() {
        return INSTANCE.mo28717b();
    }

    public static boolean isCompatibleWithOmidApiVersion(String str) {
        return INSTANCE.mo28716a(str);
    }
}
