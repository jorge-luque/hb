package com.google.android.datatransport.cct.p070b;

import com.google.android.datatransport.cct.p070b.C2942a;

/* renamed from: com.google.android.datatransport.cct.b.d */
/* compiled from: com.google.android.datatransport:transport-backend-cct@@2.2.0 */
final class C2946d extends C2942a {

    /* renamed from: a */
    private final int f8226a;

    /* renamed from: b */
    private final String f8227b;

    /* renamed from: c */
    private final String f8228c;

    /* renamed from: d */
    private final String f8229d;

    /* renamed from: e */
    private final String f8230e;

    /* renamed from: f */
    private final String f8231f;

    /* renamed from: g */
    private final String f8232g;

    /* renamed from: h */
    private final String f8233h;

    /* renamed from: com.google.android.datatransport.cct.b.d$b */
    /* compiled from: com.google.android.datatransport:transport-backend-cct@@2.2.0 */
    static final class C2948b extends C2942a.C2943a {

        /* renamed from: a */
        private Integer f8234a;

        /* renamed from: b */
        private String f8235b;

        /* renamed from: c */
        private String f8236c;

        /* renamed from: d */
        private String f8237d;

        /* renamed from: e */
        private String f8238e;

        /* renamed from: f */
        private String f8239f;

        /* renamed from: g */
        private String f8240g;

        /* renamed from: h */
        private String f8241h;

        C2948b() {
        }

        /* renamed from: a */
        public C2942a.C2943a mo12857a(int i) {
            this.f8234a = Integer.valueOf(i);
            return this;
        }

        /* renamed from: b */
        public C2942a.C2943a mo12860b(String str) {
            this.f8241h = str;
            return this;
        }

        /* renamed from: c */
        public C2942a.C2943a mo12861c(String str) {
            this.f8236c = str;
            return this;
        }

        /* renamed from: d */
        public C2942a.C2943a mo12862d(String str) {
            this.f8240g = str;
            return this;
        }

        /* renamed from: e */
        public C2942a.C2943a mo12863e(String str) {
            this.f8235b = str;
            return this;
        }

        /* renamed from: f */
        public C2942a.C2943a mo12864f(String str) {
            this.f8239f = str;
            return this;
        }

        /* renamed from: g */
        public C2942a.C2943a mo12865g(String str) {
            this.f8238e = str;
            return this;
        }

        /* renamed from: a */
        public C2942a.C2943a mo12858a(String str) {
            this.f8237d = str;
            return this;
        }

        /* renamed from: a */
        public C2942a mo12859a() {
            String str = "";
            if (this.f8234a == null) {
                str = str + " sdkVersion";
            }
            if (str.isEmpty()) {
                return new C2946d(this.f8234a.intValue(), this.f8235b, this.f8236c, this.f8237d, this.f8238e, this.f8239f, this.f8240g, this.f8241h, (C2947a) null);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }
    }

    /* synthetic */ C2946d(int i, String str, String str2, String str3, String str4, String str5, String str6, String str7, C2947a aVar) {
        this.f8226a = i;
        this.f8227b = str;
        this.f8228c = str2;
        this.f8229d = str3;
        this.f8230e = str4;
        this.f8231f = str5;
        this.f8232g = str6;
        this.f8233h = str7;
    }

    /* renamed from: b */
    public String mo12867b() {
        return this.f8229d;
    }

    /* renamed from: c */
    public String mo12868c() {
        return this.f8233h;
    }

    /* renamed from: d */
    public String mo12869d() {
        return this.f8228c;
    }

    /* renamed from: e */
    public String mo12870e() {
        return this.f8232g;
    }

    public boolean equals(Object obj) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C2942a)) {
            return false;
        }
        C2946d dVar = (C2946d) ((C2942a) obj);
        if (this.f8226a == dVar.f8226a && ((str = this.f8227b) != null ? str.equals(dVar.f8227b) : dVar.f8227b == null) && ((str2 = this.f8228c) != null ? str2.equals(dVar.f8228c) : dVar.f8228c == null) && ((str3 = this.f8229d) != null ? str3.equals(dVar.f8229d) : dVar.f8229d == null) && ((str4 = this.f8230e) != null ? str4.equals(dVar.f8230e) : dVar.f8230e == null) && ((str5 = this.f8231f) != null ? str5.equals(dVar.f8231f) : dVar.f8231f == null) && ((str6 = this.f8232g) != null ? str6.equals(dVar.f8232g) : dVar.f8232g == null)) {
            String str7 = this.f8233h;
            if (str7 == null) {
                if (dVar.f8233h == null) {
                    return true;
                }
            } else if (str7.equals(dVar.f8233h)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: f */
    public String mo12872f() {
        return this.f8227b;
    }

    /* renamed from: g */
    public String mo12873g() {
        return this.f8231f;
    }

    /* renamed from: h */
    public String mo12874h() {
        return this.f8230e;
    }

    public int hashCode() {
        int i = (this.f8226a ^ 1000003) * 1000003;
        String str = this.f8227b;
        int i2 = 0;
        int hashCode = (i ^ (str == null ? 0 : str.hashCode())) * 1000003;
        String str2 = this.f8228c;
        int hashCode2 = (hashCode ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
        String str3 = this.f8229d;
        int hashCode3 = (hashCode2 ^ (str3 == null ? 0 : str3.hashCode())) * 1000003;
        String str4 = this.f8230e;
        int hashCode4 = (hashCode3 ^ (str4 == null ? 0 : str4.hashCode())) * 1000003;
        String str5 = this.f8231f;
        int hashCode5 = (hashCode4 ^ (str5 == null ? 0 : str5.hashCode())) * 1000003;
        String str6 = this.f8232g;
        int hashCode6 = (hashCode5 ^ (str6 == null ? 0 : str6.hashCode())) * 1000003;
        String str7 = this.f8233h;
        if (str7 != null) {
            i2 = str7.hashCode();
        }
        return hashCode6 ^ i2;
    }

    /* renamed from: i */
    public int mo12876i() {
        return this.f8226a;
    }

    public String toString() {
        return "AndroidClientInfo{sdkVersion=" + this.f8226a + ", model=" + this.f8227b + ", hardware=" + this.f8228c + ", device=" + this.f8229d + ", product=" + this.f8230e + ", osBuild=" + this.f8231f + ", manufacturer=" + this.f8232g + ", fingerprint=" + this.f8233h + "}";
    }
}
