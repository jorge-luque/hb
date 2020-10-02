package com.unity3d.services.analytics;

import admost.sdk.AdMostInterstitial;
import admost.sdk.base.AdMostExperimentManager;
import com.applovin.sdk.AppLovinEventParameters;
import com.applovin.sdk.AppLovinEventTypes;
import com.unity3d.services.core.webview.WebViewApp;
import com.unity3d.services.core.webview.WebViewEventCategory;
import com.unity3d.services.purchasing.core.TransactionDetailsUtilities;
import com.vungle.warren.model.AdvertisementDBAdapter;
import com.vungle.warren.persistence.IdColumns;
import java.util.Date;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

public class UnityAnalytics {
    protected static JSONArray eventQueue = new JSONArray();

    private enum AnalyticsEventType {
        POSTEVENT
    }

    private static JSONObject createAdComplete(String str, String str2, Boolean bool) {
        HashMap hashMap = new HashMap();
        hashMap.put(AdMostInterstitial.ZONE_TYPE_REWARDED, bool);
        hashMap.put(AdMostExperimentManager.TYPE_NETWORK, str);
        hashMap.put(AdvertisementDBAdapter.AdvertisementColumns.COLUMN_PLACEMENT_ID, str2);
        HashMap hashMap2 = new HashMap();
        hashMap2.put("custom_params", hashMap);
        hashMap2.put("ts", Long.valueOf(new Date().getTime()));
        hashMap2.put("name", "ad_complete");
        HashMap hashMap3 = new HashMap();
        hashMap3.put("type", "analytics.custom.v1");
        hashMap3.put("msg", hashMap2);
        return new JSONObject(hashMap3);
    }

    private static JSONObject createIapTransaction(String str, Float f, String str2, Boolean bool, String str3) {
        HashMap hashMap = new HashMap();
        hashMap.put("ts", Long.valueOf(new Date().getTime()));
        hashMap.put("productid", str);
        hashMap.put("amount", f);
        hashMap.put("currency", str2);
        hashMap.put("promo", bool);
        hashMap.put(TransactionDetailsUtilities.RECEIPT, str3);
        HashMap hashMap2 = new HashMap();
        hashMap2.put("type", "analytics.transaction.v1");
        hashMap2.put("msg", hashMap);
        return new JSONObject(hashMap2);
    }

    private static JSONObject createItemAcquired(String str, Float f, String str2, Float f2, String str3, String str4, String str5, AcquisitionType acquisitionType) {
        HashMap hashMap = new HashMap();
        hashMap.put("currency_type", acquisitionType.toString());
        hashMap.put("transaction_context", str);
        hashMap.put("amount", f);
        hashMap.put(IdColumns.COLUMN_IDENTIFIER, str2);
        hashMap.put("balance", f2);
        hashMap.put("item_type", str3);
        hashMap.put(AppLovinEventTypes.USER_COMPLETED_LEVEL, str4);
        hashMap.put(AppLovinEventParameters.CHECKOUT_TRANSACTION_IDENTIFIER, str5);
        HashMap hashMap2 = new HashMap();
        hashMap2.put("custom_params", hashMap);
        hashMap2.put("ts", 1533594423477L);
        hashMap2.put("name", "item_acquired");
        HashMap hashMap3 = new HashMap();
        hashMap3.put("type", "analytics.custom.v1");
        hashMap3.put("msg", hashMap2);
        return new JSONObject(hashMap3);
    }

    private static JSONObject createItemSpent(String str, Float f, String str2, Float f2, String str3, String str4, String str5, AcquisitionType acquisitionType) {
        HashMap hashMap = new HashMap();
        hashMap.put("currency_type", acquisitionType.toString());
        hashMap.put("transaction_context", str);
        hashMap.put("amount", f);
        hashMap.put(IdColumns.COLUMN_IDENTIFIER, str2);
        hashMap.put("balance", f2);
        hashMap.put("item_type", str3);
        hashMap.put(AppLovinEventTypes.USER_COMPLETED_LEVEL, str4);
        hashMap.put(AppLovinEventParameters.CHECKOUT_TRANSACTION_IDENTIFIER, str5);
        HashMap hashMap2 = new HashMap();
        hashMap2.put("custom_params", hashMap);
        hashMap2.put("ts", Long.valueOf(new Date().getTime()));
        hashMap2.put("name", "item_spent");
        HashMap hashMap3 = new HashMap();
        hashMap3.put("type", "analytics.custom.v1");
        hashMap3.put("msg", hashMap2);
        return new JSONObject(hashMap3);
    }

    private static JSONObject createLevelFail(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("level_index", str);
        HashMap hashMap2 = new HashMap();
        hashMap2.put("custom_params", hashMap);
        hashMap2.put("ts", Long.valueOf(new Date().getTime()));
        hashMap2.put("name", "level_fail");
        HashMap hashMap3 = new HashMap();
        hashMap3.put("type", "analytics.custom.v1");
        hashMap3.put("msg", hashMap2);
        return new JSONObject(hashMap3);
    }

    private static JSONObject createLevelUp(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("new_level_index", str);
        HashMap hashMap2 = new HashMap();
        hashMap2.put("custom_params", hashMap);
        hashMap2.put("ts", Long.valueOf(new Date().getTime()));
        hashMap2.put("name", "level_up");
        HashMap hashMap3 = new HashMap();
        hashMap3.put("type", "analytics.custom.v1");
        hashMap3.put("msg", hashMap2);
        return new JSONObject(hashMap3);
    }

    public static void onAdComplete(String str, String str2, Boolean bool) {
        postEvent(createAdComplete(str, str2, bool));
    }

    public static void onEvent(JSONObject jSONObject) {
        postEvent(jSONObject);
    }

    public static void onIapTransaction(String str, Float f, String str2, Boolean bool, String str3) {
        postEvent(createIapTransaction(str, f, str2, bool, str3));
    }

    public static void onItemAcquired(String str, Float f, String str2, Float f2, String str3, String str4, String str5, AcquisitionType acquisitionType) {
        postEvent(createItemAcquired(str, f, str2, f2, str3, str4, str5, acquisitionType));
    }

    public static void onItemSpent(String str, Float f, String str2, Float f2, String str3, String str4, String str5, AcquisitionType acquisitionType) {
        postEvent(createItemSpent(str, f, str2, f2, str3, str4, str5, acquisitionType));
    }

    public static void onLevelFail(String str) {
        postEvent(createLevelFail(str));
    }

    public static void onLevelUp(String str) {
        postEvent(createLevelUp(str));
    }

    private static synchronized void postEvent(JSONObject jSONObject) {
        synchronized (UnityAnalytics.class) {
            if (eventQueue.length() < 200) {
                eventQueue.put(jSONObject);
            }
            WebViewApp currentApp = WebViewApp.getCurrentApp();
            if (currentApp != null) {
                if (Boolean.valueOf(currentApp.sendEvent(WebViewEventCategory.ANALYTICS, AnalyticsEventType.POSTEVENT, eventQueue.toString())).booleanValue()) {
                    eventQueue = new JSONArray();
                }
            }
        }
    }
}
