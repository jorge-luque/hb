package p093e.p101c.p102a.p103a.p104i;

import java.util.Map;
import p093e.p101c.p102a.p103a.p104i.C3400h;

/* renamed from: e.c.a.a.i.a */
/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
final class C3385a extends C3400h {

    /* renamed from: a */
    private final String f9446a;

    /* renamed from: b */
    private final Integer f9447b;

    /* renamed from: c */
    private final C3399g f9448c;

    /* renamed from: d */
    private final long f9449d;

    /* renamed from: e */
    private final long f9450e;

    /* renamed from: f */
    private final Map<String, String> f9451f;

    /* renamed from: e.c.a.a.i.a$b */
    /* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
    static final class C3387b extends C3400h.C3401a {

        /* renamed from: a */
        private String f9452a;

        /* renamed from: b */
        private Integer f9453b;

        /* renamed from: c */
        private C3399g f9454c;

        /* renamed from: d */
        private Long f9455d;

        /* renamed from: e */
        private Long f9456e;

        /* renamed from: f */
        private Map<String, String> f9457f;

        C3387b() {
        }

        /* renamed from: a */
        public C3400h.C3401a mo19165a(String str) {
            if (str != null) {
                this.f9452a = str;
                return this;
            }
            throw new NullPointerException("Null transportName");
        }

        /* renamed from: b */
        public C3400h.C3401a mo19168b(long j) {
            this.f9456e = Long.valueOf(j);
            return this;
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public Map<String, String> mo19169b() {
            Map<String, String> map = this.f9457f;
            if (map != null) {
                return map;
            }
            throw new IllegalStateException("Property \"autoMetadata\" has not been set");
        }

        /* renamed from: a */
        public C3400h.C3401a mo19164a(Integer num) {
            this.f9453b = num;
            return this;
        }

        /* renamed from: a */
        public C3400h.C3401a mo19163a(C3399g gVar) {
            if (gVar != null) {
                this.f9454c = gVar;
                return this;
            }
            throw new NullPointerException("Null encodedPayload");
        }

        /* renamed from: a */
        public C3400h.C3401a mo19162a(long j) {
            this.f9455d = Long.valueOf(j);
            return this;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public C3400h.C3401a mo19166a(Map<String, String> map) {
            if (map != null) {
                this.f9457f = map;
                return this;
            }
            throw new NullPointerException("Null autoMetadata");
        }

        /* renamed from: a */
        public C3400h mo19167a() {
            String str = "";
            if (this.f9452a == null) {
                str = str + " transportName";
            }
            if (this.f9454c == null) {
                str = str + " encodedPayload";
            }
            if (this.f9455d == null) {
                str = str + " eventMillis";
            }
            if (this.f9456e == null) {
                str = str + " uptimeMillis";
            }
            if (this.f9457f == null) {
                str = str + " autoMetadata";
            }
            if (str.isEmpty()) {
                return new C3385a(this.f9452a, this.f9453b, this.f9454c, this.f9455d.longValue(), this.f9456e.longValue(), this.f9457f);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public Map<String, String> mo19153a() {
        return this.f9451f;
    }

    /* renamed from: b */
    public Integer mo19154b() {
        return this.f9447b;
    }

    /* renamed from: c */
    public C3399g mo19155c() {
        return this.f9448c;
    }

    /* renamed from: d */
    public long mo19156d() {
        return this.f9449d;
    }

    public boolean equals(Object obj) {
        Integer num;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C3400h)) {
            return false;
        }
        C3400h hVar = (C3400h) obj;
        if (!this.f9446a.equals(hVar.mo19158f()) || ((num = this.f9447b) != null ? !num.equals(hVar.mo19154b()) : hVar.mo19154b() != null) || !this.f9448c.equals(hVar.mo19155c()) || this.f9449d != hVar.mo19156d() || this.f9450e != hVar.mo19159g() || !this.f9451f.equals(hVar.mo19153a())) {
            return false;
        }
        return true;
    }

    /* renamed from: f */
    public String mo19158f() {
        return this.f9446a;
    }

    /* renamed from: g */
    public long mo19159g() {
        return this.f9450e;
    }

    public int hashCode() {
        int hashCode = (this.f9446a.hashCode() ^ 1000003) * 1000003;
        Integer num = this.f9447b;
        int hashCode2 = num == null ? 0 : num.hashCode();
        long j = this.f9449d;
        long j2 = this.f9450e;
        return ((((((((hashCode ^ hashCode2) * 1000003) ^ this.f9448c.hashCode()) * 1000003) ^ ((int) (j ^ (j >>> 32)))) * 1000003) ^ ((int) (j2 ^ (j2 >>> 32)))) * 1000003) ^ this.f9451f.hashCode();
    }

    public String toString() {
        return "EventInternal{transportName=" + this.f9446a + ", code=" + this.f9447b + ", encodedPayload=" + this.f9448c + ", eventMillis=" + this.f9449d + ", uptimeMillis=" + this.f9450e + ", autoMetadata=" + this.f9451f + "}";
    }

    private C3385a(String str, Integer num, C3399g gVar, long j, long j2, Map<String, String> map) {
        this.f9446a = str;
        this.f9447b = num;
        this.f9448c = gVar;
        this.f9449d = j;
        this.f9450e = j2;
        this.f9451f = map;
    }
}
