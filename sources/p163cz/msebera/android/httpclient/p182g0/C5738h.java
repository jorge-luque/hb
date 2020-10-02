package p163cz.msebera.android.httpclient.p182g0;

import p163cz.msebera.android.httpclient.C5899o;
import p163cz.msebera.android.httpclient.C5905t;
import p163cz.msebera.android.httpclient.C5907v;
import p163cz.msebera.android.httpclient.C5909x;
import p163cz.msebera.android.httpclient.p187k0.C5886a;

/* renamed from: cz.msebera.android.httpclient.g0.h */
/* compiled from: BasicHttpRequest */
public class C5738h extends C5731a implements C5899o {

    /* renamed from: c */
    private final String f14815c;

    /* renamed from: d */
    private final String f14816d;

    /* renamed from: e */
    private C5909x f14817e;

    public C5738h(String str, String str2, C5907v vVar) {
        this(new C5744n(str, str2, vVar));
    }

    public C5907v getProtocolVersion() {
        return getRequestLine().getProtocolVersion();
    }

    public C5909x getRequestLine() {
        if (this.f14817e == null) {
            this.f14817e = new C5744n(this.f14815c, this.f14816d, C5905t.f15130f);
        }
        return this.f14817e;
    }

    public String toString() {
        return this.f14815c + ' ' + this.f14816d + ' ' + this.f14795a;
    }

    public C5738h(C5909x xVar) {
        C5886a.m18894a(xVar, "Request line");
        this.f14817e = xVar;
        this.f14815c = xVar.getMethod();
        this.f14816d = xVar.getUri();
    }
}
