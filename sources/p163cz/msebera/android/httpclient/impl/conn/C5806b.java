package p163cz.msebera.android.httpclient.impl.conn;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.Socket;
import p163cz.msebera.android.httpclient.C5896l;
import p163cz.msebera.android.httpclient.conn.C5626d;
import p163cz.msebera.android.httpclient.conn.C5637o;
import p163cz.msebera.android.httpclient.conn.p174r.C5645b;
import p163cz.msebera.android.httpclient.conn.p174r.C5651f;
import p163cz.msebera.android.httpclient.p183h0.C5759e;
import p163cz.msebera.android.httpclient.p186j0.C5875e;
import p163cz.msebera.android.httpclient.p187k0.C5886a;
import p163cz.msebera.android.httpclient.p187k0.C5887b;

@Deprecated
/* renamed from: cz.msebera.android.httpclient.impl.conn.b */
/* compiled from: AbstractPoolEntry */
public abstract class C5806b {

    /* renamed from: a */
    protected final C5626d f14980a;

    /* renamed from: b */
    protected final C5637o f14981b;

    /* renamed from: c */
    protected volatile C5645b f14982c;

    /* renamed from: d */
    protected volatile Object f14983d;

    /* renamed from: e */
    protected volatile C5651f f14984e = null;

    protected C5806b(C5626d dVar, C5645b bVar) {
        C5886a.m18894a(dVar, "Connection operator");
        this.f14980a = dVar;
        this.f14981b = dVar.mo33014a();
        this.f14982c = bVar;
    }

    /* renamed from: a */
    public Object mo33541a() {
        return this.f14983d;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo33546b() {
        this.f14984e = null;
        this.f14983d = null;
    }

    /* renamed from: a */
    public void mo33544a(Object obj) {
        this.f14983d = obj;
    }

    /* renamed from: a */
    public void mo33542a(C5645b bVar, C5875e eVar, C5759e eVar2) throws IOException {
        C5896l lVar;
        C5886a.m18894a(bVar, "Route");
        C5886a.m18894a(eVar2, "HTTP parameters");
        if (this.f14984e != null) {
            C5887b.m18902a(!this.f14984e.mo33073g(), "Connection already open");
        }
        this.f14984e = new C5651f(bVar);
        C5896l c = bVar.mo33058c();
        C5626d dVar = this.f14980a;
        C5637o oVar = this.f14981b;
        if (c != null) {
            lVar = c;
        } else {
            lVar = bVar.mo33061e();
        }
        dVar.mo33016a(oVar, lVar, bVar.mo33060d(), eVar, eVar2);
        C5651f fVar = this.f14984e;
        if (fVar == null) {
            throw new InterruptedIOException("Request aborted");
        } else if (c == null) {
            fVar.mo33068a(this.f14981b.mo33041B());
        } else {
            fVar.mo33067a(c, this.f14981b.mo33041B());
        }
    }

    /* renamed from: a */
    public void mo33545a(boolean z, C5759e eVar) throws IOException {
        C5886a.m18894a(eVar, "HTTP parameters");
        C5887b.m18901a((Object) this.f14984e, "Route tracker");
        C5887b.m18902a(this.f14984e.mo33073g(), "Connection not open");
        C5887b.m18902a(!this.f14984e.mo33057b(), "Connection is already tunnelled");
        this.f14981b.mo33044a((Socket) null, this.f14984e.mo33061e(), z, eVar);
        this.f14984e.mo33070c(z);
    }

    /* renamed from: a */
    public void mo33543a(C5875e eVar, C5759e eVar2) throws IOException {
        C5886a.m18894a(eVar2, "HTTP parameters");
        C5887b.m18901a((Object) this.f14984e, "Route tracker");
        C5887b.m18902a(this.f14984e.mo33073g(), "Connection not open");
        C5887b.m18902a(this.f14984e.mo33057b(), "Protocol layering without a tunnel not supported");
        C5887b.m18902a(!this.f14984e.mo33063f(), "Multiple protocol layering not supported");
        this.f14980a.mo33015a(this.f14981b, this.f14984e.mo33061e(), eVar, eVar2);
        this.f14984e.mo33069b(this.f14981b.mo33041B());
    }
}
