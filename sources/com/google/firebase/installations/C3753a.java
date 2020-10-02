package com.google.firebase.installations;

import com.google.firebase.installations.C3768l;

/* renamed from: com.google.firebase.installations.a */
/* compiled from: com.google.firebase:firebase-installations-interop@@16.0.0 */
final class C3753a extends C3768l {

    /* renamed from: a */
    private final String f10409a;

    /* renamed from: b */
    private final long f10410b;

    /* renamed from: c */
    private final long f10411c;

    /* renamed from: a */
    public String mo27387a() {
        return this.f10409a;
    }

    /* renamed from: b */
    public long mo27388b() {
        return this.f10411c;
    }

    /* renamed from: c */
    public long mo27389c() {
        return this.f10410b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C3768l)) {
            return false;
        }
        C3768l lVar = (C3768l) obj;
        if (this.f10409a.equals(lVar.mo27387a()) && this.f10410b == lVar.mo27389c() && this.f10411c == lVar.mo27388b()) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        long j = this.f10410b;
        long j2 = this.f10411c;
        return ((((this.f10409a.hashCode() ^ 1000003) * 1000003) ^ ((int) (j ^ (j >>> 32)))) * 1000003) ^ ((int) (j2 ^ (j2 >>> 32)));
    }

    public String toString() {
        return "InstallationTokenResult{token=" + this.f10409a + ", tokenExpirationTimestamp=" + this.f10410b + ", tokenCreationTimestamp=" + this.f10411c + "}";
    }

    /* renamed from: com.google.firebase.installations.a$b */
    /* compiled from: com.google.firebase:firebase-installations-interop@@16.0.0 */
    static final class C3755b extends C3768l.C3769a {

        /* renamed from: a */
        private String f10412a;

        /* renamed from: b */
        private Long f10413b;

        /* renamed from: c */
        private Long f10414c;

        C3755b() {
        }

        /* renamed from: a */
        public C3768l.C3769a mo27394a(String str) {
            if (str != null) {
                this.f10412a = str;
                return this;
            }
            throw new NullPointerException("Null token");
        }

        /* renamed from: b */
        public C3768l.C3769a mo27396b(long j) {
            this.f10413b = Long.valueOf(j);
            return this;
        }

        /* renamed from: a */
        public C3768l.C3769a mo27393a(long j) {
            this.f10414c = Long.valueOf(j);
            return this;
        }

        /* renamed from: a */
        public C3768l mo27395a() {
            String str = "";
            if (this.f10412a == null) {
                str = str + " token";
            }
            if (this.f10413b == null) {
                str = str + " tokenExpirationTimestamp";
            }
            if (this.f10414c == null) {
                str = str + " tokenCreationTimestamp";
            }
            if (str.isEmpty()) {
                return new C3753a(this.f10412a, this.f10413b.longValue(), this.f10414c.longValue());
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }
    }

    private C3753a(String str, long j, long j2) {
        this.f10409a = str;
        this.f10410b = j;
        this.f10411c = j2;
    }
}
