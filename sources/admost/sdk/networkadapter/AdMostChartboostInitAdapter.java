package admost.sdk.networkadapter;

import admost.sdk.BuildConfig;
import admost.sdk.base.AdMost;
import admost.sdk.base.AdMostAdNetwork;
import admost.sdk.base.AdMostLog;
import admost.sdk.interfaces.AdMostAdNetworkInitInterface;
import android.app.Activity;
import com.chartboost.sdk.Chartboost;
import com.chartboost.sdk.ChartboostDelegate;
import com.chartboost.sdk.Model.CBError;
import java.util.HashMap;

public class AdMostChartboostInitAdapter extends AdMostAdNetworkInitInterface {
    /* access modifiers changed from: private */
    public HashMap<String, Boolean> locationAvailability = new HashMap<>();

    public AdMostChartboostInitAdapter() {
        super(true, 2, 16, true, "fullscreen_banner", "fullscreen_video", "banner_banner");
    }

    public String getAdapterVersion() {
        return BuildConfig.ADAPTER_MIN_VERSION;
    }

    public String getMinSdkVersion() {
        return "2.1.6";
    }

    public String getVersion() {
        return Chartboost.getSDKVersion();
    }

    public void initialize(Activity activity, String[] strArr) {
        setAsInitialized();
        setUserId(AdMost.getInstance().getUserId());
        try {
            if (!AdMost.getInstance().getConfiguration().showPersonalizedAdForGDPR() || !AdMost.getInstance().getConfiguration().showPersonalizedAdForCCPA()) {
                Chartboost.setPIDataUseConsent(AdMost.getInstance().getContext(), Chartboost.CBPIDataUseConsent.NO_BEHAVIORAL);
            } else {
                Chartboost.setPIDataUseConsent(AdMost.getInstance().getContext(), Chartboost.CBPIDataUseConsent.YES_BEHAVIORAL);
            }
            Chartboost.startWithAppId(activity.getApplicationContext(), strArr[0], strArr[1]);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Chartboost.setDelegate(new ChartboostDelegate() {
            public void didCacheInterstitial(String str) {
                if (AdMostChartboostInitAdapter.this.placementListeners.containsKey(str)) {
                    AdMostChartboostInitAdapter.this.placementListeners.get(str).onReady(AdMostAdNetwork.CHARTBOOST, 0);
                }
                AdMostChartboostInitAdapter.this.locationAvailability.put(str, true);
            }

            public void didCacheRewardedVideo(String str) {
                if (AdMostChartboostInitAdapter.this.placementListeners.containsKey(str)) {
                    AdMostChartboostInitAdapter.this.placementListeners.get(str).onReady(AdMostAdNetwork.CHARTBOOST, 0);
                }
                AdMostChartboostInitAdapter.this.locationAvailability.put(str, true);
            }

            public void didClickInterstitial(String str) {
                if (AdMostChartboostInitAdapter.this.placementListeners.containsKey(str)) {
                    AdMostChartboostInitAdapter.this.placementListeners.get(str).onClicked(AdMostAdNetwork.CHARTBOOST);
                }
            }

            public void didClickRewardedVideo(String str) {
                if (AdMostChartboostInitAdapter.this.placementListeners.containsKey(str)) {
                    AdMostChartboostInitAdapter.this.placementListeners.get(str).onClicked(AdMostAdNetwork.CHARTBOOST);
                }
            }

            public void didCloseInterstitial(String str) {
                if (AdMostChartboostInitAdapter.this.placementListeners.containsKey(str)) {
                    AdMostChartboostInitAdapter.this.placementListeners.get(str).onDismiss("");
                }
                AdMostChartboostInitAdapter.this.removeListenerForPlacement(str);
            }

            public void didCloseRewardedVideo(String str) {
                if (AdMostChartboostInitAdapter.this.placementListeners.containsKey(str)) {
                    AdMostChartboostInitAdapter.this.placementListeners.get(str).onDismiss("");
                }
                AdMostChartboostInitAdapter.this.removeListenerForPlacement(str);
            }

            public void didCompleteRewardedVideo(String str, int i) {
                if (AdMostChartboostInitAdapter.this.placementListeners.containsKey(str)) {
                    AdMostChartboostInitAdapter.this.placementListeners.get(str).onComplete(AdMostAdNetwork.CHARTBOOST);
                }
            }

            public void didFailToLoadInterstitial(String str, CBError.CBImpressionError cBImpressionError) {
                if (AdMostChartboostInitAdapter.this.placementListeners.containsKey(str)) {
                    AdMostChartboostInitAdapter.this.placementListeners.get(str).onFail(400);
                }
                AdMostChartboostInitAdapter.this.locationAvailability.put(str, false);
            }

            public void didFailToLoadRewardedVideo(String str, CBError.CBImpressionError cBImpressionError) {
                if (AdMostChartboostInitAdapter.this.placementListeners.containsKey(str)) {
                    AdMostChartboostInitAdapter.this.placementListeners.get(str).onFail(400);
                }
                AdMostChartboostInitAdapter.this.locationAvailability.put(str, false);
            }

            public void didInitialize() {
                AdMostLog.m299i("ChartBoost initialized");
                AdMostChartboostInitAdapter adMostChartboostInitAdapter = AdMostChartboostInitAdapter.this;
                adMostChartboostInitAdapter.isInitAdNetworkCompletedSuccessfully = true;
                adMostChartboostInitAdapter.sendSuccessToInitListeners();
            }

            public void willDisplayInterstitial(String str) {
            }

            public void willDisplayVideo(String str) {
            }
        });
        Chartboost.setShouldPrefetchVideoContent(true);
        if (strArr.length > 2) {
            Chartboost.setFramework(Chartboost.CBFramework.CBFrameworkUnity, strArr[2]);
        }
        Chartboost.setMediation(Chartboost.CBMediation.CBMediationOther, AdMost.getInstance().getVersion());
    }

    public boolean isLocationCallable(String str) {
        return !this.locationAvailability.containsKey(str) || (this.locationAvailability.containsKey(str) && this.locationAvailability.get(str).booleanValue());
    }

    public boolean onBackPressed(Activity activity) {
        return !Chartboost.onBackPressed();
    }

    public void setUserId(String str) {
        if (str != null) {
            try {
                if (!str.equals("")) {
                    Chartboost.setCustomId(str);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
