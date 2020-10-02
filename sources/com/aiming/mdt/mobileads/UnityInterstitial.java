package com.aiming.mdt.mobileads;

import android.app.Activity;
import android.text.TextUtils;
import com.aiming.mdt.mediation.CustomInterstitialEvent;
import com.aiming.mdt.utils.AdLog;
import com.unity3d.ads.UnityAds;
import com.unity3d.ads.mediation.IUnityAdsExtendedListener;
import java.util.Map;

public class UnityInterstitial extends CustomInterstitialEvent {
    /* access modifiers changed from: private */
    public boolean isShowed;

    public void destroy(Activity activity) {
        this.isShowed = false;
        this.isDestroyed = true;
    }

    public int getMediation() {
        return 3;
    }

    public boolean isReady() {
        return !this.isDestroyed && !this.isShowed && UnityAds.isReady(this.mInstancesKey);
    }

    public void loadAd(Activity activity, Map<String, String> map) throws Throwable {
        UnityInterstitial.super.loadAd(activity, map);
        if (check(activity, map)) {
            this.isShowed = false;
            UnityAds.setListener(new IUnityAdsExtendedListener() {
                public void onUnityAdsClick(String str) {
                    if (!UnityInterstitial.this.isDestroyed && TextUtils.equals(str, UnityInterstitial.this.mInstancesKey)) {
                        UnityInterstitial.this.onInsClicked();
                    }
                }

                public void onUnityAdsError(UnityAds.UnityAdsError unityAdsError, String str) {
                    if (!UnityInterstitial.this.isDestroyed && !UnityInterstitial.this.isShowed) {
                        UnityInterstitial.this.onInsError(str);
                        AdLog singleton = AdLog.getSingleton();
                        singleton.LogD("Adt-Unity", "Unity Interstitial ad load failed " + str);
                    }
                }

                public void onUnityAdsFinish(String str, UnityAds.FinishState finishState) {
                    if (!UnityInterstitial.this.isDestroyed && TextUtils.equals(str, UnityInterstitial.this.mInstancesKey)) {
                        boolean z = false;
                        boolean unused = UnityInterstitial.this.isShowed = false;
                        UnityInterstitial unityInterstitial = UnityInterstitial.this;
                        if (finishState == UnityAds.FinishState.COMPLETED) {
                            z = true;
                        }
                        unityInterstitial.onInsClose(z);
                        AdLog singleton = AdLog.getSingleton();
                        singleton.LogD("Adt-Unity", "Unity Interstitial ad close :" + str);
                    }
                }

                public void onUnityAdsPlacementStateChanged(String str, UnityAds.PlacementState placementState, UnityAds.PlacementState placementState2) {
                }

                public void onUnityAdsReady(String str) {
                    if (!UnityInterstitial.this.isDestroyed && !UnityInterstitial.this.isShowed && TextUtils.equals(UnityInterstitial.this.mInstancesKey, str)) {
                        UnityInterstitial.this.onInsReady(str);
                        AdLog.getSingleton().LogD("Adt-Unity", "Unity Interstitial ad load success ");
                    }
                }

                public void onUnityAdsStart(String str) {
                    if (!UnityInterstitial.this.isDestroyed && TextUtils.equals(str, UnityInterstitial.this.mInstancesKey)) {
                        UnityInterstitial.this.onInsShow(str);
                    }
                }
            });
            if (UnityAds.isReady(this.mInstancesKey)) {
                onInsReady(this.mInstancesKey);
            }
        }
    }

    public boolean show(Activity activity) {
        if (isReady()) {
            UnityAds.show(activity, this.mInstancesKey);
            this.isShowed = true;
            return true;
        }
        AdLog.getSingleton().LogD("Adt-Unity", "Unity interstitial show() called but ad not ready");
        return false;
    }
}
