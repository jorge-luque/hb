package p163cz.msebera.android.httpclient.impl.auth;

import java.io.IOException;
import java.io.OutputStream;
import java.security.MessageDigest;

/* renamed from: cz.msebera.android.httpclient.impl.auth.g */
/* compiled from: HttpEntityDigester */
class C5771g extends OutputStream {

    /* renamed from: a */
    private final MessageDigest f14875a;

    /* renamed from: b */
    private boolean f14876b;

    /* renamed from: c */
    private byte[] f14877c;

    C5771g(MessageDigest messageDigest) {
        this.f14875a = messageDigest;
        messageDigest.reset();
    }

    public void close() throws IOException {
        if (!this.f14876b) {
            this.f14876b = true;
            this.f14877c = this.f14875a.digest();
            super.close();
        }
    }

    /* renamed from: d */
    public byte[] mo33440d() {
        return this.f14877c;
    }

    public void write(int i) throws IOException {
        if (!this.f14876b) {
            this.f14875a.update((byte) i);
            return;
        }
        throw new IOException("Stream has been already closed");
    }

    public void write(byte[] bArr, int i, int i2) throws IOException {
        if (!this.f14876b) {
            this.f14875a.update(bArr, i, i2);
            return;
        }
        throw new IOException("Stream has been already closed");
    }
}
