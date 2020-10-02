package p163cz.msebera.android.httpclient.p186j0;

import p163cz.msebera.android.httpclient.p187k0.C5886a;

@Deprecated
/* renamed from: cz.msebera.android.httpclient.j0.c */
/* compiled from: DefaultedHttpContext */
public final class C5873c implements C5875e {

    /* renamed from: a */
    private final C5875e f15103a;

    /* renamed from: b */
    private final C5875e f15104b;

    public C5873c(C5875e eVar, C5875e eVar2) {
        C5886a.m18894a(eVar, "HTTP context");
        this.f15103a = eVar;
        this.f15104b = eVar2;
    }

    /* renamed from: a */
    public Object mo33533a(String str) {
        Object a = this.f15103a.mo33533a(str);
        return a == null ? this.f15104b.mo33533a(str) : a;
    }

    public String toString() {
        return "[local: " + this.f15103a + "defaults: " + this.f15104b + "]";
    }

    /* renamed from: a */
    public void mo33535a(String str, Object obj) {
        this.f15103a.mo33535a(str, obj);
    }
}
