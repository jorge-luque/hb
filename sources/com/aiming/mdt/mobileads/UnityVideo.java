package com.aiming.mdt.mobileads;

import android.app.Activity;
import android.text.TextUtils;
import com.aiming.mdt.mediation.CustomVideoEvent;
import com.aiming.mdt.utils.AdLog;
import com.unity3d.ads.UnityAds;
import com.unity3d.ads.mediation.IUnityAdsExtendedListener;
import java.util.Map;

public class UnityVideo extends CustomVideoEvent {
    /* access modifiers changed from: private */
    public boolean isShowed;
    private UnityAdListener mAdListener;

    private class UnityAdListener implements IUnityAdsExtendedListener {
        private UnityAdListener() {
        }

        public void onUnityAdsClick(String str) {
            if (!UnityVideo.this.isDestroyed && TextUtils.equals(str, UnityVideo.this.mInstancesKey)) {
                UnityVideo.this.onInsClicked();
            }
        }

        public void onUnityAdsError(UnityAds.UnityAdsError unityAdsError, String str) {
            if (!UnityVideo.this.isDestroyed && !UnityVideo.this.isShowed) {
                UnityVideo.this.onInsError(str);
                AdLog singleton = AdLog.getSingleton();
                singleton.LogD("Adt-Unity", "Unity Video ad load failed " + str);
            }
        }

        public void onUnityAdsFinish(String str, UnityAds.FinishState finishState) {
            if (!UnityVideo.this.isDestroyed && TextUtils.equals(str, UnityVideo.this.mInstancesKey)) {
                if (finishState == UnityAds.FinishState.COMPLETED) {
                    UnityVideo.this.callbackInsRewarded();
                }
                UnityVideo.this.onInsClose(finishState == UnityAds.FinishState.COMPLETED);
                boolean unused = UnityVideo.this.isShowed = false;
            }
        }

        public void onUnityAdsPlacementStateChanged(String str, UnityAds.PlacementState placementState, UnityAds.PlacementState placementState2) {
        }

        public void onUnityAdsReady(String str) {
            if (!UnityVideo.this.isDestroyed && !UnityVideo.this.isShowed && TextUtils.equals(UnityVideo.this.mInstancesKey, str)) {
                UnityVideo.this.onInsReady(str);
                AdLog.getSingleton().LogD("Adt-Unity", "Unity video ad load success ");
            }
        }

        public void onUnityAdsStart(String str) {
            if (!UnityVideo.this.isDestroyed && TextUtils.equals(str, UnityVideo.this.mInstancesKey)) {
                UnityVideo.this.onInsShow(str);
            }
        }
    }

    public void destroy(Activity activity) {
    }

    public int getMediation() {
        return 3;
    }

    public boolean isReady() {
        return !this.isShowed && !TextUtils.isEmpty(this.mInstancesKey) && UnityAds.isReady(this.mInstancesKey);
    }

    public void loadAd(Activity activity, Map<String, String> map) throws Throwable {
        UnityVideo.super.loadAd(activity, map);
        if (check(activity, map)) {
            this.isShowed = false;
            if (this.mAdListener == null) {
                this.mAdListener = new UnityAdListener();
            }
            UnityAds.setListener(this.mAdListener);
            if (UnityAds.isReady(this.mInstancesKey)) {
                onInsReady(this.mInstancesKey);
            }
        }
    }

    public boolean show(Activity activity) {
        if (isReady()) {
            if (this.mAdListener == null) {
                this.mAdListener = new UnityAdListener();
            }
            UnityAds.setListener(this.mAdListener);
            UnityAds.show(activity, this.mInstancesKey);
            this.isShowed = true;
            return true;
        }
        AdLog.getSingleton().LogD("Adt-Unity", "Unity Video show() called but ad not ready");
        return false;
    }
}
