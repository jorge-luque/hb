package p163cz.msebera.android.httpclient.impl.conn.p185r;

import java.util.concurrent.TimeUnit;
import p163cz.msebera.android.httpclient.conn.C5624b;
import p163cz.msebera.android.httpclient.conn.C5626d;
import p163cz.msebera.android.httpclient.conn.C5627e;
import p163cz.msebera.android.httpclient.conn.C5635m;
import p163cz.msebera.android.httpclient.conn.ConnectionPoolTimeoutException;
import p163cz.msebera.android.httpclient.conn.p173q.C5642c;
import p163cz.msebera.android.httpclient.conn.p174r.C5645b;
import p163cz.msebera.android.httpclient.conn.p175s.C5660i;
import p163cz.msebera.android.httpclient.impl.conn.C5811f;
import p163cz.msebera.android.httpclient.p177d0.C5695b;
import p163cz.msebera.android.httpclient.p183h0.C5759e;
import p163cz.msebera.android.httpclient.p187k0.C5886a;

@Deprecated
/* renamed from: cz.msebera.android.httpclient.impl.conn.r.g */
/* compiled from: ThreadSafeClientConnManager */
public class C5830g implements C5624b {

    /* renamed from: a */
    public C5695b f15057a = new C5695b(C5830g.class);

    /* renamed from: b */
    protected final C5660i f15058b;

    /* renamed from: c */
    protected final C5826d f15059c;

    /* renamed from: d */
    protected final C5626d f15060d;

    /* renamed from: cz.msebera.android.httpclient.impl.conn.r.g$a */
    /* compiled from: ThreadSafeClientConnManager */
    class C5831a implements C5627e {

        /* renamed from: a */
        final /* synthetic */ C5828e f15061a;

        /* renamed from: b */
        final /* synthetic */ C5645b f15062b;

        C5831a(C5828e eVar, C5645b bVar) {
            this.f15061a = eVar;
            this.f15062b = bVar;
        }

        /* renamed from: a */
        public void mo33018a() {
            this.f15061a.mo33591a();
        }

        /* renamed from: a */
        public C5635m mo33017a(long j, TimeUnit timeUnit) throws InterruptedException, ConnectionPoolTimeoutException {
            C5886a.m18894a(this.f15062b, "Route");
            if (C5830g.this.f15057a.mo33168a()) {
                C5695b bVar = C5830g.this.f15057a;
                bVar.mo33166a("Get connection: " + this.f15062b + ", timeout = " + j);
            }
            return new C5825c(C5830g.this, this.f15061a.mo33590a(j, timeUnit));
        }
    }

    @Deprecated
    public C5830g(C5759e eVar, C5660i iVar) {
        C5886a.m18894a(iVar, "Scheme registry");
        this.f15058b = iVar;
        new C5642c();
        this.f15060d = mo33605a(iVar);
        this.f15059c = (C5826d) mo33606a(eVar);
    }

    /* access modifiers changed from: protected */
    @Deprecated
    /* renamed from: a */
    public C5823a mo33606a(C5759e eVar) {
        return new C5826d(this.f15060d, eVar);
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
        this.f15057a.mo33166a("Shutting down");
        this.f15059c.mo33589e();
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public C5626d mo33605a(C5660i iVar) {
        return new C5811f(iVar);
    }

    /* renamed from: a */
    public C5660i mo33010a() {
        return this.f15058b;
    }

    /* renamed from: a */
    public C5627e mo33009a(C5645b bVar, Object obj) {
        return new C5831a(this.f15059c.mo33578a(bVar, obj), bVar);
    }

    /* JADX WARNING: Unknown top exception splitter block from list: {B:33:0x0072=Splitter:B:33:0x0072, B:19:0x0038=Splitter:B:19:0x0038} */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo33011a(p163cz.msebera.android.httpclient.conn.C5635m r8, long r9, java.util.concurrent.TimeUnit r11) {
        /*
            r7 = this;
            boolean r0 = r8 instanceof p163cz.msebera.android.httpclient.impl.conn.p185r.C5825c
            java.lang.String r1 = "Connection class mismatch, connection not obtained from this manager"
            p163cz.msebera.android.httpclient.p187k0.C5886a.m18896a((boolean) r0, (java.lang.String) r1)
            cz.msebera.android.httpclient.impl.conn.r.c r8 = (p163cz.msebera.android.httpclient.impl.conn.p185r.C5825c) r8
            cz.msebera.android.httpclient.impl.conn.b r0 = r8.mo33548z()
            if (r0 == 0) goto L_0x001d
            cz.msebera.android.httpclient.conn.b r0 = r8.mo33537v()
            if (r0 != r7) goto L_0x0017
            r0 = 1
            goto L_0x0018
        L_0x0017:
            r0 = 0
        L_0x0018:
            java.lang.String r1 = "Connection not obtained from this manager"
            p163cz.msebera.android.httpclient.p187k0.C5887b.m18902a((boolean) r0, (java.lang.String) r1)
        L_0x001d:
            monitor-enter(r8)
            cz.msebera.android.httpclient.impl.conn.b r0 = r8.mo33548z()     // Catch:{ all -> 0x00bf }
            r2 = r0
            cz.msebera.android.httpclient.impl.conn.r.b r2 = (p163cz.msebera.android.httpclient.impl.conn.p185r.C5824b) r2     // Catch:{ all -> 0x00bf }
            if (r2 != 0) goto L_0x0029
            monitor-exit(r8)     // Catch:{ all -> 0x00bf }
            return
        L_0x0029:
            boolean r0 = r8.isOpen()     // Catch:{ IOException -> 0x0062 }
            if (r0 == 0) goto L_0x0038
            boolean r0 = r8.mo33539x()     // Catch:{ IOException -> 0x0062 }
            if (r0 != 0) goto L_0x0038
            r8.shutdown()     // Catch:{ IOException -> 0x0062 }
        L_0x0038:
            boolean r3 = r8.mo33539x()     // Catch:{ all -> 0x00bf }
            cz.msebera.android.httpclient.d0.b r0 = r7.f15057a     // Catch:{ all -> 0x00bf }
            boolean r0 = r0.mo33168a()     // Catch:{ all -> 0x00bf }
            if (r0 == 0) goto L_0x0055
            if (r3 == 0) goto L_0x004e
            cz.msebera.android.httpclient.d0.b r0 = r7.f15057a     // Catch:{ all -> 0x00bf }
            java.lang.String r1 = "Released connection is reusable."
            r0.mo33166a(r1)     // Catch:{ all -> 0x00bf }
            goto L_0x0055
        L_0x004e:
            cz.msebera.android.httpclient.d0.b r0 = r7.f15057a     // Catch:{ all -> 0x00bf }
            java.lang.String r1 = "Released connection is not reusable."
            r0.mo33166a(r1)     // Catch:{ all -> 0x00bf }
        L_0x0055:
            r8.mo33536u()     // Catch:{ all -> 0x00bf }
            cz.msebera.android.httpclient.impl.conn.r.d r1 = r7.f15059c     // Catch:{ all -> 0x00bf }
        L_0x005a:
            r4 = r9
            r6 = r11
            r1.mo33584a(r2, r3, r4, r6)     // Catch:{ all -> 0x00bf }
            goto L_0x0095
        L_0x0060:
            r0 = move-exception
            goto L_0x0097
        L_0x0062:
            r0 = move-exception
            cz.msebera.android.httpclient.d0.b r1 = r7.f15057a     // Catch:{ all -> 0x0060 }
            boolean r1 = r1.mo33168a()     // Catch:{ all -> 0x0060 }
            if (r1 == 0) goto L_0x0072
            cz.msebera.android.httpclient.d0.b r1 = r7.f15057a     // Catch:{ all -> 0x0060 }
            java.lang.String r3 = "Exception shutting down released connection."
            r1.mo33167a(r3, r0)     // Catch:{ all -> 0x0060 }
        L_0x0072:
            boolean r3 = r8.mo33539x()     // Catch:{ all -> 0x00bf }
            cz.msebera.android.httpclient.d0.b r0 = r7.f15057a     // Catch:{ all -> 0x00bf }
            boolean r0 = r0.mo33168a()     // Catch:{ all -> 0x00bf }
            if (r0 == 0) goto L_0x008f
            if (r3 == 0) goto L_0x0088
            cz.msebera.android.httpclient.d0.b r0 = r7.f15057a     // Catch:{ all -> 0x00bf }
            java.lang.String r1 = "Released connection is reusable."
            r0.mo33166a(r1)     // Catch:{ all -> 0x00bf }
            goto L_0x008f
        L_0x0088:
            cz.msebera.android.httpclient.d0.b r0 = r7.f15057a     // Catch:{ all -> 0x00bf }
            java.lang.String r1 = "Released connection is not reusable."
            r0.mo33166a(r1)     // Catch:{ all -> 0x00bf }
        L_0x008f:
            r8.mo33536u()     // Catch:{ all -> 0x00bf }
            cz.msebera.android.httpclient.impl.conn.r.d r1 = r7.f15059c     // Catch:{ all -> 0x00bf }
            goto L_0x005a
        L_0x0095:
            monitor-exit(r8)     // Catch:{ all -> 0x00bf }
            return
        L_0x0097:
            boolean r3 = r8.mo33539x()     // Catch:{ all -> 0x00bf }
            cz.msebera.android.httpclient.d0.b r1 = r7.f15057a     // Catch:{ all -> 0x00bf }
            boolean r1 = r1.mo33168a()     // Catch:{ all -> 0x00bf }
            if (r1 == 0) goto L_0x00b4
            if (r3 == 0) goto L_0x00ad
            cz.msebera.android.httpclient.d0.b r1 = r7.f15057a     // Catch:{ all -> 0x00bf }
            java.lang.String r4 = "Released connection is reusable."
            r1.mo33166a(r4)     // Catch:{ all -> 0x00bf }
            goto L_0x00b4
        L_0x00ad:
            cz.msebera.android.httpclient.d0.b r1 = r7.f15057a     // Catch:{ all -> 0x00bf }
            java.lang.String r4 = "Released connection is not reusable."
            r1.mo33166a(r4)     // Catch:{ all -> 0x00bf }
        L_0x00b4:
            r8.mo33536u()     // Catch:{ all -> 0x00bf }
            cz.msebera.android.httpclient.impl.conn.r.d r1 = r7.f15059c     // Catch:{ all -> 0x00bf }
            r4 = r9
            r6 = r11
            r1.mo33584a(r2, r3, r4, r6)     // Catch:{ all -> 0x00bf }
            throw r0     // Catch:{ all -> 0x00bf }
        L_0x00bf:
            r9 = move-exception
            monitor-exit(r8)     // Catch:{ all -> 0x00bf }
            goto L_0x00c3
        L_0x00c2:
            throw r9
        L_0x00c3:
            goto L_0x00c2
        */
        throw new UnsupportedOperationException("Method not decompiled: p163cz.msebera.android.httpclient.impl.conn.p185r.C5830g.mo33011a(cz.msebera.android.httpclient.conn.m, long, java.util.concurrent.TimeUnit):void");
    }
}
