package p163cz.msebera.android.httpclient.conn.p175s;

import java.util.Locale;
import p163cz.msebera.android.httpclient.p187k0.C5886a;
import p163cz.msebera.android.httpclient.p187k0.C5893h;

@Deprecated
/* renamed from: cz.msebera.android.httpclient.conn.s.e */
/* compiled from: Scheme */
public final class C5656e {

    /* renamed from: a */
    private final String f14654a;

    /* renamed from: b */
    private final C5661j f14655b;

    /* renamed from: c */
    private final int f14656c;

    /* renamed from: d */
    private final boolean f14657d;

    /* renamed from: e */
    private String f14658e;

    public C5656e(String str, int i, C5661j jVar) {
        C5886a.m18894a(str, "Scheme name");
        C5886a.m18896a(i > 0 && i <= 65535, "Port is invalid");
        C5886a.m18894a(jVar, "Socket factory");
        this.f14654a = str.toLowerCase(Locale.ENGLISH);
        this.f14656c = i;
        if (jVar instanceof C5657f) {
            this.f14657d = true;
            this.f14655b = jVar;
        } else if (jVar instanceof C5653b) {
            this.f14657d = true;
            this.f14655b = new C5658g((C5653b) jVar);
        } else {
            this.f14657d = false;
            this.f14655b = jVar;
        }
    }

    /* renamed from: a */
    public final int mo33084a() {
        return this.f14656c;
    }

    /* renamed from: b */
    public final String mo33086b() {
        return this.f14654a;
    }

    /* renamed from: c */
    public final C5661j mo33087c() {
        return this.f14655b;
    }

    /* renamed from: d */
    public final boolean mo33088d() {
        return this.f14657d;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C5656e)) {
            return false;
        }
        C5656e eVar = (C5656e) obj;
        if (this.f14654a.equals(eVar.f14654a) && this.f14656c == eVar.f14656c && this.f14657d == eVar.f14657d) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return C5893h.m18939a(C5893h.m18938a(C5893h.m18937a(17, this.f14656c), (Object) this.f14654a), this.f14657d);
    }

    public final String toString() {
        if (this.f14658e == null) {
            this.f14658e = this.f14654a + ':' + Integer.toString(this.f14656c);
        }
        return this.f14658e;
    }

    /* renamed from: a */
    public final int mo33085a(int i) {
        return i <= 0 ? this.f14656c : i;
    }

    @Deprecated
    public C5656e(String str, C5663l lVar, int i) {
        C5886a.m18894a(str, "Scheme name");
        C5886a.m18894a(lVar, "Socket factory");
        C5886a.m18896a(i > 0 && i <= 65535, "Port is invalid");
        this.f14654a = str.toLowerCase(Locale.ENGLISH);
        if (lVar instanceof C5654c) {
            this.f14655b = new C5659h((C5654c) lVar);
            this.f14657d = true;
        } else {
            this.f14655b = new C5662k(lVar);
            this.f14657d = false;
        }
        this.f14656c = i;
    }
}
