package com.ogury.p159cm;

import android.content.SharedPreferences;
import com.android.billingclient.api.Purchase;
import com.applovin.sdk.AppLovinEventTypes;
import java.util.HashSet;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.ogury.cm.abccb */
public final class abccb {

    /* renamed from: a */
    public static final abccb f12123a = new abccb();

    /* renamed from: b */
    private static SharedPreferences f12124b;

    private abccb() {
    }

    /* renamed from: a */
    public static String m15179a() {
        SharedPreferences sharedPreferences = f12124b;
        if (sharedPreferences == null) {
            accbb.m15216a("sharedPref");
        }
        return sharedPreferences.getString("activePurchases", (String) null);
    }

    /* renamed from: a */
    public static void m15180a(SharedPreferences sharedPreferences) {
        accbb.m15218b(sharedPreferences, "sharedPreferences");
        f12124b = sharedPreferences;
    }

    /* renamed from: a */
    public static void m15181a(acaaa acaaa) {
        accbb.m15218b(acaaa, AppLovinEventTypes.USER_VIEWED_PRODUCT);
        SharedPreferences sharedPreferences = f12124b;
        if (sharedPreferences == null) {
            accbb.m15216a("sharedPref");
        }
        SharedPreferences.Editor edit = sharedPreferences.edit();
        accbb.m15215a((Object) edit, "sharedPref.edit()");
        edit.putString("activeProduct", acaaa.mo29514b());
        edit.apply();
    }

    /* renamed from: a */
    public static void m15182a(HashSet<Purchase> hashSet) {
        JSONArray jSONArray = new JSONArray();
        for (Purchase purchase : hashSet) {
            if (!(purchase.getSku() == null || purchase.getPurchaseToken() == null)) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("productId", purchase.getSku());
                jSONObject.put("purchaseToken", purchase.getPurchaseToken());
                jSONArray.put(jSONObject);
            }
        }
        SharedPreferences sharedPreferences = f12124b;
        if (sharedPreferences == null) {
            accbb.m15216a("sharedPref");
        }
        SharedPreferences.Editor edit = sharedPreferences.edit();
        accbb.m15215a((Object) edit, "sharedPref.edit()");
        if (jSONArray.length() > 0) {
            edit.putString("activePurchases", jSONArray.toString());
        } else {
            edit = edit.remove("activePurchases");
        }
        edit.apply();
    }

    /* renamed from: b */
    public static String m15183b() {
        SharedPreferences sharedPreferences = f12124b;
        if (sharedPreferences == null) {
            accbb.m15216a("sharedPref");
        }
        String string = sharedPreferences.getString("activeProduct", "");
        accbb.m15215a((Object) string, "sharedPref.getString(ACTIVE_PRODUCT, \"\")");
        return string;
    }
}
