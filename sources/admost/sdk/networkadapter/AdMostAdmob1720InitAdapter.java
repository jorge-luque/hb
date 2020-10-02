package admost.sdk.networkadapter;

import admost.sdk.BuildConfig;
import admost.sdk.base.AdMost;
import admost.sdk.base.AdMostAdClassName;
import admost.sdk.base.AdMostAdNetwork;
import admost.sdk.base.AdMostUtil;
import admost.sdk.interfaces.AdMostAdNetworkInitInterface;
import android.app.Activity;
import com.facebook.appevents.AppEventsConstants;
import com.google.android.gms.ads.MobileAds;
import java.util.ArrayList;
import java.util.Arrays;

public class AdMostAdmob1720InitAdapter extends AdMostAdNetworkInitInterface {
    static String[] supportedAdTypes;
    private static String userId = "";
    private boolean useAdaptiveBanners;

    static {
        ArrayList arrayList = new ArrayList();
        arrayList.add("fullscreen_banner");
        arrayList.add("fullscreen_video");
        arrayList.add("banner_banner");
        if (AdMostUtil.isClassAvailable(AdMostAdClassName.ADMOB_NATIVE)) {
            arrayList.add("fullscreen_native");
            arrayList.add("fullscreen_native_install");
            arrayList.add("banner_native");
            arrayList.add("banner_native_install");
        }
        arrayList.removeAll(Arrays.asList(new String[]{"", null}));
        supportedAdTypes = (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    public AdMostAdmob1720InitAdapter() {
        super(true, 0, 0, true, supportedAdTypes);
    }

    public static String getUserId() {
        return userId;
    }

    public String getAdapterVersion() {
        return BuildConfig.ADAPTER_MIN_VERSION;
    }

    public String getMinSdkVersion() {
        return "2.1.6";
    }

    public void initialize(Activity activity, String[] strArr) {
        setAsInitialized();
        setUserId(AdMost.getInstance().getUserId());
        MobileAds.initialize(AdMost.getInstance().getContext());
        if (!AdMostUtil.isClassAvailable(AdMostAdClassName.ADMOB_ADAPTER_GT_17_2)) {
            this.useAdaptiveBanners = false;
        } else if (strArr == null || strArr.length <= 1) {
            this.useAdaptiveBanners = true;
        } else {
            this.useAdaptiveBanners = true ^ strArr[1].equals(AppEventsConstants.EVENT_PARAM_VALUE_NO);
        }
        try {
            MobileAds.setAppMuted(AdMost.getInstance().isSoundMuted(AdMostAdNetwork.ADMOB));
        } catch (Exception unused) {
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

    public boolean useAdaptiveBanners() {
        return this.useAdaptiveBanners;
    }
}
