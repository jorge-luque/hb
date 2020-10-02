package admost.sdk.networkadapter;

import admost.sdk.AdMostViewBinder;
import admost.sdk.C0164R;
import admost.sdk.base.AdMost;
import admost.sdk.base.AdMostAdNetwork;
import admost.sdk.base.AdMostAdNetworkManager;
import admost.sdk.base.AdMostLocation;
import admost.sdk.base.AdMostLog;
import admost.sdk.base.AdMostZoneType;
import admost.sdk.interfaces.AdMostAdNetworkInitInterface;
import admost.sdk.interfaces.AdMostBannerInterface;
import admost.sdk.model.AdMostBannerResponseItem;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdLoader;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.VideoOptions;
import com.google.android.gms.ads.doubleclick.PublisherAdRequest;
import com.google.android.gms.ads.formats.AdChoicesView;
import com.google.android.gms.ads.formats.MediaView;
import com.google.android.gms.ads.formats.NativeAdOptions;
import com.google.android.gms.ads.formats.UnifiedNativeAd;
import com.google.android.gms.ads.formats.UnifiedNativeAdView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;

public class AdMostAdmob1720BannerAdapter extends AdMostBannerInterface {
    private AdSize adaptiveSize;
    private boolean useAdaptiveBanners;

    public AdMostAdmob1720BannerAdapter() {
        AdMostAdNetworkInitInterface initAdapter = AdMostAdNetworkManager.getInstance().getInitAdapter(AdMostAdNetwork.ADMOB);
        this.useAdaptiveBanners = (initAdapter instanceof AdMostAdmob1720InitAdapter) && ((AdMostAdmob1720InitAdapter) initAdapter).useAdaptiveBanners();
    }

    private AdRequest.Builder getAdRequestBuilder(Activity activity) {
        Class<AdMobAdapter> cls = AdMobAdapter.class;
        AdRequest.Builder builder = new AdRequest.Builder();
        if (!AdMost.getInstance().getConfiguration().showPersonalizedAdForGDPR()) {
            Bundle bundle = new Bundle();
            bundle.putString("npa", "1");
            builder.addNetworkExtrasBundle(cls, bundle);
        }
        if (!AdMost.getInstance().getConfiguration().showPersonalizedAdForCCPA()) {
            Bundle bundle2 = new Bundle();
            bundle2.putInt("rdp", 1);
            builder.addNetworkExtrasBundle(cls, bundle2);
        }
        if (AdMostLocation.isStarted() && AdMostLocation.getInstance().isFound()) {
            builder.setLocation(AdMostLocation.getInstance().location());
        }
        try {
            ArrayList<String> testDeviceIds = AdMost.getInstance().getConfiguration().getTestDeviceIds(AdMostAdNetwork.ADMOB);
            if (testDeviceIds != null && testDeviceIds.size() > 0) {
                Enumeration<T> enumeration = Collections.enumeration(testDeviceIds);
                while (enumeration.hasMoreElements()) {
                    builder.addTestDevice((String) enumeration.nextElement());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (AdMost.getInstance().isUserChild()) {
            builder.tagForChildDirectedTreatment(true);
        }
        setContentUrl(activity, builder);
        return builder;
    }

    private AdSize getAdaptiveBannerAdSize(Activity activity, AdSize adSize) {
        Class<AdSize> cls = AdSize.class;
        if (this.adaptiveSize != null) {
            AdMostLog.m294d("Admob uses adaptive size. width: " + this.adaptiveSize.getWidth() + " , height: " + this.adaptiveSize.getHeight());
            return this.adaptiveSize;
        }
        Display defaultDisplay = activity.getWindowManager().getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        defaultDisplay.getMetrics(displayMetrics);
        try {
            Object invokeAdaptiveBannerSizeMethod = invokeAdaptiveBannerSizeMethod(cls, "getCurrentOrientationAnchoredAdaptiveBannerAdSize", activity, Integer.valueOf((int) (((float) displayMetrics.widthPixels) / displayMetrics.density)));
            if ((invokeAdaptiveBannerSizeMethod instanceof AdSize) && ((AdSize) invokeAdaptiveBannerSizeMethod).getHeight() > 0) {
                double width = (double) ((AdSize) invokeAdaptiveBannerSizeMethod).getWidth();
                Double.isNaN(width);
                double d = width * 1.0d;
                double height = (double) ((AdSize) invokeAdaptiveBannerSizeMethod).getHeight();
                Double.isNaN(height);
                Object invokeAdaptiveBannerSizeMethod2 = invokeAdaptiveBannerSizeMethod(cls, "getCurrentOrientationAnchoredAdaptiveBannerAdSize", activity, Integer.valueOf(((int) Math.floor(d / height)) * 50));
                if (invokeAdaptiveBannerSizeMethod2 instanceof AdSize) {
                    this.adaptiveSize = (AdSize) invokeAdaptiveBannerSizeMethod2;
                    AdMostLog.m294d("Admob uses adaptive size. width: " + this.adaptiveSize.getWidth() + " , height: " + this.adaptiveSize.getHeight());
                    return this.adaptiveSize;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return AdSize.BANNER;
    }

    private PublisherAdRequest.Builder getPublisherAdRequest(Activity activity) {
        Class<AdMobAdapter> cls = AdMobAdapter.class;
        PublisherAdRequest.Builder builder = new PublisherAdRequest.Builder();
        if (!AdMost.getInstance().getConfiguration().showPersonalizedAdForGDPR()) {
            Bundle bundle = new Bundle();
            bundle.putString("npa", "1");
            builder.addNetworkExtrasBundle(cls, bundle);
        }
        if (!AdMost.getInstance().getConfiguration().showPersonalizedAdForCCPA()) {
            Bundle bundle2 = new Bundle();
            bundle2.putInt("rdp", 1);
            builder.addNetworkExtrasBundle(cls, bundle2);
        }
        if (AdMostLocation.isStarted() && AdMostLocation.getInstance() != null && AdMostLocation.getInstance().isFound()) {
            builder.setLocation(AdMostLocation.getInstance().location());
        }
        try {
            ArrayList<String> testDeviceIds = AdMost.getInstance().getConfiguration().getTestDeviceIds(AdMostAdNetwork.ADMOB);
            if (testDeviceIds != null && testDeviceIds.size() > 0) {
                Enumeration<T> enumeration = Collections.enumeration(testDeviceIds);
                while (enumeration.hasMoreElements()) {
                    builder.addTestDevice((String) enumeration.nextElement());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        setContentUrl(activity, builder);
        return builder;
    }

    public static Object invokeAdaptiveBannerSizeMethod(Class<?> cls, String str, Activity activity, Integer num) {
        try {
            return cls.getMethod(str, new Class[]{Context.class, Integer.TYPE}).invoke((Object) null, new Object[]{activity, num});
        } catch (Exception unused) {
            AdMostLog.m303w("getCurrentOrientationAnchoredAdaptiveBannerAdSize method not found. Default Banner implementation will be used.");
            return null;
        }
    }

    private void setContentUrl(Activity activity, Object obj) {
        if (activity != null) {
            try {
                String stringExtra = activity.getIntent().getStringExtra(AdMost.CONTENT_URL);
                if (stringExtra != null) {
                    if (!stringExtra.startsWith("http")) {
                        if (!stringExtra.startsWith("site")) {
                            AdMostLog.m296e("Content URL must be start with 'http' or 'site' (https://support.google.com/admob/answer/6270563)");
                            return;
                        }
                    }
                    if (obj instanceof PublisherAdRequest.Builder) {
                        ((PublisherAdRequest.Builder) obj).setContentUrl(stringExtra);
                    } else if (obj instanceof AdRequest.Builder) {
                        ((AdRequest.Builder) obj).setContentUrl(stringExtra);
                    }
                    AdMostLog.m299i("ADMOST_CONTENT_URL " + stringExtra);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void addAdChoivesView(View view, AdMostViewBinder adMostViewBinder) {
        ImageView imageView;
        int i = adMostViewBinder.privacyIconId;
        if (i > 0 && (imageView = (ImageView) view.findViewById(i)) != null && (view instanceof RelativeLayout)) {
            AdChoicesView adChoicesView = new AdChoicesView(AdMost.getInstance().getContext());
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) imageView.getLayoutParams();
            layoutParams.addRule(11);
            layoutParams.addRule(10);
            ((ViewGroup) view).addView(adChoicesView, layoutParams);
            ((ViewGroup) imageView.getParent()).removeView(imageView);
            adChoicesView.setId(adMostViewBinder.privacyIconId);
            ((UnifiedNativeAdView) this.mAd1).setAdChoicesView(adChoicesView);
            adChoicesView.setVisibility(0);
        }
    }

    public void destroyBanner() {
        Object obj = this.mAd;
        if (obj != null) {
            ((AdView) obj).destroy();
        }
    }

    /* access modifiers changed from: protected */
    public void destroyNative() {
        UnifiedNativeAd unifiedNativeAd = (UnifiedNativeAd) this.mAd;
        if (unifiedNativeAd != null) {
            unifiedNativeAd.destroy();
        }
    }

    /* access modifiers changed from: protected */
    public View getBannerAdView(WeakReference<Activity> weakReference) {
        return (View) this.mAd;
    }

    /* access modifiers changed from: protected */
    public View getNativeAdView(LayoutInflater layoutInflater, AdMostViewBinder adMostViewBinder, WeakReference<Activity> weakReference, ViewGroup viewGroup) {
        ImageView imageView;
        int i;
        UnifiedNativeAd unifiedNativeAd = (UnifiedNativeAd) this.mAd;
        UnifiedNativeAdView unifiedNativeAdView = (UnifiedNativeAdView) layoutInflater.inflate(C0164R.layout.admost_native_admob, viewGroup, false);
        this.mAd1 = unifiedNativeAdView;
        unifiedNativeAdView.addView(layoutInflater.inflate(adMostViewBinder.layoutId, unifiedNativeAdView, false));
        View findViewById = unifiedNativeAdView.findViewById(adMostViewBinder.titleId);
        View findViewById2 = unifiedNativeAdView.findViewById(adMostViewBinder.textId);
        View findViewById3 = unifiedNativeAdView.findViewById(adMostViewBinder.callToActionId);
        View findViewById4 = unifiedNativeAdView.findViewById(adMostViewBinder.iconImageId);
        AdMostBannerResponseItem adMostBannerResponseItem = this.mBannerResponseItem;
        if ((adMostBannerResponseItem.ZoneSize == 250 || adMostBannerResponseItem.ZoneType.equals(AdMostZoneType.FULLSCREEN)) && (imageView = (ImageView) unifiedNativeAdView.findViewById(adMostViewBinder.mainImageId)) != null) {
            ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
            int i2 = layoutParams.height;
            if (i2 > 0 && layoutParams.width <= 0) {
                layoutParams.width = (i2 * 10) / 7;
            } else if (layoutParams.height <= 0 && (i = layoutParams.width) > 0) {
                layoutParams.height = (i * 7) / 10;
            }
            MediaView mediaView = new MediaView(AdMost.getInstance().getContext());
            ViewGroup viewGroup2 = (ViewGroup) imageView.getParent();
            if (viewGroup2 != null) {
                viewGroup2.addView(mediaView, viewGroup2.indexOfChild(imageView), layoutParams);
                viewGroup2.removeView(imageView);
                mediaView.setId(adMostViewBinder.mainImageId);
                unifiedNativeAdView.setMediaView(mediaView);
            }
        }
        if (findViewById != null) {
            unifiedNativeAdView.setHeadlineView(findViewById);
            if (unifiedNativeAd.getHeadline() != null) {
                ((TextView) unifiedNativeAdView.getHeadlineView()).setText(unifiedNativeAd.getHeadline());
            }
        }
        if (findViewById2 != null) {
            unifiedNativeAdView.setBodyView(findViewById2);
            if (unifiedNativeAd.getBody() == null) {
                unifiedNativeAdView.getBodyView().setVisibility(4);
            } else {
                unifiedNativeAdView.getBodyView().setVisibility(0);
                ((TextView) unifiedNativeAdView.getBodyView()).setText(unifiedNativeAd.getBody());
            }
        }
        if (findViewById3 != null) {
            unifiedNativeAdView.setCallToActionView(findViewById3);
            if (unifiedNativeAd.getCallToAction() == null) {
                unifiedNativeAdView.getCallToActionView().setVisibility(4);
            } else {
                unifiedNativeAdView.getCallToActionView().setVisibility(0);
                ((TextView) unifiedNativeAdView.getCallToActionView()).setText(unifiedNativeAd.getCallToAction());
            }
        }
        if (findViewById4 != null) {
            try {
                unifiedNativeAdView.setIconView(findViewById4);
                if (this.hasAdIcon) {
                    unifiedNativeAdView.getIconView().setVisibility(0);
                    ((ImageView) unifiedNativeAdView.getIconView()).setImageDrawable(unifiedNativeAd.getIcon().getDrawable());
                } else {
                    unifiedNativeAdView.getIconView().setVisibility(4);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        unifiedNativeAdView.setNativeAd(unifiedNativeAd);
        return unifiedNativeAdView;
    }

    public boolean isActivityRequiredForLoad(Activity activity) {
        if (this.useAdaptiveBanners) {
            return true;
        }
        if (activity == null || activity.getIntent() == null || activity.getIntent().getStringExtra(AdMost.CONTENT_URL) == null) {
            return false;
        }
        return true;
    }

    public boolean loadBanner(WeakReference<Activity> weakReference) {
        AdSize adSize = AdSize.BANNER;
        int i = this.mBannerResponseItem.ZoneSize;
        if (i == 50) {
            if (!this.useAdaptiveBanners || weakReference == null || weakReference.get() == null) {
                AdMostLog.m303w("Admob does not use adaptive size.");
            } else {
                adSize = getAdaptiveBannerAdSize((Activity) weakReference.get(), AdSize.BANNER);
            }
        } else if (i == 90) {
            adSize = AdSize.LEADERBOARD;
        } else {
            adSize = AdSize.MEDIUM_RECTANGLE;
        }
        final AdView adView = new AdView(AdMost.getInstance().getContext());
        adView.setAdSize(adSize);
        adView.setAdUnitId(this.mBannerResponseItem.AdSpaceId);
        adView.setAdListener(new AdListener() {
            public void onAdFailedToLoad(int i) {
                AdMostAdmob1720BannerAdapter adMostAdmob1720BannerAdapter = AdMostAdmob1720BannerAdapter.this;
                adMostAdmob1720BannerAdapter.onAmrFail(adMostAdmob1720BannerAdapter.mBannerResponseItem, i, "onAdFailedToLoad");
            }

            public void onAdLoaded() {
                adView.setAdListener(new AdListener() {
                    public void onAdLoaded() {
                        super.onAdLoaded();
                    }

                    public void onAdOpened() {
                        AdMostAdmob1720BannerAdapter.this.onAmrClick();
                    }
                });
                adView.pause();
                AdMostAdmob1720BannerAdapter adMostAdmob1720BannerAdapter = AdMostAdmob1720BannerAdapter.this;
                adMostAdmob1720BannerAdapter.mAd = adView;
                adMostAdmob1720BannerAdapter.onAmrReady();
            }
        });
        adView.setVisibility(8);
        adView.loadAd(getAdRequestBuilder((Activity) weakReference.get()).build());
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean loadNative(WeakReference<Activity> weakReference) {
        new AdLoader.Builder(AdMost.getInstance().getContext(), this.mBannerResponseItem.AdSpaceId).forUnifiedNativeAd(new UnifiedNativeAd.OnUnifiedNativeAdLoadedListener() {
            public void onUnifiedNativeAdLoaded(UnifiedNativeAd unifiedNativeAd) {
                AdMostAdmob1720BannerAdapter adMostAdmob1720BannerAdapter = AdMostAdmob1720BannerAdapter.this;
                adMostAdmob1720BannerAdapter.mAd = unifiedNativeAd;
                adMostAdmob1720BannerAdapter.hasAdIcon = unifiedNativeAd.getIcon() != null;
                AdMostAdmob1720BannerAdapter.this.onAmrReady();
            }
        }).withAdListener(new AdListener() {
            public void onAdFailedToLoad(int i) {
                AdMostAdmob1720BannerAdapter adMostAdmob1720BannerAdapter = AdMostAdmob1720BannerAdapter.this;
                adMostAdmob1720BannerAdapter.onAmrFail(adMostAdmob1720BannerAdapter.mBannerResponseItem, i, "onAdFailedToLoad");
            }

            public void onAdImpression() {
                AdMostLog.m294d("Admost native onAdImpression");
            }

            public void onAdOpened() {
                AdMostLog.m294d("Admost native onAdOpened");
                AdMostAdmob1720BannerAdapter.this.onAmrClick();
            }
        }).withNativeAdOptions(new NativeAdOptions.Builder().setAdChoicesPlacement(1).setVideoOptions(new VideoOptions.Builder().setStartMuted(true).build()).build()).build().loadAd(getPublisherAdRequest((Activity) weakReference.get()).build());
        return true;
    }

    /* access modifiers changed from: protected */
    public void pauseBanner() {
        Object obj = this.mAd;
        if (obj != null) {
            ((AdView) obj).pause();
        }
    }

    /* access modifiers changed from: protected */
    public void resumeBanner() {
        Object obj = this.mAd;
        if (obj != null) {
            ((AdView) obj).setVisibility(0);
            ((AdView) this.mAd).resume();
        }
    }
}
