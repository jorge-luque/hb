package admost.sdk.networkadapter;

import admost.sdk.interfaces.AdMostBannerInterface;
import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.chartboost.sdk.Banner.BannerSize;
import com.chartboost.sdk.ChartboostBanner;
import com.chartboost.sdk.ChartboostBannerListener;
import com.chartboost.sdk.Events.ChartboostCacheError;
import com.chartboost.sdk.Events.ChartboostCacheEvent;
import com.chartboost.sdk.Events.ChartboostClickError;
import com.chartboost.sdk.Events.ChartboostClickEvent;
import com.chartboost.sdk.Events.ChartboostShowError;
import com.chartboost.sdk.Events.ChartboostShowEvent;
import java.lang.ref.WeakReference;

public class AdMostChartboostBannerAdapter extends AdMostBannerInterface {
    ChartboostBanner chartboostBanner;

    /* access modifiers changed from: protected */
    public void destroyBanner() {
        Object obj = this.mAd1;
        if (obj != null) {
            ((ChartboostBanner) obj).detachBanner();
        }
        if (this.mAd != null) {
            this.mAd = null;
        }
    }

    /* access modifiers changed from: protected */
    public View getBannerAdView(WeakReference<Activity> weakReference) {
        ((ChartboostBanner) this.mAd1).show();
        return (View) this.mAd;
    }

    public boolean loadBanner(WeakReference<Activity> weakReference) {
        if (weakReference.get() == null) {
            onAmrFail(this.mBannerResponseItem, "Banner activity is null!");
            return false;
        }
        final LinearLayout linearLayout = new LinearLayout((Context) weakReference.get());
        final LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 1;
        C02911 r4 = new ChartboostBannerListener() {
            public void onAdCached(ChartboostCacheEvent chartboostCacheEvent, ChartboostCacheError chartboostCacheError) {
                if (chartboostCacheEvent != null) {
                    if (AdMostChartboostBannerAdapter.this.chartboostBanner.getParent() != null) {
                        ((ViewGroup) AdMostChartboostBannerAdapter.this.chartboostBanner.getParent()).removeView(AdMostChartboostBannerAdapter.this.chartboostBanner);
                    }
                    linearLayout.addView(AdMostChartboostBannerAdapter.this.chartboostBanner, layoutParams);
                    AdMostChartboostBannerAdapter adMostChartboostBannerAdapter = AdMostChartboostBannerAdapter.this;
                    adMostChartboostBannerAdapter.mAd = linearLayout;
                    adMostChartboostBannerAdapter.mAd1 = adMostChartboostBannerAdapter.chartboostBanner;
                    adMostChartboostBannerAdapter.onAmrReady();
                } else if (chartboostCacheError != null) {
                    AdMostChartboostBannerAdapter adMostChartboostBannerAdapter2 = AdMostChartboostBannerAdapter.this;
                    adMostChartboostBannerAdapter2.onAmrFail(adMostChartboostBannerAdapter2.mBannerResponseItem, chartboostCacheError.toString());
                }
            }

            public void onAdClicked(ChartboostClickEvent chartboostClickEvent, ChartboostClickError chartboostClickError) {
                AdMostChartboostBannerAdapter.this.onAmrClick();
            }

            public void onAdShown(ChartboostShowEvent chartboostShowEvent, ChartboostShowError chartboostShowError) {
            }
        };
        if (this.mBannerResponseItem.ZoneSize == 250) {
            this.chartboostBanner = new ChartboostBanner((Context) weakReference.get(), this.mBannerResponseItem.AdSpaceId, BannerSize.MEDIUM, r4);
        } else {
            this.chartboostBanner = new ChartboostBanner((Context) weakReference.get(), this.mBannerResponseItem.AdSpaceId, BannerSize.STANDARD, r4);
        }
        this.chartboostBanner.setAutomaticallyRefreshesContent(false);
        this.chartboostBanner.cache();
        return true;
    }
}
