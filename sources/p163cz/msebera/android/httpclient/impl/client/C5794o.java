package p163cz.msebera.android.httpclient.impl.client;

import java.net.URI;
import p163cz.msebera.android.httpclient.C5899o;
import p163cz.msebera.android.httpclient.C5901q;
import p163cz.msebera.android.httpclient.ProtocolException;
import p163cz.msebera.android.httpclient.client.C5583i;
import p163cz.msebera.android.httpclient.client.C5584j;
import p163cz.msebera.android.httpclient.client.p169o.C5597f;
import p163cz.msebera.android.httpclient.client.p169o.C5598g;
import p163cz.msebera.android.httpclient.client.p169o.C5600i;
import p163cz.msebera.android.httpclient.p186j0.C5875e;

@Deprecated
/* renamed from: cz.msebera.android.httpclient.impl.client.o */
/* compiled from: DefaultRedirectStrategyAdaptor */
class C5794o implements C5584j {

    /* renamed from: a */
    private final C5583i f14941a;

    public C5794o(C5583i iVar) {
        this.f14941a = iVar;
    }

    /* renamed from: a */
    public C5600i mo32926a(C5899o oVar, C5901q qVar, C5875e eVar) throws ProtocolException {
        URI a = this.f14941a.mo28911a(qVar, eVar);
        if (oVar.getRequestLine().getMethod().equalsIgnoreCase("HEAD")) {
            return new C5598g(a);
        }
        return new C5597f(a);
    }

    /* renamed from: b */
    public boolean mo32927b(C5899o oVar, C5901q qVar, C5875e eVar) throws ProtocolException {
        return this.f14941a.mo28912b(qVar, eVar);
    }

    /* renamed from: a */
    public C5583i mo33506a() {
        return this.f14941a;
    }
}
