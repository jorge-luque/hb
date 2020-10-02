package p163cz.msebera.android.httpclient.conn;

import java.io.IOException;
import java.io.InputStream;
import p163cz.msebera.android.httpclient.p187k0.C5886a;

/* renamed from: cz.msebera.android.httpclient.conn.i */
/* compiled from: EofSensorInputStream */
public class C5631i extends InputStream implements C5629g {

    /* renamed from: a */
    protected InputStream f14627a;

    /* renamed from: b */
    private boolean f14628b = false;

    /* renamed from: c */
    private final C5632j f14629c;

    public C5631i(InputStream inputStream, C5632j jVar) {
        C5886a.m18894a(inputStream, "Wrapped stream");
        this.f14627a = inputStream;
        this.f14629c = jVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo33021a(int i) throws IOException {
        InputStream inputStream = this.f14627a;
        if (inputStream != null && i < 0) {
            boolean z = true;
            try {
                if (this.f14629c != null) {
                    z = this.f14629c.mo33003a(inputStream);
                }
                if (z) {
                    this.f14627a.close();
                }
            } finally {
                this.f14627a = null;
            }
        }
    }

    public int available() throws IOException {
        if (!mo33029w()) {
            return 0;
        }
        try {
            return this.f14627a.available();
        } catch (IOException e) {
            mo33027u();
            throw e;
        }
    }

    public void close() throws IOException {
        this.f14628b = true;
        mo33028v();
    }

    /* renamed from: d */
    public void mo33006d() throws IOException {
        close();
    }

    public int read() throws IOException {
        if (!mo33029w()) {
            return -1;
        }
        try {
            int read = this.f14627a.read();
            mo33021a(read);
            return read;
        } catch (IOException e) {
            mo33027u();
            throw e;
        }
    }

    /* renamed from: t */
    public void mo33008t() throws IOException {
        this.f14628b = true;
        mo33027u();
    }

    /* access modifiers changed from: protected */
    /* renamed from: u */
    public void mo33027u() throws IOException {
        InputStream inputStream = this.f14627a;
        if (inputStream != null) {
            boolean z = true;
            try {
                if (this.f14629c != null) {
                    z = this.f14629c.mo33005c(inputStream);
                }
                if (z) {
                    this.f14627a.close();
                }
            } finally {
                this.f14627a = null;
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: v */
    public void mo33028v() throws IOException {
        InputStream inputStream = this.f14627a;
        if (inputStream != null) {
            boolean z = true;
            try {
                if (this.f14629c != null) {
                    z = this.f14629c.mo33004b(inputStream);
                }
                if (z) {
                    this.f14627a.close();
                }
            } finally {
                this.f14627a = null;
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: w */
    public boolean mo33029w() throws IOException {
        if (!this.f14628b) {
            return this.f14627a != null;
        }
        throw new IOException("Attempted read on closed stream.");
    }

    public int read(byte[] bArr, int i, int i2) throws IOException {
        if (!mo33029w()) {
            return -1;
        }
        try {
            int read = this.f14627a.read(bArr, i, i2);
            mo33021a(read);
            return read;
        } catch (IOException e) {
            mo33027u();
            throw e;
        }
    }

    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }
}
