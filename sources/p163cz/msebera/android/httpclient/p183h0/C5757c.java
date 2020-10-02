package p163cz.msebera.android.httpclient.p183h0;

import p163cz.msebera.android.httpclient.p187k0.C5886a;

@Deprecated
/* renamed from: cz.msebera.android.httpclient.h0.c */
/* compiled from: HttpConnectionParams */
public final class C5757c {
    /* renamed from: a */
    public static void m18339a(C5759e eVar, boolean z) {
        C5886a.m18894a(eVar, "HTTP parameters");
        eVar.mo33417a("http.tcp.nodelay", z);
    }

    /* renamed from: b */
    public static void m18341b(C5759e eVar, int i) {
        C5886a.m18894a(eVar, "HTTP parameters");
        eVar.mo33416a("http.socket.timeout", i);
    }

    /* renamed from: c */
    public static boolean m18343c(C5759e eVar) {
        C5886a.m18894a(eVar, "HTTP parameters");
        return eVar.mo33421b("http.socket.reuseaddr", false);
    }

    /* renamed from: d */
    public static int m18344d(C5759e eVar) {
        C5886a.m18894a(eVar, "HTTP parameters");
        return eVar.mo33419b("http.socket.timeout", 0);
    }

    /* renamed from: e */
    public static boolean m18345e(C5759e eVar) {
        C5886a.m18894a(eVar, "HTTP parameters");
        return eVar.mo33421b("http.tcp.nodelay", true);
    }

    /* renamed from: f */
    public static boolean m18346f(C5759e eVar) {
        C5886a.m18894a(eVar, "HTTP parameters");
        return eVar.mo33421b("http.connection.stalecheck", true);
    }

    /* renamed from: a */
    public static int m18337a(C5759e eVar) {
        C5886a.m18894a(eVar, "HTTP parameters");
        return eVar.mo33419b("http.connection.timeout", 0);
    }

    /* renamed from: b */
    public static int m18340b(C5759e eVar) {
        C5886a.m18894a(eVar, "HTTP parameters");
        return eVar.mo33419b("http.socket.linger", -1);
    }

    /* renamed from: c */
    public static void m18342c(C5759e eVar, int i) {
        C5886a.m18894a(eVar, "HTTP parameters");
        eVar.mo33416a("http.socket.buffer-size", i);
    }

    /* renamed from: a */
    public static void m18338a(C5759e eVar, int i) {
        C5886a.m18894a(eVar, "HTTP parameters");
        eVar.mo33416a("http.connection.timeout", i);
    }
}
