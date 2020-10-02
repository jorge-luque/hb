package p093e.p101c.p102a.p103a.p104i;

import android.util.Base64;
import p093e.p101c.p102a.p103a.C3380d;
import p093e.p101c.p102a.p103a.p104i.C3391c;

/* renamed from: e.c.a.a.i.l */
/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
public abstract class C3406l {

    /* renamed from: e.c.a.a.i.l$a */
    /* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
    public static abstract class C3407a {
        /* renamed from: a */
        public abstract C3407a mo19189a(C3380d dVar);

        /* renamed from: a */
        public abstract C3407a mo19190a(String str);

        /* renamed from: a */
        public abstract C3407a mo19191a(byte[] bArr);

        /* renamed from: a */
        public abstract C3406l mo19192a();
    }

    /* renamed from: d */
    public static C3407a m11350d() {
        C3391c.C3393b bVar = new C3391c.C3393b();
        bVar.mo19189a(C3380d.f9442a);
        return bVar;
    }

    /* renamed from: a */
    public C3406l mo19211a(C3380d dVar) {
        C3407a d = m11350d();
        d.mo19190a(mo19184a());
        d.mo19189a(dVar);
        d.mo19191a(mo19185b());
        return d.mo19192a();
    }

    /* renamed from: a */
    public abstract String mo19184a();

    /* renamed from: b */
    public abstract byte[] mo19185b();

    /* renamed from: c */
    public abstract C3380d mo19186c();

    public final String toString() {
        Object[] objArr = new Object[3];
        objArr[0] = mo19184a();
        objArr[1] = mo19186c();
        objArr[2] = mo19185b() == null ? "" : Base64.encodeToString(mo19185b(), 2);
        return String.format("TransportContext(%s, %s, %s)", objArr);
    }
}
