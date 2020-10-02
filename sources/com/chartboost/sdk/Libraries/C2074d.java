package com.chartboost.sdk.Libraries;

import android.content.ContentResolver;
import android.content.Context;
import android.os.Build;
import android.os.Looper;
import android.provider.Settings;
import android.util.Base64;
import com.chartboost.sdk.C2242k;
import com.chartboost.sdk.impl.C2169j1;
import com.chartboost.sdk.impl.C2172k1;
import com.tapjoy.TapjoyConstants;
import org.json.JSONObject;

/* renamed from: com.chartboost.sdk.Libraries.d */
public class C2074d {

    /* renamed from: a */
    private int f6855a = -1;

    /* renamed from: b */
    private String f6856b = null;

    /* renamed from: c */
    private final String f6857c;

    /* renamed from: com.chartboost.sdk.Libraries.d$a */
    public static class C2075a {

        /* renamed from: a */
        public final int f6858a;

        /* renamed from: b */
        public final String f6859b;

        /* renamed from: c */
        public final String f6860c;

        public C2075a(int i, String str, String str2, String str3) {
            this.f6858a = i;
            this.f6859b = str;
            this.f6860c = str3;
        }

        /* renamed from: a */
        public synchronized Boolean mo9087a() {
            boolean z;
            z = true;
            if (this.f6858a != 1) {
                z = false;
            }
            return Boolean.valueOf(z);
        }
    }

    public C2074d(Context context) {
        this.f6857c = C2169j1.m8618a(context);
    }

    /* renamed from: b */
    private void m8180b() {
        if (C2172k1.m8630a(C2242k.f7612l)) {
            C2071a aVar = new C2071a(C2242k.f7612l);
            this.f6855a = aVar.f6851a;
            this.f6856b = aVar.f6852b;
        }
    }

    /* renamed from: c */
    private static boolean m8181c() {
        return !"Amazon".equalsIgnoreCase(Build.MANUFACTURER);
    }

    /* renamed from: a */
    public synchronized C2075a mo9086a() {
        if (Looper.myLooper() != Looper.getMainLooper() || "robolectric".equals(Build.FINGERPRINT)) {
            if (m8181c()) {
                m8180b();
            } else {
                m8179a(C2242k.f7612l);
            }
            String str = this.f6856b;
            JSONObject jSONObject = new JSONObject();
            String str2 = this.f6857c;
            if (str2 != null && str == null) {
                C2076e.m8187a(jSONObject, "uuid", str2);
            }
            if (str != null) {
                C2076e.m8187a(jSONObject, "gaid", str);
            }
            return new C2075a(this.f6855a, Base64.encodeToString(jSONObject.toString().getBytes(), 0), str != null ? "000000000" : this.f6857c, str);
        }
        CBLogging.m8154b("CBIdentity", "I must be called from a background thread");
        return null;
    }

    /* renamed from: a */
    private void m8179a(Context context) {
        try {
            ContentResolver contentResolver = context.getContentResolver();
            if (!(Settings.Secure.getInt(contentResolver, "limit_ad_tracking") != 0)) {
                String string = Settings.Secure.getString(contentResolver, TapjoyConstants.TJC_ADVERTISING_ID);
                if ("00000000-0000-0000-0000-000000000000".equals(string)) {
                    this.f6855a = 1;
                    this.f6856b = null;
                    return;
                }
                this.f6855a = 0;
                this.f6856b = string;
                return;
            }
            this.f6855a = 1;
            this.f6856b = null;
        } catch (Settings.SettingNotFoundException unused) {
            this.f6855a = -1;
            this.f6856b = null;
        }
    }
}
