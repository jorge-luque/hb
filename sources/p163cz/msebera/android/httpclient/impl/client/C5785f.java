package p163cz.msebera.android.httpclient.impl.client;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import p163cz.msebera.android.httpclient.auth.C5554g;
import p163cz.msebera.android.httpclient.auth.C5559l;
import p163cz.msebera.android.httpclient.client.C5581g;
import p163cz.msebera.android.httpclient.p187k0.C5886a;

/* renamed from: cz.msebera.android.httpclient.impl.client.f */
/* compiled from: BasicCredentialsProvider */
public class C5785f implements C5581g {

    /* renamed from: a */
    private final ConcurrentHashMap<C5554g, C5559l> f14929a = new ConcurrentHashMap<>();

    /* renamed from: a */
    private static C5559l m18479a(Map<C5554g, C5559l> map, C5554g gVar) {
        C5559l lVar = map.get(gVar);
        if (lVar != null) {
            return lVar;
        }
        int i = -1;
        C5554g gVar2 = null;
        for (C5554g next : map.keySet()) {
            int a = gVar.mo32848a(next);
            if (a > i) {
                gVar2 = next;
                i = a;
            }
        }
        return gVar2 != null ? map.get(gVar2) : lVar;
    }

    public String toString() {
        return this.f14929a.toString();
    }

    /* renamed from: a */
    public C5559l mo32925a(C5554g gVar) {
        C5886a.m18894a(gVar, "Authentication scope");
        return m18479a(this.f14929a, gVar);
    }
}
