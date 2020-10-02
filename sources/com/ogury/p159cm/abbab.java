package com.ogury.p159cm;

import android.content.Context;
import android.content.res.Resources;
import android.net.NetworkInfo;
import android.os.Build;
import android.util.DisplayMetrics;
import com.ogury.p159cm.ConsentActivity;
import com.tapjoy.TJAdUnitConstants;
import com.tapjoy.TapjoyConstants;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.ogury.cm.abbab */
public final class abbab {

    /* renamed from: a */
    public static final aaaaa f12074a = new aaaaa((baaca) null);

    /* renamed from: com.ogury.cm.abbab$aaaaa */
    public static final class aaaaa {
        private aaaaa() {
        }

        public /* synthetic */ aaaaa(baaca baaca) {
            this();
        }
    }

    /* renamed from: a */
    public static String m15112a(Context context, String str) {
        accbb.m15218b(context, "context");
        accbb.m15218b(str, "appKey");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("assetType", "android");
        jSONObject.put("assetKey", str);
        aacca aacca = aacca.f12035a;
        jSONObject.put("deviceId", aacca.m15037c().mo29543b());
        jSONObject.put("sdkVersion", "3.0.1");
        NetworkInfo a = ConsentActivity.aaaaa.m14878a(context);
        jSONObject.put("connectivity", a != null ? a.getTypeName() : null);
        String str2 = Build.MANUFACTURER + " " + Build.MODEL;
        if (str2.length() > 32) {
            if (str2 != null) {
                str2 = str2.substring(0, 31);
                accbb.m15215a((Object) str2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            } else {
                throw new acbab("null cannot be cast to non-null type java.lang.String");
            }
        }
        jSONObject.put("deviceModel", str2);
        jSONObject.put("deviceOsVersion", String.valueOf(Build.VERSION.SDK_INT));
        Context applicationContext = context.getApplicationContext();
        accbb.m15215a((Object) applicationContext, "context.applicationContext");
        Resources resources = applicationContext.getResources();
        accbb.m15215a((Object) resources, "context.applicationContext.resources");
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        accbb.m15215a((Object) displayMetrics, "context.applicationConte….resources.displayMetrics");
        jSONObject.put("deviceScreenWidth", displayMetrics.widthPixels);
        jSONObject.put("deviceScreenHeight", displayMetrics.heightPixels);
        aacca aacca2 = aacca.f12035a;
        jSONObject.put(TJAdUnitConstants.String.BUNDLE, aacca.m15037c().mo29540a());
        StringBuilder sb = new StringBuilder();
        Locale locale = Locale.getDefault();
        accbb.m15215a((Object) locale, "Locale.getDefault()");
        sb.append(locale.getLanguage());
        sb.append("-");
        Locale locale2 = Locale.getDefault();
        accbb.m15215a((Object) locale2, "Locale.getDefault()");
        sb.append(locale2.getCountry());
        jSONObject.put("locale", sb.toString());
        jSONObject.put("deviceScreenDensity", displayMetrics.densityDpi);
        if (abcbc.f12099a.isBillingDisabled()) {
            jSONObject.put("billingEnabled", false);
        }
        abccb abccb = abccb.f12123a;
        String a2 = abccb.m15179a();
        if (a2 != null) {
            jSONObject.put("purchaseTokens", new JSONArray(a2));
        }
        String jSONObject2 = jSONObject.toString();
        accbb.m15215a((Object) jSONObject2, "json.toString()");
        return jSONObject2;
    }

    /* renamed from: a */
    public static String m15113a(String str) {
        accbb.m15218b(str, "errorMessage");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(TapjoyConstants.TJC_SDK_TYPE_DEFAULT, "CONSENT_ERROR");
        jSONObject.put("errorMessage", str);
        String jSONObject2 = jSONObject.toString();
        accbb.m15215a((Object) jSONObject2, "json.toString()");
        return jSONObject2;
    }

    /* renamed from: a */
    public static String m15114a(String str, String str2, Integer[] numArr) {
        accbb.m15218b(str, "appKey");
        accbb.m15218b(str2, "iabString");
        JSONObject jSONObject = new JSONObject();
        m15116a(jSONObject, str, str2);
        m15117a(jSONObject, numArr);
        String jSONObject2 = jSONObject.toString();
        accbb.m15215a((Object) jSONObject2, "json.toString()");
        return jSONObject2;
    }

    /* renamed from: a */
    public static String m15115a(String str, String str2, String[] strArr) {
        accbb.m15218b(str, "appKey");
        accbb.m15218b(str2, "iabString");
        JSONObject jSONObject = new JSONObject();
        m15116a(jSONObject, str, str2);
        m15118a(jSONObject, strArr);
        String jSONObject2 = jSONObject.toString();
        accbb.m15215a((Object) jSONObject2, "json.toString()");
        return jSONObject2;
    }

    /* renamed from: a */
    private static void m15116a(JSONObject jSONObject, String str, String str2) {
        jSONObject.put("assetType", "android");
        jSONObject.put("assetKey", str);
        aacca aacca = aacca.f12035a;
        jSONObject.put("deviceId", aacca.m15037c().mo29543b());
        jSONObject.put("iabString", str2);
    }

    /* renamed from: a */
    private static void m15117a(JSONObject jSONObject, Integer[] numArr) {
        JSONArray jSONArray = new JSONArray();
        if (numArr != null) {
            if (!(numArr.length == 0)) {
                for (Integer intValue : numArr) {
                    jSONArray.put(intValue.intValue());
                }
                jSONObject.put("vendorIds", jSONArray);
            }
        }
    }

    /* renamed from: a */
    private static void m15118a(JSONObject jSONObject, String[] strArr) {
        JSONArray jSONArray = new JSONArray();
        if (strArr != null) {
            if (!(strArr.length == 0)) {
                for (String put : strArr) {
                    jSONArray.put(put);
                }
                jSONObject.put(TJAdUnitConstants.String.VENDORS, jSONArray);
            }
        }
    }
}
