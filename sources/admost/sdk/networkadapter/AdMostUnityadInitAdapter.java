package admost.sdk.networkadapter;

import admost.sdk.BuildConfig;
import admost.sdk.base.AdMost;
import admost.sdk.base.AdMostAdNetwork;
import admost.sdk.base.AdMostLog;
import admost.sdk.interfaces.AdMostAdNetworkInitInterface;
import admost.sdk.listener.AdMostAdListenerForNetworkAdapter;
import android.app.Activity;
import android.util.Log;
import com.unity3d.ads.IUnityAdsListener;
import com.unity3d.ads.UnityAds;
import com.unity3d.ads.metadata.MediationMetaData;
import com.unity3d.ads.metadata.MetaData;
import com.unity3d.ads.metadata.PlayerMetaData;
import java.util.Map;

public class AdMostUnityadInitAdapter extends AdMostAdNetworkInitInterface {
    public AdMostUnityadInitAdapter() {
        super(true, 1, 16, true, "banner_banner", "fullscreen_banner", "fullscreen_video");
    }

    private void setNetworkDelegate() {
        UnityAds.addListener(new IUnityAdsListener() {
            public void onUnityAdsError(UnityAds.UnityAdsError unityAdsError, String str) {
                Log.e(AdMostAdNetwork.ADMOST, "unityads delegate onUnityAdsError : " + str + " unityAdsError : " + unityAdsError.toString());
                synchronized (AdMostUnityadInitAdapter.this.placementListeners) {
                    try {
                        for (Map.Entry<String, AdMostAdListenerForNetworkAdapter> value : AdMostUnityadInitAdapter.this.placementListeners.entrySet()) {
                            ((AdMostAdListenerForNetworkAdapter) value.getValue()).onFail(400);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }

            public void onUnityAdsFinish(String str, UnityAds.FinishState finishState) {
                Log.e(AdMostAdNetwork.ADMOST, "unityads delegate onUnityAdsFinish : " + str);
                if (AdMostUnityadInitAdapter.this.placementListeners.containsKey(str)) {
                    if (finishState == UnityAds.FinishState.COMPLETED) {
                        AdMostUnityadInitAdapter.this.placementListeners.get(str).onComplete(AdMostAdNetwork.UNITY);
                    }
                    AdMostUnityadInitAdapter.this.placementListeners.get(str).onDismiss("");
                    AdMostUnityadInitAdapter.this.removeListenerForPlacement(str);
                }
            }

            public void onUnityAdsReady(String str) {
                if (AdMostUnityadInitAdapter.this.placementListeners.containsKey(str)) {
                    AdMostUnityadInitAdapter.this.placementListeners.get(str).onReady(AdMostAdNetwork.UNITY, 0);
                }
                try {
                    if (AdMostUnityadInitAdapter.this.placementListeners.size() > 0) {
                        for (Map.Entry next : AdMostUnityadInitAdapter.this.placementListeners.entrySet()) {
                            String str2 = (String) next.getKey();
                            if (UnityAds.getPlacementState(str2) == UnityAds.PlacementState.NO_FILL || UnityAds.getPlacementState(str2) == UnityAds.PlacementState.DISABLED) {
                                ((AdMostAdListenerForNetworkAdapter) next.getValue()).onFail(400);
                            }
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            public void onUnityAdsStart(String str) {
            }
        });
    }

    public String getAdapterVersion() {
        return BuildConfig.ADAPTER_MIN_VERSION;
    }

    public String getMinSdkVersion() {
        return "2.1.6";
    }

    public String getVersion() {
        return UnityAds.getVersion();
    }

    public void initialize(Activity activity, String[] strArr) {
        setAsInitialized();
        boolean z = false;
        try {
            if (AdMost.getInstance().getConfiguration().showPersonalizedAdForGDPR()) {
                MetaData metaData = new MetaData(activity);
                metaData.set("gdpr.consent", true);
                metaData.commit();
            } else {
                MetaData metaData2 = new MetaData(activity);
                metaData2.set("gdpr.consent", false);
                metaData2.commit();
            }
            if (AdMost.getInstance().getConfiguration().showPersonalizedAdForCCPA()) {
                MetaData metaData3 = new MetaData(activity);
                metaData3.set("privacy.consent", true);
                metaData3.commit();
            } else {
                MetaData metaData4 = new MetaData(activity);
                metaData4.set("privacy.consent", false);
                metaData4.commit();
            }
            if (AdMost.getInstance().isUserChild()) {
                MetaData metaData5 = new MetaData(activity);
                metaData5.set("privacy.useroveragelimit", false);
                metaData5.commit();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        MediationMetaData mediationMetaData = new MediationMetaData(activity);
        mediationMetaData.setName("amr");
        mediationMetaData.setVersion(AdMost.getInstance().getVersion());
        mediationMetaData.commit();
        if (!UnityAds.isInitialized()) {
            String str = strArr[0];
            if (AdMost.getInstance().getConfiguration() != null && AdMost.getInstance().getConfiguration().isTestAdsEnabled()) {
                z = true;
            }
            UnityAds.initialize(activity, str, (IUnityAdsListener) null, z);
            if (AdMostLog.isAdNetworkLogsEnabled()) {
                UnityAds.setDebugMode(true);
            }
        }
        setNetworkDelegate();
    }

    public void setUserId(String str) {
        try {
            if (UnityAds.isReady() && str != null && !str.equals("")) {
                PlayerMetaData playerMetaData = new PlayerMetaData(AdMost.getInstance().getContext());
                playerMetaData.setServerId(AdMost.getInstance().getUserId());
                playerMetaData.commit();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
