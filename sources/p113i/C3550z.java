package p113i;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import javax.annotation.Nullable;
import p113i.p114e0.C3500c;
import p119j.C3579d;
import p119j.C3581f;
import p119j.C3586u;
import p119j.C6589n;

/* renamed from: i.z */
/* compiled from: RequestBody */
public abstract class C3550z {

    /* renamed from: i.z$a */
    /* compiled from: RequestBody */
    class C3551a extends C3550z {

        /* renamed from: a */
        final /* synthetic */ C3541u f9958a;

        /* renamed from: b */
        final /* synthetic */ C3581f f9959b;

        C3551a(C3541u uVar, C3581f fVar) {
            this.f9958a = uVar;
            this.f9959b = fVar;
        }

        public long contentLength() throws IOException {
            return (long) this.f9959b.mo19759f();
        }

        @Nullable
        public C3541u contentType() {
            return this.f9958a;
        }

        public void writeTo(C3579d dVar) throws IOException {
            dVar.mo19694a(this.f9959b);
        }
    }

    /* renamed from: i.z$b */
    /* compiled from: RequestBody */
    class C3552b extends C3550z {

        /* renamed from: a */
        final /* synthetic */ C3541u f9960a;

        /* renamed from: b */
        final /* synthetic */ int f9961b;

        /* renamed from: c */
        final /* synthetic */ byte[] f9962c;

        /* renamed from: d */
        final /* synthetic */ int f9963d;

        C3552b(C3541u uVar, int i, byte[] bArr, int i2) {
            this.f9960a = uVar;
            this.f9961b = i;
            this.f9962c = bArr;
            this.f9963d = i2;
        }

        public long contentLength() {
            return (long) this.f9961b;
        }

        @Nullable
        public C3541u contentType() {
            return this.f9960a;
        }

        public void writeTo(C3579d dVar) throws IOException {
            dVar.write(this.f9962c, this.f9963d, this.f9961b);
        }
    }

    /* renamed from: i.z$c */
    /* compiled from: RequestBody */
    class C3553c extends C3550z {

        /* renamed from: a */
        final /* synthetic */ C3541u f9964a;

        /* renamed from: b */
        final /* synthetic */ File f9965b;

        C3553c(C3541u uVar, File file) {
            this.f9964a = uVar;
            this.f9965b = file;
        }

        public long contentLength() {
            return this.f9965b.length();
        }

        @Nullable
        public C3541u contentType() {
            return this.f9964a;
        }

        public void writeTo(C3579d dVar) throws IOException {
            C3586u uVar = null;
            try {
                uVar = C6589n.m21622c(this.f9965b);
                dVar.mo19692a(uVar);
            } finally {
                C3500c.m11649a((Closeable) uVar);
            }
        }
    }

    public static C3550z create(@Nullable C3541u uVar, String str) {
        Charset charset = C3500c.f9709i;
        if (uVar != null && (charset = uVar.mo19548a()) == null) {
            charset = C3500c.f9709i;
            uVar = C3541u.m11900b(uVar + "; charset=utf-8");
        }
        return create(uVar, str.getBytes(charset));
    }

    public abstract long contentLength() throws IOException;

    @Nullable
    public abstract C3541u contentType();

    public abstract void writeTo(C3579d dVar) throws IOException;

    public static C3550z create(@Nullable C3541u uVar, C3581f fVar) {
        return new C3551a(uVar, fVar);
    }

    public static C3550z create(@Nullable C3541u uVar, byte[] bArr) {
        return create(uVar, bArr, 0, bArr.length);
    }

    public static C3550z create(@Nullable C3541u uVar, byte[] bArr, int i, int i2) {
        if (bArr != null) {
            C3500c.m11648a((long) bArr.length, (long) i, (long) i2);
            return new C3552b(uVar, i2, bArr, i);
        }
        throw new NullPointerException("content == null");
    }

    public static C3550z create(@Nullable C3541u uVar, File file) {
        if (file != null) {
            return new C3553c(uVar, file);
        }
        throw new NullPointerException("file == null");
    }
}
