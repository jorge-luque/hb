package com.applovin.adview;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.applovin.impl.adview.AdViewControllerImpl;
import com.applovin.impl.sdk.C1977q;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdClickListener;
import com.applovin.sdk.AppLovinAdDisplayListener;
import com.applovin.sdk.AppLovinAdLoadListener;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinSdk;

public class AppLovinAdView extends RelativeLayout {
    public static final String NAMESPACE = "http://schemas.applovin.com/android/1.0";

    /* renamed from: a */
    private AdViewController f4570a;

    public AppLovinAdView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AppLovinAdView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m5691a((AppLovinAdSize) null, (String) null, (AppLovinSdk) null, context, attributeSet);
    }

    public AppLovinAdView(AppLovinAdSize appLovinAdSize, Context context) {
        this(appLovinAdSize, (String) null, context);
    }

    public AppLovinAdView(AppLovinAdSize appLovinAdSize, String str, Context context) {
        super(context);
        m5691a(appLovinAdSize, str, (AppLovinSdk) null, context, (AttributeSet) null);
    }

    public AppLovinAdView(AppLovinSdk appLovinSdk, AppLovinAdSize appLovinAdSize, Context context) {
        this(appLovinSdk, appLovinAdSize, (String) null, context);
    }

    public AppLovinAdView(AppLovinSdk appLovinSdk, AppLovinAdSize appLovinAdSize, String str, Context context) {
        super(context);
        m5691a(appLovinAdSize, str, appLovinSdk, context, (AttributeSet) null);
    }

    /* renamed from: a */
    private void m5690a(AttributeSet attributeSet, Context context) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        TextView textView = new TextView(context);
        textView.setBackgroundColor(Color.rgb(220, 220, 220));
        textView.setTextColor(-16777216);
        textView.setText("AppLovin Ad");
        textView.setGravity(17);
        addView(textView, displayMetrics.widthPixels, (int) TypedValue.applyDimension(1, 50.0f, displayMetrics));
    }

    /* renamed from: a */
    private void m5691a(AppLovinAdSize appLovinAdSize, String str, AppLovinSdk appLovinSdk, Context context, AttributeSet attributeSet) {
        if (!isInEditMode()) {
            AdViewControllerImpl adViewControllerImpl = new AdViewControllerImpl();
            adViewControllerImpl.initializeAdView(this, context, appLovinAdSize, str, appLovinSdk, attributeSet);
            this.f4570a = adViewControllerImpl;
            return;
        }
        m5690a(attributeSet, context);
    }

    public void destroy() {
        AdViewController adViewController = this.f4570a;
        if (adViewController != null) {
            adViewController.destroy();
        }
    }

    @Deprecated
    public AdViewController getAdViewController() {
        return this.f4570a;
    }

    public AppLovinAdSize getSize() {
        AdViewController adViewController = this.f4570a;
        if (adViewController != null) {
            return adViewController.getSize();
        }
        return null;
    }

    public String getZoneId() {
        AdViewController adViewController = this.f4570a;
        if (adViewController != null) {
            return adViewController.getZoneId();
        }
        return null;
    }

    @Deprecated
    public boolean isAdReadyToDisplay() {
        AdViewController adViewController = this.f4570a;
        return adViewController != null && adViewController.isAdReadyToDisplay();
    }

    public void loadNextAd() {
        AdViewController adViewController = this.f4570a;
        if (adViewController != null) {
            adViewController.loadNextAd();
        } else {
            C1977q.m7749g("AppLovinSdk", "Unable to load next ad: AppLovinAdView is not initialized.");
        }
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        AdViewController adViewController = this.f4570a;
        if (adViewController != null) {
            adViewController.onAttachedToWindow();
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        AdViewController adViewController = this.f4570a;
        if (adViewController != null) {
            adViewController.onDetachedFromWindow();
        }
        super.onDetachedFromWindow();
    }

    public void pause() {
        AdViewController adViewController = this.f4570a;
        if (adViewController != null) {
            adViewController.pause();
        }
    }

    public void renderAd(AppLovinAd appLovinAd) {
        renderAd(appLovinAd, (String) null);
    }

    @Deprecated
    public void renderAd(AppLovinAd appLovinAd, String str) {
        AdViewController adViewController = this.f4570a;
        if (adViewController != null) {
            adViewController.renderAd(appLovinAd, str);
        }
    }

    public void resume() {
        AdViewController adViewController = this.f4570a;
        if (adViewController != null) {
            adViewController.resume();
        }
    }

    public void setAdClickListener(AppLovinAdClickListener appLovinAdClickListener) {
        AdViewController adViewController = this.f4570a;
        if (adViewController != null) {
            adViewController.setAdClickListener(appLovinAdClickListener);
        }
    }

    public void setAdDisplayListener(AppLovinAdDisplayListener appLovinAdDisplayListener) {
        AdViewController adViewController = this.f4570a;
        if (adViewController != null) {
            adViewController.setAdDisplayListener(appLovinAdDisplayListener);
        }
    }

    public void setAdLoadListener(AppLovinAdLoadListener appLovinAdLoadListener) {
        AdViewController adViewController = this.f4570a;
        if (adViewController != null) {
            adViewController.setAdLoadListener(appLovinAdLoadListener);
        }
    }

    public void setAdViewEventListener(AppLovinAdViewEventListener appLovinAdViewEventListener) {
        AdViewController adViewController = this.f4570a;
        if (adViewController != null) {
            adViewController.setAdViewEventListener(appLovinAdViewEventListener);
        }
    }

    @Deprecated
    public void setAutoDestroy(boolean z) {
    }

    public String toString() {
        return "AppLovinAdView{zoneId='" + getZoneId() + "', size=" + getSize() + '}';
    }
}
