package com.tapjoy.internal;

import android.content.Context;
import android.content.SharedPreferences;
import com.tapjoy.TapjoyConstants;

/* renamed from: com.tapjoy.internal.ga */
public final class C5106ga {

    /* renamed from: b */
    private static final C5106ga f13971b;

    /* renamed from: c */
    private static C5106ga f13972c;

    /* renamed from: a */
    public final C3136fy f13973a = new C3136fy();

    /* renamed from: d */
    private Context f13974d;

    static {
        C5106ga gaVar = new C5106ga();
        f13971b = gaVar;
        f13972c = gaVar;
    }

    C5106ga() {
    }

    /* renamed from: a */
    public static C5106ga m17238a() {
        return f13972c;
    }

    /* renamed from: b */
    public static C3136fy m17239b() {
        return f13972c.f13973a;
    }

    /* renamed from: c */
    public final SharedPreferences mo31280c() {
        return this.f13974d.getSharedPreferences(TapjoyConstants.TJC_PREFERENCE, 0);
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:16:0x0030 */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void mo31279a(android.content.Context r4) {
        /*
            r3 = this;
            monitor-enter(r3)
            if (r4 == 0) goto L_0x0050
            android.content.Context r0 = r3.f13974d     // Catch:{ all -> 0x004d }
            if (r0 != 0) goto L_0x0050
            r3.f13974d = r4     // Catch:{ all -> 0x004d }
            android.content.SharedPreferences r4 = r3.mo31280c()     // Catch:{ all -> 0x004d }
            android.content.SharedPreferences r0 = r3.mo31280c()     // Catch:{ all -> 0x004d }
            java.lang.String r1 = "configurations"
            r2 = 0
            java.lang.String r0 = r0.getString(r1, r2)     // Catch:{ all -> 0x004d }
            if (r0 == 0) goto L_0x003d
            com.tapjoy.internal.bn r0 = com.tapjoy.internal.C3126bn.m10231b(r0)     // Catch:{ Exception -> 0x0030 }
            java.util.Map r1 = r0.mo18484d()     // Catch:{ all -> 0x002b }
            r0.close()     // Catch:{ Exception -> 0x0030 }
            com.tapjoy.internal.fy r0 = r3.f13973a     // Catch:{ Exception -> 0x0030 }
            r0.mo18516a((java.util.Map) r1)     // Catch:{ Exception -> 0x0030 }
            goto L_0x003d
        L_0x002b:
            r1 = move-exception
            r0.close()     // Catch:{ Exception -> 0x0030 }
            throw r1     // Catch:{ Exception -> 0x0030 }
        L_0x0030:
            android.content.SharedPreferences$Editor r4 = r4.edit()     // Catch:{ all -> 0x004d }
            java.lang.String r0 = "configurations"
            android.content.SharedPreferences$Editor r4 = r4.remove(r0)     // Catch:{ all -> 0x004d }
            r4.apply()     // Catch:{ all -> 0x004d }
        L_0x003d:
            com.tapjoy.internal.ga$1 r4 = new com.tapjoy.internal.ga$1     // Catch:{ all -> 0x004d }
            r4.<init>()     // Catch:{ all -> 0x004d }
            com.tapjoy.internal.fy r0 = r3.f13973a     // Catch:{ all -> 0x004d }
            r0.addObserver(r4)     // Catch:{ all -> 0x004d }
            com.tapjoy.internal.fy r0 = r3.f13973a     // Catch:{ all -> 0x004d }
            r4.update(r0, r2)     // Catch:{ all -> 0x004d }
            goto L_0x0050
        L_0x004d:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        L_0x0050:
            monitor-exit(r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tapjoy.internal.C5106ga.mo31279a(android.content.Context):void");
    }
}
