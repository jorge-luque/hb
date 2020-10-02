package admost.sdk.listener;

import admost.sdk.base.AdMostBannerResponseFailReason;
import admost.sdk.model.AdMostItem;

public abstract class AdMostManagerListener {
    public static final int LOAD_STATUS_FOR_ZONE_CACHE = 2;
    public static final int LOAD_STATUS_NO_LISTENER = 1;
    public static final int LOAD_STATUS_SUCCESS = 0;
    public static final int LOAD_STATUS_WAITING_RESPONSETIMEOUT = 3;
    public boolean dontTryNextWaterfallItem;
    public boolean isSecondRun;
    public int listenerId;
    public int requestNumber;
    public long requestStartedAt = 0;
    public int timeoutPeriod;
    public boolean waitingResponse = true;
    public String zoneId;

    public AdMostManagerListener(int i, int i2, boolean z, int i3, String str) {
        this.listenerId = i;
        this.requestNumber = i2;
        this.isSecondRun = z;
        this.timeoutPeriod = i3 <= 0 ? 3000 : i3;
        this.zoneId = str;
    }

    public void onAdClicked() {
    }

    public boolean onAdFailed(String str) {
        if (str.equals(AdMostBannerResponseFailReason.TIMEOUT) || str.equals(AdMostBannerResponseFailReason.NO_FILL_MARKED) || !this.waitingResponse) {
            return false;
        }
        this.waitingResponse = false;
        return true;
    }

    public int onAdLoad(String str, AdMostItem adMostItem) {
        this.waitingResponse = false;
        return 0;
    }
}
