package com.applovin.impl.sdk.p051c;

import android.annotation.TargetApi;
import android.app.Activity;
import com.applovin.impl.sdk.AppLovinAdBase;
import com.applovin.impl.sdk.C1941j;
import com.applovin.impl.sdk.p051c.C1848c;
import com.applovin.impl.sdk.utils.C1991g;
import com.applovin.impl.sdk.utils.C1992h;

/* renamed from: com.applovin.impl.sdk.c.d */
public class C1854d {

    /* renamed from: a */
    private final C1941j f6165a;

    /* renamed from: b */
    private final C1860h f6166b;

    /* renamed from: c */
    private final C1848c.C1852b f6167c;

    /* renamed from: d */
    private final Object f6168d = new Object();

    /* renamed from: e */
    private final long f6169e;

    /* renamed from: f */
    private long f6170f;

    /* renamed from: g */
    private long f6171g;

    /* renamed from: h */
    private long f6172h;

    public C1854d(AppLovinAdBase appLovinAdBase, C1941j jVar) {
        if (appLovinAdBase == null) {
            throw new IllegalArgumentException("No ad specified");
        } else if (jVar != null) {
            this.f6165a = jVar;
            this.f6166b = jVar.mo8534M();
            C1848c.C1852b a = jVar.mo8545X().mo8346a(appLovinAdBase);
            this.f6167c = a;
            a.mo8355a(C1847b.f6125a, (long) appLovinAdBase.getSource().ordinal()).mo8357a();
            this.f6169e = appLovinAdBase.getCreatedAtMillis();
        } else {
            throw new IllegalArgumentException("No sdk specified");
        }
    }

    /* renamed from: a */
    public static void m7122a(long j, AppLovinAdBase appLovinAdBase, C1941j jVar) {
        if (appLovinAdBase != null && jVar != null) {
            jVar.mo8545X().mo8346a(appLovinAdBase).mo8355a(C1847b.f6126b, j).mo8357a();
        }
    }

    /* renamed from: a */
    public static void m7123a(AppLovinAdBase appLovinAdBase, C1941j jVar) {
        if (appLovinAdBase != null && jVar != null) {
            jVar.mo8545X().mo8346a(appLovinAdBase).mo8355a(C1847b.f6127c, appLovinAdBase.getFetchLatencyMillis()).mo8355a(C1847b.f6128d, appLovinAdBase.getFetchResponseSize()).mo8357a();
        }
    }

    /* renamed from: a */
    private void m7124a(C1847b bVar) {
        synchronized (this.f6168d) {
            if (this.f6170f > 0) {
                this.f6167c.mo8355a(bVar, System.currentTimeMillis() - this.f6170f).mo8357a();
            }
        }
    }

    /* renamed from: a */
    public static void m7125a(C1855e eVar, AppLovinAdBase appLovinAdBase, C1941j jVar) {
        if (appLovinAdBase != null && jVar != null && eVar != null) {
            jVar.mo8545X().mo8346a(appLovinAdBase).mo8355a(C1847b.f6129e, eVar.mo8374c()).mo8355a(C1847b.f6130f, eVar.mo8375d()).mo8355a(C1847b.f6145u, eVar.mo8378g()).mo8355a(C1847b.f6146v, eVar.mo8379h()).mo8355a(C1847b.f6147w, eVar.mo8373b() ? 1 : 0).mo8357a();
        }
    }

    @TargetApi(24)
    /* renamed from: a */
    public void mo8359a() {
        this.f6167c.mo8355a(C1847b.f6134j, this.f6166b.mo8387a(C1859g.f6187b)).mo8355a(C1847b.f6133i, this.f6166b.mo8387a(C1859g.f6189d));
        synchronized (this.f6168d) {
            long j = 0;
            if (this.f6169e > 0) {
                long currentTimeMillis = System.currentTimeMillis();
                this.f6170f = currentTimeMillis;
                long H = currentTimeMillis - this.f6165a.mo8529H();
                long j2 = this.f6170f - this.f6169e;
                long j3 = C1992h.m7853a(this.f6165a.mo8527E()) ? 1 : 0;
                Activity a = this.f6165a.mo8565aa().mo8070a();
                if (C1991g.m7843f() && a != null && a.isInMultiWindowMode()) {
                    j = 1;
                }
                this.f6167c.mo8355a(C1847b.f6132h, H).mo8355a(C1847b.f6131g, j2).mo8355a(C1847b.f6140p, j3).mo8355a(C1847b.f6148x, j);
            }
        }
        this.f6167c.mo8357a();
    }

    /* renamed from: a */
    public void mo8360a(long j) {
        this.f6167c.mo8355a(C1847b.f6142r, j).mo8357a();
    }

    /* renamed from: b */
    public void mo8361b() {
        synchronized (this.f6168d) {
            if (this.f6171g < 1) {
                long currentTimeMillis = System.currentTimeMillis();
                this.f6171g = currentTimeMillis;
                if (this.f6170f > 0) {
                    this.f6167c.mo8355a(C1847b.f6137m, currentTimeMillis - this.f6170f).mo8357a();
                }
            }
        }
    }

    /* renamed from: b */
    public void mo8362b(long j) {
        this.f6167c.mo8355a(C1847b.f6141q, j).mo8357a();
    }

    /* renamed from: c */
    public void mo8363c() {
        m7124a(C1847b.f6135k);
    }

    /* renamed from: c */
    public void mo8364c(long j) {
        this.f6167c.mo8355a(C1847b.f6143s, j).mo8357a();
    }

    /* renamed from: d */
    public void mo8365d() {
        m7124a(C1847b.f6138n);
    }

    /* renamed from: d */
    public void mo8366d(long j) {
        synchronized (this.f6168d) {
            if (this.f6172h < 1) {
                this.f6172h = j;
                this.f6167c.mo8355a(C1847b.f6144t, j).mo8357a();
            }
        }
    }

    /* renamed from: e */
    public void mo8367e() {
        m7124a(C1847b.f6139o);
    }

    /* renamed from: f */
    public void mo8368f() {
        m7124a(C1847b.f6136l);
    }

    /* renamed from: g */
    public void mo8369g() {
        this.f6167c.mo8354a(C1847b.f6149y).mo8357a();
    }
}
