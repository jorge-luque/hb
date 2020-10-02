package p163cz.msebera.android.httpclient.p166c0;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import p163cz.msebera.android.httpclient.p178e0.p180h.C5715i;
import p163cz.msebera.android.httpclient.p187k0.C5886a;
import p163cz.msebera.android.httpclient.p187k0.C5887b;

/* renamed from: cz.msebera.android.httpclient.c0.b */
/* compiled from: BasicHttpEntity */
public class C5569b extends C5568a {

    /* renamed from: d */
    private InputStream f14531d;

    /* renamed from: e */
    private long f14532e = -1;

    /* renamed from: a */
    public void mo32897a(long j) {
        this.f14532e = j;
    }

    /* renamed from: b */
    public boolean mo32900b() {
        return false;
    }

    /* renamed from: f */
    public boolean mo32901f() {
        InputStream inputStream = this.f14531d;
        return (inputStream == null || inputStream == C5715i.f14787a) ? false : true;
    }

    public InputStream getContent() throws IllegalStateException {
        C5887b.m18902a(this.f14531d != null, "Content has not been provided");
        return this.f14531d;
    }

    /* renamed from: h */
    public long mo28849h() {
        return this.f14532e;
    }

    /* renamed from: a */
    public void mo32898a(InputStream inputStream) {
        this.f14531d = inputStream;
    }

    /* renamed from: a */
    public void mo32899a(OutputStream outputStream) throws IOException {
        C5886a.m18894a(outputStream, "Output stream");
        InputStream content = getContent();
        try {
            byte[] bArr = new byte[CodedOutputStream.DEFAULT_BUFFER_SIZE];
            while (true) {
                int read = content.read(bArr);
                if (read != -1) {
                    outputStream.write(bArr, 0, read);
                } else {
                    return;
                }
            }
        } finally {
            content.close();
        }
    }
}
