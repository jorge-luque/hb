package p093e.p101c.p102a.p103a.p104i.p107v.p108j;

import p093e.p101c.p102a.p103a.p104i.p107v.p108j.C3437d;

/* renamed from: e.c.a.a.i.v.j.a */
/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
final class C3429a extends C3437d {

    /* renamed from: b */
    private final long f9532b;

    /* renamed from: c */
    private final int f9533c;

    /* renamed from: d */
    private final int f9534d;

    /* renamed from: e */
    private final long f9535e;

    /* renamed from: e.c.a.a.i.v.j.a$b */
    /* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
    static final class C3431b extends C3437d.C3438a {

        /* renamed from: a */
        private Long f9536a;

        /* renamed from: b */
        private Integer f9537b;

        /* renamed from: c */
        private Integer f9538c;

        /* renamed from: d */
        private Long f9539d;

        C3431b() {
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public C3437d.C3438a mo19227a(int i) {
            this.f9538c = Integer.valueOf(i);
            return this;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public C3437d.C3438a mo19231b(long j) {
            this.f9536a = Long.valueOf(j);
            return this;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public C3437d.C3438a mo19228a(long j) {
            this.f9539d = Long.valueOf(j);
            return this;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public C3437d.C3438a mo19230b(int i) {
            this.f9537b = Integer.valueOf(i);
            return this;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public C3437d mo19229a() {
            String str = "";
            if (this.f9536a == null) {
                str = str + " maxStorageSizeInBytes";
            }
            if (this.f9537b == null) {
                str = str + " loadBatchSize";
            }
            if (this.f9538c == null) {
                str = str + " criticalSectionEnterTimeoutMs";
            }
            if (this.f9539d == null) {
                str = str + " eventCleanUpAge";
            }
            if (str.isEmpty()) {
                return new C3429a(this.f9536a.longValue(), this.f9537b.intValue(), this.f9538c.intValue(), this.f9539d.longValue());
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public int mo19220a() {
        return this.f9534d;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public long mo19221b() {
        return this.f9535e;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public int mo19222c() {
        return this.f9533c;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public long mo19223d() {
        return this.f9532b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C3437d)) {
            return false;
        }
        C3437d dVar = (C3437d) obj;
        if (this.f9532b == dVar.mo19223d() && this.f9533c == dVar.mo19222c() && this.f9534d == dVar.mo19220a() && this.f9535e == dVar.mo19221b()) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        long j = this.f9532b;
        long j2 = this.f9535e;
        return ((int) (j2 ^ (j2 >>> 32))) ^ ((((((((int) (j ^ (j >>> 32))) ^ 1000003) * 1000003) ^ this.f9533c) * 1000003) ^ this.f9534d) * 1000003);
    }

    public String toString() {
        return "EventStoreConfig{maxStorageSizeInBytes=" + this.f9532b + ", loadBatchSize=" + this.f9533c + ", criticalSectionEnterTimeoutMs=" + this.f9534d + ", eventCleanUpAge=" + this.f9535e + "}";
    }

    private C3429a(long j, int i, int i2, long j2) {
        this.f9532b = j;
        this.f9533c = i;
        this.f9534d = i2;
        this.f9535e = j2;
    }
}
