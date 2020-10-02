package p163cz.msebera.android.httpclient.p178e0;

import java.io.IOException;
import java.net.SocketTimeoutException;
import p163cz.msebera.android.httpclient.C5754h;
import p163cz.msebera.android.httpclient.C5885k;
import p163cz.msebera.android.httpclient.C5899o;
import p163cz.msebera.android.httpclient.C5901q;
import p163cz.msebera.android.httpclient.C5902r;
import p163cz.msebera.android.httpclient.HttpException;
import p163cz.msebera.android.httpclient.p178e0.p179g.C5703a;
import p163cz.msebera.android.httpclient.p178e0.p179g.C5704b;
import p163cz.msebera.android.httpclient.p178e0.p179g.C5705c;
import p163cz.msebera.android.httpclient.p178e0.p179g.C5706d;
import p163cz.msebera.android.httpclient.p178e0.p180h.C5716j;
import p163cz.msebera.android.httpclient.p181f0.C5724b;
import p163cz.msebera.android.httpclient.p181f0.C5725c;
import p163cz.msebera.android.httpclient.p181f0.C5726d;
import p163cz.msebera.android.httpclient.p181f0.C5727e;
import p163cz.msebera.android.httpclient.p181f0.C5728f;
import p163cz.msebera.android.httpclient.p181f0.C5729g;
import p163cz.msebera.android.httpclient.p182g0.C5750t;
import p163cz.msebera.android.httpclient.p183h0.C5759e;
import p163cz.msebera.android.httpclient.p187k0.C5886a;

@Deprecated
/* renamed from: cz.msebera.android.httpclient.e0.a */
/* compiled from: AbstractHttpClientConnection */
public abstract class C5697a implements C5754h {

    /* renamed from: a */
    private final C5704b f14712a = mo33195u();

    /* renamed from: b */
    private final C5703a f14713b = mo33194t();

    /* renamed from: c */
    private C5728f f14714c = null;

    /* renamed from: d */
    private C5729g f14715d = null;

    /* renamed from: e */
    private C5724b f14716e = null;

    /* renamed from: f */
    private C5725c<C5901q> f14717f = null;

    /* renamed from: g */
    private C5726d<C5899o> f14718g = null;

    /* renamed from: h */
    private C5701e f14719h = null;

    /* renamed from: R */
    public C5901q mo33182R() throws HttpException, IOException {
        mo33191d();
        C5901q a = this.f14717f.mo33219a();
        if (a.mo33335a().mo33371a() >= 200) {
            this.f14719h.mo33203b();
        }
        return a;
    }

    /* renamed from: W */
    public boolean mo33183W() {
        if (!isOpen() || mo33198x()) {
            return true;
        }
        try {
            this.f14714c.mo33287a(1);
            return mo33198x();
        } catch (SocketTimeoutException unused) {
            return false;
        } catch (IOException unused2) {
            return true;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract C5725c<C5901q> mo33185a(C5728f fVar, C5902r rVar, C5759e eVar);

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public C5726d<C5899o> mo33186a(C5729g gVar, C5759e eVar) {
        return new C5716j(gVar, (C5750t) null, eVar);
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public abstract void mo33191d() throws IllegalStateException;

    public void flush() throws IOException {
        mo33191d();
        mo33197w();
    }

    /* renamed from: h */
    public boolean mo33193h(int i) throws IOException {
        mo33191d();
        try {
            return this.f14714c.mo33287a(i);
        } catch (SocketTimeoutException unused) {
            return false;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: t */
    public C5703a mo33194t() {
        return new C5703a(new C5705c());
    }

    /* access modifiers changed from: protected */
    /* renamed from: u */
    public C5704b mo33195u() {
        return new C5704b(new C5706d());
    }

    /* access modifiers changed from: protected */
    /* renamed from: v */
    public C5902r mo33196v() {
        return C5699c.f14720b;
    }

    /* access modifiers changed from: protected */
    /* renamed from: w */
    public void mo33197w() throws IOException {
        this.f14715d.flush();
    }

    /* access modifiers changed from: protected */
    /* renamed from: x */
    public boolean mo33198x() {
        C5724b bVar = this.f14716e;
        return bVar != null && bVar.mo33288b();
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public C5701e mo33184a(C5727e eVar, C5727e eVar2) {
        return new C5701e(eVar, eVar2);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo33187a(C5728f fVar, C5729g gVar, C5759e eVar) {
        C5886a.m18894a(fVar, "Input session buffer");
        this.f14714c = fVar;
        C5886a.m18894a(gVar, "Output session buffer");
        this.f14715d = gVar;
        if (fVar instanceof C5724b) {
            this.f14716e = (C5724b) fVar;
        }
        this.f14717f = mo33185a(fVar, mo33196v(), eVar);
        this.f14718g = mo33186a(gVar, eVar);
        this.f14719h = mo33184a(fVar.mo33224a(), gVar.mo33232a());
    }

    /* renamed from: a */
    public void mo33189a(C5899o oVar) throws HttpException, IOException {
        C5886a.m18894a(oVar, "HTTP request");
        mo33191d();
        this.f14718g.mo33221a(oVar);
        this.f14719h.mo33202a();
    }

    /* renamed from: a */
    public void mo33188a(C5885k kVar) throws HttpException, IOException {
        C5886a.m18894a(kVar, "HTTP request");
        mo33191d();
        if (kVar.getEntity() != null) {
            this.f14712a.mo33218a(this.f14715d, kVar, kVar.getEntity());
        }
    }

    /* renamed from: a */
    public void mo33190a(C5901q qVar) throws HttpException, IOException {
        C5886a.m18894a(qVar, "HTTP response");
        mo33191d();
        qVar.mo33337a(this.f14713b.mo33215a(this.f14714c, qVar));
    }
}
