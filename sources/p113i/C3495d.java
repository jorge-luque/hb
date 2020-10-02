package p113i;

import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;

/* renamed from: i.d */
/* compiled from: CacheControl */
public final class C3495d {

    /* renamed from: n */
    public static final C3495d f9678n;

    /* renamed from: a */
    private final boolean f9679a;

    /* renamed from: b */
    private final boolean f9680b;

    /* renamed from: c */
    private final int f9681c;

    /* renamed from: d */
    private final int f9682d;

    /* renamed from: e */
    private final boolean f9683e;

    /* renamed from: f */
    private final boolean f9684f;

    /* renamed from: g */
    private final boolean f9685g;

    /* renamed from: h */
    private final int f9686h;

    /* renamed from: i */
    private final int f9687i;

    /* renamed from: j */
    private final boolean f9688j;

    /* renamed from: k */
    private final boolean f9689k;

    /* renamed from: l */
    private final boolean f9690l;
    @Nullable

    /* renamed from: m */
    String f9691m;

    static {
        C3496a aVar = new C3496a();
        aVar.mo19359b();
        aVar.mo19358a();
        C3496a aVar2 = new C3496a();
        aVar2.mo19361d();
        aVar2.mo19357a(Integer.MAX_VALUE, TimeUnit.SECONDS);
        f9678n = aVar2.mo19358a();
    }

    private C3495d(boolean z, boolean z2, int i, int i2, boolean z3, boolean z4, boolean z5, int i3, int i4, boolean z6, boolean z7, boolean z8, @Nullable String str) {
        this.f9679a = z;
        this.f9680b = z2;
        this.f9681c = i;
        this.f9682d = i2;
        this.f9683e = z3;
        this.f9684f = z4;
        this.f9685g = z5;
        this.f9686h = i3;
        this.f9687i = i4;
        this.f9688j = z6;
        this.f9689k = z7;
        this.f9690l = z8;
        this.f9691m = str;
    }

    /* renamed from: j */
    private String m11603j() {
        StringBuilder sb = new StringBuilder();
        if (this.f9679a) {
            sb.append("no-cache, ");
        }
        if (this.f9680b) {
            sb.append("no-store, ");
        }
        if (this.f9681c != -1) {
            sb.append("max-age=");
            sb.append(this.f9681c);
            sb.append(", ");
        }
        if (this.f9682d != -1) {
            sb.append("s-maxage=");
            sb.append(this.f9682d);
            sb.append(", ");
        }
        if (this.f9683e) {
            sb.append("private, ");
        }
        if (this.f9684f) {
            sb.append("public, ");
        }
        if (this.f9685g) {
            sb.append("must-revalidate, ");
        }
        if (this.f9686h != -1) {
            sb.append("max-stale=");
            sb.append(this.f9686h);
            sb.append(", ");
        }
        if (this.f9687i != -1) {
            sb.append("min-fresh=");
            sb.append(this.f9687i);
            sb.append(", ");
        }
        if (this.f9688j) {
            sb.append("only-if-cached, ");
        }
        if (this.f9689k) {
            sb.append("no-transform, ");
        }
        if (this.f9690l) {
            sb.append("immutable, ");
        }
        if (sb.length() == 0) {
            return "";
        }
        sb.delete(sb.length() - 2, sb.length());
        return sb.toString();
    }

    /* renamed from: a */
    public boolean mo19347a() {
        return this.f9683e;
    }

    /* renamed from: b */
    public boolean mo19348b() {
        return this.f9684f;
    }

    /* renamed from: c */
    public int mo19349c() {
        return this.f9681c;
    }

    /* renamed from: d */
    public int mo19350d() {
        return this.f9686h;
    }

    /* renamed from: e */
    public int mo19351e() {
        return this.f9687i;
    }

    /* renamed from: f */
    public boolean mo19352f() {
        return this.f9685g;
    }

    /* renamed from: g */
    public boolean mo19353g() {
        return this.f9679a;
    }

    /* renamed from: h */
    public boolean mo19354h() {
        return this.f9680b;
    }

    /* renamed from: i */
    public boolean mo19355i() {
        return this.f9688j;
    }

    public String toString() {
        String str = this.f9691m;
        if (str != null) {
            return str;
        }
        String j = m11603j();
        this.f9691m = j;
        return j;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0041  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static p113i.C3495d m11602a(p113i.C3537r r22) {
        /*
            r0 = r22
            int r1 = r22.mo19503b()
            r6 = 0
            r7 = 1
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = -1
            r12 = -1
            r13 = 0
            r14 = 0
            r15 = 0
            r16 = -1
            r17 = -1
            r18 = 0
            r19 = 0
            r20 = 0
        L_0x001a:
            if (r6 >= r1) goto L_0x013f
            java.lang.String r2 = r0.mo19501a((int) r6)
            java.lang.String r4 = r0.mo19504b((int) r6)
            java.lang.String r3 = "Cache-Control"
            boolean r3 = r2.equalsIgnoreCase(r3)
            if (r3 == 0) goto L_0x0031
            if (r8 == 0) goto L_0x002f
            goto L_0x0039
        L_0x002f:
            r8 = r4
            goto L_0x003a
        L_0x0031:
            java.lang.String r3 = "Pragma"
            boolean r2 = r2.equalsIgnoreCase(r3)
            if (r2 == 0) goto L_0x0138
        L_0x0039:
            r7 = 0
        L_0x003a:
            r2 = 0
        L_0x003b:
            int r3 = r4.length()
            if (r2 >= r3) goto L_0x0138
            java.lang.String r3 = "=,;"
            int r3 = p113i.p114e0.p116f.C5940e.m19027a((java.lang.String) r4, (int) r2, (java.lang.String) r3)
            java.lang.String r2 = r4.substring(r2, r3)
            java.lang.String r2 = r2.trim()
            int r5 = r4.length()
            if (r3 == r5) goto L_0x0099
            char r5 = r4.charAt(r3)
            r0 = 44
            if (r5 == r0) goto L_0x0099
            char r0 = r4.charAt(r3)
            r5 = 59
            if (r0 != r5) goto L_0x0066
            goto L_0x0099
        L_0x0066:
            int r3 = r3 + 1
            int r0 = p113i.p114e0.p116f.C5940e.m19034b(r4, r3)
            int r3 = r4.length()
            if (r0 >= r3) goto L_0x0089
            char r3 = r4.charAt(r0)
            r5 = 34
            if (r3 != r5) goto L_0x0089
            int r0 = r0 + 1
            java.lang.String r3 = "\""
            int r3 = p113i.p114e0.p116f.C5940e.m19027a((java.lang.String) r4, (int) r0, (java.lang.String) r3)
            java.lang.String r0 = r4.substring(r0, r3)
            r5 = 1
            int r3 = r3 + r5
            goto L_0x009d
        L_0x0089:
            r5 = 1
            java.lang.String r3 = ",;"
            int r3 = p113i.p114e0.p116f.C5940e.m19027a((java.lang.String) r4, (int) r0, (java.lang.String) r3)
            java.lang.String r0 = r4.substring(r0, r3)
            java.lang.String r0 = r0.trim()
            goto L_0x009d
        L_0x0099:
            r5 = 1
            int r3 = r3 + 1
            r0 = 0
        L_0x009d:
            java.lang.String r5 = "no-cache"
            boolean r5 = r5.equalsIgnoreCase(r2)
            if (r5 == 0) goto L_0x00a9
            r5 = -1
            r9 = 1
            goto L_0x0133
        L_0x00a9:
            java.lang.String r5 = "no-store"
            boolean r5 = r5.equalsIgnoreCase(r2)
            if (r5 == 0) goto L_0x00b5
            r5 = -1
            r10 = 1
            goto L_0x0133
        L_0x00b5:
            java.lang.String r5 = "max-age"
            boolean r5 = r5.equalsIgnoreCase(r2)
            if (r5 == 0) goto L_0x00c4
            r5 = -1
            int r11 = p113i.p114e0.p116f.C5940e.m19026a((java.lang.String) r0, (int) r5)
            goto L_0x0133
        L_0x00c4:
            java.lang.String r5 = "s-maxage"
            boolean r5 = r5.equalsIgnoreCase(r2)
            if (r5 == 0) goto L_0x00d2
            r5 = -1
            int r12 = p113i.p114e0.p116f.C5940e.m19026a((java.lang.String) r0, (int) r5)
            goto L_0x0133
        L_0x00d2:
            java.lang.String r5 = "private"
            boolean r5 = r5.equalsIgnoreCase(r2)
            if (r5 == 0) goto L_0x00dd
            r5 = -1
            r13 = 1
            goto L_0x0133
        L_0x00dd:
            java.lang.String r5 = "public"
            boolean r5 = r5.equalsIgnoreCase(r2)
            if (r5 == 0) goto L_0x00e8
            r5 = -1
            r14 = 1
            goto L_0x0133
        L_0x00e8:
            java.lang.String r5 = "must-revalidate"
            boolean r5 = r5.equalsIgnoreCase(r2)
            if (r5 == 0) goto L_0x00f3
            r5 = -1
            r15 = 1
            goto L_0x0133
        L_0x00f3:
            java.lang.String r5 = "max-stale"
            boolean r5 = r5.equalsIgnoreCase(r2)
            if (r5 == 0) goto L_0x0104
            r2 = 2147483647(0x7fffffff, float:NaN)
            int r16 = p113i.p114e0.p116f.C5940e.m19026a((java.lang.String) r0, (int) r2)
            r5 = -1
            goto L_0x0133
        L_0x0104:
            java.lang.String r5 = "min-fresh"
            boolean r5 = r5.equalsIgnoreCase(r2)
            if (r5 == 0) goto L_0x0112
            r5 = -1
            int r17 = p113i.p114e0.p116f.C5940e.m19026a((java.lang.String) r0, (int) r5)
            goto L_0x0133
        L_0x0112:
            r5 = -1
            java.lang.String r0 = "only-if-cached"
            boolean r0 = r0.equalsIgnoreCase(r2)
            if (r0 == 0) goto L_0x011e
            r18 = 1
            goto L_0x0133
        L_0x011e:
            java.lang.String r0 = "no-transform"
            boolean r0 = r0.equalsIgnoreCase(r2)
            if (r0 == 0) goto L_0x0129
            r19 = 1
            goto L_0x0133
        L_0x0129:
            java.lang.String r0 = "immutable"
            boolean r0 = r0.equalsIgnoreCase(r2)
            if (r0 == 0) goto L_0x0133
            r20 = 1
        L_0x0133:
            r0 = r22
            r2 = r3
            goto L_0x003b
        L_0x0138:
            r5 = -1
            int r6 = r6 + 1
            r0 = r22
            goto L_0x001a
        L_0x013f:
            if (r7 != 0) goto L_0x0144
            r21 = 0
            goto L_0x0146
        L_0x0144:
            r21 = r8
        L_0x0146:
            i.d r0 = new i.d
            r8 = r0
            r8.<init>(r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p113i.C3495d.m11602a(i.r):i.d");
    }

    /* renamed from: i.d$a */
    /* compiled from: CacheControl */
    public static final class C3496a {

        /* renamed from: a */
        boolean f9692a;

        /* renamed from: b */
        boolean f9693b;

        /* renamed from: c */
        int f9694c = -1;

        /* renamed from: d */
        int f9695d = -1;

        /* renamed from: e */
        int f9696e = -1;

        /* renamed from: f */
        boolean f9697f;

        /* renamed from: g */
        boolean f9698g;

        /* renamed from: h */
        boolean f9699h;

        /* renamed from: a */
        public C3496a mo19357a(int i, TimeUnit timeUnit) {
            if (i >= 0) {
                long seconds = timeUnit.toSeconds((long) i);
                this.f9695d = seconds > 2147483647L ? Integer.MAX_VALUE : (int) seconds;
                return this;
            }
            throw new IllegalArgumentException("maxStale < 0: " + i);
        }

        /* renamed from: b */
        public C3496a mo19359b() {
            this.f9692a = true;
            return this;
        }

        /* renamed from: c */
        public C3496a mo19360c() {
            this.f9693b = true;
            return this;
        }

        /* renamed from: d */
        public C3496a mo19361d() {
            this.f9697f = true;
            return this;
        }

        /* renamed from: a */
        public C3495d mo19358a() {
            return new C3495d(this);
        }
    }

    C3495d(C3496a aVar) {
        this.f9679a = aVar.f9692a;
        this.f9680b = aVar.f9693b;
        this.f9681c = aVar.f9694c;
        this.f9682d = -1;
        this.f9683e = false;
        this.f9684f = false;
        this.f9685g = false;
        this.f9686h = aVar.f9695d;
        this.f9687i = aVar.f9696e;
        this.f9688j = aVar.f9697f;
        this.f9689k = aVar.f9698g;
        this.f9690l = aVar.f9699h;
    }
}
