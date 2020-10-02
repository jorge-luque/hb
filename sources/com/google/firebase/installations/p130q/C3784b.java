package com.google.firebase.installations.p130q;

import com.google.firebase.installations.p130q.C3791e;

/* renamed from: com.google.firebase.installations.q.b */
/* compiled from: com.google.firebase:firebase-installations@@16.3.0 */
final class C3784b extends C3791e {

    /* renamed from: a */
    private final String f10479a;

    /* renamed from: b */
    private final long f10480b;

    /* renamed from: c */
    private final C3791e.C3793b f10481c;

    /* renamed from: com.google.firebase.installations.q.b$b */
    /* compiled from: com.google.firebase:firebase-installations@@16.3.0 */
    static final class C3786b extends C3791e.C3792a {

        /* renamed from: a */
        private String f10482a;

        /* renamed from: b */
        private Long f10483b;

        /* renamed from: c */
        private C3791e.C3793b f10484c;

        C3786b() {
        }

        /* renamed from: a */
        public C3791e.C3792a mo27469a(String str) {
            this.f10482a = str;
            return this;
        }

        /* renamed from: a */
        public C3791e.C3792a mo27467a(long j) {
            this.f10483b = Long.valueOf(j);
            return this;
        }

        /* renamed from: a */
        public C3791e.C3792a mo27468a(C3791e.C3793b bVar) {
            this.f10484c = bVar;
            return this;
        }

        /* renamed from: a */
        public C3791e mo27470a() {
            String str = "";
            if (this.f10483b == null) {
                str = str + " tokenExpirationTimestamp";
            }
            if (str.isEmpty()) {
                return new C3784b(this.f10482a, this.f10483b.longValue(), this.f10484c);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }
    }

    /* renamed from: a */
    public C3791e.C3793b mo27461a() {
        return this.f10481c;
    }

    /* renamed from: b */
    public String mo27462b() {
        return this.f10479a;
    }

    /* renamed from: c */
    public long mo27463c() {
        return this.f10480b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C3791e)) {
            return false;
        }
        C3791e eVar = (C3791e) obj;
        String str = this.f10479a;
        if (str != null ? str.equals(eVar.mo27462b()) : eVar.mo27462b() == null) {
            if (this.f10480b == eVar.mo27463c()) {
                C3791e.C3793b bVar = this.f10481c;
                if (bVar == null) {
                    if (eVar.mo27461a() == null) {
                        return true;
                    }
                } else if (bVar.equals(eVar.mo27461a())) {
                    return true;
                }
            }
        }
        return false;
    }

    public int hashCode() {
        String str = this.f10479a;
        int i = 0;
        int hashCode = str == null ? 0 : str.hashCode();
        long j = this.f10480b;
        int i2 = (((hashCode ^ 1000003) * 1000003) ^ ((int) (j ^ (j >>> 32)))) * 1000003;
        C3791e.C3793b bVar = this.f10481c;
        if (bVar != null) {
            i = bVar.hashCode();
        }
        return i2 ^ i;
    }

    public String toString() {
        return "TokenResult{token=" + this.f10479a + ", tokenExpirationTimestamp=" + this.f10480b + ", responseCode=" + this.f10481c + "}";
    }

    private C3784b(String str, long j, C3791e.C3793b bVar) {
        this.f10479a = str;
        this.f10480b = j;
        this.f10481c = bVar;
    }
}
