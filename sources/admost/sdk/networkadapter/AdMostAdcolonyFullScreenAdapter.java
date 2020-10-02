package admost.sdk.networkadapter;

import admost.sdk.base.AdMost;
import admost.sdk.base.AdMostAdNetwork;
import admost.sdk.base.AdMostAdNetworkManager;
import admost.sdk.interfaces.AdMostBiddingInterface;
import admost.sdk.interfaces.AdMostFullScreenInterface;
import admost.sdk.listener.AdMostBiddingListener;
import admost.sdk.listener.AdMostInitializationListener;
import admost.sdk.model.AdMostBannerResponseItem;
import admost.sdk.networkadapter.AdMostAdcolonyBiddingManager;
import com.adcolony.sdk.AdColony;
import com.adcolony.sdk.AdColonyAdOptions;
import com.adcolony.sdk.AdColonyInterstitial;
import com.adcolony.sdk.AdColonyInterstitialListener;
import com.adcolony.sdk.AdColonyReward;
import com.adcolony.sdk.AdColonyRewardListener;
import com.adcolony.sdk.AdColonyUserMetadata;
import com.adcolony.sdk.AdColonyZone;

public class AdMostAdcolonyFullScreenAdapter extends AdMostFullScreenInterface implements AdMostBiddingInterface {
    private String auctionId;
    /* access modifiers changed from: private */
    public AdMostAdcolonyBiddingManager.AdMostAdcolonyBiddingRequestResponse.AdMostAdcolonyBid biddingResponse;
    private double clearingPriceForLossNotice;
    /* access modifiers changed from: private */
    public boolean expired;
    private AdColonyAdOptions options;
    private int reasonForLossNotice;
    private boolean waitingResponseForLossNotice;

    public AdMostAdcolonyFullScreenAdapter() {
        this.isSingleton = true;
        this.isSingletonForIntAndRewardedBoth = false;
        AdColonyUserMetadata adColonyUserMetadata = new AdColonyUserMetadata();
        if (AdMost.getInstance().getInterests() != null) {
            adColonyUserMetadata.addUserInterest(AdMost.getInstance().getInterests());
        }
        if (AdMost.getInstance().getAge() > 0) {
            adColonyUserMetadata.setUserAge(AdMost.getInstance().getAge());
        }
        int gender = AdMost.getInstance().getGender();
        if (gender == 0) {
            adColonyUserMetadata.setUserGender(AdColonyUserMetadata.USER_MALE);
        } else if (gender == 1) {
            adColonyUserMetadata.setUserGender(AdColonyUserMetadata.USER_FEMALE);
        }
        this.options = new AdColonyAdOptions().setUserMetadata(adColonyUserMetadata);
    }

    /* access modifiers changed from: private */
    public void sendWaitingLossNotice() {
        if (this.waitingResponseForLossNotice && this.biddingResponse != null && this.reasonForLossNotice > 0) {
            this.waitingResponseForLossNotice = false;
            AdMostAdcolonyBiddingManager.getInstance().sendLossNotice(this.biddingResponse, this.auctionId, this.reasonForLossNotice, this.clearingPriceForLossNotice);
        }
    }

    public void bid(final AdMostBiddingListener adMostBiddingListener) {
        if (!AdMostAdNetworkManager.getInstance().getInitAdapter(AdMostAdNetwork.ADCOLONY).isInitAdNetworkCompletedSuccessfully) {
            AdMostAdNetworkManager.getInstance().getInitAdapter(AdMostAdNetwork.ADCOLONY).setInitListener(new AdMostInitializationListener() {
                public void onError(String str) {
                    AdMostAdcolonyFullScreenAdapter adMostAdcolonyFullScreenAdapter = AdMostAdcolonyFullScreenAdapter.this;
                    AdMostBannerResponseItem adMostBannerResponseItem = adMostAdcolonyFullScreenAdapter.mBannerResponseItem;
                    adMostAdcolonyFullScreenAdapter.onAmrFail(adMostBannerResponseItem, "onError: " + str);
                }

                public void onInitialized() {
                    AdMostAdcolonyFullScreenAdapter.this.bid(adMostBiddingListener);
                }
            });
        } else {
            this.auctionId = AdMostAdcolonyBiddingManager.getInstance().bid(this.mBannerResponseItem, new AdMostAdcolonyBiddingManager.AdMostAdcolonyBiddingListener() {
                public void onFail(AdMostAdcolonyBiddingManager.AdMostAdcolonyBiddingError adMostAdcolonyBiddingError) {
                    adMostBiddingListener.onFail(adMostAdcolonyBiddingError.message);
                }

                public void onSuccess(AdMostAdcolonyBiddingManager.AdMostAdcolonyBiddingRequestResponse.AdMostAdcolonyBid adMostAdcolonyBid) {
                    AdMostAdcolonyBiddingManager.AdMostAdcolonyBiddingRequestResponse.AdMostAdcolonyBid unused = AdMostAdcolonyFullScreenAdapter.this.biddingResponse = adMostAdcolonyBid;
                    AdMostAdcolonyFullScreenAdapter.this.sendWaitingLossNotice();
                    adMostBiddingListener.onSuccess(AdMostAdcolonyFullScreenAdapter.this.getBiddingPrice());
                }
            }, false);
        }
    }

    public double getBiddingPrice() {
        AdMostAdcolonyBiddingManager.AdMostAdcolonyBiddingRequestResponse.AdMostAdcolonyBid adMostAdcolonyBid = this.biddingResponse;
        if (adMostAdcolonyBid == null) {
            return 0.0d;
        }
        double d = adMostAdcolonyBid.price;
        AdMostBannerResponseItem adMostBannerResponseItem = this.mBannerResponseItem;
        return d * (adMostBannerResponseItem == null ? 100.0d : adMostBannerResponseItem.BidScore);
    }

    public void loadInterstitial() {
        if (!AdMostAdNetworkManager.getInstance().getInitAdapter(AdMostAdNetwork.ADCOLONY).isInitAdNetworkCompletedSuccessfully) {
            AdMostAdNetworkManager.getInstance().getInitAdapter(AdMostAdNetwork.ADCOLONY).setInitListener(new AdMostInitializationListener() {
                public void onError(String str) {
                    AdMostAdcolonyFullScreenAdapter adMostAdcolonyFullScreenAdapter = AdMostAdcolonyFullScreenAdapter.this;
                    AdMostBannerResponseItem adMostBannerResponseItem = adMostAdcolonyFullScreenAdapter.mBannerResponseItem;
                    adMostAdcolonyFullScreenAdapter.onAmrFail(adMostBannerResponseItem, "onError: " + str);
                }

                public void onInitialized() {
                    AdMostAdcolonyFullScreenAdapter.this.loadInterstitial();
                }
            });
            return;
        }
        String str = this.mBannerResponseItem.AdSpaceId;
        C02512 r1 = new AdColonyInterstitialListener() {
            public void onClicked(AdColonyInterstitial adColonyInterstitial) {
                AdMostAdcolonyFullScreenAdapter.this.onAmrClick();
            }

            public void onClosed(AdColonyInterstitial adColonyInterstitial) {
                AdMostAdcolonyFullScreenAdapter.this.onAmrDismiss();
            }

            public void onExpiring(AdColonyInterstitial adColonyInterstitial) {
                boolean unused = AdMostAdcolonyFullScreenAdapter.this.expired = true;
            }

            public void onOpened(AdColonyInterstitial adColonyInterstitial) {
            }

            public void onRequestFilled(AdColonyInterstitial adColonyInterstitial) {
                AdMostAdcolonyFullScreenAdapter adMostAdcolonyFullScreenAdapter = AdMostAdcolonyFullScreenAdapter.this;
                adMostAdcolonyFullScreenAdapter.mAd1 = adColonyInterstitial;
                adMostAdcolonyFullScreenAdapter.onAmrReady();
            }

            public void onRequestNotFilled(AdColonyZone adColonyZone) {
                AdMostAdcolonyFullScreenAdapter adMostAdcolonyFullScreenAdapter = AdMostAdcolonyFullScreenAdapter.this;
                adMostAdcolonyFullScreenAdapter.onAmrFail(adMostAdcolonyFullScreenAdapter.mBannerResponseItem, "onRequestNotFilled");
            }
        };
        if (this.mBannerResponseItem.Type.equals("video")) {
            AdColony.setRewardListener(new AdColonyRewardListener() {
                public void onReward(AdColonyReward adColonyReward) {
                    AdMostAdcolonyFullScreenAdapter.this.onAmrComplete();
                }
            });
        }
        if (!AdColony.requestInterstitial(str, r1, this.options)) {
            onAmrFail(this.mBannerResponseItem, "adcolonyResponse false");
        }
    }

    public void loadVideo() {
        loadInterstitial();
    }

    public void sendLossNotice(double d, int i) {
        AdMostAdcolonyBiddingManager.AdMostAdcolonyBiddingRequestResponse.AdMostAdcolonyBid adMostAdcolonyBid = this.biddingResponse;
        if (adMostAdcolonyBid != null) {
            adMostAdcolonyBid.sendLossNotice(d, i);
            return;
        }
        this.waitingResponseForLossNotice = true;
        this.reasonForLossNotice = i;
        this.clearingPriceForLossNotice = d;
    }

    public void sendWinNotice(double d) {
        AdMostAdcolonyBiddingManager.AdMostAdcolonyBiddingRequestResponse.AdMostAdcolonyBid adMostAdcolonyBid = this.biddingResponse;
        if (adMostAdcolonyBid != null) {
            adMostAdcolonyBid.sendWinNotice(d);
        }
    }

    public void showInterstitial() {
        if (this.expired || ((AdColonyInterstitial) this.mAd1).isExpired()) {
            onAmrFailToShow(this.mBannerResponseItem, "ad is expired");
        } else {
            ((AdColonyInterstitial) this.mAd1).show();
        }
    }

    public void showVideo() {
        showInterstitial();
    }
}
