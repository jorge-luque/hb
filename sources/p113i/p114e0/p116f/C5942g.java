package p113i.p114e0.p116f;

import java.io.IOException;
import java.util.List;
import okhttp3.internal.connection.C3589c;
import okhttp3.internal.connection.C6613f;
import p113i.C3480a0;
import p113i.C3497e;
import p113i.C3525i;
import p113i.C3532p;
import p113i.C3548y;
import p113i.C5970t;

/* renamed from: i.e0.f.g */
/* compiled from: RealInterceptorChain */
public final class C5942g implements C5970t.C5971a {

    /* renamed from: a */
    private final List<C5970t> f15182a;

    /* renamed from: b */
    private final C6613f f15183b;

    /* renamed from: c */
    private final C5937c f15184c;

    /* renamed from: d */
    private final C3589c f15185d;

    /* renamed from: e */
    private final int f15186e;

    /* renamed from: f */
    private final C3548y f15187f;

    /* renamed from: g */
    private final C3497e f15188g;

    /* renamed from: h */
    private final C3532p f15189h;

    /* renamed from: i */
    private final int f15190i;

    /* renamed from: j */
    private final int f15191j;

    /* renamed from: k */
    private final int f15192k;

    /* renamed from: l */
    private int f15193l;

    public C5942g(List<C5970t> list, C6613f fVar, C5937c cVar, C3589c cVar2, int i, C3548y yVar, C3497e eVar, C3532p pVar, int i2, int i3, int i4) {
        this.f15182a = list;
        this.f15185d = cVar2;
        this.f15183b = fVar;
        this.f15184c = cVar;
        this.f15186e = i;
        this.f15187f = yVar;
        this.f15188g = eVar;
        this.f15189h = pVar;
        this.f15190i = i2;
        this.f15191j = i3;
        this.f15192k = i4;
    }

    /* renamed from: a */
    public int mo33729a() {
        return this.f15191j;
    }

    /* renamed from: b */
    public int mo33732b() {
        return this.f15192k;
    }

    /* renamed from: c */
    public int mo33733c() {
        return this.f15190i;
    }

    /* renamed from: d */
    public C3548y mo33734d() {
        return this.f15187f;
    }

    /* renamed from: e */
    public C3497e mo33735e() {
        return this.f15188g;
    }

    /* renamed from: f */
    public C3525i mo33736f() {
        return this.f15185d;
    }

    /* renamed from: g */
    public C3532p mo33737g() {
        return this.f15189h;
    }

    /* renamed from: h */
    public C5937c mo33738h() {
        return this.f15184c;
    }

    /* renamed from: i */
    public C6613f mo33739i() {
        return this.f15183b;
    }

    /* renamed from: a */
    public C3480a0 mo33730a(C3548y yVar) throws IOException {
        return mo33731a(yVar, this.f15183b, this.f15184c, this.f15185d);
    }

    /* renamed from: a */
    public C3480a0 mo33731a(C3548y yVar, C6613f fVar, C5937c cVar, C3589c cVar2) throws IOException {
        if (this.f15186e < this.f15182a.size()) {
            this.f15193l++;
            if (this.f15184c != null && !this.f15185d.mo19785a(yVar.mo19607g())) {
                throw new IllegalStateException("network interceptor " + this.f15182a.get(this.f15186e - 1) + " must retain the same host and port");
            } else if (this.f15184c == null || this.f15193l <= 1) {
                C5942g gVar = new C5942g(this.f15182a, fVar, cVar, cVar2, this.f15186e + 1, yVar, this.f15188g, this.f15189h, this.f15190i, this.f15191j, this.f15192k);
                C5970t tVar = this.f15182a.get(this.f15186e);
                C3480a0 intercept = tVar.intercept(gVar);
                if (cVar != null && this.f15186e + 1 < this.f15182a.size() && gVar.f15193l != 1) {
                    throw new IllegalStateException("network interceptor " + tVar + " must call proceed() exactly once");
                } else if (intercept == null) {
                    throw new NullPointerException("interceptor " + tVar + " returned null");
                } else if (intercept.mo19284d() != null) {
                    return intercept;
                } else {
                    throw new IllegalStateException("interceptor " + tVar + " returned a response with no body");
                }
            } else {
                throw new IllegalStateException("network interceptor " + this.f15182a.get(this.f15186e - 1) + " must call proceed() exactly once");
            }
        } else {
            throw new AssertionError();
        }
    }
}
