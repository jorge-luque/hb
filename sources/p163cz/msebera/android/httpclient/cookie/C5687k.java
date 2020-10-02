package p163cz.msebera.android.httpclient.cookie;

import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;
import p163cz.msebera.android.httpclient.C5899o;
import p163cz.msebera.android.httpclient.p165b0.C5564a;
import p163cz.msebera.android.httpclient.p183h0.C5759e;
import p163cz.msebera.android.httpclient.p186j0.C5875e;
import p163cz.msebera.android.httpclient.p187k0.C5886a;

@Deprecated
/* renamed from: cz.msebera.android.httpclient.cookie.k */
/* compiled from: CookieSpecRegistry */
public final class C5687k implements C5564a<C5686j> {

    /* renamed from: a */
    private final ConcurrentHashMap<String, C5685i> f14693a = new ConcurrentHashMap<>();

    /* renamed from: cz.msebera.android.httpclient.cookie.k$a */
    /* compiled from: CookieSpecRegistry */
    class C5688a implements C5686j {

        /* renamed from: a */
        final /* synthetic */ String f14694a;

        C5688a(String str) {
            this.f14694a = str;
        }

        /* renamed from: a */
        public C5684h mo33150a(C5875e eVar) {
            return C5687k.this.mo33151a(this.f14694a, ((C5899o) eVar.mo33533a("http.request")).getParams());
        }
    }

    /* renamed from: a */
    public void mo33152a(String str, C5685i iVar) {
        C5886a.m18894a(str, "Name");
        C5886a.m18894a(iVar, "Cookie spec factory");
        this.f14693a.put(str.toLowerCase(Locale.ENGLISH), iVar);
    }

    /* renamed from: a */
    public C5684h mo33151a(String str, C5759e eVar) throws IllegalStateException {
        C5886a.m18894a(str, "Name");
        C5685i iVar = this.f14693a.get(str.toLowerCase(Locale.ENGLISH));
        if (iVar != null) {
            return iVar.mo33149a(eVar);
        }
        throw new IllegalStateException("Unsupported cookie spec: " + str);
    }

    /* renamed from: a */
    public C5686j m18111a(String str) {
        return new C5688a(str);
    }
}
