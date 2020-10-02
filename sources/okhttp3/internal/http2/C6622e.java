package okhttp3.internal.http2;

import java.io.IOException;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import okhttp3.internal.connection.C6613f;
import p113i.C3480a0;
import p113i.C3484b0;
import p113i.C3537r;
import p113i.C3542v;
import p113i.C3548y;
import p113i.C5970t;
import p113i.C5972w;
import p113i.p114e0.C3499a;
import p113i.p114e0.C3500c;
import p113i.p114e0.p116f.C3512h;
import p113i.p114e0.p116f.C5937c;
import p113i.p114e0.p116f.C5940e;
import p113i.p114e0.p116f.C5943i;
import p113i.p114e0.p116f.C5945k;
import p119j.C3577c;
import p119j.C3581f;
import p119j.C3585t;
import p119j.C3586u;
import p119j.C6584i;
import p119j.C6589n;

/* renamed from: okhttp3.internal.http2.e */
/* compiled from: Http2Codec */
public final class C6622e implements C5937c {

    /* renamed from: f */
    private static final List<String> f17360f = C3500c.m11644a((T[]) new String[]{"connection", "host", "keep-alive", "proxy-connection", "te", "transfer-encoding", "encoding", "upgrade", ":method", ":path", ":scheme", ":authority"});

    /* renamed from: g */
    private static final List<String> f17361g = C3500c.m11644a((T[]) new String[]{"connection", "host", "keep-alive", "proxy-connection", "te", "transfer-encoding", "encoding", "upgrade"});

    /* renamed from: a */
    private final C5970t.C5971a f17362a;

    /* renamed from: b */
    final C6613f f17363b;

    /* renamed from: c */
    private final C6624f f17364c;

    /* renamed from: d */
    private C3592h f17365d;

    /* renamed from: e */
    private final C5972w f17366e;

    /* renamed from: okhttp3.internal.http2.e$a */
    /* compiled from: Http2Codec */
    class C6623a extends C6584i {

        /* renamed from: a */
        boolean f17367a = false;

        /* renamed from: b */
        long f17368b = 0;

        C6623a(C3586u uVar) {
            super(uVar);
        }

        /* renamed from: a */
        private void m21783a(IOException iOException) {
            if (!this.f17367a) {
                this.f17367a = true;
                C6622e eVar = C6622e.this;
                eVar.f17363b.mo35663a(false, eVar, this.f17368b, iOException);
            }
        }

        public void close() throws IOException {
            super.close();
            m21783a((IOException) null);
        }

        public long read(C3577c cVar, long j) throws IOException {
            try {
                long read = delegate().read(cVar, j);
                if (read > 0) {
                    this.f17368b += read;
                }
                return read;
            } catch (IOException e) {
                m21783a(e);
                throw e;
            }
        }
    }

    public C6622e(C3542v vVar, C5970t.C5971a aVar, C6613f fVar, C6624f fVar2) {
        C5972w wVar;
        this.f17362a = aVar;
        this.f17363b = fVar;
        this.f17364c = fVar2;
        if (vVar.mo19574t().contains(C5972w.H2_PRIOR_KNOWLEDGE)) {
            wVar = C5972w.H2_PRIOR_KNOWLEDGE;
        } else {
            wVar = C5972w.HTTP_2;
        }
        this.f17366e = wVar;
    }

    /* renamed from: a */
    public C3585t mo33723a(C3548y yVar, long j) {
        return this.f17365d.mo19801d();
    }

    /* renamed from: b */
    public void mo33726b() throws IOException {
        this.f17364c.flush();
    }

    public void cancel() {
        C3592h hVar = this.f17365d;
        if (hVar != null) {
            hVar.mo19798b(C6615a.CANCEL);
        }
    }

    /* renamed from: b */
    public static List<C6616b> m21776b(C3548y yVar) {
        C3537r c = yVar.mo19603c();
        ArrayList arrayList = new ArrayList(c.mo19503b() + 4);
        arrayList.add(new C6616b(C6616b.f17330f, yVar.mo19605e()));
        arrayList.add(new C6616b(C6616b.f17331g, C5943i.m19057a(yVar.mo19607g())));
        String a = yVar.mo19600a("Host");
        if (a != null) {
            arrayList.add(new C6616b(C6616b.f17333i, a));
        }
        arrayList.add(new C6616b(C6616b.f17332h, yVar.mo19607g().mo19533n()));
        int b = c.mo19503b();
        for (int i = 0; i < b; i++) {
            C3581f d = C3581f.m12177d(c.mo19501a(i).toLowerCase(Locale.US));
            if (!f17360f.contains(d.mo19763i())) {
                arrayList.add(new C6616b(d, c.mo19504b(i)));
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    public void mo33725a(C3548y yVar) throws IOException {
        if (this.f17365d == null) {
            C3592h a = this.f17364c.mo35684a(m21776b(yVar), yVar.mo19599a() != null);
            this.f17365d = a;
            a.mo19805h().mo19773a((long) this.f17362a.mo33729a(), TimeUnit.MILLISECONDS);
            this.f17365d.mo19809l().mo19773a((long) this.f17362a.mo33732b(), TimeUnit.MILLISECONDS);
        }
    }

    /* renamed from: a */
    public void mo33724a() throws IOException {
        this.f17365d.mo19801d().close();
    }

    /* renamed from: a */
    public C3480a0.C3481a mo33721a(boolean z) throws IOException {
        C3480a0.C3481a a = m21775a(this.f17365d.mo19807j(), this.f17366e);
        if (!z || C3499a.f9700a.mo19366a(a) != 100) {
            return a;
        }
        return null;
    }

    /* renamed from: a */
    public static C3480a0.C3481a m21775a(C3537r rVar, C5972w wVar) throws IOException {
        C3537r.C3538a aVar = new C3537r.C3538a();
        int b = rVar.mo19503b();
        C5945k kVar = null;
        for (int i = 0; i < b; i++) {
            String a = rVar.mo19501a(i);
            String b2 = rVar.mo19504b(i);
            if (a.equals(":status")) {
                kVar = C5945k.m19069a("HTTP/1.1 " + b2);
            } else if (!f17361g.contains(a)) {
                C3499a.f9700a.mo19373a(aVar, a, b2);
            }
        }
        if (kVar != null) {
            C3480a0.C3481a aVar2 = new C3480a0.C3481a();
            aVar2.mo19299a(wVar);
            aVar2.mo19293a(kVar.f15199b);
            aVar2.mo19301a(kVar.f15200c);
            aVar2.mo19298a(aVar.mo19511a());
            return aVar2;
        }
        throw new ProtocolException("Expected ':status' header not present");
    }

    /* renamed from: a */
    public C3484b0 mo33722a(C3480a0 a0Var) throws IOException {
        C6613f fVar = this.f17363b;
        fVar.f17304f.mo19490e(fVar.f17303e);
        return new C3512h(a0Var.mo19278a("Content-Type"), C5940e.m19028a(a0Var), C6589n.m21610a((C3586u) new C6623a(this.f17365d.mo19802e())));
    }
}
