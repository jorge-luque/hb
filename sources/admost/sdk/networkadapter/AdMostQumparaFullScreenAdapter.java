package admost.sdk.networkadapter;

import admost.sdk.base.AdMost;
import admost.sdk.base.AdMostAdNetwork;
import admost.sdk.base.AdMostAdNetworkManager;
import admost.sdk.interfaces.AdMostFullScreenInterface;
import admost.sdk.listener.AdMostInitializationListener;
import admost.sdk.model.AdMostBannerResponseItem;
import com.qumpara.offerwall.sdk.core.QumparaOfferwall;
import com.qumpara.offerwall.sdk.listener.QumparaOfferwallListener;

public class AdMostQumparaFullScreenAdapter extends AdMostFullScreenInterface {
    /* access modifiers changed from: private */
    public QumparaOfferwall offerwall;

    public AdMostQumparaFullScreenAdapter() {
        this.isSingleton = true;
    }

    public void loadOfferwall() {
        if (!AdMostAdNetworkManager.getInstance().getInitAdapter(AdMostAdNetwork.QUMPARA).isInitAdNetworkCompletedSuccessfully) {
            AdMostAdNetworkManager.getInstance().getInitAdapter(AdMostAdNetwork.QUMPARA).setInitListener(new AdMostInitializationListener() {
                public void onError(String str) {
                    AdMostQumparaFullScreenAdapter adMostQumparaFullScreenAdapter = AdMostQumparaFullScreenAdapter.this;
                    AdMostBannerResponseItem adMostBannerResponseItem = adMostQumparaFullScreenAdapter.mBannerResponseItem;
                    adMostQumparaFullScreenAdapter.onAmrFail(adMostBannerResponseItem, "init listener onError: " + str);
                }

                public void onInitialized() {
                    AdMostQumparaFullScreenAdapter.this.loadOfferwall();
                }
            });
            return;
        }
        QumparaOfferwall qumparaOfferwall = new QumparaOfferwall(AdMost.getInstance().getContext(), new QumparaOfferwallListener() {
            public void onClicked() {
                AdMostQumparaFullScreenAdapter.this.onAmrClick();
            }

            public void onDismiss() {
                AdMostQumparaFullScreenAdapter.this.onAmrDismiss();
            }

            public void onEngageClicked(String str) {
            }

            public void onEngageFail(String str, int i, String str2) {
            }

            public void onEngageSuccess(String str, String str2) {
            }

            public void onFail(int i, String str) {
                QumparaOfferwall unused = AdMostQumparaFullScreenAdapter.this.offerwall = null;
                AdMostQumparaFullScreenAdapter adMostQumparaFullScreenAdapter = AdMostQumparaFullScreenAdapter.this;
                AdMostBannerResponseItem adMostBannerResponseItem = adMostQumparaFullScreenAdapter.mBannerResponseItem;
                adMostQumparaFullScreenAdapter.onAmrFail(adMostBannerResponseItem, i, "onFail" + str);
            }

            public void onReady() {
                AdMostQumparaFullScreenAdapter adMostQumparaFullScreenAdapter = AdMostQumparaFullScreenAdapter.this;
                adMostQumparaFullScreenAdapter.mAd1 = adMostQumparaFullScreenAdapter.offerwall;
                AdMostQumparaFullScreenAdapter.this.onAmrReady();
            }

            public void onRedeemClicked(String str) {
            }

            public void onRedeemFail(String str, int i, String str2) {
            }

            public void onRedeemSuccess(String str) {
            }

            public void onShown() {
            }
        });
        this.offerwall = qumparaOfferwall;
        qumparaOfferwall.load();
    }

    public void showOfferwall() {
        Object obj = this.mAd1;
        if (obj == null) {
            onAmrFailToShow(this.mBannerResponseItem, "ad is null");
        } else if (((QumparaOfferwall) obj).isLoaded()) {
            ((QumparaOfferwall) this.mAd1).show();
        } else {
            onAmrFailToShow(this.mBannerResponseItem, "ad is not loaded");
        }
    }
}
