package p163cz.msebera.android.httpclient.impl.cookie;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import p163cz.msebera.android.httpclient.cookie.C5678b;
import p163cz.msebera.android.httpclient.cookie.C5680d;
import p163cz.msebera.android.httpclient.cookie.C5684h;

/* renamed from: cz.msebera.android.httpclient.impl.cookie.b */
/* compiled from: AbstractCookieSpec */
public abstract class C5836b implements C5684h {

    /* renamed from: a */
    private final Map<String, C5680d> f15069a;

    public C5836b() {
        this.f15069a = new ConcurrentHashMap(10);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public C5680d mo33613a(String str) {
        return this.f15069a.get(str);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public Collection<C5680d> mo33614b() {
        return this.f15069a.values();
    }

    protected C5836b(C5678b... bVarArr) {
        this.f15069a = new ConcurrentHashMap(bVarArr.length);
        for (C5678b bVar : bVarArr) {
            this.f15069a.put(bVar.mo33121a(), bVar);
        }
    }
}
