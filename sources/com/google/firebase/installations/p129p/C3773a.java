package com.google.firebase.installations.p129p;

import com.google.firebase.installations.p129p.C3777c;
import com.google.firebase.installations.p129p.C3779d;

/* renamed from: com.google.firebase.installations.p.a */
/* compiled from: com.google.firebase:firebase-installations@@16.3.0 */
final class C3773a extends C3779d {

    /* renamed from: a */
    private final String f10444a;

    /* renamed from: b */
    private final C3777c.C3778a f10445b;

    /* renamed from: c */
    private final String f10446c;

    /* renamed from: d */
    private final String f10447d;

    /* renamed from: e */
    private final long f10448e;

    /* renamed from: f */
    private final long f10449f;

    /* renamed from: g */
    private final String f10450g;

    /* renamed from: com.google.firebase.installations.p.a$b */
    /* compiled from: com.google.firebase:firebase-installations@@16.3.0 */
    static final class C3775b extends C3779d.C3780a {

        /* renamed from: a */
        private String f10451a;

        /* renamed from: b */
        private C3777c.C3778a f10452b;

        /* renamed from: c */
        private String f10453c;

        /* renamed from: d */
        private String f10454d;

        /* renamed from: e */
        private Long f10455e;

        /* renamed from: f */
        private Long f10456f;

        /* renamed from: g */
        private String f10457g;

        /* renamed from: a */
        public C3779d.C3780a mo27425a(C3777c.C3778a aVar) {
            if (aVar != null) {
                this.f10452b = aVar;
                return this;
            }
            throw new NullPointerException("Null registrationStatus");
        }

        /* renamed from: b */
        public C3779d.C3780a mo27429b(String str) {
            this.f10451a = str;
            return this;
        }

        /* renamed from: c */
        public C3779d.C3780a mo27430c(String str) {
            this.f10457g = str;
            return this;
        }

        /* renamed from: d */
        public C3779d.C3780a mo27431d(String str) {
            this.f10454d = str;
            return this;
        }

        C3775b() {
        }

        /* renamed from: b */
        public C3779d.C3780a mo27428b(long j) {
            this.f10456f = Long.valueOf(j);
            return this;
        }

        private C3775b(C3779d dVar) {
            this.f10451a = dVar.mo27415c();
            this.f10452b = dVar.mo27419f();
            this.f10453c = dVar.mo27413a();
            this.f10454d = dVar.mo27417e();
            this.f10455e = Long.valueOf(dVar.mo27414b());
            this.f10456f = Long.valueOf(dVar.mo27420g());
            this.f10457g = dVar.mo27416d();
        }

        /* renamed from: a */
        public C3779d.C3780a mo27426a(String str) {
            this.f10453c = str;
            return this;
        }

        /* renamed from: a */
        public C3779d.C3780a mo27424a(long j) {
            this.f10455e = Long.valueOf(j);
            return this;
        }

        /* renamed from: a */
        public C3779d mo27427a() {
            String str = "";
            if (this.f10452b == null) {
                str = str + " registrationStatus";
            }
            if (this.f10455e == null) {
                str = str + " expiresInSecs";
            }
            if (this.f10456f == null) {
                str = str + " tokenCreationEpochInSecs";
            }
            if (str.isEmpty()) {
                return new C3773a(this.f10451a, this.f10452b, this.f10453c, this.f10454d, this.f10455e.longValue(), this.f10456f.longValue(), this.f10457g);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }
    }

    /* renamed from: a */
    public String mo27413a() {
        return this.f10446c;
    }

    /* renamed from: b */
    public long mo27414b() {
        return this.f10448e;
    }

    /* renamed from: c */
    public String mo27415c() {
        return this.f10444a;
    }

    /* renamed from: d */
    public String mo27416d() {
        return this.f10450g;
    }

    /* renamed from: e */
    public String mo27417e() {
        return this.f10447d;
    }

    public boolean equals(Object obj) {
        String str;
        String str2;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C3779d)) {
            return false;
        }
        C3779d dVar = (C3779d) obj;
        String str3 = this.f10444a;
        if (str3 != null ? str3.equals(dVar.mo27415c()) : dVar.mo27415c() == null) {
            if (this.f10445b.equals(dVar.mo27419f()) && ((str = this.f10446c) != null ? str.equals(dVar.mo27413a()) : dVar.mo27413a() == null) && ((str2 = this.f10447d) != null ? str2.equals(dVar.mo27417e()) : dVar.mo27417e() == null) && this.f10448e == dVar.mo27414b() && this.f10449f == dVar.mo27420g()) {
                String str4 = this.f10450g;
                if (str4 == null) {
                    if (dVar.mo27416d() == null) {
                        return true;
                    }
                } else if (str4.equals(dVar.mo27416d())) {
                    return true;
                }
            }
        }
        return false;
    }

    /* renamed from: f */
    public C3777c.C3778a mo27419f() {
        return this.f10445b;
    }

    /* renamed from: g */
    public long mo27420g() {
        return this.f10449f;
    }

    public int hashCode() {
        String str = this.f10444a;
        int i = 0;
        int hashCode = ((((str == null ? 0 : str.hashCode()) ^ 1000003) * 1000003) ^ this.f10445b.hashCode()) * 1000003;
        String str2 = this.f10446c;
        int hashCode2 = (hashCode ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
        String str3 = this.f10447d;
        int hashCode3 = str3 == null ? 0 : str3.hashCode();
        long j = this.f10448e;
        long j2 = this.f10449f;
        int i2 = (((((hashCode2 ^ hashCode3) * 1000003) ^ ((int) (j ^ (j >>> 32)))) * 1000003) ^ ((int) (j2 ^ (j2 >>> 32)))) * 1000003;
        String str4 = this.f10450g;
        if (str4 != null) {
            i = str4.hashCode();
        }
        return i2 ^ i;
    }

    /* renamed from: m */
    public C3779d.C3780a mo27422m() {
        return new C3775b(this);
    }

    public String toString() {
        return "PersistedInstallationEntry{firebaseInstallationId=" + this.f10444a + ", registrationStatus=" + this.f10445b + ", authToken=" + this.f10446c + ", refreshToken=" + this.f10447d + ", expiresInSecs=" + this.f10448e + ", tokenCreationEpochInSecs=" + this.f10449f + ", fisError=" + this.f10450g + "}";
    }

    private C3773a(String str, C3777c.C3778a aVar, String str2, String str3, long j, long j2, String str4) {
        this.f10444a = str;
        this.f10445b = aVar;
        this.f10446c = str2;
        this.f10447d = str3;
        this.f10448e = j;
        this.f10449f = j2;
        this.f10450g = str4;
    }
}
