package com.applovin.mediation.adapters;

import android.content.Context;
import android.os.Bundle;
import com.applovin.impl.sdk.C1941j;
import com.applovin.impl.sdk.C1977q;
import com.applovin.impl.sdk.utils.BundleUtils;
import com.applovin.impl.sdk.utils.C2029r;
import com.applovin.mediation.MaxReward;
import com.applovin.mediation.adapter.MaxAdapter;
import com.applovin.mediation.adapter.parameters.MaxAdapterResponseParameters;
import com.applovin.sdk.AppLovinSdk;

public abstract class MediationAdapterBase implements MaxAdapter {
    private boolean alwaysRewardUser;
    private final C1977q mLogger;
    private final C1941j mSdk;
    private final String mTag = getClass().getSimpleName();
    private final AppLovinSdk mWrappingSdk;
    private MaxReward reward;

    public MediationAdapterBase(AppLovinSdk appLovinSdk) {
        this.mWrappingSdk = appLovinSdk;
        C1941j a = C2029r.m7993a(appLovinSdk);
        this.mSdk = a;
        this.mLogger = a.mo8602v();
    }

    protected static String mediationTag() {
        return "AppLovinSdk_" + AppLovinSdk.VERSION;
    }

    /* access modifiers changed from: protected */
    public void checkActivities(Context context, Class<?>... clsArr) {
    }

    /* access modifiers changed from: protected */
    public void checkExistence(Class<?>... clsArr) {
        if (clsArr != null && clsArr.length > 0) {
            for (Class<?> cls : clsArr) {
                log("Found: " + cls.getName());
            }
        }
    }

    /* access modifiers changed from: protected */
    public void configureReward(MaxAdapterResponseParameters maxAdapterResponseParameters) {
        Bundle serverParameters = maxAdapterResponseParameters.getServerParameters();
        this.alwaysRewardUser = BundleUtils.getBoolean("always_reward_user", maxAdapterResponseParameters.isTesting(), serverParameters);
        int i = BundleUtils.getInt("amount", 0, serverParameters);
        String string = BundleUtils.getString("currency", "", serverParameters);
        log("Creating reward: " + i + " " + string);
        this.reward = MaxReward.create(i, string);
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public void mo8881d(String str) {
        this.mLogger.mo8742b(this.mTag, str);
    }

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public void mo8882e(String str) {
        this.mLogger.mo8746e(this.mTag, str);
    }

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public void mo8883e(String str, Throwable th) {
        this.mLogger.mo8743b(this.mTag, str, th);
    }

    /* access modifiers changed from: protected */
    public MaxReward getReward() {
        MaxReward maxReward = this.reward;
        return maxReward != null ? maxReward : MaxReward.createDefault();
    }

    /* access modifiers changed from: package-private */
    public String getVersionString(Class cls, String str) {
        String b = C2029r.m8024b(cls, str);
        if (b == null) {
            log("Failed to retrieve version string.");
        }
        return b;
    }

    /* access modifiers changed from: protected */
    public AppLovinSdk getWrappingSdk() {
        return this.mWrappingSdk;
    }

    /* access modifiers changed from: protected */
    /* renamed from: i */
    public void mo8887i(String str) {
        this.mLogger.mo8744c(this.mTag, str);
    }

    /* access modifiers changed from: protected */
    public void log(String str) {
        this.mLogger.mo8744c(this.mTag, str);
    }

    /* access modifiers changed from: protected */
    public void log(String str, Throwable th) {
        this.mLogger.mo8743b(this.mTag, str, th);
    }

    /* access modifiers changed from: protected */
    public boolean shouldAlwaysRewardUser() {
        return this.alwaysRewardUser;
    }

    /* access modifiers changed from: protected */
    /* renamed from: w */
    public void mo8891w(String str) {
        this.mLogger.mo8745d(this.mTag, str);
    }
}
