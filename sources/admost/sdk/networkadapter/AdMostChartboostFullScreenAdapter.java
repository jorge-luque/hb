package admost.sdk.networkadapter;

import admost.sdk.base.AdMostAdNetwork;
import admost.sdk.base.AdMostAdNetworkManager;
import admost.sdk.interfaces.AdMostFullScreenInterface;
import admost.sdk.listener.AdMostAdListenerForNetworkAdapter;
import com.chartboost.sdk.Chartboost;

public class AdMostChartboostFullScreenAdapter extends AdMostFullScreenInterface {
    /* access modifiers changed from: private */
    public boolean waitingResponseFromNetwork = false;

    public AdMostChartboostFullScreenAdapter() {
        this.isSingleton = true;
        this.isSingletonForIntAndRewardedBoth = false;
        this.isSingletonForPlacement = true;
    }

    /* access modifiers changed from: protected */
    public void destroyInterstitial() {
    }

    /* access modifiers changed from: protected */
    public void destroyVideo() {
    }

    /* access modifiers changed from: protected */
    public void loadInterstitial() {
        String str = this.mBannerResponseItem.AdSpaceId;
        AdMostAdNetworkManager.getInstance().getInitAdapter(AdMostAdNetwork.CHARTBOOST).setListenerForPlacement(str, new AdMostAdListenerForNetworkAdapter() {
            public void onClicked(String str) {
                AdMostChartboostFullScreenAdapter.this.onAmrClick();
            }

            public void onComplete(String str) {
                AdMostChartboostFullScreenAdapter.this.onAmrComplete();
            }

            public void onDismiss(String str) {
                AdMostChartboostFullScreenAdapter.this.onAmrDismiss();
            }

            public void onFail(int i) {
                if (AdMostChartboostFullScreenAdapter.this.waitingResponseFromNetwork) {
                    boolean unused = AdMostChartboostFullScreenAdapter.this.waitingResponseFromNetwork = false;
                    AdMostChartboostFullScreenAdapter adMostChartboostFullScreenAdapter = AdMostChartboostFullScreenAdapter.this;
                    adMostChartboostFullScreenAdapter.onAmrFail(adMostChartboostFullScreenAdapter.mBannerResponseItem, i, "onFail");
                }
            }

            public void onFailToShow(int i) {
            }

            public void onReady(String str, int i) {
                if (AdMostChartboostFullScreenAdapter.this.waitingResponseFromNetwork) {
                    boolean unused = AdMostChartboostFullScreenAdapter.this.waitingResponseFromNetwork = false;
                    AdMostChartboostFullScreenAdapter.this.onAmrReady();
                }
            }

            public void onShown(String str) {
            }
        });
        if ((!this.mBannerResponseItem.Type.equals("video") || !Chartboost.hasRewardedVideo(str)) && (!this.mBannerResponseItem.Type.equals("banner") || !Chartboost.hasInterstitial(str))) {
            if (((AdMostChartboostInitAdapter) AdMostAdNetworkManager.getInstance().getInitAdapter(AdMostAdNetwork.CHARTBOOST)).isLocationCallable(str)) {
                this.waitingResponseFromNetwork = true;
            } else {
                onAmrFail(this.mBannerResponseItem, "location is not callable");
            }
            if (this.mBannerResponseItem.Type.equals("video")) {
                Chartboost.cacheRewardedVideo(this.mBannerResponseItem.AdSpaceId);
            } else {
                Chartboost.cacheInterstitial(this.mBannerResponseItem.AdSpaceId);
            }
        } else {
            onAmrReady();
        }
    }

    /* access modifiers changed from: protected */
    public void loadVideo() {
        loadInterstitial();
    }

    /* access modifiers changed from: protected */
    public void showInterstitial() {
        if (Chartboost.hasInterstitial(this.mBannerResponseItem.AdSpaceId)) {
            Chartboost.showInterstitial(this.mBannerResponseItem.AdSpaceId);
        } else {
            onAmrFailToShow(this.mBannerResponseItem, "hasInterstitial() false");
        }
    }

    /* access modifiers changed from: protected */
    public void showVideo() {
        if (Chartboost.hasRewardedVideo(this.mBannerResponseItem.AdSpaceId)) {
            Chartboost.showRewardedVideo(this.mBannerResponseItem.AdSpaceId);
        } else {
            onAmrFailToShow(this.mBannerResponseItem, "hasRewardedVideo false");
        }
    }
}
