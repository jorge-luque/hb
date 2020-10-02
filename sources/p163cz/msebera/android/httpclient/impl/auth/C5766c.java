package p163cz.msebera.android.httpclient.impl.auth;

import java.nio.charset.Charset;
import p163cz.msebera.android.httpclient.auth.C5549c;
import p163cz.msebera.android.httpclient.auth.C5550d;
import p163cz.msebera.android.httpclient.auth.C5551e;
import p163cz.msebera.android.httpclient.p183h0.C5759e;
import p163cz.msebera.android.httpclient.p186j0.C5875e;

/* renamed from: cz.msebera.android.httpclient.impl.auth.c */
/* compiled from: BasicSchemeFactory */
public class C5766c implements C5550d, C5551e {

    /* renamed from: a */
    private final Charset f14864a;

    public C5766c(Charset charset) {
        this.f14864a = charset;
    }

    /* renamed from: a */
    public C5549c mo32843a(C5759e eVar) {
        return new C5765b();
    }

    /* renamed from: a */
    public C5549c mo32844a(C5875e eVar) {
        return new C5765b(this.f14864a);
    }

    public C5766c() {
        this((Charset) null);
    }
}
