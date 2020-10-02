package com.moat.analytics.mobile.ogury;

import android.util.Log;

/* renamed from: com.moat.analytics.mobile.ogury.l */
final class C4332l extends Exception {

    /* renamed from: ˋ */
    private static final Long f11597 = 60000L;

    /* renamed from: ˎ */
    private static Exception f11598 = null;

    /* renamed from: ॱ */
    private static Long f11599;

    C4332l(String str) {
        super(str);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(20:7|(4:9|10|11|(1:13))|14|(1:16)(1:17)|18|19|20|21|(1:23)(2:24|25)|26|27|29|30|31|32|33|34|40|41|(2:45|48)(1:49)) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:40:0x00d8 */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0172 A[Catch:{ Exception -> 0x0183 }] */
    /* JADX WARNING: Removed duplicated region for block: B:49:? A[Catch:{ Exception -> 0x0183 }, RETURN, SYNTHETIC] */
    /* renamed from: ˊ */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void m14506(java.lang.Exception r13) {
        /*
            java.lang.String r0 = ""
            com.moat.analytics.mobile.ogury.q r1 = com.moat.analytics.mobile.ogury.C4346q.m14542()     // Catch:{ Exception -> 0x0183 }
            int r1 = r1.f11640     // Catch:{ Exception -> 0x0183 }
            int r2 = com.moat.analytics.mobile.ogury.C4346q.C4354e.f11657     // Catch:{ Exception -> 0x0183 }
            if (r1 != r2) goto L_0x0181
            com.moat.analytics.mobile.ogury.q r1 = com.moat.analytics.mobile.ogury.C4346q.m14542()     // Catch:{ Exception -> 0x0183 }
            int r1 = r1.f11633     // Catch:{ Exception -> 0x0183 }
            if (r1 != 0) goto L_0x0015
            return
        L_0x0015:
            r2 = 100
            if (r1 >= r2) goto L_0x0029
            double r2 = (double) r1
            r4 = 4636737291354636288(0x4059000000000000, double:100.0)
            java.lang.Double.isNaN(r2)
            double r2 = r2 / r4
            double r4 = java.lang.Math.random()     // Catch:{ Exception -> 0x0183 }
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 >= 0) goto L_0x0029
            return
        L_0x0029:
            java.lang.String r2 = "https://px.moatads.com/pixel.gif?e=0&i=MOATSDK1&ac=1"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0183 }
            r3.<init>(r2)     // Catch:{ Exception -> 0x0183 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0183 }
            java.lang.String r4 = "&zt="
            r2.<init>(r4)     // Catch:{ Exception -> 0x0183 }
            boolean r4 = r13 instanceof com.moat.analytics.mobile.ogury.C4332l     // Catch:{ Exception -> 0x0183 }
            r5 = 1
            r6 = 0
            if (r4 == 0) goto L_0x003f
            r4 = 1
            goto L_0x0040
        L_0x003f:
            r4 = 0
        L_0x0040:
            r2.append(r4)     // Catch:{ Exception -> 0x0183 }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x0183 }
            r3.append(r2)     // Catch:{ Exception -> 0x0183 }
            java.lang.String r2 = "&zr="
            java.lang.String r1 = java.lang.String.valueOf(r1)     // Catch:{ Exception -> 0x0183 }
            java.lang.String r1 = r2.concat(r1)     // Catch:{ Exception -> 0x0183 }
            r3.append(r1)     // Catch:{ Exception -> 0x0183 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00a4 }
            java.lang.String r2 = "&zm="
            r1.<init>(r2)     // Catch:{ Exception -> 0x00a4 }
            java.lang.String r2 = r13.getMessage()     // Catch:{ Exception -> 0x00a4 }
            java.lang.String r4 = "UTF-8"
            if (r2 != 0) goto L_0x0069
            java.lang.String r2 = "null"
            goto L_0x0079
        L_0x0069:
            java.lang.String r2 = r13.getMessage()     // Catch:{ Exception -> 0x00a4 }
            byte[] r2 = r2.getBytes(r4)     // Catch:{ Exception -> 0x00a4 }
            java.lang.String r2 = android.util.Base64.encodeToString(r2, r6)     // Catch:{ Exception -> 0x00a4 }
            java.lang.String r2 = java.net.URLEncoder.encode(r2, r4)     // Catch:{ Exception -> 0x00a4 }
        L_0x0079:
            r1.append(r2)     // Catch:{ Exception -> 0x00a4 }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x00a4 }
            r3.append(r1)     // Catch:{ Exception -> 0x00a4 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00a4 }
            java.lang.String r2 = "&k="
            r1.<init>(r2)     // Catch:{ Exception -> 0x00a4 }
            java.lang.String r13 = android.util.Log.getStackTraceString(r13)     // Catch:{ Exception -> 0x00a4 }
            byte[] r13 = r13.getBytes(r4)     // Catch:{ Exception -> 0x00a4 }
            java.lang.String r13 = android.util.Base64.encodeToString(r13, r6)     // Catch:{ Exception -> 0x00a4 }
            java.lang.String r13 = java.net.URLEncoder.encode(r13, r4)     // Catch:{ Exception -> 0x00a4 }
            r1.append(r13)     // Catch:{ Exception -> 0x00a4 }
            java.lang.String r13 = r1.toString()     // Catch:{ Exception -> 0x00a4 }
            r3.append(r13)     // Catch:{ Exception -> 0x00a4 }
        L_0x00a4:
            java.lang.String r13 = "OGURY"
            java.lang.String r1 = "&zMoatMMAKv=5e29fb7ac3f5a02776850780700bd118383621e1"
            r3.append(r1)     // Catch:{ Exception -> 0x00d3 }
            java.lang.String r1 = "2.4.3"
            com.moat.analytics.mobile.ogury.s$a r2 = com.moat.analytics.mobile.ogury.C4356s.m14574()     // Catch:{ Exception -> 0x00d1 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00d1 }
            java.lang.String r7 = "&zMoatMMAKan="
            r4.<init>(r7)     // Catch:{ Exception -> 0x00d1 }
            java.lang.String r7 = r2.mo29191()     // Catch:{ Exception -> 0x00d1 }
            r4.append(r7)     // Catch:{ Exception -> 0x00d1 }
            java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x00d1 }
            r3.append(r4)     // Catch:{ Exception -> 0x00d1 }
            java.lang.String r2 = r2.mo29190()     // Catch:{ Exception -> 0x00d1 }
            int r4 = android.os.Build.VERSION.SDK_INT     // Catch:{ Exception -> 0x00d8 }
            java.lang.String r0 = java.lang.Integer.toString(r4)     // Catch:{ Exception -> 0x00d8 }
            goto L_0x00d8
        L_0x00d1:
            r2 = r0
            goto L_0x00d8
        L_0x00d3:
            r1 = r0
            goto L_0x00d7
        L_0x00d5:
            r13 = r0
            r1 = r13
        L_0x00d7:
            r2 = r1
        L_0x00d8:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0183 }
            java.lang.String r7 = "&d=Android:"
            r4.<init>(r7)     // Catch:{ Exception -> 0x0183 }
            r4.append(r13)     // Catch:{ Exception -> 0x0183 }
            java.lang.String r13 = ":"
            r4.append(r13)     // Catch:{ Exception -> 0x0183 }
            r4.append(r2)     // Catch:{ Exception -> 0x0183 }
            java.lang.String r13 = ":-"
            r4.append(r13)     // Catch:{ Exception -> 0x0183 }
            java.lang.String r13 = r4.toString()     // Catch:{ Exception -> 0x0183 }
            r3.append(r13)     // Catch:{ Exception -> 0x0183 }
            java.lang.String r13 = "&bo="
            java.lang.String r13 = r13.concat(r1)     // Catch:{ Exception -> 0x0183 }
            r3.append(r13)     // Catch:{ Exception -> 0x0183 }
            java.lang.String r13 = "&bd="
            java.lang.String r0 = java.lang.String.valueOf(r0)     // Catch:{ Exception -> 0x0183 }
            java.lang.String r13 = r13.concat(r0)     // Catch:{ Exception -> 0x0183 }
            r3.append(r13)     // Catch:{ Exception -> 0x0183 }
            long r0 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x0183 }
            java.lang.Long r13 = java.lang.Long.valueOf(r0)     // Catch:{ Exception -> 0x0183 }
            java.lang.String r0 = "&t="
            java.lang.String r1 = java.lang.String.valueOf(r13)     // Catch:{ Exception -> 0x0183 }
            java.lang.String r0 = r0.concat(r1)     // Catch:{ Exception -> 0x0183 }
            r3.append(r0)     // Catch:{ Exception -> 0x0183 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0183 }
            java.lang.String r1 = "&de="
            r0.<init>(r1)     // Catch:{ Exception -> 0x0183 }
            java.util.Locale r1 = java.util.Locale.ROOT     // Catch:{ Exception -> 0x0183 }
            java.lang.String r2 = "%.0f"
            java.lang.Object[] r4 = new java.lang.Object[r5]     // Catch:{ Exception -> 0x0183 }
            double r7 = java.lang.Math.random()     // Catch:{ Exception -> 0x0183 }
            r9 = 4621819117588971520(0x4024000000000000, double:10.0)
            r11 = 4622945017495814144(0x4028000000000000, double:12.0)
            double r9 = java.lang.Math.pow(r9, r11)     // Catch:{ Exception -> 0x0183 }
            double r7 = r7 * r9
            double r7 = java.lang.Math.floor(r7)     // Catch:{ Exception -> 0x0183 }
            java.lang.Double r5 = java.lang.Double.valueOf(r7)     // Catch:{ Exception -> 0x0183 }
            r4[r6] = r5     // Catch:{ Exception -> 0x0183 }
            java.lang.String r1 = java.lang.String.format(r1, r2, r4)     // Catch:{ Exception -> 0x0183 }
            r0.append(r1)     // Catch:{ Exception -> 0x0183 }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x0183 }
            r3.append(r0)     // Catch:{ Exception -> 0x0183 }
            java.lang.String r0 = "&cs=0"
            r3.append(r0)     // Catch:{ Exception -> 0x0183 }
            java.lang.Long r0 = f11599     // Catch:{ Exception -> 0x0183 }
            if (r0 == 0) goto L_0x0172
            long r0 = r13.longValue()     // Catch:{ Exception -> 0x0183 }
            java.lang.Long r2 = f11599     // Catch:{ Exception -> 0x0183 }
            long r4 = r2.longValue()     // Catch:{ Exception -> 0x0183 }
            long r0 = r0 - r4
            java.lang.Long r2 = f11597     // Catch:{ Exception -> 0x0183 }
            long r4 = r2.longValue()     // Catch:{ Exception -> 0x0183 }
            int r2 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r2 <= 0) goto L_0x0180
        L_0x0172:
            java.lang.String r0 = r3.toString()     // Catch:{ Exception -> 0x0183 }
            com.moat.analytics.mobile.ogury.k$5 r1 = new com.moat.analytics.mobile.ogury.k$5     // Catch:{ Exception -> 0x0183 }
            r1.<init>(r0)     // Catch:{ Exception -> 0x0183 }
            r1.start()     // Catch:{ Exception -> 0x0183 }
            f11599 = r13     // Catch:{ Exception -> 0x0183 }
        L_0x0180:
            return
        L_0x0181:
            f11598 = r13     // Catch:{ Exception -> 0x0183 }
        L_0x0183:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.moat.analytics.mobile.ogury.C4332l.m14506(java.lang.Exception):void");
    }

    /* renamed from: ˋ */
    static String m14507(String str, Exception exc) {
        if (exc instanceof C4332l) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(" failed: ");
            sb.append(exc.getMessage());
            return sb.toString();
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str);
        sb2.append(" failed unexpectedly");
        return sb2.toString();
    }

    /* renamed from: ॱ */
    static void m14509(Exception exc) {
        if (C4346q.m14542().f11638) {
            Log.e("MoatException", Log.getStackTraceString(exc));
        } else {
            m14506(exc);
        }
    }

    /* renamed from: ˋ */
    static void m14508() {
        Exception exc = f11598;
        if (exc != null) {
            m14506(exc);
            f11598 = null;
        }
    }
}
