package p163cz.msebera.android.httpclient.p182g0;

import java.util.ArrayList;
import java.util.BitSet;
import p163cz.msebera.android.httpclient.C5696e;
import p163cz.msebera.android.httpclient.C5906u;
import p163cz.msebera.android.httpclient.ParseException;
import p163cz.msebera.android.httpclient.p187k0.C5886a;
import p163cz.msebera.android.httpclient.p187k0.C5889d;

/* renamed from: cz.msebera.android.httpclient.g0.g */
/* compiled from: BasicHeaderValueParser */
public class C5737g implements C5749s {

    /* renamed from: b */
    public static final C5737g f14811b = new C5737g();

    /* renamed from: c */
    private static final BitSet f14812c = C5753w.m18313a(61, 59, 44);

    /* renamed from: d */
    private static final BitSet f14813d = C5753w.m18313a(59, 44);

    /* renamed from: a */
    private final C5753w f14814a = C5753w.f14852a;

    static {
        new C5737g();
    }

    /* renamed from: a */
    public static C5696e[] m18249a(String str, C5749s sVar) throws ParseException {
        C5886a.m18894a(str, "Value");
        C5889d dVar = new C5889d(str.length());
        dVar.mo33670a(str);
        C5752v vVar = new C5752v(0, str.length());
        if (sVar == null) {
            sVar = f14811b;
        }
        return sVar.mo33330a(dVar, vVar);
    }

    /* renamed from: b */
    public C5696e mo33331b(C5889d dVar, C5752v vVar) {
        C5886a.m18894a(dVar, "Char array buffer");
        C5886a.m18894a(vVar, "Parser cursor");
        C5906u c = mo33332c(dVar, vVar);
        return mo33328a(c.getName(), c.getValue(), (vVar.mo33405a() || dVar.charAt(vVar.mo33406b() + -1) == ',') ? null : mo33333d(dVar, vVar));
    }

    /* renamed from: c */
    public C5906u mo33332c(C5889d dVar, C5752v vVar) {
        C5886a.m18894a(dVar, "Char array buffer");
        C5886a.m18894a(vVar, "Parser cursor");
        String a = this.f14814a.mo33409a(dVar, vVar, f14812c);
        if (vVar.mo33405a()) {
            return new C5743m(a, (String) null);
        }
        char charAt = dVar.charAt(vVar.mo33406b());
        vVar.mo33404a(vVar.mo33406b() + 1);
        if (charAt != '=') {
            return mo33329a(a, (String) null);
        }
        String b = this.f14814a.mo33413b(dVar, vVar, f14813d);
        if (!vVar.mo33405a()) {
            vVar.mo33404a(vVar.mo33406b() + 1);
        }
        return mo33329a(a, b);
    }

    /* renamed from: d */
    public C5906u[] mo33333d(C5889d dVar, C5752v vVar) {
        C5886a.m18894a(dVar, "Char array buffer");
        C5886a.m18894a(vVar, "Parser cursor");
        this.f14814a.mo33410a(dVar, vVar);
        ArrayList arrayList = new ArrayList();
        while (!vVar.mo33405a()) {
            arrayList.add(mo33332c(dVar, vVar));
            if (dVar.charAt(vVar.mo33406b() - 1) == ',') {
                break;
            }
        }
        return (C5906u[]) arrayList.toArray(new C5906u[arrayList.size()]);
    }

    /* renamed from: a */
    public C5696e[] mo33330a(C5889d dVar, C5752v vVar) {
        C5886a.m18894a(dVar, "Char array buffer");
        C5886a.m18894a(vVar, "Parser cursor");
        ArrayList arrayList = new ArrayList();
        while (!vVar.mo33405a()) {
            C5696e b = mo33331b(dVar, vVar);
            if (b.getName().length() != 0 || b.getValue() != null) {
                arrayList.add(b);
            }
        }
        return (C5696e[]) arrayList.toArray(new C5696e[arrayList.size()]);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public C5696e mo33328a(String str, String str2, C5906u[] uVarArr) {
        return new C5733c(str, str2, uVarArr);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public C5906u mo33329a(String str, String str2) {
        return new C5743m(str, str2);
    }
}
