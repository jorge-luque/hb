package p163cz.msebera.android.httpclient.impl.cookie;

import com.qumpara.offerwall.sdk.core.QumparaDateUtil;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import p163cz.msebera.android.httpclient.C5567c;
import p163cz.msebera.android.httpclient.C5691d;
import p163cz.msebera.android.httpclient.C5696e;
import p163cz.msebera.android.httpclient.C5906u;
import p163cz.msebera.android.httpclient.cookie.C5679c;
import p163cz.msebera.android.httpclient.cookie.C5680d;
import p163cz.msebera.android.httpclient.cookie.C5682f;
import p163cz.msebera.android.httpclient.cookie.C5690m;
import p163cz.msebera.android.httpclient.cookie.MalformedCookieException;
import p163cz.msebera.android.httpclient.p182g0.C5733c;
import p163cz.msebera.android.httpclient.p182g0.C5736f;
import p163cz.msebera.android.httpclient.p182g0.C5747q;
import p163cz.msebera.android.httpclient.p182g0.C5752v;
import p163cz.msebera.android.httpclient.p187k0.C5886a;
import p163cz.msebera.android.httpclient.p187k0.C5889d;

/* renamed from: cz.msebera.android.httpclient.impl.cookie.m */
/* compiled from: BrowserCompatSpec */
public class C5854m extends C5859p {

    /* renamed from: b */
    private static final String[] f15083b = {QumparaDateUtil.PATTERN_RFC1123, "EEE, dd-MMM-yy HH:mm:ss zzz", QumparaDateUtil.PATTERN_ASCTIME, "EEE, dd-MMM-yyyy HH:mm:ss z", "EEE, dd-MMM-yyyy HH-mm-ss z", "EEE, dd MMM yy HH:mm:ss z", "EEE dd-MMM-yyyy HH:mm:ss z", "EEE dd MMM yyyy HH:mm:ss z", "EEE dd-MMM-yyyy HH-mm-ss z", "EEE dd-MMM-yy HH:mm:ss z", "EEE dd MMM yy HH:mm:ss z", "EEE,dd-MMM-yy HH:mm:ss z", "EEE,dd-MMM-yyyy HH:mm:ss z", "EEE, dd-MM-yyyy HH:mm:ss z"};

    /* renamed from: cz.msebera.android.httpclient.impl.cookie.m$a */
    /* compiled from: BrowserCompatSpec */
    class C5855a extends C5850i {
        C5855a() {
        }

        /* renamed from: a */
        public void mo33131a(C5679c cVar, C5682f fVar) throws MalformedCookieException {
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public C5854m(java.lang.String[] r4, p163cz.msebera.android.httpclient.impl.cookie.C5856n.C5857a r5) {
        /*
            r3 = this;
            r0 = 7
            cz.msebera.android.httpclient.cookie.b[] r0 = new p163cz.msebera.android.httpclient.cookie.C5678b[r0]
            cz.msebera.android.httpclient.impl.cookie.o r1 = new cz.msebera.android.httpclient.impl.cookie.o
            r1.<init>()
            r2 = 0
            r0[r2] = r1
            cz.msebera.android.httpclient.impl.cookie.f r1 = new cz.msebera.android.httpclient.impl.cookie.f
            r1.<init>()
            r2 = 1
            r0[r2] = r1
            cz.msebera.android.httpclient.impl.cookie.n$a r1 = p163cz.msebera.android.httpclient.impl.cookie.C5856n.C5857a.SECURITYLEVEL_IE_MEDIUM
            if (r5 != r1) goto L_0x001d
            cz.msebera.android.httpclient.impl.cookie.m$a r5 = new cz.msebera.android.httpclient.impl.cookie.m$a
            r5.<init>()
            goto L_0x0022
        L_0x001d:
            cz.msebera.android.httpclient.impl.cookie.i r5 = new cz.msebera.android.httpclient.impl.cookie.i
            r5.<init>()
        L_0x0022:
            r1 = 2
            r0[r1] = r5
            r5 = 3
            cz.msebera.android.httpclient.impl.cookie.h r1 = new cz.msebera.android.httpclient.impl.cookie.h
            r1.<init>()
            r0[r5] = r1
            r5 = 4
            cz.msebera.android.httpclient.impl.cookie.j r1 = new cz.msebera.android.httpclient.impl.cookie.j
            r1.<init>()
            r0[r5] = r1
            r5 = 5
            cz.msebera.android.httpclient.impl.cookie.e r1 = new cz.msebera.android.httpclient.impl.cookie.e
            r1.<init>()
            r0[r5] = r1
            r5 = 6
            cz.msebera.android.httpclient.impl.cookie.g r1 = new cz.msebera.android.httpclient.impl.cookie.g
            if (r4 == 0) goto L_0x0049
            java.lang.Object r4 = r4.clone()
            java.lang.String[] r4 = (java.lang.String[]) r4
            goto L_0x004b
        L_0x0049:
            java.lang.String[] r4 = f15083b
        L_0x004b:
            r1.<init>(r4)
            r0[r5] = r1
            r3.<init>(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p163cz.msebera.android.httpclient.impl.cookie.C5854m.<init>(java.lang.String[], cz.msebera.android.httpclient.impl.cookie.n$a):void");
    }

    /* renamed from: b */
    private static boolean m18790b(String str) {
        return str != null && str.startsWith("\"") && str.endsWith("\"");
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
            if (!z && z2) {
                return mo33619a(b, fVar);
            }
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
            C5696e a = uVar.mo33624a(dVar2, vVar);
            String name = a.getName();
            String value2 = a.getValue();
            if (name == null || name.isEmpty()) {
                throw new MalformedCookieException("Cookie name may not be empty");
            }
            C5840d dVar3 = new C5840d(name, value2);
            dVar3.mo33159b(C5859p.m18800b(fVar));
            dVar3.mo33161f(C5859p.m18799a(fVar));
            C5906u[] parameters = a.getParameters();
            for (int length = parameters.length - 1; length >= 0; length--) {
                C5906u uVar2 = parameters[length];
                String lowerCase = uVar2.getName().toLowerCase(Locale.ROOT);
                dVar3.mo33616a(lowerCase, uVar2.getValue());
                C5680d a2 = mo33613a(lowerCase);
                if (a2 != null) {
                    a2.mo33132a((C5690m) dVar3, uVar2.getValue());
                }
            }
            if (z) {
                dVar3.mo33156a(0);
            }
            return Collections.singletonList(dVar3);
        }
        throw new MalformedCookieException("Unrecognized cookie header '" + dVar.toString() + "'");
    }

    public int getVersion() {
        return 0;
    }

    public String toString() {
        return "compatibility";
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
            String name = cVar.getName();
            String value = cVar.getValue();
            if (cVar.getVersion() <= 0 || m18790b(value)) {
                dVar.mo33670a(name);
                dVar.mo33670a("=");
                if (value != null) {
                    dVar.mo33670a(value);
                }
            } else {
                C5736f.f14810a.mo33322a(dVar, (C5696e) new C5733c(name, value), false);
            }
        }
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(new C5747q(dVar));
        return arrayList;
    }
}
