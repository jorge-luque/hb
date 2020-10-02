package p163cz.msebera.android.httpclient.p178e0.p180h;

import com.ogury.p159cm.OguryChoiceManager;
import java.io.IOException;
import p163cz.msebera.android.httpclient.C5730g;
import p163cz.msebera.android.httpclient.C5898n;
import p163cz.msebera.android.httpclient.HttpException;
import p163cz.msebera.android.httpclient.p181f0.C5726d;
import p163cz.msebera.android.httpclient.p181f0.C5729g;
import p163cz.msebera.android.httpclient.p182g0.C5740j;
import p163cz.msebera.android.httpclient.p182g0.C5750t;
import p163cz.msebera.android.httpclient.p183h0.C5759e;
import p163cz.msebera.android.httpclient.p187k0.C5886a;
import p163cz.msebera.android.httpclient.p187k0.C5889d;

/* renamed from: cz.msebera.android.httpclient.e0.h.b */
/* compiled from: AbstractMessageWriter */
public abstract class C5708b<T extends C5898n> implements C5726d<T> {

    /* renamed from: a */
    protected final C5729g f14738a;

    /* renamed from: b */
    protected final C5889d f14739b = new C5889d(OguryChoiceManager.TcfV2.Purpose.MEASURE_AD_PERFORMANCE);

    /* renamed from: c */
    protected final C5750t f14740c;

    @Deprecated
    public C5708b(C5729g gVar, C5750t tVar, C5759e eVar) {
        C5886a.m18894a(gVar, "Session input buffer");
        this.f14738a = gVar;
        this.f14740c = tVar == null ? C5740j.f14825a : tVar;
    }

    /* renamed from: a */
    public void mo33221a(T t) throws IOException, HttpException {
        C5886a.m18894a(t, "HTTP message");
        mo33222b(t);
        C5730g headerIterator = t.headerIterator();
        while (headerIterator.hasNext()) {
            this.f14738a.mo33234a(this.f14740c.mo33342a(this.f14739b, headerIterator.nextHeader()));
        }
        this.f14739b.mo33676b();
        this.f14738a.mo33234a(this.f14739b);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public abstract void mo33222b(T t) throws IOException;
}
