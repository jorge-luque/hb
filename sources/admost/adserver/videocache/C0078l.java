package admost.adserver.videocache;

import android.util.Log;
import java.lang.Thread;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: admost.adserver.videocache.l */
/* compiled from: ProxyCache */
class C0078l {

    /* renamed from: a */
    private final C0082n f223a;

    /* renamed from: b */
    private final C0061a f224b;

    /* renamed from: c */
    private final Object f225c = new Object();

    /* renamed from: d */
    private final Object f226d = new Object();

    /* renamed from: e */
    private final AtomicInteger f227e;

    /* renamed from: f */
    private volatile Thread f228f;

    /* renamed from: g */
    private volatile boolean f229g;

    /* renamed from: h */
    private volatile int f230h = -1;

    /* renamed from: admost.adserver.videocache.l$b */
    /* compiled from: ProxyCache */
    private class C0080b implements Runnable {
        private C0080b() {
        }

        public void run() {
            C0078l.this.m242f();
        }
    }

    public C0078l(C0082n nVar, C0061a aVar) {
        C0077k.m231a(nVar);
        this.f223a = nVar;
        C0077k.m231a(aVar);
        this.f224b = aVar;
        this.f227e = new AtomicInteger();
    }

    /* renamed from: b */
    private void m237b() throws ProxyCacheException {
        int i = this.f227e.get();
        if (i >= 1) {
            this.f227e.set(0);
            throw new ProxyCacheException("Error reading source " + i + " times");
        }
    }

    /* renamed from: c */
    private void m239c() {
        try {
            this.f223a.close();
        } catch (ProxyCacheException e) {
            mo146a((Throwable) new ProxyCacheException("Error closing source " + this.f223a, e));
        }
    }

    /* renamed from: d */
    private boolean m240d() {
        return Thread.currentThread().isInterrupted() || this.f229g;
    }

    /* renamed from: e */
    private void m241e() {
        this.f230h = 100;
        mo113a(this.f230h);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0039, code lost:
        r2 = r2 + ((long) r5);
     */
    /* renamed from: f */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void m242f() {
        /*
            r8 = this;
            r0 = -1
            r2 = 0
            admost.adserver.videocache.a r4 = r8.f224b     // Catch:{ all -> 0x0049 }
            long r2 = r4.available()     // Catch:{ all -> 0x0049 }
            admost.adserver.videocache.n r4 = r8.f223a     // Catch:{ all -> 0x0049 }
            r4.mo131a(r2)     // Catch:{ all -> 0x0049 }
            admost.adserver.videocache.n r4 = r8.f223a     // Catch:{ all -> 0x0049 }
            long r0 = r4.length()     // Catch:{ all -> 0x0049 }
            r4 = 8192(0x2000, float:1.14794E-41)
            byte[] r4 = new byte[r4]     // Catch:{ all -> 0x0049 }
        L_0x0019:
            admost.adserver.videocache.n r5 = r8.f223a     // Catch:{ all -> 0x0049 }
            int r5 = r5.read(r4)     // Catch:{ all -> 0x0049 }
            r6 = -1
            if (r5 == r6) goto L_0x0042
            java.lang.Object r6 = r8.f226d     // Catch:{ all -> 0x0049 }
            monitor-enter(r6)     // Catch:{ all -> 0x0049 }
            boolean r7 = r8.m240d()     // Catch:{ all -> 0x003f }
            if (r7 == 0) goto L_0x0033
            monitor-exit(r6)     // Catch:{ all -> 0x003f }
            r8.m239c()
            r8.m238b(r2, r0)
            return
        L_0x0033:
            admost.adserver.videocache.a r7 = r8.f224b     // Catch:{ all -> 0x003f }
            r7.mo106a(r4, r5)     // Catch:{ all -> 0x003f }
            monitor-exit(r6)     // Catch:{ all -> 0x003f }
            long r5 = (long) r5
            long r2 = r2 + r5
            r8.m238b(r2, r0)     // Catch:{ all -> 0x0049 }
            goto L_0x0019
        L_0x003f:
            r4 = move-exception
            monitor-exit(r6)     // Catch:{ all -> 0x003f }
            throw r4     // Catch:{ all -> 0x0049 }
        L_0x0042:
            r8.m244h()     // Catch:{ all -> 0x0049 }
            r8.m241e()     // Catch:{ all -> 0x0049 }
            goto L_0x0052
        L_0x0049:
            r4 = move-exception
            java.util.concurrent.atomic.AtomicInteger r5 = r8.f227e     // Catch:{ all -> 0x0059 }
            r5.incrementAndGet()     // Catch:{ all -> 0x0059 }
            r8.mo146a((java.lang.Throwable) r4)     // Catch:{ all -> 0x0059 }
        L_0x0052:
            r8.m239c()
            r8.m238b(r2, r0)
            return
        L_0x0059:
            r4 = move-exception
            r8.m239c()
            r8.m238b(r2, r0)
            goto L_0x0062
        L_0x0061:
            throw r4
        L_0x0062:
            goto L_0x0061
        */
        throw new UnsupportedOperationException("Method not decompiled: admost.adserver.videocache.C0078l.m242f():void");
    }

    /* renamed from: g */
    private synchronized void m243g() throws ProxyCacheException {
        boolean z = (this.f228f == null || this.f228f.getState() == Thread.State.TERMINATED) ? false : true;
        if (!this.f229g && !this.f224b.mo107a() && !z) {
            C0080b bVar = new C0080b();
            this.f228f = new Thread(bVar, "Source reader for " + this.f223a);
            this.f228f.start();
        }
    }

    /* renamed from: h */
    private void m244h() throws ProxyCacheException {
        synchronized (this.f226d) {
            if (!m240d() && this.f224b.available() == this.f223a.length()) {
                this.f224b.complete();
            }
        }
    }

    /* renamed from: i */
    private void m245i() throws ProxyCacheException {
        synchronized (this.f225c) {
            try {
                this.f225c.wait(1000);
            } catch (InterruptedException e) {
                throw new ProxyCacheException("Waiting source data is interrupted!", e);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo113a(int i) {
        throw null;
    }

    /* renamed from: a */
    public int mo143a(byte[] bArr, long j, int i) throws ProxyCacheException {
        C0081m.m254a(bArr, j, i);
        while (!this.f224b.mo107a() && this.f224b.available() < ((long) i) + j && !this.f229g) {
            m243g();
            m245i();
            m237b();
        }
        int a = this.f224b.mo105a(bArr, j, i);
        if (this.f224b.mo107a() && this.f230h != 100) {
            this.f230h = 100;
            mo113a(100);
        }
        return a;
    }

    /* renamed from: b */
    private void m238b(long j, long j2) {
        mo145a(j, j2);
        synchronized (this.f225c) {
            this.f225c.notifyAll();
        }
    }

    /* renamed from: a */
    public void mo144a() {
        synchronized (this.f226d) {
            "Shutdown proxy for " + this.f223a;
            try {
                this.f229g = true;
                if (this.f228f != null) {
                    this.f228f.interrupt();
                }
                this.f224b.close();
            } catch (ProxyCacheException e) {
                mo146a((Throwable) e);
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo145a(long j, long j2) {
        boolean z = true;
        int i = (j2 > 0 ? 1 : (j2 == 0 ? 0 : -1)) == 0 ? 100 : (int) ((((float) j) / ((float) j2)) * 100.0f);
        boolean z2 = i != this.f230h;
        if (j2 < 0) {
            z = false;
        }
        if (z && z2) {
            mo113a(i);
        }
        this.f230h = i;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo146a(Throwable th) {
        if (!(th instanceof InterruptedProxyCacheException)) {
            Log.w("ADMOST-VIDEO", "ProxyCache error", th);
        }
    }
}
