package p119j;

import android.support.p004v4.media.session.PlaybackStateCompat;
import java.io.IOException;
import java.nio.ByteBuffer;

/* renamed from: j.o */
/* compiled from: RealBufferedSink */
final class C6593o implements C3579d {

    /* renamed from: a */
    public final C3577c f17163a = new C3577c();

    /* renamed from: b */
    public final C3585t f17164b;

    /* renamed from: c */
    boolean f17165c;

    C6593o(C3585t tVar) {
        if (tVar != null) {
            this.f17164b = tVar;
            return;
        }
        throw new NullPointerException("sink == null");
    }

    /* renamed from: C */
    public C3577c mo19678C() {
        return this.f17163a;
    }

    /* renamed from: F */
    public C3579d mo19679F() throws IOException {
        if (!this.f17165c) {
            long size = this.f17163a.size();
            if (size > 0) {
                this.f17164b.mo19670a(this.f17163a, size);
            }
            return this;
        }
        throw new IllegalStateException("closed");
    }

    /* renamed from: J */
    public C3579d mo19682J() throws IOException {
        if (!this.f17165c) {
            long t = this.f17163a.mo19729t();
            if (t > 0) {
                this.f17164b.mo19670a(this.f17163a, t);
            }
            return this;
        }
        throw new IllegalStateException("closed");
    }

    /* renamed from: a */
    public void mo19670a(C3577c cVar, long j) throws IOException {
        if (!this.f17165c) {
            this.f17163a.mo19670a(cVar, j);
            mo19682J();
            return;
        }
        throw new IllegalStateException("closed");
    }

    public void close() throws IOException {
        if (!this.f17165c) {
            try {
                if (this.f17163a.f10032b > 0) {
                    this.f17164b.mo19670a(this.f17163a, this.f17163a.f10032b);
                }
                th = null;
            } catch (Throwable th) {
                th = th;
            }
            try {
                this.f17164b.close();
            } catch (Throwable th2) {
                if (th == null) {
                    th = th2;
                }
            }
            this.f17165c = true;
            if (th != null) {
                C6597w.m21674a(th);
                throw null;
            }
        }
    }

    /* renamed from: e */
    public C3579d mo19708e(String str) throws IOException {
        if (!this.f17165c) {
            this.f17163a.mo19708e(str);
            return mo19682J();
        }
        throw new IllegalStateException("closed");
    }

    public void flush() throws IOException {
        if (!this.f17165c) {
            C3577c cVar = this.f17163a;
            long j = cVar.f10032b;
            if (j > 0) {
                this.f17164b.mo19670a(cVar, j);
            }
            this.f17164b.flush();
            return;
        }
        throw new IllegalStateException("closed");
    }

    /* renamed from: g */
    public C3579d mo19710g(int i) throws IOException {
        if (!this.f17165c) {
            this.f17163a.mo19710g(i);
            mo19682J();
            return this;
        }
        throw new IllegalStateException("closed");
    }

    public boolean isOpen() {
        return !this.f17165c;
    }

    /* renamed from: j */
    public C3579d mo19716j(long j) throws IOException {
        if (!this.f17165c) {
            this.f17163a.mo19716j(j);
            return mo19682J();
        }
        throw new IllegalStateException("closed");
    }

    /* renamed from: m */
    public C3579d mo19719m(long j) throws IOException {
        if (!this.f17165c) {
            this.f17163a.mo19719m(j);
            mo19682J();
            return this;
        }
        throw new IllegalStateException("closed");
    }

    public C3587v timeout() {
        return this.f17164b.timeout();
    }

    public String toString() {
        return "buffer(" + this.f17164b + ")";
    }

    public C3579d write(byte[] bArr) throws IOException {
        if (!this.f17165c) {
            this.f17163a.write(bArr);
            mo19682J();
            return this;
        }
        throw new IllegalStateException("closed");
    }

    public C3579d writeByte(int i) throws IOException {
        if (!this.f17165c) {
            this.f17163a.writeByte(i);
            mo19682J();
            return this;
        }
        throw new IllegalStateException("closed");
    }

    public C3579d writeInt(int i) throws IOException {
        if (!this.f17165c) {
            this.f17163a.writeInt(i);
            return mo19682J();
        }
        throw new IllegalStateException("closed");
    }

    public C3579d writeShort(int i) throws IOException {
        if (!this.f17165c) {
            this.f17163a.writeShort(i);
            mo19682J();
            return this;
        }
        throw new IllegalStateException("closed");
    }

    /* renamed from: a */
    public C3579d mo19694a(C3581f fVar) throws IOException {
        if (!this.f17165c) {
            this.f17163a.mo19694a(fVar);
            mo19682J();
            return this;
        }
        throw new IllegalStateException("closed");
    }

    public C3579d write(byte[] bArr, int i, int i2) throws IOException {
        if (!this.f17165c) {
            this.f17163a.write(bArr, i, i2);
            mo19682J();
            return this;
        }
        throw new IllegalStateException("closed");
    }

    /* renamed from: a */
    public long mo19692a(C3586u uVar) throws IOException {
        if (uVar != null) {
            long j = 0;
            while (true) {
                long read = uVar.read(this.f17163a, PlaybackStateCompat.ACTION_PLAY_FROM_URI);
                if (read == -1) {
                    return j;
                }
                j += read;
                mo19682J();
            }
        } else {
            throw new IllegalArgumentException("source == null");
        }
    }

    public int write(ByteBuffer byteBuffer) throws IOException {
        if (!this.f17165c) {
            int write = this.f17163a.write(byteBuffer);
            mo19682J();
            return write;
        }
        throw new IllegalStateException("closed");
    }
}
