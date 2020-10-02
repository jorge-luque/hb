package p163cz.msebera.android.httpclient.impl.client;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import p163cz.msebera.android.httpclient.C5691d;
import p163cz.msebera.android.httpclient.C5870j;
import p163cz.msebera.android.httpclient.C5885k;
import p163cz.msebera.android.httpclient.ProtocolException;
import p163cz.msebera.android.httpclient.p166c0.C5573f;

@Deprecated
/* renamed from: cz.msebera.android.httpclient.impl.client.r */
/* compiled from: EntityEnclosingRequestWrapper */
public class C5797r extends C5802v implements C5885k {

    /* renamed from: h */
    private C5870j f14963h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public boolean f14964i;

    /* renamed from: cz.msebera.android.httpclient.impl.client.r$a */
    /* compiled from: EntityEnclosingRequestWrapper */
    class C5798a extends C5573f {
        C5798a(C5870j jVar) {
            super(jVar);
        }

        /* renamed from: a */
        public void mo32899a(OutputStream outputStream) throws IOException {
            boolean unused = C5797r.this.f14964i = true;
            super.mo32899a(outputStream);
        }

        /* renamed from: g */
        public void mo28847g() throws IOException {
            boolean unused = C5797r.this.f14964i = true;
            super.mo28847g();
        }

        public InputStream getContent() throws IOException {
            boolean unused = C5797r.this.f14964i = true;
            return super.getContent();
        }
    }

    public C5797r(C5885k kVar) throws ProtocolException {
        super(kVar);
        mo33515a(kVar.getEntity());
    }

    /* renamed from: e */
    public boolean mo33516e() {
        C5870j jVar = this.f14963h;
        return jVar == null || jVar.mo32900b() || !this.f14964i;
    }

    public boolean expectContinue() {
        C5691d firstHeader = getFirstHeader("Expect");
        return firstHeader != null && "100-continue".equalsIgnoreCase(firstHeader.getValue());
    }

    public C5870j getEntity() {
        return this.f14963h;
    }

    /* renamed from: a */
    public void mo33515a(C5870j jVar) {
        this.f14963h = jVar != null ? new C5798a(jVar) : null;
        this.f14964i = false;
    }
}
