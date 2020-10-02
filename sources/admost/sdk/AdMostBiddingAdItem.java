package admost.sdk;

import admost.sdk.base.AdMost;
import admost.sdk.base.AdMostConfiguration;
import admost.sdk.base.AdMostImpressionManager;
import admost.sdk.base.AdMostLog;
import admost.sdk.base.AdMostUtil;
import admost.sdk.interfaces.AdMostAdInterface;
import admost.sdk.interfaces.AdMostBannerInterface;
import admost.sdk.interfaces.AdMostBiddingInterface;
import admost.sdk.interfaces.AdMostFullScreenInterface;
import admost.sdk.listener.AdMostBiddingCompeteListener;
import admost.sdk.listener.AdMostBiddingEventListener;
import admost.sdk.model.AdMostBannerResponseBase;
import admost.sdk.model.AdMostBannerResponseItem;
import admost.sdk.model.AdMostWaterfallLog;
import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Hashtable;
import java.util.Vector;

class AdMostBiddingAdItem {
    private int bidTimeout;
    /* access modifiers changed from: private */
    public AdMostAdInterface biddingAd;
    private AdMostBiddingCompeteListener biddingCompeteListener;
    private boolean biddingCompleted;
    private long biddingCycleCompletedAt;
    /* access modifiers changed from: private */
    public Vector<AdMostBiddingInterface> biddingResponses = new Vector<>();
    private boolean callbacksTriggered = false;
    private Hashtable<String, Object> customData;
    /* access modifiers changed from: private */
    public Handler handler = new Handler(Looper.getMainLooper());
    /* access modifiers changed from: private */
    public double maxBidPrice;
    /* access modifiers changed from: private */
    public int waitingBidResponseCount = 0;
    /* access modifiers changed from: private */
    public AdMostAdInterface waterfallAd;
    private AdMostBiddingCompeteListener waterfallCompeteListener;
    private boolean waterfallCompleted;
    private long waterfallCycleCompletedAt;
    AdMostBannerResponseBase waterfallResponse;

    public static class CustomComparatorBiddingResponse implements Comparator<AdMostBiddingInterface> {
        public int compare(AdMostBiddingInterface adMostBiddingInterface, AdMostBiddingInterface adMostBiddingInterface2) {
            return Double.compare(adMostBiddingInterface2.getBiddingPrice(), adMostBiddingInterface.getBiddingPrice());
        }
    }

    AdMostBiddingAdItem() {
    }

    static /* synthetic */ int access$010(AdMostBiddingAdItem adMostBiddingAdItem) {
        int i = adMostBiddingAdItem.waitingBidResponseCount;
        adMostBiddingAdItem.waitingBidResponseCount = i - 1;
        return i;
    }

    /* access modifiers changed from: private */
    public void biddingCompletedForAll() {
        AdMostBiddingInterface adMostBiddingInterface;
        AdMostBannerResponseItem adMostBannerResponseItem;
        Vector<AdMostBiddingInterface> vector = this.biddingResponses;
        if (vector == null || vector.size() <= 0) {
            adMostBiddingInterface = null;
        } else {
            Collections.sort(this.biddingResponses, new CustomComparatorBiddingResponse());
            adMostBiddingInterface = this.biddingResponses.get(0);
            if (adMostBiddingInterface instanceof AdMostFullScreenInterface) {
                adMostBannerResponseItem = ((AdMostFullScreenInterface) adMostBiddingInterface).mBannerResponseItem;
            } else {
                adMostBannerResponseItem = ((AdMostBannerInterface) adMostBiddingInterface).mBannerResponseItem;
            }
            AdMostImpressionManager.getInstance().setPlacementBidData(12, adMostBannerResponseItem);
        }
        biddingCycleCompleted((AdMostAdInterface) adMostBiddingInterface, new AdMostBiddingCompeteListener() {
            public void onBiddingWins(AdMostAdInterface adMostAdInterface, AdMostAdInterface adMostAdInterface2) {
                AdMostBannerResponseItem bannerResponseItem;
                final AdMostAdInterface access$500 = AdMostBiddingAdItem.this.biddingAd;
                if (access$500 != null && (bannerResponseItem = access$500.getBannerResponseItem()) != null) {
                    AdMostLog.m299i("Bidding biddingCompletedForAll *** onBiddingWins");
                    double d = 0.0d;
                    AdMostBiddingInterface adMostBiddingInterface = (AdMostBiddingInterface) access$500;
                    double biddingPrice = adMostBiddingInterface.getBiddingPrice() / 100.0d;
                    for (int i = 0; i < AdMostBiddingAdItem.this.biddingResponses.size(); i++) {
                        if (access$500 != AdMostBiddingAdItem.this.biddingResponses.get(i)) {
                            d = Math.max(d, ((AdMostBiddingInterface) AdMostBiddingAdItem.this.biddingResponses.get(i)).getBiddingPrice());
                            AdMostBiddingManager.getInstance().sendLossNotice((AdMostBiddingInterface) AdMostBiddingAdItem.this.biddingResponses.get(i), biddingPrice, AdMostBiddingManager.LOSS_REASON_NOT_HIGHEST_RTB_BIDDER);
                            AdMostBiddingAdItem adMostBiddingAdItem = AdMostBiddingAdItem.this;
                            adMostBiddingAdItem.destroyBiddingResponseAd((AdMostBiddingInterface) adMostBiddingAdItem.biddingResponses.get(i));
                        }
                    }
                    if (!(adMostAdInterface2 == null || adMostAdInterface2.getBannerResponseItem() == null || ((double) adMostAdInterface2.getBannerResponseItem().PureWeight) <= d)) {
                        d = (double) adMostAdInterface2.getBannerResponseItem().PureWeight;
                    }
                    AdMostBiddingManager.getInstance().sendWinNotice(adMostBiddingInterface, d / 100.0d);
                    AdMostImpressionManager.getInstance().setPlacementBidData(17, bannerResponseItem);
                    AdMostWaterfallLog adMostWaterfallLog = bannerResponseItem.WaterFallLogItem;
                    adMostWaterfallLog.requestCount++;
                    adMostWaterfallLog.isTried = true;
                    adMostWaterfallLog.triedAt = System.currentTimeMillis();
                    AdMostBiddingAdItem.this.handler.post(new Runnable() {
                        public void run() {
                            AdMostAdInterface adMostAdInterface = access$500;
                            if (adMostAdInterface != null) {
                                AdMostBiddingAdItem adMostBiddingAdItem = AdMostBiddingAdItem.this;
                                adMostBiddingAdItem.loadBiddingAd(adMostAdInterface, adMostBiddingAdItem.waterfallAd);
                            }
                        }
                    });
                }
            }

            public void onWaterfallWins(AdMostAdInterface adMostAdInterface) {
                AdMostLog.m299i("Bidding biddingCompletedForAll *** onWaterfallWins");
                int i = 0;
                while (i < AdMostBiddingAdItem.this.biddingResponses.size()) {
                    try {
                        AdMostBiddingInterface adMostBiddingInterface = (AdMostBiddingInterface) AdMostBiddingAdItem.this.biddingResponses.get(i);
                        AdMostBiddingManager instance = AdMostBiddingManager.getInstance();
                        double d = (double) adMostAdInterface.getBannerResponseItem().PureWeight;
                        Double.isNaN(d);
                        instance.sendLossNotice(adMostBiddingInterface, d / 100.0d, AdMostBiddingManager.LOSS_REASON_NOT_HIGHER_THAN_WATERFALL);
                        AdMostBiddingAdItem.this.destroyBiddingResponseAd(adMostBiddingInterface);
                        i++;
                    } catch (Exception e) {
                        e.printStackTrace();
                        return;
                    }
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public void destroyBiddingResponseAd(AdMostBiddingInterface adMostBiddingInterface) {
        if (adMostBiddingInterface instanceof AdMostFullScreenInterface) {
            AdMostFullScreenInterface adMostFullScreenInterface = (AdMostFullScreenInterface) adMostBiddingInterface;
            AdMostBiddingManager.getInstance().removeFromSingletonArray(adMostFullScreenInterface);
            adMostFullScreenInterface.destroy();
            return;
        }
        ((AdMostBannerInterface) adMostBiddingInterface).destroy();
    }

    private void finishCycleAndCompete(AdMostAdInterface adMostAdInterface, AdMostBiddingCompeteListener adMostBiddingCompeteListener, boolean z) {
        if (z) {
            if (!this.waterfallCompleted) {
                this.waterfallCycleCompletedAt = System.currentTimeMillis();
                this.waterfallCompeteListener = adMostBiddingCompeteListener;
                this.waterfallAd = adMostAdInterface;
                this.waterfallCompleted = true;
            }
        } else if (!this.biddingCompleted) {
            this.biddingCycleCompletedAt = System.currentTimeMillis();
            this.biddingCompeteListener = adMostBiddingCompeteListener;
            this.biddingAd = adMostAdInterface;
            this.biddingCompleted = true;
        }
        if (this.biddingCompleted && this.waterfallCompleted && !this.callbacksTriggered) {
            this.callbacksTriggered = true;
            AdMostAdInterface adMostAdInterface2 = this.waterfallAd;
            if (adMostAdInterface2 == null || (this.biddingAd != null && ((double) adMostAdInterface2.getBannerResponseItem().WeightWithoutMultiplier) < ((AdMostBiddingInterface) this.biddingAd).getBiddingPrice())) {
                AdMostAdInterface adMostAdInterface3 = this.biddingAd;
                if (adMostAdInterface3 != null) {
                    this.biddingCompeteListener.onBiddingWins(adMostAdInterface3, this.waterfallAd);
                    AdMostBiddingCompeteListener adMostBiddingCompeteListener2 = this.waterfallCompeteListener;
                    if (adMostBiddingCompeteListener2 != null) {
                        adMostBiddingCompeteListener2.onBiddingWins(this.biddingAd, this.waterfallAd);
                        return;
                    }
                    return;
                }
                returnNoFillToUser();
                return;
            }
            AdMostBiddingCompeteListener adMostBiddingCompeteListener3 = this.biddingCompeteListener;
            if (adMostBiddingCompeteListener3 != null) {
                adMostBiddingCompeteListener3.onWaterfallWins(this.waterfallAd);
            }
            this.waterfallCompeteListener.onWaterfallWins(this.waterfallAd);
        }
    }

    private void startBidRequest(AdMostBannerResponseItem adMostBannerResponseItem, String str) {
        adMostBannerResponseItem.NetworkData = this.customData;
        AdMostLog.m299i("Bidding Request started *** " + adMostBannerResponseItem.Network);
        this.waitingBidResponseCount = this.waitingBidResponseCount + 1;
        final AdMostBannerResponseItem adMostBannerResponseItem2 = adMostBannerResponseItem;
        AdMostBiddingManager.getInstance().bid(adMostBannerResponseItem, this instanceof AdMostInterstitial, new AdMostBiddingEventListener(adMostBannerResponseItem, (long) this.bidTimeout, str) {
            public void onBiddingFail(AdMostBannerResponseItem adMostBannerResponseItem, String str) {
                AdMostLog.m299i("Bidding onBiddingFail *** " + adMostBannerResponseItem.Network + " - " + str);
                AdMostUtil.keepFrequencyCapping("NFFC*" + adMostBannerResponseItem.ZoneId + "*" + adMostBannerResponseItem.PlacementId);
                if (this.waitingResponse) {
                    AdMostBiddingAdItem.access$010(AdMostBiddingAdItem.this);
                }
                super.onBiddingFail(adMostBannerResponseItem, str);
                if (AdMostBiddingAdItem.this.waitingBidResponseCount <= 0) {
                    AdMostBiddingAdItem.this.biddingCompletedForAll();
                }
            }

            public void onBiddingSuccess(AdMostBiddingInterface adMostBiddingInterface) {
                if (this.waitingResponse) {
                    AdMostBiddingAdItem.access$010(AdMostBiddingAdItem.this);
                }
                super.onBiddingSuccess(adMostBiddingInterface);
                AdMostBiddingAdItem.this.biddingResponses.add(adMostBiddingInterface);
                double biddingPrice = adMostBiddingInterface.getBiddingPrice();
                AdMostLog.m299i("Bidding onBiddingSuccess *** " + adMostBannerResponseItem2.Network + " - " + biddingPrice);
                AdMostBiddingAdItem adMostBiddingAdItem = AdMostBiddingAdItem.this;
                if (biddingPrice <= adMostBiddingAdItem.maxBidPrice) {
                    biddingPrice = AdMostBiddingAdItem.this.maxBidPrice;
                }
                double unused = adMostBiddingAdItem.maxBidPrice = biddingPrice;
                if (AdMostBiddingAdItem.this.waitingBidResponseCount <= 0) {
                    AdMostBiddingAdItem.this.biddingCompletedForAll();
                }
            }
        });
    }

    /* access modifiers changed from: package-private */
    public void biddingCycleCompleted(AdMostAdInterface adMostAdInterface, AdMostBiddingCompeteListener adMostBiddingCompeteListener) {
        finishCycleAndCompete(adMostAdInterface, adMostBiddingCompeteListener, false);
    }

    /* access modifiers changed from: package-private */
    public void destroy() {
        this.biddingAd = null;
        this.waterfallAd = null;
        if (this.biddingResponses != null) {
            for (int i = 0; i < this.biddingResponses.size(); i++) {
                destroyBiddingResponseAd(this.biddingResponses.get(i));
            }
            this.biddingResponses = new Vector<>();
        }
    }

    /* access modifiers changed from: package-private */
    public long getBiddingCycleCompletedAt() {
        return this.biddingCycleCompletedAt;
    }

    /* access modifiers changed from: package-private */
    public Hashtable<String, Object> getCustomData() {
        return this.customData;
    }

    /* access modifiers changed from: package-private */
    public Handler getHandler() {
        return this.handler;
    }

    /* access modifiers changed from: package-private */
    public double getMaxBidPrice() {
        return this.maxBidPrice;
    }

    /* access modifiers changed from: package-private */
    public long getWaterfallCycleCompletedAt() {
        return this.waterfallCycleCompletedAt;
    }

    /* access modifiers changed from: package-private */
    public void init() {
        this.waitingBidResponseCount = 0;
        this.biddingCompleted = false;
        this.waterfallCompleted = false;
        this.callbacksTriggered = false;
        this.maxBidPrice = 0.0d;
        this.biddingResponses = new Vector<>();
        this.biddingAd = null;
        this.waterfallAd = null;
    }

    /* access modifiers changed from: package-private */
    public boolean isWaterfallCompleted() {
        return this.waterfallCompleted;
    }

    /* access modifiers changed from: package-private */
    public void loadBiddingAd(AdMostAdInterface adMostAdInterface, AdMostAdInterface adMostAdInterface2) {
    }

    /* access modifiers changed from: package-private */
    public void returnNoFillToUser() {
    }

    /* access modifiers changed from: package-private */
    public void setBiddingCompleted() {
        this.biddingCompleted = true;
    }

    public void setNetworkData(Hashtable<String, Object> hashtable) {
        this.customData = hashtable;
    }

    /* access modifiers changed from: package-private */
    public void startBiddingCycle(String str) {
        ArrayList<AdMostBannerResponseItem> arrayList;
        AdMostBannerResponseBase adMostBannerResponseBase = this.waterfallResponse;
        if (adMostBannerResponseBase == null || (arrayList = adMostBannerResponseBase.BiddingItems) == null || arrayList.size() <= 0) {
            biddingCycleCompleted((AdMostAdInterface) null, (AdMostBiddingCompeteListener) null);
            return;
        }
        AdMostConfiguration configuration = AdMost.getInstance().getConfiguration();
        AdMostBannerResponseBase adMostBannerResponseBase2 = this.waterfallResponse;
        this.bidTimeout = configuration.getBidTimeout(adMostBannerResponseBase2.ZoneId, adMostBannerResponseBase2.IsFirstRequestForZone);
        boolean z = false;
        for (int i = 0; i < this.waterfallResponse.BiddingItems.size(); i++) {
            AdMostBannerResponseItem adMostBannerResponseItem = this.waterfallResponse.BiddingItems.get(i);
            if (adMostBannerResponseItem.IsTestItem || AdMostUtil.checkFrequencyCapping(adMostBannerResponseItem, false)) {
                startBidRequest(adMostBannerResponseItem, str);
                z = true;
            }
        }
        if (!z) {
            biddingCycleCompleted((AdMostAdInterface) null, (AdMostBiddingCompeteListener) null);
        }
    }

    /* access modifiers changed from: package-private */
    public void waterfallCycleCompleted(AdMostAdInterface adMostAdInterface, AdMostBiddingCompeteListener adMostBiddingCompeteListener) {
        finishCycleAndCompete(adMostAdInterface, adMostBiddingCompeteListener, true);
    }
}
