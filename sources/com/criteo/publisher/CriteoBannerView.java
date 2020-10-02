package com.criteo.publisher;

import android.content.Context;
import android.util.Log;
import android.webkit.WebView;
import com.criteo.publisher.model.AdUnit;
import com.criteo.publisher.model.BannerAdUnit;
import com.criteo.publisher.p054a0.C2340o;

public class CriteoBannerView extends WebView {

    /* renamed from: e */
    private static final String f7636e = CriteoBannerView.class.getSimpleName();

    /* renamed from: a */
    private final BannerAdUnit f7637a;

    /* renamed from: b */
    private final Criteo f7638b;

    /* renamed from: c */
    private CriteoBannerAdListener f7639c;

    /* renamed from: d */
    private C2380d f7640d;

    public CriteoBannerView(Context context, BannerAdUnit bannerAdUnit) {
        this(context, bannerAdUnit, (Criteo) null);
    }

    /* renamed from: a */
    private void m8927a() {
        getOrCreateController().mo10240a((AdUnit) this.f7637a);
    }

    private Criteo getCriteo() {
        Criteo criteo = this.f7638b;
        return criteo == null ? Criteo.getInstance() : criteo;
    }

    /* access modifiers changed from: package-private */
    public CriteoBannerAdListener getCriteoBannerAdListener() {
        return this.f7639c;
    }

    /* access modifiers changed from: package-private */
    public C2380d getOrCreateController() {
        if (this.f7640d == null) {
            this.f7640d = getCriteo().createBannerController(this);
        }
        return this.f7640d;
    }

    public void loadAd() {
        try {
            m8927a();
        } catch (Throwable th) {
            Log.e(f7636e, "Internal error while loading banner.", th);
        }
    }

    public void setCriteoBannerAdListener(CriteoBannerAdListener criteoBannerAdListener) {
        this.f7639c = criteoBannerAdListener;
    }

    CriteoBannerView(Context context, BannerAdUnit bannerAdUnit, Criteo criteo) {
        super(context);
        this.f7637a = bannerAdUnit;
        this.f7638b = criteo;
    }

    /* renamed from: a */
    private void m8928a(BidToken bidToken) {
        if (bidToken == null || C2340o.m8994a(this.f7637a, bidToken.mo10073a())) {
            getOrCreateController().mo10239a(bidToken);
        }
    }

    public void loadAd(BidToken bidToken) {
        try {
            m8928a(bidToken);
        } catch (Throwable th) {
            Log.e(f7636e, "Internal error while loading banner from bid token.", th);
        }
    }
}
