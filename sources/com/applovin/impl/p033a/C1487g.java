package com.applovin.impl.p033a;

import com.applovin.impl.sdk.C1941j;
import com.applovin.impl.sdk.utils.C1989e;
import com.applovin.impl.sdk.utils.C2025o;
import com.applovin.impl.sdk.utils.C2032t;
import com.tapjoy.TJAdUnitConstants;
import com.tapjoy.TapjoyConstants;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* renamed from: com.applovin.impl.a.g */
public class C1487g {

    /* renamed from: a */
    private String f4652a;

    /* renamed from: b */
    private String f4653b;

    /* renamed from: c */
    private String f4654c;

    /* renamed from: d */
    private long f4655d = -1;

    /* renamed from: e */
    private int f4656e = -1;

    private C1487g() {
    }

    /* renamed from: a */
    private static int m5771a(String str, C1482c cVar) {
        if (TJAdUnitConstants.String.VIDEO_START.equalsIgnoreCase(str)) {
            return 0;
        }
        if (TJAdUnitConstants.String.VIDEO_FIRST_QUARTILE.equalsIgnoreCase(str)) {
            return 25;
        }
        if (TJAdUnitConstants.String.VIDEO_MIDPOINT.equalsIgnoreCase(str)) {
            return 50;
        }
        if (TJAdUnitConstants.String.VIDEO_THIRD_QUARTILE.equalsIgnoreCase(str)) {
            return 75;
        }
        if (!TJAdUnitConstants.String.VIDEO_COMPLETE.equalsIgnoreCase(str)) {
            return -1;
        }
        if (cVar != null) {
            return cVar.mo7198i();
        }
        return 95;
    }

    /* renamed from: a */
    public static C1487g m5772a(C2032t tVar, C1482c cVar, C1941j jVar) {
        TimeUnit timeUnit;
        long seconds;
        if (tVar == null) {
            throw new IllegalArgumentException("No node specified.");
        } else if (jVar != null) {
            try {
                String c = tVar.mo8828c();
                if (C2025o.m7963b(c)) {
                    C1487g gVar = new C1487g();
                    gVar.f4654c = c;
                    gVar.f4652a = tVar.mo8826b().get("id");
                    gVar.f4653b = tVar.mo8826b().get(TapjoyConstants.TJC_SDK_TYPE_DEFAULT);
                    gVar.f4656e = m5771a(gVar.mo7211a(), cVar);
                    String str = tVar.mo8826b().get("offset");
                    if (C2025o.m7963b(str)) {
                        String trim = str.trim();
                        if (trim.contains("%")) {
                            gVar.f4656e = C2025o.m7953a(trim.substring(0, trim.length() - 1));
                        } else if (trim.contains(":")) {
                            List<String> a = C1989e.m7832a(trim, ":");
                            int size = a.size();
                            if (size > 0) {
                                long j = 0;
                                int i = size - 1;
                                for (int i2 = i; i2 >= 0; i2--) {
                                    String str2 = a.get(i2);
                                    if (C2025o.m7965d(str2)) {
                                        int parseInt = Integer.parseInt(str2);
                                        if (i2 == i) {
                                            seconds = (long) parseInt;
                                        } else {
                                            if (i2 == size - 2) {
                                                timeUnit = TimeUnit.MINUTES;
                                            } else if (i2 == size - 3) {
                                                timeUnit = TimeUnit.HOURS;
                                            }
                                            seconds = timeUnit.toSeconds((long) parseInt);
                                        }
                                        j += seconds;
                                    }
                                }
                                gVar.f4655d = j;
                                gVar.f4656e = -1;
                            }
                        } else {
                            jVar.mo8602v().mo8746e("VastTracker", "Unable to parse time offset from rawOffsetString = " + trim);
                        }
                    }
                    return gVar;
                }
                jVar.mo8602v().mo8746e("VastTracker", "Unable to create tracker. Could not find URL.");
                return null;
            } catch (Throwable th) {
                jVar.mo8602v().mo8743b("VastTracker", "Error occurred while initializing", th);
                return null;
            }
        } else {
            throw new IllegalArgumentException("No sdk specified.");
        }
    }

    /* renamed from: a */
    public String mo7211a() {
        return this.f4653b;
    }

    /* renamed from: a */
    public boolean mo7212a(long j, int i) {
        boolean z = this.f4655d >= 0;
        boolean z2 = j >= this.f4655d;
        boolean z3 = this.f4656e >= 0;
        boolean z4 = i >= this.f4656e;
        if (!z || !z2) {
            return z3 && z4;
        }
        return true;
    }

    /* renamed from: b */
    public String mo7213b() {
        return this.f4654c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C1487g)) {
            return false;
        }
        C1487g gVar = (C1487g) obj;
        if (this.f4655d != gVar.f4655d || this.f4656e != gVar.f4656e) {
            return false;
        }
        String str = this.f4652a;
        if (str == null ? gVar.f4652a != null : !str.equals(gVar.f4652a)) {
            return false;
        }
        String str2 = this.f4653b;
        if (str2 == null ? gVar.f4653b == null : str2.equals(gVar.f4653b)) {
            return this.f4654c.equals(gVar.f4654c);
        }
        return false;
    }

    public int hashCode() {
        String str = this.f4652a;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.f4653b;
        if (str2 != null) {
            i = str2.hashCode();
        }
        long j = this.f4655d;
        return ((((((hashCode + i) * 31) + this.f4654c.hashCode()) * 31) + ((int) (j ^ (j >>> 32)))) * 31) + this.f4656e;
    }

    public String toString() {
        return "VastTracker{identifier='" + this.f4652a + '\'' + ", event='" + this.f4653b + '\'' + ", uriString='" + this.f4654c + '\'' + ", offsetSeconds=" + this.f4655d + ", offsetPercent=" + this.f4656e + '}';
    }
}
