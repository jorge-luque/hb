package p163cz.msebera.android.httpclient.p178e0.p180h;

import java.io.IOException;
import java.io.InputStream;
import p163cz.msebera.android.httpclient.ConnectionClosedException;
import p163cz.msebera.android.httpclient.HttpException;
import p163cz.msebera.android.httpclient.MalformedChunkCodingException;
import p163cz.msebera.android.httpclient.TruncatedChunkException;
import p163cz.msebera.android.httpclient.p165b0.C5565b;
import p163cz.msebera.android.httpclient.p181f0.C5723a;
import p163cz.msebera.android.httpclient.p181f0.C5728f;
import p163cz.msebera.android.httpclient.p182g0.C5751u;
import p163cz.msebera.android.httpclient.p187k0.C5886a;
import p163cz.msebera.android.httpclient.p187k0.C5889d;

/* renamed from: cz.msebera.android.httpclient.e0.h.e */
/* compiled from: ChunkedInputStream */
public class C5711e extends InputStream {

    /* renamed from: a */
    private final C5728f f14766a;

    /* renamed from: b */
    private final C5889d f14767b;

    /* renamed from: c */
    private final C5565b f14768c;

    /* renamed from: d */
    private int f14769d;

    /* renamed from: e */
    private int f14770e;

    /* renamed from: f */
    private int f14771f;

    /* renamed from: g */
    private boolean f14772g;

    /* renamed from: h */
    private boolean f14773h;

    public C5711e(C5728f fVar, C5565b bVar) {
        this.f14772g = false;
        this.f14773h = false;
        C5886a.m18894a(fVar, "Session input buffer");
        this.f14766a = fVar;
        this.f14771f = 0;
        this.f14767b = new C5889d(16);
        this.f14768c = bVar == null ? C5565b.f14523c : bVar;
        this.f14769d = 1;
    }

    /* renamed from: d */
    private int m18205d() throws IOException {
        int i = this.f14769d;
        if (i != 1) {
            if (i == 3) {
                this.f14767b.mo33676b();
                if (this.f14766a.mo33223a(this.f14767b) == -1) {
                    throw new MalformedChunkCodingException("CRLF expected at end of chunk");
                } else if (this.f14767b.mo33677c()) {
                    this.f14769d = 1;
                } else {
                    throw new MalformedChunkCodingException("Unexpected content at the end of chunk");
                }
            } else {
                throw new IllegalStateException("Inconsistent codec state");
            }
        }
        this.f14767b.mo33676b();
        if (this.f14766a.mo33223a(this.f14767b) != -1) {
            int b = this.f14767b.mo33674b(59);
            if (b < 0) {
                b = this.f14767b.length();
            }
            try {
                return Integer.parseInt(this.f14767b.mo33675b(0, b), 16);
            } catch (NumberFormatException unused) {
                throw new MalformedChunkCodingException("Bad chunk header");
            }
        } else {
            throw new ConnectionClosedException("Premature end of chunk coded message body: closing chunk expected");
        }
    }

    /* renamed from: t */
    private void m18206t() throws IOException {
        if (this.f14769d != Integer.MAX_VALUE) {
            try {
                int d = m18205d();
                this.f14770e = d;
                if (d >= 0) {
                    this.f14769d = 2;
                    this.f14771f = 0;
                    if (d == 0) {
                        this.f14772g = true;
                        m18207u();
                        return;
                    }
                    return;
                }
                throw new MalformedChunkCodingException("Negative chunk size");
            } catch (MalformedChunkCodingException e) {
                this.f14769d = Integer.MAX_VALUE;
                throw e;
            }
        } else {
            throw new MalformedChunkCodingException("Corrupt data stream");
        }
    }

    /* renamed from: u */
    private void m18207u() throws IOException {
        try {
            C5707a.m18178a(this.f14766a, this.f14768c.mo32880a(), this.f14768c.mo32881b(), (C5751u) null);
        } catch (HttpException e) {
            MalformedChunkCodingException malformedChunkCodingException = new MalformedChunkCodingException("Invalid footer: " + e.getMessage());
            malformedChunkCodingException.initCause(e);
            throw malformedChunkCodingException;
        }
    }

    public int available() throws IOException {
        C5728f fVar = this.f14766a;
        if (fVar instanceof C5723a) {
            return Math.min(((C5723a) fVar).length(), this.f14770e - this.f14771f);
        }
        return 0;
    }

    public void close() throws IOException {
        if (!this.f14773h) {
            try {
                if (!this.f14772g && this.f14769d != Integer.MAX_VALUE) {
                    do {
                    } while (read(new byte[2048]) >= 0);
                }
            } finally {
                this.f14772g = true;
                this.f14773h = true;
            }
        }
    }

    public int read() throws IOException {
        if (this.f14773h) {
            throw new IOException("Attempted read from closed stream.");
        } else if (this.f14772g) {
            return -1;
        } else {
            if (this.f14769d != 2) {
                m18206t();
                if (this.f14772g) {
                    return -1;
                }
            }
            int read = this.f14766a.read();
            if (read != -1) {
                int i = this.f14771f + 1;
                this.f14771f = i;
                if (i >= this.f14770e) {
                    this.f14769d = 3;
                }
            }
            return read;
        }
    }

    public C5711e(C5728f fVar) {
        this(fVar, (C5565b) null);
    }

    public int read(byte[] bArr, int i, int i2) throws IOException {
        if (this.f14773h) {
            throw new IOException("Attempted read from closed stream.");
        } else if (this.f14772g) {
            return -1;
        } else {
            if (this.f14769d != 2) {
                m18206t();
                if (this.f14772g) {
                    return -1;
                }
            }
            int read = this.f14766a.read(bArr, i, Math.min(i2, this.f14770e - this.f14771f));
            if (read != -1) {
                int i3 = this.f14771f + read;
                this.f14771f = i3;
                if (i3 >= this.f14770e) {
                    this.f14769d = 3;
                }
                return read;
            }
            this.f14772g = true;
            throw new TruncatedChunkException("Truncated chunk ( expected size: " + this.f14770e + "; actual size: " + this.f14771f + ")");
        }
    }

    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }
}
