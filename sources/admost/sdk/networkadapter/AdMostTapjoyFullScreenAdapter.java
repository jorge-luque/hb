package admost.sdk.networkadapter;

import admost.sdk.base.AdMost;
import admost.sdk.base.AdMostAdNetwork;
import admost.sdk.base.AdMostAdNetworkManager;
import admost.sdk.interfaces.AdMostFullScreenInterface;
import admost.sdk.listener.AdMostInitializationListener;
import admost.sdk.model.AdMostBannerResponseItem;
import android.os.Handler;
import android.os.Looper;
import com.tapjoy.TJActionRequest;
import com.tapjoy.TJError;
import com.tapjoy.TJPlacement;
import com.tapjoy.TJPlacementListener;
import com.tapjoy.TJPlacementVideoListener;
import com.tapjoy.Tapjoy;

public class AdMostTapjoyFullScreenAdapter extends AdMostFullScreenInterface {
    /* access modifiers changed from: private */
    public boolean isAdLoaded;
    /* access modifiers changed from: private */
    public boolean waitingResponse;

    public AdMostTapjoyFullScreenAdapter() {
        this.isSingleton = true;
        this.isSingletonForIntAndRewardedBoth = false;
    }

    /* access modifiers changed from: protected */
    public void loadInterstitial() {
        loadVideo();
    }

    /* access modifiers changed from: protected */
    public void loadOfferwall() {
        loadVideo();
    }

    public void loadVideo() {
        String str = this.mBannerResponseItem.AdSpaceId;
        if (Tapjoy.isConnected() && AdMostAdNetworkManager.getInstance().getInitAdapter(AdMostAdNetwork.TAPJOY).isInitialized) {
            C03231 r0 = new TJPlacementListener() {
                public void onClick(TJPlacement tJPlacement) {
                    AdMostTapjoyFullScreenAdapter.this.onAmrClick();
                }

                public void onContentDismiss(TJPlacement tJPlacement) {
                    AdMostTapjoyFullScreenAdapter.this.onAmrDismiss();
                }

                public void onContentReady(TJPlacement tJPlacement) {
                    if (!AdMostTapjoyFullScreenAdapter.this.isAdLoaded) {
                        boolean unused = AdMostTapjoyFullScreenAdapter.this.isAdLoaded = true;
                        AdMostTapjoyFullScreenAdapter adMostTapjoyFullScreenAdapter = AdMostTapjoyFullScreenAdapter.this;
                        adMostTapjoyFullScreenAdapter.mAd1 = tJPlacement;
                        boolean unused2 = adMostTapjoyFullScreenAdapter.waitingResponse = false;
                        AdMostTapjoyFullScreenAdapter.this.onAmrReady();
                    }
                }

                public void onContentShow(TJPlacement tJPlacement) {
                }

                public void onPurchaseRequest(TJPlacement tJPlacement, TJActionRequest tJActionRequest, String str) {
                }

                public void onRequestFailure(TJPlacement tJPlacement, TJError tJError) {
                    boolean unused = AdMostTapjoyFullScreenAdapter.this.waitingResponse = false;
                    AdMostTapjoyFullScreenAdapter adMostTapjoyFullScreenAdapter = AdMostTapjoyFullScreenAdapter.this;
                    AdMostBannerResponseItem adMostBannerResponseItem = adMostTapjoyFullScreenAdapter.mBannerResponseItem;
                    int i = tJError == null ? -1 : tJError.code;
                    StringBuilder sb = new StringBuilder();
                    sb.append("onRequestFailure");
                    sb.append(tJError == null ? "" : tJError.message);
                    adMostTapjoyFullScreenAdapter.onAmrFail(adMostBannerResponseItem, i, sb.toString());
                }

                public void onRequestSuccess(final TJPlacement tJPlacement) {
                    if (!tJPlacement.isContentAvailable()) {
                        boolean unused = AdMostTapjoyFullScreenAdapter.this.waitingResponse = false;
                        AdMostTapjoyFullScreenAdapter adMostTapjoyFullScreenAdapter = AdMostTapjoyFullScreenAdapter.this;
                        adMostTapjoyFullScreenAdapter.onAmrFail(adMostTapjoyFullScreenAdapter.mBannerResponseItem, "isContentAvailable() false");
                        return;
                    }
                    new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                        public void run() {
                            if (!AdMostTapjoyFullScreenAdapter.this.isAdLoaded && tJPlacement.isContentReady()) {
                                boolean unused = AdMostTapjoyFullScreenAdapter.this.isAdLoaded = true;
                                AdMostTapjoyFullScreenAdapter adMostTapjoyFullScreenAdapter = AdMostTapjoyFullScreenAdapter.this;
                                adMostTapjoyFullScreenAdapter.mAd1 = tJPlacement;
                                boolean unused2 = adMostTapjoyFullScreenAdapter.waitingResponse = false;
                                AdMostTapjoyFullScreenAdapter.this.onAmrReady();
                            }
                        }
                    }, 1000);
                }

                public void onRewardRequest(TJPlacement tJPlacement, TJActionRequest tJActionRequest, String str, int i) {
                }
            };
            C03252 r1 = new TJPlacementVideoListener() {
                public void onVideoComplete(TJPlacement tJPlacement) {
                    AdMostTapjoyFullScreenAdapter.this.onAmrComplete();
                }

                public void onVideoError(TJPlacement tJPlacement, String str) {
                    AdMostTapjoyFullScreenAdapter adMostTapjoyFullScreenAdapter = AdMostTapjoyFullScreenAdapter.this;
                    AdMostBannerResponseItem adMostBannerResponseItem = adMostTapjoyFullScreenAdapter.mBannerResponseItem;
                    adMostTapjoyFullScreenAdapter.onAmrFail(adMostBannerResponseItem, "onVideoError " + str);
                }

                public void onVideoStart(TJPlacement tJPlacement) {
                }
            };
            TJPlacement tJPlacement = new TJPlacement(AdMost.getInstance().getActivity(), this.mBannerResponseItem.AdSpaceId, r0);
            if (this.mBannerResponseItem.Type.equals("video")) {
                tJPlacement.setVideoListener(r1);
            }
            tJPlacement.setMediationName("amr");
            tJPlacement.setAdapterVersion(AdMost.getInstance().getVersion());
            tJPlacement.requestContent();
            this.waitingResponse = true;
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                public void run() {
                    if (AdMostTapjoyFullScreenAdapter.this.waitingResponse) {
                        AdMostTapjoyFullScreenAdapter adMostTapjoyFullScreenAdapter = AdMostTapjoyFullScreenAdapter.this;
                        adMostTapjoyFullScreenAdapter.onAmrFail(adMostTapjoyFullScreenAdapter.mBannerResponseItem, "loadVideo: response timeout");
                    }
                }
            }, 30000);
        } else if (AdMostAdNetworkManager.getInstance().getInitAdapter(AdMostAdNetwork.TAPJOY).isInitFailed) {
            onAmrFail(this.mBannerResponseItem, "isInitFailed");
        } else {
            try {
                AdMostAdNetworkManager.getInstance().getInitAdapter(AdMostAdNetwork.TAPJOY).setInitListener(new AdMostInitializationListener() {
                    public void onError(String str) {
                        AdMostTapjoyFullScreenAdapter adMostTapjoyFullScreenAdapter = AdMostTapjoyFullScreenAdapter.this;
                        AdMostBannerResponseItem adMostBannerResponseItem = adMostTapjoyFullScreenAdapter.mBannerResponseItem;
                        adMostTapjoyFullScreenAdapter.onAmrFail(adMostBannerResponseItem, "onError " + str);
                    }

                    public void onInitialized() {
                        AdMostTapjoyFullScreenAdapter.this.loadVideo();
                    }
                });
            } catch (Exception e) {
                AdMostBannerResponseItem adMostBannerResponseItem = this.mBannerResponseItem;
                onAmrFail(adMostBannerResponseItem, "exception " + e.getMessage());
            }
        }
    }

    /* access modifiers changed from: protected */
    public void showInterstitial() {
        showVideo();
    }

    /* access modifiers changed from: protected */
    public void showOfferwall() {
        showVideo();
    }

    public void showVideo() {
        if (!((TJPlacement) this.mAd1).isContentAvailable() || !((TJPlacement) this.mAd1).isContentReady()) {
            onAmrFailToShow(this.mBannerResponseItem, "not ContentAvailable and ContentReady");
        } else {
            ((TJPlacement) this.mAd1).showContent();
        }
    }
}
