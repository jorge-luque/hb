package admost.sdk.networkadapter;

import admost.sdk.BuildConfig;
import admost.sdk.base.AdMost;
import admost.sdk.base.AdMostAdNetwork;
import admost.sdk.interfaces.AdMostAdNetworkInitInterface;
import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import com.adcolony.sdk.AdColony;
import com.adcolony.sdk.AdColonyAppOptions;
import com.facebook.appevents.AppEventsConstants;
import org.json.JSONObject;

public class AdMostAdcolonyInitAdapter extends AdMostAdNetworkInitInterface {
    String SSPId;
    String appStoreUrl;
    String applicationId;
    String applicationName;
    String applicationPublisherId;
    String exchangeSpecificAppId;

    public AdMostAdcolonyInitAdapter() {
        super(true, 2, 14, true, "banner_banner", "fullscreen_banner", "fullscreen_video");
    }

    private void setBidConfig() {
        JSONObject bidConfig = AdMost.getInstance().getConfiguration().getBidConfig(AdMostAdNetwork.ADCOLONY);
        if (bidConfig == null) {
            this.hasBiddingInitializationError = true;
            return;
        }
        this.SSPId = bidConfig.optString("SSPId", (String) null);
        this.applicationId = bidConfig.optString("AppId", (String) null);
        this.applicationName = bidConfig.optString("AppName", "");
        this.applicationPublisherId = bidConfig.optString("AppPubId", "");
        this.exchangeSpecificAppId = bidConfig.optString("ExcAppId", "");
        this.appStoreUrl = bidConfig.optString("AppStoreUrl", "");
        String str = this.SSPId;
        if (str == null || this.applicationId == null || str.length() < 3 || this.applicationId.length() < 3) {
            this.hasBiddingInitializationError = true;
        }
    }

    public String getAdapterVersion() {
        return BuildConfig.ADAPTER_MIN_VERSION;
    }

    public String getMinSdkVersion() {
        return "2.1.6";
    }

    public String getVersion() {
        return AdColony.getSDKVersion();
    }

    public void initialize(Activity activity, String[] strArr) {
        String str = "1";
        setAsInitialized();
        setBidConfig();
        String[] strArr2 = new String[(strArr.length - 1)];
        for (int i = 1; i < strArr.length; i++) {
            strArr2[i - 1] = strArr[i];
        }
        final AdColonyAppOptions adColonyAppOptions = new AdColonyAppOptions();
        try {
            adColonyAppOptions.setPrivacyFrameworkRequired("GDPR", AdMost.getInstance().getConfiguration().isGDPRRequired()).setPrivacyConsentString("GDPR", AdMost.getInstance().getConfiguration().getUserConsent().equals(str) ? str : AppEventsConstants.EVENT_PARAM_VALUE_NO);
            AdColonyAppOptions privacyFrameworkRequired = adColonyAppOptions.setPrivacyFrameworkRequired("CCPA", AdMost.getInstance().getConfiguration().isCCPARequired());
            if (!AdMost.getInstance().getConfiguration().getUserConsent().equals(str)) {
                str = AppEventsConstants.EVENT_PARAM_VALUE_NO;
            }
            privacyFrameworkRequired.setPrivacyConsentString("CCPA", str);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String str2 = strArr[0];
        this.applicationId = str2;
        boolean z = !AdColony.configure(activity, adColonyAppOptions, str2, strArr2);
        this.hasInitializationError = z;
        if (!z) {
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                public void run() {
                    String userId = AdMost.getInstance().getUserId();
                    if (userId != null && !userId.equals("")) {
                        adColonyAppOptions.setUserID(userId);
                    }
                    AdMostAdcolonyInitAdapter adMostAdcolonyInitAdapter = AdMostAdcolonyInitAdapter.this;
                    adMostAdcolonyInitAdapter.isInitAdNetworkCompletedSuccessfully = true;
                    adMostAdcolonyInitAdapter.sendSuccessToInitListeners();
                }
            }, 1500);
        } else {
            sendFailToInitListeners();
        }
    }

    public void setUserId(String str) {
        if (str != null) {
            try {
                if (str.equals("")) {
                    return;
                }
                if (AdColony.getAppOptions() == null || AdColony.getAppOptions().getUserID().equals(str)) {
                    AdColonyAppOptions adColonyAppOptions = new AdColonyAppOptions();
                    adColonyAppOptions.setUserID(str);
                    AdColony.setAppOptions(adColonyAppOptions);
                    return;
                }
                AdColony.setAppOptions(AdColony.getAppOptions().setUserID(str));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
