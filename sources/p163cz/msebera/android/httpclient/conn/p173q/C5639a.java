package p163cz.msebera.android.httpclient.conn.p173q;

import p163cz.msebera.android.httpclient.conn.p174r.C5645b;
import p163cz.msebera.android.httpclient.p183h0.C5759e;
import p163cz.msebera.android.httpclient.p187k0.C5886a;

@Deprecated
/* renamed from: cz.msebera.android.httpclient.conn.q.a */
/* compiled from: ConnManagerParams */
public final class C5639a {

    /* renamed from: a */
    private static final C5641b f14631a = new C5640a();

    /* renamed from: cz.msebera.android.httpclient.conn.q.a$a */
    /* compiled from: ConnManagerParams */
    static class C5640a implements C5641b {
        C5640a() {
        }

        /* renamed from: a */
        public int mo33047a(C5645b bVar) {
            return 2;
        }
    }

    @Deprecated
    /* renamed from: a */
    public static void m17961a(C5759e eVar, long j) {
        C5886a.m18894a(eVar, "HTTP parameters");
        eVar.mo33420b("http.conn-manager.timeout", j);
    }

    /* renamed from: b */
    public static int m17963b(C5759e eVar) {
        C5886a.m18894a(eVar, "HTTP parameters");
        return eVar.mo33419b("http.conn-manager.max-total", 20);
    }

    /* renamed from: a */
    public static void m17962a(C5759e eVar, C5641b bVar) {
        C5886a.m18894a(eVar, "HTTP parameters");
        eVar.mo33423a("http.conn-manager.max-per-route", (Object) bVar);
    }

    /* renamed from: a */
    public static C5641b m17959a(C5759e eVar) {
        C5886a.m18894a(eVar, "HTTP parameters");
        C5641b bVar = (C5641b) eVar.mo33425b("http.conn-manager.max-per-route");
        return bVar == null ? f14631a : bVar;
    }

    /* renamed from: a */
    public static void m17960a(C5759e eVar, int i) {
        C5886a.m18894a(eVar, "HTTP parameters");
        eVar.mo33416a("http.conn-manager.max-total", i);
    }
}
