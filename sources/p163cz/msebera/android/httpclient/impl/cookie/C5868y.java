package p163cz.msebera.android.httpclient.impl.cookie;

import com.qumpara.offerwall.sdk.core.QumparaDateUtil;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import p163cz.msebera.android.httpclient.C5691d;
import p163cz.msebera.android.httpclient.cookie.C5677a;
import p163cz.msebera.android.httpclient.cookie.C5678b;
import p163cz.msebera.android.httpclient.cookie.C5679c;
import p163cz.msebera.android.httpclient.cookie.C5682f;
import p163cz.msebera.android.httpclient.cookie.C5683g;
import p163cz.msebera.android.httpclient.cookie.CookieRestrictionViolationException;
import p163cz.msebera.android.httpclient.cookie.MalformedCookieException;
import p163cz.msebera.android.httpclient.p182g0.C5747q;
import p163cz.msebera.android.httpclient.p187k0.C5886a;
import p163cz.msebera.android.httpclient.p187k0.C5889d;

/* renamed from: cz.msebera.android.httpclient.impl.cookie.y */
/* compiled from: RFC2109Spec */
public class C5868y extends C5859p {

    /* renamed from: c */
    static final String[] f15096c = {QumparaDateUtil.PATTERN_RFC1123, "EEE, dd-MMM-yy HH:mm:ss zzz", QumparaDateUtil.PATTERN_ASCTIME};

    /* renamed from: b */
    private final boolean f15097b;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public C5868y(java.lang.String[] r4, boolean r5) {
        /*
            r3 = this;
            r0 = 7
            cz.msebera.android.httpclient.cookie.b[] r0 = new p163cz.msebera.android.httpclient.cookie.C5678b[r0]
            cz.msebera.android.httpclient.impl.cookie.a0 r1 = new cz.msebera.android.httpclient.impl.cookie.a0
            r1.<init>()
            r2 = 0
            r0[r2] = r1
            cz.msebera.android.httpclient.impl.cookie.i r1 = new cz.msebera.android.httpclient.impl.cookie.i
            r1.<init>()
            r2 = 1
            r0[r2] = r1
            cz.msebera.android.httpclient.impl.cookie.x r1 = new cz.msebera.android.httpclient.impl.cookie.x
            r1.<init>()
            r2 = 2
            r0[r2] = r1
            cz.msebera.android.httpclient.impl.cookie.h r1 = new cz.msebera.android.httpclient.impl.cookie.h
            r1.<init>()
            r2 = 3
            r0[r2] = r1
            cz.msebera.android.httpclient.impl.cookie.j r1 = new cz.msebera.android.httpclient.impl.cookie.j
            r1.<init>()
            r2 = 4
            r0[r2] = r1
            cz.msebera.android.httpclient.impl.cookie.e r1 = new cz.msebera.android.httpclient.impl.cookie.e
            r1.<init>()
            r2 = 5
            r0[r2] = r1
            cz.msebera.android.httpclient.impl.cookie.g r1 = new cz.msebera.android.httpclient.impl.cookie.g
            if (r4 == 0) goto L_0x003e
            java.lang.Object r4 = r4.clone()
            java.lang.String[] r4 = (java.lang.String[]) r4
            goto L_0x0040
        L_0x003e:
            java.lang.String[] r4 = f15096c
        L_0x0040:
            r1.<init>(r4)
            r4 = 6
            r0[r4] = r1
            r3.<init>(r0)
            r3.f15097b = r5
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p163cz.msebera.android.httpclient.impl.cookie.C5868y.<init>(java.lang.String[], boolean):void");
    }

    /* renamed from: b */
    private List<C5691d> m18830b(List<C5679c> list) {
        ArrayList arrayList = new ArrayList(list.size());
        for (C5679c next : list) {
            int version = next.getVersion();
            C5889d dVar = new C5889d(40);
            dVar.mo33670a("Cookie: ");
            dVar.mo33670a("$Version=");
            dVar.mo33670a(Integer.toString(version));
            dVar.mo33670a("; ");
            mo33620a(dVar, next, version);
            arrayList.add(new C5747q(dVar));
        }
        return arrayList;
    }

    /* renamed from: c */
    private List<C5691d> m18831c(List<C5679c> list) {
        int i = Integer.MAX_VALUE;
        for (C5679c next : list) {
            if (next.getVersion() < i) {
                i = next.getVersion();
            }
        }
        C5889d dVar = new C5889d(list.size() * 40);
        dVar.mo33670a("Cookie");
        dVar.mo33670a(": ");
        dVar.mo33670a("$Version=");
        dVar.mo33670a(Integer.toString(i));
        for (C5679c a : list) {
            dVar.mo33670a("; ");
            mo33620a(dVar, a, i);
        }
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(new C5747q(dVar));
        return arrayList;
    }

    /* renamed from: a */
    public C5691d mo33143a() {
        return null;
    }

    /* renamed from: a */
    public List<C5679c> mo33144a(C5691d dVar, C5682f fVar) throws MalformedCookieException {
        C5886a.m18894a(dVar, "Header");
        C5886a.m18894a(fVar, "Cookie origin");
        if (dVar.getName().equalsIgnoreCase("Set-Cookie")) {
            return mo33619a(dVar.mo33162b(), fVar);
        }
        throw new MalformedCookieException("Unrecognized cookie header '" + dVar.toString() + "'");
    }

    public int getVersion() {
        return 1;
    }

    public String toString() {
        return "rfc2109";
    }

    public C5868y() {
        this((String[]) null, false);
    }

    protected C5868y(boolean z, C5678b... bVarArr) {
        super(bVarArr);
        this.f15097b = z;
    }

    /* renamed from: a */
    public void mo33146a(C5679c cVar, C5682f fVar) throws MalformedCookieException {
        C5886a.m18894a(cVar, "Cookie");
        String name = cVar.getName();
        if (name.indexOf(32) != -1) {
            throw new CookieRestrictionViolationException("Cookie name may not contain blanks");
        } else if (!name.startsWith("$")) {
            super.mo33146a(cVar, fVar);
        } else {
            throw new CookieRestrictionViolationException("Cookie name may not start with $");
        }
    }

    /* renamed from: a */
    public List<C5691d> mo33145a(List<C5679c> list) {
        C5886a.m18895a(list, "List of cookies");
        if (list.size() > 1) {
            ArrayList arrayList = new ArrayList(list);
            Collections.sort(arrayList, C5683g.f14692a);
            list = arrayList;
        }
        if (this.f15097b) {
            return m18831c(list);
        }
        return m18830b(list);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo33626a(C5889d dVar, String str, String str2, int i) {
        dVar.mo33670a(str);
        dVar.mo33670a("=");
        if (str2 == null) {
            return;
        }
        if (i > 0) {
            dVar.mo33666a('\"');
            dVar.mo33670a(str2);
            dVar.mo33666a('\"');
            return;
        }
        dVar.mo33670a(str2);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo33620a(C5889d dVar, C5679c cVar, int i) {
        mo33626a(dVar, cVar.getName(), cVar.getValue(), i);
        if (cVar.mo33126c() != null && (cVar instanceof C5677a) && ((C5677a) cVar).mo33120c("path")) {
            dVar.mo33670a("; ");
            mo33626a(dVar, "$Path", cVar.mo33126c(), i);
        }
        if (cVar.mo33127d() != null && (cVar instanceof C5677a) && ((C5677a) cVar).mo33120c("domain")) {
            dVar.mo33670a("; ");
            mo33626a(dVar, "$Domain", cVar.mo33127d(), i);
        }
    }
}
