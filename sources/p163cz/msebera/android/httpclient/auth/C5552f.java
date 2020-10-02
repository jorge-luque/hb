package p163cz.msebera.android.httpclient.auth;

import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;
import p163cz.msebera.android.httpclient.C5899o;
import p163cz.msebera.android.httpclient.p165b0.C5564a;
import p163cz.msebera.android.httpclient.p183h0.C5759e;
import p163cz.msebera.android.httpclient.p186j0.C5875e;
import p163cz.msebera.android.httpclient.p187k0.C5886a;

@Deprecated
/* renamed from: cz.msebera.android.httpclient.auth.f */
/* compiled from: AuthSchemeRegistry */
public final class C5552f implements C5564a<C5551e> {

    /* renamed from: a */
    private final ConcurrentHashMap<String, C5550d> f14498a = new ConcurrentHashMap<>();

    /* renamed from: cz.msebera.android.httpclient.auth.f$a */
    /* compiled from: AuthSchemeRegistry */
    class C5553a implements C5551e {

        /* renamed from: a */
        final /* synthetic */ String f14499a;

        C5553a(String str) {
            this.f14499a = str;
        }

        /* renamed from: a */
        public C5549c mo32844a(C5875e eVar) {
            return C5552f.this.mo32845a(this.f14499a, ((C5899o) eVar.mo33533a("http.request")).getParams());
        }
    }

    /* renamed from: a */
    public void mo32847a(String str, C5550d dVar) {
        C5886a.m18894a(str, "Name");
        C5886a.m18894a(dVar, "Authentication scheme factory");
        this.f14498a.put(str.toLowerCase(Locale.ENGLISH), dVar);
    }

    /* renamed from: a */
    public C5549c mo32845a(String str, C5759e eVar) throws IllegalStateException {
        C5886a.m18894a(str, "Name");
        C5550d dVar = this.f14498a.get(str.toLowerCase(Locale.ENGLISH));
        if (dVar != null) {
            return dVar.mo32843a(eVar);
        }
        throw new IllegalStateException("Unsupported authentication scheme: " + str);
    }

    /* renamed from: a */
    public C5551e m17701a(String str) {
        return new C5553a(str);
    }
}
