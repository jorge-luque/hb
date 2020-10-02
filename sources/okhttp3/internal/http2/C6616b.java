package okhttp3.internal.http2;

import p113i.C3537r;
import p113i.p114e0.C3500c;
import p119j.C3581f;

/* renamed from: okhttp3.internal.http2.b */
/* compiled from: Header */
public final class C6616b {

    /* renamed from: d */
    public static final C3581f f17328d = C3581f.m12177d(":");

    /* renamed from: e */
    public static final C3581f f17329e = C3581f.m12177d(":status");

    /* renamed from: f */
    public static final C3581f f17330f = C3581f.m12177d(":method");

    /* renamed from: g */
    public static final C3581f f17331g = C3581f.m12177d(":path");

    /* renamed from: h */
    public static final C3581f f17332h = C3581f.m12177d(":scheme");

    /* renamed from: i */
    public static final C3581f f17333i = C3581f.m12177d(":authority");

    /* renamed from: a */
    public final C3581f f17334a;

    /* renamed from: b */
    public final C3581f f17335b;

    /* renamed from: c */
    final int f17336c;

    /* renamed from: okhttp3.internal.http2.b$a */
    /* compiled from: Header */
    interface C6617a {
        /* renamed from: a */
        void mo35674a(C3537r rVar);
    }

    public C6616b(String str, String str2) {
        this(C3581f.m12177d(str), C3581f.m12177d(str2));
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C6616b)) {
            return false;
        }
        C6616b bVar = (C6616b) obj;
        if (!this.f17334a.equals(bVar.f17334a) || !this.f17335b.equals(bVar.f17335b)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return ((527 + this.f17334a.hashCode()) * 31) + this.f17335b.hashCode();
    }

    public String toString() {
        return C3500c.m11639a("%s: %s", this.f17334a.mo19763i(), this.f17335b.mo19763i());
    }

    public C6616b(C3581f fVar, String str) {
        this(fVar, C3581f.m12177d(str));
    }

    public C6616b(C3581f fVar, C3581f fVar2) {
        this.f17334a = fVar;
        this.f17335b = fVar2;
        this.f17336c = fVar.mo19759f() + 32 + fVar2.mo19759f();
    }
}
