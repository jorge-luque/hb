package p163cz.msebera.android.httpclient.client.p167m;

import java.net.InetAddress;
import java.util.Collection;
import p163cz.msebera.android.httpclient.C5896l;

/* renamed from: cz.msebera.android.httpclient.client.m.a */
/* compiled from: RequestConfig */
public class C5587a implements Cloneable {

    /* renamed from: p */
    public static final C5587a f14542p = new C5588a().mo32943a();

    /* renamed from: a */
    private final boolean f14543a;

    /* renamed from: b */
    private final C5896l f14544b;

    /* renamed from: c */
    private final InetAddress f14545c;

    /* renamed from: d */
    private final String f14546d;

    /* renamed from: e */
    private final boolean f14547e;

    /* renamed from: f */
    private final boolean f14548f;

    /* renamed from: g */
    private final boolean f14549g;

    /* renamed from: h */
    private final int f14550h;

    /* renamed from: i */
    private final boolean f14551i;

    /* renamed from: j */
    private final Collection<String> f14552j;

    /* renamed from: k */
    private final Collection<String> f14553k;

    /* renamed from: l */
    private final int f14554l;

    /* renamed from: m */
    private final int f14555m;

    /* renamed from: n */
    private final int f14556n;

    /* renamed from: o */
    private final boolean f14557o;

    /* renamed from: cz.msebera.android.httpclient.client.m.a$a */
    /* compiled from: RequestConfig */
    public static class C5588a {

        /* renamed from: a */
        private boolean f14558a;

        /* renamed from: b */
        private C5896l f14559b;

        /* renamed from: c */
        private InetAddress f14560c;

        /* renamed from: d */
        private boolean f14561d = false;

        /* renamed from: e */
        private String f14562e;

        /* renamed from: f */
        private boolean f14563f = true;

        /* renamed from: g */
        private boolean f14564g = true;

        /* renamed from: h */
        private boolean f14565h;

        /* renamed from: i */
        private int f14566i = 50;

        /* renamed from: j */
        private boolean f14567j = true;

        /* renamed from: k */
        private Collection<String> f14568k;

        /* renamed from: l */
        private Collection<String> f14569l;

        /* renamed from: m */
        private int f14570m = -1;

        /* renamed from: n */
        private int f14571n = -1;

        /* renamed from: o */
        private int f14572o = -1;

        /* renamed from: p */
        private boolean f14573p = true;

        C5588a() {
        }

        /* renamed from: a */
        public C5588a mo32938a(C5896l lVar) {
            this.f14559b = lVar;
            return this;
        }

        /* renamed from: b */
        public C5588a mo32946b(boolean z) {
            this.f14565h = z;
            return this;
        }

        /* renamed from: c */
        public C5588a mo32948c(boolean z) {
            this.f14558a = z;
            return this;
        }

        /* renamed from: d */
        public C5588a mo32950d(boolean z) {
            this.f14563f = z;
            return this;
        }

        /* renamed from: e */
        public C5588a mo32951e(boolean z) {
            this.f14564g = z;
            return this;
        }

        @Deprecated
        /* renamed from: f */
        public C5588a mo32952f(boolean z) {
            this.f14561d = z;
            return this;
        }

        /* renamed from: a */
        public C5588a mo32940a(InetAddress inetAddress) {
            this.f14560c = inetAddress;
            return this;
        }

        /* renamed from: b */
        public C5588a mo32945b(Collection<String> collection) {
            this.f14568k = collection;
            return this;
        }

        /* renamed from: c */
        public C5588a mo32947c(int i) {
            this.f14566i = i;
            return this;
        }

        /* renamed from: d */
        public C5588a mo32949d(int i) {
            this.f14572o = i;
            return this;
        }

        /* renamed from: a */
        public C5588a mo32939a(String str) {
            this.f14562e = str;
            return this;
        }

        /* renamed from: b */
        public C5588a mo32944b(int i) {
            this.f14570m = i;
            return this;
        }

        /* renamed from: a */
        public C5588a mo32942a(boolean z) {
            this.f14567j = z;
            return this;
        }

        /* renamed from: a */
        public C5588a mo32941a(Collection<String> collection) {
            this.f14569l = collection;
            return this;
        }

        /* renamed from: a */
        public C5588a mo32937a(int i) {
            this.f14571n = i;
            return this;
        }

        /* renamed from: a */
        public C5587a mo32943a() {
            return new C5587a(this.f14558a, this.f14559b, this.f14560c, this.f14561d, this.f14562e, this.f14563f, this.f14564g, this.f14565h, this.f14566i, this.f14567j, this.f14568k, this.f14569l, this.f14570m, this.f14571n, this.f14572o, this.f14573p);
        }
    }

    C5587a(boolean z, C5896l lVar, InetAddress inetAddress, boolean z2, String str, boolean z3, boolean z4, boolean z5, int i, boolean z6, Collection<String> collection, Collection<String> collection2, int i2, int i3, int i4, boolean z7) {
        this.f14543a = z;
        this.f14544b = lVar;
        this.f14545c = inetAddress;
        this.f14546d = str;
        this.f14547e = z3;
        this.f14548f = z4;
        this.f14549g = z5;
        this.f14550h = i;
        this.f14551i = z6;
        this.f14552j = collection;
        this.f14553k = collection2;
        this.f14554l = i2;
        this.f14555m = i3;
        this.f14556n = i4;
        this.f14557o = z7;
    }

    /* renamed from: f */
    public static C5588a m17800f() {
        return new C5588a();
    }

    /* renamed from: a */
    public String mo32930a() {
        return this.f14546d;
    }

    /* renamed from: b */
    public Collection<String> mo32931b() {
        return this.f14553k;
    }

    /* renamed from: c */
    public Collection<String> mo32932c() {
        return this.f14552j;
    }

    /* renamed from: d */
    public boolean mo32934d() {
        return this.f14549g;
    }

    /* renamed from: e */
    public boolean mo32935e() {
        return this.f14548f;
    }

    public String toString() {
        return "[" + "expectContinueEnabled=" + this.f14543a + ", proxy=" + this.f14544b + ", localAddress=" + this.f14545c + ", cookieSpec=" + this.f14546d + ", redirectsEnabled=" + this.f14547e + ", relativeRedirectsAllowed=" + this.f14548f + ", maxRedirects=" + this.f14550h + ", circularRedirectsAllowed=" + this.f14549g + ", authenticationEnabled=" + this.f14551i + ", targetPreferredAuthSchemes=" + this.f14552j + ", proxyPreferredAuthSchemes=" + this.f14553k + ", connectionRequestTimeout=" + this.f14554l + ", connectTimeout=" + this.f14555m + ", socketTimeout=" + this.f14556n + ", decompressionEnabled=" + this.f14557o + "]";
    }

    /* access modifiers changed from: protected */
    public C5587a clone() throws CloneNotSupportedException {
        return (C5587a) super.clone();
    }
}
