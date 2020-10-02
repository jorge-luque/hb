package p163cz.msebera.android.httpclient.impl.conn;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import p163cz.msebera.android.httpclient.C5885k;
import p163cz.msebera.android.httpclient.C5896l;
import p163cz.msebera.android.httpclient.C5899o;
import p163cz.msebera.android.httpclient.C5901q;
import p163cz.msebera.android.httpclient.HttpException;
import p163cz.msebera.android.httpclient.conn.C5624b;
import p163cz.msebera.android.httpclient.conn.C5626d;
import p163cz.msebera.android.httpclient.conn.C5635m;
import p163cz.msebera.android.httpclient.conn.C5637o;
import p163cz.msebera.android.httpclient.conn.p174r.C5645b;
import p163cz.msebera.android.httpclient.conn.p174r.C5651f;
import p163cz.msebera.android.httpclient.p183h0.C5759e;
import p163cz.msebera.android.httpclient.p186j0.C5875e;
import p163cz.msebera.android.httpclient.p187k0.C5886a;
import p163cz.msebera.android.httpclient.p187k0.C5887b;

@Deprecated
/* renamed from: cz.msebera.android.httpclient.impl.conn.n */
/* compiled from: ManagedClientConnectionImpl */
class C5819n implements C5635m {

    /* renamed from: a */
    private final C5624b f15020a;

    /* renamed from: b */
    private final C5626d f15021b;

    /* renamed from: c */
    private volatile C5815j f15022c;

    /* renamed from: d */
    private volatile boolean f15023d = false;

    /* renamed from: e */
    private volatile long f15024e = Long.MAX_VALUE;

    C5819n(C5624b bVar, C5626d dVar, C5815j jVar) {
        C5886a.m18894a(bVar, "Connection manager");
        C5886a.m18894a(dVar, "Connection operator");
        C5886a.m18894a(jVar, "HTTP pool entry");
        this.f15020a = bVar;
        this.f15021b = dVar;
        this.f15022c = jVar;
    }

    /* renamed from: A */
    private C5637o m18619A() {
        C5815j jVar = this.f15022c;
        if (jVar == null) {
            return null;
        }
        return (C5637o) jVar.mo33427a();
    }

    /* renamed from: y */
    private C5637o m18620y() {
        C5815j jVar = this.f15022c;
        if (jVar != null) {
            return (C5637o) jVar.mo33427a();
        }
        throw new ConnectionShutdownException();
    }

    /* renamed from: z */
    private C5815j m18621z() {
        C5815j jVar = this.f15022c;
        if (jVar != null) {
            return jVar;
        }
        throw new ConnectionShutdownException();
    }

    /* renamed from: D */
    public C5645b mo33032D() {
        return m18621z().mo33556e();
    }

    /* renamed from: L */
    public void mo33033L() {
        this.f15023d = false;
    }

    /* renamed from: O */
    public int mo33204O() {
        return m18620y().mo33204O();
    }

    /* renamed from: R */
    public C5901q mo33182R() throws HttpException, IOException {
        return m18620y().mo33182R();
    }

    /* renamed from: S */
    public void mo33034S() {
        this.f15023d = true;
    }

    /* renamed from: T */
    public SSLSession mo33040T() {
        Socket N = m18620y().mo33042N();
        if (N instanceof SSLSocket) {
            return ((SSLSocket) N).getSession();
        }
        return null;
    }

    /* renamed from: W */
    public boolean mo33183W() {
        C5637o A = m18619A();
        if (A != null) {
            return A.mo33183W();
        }
        return true;
    }

    /* renamed from: a */
    public void mo33190a(C5901q qVar) throws HttpException, IOException {
        m18620y().mo33190a(qVar);
    }

    /* renamed from: b */
    public void mo33039b(Object obj) {
        m18621z().mo33429a(obj);
    }

    public void close() throws IOException {
        C5815j jVar = this.f15022c;
        if (jVar != null) {
            jVar.mo33558g().mo33074h();
            ((C5637o) jVar.mo33427a()).close();
        }
    }

    /* renamed from: d */
    public void mo33006d() {
        synchronized (this) {
            if (this.f15022c != null) {
                this.f15020a.mo33011a(this, this.f15024e, TimeUnit.MILLISECONDS);
                this.f15022c = null;
            }
        }
    }

    /* renamed from: f */
    public void mo33209f(int i) {
        m18620y().mo33209f(i);
    }

    public void flush() throws IOException {
        m18620y().flush();
    }

    public InetAddress getRemoteAddress() {
        return m18620y().getRemoteAddress();
    }

    /* renamed from: h */
    public boolean mo33193h(int i) throws IOException {
        return m18620y().mo33193h(i);
    }

    public boolean isOpen() {
        C5637o A = m18619A();
        if (A != null) {
            return A.isOpen();
        }
        return false;
    }

    public void shutdown() throws IOException {
        C5815j jVar = this.f15022c;
        if (jVar != null) {
            jVar.mo33558g().mo33074h();
            ((C5637o) jVar.mo33427a()).shutdown();
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(7:6|7|8|9|10|11|12) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0015 */
    /* renamed from: t */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo33008t() {
        /*
            r4 = this;
            monitor-enter(r4)
            cz.msebera.android.httpclient.impl.conn.j r0 = r4.f15022c     // Catch:{ all -> 0x0023 }
            if (r0 != 0) goto L_0x0007
            monitor-exit(r4)     // Catch:{ all -> 0x0023 }
            return
        L_0x0007:
            r0 = 0
            r4.f15023d = r0     // Catch:{ all -> 0x0023 }
            cz.msebera.android.httpclient.impl.conn.j r0 = r4.f15022c     // Catch:{ all -> 0x0023 }
            java.lang.Object r0 = r0.mo33427a()     // Catch:{ all -> 0x0023 }
            cz.msebera.android.httpclient.conn.o r0 = (p163cz.msebera.android.httpclient.conn.C5637o) r0     // Catch:{ all -> 0x0023 }
            r0.shutdown()     // Catch:{ IOException -> 0x0015 }
        L_0x0015:
            cz.msebera.android.httpclient.conn.b r0 = r4.f15020a     // Catch:{ all -> 0x0023 }
            long r1 = r4.f15024e     // Catch:{ all -> 0x0023 }
            java.util.concurrent.TimeUnit r3 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch:{ all -> 0x0023 }
            r0.mo33011a(r4, r1, r3)     // Catch:{ all -> 0x0023 }
            r0 = 0
            r4.f15022c = r0     // Catch:{ all -> 0x0023 }
            monitor-exit(r4)     // Catch:{ all -> 0x0023 }
            return
        L_0x0023:
            r0 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x0023 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p163cz.msebera.android.httpclient.impl.conn.C5819n.mo33008t():void");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: u */
    public C5815j mo33560u() {
        C5815j jVar = this.f15022c;
        this.f15022c = null;
        return jVar;
    }

    /* renamed from: v */
    public C5624b mo33561v() {
        return this.f15020a;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: w */
    public C5815j mo33562w() {
        return this.f15022c;
    }

    /* renamed from: x */
    public boolean mo33563x() {
        return this.f15023d;
    }

    /* renamed from: a */
    public void mo33188a(C5885k kVar) throws HttpException, IOException {
        m18620y().mo33188a(kVar);
    }

    /* renamed from: a */
    public void mo33189a(C5899o oVar) throws HttpException, IOException {
        m18620y().mo33189a(oVar);
    }

    /* renamed from: a */
    public void mo33036a(C5645b bVar, C5875e eVar, C5759e eVar2) throws IOException {
        C5637o oVar;
        C5896l lVar;
        C5886a.m18894a(bVar, "Route");
        C5886a.m18894a(eVar2, "HTTP parameters");
        synchronized (this) {
            if (this.f15022c != null) {
                C5651f g = this.f15022c.mo33558g();
                C5887b.m18901a((Object) g, "Route tracker");
                C5887b.m18902a(!g.mo33073g(), "Connection already open");
                oVar = (C5637o) this.f15022c.mo33427a();
            } else {
                throw new ConnectionShutdownException();
            }
        }
        C5896l c = bVar.mo33058c();
        C5626d dVar = this.f15021b;
        if (c != null) {
            lVar = c;
        } else {
            lVar = bVar.mo33061e();
        }
        dVar.mo33016a(oVar, lVar, bVar.mo33060d(), eVar, eVar2);
        synchronized (this) {
            if (this.f15022c != null) {
                C5651f g2 = this.f15022c.mo33558g();
                if (c == null) {
                    g2.mo33068a(oVar.mo33041B());
                } else {
                    g2.mo33067a(c, oVar.mo33041B());
                }
            } else {
                throw new InterruptedIOException();
            }
        }
    }

    /* renamed from: a */
    public void mo33038a(boolean z, C5759e eVar) throws IOException {
        C5896l e;
        C5637o oVar;
        C5886a.m18894a(eVar, "HTTP parameters");
        synchronized (this) {
            if (this.f15022c != null) {
                C5651f g = this.f15022c.mo33558g();
                C5887b.m18901a((Object) g, "Route tracker");
                C5887b.m18902a(g.mo33073g(), "Connection not open");
                C5887b.m18902a(!g.mo33057b(), "Connection is already tunnelled");
                e = g.mo33061e();
                oVar = (C5637o) this.f15022c.mo33427a();
            } else {
                throw new ConnectionShutdownException();
            }
        }
        oVar.mo33044a((Socket) null, e, z, eVar);
        synchronized (this) {
            if (this.f15022c != null) {
                this.f15022c.mo33558g().mo33070c(z);
            } else {
                throw new InterruptedIOException();
            }
        }
    }

    /* renamed from: a */
    public void mo33037a(C5875e eVar, C5759e eVar2) throws IOException {
        C5896l e;
        C5637o oVar;
        C5886a.m18894a(eVar2, "HTTP parameters");
        synchronized (this) {
            if (this.f15022c != null) {
                C5651f g = this.f15022c.mo33558g();
                C5887b.m18901a((Object) g, "Route tracker");
                C5887b.m18902a(g.mo33073g(), "Connection not open");
                C5887b.m18902a(g.mo33057b(), "Protocol layering without a tunnel not supported");
                C5887b.m18902a(!g.mo33063f(), "Multiple protocol layering not supported");
                e = g.mo33061e();
                oVar = (C5637o) this.f15022c.mo33427a();
            } else {
                throw new ConnectionShutdownException();
            }
        }
        this.f15021b.mo33015a(oVar, e, eVar, eVar2);
        synchronized (this) {
            if (this.f15022c != null) {
                this.f15022c.mo33558g().mo33069b(oVar.mo33041B());
            } else {
                throw new InterruptedIOException();
            }
        }
    }

    /* renamed from: a */
    public void mo33035a(long j, TimeUnit timeUnit) {
        if (j > 0) {
            this.f15024e = timeUnit.toMillis(j);
        } else {
            this.f15024e = -1;
        }
    }
}
