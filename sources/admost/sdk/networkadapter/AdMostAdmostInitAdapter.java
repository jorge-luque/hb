package admost.sdk.networkadapter;

import admost.adserver.core.C0055e;
import admost.sdk.BuildConfig;
import admost.sdk.interfaces.AdMostAdNetworkInitInterface;

public class AdMostAdmostInitAdapter extends AdMostAdNetworkInitInterface {
    public AdMostAdmostInitAdapter() {
        super(false, 0, 16, true, "fullscreen_banner", "fullscreen_video", "banner_banner", "banner_native");
    }

    public String getAdapterVersion() {
        return BuildConfig.ADAPTER_MIN_VERSION;
    }

    public String getMinSdkVersion() {
        return "2.1.6";
    }

    public String getVersion() {
        try {
            return C0055e.class.getMethod("c", new Class[0]) != null ? C0055e.m155c() : "";
        } catch (Exception unused) {
            return "";
        }
    }
}
