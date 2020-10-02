package p093e.p101c.p102a.p103a.p104i;

import p093e.p101c.p102a.p103a.C3378b;
import p093e.p101c.p102a.p103a.C3379c;
import p093e.p101c.p102a.p103a.C3381e;
import p093e.p101c.p102a.p103a.p104i.C3404k;

/* renamed from: e.c.a.a.i.b */
/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
final class C3388b extends C3404k {

    /* renamed from: a */
    private final C3406l f9458a;

    /* renamed from: b */
    private final String f9459b;

    /* renamed from: c */
    private final C3379c<?> f9460c;

    /* renamed from: d */
    private final C3381e<?, byte[]> f9461d;

    /* renamed from: e */
    private final C3378b f9462e;

    /* renamed from: a */
    public C3378b mo19170a() {
        return this.f9462e;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public C3379c<?> mo19171b() {
        return this.f9460c;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public C3381e<?, byte[]> mo19172d() {
        return this.f9461d;
    }

    /* renamed from: e */
    public C3406l mo19173e() {
        return this.f9458a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C3404k)) {
            return false;
        }
        C3404k kVar = (C3404k) obj;
        if (!this.f9458a.equals(kVar.mo19173e()) || !this.f9459b.equals(kVar.mo19175f()) || !this.f9460c.equals(kVar.mo19171b()) || !this.f9461d.equals(kVar.mo19172d()) || !this.f9462e.equals(kVar.mo19170a())) {
            return false;
        }
        return true;
    }

    /* renamed from: f */
    public String mo19175f() {
        return this.f9459b;
    }

    public int hashCode() {
        return ((((((((this.f9458a.hashCode() ^ 1000003) * 1000003) ^ this.f9459b.hashCode()) * 1000003) ^ this.f9460c.hashCode()) * 1000003) ^ this.f9461d.hashCode()) * 1000003) ^ this.f9462e.hashCode();
    }

    public String toString() {
        return "SendRequest{transportContext=" + this.f9458a + ", transportName=" + this.f9459b + ", event=" + this.f9460c + ", transformer=" + this.f9461d + ", encoding=" + this.f9462e + "}";
    }

    /* renamed from: e.c.a.a.i.b$b */
    /* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
    static final class C3390b extends C3404k.C3405a {

        /* renamed from: a */
        private C3406l f9463a;

        /* renamed from: b */
        private String f9464b;

        /* renamed from: c */
        private C3379c<?> f9465c;

        /* renamed from: d */
        private C3381e<?, byte[]> f9466d;

        /* renamed from: e */
        private C3378b f9467e;

        C3390b() {
        }

        /* renamed from: a */
        public C3404k.C3405a mo19181a(C3406l lVar) {
            if (lVar != null) {
                this.f9463a = lVar;
                return this;
            }
            throw new NullPointerException("Null transportContext");
        }

        /* renamed from: a */
        public C3404k.C3405a mo19182a(String str) {
            if (str != null) {
                this.f9464b = str;
                return this;
            }
            throw new NullPointerException("Null transportName");
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public C3404k.C3405a mo19179a(C3379c<?> cVar) {
            if (cVar != null) {
                this.f9465c = cVar;
                return this;
            }
            throw new NullPointerException("Null event");
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public C3404k.C3405a mo19180a(C3381e<?, byte[]> eVar) {
            if (eVar != null) {
                this.f9466d = eVar;
                return this;
            }
            throw new NullPointerException("Null transformer");
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public C3404k.C3405a mo19178a(C3378b bVar) {
            if (bVar != null) {
                this.f9467e = bVar;
                return this;
            }
            throw new NullPointerException("Null encoding");
        }

        /* renamed from: a */
        public C3404k mo19183a() {
            String str = "";
            if (this.f9463a == null) {
                str = str + " transportContext";
            }
            if (this.f9464b == null) {
                str = str + " transportName";
            }
            if (this.f9465c == null) {
                str = str + " event";
            }
            if (this.f9466d == null) {
                str = str + " transformer";
            }
            if (this.f9467e == null) {
                str = str + " encoding";
            }
            if (str.isEmpty()) {
                return new C3388b(this.f9463a, this.f9464b, this.f9465c, this.f9466d, this.f9467e);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }
    }

    private C3388b(C3406l lVar, String str, C3379c<?> cVar, C3381e<?, byte[]> eVar, C3378b bVar) {
        this.f9458a = lVar;
        this.f9459b = str;
        this.f9460c = cVar;
        this.f9461d = eVar;
        this.f9462e = bVar;
    }
}
