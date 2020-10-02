package com.criteo.publisher;

import android.content.Context;
import android.util.Log;
import com.criteo.publisher.model.AdUnit;
import com.criteo.publisher.model.C2467y;
import com.criteo.publisher.model.InterstitialAdUnit;
import com.criteo.publisher.p054a0.C2340o;

public class CriteoInterstitial {

    /* renamed from: f */
    private static final String f7642f = "CriteoInterstitial";

    /* renamed from: a */
    private final InterstitialAdUnit f7643a;

    /* renamed from: b */
    private final Criteo f7644b;

    /* renamed from: c */
    private C2384f f7645c;

    /* renamed from: d */
    private CriteoInterstitialAdListener f7646d;

    /* renamed from: e */
    private CriteoInterstitialAdDisplayListener f7647e;

    public CriteoInterstitial(Context context, InterstitialAdUnit interstitialAdUnit) {
        this(context, interstitialAdUnit, (Criteo) null);
    }

    /* renamed from: a */
    private void m8929a(BidToken bidToken) {
        if (bidToken == null || C2340o.m8994a(this.f7643a, bidToken.mo10073a())) {
            mo10095a().mo10242a(bidToken);
        }
    }

    /* renamed from: b */
    private void m8930b() {
        mo10095a().mo10244a((AdUnit) this.f7643a);
    }

    /* renamed from: c */
    private void m8931c() {
        mo10095a().mo10247b();
    }

    /* renamed from: d */
    private Criteo m8932d() {
        Criteo criteo = this.f7644b;
        return criteo == null ? Criteo.getInstance() : criteo;
    }

    public boolean isAdLoaded() {
        try {
            return mo10095a().mo10246a();
        } catch (Throwable th) {
            Log.e(f7642f, "Internal error while detecting interstitial load state.", th);
            return false;
        }
    }

    public void loadAd() {
        try {
            m8930b();
        } catch (Throwable th) {
            Log.e(f7642f, "Internal error while loading interstitial.", th);
        }
    }

    public void setCriteoInterstitialAdDisplayListener(CriteoInterstitialAdDisplayListener criteoInterstitialAdDisplayListener) {
        this.f7647e = criteoInterstitialAdDisplayListener;
    }

    public void setCriteoInterstitialAdListener(CriteoInterstitialAdListener criteoInterstitialAdListener) {
        this.f7646d = criteoInterstitialAdListener;
    }

    public void show() {
        try {
            m8931c();
        } catch (Throwable th) {
            Log.e(f7642f, "Internal error while showing interstitial.", th);
        }
    }

    CriteoInterstitial(Context context, InterstitialAdUnit interstitialAdUnit, Criteo criteo) {
        this.f7643a = interstitialAdUnit;
        this.f7644b = criteo;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public C2384f mo10095a() {
        if (this.f7645c == null) {
            Criteo d = m8932d();
            this.f7645c = new C2384f(this.f7646d, this.f7647e, new C2467y(d.mo10076a()), d.mo10080c(), d);
        }
        return this.f7645c;
    }

    public void loadAd(BidToken bidToken) {
        try {
            m8929a(bidToken);
        } catch (Throwable th) {
            Log.e(f7642f, "Internal error while loading interstitial from bid token.", th);
        }
    }
}
