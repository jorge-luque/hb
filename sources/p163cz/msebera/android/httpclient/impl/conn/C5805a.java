package p163cz.msebera.android.httpclient.impl.conn;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import p163cz.msebera.android.httpclient.C5885k;
import p163cz.msebera.android.httpclient.C5899o;
import p163cz.msebera.android.httpclient.C5901q;
import p163cz.msebera.android.httpclient.HttpException;
import p163cz.msebera.android.httpclient.conn.C5624b;
import p163cz.msebera.android.httpclient.conn.C5635m;
import p163cz.msebera.android.httpclient.conn.C5637o;
import p163cz.msebera.android.httpclient.p186j0.C5875e;

@Deprecated
/* renamed from: cz.msebera.android.httpclient.impl.conn.a */
/* compiled from: AbstractClientConnAdapter */
public abstract class C5805a implements C5635m, C5875e {

    /* renamed from: a */
    private final C5624b f14975a;

    /* renamed from: b */
    private volatile C5637o f14976b;

    /* renamed from: c */
    private volatile boolean f14977c = false;

    /* renamed from: d */
    private volatile boolean f14978d = false;

    /* renamed from: e */
    private volatile long f14979e = Long.MAX_VALUE;

    protected C5805a(C5624b bVar, C5637o oVar) {
        this.f14975a = bVar;
        this.f14976b = oVar;
    }

    /* renamed from: L */
    public void mo33033L() {
        this.f14977c = false;
    }

    /* renamed from: O */
    public int mo33204O() {
        C5637o w = mo33538w();
        mo33534a(w);
        return w.mo33204O();
    }

    /* renamed from: R */
    public C5901q mo33182R() throws HttpException, IOException {
        C5637o w = mo33538w();
        mo33534a(w);
        mo33033L();
        return w.mo33182R();
    }

    /* renamed from: S */
    public void mo33034S() {
        this.f14977c = true;
    }

    /* renamed from: T */
    public SSLSession mo33040T() {
        C5637o w = mo33538w();
        mo33534a(w);
        if (!isOpen()) {
            return null;
        }
        Socket N = w.mo33042N();
        if (N instanceof SSLSocket) {
            return ((SSLSocket) N).getSession();
        }
        return null;
    }

    /* renamed from: W */
    public boolean mo33183W() {
        C5637o w;
        if (!mo33540y() && (w = mo33538w()) != null) {
            return w.mo33183W();
        }
        return true;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo33534a(C5637o oVar) throws ConnectionShutdownException {
        if (mo33540y() || oVar == null) {
            throw new ConnectionShutdownException();
        }
    }

    /* renamed from: d */
    public synchronized void mo33006d() {
        if (!this.f14978d) {
            this.f14978d = true;
            this.f14975a.mo33011a(this, this.f14979e, TimeUnit.MILLISECONDS);
        }
    }

    /* renamed from: f */
    public void mo33209f(int i) {
        C5637o w = mo33538w();
        mo33534a(w);
        w.mo33209f(i);
    }

    public void flush() throws IOException {
        C5637o w = mo33538w();
        mo33534a(w);
        w.flush();
    }

    public InetAddress getRemoteAddress() {
        C5637o w = mo33538w();
        mo33534a(w);
        return w.getRemoteAddress();
    }

    /* renamed from: h */
    public boolean mo33193h(int i) throws IOException {
        C5637o w = mo33538w();
        mo33534a(w);
        return w.mo33193h(i);
    }

    public boolean isOpen() {
        C5637o w = mo33538w();
        if (w == null) {
            return false;
        }
        return w.isOpen();
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(9:6|7|8|9|10|11|12|13|14) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0010 */
    /* renamed from: t */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void mo33008t() {
        /*
            r4 = this;
            monitor-enter(r4)
            boolean r0 = r4.f14978d     // Catch:{ all -> 0x001b }
            if (r0 == 0) goto L_0x0007
            monitor-exit(r4)
            return
        L_0x0007:
            r0 = 1
            r4.f14978d = r0     // Catch:{ all -> 0x001b }
            r4.mo33033L()     // Catch:{ all -> 0x001b }
            r4.shutdown()     // Catch:{ IOException -> 0x0010 }
        L_0x0010:
            cz.msebera.android.httpclient.conn.b r0 = r4.f14975a     // Catch:{ all -> 0x001b }
            long r1 = r4.f14979e     // Catch:{ all -> 0x001b }
            java.util.concurrent.TimeUnit r3 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch:{ all -> 0x001b }
            r0.mo33011a(r4, r1, r3)     // Catch:{ all -> 0x001b }
            monitor-exit(r4)
            return
        L_0x001b:
            r0 = move-exception
            monitor-exit(r4)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p163cz.msebera.android.httpclient.impl.conn.C5805a.mo33008t():void");
    }

    /* access modifiers changed from: protected */
    /* renamed from: u */
    public synchronized void mo33536u() {
        this.f14976b = null;
        this.f14979e = Long.MAX_VALUE;
    }

    /* access modifiers changed from: protected */
    /* renamed from: v */
    public C5624b mo33537v() {
        return this.f14975a;
    }

    /* access modifiers changed from: protected */
    /* renamed from: w */
    public C5637o mo33538w() {
        return this.f14976b;
    }

    /* renamed from: x */
    public boolean mo33539x() {
        return this.f14977c;
    }

    /* access modifiers changed from: protected */
    /* renamed from: y */
    public boolean mo33540y() {
        return this.f14978d;
    }

    /* renamed from: a */
    public void mo33190a(C5901q qVar) throws HttpException, IOException {
        C5637o w = mo33538w();
        mo33534a(w);
        mo33033L();
        w.mo33190a(qVar);
    }

    /* renamed from: a */
    public void mo33188a(C5885k kVar) throws HttpException, IOException {
        C5637o w = mo33538w();
        mo33534a(w);
        mo33033L();
        w.mo33188a(kVar);
    }

    /* renamed from: a */
    public void mo33189a(C5899o oVar) throws HttpException, IOException {
        C5637o w = mo33538w();
        mo33534a(w);
        mo33033L();
        w.mo33189a(oVar);
    }

    /* renamed from: a */
    public void mo33035a(long j, TimeUnit timeUnit) {
        if (j > 0) {
            this.f14979e = timeUnit.toMillis(j);
        } else {
            this.f14979e = -1;
        }
    }

    /* renamed from: a */
    public Object mo33533a(String str) {
        C5637o w = mo33538w();
        mo33534a(w);
        if (w instanceof C5875e) {
            return ((C5875e) w).mo33533a(str);
        }
        return null;
    }

    /* renamed from: a */
    public void mo33535a(String str, Object obj) {
        C5637o w = mo33538w();
        mo33534a(w);
        if (w instanceof C5875e) {
            ((C5875e) w).mo33535a(str, obj);
        }
    }
}
