package p163cz.msebera.android.httpclient.impl.cookie;

import java.util.ArrayList;
import java.util.List;
import p163cz.msebera.android.httpclient.C5567c;
import p163cz.msebera.android.httpclient.C5691d;
import p163cz.msebera.android.httpclient.C5696e;
import p163cz.msebera.android.httpclient.cookie.C5678b;
import p163cz.msebera.android.httpclient.cookie.C5679c;
import p163cz.msebera.android.httpclient.cookie.C5682f;
import p163cz.msebera.android.httpclient.cookie.MalformedCookieException;
import p163cz.msebera.android.httpclient.p182g0.C5747q;
import p163cz.msebera.android.httpclient.p182g0.C5752v;
import p163cz.msebera.android.httpclient.p187k0.C5886a;
import p163cz.msebera.android.httpclient.p187k0.C5889d;

/* renamed from: cz.msebera.android.httpclient.impl.cookie.v */
/* compiled from: NetscapeDraftSpec */
public class C5865v extends C5859p {
    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public C5865v(java.lang.String[] r6) {
        /*
            r5 = this;
            r0 = 5
            cz.msebera.android.httpclient.cookie.b[] r0 = new p163cz.msebera.android.httpclient.cookie.C5678b[r0]
            cz.msebera.android.httpclient.impl.cookie.i r1 = new cz.msebera.android.httpclient.impl.cookie.i
            r1.<init>()
            r2 = 0
            r0[r2] = r1
            cz.msebera.android.httpclient.impl.cookie.t r1 = new cz.msebera.android.httpclient.impl.cookie.t
            r1.<init>()
            r3 = 1
            r0[r3] = r1
            cz.msebera.android.httpclient.impl.cookie.j r1 = new cz.msebera.android.httpclient.impl.cookie.j
            r1.<init>()
            r4 = 2
            r0[r4] = r1
            cz.msebera.android.httpclient.impl.cookie.e r1 = new cz.msebera.android.httpclient.impl.cookie.e
            r1.<init>()
            r4 = 3
            r0[r4] = r1
            cz.msebera.android.httpclient.impl.cookie.g r1 = new cz.msebera.android.httpclient.impl.cookie.g
            if (r6 == 0) goto L_0x002e
            java.lang.Object r6 = r6.clone()
            java.lang.String[] r6 = (java.lang.String[]) r6
            goto L_0x0034
        L_0x002e:
            java.lang.String[] r6 = new java.lang.String[r3]
            java.lang.String r3 = "EEE, dd-MMM-yy HH:mm:ss z"
            r6[r2] = r3
        L_0x0034:
            r1.<init>(r6)
            r6 = 4
            r0[r6] = r1
            r5.<init>(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p163cz.msebera.android.httpclient.impl.cookie.C5865v.<init>(java.lang.String[]):void");
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
        if (dVar.getName().equalsIgnoreCase("Set-Cookie")) {
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
            return mo33619a(new C5696e[]{uVar.mo33624a(dVar2, vVar)}, fVar);
        }
        throw new MalformedCookieException("Unrecognized cookie header '" + dVar.toString() + "'");
    }

    public int getVersion() {
        return 0;
    }

    public String toString() {
        return "netscape";
    }

    C5865v(C5678b... bVarArr) {
        super(bVarArr);
    }

    public C5865v() {
        this((String[]) null);
    }

    /* renamed from: a */
    public List<C5691d> mo33145a(List<C5679c> list) {
        C5886a.m18895a(list, "List of cookies");
        C5889d dVar = new C5889d(list.size() * 20);
        dVar.mo33670a("Cookie");
        dVar.mo33670a(": ");
        for (int i = 0; i < list.size(); i++) {
            C5679c cVar = list.get(i);
            if (i > 0) {
                dVar.mo33670a("; ");
            }
            dVar.mo33670a(cVar.getName());
            String value = cVar.getValue();
            if (value != null) {
                dVar.mo33670a("=");
                dVar.mo33670a(value);
            }
        }
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(new C5747q(dVar));
        return arrayList;
    }
}
