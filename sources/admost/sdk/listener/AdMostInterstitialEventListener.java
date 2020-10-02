package admost.sdk.listener;

import admost.sdk.interfaces.AdMostFullScreenInterface;
import admost.sdk.model.AdMostBannerResponseItem;

public abstract class AdMostInterstitialEventListener {
    public static final int ERROR_EXCLUDED_DEVICE = 12;
    public static final int ERROR_EXCLUDED_SDK_VERSION = 11;
    public static final int ERROR_INITIALIZATION_ERROR = 1;
    public static final int ERROR_INITIALIZATION_STARTED = 3;
    public static final int ERROR_NOT_SUPPORTED_AD_TYPE = 10;
    public static final int ERROR_NO_FILL = 6;
    public static final int ERROR_REQUEST_TIMEOUT = 8;
    public static final int ERROR_SDK_VERSION = 2;
    public static final int ERROR_SINGLETON = 5;
    public static final int ERROR_STATUS_CHANGED = 4;
    public static final int ERROR_UNKNOWN_REASON = 7;
    public static final int REQUEST_LIMIT_PER_WATERFALL = 9;
    public static final int SUCCESS = 0;
    public boolean failedOnce;
    public String interstitialHash;
    public boolean isTimeoutFail;
    public long requestInterval;
    public long requestTimeout;
    public AdMostBannerResponseItem responseItem;
    public long timeoutAt;
    public String waitingInterstitialWaterfallKey;
    public boolean waitingResponse = true;

    protected AdMostInterstitialEventListener(AdMostBannerResponseItem adMostBannerResponseItem, long j, String str, String str2, long j2) {
        this.requestTimeout = j <= 0 ? 5000 : j;
        this.requestInterval = j2;
        this.responseItem = adMostBannerResponseItem;
        this.waitingInterstitialWaterfallKey = str;
        this.interstitialHash = str2;
    }

    public void destroy() {
        this.responseItem = null;
    }

    public void onClick(AdMostBannerResponseItem adMostBannerResponseItem) {
    }

    public void onComplete(AdMostBannerResponseItem adMostBannerResponseItem) {
    }

    public void onDismiss(AdMostBannerResponseItem adMostBannerResponseItem) {
    }

    public void onFail(AdMostBannerResponseItem adMostBannerResponseItem, int i) {
        if (i != 8) {
            this.waitingResponse = false;
            this.failedOnce = true;
            return;
        }
        this.isTimeoutFail = true;
    }

    public void onFailToShow() {
    }

    public void onLoad(AdMostFullScreenInterface adMostFullScreenInterface, long j) {
        this.waitingResponse = false;
    }

    public void setTimeoutAt() {
        this.timeoutAt = System.currentTimeMillis() + this.requestTimeout;
    }
}
