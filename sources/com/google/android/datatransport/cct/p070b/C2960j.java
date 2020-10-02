package com.google.android.datatransport.cct.p070b;

import com.google.android.datatransport.cct.p070b.C2977u;

/* renamed from: com.google.android.datatransport.cct.b.j */
/* compiled from: com.google.android.datatransport:transport-backend-cct@@2.2.0 */
final class C2960j extends C2977u {

    /* renamed from: a */
    private final C2977u.C2980c f8276a;

    /* renamed from: b */
    private final C2977u.C2979b f8277b;

    /* renamed from: com.google.android.datatransport.cct.b.j$b */
    /* compiled from: com.google.android.datatransport:transport-backend-cct@@2.2.0 */
    static final class C2962b extends C2977u.C2978a {

        /* renamed from: a */
        private C2977u.C2980c f8278a;

        /* renamed from: b */
        private C2977u.C2979b f8279b;

        C2962b() {
        }

        /* renamed from: a */
        public C2977u.C2978a mo12935a(C2977u.C2980c cVar) {
            this.f8278a = cVar;
            return this;
        }

        /* renamed from: a */
        public C2977u.C2978a mo12934a(C2977u.C2979b bVar) {
            this.f8279b = bVar;
            return this;
        }

        /* renamed from: a */
        public C2977u mo12936a() {
            return new C2960j(this.f8278a, this.f8279b, (C2961a) null);
        }
    }

    /* synthetic */ C2960j(C2977u.C2980c cVar, C2977u.C2979b bVar, C2961a aVar) {
        this.f8276a = cVar;
        this.f8277b = bVar;
    }

    /* renamed from: b */
    public C2977u.C2979b mo12929b() {
        return this.f8277b;
    }

    /* renamed from: c */
    public C2977u.C2980c mo12930c() {
        return this.f8276a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C2977u)) {
            return false;
        }
        C2977u.C2980c cVar = this.f8276a;
        if (cVar != null ? cVar.equals(((C2960j) obj).f8276a) : ((C2960j) obj).f8276a == null) {
            C2977u.C2979b bVar = this.f8277b;
            if (bVar == null) {
                if (((C2960j) obj).f8277b == null) {
                    return true;
                }
            } else if (bVar.equals(((C2960j) obj).f8277b)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        C2977u.C2980c cVar = this.f8276a;
        int i = 0;
        int hashCode = ((cVar == null ? 0 : cVar.hashCode()) ^ 1000003) * 1000003;
        C2977u.C2979b bVar = this.f8277b;
        if (bVar != null) {
            i = bVar.hashCode();
        }
        return hashCode ^ i;
    }

    public String toString() {
        return "NetworkConnectionInfo{networkType=" + this.f8276a + ", mobileSubtype=" + this.f8277b + "}";
    }
}
