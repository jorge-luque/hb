package p163cz.msebera.android.httpclient.p178e0.p180h;

import java.io.IOException;
import java.io.OutputStream;
import p163cz.msebera.android.httpclient.p181f0.C5729g;
import p163cz.msebera.android.httpclient.p187k0.C5886a;

/* renamed from: cz.msebera.android.httpclient.e0.h.m */
/* compiled from: IdentityOutputStream */
public class C5719m extends OutputStream {

    /* renamed from: a */
    private final C5729g f14791a;

    /* renamed from: b */
    private boolean f14792b = false;

    public C5719m(C5729g gVar) {
        C5886a.m18894a(gVar, "Session output buffer");
        this.f14791a = gVar;
    }

    public void close() throws IOException {
        if (!this.f14792b) {
            this.f14792b = true;
            this.f14791a.flush();
        }
    }

    public void flush() throws IOException {
        this.f14791a.flush();
    }

    public void write(byte[] bArr, int i, int i2) throws IOException {
        if (!this.f14792b) {
            this.f14791a.write(bArr, i, i2);
            return;
        }
        throw new IOException("Attempted write to closed stream.");
    }

    public void write(byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }

    public void write(int i) throws IOException {
        if (!this.f14792b) {
            this.f14791a.mo33233a(i);
            return;
        }
        throw new IOException("Attempted write to closed stream.");
    }
}
