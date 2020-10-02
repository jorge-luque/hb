package p163cz.msebera.android.httpclient.impl.cookie;

import java.util.List;
import p163cz.msebera.android.httpclient.C5567c;
import p163cz.msebera.android.httpclient.C5691d;
import p163cz.msebera.android.httpclient.C5696e;
import p163cz.msebera.android.httpclient.cookie.C5678b;
import p163cz.msebera.android.httpclient.cookie.C5679c;
import p163cz.msebera.android.httpclient.cookie.C5682f;
import p163cz.msebera.android.httpclient.cookie.C5684h;
import p163cz.msebera.android.httpclient.cookie.C5689l;
import p163cz.msebera.android.httpclient.cookie.MalformedCookieException;
import p163cz.msebera.android.httpclient.p182g0.C5752v;
import p163cz.msebera.android.httpclient.p187k0.C5886a;
import p163cz.msebera.android.httpclient.p187k0.C5889d;

/* renamed from: cz.msebera.android.httpclient.impl.cookie.q */
/* compiled from: DefaultCookieSpec */
public class C5860q implements C5684h {

    /* renamed from: a */
    private final C5845f0 f15088a;

    /* renamed from: b */
    private final C5868y f15089b;

    /* renamed from: c */
    private final C5865v f15090c;

    public C5860q(String[] strArr, boolean z) {
        this.f15088a = new C5845f0(z, new C5849h0(), new C5850i(), new C5841d0(), new C5843e0(), new C5848h(), new C5851j(), new C5842e(), new C5837b0(), new C5839c0());
        this.f15089b = new C5868y(z, new C5835a0(), new C5850i(), new C5867x(), new C5848h(), new C5851j(), new C5842e());
        C5678b[] bVarArr = new C5678b[5];
        bVarArr[0] = new C5844f();
        bVarArr[1] = new C5850i();
        bVarArr[2] = new C5851j();
        bVarArr[3] = new C5842e();
        bVarArr[4] = new C5846g(strArr != null ? (String[]) strArr.clone() : new String[]{"EEE, dd-MMM-yy HH:mm:ss z"});
        this.f15090c = new C5865v(bVarArr);
    }

    /* renamed from: a */
    public C5691d mo33143a() {
        return null;
    }

    /* renamed from: a */
    public List<C5679c> mo33144a(C5691d dVar, C5682f fVar) throws MalformedCookieException {
        C5752v vVar;
        C5889d dVar2;
        C5886a.m18894a(dVar, "Header");
        C5886a.m18894a(fVar, "Cookie origin");
        C5696e[] b = dVar.mo33162b();
        boolean z = false;
        boolean z2 = false;
        for (C5696e eVar : b) {
            if (eVar.mo33178a("version") != null) {
                z2 = true;
            }
            if (eVar.mo33178a("expires") != null) {
                z = true;
            }
        }
        if (z || !z2) {
            C5864u uVar = C5864u.f15091b;
            if (dVar instanceof C5567c) {
                C5567c cVar = (C5567c) dVar;
                dVar2 = cVar.mo32887a();
                vVar = new C5752v(cVar.mo32888c(), dVar2.length());
            } else {
                String value = dVar.getValue();
                if (value != null) {
                    dVar2 = new C5889d(value.length());
                    dVar2.mo33670a(value);
                    vVar = new C5752v(0, dVar2.length());
                } else {
                    throw new MalformedCookieException("Header value is null");
                }
            }
            return this.f15090c.mo33619a(new C5696e[]{uVar.mo33624a(dVar2, vVar)}, fVar);
        } else if ("Set-Cookie2".equals(dVar.getName())) {
            return this.f15088a.mo33619a(b, fVar);
        } else {
            return this.f15089b.mo33619a(b, fVar);
        }
    }

    /* renamed from: b */
    public boolean mo33147b(C5679c cVar, C5682f fVar) {
        C5886a.m18894a(cVar, "Cookie");
        C5886a.m18894a(fVar, "Cookie origin");
        if (cVar.getVersion() <= 0) {
            return this.f15090c.mo33147b(cVar, fVar);
        }
        if (cVar instanceof C5689l) {
            return this.f15088a.mo33147b(cVar, fVar);
        }
        return this.f15089b.mo33147b(cVar, fVar);
    }

    public int getVersion() {
        return this.f15088a.getVersion();
    }

    /* renamed from: a */
    public void mo33146a(C5679c cVar, C5682f fVar) throws MalformedCookieException {
        C5886a.m18894a(cVar, "Cookie");
        C5886a.m18894a(fVar, "Cookie origin");
        if (cVar.getVersion() <= 0) {
            this.f15090c.mo33146a(cVar, fVar);
        } else if (cVar instanceof C5689l) {
            this.f15088a.mo33146a(cVar, fVar);
        } else {
            this.f15089b.mo33146a(cVar, fVar);
        }
    }

    /* renamed from: a */
    public List<C5691d> mo33145a(List<C5679c> list) {
        C5886a.m18894a(list, "List of cookies");
        int i = Integer.MAX_VALUE;
        boolean z = true;
        for (C5679c next : list) {
            if (!(next instanceof C5689l)) {
                z = false;
            }
            if (next.getVersion() < i) {
                i = next.getVersion();
            }
        }
        if (i <= 0) {
            return this.f15090c.mo33145a(list);
        }
        if (z) {
            return this.f15088a.mo33145a(list);
        }
        return this.f15089b.mo33145a(list);
    }
}
