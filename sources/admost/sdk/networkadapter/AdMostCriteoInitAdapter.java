package admost.sdk.networkadapter;

import admost.sdk.AdMostManager;
import admost.sdk.BuildConfig;
import admost.sdk.base.AdMost;
import admost.sdk.base.AdMostAdNetwork;
import admost.sdk.base.AdMostLog;
import admost.sdk.interfaces.AdMostAdNetworkInitInterface;
import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import com.criteo.publisher.Criteo;
import com.criteo.publisher.CriteoInitException;
import com.criteo.publisher.model.AdSize;
import com.criteo.publisher.model.BannerAdUnit;
import com.criteo.publisher.model.InterstitialAdUnit;
import java.util.ArrayList;
import org.json.JSONObject;

public class AdMostCriteoInitAdapter extends AdMostAdNetworkInitInterface {
    BannerAdUnit bannerAdUnit;
    int initDuration = 1800;

    public AdMostCriteoInitAdapter() {
        super(true, 2, 21, true, "fullscreen_banner", "banner_banner");
        AdMostLog.log(getAdapterVersion());
    }

    private void setBidConfig() {
        JSONObject bidConfig = AdMost.getInstance().getConfiguration().getBidConfig(AdMostAdNetwork.CRITEO);
        if (bidConfig != null) {
            this.initDuration = bidConfig.optInt("InitDuration", 1800);
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
        String str = strArr[0];
        ArrayList arrayList = new ArrayList();
        for (int i = 1; i < strArr.length; i++) {
            String[] split = strArr[i].split(":");
            if (split[0].equals("B")) {
                if (split[2].equals("90")) {
                    this.bannerAdUnit = new BannerAdUnit(split[1], new AdSize(320, 90));
                } else if (split[2].equals("250")) {
                    this.bannerAdUnit = new BannerAdUnit(split[1], new AdSize(AdMost.AD_ERROR_FREQ_CAP, AdMostManager.AD_MEDIUM_RECTANGLE));
                } else {
                    this.bannerAdUnit = new BannerAdUnit(split[1], new AdSize(320, 50));
                }
                arrayList.add(this.bannerAdUnit);
            } else if (split[0].equals("I")) {
                for (int i2 = 1; i2 < split.length; i2++) {
                    arrayList.add(new InterstitialAdUnit(split[1]));
                }
            } else {
                this.hasInitializationError = true;
                AdMostLog.m296e("Criteo placements should start with 'I:' or 'B:'.");
            }
        }
        try {
            Criteo.init(AdMost.getInstance().getActivity().getApplication(), str, arrayList);
            int bidTimeout = AdMost.getInstance().getConfiguration().getBidTimeout((String) null, false);
            if (this.initDuration > bidTimeout) {
                this.initDuration = bidTimeout - 100;
            }
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                public void run() {
                    AdMostCriteoInitAdapter adMostCriteoInitAdapter = AdMostCriteoInitAdapter.this;
                    adMostCriteoInitAdapter.isInitAdNetworkCompletedSuccessfully = true;
                    adMostCriteoInitAdapter.sendSuccessToInitListeners();
                }
            }, (long) this.initDuration);
        } catch (CriteoInitException e) {
            e.printStackTrace();
            this.hasInitializationError = true;
        }
    }
}
