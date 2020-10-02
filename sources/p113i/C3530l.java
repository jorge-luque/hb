package p113i;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.annotation.Nullable;
import p113i.p114e0.C3500c;
import p113i.p114e0.p116f.C5938d;

/* renamed from: i.l */
/* compiled from: Cookie */
public final class C3530l {

    /* renamed from: j */
    private static final Pattern f9829j = Pattern.compile("(\\d{2,4})[^\\d]*");

    /* renamed from: k */
    private static final Pattern f9830k = Pattern.compile("(?i)(jan|feb|mar|apr|may|jun|jul|aug|sep|oct|nov|dec).*");

    /* renamed from: l */
    private static final Pattern f9831l = Pattern.compile("(\\d{1,2})[^\\d]*");

    /* renamed from: m */
    private static final Pattern f9832m = Pattern.compile("(\\d{1,2}):(\\d{1,2}):(\\d{1,2})[^\\d]*");

    /* renamed from: a */
    private final String f9833a;

    /* renamed from: b */
    private final String f9834b;

    /* renamed from: c */
    private final long f9835c;

    /* renamed from: d */
    private final String f9836d;

    /* renamed from: e */
    private final String f9837e;

    /* renamed from: f */
    private final boolean f9838f;

    /* renamed from: g */
    private final boolean f9839g;

    /* renamed from: h */
    private final boolean f9840h;

    /* renamed from: i */
    private final boolean f9841i;

    private C3530l(String str, String str2, long j, String str3, String str4, boolean z, boolean z2, boolean z3, boolean z4) {
        this.f9833a = str;
        this.f9834b = str2;
        this.f9835c = j;
        this.f9836d = str3;
        this.f9837e = str4;
        this.f9838f = z;
        this.f9839g = z2;
        this.f9841i = z3;
        this.f9840h = z4;
    }

    /* renamed from: a */
    public String mo19461a() {
        return this.f9833a;
    }

    /* renamed from: b */
    public String mo19463b() {
        return this.f9834b;
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof C3530l)) {
            return false;
        }
        C3530l lVar = (C3530l) obj;
        if (lVar.f9833a.equals(this.f9833a) && lVar.f9834b.equals(this.f9834b) && lVar.f9836d.equals(this.f9836d) && lVar.f9837e.equals(this.f9837e) && lVar.f9835c == this.f9835c && lVar.f9838f == this.f9838f && lVar.f9839g == this.f9839g && lVar.f9840h == this.f9840h && lVar.f9841i == this.f9841i) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        long j = this.f9835c;
        return ((((((((((((((((527 + this.f9833a.hashCode()) * 31) + this.f9834b.hashCode()) * 31) + this.f9836d.hashCode()) * 31) + this.f9837e.hashCode()) * 31) + ((int) (j ^ (j >>> 32)))) * 31) + (this.f9838f ^ true ? 1 : 0)) * 31) + (this.f9839g ^ true ? 1 : 0)) * 31) + (this.f9840h ^ true ? 1 : 0)) * 31) + (this.f9841i ^ true ? 1 : 0);
    }

    public String toString() {
        return mo19462a(false);
    }

    /* renamed from: a */
    private static boolean m11788a(String str, String str2) {
        if (str.equals(str2)) {
            return true;
        }
        if (!str.endsWith(str2) || str.charAt((str.length() - str2.length()) - 1) != '.' || C3500c.m11666d(str)) {
            return false;
        }
        return true;
    }

    /* renamed from: b */
    private static long m11789b(String str) {
        try {
            long parseLong = Long.parseLong(str);
            if (parseLong <= 0) {
                return Long.MIN_VALUE;
            }
            return parseLong;
        } catch (NumberFormatException e) {
            if (!str.matches("-?\\d+")) {
                throw e;
            } else if (str.startsWith("-")) {
                return Long.MIN_VALUE;
            } else {
                return Long.MAX_VALUE;
            }
        }
    }

    @Nullable
    /* renamed from: a */
    public static C3530l m11785a(C3539s sVar, String str) {
        return m11784a(System.currentTimeMillis(), sVar, str);
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00ed  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00f0  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x010e A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x010f  */
    @javax.annotation.Nullable
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static p113i.C3530l m11784a(long r23, p113i.C3539s r25, java.lang.String r26) {
        /*
            r0 = r26
            int r1 = r26.length()
            r2 = 59
            r3 = 0
            int r4 = p113i.p114e0.C3500c.m11632a((java.lang.String) r0, (int) r3, (int) r1, (char) r2)
            r5 = 61
            int r6 = p113i.p114e0.C3500c.m11632a((java.lang.String) r0, (int) r3, (int) r4, (char) r5)
            r7 = 0
            if (r6 != r4) goto L_0x0017
            return r7
        L_0x0017:
            java.lang.String r9 = p113i.p114e0.C3500c.m11665d(r0, r3, r6)
            boolean r8 = r9.isEmpty()
            if (r8 != 0) goto L_0x0135
            int r8 = p113i.p114e0.C3500c.m11663c(r9)
            r10 = -1
            if (r8 == r10) goto L_0x002a
            goto L_0x0135
        L_0x002a:
            r8 = 1
            int r6 = r6 + r8
            java.lang.String r6 = p113i.p114e0.C3500c.m11665d(r0, r6, r4)
            int r11 = p113i.p114e0.C3500c.m11663c(r6)
            if (r11 == r10) goto L_0x0037
            return r7
        L_0x0037:
            int r4 = r4 + r8
            r10 = -1
            r12 = 253402300799999(0xe677d21fdbff, double:1.251973714024093E-309)
            r8 = r7
            r14 = r8
            r19 = r10
            r21 = r12
            r15 = 0
            r16 = 0
            r17 = 1
            r18 = 0
        L_0x004c:
            if (r4 >= r1) goto L_0x00ba
            int r7 = p113i.p114e0.C3500c.m11632a((java.lang.String) r0, (int) r4, (int) r1, (char) r2)
            int r2 = p113i.p114e0.C3500c.m11632a((java.lang.String) r0, (int) r4, (int) r7, (char) r5)
            java.lang.String r4 = p113i.p114e0.C3500c.m11665d(r0, r4, r2)
            if (r2 >= r7) goto L_0x0063
            int r2 = r2 + 1
            java.lang.String r2 = p113i.p114e0.C3500c.m11665d(r0, r2, r7)
            goto L_0x0065
        L_0x0063:
            java.lang.String r2 = ""
        L_0x0065:
            java.lang.String r5 = "expires"
            boolean r5 = r4.equalsIgnoreCase(r5)
            if (r5 == 0) goto L_0x0076
            int r4 = r2.length()     // Catch:{ IllegalArgumentException -> 0x00b2 }
            long r21 = m11783a((java.lang.String) r2, (int) r3, (int) r4)     // Catch:{ IllegalArgumentException -> 0x00b2 }
            goto L_0x0082
        L_0x0076:
            java.lang.String r5 = "max-age"
            boolean r5 = r4.equalsIgnoreCase(r5)
            if (r5 == 0) goto L_0x0085
            long r19 = m11789b(r2)     // Catch:{  }
        L_0x0082:
            r18 = 1
            goto L_0x00b2
        L_0x0085:
            java.lang.String r5 = "domain"
            boolean r5 = r4.equalsIgnoreCase(r5)
            if (r5 == 0) goto L_0x0094
            java.lang.String r14 = m11786a((java.lang.String) r2)     // Catch:{ IllegalArgumentException -> 0x00b2 }
            r17 = 0
            goto L_0x00b2
        L_0x0094:
            java.lang.String r5 = "path"
            boolean r5 = r4.equalsIgnoreCase(r5)
            if (r5 == 0) goto L_0x009e
            r8 = r2
            goto L_0x00b2
        L_0x009e:
            java.lang.String r2 = "secure"
            boolean r2 = r4.equalsIgnoreCase(r2)
            if (r2 == 0) goto L_0x00a8
            r15 = 1
            goto L_0x00b2
        L_0x00a8:
            java.lang.String r2 = "httponly"
            boolean r2 = r4.equalsIgnoreCase(r2)
            if (r2 == 0) goto L_0x00b2
            r16 = 1
        L_0x00b2:
            int r4 = r7 + 1
            r2 = 59
            r5 = 61
            r7 = 0
            goto L_0x004c
        L_0x00ba:
            r0 = -9223372036854775808
            int r2 = (r19 > r0 ? 1 : (r19 == r0 ? 0 : -1))
            if (r2 != 0) goto L_0x00c2
        L_0x00c0:
            r11 = r0
            goto L_0x00e7
        L_0x00c2:
            int r0 = (r19 > r10 ? 1 : (r19 == r10 ? 0 : -1))
            if (r0 == 0) goto L_0x00e5
            r0 = 9223372036854775(0x20c49ba5e353f7, double:4.663754807431093E-308)
            int r2 = (r19 > r0 ? 1 : (r19 == r0 ? 0 : -1))
            if (r2 > 0) goto L_0x00d4
            r0 = 1000(0x3e8, double:4.94E-321)
            long r19 = r19 * r0
            goto L_0x00d9
        L_0x00d4:
            r19 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
        L_0x00d9:
            long r0 = r23 + r19
            int r2 = (r0 > r23 ? 1 : (r0 == r23 ? 0 : -1))
            if (r2 < 0) goto L_0x00e3
            int r2 = (r0 > r12 ? 1 : (r0 == r12 ? 0 : -1))
            if (r2 <= 0) goto L_0x00c0
        L_0x00e3:
            r11 = r12
            goto L_0x00e7
        L_0x00e5:
            r11 = r21
        L_0x00e7:
            java.lang.String r0 = r25.mo19525g()
            if (r14 != 0) goto L_0x00f0
            r13 = r0
            r1 = 0
            goto L_0x00fa
        L_0x00f0:
            boolean r1 = m11788a((java.lang.String) r0, (java.lang.String) r14)
            if (r1 != 0) goto L_0x00f8
            r1 = 0
            return r1
        L_0x00f8:
            r1 = 0
            r13 = r14
        L_0x00fa:
            int r0 = r0.length()
            int r2 = r13.length()
            if (r0 == r2) goto L_0x010f
            okhttp3.internal.publicsuffix.PublicSuffixDatabase r0 = okhttp3.internal.publicsuffix.PublicSuffixDatabase.m21904a()
            java.lang.String r0 = r0.mo35755a((java.lang.String) r13)
            if (r0 != 0) goto L_0x010f
            return r1
        L_0x010f:
            java.lang.String r0 = "/"
            if (r8 == 0) goto L_0x011c
            boolean r1 = r8.startsWith(r0)
            if (r1 != 0) goto L_0x011a
            goto L_0x011c
        L_0x011a:
            r14 = r8
            goto L_0x012d
        L_0x011c:
            java.lang.String r1 = r25.mo19520c()
            r2 = 47
            int r2 = r1.lastIndexOf(r2)
            if (r2 == 0) goto L_0x012c
            java.lang.String r0 = r1.substring(r3, r2)
        L_0x012c:
            r14 = r0
        L_0x012d:
            i.l r0 = new i.l
            r8 = r0
            r10 = r6
            r8.<init>(r9, r10, r11, r13, r14, r15, r16, r17, r18)
            return r0
        L_0x0135:
            r0 = r7
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p113i.C3530l.m11784a(long, i.s, java.lang.String):i.l");
    }

    /* renamed from: a */
    private static long m11783a(String str, int i, int i2) {
        int a = m11782a(str, i, i2, false);
        Matcher matcher = f9832m.matcher(str);
        int i3 = -1;
        int i4 = -1;
        int i5 = -1;
        int i6 = -1;
        int i7 = -1;
        int i8 = -1;
        while (a < i2) {
            int a2 = m11782a(str, a + 1, i2, true);
            matcher.region(a, a2);
            if (i4 == -1 && matcher.usePattern(f9832m).matches()) {
                i4 = Integer.parseInt(matcher.group(1));
                i7 = Integer.parseInt(matcher.group(2));
                i8 = Integer.parseInt(matcher.group(3));
            } else if (i5 == -1 && matcher.usePattern(f9831l).matches()) {
                i5 = Integer.parseInt(matcher.group(1));
            } else if (i6 == -1 && matcher.usePattern(f9830k).matches()) {
                i6 = f9830k.pattern().indexOf(matcher.group(1).toLowerCase(Locale.US)) / 4;
            } else if (i3 == -1 && matcher.usePattern(f9829j).matches()) {
                i3 = Integer.parseInt(matcher.group(1));
            }
            a = m11782a(str, a2 + 1, i2, false);
        }
        if (i3 >= 70 && i3 <= 99) {
            i3 += 1900;
        }
        if (i3 >= 0 && i3 <= 69) {
            i3 += 2000;
        }
        if (i3 < 1601) {
            throw new IllegalArgumentException();
        } else if (i6 == -1) {
            throw new IllegalArgumentException();
        } else if (i5 < 1 || i5 > 31) {
            throw new IllegalArgumentException();
        } else if (i4 < 0 || i4 > 23) {
            throw new IllegalArgumentException();
        } else if (i7 < 0 || i7 > 59) {
            throw new IllegalArgumentException();
        } else if (i8 < 0 || i8 > 59) {
            throw new IllegalArgumentException();
        } else {
            GregorianCalendar gregorianCalendar = new GregorianCalendar(C3500c.f9714n);
            gregorianCalendar.setLenient(false);
            gregorianCalendar.set(1, i3);
            gregorianCalendar.set(2, i6 - 1);
            gregorianCalendar.set(5, i5);
            gregorianCalendar.set(11, i4);
            gregorianCalendar.set(12, i7);
            gregorianCalendar.set(13, i8);
            gregorianCalendar.set(14, 0);
            return gregorianCalendar.getTimeInMillis();
        }
    }

    /* renamed from: a */
    private static int m11782a(String str, int i, int i2, boolean z) {
        while (i < i2) {
            char charAt = str.charAt(i);
            if (((charAt < ' ' && charAt != 9) || charAt >= 127 || (charAt >= '0' && charAt <= '9') || ((charAt >= 'a' && charAt <= 'z') || ((charAt >= 'A' && charAt <= 'Z') || charAt == ':'))) == (!z)) {
                return i;
            }
            i++;
        }
        return i2;
    }

    /* renamed from: a */
    private static String m11786a(String str) {
        if (!str.endsWith(".")) {
            if (str.startsWith(".")) {
                str = str.substring(1);
            }
            String a = C3500c.m11638a(str);
            if (a != null) {
                return a;
            }
            throw new IllegalArgumentException();
        }
        throw new IllegalArgumentException();
    }

    /* renamed from: a */
    public static List<C3530l> m11787a(C3539s sVar, C3537r rVar) {
        List<String> b = rVar.mo19505b("Set-Cookie");
        int size = b.size();
        ArrayList arrayList = null;
        for (int i = 0; i < size; i++) {
            C3530l a = m11785a(sVar, b.get(i));
            if (a != null) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(a);
            }
        }
        if (arrayList != null) {
            return Collections.unmodifiableList(arrayList);
        }
        return Collections.emptyList();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public String mo19462a(boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f9833a);
        sb.append('=');
        sb.append(this.f9834b);
        if (this.f9840h) {
            if (this.f9835c == Long.MIN_VALUE) {
                sb.append("; max-age=0");
            } else {
                sb.append("; expires=");
                sb.append(C5938d.m19024a(new Date(this.f9835c)));
            }
        }
        if (!this.f9841i) {
            sb.append("; domain=");
            if (z) {
                sb.append(".");
            }
            sb.append(this.f9836d);
        }
        sb.append("; path=");
        sb.append(this.f9837e);
        if (this.f9838f) {
            sb.append("; secure");
        }
        if (this.f9839g) {
            sb.append("; httponly");
        }
        return sb.toString();
    }
}
