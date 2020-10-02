package p163cz.msebera.android.httpclient.impl.conn;

import p163cz.msebera.android.httpclient.conn.p175s.C5655d;
import p163cz.msebera.android.httpclient.conn.p175s.C5656e;
import p163cz.msebera.android.httpclient.conn.p175s.C5660i;
import p163cz.msebera.android.httpclient.conn.p175s.C5661j;
import p163cz.msebera.android.httpclient.conn.ssl.C5672h;

@Deprecated
/* renamed from: cz.msebera.android.httpclient.impl.conn.o */
/* compiled from: SchemeRegistryFactory */
public final class C5820o {
    /* renamed from: a */
    public static C5660i m18645a() {
        C5660i iVar = new C5660i();
        iVar.mo33093a(new C5656e("http", 80, (C5661j) C5655d.m18013b()));
        iVar.mo33093a(new C5656e("https", 443, (C5661j) C5672h.m18064b()));
        return iVar;
    }
}
