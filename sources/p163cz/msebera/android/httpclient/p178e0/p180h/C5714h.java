package p163cz.msebera.android.httpclient.p178e0.p180h;

import java.io.IOException;
import java.io.OutputStream;
import p163cz.msebera.android.httpclient.p181f0.C5729g;
import p163cz.msebera.android.httpclient.p187k0.C5886a;

/* renamed from: cz.msebera.android.httpclient.e0.h.h */
/* compiled from: ContentLengthOutputStream */
public class C5714h extends OutputStream {

    /* renamed from: a */
    private final C5729g f14783a;

    /* renamed from: b */
    private final long f14784b;

    /* renamed from: c */
    private long f14785c = 0;

    /* renamed from: d */
    private boolean f14786d = false;

    public C5714h(C5729g gVar, long j) {
        C5886a.m18894a(gVar, "Session output buffer");
        this.f14783a = gVar;
        C5886a.m18892a(j, "Content length");
        this.f14784b = j;
    }

    public void close() throws IOException {
        if (!this.f14786d) {
            this.f14786d = true;
            this.f14783a.flush();
        }
    }

    public void flush() throws IOException {
        this.f14783a.flush();
    }

    public void write(byte[] bArr, int i, int i2) throws IOException {
        if (!this.f14786d) {
            long j = this.f14785c;
            long j2 = this.f14784b;
            if (j < j2) {
                long j3 = j2 - j;
                if (((long) i2) > j3) {
                    i2 = (int) j3;
                }
                this.f14783a.write(bArr, i, i2);
                this.f14785c += (long) i2;
                return;
            }
            return;
        }
        throw new IOException("Attempted write to closed stream.");
    }

    public void write(byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }

    public void write(int i) throws IOException {
        if (this.f14786d) {
            throw new IOException("Attempted write to closed stream.");
        } else if (this.f14785c < this.f14784b) {
            this.f14783a.mo33233a(i);
            this.f14785c++;
        }
    }
}
