package com.criteo.publisher.p061t;

import com.criteo.publisher.p061t.C2540m;

/* renamed from: com.criteo.publisher.t.a */
abstract class C2512a extends C2540m {

    /* renamed from: a */
    private final Long f8003a;

    /* renamed from: b */
    private final Long f8004b;

    /* renamed from: c */
    private final boolean f8005c;

    /* renamed from: d */
    private final boolean f8006d;

    /* renamed from: e */
    private final Long f8007e;

    /* renamed from: f */
    private final String f8008f;

    /* renamed from: g */
    private final String f8009g;

    /* renamed from: h */
    private final boolean f8010h;

    /* renamed from: com.criteo.publisher.t.a$b */
    static class C2514b extends C2540m.C2541a {

        /* renamed from: a */
        private Long f8011a;

        /* renamed from: b */
        private Long f8012b;

        /* renamed from: c */
        private Boolean f8013c;

        /* renamed from: d */
        private Boolean f8014d;

        /* renamed from: e */
        private Long f8015e;

        /* renamed from: f */
        private String f8016f;

        /* renamed from: g */
        private String f8017g;

        /* renamed from: h */
        private Boolean f8018h;

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public C2540m.C2541a mo10535a(Long l) {
            this.f8012b = l;
            return this;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public C2540m.C2541a mo10539b(Long l) {
            this.f8011a = l;
            return this;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: c */
        public C2540m.C2541a mo10542c(Long l) {
            this.f8015e = l;
            return this;
        }

        C2514b() {
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public C2540m.C2541a mo10537a(boolean z) {
            this.f8014d = Boolean.valueOf(z);
            return this;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public C2540m.C2541a mo10541b(boolean z) {
            this.f8013c = Boolean.valueOf(z);
            return this;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: c */
        public C2540m.C2541a mo10543c(boolean z) {
            this.f8018h = Boolean.valueOf(z);
            return this;
        }

        private C2514b(C2540m mVar) {
            this.f8011a = mVar.mo10524b();
            this.f8012b = mVar.mo10523a();
            this.f8013c = Boolean.valueOf(mVar.mo10530g());
            this.f8014d = Boolean.valueOf(mVar.mo10529f());
            this.f8015e = mVar.mo10525c();
            this.f8016f = mVar.mo10526d();
            this.f8017g = mVar.mo10527e();
            this.f8018h = Boolean.valueOf(mVar.mo10531h());
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public C2540m.C2541a mo10536a(String str) {
            if (str != null) {
                this.f8016f = str;
                return this;
            }
            throw new NullPointerException("Null impressionId");
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public C2540m.C2541a mo10540b(String str) {
            this.f8017g = str;
            return this;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public C2540m mo10538a() {
            String str = "";
            if (this.f8013c == null) {
                str = str + " cdbCallTimeout";
            }
            if (this.f8014d == null) {
                str = str + " cachedBidUsed";
            }
            if (this.f8016f == null) {
                str = str + " impressionId";
            }
            if (this.f8018h == null) {
                str = str + " readyToSend";
            }
            if (str.isEmpty()) {
                return new C2518e(this.f8011a, this.f8012b, this.f8013c.booleanValue(), this.f8014d.booleanValue(), this.f8015e, this.f8016f, this.f8017g, this.f8018h.booleanValue());
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }
    }

    C2512a(Long l, Long l2, boolean z, boolean z2, Long l3, String str, String str2, boolean z3) {
        this.f8003a = l;
        this.f8004b = l2;
        this.f8005c = z;
        this.f8006d = z2;
        this.f8007e = l3;
        if (str != null) {
            this.f8008f = str;
            this.f8009g = str2;
            this.f8010h = z3;
            return;
        }
        throw new NullPointerException("Null impressionId");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public Long mo10523a() {
        return this.f8004b;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public Long mo10524b() {
        return this.f8003a;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public Long mo10525c() {
        return this.f8007e;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public String mo10526d() {
        return this.f8008f;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public String mo10527e() {
        return this.f8009g;
    }

    public boolean equals(Object obj) {
        Long l;
        String str;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C2540m)) {
            return false;
        }
        C2540m mVar = (C2540m) obj;
        Long l2 = this.f8003a;
        if (l2 != null ? l2.equals(mVar.mo10524b()) : mVar.mo10524b() == null) {
            Long l3 = this.f8004b;
            if (l3 != null ? l3.equals(mVar.mo10523a()) : mVar.mo10523a() == null) {
                if (this.f8005c != mVar.mo10530g() || this.f8006d != mVar.mo10529f() || ((l = this.f8007e) != null ? !l.equals(mVar.mo10525c()) : mVar.mo10525c() != null) || !this.f8008f.equals(mVar.mo10526d()) || ((str = this.f8009g) != null ? !str.equals(mVar.mo10527e()) : mVar.mo10527e() != null) || this.f8010h != mVar.mo10531h()) {
                    return false;
                }
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public boolean mo10529f() {
        return this.f8006d;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: g */
    public boolean mo10530g() {
        return this.f8005c;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: h */
    public boolean mo10531h() {
        return this.f8010h;
    }

    public int hashCode() {
        Long l = this.f8003a;
        int i = 0;
        int hashCode = ((l == null ? 0 : l.hashCode()) ^ 1000003) * 1000003;
        Long l2 = this.f8004b;
        int i2 = 1231;
        int hashCode2 = (((((hashCode ^ (l2 == null ? 0 : l2.hashCode())) * 1000003) ^ (this.f8005c ? 1231 : 1237)) * 1000003) ^ (this.f8006d ? 1231 : 1237)) * 1000003;
        Long l3 = this.f8007e;
        int hashCode3 = (((hashCode2 ^ (l3 == null ? 0 : l3.hashCode())) * 1000003) ^ this.f8008f.hashCode()) * 1000003;
        String str = this.f8009g;
        if (str != null) {
            i = str.hashCode();
        }
        int i3 = (hashCode3 ^ i) * 1000003;
        if (!this.f8010h) {
            i2 = 1237;
        }
        return i3 ^ i2;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: i */
    public C2540m.C2541a mo10533i() {
        return new C2514b(this);
    }

    public String toString() {
        return "Metric{cdbCallStartTimestamp=" + this.f8003a + ", cdbCallEndTimestamp=" + this.f8004b + ", cdbCallTimeout=" + this.f8005c + ", cachedBidUsed=" + this.f8006d + ", elapsedTimestamp=" + this.f8007e + ", impressionId=" + this.f8008f + ", requestGroupId=" + this.f8009g + ", readyToSend=" + this.f8010h + "}";
    }
}
