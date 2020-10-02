package p113i.p114e0.p115e;

import java.util.Date;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import p113i.C3480a0;
import p113i.C3495d;
import p113i.C3537r;
import p113i.C3548y;
import p113i.p114e0.C3499a;
import p113i.p114e0.p116f.C5938d;
import p113i.p114e0.p116f.C5940e;

/* renamed from: i.e0.e.c */
/* compiled from: CacheStrategy */
public final class C3503c {
    @Nullable

    /* renamed from: a */
    public final C3548y f9720a;
    @Nullable

    /* renamed from: b */
    public final C3480a0 f9721b;

    C3503c(C3548y yVar, C3480a0 a0Var) {
        this.f9720a = yVar;
        this.f9721b = a0Var;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0056, code lost:
        if (r3.mo19285t().mo19347a() == false) goto L_0x0059;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0059, code lost:
        return false;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean m11668a(p113i.C3480a0 r3, p113i.C3548y r4) {
        /*
            int r0 = r3.mo19288v()
            r1 = 200(0xc8, float:2.8E-43)
            r2 = 0
            if (r0 == r1) goto L_0x005a
            r1 = 410(0x19a, float:5.75E-43)
            if (r0 == r1) goto L_0x005a
            r1 = 414(0x19e, float:5.8E-43)
            if (r0 == r1) goto L_0x005a
            r1 = 501(0x1f5, float:7.02E-43)
            if (r0 == r1) goto L_0x005a
            r1 = 203(0xcb, float:2.84E-43)
            if (r0 == r1) goto L_0x005a
            r1 = 204(0xcc, float:2.86E-43)
            if (r0 == r1) goto L_0x005a
            r1 = 307(0x133, float:4.3E-43)
            if (r0 == r1) goto L_0x0031
            r1 = 308(0x134, float:4.32E-43)
            if (r0 == r1) goto L_0x005a
            r1 = 404(0x194, float:5.66E-43)
            if (r0 == r1) goto L_0x005a
            r1 = 405(0x195, float:5.68E-43)
            if (r0 == r1) goto L_0x005a
            switch(r0) {
                case 300: goto L_0x005a;
                case 301: goto L_0x005a;
                case 302: goto L_0x0031;
                default: goto L_0x0030;
            }
        L_0x0030:
            goto L_0x0059
        L_0x0031:
            java.lang.String r0 = "Expires"
            java.lang.String r0 = r3.mo19278a(r0)
            if (r0 != 0) goto L_0x005a
            i.d r0 = r3.mo19285t()
            int r0 = r0.mo19349c()
            r1 = -1
            if (r0 != r1) goto L_0x005a
            i.d r0 = r3.mo19285t()
            boolean r0 = r0.mo19348b()
            if (r0 != 0) goto L_0x005a
            i.d r0 = r3.mo19285t()
            boolean r0 = r0.mo19347a()
            if (r0 == 0) goto L_0x0059
            goto L_0x005a
        L_0x0059:
            return r2
        L_0x005a:
            i.d r3 = r3.mo19285t()
            boolean r3 = r3.mo19354h()
            if (r3 != 0) goto L_0x006f
            i.d r3 = r4.mo19601b()
            boolean r3 = r3.mo19354h()
            if (r3 != 0) goto L_0x006f
            r2 = 1
        L_0x006f:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: p113i.p114e0.p115e.C3503c.m11668a(i.a0, i.y):boolean");
    }

    /* renamed from: i.e0.e.c$a */
    /* compiled from: CacheStrategy */
    public static class C3504a {

        /* renamed from: a */
        final long f9722a;

        /* renamed from: b */
        final C3548y f9723b;

        /* renamed from: c */
        final C3480a0 f9724c;

        /* renamed from: d */
        private Date f9725d;

        /* renamed from: e */
        private String f9726e;

        /* renamed from: f */
        private Date f9727f;

        /* renamed from: g */
        private String f9728g;

        /* renamed from: h */
        private Date f9729h;

        /* renamed from: i */
        private long f9730i;

        /* renamed from: j */
        private long f9731j;

        /* renamed from: k */
        private String f9732k;

        /* renamed from: l */
        private int f9733l = -1;

        public C3504a(long j, C3548y yVar, C3480a0 a0Var) {
            this.f9722a = j;
            this.f9723b = yVar;
            this.f9724c = a0Var;
            if (a0Var != null) {
                this.f9730i = a0Var.mo19282c0();
                this.f9731j = a0Var.mo19280a0();
                C3537r x = a0Var.mo19290x();
                int b = x.mo19503b();
                for (int i = 0; i < b; i++) {
                    String a = x.mo19501a(i);
                    String b2 = x.mo19504b(i);
                    if ("Date".equalsIgnoreCase(a)) {
                        this.f9725d = C5938d.m19025a(b2);
                        this.f9726e = b2;
                    } else if ("Expires".equalsIgnoreCase(a)) {
                        this.f9729h = C5938d.m19025a(b2);
                    } else if ("Last-Modified".equalsIgnoreCase(a)) {
                        this.f9727f = C5938d.m19025a(b2);
                        this.f9728g = b2;
                    } else if ("ETag".equalsIgnoreCase(a)) {
                        this.f9732k = b2;
                    } else if ("Age".equalsIgnoreCase(a)) {
                        this.f9733l = C5940e.m19026a(b2, -1);
                    }
                }
            }
        }

        /* renamed from: b */
        private long m11670b() {
            Date date = this.f9725d;
            long j = 0;
            if (date != null) {
                j = Math.max(0, this.f9731j - date.getTime());
            }
            int i = this.f9733l;
            if (i != -1) {
                j = Math.max(j, TimeUnit.SECONDS.toMillis((long) i));
            }
            long j2 = this.f9731j;
            return j + (j2 - this.f9730i) + (this.f9722a - j2);
        }

        /* renamed from: c */
        private long m11671c() {
            long j;
            long j2;
            C3495d t = this.f9724c.mo19285t();
            if (t.mo19349c() != -1) {
                return TimeUnit.SECONDS.toMillis((long) t.mo19349c());
            }
            if (this.f9729h != null) {
                Date date = this.f9725d;
                if (date != null) {
                    j2 = date.getTime();
                } else {
                    j2 = this.f9731j;
                }
                long time = this.f9729h.getTime() - j2;
                if (time > 0) {
                    return time;
                }
                return 0;
            } else if (this.f9727f == null || this.f9724c.mo19281b0().mo19607g().mo19531l() != null) {
                return 0;
            } else {
                Date date2 = this.f9725d;
                if (date2 != null) {
                    j = date2.getTime();
                } else {
                    j = this.f9730i;
                }
                long time2 = j - this.f9727f.getTime();
                if (time2 > 0) {
                    return time2 / 10;
                }
                return 0;
            }
        }

        /* renamed from: d */
        private C3503c m11672d() {
            if (this.f9724c == null) {
                return new C3503c(this.f9723b, (C3480a0) null);
            }
            if (this.f9723b.mo19604d() && this.f9724c.mo19289w() == null) {
                return new C3503c(this.f9723b, (C3480a0) null);
            }
            if (!C3503c.m11668a(this.f9724c, this.f9723b)) {
                return new C3503c(this.f9723b, (C3480a0) null);
            }
            C3495d b = this.f9723b.mo19601b();
            if (b.mo19353g() || m11669a(this.f9723b)) {
                return new C3503c(this.f9723b, (C3480a0) null);
            }
            C3495d t = this.f9724c.mo19285t();
            long b2 = m11670b();
            long c = m11671c();
            if (b.mo19349c() != -1) {
                c = Math.min(c, TimeUnit.SECONDS.toMillis((long) b.mo19349c()));
            }
            long j = 0;
            long millis = b.mo19351e() != -1 ? TimeUnit.SECONDS.toMillis((long) b.mo19351e()) : 0;
            if (!t.mo19352f() && b.mo19350d() != -1) {
                j = TimeUnit.SECONDS.toMillis((long) b.mo19350d());
            }
            if (!t.mo19353g()) {
                long j2 = millis + b2;
                if (j2 < j + c) {
                    C3480a0.C3481a X = this.f9724c.mo19275X();
                    if (j2 >= c) {
                        X.mo19302a("Warning", "110 HttpURLConnection \"Response is stale\"");
                    }
                    if (b2 > 86400000 && m11673e()) {
                        X.mo19302a("Warning", "113 HttpURLConnection \"Heuristic expiration\"");
                    }
                    return new C3503c((C3548y) null, X.mo19303a());
                }
            }
            String str = this.f9732k;
            String str2 = "If-Modified-Since";
            if (str != null) {
                str2 = "If-None-Match";
            } else if (this.f9727f != null) {
                str = this.f9728g;
            } else if (this.f9725d == null) {
                return new C3503c(this.f9723b, (C3480a0) null);
            } else {
                str = this.f9726e;
            }
            C3537r.C3538a a = this.f9723b.mo19603c().mo19500a();
            C3499a.f9700a.mo19373a(a, str2, str);
            C3548y.C3549a f = this.f9723b.mo19606f();
            f.mo19610a(a.mo19511a());
            return new C3503c(f.mo19616a(), this.f9724c);
        }

        /* renamed from: e */
        private boolean m11673e() {
            return this.f9724c.mo19285t().mo19349c() == -1 && this.f9729h == null;
        }

        /* renamed from: a */
        public C3503c mo19380a() {
            C3503c d = m11672d();
            return (d.f9720a == null || !this.f9723b.mo19601b().mo19355i()) ? d : new C3503c((C3548y) null, (C3480a0) null);
        }

        /* renamed from: a */
        private static boolean m11669a(C3548y yVar) {
            return (yVar.mo19600a("If-Modified-Since") == null && yVar.mo19600a("If-None-Match") == null) ? false : true;
        }
    }
}
