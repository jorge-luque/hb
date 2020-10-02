package admost.sdk.listener;

import admost.sdk.AdMostBiddingManager;
import admost.sdk.base.AdMostImpressionManager;
import admost.sdk.interfaces.AdMostBiddingInterface;
import admost.sdk.model.AdMostBannerResponseItem;

public abstract class AdMostBiddingEventListener {
    public static final String ERROR_INITIALIZATION_ERROR = "ERROR_INITIALIZATION_ERROR";
    public static final String ERROR_REQUEST_TIMEOUT = "ERROR_REQUEST_TIMEOUT";
    public static final String ERROR_SINGLETON = "ERROR_SINGLETON";
    public static final String ERROR_STATUS_CHANGED = "ERROR_STATUS_CHANGED";
    public static final String ERROR_UNKNOWN_REASON = "ERROR_UNKNOWN_REASON";
    public String advId;
    public AdMostBiddingInterface biddingInterface;
    public boolean failedOnce;
    public long requestTimeout;
    public AdMostBannerResponseItem responseItem;
    public long timeoutAt;
    public boolean waitingResponse = true;

    protected AdMostBiddingEventListener(AdMostBannerResponseItem adMostBannerResponseItem, long j, String str) {
        this.requestTimeout = j <= 0 ? 1000 : j;
        this.responseItem = adMostBannerResponseItem;
        this.advId = str;
    }

    public void onBiddingFail(AdMostBannerResponseItem adMostBannerResponseItem, String str) {
        this.waitingResponse = false;
        if (str.equals(ERROR_REQUEST_TIMEOUT)) {
            adMostBannerResponseItem.WaterFallLogItem.isBidTimeout = true;
            AdMostBiddingManager.getInstance().sendLossNotice(this.biddingInterface, 0.0d, AdMostBiddingManager.LOSS_REASON_BID_TIMEOUT);
            AdMostImpressionManager.getInstance().setPlacementBidData(13, adMostBannerResponseItem);
        }
    }

    public void onBiddingSuccess(AdMostBiddingInterface adMostBiddingInterface) {
        this.waitingResponse = false;
    }

    public void setTimeoutAt() {
        this.timeoutAt = System.currentTimeMillis() + this.requestTimeout;
    }
}
