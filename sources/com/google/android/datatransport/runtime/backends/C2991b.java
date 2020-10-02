package com.google.android.datatransport.runtime.backends;

import com.google.android.datatransport.runtime.backends.C2997g;

/* renamed from: com.google.android.datatransport.runtime.backends.b */
/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
final class C2991b extends C2997g {

    /* renamed from: a */
    private final C2997g.C2998a f8344a;

    /* renamed from: b */
    private final long f8345b;

    C2991b(C2997g.C2998a aVar, long j) {
        if (aVar != null) {
            this.f8344a = aVar;
            this.f8345b = j;
            return;
        }
        throw new NullPointerException("Null status");
    }

    /* renamed from: a */
    public long mo12955a() {
        return this.f8345b;
    }

    /* renamed from: b */
    public C2997g.C2998a mo12956b() {
        return this.f8344a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C2997g)) {
            return false;
        }
        C2997g gVar = (C2997g) obj;
        if (!this.f8344a.equals(gVar.mo12956b()) || this.f8345b != gVar.mo12955a()) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        long j = this.f8345b;
        return ((this.f8344a.hashCode() ^ 1000003) * 1000003) ^ ((int) (j ^ (j >>> 32)));
    }

    public String toString() {
        return "BackendResponse{status=" + this.f8344a + ", nextRequestWaitMillis=" + this.f8345b + "}";
    }
}
