package admost.sdk.networkadapter;

import admost.sdk.AdMostManager;
import admost.sdk.base.AdMost;
import admost.sdk.base.AdMostAdNetwork;
import admost.sdk.base.AdMostAdNetworkManager;
import admost.sdk.interfaces.AdMostBannerInterface;
import admost.sdk.interfaces.AdMostBiddingInterface;
import admost.sdk.listener.AdMostBiddingListener;
import admost.sdk.listener.AdMostInitializationListener;
import admost.sdk.model.AdMostBannerResponseItem;
import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.RelativeLayout;
import com.criteo.publisher.BidResponse;
import com.criteo.publisher.Criteo;
import com.criteo.publisher.CriteoBannerAdListener;
import com.criteo.publisher.CriteoBannerView;
import com.criteo.publisher.CriteoErrorCode;
import com.criteo.publisher.model.AdSize;
import com.criteo.publisher.model.BannerAdUnit;
import java.lang.ref.WeakReference;

public class AdMostCriteoBannerAdapter extends AdMostBannerInterface implements AdMostBiddingInterface {
    private BannerAdUnit bannerAdUnit;
    private BidResponse bidResponse;

    private void setAdUnit() {
        AdSize adSize;
        if (this.bannerAdUnit == null) {
            int i = this.mBannerResponseItem.ZoneSize;
            if (i == 250) {
                adSize = new AdSize(AdMost.AD_ERROR_FREQ_CAP, AdMostManager.AD_MEDIUM_RECTANGLE);
            } else if (i == 90) {
                adSize = new AdSize(320, 90);
            } else {
                adSize = new AdSize(320, 50);
            }
            this.bannerAdUnit = new BannerAdUnit(this.mBannerResponseItem.AdSpaceId, adSize);
        }
    }

    public void bid(final AdMostBiddingListener adMostBiddingListener) {
        if (!AdMostAdNetworkManager.getInstance().getInitAdapter(AdMostAdNetwork.CRITEO).isInitAdNetworkCompletedSuccessfully) {
            AdMostAdNetworkManager.getInstance().getInitAdapter(AdMostAdNetwork.CRITEO).setInitListener(new AdMostInitializationListener() {
                public void onError(String str) {
                    AdMostCriteoBannerAdapter adMostCriteoBannerAdapter = AdMostCriteoBannerAdapter.this;
                    AdMostBannerResponseItem adMostBannerResponseItem = adMostCriteoBannerAdapter.mBannerResponseItem;
                    adMostCriteoBannerAdapter.onAmrFail(adMostBannerResponseItem, "onError: " + str);
                }

                public void onInitialized() {
                    AdMostCriteoBannerAdapter.this.bid(adMostBiddingListener);
                }
            });
            return;
        }
        setAdUnit();
        BidResponse bidResponse2 = Criteo.getInstance().getBidResponse(this.bannerAdUnit);
        this.bidResponse = bidResponse2;
        if (bidResponse2 == null || !bidResponse2.isBidSuccess()) {
            adMostBiddingListener.onFail("bid failed");
        } else {
            adMostBiddingListener.onSuccess(getBiddingPrice());
        }
    }

    /* access modifiers changed from: protected */
    public void destroyBanner() {
        Object obj = this.mAd1;
        if (obj != null) {
            ((CriteoBannerView) obj).destroy();
        }
    }

    /* access modifiers changed from: protected */
    public View getBannerAdView(WeakReference<Activity> weakReference) {
        return (View) this.mAd;
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

    public boolean loadBanner(WeakReference<Activity> weakReference) {
        if (weakReference == null || weakReference.get() == null) {
            onAmrFail(this.mBannerResponseItem, "Banner activity is null!");
            return false;
        }
        RelativeLayout relativeLayout = new RelativeLayout((Context) weakReference.get());
        setAdUnit();
        CriteoBannerView criteoBannerView = new CriteoBannerView(AdMost.getInstance().getContext(), this.bannerAdUnit);
        criteoBannerView.setCriteoBannerAdListener(new CriteoBannerAdListener() {
            public void onAdClicked() {
                AdMostCriteoBannerAdapter.this.onAmrClick();
            }

            public void onAdClosed() {
            }

            public void onAdFailedToReceive(CriteoErrorCode criteoErrorCode) {
                AdMostCriteoBannerAdapter adMostCriteoBannerAdapter = AdMostCriteoBannerAdapter.this;
                AdMostBannerResponseItem adMostBannerResponseItem = adMostCriteoBannerAdapter.mBannerResponseItem;
                StringBuilder sb = new StringBuilder();
                sb.append("onAdFailedToReceive: ");
                sb.append(criteoErrorCode == null ? "" : criteoErrorCode.name());
                adMostCriteoBannerAdapter.onAmrFail(adMostBannerResponseItem, sb.toString());
            }

            public void onAdLeftApplication() {
            }

            public void onAdOpened() {
            }

            public void onAdReceived(View view) {
                AdMostCriteoBannerAdapter adMostCriteoBannerAdapter = AdMostCriteoBannerAdapter.this;
                adMostCriteoBannerAdapter.mAd1 = view;
                adMostCriteoBannerAdapter.onAmrReady();
            }
        });
        BidResponse bidResponse2 = this.bidResponse;
        if (bidResponse2 == null || !bidResponse2.isBidSuccess()) {
            criteoBannerView.loadAd();
        } else {
            criteoBannerView.loadAd(this.bidResponse.getBidToken());
        }
        relativeLayout.addView(criteoBannerView);
        this.mAd = relativeLayout;
        return true;
    }

    public void sendLossNotice(double d, int i) {
    }

    public void sendWinNotice(double d) {
    }
}
