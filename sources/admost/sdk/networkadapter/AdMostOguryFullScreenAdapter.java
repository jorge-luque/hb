package admost.sdk.networkadapter;

import admost.sdk.base.AdMost;
import admost.sdk.interfaces.AdMostFullScreenInterface;
import p118io.presage.common.AdConfig;
import p118io.presage.common.network.models.RewardItem;
import p118io.presage.interstitial.PresageInterstitial;
import p118io.presage.interstitial.PresageInterstitialCallback;
import p118io.presage.interstitial.optinvideo.PresageOptinVideo;
import p118io.presage.interstitial.optinvideo.PresageOptinVideoCallback;

public class AdMostOguryFullScreenAdapter extends AdMostFullScreenInterface {
    public void loadInterstitial() {
        final PresageInterstitial presageInterstitial = new PresageInterstitial(AdMost.getInstance().getActivity(), new AdConfig(this.mBannerResponseItem.AdSpaceId));
        presageInterstitial.setInterstitialCallback(new PresageInterstitialCallback() {
            public void onAdAvailable() {
            }

            public void onAdClosed() {
                AdMostOguryFullScreenAdapter.this.onAmrDismiss();
            }

            public void onAdDisplayed() {
            }

            public void onAdError(int i) {
                AdMostOguryFullScreenAdapter adMostOguryFullScreenAdapter = AdMostOguryFullScreenAdapter.this;
                adMostOguryFullScreenAdapter.onAmrFail(adMostOguryFullScreenAdapter.mBannerResponseItem, i, "onAdError");
            }

            public void onAdLoaded() {
                AdMostOguryFullScreenAdapter adMostOguryFullScreenAdapter = AdMostOguryFullScreenAdapter.this;
                adMostOguryFullScreenAdapter.mAd1 = presageInterstitial;
                adMostOguryFullScreenAdapter.onAmrReady();
            }

            public void onAdNotAvailable() {
                AdMostOguryFullScreenAdapter adMostOguryFullScreenAdapter = AdMostOguryFullScreenAdapter.this;
                adMostOguryFullScreenAdapter.onAmrFail(adMostOguryFullScreenAdapter.mBannerResponseItem, "onAdNotAvailable");
            }

            public void onAdNotLoaded() {
                AdMostOguryFullScreenAdapter adMostOguryFullScreenAdapter = AdMostOguryFullScreenAdapter.this;
                adMostOguryFullScreenAdapter.onAmrFail(adMostOguryFullScreenAdapter.mBannerResponseItem, "onAdNotLoaded");
            }
        });
        presageInterstitial.load();
    }

    public void loadVideo() {
        final PresageOptinVideo presageOptinVideo = new PresageOptinVideo(AdMost.getInstance().getActivity(), new AdConfig(this.mBannerResponseItem.AdSpaceId));
        presageOptinVideo.setOptinVideoCallback(new PresageOptinVideoCallback() {
            public void onAdAvailable() {
            }

            public void onAdClosed() {
                AdMostOguryFullScreenAdapter.this.onAmrDismiss();
            }

            public void onAdDisplayed() {
            }

            public void onAdError(int i) {
                AdMostOguryFullScreenAdapter adMostOguryFullScreenAdapter = AdMostOguryFullScreenAdapter.this;
                adMostOguryFullScreenAdapter.onAmrFail(adMostOguryFullScreenAdapter.mBannerResponseItem, i, "onAdError");
            }

            public void onAdLoaded() {
                AdMostOguryFullScreenAdapter adMostOguryFullScreenAdapter = AdMostOguryFullScreenAdapter.this;
                adMostOguryFullScreenAdapter.mAd1 = presageOptinVideo;
                adMostOguryFullScreenAdapter.onAmrReady();
            }

            public void onAdNotAvailable() {
                AdMostOguryFullScreenAdapter adMostOguryFullScreenAdapter = AdMostOguryFullScreenAdapter.this;
                adMostOguryFullScreenAdapter.onAmrFail(adMostOguryFullScreenAdapter.mBannerResponseItem, "onAdNotAvailable");
            }

            public void onAdNotLoaded() {
            }

            public void onAdRewarded(RewardItem rewardItem) {
                AdMostOguryFullScreenAdapter.this.onAmrComplete();
            }
        });
        presageOptinVideo.load();
    }

    public void showInterstitial() {
        ((PresageInterstitial) this.mAd1).show();
    }

    public void showVideo() {
        Object obj = this.mAd1;
        if (obj == null) {
            onAmrFailToShow(this.mBannerResponseItem, "mAd1 null");
        } else {
            ((PresageOptinVideo) obj).show();
        }
    }
}
