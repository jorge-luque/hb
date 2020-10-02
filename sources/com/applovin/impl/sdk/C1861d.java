package com.applovin.impl.sdk;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.applovin.impl.sdk.AppLovinBroadcastManager;
import com.applovin.impl.sdk.p050b.C1840b;
import com.applovin.impl.sdk.utils.C2026p;
import java.lang.ref.WeakReference;
import java.util.Map;

/* renamed from: com.applovin.impl.sdk.d */
public class C1861d implements AppLovinBroadcastManager.Receiver {

    /* renamed from: a */
    private C2026p f6210a;

    /* renamed from: b */
    private final Object f6211b = new Object();

    /* renamed from: c */
    private final C1941j f6212c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final WeakReference<C1863a> f6213d;

    /* renamed from: e */
    private long f6214e;

    /* renamed from: com.applovin.impl.sdk.d$a */
    public interface C1863a {
        void onAdRefresh();
    }

    public C1861d(C1941j jVar, C1863a aVar) {
        this.f6213d = new WeakReference<>(aVar);
        this.f6212c = jVar;
    }

    /* access modifiers changed from: private */
    /* renamed from: h */
    public void m7170h() {
        synchronized (this.f6211b) {
            this.f6210a = null;
            if (!((Boolean) this.f6212c.mo8549a(C1840b.f5783u)).booleanValue()) {
                this.f6212c.mo8570af().unregisterReceiver(this);
            }
        }
    }

    /* renamed from: i */
    private void m7171i() {
        if (((Boolean) this.f6212c.mo8549a(C1840b.f5782t)).booleanValue()) {
            mo8400d();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
        return;
     */
    /* renamed from: j */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m7172j() {
        /*
            r4 = this;
            com.applovin.impl.sdk.j r0 = r4.f6212c
            com.applovin.impl.sdk.b.c<java.lang.Boolean> r1 = com.applovin.impl.sdk.p050b.C1840b.f5782t
            java.lang.Object r0 = r0.mo8549a(r1)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L_0x003c
            java.lang.Object r0 = r4.f6211b
            monitor-enter(r0)
            com.applovin.impl.sdk.j r1 = r4.f6212c     // Catch:{ all -> 0x0039 }
            com.applovin.impl.sdk.w r1 = r1.mo8546Y()     // Catch:{ all -> 0x0039 }
            boolean r1 = r1.mo8846a()     // Catch:{ all -> 0x0039 }
            if (r1 == 0) goto L_0x002e
            com.applovin.impl.sdk.j r1 = r4.f6212c     // Catch:{ all -> 0x0039 }
            com.applovin.impl.sdk.q r1 = r1.mo8602v()     // Catch:{ all -> 0x0039 }
            java.lang.String r2 = "AdRefreshManager"
            java.lang.String r3 = "Waiting for the application to enter foreground to resume the timer."
            r1.mo8742b(r2, r3)     // Catch:{ all -> 0x0039 }
            monitor-exit(r0)     // Catch:{ all -> 0x0039 }
            return
        L_0x002e:
            com.applovin.impl.sdk.utils.p r1 = r4.f6210a     // Catch:{ all -> 0x0039 }
            if (r1 == 0) goto L_0x0037
            com.applovin.impl.sdk.utils.p r1 = r4.f6210a     // Catch:{ all -> 0x0039 }
            r1.mo8813c()     // Catch:{ all -> 0x0039 }
        L_0x0037:
            monitor-exit(r0)     // Catch:{ all -> 0x0039 }
            goto L_0x003c
        L_0x0039:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0039 }
            throw r1
        L_0x003c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.sdk.C1861d.m7172j():void");
    }

    /* renamed from: a */
    public void mo8396a(long j) {
        synchronized (this.f6211b) {
            mo8399c();
            this.f6214e = j;
            this.f6210a = C2026p.m7968a(j, this.f6212c, new Runnable() {
                public void run() {
                    C1861d.this.m7170h();
                    C1863a aVar = (C1863a) C1861d.this.f6213d.get();
                    if (aVar != null) {
                        aVar.onAdRefresh();
                    }
                }
            });
            if (!((Boolean) this.f6212c.mo8549a(C1840b.f5783u)).booleanValue()) {
                this.f6212c.mo8570af().registerReceiver(this, new IntentFilter("com.applovin.application_paused"));
                this.f6212c.mo8570af().registerReceiver(this, new IntentFilter("com.applovin.application_resumed"));
                this.f6212c.mo8570af().registerReceiver(this, new IntentFilter("com.applovin.fullscreen_ad_displayed"));
                this.f6212c.mo8570af().registerReceiver(this, new IntentFilter("com.applovin.fullscreen_ad_hidden"));
            }
            if (((Boolean) this.f6212c.mo8549a(C1840b.f5782t)).booleanValue() && (this.f6212c.mo8547Z().mo8735b() || this.f6212c.mo8546Y().mo8846a())) {
                this.f6210a.mo8812b();
            }
        }
    }

    /* renamed from: a */
    public boolean mo8397a() {
        boolean z;
        synchronized (this.f6211b) {
            z = this.f6210a != null;
        }
        return z;
    }

    /* renamed from: b */
    public long mo8398b() {
        long a;
        synchronized (this.f6211b) {
            a = this.f6210a != null ? this.f6210a.mo8811a() : -1;
        }
        return a;
    }

    /* renamed from: c */
    public void mo8399c() {
        synchronized (this.f6211b) {
            if (this.f6210a != null) {
                this.f6210a.mo8814d();
                m7170h();
            }
        }
    }

    /* renamed from: d */
    public void mo8400d() {
        synchronized (this.f6211b) {
            if (this.f6210a != null) {
                this.f6210a.mo8812b();
            }
        }
    }

    /* renamed from: e */
    public void mo8401e() {
        synchronized (this.f6211b) {
            if (this.f6210a != null) {
                this.f6210a.mo8813c();
            }
        }
    }

    /* renamed from: f */
    public void mo8402f() {
        if (((Boolean) this.f6212c.mo8549a(C1840b.f5781s)).booleanValue()) {
            mo8400d();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x005e, code lost:
        if (r2 == false) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0060, code lost:
        r0 = (com.applovin.impl.sdk.C1861d.C1863a) r9.f6213d.get();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0068, code lost:
        if (r0 == null) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x006a, code lost:
        r0.onAdRefresh();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:?, code lost:
        return;
     */
    /* renamed from: g */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo8403g() {
        /*
            r9 = this;
            com.applovin.impl.sdk.j r0 = r9.f6212c
            com.applovin.impl.sdk.b.c<java.lang.Boolean> r1 = com.applovin.impl.sdk.p050b.C1840b.f5781s
            java.lang.Object r0 = r0.mo8549a(r1)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L_0x0071
            java.lang.Object r0 = r9.f6211b
            monitor-enter(r0)
            com.applovin.impl.sdk.j r1 = r9.f6212c     // Catch:{ all -> 0x006e }
            com.applovin.impl.sdk.p r1 = r1.mo8547Z()     // Catch:{ all -> 0x006e }
            boolean r1 = r1.mo8735b()     // Catch:{ all -> 0x006e }
            if (r1 == 0) goto L_0x002e
            com.applovin.impl.sdk.j r1 = r9.f6212c     // Catch:{ all -> 0x006e }
            com.applovin.impl.sdk.q r1 = r1.mo8602v()     // Catch:{ all -> 0x006e }
            java.lang.String r2 = "AdRefreshManager"
            java.lang.String r3 = "Waiting for the full screen ad to be dismissed to resume the timer."
            r1.mo8742b(r2, r3)     // Catch:{ all -> 0x006e }
            monitor-exit(r0)     // Catch:{ all -> 0x006e }
            return
        L_0x002e:
            com.applovin.impl.sdk.utils.p r1 = r9.f6210a     // Catch:{ all -> 0x006e }
            r2 = 0
            if (r1 == 0) goto L_0x005d
            long r3 = r9.f6214e     // Catch:{ all -> 0x006e }
            long r5 = r9.mo8398b()     // Catch:{ all -> 0x006e }
            long r3 = r3 - r5
            com.applovin.impl.sdk.j r1 = r9.f6212c     // Catch:{ all -> 0x006e }
            com.applovin.impl.sdk.b.c<java.lang.Long> r5 = com.applovin.impl.sdk.p050b.C1840b.f5780r     // Catch:{ all -> 0x006e }
            java.lang.Object r1 = r1.mo8549a(r5)     // Catch:{ all -> 0x006e }
            java.lang.Long r1 = (java.lang.Long) r1     // Catch:{ all -> 0x006e }
            long r5 = r1.longValue()     // Catch:{ all -> 0x006e }
            r7 = 0
            int r1 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r1 < 0) goto L_0x0058
            int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r1 <= 0) goto L_0x0058
            r9.mo8399c()     // Catch:{ all -> 0x006e }
            r1 = 1
            r2 = 1
            goto L_0x005d
        L_0x0058:
            com.applovin.impl.sdk.utils.p r1 = r9.f6210a     // Catch:{ all -> 0x006e }
            r1.mo8813c()     // Catch:{ all -> 0x006e }
        L_0x005d:
            monitor-exit(r0)     // Catch:{ all -> 0x006e }
            if (r2 == 0) goto L_0x0071
            java.lang.ref.WeakReference<com.applovin.impl.sdk.d$a> r0 = r9.f6213d
            java.lang.Object r0 = r0.get()
            com.applovin.impl.sdk.d$a r0 = (com.applovin.impl.sdk.C1861d.C1863a) r0
            if (r0 == 0) goto L_0x0071
            r0.onAdRefresh()
            goto L_0x0071
        L_0x006e:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x006e }
            throw r1
        L_0x0071:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.sdk.C1861d.mo8403g():void");
    }

    public void onReceive(Context context, Intent intent, Map<String, Object> map) {
        String action = intent.getAction();
        if ("com.applovin.application_paused".equals(action)) {
            mo8402f();
        } else if ("com.applovin.application_resumed".equals(action)) {
            mo8403g();
        } else if ("com.applovin.fullscreen_ad_displayed".equals(action)) {
            m7171i();
        } else if ("com.applovin.fullscreen_ad_hidden".equals(action)) {
            m7172j();
        }
    }
}
