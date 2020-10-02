package p163cz.msebera.android.httpclient.p166c0;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import p163cz.msebera.android.httpclient.C5870j;
import p163cz.msebera.android.httpclient.p187k0.C5886a;
import p163cz.msebera.android.httpclient.p187k0.C5892g;

/* renamed from: cz.msebera.android.httpclient.c0.c */
/* compiled from: BufferedHttpEntity */
public class C5570c extends C5573f {

    /* renamed from: b */
    private final byte[] f14533b;

    public C5570c(C5870j jVar) throws IOException {
        super(jVar);
        if (!jVar.mo32900b() || jVar.mo28849h() < 0) {
            this.f14533b = C5892g.m18936b(jVar);
        } else {
            this.f14533b = null;
        }
    }

    /* renamed from: a */
    public void mo32899a(OutputStream outputStream) throws IOException {
        C5886a.m18894a(outputStream, "Output stream");
        byte[] bArr = this.f14533b;
        if (bArr != null) {
            outputStream.write(bArr);
        } else {
            super.mo32899a(outputStream);
        }
    }

    /* renamed from: b */
    public boolean mo32900b() {
        return true;
    }

    /* renamed from: e */
    public boolean mo32895e() {
        return this.f14533b == null && super.mo32895e();
    }

    /* renamed from: f */
    public boolean mo32901f() {
        return this.f14533b == null && super.mo32901f();
    }

    public InputStream getContent() throws IOException {
        if (this.f14533b != null) {
            return new ByteArrayInputStream(this.f14533b);
        }
        return super.getContent();
    }

    /* renamed from: h */
    public long mo28849h() {
        byte[] bArr = this.f14533b;
        if (bArr != null) {
            return (long) bArr.length;
        }
        return super.mo28849h();
    }
}
