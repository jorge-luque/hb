package p163cz.msebera.android.httpclient.impl.cookie;

import java.util.Collection;
import p163cz.msebera.android.httpclient.cookie.C5684h;
import p163cz.msebera.android.httpclient.cookie.C5685i;
import p163cz.msebera.android.httpclient.cookie.C5686j;
import p163cz.msebera.android.httpclient.p183h0.C5759e;
import p163cz.msebera.android.httpclient.p186j0.C5875e;

@Deprecated
/* renamed from: cz.msebera.android.httpclient.impl.cookie.l */
/* compiled from: BestMatchSpecFactory */
public class C5853l implements C5685i, C5686j {

    /* renamed from: a */
    private final C5684h f15082a;

    public C5853l(String[] strArr, boolean z) {
        this.f15082a = new C5852k(strArr, z);
    }

    /* renamed from: a */
    public C5684h mo33149a(C5759e eVar) {
        if (eVar == null) {
            return new C5852k();
        }
        String[] strArr = null;
        Collection collection = (Collection) eVar.mo33425b("http.protocol.cookie-datepatterns");
        if (collection != null) {
            strArr = (String[]) collection.toArray(new String[collection.size()]);
        }
        return new C5852k(strArr, eVar.mo33421b("http.protocol.single-cookie-header", false));
    }

    public C5853l() {
        this((String[]) null, false);
    }

    /* renamed from: a */
    public C5684h mo33150a(C5875e eVar) {
        return this.f15082a;
    }
}
