package com.google.ads.mediation.customevent;

import android.app.Activity;
import android.view.View;
import com.google.ads.AdRequest;
import com.google.ads.AdSize;
import com.google.ads.mediation.MediationAdRequest;
import com.google.ads.mediation.MediationBannerAdapter;
import com.google.ads.mediation.MediationBannerListener;
import com.google.ads.mediation.MediationInterstitialAdapter;
import com.google.ads.mediation.MediationInterstitialListener;
import com.google.android.gms.ads.mediation.customevent.CustomEventExtras;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.ads.zzazw;

@KeepName
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.1.0 */
public final class CustomEventAdapter implements MediationBannerAdapter<CustomEventExtras, CustomEventServerParameters>, MediationInterstitialAdapter<CustomEventExtras, CustomEventServerParameters> {
    private View zzms;
    @VisibleForTesting
    private CustomEventBanner zzmt;
    @VisibleForTesting
    private CustomEventInterstitial zzmu;

    @VisibleForTesting
    /* renamed from: com.google.ads.mediation.customevent.CustomEventAdapter$a */
    /* compiled from: com.google.android.gms:play-services-ads-lite@@19.1.0 */
    static final class C2939a implements CustomEventBannerListener {

        /* renamed from: a */
        private final CustomEventAdapter f8207a;

        /* renamed from: b */
        private final MediationBannerListener f8208b;

        public C2939a(CustomEventAdapter customEventAdapter, MediationBannerListener mediationBannerListener) {
            this.f8207a = customEventAdapter;
            this.f8208b = mediationBannerListener;
        }

        public final void onClick() {
            zzazw.zzed("Custom event adapter called onFailedToReceiveAd.");
            this.f8208b.onClick(this.f8207a);
        }

        public final void onDismissScreen() {
            zzazw.zzed("Custom event adapter called onFailedToReceiveAd.");
            this.f8208b.onDismissScreen(this.f8207a);
        }

        public final void onFailedToReceiveAd() {
            zzazw.zzed("Custom event adapter called onFailedToReceiveAd.");
            this.f8208b.onFailedToReceiveAd(this.f8207a, AdRequest.ErrorCode.NO_FILL);
        }

        public final void onLeaveApplication() {
            zzazw.zzed("Custom event adapter called onFailedToReceiveAd.");
            this.f8208b.onLeaveApplication(this.f8207a);
        }

        public final void onPresentScreen() {
            zzazw.zzed("Custom event adapter called onFailedToReceiveAd.");
            this.f8208b.onPresentScreen(this.f8207a);
        }

        public final void onReceivedAd(View view) {
            zzazw.zzed("Custom event adapter called onReceivedAd.");
            this.f8207a.zza(view);
            this.f8208b.onReceivedAd(this.f8207a);
        }
    }

    @VisibleForTesting
    /* renamed from: com.google.ads.mediation.customevent.CustomEventAdapter$b */
    /* compiled from: com.google.android.gms:play-services-ads-lite@@19.1.0 */
    class C2940b implements CustomEventInterstitialListener {

        /* renamed from: a */
        private final CustomEventAdapter f8209a;

        /* renamed from: b */
        private final MediationInterstitialListener f8210b;

        public C2940b(CustomEventAdapter customEventAdapter, MediationInterstitialListener mediationInterstitialListener) {
            this.f8209a = customEventAdapter;
            this.f8210b = mediationInterstitialListener;
        }

        public final void onDismissScreen() {
            zzazw.zzed("Custom event adapter called onDismissScreen.");
            this.f8210b.onDismissScreen(this.f8209a);
        }

        public final void onFailedToReceiveAd() {
            zzazw.zzed("Custom event adapter called onFailedToReceiveAd.");
            this.f8210b.onFailedToReceiveAd(this.f8209a, AdRequest.ErrorCode.NO_FILL);
        }

        public final void onLeaveApplication() {
            zzazw.zzed("Custom event adapter called onLeaveApplication.");
            this.f8210b.onLeaveApplication(this.f8209a);
        }

        public final void onPresentScreen() {
            zzazw.zzed("Custom event adapter called onPresentScreen.");
            this.f8210b.onPresentScreen(this.f8209a);
        }

        public final void onReceivedAd() {
            zzazw.zzed("Custom event adapter called onReceivedAd.");
            this.f8210b.onReceivedAd(CustomEventAdapter.this);
        }
    }

    /* access modifiers changed from: private */
    public final void zza(View view) {
        this.zzms = view;
    }

    private static <T> T zzak(String str) {
        try {
            return Class.forName(str).newInstance();
        } catch (Throwable th) {
            String message = th.getMessage();
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 46 + String.valueOf(message).length());
            sb.append("Could not instantiate custom event adapter: ");
            sb.append(str);
            sb.append(". ");
            sb.append(message);
            zzazw.zzfc(sb.toString());
            return null;
        }
    }

    public final void destroy() {
        CustomEventBanner customEventBanner = this.zzmt;
        if (customEventBanner != null) {
            customEventBanner.destroy();
        }
        CustomEventInterstitial customEventInterstitial = this.zzmu;
        if (customEventInterstitial != null) {
            customEventInterstitial.destroy();
        }
    }

    public final Class<CustomEventExtras> getAdditionalParametersType() {
        return CustomEventExtras.class;
    }

    public final View getBannerView() {
        return this.zzms;
    }

    public final Class<CustomEventServerParameters> getServerParametersType() {
        return CustomEventServerParameters.class;
    }

    public final void requestBannerAd(MediationBannerListener mediationBannerListener, Activity activity, CustomEventServerParameters customEventServerParameters, AdSize adSize, MediationAdRequest mediationAdRequest, CustomEventExtras customEventExtras) {
        Object obj;
        CustomEventBanner customEventBanner = (CustomEventBanner) zzak(customEventServerParameters.className);
        this.zzmt = customEventBanner;
        if (customEventBanner == null) {
            mediationBannerListener.onFailedToReceiveAd(this, AdRequest.ErrorCode.INTERNAL_ERROR);
            return;
        }
        if (customEventExtras == null) {
            obj = null;
        } else {
            obj = customEventExtras.getExtra(customEventServerParameters.label);
        }
        Activity activity2 = activity;
        this.zzmt.requestBannerAd(new C2939a(this, mediationBannerListener), activity2, customEventServerParameters.label, customEventServerParameters.parameter, adSize, mediationAdRequest, obj);
    }

    public final void requestInterstitialAd(MediationInterstitialListener mediationInterstitialListener, Activity activity, CustomEventServerParameters customEventServerParameters, MediationAdRequest mediationAdRequest, CustomEventExtras customEventExtras) {
        Object obj;
        CustomEventInterstitial customEventInterstitial = (CustomEventInterstitial) zzak(customEventServerParameters.className);
        this.zzmu = customEventInterstitial;
        if (customEventInterstitial == null) {
            mediationInterstitialListener.onFailedToReceiveAd(this, AdRequest.ErrorCode.INTERNAL_ERROR);
            return;
        }
        if (customEventExtras == null) {
            obj = null;
        } else {
            obj = customEventExtras.getExtra(customEventServerParameters.label);
        }
        Activity activity2 = activity;
        this.zzmu.requestInterstitialAd(new C2940b(this, mediationInterstitialListener), activity2, customEventServerParameters.label, customEventServerParameters.parameter, mediationAdRequest, obj);
    }

    public final void showInterstitial() {
        this.zzmu.showInterstitial();
    }
}
