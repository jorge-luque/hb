package com.google.firebase.installations.p130q;

import com.google.firebase.installations.p130q.C3788d;

/* renamed from: com.google.firebase.installations.q.a */
/* compiled from: com.google.firebase:firebase-installations@@16.3.0 */
final class C3781a extends C3788d {

    /* renamed from: a */
    private final String f10469a;

    /* renamed from: b */
    private final String f10470b;

    /* renamed from: c */
    private final String f10471c;

    /* renamed from: d */
    private final C3791e f10472d;

    /* renamed from: e */
    private final C3788d.C3790b f10473e;

    /* renamed from: com.google.firebase.installations.q.a$b */
    /* compiled from: com.google.firebase:firebase-installations@@16.3.0 */
    static final class C3783b extends C3788d.C3789a {

        /* renamed from: a */
        private String f10474a;

        /* renamed from: b */
        private String f10475b;

        /* renamed from: c */
        private String f10476c;

        /* renamed from: d */
        private C3791e f10477d;

        /* renamed from: e */
        private C3788d.C3790b f10478e;

        C3783b() {
        }

        /* renamed from: a */
        public C3788d.C3789a mo27457a(String str) {
            this.f10475b = str;
            return this;
        }

        /* renamed from: b */
        public C3788d.C3789a mo27459b(String str) {
            this.f10476c = str;
            return this;
        }

        /* renamed from: c */
        public C3788d.C3789a mo27460c(String str) {
            this.f10474a = str;
            return this;
        }

        /* renamed from: a */
        public C3788d.C3789a mo27456a(C3791e eVar) {
            this.f10477d = eVar;
            return this;
        }

        /* renamed from: a */
        public C3788d.C3789a mo27455a(C3788d.C3790b bVar) {
            this.f10478e = bVar;
            return this;
        }

        /* renamed from: a */
        public C3788d mo27458a() {
            return new C3781a(this.f10474a, this.f10475b, this.f10476c, this.f10477d, this.f10478e);
        }
    }

    /* renamed from: a */
    public C3791e mo27447a() {
        return this.f10472d;
    }

    /* renamed from: b */
    public String mo27448b() {
        return this.f10470b;
    }

    /* renamed from: c */
    public String mo27449c() {
        return this.f10471c;
    }

    /* renamed from: d */
    public C3788d.C3790b mo27450d() {
        return this.f10473e;
    }

    /* renamed from: e */
    public String mo27451e() {
        return this.f10469a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C3788d)) {
            return false;
        }
        C3788d dVar = (C3788d) obj;
        String str = this.f10469a;
        if (str != null ? str.equals(dVar.mo27451e()) : dVar.mo27451e() == null) {
            String str2 = this.f10470b;
            if (str2 != null ? str2.equals(dVar.mo27448b()) : dVar.mo27448b() == null) {
                String str3 = this.f10471c;
                if (str3 != null ? str3.equals(dVar.mo27449c()) : dVar.mo27449c() == null) {
                    C3791e eVar = this.f10472d;
                    if (eVar != null ? eVar.equals(dVar.mo27447a()) : dVar.mo27447a() == null) {
                        C3788d.C3790b bVar = this.f10473e;
                        if (bVar == null) {
                            if (dVar.mo27450d() == null) {
                                return true;
                            }
                        } else if (bVar.equals(dVar.mo27450d())) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public int hashCode() {
        String str = this.f10469a;
        int i = 0;
        int hashCode = ((str == null ? 0 : str.hashCode()) ^ 1000003) * 1000003;
        String str2 = this.f10470b;
        int hashCode2 = (hashCode ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
        String str3 = this.f10471c;
        int hashCode3 = (hashCode2 ^ (str3 == null ? 0 : str3.hashCode())) * 1000003;
        C3791e eVar = this.f10472d;
        int hashCode4 = (hashCode3 ^ (eVar == null ? 0 : eVar.hashCode())) * 1000003;
        C3788d.C3790b bVar = this.f10473e;
        if (bVar != null) {
            i = bVar.hashCode();
        }
        return hashCode4 ^ i;
    }

    public String toString() {
        return "InstallationResponse{uri=" + this.f10469a + ", fid=" + this.f10470b + ", refreshToken=" + this.f10471c + ", authToken=" + this.f10472d + ", responseCode=" + this.f10473e + "}";
    }

    private C3781a(String str, String str2, String str3, C3791e eVar, C3788d.C3790b bVar) {
        this.f10469a = str;
        this.f10470b = str2;
        this.f10471c = str3;
        this.f10472d = eVar;
        this.f10473e = bVar;
    }
}
