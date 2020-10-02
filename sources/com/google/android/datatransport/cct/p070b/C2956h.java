package com.google.android.datatransport.cct.p070b;

import com.google.android.datatransport.cct.p070b.C2973r;
import java.util.List;

/* renamed from: com.google.android.datatransport.cct.b.h */
/* compiled from: com.google.android.datatransport:transport-backend-cct@@2.2.0 */
final class C2956h extends C2973r {

    /* renamed from: a */
    private final long f8261a;

    /* renamed from: b */
    private final long f8262b;

    /* renamed from: c */
    private final C2965m f8263c;

    /* renamed from: d */
    private final int f8264d;

    /* renamed from: e */
    private final String f8265e;

    /* renamed from: f */
    private final List<C2970p> f8266f;

    /* renamed from: g */
    private final C2944b f8267g;

    /* renamed from: com.google.android.datatransport.cct.b.h$b */
    /* compiled from: com.google.android.datatransport:transport-backend-cct@@2.2.0 */
    static final class C2958b extends C2973r.C2974a {

        /* renamed from: a */
        private Long f8268a;

        /* renamed from: b */
        private Long f8269b;

        /* renamed from: c */
        private C2965m f8270c;

        /* renamed from: d */
        private Integer f8271d;

        /* renamed from: e */
        private String f8272e;

        /* renamed from: f */
        private List<C2970p> f8273f;

        /* renamed from: g */
        private C2944b f8274g;

        C2958b() {
        }

        /* renamed from: a */
        public C2973r.C2974a mo12918a(long j) {
            this.f8268a = Long.valueOf(j);
            return this;
        }

        /* renamed from: b */
        public C2973r.C2974a mo12924b(long j) {
            this.f8269b = Long.valueOf(j);
            return this;
        }

        /* renamed from: a */
        public C2973r.C2974a mo12920a(C2965m mVar) {
            this.f8270c = mVar;
            return this;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public C2973r.C2974a mo12917a(int i) {
            this.f8271d = Integer.valueOf(i);
            return this;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public C2973r.C2974a mo12921a(String str) {
            this.f8272e = str;
            return this;
        }

        /* renamed from: a */
        public C2973r.C2974a mo12922a(List<C2970p> list) {
            this.f8273f = list;
            return this;
        }

        /* renamed from: a */
        public C2973r.C2974a mo12919a(C2944b bVar) {
            this.f8274g = bVar;
            return this;
        }

        /* renamed from: a */
        public C2973r mo12923a() {
            String str = "";
            if (this.f8268a == null) {
                str = str + " requestTimeMs";
            }
            if (this.f8269b == null) {
                str = str + " requestUptimeMs";
            }
            if (this.f8271d == null) {
                str = str + " logSource";
            }
            if (str.isEmpty()) {
                return new C2956h(this.f8268a.longValue(), this.f8269b.longValue(), this.f8270c, this.f8271d.intValue(), this.f8272e, this.f8273f, this.f8274g, (C2957a) null);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }
    }

    /* synthetic */ C2956h(long j, long j2, C2965m mVar, int i, String str, List list, C2944b bVar, C2957a aVar) {
        this.f8261a = j;
        this.f8262b = j2;
        this.f8263c = mVar;
        this.f8264d = i;
        this.f8265e = str;
        this.f8266f = list;
        this.f8267g = bVar;
    }

    /* renamed from: b */
    public C2965m mo12908b() {
        return this.f8263c;
    }

    /* renamed from: c */
    public List<C2970p> mo12909c() {
        return this.f8266f;
    }

    /* renamed from: d */
    public int mo12910d() {
        return this.f8264d;
    }

    /* renamed from: e */
    public String mo12911e() {
        return this.f8265e;
    }

    public boolean equals(Object obj) {
        C2965m mVar;
        String str;
        List<C2970p> list;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C2973r)) {
            return false;
        }
        C2956h hVar = (C2956h) ((C2973r) obj);
        if (this.f8261a == hVar.f8261a && this.f8262b == hVar.f8262b && ((mVar = this.f8263c) != null ? mVar.equals(hVar.f8263c) : hVar.f8263c == null) && this.f8264d == hVar.f8264d && ((str = this.f8265e) != null ? str.equals(hVar.f8265e) : hVar.f8265e == null) && ((list = this.f8266f) != null ? list.equals(hVar.f8266f) : hVar.f8266f == null)) {
            C2944b bVar = this.f8267g;
            if (bVar == null) {
                if (hVar.f8267g == null) {
                    return true;
                }
            } else if (bVar.equals(hVar.f8267g)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: f */
    public long mo12913f() {
        return this.f8261a;
    }

    /* renamed from: g */
    public long mo12914g() {
        return this.f8262b;
    }

    public int hashCode() {
        long j = this.f8261a;
        long j2 = this.f8262b;
        int i = (((((int) (j ^ (j >>> 32))) ^ 1000003) * 1000003) ^ ((int) (j2 ^ (j2 >>> 32)))) * 1000003;
        C2965m mVar = this.f8263c;
        int i2 = 0;
        int hashCode = (((i ^ (mVar == null ? 0 : mVar.hashCode())) * 1000003) ^ this.f8264d) * 1000003;
        String str = this.f8265e;
        int hashCode2 = (hashCode ^ (str == null ? 0 : str.hashCode())) * 1000003;
        List<C2970p> list = this.f8266f;
        int hashCode3 = (hashCode2 ^ (list == null ? 0 : list.hashCode())) * 1000003;
        C2944b bVar = this.f8267g;
        if (bVar != null) {
            i2 = bVar.hashCode();
        }
        return hashCode3 ^ i2;
    }

    public String toString() {
        return "LogRequest{requestTimeMs=" + this.f8261a + ", requestUptimeMs=" + this.f8262b + ", clientInfo=" + this.f8263c + ", logSource=" + this.f8264d + ", logSourceName=" + this.f8265e + ", logEvents=" + this.f8266f + ", qosTier=" + this.f8267g + "}";
    }
}
