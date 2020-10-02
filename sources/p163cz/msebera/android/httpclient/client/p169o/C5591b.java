package p163cz.msebera.android.httpclient.client.p169o;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import p163cz.msebera.android.httpclient.C5899o;
import p163cz.msebera.android.httpclient.client.p172r.C5616a;
import p163cz.msebera.android.httpclient.conn.C5627e;
import p163cz.msebera.android.httpclient.conn.C5629g;
import p163cz.msebera.android.httpclient.p164a0.C5546a;
import p163cz.msebera.android.httpclient.p182g0.C5731a;
import p163cz.msebera.android.httpclient.p182g0.C5748r;
import p163cz.msebera.android.httpclient.p183h0.C5759e;

/* renamed from: cz.msebera.android.httpclient.client.o.b */
/* compiled from: AbstractExecutionAwareRequest */
public abstract class C5591b extends C5731a implements C5590a, Cloneable, C5899o {

    /* renamed from: c */
    private final AtomicBoolean f14574c = new AtomicBoolean(false);

    /* renamed from: d */
    private final AtomicReference<C5546a> f14575d = new AtomicReference<>((Object) null);

    /* renamed from: cz.msebera.android.httpclient.client.o.b$a */
    /* compiled from: AbstractExecutionAwareRequest */
    class C5592a implements C5546a {

        /* renamed from: a */
        final /* synthetic */ C5627e f14576a;

        C5592a(C5591b bVar, C5627e eVar) {
            this.f14576a = eVar;
        }

        public boolean cancel() {
            this.f14576a.mo33018a();
            return true;
        }
    }

    /* renamed from: cz.msebera.android.httpclient.client.o.b$b */
    /* compiled from: AbstractExecutionAwareRequest */
    class C5593b implements C5546a {

        /* renamed from: a */
        final /* synthetic */ C5629g f14577a;

        C5593b(C5591b bVar, C5629g gVar) {
            this.f14577a = gVar;
        }

        public boolean cancel() {
            try {
                this.f14577a.mo33008t();
                return true;
            } catch (IOException unused) {
                return false;
            }
        }
    }

    protected C5591b() {
    }

    @Deprecated
    /* renamed from: a */
    public void mo32953a(C5627e eVar) {
        mo32955a((C5546a) new C5592a(this, eVar));
    }

    public void abort() {
        C5546a andSet;
        if (this.f14574c.compareAndSet(false, true) && (andSet = this.f14575d.getAndSet((Object) null)) != null) {
            andSet.cancel();
        }
    }

    public Object clone() throws CloneNotSupportedException {
        C5591b bVar = (C5591b) super.clone();
        bVar.f14795a = (C5748r) C5616a.m17866a(this.f14795a);
        bVar.f14796b = (C5759e) C5616a.m17866a(this.f14796b);
        return bVar;
    }

    public boolean isAborted() {
        return this.f14574c.get();
    }

    @Deprecated
    /* renamed from: a */
    public void mo32954a(C5629g gVar) {
        mo32955a((C5546a) new C5593b(this, gVar));
    }

    /* renamed from: a */
    public void mo32955a(C5546a aVar) {
        if (!this.f14574c.get()) {
            this.f14575d.set(aVar);
        }
    }
}
