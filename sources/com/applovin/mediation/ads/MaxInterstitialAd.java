package com.applovin.mediation.ads;

import android.app.Activity;
import android.text.TextUtils;
import com.applovin.impl.mediation.ads.C1694a;
import com.applovin.impl.mediation.ads.MaxFullscreenAdImpl;
import com.applovin.impl.sdk.utils.C2029r;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.MaxAdListener;
import com.applovin.sdk.AppLovinSdk;
import java.lang.ref.WeakReference;

public class MaxInterstitialAd implements MaxFullscreenAdImpl.C1687a {

    /* renamed from: a */
    private static WeakReference<Activity> f6790a = new WeakReference<>((Object) null);

    /* renamed from: b */
    private final MaxFullscreenAdImpl f6791b;

    public MaxInterstitialAd(String str, Activity activity) {
        this(str, AppLovinSdk.getInstance(activity), activity);
    }

    public MaxInterstitialAd(String str, AppLovinSdk appLovinSdk, Activity activity) {
        C1694a.logApiCall("MaxInterstitialAd", "MaxInterstitialAd(adUnitId=" + str + ", sdk=" + appLovinSdk + ", activity=" + activity + ")");
        if (str == null) {
            throw new IllegalArgumentException("No ad unit ID specified");
        } else if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("Empty ad unit ID specified");
        } else if (activity == null) {
            throw new IllegalArgumentException("No activity specified");
        } else if (appLovinSdk != null) {
            f6790a = new WeakReference<>(activity);
            this.f6791b = new MaxFullscreenAdImpl(str, MaxAdFormat.INTERSTITIAL, this, "MaxInterstitialAd", C2029r.m7993a(appLovinSdk));
        } else {
            throw new IllegalArgumentException("No sdk specified");
        }
    }

    public void destroy() {
        this.f6791b.logApiCall("destroy()");
        this.f6791b.destroy();
    }

    public Activity getActivity() {
        this.f6791b.logApiCall("getActivity()");
        return (Activity) f6790a.get();
    }

    public boolean isReady() {
        this.f6791b.logApiCall("isReady()");
        return this.f6791b.isReady();
    }

    public void loadAd() {
        this.f6791b.logApiCall("loadAd()");
        this.f6791b.loadAd(getActivity());
    }

    public void setExtraParameter(String str, String str2) {
        MaxFullscreenAdImpl maxFullscreenAdImpl = this.f6791b;
        maxFullscreenAdImpl.logApiCall("setExtraParameter(key=" + str + ", value=" + str2 + ")");
        this.f6791b.setExtraParameter(str, str2);
    }

    public void setListener(MaxAdListener maxAdListener) {
        MaxFullscreenAdImpl maxFullscreenAdImpl = this.f6791b;
        maxFullscreenAdImpl.logApiCall("setListener(listener=" + maxAdListener + ")");
        this.f6791b.setListener(maxAdListener);
    }

    public void showAd() {
        showAd((String) null);
    }

    public void showAd(String str) {
        MaxFullscreenAdImpl maxFullscreenAdImpl = this.f6791b;
        maxFullscreenAdImpl.logApiCall("showAd(placement=" + str + ")");
        this.f6791b.showAd(str, getActivity());
    }

    public String toString() {
        return "" + this.f6791b;
    }
}
