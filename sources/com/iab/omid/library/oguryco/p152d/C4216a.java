package com.iab.omid.library.oguryco.p152d;

import android.os.Build;
import org.json.JSONObject;

/* renamed from: com.iab.omid.library.oguryco.d.a */
public final class C4216a {
    /* renamed from: a */
    public static String m14204a() {
        return Build.MANUFACTURER + "; " + Build.MODEL;
    }

    /* renamed from: b */
    public static String m14205b() {
        return Integer.toString(Build.VERSION.SDK_INT);
    }

    /* renamed from: c */
    public static String m14206c() {
        return "Android";
    }

    /* renamed from: d */
    public static JSONObject m14207d() {
        JSONObject jSONObject = new JSONObject();
        C4217b.m14214a(jSONObject, "deviceType", m14204a());
        C4217b.m14214a(jSONObject, "osVersion", m14205b());
        C4217b.m14214a(jSONObject, "os", m14206c());
        return jSONObject;
    }
}
