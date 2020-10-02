package p113i;

import java.io.IOException;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.Socket;
import java.security.GeneralSecurityException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import okhttp3.internal.connection.C3589c;
import okhttp3.internal.connection.C6610d;
import okhttp3.internal.connection.C6613f;
import p113i.C3480a0;
import p113i.C3497e;
import p113i.C3532p;
import p113i.C3537r;
import p113i.p114e0.C3499a;
import p113i.p114e0.C3500c;
import p113i.p114e0.p115e.C5933f;
import p113i.p114e0.p117i.C3521f;
import p113i.p114e0.p197j.C5957a;
import p113i.p114e0.p198k.C5960c;
import p113i.p114e0.p198k.C5961d;
import p118io.fabric.sdk.android.p200m.p202b.C6078a;

/* renamed from: i.v */
/* compiled from: OkHttpClient */
public class C3542v implements Cloneable, C3497e.C3498a {

    /* renamed from: C */
    static final List<C5972w> f9879C = C3500c.m11644a((T[]) new C5972w[]{C5972w.HTTP_2, C5972w.HTTP_1_1});

    /* renamed from: D */
    static final List<C3528k> f9880D = C3500c.m11644a((T[]) new C3528k[]{C3528k.f9819g, C3528k.f9820h});

    /* renamed from: A */
    final int f9881A;

    /* renamed from: B */
    final int f9882B;

    /* renamed from: a */
    final C3531n f9883a;
    @Nullable

    /* renamed from: b */
    final Proxy f9884b;

    /* renamed from: c */
    final List<C5972w> f9885c;

    /* renamed from: d */
    final List<C3528k> f9886d;

    /* renamed from: e */
    final List<C5970t> f9887e;

    /* renamed from: f */
    final List<C5970t> f9888f;

    /* renamed from: g */
    final C3532p.C3535c f9889g;

    /* renamed from: h */
    final ProxySelector f9890h;

    /* renamed from: i */
    final C5966m f9891i;
    @Nullable

    /* renamed from: j */
    final C3487c f9892j;
    @Nullable

    /* renamed from: k */
    final C5933f f9893k;

    /* renamed from: l */
    final SocketFactory f9894l;

    /* renamed from: m */
    final SSLSocketFactory f9895m;

    /* renamed from: n */
    final C5960c f9896n;

    /* renamed from: o */
    final HostnameVerifier f9897o;

    /* renamed from: p */
    final C3522g f9898p;

    /* renamed from: q */
    final C3482b f9899q;

    /* renamed from: r */
    final C3482b f9900r;

    /* renamed from: s */
    final C3526j f9901s;

    /* renamed from: t */
    final C5968o f9902t;

    /* renamed from: u */
    final boolean f9903u;

    /* renamed from: v */
    final boolean f9904v;

    /* renamed from: w */
    final boolean f9905w;

    /* renamed from: x */
    final int f9906x;

    /* renamed from: y */
    final int f9907y;

    /* renamed from: z */
    final int f9908z;

    /* renamed from: i.v$a */
    /* compiled from: OkHttpClient */
    class C3543a extends C3499a {
        C3543a() {
        }

        /* renamed from: a */
        public void mo19372a(C3537r.C3538a aVar, String str) {
            aVar.mo19509a(str);
        }

        /* renamed from: b */
        public void mo19376b(C3526j jVar, C3589c cVar) {
            jVar.mo19444b(cVar);
        }

        /* renamed from: a */
        public void mo19373a(C3537r.C3538a aVar, String str, String str2) {
            aVar.mo19512b(str, str2);
        }

        /* renamed from: a */
        public boolean mo19375a(C3526j jVar, C3589c cVar) {
            return jVar.mo19443a(cVar);
        }

        /* renamed from: a */
        public C3589c mo19369a(C3526j jVar, C3479a aVar, C6613f fVar, C3494c0 c0Var) {
            return jVar.mo19442a(aVar, fVar, c0Var);
        }

        /* renamed from: a */
        public boolean mo19374a(C3479a aVar, C3479a aVar2) {
            return aVar.mo19260a(aVar2);
        }

        /* renamed from: a */
        public Socket mo19368a(C3526j jVar, C3479a aVar, C6613f fVar) {
            return jVar.mo19441a(aVar, fVar);
        }

        /* renamed from: a */
        public C6610d mo19370a(C3526j jVar) {
            return jVar.f9814e;
        }

        /* renamed from: a */
        public int mo19366a(C3480a0.C3481a aVar) {
            return aVar.f9623c;
        }

        /* renamed from: a */
        public void mo19371a(C3528k kVar, SSLSocket sSLSocket, boolean z) {
            kVar.mo19447a(sSLSocket, z);
        }

        @Nullable
        /* renamed from: a */
        public IOException mo19367a(C3497e eVar, @Nullable IOException iOException) {
            return ((C3545x) eVar).mo19589a(iOException);
        }
    }

    /* renamed from: i.v$b */
    /* compiled from: OkHttpClient */
    public static final class C3544b {

        /* renamed from: A */
        int f9909A;

        /* renamed from: B */
        int f9910B;

        /* renamed from: a */
        C3531n f9911a;
        @Nullable

        /* renamed from: b */
        Proxy f9912b;

        /* renamed from: c */
        List<C5972w> f9913c;

        /* renamed from: d */
        List<C3528k> f9914d;

        /* renamed from: e */
        final List<C5970t> f9915e;

        /* renamed from: f */
        final List<C5970t> f9916f;

        /* renamed from: g */
        C3532p.C3535c f9917g;

        /* renamed from: h */
        ProxySelector f9918h;

        /* renamed from: i */
        C5966m f9919i;
        @Nullable

        /* renamed from: j */
        C3487c f9920j;
        @Nullable

        /* renamed from: k */
        C5933f f9921k;

        /* renamed from: l */
        SocketFactory f9922l;
        @Nullable

        /* renamed from: m */
        SSLSocketFactory f9923m;
        @Nullable

        /* renamed from: n */
        C5960c f9924n;

        /* renamed from: o */
        HostnameVerifier f9925o;

        /* renamed from: p */
        C3522g f9926p;

        /* renamed from: q */
        C3482b f9927q;

        /* renamed from: r */
        C3482b f9928r;

        /* renamed from: s */
        C3526j f9929s;

        /* renamed from: t */
        C5968o f9930t;

        /* renamed from: u */
        boolean f9931u;

        /* renamed from: v */
        boolean f9932v;

        /* renamed from: w */
        boolean f9933w;

        /* renamed from: x */
        int f9934x;

        /* renamed from: y */
        int f9935y;

        /* renamed from: z */
        int f9936z;

        public C3544b() {
            this.f9915e = new ArrayList();
            this.f9916f = new ArrayList();
            this.f9911a = new C3531n();
            this.f9913c = C3542v.f9879C;
            this.f9914d = C3542v.f9880D;
            this.f9917g = C3532p.m11802a(C3532p.f9849a);
            ProxySelector proxySelector = ProxySelector.getDefault();
            this.f9918h = proxySelector;
            if (proxySelector == null) {
                this.f9918h = new C5957a();
            }
            this.f9919i = C5966m.f15252a;
            this.f9922l = SocketFactory.getDefault();
            this.f9925o = C5961d.f15230a;
            this.f9926p = C3522g.f9801c;
            C3482b bVar = C3482b.f9633a;
            this.f9927q = bVar;
            this.f9928r = bVar;
            this.f9929s = new C3526j();
            this.f9930t = C5968o.f15253a;
            this.f9931u = true;
            this.f9932v = true;
            this.f9933w = true;
            this.f9934x = 0;
            this.f9935y = C6078a.DEFAULT_TIMEOUT;
            this.f9936z = C6078a.DEFAULT_TIMEOUT;
            this.f9909A = C6078a.DEFAULT_TIMEOUT;
            this.f9910B = 0;
        }

        /* renamed from: a */
        public C3544b mo19581a(long j, TimeUnit timeUnit) {
            this.f9935y = C3500c.m11634a("timeout", j, timeUnit);
            return this;
        }

        /* renamed from: b */
        public C3544b mo19586b(long j, TimeUnit timeUnit) {
            this.f9936z = C3500c.m11634a("timeout", j, timeUnit);
            return this;
        }

        /* renamed from: a */
        public C3544b mo19582a(@Nullable C3487c cVar) {
            this.f9920j = cVar;
            this.f9921k = null;
            return this;
        }

        /* renamed from: b */
        public C3544b mo19587b(boolean z) {
            this.f9931u = z;
            return this;
        }

        /* renamed from: a */
        public C3544b mo19584a(boolean z) {
            this.f9932v = z;
            return this;
        }

        /* renamed from: a */
        public C3544b mo19583a(C5970t tVar) {
            if (tVar != null) {
                this.f9915e.add(tVar);
                return this;
            }
            throw new IllegalArgumentException("interceptor == null");
        }

        /* renamed from: a */
        public C3542v mo19585a() {
            return new C3542v(this);
        }

        C3544b(C3542v vVar) {
            this.f9915e = new ArrayList();
            this.f9916f = new ArrayList();
            this.f9911a = vVar.f9883a;
            this.f9912b = vVar.f9884b;
            this.f9913c = vVar.f9885c;
            this.f9914d = vVar.f9886d;
            this.f9915e.addAll(vVar.f9887e);
            this.f9916f.addAll(vVar.f9888f);
            this.f9917g = vVar.f9889g;
            this.f9918h = vVar.f9890h;
            this.f9919i = vVar.f9891i;
            this.f9921k = vVar.f9893k;
            this.f9920j = vVar.f9892j;
            this.f9922l = vVar.f9894l;
            this.f9923m = vVar.f9895m;
            this.f9924n = vVar.f9896n;
            this.f9925o = vVar.f9897o;
            this.f9926p = vVar.f9898p;
            this.f9927q = vVar.f9899q;
            this.f9928r = vVar.f9900r;
            this.f9929s = vVar.f9901s;
            this.f9930t = vVar.f9902t;
            this.f9931u = vVar.f9903u;
            this.f9932v = vVar.f9904v;
            this.f9933w = vVar.f9905w;
            this.f9934x = vVar.f9906x;
            this.f9935y = vVar.f9907y;
            this.f9936z = vVar.f9908z;
            this.f9909A = vVar.f9881A;
            this.f9910B = vVar.f9882B;
        }
    }

    static {
        C3499a.f9700a = new C3543a();
    }

    public C3542v() {
        this(new C3544b());
    }

    /* renamed from: a */
    private static SSLSocketFactory m11903a(X509TrustManager x509TrustManager) {
        try {
            SSLContext b = C3521f.m11740d().mo19415b();
            b.init((KeyManager[]) null, new TrustManager[]{x509TrustManager}, (SecureRandom) null);
            return b.getSocketFactory();
        } catch (GeneralSecurityException e) {
            throw C3500c.m11636a("No System TLS", (Exception) e);
        }
    }

    /* renamed from: A */
    public SSLSocketFactory mo19553A() {
        return this.f9895m;
    }

    /* renamed from: B */
    public int mo19554B() {
        return this.f9881A;
    }

    @Nullable
    /* renamed from: b */
    public C3487c mo19556b() {
        return this.f9892j;
    }

    /* renamed from: c */
    public int mo19557c() {
        return this.f9906x;
    }

    /* renamed from: d */
    public C3522g mo19558d() {
        return this.f9898p;
    }

    /* renamed from: e */
    public int mo19559e() {
        return this.f9907y;
    }

    /* renamed from: f */
    public C3526j mo19560f() {
        return this.f9901s;
    }

    /* renamed from: g */
    public List<C3528k> mo19561g() {
        return this.f9886d;
    }

    /* renamed from: h */
    public C5966m mo19562h() {
        return this.f9891i;
    }

    /* renamed from: i */
    public C3531n mo19563i() {
        return this.f9883a;
    }

    /* renamed from: j */
    public C5968o mo19564j() {
        return this.f9902t;
    }

    /* renamed from: k */
    public C3532p.C3535c mo19565k() {
        return this.f9889g;
    }

    /* renamed from: l */
    public boolean mo19566l() {
        return this.f9904v;
    }

    /* renamed from: m */
    public boolean mo19567m() {
        return this.f9903u;
    }

    /* renamed from: n */
    public HostnameVerifier mo19568n() {
        return this.f9897o;
    }

    /* renamed from: o */
    public List<C5970t> mo19569o() {
        return this.f9887e;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: p */
    public C5933f mo19570p() {
        C3487c cVar = this.f9892j;
        return cVar != null ? cVar.f9641a : this.f9893k;
    }

    /* renamed from: q */
    public List<C5970t> mo19571q() {
        return this.f9888f;
    }

    /* renamed from: r */
    public C3544b mo19572r() {
        return new C3544b(this);
    }

    /* renamed from: s */
    public int mo19573s() {
        return this.f9882B;
    }

    /* renamed from: t */
    public List<C5972w> mo19574t() {
        return this.f9885c;
    }

    @Nullable
    /* renamed from: u */
    public Proxy mo19575u() {
        return this.f9884b;
    }

    /* renamed from: v */
    public C3482b mo19576v() {
        return this.f9899q;
    }

    /* renamed from: w */
    public ProxySelector mo19577w() {
        return this.f9890h;
    }

    /* renamed from: x */
    public int mo19578x() {
        return this.f9908z;
    }

    /* renamed from: y */
    public boolean mo19579y() {
        return this.f9905w;
    }

    /* renamed from: z */
    public SocketFactory mo19580z() {
        return this.f9894l;
    }

    C3542v(C3544b bVar) {
        boolean z;
        this.f9883a = bVar.f9911a;
        this.f9884b = bVar.f9912b;
        this.f9885c = bVar.f9913c;
        this.f9886d = bVar.f9914d;
        this.f9887e = C3500c.m11643a(bVar.f9915e);
        this.f9888f = C3500c.m11643a(bVar.f9916f);
        this.f9889g = bVar.f9917g;
        this.f9890h = bVar.f9918h;
        this.f9891i = bVar.f9919i;
        this.f9892j = bVar.f9920j;
        this.f9893k = bVar.f9921k;
        this.f9894l = bVar.f9922l;
        Iterator<C3528k> it = this.f9886d.iterator();
        loop0:
        while (true) {
            z = false;
            while (true) {
                if (!it.hasNext()) {
                    break loop0;
                }
                C3528k next = it.next();
                if (z || next.mo19449b()) {
                    z = true;
                }
            }
        }
        if (bVar.f9923m != null || !z) {
            this.f9895m = bVar.f9923m;
            this.f9896n = bVar.f9924n;
        } else {
            X509TrustManager a = C3500c.m11647a();
            this.f9895m = m11903a(a);
            this.f9896n = C5960c.m19113a(a);
        }
        if (this.f9895m != null) {
            C3521f.m11740d().mo19425a(this.f9895m);
        }
        this.f9897o = bVar.f9925o;
        this.f9898p = bVar.f9926p.mo19430a(this.f9896n);
        this.f9899q = bVar.f9927q;
        this.f9900r = bVar.f9928r;
        this.f9901s = bVar.f9929s;
        this.f9902t = bVar.f9930t;
        this.f9903u = bVar.f9931u;
        this.f9904v = bVar.f9932v;
        this.f9905w = bVar.f9933w;
        this.f9906x = bVar.f9934x;
        this.f9907y = bVar.f9935y;
        this.f9908z = bVar.f9936z;
        this.f9881A = bVar.f9909A;
        this.f9882B = bVar.f9910B;
        if (this.f9887e.contains((Object) null)) {
            throw new IllegalStateException("Null interceptor: " + this.f9887e);
        } else if (this.f9888f.contains((Object) null)) {
            throw new IllegalStateException("Null network interceptor: " + this.f9888f);
        }
    }

    /* renamed from: a */
    public C3482b mo19555a() {
        return this.f9900r;
    }

    /* renamed from: a */
    public C3497e mo19365a(C3548y yVar) {
        return C3545x.m11952a(this, yVar, false);
    }
}
