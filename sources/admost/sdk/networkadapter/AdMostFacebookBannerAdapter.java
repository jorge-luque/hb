package admost.sdk.networkadapter;

import admost.sdk.AdMostViewBinder;
import admost.sdk.C0164R;
import admost.sdk.base.AdMost;
import admost.sdk.base.AdMostAdNetwork;
import admost.sdk.base.AdMostAdNetworkManager;
import admost.sdk.base.AdMostLog;
import admost.sdk.base.AdMostUtil;
import admost.sdk.base.AdMostZoneType;
import admost.sdk.interfaces.AdMostBannerInterface;
import admost.sdk.interfaces.AdMostBiddingInterface;
import admost.sdk.listener.AdMostBiddingListener;
import admost.sdk.model.AdMostBannerResponseItem;
import admost.sdk.networkadapter.AdMostFacebookBiddingManager;
import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.facebook.ads.AdError;
import com.facebook.ads.AdIconView;
import com.facebook.ads.AdListener;
import com.facebook.ads.AdOptionsView;
import com.facebook.ads.AdSize;
import com.facebook.ads.AdView;
import com.facebook.ads.C2630Ad;
import com.facebook.ads.MediaView;
import com.facebook.ads.MediaViewVideoRenderer;
import com.facebook.ads.NativeAd;
import com.facebook.ads.NativeAdLayout;
import com.facebook.ads.NativeAdListener;
import com.facebook.ads.NativeBannerAd;
import com.facebook.ads.VideoStartReason;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class AdMostFacebookBannerAdapter extends AdMostBannerInterface implements AdMostBiddingInterface {
    private AdOptionsView adOptionsView;
    private String auctionId;
    /* access modifiers changed from: private */
    public AdMostFacebookBiddingManager.AdMostFacebookBiddingRequestResponse.AdMostFacebookBid biddingResponse;
    private CustomRenderer customMediaRenderer;
    private View mView;
    private MediaView mediaView;
    private NativeAdLayout nativeAdLayout;

    private static class CustomRenderer extends MediaViewVideoRenderer {
        public CustomRenderer(Context context) {
            super(context);
        }

        public void onCompleted() {
            engageSeek();
            seekTo(0);
            disengageSeek(VideoStartReason.AUTO_STARTED);
            play(VideoStartReason.AUTO_STARTED);
        }

        public void onPrepared() {
            super.onPrepared();
            play(VideoStartReason.AUTO_STARTED);
        }
    }

    public void addAdChoivesView(View view, AdMostViewBinder adMostViewBinder) {
        if (this.nativeAdLayout != null) {
            ImageView imageView = (ImageView) view.findViewById(adMostViewBinder.privacyIconId);
            if (imageView != null) {
                if (this.mBannerResponseItem.ZoneSize == 250) {
                    this.adOptionsView = new AdOptionsView(AdMost.getInstance().getContext(), (NativeAd) this.mAd, this.nativeAdLayout);
                } else {
                    this.adOptionsView = new AdOptionsView(AdMost.getInstance().getContext(), (NativeBannerAd) this.mAd, this.nativeAdLayout);
                }
                ((ViewGroup) imageView.getParent()).addView(this.adOptionsView, ((ViewGroup) imageView.getParent()).indexOfChild(imageView), imageView.getLayoutParams());
                ((ViewGroup) imageView.getParent()).removeView(imageView);
                this.adOptionsView.setId(adMostViewBinder.privacyIconId);
                return;
            }
            AdMostLog.m296e("You need to set privacyIconId in your AdMostViewBinder. Please look at the AdMost docs related to Native Ads.");
            LinearLayout linearLayout = (LinearLayout) view.findViewById(C0164R.C0166id.ad_choices);
            if (linearLayout != null) {
                linearLayout.removeAllViews();
                if (this.mBannerResponseItem.ZoneSize == 250) {
                    this.adOptionsView = new AdOptionsView(AdMost.getInstance().getContext(), (NativeAd) this.mAd, this.nativeAdLayout);
                } else {
                    this.adOptionsView = new AdOptionsView(AdMost.getInstance().getContext(), (NativeBannerAd) this.mAd, this.nativeAdLayout);
                }
                linearLayout.addView(this.adOptionsView);
                linearLayout.setVisibility(0);
            }
        }
    }

    public void bid(final AdMostBiddingListener adMostBiddingListener) {
        if (!AdMostFacebookBiddingManager.getInstance().initCompleted) {
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                public void run() {
                    AdMostFacebookBannerAdapter.this.bid(adMostBiddingListener);
                }
            }, 100);
        } else {
            this.auctionId = AdMostFacebookBiddingManager.getInstance().bid(this.mBannerResponseItem, new AdMostFacebookBiddingManager.AdMostFacebookBiddingListener() {
                public void onFail(AdMostFacebookBiddingManager.AdMostFacebookBiddingError adMostFacebookBiddingError) {
                    adMostBiddingListener.onFail(adMostFacebookBiddingError.message);
                }

                public void onSuccess(AdMostFacebookBiddingManager.AdMostFacebookBiddingRequestResponse.AdMostFacebookBid adMostFacebookBid) {
                    AdMostFacebookBiddingManager.AdMostFacebookBiddingRequestResponse.AdMostFacebookBid unused = AdMostFacebookBannerAdapter.this.biddingResponse = adMostFacebookBid;
                    adMostBiddingListener.onSuccess(AdMostFacebookBannerAdapter.this.getBiddingPrice());
                }
            }, false);
        }
    }

    public void destroyBanner() {
        ((AdView) this.mAd).destroy();
        clearParentView();
    }

    /* access modifiers changed from: protected */
    public void destroyNative() {
        this.mView = null;
        MediaView mediaView2 = this.mediaView;
        if (mediaView2 != null) {
            mediaView2.destroy();
            this.mediaView = null;
            this.customMediaRenderer = null;
        }
        if (this.mBannerResponseItem.ZoneSize == 250) {
            ((NativeAd) this.mAd).unregisterView();
            ((NativeAd) this.mAd).destroy();
        } else {
            ((NativeBannerAd) this.mAd).unregisterView();
            ((NativeBannerAd) this.mAd).destroy();
        }
        clearParentView();
    }

    /* access modifiers changed from: protected */
    public View getBannerAdView(WeakReference<Activity> weakReference) {
        return (View) this.mAd;
    }

    public double getBiddingPrice() {
        AdMostFacebookBiddingManager.AdMostFacebookBiddingRequestResponse.AdMostFacebookBid adMostFacebookBid = this.biddingResponse;
        if (adMostFacebookBid == null) {
            return 0.0d;
        }
        double d = adMostFacebookBid.price;
        AdMostBannerResponseItem adMostBannerResponseItem = this.mBannerResponseItem;
        return d * (adMostBannerResponseItem == null ? 100.0d : adMostBannerResponseItem.BidScore);
    }

    /* access modifiers changed from: protected */
    public View getNativeAdView(LayoutInflater layoutInflater, AdMostViewBinder adMostViewBinder, WeakReference<Activity> weakReference, ViewGroup viewGroup) {
        int i;
        View view = this.mView;
        if (view != null) {
            return view;
        }
        this.nativeAdLayout = new NativeAdLayout(AdMost.getInstance().getContext());
        if (!(viewGroup == null || viewGroup.getLayoutParams() == null)) {
            this.nativeAdLayout.setLayoutParams(viewGroup.getLayoutParams());
        }
        int i2 = 0;
        View inflate = layoutInflater.inflate(adMostViewBinder.layoutId, this.nativeAdLayout, false);
        AdMostBannerResponseItem adMostBannerResponseItem = this.mBannerResponseItem;
        if (adMostBannerResponseItem.ZoneSize == 250 || adMostBannerResponseItem.ZoneType.equals(AdMostZoneType.FULLSCREEN)) {
            NativeAd nativeAd = (NativeAd) this.mAd;
            nativeAd.unregisterView();
            View findViewById = inflate.findViewById(adMostViewBinder.iconImageId);
            AdIconView adIconView = new AdIconView(findViewById.getContext());
            ((ViewGroup) findViewById.getParent()).addView(adIconView, ((ViewGroup) findViewById.getParent()).indexOfChild(findViewById), findViewById.getLayoutParams());
            ((ViewGroup) findViewById.getParent()).removeView(findViewById);
            adIconView.setId(adMostViewBinder.iconImageId);
            View findViewById2 = inflate.findViewById(adMostViewBinder.mainImageId);
            if (findViewById2 == null) {
                AdMostLog.m296e("MEDIUM_RECTANGLE height for zone is not allowed for custom layouts without mainImageId");
                return null;
            }
            ViewGroup.LayoutParams layoutParams = findViewById2.getLayoutParams();
            int i3 = layoutParams.height;
            if (i3 > 0 && layoutParams.width <= 0) {
                layoutParams.width = (i3 * 191) / 100;
            } else if (layoutParams.height <= 0 && (i = layoutParams.width) > 0) {
                layoutParams.height = (i * 100) / 191;
            }
            this.mediaView = new MediaView(findViewById2.getContext());
            if (((AdMostFacebookInitAdapter) AdMostAdNetworkManager.getInstance().getInitAdapter(AdMostAdNetwork.FACEBOOK)).useCustomRenderer) {
                this.customMediaRenderer = new CustomRenderer(findViewById2.getContext());
                if (AdMost.getInstance().isSoundMuted(AdMostAdNetwork.FACEBOOK)) {
                    this.customMediaRenderer.setVolume(0.0f);
                }
                this.mediaView.setVideoRenderer(this.customMediaRenderer);
            }
            ((ViewGroup) findViewById2.getParent()).addView(this.mediaView, ((ViewGroup) findViewById2.getParent()).indexOfChild(findViewById2), layoutParams);
            ((ViewGroup) findViewById2.getParent()).removeView(findViewById2);
            this.mediaView.setId(adMostViewBinder.mainImageId);
            TextView textView = (TextView) inflate.findViewById(adMostViewBinder.textId);
            if (nativeAd.getAdBodyText() != null) {
                textView.setText(nativeAd.getAdBodyText());
            } else {
                ((ViewGroup) inflate.findViewById(adMostViewBinder.textId).getParent()).removeView(inflate.findViewById(adMostViewBinder.textId));
            }
            TextView textView2 = (TextView) inflate.findViewById(adMostViewBinder.titleId);
            textView2.setText(nativeAd.getAdvertiserName());
            TextView textView3 = (TextView) inflate.findViewById(adMostViewBinder.callToActionId);
            if (!nativeAd.hasCallToAction()) {
                i2 = 4;
            }
            textView3.setVisibility(i2);
            textView3.setText(nativeAd.getAdCallToAction());
            ArrayList arrayList = new ArrayList();
            arrayList.add(textView2);
            arrayList.add(adIconView);
            arrayList.add(textView3);
            arrayList.add(textView);
            arrayList.add(this.mediaView);
            nativeAd.registerViewForInteraction(inflate, this.mediaView, (MediaView) adIconView, (List<View>) arrayList);
        } else {
            NativeBannerAd nativeBannerAd = (NativeBannerAd) this.mAd;
            nativeBannerAd.unregisterView();
            TextView textView4 = (TextView) inflate.findViewById(adMostViewBinder.textId);
            String adSocialContext = nativeBannerAd.getAdSocialContext();
            if (adSocialContext != null) {
                textView4.setText(adSocialContext);
            }
            TextView textView5 = (TextView) inflate.findViewById(adMostViewBinder.attributionId);
            TextView textView6 = (TextView) inflate.findViewById(adMostViewBinder.titleId);
            textView6.setText(nativeBannerAd.getAdvertiserName());
            String sponsoredTranslation = nativeBannerAd.getSponsoredTranslation();
            if (!(textView5 == null || sponsoredTranslation == null)) {
                textView5.setText(sponsoredTranslation);
            }
            View findViewById3 = inflate.findViewById(adMostViewBinder.iconImageId);
            AdIconView adIconView2 = new AdIconView(findViewById3.getContext());
            ((ViewGroup) findViewById3.getParent()).addView(adIconView2, ((ViewGroup) findViewById3.getParent()).indexOfChild(findViewById3), findViewById3.getLayoutParams());
            ((ViewGroup) findViewById3.getParent()).removeView(findViewById3);
            adIconView2.setId(adMostViewBinder.iconImageId);
            TextView textView7 = (TextView) inflate.findViewById(adMostViewBinder.callToActionId);
            try {
                ViewGroup viewGroup2 = (ViewGroup) textView7.getParent();
                ViewGroup viewGroup3 = (ViewGroup) viewGroup2.getParent();
                if (adMostViewBinder.layoutId == C0164R.layout.admost_native_50 && (viewGroup2.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) && (viewGroup3.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
                    ((ViewGroup.MarginLayoutParams) viewGroup2.getLayoutParams()).bottomMargin = 0;
                    viewGroup3.setPadding(0, 0, 0, 0);
                }
            } catch (Exception unused) {
            }
            if (!nativeBannerAd.hasCallToAction()) {
                i2 = 4;
            }
            textView7.setVisibility(i2);
            if (nativeBannerAd.hasCallToAction()) {
                textView7.setText(nativeBannerAd.getAdCallToAction());
            }
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(textView6);
            arrayList2.add(adIconView2);
            arrayList2.add(textView7);
            arrayList2.add(textView4);
            nativeBannerAd.registerViewForInteraction(inflate, (MediaView) adIconView2, (List<View>) arrayList2);
        }
        this.nativeAdLayout.addView(inflate);
        NativeAdLayout nativeAdLayout2 = this.nativeAdLayout;
        this.mView = nativeAdLayout2;
        return nativeAdLayout2;
    }

    public boolean isActivityRequiredForLoad(Activity activity) {
        return false;
    }

    public boolean loadBanner(WeakReference<Activity> weakReference) {
        AdSize adSize = AdSize.BANNER_HEIGHT_50;
        int i = this.mBannerResponseItem.ZoneSize;
        if (i == 90) {
            adSize = AdSize.BANNER_HEIGHT_90;
        } else if (i == 250) {
            adSize = AdSize.RECTANGLE_HEIGHT_250;
        }
        final AdView adView = new AdView(AdMost.getInstance().getContext(), this.mBannerResponseItem.AdSpaceId, adSize);
        adView.setLayoutParams(new RelativeLayout.LayoutParams(-1, AdMostUtil.getDip(this.mBannerResponseItem.ZoneSize)));
        adView.setAdListener(new AdListener() {
            public void onAdClicked(C2630Ad ad) {
                AdMostFacebookBannerAdapter.this.onAmrClick();
            }

            public void onAdLoaded(C2630Ad ad) {
                AdMostFacebookBannerAdapter adMostFacebookBannerAdapter = AdMostFacebookBannerAdapter.this;
                adMostFacebookBannerAdapter.mAd = adView;
                adMostFacebookBannerAdapter.onAmrReady();
            }

            public void onError(C2630Ad ad, AdError adError) {
                try {
                    adView.destroy();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                AdMostFacebookBannerAdapter adMostFacebookBannerAdapter = AdMostFacebookBannerAdapter.this;
                AdMostBannerResponseItem adMostBannerResponseItem = adMostFacebookBannerAdapter.mBannerResponseItem;
                int errorCode = adError == null ? -1 : adError.getErrorCode();
                StringBuilder sb = new StringBuilder();
                sb.append("onError: ");
                sb.append(adError == null ? "" : adError.getErrorMessage());
                adMostFacebookBannerAdapter.onAmrFail(adMostBannerResponseItem, errorCode, sb.toString());
            }

            public void onLoggingImpression(C2630Ad ad) {
            }
        });
        AdMostFacebookBiddingManager.AdMostFacebookBiddingRequestResponse.AdMostFacebookBid adMostFacebookBid = this.biddingResponse;
        if (adMostFacebookBid != null) {
            adView.loadAdFromBid(adMostFacebookBid.adm);
            return true;
        }
        adView.loadAd();
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean loadNative(WeakReference<Activity> weakReference) {
        AdMostBannerResponseItem adMostBannerResponseItem = this.mBannerResponseItem;
        if (adMostBannerResponseItem.ZoneSize == 250 || adMostBannerResponseItem.ZoneType.equals(AdMostZoneType.FULLSCREEN)) {
            final NativeAd nativeAd = new NativeAd(AdMost.getInstance().getContext(), this.mBannerResponseItem.AdSpaceId);
            nativeAd.setAdListener(new NativeAdListener() {
                public void onAdClicked(C2630Ad ad) {
                    AdMostFacebookBannerAdapter.this.onAmrClick();
                }

                public void onAdLoaded(C2630Ad ad) {
                    NativeAd nativeAd = nativeAd;
                    if (ad != nativeAd) {
                        try {
                            nativeAd.unregisterView();
                            nativeAd.destroy();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        AdMostFacebookBannerAdapter adMostFacebookBannerAdapter = AdMostFacebookBannerAdapter.this;
                        adMostFacebookBannerAdapter.onAmrFail(adMostFacebookBannerAdapter.mBannerResponseItem, "onAdLoaded failed");
                        return;
                    }
                    AdMostFacebookBannerAdapter adMostFacebookBannerAdapter2 = AdMostFacebookBannerAdapter.this;
                    adMostFacebookBannerAdapter2.mAd = nativeAd;
                    boolean z = true;
                    adMostFacebookBannerAdapter2.hasAdIcon = nativeAd.getAdIcon() != null;
                    AdMostFacebookBannerAdapter adMostFacebookBannerAdapter3 = AdMostFacebookBannerAdapter.this;
                    if (nativeAd.getAdCoverImage() == null) {
                        z = false;
                    }
                    adMostFacebookBannerAdapter3.hasAdImage = z;
                    AdMostFacebookBannerAdapter.this.onAmrReady();
                }

                public void onError(C2630Ad ad, AdError adError) {
                    try {
                        nativeAd.unregisterView();
                        nativeAd.destroy();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    AdMostFacebookBannerAdapter adMostFacebookBannerAdapter = AdMostFacebookBannerAdapter.this;
                    AdMostBannerResponseItem adMostBannerResponseItem = adMostFacebookBannerAdapter.mBannerResponseItem;
                    int errorCode = adError == null ? -1 : adError.getErrorCode();
                    StringBuilder sb = new StringBuilder();
                    sb.append("onError: ");
                    sb.append(adError == null ? "" : adError.getErrorMessage());
                    adMostFacebookBannerAdapter.onAmrFail(adMostBannerResponseItem, errorCode, sb.toString());
                }

                public void onLoggingImpression(C2630Ad ad) {
                }

                public void onMediaDownloaded(C2630Ad ad) {
                }
            });
            AdMostFacebookBiddingManager.AdMostFacebookBiddingRequestResponse.AdMostFacebookBid adMostFacebookBid = this.biddingResponse;
            if (adMostFacebookBid != null) {
                nativeAd.loadAdFromBid(adMostFacebookBid.adm);
                return true;
            }
            nativeAd.loadAd();
            return true;
        }
        final NativeBannerAd nativeBannerAd = new NativeBannerAd(AdMost.getInstance().getContext(), this.mBannerResponseItem.AdSpaceId);
        nativeBannerAd.setAdListener(new NativeAdListener() {
            public void onAdClicked(C2630Ad ad) {
                AdMostFacebookBannerAdapter.this.onAmrClick();
            }

            public void onAdLoaded(C2630Ad ad) {
                NativeBannerAd nativeBannerAd = nativeBannerAd;
                if (ad != nativeBannerAd) {
                    try {
                        nativeBannerAd.unregisterView();
                        nativeBannerAd.destroy();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    AdMostFacebookBannerAdapter adMostFacebookBannerAdapter = AdMostFacebookBannerAdapter.this;
                    adMostFacebookBannerAdapter.onAmrFail(adMostFacebookBannerAdapter.mBannerResponseItem, "onAdLoaded failed");
                    return;
                }
                AdMostFacebookBannerAdapter adMostFacebookBannerAdapter2 = AdMostFacebookBannerAdapter.this;
                adMostFacebookBannerAdapter2.mAd = nativeBannerAd;
                boolean z = true;
                adMostFacebookBannerAdapter2.hasAdIcon = nativeBannerAd.getAdIcon() != null;
                AdMostFacebookBannerAdapter adMostFacebookBannerAdapter3 = AdMostFacebookBannerAdapter.this;
                if (nativeBannerAd.getAdCoverImage() == null) {
                    z = false;
                }
                adMostFacebookBannerAdapter3.hasAdImage = z;
                AdMostFacebookBannerAdapter.this.onAmrReady();
            }

            public void onError(C2630Ad ad, AdError adError) {
                try {
                    nativeBannerAd.unregisterView();
                    nativeBannerAd.destroy();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                AdMostFacebookBannerAdapter adMostFacebookBannerAdapter = AdMostFacebookBannerAdapter.this;
                AdMostBannerResponseItem adMostBannerResponseItem = adMostFacebookBannerAdapter.mBannerResponseItem;
                int errorCode = adError == null ? -1 : adError.getErrorCode();
                StringBuilder sb = new StringBuilder();
                sb.append("onError: ");
                sb.append(adError == null ? "" : adError.getErrorMessage());
                adMostFacebookBannerAdapter.onAmrFail(adMostBannerResponseItem, errorCode, sb.toString());
            }

            public void onLoggingImpression(C2630Ad ad) {
            }

            public void onMediaDownloaded(C2630Ad ad) {
            }
        });
        AdMostFacebookBiddingManager.AdMostFacebookBiddingRequestResponse.AdMostFacebookBid adMostFacebookBid2 = this.biddingResponse;
        if (adMostFacebookBid2 != null) {
            nativeBannerAd.loadAdFromBid(adMostFacebookBid2.adm);
            return true;
        }
        nativeBannerAd.loadAd();
        return true;
    }

    /* access modifiers changed from: protected */
    public void pauseBanner() {
    }

    public void removeAdChoicesView(View view, AdMostViewBinder adMostViewBinder) {
        AdOptionsView adOptionsView2 = this.adOptionsView;
        if (adOptionsView2 != null) {
            adOptionsView2.setVisibility(8);
            ((ViewGroup) view).removeView(this.adOptionsView);
            this.adOptionsView = null;
            return;
        }
        LinearLayout linearLayout = (LinearLayout) view.findViewById(C0164R.C0166id.ad_choices);
        if (linearLayout != null) {
            linearLayout.removeAllViews();
            linearLayout.setVisibility(8);
        }
    }

    /* access modifiers changed from: protected */
    public void resumeBanner() {
    }

    public void sendLossNotice(double d, int i) {
        AdMostFacebookBiddingManager.AdMostFacebookBiddingRequestResponse.AdMostFacebookBid adMostFacebookBid = this.biddingResponse;
        if (adMostFacebookBid != null) {
            adMostFacebookBid.sendLossNotice(d, i);
        } else {
            AdMostFacebookBiddingManager.getInstance().sendLossNotice((AdMostFacebookBiddingManager.AdMostFacebookBiddingRequestResponse.AdMostFacebookBid) null, this.auctionId, i, d);
        }
    }

    public void sendWinNotice(double d) {
        AdMostFacebookBiddingManager.AdMostFacebookBiddingRequestResponse.AdMostFacebookBid adMostFacebookBid = this.biddingResponse;
        if (adMostFacebookBid != null) {
            adMostFacebookBid.sendWinNotice(d);
        }
    }
}
