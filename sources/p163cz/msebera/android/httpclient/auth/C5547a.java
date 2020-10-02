package p163cz.msebera.android.httpclient.auth;

import p163cz.msebera.android.httpclient.p187k0.C5886a;

/* renamed from: cz.msebera.android.httpclient.auth.a */
/* compiled from: AuthOption */
public final class C5547a {

    /* renamed from: a */
    private final C5549c f14490a;

    /* renamed from: b */
    private final C5559l f14491b;

    public C5547a(C5549c cVar, C5559l lVar) {
        C5886a.m18894a(cVar, "Auth scheme");
        C5886a.m18894a(lVar, "User credentials");
        this.f14490a = cVar;
        this.f14491b = lVar;
    }

    /* renamed from: a */
    public C5549c mo32834a() {
        return this.f14490a;
    }

    /* renamed from: b */
    public C5559l mo32835b() {
        return this.f14491b;
    }

    public String toString() {
        return this.f14490a.toString();
    }
}
