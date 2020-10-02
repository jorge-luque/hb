package com.applovin.impl.sdk.p052d;

import android.app.Activity;
import android.os.Build;
import com.applovin.impl.sdk.C1928g;
import com.applovin.impl.sdk.C1941j;
import com.applovin.impl.sdk.C1945k;
import com.applovin.impl.sdk.C1977q;
import com.applovin.impl.sdk.p049ad.C1821d;
import com.applovin.impl.sdk.p050b.C1841c;
import com.applovin.impl.sdk.p050b.C1843e;
import com.applovin.impl.sdk.p052d.C1907s;
import com.applovin.impl.sdk.utils.C1989e;
import com.applovin.impl.sdk.utils.C2021k;
import com.applovin.impl.sdk.utils.C2029r;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinAdType;
import com.applovin.sdk.AppLovinSdk;
import java.util.concurrent.TimeUnit;

/* renamed from: com.applovin.impl.sdk.d.r */
public class C1905r extends C1864a {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final C1941j f6278a;

    public C1905r(C1941j jVar) {
        super("TaskInitializeSdk", jVar);
        this.f6278a = jVar;
    }

    /* renamed from: a */
    private void m7340a() {
        if (!this.f6278a.mo8604x().mo7889a()) {
            Activity ah = this.f6278a.mo8572ah();
            if (ah != null) {
                this.f6278a.mo8604x().mo7886a(ah);
            } else {
                this.f6278a.mo8533L().mo8476a(new C1871ad(this.f6278a, true, new Runnable() {
                    public void run() {
                        C1905r.this.f6278a.mo8604x().mo7886a(C1905r.this.f6278a.mo8565aa().mo8070a());
                    }
                }), C1907s.C1909a.MAIN, TimeUnit.SECONDS.toMillis(1));
            }
        }
    }

    /* JADX WARNING: type inference failed for: r3v0, types: [com.applovin.impl.sdk.b.c<java.lang.Boolean>, com.applovin.impl.sdk.b.c] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m7341a(com.applovin.impl.sdk.p050b.C1841c<java.lang.Boolean> r3) {
        /*
            r2 = this;
            com.applovin.impl.sdk.j r0 = r2.f6278a
            java.lang.Object r3 = r0.mo8549a(r3)
            java.lang.Boolean r3 = (java.lang.Boolean) r3
            boolean r3 = r3.booleanValue()
            if (r3 == 0) goto L_0x0021
            com.applovin.sdk.AppLovinAdSize r3 = com.applovin.sdk.AppLovinAdSize.INTERSTITIAL
            com.applovin.sdk.AppLovinAdType r0 = com.applovin.sdk.AppLovinAdType.INCENTIVIZED
            com.applovin.impl.sdk.j r1 = r2.f6278a
            com.applovin.impl.sdk.ad.d r3 = com.applovin.impl.sdk.p049ad.C1821d.m6857a((com.applovin.sdk.AppLovinAdSize) r3, (com.applovin.sdk.AppLovinAdType) r0, (com.applovin.impl.sdk.C1941j) r1)
            com.applovin.impl.sdk.j r0 = r2.f6278a
            com.applovin.impl.sdk.c r0 = r0.mo8541T()
            r0.mo8336f(r3)
        L_0x0021:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.sdk.p052d.C1905r.m7341a(com.applovin.impl.sdk.b.c):void");
    }

    /* renamed from: b */
    private void m7342b() {
        this.f6278a.mo8533L().mo8475a((C1864a) new C1875b(this.f6278a), C1907s.C1909a.MAIN);
    }

    /* renamed from: c */
    private void m7343c() {
        this.f6278a.mo8541T().mo8325a();
        this.f6278a.mo8542U().mo8750a();
    }

    /* renamed from: h */
    private void m7344h() {
        m7345i();
        m7346j();
    }

    /* renamed from: i */
    private void m7345i() {
        C1841c<Boolean> cVar = C1841c.f5881bb;
        String str = (String) this.f6278a.mo8549a(C1841c.f5880ba);
        boolean z = false;
        if (str.length() > 0) {
            for (String fromString : C1989e.m7831a(str)) {
                AppLovinAdSize fromString2 = AppLovinAdSize.fromString(fromString);
                if (fromString2 != null) {
                    this.f6278a.mo8541T().mo8336f(C1821d.m6857a(fromString2, AppLovinAdType.REGULAR, this.f6278a));
                    if (AppLovinAdSize.INTERSTITIAL.getLabel().equals(fromString2.getLabel())) {
                        m7341a(cVar);
                        z = true;
                    }
                }
            }
        }
        if (!z) {
            m7341a(cVar);
        }
    }

    /* renamed from: j */
    private void m7346j() {
        if (((Boolean) this.f6278a.mo8549a(C1841c.f5882bc)).booleanValue()) {
            this.f6278a.mo8542U().mo8336f(C1821d.m6871g(this.f6278a));
        }
    }

    /* renamed from: k */
    private void m7347k() {
        String str;
        if (!this.f6278a.mo8584e()) {
            C2021k kVar = new C2021k();
            kVar.mo8801a().mo8802a("AppLovin SDK");
            kVar.mo8803a("Version", AppLovinSdk.VERSION).mo8803a("Plugin Version", this.f6278a.mo8549a(C1841c.f5975dR)).mo8803a("SafeDK Version", C2029r.m8040f());
            boolean e = this.f6278a.mo8526D().mo8311e();
            if (e) {
                str = this.f6278a.mo8536O().mo8615d().f6468b + " (use this for test devices)";
            } else {
                str = "<Enable verbose logging to see the GAID to use for test devices - https://monetization-support.applovin.com/hc/en-us/articles/236114328-How-can-I-expose-verbose-logging-for-the-SDK>";
            }
            kVar.mo8803a("OS", C2029r.m8037e() + " " + Build.VERSION.SDK_INT).mo8803a("GAID", str).mo8803a("SDK Key", this.f6278a.mo8599t());
            C1945k.C1950d b = this.f6278a.mo8536O().mo8613b();
            kVar.mo8803a("Model", b.f6501d).mo8803a("Locale", b.f6508k).mo8803a("Emulator", Boolean.valueOf(b.f6480A));
            kVar.mo8803a("Application ID", mo8412f().getPackageName()).mo8803a("Test Mode On", Boolean.valueOf(this.f6278a.mo8573ai())).mo8803a("Verbose Logging On", Boolean.valueOf(e));
            kVar.mo8803a("Mediation Provider", this.f6278a.mo8593n()).mo8803a("TG", C2029r.m7996a(C1843e.f6093g, this.f6278a)).mo8803a("LTG", C2029r.m7996a(C1843e.f6094h, this.f6278a)).mo8803a("ARU", C1928g.m7413b(mo8412f())).mo8803a("HUC", C1928g.m7409a(mo8412f())).mo8803a("DNS", C1928g.m7415c(mo8412f()));
            kVar.mo8801a();
            C1977q.m7748f("AppLovinSdk", kVar.toString());
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0133, code lost:
        if (r12.f6278a.mo8583d() == false) goto L_0x0136;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0136, code lost:
        r2 = "failed";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0137, code lost:
        r8.append(r2);
        r8.append(" in ");
        r8.append(java.lang.System.currentTimeMillis() - r6);
        r8.append("ms");
        mo8405a(r8.toString());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x014f, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x00eb, code lost:
        if (r12.f6278a.mo8583d() != false) goto L_0x0137;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void run() {
        /*
            r12 = this;
            java.lang.String r0 = "ms"
            java.lang.String r1 = " in "
            java.lang.String r2 = "succeeded"
            java.lang.String r3 = "failed"
            java.lang.String r4 = " initialization "
            java.lang.String r5 = "AppLovin SDK "
            long r6 = java.lang.System.currentTimeMillis()
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r9 = "Initializing AppLovin SDK "
            r8.append(r9)
            java.lang.String r9 = com.applovin.sdk.AppLovinSdk.VERSION
            r8.append(r9)
            java.lang.String r9 = "..."
            r8.append(r9)
            java.lang.String r8 = r8.toString()
            r12.mo8405a(r8)
            com.applovin.impl.sdk.j r8 = r12.f6278a     // Catch:{ all -> 0x00ee }
            com.applovin.impl.sdk.c.h r8 = r8.mo8534M()     // Catch:{ all -> 0x00ee }
            r8.mo8395d()     // Catch:{ all -> 0x00ee }
            com.applovin.impl.sdk.j r8 = r12.f6278a     // Catch:{ all -> 0x00ee }
            com.applovin.impl.sdk.c.h r8 = r8.mo8534M()     // Catch:{ all -> 0x00ee }
            com.applovin.impl.sdk.c.g r9 = com.applovin.impl.sdk.p051c.C1859g.f6187b     // Catch:{ all -> 0x00ee }
            r8.mo8394c(r9)     // Catch:{ all -> 0x00ee }
            com.applovin.impl.sdk.j r8 = r12.f6278a     // Catch:{ all -> 0x00ee }
            com.applovin.impl.sdk.o r8 = r8.mo8543V()     // Catch:{ all -> 0x00ee }
            android.content.Context r9 = r12.mo8412f()     // Catch:{ all -> 0x00ee }
            r8.mo8726a((android.content.Context) r9)     // Catch:{ all -> 0x00ee }
            com.applovin.impl.sdk.j r8 = r12.f6278a     // Catch:{ all -> 0x00ee }
            com.applovin.impl.sdk.o r8 = r8.mo8543V()     // Catch:{ all -> 0x00ee }
            android.content.Context r9 = r12.mo8412f()     // Catch:{ all -> 0x00ee }
            r8.mo8729b((android.content.Context) r9)     // Catch:{ all -> 0x00ee }
            r12.m7343c()     // Catch:{ all -> 0x00ee }
            r12.m7344h()     // Catch:{ all -> 0x00ee }
            r12.m7340a()     // Catch:{ all -> 0x00ee }
            com.applovin.impl.sdk.j r8 = r12.f6278a     // Catch:{ all -> 0x00ee }
            com.applovin.impl.sdk.c.c r8 = r8.mo8545X()     // Catch:{ all -> 0x00ee }
            r8.mo8347a()     // Catch:{ all -> 0x00ee }
            r12.m7342b()     // Catch:{ all -> 0x00ee }
            com.applovin.impl.sdk.j r8 = r12.f6278a     // Catch:{ all -> 0x00ee }
            com.applovin.impl.sdk.k r8 = r8.mo8536O()     // Catch:{ all -> 0x00ee }
            r8.mo8616e()     // Catch:{ all -> 0x00ee }
            com.applovin.impl.sdk.j r8 = r12.f6278a     // Catch:{ all -> 0x00ee }
            com.applovin.impl.sdk.utils.n r8 = r8.mo8568ad()     // Catch:{ all -> 0x00ee }
            r8.mo8806a()     // Catch:{ all -> 0x00ee }
            com.applovin.impl.sdk.j r8 = r12.f6278a     // Catch:{ all -> 0x00ee }
            r9 = 1
            r8.mo8564a((boolean) r9)     // Catch:{ all -> 0x00ee }
            r12.m7347k()     // Catch:{ all -> 0x00ee }
            com.applovin.impl.sdk.j r8 = r12.f6278a     // Catch:{ all -> 0x00ee }
            com.applovin.impl.sdk.network.e r8 = r8.mo8535N()     // Catch:{ all -> 0x00ee }
            r8.mo8677a()     // Catch:{ all -> 0x00ee }
            com.applovin.impl.sdk.j r8 = r12.f6278a     // Catch:{ all -> 0x00ee }
            com.applovin.sdk.AppLovinEventService r8 = r8.mo8596q()     // Catch:{ all -> 0x00ee }
            com.applovin.impl.sdk.EventServiceImpl r8 = (com.applovin.impl.sdk.EventServiceImpl) r8     // Catch:{ all -> 0x00ee }
            r8.maybeTrackAppOpenEvent()     // Catch:{ all -> 0x00ee }
            com.applovin.impl.sdk.j r8 = r12.f6278a     // Catch:{ all -> 0x00ee }
            com.applovin.impl.mediation.a.a r8 = r8.mo8523A()     // Catch:{ all -> 0x00ee }
            boolean r8 = r8.mo7631a()     // Catch:{ all -> 0x00ee }
            if (r8 == 0) goto L_0x00b2
            com.applovin.impl.sdk.j r8 = r12.f6278a     // Catch:{ all -> 0x00ee }
            com.applovin.impl.mediation.a.a r8 = r8.mo8523A()     // Catch:{ all -> 0x00ee }
            r8.mo7632b()     // Catch:{ all -> 0x00ee }
        L_0x00b2:
            com.applovin.impl.sdk.j r8 = r12.f6278a
            com.applovin.impl.sdk.b.c<java.lang.Boolean> r9 = com.applovin.impl.sdk.p050b.C1841c.f5843aq
            java.lang.Object r8 = r8.mo8549a(r9)
            java.lang.Boolean r8 = (java.lang.Boolean) r8
            boolean r8 = r8.booleanValue()
            if (r8 == 0) goto L_0x00d5
            com.applovin.impl.sdk.j r8 = r12.f6278a
            com.applovin.impl.sdk.b.c<java.lang.Long> r9 = com.applovin.impl.sdk.p050b.C1841c.f5844ar
            java.lang.Object r8 = r8.mo8549a(r9)
            java.lang.Long r8 = (java.lang.Long) r8
            long r8 = r8.longValue()
            com.applovin.impl.sdk.j r10 = r12.f6278a
            r10.mo8553a((long) r8)
        L_0x00d5:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            r8.append(r5)
            java.lang.String r5 = com.applovin.sdk.AppLovinSdk.VERSION
            r8.append(r5)
            r8.append(r4)
            com.applovin.impl.sdk.j r4 = r12.f6278a
            boolean r4 = r4.mo8583d()
            if (r4 == 0) goto L_0x0136
            goto L_0x0137
        L_0x00ee:
            r8 = move-exception
            java.lang.String r9 = "Unable to initialize SDK."
            r12.mo8406a(r9, r8)     // Catch:{ all -> 0x0150 }
            com.applovin.impl.sdk.j r8 = r12.f6278a     // Catch:{ all -> 0x0150 }
            r9 = 0
            r8.mo8564a((boolean) r9)     // Catch:{ all -> 0x0150 }
            com.applovin.impl.sdk.j r8 = r12.f6278a
            com.applovin.impl.sdk.b.c<java.lang.Boolean> r9 = com.applovin.impl.sdk.p050b.C1841c.f5843aq
            java.lang.Object r8 = r8.mo8549a(r9)
            java.lang.Boolean r8 = (java.lang.Boolean) r8
            boolean r8 = r8.booleanValue()
            if (r8 == 0) goto L_0x011d
            com.applovin.impl.sdk.j r8 = r12.f6278a
            com.applovin.impl.sdk.b.c<java.lang.Long> r9 = com.applovin.impl.sdk.p050b.C1841c.f5844ar
            java.lang.Object r8 = r8.mo8549a(r9)
            java.lang.Long r8 = (java.lang.Long) r8
            long r8 = r8.longValue()
            com.applovin.impl.sdk.j r10 = r12.f6278a
            r10.mo8553a((long) r8)
        L_0x011d:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            r8.append(r5)
            java.lang.String r5 = com.applovin.sdk.AppLovinSdk.VERSION
            r8.append(r5)
            r8.append(r4)
            com.applovin.impl.sdk.j r4 = r12.f6278a
            boolean r4 = r4.mo8583d()
            if (r4 == 0) goto L_0x0136
            goto L_0x0137
        L_0x0136:
            r2 = r3
        L_0x0137:
            r8.append(r2)
            r8.append(r1)
            long r1 = java.lang.System.currentTimeMillis()
            long r1 = r1 - r6
            r8.append(r1)
            r8.append(r0)
            java.lang.String r0 = r8.toString()
            r12.mo8405a(r0)
            return
        L_0x0150:
            r8 = move-exception
            com.applovin.impl.sdk.j r9 = r12.f6278a
            com.applovin.impl.sdk.b.c<java.lang.Boolean> r10 = com.applovin.impl.sdk.p050b.C1841c.f5843aq
            java.lang.Object r9 = r9.mo8549a(r10)
            java.lang.Boolean r9 = (java.lang.Boolean) r9
            boolean r9 = r9.booleanValue()
            if (r9 == 0) goto L_0x0174
            com.applovin.impl.sdk.j r9 = r12.f6278a
            com.applovin.impl.sdk.b.c<java.lang.Long> r10 = com.applovin.impl.sdk.p050b.C1841c.f5844ar
            java.lang.Object r9 = r9.mo8549a(r10)
            java.lang.Long r9 = (java.lang.Long) r9
            long r9 = r9.longValue()
            com.applovin.impl.sdk.j r11 = r12.f6278a
            r11.mo8553a((long) r9)
        L_0x0174:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            r9.append(r5)
            java.lang.String r5 = com.applovin.sdk.AppLovinSdk.VERSION
            r9.append(r5)
            r9.append(r4)
            com.applovin.impl.sdk.j r4 = r12.f6278a
            boolean r4 = r4.mo8583d()
            if (r4 == 0) goto L_0x018d
            goto L_0x018e
        L_0x018d:
            r2 = r3
        L_0x018e:
            r9.append(r2)
            r9.append(r1)
            long r1 = java.lang.System.currentTimeMillis()
            long r1 = r1 - r6
            r9.append(r1)
            r9.append(r0)
            java.lang.String r0 = r9.toString()
            r12.mo8405a(r0)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.sdk.p052d.C1905r.run():void");
    }
}
