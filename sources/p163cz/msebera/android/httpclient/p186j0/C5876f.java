package p163cz.msebera.android.httpclient.p186j0;

import p163cz.msebera.android.httpclient.C5762i;
import p163cz.msebera.android.httpclient.C5896l;
import p163cz.msebera.android.httpclient.C5899o;
import p163cz.msebera.android.httpclient.p187k0.C5886a;

/* renamed from: cz.msebera.android.httpclient.j0.f */
/* compiled from: HttpCoreContext */
public class C5876f implements C5875e {

    /* renamed from: a */
    private final C5875e f15107a;

    public C5876f(C5875e eVar) {
        this.f15107a = eVar;
    }

    /* renamed from: a */
    public static C5876f m18868a(C5875e eVar) {
        C5886a.m18894a(eVar, "HTTP context");
        if (eVar instanceof C5876f) {
            return (C5876f) eVar;
        }
        return new C5876f(eVar);
    }

    /* renamed from: b */
    public C5899o mo33643b() {
        return (C5899o) mo33642a("http.request", C5899o.class);
    }

    /* renamed from: c */
    public C5896l mo33644c() {
        return (C5896l) mo33642a("http.target_host", C5896l.class);
    }

    /* renamed from: d */
    public boolean mo33645d() {
        Boolean bool = (Boolean) mo33642a("http.request_sent", Boolean.class);
        return bool != null && bool.booleanValue();
    }

    public C5876f() {
        this.f15107a = new C5871a();
    }

    /* renamed from: a */
    public Object mo33533a(String str) {
        return this.f15107a.mo33533a(str);
    }

    /* renamed from: a */
    public void mo33535a(String str, Object obj) {
        this.f15107a.mo33535a(str, obj);
    }

    /* renamed from: a */
    public <T> T mo33642a(String str, Class<T> cls) {
        C5886a.m18894a(cls, "Attribute class");
        Object a = mo33533a(str);
        if (a == null) {
            return null;
        }
        return cls.cast(a);
    }

    /* renamed from: a */
    public C5762i mo33641a() {
        return (C5762i) mo33642a("http.connection", C5762i.class);
    }
}
