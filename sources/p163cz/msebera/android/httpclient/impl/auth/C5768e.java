package p163cz.msebera.android.httpclient.impl.auth;

import java.nio.charset.Charset;
import p163cz.msebera.android.httpclient.auth.C5549c;
import p163cz.msebera.android.httpclient.auth.C5550d;
import p163cz.msebera.android.httpclient.auth.C5551e;
import p163cz.msebera.android.httpclient.p183h0.C5759e;
import p163cz.msebera.android.httpclient.p186j0.C5875e;

/* renamed from: cz.msebera.android.httpclient.impl.auth.e */
/* compiled from: DigestSchemeFactory */
public class C5768e implements C5550d, C5551e {

    /* renamed from: a */
    private final Charset f14872a;

    public C5768e(Charset charset) {
        this.f14872a = charset;
    }

    /* renamed from: a */
    public C5549c mo32843a(C5759e eVar) {
        return new C5767d();
    }

    /* renamed from: a */
    public C5549c mo32844a(C5875e eVar) {
        return new C5767d(this.f14872a);
    }

    public C5768e() {
        this((Charset) null);
    }
}
