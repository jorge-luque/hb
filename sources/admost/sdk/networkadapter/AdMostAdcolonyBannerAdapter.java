package admost.sdk.networkadapter;

import admost.sdk.AdMostManager;
import admost.sdk.interfaces.AdMostBannerInterface;
import android.app.Activity;
import android.view.View;
import com.adcolony.sdk.AdColony;
import com.adcolony.sdk.AdColonyAdSize;
import com.adcolony.sdk.AdColonyAdView;
import com.adcolony.sdk.AdColonyAdViewListener;
import com.adcolony.sdk.AdColonyZone;
import java.lang.ref.WeakReference;

public class AdMostAdcolonyBannerAdapter extends AdMostBannerInterface {
    /* access modifiers changed from: protected */
    public void destroyBanner() {
        Object obj = this.mAd1;
        if (obj != null) {
            ((AdColonyAdView) obj).destroy();
        }
        this.mAd1 = null;
    }

    /* access modifiers changed from: protected */
    public View getBannerAdView(WeakReference<Activity> weakReference) {
        return (View) this.mAd1;
    }

    public boolean loadBanner(WeakReference<Activity> weakReference) {
        C02461 r3 = new AdColonyAdViewListener() {
            public void onClicked(AdColonyAdView adColonyAdView) {
                AdMostAdcolonyBannerAdapter.this.onAmrClick();
            }

            public void onRequestFilled(AdColonyAdView adColonyAdView) {
                AdMostAdcolonyBannerAdapter adMostAdcolonyBannerAdapter = AdMostAdcolonyBannerAdapter.this;
                adMostAdcolonyBannerAdapter.mAd1 = adColonyAdView;
                adMostAdcolonyBannerAdapter.onAmrReady();
            }

            public void onRequestNotFilled(AdColonyZone adColonyZone) {
                AdMostAdcolonyBannerAdapter adMostAdcolonyBannerAdapter = AdMostAdcolonyBannerAdapter.this;
                adMostAdcolonyBannerAdapter.onAmrFail(adMostAdcolonyBannerAdapter.mBannerResponseItem, "onRequestNotFilled");
            }
        };
        int i = this.mBannerResponseItem.ZoneSize;
        AdMostManager.getInstance();
        if (i == 50) {
            AdColony.requestAdView(this.mBannerResponseItem.AdSpaceId, r3, AdColonyAdSize.BANNER);
            return true;
        }
        int i2 = this.mBannerResponseItem.ZoneSize;
        AdMostManager.getInstance();
        if (i2 == 90) {
            AdColony.requestAdView(this.mBannerResponseItem.AdSpaceId, r3, AdColonyAdSize.LEADERBOARD);
            return true;
        }
        int i3 = this.mBannerResponseItem.ZoneSize;
        AdMostManager.getInstance();
        if (i3 != 250) {
            return true;
        }
        AdColony.requestAdView(this.mBannerResponseItem.AdSpaceId, r3, AdColonyAdSize.MEDIUM_RECTANGLE);
        return true;
    }
}
