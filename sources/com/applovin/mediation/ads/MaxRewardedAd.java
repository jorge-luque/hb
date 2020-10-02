package com.applovin.mediation.ads;

import android.app.Activity;
import android.text.TextUtils;
import com.applovin.impl.mediation.ads.C1694a;
import com.applovin.impl.mediation.ads.MaxFullscreenAdImpl;
import com.applovin.impl.sdk.utils.C2029r;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.MaxRewardedAdListener;
import com.applovin.sdk.AppLovinSdk;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

public class MaxRewardedAd implements MaxFullscreenAdImpl.C1687a {

    /* renamed from: a */
    private static final Map<String, MaxRewardedAd> f6792a = new HashMap();

    /* renamed from: b */
    private static final Object f6793b = new Object();

    /* renamed from: c */
    private static WeakReference<Activity> f6794c = new WeakReference<>((Object) null);

    /* renamed from: d */
    private final MaxFullscreenAdImpl f6795d;

    private MaxRewardedAd(String str, AppLovinSdk appLovinSdk) {
        this.f6795d = new MaxFullscreenAdImpl(str, MaxAdFormat.REWARDED, this, "MaxRewardedAd", C2029r.m7993a(appLovinSdk));
    }

    public static MaxRewardedAd getInstance(String str, Activity activity) {
        return getInstance(str, AppLovinSdk.getInstance(activity), activity);
    }

    public static MaxRewardedAd getInstance(String str, AppLovinSdk appLovinSdk, Activity activity) {
        C1694a.logApiCall("MaxRewardedAd", "getInstance(adUnitId=" + str + ", sdk=" + appLovinSdk + ", activity=" + activity + ")");
        if (str == null) {
            throw new IllegalArgumentException("No ad unit ID specified");
        } else if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("Empty ad unit ID specified");
        } else if (activity == null) {
            throw new IllegalArgumentException("No activity specified");
        } else if (appLovinSdk != null) {
            updateActivity(activity);
            synchronized (f6793b) {
                MaxRewardedAd maxRewardedAd = f6792a.get(str);
                if (maxRewardedAd != null) {
                    return maxRewardedAd;
                }
                MaxRewardedAd maxRewardedAd2 = new MaxRewardedAd(str, appLovinSdk);
                f6792a.put(str, maxRewardedAd2);
                return maxRewardedAd2;
            }
        } else {
            throw new IllegalArgumentException("No sdk specified");
        }
    }

    public static void updateActivity(Activity activity) {
        C1694a.logApiCall("MaxRewardedAd", "updateActivity(activity=" + activity + ")");
        if (activity != null) {
            f6794c = new WeakReference<>(activity);
        }
    }

    public void destroy() {
        this.f6795d.logApiCall("destroy()");
        synchronized (f6793b) {
            f6792a.remove(this.f6795d.getAdUnitId());
        }
        this.f6795d.destroy();
    }

    public Activity getActivity() {
        this.f6795d.logApiCall("getActivity()");
        return (Activity) f6794c.get();
    }

    public boolean isReady() {
        this.f6795d.logApiCall("isReady()");
        return this.f6795d.isReady();
    }

    public void loadAd() {
        this.f6795d.logApiCall("loadAd()");
        this.f6795d.loadAd(getActivity());
    }

    public void setExtraParameter(String str, String str2) {
        MaxFullscreenAdImpl maxFullscreenAdImpl = this.f6795d;
        maxFullscreenAdImpl.logApiCall("setExtraParameter(key=" + str + ", value=" + str2 + ")");
        this.f6795d.setExtraParameter(str, str2);
    }

    public void setListener(MaxRewardedAdListener maxRewardedAdListener) {
        MaxFullscreenAdImpl maxFullscreenAdImpl = this.f6795d;
        maxFullscreenAdImpl.logApiCall("setListener(listener=" + maxRewardedAdListener + ")");
        this.f6795d.setListener(maxRewardedAdListener);
    }

    public void showAd() {
        showAd((String) null);
    }

    public void showAd(String str) {
        MaxFullscreenAdImpl maxFullscreenAdImpl = this.f6795d;
        maxFullscreenAdImpl.logApiCall("showAd(placement=" + str + ")");
        this.f6795d.showAd(str, getActivity());
    }

    public String toString() {
        return "" + this.f6795d;
    }
}
