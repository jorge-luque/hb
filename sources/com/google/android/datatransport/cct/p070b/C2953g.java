package com.google.android.datatransport.cct.p070b;

import com.google.android.datatransport.cct.p070b.C2970p;
import java.util.Arrays;

/* renamed from: com.google.android.datatransport.cct.b.g */
/* compiled from: com.google.android.datatransport:transport-backend-cct@@2.2.0 */
final class C2953g extends C2970p {

    /* renamed from: a */
    private final long f8247a;

    /* renamed from: b */
    private final int f8248b;

    /* renamed from: c */
    private final long f8249c;

    /* renamed from: d */
    private final byte[] f8250d;

    /* renamed from: e */
    private final String f8251e;

    /* renamed from: f */
    private final long f8252f;

    /* renamed from: g */
    private final C2977u f8253g;

    /* renamed from: com.google.android.datatransport.cct.b.g$b */
    /* compiled from: com.google.android.datatransport:transport-backend-cct@@2.2.0 */
    static final class C2955b extends C2970p.C2971a {

        /* renamed from: a */
        private Long f8254a;

        /* renamed from: b */
        private Integer f8255b;

        /* renamed from: c */
        private Long f8256c;

        /* renamed from: d */
        private byte[] f8257d;

        /* renamed from: e */
        private String f8258e;

        /* renamed from: f */
        private Long f8259f;

        /* renamed from: g */
        private C2977u f8260g;

        C2955b() {
        }

        /* renamed from: a */
        public C2970p.C2971a mo12901a(long j) {
            this.f8254a = Long.valueOf(j);
            return this;
        }

        /* renamed from: b */
        public C2970p.C2971a mo12906b(long j) {
            this.f8256c = Long.valueOf(j);
            return this;
        }

        /* renamed from: c */
        public C2970p.C2971a mo12907c(long j) {
            this.f8259f = Long.valueOf(j);
            return this;
        }

        /* renamed from: a */
        public C2970p.C2971a mo12900a(int i) {
            this.f8255b = Integer.valueOf(i);
            return this;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public C2970p.C2971a mo12904a(byte[] bArr) {
            this.f8257d = bArr;
            return this;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public C2970p.C2971a mo12903a(String str) {
            this.f8258e = str;
            return this;
        }

        /* renamed from: a */
        public C2970p.C2971a mo12902a(C2977u uVar) {
            this.f8260g = uVar;
            return this;
        }

        /* renamed from: a */
        public C2970p mo12905a() {
            String str = "";
            if (this.f8254a == null) {
                str = str + " eventTimeMs";
            }
            if (this.f8255b == null) {
                str = str + " eventCode";
            }
            if (this.f8256c == null) {
                str = str + " eventUptimeMs";
            }
            if (this.f8259f == null) {
                str = str + " timezoneOffsetSeconds";
            }
            if (str.isEmpty()) {
                return new C2953g(this.f8254a.longValue(), this.f8255b.intValue(), this.f8256c.longValue(), this.f8257d, this.f8258e, this.f8259f.longValue(), this.f8260g, (C2954a) null);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }
    }

    /* synthetic */ C2953g(long j, int i, long j2, byte[] bArr, String str, long j3, C2977u uVar, C2954a aVar) {
        this.f8247a = j;
        this.f8248b = i;
        this.f8249c = j2;
        this.f8250d = bArr;
        this.f8251e = str;
        this.f8252f = j3;
        this.f8253g = uVar;
    }

    /* renamed from: a */
    public long mo12890a() {
        return this.f8247a;
    }

    /* renamed from: b */
    public long mo12891b() {
        return this.f8249c;
    }

    /* renamed from: c */
    public long mo12892c() {
        return this.f8252f;
    }

    /* renamed from: d */
    public int mo12893d() {
        return this.f8248b;
    }

    /* renamed from: e */
    public C2977u mo12894e() {
        return this.f8253g;
    }

    public boolean equals(Object obj) {
        byte[] bArr;
        String str;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C2970p)) {
            return false;
        }
        C2970p pVar = (C2970p) obj;
        if (this.f8247a == pVar.mo12890a()) {
            C2953g gVar = (C2953g) pVar;
            if (this.f8248b == gVar.f8248b && this.f8249c == pVar.mo12891b()) {
                byte[] bArr2 = this.f8250d;
                if (pVar instanceof C2953g) {
                    bArr = gVar.f8250d;
                } else {
                    bArr = gVar.f8250d;
                }
                if (Arrays.equals(bArr2, bArr) && ((str = this.f8251e) != null ? str.equals(gVar.f8251e) : gVar.f8251e == null) && this.f8252f == pVar.mo12892c()) {
                    C2977u uVar = this.f8253g;
                    if (uVar == null) {
                        if (gVar.f8253g == null) {
                            return true;
                        }
                    } else if (uVar.equals(gVar.f8253g)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /* renamed from: f */
    public byte[] mo12896f() {
        return this.f8250d;
    }

    /* renamed from: g */
    public String mo12897g() {
        return this.f8251e;
    }

    public int hashCode() {
        long j = this.f8247a;
        long j2 = this.f8249c;
        int hashCode = (((((((((int) (j ^ (j >>> 32))) ^ 1000003) * 1000003) ^ this.f8248b) * 1000003) ^ ((int) (j2 ^ (j2 >>> 32)))) * 1000003) ^ Arrays.hashCode(this.f8250d)) * 1000003;
        String str = this.f8251e;
        int i = 0;
        int hashCode2 = str == null ? 0 : str.hashCode();
        long j3 = this.f8252f;
        int i2 = (((hashCode ^ hashCode2) * 1000003) ^ ((int) ((j3 >>> 32) ^ j3))) * 1000003;
        C2977u uVar = this.f8253g;
        if (uVar != null) {
            i = uVar.hashCode();
        }
        return i2 ^ i;
    }

    public String toString() {
        return "LogEvent{eventTimeMs=" + this.f8247a + ", eventCode=" + this.f8248b + ", eventUptimeMs=" + this.f8249c + ", sourceExtension=" + Arrays.toString(this.f8250d) + ", sourceExtensionJsonProto3=" + this.f8251e + ", timezoneOffsetSeconds=" + this.f8252f + ", networkConnectionInfo=" + this.f8253g + "}";
    }
}
