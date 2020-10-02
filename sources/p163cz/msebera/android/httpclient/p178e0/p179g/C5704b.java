package p163cz.msebera.android.httpclient.p178e0.p179g;

import java.io.IOException;
import java.io.OutputStream;
import p163cz.msebera.android.httpclient.C5870j;
import p163cz.msebera.android.httpclient.C5898n;
import p163cz.msebera.android.httpclient.HttpException;
import p163cz.msebera.android.httpclient.p166c0.C5571d;
import p163cz.msebera.android.httpclient.p178e0.p180h.C5712f;
import p163cz.msebera.android.httpclient.p178e0.p180h.C5714h;
import p163cz.msebera.android.httpclient.p178e0.p180h.C5719m;
import p163cz.msebera.android.httpclient.p181f0.C5729g;
import p163cz.msebera.android.httpclient.p187k0.C5886a;

@Deprecated
/* renamed from: cz.msebera.android.httpclient.e0.g.b */
/* compiled from: EntitySerializer */
public class C5704b {

    /* renamed from: a */
    private final C5571d f14729a;

    public C5704b(C5571d dVar) {
        C5886a.m18894a(dVar, "Content length strategy");
        this.f14729a = dVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public OutputStream mo33217a(C5729g gVar, C5898n nVar) throws HttpException, IOException {
        long a = this.f14729a.mo32902a(nVar);
        if (a == -2) {
            return new C5712f(gVar);
        }
        if (a == -1) {
            return new C5719m(gVar);
        }
        return new C5714h(gVar, a);
    }

    /* renamed from: a */
    public void mo33218a(C5729g gVar, C5898n nVar, C5870j jVar) throws HttpException, IOException {
        C5886a.m18894a(gVar, "Session output buffer");
        C5886a.m18894a(nVar, "HTTP message");
        C5886a.m18894a(jVar, "HTTP entity");
        OutputStream a = mo33217a(gVar, nVar);
        jVar.mo32899a(a);
        a.close();
    }
}
