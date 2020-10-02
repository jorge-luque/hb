package p163cz.msebera.android.httpclient.p183h0;

import p163cz.msebera.android.httpclient.C5905t;
import p163cz.msebera.android.httpclient.C5907v;
import p163cz.msebera.android.httpclient.p186j0.C5874d;
import p163cz.msebera.android.httpclient.p187k0.C5886a;

@Deprecated
/* renamed from: cz.msebera.android.httpclient.h0.f */
/* compiled from: HttpProtocolParams */
public final class C5760f {
    /* renamed from: a */
    public static String m18358a(C5759e eVar) {
        C5886a.m18894a(eVar, "HTTP parameters");
        String str = (String) eVar.mo33425b("http.protocol.element-charset");
        return str == null ? C5874d.f15106b.name() : str;
    }

    /* renamed from: b */
    public static C5907v m18361b(C5759e eVar) {
        C5886a.m18894a(eVar, "HTTP parameters");
        Object b = eVar.mo33425b("http.protocol.version");
        if (b == null) {
            return C5905t.f15130f;
        }
        return (C5907v) b;
    }

    /* renamed from: a */
    public static void m18360a(C5759e eVar, String str) {
        C5886a.m18894a(eVar, "HTTP parameters");
        eVar.mo33423a("http.protocol.content-charset", (Object) str);
    }

    /* renamed from: b */
    public static void m18362b(C5759e eVar, String str) {
        C5886a.m18894a(eVar, "HTTP parameters");
        eVar.mo33423a("http.useragent", (Object) str);
    }

    /* renamed from: a */
    public static void m18359a(C5759e eVar, C5907v vVar) {
        C5886a.m18894a(eVar, "HTTP parameters");
        eVar.mo33423a("http.protocol.version", (Object) vVar);
    }
}
