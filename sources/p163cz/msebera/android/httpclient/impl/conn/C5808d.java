package p163cz.msebera.android.httpclient.impl.conn;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import p163cz.msebera.android.httpclient.C5754h;
import p163cz.msebera.android.httpclient.conn.C5624b;
import p163cz.msebera.android.httpclient.conn.C5626d;
import p163cz.msebera.android.httpclient.conn.C5627e;
import p163cz.msebera.android.httpclient.conn.C5635m;
import p163cz.msebera.android.httpclient.conn.p174r.C5645b;
import p163cz.msebera.android.httpclient.conn.p175s.C5660i;
import p163cz.msebera.android.httpclient.p177d0.C5695b;
import p163cz.msebera.android.httpclient.p187k0.C5886a;
import p163cz.msebera.android.httpclient.p187k0.C5887b;

@Deprecated
/* renamed from: cz.msebera.android.httpclient.impl.conn.d */
/* compiled from: BasicClientConnectionManager */
public class C5808d implements C5624b {

    /* renamed from: g */
    private static final AtomicLong f14986g = new AtomicLong();

    /* renamed from: a */
    public C5695b f14987a = new C5695b(C5808d.class);

    /* renamed from: b */
    private final C5660i f14988b;

    /* renamed from: c */
    private final C5626d f14989c;

    /* renamed from: d */
    private C5815j f14990d;

    /* renamed from: e */
    private C5819n f14991e;

    /* renamed from: f */
    private volatile boolean f14992f;

    /* renamed from: cz.msebera.android.httpclient.impl.conn.d$a */
    /* compiled from: BasicClientConnectionManager */
    class C5809a implements C5627e {

        /* renamed from: a */
        final /* synthetic */ C5645b f14993a;

        /* renamed from: b */
        final /* synthetic */ Object f14994b;

        C5809a(C5645b bVar, Object obj) {
            this.f14993a = bVar;
            this.f14994b = obj;
        }

        /* renamed from: a */
        public C5635m mo33017a(long j, TimeUnit timeUnit) {
            return C5808d.this.mo33550b(this.f14993a, this.f14994b);
        }

        /* renamed from: a */
        public void mo33018a() {
        }
    }

    public C5808d(C5660i iVar) {
        C5886a.m18894a(iVar, "Scheme registry");
        this.f14988b = iVar;
        this.f14989c = mo33549a(iVar);
    }

    /* renamed from: b */
    private void m18573b() {
        C5887b.m18902a(!this.f14992f, "Connection manager has been shut down");
    }

    /* renamed from: a */
    public C5660i mo33010a() {
        return this.f14988b;
    }

    /* access modifiers changed from: protected */
    public void finalize() throws Throwable {
        try {
            shutdown();
        } finally {
            super.finalize();
        }
    }

    public void shutdown() {
        synchronized (this) {
            this.f14992f = true;
            try {
                if (this.f14990d != null) {
                    this.f14990d.mo33555d();
                }
            } finally {
                this.f14990d = null;
                this.f14991e = null;
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public C5626d mo33549a(C5660i iVar) {
        return new C5811f(iVar);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public C5635m mo33550b(C5645b bVar, Object obj) {
        C5819n nVar;
        C5886a.m18894a(bVar, "Route");
        synchronized (this) {
            m18573b();
            if (this.f14987a.mo33168a()) {
                C5695b bVar2 = this.f14987a;
                bVar2.mo33166a("Get connection for route " + bVar);
            }
            C5887b.m18902a(this.f14991e == null, "Invalid use of BasicClientConnManager: connection still allocated.\nMake sure to release the connection before allocating another one.");
            if (this.f14990d != null && !this.f14990d.mo33557f().equals(bVar)) {
                this.f14990d.mo33555d();
                this.f14990d = null;
            }
            if (this.f14990d == null) {
                this.f14990d = new C5815j(this.f14987a, Long.toString(f14986g.getAndIncrement()), bVar, this.f14989c.mo33014a(), 0, TimeUnit.MILLISECONDS);
            }
            if (this.f14990d.mo33430a(System.currentTimeMillis())) {
                this.f14990d.mo33555d();
                this.f14990d.mo33558g().mo33074h();
            }
            nVar = new C5819n(this, this.f14989c, this.f14990d);
            this.f14991e = nVar;
        }
        return nVar;
    }

    /* renamed from: a */
    public final C5627e mo33009a(C5645b bVar, Object obj) {
        return new C5809a(bVar, obj);
    }

    /* renamed from: a */
    private void m18572a(C5754h hVar) {
        try {
            hVar.shutdown();
        } catch (IOException e) {
            if (this.f14987a.mo33168a()) {
                this.f14987a.mo33167a("I/O exception shutting down connection", e);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00bc, code lost:
        return;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo33011a(p163cz.msebera.android.httpclient.conn.C5635m r5, long r6, java.util.concurrent.TimeUnit r8) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof p163cz.msebera.android.httpclient.impl.conn.C5819n
            java.lang.String r1 = "Connection class mismatch, connection not obtained from this manager"
            p163cz.msebera.android.httpclient.p187k0.C5886a.m18896a((boolean) r0, (java.lang.String) r1)
            r0 = r5
            cz.msebera.android.httpclient.impl.conn.n r0 = (p163cz.msebera.android.httpclient.impl.conn.C5819n) r0
            monitor-enter(r0)
            cz.msebera.android.httpclient.d0.b r1 = r4.f14987a     // Catch:{ all -> 0x00d1 }
            boolean r1 = r1.mo33168a()     // Catch:{ all -> 0x00d1 }
            if (r1 == 0) goto L_0x0029
            cz.msebera.android.httpclient.d0.b r1 = r4.f14987a     // Catch:{ all -> 0x00d1 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x00d1 }
            r2.<init>()     // Catch:{ all -> 0x00d1 }
            java.lang.String r3 = "Releasing connection "
            r2.append(r3)     // Catch:{ all -> 0x00d1 }
            r2.append(r5)     // Catch:{ all -> 0x00d1 }
            java.lang.String r5 = r2.toString()     // Catch:{ all -> 0x00d1 }
            r1.mo33166a(r5)     // Catch:{ all -> 0x00d1 }
        L_0x0029:
            cz.msebera.android.httpclient.impl.conn.j r5 = r0.mo33562w()     // Catch:{ all -> 0x00d1 }
            if (r5 != 0) goto L_0x0031
            monitor-exit(r0)     // Catch:{ all -> 0x00d1 }
            return
        L_0x0031:
            cz.msebera.android.httpclient.conn.b r5 = r0.mo33561v()     // Catch:{ all -> 0x00d1 }
            if (r5 != r4) goto L_0x0039
            r5 = 1
            goto L_0x003a
        L_0x0039:
            r5 = 0
        L_0x003a:
            java.lang.String r1 = "Connection not obtained from this manager"
            p163cz.msebera.android.httpclient.p187k0.C5887b.m18902a((boolean) r5, (java.lang.String) r1)     // Catch:{ all -> 0x00d1 }
            monitor-enter(r4)     // Catch:{ all -> 0x00d1 }
            boolean r5 = r4.f14992f     // Catch:{ all -> 0x00ce }
            if (r5 == 0) goto L_0x004a
            r4.m18572a((p163cz.msebera.android.httpclient.C5754h) r0)     // Catch:{ all -> 0x00ce }
            monitor-exit(r4)     // Catch:{ all -> 0x00ce }
            monitor-exit(r0)     // Catch:{ all -> 0x00d1 }
            return
        L_0x004a:
            r5 = 0
            boolean r1 = r0.isOpen()     // Catch:{ all -> 0x00bd }
            if (r1 == 0) goto L_0x005a
            boolean r1 = r0.mo33563x()     // Catch:{ all -> 0x00bd }
            if (r1 != 0) goto L_0x005a
            r4.m18572a((p163cz.msebera.android.httpclient.C5754h) r0)     // Catch:{ all -> 0x00bd }
        L_0x005a:
            boolean r1 = r0.mo33563x()     // Catch:{ all -> 0x00bd }
            if (r1 == 0) goto L_0x00ab
            cz.msebera.android.httpclient.impl.conn.j r1 = r4.f14990d     // Catch:{ all -> 0x00bd }
            if (r8 == 0) goto L_0x0066
            r2 = r8
            goto L_0x0068
        L_0x0066:
            java.util.concurrent.TimeUnit r2 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch:{ all -> 0x00bd }
        L_0x0068:
            r1.mo33428a(r6, r2)     // Catch:{ all -> 0x00bd }
            cz.msebera.android.httpclient.d0.b r1 = r4.f14987a     // Catch:{ all -> 0x00bd }
            boolean r1 = r1.mo33168a()     // Catch:{ all -> 0x00bd }
            if (r1 == 0) goto L_0x00ab
            r1 = 0
            int r3 = (r6 > r1 ? 1 : (r6 == r1 ? 0 : -1))
            if (r3 <= 0) goto L_0x0093
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x00bd }
            r1.<init>()     // Catch:{ all -> 0x00bd }
            java.lang.String r2 = "for "
            r1.append(r2)     // Catch:{ all -> 0x00bd }
            r1.append(r6)     // Catch:{ all -> 0x00bd }
            java.lang.String r6 = " "
            r1.append(r6)     // Catch:{ all -> 0x00bd }
            r1.append(r8)     // Catch:{ all -> 0x00bd }
            java.lang.String r6 = r1.toString()     // Catch:{ all -> 0x00bd }
            goto L_0x0095
        L_0x0093:
            java.lang.String r6 = "indefinitely"
        L_0x0095:
            cz.msebera.android.httpclient.d0.b r7 = r4.f14987a     // Catch:{ all -> 0x00bd }
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x00bd }
            r8.<init>()     // Catch:{ all -> 0x00bd }
            java.lang.String r1 = "Connection can be kept alive "
            r8.append(r1)     // Catch:{ all -> 0x00bd }
            r8.append(r6)     // Catch:{ all -> 0x00bd }
            java.lang.String r6 = r8.toString()     // Catch:{ all -> 0x00bd }
            r7.mo33166a(r6)     // Catch:{ all -> 0x00bd }
        L_0x00ab:
            r0.mo33560u()     // Catch:{ all -> 0x00ce }
            r4.f14991e = r5     // Catch:{ all -> 0x00ce }
            cz.msebera.android.httpclient.impl.conn.j r6 = r4.f14990d     // Catch:{ all -> 0x00ce }
            boolean r6 = r6.mo33559h()     // Catch:{ all -> 0x00ce }
            if (r6 == 0) goto L_0x00ba
            r4.f14990d = r5     // Catch:{ all -> 0x00ce }
        L_0x00ba:
            monitor-exit(r4)     // Catch:{ all -> 0x00ce }
            monitor-exit(r0)     // Catch:{ all -> 0x00d1 }
            return
        L_0x00bd:
            r6 = move-exception
            r0.mo33560u()     // Catch:{ all -> 0x00ce }
            r4.f14991e = r5     // Catch:{ all -> 0x00ce }
            cz.msebera.android.httpclient.impl.conn.j r7 = r4.f14990d     // Catch:{ all -> 0x00ce }
            boolean r7 = r7.mo33559h()     // Catch:{ all -> 0x00ce }
            if (r7 == 0) goto L_0x00cd
            r4.f14990d = r5     // Catch:{ all -> 0x00ce }
        L_0x00cd:
            throw r6     // Catch:{ all -> 0x00ce }
        L_0x00ce:
            r5 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x00ce }
            throw r5     // Catch:{ all -> 0x00d1 }
        L_0x00d1:
            r5 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x00d1 }
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: p163cz.msebera.android.httpclient.impl.conn.C5808d.mo33011a(cz.msebera.android.httpclient.conn.m, long, java.util.concurrent.TimeUnit):void");
    }
}
