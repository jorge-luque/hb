package com.google.android.datatransport.cct.p070b;

/* renamed from: com.google.android.datatransport.cct.b.i */
/* compiled from: com.google.android.datatransport:transport-backend-cct@@2.2.0 */
final class C2959i extends C2976t {

    /* renamed from: a */
    private final long f8275a;

    C2959i(long j) {
        this.f8275a = j;
    }

    /* renamed from: a */
    public long mo12925a() {
        return this.f8275a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C2976t) || this.f8275a != ((C2976t) obj).mo12925a()) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        long j = this.f8275a;
        return 1000003 ^ ((int) (j ^ (j >>> 32)));
    }

    public String toString() {
        return "LogResponse{nextRequestWaitMillis=" + this.f8275a + "}";
    }
}
