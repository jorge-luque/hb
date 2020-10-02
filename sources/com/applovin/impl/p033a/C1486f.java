package com.applovin.impl.p033a;

import com.applovin.impl.sdk.C1941j;
import com.applovin.impl.sdk.utils.C2025o;
import com.applovin.impl.sdk.utils.C2032t;

/* renamed from: com.applovin.impl.a.f */
public class C1486f {

    /* renamed from: a */
    private String f4650a;

    /* renamed from: b */
    private String f4651b;

    private C1486f() {
    }

    /* renamed from: a */
    public static C1486f m5770a(C2032t tVar, C1486f fVar, C1941j jVar) {
        if (tVar == null) {
            throw new IllegalArgumentException("No node specified.");
        } else if (jVar != null) {
            if (fVar == null) {
                try {
                    fVar = new C1486f();
                } catch (Throwable th) {
                    jVar.mo8602v().mo8743b("VastSystemInfo", "Error occurred while initializing", th);
                    return null;
                }
            }
            if (!C2025o.m7963b(fVar.f4650a)) {
                String c = tVar.mo8828c();
                if (C2025o.m7963b(c)) {
                    fVar.f4650a = c;
                }
            }
            if (!C2025o.m7963b(fVar.f4651b)) {
                String str = tVar.mo8826b().get("version");
                if (C2025o.m7963b(str)) {
                    fVar.f4651b = str;
                }
            }
            return fVar;
        } else {
            throw new IllegalArgumentException("No sdk specified.");
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C1486f)) {
            return false;
        }
        C1486f fVar = (C1486f) obj;
        String str = this.f4650a;
        if (str == null ? fVar.f4650a != null : !str.equals(fVar.f4650a)) {
            return false;
        }
        String str2 = this.f4651b;
        String str3 = fVar.f4651b;
        return str2 != null ? str2.equals(str3) : str3 == null;
    }

    public int hashCode() {
        String str = this.f4650a;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.f4651b;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "VastSystemInfo{name='" + this.f4650a + '\'' + ", version='" + this.f4651b + '\'' + '}';
    }
}
