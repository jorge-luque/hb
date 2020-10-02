package com.ogury.p159cm;

import android.content.Context;
import android.content.SharedPreferences;

/* renamed from: com.ogury.cm.abbcc */
public final class abbcc extends abbcb {

    /* renamed from: b */
    private String f12091b = "cacheConsent";

    /* renamed from: b */
    private static ababb m15152b() {
        aacca aacca = aacca.f12035a;
        return (ababb) ababa.m15062f();
    }

    /* renamed from: a */
    public final String mo29487a() {
        return this.f12091b;
    }

    /* renamed from: a */
    public final boolean mo29490a(String str, Context context) {
        accbb.m15218b(str, "assetKey");
        accbb.m15218b(context, "context");
        boolean a = super.mo29490a(str, context);
        if (a) {
            SharedPreferences sharedPreferences = context.getSharedPreferences(this.f12091b, 0);
            ababb b = m15152b();
            String string = sharedPreferences.getString("purposes", "");
            accbb.m15215a((Object) string, "prefs.getString(PURPOSES, \"\")");
            b.mo29441d(string);
            String string2 = sharedPreferences.getString("acceptedVendors", "");
            accbb.m15215a((Object) string2, "prefs.getString(ACCEPTED_VENDORS, \"\")");
            b.mo29439b(string2);
            String string3 = sharedPreferences.getString("refusedVendors", "");
            accbb.m15215a((Object) string3, "prefs.getString(REFUSED_VENDORS, \"\")");
            b.mo29440c(string3);
            String string4 = sharedPreferences.getString("specialFeatures", "");
            accbb.m15215a((Object) string4, "prefs.getString(SPECIAL_FEATURES, \"\")");
            b.mo29442e(string4);
        }
        return a;
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public final void mo29491d(Context context) {
        accbb.m15218b(context, "context");
        super.mo29491d(context);
        SharedPreferences.Editor edit = context.getSharedPreferences(this.f12091b, 0).edit();
        ababb b = m15152b();
        edit.putString("purposes", b.mo29445i());
        edit.putString("acceptedVendors", b.mo29443g());
        edit.putString("refusedVendors", b.mo29444h());
        edit.putString("specialFeatures", b.mo29446j());
        edit.apply();
    }
}
