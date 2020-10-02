package com.adcolony.sdk;

import admost.sdk.base.AdMostExperimentManager;
import com.adcolony.sdk.C1439u;
import com.applovin.sdk.AppLovinEventParameters;
import com.applovin.sdk.AppLovinEventTypes;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.tapjoy.TJAdUnitConstants;
import com.tapjoy.TapjoyConstants;
import com.unity3d.services.purchasing.core.TransactionDetailsUtilities;
import com.vungle.warren.persistence.IdColumns;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;
import org.json.JSONException;
import org.json.JSONObject;

public class AdColonyEventTracker {
    public static final String CUSTOM_EVENT_1 = "ADCT_CUSTOM_EVENT_1";
    public static final String CUSTOM_EVENT_2 = "ADCT_CUSTOM_EVENT_2";
    public static final String CUSTOM_EVENT_3 = "ADCT_CUSTOM_EVENT_3";
    public static final String CUSTOM_EVENT_4 = "ADCT_CUSTOM_EVENT_4";
    public static final String CUSTOM_EVENT_5 = "ADCT_CUSTOM_EVENT_5";
    public static final String LOGIN_DEFAULT = "ADCT_DEFAULT_LOGIN";
    public static final String LOGIN_FACEBOOK = "ADCT_FACEBOOK_LOGIN";
    public static final String LOGIN_GOOGLE = "ADCT_GOOGLE_LOGIN";
    public static final String LOGIN_LINKEDIN = "ADCT_LINKEDIN_LOGIN";
    public static final String LOGIN_OPENID = "ADCT_OPENID_LOGIN";
    public static final String LOGIN_TWITTER = "ADCT_TWITTER_LOGIN";
    public static final String REGISTRATION_CUSTOM = "ADCT_CUSTOM_REGISTRATION";
    public static final String REGISTRATION_DEFAULT = "ADCT_DEFAULT_REGISTRATION";
    public static final String REGISTRATION_FACEBOOK = "ADCT_FACEBOOK_REGISTRATION";
    public static final String REGISTRATION_GOOGLE = "ADCT_GOOGLE_REGISTRATION";
    public static final String REGISTRATION_LINKEDIN = "ADCT_LINKEDIN_REGISTRATION";
    public static final String REGISTRATION_OPENID = "ADCT_OPENID_REGISTRATION";
    public static final String REGISTRATION_TWITTER = "ADCT_TWITTER_REGISTRATION";
    public static final String SOCIAL_SHARING_CUSTOM = "ADCT_CUSTOM_SHARING";
    public static final String SOCIAL_SHARING_FACEBOOK = "ADCT_FACEBOOK_SHARING";
    public static final String SOCIAL_SHARING_FLICKR = "ADCT_FLICKR_SHARING";
    public static final String SOCIAL_SHARING_FOURSQUARE = "ADCT_FOURSQUARE_SHARING";
    public static final String SOCIAL_SHARING_GOOGLE = "ADCT_GOOGLE_SHARING";
    public static final String SOCIAL_SHARING_INSTAGRAM = "ADCT_INSTAGRAM_SHARING";
    public static final String SOCIAL_SHARING_LINKEDIN = "ADCT_LINKEDIN_SHARING";
    public static final String SOCIAL_SHARING_PINTEREST = "ADCT_PINTEREST_SHARING";
    public static final String SOCIAL_SHARING_SNAPCHAT = "ADCT_SNAPCHAT_SHARING";
    public static final String SOCIAL_SHARING_TUMBLR = "ADCT_TUMBLR_SHARING";
    public static final String SOCIAL_SHARING_TWITTER = "ADCT_TWITTER_SHARING";
    public static final String SOCIAL_SHARING_VIMEO = "ADCT_VIMEO_SHARING";
    public static final String SOCIAL_SHARING_VINE = "ADCT_VINE_SHARING";
    public static final String SOCIAL_SHARING_YOUTUBE = "ADCT_YOUTUBE_SHARING";

    /* renamed from: a */
    private static final List<JSONObject> f3297a = Collections.synchronizedList(new ArrayList());

    /* renamed from: b */
    private static final int f3298b = 200;

    /* renamed from: a */
    static void m4836a(JSONObject jSONObject) {
        synchronized (f3297a) {
            if (f3298b > f3297a.size()) {
                f3297a.add(jSONObject);
            }
        }
    }

    /* renamed from: b */
    static void m4839b() {
        if (!C1290h.m5112s().equals("")) {
            synchronized (f3297a) {
                for (JSONObject b : f3297a) {
                    m4840b(b);
                }
                f3297a.clear();
            }
        }
    }

    /* renamed from: c */
    private static void m4841c(JSONObject jSONObject) {
        JSONObject g = C1437s.m5612g(jSONObject, MessengerShareContentUtility.ATTACHMENT_PAYLOAD);
        if (C1379m0.f4345N) {
            C1437s.m5592a(g, TapjoyConstants.TJC_API_KEY, "bb2cf0647ba654d7228dd3f9405bbc6a");
        } else {
            C1437s.m5592a(g, TapjoyConstants.TJC_API_KEY, C1290h.m5112s());
        }
        try {
            jSONObject.remove(MessengerShareContentUtility.ATTACHMENT_PAYLOAD);
            jSONObject.put(MessengerShareContentUtility.ATTACHMENT_PAYLOAD, g);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /* renamed from: d */
    private static void m4842d(JSONObject jSONObject) {
        C1437s.m5592a(jSONObject, TapjoyConstants.TJC_DEVICE_TIMEZONE, TimeZone.getDefault().getID());
        C1437s.m5592a(jSONObject, "action_time", String.valueOf(Math.round((float) (System.currentTimeMillis() / 1000))));
    }

    public static void logAchievementUnlocked(String str) {
        if (!m4838a(str, "logAchievementUnlocked")) {
            HashMap hashMap = new HashMap();
            hashMap.put("description", str);
            logEvent("achievement_unlocked", hashMap);
        }
    }

    public static void logActivated() {
        logEvent("activated");
    }

    public static void logAddToCart(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put(IdColumns.COLUMN_IDENTIFIER, str);
        logEvent("add_to_cart", hashMap);
    }

    public static void logAddToWishlist(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put(IdColumns.COLUMN_IDENTIFIER, str);
        logEvent("add_to_wishlist", hashMap);
    }

    public static void logAppRated() {
        logEvent("app_rated");
    }

    public static void logCheckoutInitiated() {
        logEvent("checkout_initiated");
    }

    public static void logContentView(String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put(AppLovinEventParameters.CONTENT_IDENTIFIER, str);
        hashMap.put("content_type", str2);
        logEvent("content_view", hashMap);
    }

    public static void logCreditsSpent(String str, Integer num, Double d, String str2) {
        if (str2 == null || str2.length() == 3) {
            HashMap hashMap = new HashMap();
            hashMap.put("name", str);
            hashMap.put("quantity", String.valueOf(num));
            hashMap.put(AppMeasurementSdk.ConditionalUserProperty.VALUE, String.valueOf(d));
            hashMap.put("currency_code", str2);
            logEvent("credits_spent", hashMap);
            return;
        }
        new C1439u.C1440a().mo6801a("Event logCreditsSpentWithName currency code is specified, but a three-letter ISO 4217 code, (e.g.: 'USD'). Event will not be sent.").mo6803a(C1439u.f4516i);
    }

    public static void logCustomEvent(String str, String str2) {
        if (!m4838a(str2, "logCustomEvent")) {
            HashMap hashMap = new HashMap();
            hashMap.put(TapjoyConstants.TJC_SDK_TYPE_DEFAULT, str);
            hashMap.put("description", str2);
            logEvent("custom_event", hashMap);
        }
    }

    public static void logEvent(String str) {
        logEvent(str, (HashMap<String, String>) null);
    }

    public static void logInvite() {
        logEvent(AppLovinEventTypes.USER_SENT_INVITATION);
    }

    public static void logLevelAchieved(Integer num) {
        HashMap hashMap = new HashMap();
        hashMap.put("level_achieved", String.valueOf(num));
        logEvent("level_achieved", hashMap);
    }

    public static void logLogin(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put(TJAdUnitConstants.String.METHOD, str);
        logEvent(AppLovinEventTypes.USER_LOGGED_IN, hashMap);
    }

    public static void logPaymentInfoAdded() {
        logEvent("payment_info_added");
    }

    public static void logRegistrationCompleted(String str, String str2) {
        if (!m4838a(str2, "logRegistrationCompleted")) {
            HashMap hashMap = new HashMap();
            hashMap.put(TJAdUnitConstants.String.METHOD, str);
            hashMap.put("description", str2);
            logEvent("registration_completed", hashMap);
        }
    }

    public static void logReservation() {
        logEvent(AppLovinEventTypes.USER_CREATED_RESERVATION);
    }

    public static void logSearch(String str) {
        if (str == null || str.length() <= 512) {
            HashMap hashMap = new HashMap();
            hashMap.put("search_string", str);
            logEvent(AppLovinEventTypes.USER_EXECUTED_SEARCH, hashMap);
            return;
        }
        new C1439u.C1440a().mo6801a("logSearch searchString cannot exceed 512 characters. Event will ").mo6801a("not be sent.").mo6803a(C1439u.f4516i);
    }

    public static void logSocialSharingEvent(String str, String str2) {
        if (!m4838a(str2, "logSocialSharingEvent")) {
            HashMap hashMap = new HashMap();
            hashMap.put(AdMostExperimentManager.TYPE_NETWORK, str);
            hashMap.put("description", str2);
            logEvent("social_sharing_event", hashMap);
        }
    }

    public static void logTransaction(String str, Integer num, Double d, String str2, String str3, String str4, String str5) {
        if (!m4838a(str5, "logTransaction")) {
            if (str2 == null || str2.length() == 3) {
                HashMap hashMap = new HashMap();
                hashMap.put(IdColumns.COLUMN_IDENTIFIER, str);
                hashMap.put("quantity", String.valueOf(num));
                hashMap.put("price", String.valueOf(d));
                hashMap.put("currency_code", str2);
                hashMap.put(TransactionDetailsUtilities.RECEIPT, str3);
                hashMap.put("store", str4);
                hashMap.put("description", str5);
                logEvent("transaction", hashMap);
                return;
            }
            new C1439u.C1440a().mo6801a("Event logCreditsSpentWithName currency code is specified, but a three-letter ISO 4217 code, (e.g.: 'USD'). Event will not be sent.").mo6803a(C1439u.f4516i);
        }
    }

    public static void logTutorialCompleted() {
        logEvent("tutorial_completed");
    }

    public static void logEvent(String str, HashMap<String, String> hashMap) {
        JSONObject b = C1437s.m5599b();
        C1437s.m5592a(b, TJAdUnitConstants.PARAM_PLACEMENT_NAME, str);
        JSONObject b2 = C1437s.m5599b();
        if (hashMap != null) {
            for (Map.Entry next : hashMap.entrySet()) {
                if (next.getValue() != null && !((String) next.getValue()).equals("null")) {
                    C1437s.m5592a(b2, (String) next.getKey(), (String) next.getValue());
                }
            }
        }
        m4842d(b2);
        C1437s.m5594a(b, MessengerShareContentUtility.ATTACHMENT_PAYLOAD, b2);
        m4840b(b);
    }

    /* renamed from: a */
    static boolean m4837a() {
        boolean z;
        synchronized (f3297a) {
            z = f3297a.size() != 0;
        }
        return z;
    }

    /* renamed from: a */
    private static boolean m4838a(String str, String str2) {
        if (str == null || str.length() <= 512) {
            return false;
        }
        new C1439u.C1440a().mo6801a("Description of event ").mo6801a(str2).mo6801a(" must be less").mo6801a(" than 512 characters").mo6803a(C1439u.f4516i);
        return true;
    }

    /* renamed from: b */
    private static void m4840b(JSONObject jSONObject) {
        C1199a.m4880c();
        if (C1290h.m5112s().equals("")) {
            m4836a(jSONObject);
            return;
        }
        m4841c(jSONObject);
        new C1454x("AdColony.log_event", 1, jSONObject).mo6834d();
    }
}
