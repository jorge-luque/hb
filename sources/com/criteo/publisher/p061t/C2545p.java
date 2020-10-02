package com.criteo.publisher.p061t;

import android.content.Context;
import com.criteo.publisher.p054a0.C2330h;
import com.criteo.publisher.p054a0.C2341p;
import com.squareup.tape.C4805a;
import com.squareup.tape.C4808b;
import com.squareup.tape.C4809c;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;

/* renamed from: com.criteo.publisher.t.p */
public class C2545p {

    /* renamed from: a */
    private final Context f8082a;

    /* renamed from: b */
    private final C2547q f8083b;

    /* renamed from: c */
    private final C2330h f8084c;

    /* renamed from: com.criteo.publisher.t.p$a */
    static class C2546a implements C4805a.C4806a<C2540m> {

        /* renamed from: a */
        private final C2547q f8085a;

        C2546a(C2547q qVar) {
            this.f8085a = qVar;
        }

        /* renamed from: a */
        public void toStream(C2540m mVar, OutputStream outputStream) throws IOException {
            if (mVar != null && outputStream != null) {
                this.f8085a.mo10593a(mVar, outputStream);
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:10:0x0015, code lost:
            r2 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:12:?, code lost:
            r0.close();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x0019, code lost:
            throw r2;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public com.criteo.publisher.p061t.C2540m from(byte[] r2) throws java.io.IOException {
            /*
                r1 = this;
                if (r2 != 0) goto L_0x0004
                r2 = 0
                return r2
            L_0x0004:
                java.io.ByteArrayInputStream r0 = new java.io.ByteArrayInputStream
                r0.<init>(r2)
                com.criteo.publisher.t.q r2 = r1.f8085a     // Catch:{ all -> 0x0013 }
                com.criteo.publisher.t.m r2 = r2.mo10592a(r0)     // Catch:{ all -> 0x0013 }
                r0.close()
                return r2
            L_0x0013:
                r2 = move-exception
                throw r2     // Catch:{ all -> 0x0015 }
            L_0x0015:
                r2 = move-exception
                r0.close()     // Catch:{ all -> 0x0019 }
            L_0x0019:
                throw r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.criteo.publisher.p061t.C2545p.C2546a.from(byte[]):com.criteo.publisher.t.m");
        }
    }

    public C2545p(Context context, C2547q qVar, C2330h hVar) {
        this.f8082a = context;
        this.f8083b = qVar;
        this.f8084c = hVar;
    }

    /* renamed from: a */
    public C4809c<C2540m> mo10587a() {
        return m9564a(mo10588b());
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public File mo10588b() {
        return new File(this.f8082a.getFilesDir(), this.f8084c.mo10133f());
    }

    /* renamed from: b */
    private boolean m9565b(File file) {
        File[] listFiles;
        if (file.isDirectory() && (listFiles = file.listFiles()) != null) {
            for (File b : listFiles) {
                if (!m9565b(b)) {
                    return false;
                }
            }
        }
        return file.delete();
    }

    /* renamed from: a */
    private C4809c<C2540m> m9564a(File file) {
        try {
            return new C4805a(file, new C2546a(this.f8083b));
        } catch (IOException e) {
            if (m9565b(file)) {
                try {
                    return new C4805a(file, new C2546a(this.f8083b));
                } catch (IOException unused) {
                    return new C4808b();
                } finally {
                    C2341p.m8996a((Throwable) e);
                }
            }
            return new C4808b();
        }
    }
}
