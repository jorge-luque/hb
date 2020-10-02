package p163cz.msebera.android.httpclient.p182g0;

import java.io.Serializable;
import p163cz.msebera.android.httpclient.C5907v;
import p163cz.msebera.android.httpclient.C5909x;
import p163cz.msebera.android.httpclient.p187k0.C5886a;
import p163cz.msebera.android.httpclient.p187k0.C5889d;

/* renamed from: cz.msebera.android.httpclient.g0.n */
/* compiled from: BasicRequestLine */
public class C5744n implements C5909x, Cloneable, Serializable {
    private static final long serialVersionUID = 2810581718468737193L;

    /* renamed from: a */
    private final C5907v f14834a;

    /* renamed from: b */
    private final String f14835b;

    /* renamed from: c */
    private final String f14836c;

    public C5744n(String str, String str2, C5907v vVar) {
        C5886a.m18894a(str, "Method");
        this.f14835b = str;
        C5886a.m18894a(str2, "URI");
        this.f14836c = str2;
        C5886a.m18894a(vVar, "Version");
        this.f14834a = vVar;
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public String getMethod() {
        return this.f14835b;
    }

    public C5907v getProtocolVersion() {
        return this.f14834a;
    }

    public String getUri() {
        return this.f14836c;
    }

    public String toString() {
        return C5740j.f14825a.mo33344a((C5889d) null, (C5909x) this).toString();
    }
}
