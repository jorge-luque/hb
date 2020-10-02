package com.onesignal;

import com.onesignal.C4523i1;
import com.onesignal.C4564n1;
import java.util.ArrayList;
import java.util.Date;
import java.util.TimerTask;

/* renamed from: com.onesignal.g0 */
/* compiled from: OSDynamicTriggerController */
class C4508g0 {

    /* renamed from: c */
    static Date f12338c = new Date();
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final C4511c f12339a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final ArrayList<String> f12340b = new ArrayList<>();

    /* renamed from: com.onesignal.g0$a */
    /* compiled from: OSDynamicTriggerController */
    class C4509a extends TimerTask {

        /* renamed from: a */
        final /* synthetic */ C4523i1 f12341a;

        C4509a(C4523i1 i1Var) {
            this.f12341a = i1Var;
        }

        public void run() {
            C4508g0.this.f12340b.remove(this.f12341a.f12352a);
            C4508g0.this.f12339a.mo29775a();
        }
    }

    /* renamed from: com.onesignal.g0$b */
    /* compiled from: OSDynamicTriggerController */
    static /* synthetic */ class C4510b {

        /* renamed from: a */
        static final /* synthetic */ int[] f12343a;

        /* renamed from: b */
        static final /* synthetic */ int[] f12344b;

        /* JADX WARNING: Can't wrap try/catch for region: R(17:0|(2:1|2)|3|5|6|7|8|9|10|11|12|13|14|15|17|18|(3:19|20|22)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(20:0|1|2|3|5|6|7|8|9|10|11|12|13|14|15|17|18|19|20|22) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0033 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x005a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0028 */
        static {
            /*
                com.onesignal.i1$b[] r0 = com.onesignal.C4523i1.C4525b.m15566b()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f12344b = r0
                r1 = 1
                com.onesignal.i1$b r2 = com.onesignal.C4523i1.C4525b.LESS_THAN     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = f12344b     // Catch:{ NoSuchFieldError -> 0x001d }
                com.onesignal.i1$b r3 = com.onesignal.C4523i1.C4525b.LESS_THAN_OR_EQUAL_TO     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r2 = f12344b     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.onesignal.i1$b r3 = com.onesignal.C4523i1.C4525b.GREATER_THAN     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r4 = 3
                r2[r3] = r4     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r2 = f12344b     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.onesignal.i1$b r3 = com.onesignal.C4523i1.C4525b.GREATER_THAN_OR_EQUAL_TO     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r4 = 4
                r2[r3] = r4     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r2 = f12344b     // Catch:{ NoSuchFieldError -> 0x003e }
                com.onesignal.i1$b r3 = com.onesignal.C4523i1.C4525b.EQUAL_TO     // Catch:{ NoSuchFieldError -> 0x003e }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r4 = 5
                r2[r3] = r4     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r2 = f12344b     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.onesignal.i1$b r3 = com.onesignal.C4523i1.C4525b.NOT_EQUAL_TO     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r4 = 6
                r2[r3] = r4     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                com.onesignal.i1$a[] r2 = com.onesignal.C4523i1.C4524a.m15564a()
                int r2 = r2.length
                int[] r2 = new int[r2]
                f12343a = r2
                com.onesignal.i1$a r3 = com.onesignal.C4523i1.C4524a.SESSION_TIME     // Catch:{ NoSuchFieldError -> 0x005a }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x005a }
                r2[r3] = r1     // Catch:{ NoSuchFieldError -> 0x005a }
            L_0x005a:
                int[] r1 = f12343a     // Catch:{ NoSuchFieldError -> 0x0064 }
                com.onesignal.i1$a r2 = com.onesignal.C4523i1.C4524a.TIME_SINCE_LAST_IN_APP     // Catch:{ NoSuchFieldError -> 0x0064 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0064 }
                r1[r2] = r0     // Catch:{ NoSuchFieldError -> 0x0064 }
            L_0x0064:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.onesignal.C4508g0.C4510b.<clinit>():void");
        }
    }

    /* renamed from: com.onesignal.g0$c */
    /* compiled from: OSDynamicTriggerController */
    interface C4511c {
        /* renamed from: a */
        void mo29775a();
    }

    C4508g0(C4511c cVar) {
        this.f12339a = cVar;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0075 A[DONT_GENERATE] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0077  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean mo29773a(com.onesignal.C4523i1 r15) {
        /*
            r14 = this;
            java.lang.Object r0 = r15.f12356e
            r1 = 0
            if (r0 != 0) goto L_0x0006
            return r1
        L_0x0006:
            java.util.ArrayList<java.lang.String> r0 = r14.f12340b
            monitor-enter(r0)
            java.lang.Object r2 = r15.f12356e     // Catch:{ all -> 0x009d }
            boolean r2 = r2 instanceof java.lang.Number     // Catch:{ all -> 0x009d }
            if (r2 != 0) goto L_0x0011
            monitor-exit(r0)     // Catch:{ all -> 0x009d }
            return r1
        L_0x0011:
            int[] r2 = com.onesignal.C4508g0.C4510b.f12343a     // Catch:{ all -> 0x009d }
            com.onesignal.i1$a r3 = r15.f12353b     // Catch:{ all -> 0x009d }
            int r3 = r3.ordinal()     // Catch:{ all -> 0x009d }
            r2 = r2[r3]     // Catch:{ all -> 0x009d }
            r3 = 1
            r4 = 0
            if (r2 == r3) goto L_0x004b
            r6 = 2
            if (r2 == r6) goto L_0x0025
            r6 = r4
            goto L_0x005b
        L_0x0025:
            com.onesignal.m0 r2 = com.onesignal.C4548m0.m15715h()     // Catch:{ all -> 0x009d }
            boolean r2 = r2.mo29839d()     // Catch:{ all -> 0x009d }
            if (r2 == 0) goto L_0x0031
            monitor-exit(r0)     // Catch:{ all -> 0x009d }
            return r1
        L_0x0031:
            com.onesignal.m0 r2 = com.onesignal.C4548m0.m15715h()     // Catch:{ all -> 0x009d }
            java.util.Date r2 = r2.f12442m     // Catch:{ all -> 0x009d }
            if (r2 != 0) goto L_0x003d
            r6 = 999999(0xf423f, double:4.94065E-318)
            goto L_0x005b
        L_0x003d:
            java.util.Date r6 = new java.util.Date     // Catch:{ all -> 0x009d }
            r6.<init>()     // Catch:{ all -> 0x009d }
            long r6 = r6.getTime()     // Catch:{ all -> 0x009d }
            long r8 = r2.getTime()     // Catch:{ all -> 0x009d }
            goto L_0x005a
        L_0x004b:
            java.util.Date r2 = new java.util.Date     // Catch:{ all -> 0x009d }
            r2.<init>()     // Catch:{ all -> 0x009d }
            long r6 = r2.getTime()     // Catch:{ all -> 0x009d }
            java.util.Date r2 = f12338c     // Catch:{ all -> 0x009d }
            long r8 = r2.getTime()     // Catch:{ all -> 0x009d }
        L_0x005a:
            long r6 = r6 - r8
        L_0x005b:
            java.lang.Object r2 = r15.f12356e     // Catch:{ all -> 0x009d }
            java.lang.Number r2 = (java.lang.Number) r2     // Catch:{ all -> 0x009d }
            double r8 = r2.doubleValue()     // Catch:{ all -> 0x009d }
            r10 = 4652007308841189376(0x408f400000000000, double:1000.0)
            double r8 = r8 * r10
            long r8 = (long) r8     // Catch:{ all -> 0x009d }
            double r10 = (double) r8     // Catch:{ all -> 0x009d }
            double r12 = (double) r6     // Catch:{ all -> 0x009d }
            com.onesignal.i1$b r2 = r15.f12355d     // Catch:{ all -> 0x009d }
            boolean r2 = m15532a(r10, r12, r2)     // Catch:{ all -> 0x009d }
            if (r2 == 0) goto L_0x0077
            monitor-exit(r0)     // Catch:{ all -> 0x009d }
            return r3
        L_0x0077:
            long r8 = r8 - r6
            int r2 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
            if (r2 > 0) goto L_0x007e
            monitor-exit(r0)     // Catch:{ all -> 0x009d }
            return r1
        L_0x007e:
            java.util.ArrayList<java.lang.String> r2 = r14.f12340b     // Catch:{ all -> 0x009d }
            java.lang.String r3 = r15.f12352a     // Catch:{ all -> 0x009d }
            boolean r2 = r2.contains(r3)     // Catch:{ all -> 0x009d }
            if (r2 == 0) goto L_0x008a
            monitor-exit(r0)     // Catch:{ all -> 0x009d }
            return r1
        L_0x008a:
            com.onesignal.g0$a r2 = new com.onesignal.g0$a     // Catch:{ all -> 0x009d }
            r2.<init>(r15)     // Catch:{ all -> 0x009d }
            java.lang.String r3 = r15.f12352a     // Catch:{ all -> 0x009d }
            com.onesignal.C4515h0.m15550a(r2, r3, r8)     // Catch:{ all -> 0x009d }
            java.util.ArrayList<java.lang.String> r2 = r14.f12340b     // Catch:{ all -> 0x009d }
            java.lang.String r15 = r15.f12352a     // Catch:{ all -> 0x009d }
            r2.add(r15)     // Catch:{ all -> 0x009d }
            monitor-exit(r0)     // Catch:{ all -> 0x009d }
            return r1
        L_0x009d:
            r15 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x009d }
            throw r15
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.C4508g0.mo29773a(com.onesignal.i1):boolean");
    }

    /* renamed from: a */
    private static boolean m15532a(double d, double d2, C4523i1.C4525b bVar) {
        switch (C4510b.f12344b[bVar.ordinal()]) {
            case 1:
                if (d2 < d) {
                    return true;
                }
                return false;
            case 2:
                if (d2 <= d || m15531a(d, d2)) {
                    return true;
                }
                return false;
            case 3:
                if (d2 > d) {
                    return true;
                }
                return false;
            case 4:
                if (d2 >= d || m15531a(d, d2)) {
                    return true;
                }
                return false;
            case 5:
                return m15531a(d, d2);
            case 6:
                return !m15531a(d, d2);
            default:
                C4564n1.C4566a0 a0Var = C4564n1.C4566a0.ERROR;
                C4564n1.m15815b(a0Var, "Attempted to apply an invalid operator on a time-based in-app-message trigger: " + bVar.toString());
                return false;
        }
    }

    /* renamed from: a */
    private static boolean m15531a(double d, double d2) {
        return Math.abs(d - d2) < 0.3d;
    }
}
