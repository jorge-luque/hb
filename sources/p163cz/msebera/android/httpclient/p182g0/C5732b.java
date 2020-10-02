package p163cz.msebera.android.httpclient.p182g0;

import java.io.Serializable;
import p163cz.msebera.android.httpclient.C5691d;
import p163cz.msebera.android.httpclient.C5696e;
import p163cz.msebera.android.httpclient.ParseException;
import p163cz.msebera.android.httpclient.p187k0.C5886a;
import p163cz.msebera.android.httpclient.p187k0.C5889d;

/* renamed from: cz.msebera.android.httpclient.g0.b */
/* compiled from: BasicHeader */
public class C5732b implements C5691d, Cloneable, Serializable {
    private static final long serialVersionUID = -5427236326487562174L;

    /* renamed from: a */
    private final String f14797a;

    /* renamed from: b */
    private final String f14798b;

    public C5732b(String str, String str2) {
        C5886a.m18894a(str, "Name");
        this.f14797a = str;
        this.f14798b = str2;
    }

    /* renamed from: b */
    public C5696e[] mo33162b() throws ParseException {
        String str = this.f14798b;
        return str != null ? C5737g.m18249a(str, (C5749s) null) : new C5696e[0];
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public String getName() {
        return this.f14797a;
    }

    public String getValue() {
        return this.f14798b;
    }

    public String toString() {
        return C5740j.f14825a.mo33342a((C5889d) null, (C5691d) this).toString();
    }
}
