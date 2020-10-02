package com.applovin.impl.sdk;

import com.applovin.impl.sdk.p049ad.C1821d;
import com.applovin.impl.sdk.p049ad.C1833h;
import com.applovin.impl.sdk.p049ad.C1835j;
import com.applovin.impl.sdk.p050b.C1841c;
import com.applovin.impl.sdk.p052d.C1864a;
import com.applovin.impl.sdk.p052d.C1907s;
import com.applovin.nativeAds.AppLovinNativeAdLoadListener;
import com.applovin.sdk.AppLovinAdLoadListener;
import com.applovin.sdk.AppLovinErrorCodes;
import com.applovin.sdk.AppLovinSdkUtils;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/* renamed from: com.applovin.impl.sdk.t */
abstract class C1981t implements C1955n, AppLovinNativeAdLoadListener {

    /* renamed from: a */
    protected final C1941j f6628a;

    /* renamed from: b */
    protected final C1977q f6629b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final Object f6630c = new Object();

    /* renamed from: d */
    private final Map<C1821d, C1983u> f6631d = new HashMap();

    /* renamed from: e */
    private final Map<C1821d, C1983u> f6632e = new HashMap();
    /* access modifiers changed from: private */

    /* renamed from: f */
    public final Map<C1821d, Object> f6633f = new HashMap();

    /* renamed from: g */
    private final Set<C1821d> f6634g = new HashSet();

    C1981t(C1941j jVar) {
        this.f6628a = jVar;
        this.f6629b = jVar.mo8602v();
    }

    /* renamed from: b */
    private void m7784b(final C1821d dVar, AppLovinAdLoadListener appLovinAdLoadListener) {
        synchronized (this.f6630c) {
            if (this.f6633f.containsKey(dVar)) {
                this.f6629b.mo8745d("PreloadManager", "Possibly missing prior registered preload callback.");
            }
            this.f6633f.put(dVar, appLovinAdLoadListener);
        }
        final int intValue = ((Integer) this.f6628a.mo8549a(C1841c.f5825aY)).intValue();
        if (intValue > 0) {
            AppLovinSdkUtils.runOnUiThreadDelayed(new Runnable() {
                public void run() {
                    synchronized (C1981t.this.f6630c) {
                        Object obj = C1981t.this.f6633f.get(dVar);
                        if (obj != null) {
                            C1981t.this.f6633f.remove(dVar);
                            C1977q qVar = C1981t.this.f6629b;
                            qVar.mo8746e("PreloadManager", "Load callback for zone " + dVar + " timed out after " + intValue + " seconds");
                            C1981t.this.mo8327a(obj, dVar, AppLovinErrorCodes.FETCH_AD_TIMEOUT);
                        }
                    }
                }
            }, TimeUnit.SECONDS.toMillis((long) intValue));
        }
    }

    /* renamed from: j */
    private C1983u m7785j(C1821d dVar) {
        C1983u uVar;
        synchronized (this.f6630c) {
            uVar = this.f6631d.get(dVar);
            if (uVar == null) {
                uVar = new C1983u(dVar.mo8180f());
                this.f6631d.put(dVar, uVar);
            }
        }
        return uVar;
    }

    /* renamed from: k */
    private C1983u m7786k(C1821d dVar) {
        C1983u uVar;
        synchronized (this.f6630c) {
            uVar = this.f6632e.get(dVar);
            if (uVar == null) {
                uVar = new C1983u(dVar.mo8181g());
                this.f6632e.put(dVar, uVar);
            }
        }
        return uVar;
    }

    /* renamed from: l */
    private boolean m7787l(C1821d dVar) {
        boolean z;
        synchronized (this.f6630c) {
            C1983u j = m7785j(dVar);
            z = j != null && j.mo8758c();
        }
        return z;
    }

    /* renamed from: m */
    private C1983u m7788m(C1821d dVar) {
        synchronized (this.f6630c) {
            C1983u k = m7786k(dVar);
            if (k != null && k.mo8754a() > 0) {
                return k;
            }
            C1983u j = m7785j(dVar);
            return j;
        }
    }

    /* renamed from: n */
    private boolean m7789n(C1821d dVar) {
        boolean contains;
        synchronized (this.f6630c) {
            contains = this.f6634g.contains(dVar);
        }
        return contains;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public abstract C1821d mo8323a(C1835j jVar);

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public abstract C1864a mo8324a(C1821d dVar);

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public abstract void mo8327a(Object obj, C1821d dVar, int i);

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public abstract void mo8328a(Object obj, C1835j jVar);

    /* renamed from: a */
    public void mo8329a(LinkedHashSet<C1821d> linkedHashSet) {
        Map<C1821d, Object> map = this.f6633f;
        if (map != null && !map.isEmpty()) {
            synchronized (this.f6630c) {
                Iterator<C1821d> it = this.f6633f.keySet().iterator();
                while (it.hasNext()) {
                    C1821d next = it.next();
                    if (!next.mo8185j() && !linkedHashSet.contains(next)) {
                        Object obj = this.f6633f.get(next);
                        it.remove();
                        C1977q.m7751i("AppLovinAdService", "Failed to load ad for zone (" + next.mo8174a() + "). Please check that the zone has been added to your AppLovin account and given at least 30 minutes to fully propagate.");
                        mo8327a(obj, next, -7);
                    }
                }
            }
        }
    }

    /* renamed from: a */
    public boolean mo8330a(C1821d dVar, AppLovinAdLoadListener appLovinAdLoadListener) {
        boolean z;
        synchronized (this.f6630c) {
            if (!m7789n(dVar)) {
                m7784b(dVar, appLovinAdLoadListener);
                z = true;
            } else {
                z = false;
            }
        }
        return z;
    }

    /* renamed from: b */
    public void mo8331b(C1821d dVar, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            mo8339i(dVar);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo8751b(C1835j jVar) {
        Object obj;
        C1821d a = mo8323a(jVar);
        synchronized (this.f6630c) {
            obj = this.f6633f.get(a);
            this.f6633f.remove(a);
            this.f6634g.add(a);
            m7785j(a).mo8756a(jVar);
            C1977q qVar = this.f6629b;
            qVar.mo8742b("PreloadManager", "Ad enqueued: " + jVar);
        }
        if (obj != null) {
            C1977q qVar2 = this.f6629b;
            qVar2.mo8742b("PreloadManager", "Called additional callback regarding " + jVar);
            mo8328a(obj, (C1835j) new C1833h(a, this.f6628a));
        }
        C1977q qVar3 = this.f6629b;
        qVar3.mo8742b("PreloadManager", "Pulled ad from network and saved to preload cache: " + jVar);
    }

    /* renamed from: b */
    public boolean mo8332b(C1821d dVar) {
        return this.f6633f.containsKey(dVar);
    }

    /* renamed from: c */
    public C1835j mo8333c(C1821d dVar) {
        C1835j f;
        synchronized (this.f6630c) {
            C1983u m = m7788m(dVar);
            f = m != null ? m.mo8761f() : null;
        }
        return f;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo8752c(C1821d dVar, int i) {
        Object remove;
        C1977q qVar = this.f6629b;
        qVar.mo8742b("PreloadManager", "Failed to pre-load an ad of zone " + dVar + ", error code " + i);
        synchronized (this.f6630c) {
            remove = this.f6633f.remove(dVar);
            this.f6634g.add(dVar);
        }
        if (remove != null) {
            try {
                mo8327a(remove, dVar, i);
            } catch (Throwable th) {
                C1977q.m7747c("PreloadManager", "Encountered exception while invoking user callback", th);
            }
        }
    }

    /* renamed from: d */
    public C1835j mo8334d(C1821d dVar) {
        C1835j e;
        synchronized (this.f6630c) {
            C1983u m = m7788m(dVar);
            e = m != null ? m.mo8760e() : null;
        }
        return e;
    }

    /* renamed from: e */
    public C1835j mo8335e(C1821d dVar) {
        C1833h hVar;
        StringBuilder sb;
        String str;
        C1833h hVar2;
        synchronized (this.f6630c) {
            C1983u j = m7785j(dVar);
            hVar = null;
            if (j != null) {
                C1983u k = m7786k(dVar);
                if (k.mo8758c()) {
                    hVar2 = new C1833h(dVar, this.f6628a);
                } else if (j.mo8754a() > 0) {
                    k.mo8756a(j.mo8760e());
                    hVar2 = new C1833h(dVar, this.f6628a);
                }
                hVar = hVar2;
            }
        }
        C1977q qVar = this.f6629b;
        if (hVar != null) {
            str = "Retrieved ad of zone ";
        } else {
            sb = new StringBuilder();
            str = "Unable to retrieve ad of zone ";
        }
        sb.append(str);
        sb.append(dVar);
        sb.append("...");
        qVar.mo8742b("PreloadManager", sb.toString());
        return hVar;
    }

    /* renamed from: f */
    public void mo8336f(C1821d dVar) {
        if (dVar != null) {
            int i = 0;
            synchronized (this.f6630c) {
                C1983u j = m7785j(dVar);
                if (j != null) {
                    i = j.mo8757b() - j.mo8754a();
                }
            }
            mo8331b(dVar, i);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0021, code lost:
        return r2;
     */
    /* renamed from: g */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean mo8337g(com.applovin.impl.sdk.p049ad.C1821d r4) {
        /*
            r3 = this;
            java.lang.Object r0 = r3.f6630c
            monitor-enter(r0)
            com.applovin.impl.sdk.u r1 = r3.m7786k(r4)     // Catch:{ all -> 0x0022 }
            r2 = 1
            if (r1 == 0) goto L_0x0012
            int r1 = r1.mo8754a()     // Catch:{ all -> 0x0022 }
            if (r1 <= 0) goto L_0x0012
            monitor-exit(r0)     // Catch:{ all -> 0x0022 }
            return r2
        L_0x0012:
            com.applovin.impl.sdk.u r4 = r3.m7785j(r4)     // Catch:{ all -> 0x0022 }
            if (r4 == 0) goto L_0x001f
            boolean r4 = r4.mo8759d()     // Catch:{ all -> 0x0022 }
            if (r4 != 0) goto L_0x001f
            goto L_0x0020
        L_0x001f:
            r2 = 0
        L_0x0020:
            monitor-exit(r0)     // Catch:{ all -> 0x0022 }
            return r2
        L_0x0022:
            r4 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0022 }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.sdk.C1981t.mo8337g(com.applovin.impl.sdk.ad.d):boolean");
    }

    /* renamed from: h */
    public void mo8338h(C1821d dVar) {
        synchronized (this.f6630c) {
            C1983u j = m7785j(dVar);
            if (j != null) {
                j.mo8755a(dVar.mo8180f());
            } else {
                this.f6631d.put(dVar, new C1983u(dVar.mo8180f()));
            }
            C1983u k = m7786k(dVar);
            if (k != null) {
                k.mo8755a(dVar.mo8181g());
            } else {
                this.f6632e.put(dVar, new C1983u(dVar.mo8181g()));
            }
        }
    }

    /* renamed from: i */
    public void mo8339i(C1821d dVar) {
        if (((Boolean) this.f6628a.mo8549a(C1841c.f5826aZ)).booleanValue() && !m7787l(dVar)) {
            C1977q qVar = this.f6629b;
            qVar.mo8742b("PreloadManager", "Preloading ad for zone " + dVar + "...");
            this.f6628a.mo8533L().mo8476a(mo8324a(dVar), C1907s.C1909a.MAIN, 500);
        }
    }
}
