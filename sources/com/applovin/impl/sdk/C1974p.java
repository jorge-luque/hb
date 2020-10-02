package com.applovin.impl.sdk;

import com.applovin.impl.mediation.p047d.C1729c;
import com.applovin.impl.sdk.p050b.C1841c;
import com.applovin.sdk.AppLovinSdkUtils;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.applovin.impl.sdk.p */
public class C1974p {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final C1941j f6611a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final AtomicBoolean f6612b = new AtomicBoolean();
    /* access modifiers changed from: private */

    /* renamed from: c */
    public long f6613c;

    /* renamed from: d */
    private final Object f6614d = new Object();
    /* access modifiers changed from: private */

    /* renamed from: e */
    public final AtomicBoolean f6615e = new AtomicBoolean();
    /* access modifiers changed from: private */

    /* renamed from: f */
    public long f6616f;

    C1974p(C1941j jVar) {
        this.f6611a = jVar;
    }

    /* renamed from: a */
    public void mo8731a(final Object obj) {
        this.f6611a.mo8571ag().mo8619a(obj);
        if (!C1729c.m6623a(obj) && this.f6612b.compareAndSet(false, true)) {
            this.f6613c = System.currentTimeMillis();
            C1977q v = this.f6611a.mo8602v();
            v.mo8742b("FullScreenAdTracker", "Setting fullscreen ad displayed: " + this.f6613c);
            this.f6611a.mo8570af().sendBroadcastWithAdObject("com.applovin.fullscreen_ad_displayed", obj);
            final long longValue = ((Long) this.f6611a.mo8549a(C1841c.f5954cw)).longValue();
            if (longValue >= 0) {
                AppLovinSdkUtils.runOnUiThreadDelayed(new Runnable() {
                    public void run() {
                        if (C1974p.this.f6612b.get() && System.currentTimeMillis() - C1974p.this.f6613c >= longValue) {
                            C1974p.this.f6611a.mo8602v().mo8742b("FullScreenAdTracker", "Resetting \"display\" state...");
                            C1974p.this.mo8734b(obj);
                        }
                    }
                }, longValue);
            }
        }
    }

    /* renamed from: a */
    public void mo8732a(boolean z) {
        synchronized (this.f6614d) {
            this.f6615e.set(z);
            if (z) {
                this.f6616f = System.currentTimeMillis();
                C1977q v = this.f6611a.mo8602v();
                v.mo8742b("FullScreenAdTracker", "Setting fullscreen ad pending display: " + this.f6616f);
                final long longValue = ((Long) this.f6611a.mo8549a(C1841c.f5953cv)).longValue();
                if (longValue >= 0) {
                    AppLovinSdkUtils.runOnUiThreadDelayed(new Runnable() {
                        public void run() {
                            if (C1974p.this.mo8733a() && System.currentTimeMillis() - C1974p.this.f6616f >= longValue) {
                                C1974p.this.f6611a.mo8602v().mo8742b("FullScreenAdTracker", "Resetting \"pending display\" state...");
                                C1974p.this.f6615e.set(false);
                            }
                        }
                    }, longValue);
                }
            } else {
                this.f6616f = 0;
                C1977q v2 = this.f6611a.mo8602v();
                v2.mo8742b("FullScreenAdTracker", "Setting fullscreen ad not pending display: " + System.currentTimeMillis());
            }
        }
    }

    /* renamed from: a */
    public boolean mo8733a() {
        return this.f6615e.get();
    }

    /* renamed from: b */
    public void mo8734b(Object obj) {
        this.f6611a.mo8571ag().mo8620b(obj);
        if (!C1729c.m6623a(obj) && this.f6612b.compareAndSet(true, false)) {
            C1977q v = this.f6611a.mo8602v();
            v.mo8742b("FullScreenAdTracker", "Setting fullscreen ad hidden: " + System.currentTimeMillis());
            this.f6611a.mo8570af().sendBroadcastWithAdObject("com.applovin.fullscreen_ad_hidden", obj);
        }
    }

    /* renamed from: b */
    public boolean mo8735b() {
        return this.f6612b.get();
    }
}
