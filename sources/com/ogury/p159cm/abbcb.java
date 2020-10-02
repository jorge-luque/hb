package com.ogury.p159cm;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/* renamed from: com.ogury.cm.abbcb */
public abstract class abbcb {

    /* renamed from: a */
    public static final aaaaa f12089a = new aaaaa((baaca) null);

    /* renamed from: b */
    private final String f12090b = "tcfVersion";

    /* renamed from: com.ogury.cm.abbcb$aaaaa */
    public static final class aaaaa {
        private aaaaa() {
        }

        public /* synthetic */ aaaaa(baaca baaca) {
            this();
        }

        /* renamed from: a */
        public static abbcb m15151a() {
            aacca aacca = aacca.f12035a;
            int a = aacca.m15027a();
            return a != 1 ? a != 2 ? new abbcc() : new abcaa() : new abbcc();
        }
    }

    /* renamed from: b */
    public static void m15143b(Context context) {
        accbb.m15218b(context, "context");
        PreferenceManager.getDefaultSharedPreferences(context).edit().remove("wrongAssetKey").apply();
    }

    /* renamed from: b */
    public static void m15144b(Context context, String str) {
        accbb.m15218b(context, "context");
        accbb.m15218b(str, "assetKey");
        PreferenceManager.getDefaultSharedPreferences(context).edit().putString("wrongAssetKey", str).commit();
    }

    /* renamed from: c */
    public static String m15145c(Context context) {
        accbb.m15218b(context, "context");
        String string = PreferenceManager.getDefaultSharedPreferences(context).getString("wrongAssetKey", "");
        accbb.m15215a((Object) string, "PreferenceManager.getDef…ring(WRONG_ASSET_KEY, \"\")");
        return string;
    }

    /* renamed from: a */
    public abstract String mo29487a();

    /* renamed from: a */
    public final void mo29488a(Context context, String str) {
        accbb.m15218b(context, "context");
        accbb.m15218b(str, "assetKey");
        boolean z = false;
        SharedPreferences.Editor edit = context.getSharedPreferences(mo29487a(), 0).edit();
        aacca aacca = aacca.f12035a;
        edit.putString("optin", aacca.m15034b().mo29430a().toString());
        aacca aacca2 = aacca.f12035a;
        edit.putLong("cacheFor", aacca.m15039d().getTime());
        aacca aacca3 = aacca.f12035a;
        edit.putString("aaid", aacca.m15037c().mo29543b());
        aacca aacca4 = aacca.f12035a;
        edit.putBoolean("isEditAvailable", aacca.m15037c().mo29548d());
        if (str.length() > 0) {
            z = true;
        }
        if (z) {
            edit.putString("assetKey", str);
        }
        aacca aacca5 = aacca.f12035a;
        edit.putString("bundleId", aacca.m15037c().mo29540a());
        edit.apply();
        mo29491d(context);
    }

    /* renamed from: a */
    public final boolean mo29489a(Context context) {
        accbb.m15218b(context, "context");
        return context.getSharedPreferences(mo29487a(), 0).getBoolean("hasPaid", false);
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0074  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0056  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean mo29490a(java.lang.String r6, android.content.Context r7) {
        /*
            r5 = this;
            java.lang.String r0 = "assetKey"
            com.ogury.p159cm.accbb.m15218b(r6, r0)
            java.lang.String r1 = "context"
            com.ogury.p159cm.accbb.m15218b(r7, r1)
            java.lang.String r1 = r5.mo29487a()
            r2 = 0
            android.content.SharedPreferences r1 = r7.getSharedPreferences(r1, r2)
            java.lang.String r3 = ""
            java.lang.String r0 = r1.getString(r0, r3)
            boolean r6 = com.ogury.p159cm.accbb.m15217a((java.lang.Object) r0, (java.lang.Object) r6)
            r0 = 1
            r6 = r6 ^ r0
            if (r6 == 0) goto L_0x0023
        L_0x0021:
            r6 = 1
            goto L_0x0054
        L_0x0023:
            java.lang.String r6 = "bundleId"
            java.lang.String r6 = r1.getString(r6, r3)
            com.ogury.cm.aacca r4 = com.ogury.p159cm.aacca.f12035a
            com.ogury.cm.accca r4 = com.ogury.p159cm.aacca.m15037c()
            java.lang.String r4 = r4.mo29540a()
            boolean r6 = com.ogury.p159cm.accbb.m15217a((java.lang.Object) r6, (java.lang.Object) r4)
            r6 = r6 ^ r0
            if (r6 == 0) goto L_0x003b
            goto L_0x0021
        L_0x003b:
            java.lang.String r6 = "aaid"
            java.lang.String r6 = r1.getString(r6, r3)
            com.ogury.cm.aacca r1 = com.ogury.p159cm.aacca.f12035a
            com.ogury.cm.accca r1 = com.ogury.p159cm.aacca.m15037c()
            java.lang.String r1 = r1.mo29543b()
            boolean r6 = com.ogury.p159cm.accbb.m15217a((java.lang.Object) r6, (java.lang.Object) r1)
            r6 = r6 ^ r0
            if (r6 == 0) goto L_0x0053
            goto L_0x0021
        L_0x0053:
            r6 = 0
        L_0x0054:
            if (r6 == 0) goto L_0x0074
            java.lang.String r6 = r5.mo29487a()
            android.content.SharedPreferences r6 = r7.getSharedPreferences(r6, r2)
            android.content.SharedPreferences$Editor r6 = r6.edit()
            android.content.SharedPreferences$Editor r6 = r6.clear()
            r6.apply()
            com.ogury.cm.aacca r6 = com.ogury.p159cm.aacca.f12035a
            java.util.Date r6 = new java.util.Date
            r6.<init>()
            com.ogury.p159cm.aacca.m15033a((java.util.Date) r6)
            return r2
        L_0x0074:
            java.lang.String r6 = r5.mo29487a()
            android.content.SharedPreferences r6 = r7.getSharedPreferences(r6, r2)
            com.ogury.cm.aacca r7 = com.ogury.p159cm.aacca.f12035a
            com.ogury.cm.ababa r7 = com.ogury.p159cm.aacca.m15034b()
            java.lang.String r1 = "iabString"
            java.lang.String r1 = r6.getString(r1, r3)
            java.lang.String r2 = "prefs.getString(IAB_STRING_KEY, \"\")"
            com.ogury.p159cm.accbb.m15215a((java.lang.Object) r1, (java.lang.String) r2)
            r7.mo29432a((java.lang.String) r1)
            com.ogury.cm.aacca r7 = com.ogury.p159cm.aacca.f12035a
            com.ogury.cm.ababa r7 = com.ogury.p159cm.aacca.m15034b()
            java.lang.String r1 = "optin"
            java.lang.String r2 = "NO_ANSWER"
            java.lang.String r1 = r6.getString(r1, r2)
            java.lang.String r2 = "prefs.getString(OPTIN_KEY, \"NO_ANSWER\")"
            com.ogury.p159cm.accbb.m15215a((java.lang.Object) r1, (java.lang.String) r2)
            com.ogury.cm.OguryChoiceManager$Answer r1 = com.ogury.p159cm.OguryChoiceManager.Answer.valueOf(r1)
            r7.mo29431a((com.ogury.p159cm.OguryChoiceManager.Answer) r1)
            com.ogury.cm.aacca r7 = com.ogury.p159cm.aacca.f12035a
            r1 = 0
            java.lang.String r7 = "cacheFor"
            long r1 = r6.getLong(r7, r1)
            com.ogury.p159cm.aacca.m15029a((long) r1)
            com.ogury.cm.aacca r7 = com.ogury.p159cm.aacca.f12035a
            com.ogury.cm.accca r7 = com.ogury.p159cm.aacca.m15037c()
            java.lang.String r1 = "formPath"
            java.lang.String r2 = "/"
            java.lang.String r6 = r6.getString(r1, r2)
            java.lang.String r1 = "prefs.getString(FORM_PATH_KEY, \"/\")"
            com.ogury.p159cm.accbb.m15215a((java.lang.Object) r6, (java.lang.String) r1)
            r7.mo29547d(r6)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ogury.p159cm.abbcb.mo29490a(java.lang.String, android.content.Context):boolean");
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public void mo29491d(Context context) {
        accbb.m15218b(context, "context");
        SharedPreferences.Editor edit = context.getSharedPreferences(mo29487a(), 0).edit();
        aacca aacca = aacca.f12035a;
        edit.putString("iabString", aacca.m15034b().mo29434b());
        aacca aacca2 = aacca.f12035a;
        edit.putBoolean("hasPaid", aacca.m15034b().mo29436c());
        aacca aacca3 = aacca.f12035a;
        edit.putString("formPath", aacca.m15037c().mo29549e());
        edit.apply();
    }
}
