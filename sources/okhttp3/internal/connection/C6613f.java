package okhttp3.internal.connection;

import java.io.IOException;
import java.lang.ref.WeakReference;
import java.net.Socket;
import java.util.List;
import okhttp3.internal.connection.C6611e;
import p113i.C3479a;
import p113i.C3494c0;
import p113i.C3497e;
import p113i.C3525i;
import p113i.C3526j;
import p113i.C3532p;
import p113i.C3542v;
import p113i.C5970t;
import p113i.p114e0.C3499a;
import p113i.p114e0.C3500c;
import p113i.p114e0.p116f.C5937c;

/* renamed from: okhttp3.internal.connection.f */
/* compiled from: StreamAllocation */
public final class C6613f {

    /* renamed from: a */
    public final C3479a f17299a;

    /* renamed from: b */
    private C6611e.C6612a f17300b;

    /* renamed from: c */
    private C3494c0 f17301c;

    /* renamed from: d */
    private final C3526j f17302d;

    /* renamed from: e */
    public final C3497e f17303e;

    /* renamed from: f */
    public final C3532p f17304f;

    /* renamed from: g */
    private final Object f17305g;

    /* renamed from: h */
    private final C6611e f17306h;

    /* renamed from: i */
    private int f17307i;

    /* renamed from: j */
    private C3589c f17308j;

    /* renamed from: k */
    private boolean f17309k;

    /* renamed from: l */
    private boolean f17310l;

    /* renamed from: m */
    private boolean f17311m;

    /* renamed from: n */
    private C5937c f17312n;

    /* renamed from: okhttp3.internal.connection.f$a */
    /* compiled from: StreamAllocation */
    public static final class C6614a extends WeakReference<C6613f> {

        /* renamed from: a */
        public final Object f17313a;

        C6614a(C6613f fVar, Object obj) {
            super(fVar);
            this.f17313a = obj;
        }
    }

    public C6613f(C3526j jVar, C3479a aVar, C3497e eVar, C3532p pVar, Object obj) {
        this.f17302d = jVar;
        this.f17299a = aVar;
        this.f17303e = eVar;
        this.f17304f = pVar;
        this.f17306h = new C6611e(aVar, m21728i(), eVar, pVar);
        this.f17305g = obj;
    }

    /* renamed from: h */
    private Socket m21727h() {
        C3589c cVar = this.f17308j;
        if (cVar == null || !cVar.f10062k) {
            return null;
        }
        return m21723a(false, false, true);
    }

    /* renamed from: i */
    private C6610d m21728i() {
        return C3499a.f9700a.mo19370a(this.f17302d);
    }

    /* renamed from: a */
    public C5937c mo35658a(C3542v vVar, C5970t.C5971a aVar, boolean z) {
        try {
            C5937c a = m21725a(aVar.mo33733c(), aVar.mo33729a(), aVar.mo33732b(), vVar.mo19573s(), vVar.mo19579y(), z).mo19779a(vVar, aVar, this);
            synchronized (this.f17302d) {
                this.f17312n = a;
            }
            return a;
        } catch (IOException e) {
            throw new RouteException(e);
        }
    }

    /* renamed from: b */
    public C5937c mo35664b() {
        C5937c cVar;
        synchronized (this.f17302d) {
            cVar = this.f17312n;
        }
        return cVar;
    }

    /* renamed from: c */
    public synchronized C3589c mo35665c() {
        return this.f17308j;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = r1.f17300b;
     */
    /* renamed from: d */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean mo35666d() {
        /*
            r1 = this;
            i.c0 r0 = r1.f17301c
            if (r0 != 0) goto L_0x0019
            okhttp3.internal.connection.e$a r0 = r1.f17300b
            if (r0 == 0) goto L_0x000e
            boolean r0 = r0.mo35656b()
            if (r0 != 0) goto L_0x0019
        L_0x000e:
            okhttp3.internal.connection.e r0 = r1.f17306h
            boolean r0 = r0.mo35653a()
            if (r0 == 0) goto L_0x0017
            goto L_0x0019
        L_0x0017:
            r0 = 0
            goto L_0x001a
        L_0x0019:
            r0 = 1
        L_0x001a:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.connection.C6613f.mo35666d():boolean");
    }

    /* renamed from: e */
    public void mo35667e() {
        C3589c cVar;
        Socket a;
        synchronized (this.f17302d) {
            cVar = this.f17308j;
            a = m21723a(true, false, false);
            if (this.f17308j != null) {
                cVar = null;
            }
        }
        C3500c.m11651a(a);
        if (cVar != null) {
            this.f17304f.mo19487b(this.f17303e, (C3525i) cVar);
        }
    }

    /* renamed from: f */
    public void mo35668f() {
        C3589c cVar;
        Socket a;
        synchronized (this.f17302d) {
            cVar = this.f17308j;
            a = m21723a(false, true, false);
            if (this.f17308j != null) {
                cVar = null;
            }
        }
        C3500c.m11651a(a);
        if (cVar != null) {
            C3499a.f9700a.mo19367a(this.f17303e, (IOException) null);
            this.f17304f.mo19487b(this.f17303e, (C3525i) cVar);
            this.f17304f.mo19473a(this.f17303e);
        }
    }

    /* renamed from: g */
    public C3494c0 mo35669g() {
        return this.f17301c;
    }

    public String toString() {
        C3589c c = mo35665c();
        return c != null ? c.toString() : this.f17299a.toString();
    }

    /* renamed from: b */
    private void m21726b(C3589c cVar) {
        int size = cVar.f10065n.size();
        for (int i = 0; i < size; i++) {
            if (cVar.f10065n.get(i).get() == this) {
                cVar.f10065n.remove(i);
                return;
            }
        }
        throw new IllegalStateException();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0018, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0012, code lost:
        if (r0.mo19786a(r9) != false) goto L_0x0018;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private okhttp3.internal.connection.C3589c m21725a(int r4, int r5, int r6, int r7, boolean r8, boolean r9) throws java.io.IOException {
        /*
            r3 = this;
        L_0x0000:
            okhttp3.internal.connection.c r0 = r3.m21724a(r4, r5, r6, r7, r8)
            i.j r1 = r3.f17302d
            monitor-enter(r1)
            int r2 = r0.f10063l     // Catch:{ all -> 0x0019 }
            if (r2 != 0) goto L_0x000d
            monitor-exit(r1)     // Catch:{ all -> 0x0019 }
            return r0
        L_0x000d:
            monitor-exit(r1)     // Catch:{ all -> 0x0019 }
            boolean r1 = r0.mo19786a((boolean) r9)
            if (r1 != 0) goto L_0x0018
            r3.mo35667e()
            goto L_0x0000
        L_0x0018:
            return r0
        L_0x0019:
            r4 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x0019 }
            goto L_0x001d
        L_0x001c:
            throw r4
        L_0x001d:
            goto L_0x001c
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.connection.C6613f.m21725a(int, int, int, int, boolean, boolean):okhttp3.internal.connection.c");
    }

    /* renamed from: a */
    private C3589c m21724a(int i, int i2, int i3, int i4, boolean z) throws IOException {
        Socket h;
        Socket socket;
        C3589c cVar;
        C3589c cVar2;
        boolean z2;
        C3494c0 c0Var;
        boolean z3;
        C6611e.C6612a aVar;
        synchronized (this.f17302d) {
            if (this.f17310l) {
                throw new IllegalStateException("released");
            } else if (this.f17312n != null) {
                throw new IllegalStateException("codec != null");
            } else if (!this.f17311m) {
                C3589c cVar3 = this.f17308j;
                h = m21727h();
                socket = null;
                if (this.f17308j != null) {
                    cVar2 = this.f17308j;
                    cVar = null;
                } else {
                    cVar = cVar3;
                    cVar2 = null;
                }
                if (!this.f17309k) {
                    cVar = null;
                }
                if (cVar2 == null) {
                    C3499a.f9700a.mo19369a(this.f17302d, this.f17299a, this, (C3494c0) null);
                    if (this.f17308j != null) {
                        cVar2 = this.f17308j;
                        c0Var = null;
                        z2 = true;
                    } else {
                        c0Var = this.f17301c;
                    }
                } else {
                    c0Var = null;
                }
                z2 = false;
            } else {
                throw new IOException("Canceled");
            }
        }
        C3500c.m11651a(h);
        if (cVar != null) {
            this.f17304f.mo19487b(this.f17303e, (C3525i) cVar);
        }
        if (z2) {
            this.f17304f.mo19476a(this.f17303e, (C3525i) cVar2);
        }
        if (cVar2 != null) {
            return cVar2;
        }
        if (c0Var != null || ((aVar = this.f17300b) != null && aVar.mo35656b())) {
            z3 = false;
        } else {
            this.f17300b = this.f17306h.mo35654b();
            z3 = true;
        }
        synchronized (this.f17302d) {
            if (!this.f17311m) {
                if (z3) {
                    List<C3494c0> a = this.f17300b.mo35655a();
                    int size = a.size();
                    int i5 = 0;
                    while (true) {
                        if (i5 >= size) {
                            break;
                        }
                        C3494c0 c0Var2 = a.get(i5);
                        C3499a.f9700a.mo19369a(this.f17302d, this.f17299a, this, c0Var2);
                        if (this.f17308j != null) {
                            cVar2 = this.f17308j;
                            this.f17301c = c0Var2;
                            z2 = true;
                            break;
                        }
                        i5++;
                    }
                }
                if (!z2) {
                    if (c0Var == null) {
                        c0Var = this.f17300b.mo35657c();
                    }
                    this.f17301c = c0Var;
                    this.f17307i = 0;
                    cVar2 = new C3589c(this.f17302d, c0Var);
                    mo35662a(cVar2, false);
                }
            } else {
                throw new IOException("Canceled");
            }
        }
        if (z2) {
            this.f17304f.mo19476a(this.f17303e, (C3525i) cVar2);
            return cVar2;
        }
        cVar2.mo19781a(i, i2, i3, i4, z, this.f17303e, this.f17304f);
        m21728i().mo35649a(cVar2.mo19789d());
        synchronized (this.f17302d) {
            this.f17309k = true;
            C3499a.f9700a.mo19376b(this.f17302d, cVar2);
            if (cVar2.mo19788c()) {
                socket = C3499a.f9700a.mo19368a(this.f17302d, this.f17299a, this);
                cVar2 = this.f17308j;
            }
        }
        C3500c.m11651a(socket);
        this.f17304f.mo19476a(this.f17303e, (C3525i) cVar2);
        return cVar2;
    }

    /* renamed from: a */
    public void mo35663a(boolean z, C5937c cVar, long j, IOException iOException) {
        C3589c cVar2;
        Socket a;
        boolean z2;
        this.f17304f.mo19486b(this.f17303e, j);
        synchronized (this.f17302d) {
            if (cVar != null) {
                if (cVar == this.f17312n) {
                    if (!z) {
                        this.f17308j.f10063l++;
                    }
                    cVar2 = this.f17308j;
                    a = m21723a(z, false, true);
                    if (this.f17308j != null) {
                        cVar2 = null;
                    }
                    z2 = this.f17310l;
                }
            }
            throw new IllegalStateException("expected " + this.f17312n + " but was " + cVar);
        }
        C3500c.m11651a(a);
        if (cVar2 != null) {
            this.f17304f.mo19487b(this.f17303e, (C3525i) cVar2);
        }
        if (iOException != null) {
            this.f17304f.mo19479a(this.f17303e, C3499a.f9700a.mo19367a(this.f17303e, iOException));
        } else if (z2) {
            C3499a.f9700a.mo19367a(this.f17303e, (IOException) null);
            this.f17304f.mo19473a(this.f17303e);
        }
    }

    /* renamed from: a */
    private Socket m21723a(boolean z, boolean z2, boolean z3) {
        Socket socket;
        if (z3) {
            this.f17312n = null;
        }
        if (z2) {
            this.f17310l = true;
        }
        C3589c cVar = this.f17308j;
        if (cVar == null) {
            return null;
        }
        if (z) {
            cVar.f10062k = true;
        }
        if (this.f17312n != null) {
            return null;
        }
        if (!this.f17310l && !this.f17308j.f10062k) {
            return null;
        }
        m21726b(this.f17308j);
        if (this.f17308j.f10065n.isEmpty()) {
            this.f17308j.f10066o = System.nanoTime();
            if (C3499a.f9700a.mo19375a(this.f17302d, this.f17308j)) {
                socket = this.f17308j.mo19790e();
                this.f17308j = null;
                return socket;
            }
        }
        socket = null;
        this.f17308j = null;
        return socket;
    }

    /* renamed from: a */
    public void mo35660a() {
        C5937c cVar;
        C3589c cVar2;
        synchronized (this.f17302d) {
            this.f17311m = true;
            cVar = this.f17312n;
            cVar2 = this.f17308j;
        }
        if (cVar != null) {
            cVar.cancel();
        } else if (cVar2 != null) {
            cVar2.mo19780a();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x0055  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo35661a(java.io.IOException r7) {
        /*
            r6 = this;
            i.j r0 = r6.f17302d
            monitor-enter(r0)
            boolean r1 = r7 instanceof okhttp3.internal.http2.StreamResetException     // Catch:{ all -> 0x0069 }
            r2 = 0
            r3 = 0
            r4 = 1
            if (r1 == 0) goto L_0x0023
            okhttp3.internal.http2.StreamResetException r7 = (okhttp3.internal.http2.StreamResetException) r7     // Catch:{ all -> 0x0069 }
            okhttp3.internal.http2.a r7 = r7.f17314a     // Catch:{ all -> 0x0069 }
            okhttp3.internal.http2.a r1 = okhttp3.internal.http2.C6615a.REFUSED_STREAM     // Catch:{ all -> 0x0069 }
            if (r7 != r1) goto L_0x001c
            int r7 = r6.f17307i     // Catch:{ all -> 0x0069 }
            int r7 = r7 + r4
            r6.f17307i = r7     // Catch:{ all -> 0x0069 }
            if (r7 <= r4) goto L_0x004a
            r6.f17301c = r3     // Catch:{ all -> 0x0069 }
            goto L_0x0048
        L_0x001c:
            okhttp3.internal.http2.a r1 = okhttp3.internal.http2.C6615a.CANCEL     // Catch:{ all -> 0x0069 }
            if (r7 == r1) goto L_0x004a
            r6.f17301c = r3     // Catch:{ all -> 0x0069 }
            goto L_0x0048
        L_0x0023:
            okhttp3.internal.connection.c r1 = r6.f17308j     // Catch:{ all -> 0x0069 }
            if (r1 == 0) goto L_0x004a
            okhttp3.internal.connection.c r1 = r6.f17308j     // Catch:{ all -> 0x0069 }
            boolean r1 = r1.mo19788c()     // Catch:{ all -> 0x0069 }
            if (r1 == 0) goto L_0x0033
            boolean r1 = r7 instanceof okhttp3.internal.http2.ConnectionShutdownException     // Catch:{ all -> 0x0069 }
            if (r1 == 0) goto L_0x004a
        L_0x0033:
            okhttp3.internal.connection.c r1 = r6.f17308j     // Catch:{ all -> 0x0069 }
            int r1 = r1.f10063l     // Catch:{ all -> 0x0069 }
            if (r1 != 0) goto L_0x0048
            i.c0 r1 = r6.f17301c     // Catch:{ all -> 0x0069 }
            if (r1 == 0) goto L_0x0046
            if (r7 == 0) goto L_0x0046
            okhttp3.internal.connection.e r1 = r6.f17306h     // Catch:{ all -> 0x0069 }
            i.c0 r5 = r6.f17301c     // Catch:{ all -> 0x0069 }
            r1.mo35652a((p113i.C3494c0) r5, (java.io.IOException) r7)     // Catch:{ all -> 0x0069 }
        L_0x0046:
            r6.f17301c = r3     // Catch:{ all -> 0x0069 }
        L_0x0048:
            r7 = 1
            goto L_0x004b
        L_0x004a:
            r7 = 0
        L_0x004b:
            okhttp3.internal.connection.c r1 = r6.f17308j     // Catch:{ all -> 0x0069 }
            java.net.Socket r7 = r6.m21723a((boolean) r7, (boolean) r2, (boolean) r4)     // Catch:{ all -> 0x0069 }
            okhttp3.internal.connection.c r2 = r6.f17308j     // Catch:{ all -> 0x0069 }
            if (r2 != 0) goto L_0x005b
            boolean r2 = r6.f17309k     // Catch:{ all -> 0x0069 }
            if (r2 != 0) goto L_0x005a
            goto L_0x005b
        L_0x005a:
            r3 = r1
        L_0x005b:
            monitor-exit(r0)     // Catch:{ all -> 0x0069 }
            p113i.p114e0.C3500c.m11651a((java.net.Socket) r7)
            if (r3 == 0) goto L_0x0068
            i.p r7 = r6.f17304f
            i.e r0 = r6.f17303e
            r7.mo19487b((p113i.C3497e) r0, (p113i.C3525i) r3)
        L_0x0068:
            return
        L_0x0069:
            r7 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0069 }
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.connection.C6613f.mo35661a(java.io.IOException):void");
    }

    /* renamed from: a */
    public void mo35662a(C3589c cVar, boolean z) {
        if (this.f17308j == null) {
            this.f17308j = cVar;
            this.f17309k = z;
            cVar.f10065n.add(new C6614a(this, this.f17305g));
            return;
        }
        throw new IllegalStateException();
    }

    /* renamed from: a */
    public Socket mo35659a(C3589c cVar) {
        if (this.f17312n == null && this.f17308j.f10065n.size() == 1) {
            Socket a = m21723a(true, false, false);
            this.f17308j = cVar;
            cVar.f10065n.add(this.f17308j.f10065n.get(0));
            return a;
        }
        throw new IllegalStateException();
    }
}
