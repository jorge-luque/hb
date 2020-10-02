package com.google.android.datatransport.cct.p070b;

import com.google.android.datatransport.cct.p070b.C2965m;

/* renamed from: com.google.android.datatransport.cct.b.f */
/* compiled from: com.google.android.datatransport:transport-backend-cct@@2.2.0 */
final class C2950f extends C2965m {

    /* renamed from: a */
    private final C2965m.C2967b f8243a;

    /* renamed from: b */
    private final C2942a f8244b;

    /* renamed from: com.google.android.datatransport.cct.b.f$b */
    /* compiled from: com.google.android.datatransport:transport-backend-cct@@2.2.0 */
    static final class C2952b extends C2965m.C2966a {

        /* renamed from: a */
        private C2965m.C2967b f8245a;

        /* renamed from: b */
        private C2942a f8246b;

        C2952b() {
        }

        /* renamed from: a */
        public C2965m.C2966a mo12888a(C2965m.C2967b bVar) {
            this.f8245a = bVar;
            return this;
        }

        /* renamed from: a */
        public C2965m.C2966a mo12887a(C2942a aVar) {
            this.f8246b = aVar;
            return this;
        }

        /* renamed from: a */
        public C2965m mo12889a() {
            return new C2950f(this.f8245a, this.f8246b, (C2951a) null);
        }
    }

    /* synthetic */ C2950f(C2965m.C2967b bVar, C2942a aVar, C2951a aVar2) {
        this.f8243a = bVar;
        this.f8244b = aVar;
    }

    /* renamed from: b */
    public C2942a mo12882b() {
        return this.f8244b;
    }

    /* renamed from: c */
    public C2965m.C2967b mo12883c() {
        return this.f8243a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C2965m)) {
            return false;
        }
        C2965m.C2967b bVar = this.f8243a;
        if (bVar != null ? bVar.equals(((C2950f) obj).f8243a) : ((C2950f) obj).f8243a == null) {
            C2942a aVar = this.f8244b;
            if (aVar == null) {
                if (((C2950f) obj).f8244b == null) {
                    return true;
                }
            } else if (aVar.equals(((C2950f) obj).f8244b)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        C2965m.C2967b bVar = this.f8243a;
        int i = 0;
        int hashCode = ((bVar == null ? 0 : bVar.hashCode()) ^ 1000003) * 1000003;
        C2942a aVar = this.f8244b;
        if (aVar != null) {
            i = aVar.hashCode();
        }
        return hashCode ^ i;
    }

    public String toString() {
        return "ClientInfo{clientType=" + this.f8243a + ", androidClientInfo=" + this.f8244b + "}";
    }
}
