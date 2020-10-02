package p163cz.msebera.android.httpclient.p183h0;

import java.io.Serializable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Deprecated
/* renamed from: cz.msebera.android.httpclient.h0.b */
/* compiled from: BasicHttpParams */
public class C5756b extends C5755a implements Serializable, Cloneable {
    private static final long serialVersionUID = -7086398485908701455L;

    /* renamed from: a */
    private final Map<String, Object> f14853a = new ConcurrentHashMap();

    /* renamed from: a */
    public C5759e mo33423a(String str, Object obj) {
        if (str == null) {
            return this;
        }
        if (obj != null) {
            this.f14853a.put(str, obj);
        } else {
            this.f14853a.remove(str);
        }
        return this;
    }

    /* renamed from: b */
    public Object mo33425b(String str) {
        return this.f14853a.get(str);
    }

    public Object clone() throws CloneNotSupportedException {
        C5756b bVar = (C5756b) super.clone();
        mo33424a(bVar);
        return bVar;
    }

    /* renamed from: a */
    public void mo33424a(C5759e eVar) {
        for (Map.Entry next : this.f14853a.entrySet()) {
            eVar.mo33423a((String) next.getKey(), next.getValue());
        }
    }
}
