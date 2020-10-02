package admost.sdk.networkadapter;

import admost.sdk.BuildConfig;
import admost.sdk.base.AdMost;
import admost.sdk.base.AdMostAdNetwork;
import admost.sdk.interfaces.AdMostAdNetworkInitInterface;
import android.app.Activity;
import com.facebook.ads.AdSettings;
import com.facebook.ads.AudienceNetworkAds;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import org.json.JSONObject;

public class AdMostFacebookInitAdapter extends AdMostAdNetworkInitInterface {
    private static String userId = "";
    public String applicationId;
    public String platformId;
    public boolean useCustomRenderer;

    public AdMostFacebookInitAdapter() {
        super(true, 0, 15, true, "fullscreen_banner", "fullscreen_video", "fullscreen_native", "banner_banner", "banner_native");
    }

    public static String getUserId() {
        return userId;
    }

    private void setBidConfig() {
        JSONObject bidConfig = AdMost.getInstance().getConfiguration().getBidConfig(AdMostAdNetwork.FACEBOOK);
        if (bidConfig == null) {
            this.hasBiddingInitializationError = true;
            return;
        }
        this.platformId = bidConfig.optString("PublisherId", (String) null);
        String optString = bidConfig.optString("AppId", (String) null);
        this.applicationId = optString;
        String str = this.platformId;
        if (str == null || optString == null || str.length() < 3 || this.applicationId.length() < 3) {
            this.hasBiddingInitializationError = true;
        }
    }

    public String getAdapterVersion() {
        return BuildConfig.ADAPTER_MIN_VERSION;
    }

    public String getMinSdkVersion() {
        return "2.1.6";
    }

    public void initialize(Activity activity, String[] strArr) {
        setAsInitialized();
        setBidConfig();
        boolean z = true;
        if (!AdMost.getInstance().getConfiguration().showPersonalizedAdForCCPA()) {
            AdSettings.setDataProcessingOptions(new String[]{"LDU"});
        }
        AudienceNetworkAds.initialize(AdMost.getInstance().getContext());
        try {
            ArrayList<String> testDeviceIds = AdMost.getInstance().getConfiguration().getTestDeviceIds(AdMostAdNetwork.FACEBOOK);
            if (testDeviceIds != null && testDeviceIds.size() > 0) {
                Enumeration<T> enumeration = Collections.enumeration(testDeviceIds);
                while (enumeration.hasMoreElements()) {
                    AdSettings.addTestDevice((String) enumeration.nextElement());
                }
            }
            if (strArr != null && strArr.length > 0) {
                if (strArr[0] == null || !strArr[0].equals("1")) {
                    z = false;
                }
                this.useCustomRenderer = z;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            AdMostFacebookBiddingManager.getInstance().sendLogsToServer();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void setUserId(String str) {
        if (str != null) {
            try {
                if (!str.equals("")) {
                    userId = str;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
