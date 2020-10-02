package p163cz.msebera.android.httpclient.p178e0.p180h;

import android.support.p004v4.media.session.PlaybackStateCompat;
import java.io.IOException;
import java.io.InputStream;
import p163cz.msebera.android.httpclient.ConnectionClosedException;
import p163cz.msebera.android.httpclient.p181f0.C5723a;
import p163cz.msebera.android.httpclient.p181f0.C5728f;
import p163cz.msebera.android.httpclient.p187k0.C5886a;

/* renamed from: cz.msebera.android.httpclient.e0.h.g */
/* compiled from: ContentLengthInputStream */
public class C5713g extends InputStream {

    /* renamed from: a */
    private final long f14779a;

    /* renamed from: b */
    private long f14780b = 0;

    /* renamed from: c */
    private boolean f14781c = false;

    /* renamed from: d */
    private C5728f f14782d = null;

    public C5713g(C5728f fVar, long j) {
        C5886a.m18894a(fVar, "Session input buffer");
        this.f14782d = fVar;
        C5886a.m18892a(j, "Content length");
        this.f14779a = j;
    }

    public int available() throws IOException {
        C5728f fVar = this.f14782d;
        if (fVar instanceof C5723a) {
            return Math.min(((C5723a) fVar).length(), (int) (this.f14779a - this.f14780b));
        }
        return 0;
    }

    public void close() throws IOException {
        if (!this.f14781c) {
            try {
                if (this.f14780b < this.f14779a) {
                    do {
                    } while (read(new byte[2048]) >= 0);
                }
            } finally {
                this.f14781c = true;
            }
        }
    }

    public int read() throws IOException {
        if (this.f14781c) {
            throw new IOException("Attempted read from closed stream.");
        } else if (this.f14780b >= this.f14779a) {
            return -1;
        } else {
            int read = this.f14782d.read();
            if (read != -1) {
                this.f14780b++;
            } else if (this.f14780b < this.f14779a) {
                throw new ConnectionClosedException("Premature end of Content-Length delimited message body (expected: " + this.f14779a + "; received: " + this.f14780b);
            }
            return read;
        }
    }

    public long skip(long j) throws IOException {
        int read;
        if (j <= 0) {
            return 0;
        }
        byte[] bArr = new byte[2048];
        long min = Math.min(j, this.f14779a - this.f14780b);
        long j2 = 0;
        while (min > 0 && (read = read(bArr, 0, (int) Math.min(PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH, min))) != -1) {
            long j3 = (long) read;
            j2 += j3;
            min -= j3;
        }
        return j2;
    }

    public int read(byte[] bArr, int i, int i2) throws IOException {
        if (!this.f14781c) {
            long j = this.f14780b;
            long j2 = this.f14779a;
            if (j >= j2) {
                return -1;
            }
            if (((long) i2) + j > j2) {
                i2 = (int) (j2 - j);
            }
            int read = this.f14782d.read(bArr, i, i2);
            if (read != -1 || this.f14780b >= this.f14779a) {
                if (read > 0) {
                    this.f14780b += (long) read;
                }
                return read;
            }
            throw new ConnectionClosedException("Premature end of Content-Length delimited message body (expected: " + this.f14779a + "; received: " + this.f14780b);
        }
        throw new IOException("Attempted read from closed stream.");
    }

    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }
}
