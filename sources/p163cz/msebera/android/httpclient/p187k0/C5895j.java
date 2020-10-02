package p163cz.msebera.android.httpclient.p187k0;

import java.util.Map;

/* renamed from: cz.msebera.android.httpclient.k0.j */
/* compiled from: VersionInfo */
public class C5895j {

    /* renamed from: a */
    private final String f15118a;

    /* renamed from: b */
    private final String f15119b;

    /* renamed from: c */
    private final String f15120c;

    /* renamed from: d */
    private final String f15121d;

    /* renamed from: e */
    private final String f15122e;

    protected C5895j(String str, String str2, String str3, String str4, String str5) {
        C5886a.m18894a(str, "Package identifier");
        this.f15118a = str;
        this.f15119b = str2 == null ? "UNAVAILABLE" : str2;
        this.f15120c = str3 == null ? "UNAVAILABLE" : str3;
        this.f15121d = str4 == null ? "UNAVAILABLE" : str4;
        this.f15122e = str5 == null ? "UNAVAILABLE" : str5;
    }

    /* renamed from: a */
    public final String mo33682a() {
        return this.f15120c;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(this.f15118a.length() + 20 + this.f15119b.length() + this.f15120c.length() + this.f15121d.length() + this.f15122e.length());
        sb.append("VersionInfo(");
        sb.append(this.f15118a);
        sb.append(':');
        sb.append(this.f15119b);
        if (!"UNAVAILABLE".equals(this.f15120c)) {
            sb.append(':');
            sb.append(this.f15120c);
        }
        if (!"UNAVAILABLE".equals(this.f15121d)) {
            sb.append(':');
            sb.append(this.f15121d);
        }
        sb.append(')');
        if (!"UNAVAILABLE".equals(this.f15122e)) {
            sb.append('@');
            sb.append(this.f15122e);
        }
        return sb.toString();
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x004b  */
    /* JADX WARNING: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static p163cz.msebera.android.httpclient.p187k0.C5895j m18945a(java.lang.String r4, java.lang.ClassLoader r5) {
        /*
            java.lang.String r0 = "Package identifier"
            p163cz.msebera.android.httpclient.p187k0.C5886a.m18894a(r4, (java.lang.String) r0)
            if (r5 == 0) goto L_0x0008
            goto L_0x0010
        L_0x0008:
            java.lang.Thread r5 = java.lang.Thread.currentThread()
            java.lang.ClassLoader r5 = r5.getContextClassLoader()
        L_0x0010:
            r0 = 0
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0048 }
            r1.<init>()     // Catch:{ IOException -> 0x0048 }
            r2 = 46
            r3 = 47
            java.lang.String r2 = r4.replace(r2, r3)     // Catch:{ IOException -> 0x0048 }
            r1.append(r2)     // Catch:{ IOException -> 0x0048 }
            java.lang.String r2 = "/"
            r1.append(r2)     // Catch:{ IOException -> 0x0048 }
            java.lang.String r2 = "version.properties"
            r1.append(r2)     // Catch:{ IOException -> 0x0048 }
            java.lang.String r1 = r1.toString()     // Catch:{ IOException -> 0x0048 }
            java.io.InputStream r1 = r5.getResourceAsStream(r1)     // Catch:{ IOException -> 0x0048 }
            if (r1 == 0) goto L_0x0048
            java.util.Properties r2 = new java.util.Properties     // Catch:{ all -> 0x0043 }
            r2.<init>()     // Catch:{ all -> 0x0043 }
            r2.load(r1)     // Catch:{ all -> 0x0043 }
            r1.close()     // Catch:{ IOException -> 0x0041 }
            goto L_0x0049
        L_0x0041:
            goto L_0x0049
        L_0x0043:
            r2 = move-exception
            r1.close()     // Catch:{ IOException -> 0x0048 }
            throw r2     // Catch:{ IOException -> 0x0048 }
        L_0x0048:
            r2 = r0
        L_0x0049:
            if (r2 == 0) goto L_0x004f
            cz.msebera.android.httpclient.k0.j r0 = m18946a((java.lang.String) r4, (java.util.Map<?, ?>) r2, (java.lang.ClassLoader) r5)
        L_0x004f:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p163cz.msebera.android.httpclient.p187k0.C5895j.m18945a(java.lang.String, java.lang.ClassLoader):cz.msebera.android.httpclient.k0.j");
    }

    /* renamed from: a */
    protected static C5895j m18946a(String str, Map<?, ?> map, ClassLoader classLoader) {
        String str2;
        String str3;
        String str4;
        C5886a.m18894a(str, "Package identifier");
        String str5 = null;
        if (map != null) {
            String str6 = (String) map.get("info.module");
            if (str6 != null && str6.length() < 1) {
                str6 = null;
            }
            String str7 = (String) map.get("info.release");
            if (str7 != null && (str7.length() < 1 || str7.equals("${pom.version}"))) {
                str7 = null;
            }
            String str8 = (String) map.get("info.timestamp");
            str2 = (str8 == null || (str8.length() >= 1 && !str8.equals("${mvn.timestamp}"))) ? str8 : null;
            str4 = str6;
            str3 = str7;
        } else {
            str4 = null;
            str3 = null;
            str2 = null;
        }
        if (classLoader != null) {
            str5 = classLoader.toString();
        }
        return new C5895j(str, str4, str3, str2, str5);
    }

    /* renamed from: a */
    public static String m18947a(String str, String str2, Class<?> cls) {
        C5895j a = m18945a(str2, cls.getClassLoader());
        return String.format("%s/%s (Java/%s)", new Object[]{str, a != null ? a.mo33682a() : "UNAVAILABLE", System.getProperty("java.version")});
    }
}
