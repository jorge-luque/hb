package p163cz.msebera.android.httpclient.client.p169o;

import p163cz.msebera.android.httpclient.C5691d;
import p163cz.msebera.android.httpclient.C5870j;
import p163cz.msebera.android.httpclient.C5885k;
import p163cz.msebera.android.httpclient.client.p172r.C5616a;

/* renamed from: cz.msebera.android.httpclient.client.o.e */
/* compiled from: HttpEntityEnclosingRequestBase */
public abstract class C5596e extends C5599h implements C5885k {

    /* renamed from: h */
    private C5870j f14578h;

    /* renamed from: a */
    public void mo32960a(C5870j jVar) {
        this.f14578h = jVar;
    }

    public Object clone() throws CloneNotSupportedException {
        C5596e eVar = (C5596e) super.clone();
        C5870j jVar = this.f14578h;
        if (jVar != null) {
            eVar.f14578h = (C5870j) C5616a.m17866a(jVar);
        }
        return eVar;
    }

    public boolean expectContinue() {
        C5691d firstHeader = getFirstHeader("Expect");
        return firstHeader != null && "100-continue".equalsIgnoreCase(firstHeader.getValue());
    }

    public C5870j getEntity() {
        return this.f14578h;
    }
}
