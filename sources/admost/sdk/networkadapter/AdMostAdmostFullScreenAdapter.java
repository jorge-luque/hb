package admost.sdk.networkadapter;

import admost.adserver.ads.C0012a;
import admost.sdk.base.AdMost;
import admost.sdk.base.AdMostAdNetwork;
import admost.sdk.base.AdMostPreferences;
import admost.sdk.interfaces.AdMostFullScreenInterface;
import admost.sdk.model.AdMostBannerResponseItem;
import android.content.Context;
import p030c.p031a.p032a.C1179b;

public class AdMostAdmostFullScreenAdapter extends AdMostFullScreenInterface {
    /* access modifiers changed from: private */
    public C0012a fullScreenAd;

    public void destroyInterstitial() {
        C0012a aVar = this.fullScreenAd;
        if (aVar != null) {
            aVar.mo23a();
            this.fullScreenAd = null;
        }
    }

    public void loadInterstitial() {
        Context context = AdMost.getInstance().getContext();
        AdMostBannerResponseItem adMostBannerResponseItem = this.mBannerResponseItem;
        this.fullScreenAd = new C0012a(context, adMostBannerResponseItem.AdSpaceId, adMostBannerResponseItem.Type.equals("video"), new C1179b() {
            public void onClicked(String str) {
                AdMostAdmostFullScreenAdapter.this.onAmrClick();
            }

            public void onComplete() {
                AdMostAdmostFullScreenAdapter.this.onAmrComplete();
            }

            public void onDismiss() {
                AdMostAdmostFullScreenAdapter.this.onAmrDismiss();
            }

            public void onFail(int i) {
                if (i == 102) {
                    AdMostAdmostFullScreenAdapter adMostAdmostFullScreenAdapter = AdMostAdmostFullScreenAdapter.this;
                    adMostAdmostFullScreenAdapter.onAmrFailToShow(adMostAdmostFullScreenAdapter.mBannerResponseItem, i, "onFail");
                    return;
                }
                AdMostAdmostFullScreenAdapter adMostAdmostFullScreenAdapter2 = AdMostAdmostFullScreenAdapter.this;
                adMostAdmostFullScreenAdapter2.onAmrFail(adMostAdmostFullScreenAdapter2.mBannerResponseItem, i, "onFail");
            }

            public void onReady() {
                AdMostAdmostFullScreenAdapter adMostAdmostFullScreenAdapter = AdMostAdmostFullScreenAdapter.this;
                adMostAdmostFullScreenAdapter.mAd1 = adMostAdmostFullScreenAdapter.fullScreenAd;
                AdMostAdmostFullScreenAdapter.this.onAmrReady();
            }

            public void onShown() {
            }
        }, this.mBannerResponseItem.NetworkData);
        if (!this.mBannerResponseItem.Network.equals(AdMostAdNetwork.ADMOST)) {
            this.fullScreenAd.mo26b(AdMostPreferences.getInstance().getAdvId());
        } else {
            try {
                this.fullScreenAd.mo24a(AdMostPreferences.getInstance().getAdvId());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        this.fullScreenAd.mo25b();
    }

    public void loadVideo() {
        loadInterstitial();
    }

    public void showInterstitial() {
        C0012a aVar = this.fullScreenAd;
        if (aVar != null) {
            aVar.mo27c();
        } else {
            onAmrFailToShow(this.mBannerResponseItem, "showInterstitial");
        }
    }

    /* access modifiers changed from: protected */
    public void showVideo() {
        showInterstitial();
    }
}
