package p163cz.msebera.android.httpclient.p182g0;

import java.io.Serializable;
import p163cz.msebera.android.httpclient.C5907v;
import p163cz.msebera.android.httpclient.C5910y;
import p163cz.msebera.android.httpclient.p187k0.C5886a;
import p163cz.msebera.android.httpclient.p187k0.C5889d;

/* renamed from: cz.msebera.android.httpclient.g0.o */
/* compiled from: BasicStatusLine */
public class C5745o implements C5910y, Cloneable, Serializable {
    private static final long serialVersionUID = -2443303766890459269L;

    /* renamed from: a */
    private final C5907v f14837a;

    /* renamed from: b */
    private final int f14838b;

    /* renamed from: c */
    private final String f14839c;

    public C5745o(C5907v vVar, int i, String str) {
        C5886a.m18894a(vVar, "Version");
        this.f14837a = vVar;
        C5886a.m18891a(i, "Status code");
        this.f14838b = i;
        this.f14839c = str;
    }

    /* renamed from: a */
    public int mo33371a() {
        return this.f14838b;
    }

    /* renamed from: b */
    public String mo33372b() {
        return this.f14839c;
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public C5907v getProtocolVersion() {
        return this.f14837a;
    }

    public String toString() {
        return C5740j.f14825a.mo33346b((C5889d) null, (C5910y) this).toString();
    }
}
