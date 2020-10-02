package com.applovin.impl.sdk;

import android.util.Log;
import com.applovin.impl.sdk.p050b.C1841c;
import com.applovin.impl.sdk.utils.C2025o;

/* renamed from: com.applovin.impl.sdk.q */
public class C1977q {

    /* renamed from: a */
    private final C1941j f6622a;

    C1977q(C1941j jVar) {
        this.f6622a = jVar;
    }

    /* renamed from: a */
    private void m7745a(String str, String str2, boolean z) {
        int intValue;
        if (C2025o.m7963b(str2) && (intValue = ((Integer) this.f6622a.mo8549a(C1841c.f5833ag)).intValue()) > 0) {
            int length = str2.length();
            int i = ((length + intValue) - 1) / intValue;
            for (int i2 = 0; i2 < i; i2++) {
                int i3 = i2 * intValue;
                int min = Math.min(length, i3 + intValue);
                if (z) {
                    str2.substring(i3, min);
                } else {
                    mo8742b(str, str2.substring(i3, min));
                }
            }
        }
    }

    /* renamed from: a */
    private boolean m7746a() {
        return this.f6622a.mo8526D().mo8311e();
    }

    /* renamed from: c */
    public static void m7747c(String str, String str2, Throwable th) {
        Log.e("AppLovinSdk", "[" + str + "] " + str2, th);
    }

    /* renamed from: f */
    public static void m7748f(String str, String str2) {
        "[" + str + "] " + str2;
    }

    /* renamed from: g */
    public static void m7749g(String str, String str2) {
        "[" + str + "] " + str2;
    }

    /* renamed from: h */
    public static void m7750h(String str, String str2) {
        Log.w("AppLovinSdk", "[" + str + "] " + str2);
    }

    /* renamed from: i */
    public static void m7751i(String str, String str2) {
        m7747c(str, str2, (Throwable) null);
    }

    /* renamed from: j */
    private void m7752j(String str, String str2) {
    }

    /* renamed from: a */
    public void mo8738a(String str, Boolean bool, String str2) {
        mo8739a(str, bool, str2, (Throwable) null);
    }

    /* renamed from: a */
    public void mo8739a(String str, Boolean bool, String str2, Throwable th) {
        if (m7746a()) {
            String str3 = "[" + str + "] " + str2;
            Log.e("AppLovinSdk", str3, th);
            m7752j("ERROR", str3 + " : " + th);
        }
        if (bool.booleanValue() && ((Boolean) this.f6622a.mo8549a(C1841c.f6059ex)).booleanValue() && this.f6622a.mo8537P() != null) {
            this.f6622a.mo8537P().mo8382a(str2, th);
        }
    }

    /* renamed from: a */
    public void mo8740a(String str, String str2) {
        if (m7746a()) {
            m7745a(str, str2, false);
        }
    }

    /* renamed from: a */
    public void mo8741a(String str, String str2, Throwable th) {
        if (m7746a()) {
            String str3 = "[" + str + "] " + str2;
            Log.w("AppLovinSdk", str3, th);
            m7752j("WARN", str3);
        }
    }

    /* renamed from: b */
    public void mo8742b(String str, String str2) {
        if (m7746a()) {
            m7752j("DEBUG", "[" + str + "] " + str2);
        }
    }

    /* renamed from: b */
    public void mo8743b(String str, String str2, Throwable th) {
        mo8739a(str, true, str2, th);
    }

    /* renamed from: c */
    public void mo8744c(String str, String str2) {
        if (m7746a()) {
            m7752j("INFO", "[" + str + "] " + str2);
        }
    }

    /* renamed from: d */
    public void mo8745d(String str, String str2) {
        mo8741a(str, str2, (Throwable) null);
    }

    /* renamed from: e */
    public void mo8746e(String str, String str2) {
        mo8743b(str, str2, (Throwable) null);
    }
}
