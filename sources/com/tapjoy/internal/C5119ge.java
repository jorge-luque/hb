package com.tapjoy.internal;

import android.content.Context;
import android.content.SharedPreferences;
import com.tapjoy.TapjoyConstants;

/* renamed from: com.tapjoy.internal.ge */
public final class C5119ge {

    /* renamed from: f */
    private static final C5119ge f14007f;

    /* renamed from: g */
    private static C5119ge f14008g;

    /* renamed from: a */
    public Boolean f14009a = null;

    /* renamed from: b */
    public String f14010b = null;

    /* renamed from: c */
    public Boolean f14011c = null;

    /* renamed from: d */
    public String f14012d = null;

    /* renamed from: e */
    public boolean f14013e = false;

    /* renamed from: h */
    private Context f14014h;

    static {
        C5119ge geVar = new C5119ge();
        f14007f = geVar;
        f14008g = geVar;
    }

    /* renamed from: a */
    public static C5119ge m17262a() {
        return f14008g;
    }

    /* renamed from: c */
    private boolean m17263c() {
        Context context = this.f14014h;
        if (context == null) {
            return false;
        }
        SharedPreferences.Editor edit = context.getSharedPreferences(TapjoyConstants.TJC_PREFERENCE, 0).edit();
        edit.putBoolean("gdpr", this.f14009a.booleanValue());
        edit.apply();
        return true;
    }

    /* renamed from: d */
    private boolean m17264d() {
        Context context = this.f14014h;
        if (context == null) {
            return false;
        }
        SharedPreferences.Editor edit = context.getSharedPreferences(TapjoyConstants.TJC_PREFERENCE, 0).edit();
        edit.putString("cgdpr", this.f14010b);
        edit.apply();
        return true;
    }

    /* renamed from: e */
    private boolean m17265e() {
        Context context = this.f14014h;
        if (context == null) {
            return false;
        }
        SharedPreferences.Editor edit = context.getSharedPreferences(TapjoyConstants.TJC_PREFERENCE, 0).edit();
        edit.putBoolean("below_consent_age", this.f14011c.booleanValue());
        edit.apply();
        return true;
    }

    /* renamed from: b */
    public final void mo31300b(boolean z) {
        this.f14011c = Boolean.valueOf(z);
        if (!m17265e()) {
            this.f14013e = true;
        }
    }

    /* renamed from: a */
    public final synchronized void mo31297a(Context context) {
        if (context != null) {
            if (this.f14014h == null) {
                this.f14014h = context;
            }
        }
        C5119ge geVar = f14008g;
        if (geVar.f14014h != null) {
            SharedPreferences sharedPreferences = geVar.f14014h.getSharedPreferences(TapjoyConstants.TJC_PREFERENCE, 0);
            if (geVar.f14009a == null && sharedPreferences.contains("gdpr")) {
                geVar.f14009a = Boolean.valueOf(sharedPreferences.getBoolean("gdpr", false));
            }
            if (geVar.f14010b == null) {
                geVar.f14010b = sharedPreferences.getString("cgdpr", "");
            }
            if (geVar.f14011c == null && sharedPreferences.contains("below_consent_age")) {
                geVar.f14011c = Boolean.valueOf(sharedPreferences.getBoolean("below_consent_age", false));
            }
            if (geVar.f14012d == null) {
                geVar.f14012d = sharedPreferences.getString("us_privacy", "");
            }
        }
        if (this.f14013e) {
            this.f14013e = false;
            C5119ge geVar2 = f14008g;
            if (geVar2.f14014h != null) {
                if (geVar2.f14009a != null) {
                    geVar2.m17263c();
                }
                if (geVar2.f14010b != null) {
                    geVar2.m17264d();
                }
                if (geVar2.f14011c != null) {
                    geVar2.m17265e();
                }
                if (geVar2.f14012d != null) {
                    geVar2.mo31301b();
                }
            }
        }
    }

    /* renamed from: b */
    public final boolean mo31301b() {
        Context context = this.f14014h;
        if (context == null) {
            return false;
        }
        SharedPreferences.Editor edit = context.getSharedPreferences(TapjoyConstants.TJC_PREFERENCE, 0).edit();
        edit.putString("us_privacy", this.f14012d);
        edit.apply();
        return true;
    }

    /* renamed from: a */
    public final void mo31299a(boolean z) {
        this.f14009a = Boolean.valueOf(z);
        if (!m17263c()) {
            this.f14013e = true;
        }
    }

    /* renamed from: a */
    public final void mo31298a(String str) {
        if (!C4889al.m16672a(str)) {
            this.f14010b = str;
            if (!m17264d()) {
                this.f14013e = true;
            }
        }
    }
}
