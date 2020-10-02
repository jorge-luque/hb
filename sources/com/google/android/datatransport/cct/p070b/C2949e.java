package com.google.android.datatransport.cct.p070b;

import java.util.List;

/* renamed from: com.google.android.datatransport.cct.b.e */
/* compiled from: com.google.android.datatransport:transport-backend-cct@@2.2.0 */
final class C2949e extends C2963k {

    /* renamed from: a */
    private final List<C2973r> f8242a;

    C2949e(List<C2973r> list) {
        if (list != null) {
            this.f8242a = list;
            return;
        }
        throw new NullPointerException("Null logRequests");
    }

    /* renamed from: a */
    public List<C2973r> mo12878a() {
        return this.f8242a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof C2963k) {
            return this.f8242a.equals(((C2963k) obj).mo12878a());
        }
        return false;
    }

    public int hashCode() {
        return this.f8242a.hashCode() ^ 1000003;
    }

    public String toString() {
        return "BatchedLogRequest{logRequests=" + this.f8242a + "}";
    }
}
