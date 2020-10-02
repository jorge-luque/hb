package admost.sdk.networkadapter;

import admost.sdk.base.AdMost;
import admost.sdk.base.AdMostLog;
import admost.sdk.interfaces.AdMostBiddingInterface;
import admost.sdk.interfaces.AdMostFullScreenInterface;
import admost.sdk.listener.AdMostBiddingListener;
import admost.sdk.model.AdMostBannerResponseItem;
import admost.sdk.networkadapter.AdMostFacebookBiddingManager;
import android.os.Handler;
import android.os.Looper;
import com.facebook.ads.AdError;
import com.facebook.ads.C2630Ad;
import com.facebook.ads.InterstitialAd;
import com.facebook.ads.InterstitialAdListener;
import com.facebook.ads.RewardData;
import com.facebook.ads.RewardedVideoAd;
import com.facebook.ads.RewardedVideoAdListener;

public class AdMostFacebookFullScreenAdapter extends AdMostFullScreenInterface implements AdMostBiddingInterface {
    private String auctionId;
    /* access modifiers changed from: private */
    public AdMostFacebookBiddingManager.AdMostFacebookBiddingRequestResponse.AdMostFacebookBid biddingResponse;
    /* access modifiers changed from: private */
    public boolean showStarted;
    /* access modifiers changed from: private */
    public boolean videoCompleted;

    public AdMostFacebookFullScreenAdapter() {
        this.isSingleton = false;
        this.isSingletonForIntAndRewardedBoth = false;
    }

    public void bid(final AdMostBiddingListener adMostBiddingListener) {
        if (!AdMostFacebookBiddingManager.getInstance().initCompleted) {
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                public void run() {
                    AdMostFacebookFullScreenAdapter.this.bid(adMostBiddingListener);
                }
            }, 100);
        } else {
            this.auctionId = AdMostFacebookBiddingManager.getInstance().bid(this.mBannerResponseItem, new AdMostFacebookBiddingManager.AdMostFacebookBiddingListener() {
                public void onFail(AdMostFacebookBiddingManager.AdMostFacebookBiddingError adMostFacebookBiddingError) {
                    adMostBiddingListener.onFail(adMostFacebookBiddingError.message);
                }

                public void onSuccess(AdMostFacebookBiddingManager.AdMostFacebookBiddingRequestResponse.AdMostFacebookBid adMostFacebookBid) {
                    AdMostFacebookBiddingManager.AdMostFacebookBiddingRequestResponse.AdMostFacebookBid unused = AdMostFacebookFullScreenAdapter.this.biddingResponse = adMostFacebookBid;
                    adMostBiddingListener.onSuccess(AdMostFacebookFullScreenAdapter.this.getBiddingPrice());
                }
            }, false);
        }
    }

    /* access modifiers changed from: protected */
    public void destroyInterstitial() {
        Object obj = this.mAd1;
        if (obj != null) {
            ((InterstitialAd) obj).destroy();
        }
    }

    /* access modifiers changed from: protected */
    public void destroyVideo() {
        Object obj = this.mAd1;
        if (obj != null) {
            ((RewardedVideoAd) obj).destroy();
        }
    }

    public double getBiddingPrice() {
        AdMostFacebookBiddingManager.AdMostFacebookBiddingRequestResponse.AdMostFacebookBid adMostFacebookBid = this.biddingResponse;
        if (adMostFacebookBid == null) {
            return 0.0d;
        }
        double d = adMostFacebookBid.price;
        AdMostBannerResponseItem adMostBannerResponseItem = this.mBannerResponseItem;
        return d * (adMostBannerResponseItem == null ? 100.0d : adMostBannerResponseItem.BidScore);
    }

    /* access modifiers changed from: protected */
    public void loadInterstitial() {
        final InterstitialAd interstitialAd = new InterstitialAd(AdMost.getInstance().getContext(), this.mBannerResponseItem.AdSpaceId);
        interstitialAd.setAdListener(new InterstitialAdListener() {
            public void onAdClicked(C2630Ad ad) {
                AdMostFacebookFullScreenAdapter.this.onAmrClick();
            }

            public void onAdLoaded(C2630Ad ad) {
                AdMostFacebookFullScreenAdapter adMostFacebookFullScreenAdapter = AdMostFacebookFullScreenAdapter.this;
                adMostFacebookFullScreenAdapter.mAd1 = interstitialAd;
                adMostFacebookFullScreenAdapter.onAmrReady();
            }

            public void onError(C2630Ad ad, AdError adError) {
                StringBuilder sb = new StringBuilder();
                sb.append("AdMostFacebookFullScreenAdapter onError : ");
                sb.append(adError != null ? adError.getErrorMessage() : "null err");
                AdMostLog.m296e(sb.toString());
                try {
                    interstitialAd.destroy();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                AdMostFacebookFullScreenAdapter adMostFacebookFullScreenAdapter = AdMostFacebookFullScreenAdapter.this;
                adMostFacebookFullScreenAdapter.onAmrFail(adMostFacebookFullScreenAdapter.mBannerResponseItem, adError == null ? -1 : adError.getErrorCode(), adError == null ? "" : adError.getErrorMessage());
            }

            public void onInterstitialDismissed(C2630Ad ad) {
                AdMostFacebookFullScreenAdapter.this.onAmrDismiss();
            }

            public void onInterstitialDisplayed(C2630Ad ad) {
            }

            public void onLoggingImpression(C2630Ad ad) {
            }
        });
        AdMostFacebookBiddingManager.AdMostFacebookBiddingRequestResponse.AdMostFacebookBid adMostFacebookBid = this.biddingResponse;
        if (adMostFacebookBid != null) {
            interstitialAd.loadAdFromBid(adMostFacebookBid.adm);
        } else {
            interstitialAd.loadAd();
        }
    }

    /* access modifiers changed from: protected */
    public void loadVideo() {
        final RewardedVideoAd rewardedVideoAd = new RewardedVideoAd(AdMost.getInstance().getContext(), this.mBannerResponseItem.AdSpaceId);
        String userId = AdMostFacebookInitAdapter.getUserId();
        if (userId != null && !userId.equals("")) {
            rewardedVideoAd.setRewardData(new RewardData(userId, "1"));
        }
        rewardedVideoAd.setAdListener(new RewardedVideoAdListener() {
            public void onAdClicked(C2630Ad ad) {
                AdMostFacebookFullScreenAdapter.this.onAmrClick();
            }

            public void onAdLoaded(C2630Ad ad) {
                AdMostFacebookFullScreenAdapter adMostFacebookFullScreenAdapter = AdMostFacebookFullScreenAdapter.this;
                adMostFacebookFullScreenAdapter.mAd1 = ad;
                adMostFacebookFullScreenAdapter.onAmrReady();
            }

            public void onError(C2630Ad ad, AdError adError) {
                try {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Facebook video Error : ");
                    sb.append(adError != null ? adError.getErrorMessage() : "facebook err");
                    AdMostLog.m296e(sb.toString());
                    rewardedVideoAd.destroy();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (!AdMostFacebookFullScreenAdapter.this.videoCompleted) {
                    String str = "";
                    int i = -1;
                    if (AdMostFacebookFullScreenAdapter.this.showStarted) {
                        AdMostFacebookFullScreenAdapter adMostFacebookFullScreenAdapter = AdMostFacebookFullScreenAdapter.this;
                        AdMostBannerResponseItem adMostBannerResponseItem = adMostFacebookFullScreenAdapter.mBannerResponseItem;
                        if (adError != null) {
                            i = adError.getErrorCode();
                        }
                        if (adError != null) {
                            str = adError.getErrorMessage();
                        }
                        adMostFacebookFullScreenAdapter.onAmrFailToShow(adMostBannerResponseItem, i, str);
                        return;
                    }
                    AdMostFacebookFullScreenAdapter adMostFacebookFullScreenAdapter2 = AdMostFacebookFullScreenAdapter.this;
                    AdMostBannerResponseItem adMostBannerResponseItem2 = adMostFacebookFullScreenAdapter2.mBannerResponseItem;
                    if (adError != null) {
                        i = adError.getErrorCode();
                    }
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("onError: ");
                    if (adError != null) {
                        str = adError.getErrorMessage();
                    }
                    sb2.append(str);
                    adMostFacebookFullScreenAdapter2.onAmrFail(adMostBannerResponseItem2, i, sb2.toString());
                }
            }

            public void onLoggingImpression(C2630Ad ad) {
            }

            public void onRewardedVideoClosed() {
                AdMostFacebookFullScreenAdapter.this.onAmrDismiss();
            }

            public void onRewardedVideoCompleted() {
                boolean unused = AdMostFacebookFullScreenAdapter.this.videoCompleted = true;
                AdMostFacebookFullScreenAdapter.this.onAmrComplete();
            }
        });
        AdMostFacebookBiddingManager.AdMostFacebookBiddingRequestResponse.AdMostFacebookBid adMostFacebookBid = this.biddingResponse;
        if (adMostFacebookBid != null) {
            rewardedVideoAd.loadAdFromBid(adMostFacebookBid.adm);
        } else {
            rewardedVideoAd.loadAd();
        }
    }

    public void sendLossNotice(double d, int i) {
        AdMostFacebookBiddingManager.AdMostFacebookBiddingRequestResponse.AdMostFacebookBid adMostFacebookBid = this.biddingResponse;
        if (adMostFacebookBid != null) {
            adMostFacebookBid.sendLossNotice(d, i);
        } else {
            AdMostFacebookBiddingManager.getInstance().sendLossNotice((AdMostFacebookBiddingManager.AdMostFacebookBiddingRequestResponse.AdMostFacebookBid) null, this.auctionId, i, d);
        }
    }

    public void sendWinNotice(double d) {
        AdMostFacebookBiddingManager.AdMostFacebookBiddingRequestResponse.AdMostFacebookBid adMostFacebookBid = this.biddingResponse;
        if (adMostFacebookBid != null) {
            adMostFacebookBid.sendWinNotice(d);
        }
    }

    /* access modifiers changed from: protected */
    public void showInterstitial() {
        InterstitialAd interstitialAd = (InterstitialAd) this.mAd1;
        if (interstitialAd == null || !interstitialAd.isAdLoaded() || interstitialAd.isAdInvalidated()) {
            onAmrFailToShow(this.mBannerResponseItem, "isAdLoaded() false or isAdInvalidated()");
            return;
        }
        this.showStarted = true;
        interstitialAd.show();
    }

    /* access modifiers changed from: protected */
    public void showVideo() {
        RewardedVideoAd rewardedVideoAd = (RewardedVideoAd) this.mAd1;
        if (rewardedVideoAd == null || !rewardedVideoAd.isAdLoaded() || rewardedVideoAd.isAdInvalidated()) {
            onAmrFailToShow(this.mBannerResponseItem, "isAdLoaded() false or isAdInvalidated()");
            return;
        }
        this.showStarted = true;
        rewardedVideoAd.show();
    }
}
