package com.chartboost.sdk.Tracking;

import android.text.TextUtils;
import android.util.Base64;
import com.chartboost.sdk.C2239j;
import com.chartboost.sdk.C2242k;
import com.chartboost.sdk.Libraries.C2076e;
import com.chartboost.sdk.Libraries.CBLogging;
import com.chartboost.sdk.Model.C2092g;
import com.chartboost.sdk.impl.C2128c1;
import com.chartboost.sdk.impl.C2218v0;
import com.unity3d.services.purchasing.core.TransactionDetailsUtilities;
import java.util.EnumMap;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;

public class CBAnalytics {

    public enum CBIAPPurchaseInfo {
        PRODUCT_ID,
        PRODUCT_TITLE,
        PRODUCT_DESCRIPTION,
        PRODUCT_PRICE,
        PRODUCT_CURRENCY_CODE,
        GOOGLE_PURCHASE_DATA,
        GOOGLE_PURCHASE_SIGNATURE,
        AMAZON_PURCHASE_TOKEN,
        AMAZON_USER_ID
    }

    public enum CBIAPType {
        GOOGLE_PLAY,
        AMAZON
    }

    public enum CBLevelType {
        HIGHEST_LEVEL_REACHED(1),
        CURRENT_AREA(2),
        CHARACTER_LEVEL(3),
        OTHER_SEQUENTIAL(4),
        OTHER_NONSEQUENTIAL(5);
        

        /* renamed from: a */
        private final int f7035a;

        private CBLevelType(int i) {
            this.f7035a = i;
        }

        public int getLevelType() {
            return this.f7035a;
        }
    }

    private CBAnalytics() {
    }

    /* renamed from: a */
    private static synchronized void m8287a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, CBIAPType cBIAPType) {
        CBIAPType cBIAPType2 = cBIAPType;
        synchronized (CBAnalytics.class) {
            if (C2242k.f7612l == null) {
                CBLogging.m8154b("CBPostInstallTracker", "You need call Chartboost.init() before calling any public API's");
                return;
            }
            C2239j n = C2239j.m8897n();
            if (n == null) {
                CBLogging.m8154b("CBPostInstallTracker", "You need call Chartboost.startWithAppId() before tracking in-app purchases");
            } else if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3) || TextUtils.isEmpty(str4) || TextUtils.isEmpty(str5)) {
                CBLogging.m8154b("CBPostInstallTracker", "Null object is passed. Please pass a valid value object");
            } else {
                try {
                    String str10 = str4;
                    Matcher matcher = Pattern.compile("(\\d+\\.\\d+)|(\\d+)").matcher(str4);
                    matcher.find();
                    String group = matcher.group();
                    if (TextUtils.isEmpty(group)) {
                        CBLogging.m8154b("CBPostInstallTracker", "Invalid price object");
                        return;
                    }
                    float parseFloat = Float.parseFloat(group);
                    JSONObject jSONObject = null;
                    if (cBIAPType2 == CBIAPType.GOOGLE_PLAY) {
                        if (!TextUtils.isEmpty(str6)) {
                            if (!TextUtils.isEmpty(str7)) {
                                jSONObject = C2076e.m8186a(C2076e.m8184a("purchaseData", (Object) str6), C2076e.m8184a("purchaseSignature", (Object) str7), C2076e.m8184a("type", (Object) Integer.valueOf(CBIAPType.GOOGLE_PLAY.ordinal())));
                            }
                        }
                        CBLogging.m8154b("CBPostInstallTracker", "Null object is passed for for purchase data or purchase signature");
                        return;
                    } else if (cBIAPType2 == CBIAPType.AMAZON) {
                        if (!TextUtils.isEmpty(str8)) {
                            if (!TextUtils.isEmpty(str9)) {
                                jSONObject = C2076e.m8186a(C2076e.m8184a("userID", (Object) str8), C2076e.m8184a("purchaseToken", (Object) str9), C2076e.m8184a("type", (Object) Integer.valueOf(CBIAPType.AMAZON.ordinal())));
                            }
                        }
                        CBLogging.m8154b("CBPostInstallTracker", "Null object is passed for for amazon user id or amazon purchase token");
                        return;
                    }
                    if (jSONObject == null) {
                        CBLogging.m8154b("CBPostInstallTracker", "Error while parsing the receipt to a JSON Object, ");
                        return;
                    }
                    String str11 = str2;
                    String str12 = str3;
                    String str13 = str;
                    JSONObject a = C2076e.m8186a(C2076e.m8184a("localized-title", (Object) str2), C2076e.m8184a("localized-description", (Object) str3), C2076e.m8184a("price", (Object) Float.valueOf(parseFloat)), C2076e.m8184a("currency", (Object) str5), C2076e.m8184a("productID", (Object) str), C2076e.m8184a((String) TransactionDetailsUtilities.RECEIPT, (Object) Base64.encodeToString(jSONObject.toString().getBytes(), 2)));
                    m8286a(n.f7585s, n.f7586t, n.f7590x, a, "iap", cBIAPType);
                } catch (IllegalStateException unused) {
                    CBLogging.m8154b("CBPostInstallTracker", "Invalid price object");
                }
            }
        }
    }

    public static synchronized void trackInAppAmazonStorePurchaseEvent(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        synchronized (CBAnalytics.class) {
            m8287a(str5, str, str2, str3, str4, (String) null, (String) null, str6, str7, CBIAPType.AMAZON);
        }
    }

    public static synchronized void trackInAppGooglePlayPurchaseEvent(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        synchronized (CBAnalytics.class) {
            m8287a(str5, str, str2, str3, str4, str6, str7, (String) null, (String) null, CBIAPType.GOOGLE_PLAY);
        }
    }

    public static synchronized void trackLevelInfo(String str, CBLevelType cBLevelType, int i, String str2) {
        synchronized (CBAnalytics.class) {
            trackLevelInfo(str, cBLevelType, i, 0, str2);
        }
    }

    public synchronized void trackInAppPurchaseEvent(EnumMap<CBIAPPurchaseInfo, String> enumMap, CBIAPType cBIAPType) {
        if (!(enumMap == null || cBIAPType == null)) {
            if (!TextUtils.isEmpty(enumMap.get(CBIAPPurchaseInfo.PRODUCT_ID)) && !TextUtils.isEmpty(enumMap.get(CBIAPPurchaseInfo.PRODUCT_TITLE)) && !TextUtils.isEmpty(enumMap.get(CBIAPPurchaseInfo.PRODUCT_DESCRIPTION)) && !TextUtils.isEmpty(enumMap.get(CBIAPPurchaseInfo.PRODUCT_PRICE))) {
                if (!TextUtils.isEmpty(enumMap.get(CBIAPPurchaseInfo.PRODUCT_CURRENCY_CODE))) {
                    m8287a(enumMap.get(CBIAPPurchaseInfo.PRODUCT_ID), enumMap.get(CBIAPPurchaseInfo.PRODUCT_TITLE), enumMap.get(CBIAPPurchaseInfo.PRODUCT_DESCRIPTION), enumMap.get(CBIAPPurchaseInfo.PRODUCT_PRICE), enumMap.get(CBIAPPurchaseInfo.PRODUCT_CURRENCY_CODE), enumMap.get(CBIAPPurchaseInfo.GOOGLE_PURCHASE_DATA), enumMap.get(CBIAPPurchaseInfo.GOOGLE_PURCHASE_SIGNATURE), enumMap.get(CBIAPPurchaseInfo.AMAZON_USER_ID), enumMap.get(CBIAPPurchaseInfo.AMAZON_PURCHASE_TOKEN), cBIAPType);
                    return;
                }
            }
        }
        CBLogging.m8154b("CBPostInstallTracker", "Null object is passed. Please pass a valid value object");
    }

    public static synchronized void trackLevelInfo(String str, CBLevelType cBLevelType, int i, int i2, String str2) {
        synchronized (CBAnalytics.class) {
            C2239j n = C2239j.m8897n();
            if (n == null) {
                CBLogging.m8154b("CBPostInstallTracker", "trackLevelInfo: SDK is not initialized");
            } else if (TextUtils.isEmpty(str)) {
                CBLogging.m8154b("CBPostInstallTracker", "Invalid value: event label cannot be empty or null");
            } else if (cBLevelType == null) {
                CBLogging.m8154b("CBPostInstallTracker", "Invalid value: level type cannot be empty or null, please choose from one of the CBLevelType enum values");
            } else if (i < 0 || i2 < 0) {
                CBLogging.m8154b("CBPostInstallTracker", "Invalid value: Level number should be > 0");
            } else if (str2.isEmpty()) {
                CBLogging.m8154b("CBPostInstallTracker", "Invalid value: description cannot be empty or null");
            } else {
                JSONObject a = C2076e.m8186a(C2076e.m8184a("event_label", (Object) str), C2076e.m8184a("event_field", (Object) Integer.valueOf(cBLevelType.getLevelType())), C2076e.m8184a("main_level", (Object) Integer.valueOf(i)), C2076e.m8184a("sub_level", (Object) Integer.valueOf(i2)), C2076e.m8184a("description", (Object) str2), C2076e.m8184a("timestamp", (Object) Long.valueOf(System.currentTimeMillis())), C2076e.m8184a("data_type", (Object) "level_info"));
                JSONArray jSONArray = new JSONArray();
                jSONArray.put(a);
                m8285a(n.f7585s, n.f7586t, n.f7590x, jSONArray, "tracking");
            }
        }
    }

    /* renamed from: a */
    private static synchronized void m8286a(C2218v0 v0Var, C2092g gVar, C2098a aVar, JSONObject jSONObject, String str, CBIAPType cBIAPType) {
        String str2 = str;
        synchronized (CBAnalytics.class) {
            C2128c1 c1Var = new C2128c1("https://live.chartboost.com", String.format(Locale.US, "%s%s", new Object[]{"/post-install-event/", str2}), gVar, aVar, 2, (C2128c1.C2129a) null);
            c1Var.mo9294a(str2, (Object) jSONObject);
            c1Var.f7130m = true;
            c1Var.mo9293a(str2);
            C2218v0 v0Var2 = v0Var;
            v0Var.mo9524a(c1Var);
        }
    }

    /* renamed from: a */
    private static synchronized void m8285a(C2218v0 v0Var, C2092g gVar, C2098a aVar, JSONArray jSONArray, String str) {
        synchronized (CBAnalytics.class) {
            C2128c1 c1Var = new C2128c1("https://live.chartboost.com", "/post-install-event/".concat("tracking"), gVar, aVar, 2, (C2128c1.C2129a) null);
            c1Var.mo9294a("track_info", (Object) jSONArray);
            c1Var.f7130m = true;
            c1Var.mo9293a(str);
            v0Var.mo9524a(c1Var);
        }
    }
}
