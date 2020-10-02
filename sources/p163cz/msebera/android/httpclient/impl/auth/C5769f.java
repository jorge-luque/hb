package p163cz.msebera.android.httpclient.impl.auth;

import p163cz.msebera.android.httpclient.C5896l;
import p163cz.msebera.android.httpclient.C5901q;
import p163cz.msebera.android.httpclient.auth.C5548b;
import p163cz.msebera.android.httpclient.auth.C5555h;
import p163cz.msebera.android.httpclient.client.C5577c;
import p163cz.msebera.android.httpclient.p177d0.C5695b;
import p163cz.msebera.android.httpclient.p186j0.C5875e;

/* renamed from: cz.msebera.android.httpclient.impl.auth.f */
/* compiled from: HttpAuthenticator */
public class C5769f {

    /* renamed from: a */
    public C5695b f14873a;

    /* renamed from: cz.msebera.android.httpclient.impl.auth.f$a */
    /* compiled from: HttpAuthenticator */
    static /* synthetic */ class C5770a {

        /* renamed from: a */
        static final /* synthetic */ int[] f14874a;

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|12) */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                cz.msebera.android.httpclient.auth.b[] r0 = p163cz.msebera.android.httpclient.auth.C5548b.m17690a()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f14874a = r0
                cz.msebera.android.httpclient.auth.b r1 = p163cz.msebera.android.httpclient.auth.C5548b.CHALLENGED     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f14874a     // Catch:{ NoSuchFieldError -> 0x001d }
                cz.msebera.android.httpclient.auth.b r1 = p163cz.msebera.android.httpclient.auth.C5548b.HANDSHAKE     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f14874a     // Catch:{ NoSuchFieldError -> 0x0028 }
                cz.msebera.android.httpclient.auth.b r1 = p163cz.msebera.android.httpclient.auth.C5548b.SUCCESS     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f14874a     // Catch:{ NoSuchFieldError -> 0x0033 }
                cz.msebera.android.httpclient.auth.b r1 = p163cz.msebera.android.httpclient.auth.C5548b.FAILURE     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f14874a     // Catch:{ NoSuchFieldError -> 0x003e }
                cz.msebera.android.httpclient.auth.b r1 = p163cz.msebera.android.httpclient.auth.C5548b.UNCHALLENGED     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: p163cz.msebera.android.httpclient.impl.auth.C5769f.C5770a.<clinit>():void");
        }
    }

    public C5769f(C5695b bVar) {
        this.f14873a = bVar == null ? new C5695b(getClass()) : bVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:39:0x00c0 A[Catch:{ MalformedChallengeException -> 0x00e8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00e7 A[RETURN] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean mo33437a(p163cz.msebera.android.httpclient.C5896l r7, p163cz.msebera.android.httpclient.C5901q r8, p163cz.msebera.android.httpclient.client.C5577c r9, p163cz.msebera.android.httpclient.auth.C5555h r10, p163cz.msebera.android.httpclient.p186j0.C5875e r11) {
        /*
            r6 = this;
            r0 = 0
            cz.msebera.android.httpclient.d0.b r1 = r6.f14873a     // Catch:{ MalformedChallengeException -> 0x00e8 }
            boolean r1 = r1.mo33168a()     // Catch:{ MalformedChallengeException -> 0x00e8 }
            if (r1 == 0) goto L_0x0023
            cz.msebera.android.httpclient.d0.b r1 = r6.f14873a     // Catch:{ MalformedChallengeException -> 0x00e8 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ MalformedChallengeException -> 0x00e8 }
            r2.<init>()     // Catch:{ MalformedChallengeException -> 0x00e8 }
            java.lang.String r3 = r7.mo33689e()     // Catch:{ MalformedChallengeException -> 0x00e8 }
            r2.append(r3)     // Catch:{ MalformedChallengeException -> 0x00e8 }
            java.lang.String r3 = " requested authentication"
            r2.append(r3)     // Catch:{ MalformedChallengeException -> 0x00e8 }
            java.lang.String r2 = r2.toString()     // Catch:{ MalformedChallengeException -> 0x00e8 }
            r1.mo33166a(r2)     // Catch:{ MalformedChallengeException -> 0x00e8 }
        L_0x0023:
            java.util.Map r1 = r9.mo32913a((p163cz.msebera.android.httpclient.C5896l) r7, (p163cz.msebera.android.httpclient.C5901q) r8, (p163cz.msebera.android.httpclient.p186j0.C5875e) r11)     // Catch:{ MalformedChallengeException -> 0x00e8 }
            boolean r2 = r1.isEmpty()     // Catch:{ MalformedChallengeException -> 0x00e8 }
            if (r2 == 0) goto L_0x0035
            cz.msebera.android.httpclient.d0.b r7 = r6.f14873a     // Catch:{ MalformedChallengeException -> 0x00e8 }
            java.lang.String r8 = "Response contains no authentication challenges"
            r7.mo33166a(r8)     // Catch:{ MalformedChallengeException -> 0x00e8 }
            return r0
        L_0x0035:
            cz.msebera.android.httpclient.auth.c r2 = r10.mo32858b()     // Catch:{ MalformedChallengeException -> 0x00e8 }
            int[] r3 = p163cz.msebera.android.httpclient.impl.auth.C5769f.C5770a.f14874a     // Catch:{ MalformedChallengeException -> 0x00e8 }
            cz.msebera.android.httpclient.auth.b r4 = r10.mo32860d()     // Catch:{ MalformedChallengeException -> 0x00e8 }
            int r4 = r4.ordinal()     // Catch:{ MalformedChallengeException -> 0x00e8 }
            r3 = r3[r4]     // Catch:{ MalformedChallengeException -> 0x00e8 }
            r4 = 1
            if (r3 == r4) goto L_0x005a
            r5 = 2
            if (r3 == r5) goto L_0x005a
            r5 = 3
            if (r3 == r5) goto L_0x0056
            r5 = 4
            if (r3 == r5) goto L_0x0055
            r5 = 5
            if (r3 == r5) goto L_0x0070
            goto L_0x00b4
        L_0x0055:
            return r0
        L_0x0056:
            r10.mo32861e()     // Catch:{ MalformedChallengeException -> 0x00e8 }
            goto L_0x00b4
        L_0x005a:
            if (r2 != 0) goto L_0x0070
            cz.msebera.android.httpclient.d0.b r8 = r6.f14873a     // Catch:{ MalformedChallengeException -> 0x00e8 }
            java.lang.String r1 = "Auth scheme is null"
            r8.mo33166a(r1)     // Catch:{ MalformedChallengeException -> 0x00e8 }
            r8 = 0
            r9.mo32915a((p163cz.msebera.android.httpclient.C5896l) r7, (p163cz.msebera.android.httpclient.auth.C5549c) r8, (p163cz.msebera.android.httpclient.p186j0.C5875e) r11)     // Catch:{ MalformedChallengeException -> 0x00e8 }
            r10.mo32861e()     // Catch:{ MalformedChallengeException -> 0x00e8 }
            cz.msebera.android.httpclient.auth.b r7 = p163cz.msebera.android.httpclient.auth.C5548b.FAILURE     // Catch:{ MalformedChallengeException -> 0x00e8 }
            r10.mo32853a((p163cz.msebera.android.httpclient.auth.C5548b) r7)     // Catch:{ MalformedChallengeException -> 0x00e8 }
            return r0
        L_0x0070:
            if (r2 == 0) goto L_0x00b4
            java.lang.String r3 = r2.mo32842d()     // Catch:{ MalformedChallengeException -> 0x00e8 }
            java.util.Locale r5 = java.util.Locale.ROOT     // Catch:{ MalformedChallengeException -> 0x00e8 }
            java.lang.String r3 = r3.toLowerCase(r5)     // Catch:{ MalformedChallengeException -> 0x00e8 }
            java.lang.Object r3 = r1.get(r3)     // Catch:{ MalformedChallengeException -> 0x00e8 }
            cz.msebera.android.httpclient.d r3 = (p163cz.msebera.android.httpclient.C5691d) r3     // Catch:{ MalformedChallengeException -> 0x00e8 }
            if (r3 == 0) goto L_0x00b1
            cz.msebera.android.httpclient.d0.b r8 = r6.f14873a     // Catch:{ MalformedChallengeException -> 0x00e8 }
            java.lang.String r1 = "Authorization challenge processed"
            r8.mo33166a(r1)     // Catch:{ MalformedChallengeException -> 0x00e8 }
            r2.mo32839a(r3)     // Catch:{ MalformedChallengeException -> 0x00e8 }
            boolean r8 = r2.mo32841c()     // Catch:{ MalformedChallengeException -> 0x00e8 }
            if (r8 == 0) goto L_0x00ab
            cz.msebera.android.httpclient.d0.b r8 = r6.f14873a     // Catch:{ MalformedChallengeException -> 0x00e8 }
            java.lang.String r1 = "Authentication failed"
            r8.mo33166a(r1)     // Catch:{ MalformedChallengeException -> 0x00e8 }
            cz.msebera.android.httpclient.auth.c r8 = r10.mo32858b()     // Catch:{ MalformedChallengeException -> 0x00e8 }
            r9.mo32915a((p163cz.msebera.android.httpclient.C5896l) r7, (p163cz.msebera.android.httpclient.auth.C5549c) r8, (p163cz.msebera.android.httpclient.p186j0.C5875e) r11)     // Catch:{ MalformedChallengeException -> 0x00e8 }
            r10.mo32861e()     // Catch:{ MalformedChallengeException -> 0x00e8 }
            cz.msebera.android.httpclient.auth.b r7 = p163cz.msebera.android.httpclient.auth.C5548b.FAILURE     // Catch:{ MalformedChallengeException -> 0x00e8 }
            r10.mo32853a((p163cz.msebera.android.httpclient.auth.C5548b) r7)     // Catch:{ MalformedChallengeException -> 0x00e8 }
            return r0
        L_0x00ab:
            cz.msebera.android.httpclient.auth.b r7 = p163cz.msebera.android.httpclient.auth.C5548b.HANDSHAKE     // Catch:{ MalformedChallengeException -> 0x00e8 }
            r10.mo32853a((p163cz.msebera.android.httpclient.auth.C5548b) r7)     // Catch:{ MalformedChallengeException -> 0x00e8 }
            return r4
        L_0x00b1:
            r10.mo32861e()     // Catch:{ MalformedChallengeException -> 0x00e8 }
        L_0x00b4:
            java.util.Queue r7 = r9.mo32914a(r1, r7, r8, r11)     // Catch:{ MalformedChallengeException -> 0x00e8 }
            if (r7 == 0) goto L_0x00e7
            boolean r8 = r7.isEmpty()     // Catch:{ MalformedChallengeException -> 0x00e8 }
            if (r8 != 0) goto L_0x00e7
            cz.msebera.android.httpclient.d0.b r8 = r6.f14873a     // Catch:{ MalformedChallengeException -> 0x00e8 }
            boolean r8 = r8.mo33168a()     // Catch:{ MalformedChallengeException -> 0x00e8 }
            if (r8 == 0) goto L_0x00de
            cz.msebera.android.httpclient.d0.b r8 = r6.f14873a     // Catch:{ MalformedChallengeException -> 0x00e8 }
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ MalformedChallengeException -> 0x00e8 }
            r9.<init>()     // Catch:{ MalformedChallengeException -> 0x00e8 }
            java.lang.String r11 = "Selected authentication options: "
            r9.append(r11)     // Catch:{ MalformedChallengeException -> 0x00e8 }
            r9.append(r7)     // Catch:{ MalformedChallengeException -> 0x00e8 }
            java.lang.String r9 = r9.toString()     // Catch:{ MalformedChallengeException -> 0x00e8 }
            r8.mo33166a(r9)     // Catch:{ MalformedChallengeException -> 0x00e8 }
        L_0x00de:
            cz.msebera.android.httpclient.auth.b r8 = p163cz.msebera.android.httpclient.auth.C5548b.CHALLENGED     // Catch:{ MalformedChallengeException -> 0x00e8 }
            r10.mo32853a((p163cz.msebera.android.httpclient.auth.C5548b) r8)     // Catch:{ MalformedChallengeException -> 0x00e8 }
            r10.mo32857a((java.util.Queue<p163cz.msebera.android.httpclient.auth.C5547a>) r7)     // Catch:{ MalformedChallengeException -> 0x00e8 }
            return r4
        L_0x00e7:
            return r0
        L_0x00e8:
            r7 = move-exception
            cz.msebera.android.httpclient.d0.b r8 = r6.f14873a
            boolean r8 = r8.mo33175d()
            if (r8 == 0) goto L_0x010b
            cz.msebera.android.httpclient.d0.b r8 = r6.f14873a
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r11 = "Malformed challenge: "
            r9.append(r11)
            java.lang.String r7 = r7.getMessage()
            r9.append(r7)
            java.lang.String r7 = r9.toString()
            r8.mo33174d(r7)
        L_0x010b:
            r10.mo32861e()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p163cz.msebera.android.httpclient.impl.auth.C5769f.mo33437a(cz.msebera.android.httpclient.l, cz.msebera.android.httpclient.q, cz.msebera.android.httpclient.client.c, cz.msebera.android.httpclient.auth.h, cz.msebera.android.httpclient.j0.e):boolean");
    }

    /* renamed from: b */
    public boolean mo33438b(C5896l lVar, C5901q qVar, C5577c cVar, C5555h hVar, C5875e eVar) {
        if (cVar.mo32917b(lVar, qVar, eVar)) {
            this.f14873a.mo33166a("Authentication required");
            if (hVar.mo32860d() == C5548b.SUCCESS) {
                cVar.mo32915a(lVar, hVar.mo32858b(), eVar);
            }
            return true;
        }
        int i = C5770a.f14874a[hVar.mo32860d().ordinal()];
        if (i == 1 || i == 2) {
            this.f14873a.mo33166a("Authentication succeeded");
            hVar.mo32853a(C5548b.SUCCESS);
            cVar.mo32916b(lVar, hVar.mo32858b(), eVar);
            return false;
        } else if (i == 3) {
            return false;
        } else {
            hVar.mo32853a(C5548b.UNCHALLENGED);
            return false;
        }
    }
}
