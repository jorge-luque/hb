package p163cz.msebera.android.httpclient.impl.cookie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import p163cz.msebera.android.httpclient.C5691d;
import p163cz.msebera.android.httpclient.C5696e;
import p163cz.msebera.android.httpclient.C5906u;
import p163cz.msebera.android.httpclient.cookie.C5677a;
import p163cz.msebera.android.httpclient.cookie.C5678b;
import p163cz.msebera.android.httpclient.cookie.C5679c;
import p163cz.msebera.android.httpclient.cookie.C5680d;
import p163cz.msebera.android.httpclient.cookie.C5682f;
import p163cz.msebera.android.httpclient.cookie.C5690m;
import p163cz.msebera.android.httpclient.cookie.MalformedCookieException;
import p163cz.msebera.android.httpclient.p182g0.C5747q;
import p163cz.msebera.android.httpclient.p187k0.C5886a;
import p163cz.msebera.android.httpclient.p187k0.C5889d;

/* renamed from: cz.msebera.android.httpclient.impl.cookie.f0 */
/* compiled from: RFC2965Spec */
public class C5845f0 extends C5868y {
    public C5845f0() {
        this((String[]) null, false);
    }

    /* renamed from: b */
    private List<C5679c> m18762b(C5696e[] eVarArr, C5682f fVar) throws MalformedCookieException {
        ArrayList arrayList = new ArrayList(eVarArr.length);
        for (C5696e eVar : eVarArr) {
            String name = eVar.getName();
            String value = eVar.getValue();
            if (name == null || name.isEmpty()) {
                throw new MalformedCookieException("Cookie name may not be empty");
            }
            C5838c cVar = new C5838c(name, value);
            cVar.mo33159b(C5859p.m18800b(fVar));
            cVar.mo33161f(C5859p.m18799a(fVar));
            cVar.mo33153a(new int[]{fVar.mo33138c()});
            C5906u[] parameters = eVar.getParameters();
            HashMap hashMap = new HashMap(parameters.length);
            for (int length = parameters.length - 1; length >= 0; length--) {
                C5906u uVar = parameters[length];
                hashMap.put(uVar.getName().toLowerCase(Locale.ROOT), uVar);
            }
            for (Map.Entry value2 : hashMap.entrySet()) {
                C5906u uVar2 = (C5906u) value2.getValue();
                String lowerCase = uVar2.getName().toLowerCase(Locale.ROOT);
                cVar.mo33616a(lowerCase, uVar2.getValue());
                C5680d a = mo33613a(lowerCase);
                if (a != null) {
                    a.mo33132a((C5690m) cVar, uVar2.getValue());
                }
            }
            arrayList.add(cVar);
        }
        return arrayList;
    }

    /* renamed from: c */
    private static C5682f m18763c(C5682f fVar) {
        String a = fVar.mo33136a();
        boolean z = false;
        int i = 0;
        while (true) {
            if (i >= a.length()) {
                z = true;
                break;
            }
            char charAt = a.charAt(i);
            if (charAt == '.' || charAt == ':') {
                break;
            }
            i++;
        }
        if (!z) {
            return fVar;
        }
        return new C5682f(a + ".local", fVar.mo33138c(), fVar.mo33137b(), fVar.mo33139d());
    }

    /* renamed from: a */
    public List<C5679c> mo33144a(C5691d dVar, C5682f fVar) throws MalformedCookieException {
        C5886a.m18894a(dVar, "Header");
        C5886a.m18894a(fVar, "Cookie origin");
        if (dVar.getName().equalsIgnoreCase("Set-Cookie2")) {
            return m18762b(dVar.mo33162b(), m18763c(fVar));
        }
        throw new MalformedCookieException("Unrecognized cookie header '" + dVar.toString() + "'");
    }

    public int getVersion() {
        return 1;
    }

    public String toString() {
        return "rfc2965";
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public C5845f0(java.lang.String[] r4, boolean r5) {
        /*
            r3 = this;
            r0 = 10
            cz.msebera.android.httpclient.cookie.b[] r0 = new p163cz.msebera.android.httpclient.cookie.C5678b[r0]
            cz.msebera.android.httpclient.impl.cookie.h0 r1 = new cz.msebera.android.httpclient.impl.cookie.h0
            r1.<init>()
            r2 = 0
            r0[r2] = r1
            cz.msebera.android.httpclient.impl.cookie.i r1 = new cz.msebera.android.httpclient.impl.cookie.i
            r1.<init>()
            r2 = 1
            r0[r2] = r1
            cz.msebera.android.httpclient.impl.cookie.d0 r1 = new cz.msebera.android.httpclient.impl.cookie.d0
            r1.<init>()
            r2 = 2
            r0[r2] = r1
            cz.msebera.android.httpclient.impl.cookie.e0 r1 = new cz.msebera.android.httpclient.impl.cookie.e0
            r1.<init>()
            r2 = 3
            r0[r2] = r1
            cz.msebera.android.httpclient.impl.cookie.h r1 = new cz.msebera.android.httpclient.impl.cookie.h
            r1.<init>()
            r2 = 4
            r0[r2] = r1
            cz.msebera.android.httpclient.impl.cookie.j r1 = new cz.msebera.android.httpclient.impl.cookie.j
            r1.<init>()
            r2 = 5
            r0[r2] = r1
            cz.msebera.android.httpclient.impl.cookie.e r1 = new cz.msebera.android.httpclient.impl.cookie.e
            r1.<init>()
            r2 = 6
            r0[r2] = r1
            cz.msebera.android.httpclient.impl.cookie.g r1 = new cz.msebera.android.httpclient.impl.cookie.g
            if (r4 == 0) goto L_0x0047
            java.lang.Object r4 = r4.clone()
            java.lang.String[] r4 = (java.lang.String[]) r4
            goto L_0x0049
        L_0x0047:
            java.lang.String[] r4 = p163cz.msebera.android.httpclient.impl.cookie.C5868y.f15096c
        L_0x0049:
            r1.<init>(r4)
            r4 = 7
            r0[r4] = r1
            r4 = 8
            cz.msebera.android.httpclient.impl.cookie.b0 r1 = new cz.msebera.android.httpclient.impl.cookie.b0
            r1.<init>()
            r0[r4] = r1
            r4 = 9
            cz.msebera.android.httpclient.impl.cookie.c0 r1 = new cz.msebera.android.httpclient.impl.cookie.c0
            r1.<init>()
            r0[r4] = r1
            r3.<init>((boolean) r5, (p163cz.msebera.android.httpclient.cookie.C5678b[]) r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p163cz.msebera.android.httpclient.impl.cookie.C5845f0.<init>(java.lang.String[], boolean):void");
    }

    C5845f0(boolean z, C5678b... bVarArr) {
        super(z, bVarArr);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public List<C5679c> mo33619a(C5696e[] eVarArr, C5682f fVar) throws MalformedCookieException {
        return m18762b(eVarArr, m18763c(fVar));
    }

    /* renamed from: a */
    public void mo33146a(C5679c cVar, C5682f fVar) throws MalformedCookieException {
        C5886a.m18894a(cVar, "Cookie");
        C5886a.m18894a(fVar, "Cookie origin");
        super.mo33146a(cVar, m18763c(fVar));
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo33620a(C5889d dVar, C5679c cVar, int i) {
        String a;
        int[] a2;
        super.mo33620a(dVar, cVar, i);
        if ((cVar instanceof C5677a) && (a = ((C5677a) cVar).mo33119a("port")) != null) {
            dVar.mo33670a("; $Port");
            dVar.mo33670a("=\"");
            if (!a.trim().isEmpty() && (a2 = cVar.mo33123a()) != null) {
                int length = a2.length;
                for (int i2 = 0; i2 < length; i2++) {
                    if (i2 > 0) {
                        dVar.mo33670a(",");
                    }
                    dVar.mo33670a(Integer.toString(a2[i2]));
                }
            }
            dVar.mo33670a("\"");
        }
    }

    /* renamed from: a */
    public C5691d mo33143a() {
        C5889d dVar = new C5889d(40);
        dVar.mo33670a("Cookie2");
        dVar.mo33670a(": ");
        dVar.mo33670a("$Version=");
        dVar.mo33670a(Integer.toString(getVersion()));
        return new C5747q(dVar);
    }

    /* renamed from: b */
    public boolean mo33147b(C5679c cVar, C5682f fVar) {
        C5886a.m18894a(cVar, "Cookie");
        C5886a.m18894a(fVar, "Cookie origin");
        return super.mo33147b(cVar, m18763c(fVar));
    }
}
