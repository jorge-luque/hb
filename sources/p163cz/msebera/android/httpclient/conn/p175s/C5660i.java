package p163cz.msebera.android.httpclient.conn.p175s;

import java.util.concurrent.ConcurrentHashMap;
import p163cz.msebera.android.httpclient.C5896l;
import p163cz.msebera.android.httpclient.p187k0.C5886a;

@Deprecated
/* renamed from: cz.msebera.android.httpclient.conn.s.i */
/* compiled from: SchemeRegistry */
public final class C5660i {

    /* renamed from: a */
    private final ConcurrentHashMap<String, C5656e> f14661a = new ConcurrentHashMap<>();

    /* renamed from: a */
    public final C5656e mo33094a(C5896l lVar) {
        C5886a.m18894a(lVar, "Host");
        return mo33096b(lVar.mo33688d());
    }

    /* renamed from: b */
    public final C5656e mo33096b(String str) {
        C5656e a = mo33095a(str);
        if (a != null) {
            return a;
        }
        throw new IllegalStateException("Scheme '" + str + "' not registered.");
    }

    /* renamed from: a */
    public final C5656e mo33095a(String str) {
        C5886a.m18894a(str, "Scheme name");
        return this.f14661a.get(str);
    }

    /* renamed from: a */
    public final C5656e mo33093a(C5656e eVar) {
        C5886a.m18894a(eVar, "Scheme");
        return this.f14661a.put(eVar.mo33086b(), eVar);
    }
}
