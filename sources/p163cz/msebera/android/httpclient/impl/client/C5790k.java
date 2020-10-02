package p163cz.msebera.android.httpclient.impl.client;

import com.facebook.internal.Utility;
import p163cz.msebera.android.httpclient.C5900p;
import p163cz.msebera.android.httpclient.C5903s;
import p163cz.msebera.android.httpclient.C5905t;
import p163cz.msebera.android.httpclient.C5907v;
import p163cz.msebera.android.httpclient.client.p171q.C5607b;
import p163cz.msebera.android.httpclient.client.p171q.C5608c;
import p163cz.msebera.android.httpclient.client.p171q.C5611e;
import p163cz.msebera.android.httpclient.client.p171q.C5612f;
import p163cz.msebera.android.httpclient.client.p171q.C5613g;
import p163cz.msebera.android.httpclient.client.p171q.C5614h;
import p163cz.msebera.android.httpclient.client.p171q.C5615i;
import p163cz.msebera.android.httpclient.conn.C5624b;
import p163cz.msebera.android.httpclient.p183h0.C5757c;
import p163cz.msebera.android.httpclient.p183h0.C5759e;
import p163cz.msebera.android.httpclient.p183h0.C5760f;
import p163cz.msebera.android.httpclient.p183h0.C5761g;
import p163cz.msebera.android.httpclient.p186j0.C5872b;
import p163cz.msebera.android.httpclient.p186j0.C5874d;
import p163cz.msebera.android.httpclient.p186j0.C5880j;
import p163cz.msebera.android.httpclient.p186j0.C5881k;
import p163cz.msebera.android.httpclient.p186j0.C5882l;
import p163cz.msebera.android.httpclient.p186j0.C5883m;
import p163cz.msebera.android.httpclient.p187k0.C5895j;

@Deprecated
/* renamed from: cz.msebera.android.httpclient.impl.client.k */
/* compiled from: DefaultHttpClient */
public class C5790k extends C5780a {
    public C5790k(C5624b bVar, C5759e eVar) {
        super(bVar, eVar);
    }

    /* renamed from: a */
    public static void m18489a(C5759e eVar) {
        C5760f.m18359a(eVar, (C5907v) C5905t.f15130f);
        C5760f.m18360a(eVar, C5874d.f15105a.name());
        C5757c.m18339a(eVar, true);
        C5757c.m18342c(eVar, Utility.DEFAULT_STREAM_BUFFER_SIZE);
        C5760f.m18362b(eVar, C5895j.m18947a("Apache-HttpClient", "cz.msebera.android.httpclient.client", (Class<?>) C5790k.class));
    }

    /* access modifiers changed from: protected */
    /* renamed from: A */
    public C5759e mo33448A() {
        C5761g gVar = new C5761g();
        m18489a(gVar);
        return gVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: X */
    public C5872b mo33449X() {
        C5872b bVar = new C5872b();
        bVar.mo33631a((C5900p) new C5612f());
        bVar.mo33631a((C5900p) new C5880j());
        bVar.mo33631a((C5900p) new C5882l());
        bVar.mo33631a((C5900p) new C5611e());
        bVar.mo33631a((C5900p) new C5883m());
        bVar.mo33631a((C5900p) new C5881k());
        bVar.mo33631a((C5900p) new C5607b());
        bVar.mo33633a((C5903s) new C5615i());
        bVar.mo33631a((C5900p) new C5608c());
        bVar.mo33631a((C5900p) new C5614h());
        bVar.mo33631a((C5900p) new C5613g());
        return bVar;
    }

    public C5790k() {
        super((C5624b) null, (C5759e) null);
    }
}
