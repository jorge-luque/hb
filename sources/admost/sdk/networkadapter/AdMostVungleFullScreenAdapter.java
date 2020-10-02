package admost.sdk.networkadapter;

import admost.sdk.base.AdMost;
import admost.sdk.base.AdMostAdNetwork;
import admost.sdk.base.AdMostAdNetworkManager;
import admost.sdk.interfaces.AdMostFullScreenInterface;
import admost.sdk.listener.AdMostAdListenerForNetworkAdapter;
import admost.sdk.listener.AdMostInitializationListener;
import admost.sdk.model.AdMostBannerResponseItem;
import com.vungle.warren.AdConfig;
import com.vungle.warren.LoadAdCallback;
import com.vungle.warren.PlayAdCallback;
import com.vungle.warren.Vungle;
import com.vungle.warren.error.VungleException;

public class AdMostVungleFullScreenAdapter extends AdMostFullScreenInterface {
    private boolean waitingResponseFromNetwork;

    public AdMostVungleFullScreenAdapter() {
        this.isSingleton = true;
        this.isSingletonForIntAndRewardedBoth = false;
        this.isSingletonForPlacement = true;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x001e, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void onAdResponse(java.lang.String r2, boolean r3) {
        /*
            r1 = this;
            monitor-enter(r1)
            boolean r0 = r1.waitingResponseFromNetwork     // Catch:{ all -> 0x001f }
            if (r0 != 0) goto L_0x0007
            monitor-exit(r1)
            return
        L_0x0007:
            r0 = 0
            r1.waitingResponseFromNetwork = r0     // Catch:{ all -> 0x001f }
            if (r3 == 0) goto L_0x0016
            boolean r2 = com.vungle.warren.Vungle.canPlayAd((java.lang.String) r2)     // Catch:{ all -> 0x001f }
            if (r2 == 0) goto L_0x0016
            r1.onAmrReady()     // Catch:{ all -> 0x001f }
            goto L_0x001d
        L_0x0016:
            admost.sdk.model.AdMostBannerResponseItem r2 = r1.mBannerResponseItem     // Catch:{ all -> 0x001f }
            java.lang.String r3 = "isLoaded or canPlayAd false"
            r1.onAmrFail(r2, r3)     // Catch:{ all -> 0x001f }
        L_0x001d:
            monitor-exit(r1)
            return
        L_0x001f:
            r2 = move-exception
            monitor-exit(r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: admost.sdk.networkadapter.AdMostVungleFullScreenAdapter.onAdResponse(java.lang.String, boolean):void");
    }

    /* access modifiers changed from: protected */
    public void destroyInterstitial() {
    }

    /* access modifiers changed from: protected */
    public void destroyVideo() {
    }

    /* access modifiers changed from: protected */
    public void loadInterstitial() {
        final String str = this.mBannerResponseItem.AdSpaceId;
        if (!Vungle.isInitialized()) {
            AdMostAdNetworkManager.getInstance().getInitAdapter(AdMostAdNetwork.VUNGLE).setInitListener(new AdMostInitializationListener() {
                public void onError(String str) {
                    AdMostVungleFullScreenAdapter adMostVungleFullScreenAdapter = AdMostVungleFullScreenAdapter.this;
                    AdMostBannerResponseItem adMostBannerResponseItem = adMostVungleFullScreenAdapter.mBannerResponseItem;
                    adMostVungleFullScreenAdapter.onAmrFail(adMostBannerResponseItem, "init listener onError: " + str);
                }

                public void onInitialized() {
                    if (Vungle.isInitialized()) {
                        AdMostVungleFullScreenAdapter.this.loadInterstitial();
                        return;
                    }
                    AdMostVungleFullScreenAdapter adMostVungleFullScreenAdapter = AdMostVungleFullScreenAdapter.this;
                    adMostVungleFullScreenAdapter.onAmrFail(adMostVungleFullScreenAdapter.mBannerResponseItem, "Vungle isInitialized() false");
                }
            });
        } else if (Vungle.canPlayAd(str)) {
            onAmrReady();
        } else {
            this.waitingResponseFromNetwork = true;
            AdMostAdNetworkManager.getInstance().getInitAdapter(AdMostAdNetwork.VUNGLE).setListenerForPlacement(str, new AdMostAdListenerForNetworkAdapter() {
                public void onClicked(String str) {
                }

                public void onComplete(String str) {
                }

                public void onDismiss(String str) {
                }

                public void onFail(int i) {
                }

                public void onFailToShow(int i) {
                }

                public void onReady(String str, int i) {
                    AdMostVungleFullScreenAdapter.this.onAdResponse(str, true);
                }

                public void onShown(String str) {
                }
            });
            Vungle.loadAd(str, new LoadAdCallback() {
                public void onAdLoad(String str) {
                    if (str.equals(str)) {
                        AdMostVungleFullScreenAdapter.this.onAdResponse(str, true);
                    }
                }

                public void onError(String str, VungleException vungleException) {
                    if (str.equals(str)) {
                        AdMostVungleFullScreenAdapter.this.onAdResponse(str, false);
                    }
                }
            });
        }
    }

    /* access modifiers changed from: protected */
    public void loadVideo() {
        loadInterstitial();
    }

    /* access modifiers changed from: protected */
    public void showInterstitial() {
        if (Vungle.canPlayAd(this.mBannerResponseItem.AdSpaceId)) {
            boolean isSoundMuted = AdMost.getInstance().isSoundMuted(AdMostAdNetwork.VUNGLE);
            AdConfig adConfig = new AdConfig();
            adConfig.setMuted(isSoundMuted);
            Vungle.playAd(this.mBannerResponseItem.AdSpaceId, adConfig, new PlayAdCallback() {
                public void onAdClick(String str) {
                    AdMostBannerResponseItem adMostBannerResponseItem = AdMostVungleFullScreenAdapter.this.mBannerResponseItem;
                    if (adMostBannerResponseItem != null && str.equals(adMostBannerResponseItem.AdSpaceId)) {
                        AdMostVungleFullScreenAdapter.this.onAmrClick();
                    }
                }

                public void onAdEnd(String str) {
                    AdMostBannerResponseItem adMostBannerResponseItem = AdMostVungleFullScreenAdapter.this.mBannerResponseItem;
                    if (adMostBannerResponseItem != null && str.equals(adMostBannerResponseItem.AdSpaceId)) {
                        AdMostVungleFullScreenAdapter.this.onAmrDismiss();
                    }
                }

                public void onAdEnd(String str, boolean z, boolean z2) {
                }

                public void onAdLeftApplication(String str) {
                }

                public void onAdRewarded(String str) {
                    AdMostBannerResponseItem adMostBannerResponseItem = AdMostVungleFullScreenAdapter.this.mBannerResponseItem;
                    if (adMostBannerResponseItem != null && str.equals(adMostBannerResponseItem.AdSpaceId)) {
                        AdMostVungleFullScreenAdapter.this.onAmrComplete();
                    }
                }

                public void onAdStart(String str) {
                }

                public void onError(String str, VungleException vungleException) {
                    AdMostBannerResponseItem adMostBannerResponseItem = AdMostVungleFullScreenAdapter.this.mBannerResponseItem;
                    if (adMostBannerResponseItem != null && str.equals(adMostBannerResponseItem.AdSpaceId)) {
                        AdMostVungleFullScreenAdapter adMostVungleFullScreenAdapter = AdMostVungleFullScreenAdapter.this;
                        adMostVungleFullScreenAdapter.onAmrFailToShow(adMostVungleFullScreenAdapter.mBannerResponseItem, vungleException == null ? "" : vungleException.getMessage());
                    }
                }
            });
            return;
        }
        onAmrFailToShow(this.mBannerResponseItem, "canPlayAd false");
    }

    /* access modifiers changed from: protected */
    public void showVideo() {
        showInterstitial();
    }
}
