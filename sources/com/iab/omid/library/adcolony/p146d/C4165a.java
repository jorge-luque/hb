package com.iab.omid.library.adcolony.p146d;

import android.os.Build;
import org.json.JSONObject;

/* renamed from: com.iab.omid.library.adcolony.d.a */
public final class C4165a {
    /* renamed from: a */
    public static String m13975a() {
        return Build.MANUFACTURER + "; " + Build.MODEL;
    }

    /* renamed from: b */
    public static String m13976b() {
        return Integer.toString(Build.VERSION.SDK_INT);
    }

    /* renamed from: c */
    public static String m13977c() {
        return "Android";
    }

    /* renamed from: d */
    public static JSONObject m13978d() {
        JSONObject jSONObject = new JSONObject();
        C4166b.m13985a(jSONObject, "deviceType", m13975a());
        C4166b.m13985a(jSONObject, "osVersion", m13976b());
        C4166b.m13985a(jSONObject, "os", m13977c());
        return jSONObject;
    }
}
