package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import com.google.android.datatransport.runtime.scheduling.jobscheduling.C3014g;
import java.util.Set;

/* renamed from: com.google.android.datatransport.runtime.scheduling.jobscheduling.d */
/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
final class C3009d extends C3014g.C3016b {

    /* renamed from: a */
    private final long f8374a;

    /* renamed from: b */
    private final long f8375b;

    /* renamed from: c */
    private final Set<C3014g.C3018c> f8376c;

    /* renamed from: com.google.android.datatransport.runtime.scheduling.jobscheduling.d$b */
    /* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
    static final class C3011b extends C3014g.C3016b.C3017a {

        /* renamed from: a */
        private Long f8377a;

        /* renamed from: b */
        private Long f8378b;

        /* renamed from: c */
        private Set<C3014g.C3018c> f8379c;

        C3011b() {
        }

        /* renamed from: a */
        public C3014g.C3016b.C3017a mo12988a(long j) {
            this.f8377a = Long.valueOf(j);
            return this;
        }

        /* renamed from: b */
        public C3014g.C3016b.C3017a mo12991b(long j) {
            this.f8378b = Long.valueOf(j);
            return this;
        }

        /* renamed from: a */
        public C3014g.C3016b.C3017a mo12989a(Set<C3014g.C3018c> set) {
            if (set != null) {
                this.f8379c = set;
                return this;
            }
            throw new NullPointerException("Null flags");
        }

        /* renamed from: a */
        public C3014g.C3016b mo12990a() {
            String str = "";
            if (this.f8377a == null) {
                str = str + " delta";
            }
            if (this.f8378b == null) {
                str = str + " maxAllowedDelay";
            }
            if (this.f8379c == null) {
                str = str + " flags";
            }
            if (str.isEmpty()) {
                return new C3009d(this.f8377a.longValue(), this.f8378b.longValue(), this.f8379c);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public long mo12982a() {
        return this.f8374a;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public Set<C3014g.C3018c> mo12983b() {
        return this.f8376c;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public long mo12984c() {
        return this.f8375b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C3014g.C3016b)) {
            return false;
        }
        C3014g.C3016b bVar = (C3014g.C3016b) obj;
        if (this.f8374a == bVar.mo12982a() && this.f8375b == bVar.mo12984c() && this.f8376c.equals(bVar.mo12983b())) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        long j = this.f8374a;
        long j2 = this.f8375b;
        return this.f8376c.hashCode() ^ ((((((int) (j ^ (j >>> 32))) ^ 1000003) * 1000003) ^ ((int) (j2 ^ (j2 >>> 32)))) * 1000003);
    }

    public String toString() {
        return "ConfigValue{delta=" + this.f8374a + ", maxAllowedDelay=" + this.f8375b + ", flags=" + this.f8376c + "}";
    }

    private C3009d(long j, long j2, Set<C3014g.C3018c> set) {
        this.f8374a = j;
        this.f8375b = j2;
        this.f8376c = set;
    }
}
