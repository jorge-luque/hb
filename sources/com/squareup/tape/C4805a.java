package com.squareup.tape;

import com.squareup.tape.C4809c;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;

/* renamed from: com.squareup.tape.a */
/* compiled from: FileObjectQueue */
public class C4805a<T> implements C4809c<T> {

    /* renamed from: a */
    private final C4811d f12881a;

    /* renamed from: b */
    private final C4807b f12882b = new C4807b();

    /* renamed from: c */
    private final File f12883c;

    /* renamed from: d */
    private final C4806a<T> f12884d;

    /* renamed from: e */
    private C4809c.C4810a<T> f12885e;

    /* renamed from: com.squareup.tape.a$a */
    /* compiled from: FileObjectQueue */
    public interface C4806a<T> {
        T from(byte[] bArr) throws IOException;

        void toStream(T t, OutputStream outputStream) throws IOException;
    }

    /* renamed from: com.squareup.tape.a$b */
    /* compiled from: FileObjectQueue */
    private static class C4807b extends ByteArrayOutputStream {
        /* renamed from: d */
        public byte[] mo30529d() {
            return this.buf;
        }
    }

    public C4805a(File file, C4806a<T> aVar) throws IOException {
        this.f12883c = file;
        this.f12884d = aVar;
        this.f12881a = new C4811d(file);
    }

    public final void add(T t) {
        try {
            this.f12882b.reset();
            this.f12884d.toStream(t, this.f12882b);
            this.f12881a.mo30534a(this.f12882b.mo30529d(), 0, this.f12882b.size());
            if (this.f12885e != null) {
                this.f12885e.mo30531a(this, t);
            }
        } catch (IOException e) {
            throw new FileException("Failed to add entry.", e, this.f12883c);
        }
    }

    public T peek() {
        try {
            byte[] c = this.f12881a.mo30536c();
            if (c == null) {
                return null;
            }
            return this.f12884d.from(c);
        } catch (IOException e) {
            throw new FileException("Failed to peek.", e, this.f12883c);
        }
    }

    public final void remove() {
        try {
            this.f12881a.mo30537d();
            if (this.f12885e != null) {
                this.f12885e.mo30530a(this);
            }
        } catch (IOException e) {
            throw new FileException("Failed to remove.", e, this.f12883c);
        }
    }
}
