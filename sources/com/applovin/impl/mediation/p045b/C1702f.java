package com.applovin.impl.mediation.p045b;

import com.applovin.impl.mediation.C1743j;

/* renamed from: com.applovin.impl.mediation.b.f */
public class C1702f {

    /* renamed from: a */
    private final C1704g f5307a;

    /* renamed from: b */
    private final String f5308b;

    /* renamed from: c */
    private final String f5309c;

    /* renamed from: d */
    private final String f5310d;

    /* renamed from: e */
    private final String f5311e;

    /* renamed from: com.applovin.impl.mediation.b.f$a */
    public interface C1703a {
        /* renamed from: a */
        void mo7848a(C1702f fVar);
    }

    private C1702f(C1704g gVar, C1743j jVar, String str, String str2) {
        this.f5307a = gVar;
        this.f5311e = str2;
        if (str != null) {
            this.f5310d = str.substring(0, Math.min(str.length(), gVar.mo7765a()));
        } else {
            this.f5310d = null;
        }
        if (jVar != null) {
            this.f5308b = jVar.mo7906f();
            this.f5309c = jVar.mo7907g();
            return;
        }
        this.f5308b = null;
        this.f5309c = null;
    }

    /* renamed from: a */
    public static C1702f m6519a(C1704g gVar, C1743j jVar, String str) {
        if (gVar == null) {
            throw new IllegalArgumentException("No spec specified");
        } else if (jVar != null) {
            return new C1702f(gVar, jVar, str, (String) null);
        } else {
            throw new IllegalArgumentException("No adapterWrapper specified");
        }
    }

    /* renamed from: a */
    public static C1702f m6520a(C1704g gVar, String str) {
        return m6521b(gVar, (C1743j) null, str);
    }

    /* renamed from: b */
    public static C1702f m6521b(C1704g gVar, C1743j jVar, String str) {
        if (gVar != null) {
            return new C1702f(gVar, jVar, (String) null, str);
        }
        throw new IllegalArgumentException("No spec specified");
    }

    /* renamed from: a */
    public C1704g mo7842a() {
        return this.f5307a;
    }

    /* renamed from: b */
    public String mo7843b() {
        return this.f5308b;
    }

    /* renamed from: c */
    public String mo7844c() {
        return this.f5309c;
    }

    /* renamed from: d */
    public String mo7845d() {
        return this.f5310d;
    }

    /* renamed from: e */
    public String mo7846e() {
        return this.f5311e;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SignalCollectionResult{mSignalProviderSpec=");
        sb.append(this.f5307a);
        sb.append(", mSdkVersion='");
        sb.append(this.f5308b);
        sb.append('\'');
        sb.append(", mAdapterVersion='");
        sb.append(this.f5309c);
        sb.append('\'');
        sb.append(", mSignalDataLength='");
        String str = this.f5310d;
        sb.append(str != null ? str.length() : 0);
        sb.append('\'');
        sb.append(", mErrorMessage=");
        sb.append(this.f5311e);
        sb.append('}');
        return sb.toString();
    }
}
