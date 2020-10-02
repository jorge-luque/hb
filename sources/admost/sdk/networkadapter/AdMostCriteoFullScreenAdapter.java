package admost.sdk.networkadapter;

import admost.sdk.base.AdMost;
import admost.sdk.base.AdMostAdNetwork;
import admost.sdk.base.AdMostAdNetworkManager;
import admost.sdk.interfaces.AdMostBiddingInterface;
import admost.sdk.interfaces.AdMostFullScreenInterface;
import admost.sdk.listener.AdMostBiddingListener;
import admost.sdk.listener.AdMostInitializationListener;
import admost.sdk.model.AdMostBannerResponseItem;
import com.criteo.publisher.BidResponse;
import com.criteo.publisher.Criteo;
import com.criteo.publisher.CriteoErrorCode;
import com.criteo.publisher.CriteoInterstitial;
import com.criteo.publisher.CriteoInterstitialAdListener;
import com.criteo.publisher.model.InterstitialAdUnit;

public class AdMostCriteoFullScreenAdapter extends AdMostFullScreenInterface implements AdMostBiddingInterface {
    private BidResponse bidResponse;
    private InterstitialAdUnit interstitialAdUnit;
    boolean requestDone;

    public void bid(final AdMostBiddingListener adMostBiddingListener) {
        if (!AdMostAdNetworkManager.getInstance().getInitAdapter(AdMostAdNetwork.CRITEO).isInitAdNetworkCompletedSuccessfully) {
            AdMostAdNetworkManager.getInstance().getInitAdapter(AdMostAdNetwork.CRITEO).setInitListener(new AdMostInitializationListener() {
                public void onError(String str) {
                    AdMostCriteoFullScreenAdapter adMostCriteoFullScreenAdapter = AdMostCriteoFullScreenAdapter.this;
                    AdMostBannerResponseItem adMostBannerResponseItem = adMostCriteoFullScreenAdapter.mBannerResponseItem;
                    adMostCriteoFullScreenAdapter.onAmrFail(adMostBannerResponseItem, "onError: " + str);
                }

                public void onInitialized() {
                    AdMostCriteoFullScreenAdapter.this.bid(adMostBiddingListener);
                }
            });
            return;
        }
        if (this.interstitialAdUnit == null) {
            this.interstitialAdUnit = new InterstitialAdUnit(this.mBannerResponseItem.AdSpaceId);
        }
        BidResponse bidResponse2 = Criteo.getInstance().getBidResponse(this.interstitialAdUnit);
        this.bidResponse = bidResponse2;
        if (bidResponse2 == null || !bidResponse2.isBidSuccess()) {
            adMostBiddingListener.onFail("bid failed");
        } else {
            adMostBiddingListener.onSuccess(getBiddingPrice());
        }
    }

    /* access modifiers changed from: protected */
    public void destroyInterstitial() {
        this.interstitialAdUnit = null;
        this.bidResponse = null;
    }

    public double getBiddingPrice() {
        BidResponse bidResponse2 = this.bidResponse;
        if (bidResponse2 == null || !bidResponse2.isBidSuccess()) {
            return 0.0d;
        }
        double price = this.bidResponse.getPrice();
        AdMostBannerResponseItem adMostBannerResponseItem = this.mBannerResponseItem;
        return price * (adMostBannerResponseItem == null ? 100.0d : adMostBannerResponseItem.BidScore);
    }

    public void loadInterstitial() {
        if (!AdMostAdNetworkManager.getInstance().getInitAdapter(AdMostAdNetwork.CRITEO).isInitAdNetworkCompletedSuccessfully) {
            AdMostAdNetworkManager.getInstance().getInitAdapter(AdMostAdNetwork.CRITEO).setInitListener(new AdMostInitializationListener() {
                public void onError(String str) {
                    AdMostCriteoFullScreenAdapter adMostCriteoFullScreenAdapter = AdMostCriteoFullScreenAdapter.this;
                    AdMostBannerResponseItem adMostBannerResponseItem = adMostCriteoFullScreenAdapter.mBannerResponseItem;
                    adMostCriteoFullScreenAdapter.onAmrFail(adMostBannerResponseItem, "onError: " + str);
                }

                public void onInitialized() {
                    AdMostCriteoFullScreenAdapter.this.loadInterstitial();
                }
            });
            return;
        }
        if (this.interstitialAdUnit == null) {
            this.interstitialAdUnit = new InterstitialAdUnit(this.mBannerResponseItem.AdSpaceId);
        }
        final CriteoInterstitial criteoInterstitial = new CriteoInterstitial(AdMost.getInstance().getContext(), this.interstitialAdUnit);
        criteoInterstitial.setCriteoInterstitialAdListener(new CriteoInterstitialAdListener() {
            public void onAdClicked() {
                AdMostCriteoFullScreenAdapter.this.onAmrClick();
            }

            public void onAdClosed() {
                AdMostCriteoFullScreenAdapter.this.onAmrDismiss();
            }

            public void onAdFailedToReceive(CriteoErrorCode criteoErrorCode) {
                AdMostCriteoFullScreenAdapter adMostCriteoFullScreenAdapter = AdMostCriteoFullScreenAdapter.this;
                if (!adMostCriteoFullScreenAdapter.requestDone) {
                    adMostCriteoFullScreenAdapter.requestDone = true;
                    AdMostBannerResponseItem adMostBannerResponseItem = adMostCriteoFullScreenAdapter.mBannerResponseItem;
                    StringBuilder sb = new StringBuilder();
                    sb.append("onAdFailedToReceive: ");
                    sb.append(criteoErrorCode == null ? "" : criteoErrorCode.name());
                    adMostCriteoFullScreenAdapter.onAmrFail(adMostBannerResponseItem, sb.toString());
                }
            }

            public void onAdLeftApplication() {
            }

            public void onAdOpened() {
            }

            public void onAdReceived() {
                AdMostCriteoFullScreenAdapter adMostCriteoFullScreenAdapter = AdMostCriteoFullScreenAdapter.this;
                if (!adMostCriteoFullScreenAdapter.requestDone) {
                    adMostCriteoFullScreenAdapter.requestDone = true;
                    adMostCriteoFullScreenAdapter.mAd1 = criteoInterstitial;
                    adMostCriteoFullScreenAdapter.onAmrReady();
                }
            }
        });
        BidResponse bidResponse2 = this.bidResponse;
        if (bidResponse2 == null || !bidResponse2.isBidSuccess()) {
            criteoInterstitial.loadAd();
        } else {
            criteoInterstitial.loadAd(this.bidResponse.getBidToken());
        }
    }

    public void sendLossNotice(double d, int i) {
    }

    public void sendWinNotice(double d) {
    }

    public void showInterstitial() {
        Object obj = this.mAd1;
        if (((CriteoInterstitial) obj) == null || !((CriteoInterstitial) obj).isAdLoaded()) {
            onAmrFailToShow(this.mBannerResponseItem, "criteo fail to show not loaded");
        } else {
            ((CriteoInterstitial) this.mAd1).show();
        }
    }
}
