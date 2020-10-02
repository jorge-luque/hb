package admost.sdk.networkadapter;

import admost.sdk.BuildConfig;
import admost.sdk.base.AdMost;
import admost.sdk.base.AdMostAdClassName;
import admost.sdk.base.AdMostAdNetwork;
import admost.sdk.base.AdMostUtil;
import admost.sdk.interfaces.AdMostAdNetworkInitInterface;
import android.app.Activity;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.reward.RewardedVideoAd;
import java.util.ArrayList;
import java.util.Arrays;

public class AdMostAdmobInitAdapter extends AdMostAdNetworkInitInterface {
    static String[] supportedAdTypes;
    private static String userId = "";
    private RewardedVideoAd rewardedVideoAd;

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

    public AdMostAdmobInitAdapter() {
        super(true, 0, 0, true, supportedAdTypes);
    }

    public static String getUserId() {
        return userId;
    }

    public String getAdapterVersion() {
        return BuildConfig.ADAPTER_MIN_VERSION;
    }

    public String getMinSdkVersion() {
        return BuildConfig.VERSION_NAME;
    }

    public void initialize(Activity activity, String[] strArr) {
        setAsInitialized();
        setUserId(AdMost.getInstance().getUserId());
        if (strArr == null || strArr.length <= 0) {
            MobileAds.initialize(AdMost.getInstance().getContext());
        } else {
            MobileAds.initialize(AdMost.getInstance().getContext(), strArr[0]);
        }
        try {
            MobileAds.setAppMuted(AdMost.getInstance().isSoundMuted(AdMostAdNetwork.ADMOB));
        } catch (Exception unused) {
        }
    }

    public void onPause(Activity activity) {
        if (!ignoreInLifeCycle(activity) && AdMostUtil.isClassAvailable(AdMostAdClassName.ADMOB_REWARDED)) {
            try {
                if (this.rewardedVideoAd != null) {
                    this.rewardedVideoAd.pause(activity);
                }
            } catch (Exception unused) {
            }
        }
    }

    public void onResume(Activity activity) {
        if (!ignoreInLifeCycle(activity) && AdMostUtil.isClassAvailable(AdMostAdClassName.ADMOB_REWARDED)) {
            try {
                if (this.rewardedVideoAd != null) {
                    this.rewardedVideoAd.resume(activity);
                }
            } catch (Exception unused) {
            }
        }
    }

    /* access modifiers changed from: protected */
    public void setRewardedVideoAd(RewardedVideoAd rewardedVideoAd2) {
        this.rewardedVideoAd = rewardedVideoAd2;
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
