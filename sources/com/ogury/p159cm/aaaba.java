package com.ogury.p159cm;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.ogury.core.OguryError;
import com.ogury.crashreport.CrashConfig;
import com.ogury.crashreport.CrashReport;
import com.ogury.crashreport.SdkInfo;
import com.ogury.p159cm.OguryChoiceManager;
import com.ogury.p159cm.aabba;
import com.ogury.p159cm.abaaa;
import com.ogury.p159cm.abbba;
import java.util.Date;
import java.util.concurrent.CountDownLatch;

/* renamed from: com.ogury.cm.aaaba */
public abstract class aaaba implements aabcb {

    /* renamed from: b */
    public static final aaaaa f11947b = new aaaaa((baaca) null);

    /* renamed from: a */
    public abbcb f11948a;

    /* renamed from: c */
    private acbbb f11949c = new acbbb();
    /* access modifiers changed from: private */

    /* renamed from: d */
    public String f11950d = "";

    /* renamed from: e */
    private Handler f11951e = new Handler(Looper.getMainLooper());

    /* renamed from: f */
    private aacba f11952f = aacba.f12030a;

    /* renamed from: g */
    private aacbc f11953g;

    /* renamed from: h */
    private abaca f11954h = new abaca();

    /* renamed from: i */
    private acbca f11955i = new acbca();

    /* renamed from: j */
    private aaaac f11956j = aaaac.f11933a;

    /* renamed from: k */
    private aabcc f11957k = new aacaa(this);

    /* renamed from: l */
    private boolean f11958l;

    /* renamed from: m */
    private String f11959m = "";

    /* renamed from: com.ogury.cm.aaaba$aaaaa */
    public static final class aaaaa {
        private aaaaa() {
        }

        public /* synthetic */ aaaaa(baaca baaca) {
            this();
        }
    }

    /* renamed from: com.ogury.cm.aaaba$aaaab */
    public static final class aaaab implements acaac {

        /* renamed from: a */
        final /* synthetic */ CountDownLatch f11960a;

        aaaab(CountDownLatch countDownLatch) {
            this.f11960a = countDownLatch;
        }

        /* renamed from: a */
        public final void mo29400a() {
            this.f11960a.countDown();
        }
    }

    /* renamed from: com.ogury.cm.aaaba$aaaac */
    public static final class aaaac implements aacac {

        /* renamed from: a */
        final /* synthetic */ aaaba f11961a;

        /* renamed from: b */
        final /* synthetic */ CountDownLatch f11962b;

        aaaac(aaaba aaaba, CountDownLatch countDownLatch) {
            this.f11961a = aaaba;
            this.f11962b = countDownLatch;
        }

        /* renamed from: a */
        public final void mo29386a(String str) {
            accbb.m15218b(str, "aaid");
            this.f11961a.mo29394a(str);
            this.f11962b.countDown();
        }
    }

    /* renamed from: com.ogury.cm.aaaba$aaaba  reason: collision with other inner class name */
    public static final class C6849aaaba implements aacbc {

        /* renamed from: a */
        final /* synthetic */ aaaba f11963a;

        /* renamed from: b */
        final /* synthetic */ Context f11964b;

        C6849aaaba(aaaba aaaba, Context context) {
            this.f11963a = aaaba;
            this.f11964b = context;
        }

        /* renamed from: a */
        public final void mo29384a(OguryError oguryError) {
            accbb.m15218b(oguryError, "error");
            aaaba.m14919a(this.f11963a, oguryError);
            abcbc.f12099a.endDataSourceConnections();
            aaaba.m14917a(this.f11963a, this.f11964b, oguryError.getMessage(), this.f11963a.f11950d);
            aaaba aaaba = this.f11963a;
            aaaba.m14916a(aaaba, this.f11964b, aaaba.f11950d);
        }

        /* renamed from: a */
        public final void mo29385a(String str) {
            accbb.m15218b(str, "response");
            this.f11963a.mo29389a();
            abbba.aaaaa aaaaa = abbba.f12082a;
            abbba.aaaaa.m15133a().mo29480a(str, true);
            aacca aacca = aacca.f12035a;
            if (aacca.m15045j()) {
                aaaba.m14915a(this.f11963a, this.f11964b);
            } else {
                aaaba aaaba = this.f11963a;
                aacca aacca2 = aacca.f12035a;
                aaaba.m14919a(aaaba, aacca.m15040e().mo29483b());
            }
            if (this.f11963a.f11948a == null) {
                accbb.m15216a("sharedPrefsHandler");
            }
            abbcb.m15143b(this.f11964b);
            aaaba aaaba2 = this.f11963a;
            aaaba.m14916a(aaaba2, this.f11964b, aaaba2.f11950d);
        }
    }

    /* renamed from: com.ogury.cm.aaaba$aaabb */
    static final class aaabb extends accbc implements accac<Integer, Boolean> {

        /* renamed from: a */
        final /* synthetic */ aaaba f11965a;

        /* renamed from: b */
        final /* synthetic */ int f11966b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        aaabb(aaaba aaaba, int i) {
            super(1);
            this.f11965a = aaaba;
            this.f11966b = i;
        }

        /* renamed from: a */
        public final /* synthetic */ Object mo29401a(Object obj) {
            ((Number) obj).intValue();
            aabac aabac = aabac.f12008a;
            return Boolean.valueOf(aabac.m14995a(this.f11965a.mo29397b().mo29438e(), this.f11966b));
        }
    }

    /* renamed from: com.ogury.cm.aaaba$aaabc */
    static final class aaabc implements Runnable {

        /* renamed from: a */
        final /* synthetic */ accab f11967a;

        aaabc(accab accab) {
            this.f11967a = accab;
        }

        public final void run() {
            this.f11967a.mo29404a();
        }
    }

    /* renamed from: com.ogury.cm.aaaba$aaaca */
    static final class aaaca implements Runnable {

        /* renamed from: a */
        final /* synthetic */ aaaba f11968a;

        /* renamed from: b */
        final /* synthetic */ Context f11969b;

        aaaca(aaaba aaaba, Context context) {
            this.f11968a = aaaba;
            this.f11969b = context;
        }

        public final void run() {
            aaaba.m14926b(this.f11968a, this.f11969b);
        }
    }

    /* renamed from: com.ogury.cm.aaaba$aaacb */
    public static final class aaacb implements aacbc {

        /* renamed from: a */
        final /* synthetic */ aaaba f11970a;

        /* renamed from: b */
        final /* synthetic */ OguryConsentListener f11971b;

        /* renamed from: com.ogury.cm.aaaba$aaacb$aaaaa */
        static final class aaaaa extends accbc implements accab<acbba> {

            /* renamed from: a */
            final /* synthetic */ aaacb f11972a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            aaaaa(aaacb aaacb) {
                super(0);
                this.f11972a = aaacb;
            }

            /* renamed from: a */
            public final /* synthetic */ Object mo29404a() {
                OguryConsentListener oguryConsentListener = this.f11972a.f11971b;
                aacca aacca = aacca.f12035a;
                oguryConsentListener.onComplete(aacca.m15034b().mo29430a());
                return acbba.f12137a;
            }
        }

        /* renamed from: com.ogury.cm.aaaba$aaacb$aaaab */
        static final class aaaab extends accbc implements accab<acbba> {

            /* renamed from: a */
            final /* synthetic */ aaacb f11973a;

            /* renamed from: b */
            final /* synthetic */ OguryError f11974b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            aaaab(aaacb aaacb, OguryError oguryError) {
                super(0);
                this.f11973a = aaacb;
                this.f11974b = oguryError;
            }

            /* renamed from: a */
            public final /* synthetic */ Object mo29404a() {
                this.f11973a.f11971b.onError(this.f11974b);
                return acbba.f12137a;
            }
        }

        aaacb(aaaba aaaba, OguryConsentListener oguryConsentListener) {
            this.f11970a = aaaba;
            this.f11971b = oguryConsentListener;
        }

        /* renamed from: a */
        public final void mo29384a(OguryError oguryError) {
            accbb.m15218b(oguryError, "error");
            this.f11970a.mo29395a(false);
            aaaba.m14918a(this.f11970a, (accab) new aaaab(this, oguryError));
        }

        /* renamed from: a */
        public final void mo29385a(String str) {
            accbb.m15218b(str, "response");
            this.f11970a.mo29395a(false);
            aaaba.m14918a(this.f11970a, (accab) new aaaaa(this));
        }
    }

    /* renamed from: a */
    private final aacbc m14911a(Context context) {
        return new C6849aaaba(this, context);
    }

    /* renamed from: a */
    private final void m14913a(Context context, String str, String str2) {
        this.f11958l = true;
        this.f11950d = str;
        if (acbbb.m15202a(context)) {
            this.f11957k.mo29422a(context, str2, new CountDownLatch(2));
            return;
        }
        aacbc aacbc = this.f11953g;
        if (aacbc == null) {
            accbb.m15216a("consentCallback");
        }
        aacbc.mo29384a(new OguryError(0, "No internet connection"));
    }

    /* renamed from: a */
    private final void m14914a(OguryConsentListener oguryConsentListener) {
        this.f11953g = new aaacb(this, oguryConsentListener);
    }

    /* renamed from: a */
    public static final /* synthetic */ void m14915a(aaaba aaaba, Context context) {
        aaaba.f11951e.post(new aaaca(aaaba, context));
        abaaa.aaaaa aaaaa2 = abaaa.f12046a;
        abaaa.aaaaa.m15052a().mo29429a(context);
        abbcb abbcb = aaaba.f11948a;
        if (abbcb == null) {
            accbb.m15216a("sharedPrefsHandler");
        }
        abbcb.mo29488a(context, aaaba.f11950d);
    }

    /* renamed from: a */
    public static final /* synthetic */ void m14916a(aaaba aaaba, Context context, String str) {
        aaaba.f11955i.mo29535a(context);
        accbb.m15218b(context, "context");
        accbb.m15218b(str, "assetKey");
        try {
            aacca aacca = aacca.f12035a;
            SdkInfo sdkInfo = new SdkInfo("3.0.1", str, aacca.m15037c().mo29543b());
            aacca aacca2 = aacca.f12035a;
            CrashReport.register(context, sdkInfo, new CrashConfig(aacca.m15037c().mo29545c(), context.getPackageName()));
        } catch (Throwable unused) {
            aaccc aaccc = aaccc.f12045a;
            aaccc.m15050b("crash report init failed");
        }
    }

    /* renamed from: a */
    public static final /* synthetic */ void m14917a(aaaba aaaba, Context context, String str, String str2) {
        if (str != null && accbb.m15217a((Object) str, (Object) aabba.aaaaa.m14999b("assetKey-unknown"))) {
            if (aaaba.f11948a == null) {
                accbb.m15216a("sharedPrefsHandler");
            }
            abbcb.m15144b(context, str2);
        }
    }

    /* renamed from: a */
    public static final /* synthetic */ void m14918a(aaaba aaaba, accab accab) {
        Thread currentThread = Thread.currentThread();
        Looper mainLooper = Looper.getMainLooper();
        accbb.m15215a((Object) mainLooper, "Looper.getMainLooper()");
        if (accbb.m15217a((Object) currentThread, (Object) mainLooper.getThread())) {
            accab.mo29404a();
        } else {
            aaaba.f11951e.post(new aaabc(accab));
        }
    }

    /* renamed from: a */
    public static final /* synthetic */ void m14919a(aaaba aaaba, OguryError oguryError) {
        aacbc aacbc = aaaba.f11953g;
        if (aacbc == null) {
            accbb.m15216a("consentCallback");
        }
        aacbc.mo29384a(oguryError);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m14921a(OguryError oguryError) {
        abcbc.f12099a.endDataSourceConnections();
        aacca aacca = aacca.f12035a;
        if (aacca.m15034b().mo29430a() != OguryChoiceManager.Answer.NO_ANSWER) {
            aacbc aacbc = this.f11953g;
            if (aacbc == null) {
                accbb.m15216a("consentCallback");
            }
            aacca aacca2 = aacca.f12035a;
            aacbc.mo29385a(aacca.m15034b().mo29430a().toString());
            return;
        }
        aacbc aacbc2 = this.f11953g;
        if (aacbc2 == null) {
            accbb.m15216a("consentCallback");
        }
        aacbc2.mo29384a(oguryError);
    }

    /* renamed from: a */
    private final void m14922a(String str, Context context) {
        abaca.m15098a(context, this.f11950d, str, m14911a(context));
    }

    /* renamed from: a */
    public static boolean m14923a(int i, Integer[] numArr, accac<? super Integer, Boolean> accac) {
        accbb.m15218b(numArr, "conditionValues");
        accbb.m15218b(accac, "unit");
        if (m14924a(numArr, i)) {
            return accac.mo29401a(Integer.valueOf(i)).booleanValue();
        }
        aaccc aaccc = aaccc.f12045a;
        aaccc.m15047a("Value that you are trying to check is not valid.");
        return false;
    }

    /* renamed from: a */
    private static boolean m14924a(Integer[] numArr, int i) {
        if (numArr.length == 0) {
            return true;
        }
        if (i != 0) {
            aabac aabac = aabac.f12008a;
            if (aabac.m14995a(acbbb.m15198a(numArr), i)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: b */
    private static void m14925b(Context context) {
        aacca aacca = aacca.f12035a;
        accca c = aacca.m15037c();
        Context applicationContext = context.getApplicationContext();
        accbb.m15215a((Object) applicationContext, "context.applicationContext");
        String packageName = applicationContext.getPackageName();
        accbb.m15215a((Object) packageName, "context.applicationContext.packageName");
        c.mo29541a(packageName);
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0059  */
    /* JADX WARNING: Removed duplicated region for block: B:29:? A[RETURN, SYNTHETIC] */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ void m14926b(com.ogury.p159cm.aaaba r6, android.content.Context r7) {
        /*
            com.ogury.cm.aacca r0 = com.ogury.p159cm.aacca.f12035a
            java.lang.String r0 = com.ogury.p159cm.aacca.m15043h()
            int r0 = r0.length()
            r1 = 1
            r2 = 0
            if (r0 <= 0) goto L_0x0010
            r0 = 1
            goto L_0x0011
        L_0x0010:
            r0 = 0
        L_0x0011:
            if (r0 == 0) goto L_0x0064
            boolean r0 = com.ogury.p159cm.acbbb.m15202a((android.content.Context) r7)
            java.lang.String r3 = "consentCallback"
            if (r0 != 0) goto L_0x002e
            com.ogury.cm.aacbc r0 = r6.f11953g
            if (r0 != 0) goto L_0x0022
            com.ogury.p159cm.accbb.m15216a((java.lang.String) r3)
        L_0x0022:
            com.ogury.core.OguryError r1 = new com.ogury.core.OguryError
            java.lang.String r4 = "No internet connection"
            r1.<init>(r2, r4)
            r0.mo29384a((com.ogury.core.OguryError) r1)
        L_0x002c:
            r1 = 0
            goto L_0x0057
        L_0x002e:
            com.ogury.cm.aacca r0 = com.ogury.p159cm.aacca.f12035a
            java.lang.String r0 = com.ogury.p159cm.aacca.m15041f()
            int r0 = r0.length()
            if (r0 != 0) goto L_0x003c
            r0 = 1
            goto L_0x003d
        L_0x003c:
            r0 = 0
        L_0x003d:
            if (r0 == 0) goto L_0x0057
            com.ogury.cm.aacbc r0 = r6.f11953g
            if (r0 != 0) goto L_0x0046
            com.ogury.p159cm.accbb.m15216a((java.lang.String) r3)
        L_0x0046:
            com.ogury.core.OguryError r1 = new com.ogury.core.OguryError
            r4 = 4
            java.lang.String r5 = "Missing consent configuration"
            r1.<init>(r4, r5)
            r0.mo29384a((com.ogury.core.OguryError) r1)
            com.ogury.cm.aaccc r0 = com.ogury.p159cm.aaccc.f12045a
            com.ogury.p159cm.aaccc.m15050b(r5)
            goto L_0x002c
        L_0x0057:
            if (r1 == 0) goto L_0x0063
            com.ogury.cm.aacbc r6 = r6.f11953g
            if (r6 != 0) goto L_0x0060
            com.ogury.p159cm.accbb.m15216a((java.lang.String) r3)
        L_0x0060:
            com.ogury.p159cm.aaaac.m14896a((android.content.Context) r7, (com.ogury.p159cm.aacbc) r6)
        L_0x0063:
            return
        L_0x0064:
            r7 = 0
            r6.m14921a(new com.ogury.core.OguryError(4, "Consent not received"))
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ogury.p159cm.aaaba.m14926b(com.ogury.cm.aaaba, android.content.Context):void");
    }

    /* renamed from: d */
    public static String m14927d() {
        aacca aacca = aacca.f12035a;
        if (!(aacca.m15034b().mo29434b().length() > 0)) {
            return "";
        }
        aacca aacca2 = aacca.f12035a;
        return aacca.m15034b().mo29434b();
    }

    /* renamed from: e */
    public static boolean m14928e() {
        aacca aacca = aacca.f12035a;
        return aacca.m15034b().mo29437d();
    }

    /* renamed from: a */
    public abstract void mo29389a();

    /* renamed from: a */
    public final void mo29390a(Context context, String str, OguryConsentListener oguryConsentListener) {
        accbb.m15218b(context, "context");
        accbb.m15218b(str, "assetKey");
        accbb.m15218b(oguryConsentListener, "oguryConsentListener");
        if (!this.f11958l) {
            m14925b(context);
            m14914a(oguryConsentListener);
            m14913a(context, str, "ask");
        }
    }

    /* renamed from: a */
    public final void mo29391a(Context context, String str, CountDownLatch countDownLatch) {
        boolean z;
        accbb.m15218b(context, "context");
        accbb.m15218b(str, "requestType");
        accbb.m15218b(countDownLatch, "countDownLatch");
        aacca aacca = aacca.f12035a;
        aacca.m15037c().mo29544b(this.f11959m);
        String str2 = this.f11950d;
        abbcb abbcb = this.f11948a;
        if (abbcb == null) {
            accbb.m15216a("sharedPrefsHandler");
        }
        abbcb.mo29490a(str2, context);
        this.f11950d = str2;
        if (accbb.m15217a((Object) str, (Object) "edit")) {
            m14922a("edit", context);
            return;
        }
        if (this.f11948a == null) {
            accbb.m15216a("sharedPrefsHandler");
        }
        String c = abbcb.m15145c(context);
        boolean z2 = false;
        if (baacc.m15250a((CharSequence) c) || (!accbb.m15217a((Object) c, (Object) this.f11950d))) {
            z = false;
        } else {
            m14921a(new OguryError(1, aabba.aaaaa.m14999b("assetKey-unknown")));
            z = true;
        }
        if (!z) {
            aacca aacca2 = aacca.f12035a;
            boolean z3 = !aacca.m15039d().after(new Date());
            boolean z4 = abcbc.f12099a.tokenExistsForActiveProduct();
            abbcb abbcb2 = this.f11948a;
            if (abbcb2 == null) {
                accbb.m15216a("sharedPrefsHandler");
            }
            boolean a = abbcb2.mo29489a(context);
            boolean z5 = z4 && !a;
            boolean z6 = !z4 && a;
            if (z3 || z5 || z6) {
                z2 = true;
            }
            if (z2) {
                m14922a("ask", context);
            } else {
                m14921a(new OguryError(4, "Consent not received"));
            }
        }
    }

    /* renamed from: a */
    public final void mo29392a(Context context, CountDownLatch countDownLatch) {
        accbb.m15218b(context, "context");
        accbb.m15218b(countDownLatch, "countDownLatch");
        aacba.m15022a(context, (aacac) new aaaac(this, countDownLatch));
        abcbc.f12099a.startDataSourceConnections(context);
        abcbc.f12099a.queryPurchase(new aaaab(countDownLatch));
    }

    /* renamed from: a */
    public final void mo29393a(abbcb abbcb) {
        accbb.m15218b(abbcb, "<set-?>");
        this.f11948a = abbcb;
    }

    /* renamed from: a */
    public final void mo29394a(String str) {
        accbb.m15218b(str, "<set-?>");
        this.f11959m = str;
    }

    /* renamed from: a */
    public final void mo29395a(boolean z) {
        this.f11958l = false;
    }

    /* renamed from: a */
    public final boolean mo29396a(int i) {
        return m14923a(i, mo29399c(), (accac<? super Integer, Boolean>) new aaabb(this, i));
    }

    /* renamed from: b */
    public abstract ababa mo29397b();

    /* renamed from: b */
    public final void mo29398b(Context context, String str, OguryConsentListener oguryConsentListener) {
        accbb.m15218b(context, "context");
        accbb.m15218b(str, "assetKey");
        accbb.m15218b(oguryConsentListener, "oguryConsentListener");
        if (!this.f11958l) {
            m14925b(context);
            m14914a(oguryConsentListener);
            m14913a(context, str, "edit");
        }
    }

    /* renamed from: c */
    public abstract Integer[] mo29399c();
}
