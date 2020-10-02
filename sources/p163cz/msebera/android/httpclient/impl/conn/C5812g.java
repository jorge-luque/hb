package p163cz.msebera.android.httpclient.impl.conn;

import com.ogury.p159cm.OguryChoiceManager;
import java.io.IOException;
import p163cz.msebera.android.httpclient.C5901q;
import p163cz.msebera.android.httpclient.C5902r;
import p163cz.msebera.android.httpclient.HttpException;
import p163cz.msebera.android.httpclient.NoHttpResponseException;
import p163cz.msebera.android.httpclient.ProtocolException;
import p163cz.msebera.android.httpclient.p177d0.C5695b;
import p163cz.msebera.android.httpclient.p178e0.p180h.C5707a;
import p163cz.msebera.android.httpclient.p181f0.C5728f;
import p163cz.msebera.android.httpclient.p182g0.C5751u;
import p163cz.msebera.android.httpclient.p182g0.C5752v;
import p163cz.msebera.android.httpclient.p183h0.C5759e;
import p163cz.msebera.android.httpclient.p186j0.C5875e;
import p163cz.msebera.android.httpclient.p187k0.C5886a;
import p163cz.msebera.android.httpclient.p187k0.C5889d;

/* renamed from: cz.msebera.android.httpclient.impl.conn.g */
/* compiled from: DefaultHttpResponseParser */
public class C5812g extends C5707a<C5901q> {

    /* renamed from: g */
    public C5695b f15006g = new C5695b(C5812g.class);

    /* renamed from: h */
    private final C5902r f15007h;

    /* renamed from: i */
    private final C5889d f15008i;

    @Deprecated
    public C5812g(C5728f fVar, C5751u uVar, C5902r rVar, C5759e eVar) {
        super(fVar, uVar, eVar);
        C5886a.m18894a(rVar, "Response factory");
        this.f15007h = rVar;
        this.f15008i = new C5889d(OguryChoiceManager.TcfV2.Purpose.MEASURE_AD_PERFORMANCE);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo33554a(C5889d dVar, int i) {
        return false;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public C5901q m18601a(C5728f fVar) throws IOException, HttpException {
        int i = 0;
        while (true) {
            this.f15008i.mo33676b();
            int a = fVar.mo33223a(this.f15008i);
            if (a == -1 && i == 0) {
                throw new NoHttpResponseException("The target server failed to respond");
            }
            C5752v vVar = new C5752v(0, this.f15008i.length());
            if (this.f14735d.mo33353b(this.f15008i, vVar)) {
                return this.f15007h.mo33199a(this.f14735d.mo33351a(this.f15008i, vVar), (C5875e) null);
            } else if (a != -1 && !mo33554a(this.f15008i, i)) {
                if (this.f15006g.mo33168a()) {
                    C5695b bVar = this.f15006g;
                    bVar.mo33166a("Garbage in response: " + this.f15008i.toString());
                }
                i++;
            }
        }
        throw new ProtocolException("The server failed to respond with a valid HTTP response");
    }
}
