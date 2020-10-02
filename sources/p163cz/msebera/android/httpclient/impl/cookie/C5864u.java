package p163cz.msebera.android.httpclient.impl.cookie;

import java.util.ArrayList;
import java.util.BitSet;
import p163cz.msebera.android.httpclient.C5696e;
import p163cz.msebera.android.httpclient.C5906u;
import p163cz.msebera.android.httpclient.ParseException;
import p163cz.msebera.android.httpclient.p182g0.C5733c;
import p163cz.msebera.android.httpclient.p182g0.C5743m;
import p163cz.msebera.android.httpclient.p182g0.C5752v;
import p163cz.msebera.android.httpclient.p182g0.C5753w;
import p163cz.msebera.android.httpclient.p187k0.C5886a;
import p163cz.msebera.android.httpclient.p187k0.C5889d;

/* renamed from: cz.msebera.android.httpclient.impl.cookie.u */
/* compiled from: NetscapeDraftHeaderParser */
public class C5864u {

    /* renamed from: b */
    public static final C5864u f15091b = new C5864u();

    /* renamed from: c */
    private static final BitSet f15092c = C5753w.m18313a(61, 59);

    /* renamed from: d */
    private static final BitSet f15093d = C5753w.m18313a(59);

    /* renamed from: a */
    private final C5753w f15094a = C5753w.f14852a;

    /* renamed from: b */
    private C5906u m18819b(C5889d dVar, C5752v vVar) {
        String a = this.f15094a.mo33409a(dVar, vVar, f15092c);
        if (vVar.mo33405a()) {
            return new C5743m(a, (String) null);
        }
        char charAt = dVar.charAt(vVar.mo33406b());
        vVar.mo33404a(vVar.mo33406b() + 1);
        if (charAt != '=') {
            return new C5743m(a, (String) null);
        }
        String a2 = this.f15094a.mo33409a(dVar, vVar, f15093d);
        if (!vVar.mo33405a()) {
            vVar.mo33404a(vVar.mo33406b() + 1);
        }
        return new C5743m(a, a2);
    }

    /* renamed from: a */
    public C5696e mo33624a(C5889d dVar, C5752v vVar) throws ParseException {
        C5886a.m18894a(dVar, "Char array buffer");
        C5886a.m18894a(vVar, "Parser cursor");
        C5906u b = m18819b(dVar, vVar);
        ArrayList arrayList = new ArrayList();
        while (!vVar.mo33405a()) {
            arrayList.add(m18819b(dVar, vVar));
        }
        return new C5733c(b.getName(), b.getValue(), (C5906u[]) arrayList.toArray(new C5906u[arrayList.size()]));
    }
}
