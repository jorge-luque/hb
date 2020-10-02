package p163cz.msebera.android.httpclient.p166c0;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import p163cz.msebera.android.httpclient.C5691d;
import p163cz.msebera.android.httpclient.C5870j;
import p163cz.msebera.android.httpclient.p187k0.C5886a;

/* renamed from: cz.msebera.android.httpclient.c0.f */
/* compiled from: HttpEntityWrapper */
public class C5573f implements C5870j {

    /* renamed from: a */
    protected C5870j f14540a;

    public C5573f(C5870j jVar) {
        C5886a.m18894a(jVar, "Wrapped entity");
        this.f14540a = jVar;
    }

    /* renamed from: a */
    public C5691d mo32889a() {
        return this.f14540a.mo32889a();
    }

    /* renamed from: b */
    public boolean mo32900b() {
        return this.f14540a.mo32900b();
    }

    /* renamed from: c */
    public C5691d mo32894c() {
        return this.f14540a.mo32894c();
    }

    /* renamed from: e */
    public boolean mo32895e() {
        return this.f14540a.mo32895e();
    }

    /* renamed from: f */
    public boolean mo32901f() {
        return this.f14540a.mo32901f();
    }

    @Deprecated
    /* renamed from: g */
    public void mo28847g() throws IOException {
        this.f14540a.mo28847g();
    }

    public InputStream getContent() throws IOException {
        return this.f14540a.getContent();
    }

    /* renamed from: h */
    public long mo28849h() {
        return this.f14540a.mo28849h();
    }

    /* renamed from: a */
    public void mo32899a(OutputStream outputStream) throws IOException {
        this.f14540a.mo32899a(outputStream);
    }
}
