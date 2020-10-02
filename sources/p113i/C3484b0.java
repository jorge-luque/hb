package p113i;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import javax.annotation.Nullable;
import p113i.p114e0.C3500c;
import p119j.C3577c;
import p119j.C3580e;
import p119j.C3581f;

/* renamed from: i.b0 */
/* compiled from: ResponseBody */
public abstract class C3484b0 implements Closeable {
    @Nullable
    private Reader reader;

    /* renamed from: i.b0$a */
    /* compiled from: ResponseBody */
    class C3485a extends C3484b0 {

        /* renamed from: a */
        final /* synthetic */ C3541u f9634a;

        /* renamed from: b */
        final /* synthetic */ long f9635b;

        /* renamed from: c */
        final /* synthetic */ C3580e f9636c;

        C3485a(C3541u uVar, long j, C3580e eVar) {
            this.f9634a = uVar;
            this.f9635b = j;
            this.f9636c = eVar;
        }

        public long contentLength() {
            return this.f9635b;
        }

        @Nullable
        public C3541u contentType() {
            return this.f9634a;
        }

        public C3580e source() {
            return this.f9636c;
        }
    }

    /* renamed from: i.b0$b */
    /* compiled from: ResponseBody */
    static final class C3486b extends Reader {

        /* renamed from: a */
        private final C3580e f9637a;

        /* renamed from: b */
        private final Charset f9638b;

        /* renamed from: c */
        private boolean f9639c;
        @Nullable

        /* renamed from: d */
        private Reader f9640d;

        C3486b(C3580e eVar, Charset charset) {
            this.f9637a = eVar;
            this.f9638b = charset;
        }

        public void close() throws IOException {
            this.f9639c = true;
            Reader reader = this.f9640d;
            if (reader != null) {
                reader.close();
            } else {
                this.f9637a.close();
            }
        }

        public int read(char[] cArr, int i, int i2) throws IOException {
            if (!this.f9639c) {
                Reader reader = this.f9640d;
                if (reader == null) {
                    InputStreamReader inputStreamReader = new InputStreamReader(this.f9637a.mo19688V(), C3500c.m11642a(this.f9637a, this.f9638b));
                    this.f9640d = inputStreamReader;
                    reader = inputStreamReader;
                }
                return reader.read(cArr, i, i2);
            }
            throw new IOException("Stream closed");
        }
    }

    private Charset charset() {
        C3541u contentType = contentType();
        return contentType != null ? contentType.mo19549a(C3500c.f9709i) : C3500c.f9709i;
    }

    public static C3484b0 create(@Nullable C3541u uVar, String str) {
        Charset charset = C3500c.f9709i;
        if (uVar != null && (charset = uVar.mo19548a()) == null) {
            charset = C3500c.f9709i;
            uVar = C3541u.m11900b(uVar + "; charset=utf-8");
        }
        C3577c cVar = new C3577c();
        cVar.mo19697a(str, charset);
        return create(uVar, cVar.size(), cVar);
    }

    public final InputStream byteStream() {
        return source().mo19688V();
    }

    /* JADX INFO: finally extract failed */
    public final byte[] bytes() throws IOException {
        long contentLength = contentLength();
        if (contentLength <= 2147483647L) {
            C3580e source = source();
            try {
                byte[] G = source.mo19680G();
                C3500c.m11649a((Closeable) source);
                if (contentLength == -1 || contentLength == ((long) G.length)) {
                    return G;
                }
                throw new IOException("Content-Length (" + contentLength + ") and stream length (" + G.length + ") disagree");
            } catch (Throwable th) {
                C3500c.m11649a((Closeable) source);
                throw th;
            }
        } else {
            throw new IOException("Cannot buffer entire body for content length: " + contentLength);
        }
    }

    public final Reader charStream() {
        Reader reader2 = this.reader;
        if (reader2 != null) {
            return reader2;
        }
        C3486b bVar = new C3486b(source(), charset());
        this.reader = bVar;
        return bVar;
    }

    public void close() {
        C3500c.m11649a((Closeable) source());
    }

    public abstract long contentLength();

    @Nullable
    public abstract C3541u contentType();

    public abstract C3580e source();

    public final String string() throws IOException {
        C3580e source = source();
        try {
            return source.mo19700a(C3500c.m11642a(source, charset()));
        } finally {
            C3500c.m11649a((Closeable) source);
        }
    }

    public static C3484b0 create(@Nullable C3541u uVar, byte[] bArr) {
        C3577c cVar = new C3577c();
        cVar.write(bArr);
        return create(uVar, (long) bArr.length, cVar);
    }

    public static C3484b0 create(@Nullable C3541u uVar, C3581f fVar) {
        C3577c cVar = new C3577c();
        cVar.mo19694a(fVar);
        return create(uVar, (long) fVar.mo19759f(), cVar);
    }

    public static C3484b0 create(@Nullable C3541u uVar, long j, C3580e eVar) {
        if (eVar != null) {
            return new C3485a(uVar, j, eVar);
        }
        throw new NullPointerException("source == null");
    }
}
