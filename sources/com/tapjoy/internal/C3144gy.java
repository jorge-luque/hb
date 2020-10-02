package com.tapjoy.internal;

import android.content.SharedPreferences;
import android.os.SystemClock;
import com.tapjoy.internal.C5041ev;
import com.tapjoy.internal.C5047ex;
import com.tapjoy.internal.C5065fd;
import java.util.Map;
import javax.annotation.Nullable;

/* renamed from: com.tapjoy.internal.gy */
public final class C3144gy {

    /* renamed from: a */
    final C3149hc f8748a;

    /* renamed from: b */
    final C5140gx f8749b;

    /* renamed from: c */
    long f8750c;

    /* renamed from: d */
    private int f8751d = 1;

    /* renamed from: e */
    private final C5047ex.C5048a f8752e = new C5047ex.C5048a();

    C3144gy(C3149hc hcVar, C5140gx gxVar) {
        this.f8748a = hcVar;
        this.f8749b = gxVar;
    }

    /* renamed from: a */
    public final void mo18540a(String str, String str2, double d, @Nullable String str3, @Nullable String str4, @Nullable String str5) {
        double d2;
        C3149hc hcVar = this.f8748a;
        synchronized (hcVar) {
            SharedPreferences.Editor a = hcVar.f8783c.mo31334a();
            int i = 1;
            if (str2.equals(hcVar.f8783c.f14124l.mo31485a())) {
                i = 1 + hcVar.f8783c.f14125m.mo31466b();
                hcVar.f8783c.f14125m.mo31462a(a, i);
                d2 = hcVar.f8783c.f14126n.mo31348a() + d;
                hcVar.f8783c.f14126n.mo31350a(a, d2);
                a.apply();
            } else {
                hcVar.f8783c.f14124l.mo31484a(a, str2);
                hcVar.f8783c.f14125m.mo31462a(a, 1);
                hcVar.f8783c.f14126n.mo31350a(a, d);
                hcVar.f8783c.f14127o.mo31480a(a);
                hcVar.f8783c.f14128p.mo31349a(a);
                a.apply();
                hcVar.f8782b.f13899l = str2;
                hcVar.f8782b.f13902o = null;
                hcVar.f8782b.f13903p = null;
                d2 = d;
            }
            hcVar.f8782b.f13900m = Integer.valueOf(i);
            hcVar.f8782b.f13901n = Double.valueOf(d2);
        }
        C5041ev.C5042a a2 = mo18538a(C5050ey.APP, "purchase");
        C5065fd.C5066a aVar = new C5065fd.C5066a();
        aVar.f13817c = str;
        if (str2 != null) {
            aVar.f13820f = str2;
        }
        aVar.f13819e = Double.valueOf(d);
        if (str5 != null) {
            aVar.f13827m = str5;
        }
        if (str3 != null) {
            aVar.f13829o = str3;
        }
        if (str4 != null) {
            aVar.f13830p = str4;
        }
        a2.f13707p = aVar.mo31221b();
        mo18539a(a2);
        C3149hc hcVar2 = this.f8748a;
        long longValue = a2.f13696e.longValue();
        synchronized (hcVar2) {
            SharedPreferences.Editor a3 = hcVar2.f8783c.mo31334a();
            hcVar2.f8783c.f14127o.mo31481a(a3, longValue);
            hcVar2.f8783c.f14128p.mo31350a(a3, d);
            a3.apply();
            hcVar2.f8782b.f13902o = Long.valueOf(longValue);
            hcVar2.f8782b.f13903p = Double.valueOf(d);
        }
    }

    /* renamed from: a */
    public final void mo18542a(String str, String str2, String str3, String str4, Map map) {
        C5041ev.C5042a a = mo18538a(C5050ey.CUSTOM, str2);
        a.f13711t = str;
        a.f13712u = str3;
        a.f13713v = str4;
        if (map != null) {
            for (Map.Entry entry : map.entrySet()) {
                a.f13714w.add(new C5052ez((String) entry.getKey(), (Long) entry.getValue()));
            }
        }
        mo18539a(a);
    }

    /* renamed from: a */
    public final void mo18541a(String str, String str2, int i, long j, long j2, Map map) {
        C5041ev.C5042a a = mo18538a(C5050ey.USAGES, str);
        a.f13715x = str2;
        a.f13716y = Integer.valueOf(i);
        a.f13717z = Long.valueOf(j);
        a.f13693A = Long.valueOf(j2);
        if (map != null) {
            for (Map.Entry entry : map.entrySet()) {
                a.f13714w.add(new C5052ez((String) entry.getKey(), (Long) entry.getValue()));
            }
        }
        mo18539a(a);
    }

    /* renamed from: a */
    public final C5041ev.C5042a mo18538a(C5050ey eyVar, String str) {
        C5059fb b = this.f8748a.mo18588b();
        C5041ev.C5042a aVar = new C5041ev.C5042a();
        aVar.f13698g = C3149hc.f8780a;
        aVar.f13694c = eyVar;
        aVar.f13695d = str;
        if (C5271v.m17677c()) {
            aVar.f13696e = Long.valueOf(C5271v.m17676b());
            aVar.f13697f = Long.valueOf(System.currentTimeMillis());
        } else {
            aVar.f13696e = Long.valueOf(System.currentTimeMillis());
            aVar.f13699h = Long.valueOf(SystemClock.elapsedRealtime());
        }
        aVar.f13701j = b.f13785d;
        aVar.f13702k = b.f13786e;
        aVar.f13703l = b.f13787f;
        return aVar;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(8:12|13|15|16|17|18|19|20) */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0046 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x004e */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0053  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x006a A[SYNTHETIC, Splitter:B:37:0x006a] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void mo18539a(com.tapjoy.internal.C5041ev.C5042a r5) {
        /*
            r4 = this;
            monitor-enter(r4)
            com.tapjoy.internal.ey r0 = r5.f13694c     // Catch:{ all -> 0x0075 }
            com.tapjoy.internal.ey r1 = com.tapjoy.internal.C5050ey.USAGES     // Catch:{ all -> 0x0075 }
            if (r0 == r1) goto L_0x0033
            int r0 = r4.f8751d     // Catch:{ all -> 0x0075 }
            int r1 = r0 + 1
            r4.f8751d = r1     // Catch:{ all -> 0x0075 }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ all -> 0x0075 }
            r5.f13705n = r0     // Catch:{ all -> 0x0075 }
            com.tapjoy.internal.ex$a r0 = r4.f8752e     // Catch:{ all -> 0x0075 }
            com.tapjoy.internal.ey r0 = r0.f13726c     // Catch:{ all -> 0x0075 }
            if (r0 == 0) goto L_0x0021
            com.tapjoy.internal.ex$a r0 = r4.f8752e     // Catch:{ all -> 0x0075 }
            com.tapjoy.internal.ex r0 = r0.mo31206b()     // Catch:{ all -> 0x0075 }
            r5.f13706o = r0     // Catch:{ all -> 0x0075 }
        L_0x0021:
            com.tapjoy.internal.ex$a r0 = r4.f8752e     // Catch:{ all -> 0x0075 }
            com.tapjoy.internal.ey r1 = r5.f13694c     // Catch:{ all -> 0x0075 }
            r0.f13726c = r1     // Catch:{ all -> 0x0075 }
            com.tapjoy.internal.ex$a r0 = r4.f8752e     // Catch:{ all -> 0x0075 }
            java.lang.String r1 = r5.f13695d     // Catch:{ all -> 0x0075 }
            r0.f13727d = r1     // Catch:{ all -> 0x0075 }
            com.tapjoy.internal.ex$a r0 = r4.f8752e     // Catch:{ all -> 0x0075 }
            java.lang.String r1 = r5.f13711t     // Catch:{ all -> 0x0075 }
            r0.f13728e = r1     // Catch:{ all -> 0x0075 }
        L_0x0033:
            com.tapjoy.internal.gx r0 = r4.f8749b     // Catch:{ all -> 0x0075 }
            com.tapjoy.internal.ev r5 = r5.mo31200b()     // Catch:{ all -> 0x0075 }
            com.tapjoy.internal.hl r1 = r0.f14056a     // Catch:{ Exception -> 0x0073 }
            java.lang.Object r2 = r1.f8793a     // Catch:{ Exception -> 0x0073 }
            monitor-enter(r2)     // Catch:{ Exception -> 0x0073 }
            com.tapjoy.internal.ax r3 = r1.f8794b     // Catch:{ Exception -> 0x0046 }
            r3.add(r5)     // Catch:{ Exception -> 0x0046 }
            goto L_0x004e
        L_0x0044:
            r5 = move-exception
            goto L_0x0071
        L_0x0046:
            r1.mo18601a()     // Catch:{ all -> 0x0044 }
            com.tapjoy.internal.ax r1 = r1.f8794b     // Catch:{ Exception -> 0x004e }
            r1.add(r5)     // Catch:{ Exception -> 0x004e }
        L_0x004e:
            monitor-exit(r2)     // Catch:{ all -> 0x0044 }
            com.tapjoy.internal.cd r1 = r0.f14057b     // Catch:{ all -> 0x0075 }
            if (r1 == 0) goto L_0x006a
            boolean r1 = com.tapjoy.internal.C5139gw.f14055a     // Catch:{ all -> 0x0075 }
            if (r1 != 0) goto L_0x0064
            com.tapjoy.internal.ey r5 = r5.f13680n     // Catch:{ all -> 0x0075 }
            com.tapjoy.internal.ey r1 = com.tapjoy.internal.C5050ey.CUSTOM     // Catch:{ all -> 0x0075 }
            if (r5 == r1) goto L_0x005e
            goto L_0x0064
        L_0x005e:
            r5 = 0
            r0.mo31317a(r5)     // Catch:{ all -> 0x0075 }
            monitor-exit(r4)
            return
        L_0x0064:
            r5 = 1
            r0.mo31317a(r5)     // Catch:{ all -> 0x0075 }
            monitor-exit(r4)
            return
        L_0x006a:
            com.tapjoy.internal.hl r5 = r0.f14056a     // Catch:{ all -> 0x0075 }
            r5.flush()     // Catch:{ all -> 0x0075 }
            monitor-exit(r4)
            return
        L_0x0071:
            monitor-exit(r2)     // Catch:{ all -> 0x0044 }
            throw r5     // Catch:{ Exception -> 0x0073 }
        L_0x0073:
            monitor-exit(r4)
            return
        L_0x0075:
            r5 = move-exception
            monitor-exit(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tapjoy.internal.C3144gy.mo18539a(com.tapjoy.internal.ev$a):void");
    }
}
