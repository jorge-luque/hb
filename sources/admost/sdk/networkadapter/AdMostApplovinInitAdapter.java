package admost.sdk.networkadapter;

import admost.sdk.BuildConfig;
import admost.sdk.base.AdMost;
import admost.sdk.base.AdMostAdNetwork;
import admost.sdk.base.AdMostLog;
import admost.sdk.interfaces.AdMostAdNetworkInitInterface;
import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import com.applovin.sdk.AppLovinPrivacySettings;
import com.applovin.sdk.AppLovinSdk;

public class AdMostApplovinInitAdapter extends AdMostAdNetworkInitInterface {
    private static String userId = "";
    private static boolean userIdNeedsToBeResent = true;

    public AdMostApplovinInitAdapter() {
        super(true, 1, 15, true, "fullscreen_banner", "fullscreen_video", "banner_banner", "banner_native");
    }

    public static String getUserId() {
        return userId;
    }

    public static boolean isUserIdNeedsToBeResent() {
        return userIdNeedsToBeResent;
    }

    public static void setUserIdNeedsToBeResent(boolean z) {
        userIdNeedsToBeResent = z;
    }

    public String getAdapterVersion() {
        return BuildConfig.ADAPTER_MIN_VERSION;
    }

    public String getMinSdkVersion() {
        return "2.1.6";
    }

    public void initialize(Activity activity, String[] strArr) {
        setAsInitialized();
        try {
            if (!AdMost.getInstance().getConfiguration().showPersonalizedAdForGDPR() || !AdMost.getInstance().getConfiguration().showPersonalizedAdForCCPA()) {
                AppLovinPrivacySettings.setHasUserConsent(false, AdMost.getInstance().getContext());
            } else {
                AppLovinPrivacySettings.setHasUserConsent(true, AdMost.getInstance().getContext());
            }
            AppLovinPrivacySettings.setIsAgeRestrictedUser(AdMost.getInstance().isUserChild(), AdMost.getInstance().getContext());
        } catch (Exception e) {
            e.printStackTrace();
        }
        AppLovinSdk.initializeSdk(AdMost.getInstance().getContext());
        AppLovinSdk.getInstance(AdMost.getInstance().getContext()).getSettings().setMuted(AdMost.getInstance().isSoundMuted(AdMostAdNetwork.APPLOVIN));
        AppLovinSdk.getInstance(AdMost.getInstance().getContext()).getSettings().setBannerAdRefreshSeconds(0);
        if (AdMostLog.isAdNetworkLogsEnabled()) {
            AppLovinSdk.getInstance(AdMost.getInstance().getContext()).getSettings().setVerboseLogging(true);
        }
        setUserId(AdMost.getInstance().getUserId());
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            public void run() {
                AdMostApplovinInitAdapter adMostApplovinInitAdapter = AdMostApplovinInitAdapter.this;
                adMostApplovinInitAdapter.isInitAdNetworkCompletedSuccessfully = true;
                adMostApplovinInitAdapter.sendSuccessToInitListeners();
            }
        }, 1500);
    }

    public void setUserId(String str) {
        if (str != null) {
            try {
                if (!str.equals("")) {
                    if (!userId.equals(str)) {
                        setUserIdNeedsToBeResent(true);
                    }
                    userId = str;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
