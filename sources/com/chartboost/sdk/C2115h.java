package com.chartboost.sdk;

import android.content.Context;
import com.chartboost.sdk.Chartboost;
import com.chartboost.sdk.Libraries.CBLogging;
import com.chartboost.sdk.impl.C2149g1;

/* renamed from: com.chartboost.sdk.h */
class C2115h implements Runnable {

    /* renamed from: a */
    private final int f7089a;

    /* renamed from: b */
    boolean f7090b = false;

    /* renamed from: c */
    Chartboost.CBFramework f7091c = null;

    /* renamed from: d */
    String f7092d = null;

    /* renamed from: e */
    C2149g1 f7093e = null;

    /* renamed from: f */
    String f7094f = null;

    /* renamed from: g */
    CBLogging.Level f7095g = null;

    /* renamed from: h */
    ChartboostDelegate f7096h = null;

    /* renamed from: i */
    Context f7097i = null;

    /* renamed from: j */
    String f7098j = null;

    /* renamed from: k */
    String f7099k = null;

    C2115h(int i) {
        this.f7089a = i;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v0, resolved type: java.util.concurrent.ScheduledExecutorService} */
    /* JADX WARNING: Code restructure failed: missing block: B:87:?, code lost:
        return;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x00fb A[Catch:{ all -> 0x00f5 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void run() {
        /*
            r10 = this;
            int r0 = r10.f7089a     // Catch:{ Exception -> 0x0115 }
            switch(r0) {
                case 0: goto L_0x0065;
                case 1: goto L_0x005f;
                case 2: goto L_0x0005;
                case 3: goto L_0x0059;
                case 4: goto L_0x002e;
                case 5: goto L_0x0027;
                case 6: goto L_0x0021;
                case 7: goto L_0x0014;
                case 8: goto L_0x0007;
                default: goto L_0x0005;
            }     // Catch:{ Exception -> 0x0115 }
        L_0x0005:
            goto L_0x0133
        L_0x0007:
            com.chartboost.sdk.ChartboostDelegate r0 = r10.f7096h     // Catch:{ Exception -> 0x0115 }
            com.chartboost.sdk.C2242k.f7604d = r0     // Catch:{ Exception -> 0x0115 }
            java.lang.String r0 = "SdkSettings.assignDelegate"
            com.chartboost.sdk.ChartboostDelegate r1 = r10.f7096h     // Catch:{ Exception -> 0x0115 }
            com.chartboost.sdk.impl.C2166i1.m8610a((java.lang.String) r0, (java.lang.Object) r1)     // Catch:{ Exception -> 0x0115 }
            goto L_0x0133
        L_0x0014:
            boolean r0 = com.chartboost.sdk.C2101c.m8325a()     // Catch:{ Exception -> 0x0115 }
            if (r0 != 0) goto L_0x001b
            return
        L_0x001b:
            com.chartboost.sdk.Libraries.CBLogging$Level r0 = r10.f7095g     // Catch:{ Exception -> 0x0115 }
            com.chartboost.sdk.Libraries.CBLogging.f6849a = r0     // Catch:{ Exception -> 0x0115 }
            goto L_0x0133
        L_0x0021:
            java.lang.String r0 = r10.f7094f     // Catch:{ Exception -> 0x0115 }
            com.chartboost.sdk.C2242k.f7602b = r0     // Catch:{ Exception -> 0x0115 }
            goto L_0x0133
        L_0x0027:
            java.lang.String r0 = r10.f7092d     // Catch:{ Exception -> 0x0115 }
            com.chartboost.sdk.C2101c.m8324a((java.lang.String) r0)     // Catch:{ Exception -> 0x0115 }
            goto L_0x0133
        L_0x002e:
            com.chartboost.sdk.Chartboost$CBFramework r0 = r10.f7091c     // Catch:{ Exception -> 0x0115 }
            if (r0 != 0) goto L_0x003a
            java.lang.String r0 = "ChartboostCommand"
            java.lang.String r1 = "Pass a valid CBFramework enum value"
            com.chartboost.sdk.Libraries.CBLogging.m8154b(r0, r1)     // Catch:{ Exception -> 0x0115 }
            return
        L_0x003a:
            com.chartboost.sdk.Chartboost$CBFramework r0 = r10.f7091c     // Catch:{ Exception -> 0x0115 }
            com.chartboost.sdk.C2242k.f7605e = r0     // Catch:{ Exception -> 0x0115 }
            java.lang.String r0 = r10.f7092d     // Catch:{ Exception -> 0x0115 }
            com.chartboost.sdk.C2242k.f7606f = r0     // Catch:{ Exception -> 0x0115 }
            java.lang.String r0 = "%s %s"
            r1 = 2
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch:{ Exception -> 0x0115 }
            r2 = 0
            com.chartboost.sdk.Chartboost$CBFramework r3 = r10.f7091c     // Catch:{ Exception -> 0x0115 }
            r1[r2] = r3     // Catch:{ Exception -> 0x0115 }
            r2 = 1
            java.lang.String r3 = r10.f7092d     // Catch:{ Exception -> 0x0115 }
            r1[r2] = r3     // Catch:{ Exception -> 0x0115 }
            java.lang.String r0 = java.lang.String.format(r0, r1)     // Catch:{ Exception -> 0x0115 }
            com.chartboost.sdk.C2242k.f7607g = r0     // Catch:{ Exception -> 0x0115 }
            goto L_0x0133
        L_0x0059:
            com.chartboost.sdk.impl.g1 r0 = r10.f7093e     // Catch:{ Exception -> 0x0115 }
            com.chartboost.sdk.C2242k.f7609i = r0     // Catch:{ Exception -> 0x0115 }
            goto L_0x0133
        L_0x005f:
            boolean r0 = r10.f7090b     // Catch:{ Exception -> 0x0115 }
            com.chartboost.sdk.C2242k.f7619s = r0     // Catch:{ Exception -> 0x0115 }
            goto L_0x0133
        L_0x0065:
            com.chartboost.sdk.j r0 = com.chartboost.sdk.C2239j.m8897n()     // Catch:{ Exception -> 0x0115 }
            if (r0 != 0) goto L_0x0133
            java.lang.Class<com.chartboost.sdk.j> r0 = com.chartboost.sdk.C2239j.class
            monitor-enter(r0)     // Catch:{ Exception -> 0x0115 }
            com.chartboost.sdk.j r1 = com.chartboost.sdk.C2239j.m8897n()     // Catch:{ all -> 0x0112 }
            if (r1 != 0) goto L_0x0110
            android.content.Context r1 = r10.f7097i     // Catch:{ all -> 0x0112 }
            if (r1 != 0) goto L_0x0081
            java.lang.String r1 = "ChartboostCommand"
            java.lang.String r2 = "Context object is null. Please pass a valid activity object"
            com.chartboost.sdk.Libraries.CBLogging.m8154b(r1, r2)     // Catch:{ all -> 0x0112 }
            monitor-exit(r0)     // Catch:{ all -> 0x0112 }
            return
        L_0x0081:
            android.content.Context r1 = r10.f7097i     // Catch:{ all -> 0x0112 }
            boolean r1 = com.chartboost.sdk.C2101c.m8330b(r1)     // Catch:{ all -> 0x0112 }
            if (r1 != 0) goto L_0x0092
            java.lang.String r1 = "ChartboostCommand"
            java.lang.String r2 = "Permissions not set correctly"
            com.chartboost.sdk.Libraries.CBLogging.m8154b(r1, r2)     // Catch:{ all -> 0x0112 }
            monitor-exit(r0)     // Catch:{ all -> 0x0112 }
            return
        L_0x0092:
            android.content.Context r1 = r10.f7097i     // Catch:{ all -> 0x0112 }
            boolean r1 = com.chartboost.sdk.C2101c.m8327a((android.content.Context) r1)     // Catch:{ all -> 0x0112 }
            if (r1 != 0) goto L_0x00a1
            java.lang.String r1 = "ChartboostCommand"
            java.lang.String r2 = "Please add CBImpressionActivity in AndroidManifest.xml following README.md instructions."
            com.chartboost.sdk.Libraries.CBLogging.m8154b(r1, r2)     // Catch:{ all -> 0x0112 }
        L_0x00a1:
            java.lang.String r1 = r10.f7098j     // Catch:{ all -> 0x0112 }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ all -> 0x0112 }
            if (r1 != 0) goto L_0x0107
            java.lang.String r1 = r10.f7099k     // Catch:{ all -> 0x0112 }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ all -> 0x0112 }
            if (r1 == 0) goto L_0x00b2
            goto L_0x0107
        L_0x00b2:
            com.chartboost.sdk.impl.x r6 = com.chartboost.sdk.impl.C2224x.m8805e()     // Catch:{ all -> 0x0112 }
            com.chartboost.sdk.i r1 = com.chartboost.sdk.C2116i.m8407a()     // Catch:{ all -> 0x0112 }
            android.os.Handler r8 = r6.f7490a     // Catch:{ all -> 0x0112 }
            r2 = 0
            java.util.concurrent.ScheduledExecutorService r3 = com.chartboost.sdk.impl.C2199q0.m8753a()     // Catch:{ all -> 0x00f8 }
            java.lang.Object r3 = r1.mo9266a(r3)     // Catch:{ all -> 0x00f8 }
            r7 = r3
            java.util.concurrent.ScheduledExecutorService r7 = (java.util.concurrent.ScheduledExecutorService) r7     // Catch:{ all -> 0x00f8 }
            r2 = 4
            java.util.concurrent.ExecutorService r2 = com.chartboost.sdk.impl.C2199q0.m8752a(r2)     // Catch:{ all -> 0x00f5 }
            java.lang.Object r1 = r1.mo9266a(r2)     // Catch:{ all -> 0x00f5 }
            r9 = r1
            java.util.concurrent.ExecutorService r9 = (java.util.concurrent.ExecutorService) r9     // Catch:{ all -> 0x00f5 }
            com.chartboost.sdk.j r1 = new com.chartboost.sdk.j     // Catch:{ all -> 0x0112 }
            android.content.Context r3 = r10.f7097i     // Catch:{ all -> 0x0112 }
            java.lang.String r4 = r10.f7098j     // Catch:{ all -> 0x0112 }
            java.lang.String r5 = r10.f7099k     // Catch:{ all -> 0x0112 }
            r2 = r1
            r2.<init>(r3, r4, r5, r6, r7, r8, r9)     // Catch:{ all -> 0x0112 }
            com.chartboost.sdk.C2239j.m8894a((com.chartboost.sdk.C2239j) r1)     // Catch:{ all -> 0x0112 }
            com.chartboost.sdk.impl.n r2 = r1.f7573g     // Catch:{ all -> 0x0112 }
            r2.mo9435b()     // Catch:{ all -> 0x0112 }
            com.chartboost.sdk.j$b r2 = new com.chartboost.sdk.j$b     // Catch:{ all -> 0x0112 }
            r1.getClass()     // Catch:{ all -> 0x0112 }
            r3 = 3
            r2.<init>(r3)     // Catch:{ all -> 0x0112 }
            r1.mo9603a((java.lang.Runnable) r2)     // Catch:{ all -> 0x0112 }
            goto L_0x0110
        L_0x00f5:
            r1 = move-exception
            r2 = r7
            goto L_0x00f9
        L_0x00f8:
            r1 = move-exception
        L_0x00f9:
            if (r2 == 0) goto L_0x00fe
            r2.shutdown()     // Catch:{ all -> 0x0112 }
        L_0x00fe:
            java.lang.String r2 = "ChartboostCommand"
            java.lang.String r3 = "Unable to start threads"
            com.chartboost.sdk.Libraries.CBLogging.m8153a(r2, r3, r1)     // Catch:{ all -> 0x0112 }
            monitor-exit(r0)     // Catch:{ all -> 0x0112 }
            return
        L_0x0107:
            java.lang.String r1 = "ChartboostCommand"
            java.lang.String r2 = "AppId or AppSignature is null. Please pass a valid id's"
            com.chartboost.sdk.Libraries.CBLogging.m8154b(r1, r2)     // Catch:{ all -> 0x0112 }
            monitor-exit(r0)     // Catch:{ all -> 0x0112 }
            return
        L_0x0110:
            monitor-exit(r0)     // Catch:{ all -> 0x0112 }
            goto L_0x0133
        L_0x0112:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0112 }
            throw r1     // Catch:{ Exception -> 0x0115 }
        L_0x0115:
            r0 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "run ("
            r1.append(r2)
            int r2 = r10.f7089a
            r1.append(r2)
            java.lang.String r2 = ")"
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            java.lang.Class<com.chartboost.sdk.h> r2 = com.chartboost.sdk.C2115h.class
            com.chartboost.sdk.Tracking.C2098a.m8288a((java.lang.Class) r2, (java.lang.String) r1, (java.lang.Exception) r0)
        L_0x0133:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.chartboost.sdk.C2115h.run():void");
    }
}
