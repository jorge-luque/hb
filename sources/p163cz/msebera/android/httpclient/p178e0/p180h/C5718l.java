package p163cz.msebera.android.httpclient.p178e0.p180h;

import java.io.IOException;
import java.io.InputStream;
import p163cz.msebera.android.httpclient.p181f0.C5723a;
import p163cz.msebera.android.httpclient.p181f0.C5728f;
import p163cz.msebera.android.httpclient.p187k0.C5886a;

/* renamed from: cz.msebera.android.httpclient.e0.h.l */
/* compiled from: IdentityInputStream */
public class C5718l extends InputStream {

    /* renamed from: a */
    private final C5728f f14789a;

    /* renamed from: b */
    private boolean f14790b = false;

    public C5718l(C5728f fVar) {
        C5886a.m18894a(fVar, "Session input buffer");
        this.f14789a = fVar;
    }

    public int available() throws IOException {
        C5728f fVar = this.f14789a;
        if (fVar instanceof C5723a) {
            return ((C5723a) fVar).length();
        }
        return 0;
    }

    public void close() throws IOException {
        this.f14790b = true;
    }

    public int read() throws IOException {
        if (this.f14790b) {
            return -1;
        }
        return this.f14789a.read();
    }

    public int read(byte[] bArr, int i, int i2) throws IOException {
        if (this.f14790b) {
            return -1;
        }
        return this.f14789a.read(bArr, i, i2);
    }
}
