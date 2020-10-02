package p163cz.msebera.android.httpclient.conn.p173q;

import java.util.concurrent.ConcurrentHashMap;
import p163cz.msebera.android.httpclient.conn.p174r.C5645b;
import p163cz.msebera.android.httpclient.p187k0.C5886a;

@Deprecated
/* renamed from: cz.msebera.android.httpclient.conn.q.c */
/* compiled from: ConnPerRouteBean */
public final class C5642c implements C5641b {

    /* renamed from: a */
    private final ConcurrentHashMap<C5645b, Integer> f14632a;

    /* renamed from: b */
    private volatile int f14633b;

    public C5642c(int i) {
        this.f14632a = new ConcurrentHashMap<>();
        mo33048a(i);
    }

    /* renamed from: a */
    public void mo33048a(int i) {
        C5886a.m18898b(i, "Default max per route");
        this.f14633b = i;
    }

    public String toString() {
        return this.f14632a.toString();
    }

    /* renamed from: a */
    public int mo33047a(C5645b bVar) {
        C5886a.m18894a(bVar, "HTTP route");
        Integer num = this.f14632a.get(bVar);
        if (num != null) {
            return num.intValue();
        }
        return this.f14633b;
    }

    public C5642c() {
        this(2);
    }
}
