package com.chartboost.sdk.impl;

import com.chartboost.sdk.C2242k;
import com.chartboost.sdk.Libraries.C2078f;
import com.chartboost.sdk.Libraries.CBLogging;
import com.chartboost.sdk.Model.C2087b;
import com.chartboost.sdk.Model.C2092g;
import com.chartboost.sdk.Model.C2093h;
import com.chartboost.sdk.Model.CBError;
import com.chartboost.sdk.Tracking.C2098a;
import com.chartboost.sdk.impl.C2128c1;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONObject;

/* renamed from: com.chartboost.sdk.impl.o */
public class C2186o implements C2128c1.C2129a {

    /* renamed from: a */
    public C2181n f7380a;

    /* renamed from: b */
    private final C2078f f7381b;

    /* renamed from: c */
    private final C2218v0 f7382c;

    /* renamed from: d */
    private final C2092g f7383d;

    /* renamed from: e */
    private final C2098a f7384e;

    /* renamed from: f */
    private final AtomicReference<C2093h> f7385f;

    /* renamed from: g */
    private int f7386g = 1;

    /* renamed from: h */
    private int f7387h = 0;

    /* renamed from: i */
    private long f7388i = 0;

    /* renamed from: j */
    private C2128c1 f7389j = null;

    /* renamed from: k */
    private AtomicInteger f7390k = null;

    public C2186o(C2181n nVar, C2078f fVar, C2218v0 v0Var, C2092g gVar, C2098a aVar, AtomicReference<C2093h> atomicReference) {
        this.f7380a = nVar;
        this.f7381b = fVar;
        this.f7382c = v0Var;
        this.f7383d = gVar;
        this.f7384e = aVar;
        this.f7385f = atomicReference;
    }

    /* renamed from: a */
    private void m8703a(C2093h hVar) {
        boolean z = hVar.f7023w;
        if ((this.f7387h == 1 && !(!z && hVar.f7005e)) || (this.f7387h == 2 && !z)) {
            CBLogging.m8152a("Prefetcher", "Change state to IDLE");
            this.f7386g = 1;
            this.f7387h = 0;
            this.f7388i = 0;
            this.f7389j = null;
            AtomicInteger atomicInteger = this.f7390k;
            this.f7390k = null;
            if (atomicInteger != null) {
                this.f7380a.mo9434a(atomicInteger);
            }
        }
    }

    /* renamed from: b */
    public synchronized void mo9445b() {
        try {
            CBLogging.m8156c("Chartboost SDK", "Sdk Version = 8.0.3, Commit: a33bc81418271394db93ac3fa0ad3842e5511659");
            C2093h hVar = this.f7385f.get();
            m8703a(hVar);
            if (!hVar.f7003c && !hVar.f7002b) {
                if (C2242k.f7620t) {
                    if (this.f7386g == 3) {
                        if (this.f7390k.get() <= 0) {
                            CBLogging.m8152a("Prefetcher", "Change state to COOLDOWN");
                            this.f7386g = 4;
                            this.f7390k = null;
                        } else {
                            return;
                        }
                    }
                    if (this.f7386g == 4) {
                        if (this.f7388i - System.nanoTime() > 0) {
                            CBLogging.m8152a("Prefetcher", "Prefetch session is still active. Won't be making any new prefetch until the prefetch session expires");
                            return;
                        }
                        CBLogging.m8152a("Prefetcher", "Change state to IDLE");
                        this.f7386g = 1;
                        this.f7387h = 0;
                        this.f7388i = 0;
                    }
                    if (this.f7386g == 1) {
                        if (hVar.f7023w) {
                            C2133d1 d1Var = new C2133d1(hVar.f6999D, this.f7383d, this.f7384e, 2, this);
                            d1Var.mo9315a("cache_assets", this.f7381b.mo9096d(), 0);
                            d1Var.f7130m = true;
                            CBLogging.m8152a("Prefetcher", "Change state to AWAIT_PREFETCH_RESPONSE");
                            this.f7386g = 2;
                            this.f7387h = 2;
                            this.f7388i = System.nanoTime() + TimeUnit.MINUTES.toNanos((long) hVar.f6996A);
                            this.f7389j = d1Var;
                        } else if (hVar.f7005e) {
                            C2128c1 c1Var = new C2128c1("https://live.chartboost.com", "/api/video-prefetch", this.f7383d, this.f7384e, 2, this);
                            c1Var.mo9294a("local-videos", (Object) this.f7381b.mo9094c());
                            c1Var.f7130m = true;
                            CBLogging.m8152a("Prefetcher", "Change state to AWAIT_PREFETCH_RESPONSE");
                            this.f7386g = 2;
                            this.f7387h = 1;
                            this.f7388i = System.nanoTime() + TimeUnit.MINUTES.toNanos((long) hVar.f7009i);
                            this.f7389j = c1Var;
                        } else {
                            CBLogging.m8154b("Prefetcher", "Did not prefetch because neither native nor webview are enabled.");
                            return;
                        }
                        this.f7382c.mo9524a(this.f7389j);
                    } else {
                        return;
                    }
                }
            }
            mo9444a();
        } catch (Exception e) {
            if (this.f7386g == 2) {
                CBLogging.m8152a("Prefetcher", "Change state to COOLDOWN");
                this.f7386g = 4;
                this.f7389j = null;
            }
            C2098a.m8288a(C2186o.class, "prefetch", e);
        }
    }

    /* renamed from: a */
    public synchronized void mo9444a() {
        int i = this.f7386g;
        if (i == 2) {
            CBLogging.m8152a("Prefetcher", "Change state to COOLDOWN");
            this.f7386g = 4;
            this.f7389j = null;
        } else if (i == 3) {
            CBLogging.m8152a("Prefetcher", "Change state to COOLDOWN");
            this.f7386g = 4;
            AtomicInteger atomicInteger = this.f7390k;
            this.f7390k = null;
            if (atomicInteger != null) {
                this.f7380a.mo9434a(atomicInteger);
            }
        }
    }

    /* renamed from: a */
    public synchronized void mo9300a(C2128c1 c1Var, JSONObject jSONObject) {
        try {
            if (this.f7386g == 2) {
                if (c1Var == this.f7389j) {
                    CBLogging.m8152a("Prefetcher", "Change state to DOWNLOAD_ASSETS");
                    this.f7386g = 3;
                    this.f7389j = null;
                    this.f7390k = new AtomicInteger();
                    if (jSONObject != null) {
                        CBLogging.m8152a("Prefetcher", "Got Asset list for Prefetch from server :)" + jSONObject);
                        if (this.f7387h == 1) {
                            this.f7380a.mo9432a(3, C2087b.m8221b(jSONObject), this.f7390k, (C2167j) null);
                        } else if (this.f7387h == 2) {
                            this.f7380a.mo9432a(3, C2087b.m8219a(jSONObject, this.f7385f.get().f7020t), this.f7390k, (C2167j) null);
                        }
                    }
                } else {
                    return;
                }
            } else {
                return;
            }
        } catch (Exception e) {
            C2098a.m8288a(C2186o.class, "onSuccess", e);
        }
    }

    /* renamed from: a */
    public synchronized void mo9299a(C2128c1 c1Var, CBError cBError) {
        if (this.f7386g == 2) {
            if (c1Var == this.f7389j) {
                this.f7389j = null;
                CBLogging.m8152a("Prefetcher", "Change state to COOLDOWN");
                this.f7386g = 4;
            }
        }
    }
}
