package p118io.branch.referral;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.RemoteException;
import com.tapjoy.TapjoyConstants;
import p093e.p097b.p098a.p099a.C3368a;
import p093e.p097b.p098a.p099a.C3374c;
import p093e.p097b.p098a.p099a.C3375d;

/* renamed from: io.branch.referral.InstallListener */
public class InstallListener extends BroadcastReceiver {

    /* renamed from: a */
    private static String f15306a = "bnc_no_value";

    /* renamed from: b */
    private static C3554b f15307b;

    /* renamed from: c */
    private static boolean f15308c;

    /* renamed from: d */
    private static boolean f15309d;

    /* renamed from: e */
    static boolean f15310e;

    /* renamed from: io.branch.referral.InstallListener$b */
    interface C3554b {
        /* renamed from: a */
        void mo19623a();
    }

    /* renamed from: io.branch.referral.InstallListener$a */
    static class C5982a implements Runnable {
        C5982a() {
        }

        public void run() {
            InstallListener.m19201e();
        }
    }

    /* renamed from: io.branch.referral.InstallListener$c */
    private static class C5983c {
        /* access modifiers changed from: private */

        /* renamed from: a */
        public Object f15311a;
        /* access modifiers changed from: private */

        /* renamed from: b */
        public Context f15312b;

        /* renamed from: io.branch.referral.InstallListener$c$a */
        class C5984a implements C3374c {
            C5984a() {
            }

            public void onInstallReferrerServiceDisconnected() {
                InstallListener.m19200d();
            }

            public void onInstallReferrerSetupFinished(int i) {
                long j;
                long j2;
                String str;
                if (i == 0) {
                    try {
                        if (C5983c.this.f15311a != null) {
                            C3375d a = ((C3368a) C5983c.this.f15311a).mo19130a();
                            if (a != null) {
                                String b = a.mo19137b();
                                long c = a.mo19138c();
                                j = a.mo19136a();
                                j2 = c;
                                str = b;
                            } else {
                                j = 0;
                                str = null;
                                j2 = 0;
                            }
                            InstallListener.m19197b(C5983c.this.f15312b, str, j2, j);
                        }
                    } catch (RemoteException e) {
                        C6035q.m19397b("BranchSDK", e.getMessage());
                        InstallListener.m19200d();
                    }
                } else if (i == 1) {
                    InstallListener.m19200d();
                } else if (i == 2) {
                    InstallListener.m19200d();
                }
            }
        }

        /* synthetic */ C5983c(Context context, C5982a aVar) {
            this(context);
        }

        private C5983c(Context context) {
            this.f15312b = context;
        }

        /* access modifiers changed from: private */
        /* renamed from: a */
        public boolean m19202a() {
            try {
                C3368a a = C3368a.m11242a(this.f15312b).mo19132a();
                this.f15311a = a;
                a.mo19131a((C3374c) new C5984a());
                return true;
            } catch (Throwable th) {
                C6035q.m19397b("BranchSDK", th.getMessage());
                return false;
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0052 A[Catch:{ UnsupportedEncodingException -> 0x00dc, IllegalArgumentException -> 0x00da }] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0061 A[SYNTHETIC] */
    /* renamed from: c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void m19199c(android.content.Context r6, java.lang.String r7, long r8, long r10) {
        /*
            java.lang.String r0 = "="
            java.lang.String r1 = "UTF-8"
            io.branch.referral.q r6 = p118io.branch.referral.C6035q.m19395a((android.content.Context) r6)
            r2 = 0
            int r4 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
            if (r4 <= 0) goto L_0x0013
            java.lang.String r4 = "bnc_referrer_click_ts"
            r6.mo33951a((java.lang.String) r4, (long) r8)
        L_0x0013:
            int r8 = (r10 > r2 ? 1 : (r10 == r2 ? 0 : -1))
            if (r8 <= 0) goto L_0x001c
            java.lang.String r8 = "bnc_install_begin_ts"
            r6.mo33951a((java.lang.String) r8, (long) r10)
        L_0x001c:
            if (r7 == 0) goto L_0x00ec
            java.lang.String r7 = java.net.URLDecoder.decode(r7, r1)     // Catch:{ UnsupportedEncodingException -> 0x00dc, IllegalArgumentException -> 0x00da }
            java.util.HashMap r8 = new java.util.HashMap     // Catch:{ UnsupportedEncodingException -> 0x00dc, IllegalArgumentException -> 0x00da }
            r8.<init>()     // Catch:{ UnsupportedEncodingException -> 0x00dc, IllegalArgumentException -> 0x00da }
            java.lang.String r9 = "&"
            java.lang.String[] r9 = r7.split(r9)     // Catch:{ UnsupportedEncodingException -> 0x00dc, IllegalArgumentException -> 0x00da }
            int r10 = r9.length     // Catch:{ UnsupportedEncodingException -> 0x00dc, IllegalArgumentException -> 0x00da }
            r11 = 0
            r2 = 0
        L_0x0030:
            if (r2 >= r10) goto L_0x0064
            r3 = r9[r2]     // Catch:{ UnsupportedEncodingException -> 0x00dc, IllegalArgumentException -> 0x00da }
            boolean r4 = android.text.TextUtils.isEmpty(r3)     // Catch:{ UnsupportedEncodingException -> 0x00dc, IllegalArgumentException -> 0x00da }
            if (r4 != 0) goto L_0x0061
            boolean r4 = r3.contains(r0)     // Catch:{ UnsupportedEncodingException -> 0x00dc, IllegalArgumentException -> 0x00da }
            java.lang.String r5 = "-"
            if (r4 != 0) goto L_0x0049
            boolean r4 = r3.contains(r5)     // Catch:{ UnsupportedEncodingException -> 0x00dc, IllegalArgumentException -> 0x00da }
            if (r4 == 0) goto L_0x0049
            goto L_0x004a
        L_0x0049:
            r5 = r0
        L_0x004a:
            java.lang.String[] r3 = r3.split(r5)     // Catch:{ UnsupportedEncodingException -> 0x00dc, IllegalArgumentException -> 0x00da }
            int r4 = r3.length     // Catch:{ UnsupportedEncodingException -> 0x00dc, IllegalArgumentException -> 0x00da }
            r5 = 1
            if (r4 <= r5) goto L_0x0061
            r4 = r3[r11]     // Catch:{ UnsupportedEncodingException -> 0x00dc, IllegalArgumentException -> 0x00da }
            java.lang.String r4 = java.net.URLDecoder.decode(r4, r1)     // Catch:{ UnsupportedEncodingException -> 0x00dc, IllegalArgumentException -> 0x00da }
            r3 = r3[r5]     // Catch:{ UnsupportedEncodingException -> 0x00dc, IllegalArgumentException -> 0x00da }
            java.lang.String r3 = java.net.URLDecoder.decode(r3, r1)     // Catch:{ UnsupportedEncodingException -> 0x00dc, IllegalArgumentException -> 0x00da }
            r8.put(r4, r3)     // Catch:{ UnsupportedEncodingException -> 0x00dc, IllegalArgumentException -> 0x00da }
        L_0x0061:
            int r2 = r2 + 1
            goto L_0x0030
        L_0x0064:
            io.branch.referral.l r9 = p118io.branch.referral.C6028l.LinkClickID     // Catch:{ UnsupportedEncodingException -> 0x00dc, IllegalArgumentException -> 0x00da }
            java.lang.String r9 = r9.mo33920a()     // Catch:{ UnsupportedEncodingException -> 0x00dc, IllegalArgumentException -> 0x00da }
            boolean r9 = r8.containsKey(r9)     // Catch:{ UnsupportedEncodingException -> 0x00dc, IllegalArgumentException -> 0x00da }
            if (r9 == 0) goto L_0x0081
            io.branch.referral.l r9 = p118io.branch.referral.C6028l.LinkClickID     // Catch:{ UnsupportedEncodingException -> 0x00dc, IllegalArgumentException -> 0x00da }
            java.lang.String r9 = r9.mo33920a()     // Catch:{ UnsupportedEncodingException -> 0x00dc, IllegalArgumentException -> 0x00da }
            java.lang.Object r9 = r8.get(r9)     // Catch:{ UnsupportedEncodingException -> 0x00dc, IllegalArgumentException -> 0x00da }
            java.lang.String r9 = (java.lang.String) r9     // Catch:{ UnsupportedEncodingException -> 0x00dc, IllegalArgumentException -> 0x00da }
            f15306a = r9     // Catch:{ UnsupportedEncodingException -> 0x00dc, IllegalArgumentException -> 0x00da }
            r6.mo33998t(r9)     // Catch:{ UnsupportedEncodingException -> 0x00dc, IllegalArgumentException -> 0x00da }
        L_0x0081:
            io.branch.referral.l r9 = p118io.branch.referral.C6028l.IsFullAppConv     // Catch:{ UnsupportedEncodingException -> 0x00dc, IllegalArgumentException -> 0x00da }
            java.lang.String r9 = r9.mo33920a()     // Catch:{ UnsupportedEncodingException -> 0x00dc, IllegalArgumentException -> 0x00da }
            boolean r9 = r8.containsKey(r9)     // Catch:{ UnsupportedEncodingException -> 0x00dc, IllegalArgumentException -> 0x00da }
            if (r9 == 0) goto L_0x00bb
            io.branch.referral.l r9 = p118io.branch.referral.C6028l.ReferringLink     // Catch:{ UnsupportedEncodingException -> 0x00dc, IllegalArgumentException -> 0x00da }
            java.lang.String r9 = r9.mo33920a()     // Catch:{ UnsupportedEncodingException -> 0x00dc, IllegalArgumentException -> 0x00da }
            boolean r9 = r8.containsKey(r9)     // Catch:{ UnsupportedEncodingException -> 0x00dc, IllegalArgumentException -> 0x00da }
            if (r9 == 0) goto L_0x00bb
            io.branch.referral.l r9 = p118io.branch.referral.C6028l.IsFullAppConv     // Catch:{ UnsupportedEncodingException -> 0x00dc, IllegalArgumentException -> 0x00da }
            java.lang.String r9 = r9.mo33920a()     // Catch:{ UnsupportedEncodingException -> 0x00dc, IllegalArgumentException -> 0x00da }
            java.lang.Object r9 = r8.get(r9)     // Catch:{ UnsupportedEncodingException -> 0x00dc, IllegalArgumentException -> 0x00da }
            java.lang.String r9 = (java.lang.String) r9     // Catch:{ UnsupportedEncodingException -> 0x00dc, IllegalArgumentException -> 0x00da }
            boolean r9 = java.lang.Boolean.parseBoolean(r9)     // Catch:{ UnsupportedEncodingException -> 0x00dc, IllegalArgumentException -> 0x00da }
            r6.mo33959b((boolean) r9)     // Catch:{ UnsupportedEncodingException -> 0x00dc, IllegalArgumentException -> 0x00da }
            io.branch.referral.l r9 = p118io.branch.referral.C6028l.ReferringLink     // Catch:{ UnsupportedEncodingException -> 0x00dc, IllegalArgumentException -> 0x00da }
            java.lang.String r9 = r9.mo33920a()     // Catch:{ UnsupportedEncodingException -> 0x00dc, IllegalArgumentException -> 0x00da }
            java.lang.Object r9 = r8.get(r9)     // Catch:{ UnsupportedEncodingException -> 0x00dc, IllegalArgumentException -> 0x00da }
            java.lang.String r9 = (java.lang.String) r9     // Catch:{ UnsupportedEncodingException -> 0x00dc, IllegalArgumentException -> 0x00da }
            r6.mo33972g(r9)     // Catch:{ UnsupportedEncodingException -> 0x00dc, IllegalArgumentException -> 0x00da }
        L_0x00bb:
            io.branch.referral.l r9 = p118io.branch.referral.C6028l.GoogleSearchInstallReferrer     // Catch:{ UnsupportedEncodingException -> 0x00dc, IllegalArgumentException -> 0x00da }
            java.lang.String r9 = r9.mo33920a()     // Catch:{ UnsupportedEncodingException -> 0x00dc, IllegalArgumentException -> 0x00da }
            boolean r9 = r8.containsKey(r9)     // Catch:{ UnsupportedEncodingException -> 0x00dc, IllegalArgumentException -> 0x00da }
            if (r9 == 0) goto L_0x00ec
            io.branch.referral.l r9 = p118io.branch.referral.C6028l.GoogleSearchInstallReferrer     // Catch:{ UnsupportedEncodingException -> 0x00dc, IllegalArgumentException -> 0x00da }
            java.lang.String r9 = r9.mo33920a()     // Catch:{ UnsupportedEncodingException -> 0x00dc, IllegalArgumentException -> 0x00da }
            java.lang.Object r8 = r8.get(r9)     // Catch:{ UnsupportedEncodingException -> 0x00dc, IllegalArgumentException -> 0x00da }
            java.lang.String r8 = (java.lang.String) r8     // Catch:{ UnsupportedEncodingException -> 0x00dc, IllegalArgumentException -> 0x00da }
            r6.mo33986n(r8)     // Catch:{ UnsupportedEncodingException -> 0x00dc, IllegalArgumentException -> 0x00da }
            r6.mo33984m(r7)     // Catch:{ UnsupportedEncodingException -> 0x00dc, IllegalArgumentException -> 0x00da }
            goto L_0x00ec
        L_0x00da:
            r6 = move-exception
            goto L_0x00de
        L_0x00dc:
            r6 = move-exception
            goto L_0x00e9
        L_0x00de:
            r6.printStackTrace()
            java.lang.String r6 = "BranchSDK"
            java.lang.String r7 = "Illegal characters in url encoded string"
            android.util.Log.w(r6, r7)
            goto L_0x00ec
        L_0x00e9:
            r6.printStackTrace()
        L_0x00ec:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p118io.branch.referral.InstallListener.m19199c(android.content.Context, java.lang.String, long, long):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public static void m19200d() {
        f15309d = false;
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public static void m19201e() {
        f15310e = true;
        C3554b bVar = f15307b;
        if (bVar != null) {
            bVar.mo19623a();
            f15307b = null;
            f15310e = false;
            f15308c = false;
            f15309d = false;
        }
    }

    public void onReceive(Context context, Intent intent) {
        m19199c(context, intent.getStringExtra(TapjoyConstants.TJC_REFERRER), 0, 0);
        if (f15308c && !f15309d) {
            m19201e();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static void m19197b(Context context, String str, long j, long j2) {
        m19199c(context, str, j, j2);
        if (f15308c) {
            m19201e();
        }
    }

    /* renamed from: a */
    public static void m19194a(Context context, long j, C3554b bVar) {
        f15307b = bVar;
        if (f15310e) {
            m19201e();
            return;
        }
        f15308c = true;
        f15309d = new C5983c(context, (C5982a) null).m19202a();
        new Handler().postDelayed(new C5982a(), j);
    }

    /* renamed from: c */
    public static String m19198c() {
        return f15306a;
    }
}
