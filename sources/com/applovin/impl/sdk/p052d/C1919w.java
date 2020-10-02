package com.applovin.impl.sdk.p052d;

import com.applovin.impl.sdk.C1941j;
import com.applovin.impl.sdk.p049ad.C1821d;
import com.applovin.impl.sdk.p049ad.NativeAdImpl;
import com.applovin.impl.sdk.p050b.C1841c;
import com.applovin.impl.sdk.p051c.C1846a;
import com.applovin.impl.sdk.utils.C1989e;
import com.applovin.impl.sdk.utils.C1993i;
import com.applovin.impl.sdk.utils.C2025o;
import com.applovin.impl.sdk.utils.C2029r;
import com.applovin.nativeAds.AppLovinNativeAdLoadListener;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.facebook.share.internal.ShareConstants;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.sdk.d.w */
class C1919w extends C1864a {

    /* renamed from: a */
    private final AppLovinNativeAdLoadListener f6346a;

    /* renamed from: c */
    private final JSONObject f6347c;

    C1919w(JSONObject jSONObject, C1941j jVar, AppLovinNativeAdLoadListener appLovinNativeAdLoadListener) {
        super("TaskRenderNativeAd", jVar);
        this.f6346a = appLovinNativeAdLoadListener;
        this.f6347c = jSONObject;
    }

    /* renamed from: a */
    private String m7374a(String str, JSONObject jSONObject, String str2) {
        String b = C1993i.m7896b(jSONObject, str, (String) null, this.f6217b);
        if (b != null) {
            return b.replace("{CLCODE}", str2);
        }
        return null;
    }

    /* renamed from: a */
    private String m7375a(JSONObject jSONObject, String str, String str2) {
        String b = C1993i.m7896b(jSONObject, "click_url", (String) null, this.f6217b);
        if (str2 == null) {
            str2 = "";
        }
        return b.replace("{CLCODE}", str).replace("{EVENT_ID}", str2);
    }

    /* renamed from: a */
    private void m7376a(int i) {
        try {
            if (this.f6346a != null) {
                this.f6346a.onNativeAdsFailedToLoad(i);
            }
        } catch (Exception e) {
            mo8406a("Unable to notify listener about failure.", e);
        }
    }

    /* renamed from: a */
    private void m7377a(JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONObject;
        JSONArray b = C1993i.m7900b(jSONObject2, "native_ads", new JSONArray(), this.f6217b);
        JSONObject b2 = C1993i.m7901b(jSONObject2, "native_settings", new JSONObject(), this.f6217b);
        if (b.length() > 0) {
            ArrayList arrayList = new ArrayList(b.length());
            int i = 0;
            while (i < b.length()) {
                JSONObject a = C1993i.m7883a(b, i, (JSONObject) null, this.f6217b);
                String b3 = C1993i.m7896b(a, "clcode", (String) null, this.f6217b);
                String b4 = C1993i.m7896b(a, "event_id", "", this.f6217b);
                String a2 = m7374a("simp_url", b2, b3);
                String a3 = m7375a(b2, b3, b4);
                List<C1846a> a4 = C2029r.m8001a("simp_urls", b2, b3, a2, this.f6217b);
                List<C1846a> a5 = C2029r.m8002a("click_tracking_urls", b2, b3, (Map<String, String>) C1989e.m7834a("{EVENT_ID}", b4), C1993i.m7871a(b2, "should_post_click_url", (Boolean) true, this.f6217b).booleanValue() ? a3 : null, this.f6217b);
                if (a4.size() == 0) {
                    throw new IllegalArgumentException("No impression URL available");
                } else if (a5.size() != 0) {
                    String b5 = C1993i.m7896b(a, "resource_cache_prefix", (String) null, this.f6217b);
                    JSONArray jSONArray = b;
                    int i2 = i;
                    NativeAdImpl a6 = new NativeAdImpl.C1816a().mo8136a(C1821d.m6871g(this.f6217b)).mo8146e(C1993i.m7896b(a, "title", (String) null, this.f6217b)).mo8147f(C1993i.m7896b(a, "description", (String) null, this.f6217b)).mo8148g(C1993i.m7896b(a, ShareConstants.FEED_CAPTION_PARAM, (String) null, this.f6217b)).mo8157p(C1993i.m7896b(a, "cta", (String) null, this.f6217b)).mo8138a(C1993i.m7896b(a, "icon_url", (String) null, this.f6217b)).mo8141b(C1993i.m7896b(a, MessengerShareContentUtility.IMAGE_URL, (String) null, this.f6217b)).mo8145d(C1993i.m7896b(a, "video_url", (String) null, this.f6217b)).mo8143c(C1993i.m7896b(a, "star_rating_url", (String) null, this.f6217b)).mo8149h(C1993i.m7896b(a, "icon_url", (String) null, this.f6217b)).mo8150i(C1993i.m7896b(a, MessengerShareContentUtility.IMAGE_URL, (String) null, this.f6217b)).mo8151j(C1993i.m7896b(a, "video_url", (String) null, this.f6217b)).mo8134a(C1993i.m7868a(a, "star_rating", 5.0f, this.f6217b)).mo8156o(b3).mo8152k(a3).mo8153l(a2).mo8154m(m7374a("video_start_url", b2, b3)).mo8155n(m7374a("video_end_url", b2, b3)).mo8139a(a4).mo8142b(a5).mo8135a(C1993i.m7869a(a, "ad_id", 0, this.f6217b)).mo8144c(C2025o.m7963b(b5) ? C1989e.m7831a(b5) : this.f6217b.mo8576b(C1841c.f5860bG)).mo8137a(this.f6217b).mo8140a();
                    arrayList.add(a6);
                    mo8405a("Prepared native ad: " + a6.getAdId());
                    i = i2 + 1;
                    b = jSONArray;
                } else {
                    throw new IllegalArgumentException("No click tracking URL available");
                }
            }
            AppLovinNativeAdLoadListener appLovinNativeAdLoadListener = this.f6346a;
            if (appLovinNativeAdLoadListener != null) {
                appLovinNativeAdLoadListener.onNativeAdsLoaded(arrayList);
                return;
            }
            return;
        }
        mo8408c("No ads were returned from the server");
        this.f6346a.onNativeAdsFailedToLoad(204);
    }

    public void run() {
        JSONObject jSONObject = this.f6347c;
        if (jSONObject == null || jSONObject.length() <= 0) {
            mo8410d("Attempting to run task with empty or null ad response");
            m7376a(204);
            return;
        }
        m7377a(this.f6347c);
    }
}
