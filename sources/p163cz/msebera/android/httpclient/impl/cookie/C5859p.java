package p163cz.msebera.android.httpclient.impl.cookie;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import p163cz.msebera.android.httpclient.C5696e;
import p163cz.msebera.android.httpclient.C5906u;
import p163cz.msebera.android.httpclient.cookie.C5678b;
import p163cz.msebera.android.httpclient.cookie.C5679c;
import p163cz.msebera.android.httpclient.cookie.C5680d;
import p163cz.msebera.android.httpclient.cookie.C5682f;
import p163cz.msebera.android.httpclient.cookie.C5690m;
import p163cz.msebera.android.httpclient.cookie.MalformedCookieException;
import p163cz.msebera.android.httpclient.p187k0.C5886a;

/* renamed from: cz.msebera.android.httpclient.impl.cookie.p */
/* compiled from: CookieSpecBase */
public abstract class C5859p extends C5836b {
    public C5859p() {
    }

    /* renamed from: a */
    protected static String m18799a(C5682f fVar) {
        return fVar.mo33136a();
    }

    /* renamed from: b */
    protected static String m18800b(C5682f fVar) {
        String b = fVar.mo33137b();
        int lastIndexOf = b.lastIndexOf(47);
        if (lastIndexOf < 0) {
            return b;
        }
        if (lastIndexOf == 0) {
            lastIndexOf = 1;
        }
        return b.substring(0, lastIndexOf);
    }

    protected C5859p(C5678b... bVarArr) {
        super(bVarArr);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public List<C5679c> mo33619a(C5696e[] eVarArr, C5682f fVar) throws MalformedCookieException {
        ArrayList arrayList = new ArrayList(eVarArr.length);
        for (C5696e eVar : eVarArr) {
            String name = eVar.getName();
            String value = eVar.getValue();
            if (name == null || name.isEmpty()) {
                throw new MalformedCookieException("Cookie name may not be empty");
            }
            C5840d dVar = new C5840d(name, value);
            dVar.mo33159b(m18800b(fVar));
            dVar.mo33161f(m18799a(fVar));
            C5906u[] parameters = eVar.getParameters();
            for (int length = parameters.length - 1; length >= 0; length--) {
                C5906u uVar = parameters[length];
                String lowerCase = uVar.getName().toLowerCase(Locale.ROOT);
                dVar.mo33616a(lowerCase, uVar.getValue());
                C5680d a = mo33613a(lowerCase);
                if (a != null) {
                    a.mo33132a((C5690m) dVar, uVar.getValue());
                }
            }
            arrayList.add(dVar);
        }
        return arrayList;
    }

    /* renamed from: b */
    public boolean mo33147b(C5679c cVar, C5682f fVar) {
        C5886a.m18894a(cVar, "Cookie");
        C5886a.m18894a(fVar, "Cookie origin");
        for (C5680d b : mo33614b()) {
            if (!b.mo33133b(cVar, fVar)) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: a */
    public void mo33146a(C5679c cVar, C5682f fVar) throws MalformedCookieException {
        C5886a.m18894a(cVar, "Cookie");
        C5886a.m18894a(fVar, "Cookie origin");
        for (C5680d a : mo33614b()) {
            a.mo33131a(cVar, fVar);
        }
    }
}
