package com.applovin.impl.sdk.p052d;

import android.net.Uri;
import com.applovin.impl.mediation.p045b.C1697a;
import com.applovin.impl.sdk.AppLovinAdBase;
import com.applovin.impl.sdk.C1941j;
import com.applovin.impl.sdk.C1977q;
import com.applovin.impl.sdk.p049ad.C1817a;
import com.applovin.impl.sdk.p049ad.C1827g;
import com.applovin.impl.sdk.p051c.C1854d;
import com.applovin.sdk.AppLovinAdLoadListener;

/* renamed from: com.applovin.impl.sdk.d.d */
public class C1881d extends C1877c {

    /* renamed from: c */
    private final C1817a f6243c;

    /* renamed from: d */
    private boolean f6244d;

    /* renamed from: e */
    private boolean f6245e;

    public C1881d(C1817a aVar, C1941j jVar, AppLovinAdLoadListener appLovinAdLoadListener) {
        super("TaskCacheAppLovinAd", aVar, jVar, appLovinAdLoadListener);
        this.f6243c = aVar;
    }

    /* access modifiers changed from: private */
    /* renamed from: j */
    public void m7261j() {
        boolean d = this.f6243c.mo7154d();
        boolean z = this.f6245e;
        if (d || z) {
            mo8405a("Begin caching for streaming ad #" + this.f6243c.getAdIdNumber() + "...");
            mo8434c();
            if (d) {
                if (this.f6244d) {
                    mo8438i();
                }
                m7262k();
                if (!this.f6244d) {
                    mo8438i();
                }
                m7263l();
            } else {
                mo8438i();
                m7262k();
            }
        } else {
            mo8405a("Begin processing for non-streaming ad #" + this.f6243c.getAdIdNumber() + "...");
            mo8434c();
            m7262k();
            m7263l();
            mo8438i();
        }
        long currentTimeMillis = System.currentTimeMillis() - this.f6243c.getCreatedAtMillis();
        C1854d.m7123a(this.f6243c, this.f6217b);
        C1854d.m7122a(currentTimeMillis, (AppLovinAdBase) this.f6243c, this.f6217b);
        mo8431a((AppLovinAdBase) this.f6243c);
        mo8430a();
    }

    /* renamed from: k */
    private void m7262k() {
        mo8405a("Caching HTML resources...");
        this.f6243c.mo8159a(mo8429a(this.f6243c.mo7152b(), this.f6243c.mo8211K(), (C1827g) this.f6243c));
        this.f6243c.mo8230a(true);
        mo8405a("Finish caching non-video resources for ad #" + this.f6243c.getAdIdNumber());
        C1977q v = this.f6217b.mo8602v();
        String e = mo8411e();
        v.mo8740a(e, "Ad updated with cachedHTML = " + this.f6243c.mo7152b());
    }

    /* renamed from: l */
    private void m7263l() {
        Uri e;
        if (!mo8433b() && (e = mo8435e(this.f6243c.mo8161g())) != null) {
            this.f6243c.mo8160e();
            this.f6243c.mo8158a(e);
        }
    }

    /* renamed from: a */
    public /* bridge */ /* synthetic */ void mo7969a(C1697a aVar) {
        super.mo7969a(aVar);
    }

    /* renamed from: a */
    public void mo8443a(boolean z) {
        this.f6244d = z;
    }

    /* renamed from: b */
    public void mo8444b(boolean z) {
        this.f6245e = z;
    }

    public void run() {
        super.run();
        C18821 r0 = new Runnable() {
            public void run() {
                C1881d.this.m7261j();
            }
        };
        if (this.f6232a.mo8214N()) {
            this.f6217b.mo8533L().mo8480c().execute(r0);
        } else {
            r0.run();
        }
    }
}
