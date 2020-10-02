package p113i;

import java.io.Closeable;
import java.io.File;
import java.io.Flushable;
import java.io.IOException;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.annotation.Nullable;
import p113i.C3480a0;
import p113i.C3537r;
import p113i.C3548y;
import p113i.p114e0.C3500c;
import p113i.p114e0.p115e.C3503c;
import p113i.p114e0.p115e.C3505d;
import p113i.p114e0.p115e.C5931b;
import p113i.p114e0.p115e.C5933f;
import p113i.p114e0.p116f.C5940e;
import p113i.p114e0.p116f.C5941f;
import p113i.p114e0.p116f.C5945k;
import p113i.p114e0.p117i.C3521f;
import p113i.p114e0.p196h.C5954a;
import p119j.C3577c;
import p119j.C3579d;
import p119j.C3580e;
import p119j.C3581f;
import p119j.C3585t;
import p119j.C3586u;
import p119j.C6583h;
import p119j.C6584i;
import p119j.C6589n;

/* renamed from: i.c */
/* compiled from: Cache */
public final class C3487c implements Closeable, Flushable {

    /* renamed from: a */
    final C5933f f9641a;

    /* renamed from: b */
    final C3505d f9642b;

    /* renamed from: c */
    int f9643c;

    /* renamed from: d */
    int f9644d;

    /* renamed from: e */
    private int f9645e;

    /* renamed from: f */
    private int f9646f;

    /* renamed from: g */
    private int f9647g;

    /* renamed from: i.c$c */
    /* compiled from: Cache */
    private static class C3488c extends C3484b0 {

        /* renamed from: a */
        final C3505d.C3506e f9648a;

        /* renamed from: b */
        private final C3580e f9649b;
        @Nullable

        /* renamed from: c */
        private final String f9650c;
        @Nullable

        /* renamed from: d */
        private final String f9651d;

        /* renamed from: i.c$c$a */
        /* compiled from: Cache */
        class C3489a extends C6584i {

            /* renamed from: a */
            final /* synthetic */ C3505d.C3506e f9652a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            C3489a(C3586u uVar, C3505d.C3506e eVar) {
                super(uVar);
                this.f9652a = eVar;
            }

            public void close() throws IOException {
                this.f9652a.close();
                super.close();
            }
        }

        C3488c(C3505d.C3506e eVar, String str, String str2) {
            this.f9648a = eVar;
            this.f9650c = str;
            this.f9651d = str2;
            this.f9649b = C6589n.m21610a((C3586u) new C3489a(eVar.mo19395a(1), eVar));
        }

        public long contentLength() {
            try {
                if (this.f9651d != null) {
                    return Long.parseLong(this.f9651d);
                }
                return -1;
            } catch (NumberFormatException unused) {
                return -1;
            }
        }

        public C3541u contentType() {
            String str = this.f9650c;
            if (str != null) {
                return C3541u.m11900b(str);
            }
            return null;
        }

        public C3580e source() {
            return this.f9649b;
        }
    }

    /* renamed from: i.c$a */
    /* compiled from: Cache */
    class C3491a implements C5933f {
        C3491a() {
        }

        /* renamed from: a */
        public C5931b mo19331a(C3480a0 a0Var) throws IOException {
            return C3487c.this.mo19320a(a0Var);
        }

        /* renamed from: b */
        public C3480a0 mo19336b(C3548y yVar) throws IOException {
            return C3487c.this.mo19319a(yVar);
        }

        /* renamed from: a */
        public void mo19335a(C3548y yVar) throws IOException {
            C3487c.this.mo19323b(yVar);
        }

        /* renamed from: a */
        public void mo19333a(C3480a0 a0Var, C3480a0 a0Var2) {
            C3487c.this.mo19321a(a0Var, a0Var2);
        }

        /* renamed from: a */
        public void mo19332a() {
            C3487c.this.mo19325d();
        }

        /* renamed from: a */
        public void mo19334a(C3503c cVar) {
            C3487c.this.mo19322a(cVar);
        }
    }

    /* renamed from: i.c$b */
    /* compiled from: Cache */
    private final class C3492b implements C5931b {

        /* renamed from: a */
        private final C3505d.C3509c f9667a;

        /* renamed from: b */
        private C3585t f9668b;

        /* renamed from: c */
        private C3585t f9669c;

        /* renamed from: d */
        boolean f9670d;

        /* renamed from: i.c$b$a */
        /* compiled from: Cache */
        class C3493a extends C6583h {

            /* renamed from: b */
            final /* synthetic */ C3487c f9672b;

            /* renamed from: c */
            final /* synthetic */ C3505d.C3509c f9673c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            C3493a(C3585t tVar, C3487c cVar, C3505d.C3509c cVar2) {
                super(tVar);
                this.f9672b = cVar;
                this.f9673c = cVar2;
            }

            public void close() throws IOException {
                synchronized (C3487c.this) {
                    if (!C3492b.this.f9670d) {
                        C3492b.this.f9670d = true;
                        C3487c.this.f9643c++;
                        super.close();
                        this.f9673c.mo19402b();
                    }
                }
            }
        }

        C3492b(C3505d.C3509c cVar) {
            this.f9667a = cVar;
            C3585t a = cVar.mo19400a(1);
            this.f9668b = a;
            this.f9669c = new C3493a(a, C3487c.this, cVar);
        }

        /* renamed from: a */
        public C3585t mo19337a() {
            return this.f9669c;
        }

        public void abort() {
            synchronized (C3487c.this) {
                if (!this.f9670d) {
                    this.f9670d = true;
                    C3487c.this.f9644d++;
                    C3500c.m11649a((Closeable) this.f9668b);
                    try {
                        this.f9667a.mo19401a();
                    } catch (IOException unused) {
                    }
                }
            }
        }
    }

    public C3487c(File file, long j) {
        this(file, j, C5954a.f15224a);
    }

    /* renamed from: a */
    public static String m11577a(C3539s sVar) {
        return C3581f.m12177d(sVar.toString()).mo19754c().mo19752b();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo19323b(C3548y yVar) throws IOException {
        this.f9642b.mo19388d(m11577a(yVar.mo19607g()));
    }

    public void close() throws IOException {
        this.f9642b.close();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public synchronized void mo19325d() {
        this.f9646f++;
    }

    public void flush() throws IOException {
        this.f9642b.flush();
    }

    C3487c(File file, long j, C5954a aVar) {
        this.f9641a = new C3491a();
        this.f9642b = C3505d.m11676a(aVar, file, 201105, 2, j);
    }

    /* access modifiers changed from: package-private */
    @Nullable
    /* renamed from: a */
    public C3480a0 mo19319a(C3548y yVar) {
        try {
            C3505d.C3506e c = this.f9642b.mo19385c(m11577a(yVar.mo19607g()));
            if (c == null) {
                return null;
            }
            try {
                C3490d dVar = new C3490d(c.mo19395a(0));
                C3480a0 a = dVar.mo19328a(c);
                if (dVar.mo19330a(yVar, a)) {
                    return a;
                }
                C3500c.m11649a((Closeable) a.mo19284d());
                return null;
            } catch (IOException unused) {
                C3500c.m11649a((Closeable) c);
                return null;
            }
        } catch (IOException unused2) {
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    @Nullable
    /* renamed from: a */
    public C5931b mo19320a(C3480a0 a0Var) {
        C3505d.C3509c cVar;
        String e = a0Var.mo19281b0().mo19605e();
        if (C5941f.m19041a(a0Var.mo19281b0().mo19605e())) {
            try {
                mo19323b(a0Var.mo19281b0());
            } catch (IOException unused) {
            }
            return null;
        } else if (!e.equals("GET") || C5940e.m19038c(a0Var)) {
            return null;
        } else {
            C3490d dVar = new C3490d(a0Var);
            try {
                cVar = this.f9642b.mo19381a(m11577a(a0Var.mo19281b0().mo19607g()));
                if (cVar == null) {
                    return null;
                }
                try {
                    dVar.mo19329a(cVar);
                    return new C3492b(cVar);
                } catch (IOException unused2) {
                    m11578a(cVar);
                    return null;
                }
            } catch (IOException unused3) {
                cVar = null;
                m11578a(cVar);
                return null;
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo19321a(C3480a0 a0Var, C3480a0 a0Var2) {
        C3505d.C3509c cVar;
        C3490d dVar = new C3490d(a0Var2);
        try {
            cVar = ((C3488c) a0Var.mo19284d()).f9648a.mo19397d();
            if (cVar != null) {
                try {
                    dVar.mo19329a(cVar);
                    cVar.mo19402b();
                } catch (IOException unused) {
                }
            }
        } catch (IOException unused2) {
            cVar = null;
            m11578a(cVar);
        }
    }

    /* renamed from: a */
    private void m11578a(@Nullable C3505d.C3509c cVar) {
        if (cVar != null) {
            try {
                cVar.mo19401a();
            } catch (IOException unused) {
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public synchronized void mo19322a(C3503c cVar) {
        this.f9647g++;
        if (cVar.f9720a != null) {
            this.f9645e++;
        } else if (cVar.f9721b != null) {
            this.f9646f++;
        }
    }

    /* renamed from: a */
    static int m11576a(C3580e eVar) throws IOException {
        try {
            long K = eVar.mo19683K();
            String M = eVar.mo19684M();
            if (K >= 0 && K <= 2147483647L && M.isEmpty()) {
                return (int) K;
            }
            throw new IOException("expected an int but was \"" + K + M + "\"");
        } catch (NumberFormatException e) {
            throw new IOException(e.getMessage());
        }
    }

    /* renamed from: i.c$d */
    /* compiled from: Cache */
    private static final class C3490d {

        /* renamed from: k */
        private static final String f9654k = (C3521f.m11740d().mo19428a() + "-Sent-Millis");

        /* renamed from: l */
        private static final String f9655l = (C3521f.m11740d().mo19428a() + "-Received-Millis");

        /* renamed from: a */
        private final String f9656a;

        /* renamed from: b */
        private final C3537r f9657b;

        /* renamed from: c */
        private final String f9658c;

        /* renamed from: d */
        private final C5972w f9659d;

        /* renamed from: e */
        private final int f9660e;

        /* renamed from: f */
        private final String f9661f;

        /* renamed from: g */
        private final C3537r f9662g;
        @Nullable

        /* renamed from: h */
        private final C3536q f9663h;

        /* renamed from: i */
        private final long f9664i;

        /* renamed from: j */
        private final long f9665j;

        C3490d(C3586u uVar) throws IOException {
            C5926d0 d0Var;
            try {
                C3580e a = C6589n.m21610a(uVar);
                this.f9656a = a.mo19684M();
                this.f9658c = a.mo19684M();
                C3537r.C3538a aVar = new C3537r.C3538a();
                int a2 = C3487c.m11576a(a);
                for (int i = 0; i < a2; i++) {
                    aVar.mo19509a(a.mo19684M());
                }
                this.f9657b = aVar.mo19511a();
                C5945k a3 = C5945k.m19069a(a.mo19684M());
                this.f9659d = a3.f15198a;
                this.f9660e = a3.f15199b;
                this.f9661f = a3.f15200c;
                C3537r.C3538a aVar2 = new C3537r.C3538a();
                int a4 = C3487c.m11576a(a);
                for (int i2 = 0; i2 < a4; i2++) {
                    aVar2.mo19509a(a.mo19684M());
                }
                String b = aVar2.mo19513b(f9654k);
                String b2 = aVar2.mo19513b(f9655l);
                aVar2.mo19514c(f9654k);
                aVar2.mo19514c(f9655l);
                long j = 0;
                this.f9664i = b != null ? Long.parseLong(b) : 0;
                this.f9665j = b2 != null ? Long.parseLong(b2) : j;
                this.f9662g = aVar2.mo19511a();
                if (m11587a()) {
                    String M = a.mo19684M();
                    if (M.length() <= 0) {
                        C5964h a5 = C5964h.m19122a(a.mo19684M());
                        List<Certificate> a6 = m11585a(a);
                        List<Certificate> a7 = m11585a(a);
                        if (!a.mo19681H()) {
                            d0Var = C5926d0.m18997a(a.mo19684M());
                        } else {
                            d0Var = C5926d0.SSL_3_0;
                        }
                        this.f9663h = C3536q.m11825a(d0Var, a5, a6, a7);
                    } else {
                        throw new IOException("expected \"\" but was \"" + M + "\"");
                    }
                } else {
                    this.f9663h = null;
                }
            } finally {
                uVar.close();
            }
        }

        /* renamed from: a */
        public void mo19329a(C3505d.C3509c cVar) throws IOException {
            C3579d a = C6589n.m21609a(cVar.mo19400a(0));
            a.mo19708e(this.f9656a).writeByte(10);
            a.mo19708e(this.f9658c).writeByte(10);
            a.mo19719m((long) this.f9657b.mo19503b()).writeByte(10);
            int b = this.f9657b.mo19503b();
            for (int i = 0; i < b; i++) {
                a.mo19708e(this.f9657b.mo19501a(i)).mo19708e(": ").mo19708e(this.f9657b.mo19504b(i)).writeByte(10);
            }
            a.mo19708e(new C5945k(this.f9659d, this.f9660e, this.f9661f).toString()).writeByte(10);
            a.mo19719m((long) (this.f9662g.mo19503b() + 2)).writeByte(10);
            int b2 = this.f9662g.mo19503b();
            for (int i2 = 0; i2 < b2; i2++) {
                a.mo19708e(this.f9662g.mo19501a(i2)).mo19708e(": ").mo19708e(this.f9662g.mo19504b(i2)).writeByte(10);
            }
            a.mo19708e(f9654k).mo19708e(": ").mo19719m(this.f9664i).writeByte(10);
            a.mo19708e(f9655l).mo19708e(": ").mo19719m(this.f9665j).writeByte(10);
            if (m11587a()) {
                a.writeByte(10);
                a.mo19708e(this.f9663h.mo19494a().mo33775a()).writeByte(10);
                m11586a(a, this.f9663h.mo19496c());
                m11586a(a, this.f9663h.mo19495b());
                a.mo19708e(this.f9663h.mo19497d().mo33719a()).writeByte(10);
            }
            a.close();
        }

        /* renamed from: a */
        private boolean m11587a() {
            return this.f9656a.startsWith("https://");
        }

        C3490d(C3480a0 a0Var) {
            this.f9656a = a0Var.mo19281b0().mo19607g().toString();
            this.f9657b = C5940e.m19040e(a0Var);
            this.f9658c = a0Var.mo19281b0().mo19605e();
            this.f9659d = a0Var.mo19277Z();
            this.f9660e = a0Var.mo19288v();
            this.f9661f = a0Var.mo19292z();
            this.f9662g = a0Var.mo19290x();
            this.f9663h = a0Var.mo19289w();
            this.f9664i = a0Var.mo19282c0();
            this.f9665j = a0Var.mo19280a0();
        }

        /* renamed from: a */
        private List<Certificate> m11585a(C3580e eVar) throws IOException {
            int a = C3487c.m11576a(eVar);
            if (a == -1) {
                return Collections.emptyList();
            }
            try {
                CertificateFactory instance = CertificateFactory.getInstance("X.509");
                ArrayList arrayList = new ArrayList(a);
                for (int i = 0; i < a; i++) {
                    String M = eVar.mo19684M();
                    C3577c cVar = new C3577c();
                    cVar.mo19694a(C3581f.m12173a(M));
                    arrayList.add(instance.generateCertificate(cVar.mo19688V()));
                }
                return arrayList;
            } catch (CertificateException e) {
                throw new IOException(e.getMessage());
            }
        }

        /* renamed from: a */
        private void m11586a(C3579d dVar, List<Certificate> list) throws IOException {
            try {
                dVar.mo19719m((long) list.size()).writeByte(10);
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    dVar.mo19708e(C3581f.m12174a(list.get(i).getEncoded()).mo19748a()).writeByte(10);
                }
            } catch (CertificateEncodingException e) {
                throw new IOException(e.getMessage());
            }
        }

        /* renamed from: a */
        public boolean mo19330a(C3548y yVar, C3480a0 a0Var) {
            return this.f9656a.equals(yVar.mo19607g().toString()) && this.f9658c.equals(yVar.mo19605e()) && C5940e.m19033a(a0Var, this.f9657b, yVar);
        }

        /* renamed from: a */
        public C3480a0 mo19328a(C3505d.C3506e eVar) {
            String a = this.f9662g.mo19502a("Content-Type");
            String a2 = this.f9662g.mo19502a("Content-Length");
            C3548y.C3549a aVar = new C3548y.C3549a();
            aVar.mo19618b(this.f9656a);
            aVar.mo19614a(this.f9658c, (C3550z) null);
            aVar.mo19610a(this.f9657b);
            C3548y a3 = aVar.mo19616a();
            C3480a0.C3481a aVar2 = new C3480a0.C3481a();
            aVar2.mo19300a(a3);
            aVar2.mo19299a(this.f9659d);
            aVar2.mo19293a(this.f9660e);
            aVar2.mo19301a(this.f9661f);
            aVar2.mo19298a(this.f9662g);
            aVar2.mo19296a((C3484b0) new C3488c(eVar, a, a2));
            aVar2.mo19297a(this.f9663h);
            aVar2.mo19304b(this.f9664i);
            aVar2.mo19294a(this.f9665j);
            return aVar2.mo19303a();
        }
    }
}
