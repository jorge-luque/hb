package p163cz.msebera.android.httpclient.impl.conn;

import java.io.IOException;
import p163cz.msebera.android.httpclient.conn.C5624b;
import p163cz.msebera.android.httpclient.conn.C5637o;
import p163cz.msebera.android.httpclient.conn.p174r.C5645b;
import p163cz.msebera.android.httpclient.p183h0.C5759e;
import p163cz.msebera.android.httpclient.p186j0.C5875e;

@Deprecated
/* renamed from: cz.msebera.android.httpclient.impl.conn.c */
/* compiled from: AbstractPooledConnAdapter */
public abstract class C5807c extends C5805a {

    /* renamed from: f */
    protected volatile C5806b f14985f;

    protected C5807c(C5624b bVar, C5806b bVar2) {
        super(bVar, bVar2.f14981b);
        this.f14985f = bVar2;
    }

    /* renamed from: D */
    public C5645b mo33032D() {
        C5806b z = mo33548z();
        mo33547a(z);
        if (z.f14984e == null) {
            return null;
        }
        return z.f14984e.mo33076i();
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo33547a(C5806b bVar) {
        if (mo33540y() || bVar == null) {
            throw new ConnectionShutdownException();
        }
    }

    /* renamed from: b */
    public void mo33039b(Object obj) {
        C5806b z = mo33548z();
        mo33547a(z);
        z.mo33544a(obj);
    }

    public void close() throws IOException {
        C5806b z = mo33548z();
        if (z != null) {
            z.mo33546b();
        }
        C5637o w = mo33538w();
        if (w != null) {
            w.close();
        }
    }

    public void shutdown() throws IOException {
        C5806b z = mo33548z();
        if (z != null) {
            z.mo33546b();
        }
        C5637o w = mo33538w();
        if (w != null) {
            w.shutdown();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: u */
    public synchronized void mo33536u() {
        this.f14985f = null;
        super.mo33536u();
    }

    /* access modifiers changed from: protected */
    @Deprecated
    /* renamed from: z */
    public C5806b mo33548z() {
        return this.f14985f;
    }

    /* renamed from: a */
    public void mo33036a(C5645b bVar, C5875e eVar, C5759e eVar2) throws IOException {
        C5806b z = mo33548z();
        mo33547a(z);
        z.mo33542a(bVar, eVar, eVar2);
    }

    /* renamed from: a */
    public void mo33038a(boolean z, C5759e eVar) throws IOException {
        C5806b z2 = mo33548z();
        mo33547a(z2);
        z2.mo33545a(z, eVar);
    }

    /* renamed from: a */
    public void mo33037a(C5875e eVar, C5759e eVar2) throws IOException {
        C5806b z = mo33548z();
        mo33547a(z);
        z.mo33543a(eVar, eVar2);
    }
}
