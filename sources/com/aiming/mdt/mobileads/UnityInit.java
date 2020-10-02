package com.aiming.mdt.mobileads;

import android.app.Activity;
import com.aiming.mdt.mediation.InitListener;
import com.aiming.mdt.mediation.InitModel;
import com.aiming.mdt.utils.AdLog;
import com.unity3d.ads.IUnityAdsListener;
import com.unity3d.ads.UnityAds;
import com.unity3d.ads.mediation.IUnityAdsExtendedListener;
import java.util.Map;

public class UnityInit extends InitModel {
    public void init(Activity activity, Map<String, Object> map, InitListener initListener) throws Throwable {
        UnityInit.super.init(activity, map, initListener);
        if (!UnityAds.isInitialized()) {
            UnityAds.initialize(activity, this.mAppKey, (IUnityAdsListener) new IUnityAdsExtendedListener() {
                public void onUnityAdsClick(String str) {
                }

                public void onUnityAdsError(UnityAds.UnityAdsError unityAdsError, String str) {
                    AdLog singleton = AdLog.getSingleton();
                    singleton.LogD("Adt_unity", "unity id " + unityAdsError.name() + "is error : " + str);
                }

                public void onUnityAdsFinish(String str, UnityAds.FinishState finishState) {
                }

                public void onUnityAdsPlacementStateChanged(String str, UnityAds.PlacementState placementState, UnityAds.PlacementState placementState2) {
                }

                public void onUnityAdsReady(String str) {
                    AdLog singleton = AdLog.getSingleton();
                    singleton.LogD("Adt_unity", "unity id " + str + "is ready");
                }

                public void onUnityAdsStart(String str) {
                }
            });
            initListener.onSuccess(mediation());
            AdLog.getSingleton().LogD("Adt-Unity", "Unity init success ");
        }
    }

    public String mediation() {
        return "3";
    }
}
