package p113i.p114e0.p195g;

import android.support.p004v4.media.session.PlaybackStateCompat;
import java.io.EOFException;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.concurrent.TimeUnit;
import okhttp3.internal.connection.C3589c;
import okhttp3.internal.connection.C6613f;
import p113i.C3480a0;
import p113i.C3484b0;
import p113i.C3537r;
import p113i.C3539s;
import p113i.C3542v;
import p113i.C3548y;
import p113i.p114e0.C3499a;
import p113i.p114e0.C3500c;
import p113i.p114e0.p116f.C3512h;
import p113i.p114e0.p116f.C5937c;
import p113i.p114e0.p116f.C5940e;
import p113i.p114e0.p116f.C5943i;
import p113i.p114e0.p116f.C5945k;
import p119j.C3577c;
import p119j.C3579d;
import p119j.C3580e;
import p119j.C3585t;
import p119j.C3586u;
import p119j.C3587v;
import p119j.C6585j;
import p119j.C6589n;

/* renamed from: i.e0.g.a */
/* compiled from: Http1Codec */
public final class C5946a implements C5937c {

    /* renamed from: a */
    final C3542v f15201a;

    /* renamed from: b */
    final C6613f f15202b;

    /* renamed from: c */
    final C3580e f15203c;

    /* renamed from: d */
    final C3579d f15204d;

    /* renamed from: e */
    int f15205e = 0;

    /* renamed from: f */
    private long f15206f = PlaybackStateCompat.ACTION_SET_REPEAT_MODE;

    /* renamed from: i.e0.g.a$b */
    /* compiled from: Http1Codec */
    private abstract class C5948b implements C3586u {

        /* renamed from: a */
        protected final C6585j f15207a;

        /* renamed from: b */
        protected boolean f15208b;

        /* renamed from: c */
        protected long f15209c;

        private C5948b() {
            this.f15207a = new C6585j(C5946a.this.f15203c.timeout());
            this.f15209c = 0;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public final void mo33752a(boolean z, IOException iOException) throws IOException {
            C5946a aVar = C5946a.this;
            int i = aVar.f15205e;
            if (i != 6) {
                if (i == 5) {
                    aVar.mo33747a(this.f15207a);
                    C5946a aVar2 = C5946a.this;
                    aVar2.f15205e = 6;
                    C6613f fVar = aVar2.f15202b;
                    if (fVar != null) {
                        fVar.mo35663a(!z, aVar2, this.f15209c, iOException);
                        return;
                    }
                    return;
                }
                throw new IllegalStateException("state: " + C5946a.this.f15205e);
            }
        }

        public long read(C3577c cVar, long j) throws IOException {
            try {
                long read = C5946a.this.f15203c.read(cVar, j);
                if (read > 0) {
                    this.f15209c += read;
                }
                return read;
            } catch (IOException e) {
                mo33752a(false, e);
                throw e;
            }
        }

        public C3587v timeout() {
            return this.f15207a;
        }
    }

    /* renamed from: i.e0.g.a$c */
    /* compiled from: Http1Codec */
    private final class C5949c implements C3585t {

        /* renamed from: a */
        private final C6585j f15211a = new C6585j(C5946a.this.f15204d.timeout());

        /* renamed from: b */
        private boolean f15212b;

        C5949c() {
        }

        /* renamed from: a */
        public void mo19670a(C3577c cVar, long j) throws IOException {
            if (this.f15212b) {
                throw new IllegalStateException("closed");
            } else if (j != 0) {
                C5946a.this.f15204d.mo19716j(j);
                C5946a.this.f15204d.mo19708e("\r\n");
                C5946a.this.f15204d.mo19670a(cVar, j);
                C5946a.this.f15204d.mo19708e("\r\n");
            }
        }

        public synchronized void close() throws IOException {
            if (!this.f15212b) {
                this.f15212b = true;
                C5946a.this.f15204d.mo19708e("0\r\n\r\n");
                C5946a.this.mo33747a(this.f15211a);
                C5946a.this.f15205e = 3;
            }
        }

        public synchronized void flush() throws IOException {
            if (!this.f15212b) {
                C5946a.this.f15204d.flush();
            }
        }

        public C3587v timeout() {
            return this.f15211a;
        }
    }

    /* renamed from: i.e0.g.a$d */
    /* compiled from: Http1Codec */
    private class C5950d extends C5948b {

        /* renamed from: e */
        private final C3539s f15214e;

        /* renamed from: f */
        private long f15215f = -1;

        /* renamed from: g */
        private boolean f15216g = true;

        C5950d(C3539s sVar) {
            super();
            this.f15214e = sVar;
        }

        /* renamed from: d */
        private void m19087d() throws IOException {
            if (this.f15215f != -1) {
                C5946a.this.f15203c.mo19684M();
            }
            try {
                this.f15215f = C5946a.this.f15203c.mo19687U();
                String trim = C5946a.this.f15203c.mo19684M().trim();
                if (this.f15215f < 0 || (!trim.isEmpty() && !trim.startsWith(";"))) {
                    throw new ProtocolException("expected chunk size and optional extensions but was \"" + this.f15215f + trim + "\"");
                } else if (this.f15215f == 0) {
                    this.f15216g = false;
                    C5940e.m19032a(C5946a.this.f15201a.mo19562h(), this.f15214e, C5946a.this.mo33751e());
                    mo33752a(true, (IOException) null);
                }
            } catch (NumberFormatException e) {
                throw new ProtocolException(e.getMessage());
            }
        }

        public void close() throws IOException {
            if (!this.f15208b) {
                if (this.f15216g && !C3500c.m11652a((C3586u) this, 100, TimeUnit.MILLISECONDS)) {
                    mo33752a(false, (IOException) null);
                }
                this.f15208b = true;
            }
        }

        public long read(C3577c cVar, long j) throws IOException {
            if (j < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j);
            } else if (this.f15208b) {
                throw new IllegalStateException("closed");
            } else if (!this.f15216g) {
                return -1;
            } else {
                long j2 = this.f15215f;
                if (j2 == 0 || j2 == -1) {
                    m19087d();
                    if (!this.f15216g) {
                        return -1;
                    }
                }
                long read = super.read(cVar, Math.min(j, this.f15215f));
                if (read != -1) {
                    this.f15215f -= read;
                    return read;
                }
                ProtocolException protocolException = new ProtocolException("unexpected end of stream");
                mo33752a(false, protocolException);
                throw protocolException;
            }
        }
    }

    /* renamed from: i.e0.g.a$e */
    /* compiled from: Http1Codec */
    private final class C5951e implements C3585t {

        /* renamed from: a */
        private final C6585j f15218a = new C6585j(C5946a.this.f15204d.timeout());

        /* renamed from: b */
        private boolean f15219b;

        /* renamed from: c */
        private long f15220c;

        C5951e(long j) {
            this.f15220c = j;
        }

        /* renamed from: a */
        public void mo19670a(C3577c cVar, long j) throws IOException {
            if (!this.f15219b) {
                C3500c.m11648a(cVar.size(), 0, j);
                if (j <= this.f15220c) {
                    C5946a.this.f15204d.mo19670a(cVar, j);
                    this.f15220c -= j;
                    return;
                }
                throw new ProtocolException("expected " + this.f15220c + " bytes but received " + j);
            }
            throw new IllegalStateException("closed");
        }

        public void close() throws IOException {
            if (!this.f15219b) {
                this.f15219b = true;
                if (this.f15220c <= 0) {
                    C5946a.this.mo33747a(this.f15218a);
                    C5946a.this.f15205e = 3;
                    return;
                }
                throw new ProtocolException("unexpected end of stream");
            }
        }

        public void flush() throws IOException {
            if (!this.f15219b) {
                C5946a.this.f15204d.flush();
            }
        }

        public C3587v timeout() {
            return this.f15218a;
        }
    }

    /* renamed from: i.e0.g.a$f */
    /* compiled from: Http1Codec */
    private class C5952f extends C5948b {

        /* renamed from: e */
        private long f15222e;

        C5952f(C5946a aVar, long j) throws IOException {
            super();
            this.f15222e = j;
            if (j == 0) {
                mo33752a(true, (IOException) null);
            }
        }

        public void close() throws IOException {
            if (!this.f15208b) {
                if (this.f15222e != 0 && !C3500c.m11652a((C3586u) this, 100, TimeUnit.MILLISECONDS)) {
                    mo33752a(false, (IOException) null);
                }
                this.f15208b = true;
            }
        }

        public long read(C3577c cVar, long j) throws IOException {
            if (j < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j);
            } else if (!this.f15208b) {
                long j2 = this.f15222e;
                if (j2 == 0) {
                    return -1;
                }
                long read = super.read(cVar, Math.min(j2, j));
                if (read != -1) {
                    long j3 = this.f15222e - read;
                    this.f15222e = j3;
                    if (j3 == 0) {
                        mo33752a(true, (IOException) null);
                    }
                    return read;
                }
                ProtocolException protocolException = new ProtocolException("unexpected end of stream");
                mo33752a(false, protocolException);
                throw protocolException;
            } else {
                throw new IllegalStateException("closed");
            }
        }
    }

    /* renamed from: i.e0.g.a$g */
    /* compiled from: Http1Codec */
    private class C5953g extends C5948b {

        /* renamed from: e */
        private boolean f15223e;

        C5953g(C5946a aVar) {
            super();
        }

        public void close() throws IOException {
            if (!this.f15208b) {
                if (!this.f15223e) {
                    mo33752a(false, (IOException) null);
                }
                this.f15208b = true;
            }
        }

        public long read(C3577c cVar, long j) throws IOException {
            if (j < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j);
            } else if (this.f15208b) {
                throw new IllegalStateException("closed");
            } else if (this.f15223e) {
                return -1;
            } else {
                long read = super.read(cVar, j);
                if (read != -1) {
                    return read;
                }
                this.f15223e = true;
                mo33752a(true, (IOException) null);
                return -1;
            }
        }
    }

    public C5946a(C3542v vVar, C6613f fVar, C3580e eVar, C3579d dVar) {
        this.f15201a = vVar;
        this.f15202b = fVar;
        this.f15203c = eVar;
        this.f15204d = dVar;
    }

    /* renamed from: f */
    private String m19070f() throws IOException {
        String i = this.f15203c.mo19714i(this.f15206f);
        this.f15206f -= (long) i.length();
        return i;
    }

    /* renamed from: a */
    public C3585t mo33723a(C3548y yVar, long j) {
        if ("chunked".equalsIgnoreCase(yVar.mo19600a("Transfer-Encoding"))) {
            return mo33749c();
        }
        if (j != -1) {
            return mo33744a(j);
        }
        throw new IllegalStateException("Cannot stream a request body without chunked encoding or a known content length!");
    }

    /* renamed from: b */
    public void mo33726b() throws IOException {
        this.f15204d.flush();
    }

    /* renamed from: c */
    public C3585t mo33749c() {
        if (this.f15205e == 1) {
            this.f15205e = 2;
            return new C5949c();
        }
        throw new IllegalStateException("state: " + this.f15205e);
    }

    public void cancel() {
        C3589c c = this.f15202b.mo35665c();
        if (c != null) {
            c.mo19780a();
        }
    }

    /* renamed from: d */
    public C3586u mo33750d() throws IOException {
        if (this.f15205e == 4) {
            C6613f fVar = this.f15202b;
            if (fVar != null) {
                this.f15205e = 5;
                fVar.mo35667e();
                return new C5953g(this);
            }
            throw new IllegalStateException("streamAllocation == null");
        }
        throw new IllegalStateException("state: " + this.f15205e);
    }

    /* renamed from: e */
    public C3537r mo33751e() throws IOException {
        C3537r.C3538a aVar = new C3537r.C3538a();
        while (true) {
            String f = m19070f();
            if (f.length() == 0) {
                return aVar.mo19511a();
            }
            C3499a.f9700a.mo19372a(aVar, f);
        }
    }

    /* renamed from: b */
    public C3586u mo33748b(long j) throws IOException {
        if (this.f15205e == 4) {
            this.f15205e = 5;
            return new C5952f(this, j);
        }
        throw new IllegalStateException("state: " + this.f15205e);
    }

    /* renamed from: a */
    public void mo33725a(C3548y yVar) throws IOException {
        mo33746a(yVar.mo19603c(), C5943i.m19058a(yVar, this.f15202b.mo35665c().mo19789d().mo19341b().type()));
    }

    /* renamed from: a */
    public C3484b0 mo33722a(C3480a0 a0Var) throws IOException {
        C6613f fVar = this.f15202b;
        fVar.f17304f.mo19490e(fVar.f17303e);
        String a = a0Var.mo19278a("Content-Type");
        if (!C5940e.m19035b(a0Var)) {
            return new C3512h(a, 0, C6589n.m21610a(mo33748b(0)));
        }
        if ("chunked".equalsIgnoreCase(a0Var.mo19278a("Transfer-Encoding"))) {
            return new C3512h(a, -1, C6589n.m21610a(mo33745a(a0Var.mo19281b0().mo19607g())));
        }
        long a2 = C5940e.m19028a(a0Var);
        if (a2 != -1) {
            return new C3512h(a, a2, C6589n.m21610a(mo33748b(a2)));
        }
        return new C3512h(a, -1, C6589n.m21610a(mo33750d()));
    }

    /* renamed from: a */
    public void mo33724a() throws IOException {
        this.f15204d.flush();
    }

    /* renamed from: a */
    public void mo33746a(C3537r rVar, String str) throws IOException {
        if (this.f15205e == 0) {
            this.f15204d.mo19708e(str).mo19708e("\r\n");
            int b = rVar.mo19503b();
            for (int i = 0; i < b; i++) {
                this.f15204d.mo19708e(rVar.mo19501a(i)).mo19708e(": ").mo19708e(rVar.mo19504b(i)).mo19708e("\r\n");
            }
            this.f15204d.mo19708e("\r\n");
            this.f15205e = 1;
            return;
        }
        throw new IllegalStateException("state: " + this.f15205e);
    }

    /* renamed from: a */
    public C3480a0.C3481a mo33721a(boolean z) throws IOException {
        int i = this.f15205e;
        if (i == 1 || i == 3) {
            try {
                C5945k a = C5945k.m19069a(m19070f());
                C3480a0.C3481a aVar = new C3480a0.C3481a();
                aVar.mo19299a(a.f15198a);
                aVar.mo19293a(a.f15199b);
                aVar.mo19301a(a.f15200c);
                aVar.mo19298a(mo33751e());
                if (z && a.f15199b == 100) {
                    return null;
                }
                if (a.f15199b == 100) {
                    this.f15205e = 3;
                    return aVar;
                }
                this.f15205e = 4;
                return aVar;
            } catch (EOFException e) {
                IOException iOException = new IOException("unexpected end of stream on " + this.f15202b);
                iOException.initCause(e);
                throw iOException;
            }
        } else {
            throw new IllegalStateException("state: " + this.f15205e);
        }
    }

    /* renamed from: a */
    public C3585t mo33744a(long j) {
        if (this.f15205e == 1) {
            this.f15205e = 2;
            return new C5951e(j);
        }
        throw new IllegalStateException("state: " + this.f15205e);
    }

    /* renamed from: a */
    public C3586u mo33745a(C3539s sVar) throws IOException {
        if (this.f15205e == 4) {
            this.f15205e = 5;
            return new C5950d(sVar);
        }
        throw new IllegalStateException("state: " + this.f15205e);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo33747a(C6585j jVar) {
        C3587v g = jVar.mo35612g();
        jVar.mo35611a(C3587v.f10049d);
        g.mo19771a();
        g.mo19774b();
    }
}
