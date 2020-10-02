package admost.sdk.networkadapter;

import admost.sdk.AdMostViewBinder;
import admost.sdk.base.AdMost;
import admost.sdk.base.AdMostLog;
import admost.sdk.interfaces.AdMostBannerInterface;
import admost.sdk.model.AdMostBannerResponseItem;
import android.app.Activity;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.applovin.adview.AppLovinAdView;
import com.applovin.nativeAds.AppLovinNativeAd;
import com.applovin.nativeAds.AppLovinNativeAdLoadListener;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdClickListener;
import com.applovin.sdk.AppLovinAdDisplayListener;
import com.applovin.sdk.AppLovinAdLoadListener;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinPostbackListener;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkUtils;
import java.lang.ref.WeakReference;
import java.util.List;

public class AdMostApplovinBannerAdapter extends AdMostBannerInterface {
    /* access modifiers changed from: protected */
    public void destroyBanner() {
        Object obj = this.mAd;
        if (obj != null) {
            ((AppLovinAdView) obj).setAdClickListener((AppLovinAdClickListener) null);
            ((AppLovinAdView) this.mAd).setAdDisplayListener((AppLovinAdDisplayListener) null);
            ((AppLovinAdView) this.mAd).setAdLoadListener((AppLovinAdLoadListener) null);
            ((AppLovinAdView) this.mAd).destroy();
        }
    }

    /* access modifiers changed from: protected */
    public View getBannerAdView(WeakReference<Activity> weakReference) {
        return (View) this.mAd;
    }

    /* access modifiers changed from: protected */
    public View getNativeAdView(LayoutInflater layoutInflater, AdMostViewBinder adMostViewBinder, WeakReference<Activity> weakReference, ViewGroup viewGroup) {
        View inflate = layoutInflater.inflate(adMostViewBinder.layoutId, viewGroup, false);
        final AppLovinNativeAd appLovinNativeAd = (AppLovinNativeAd) this.mAd;
        C02764 r7 = new View.OnClickListener() {
            public void onClick(View view) {
                appLovinNativeAd.launchClickTarget(AdMost.getInstance().getContext());
                AdMostApplovinBannerAdapter.this.onAmrClick();
            }
        };
        if (appLovinNativeAd.isImagePrecached() && appLovinNativeAd.getIconUrl().startsWith("file") && appLovinNativeAd.getImageUrl().startsWith("file")) {
            ImageView imageView = (ImageView) inflate.findViewById(adMostViewBinder.iconImageId);
            imageView.setImageURI(Uri.parse(appLovinNativeAd.getIconUrl()));
            imageView.setOnClickListener(r7);
            ImageView imageView2 = (ImageView) inflate.findViewById(adMostViewBinder.mainImageId);
            if (imageView2 != null) {
                imageView2.setImageURI(Uri.parse(appLovinNativeAd.getImageUrl()));
                imageView2.setOnClickListener(r7);
            }
        }
        TextView textView = (TextView) inflate.findViewById(adMostViewBinder.textId);
        TextView textView2 = (TextView) inflate.findViewById(adMostViewBinder.titleId);
        textView2.setText(appLovinNativeAd.getTitle());
        TextView textView3 = (TextView) inflate.findViewById(adMostViewBinder.callToActionId);
        textView3.setText(appLovinNativeAd.getCtaText());
        if (textView != null) {
            textView.setText(appLovinNativeAd.getDescriptionText());
            textView.setOnClickListener(r7);
        }
        textView3.setOnClickListener(r7);
        textView2.setOnClickListener(r7);
        appLovinNativeAd.trackImpression(new AppLovinPostbackListener() {
            public void onPostbackFailure(String str, int i) {
                AdMostLog.m296e("Impression could not be tracked.Error code: " + i);
            }

            public void onPostbackSuccess(String str) {
            }
        });
        return inflate;
    }

    public boolean isActivityRequiredForLoad(Activity activity) {
        return false;
    }

    public boolean isSafeForCache() {
        AdMostBannerResponseItem adMostBannerResponseItem = this.mBannerResponseItem;
        return adMostBannerResponseItem != null && "native".equals(adMostBannerResponseItem.Type);
    }

    /* access modifiers changed from: protected */
    public boolean loadBanner(WeakReference<Activity> weakReference) {
        final AppLovinAdView appLovinAdView;
        int i = this.mBannerResponseItem.ZoneSize;
        String str = null;
        if (i == 50) {
            AppLovinAdSize appLovinAdSize = AppLovinAdSize.BANNER;
            if (!this.mBannerResponseItem.AdSpaceId.equals("empty")) {
                str = this.mBannerResponseItem.AdSpaceId;
            }
            appLovinAdView = new AppLovinAdView(appLovinAdSize, str, AdMost.getInstance().getContext());
            appLovinAdView.setLayoutParams(new FrameLayout.LayoutParams(-1, AppLovinSdkUtils.dpToPx(AdMost.getInstance().getContext(), AppLovinAdSize.BANNER.getHeight())));
        } else if (i == 90) {
            appLovinAdView = new AppLovinAdView(AppLovinAdSize.LEADER, AdMost.getInstance().getContext());
            appLovinAdView.setLayoutParams(new FrameLayout.LayoutParams(-1, AppLovinSdkUtils.dpToPx(AdMost.getInstance().getContext(), AppLovinAdSize.LEADER.getHeight())));
        } else if (i == 250) {
            appLovinAdView = new AppLovinAdView(AppLovinAdSize.MREC, AdMost.getInstance().getContext());
            appLovinAdView.setLayoutParams(new FrameLayout.LayoutParams(AppLovinSdkUtils.dpToPx(AdMost.getInstance().getContext(), AppLovinAdSize.MREC.getWidth()), AppLovinSdkUtils.dpToPx(AdMost.getInstance().getContext(), AppLovinAdSize.MREC.getHeight())));
        } else {
            AppLovinAdSize appLovinAdSize2 = AppLovinAdSize.BANNER;
            if (!this.mBannerResponseItem.AdSpaceId.equals("empty")) {
                str = this.mBannerResponseItem.AdSpaceId;
            }
            appLovinAdView = new AppLovinAdView(appLovinAdSize2, str, AdMost.getInstance().getContext());
        }
        appLovinAdView.setAutoDestroy(false);
        appLovinAdView.setAdClickListener(new AppLovinAdClickListener() {
            public void adClicked(AppLovinAd appLovinAd) {
                AdMostApplovinBannerAdapter.this.onAmrClick();
            }
        });
        appLovinAdView.setAdLoadListener(new AppLovinAdLoadListener() {
            public void adReceived(AppLovinAd appLovinAd) {
                AdMostApplovinBannerAdapter adMostApplovinBannerAdapter = AdMostApplovinBannerAdapter.this;
                adMostApplovinBannerAdapter.mAd = appLovinAdView;
                adMostApplovinBannerAdapter.onAmrReady();
            }

            public void failedToReceiveAd(int i) {
                AdMostApplovinBannerAdapter adMostApplovinBannerAdapter = AdMostApplovinBannerAdapter.this;
                adMostApplovinBannerAdapter.onAmrFail(adMostApplovinBannerAdapter.mBannerResponseItem, i, "failedToReceiveAd");
            }
        });
        appLovinAdView.loadNextAd();
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean loadNative(WeakReference<Activity> weakReference) {
        AppLovinSdk.getInstance(AdMost.getInstance().getContext()).getNativeAdService();
        AppLovinSdk.getInstance(AdMost.getInstance().getContext()).getNativeAdService().loadNextAd(new AppLovinNativeAdLoadListener() {
            public void onNativeAdsFailedToLoad(int i) {
                AdMostApplovinBannerAdapter adMostApplovinBannerAdapter = AdMostApplovinBannerAdapter.this;
                adMostApplovinBannerAdapter.onAmrFail(adMostApplovinBannerAdapter.mBannerResponseItem, i, "onNativeAdsFailedToLoad");
            }

            public void onNativeAdsLoaded(List list) {
                AdMostApplovinBannerAdapter.this.mAd = (AppLovinNativeAd) list.get(0);
                AdMostApplovinBannerAdapter.this.onAmrReady();
            }
        });
        return true;
    }

    /* access modifiers changed from: protected */
    public void pauseBanner() {
        ((AppLovinAdView) this.mAd).pause();
    }

    /* access modifiers changed from: protected */
    public void resumeBanner() {
        ((AppLovinAdView) this.mAd).resume();
    }
}
