package p163cz.msebera.android.httpclient.p178e0.p179g;

import java.io.IOException;
import java.io.InputStream;
import p163cz.msebera.android.httpclient.C5691d;
import p163cz.msebera.android.httpclient.C5870j;
import p163cz.msebera.android.httpclient.C5898n;
import p163cz.msebera.android.httpclient.HttpException;
import p163cz.msebera.android.httpclient.p166c0.C5569b;
import p163cz.msebera.android.httpclient.p166c0.C5571d;
import p163cz.msebera.android.httpclient.p178e0.p180h.C5711e;
import p163cz.msebera.android.httpclient.p178e0.p180h.C5713g;
import p163cz.msebera.android.httpclient.p178e0.p180h.C5718l;
import p163cz.msebera.android.httpclient.p181f0.C5728f;
import p163cz.msebera.android.httpclient.p187k0.C5886a;

@Deprecated
/* renamed from: cz.msebera.android.httpclient.e0.g.a */
/* compiled from: EntityDeserializer */
public class C5703a {

    /* renamed from: a */
    private final C5571d f14728a;

    public C5703a(C5571d dVar) {
        C5886a.m18894a(dVar, "Content length strategy");
        this.f14728a = dVar;
    }

    /* renamed from: a */
    public C5870j mo33215a(C5728f fVar, C5898n nVar) throws HttpException, IOException {
        C5886a.m18894a(fVar, "Session input buffer");
        C5886a.m18894a(nVar, "HTTP message");
        return mo33216b(fVar, nVar);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public C5569b mo33216b(C5728f fVar, C5898n nVar) throws HttpException, IOException {
        C5569b bVar = new C5569b();
        long a = this.f14728a.mo32902a(nVar);
        if (a == -2) {
            bVar.mo32892a(true);
            bVar.mo32897a(-1);
            bVar.mo32898a((InputStream) new C5711e(fVar));
        } else if (a == -1) {
            bVar.mo32892a(false);
            bVar.mo32897a(-1);
            bVar.mo32898a((InputStream) new C5718l(fVar));
        } else {
            bVar.mo32892a(false);
            bVar.mo32897a(a);
            bVar.mo32898a((InputStream) new C5713g(fVar, a));
        }
        C5691d firstHeader = nVar.getFirstHeader("Content-Type");
        if (firstHeader != null) {
            bVar.mo32893b(firstHeader);
        }
        C5691d firstHeader2 = nVar.getFirstHeader("Content-Encoding");
        if (firstHeader2 != null) {
            bVar.mo32890a(firstHeader2);
        }
        return bVar;
    }
}
