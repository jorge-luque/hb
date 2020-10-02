package admost.sdk.networkadapter;

import admost.sdk.BuildConfig;
import admost.sdk.base.AdMostLog;
import admost.sdk.interfaces.AdMostAdNetworkInitInterface;
import android.app.Activity;
import p118io.presage.Presage;

public class AdMostOguryInitAdapter extends AdMostAdNetworkInitInterface {
    public AdMostOguryInitAdapter() {
        super(true, 1, 16, true, "fullscreen_banner", "fullscreen_video");
    }

    public String getAdapterVersion() {
        return BuildConfig.ADAPTER_MIN_VERSION;
    }

    public String getMinSdkVersion() {
        return "2.1.6";
    }

    public void initialize(Activity activity, String[] strArr) {
        setAsInitialized();
        if (strArr[0] != null) {
            Presage.getInstance().start(strArr[0], activity);
            sendSuccessToInitListeners();
            return;
        }
        AdMostLog.m296e("Ogury App Key is null!");
        sendFailToInitListeners();
    }
}
