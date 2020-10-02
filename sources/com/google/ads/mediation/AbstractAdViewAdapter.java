package com.google.ads.mediation;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import android.view.View;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdLoader;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.doubleclick.AppEventListener;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.ads.formats.NativeAdOptions;
import com.google.android.gms.ads.formats.NativeAdView;
import com.google.android.gms.ads.formats.NativeAdViewHolder;
import com.google.android.gms.ads.formats.NativeAppInstallAd;
import com.google.android.gms.ads.formats.NativeContentAd;
import com.google.android.gms.ads.formats.NativeCustomTemplateAd;
import com.google.android.gms.ads.formats.UnifiedNativeAd;
import com.google.android.gms.ads.formats.UnifiedNativeAdView;
import com.google.android.gms.ads.mediation.MediationAdRequest;
import com.google.android.gms.ads.mediation.MediationAdapter;
import com.google.android.gms.ads.mediation.MediationBannerAdapter;
import com.google.android.gms.ads.mediation.MediationBannerListener;
import com.google.android.gms.ads.mediation.MediationInterstitialListener;
import com.google.android.gms.ads.mediation.MediationNativeAdapter;
import com.google.android.gms.ads.mediation.MediationNativeListener;
import com.google.android.gms.ads.mediation.NativeAdMapper;
import com.google.android.gms.ads.mediation.NativeAppInstallAdMapper;
import com.google.android.gms.ads.mediation.NativeContentAdMapper;
import com.google.android.gms.ads.mediation.NativeMediationAdRequest;
import com.google.android.gms.ads.mediation.OnImmersiveModeUpdatedListener;
import com.google.android.gms.ads.mediation.UnifiedNativeAdMapper;
import com.google.android.gms.ads.mediation.zza;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;
import com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdAdapter;
import com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdListener;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.ads.zzazm;
import com.google.android.gms.internal.ads.zzazw;
import com.google.android.gms.internal.ads.zzbgz;
import com.google.android.gms.internal.ads.zzub;
import com.google.android.gms.internal.ads.zzvj;
import com.google.android.gms.internal.ads.zzxl;
import java.util.Date;
import java.util.Map;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.1.0 */
public abstract class AbstractAdViewAdapter implements MediationBannerAdapter, MediationNativeAdapter, OnImmersiveModeUpdatedListener, zza, MediationRewardedVideoAdAdapter, zzbgz {
    public static final String AD_UNIT_ID_PARAMETER = "pubid";
    private AdView zzlw;
    private InterstitialAd zzlx;
    private AdLoader zzly;
    private Context zzlz;
    /* access modifiers changed from: private */
    public InterstitialAd zzma;
    /* access modifiers changed from: private */
    public MediationRewardedVideoAdListener zzmb;
    @VisibleForTesting
    private final RewardedVideoAdListener zzmc = new C2938b(this);

    /* renamed from: com.google.ads.mediation.AbstractAdViewAdapter$a */
    /* compiled from: com.google.android.gms:play-services-ads-lite@@19.1.0 */
    static class C2931a extends NativeContentAdMapper {

        /* renamed from: a */
        private final NativeContentAd f8196a;

        public C2931a(NativeContentAd nativeContentAd) {
            this.f8196a = nativeContentAd;
            setHeadline(nativeContentAd.getHeadline().toString());
            setImages(nativeContentAd.getImages());
            setBody(nativeContentAd.getBody().toString());
            if (nativeContentAd.getLogo() != null) {
                setLogo(nativeContentAd.getLogo());
            }
            setCallToAction(nativeContentAd.getCallToAction().toString());
            setAdvertiser(nativeContentAd.getAdvertiser().toString());
            setOverrideImpressionRecording(true);
            setOverrideClickHandling(true);
            zza(nativeContentAd.getVideoController());
        }

        public final void trackView(View view) {
            if (view instanceof NativeAdView) {
                ((NativeAdView) view).setNativeAd(this.f8196a);
            }
            NativeAdViewHolder nativeAdViewHolder = NativeAdViewHolder.zzblg.get(view);
            if (nativeAdViewHolder != null) {
                nativeAdViewHolder.setNativeAd((NativeAd) this.f8196a);
            }
        }
    }

    /* renamed from: com.google.ads.mediation.AbstractAdViewAdapter$b */
    /* compiled from: com.google.android.gms:play-services-ads-lite@@19.1.0 */
    static class C2932b extends NativeAppInstallAdMapper {

        /* renamed from: a */
        private final NativeAppInstallAd f8197a;

        public C2932b(NativeAppInstallAd nativeAppInstallAd) {
            this.f8197a = nativeAppInstallAd;
            setHeadline(nativeAppInstallAd.getHeadline().toString());
            setImages(nativeAppInstallAd.getImages());
            setBody(nativeAppInstallAd.getBody().toString());
            setIcon(nativeAppInstallAd.getIcon());
            setCallToAction(nativeAppInstallAd.getCallToAction().toString());
            if (nativeAppInstallAd.getStarRating() != null) {
                setStarRating(nativeAppInstallAd.getStarRating().doubleValue());
            }
            if (nativeAppInstallAd.getStore() != null) {
                setStore(nativeAppInstallAd.getStore().toString());
            }
            if (nativeAppInstallAd.getPrice() != null) {
                setPrice(nativeAppInstallAd.getPrice().toString());
            }
            setOverrideImpressionRecording(true);
            setOverrideClickHandling(true);
            zza(nativeAppInstallAd.getVideoController());
        }

        public final void trackView(View view) {
            if (view instanceof NativeAdView) {
                ((NativeAdView) view).setNativeAd(this.f8197a);
            }
            NativeAdViewHolder nativeAdViewHolder = NativeAdViewHolder.zzblg.get(view);
            if (nativeAdViewHolder != null) {
                nativeAdViewHolder.setNativeAd((NativeAd) this.f8197a);
            }
        }
    }

    @VisibleForTesting
    /* renamed from: com.google.ads.mediation.AbstractAdViewAdapter$c */
    /* compiled from: com.google.android.gms:play-services-ads-lite@@19.1.0 */
    static final class C2933c extends AdListener implements AppEventListener, zzub {
        @VisibleForTesting

        /* renamed from: a */
        private final AbstractAdViewAdapter f8198a;
        @VisibleForTesting

        /* renamed from: b */
        private final MediationBannerListener f8199b;

        public C2933c(AbstractAdViewAdapter abstractAdViewAdapter, MediationBannerListener mediationBannerListener) {
            this.f8198a = abstractAdViewAdapter;
            this.f8199b = mediationBannerListener;
        }

        public final void onAdClicked() {
            this.f8199b.onAdClicked(this.f8198a);
        }

        public final void onAdClosed() {
            this.f8199b.onAdClosed(this.f8198a);
        }

        public final void onAdFailedToLoad(int i) {
            this.f8199b.onAdFailedToLoad(this.f8198a, i);
        }

        public final void onAdLeftApplication() {
            this.f8199b.onAdLeftApplication(this.f8198a);
        }

        public final void onAdLoaded() {
            this.f8199b.onAdLoaded(this.f8198a);
        }

        public final void onAdOpened() {
            this.f8199b.onAdOpened(this.f8198a);
        }

        public final void onAppEvent(String str, String str2) {
            this.f8199b.zza(this.f8198a, str, str2);
        }
    }

    /* renamed from: com.google.ads.mediation.AbstractAdViewAdapter$d */
    /* compiled from: com.google.android.gms:play-services-ads-lite@@19.1.0 */
    static class C2934d extends UnifiedNativeAdMapper {

        /* renamed from: a */
        private final UnifiedNativeAd f8200a;

        public C2934d(UnifiedNativeAd unifiedNativeAd) {
            this.f8200a = unifiedNativeAd;
            setHeadline(unifiedNativeAd.getHeadline());
            setImages(unifiedNativeAd.getImages());
            setBody(unifiedNativeAd.getBody());
            setIcon(unifiedNativeAd.getIcon());
            setCallToAction(unifiedNativeAd.getCallToAction());
            setAdvertiser(unifiedNativeAd.getAdvertiser());
            setStarRating(unifiedNativeAd.getStarRating());
            setStore(unifiedNativeAd.getStore());
            setPrice(unifiedNativeAd.getPrice());
            zzn(unifiedNativeAd.zzjv());
            setOverrideImpressionRecording(true);
            setOverrideClickHandling(true);
            zza(unifiedNativeAd.getVideoController());
        }

        public final void trackViews(View view, Map<String, View> map, Map<String, View> map2) {
            if (view instanceof UnifiedNativeAdView) {
                ((UnifiedNativeAdView) view).setNativeAd(this.f8200a);
                return;
            }
            NativeAdViewHolder nativeAdViewHolder = NativeAdViewHolder.zzblg.get(view);
            if (nativeAdViewHolder != null) {
                nativeAdViewHolder.setNativeAd(this.f8200a);
            }
        }
    }

    @VisibleForTesting
    /* renamed from: com.google.ads.mediation.AbstractAdViewAdapter$e */
    /* compiled from: com.google.android.gms:play-services-ads-lite@@19.1.0 */
    static final class C2935e extends AdListener implements NativeAppInstallAd.OnAppInstallAdLoadedListener, NativeContentAd.OnContentAdLoadedListener, NativeCustomTemplateAd.OnCustomClickListener, NativeCustomTemplateAd.OnCustomTemplateAdLoadedListener, UnifiedNativeAd.OnUnifiedNativeAdLoadedListener {
        @VisibleForTesting

        /* renamed from: a */
        private final AbstractAdViewAdapter f8201a;
        @VisibleForTesting

        /* renamed from: b */
        private final MediationNativeListener f8202b;

        public C2935e(AbstractAdViewAdapter abstractAdViewAdapter, MediationNativeListener mediationNativeListener) {
            this.f8201a = abstractAdViewAdapter;
            this.f8202b = mediationNativeListener;
        }

        public final void onAdClicked() {
            this.f8202b.onAdClicked(this.f8201a);
        }

        public final void onAdClosed() {
            this.f8202b.onAdClosed(this.f8201a);
        }

        public final void onAdFailedToLoad(int i) {
            this.f8202b.onAdFailedToLoad(this.f8201a, i);
        }

        public final void onAdImpression() {
            this.f8202b.onAdImpression(this.f8201a);
        }

        public final void onAdLeftApplication() {
            this.f8202b.onAdLeftApplication(this.f8201a);
        }

        public final void onAdLoaded() {
        }

        public final void onAdOpened() {
            this.f8202b.onAdOpened(this.f8201a);
        }

        public final void onAppInstallAdLoaded(NativeAppInstallAd nativeAppInstallAd) {
            this.f8202b.onAdLoaded((MediationNativeAdapter) this.f8201a, (NativeAdMapper) new C2932b(nativeAppInstallAd));
        }

        public final void onContentAdLoaded(NativeContentAd nativeContentAd) {
            this.f8202b.onAdLoaded((MediationNativeAdapter) this.f8201a, (NativeAdMapper) new C2931a(nativeContentAd));
        }

        public final void onCustomClick(NativeCustomTemplateAd nativeCustomTemplateAd, String str) {
            this.f8202b.zza(this.f8201a, nativeCustomTemplateAd, str);
        }

        public final void onCustomTemplateAdLoaded(NativeCustomTemplateAd nativeCustomTemplateAd) {
            this.f8202b.zza(this.f8201a, nativeCustomTemplateAd);
        }

        public final void onUnifiedNativeAdLoaded(UnifiedNativeAd unifiedNativeAd) {
            this.f8202b.onAdLoaded((MediationNativeAdapter) this.f8201a, (UnifiedNativeAdMapper) new C2934d(unifiedNativeAd));
        }
    }

    @VisibleForTesting
    /* renamed from: com.google.ads.mediation.AbstractAdViewAdapter$f */
    /* compiled from: com.google.android.gms:play-services-ads-lite@@19.1.0 */
    static final class C2936f extends AdListener implements zzub {
        @VisibleForTesting

        /* renamed from: a */
        private final AbstractAdViewAdapter f8203a;
        @VisibleForTesting

        /* renamed from: b */
        private final MediationInterstitialListener f8204b;

        public C2936f(AbstractAdViewAdapter abstractAdViewAdapter, MediationInterstitialListener mediationInterstitialListener) {
            this.f8203a = abstractAdViewAdapter;
            this.f8204b = mediationInterstitialListener;
        }

        public final void onAdClicked() {
            this.f8204b.onAdClicked(this.f8203a);
        }

        public final void onAdClosed() {
            this.f8204b.onAdClosed(this.f8203a);
        }

        public final void onAdFailedToLoad(int i) {
            this.f8204b.onAdFailedToLoad(this.f8203a, i);
        }

        public final void onAdLeftApplication() {
            this.f8204b.onAdLeftApplication(this.f8203a);
        }

        public final void onAdLoaded() {
            this.f8204b.onAdLoaded(this.f8203a);
        }

        public final void onAdOpened() {
            this.f8204b.onAdOpened(this.f8203a);
        }
    }

    private final AdRequest zza(Context context, MediationAdRequest mediationAdRequest, Bundle bundle, Bundle bundle2) {
        AdRequest.Builder builder = new AdRequest.Builder();
        Date birthday = mediationAdRequest.getBirthday();
        if (birthday != null) {
            builder.setBirthday(birthday);
        }
        int gender = mediationAdRequest.getGender();
        if (gender != 0) {
            builder.setGender(gender);
        }
        Set<String> keywords = mediationAdRequest.getKeywords();
        if (keywords != null) {
            for (String addKeyword : keywords) {
                builder.addKeyword(addKeyword);
            }
        }
        Location location = mediationAdRequest.getLocation();
        if (location != null) {
            builder.setLocation(location);
        }
        if (mediationAdRequest.isTesting()) {
            zzvj.zzpr();
            builder.addTestDevice(zzazm.zzbk(context));
        }
        if (mediationAdRequest.taggedForChildDirectedTreatment() != -1) {
            boolean z = true;
            if (mediationAdRequest.taggedForChildDirectedTreatment() != 1) {
                z = false;
            }
            builder.tagForChildDirectedTreatment(z);
        }
        builder.setIsDesignedForFamilies(mediationAdRequest.isDesignedForFamilies());
        builder.addNetworkExtrasBundle(AdMobAdapter.class, zza(bundle, bundle2));
        return builder.build();
    }

    public String getAdUnitId(Bundle bundle) {
        return bundle.getString(AD_UNIT_ID_PARAMETER);
    }

    public View getBannerView() {
        return this.zzlw;
    }

    public Bundle getInterstitialAdapterInfo() {
        return new MediationAdapter.zza().zzdo(1).zzact();
    }

    public zzxl getVideoController() {
        VideoController videoController;
        AdView adView = this.zzlw;
        if (adView == null || (videoController = adView.getVideoController()) == null) {
            return null;
        }
        return videoController.zzdu();
    }

    public void initialize(Context context, MediationAdRequest mediationAdRequest, String str, MediationRewardedVideoAdListener mediationRewardedVideoAdListener, Bundle bundle, Bundle bundle2) {
        this.zzlz = context.getApplicationContext();
        this.zzmb = mediationRewardedVideoAdListener;
        mediationRewardedVideoAdListener.onInitializationSucceeded(this);
    }

    public boolean isInitialized() {
        return this.zzmb != null;
    }

    public void loadAd(MediationAdRequest mediationAdRequest, Bundle bundle, Bundle bundle2) {
        Context context = this.zzlz;
        if (context == null || this.zzmb == null) {
            zzazw.zzfa("AdMobAdapter.loadAd called before initialize.");
            return;
        }
        InterstitialAd interstitialAd = new InterstitialAd(context);
        this.zzma = interstitialAd;
        interstitialAd.zzd(true);
        this.zzma.setAdUnitId(getAdUnitId(bundle));
        this.zzma.setRewardedVideoAdListener(this.zzmc);
        this.zzma.setAdMetadataListener(new C2937a(this));
        this.zzma.loadAd(zza(this.zzlz, mediationAdRequest, bundle2, bundle));
    }

    public void onDestroy() {
        AdView adView = this.zzlw;
        if (adView != null) {
            adView.destroy();
            this.zzlw = null;
        }
        if (this.zzlx != null) {
            this.zzlx = null;
        }
        if (this.zzly != null) {
            this.zzly = null;
        }
        if (this.zzma != null) {
            this.zzma = null;
        }
    }

    public void onImmersiveModeUpdated(boolean z) {
        InterstitialAd interstitialAd = this.zzlx;
        if (interstitialAd != null) {
            interstitialAd.setImmersiveMode(z);
        }
        InterstitialAd interstitialAd2 = this.zzma;
        if (interstitialAd2 != null) {
            interstitialAd2.setImmersiveMode(z);
        }
    }

    public void onPause() {
        AdView adView = this.zzlw;
        if (adView != null) {
            adView.pause();
        }
    }

    public void onResume() {
        AdView adView = this.zzlw;
        if (adView != null) {
            adView.resume();
        }
    }

    public void requestBannerAd(Context context, MediationBannerListener mediationBannerListener, Bundle bundle, AdSize adSize, MediationAdRequest mediationAdRequest, Bundle bundle2) {
        AdView adView = new AdView(context);
        this.zzlw = adView;
        adView.setAdSize(new AdSize(adSize.getWidth(), adSize.getHeight()));
        this.zzlw.setAdUnitId(getAdUnitId(bundle));
        this.zzlw.setAdListener(new C2933c(this, mediationBannerListener));
        this.zzlw.loadAd(zza(context, mediationAdRequest, bundle2, bundle));
    }

    public void requestInterstitialAd(Context context, MediationInterstitialListener mediationInterstitialListener, Bundle bundle, MediationAdRequest mediationAdRequest, Bundle bundle2) {
        InterstitialAd interstitialAd = new InterstitialAd(context);
        this.zzlx = interstitialAd;
        interstitialAd.setAdUnitId(getAdUnitId(bundle));
        this.zzlx.setAdListener(new C2936f(this, mediationInterstitialListener));
        this.zzlx.loadAd(zza(context, mediationAdRequest, bundle2, bundle));
    }

    public void requestNativeAd(Context context, MediationNativeListener mediationNativeListener, Bundle bundle, NativeMediationAdRequest nativeMediationAdRequest, Bundle bundle2) {
        C2935e eVar = new C2935e(this, mediationNativeListener);
        AdLoader.Builder withAdListener = new AdLoader.Builder(context, bundle.getString(AD_UNIT_ID_PARAMETER)).withAdListener(eVar);
        NativeAdOptions nativeAdOptions = nativeMediationAdRequest.getNativeAdOptions();
        if (nativeAdOptions != null) {
            withAdListener.withNativeAdOptions(nativeAdOptions);
        }
        if (nativeMediationAdRequest.isUnifiedNativeAdRequested()) {
            withAdListener.forUnifiedNativeAd(eVar);
        }
        if (nativeMediationAdRequest.isAppInstallAdRequested()) {
            withAdListener.forAppInstallAd(eVar);
        }
        if (nativeMediationAdRequest.isContentAdRequested()) {
            withAdListener.forContentAd(eVar);
        }
        if (nativeMediationAdRequest.zztw()) {
            for (String next : nativeMediationAdRequest.zztx().keySet()) {
                withAdListener.forCustomTemplateAd(next, eVar, nativeMediationAdRequest.zztx().get(next).booleanValue() ? eVar : null);
            }
        }
        AdLoader build = withAdListener.build();
        this.zzly = build;
        build.loadAd(zza(context, nativeMediationAdRequest, bundle2, bundle));
    }

    public void showInterstitial() {
        this.zzlx.show();
    }

    public void showVideo() {
        this.zzma.show();
    }

    /* access modifiers changed from: protected */
    public abstract Bundle zza(Bundle bundle, Bundle bundle2);
}
