package p163cz.msebera.android.httpclient.impl.conn;

import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import p163cz.msebera.android.httpclient.conn.C5637o;
import p163cz.msebera.android.httpclient.conn.p174r.C5645b;
import p163cz.msebera.android.httpclient.conn.p174r.C5651f;
import p163cz.msebera.android.httpclient.p177d0.C5695b;
import p163cz.msebera.android.httpclient.p184i0.C5763a;

@Deprecated
/* renamed from: cz.msebera.android.httpclient.impl.conn.j */
/* compiled from: HttpPoolEntry */
class C5815j extends C5763a<C5645b, C5637o> {

    /* renamed from: i */
    public C5695b f15011i;

    /* renamed from: j */
    private final C5651f f15012j;

    public C5815j(C5695b bVar, String str, C5645b bVar2, C5637o oVar, long j, TimeUnit timeUnit) {
        super(str, bVar2, oVar, j, timeUnit);
        this.f15011i = bVar;
        this.f15012j = new C5651f(bVar2);
    }

    /* renamed from: a */
    public boolean mo33430a(long j) {
        boolean a = super.mo33430a(j);
        if (a && this.f15011i.mo33168a()) {
            C5695b bVar = this.f15011i;
            bVar.mo33166a("Connection " + this + " expired @ " + new Date(mo33431b()));
        }
        return a;
    }

    /* renamed from: d */
    public void mo33555d() {
        try {
            ((C5637o) mo33427a()).close();
        } catch (IOException e) {
            this.f15011i.mo33167a("I/O error closing connection", e);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public C5645b mo33556e() {
        return this.f15012j.mo33076i();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public C5645b mo33557f() {
        return (C5645b) mo33432c();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: g */
    public C5651f mo33558g() {
        return this.f15012j;
    }

    /* renamed from: h */
    public boolean mo33559h() {
        return !((C5637o) mo33427a()).isOpen();
    }
}
