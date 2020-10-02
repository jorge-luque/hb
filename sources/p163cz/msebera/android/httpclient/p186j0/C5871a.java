package p163cz.msebera.android.httpclient.p186j0;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import p163cz.msebera.android.httpclient.p187k0.C5886a;

/* renamed from: cz.msebera.android.httpclient.j0.a */
/* compiled from: BasicHttpContext */
public class C5871a implements C5875e {

    /* renamed from: a */
    private final C5875e f15099a;

    /* renamed from: b */
    private final Map<String, Object> f15100b;

    public C5871a() {
        this((C5875e) null);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000d, code lost:
        r1 = r2.f15099a;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object mo33533a(java.lang.String r3) {
        /*
            r2 = this;
            java.lang.String r0 = "Id"
            p163cz.msebera.android.httpclient.p187k0.C5886a.m18894a(r3, (java.lang.String) r0)
            java.util.Map<java.lang.String, java.lang.Object> r0 = r2.f15100b
            java.lang.Object r0 = r0.get(r3)
            if (r0 != 0) goto L_0x0015
            cz.msebera.android.httpclient.j0.e r1 = r2.f15099a
            if (r1 == 0) goto L_0x0015
            java.lang.Object r0 = r1.mo33533a(r3)
        L_0x0015:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p163cz.msebera.android.httpclient.p186j0.C5871a.mo33533a(java.lang.String):java.lang.Object");
    }

    public String toString() {
        return this.f15100b.toString();
    }

    public C5871a(C5875e eVar) {
        this.f15100b = new ConcurrentHashMap();
        this.f15099a = eVar;
    }

    /* renamed from: a */
    public void mo33535a(String str, Object obj) {
        C5886a.m18894a(str, "Id");
        if (obj != null) {
            this.f15100b.put(str, obj);
        } else {
            this.f15100b.remove(str);
        }
    }
}
