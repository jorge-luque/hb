package p118io.presage;

import p118io.presage.interstitial.PresageInterstitialCallback;

/* renamed from: io.presage.ao */
public final class C6224ao implements EcirdelAubrac {

    /* renamed from: a */
    private final PresageInterstitialCallback f16751a;

    public C6224ao(PresageInterstitialCallback presageInterstitialCallback) {
        this.f16751a = presageInterstitialCallback;
    }

    /* renamed from: a */
    public final void mo34540a() {
        this.f16751a.onAdAvailable();
    }

    /* renamed from: b */
    public final void mo34542b() {
        this.f16751a.onAdNotAvailable();
    }

    /* renamed from: c */
    public final void mo34543c() {
        this.f16751a.onAdLoaded();
    }

    /* renamed from: d */
    public final void mo34544d() {
        this.f16751a.onAdNotLoaded();
    }

    /* renamed from: e */
    public final void mo34545e() {
        this.f16751a.onAdDisplayed();
    }

    /* renamed from: f */
    public final void mo34546f() {
        this.f16751a.onAdClosed();
    }

    /* renamed from: a */
    public final void mo34541a(int i) {
        this.f16751a.onAdError(i);
    }
}
