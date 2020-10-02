package com.moat.analytics.mobile.ogury;

import android.content.Context;
import android.content.pm.PackageManager;
import android.media.AudioManager;
import android.os.AsyncTask;
import android.telephony.TelephonyManager;
import com.facebook.places.model.PlaceFields;
import com.moat.analytics.mobile.ogury.C4315e;
import com.ogury.p159cm.OguryChoiceManager;
import java.lang.ref.WeakReference;

/* renamed from: com.moat.analytics.mobile.ogury.s */
final class C4356s {

    /* renamed from: ˊ */
    private static long f11660 = 5996206772453036003L;

    /* renamed from: ˋ */
    private static String f11661 = null;

    /* renamed from: ˎ */
    private static C4359b f11662 = null;

    /* renamed from: ˏ */
    private static C4358a f11663 = null;

    /* renamed from: ॱ */
    private static int f11664 = 0;

    /* renamed from: ॱॱ */
    private static int f11665 = 1;

    /* renamed from: com.moat.analytics.mobile.ogury.s$a */
    static class C4358a {

        /* renamed from: ˋ */
        private String f11667;

        /* renamed from: ˎ */
        private String f11668;

        /* renamed from: ˏ */
        private String f11669;
        /* access modifiers changed from: private */

        /* renamed from: ॱ */
        public boolean f11670;

        /* synthetic */ C4358a(byte b) {
            this();
        }

        /* access modifiers changed from: package-private */
        /* renamed from: ˋ */
        public final String mo29189() {
            String str = this.f11669;
            return str != null ? str : "_unknown_";
        }

        /* access modifiers changed from: package-private */
        /* renamed from: ˏ */
        public final String mo29190() {
            return this.f11667;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: ॱ */
        public final String mo29191() {
            return this.f11668;
        }

        private C4358a() {
            this.f11670 = false;
            this.f11668 = "_unknown_";
            this.f11667 = "_unknown_";
            this.f11669 = "_unknown_";
            try {
                Context r0 = C4356s.m14571();
                if (r0 != null) {
                    this.f11670 = true;
                    PackageManager packageManager = r0.getPackageManager();
                    this.f11667 = r0.getPackageName();
                    this.f11668 = packageManager.getApplicationLabel(r0.getApplicationInfo()).toString();
                    this.f11669 = packageManager.getInstallerPackageName(this.f11667);
                    return;
                }
                C4315e.C43161.m14442(3, "Util", this, "Can't get app name, appContext is null.");
            } catch (Exception e) {
                C4332l.m14509(e);
            }
        }
    }

    /* renamed from: com.moat.analytics.mobile.ogury.s$b */
    static class C4359b {

        /* renamed from: ʽ */
        boolean f11671;

        /* renamed from: ˊ */
        String f11672;

        /* renamed from: ˋ */
        Integer f11673;

        /* renamed from: ˎ */
        String f11674;

        /* renamed from: ˏ */
        boolean f11675;

        /* renamed from: ॱ */
        boolean f11676;

        /* synthetic */ C4359b(byte b) {
            this();
        }

        private C4359b() {
            this.f11674 = "_unknown_";
            this.f11672 = "_unknown_";
            this.f11673 = -1;
            this.f11675 = false;
            this.f11676 = false;
            this.f11671 = false;
            try {
                Context r0 = C4356s.m14571();
                if (r0 != null) {
                    this.f11671 = true;
                    TelephonyManager telephonyManager = (TelephonyManager) r0.getSystemService(PlaceFields.PHONE);
                    this.f11674 = telephonyManager.getSimOperatorName();
                    this.f11672 = telephonyManager.getNetworkOperatorName();
                    this.f11673 = Integer.valueOf(telephonyManager.getPhoneType());
                    this.f11675 = C4356s.m14569();
                    this.f11676 = C4356s.m14579(r0);
                }
            } catch (Exception e) {
                C4332l.m14509(e);
            }
        }
    }

    static {
        int i = 0 + 121;
        f11665 = i % OguryChoiceManager.TcfV2.Purpose.MEASURE_AD_PERFORMANCE;
        if (i % 2 == 0) {
            Object obj = null;
            super.hashCode();
        }
    }

    C4356s() {
    }

    /* renamed from: ʻ */
    static /* synthetic */ String m14568() {
        int i = f11664 + 27;
        f11665 = i % OguryChoiceManager.TcfV2.Purpose.MEASURE_AD_PERFORMANCE;
        int i2 = i % 2;
        String str = f11661;
        int i3 = f11665 + 115;
        f11664 = i3 % OguryChoiceManager.TcfV2.Purpose.MEASURE_AD_PERFORMANCE;
        int i4 = i3 % 2;
        return str;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0051, code lost:
        if (android.os.Build.VERSION.SDK_INT >= 108) goto L_0x0063;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0061, code lost:
        if ((android.os.Build.VERSION.SDK_INT >= 17 ? '7' : 'c') != 'c') goto L_0x0063;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0074, code lost:
        r0 = android.provider.Settings.Secure.getInt(r1.getContentResolver(), m14575("낑ᗰ냰?⮲됖䤘⛮轸᫱欥쿥孮ꪬ").intern(), 0);
     */
    /* renamed from: ʼ */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ boolean m14569() {
        /*
            int r0 = f11665
            int r0 = r0 + 107
            int r1 = r0 % 128
            f11664 = r1
            int r0 = r0 % 2
            com.moat.analytics.mobile.ogury.MoatAnalytics r0 = com.moat.analytics.mobile.ogury.MoatAnalytics.getInstance()
            com.moat.analytics.mobile.ogury.i r0 = (com.moat.analytics.mobile.ogury.C4328i) r0
            java.lang.ref.WeakReference<android.content.Context> r0 = r0.f11582
            r1 = 0
            if (r0 == 0) goto L_0x0033
            int r2 = f11665
            int r2 = r2 + 3
            int r3 = r2 % 128
            f11664 = r3
            int r2 = r2 % 2
            if (r2 == 0) goto L_0x002c
            java.lang.Object r0 = r0.get()
            android.content.Context r0 = (android.content.Context) r0
            super.hashCode()
            r1 = r0
            goto L_0x0033
        L_0x002c:
            java.lang.Object r0 = r0.get()
            r1 = r0
            android.content.Context r1 = (android.content.Context) r1
        L_0x0033:
            r0 = 65
            if (r1 == 0) goto L_0x003a
            r2 = 80
            goto L_0x003c
        L_0x003a:
            r2 = 65
        L_0x003c:
            r3 = 0
            if (r2 == r0) goto L_0x0085
            int r0 = f11664
            int r0 = r0 + 9
            int r2 = r0 % 128
            f11665 = r2
            int r0 = r0 % 2
            java.lang.String r2 = "낑ᗰ냰?⮲됖䤘⛮轸᫱欥쿥孮ꪬ"
            if (r0 != 0) goto L_0x0054
            int r0 = android.os.Build.VERSION.SDK_INT
            r4 = 108(0x6c, float:1.51E-43)
            if (r0 < r4) goto L_0x0074
            goto L_0x0063
        L_0x0054:
            int r0 = android.os.Build.VERSION.SDK_INT
            r4 = 17
            r5 = 99
            if (r0 < r4) goto L_0x005f
            r0 = 55
            goto L_0x0061
        L_0x005f:
            r0 = 99
        L_0x0061:
            if (r0 == r5) goto L_0x0074
        L_0x0063:
            android.content.ContentResolver r0 = r1.getContentResolver()
            java.lang.String r1 = m14575((java.lang.String) r2)
            java.lang.String r1 = r1.intern()
            int r0 = android.provider.Settings.Global.getInt(r0, r1, r3)
            goto L_0x0086
        L_0x0074:
            android.content.ContentResolver r0 = r1.getContentResolver()
            java.lang.String r1 = m14575((java.lang.String) r2)
            java.lang.String r1 = r1.intern()
            int r0 = android.provider.Settings.Secure.getInt(r0, r1, r3)
            goto L_0x0086
        L_0x0085:
            r0 = 0
        L_0x0086:
            r1 = 1
            if (r0 != r1) goto L_0x008a
            return r1
        L_0x008a:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.moat.analytics.mobile.ogury.C4356s.m14569():boolean");
    }

    /* renamed from: ʽ */
    private static int m14570() {
        int i = f11665 + 39;
        f11664 = i % OguryChoiceManager.TcfV2.Purpose.MEASURE_AD_PERFORMANCE;
        int i2 = i % 2;
        try {
            int streamVolume = ((AudioManager) C4307a.m14408().getSystemService(m14575("꙼㞉ꘝꭠ㓂鵕馟").intern())).getStreamVolume(3);
            int i3 = f11665 + 57;
            f11664 = i3 % OguryChoiceManager.TcfV2.Purpose.MEASURE_AD_PERFORMANCE;
            int i4 = i3 % 2;
            return streamVolume;
        } catch (Exception e) {
            C4332l.m14509(e);
            return 0;
        }
    }

    /* renamed from: ˊ */
    static Context m14571() {
        int i = f11665 + 39;
        f11664 = i % OguryChoiceManager.TcfV2.Purpose.MEASURE_AD_PERFORMANCE;
        int i2 = i % 2;
        WeakReference<Context> weakReference = ((C4328i) MoatAnalytics.getInstance()).f11582;
        if ((weakReference != null ? 'c' : 1) != 'c') {
            return null;
        }
        int i3 = f11665 + 103;
        f11664 = i3 % OguryChoiceManager.TcfV2.Purpose.MEASURE_AD_PERFORMANCE;
        if ((i3 % 2 != 0 ? '7' : '*') != '7') {
            return weakReference.get();
        }
        return weakReference.get();
    }

    /* renamed from: ˋ */
    static /* synthetic */ String m14573(String str) {
        int i = f11665 + 125;
        f11664 = i % OguryChoiceManager.TcfV2.Purpose.MEASURE_AD_PERFORMANCE;
        boolean z = i % 2 != 0;
        f11661 = str;
        if (z) {
            Object obj = null;
            super.hashCode();
        }
        int i2 = f11664 + 43;
        f11665 = i2 % OguryChoiceManager.TcfV2.Purpose.MEASURE_AD_PERFORMANCE;
        int i3 = i2 % 2;
        return str;
    }

    /* renamed from: ˎ */
    static void m14576(final Context context) {
        try {
            AsyncTask.execute(new Runnable() {
                public final void run() {
                    try {
                        Class<?> cls = Class.forName("com.google.android.gms.ads.identifier.AdvertisingIdClient");
                        Class<?> cls2 = Class.forName("com.google.android.gms.ads.identifier.AdvertisingIdClient$Info");
                        Object invoke = cls.getMethod("getAdvertisingIdInfo", new Class[]{Context.class}).invoke((Object) null, new Object[]{context});
                        if (!((Boolean) cls2.getMethod("isLimitAdTrackingEnabled", new Class[0]).invoke(invoke, new Object[0])).booleanValue()) {
                            C4356s.m14573((String) cls2.getMethod("getId", new Class[0]).invoke(invoke, new Object[0]));
                            StringBuilder sb = new StringBuilder("Retrieved Advertising ID = ");
                            sb.append(C4356s.m14568());
                            C4315e.C43161.m14442(3, "Util", this, sb.toString());
                            return;
                        }
                        C4315e.C43161.m14442(3, "Util", this, "User has limited ad tracking");
                    } catch (ClassNotFoundException e) {
                        C4315e.C43161.m14445("Util", this, "ClassNotFoundException while retrieving Advertising ID", e);
                    } catch (NoSuchMethodException e2) {
                        C4315e.C43161.m14445("Util", this, "NoSuchMethodException while retrieving Advertising ID", e2);
                    } catch (Exception e3) {
                        C4332l.m14509(e3);
                    }
                }
            });
            int i = f11665 + 103;
            f11664 = i % OguryChoiceManager.TcfV2.Purpose.MEASURE_AD_PERFORMANCE;
            int i2 = i % 2;
        } catch (Exception e) {
            C4332l.m14509(e);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0018, code lost:
        if (f11662.f11671 == false) goto L_0x001a;
     */
    /* renamed from: ˏ */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static com.moat.analytics.mobile.ogury.C4356s.C4359b m14577() {
        /*
            com.moat.analytics.mobile.ogury.s$b r0 = f11662
            r1 = 0
            if (r0 == 0) goto L_0x0007
            r0 = 1
            goto L_0x0008
        L_0x0007:
            r0 = 0
        L_0x0008:
            if (r0 == 0) goto L_0x001a
            int r0 = f11665
            int r0 = r0 + 31
            int r2 = r0 % 128
            f11664 = r2
            int r0 = r0 % 2
            com.moat.analytics.mobile.ogury.s$b r0 = f11662
            boolean r0 = r0.f11671
            if (r0 != 0) goto L_0x002b
        L_0x001a:
            com.moat.analytics.mobile.ogury.s$b r0 = new com.moat.analytics.mobile.ogury.s$b
            r0.<init>(r1)
            f11662 = r0
            int r0 = f11665
            int r0 = r0 + 45
            int r1 = r0 % 128
            f11664 = r1
            int r0 = r0 % 2
        L_0x002b:
            com.moat.analytics.mobile.ogury.s$b r0 = f11662
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.moat.analytics.mobile.ogury.C4356s.m14577():com.moat.analytics.mobile.ogury.s$b");
    }

    /* renamed from: ॱ */
    static String m14578() {
        int i = f11664 + 117;
        f11665 = i % OguryChoiceManager.TcfV2.Purpose.MEASURE_AD_PERFORMANCE;
        int i2 = i % 2;
        String str = f11661;
        int i3 = f11664 + 1;
        f11665 = i3 % OguryChoiceManager.TcfV2.Purpose.MEASURE_AD_PERFORMANCE;
        int i4 = i3 % 2;
        return str;
    }

    /* renamed from: ˋ */
    static double m14572() {
        int i = f11664 + 81;
        f11665 = i % OguryChoiceManager.TcfV2.Purpose.MEASURE_AD_PERFORMANCE;
        if ((i % 2 == 0 ? '0' : '!') != '0') {
            try {
                double r1 = (double) m14570();
                double streamMaxVolume = (double) ((AudioManager) C4307a.m14408().getSystemService(m14575("꙼㞉ꘝꭠ㓂鵕馟").intern())).getStreamMaxVolume(3);
                Double.isNaN(r1);
                Double.isNaN(streamMaxVolume);
                return r1 / streamMaxVolume;
            } catch (Exception e) {
                C4332l.m14509(e);
                return 0.0d;
            }
        } else {
            double r12 = (double) m14570();
            double streamMaxVolume2 = (double) ((AudioManager) C4307a.m14408().getSystemService(m14575("꙼㞉ꘝꭠ㓂鵕馟").intern())).getStreamMaxVolume(2);
            Double.isNaN(r12);
            Double.isNaN(streamMaxVolume2);
            return r12 * streamMaxVolume2;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x002d, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0016, code lost:
        if ((r3 & 4) != 0) goto L_0x0022;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0020, code lost:
        if (((r3 & 2) == 0) != true) goto L_0x0022;
     */
    /* renamed from: ॱ */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static boolean m14579(android.content.Context r3) {
        /*
            int r0 = f11664
            int r0 = r0 + 83
            int r1 = r0 % 128
            f11665 = r1
            int r0 = r0 % 2
            r1 = 0
            r2 = 1
            android.content.pm.ApplicationInfo r3 = r3.getApplicationInfo()
            int r3 = r3.flags
            if (r0 != 0) goto L_0x0019
            r3 = r3 & 4
            if (r3 == 0) goto L_0x002d
            goto L_0x0022
        L_0x0019:
            r3 = r3 & 2
            if (r3 == 0) goto L_0x001f
            r3 = 0
            goto L_0x0020
        L_0x001f:
            r3 = 1
        L_0x0020:
            if (r3 == r2) goto L_0x002d
        L_0x0022:
            int r3 = f11664
            int r3 = r3 + 97
            int r0 = r3 % 128
            f11665 = r0
            int r3 = r3 % 2
            return r2
        L_0x002d:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.moat.analytics.mobile.ogury.C4356s.m14579(android.content.Context):boolean");
    }

    /* renamed from: ˎ */
    static C4358a m14574() {
        int i = f11664 + 103;
        f11665 = i % OguryChoiceManager.TcfV2.Purpose.MEASURE_AD_PERFORMANCE;
        int i2 = i % 2;
        if (!(f11663 != null) || !f11663.f11670) {
            f11663 = new C4358a((byte) 0);
            int i3 = f11664 + 65;
            f11665 = i3 % OguryChoiceManager.TcfV2.Purpose.MEASURE_AD_PERFORMANCE;
            int i4 = i3 % 2;
        }
        return f11663;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v1, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v4, resolved type: char[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v5, resolved type: char[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v6, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v7, resolved type: java.lang.String} */
    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000c, code lost:
        if (r10 != null) goto L_0x0017;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0014, code lost:
        if ((r10 == null) != false) goto L_0x0033;
     */
    /* JADX WARNING: Failed to insert additional move for type inference */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: ˎ */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String m14575(java.lang.String r10) {
        /*
            int r0 = f11665
            int r0 = r0 + 31
            int r1 = r0 % 128
            f11664 = r1
            r1 = 2
            int r0 = r0 % r1
            if (r0 == 0) goto L_0x000f
            if (r10 == 0) goto L_0x0033
            goto L_0x0017
        L_0x000f:
            if (r10 == 0) goto L_0x0013
            r0 = 0
            goto L_0x0014
        L_0x0013:
            r0 = 1
        L_0x0014:
            if (r0 == 0) goto L_0x0017
            goto L_0x0033
        L_0x0017:
            int r0 = f11664
            int r0 = r0 + 121
            int r2 = r0 % 128
            f11665 = r2
            int r0 = r0 % r1
            r2 = 58
            if (r0 != 0) goto L_0x0027
            r0 = 58
            goto L_0x0028
        L_0x0027:
            r0 = 2
        L_0x0028:
            if (r0 == r2) goto L_0x002f
            char[] r10 = r10.toCharArray()
            goto L_0x0033
        L_0x002f:
            char[] r10 = r10.toCharArray()
        L_0x0033:
            char[] r10 = (char[]) r10
            long r2 = f11660
            char[] r10 = p118io.presage.CamembertauCalvados.m20267a(r2, r10)
            r0 = 4
            r2 = 4
        L_0x003d:
            int r3 = r10.length
            if (r2 >= r3) goto L_0x0060
            int r3 = r2 + -4
            char r4 = r10[r2]
            int r5 = r2 % 4
            char r5 = r10[r5]
            r4 = r4 ^ r5
            long r4 = (long) r4
            long r6 = (long) r3
            long r8 = f11660
            long r6 = r6 * r8
            long r4 = r4 ^ r6
            int r3 = (int) r4
            char r3 = (char) r3
            r10[r2] = r3
            int r2 = r2 + 1
            int r3 = f11665
            int r3 = r3 + 107
            int r4 = r3 % 128
            f11664 = r4
            int r3 = r3 % r1
            goto L_0x003d
        L_0x0060:
            java.lang.String r1 = new java.lang.String
            int r2 = r10.length
            int r2 = r2 - r0
            r1.<init>(r10, r0, r2)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.moat.analytics.mobile.ogury.C4356s.m14575(java.lang.String):java.lang.String");
    }
}
