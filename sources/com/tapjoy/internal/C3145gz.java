package com.tapjoy.internal;

import android.content.Context;
import android.content.Intent;
import android.opengl.GLSurfaceView;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Base64;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.tapjoy.TJAdUnitConstants;
import com.tapjoy.TapjoyConstants;
import com.tapjoy.internal.C5041ev;
import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ScheduledFuture;

/* renamed from: com.tapjoy.internal.gz */
public final class C3145gz {

    /* renamed from: q */
    private static final C3145gz f8753q;

    /* renamed from: r */
    private static C3145gz f8754r;

    /* renamed from: w */
    private static Handler f8755w;

    /* renamed from: x */
    private static File f8756x;

    /* renamed from: a */
    public final C5157hh f8757a = new C5157hh(this);

    /* renamed from: b */
    public C5158hi f8758b;

    /* renamed from: c */
    public boolean f8759c = false;

    /* renamed from: d */
    public String f8760d = null;

    /* renamed from: e */
    public Context f8761e;

    /* renamed from: f */
    public C3149hc f8762f;

    /* renamed from: g */
    public C3144gy f8763g;

    /* renamed from: h */
    public C3154hm f8764h;

    /* renamed from: i */
    public C5140gx f8765i;

    /* renamed from: j */
    public String f8766j;

    /* renamed from: k */
    public boolean f8767k;

    /* renamed from: l */
    public String f8768l;

    /* renamed from: m */
    public String f8769m;

    /* renamed from: n */
    public boolean f8770n = false;

    /* renamed from: o */
    public String f8771o;

    /* renamed from: p */
    public C5143ha f8772p = C5143ha.m17337a((C5126go) null);

    /* renamed from: s */
    private boolean f8773s = false;

    /* renamed from: t */
    private boolean f8774t = false;

    /* renamed from: u */
    private String f8775u;

    /* renamed from: v */
    private String f8776v;

    static {
        C3145gz gzVar = new C3145gz();
        f8753q = gzVar;
        f8754r = gzVar;
    }

    private C3145gz() {
    }

    /* renamed from: b */
    public final synchronized void mo18552b(Context context) {
        if (this.f8761e == null) {
            Context applicationContext = context.getApplicationContext();
            this.f8761e = applicationContext;
            C5106ga.m17238a().mo31279a(applicationContext);
            this.f8762f = C3149hc.m10374a(applicationContext);
            File file = new File(m10326c(applicationContext), "events2");
            if (this.f8765i == null) {
                this.f8765i = new C5140gx(file);
            }
            C3144gy gyVar = new C3144gy(this.f8762f, this.f8765i);
            this.f8763g = gyVar;
            this.f8764h = new C3154hm(gyVar);
            this.f8758b = new C5158hi(applicationContext);
            C3137gf.m10281a(new C5120gh(new File(m10326c(applicationContext), "usages"), this.f8763g));
            C5170ht htVar = C5170ht.f14164a;
            htVar.f14165b = applicationContext.getApplicationContext();
            htVar.f14166c = applicationContext.getSharedPreferences("tapjoyCacheDataMMF2E", 0);
            htVar.f14167d = applicationContext.getSharedPreferences("tapjoyCacheDataMMF2U", 0);
            htVar.mo31340a();
        }
    }

    /* renamed from: c */
    public final Set mo18554c() {
        if (!mo18557d("getUserTags")) {
            return new HashSet();
        }
        return this.f8762f.mo18594e();
    }

    /* renamed from: d */
    public final boolean mo18557d(String str) {
        if (this.f8761e != null) {
            return true;
        }
        if (!C5139gw.f14055a) {
            return false;
        }
        C5139gw.m17328b(str + ": Should be called after initializing the SDK");
        return false;
    }

    /* renamed from: e */
    public final boolean mo18558e() {
        boolean z;
        C3154hm hmVar = this.f8764h;
        ScheduledFuture scheduledFuture = hmVar.f8799c;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
            hmVar.f8799c = null;
        }
        if (hmVar.f8798b.compareAndSet(false, true)) {
            C5139gw.m17323a("New session started");
            C3144gy gyVar = hmVar.f8797a;
            C5062fc d = gyVar.f8748a.mo18593d();
            C3149hc hcVar = gyVar.f8748a;
            synchronized (hcVar) {
                int b = hcVar.f8783c.f14120h.mo31466b() + 1;
                hcVar.f8783c.f14120h.mo31464a(b);
                hcVar.f8782b.f13895h = Integer.valueOf(b);
            }
            C5041ev.C5042a a = gyVar.mo18538a(C5050ey.APP, "bootup");
            gyVar.f8750c = SystemClock.elapsedRealtime();
            if (d != null) {
                a.f13710s = d;
            }
            gyVar.mo18539a(a);
            C5096fs.f13950c.notifyObservers();
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            return false;
        }
        C5157hh hhVar = this.f8757a;
        synchronized (hhVar) {
            hhVar.f14103b = null;
        }
        C5170ht.f14164a.mo31340a();
        return true;
    }

    /* renamed from: a */
    public static C3145gz m10321a() {
        return f8754r;
    }

    /* renamed from: a */
    public final C5059fb mo18543a(boolean z) {
        if (z) {
            this.f8762f.mo18582a();
        }
        return this.f8762f.mo18588b();
    }

    /* renamed from: c */
    public final boolean mo18555c(String str) {
        if ((this.f8767k || this.f8766j != null) && this.f8761e != null) {
            return true;
        }
        if (!C5139gw.f14055a) {
            return false;
        }
        C5139gw.m17328b(str + ": Should be called after initializing the SDK");
        return false;
    }

    /* renamed from: d */
    public final boolean mo18556d() {
        C3154hm hmVar = this.f8764h;
        return hmVar != null && hmVar.f8798b.get();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0045, code lost:
        return;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void mo18545a(@javax.annotation.Nullable final java.lang.String r6) {
        /*
            r5 = this;
            monitor-enter(r5)
            boolean r0 = r5.f8767k     // Catch:{ all -> 0x0046 }
            if (r0 == 0) goto L_0x0040
            if (r6 != 0) goto L_0x000d
            java.lang.String r0 = r5.f8771o     // Catch:{ all -> 0x0046 }
            if (r0 == 0) goto L_0x000d
            java.lang.String r6 = r5.f8771o     // Catch:{ all -> 0x0046 }
        L_0x000d:
            r0 = 0
            r5.f8771o = r0     // Catch:{ all -> 0x0046 }
            if (r6 == 0) goto L_0x0044
            com.tapjoy.internal.hc r0 = r5.f8762f     // Catch:{ all -> 0x0046 }
            com.tapjoy.internal.fb r0 = r0.mo18588b()     // Catch:{ all -> 0x0046 }
            java.lang.String r1 = "GCM registration id of device {} updated for sender {}: {}"
            r2 = 3
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch:{ all -> 0x0046 }
            r3 = 0
            com.tapjoy.internal.fa r4 = r0.f13785d     // Catch:{ all -> 0x0046 }
            java.lang.String r4 = r4.f13749h     // Catch:{ all -> 0x0046 }
            r2[r3] = r4     // Catch:{ all -> 0x0046 }
            r3 = 1
            java.lang.String r4 = r5.f8760d     // Catch:{ all -> 0x0046 }
            r2[r3] = r4     // Catch:{ all -> 0x0046 }
            r3 = 2
            r2[r3] = r6     // Catch:{ all -> 0x0046 }
            com.tapjoy.internal.C5139gw.m17325a((java.lang.String) r1, (java.lang.Object[]) r2)     // Catch:{ all -> 0x0046 }
            com.tapjoy.internal.il r1 = new com.tapjoy.internal.il     // Catch:{ all -> 0x0046 }
            r1.<init>(r0, r6)     // Catch:{ all -> 0x0046 }
            com.tapjoy.internal.gz$1 r0 = new com.tapjoy.internal.gz$1     // Catch:{ all -> 0x0046 }
            r0.<init>(r6)     // Catch:{ all -> 0x0046 }
            java.util.concurrent.ExecutorService r6 = com.tapjoy.internal.C3131ca.f8717a     // Catch:{ all -> 0x0046 }
            r1.mo18507a((com.tapjoy.internal.C4935cf) r0, (java.util.concurrent.ExecutorService) r6)     // Catch:{ all -> 0x0046 }
            monitor-exit(r5)
            return
        L_0x0040:
            if (r6 == 0) goto L_0x0044
            r5.f8771o = r6     // Catch:{ all -> 0x0046 }
        L_0x0044:
            monitor-exit(r5)
            return
        L_0x0046:
            r6 = move-exception
            monitor-exit(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tapjoy.internal.C3145gz.mo18545a(java.lang.String):void");
    }

    /* renamed from: d */
    static File m10327d(Context context) {
        return new File(m10326c(context), "install");
    }

    /* renamed from: c */
    public static synchronized File m10326c(Context context) {
        File file;
        synchronized (C3145gz.class) {
            if (f8756x == null) {
                f8756x = context.getDir("fiverocks", 0);
            }
            file = f8756x;
        }
        return file;
    }

    /* renamed from: a */
    public final boolean mo18550a(Context context, String str, boolean z) {
        long currentTimeMillis = System.currentTimeMillis();
        mo18552b(context);
        if (!this.f8762f.mo18586a(str, currentTimeMillis, z)) {
            return false;
        }
        C3144gy gyVar = this.f8763g;
        C5041ev.C5042a a = gyVar.mo18538a(C5050ey.APP, "push_show");
        a.f13710s = new C5062fc((String) null, (String) null, str);
        gyVar.mo18539a(a);
        return true;
    }

    /* renamed from: b */
    public final synchronized void mo18551b() {
        if (this.f8767k) {
            C3147hb.m10351b(this.f8761e).mo18567e(this.f8760d);
            mo18545a((String) null);
        }
    }

    /* renamed from: a */
    public static void m10324a(GLSurfaceView gLSurfaceView) {
        if (C5139gw.m17326a((Object) gLSurfaceView, "setGLSurfaceView: The given GLSurfaceView was null")) {
            C5129gr.m17303a(gLSurfaceView);
        }
    }

    /* renamed from: a */
    public final void mo18549a(Set set) {
        if (mo18557d("setUserTags")) {
            if (set != null && !set.isEmpty()) {
                HashSet hashSet = new HashSet();
                Iterator it = set.iterator();
                while (it.hasNext()) {
                    String str = (String) it.next();
                    if (str != null) {
                        String trim = str.trim();
                        if (!trim.isEmpty() && trim.length() <= 200) {
                            hashSet.add(trim);
                            if (hashSet.size() >= 200) {
                                break;
                            }
                        }
                    }
                }
                set = hashSet;
            }
            C3149hc hcVar = this.f8762f;
            synchronized (hcVar) {
                if (set != null) {
                    if (!set.isEmpty()) {
                        hcVar.f8783c.f14138z.mo31486a(Base64.encodeToString(C5074fg.f13843c.mo31108b(new C5074fg(new ArrayList(set))), 2));
                        hcVar.f8782b.f13888A.clear();
                        hcVar.f8782b.f13888A.addAll(set);
                    }
                }
                hcVar.f8783c.f14138z.mo31483c();
                hcVar.f8782b.f13888A.clear();
            }
        }
    }

    /* renamed from: b */
    public final void mo18553b(String str) {
        C3144gy gyVar = this.f8763g;
        C5041ev.C5042a a = gyVar.mo18538a(C5050ey.APP, "push_ignore");
        a.f13710s = new C5062fc((String) null, (String) null, str);
        gyVar.mo18539a(a);
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x003d A[DONT_GENERATE] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x003f  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x005f A[DONT_GENERATE] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0061 A[SYNTHETIC, Splitter:B:39:0x0061] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void mo18544a(android.content.Context r4, java.lang.String r5, java.lang.String r6, java.lang.String r7, java.lang.String r8, java.lang.String r9) {
        /*
            r3 = this;
            monitor-enter(r3)
            boolean r0 = r3.f8767k     // Catch:{ all -> 0x0115 }
            if (r0 == 0) goto L_0x0007
            monitor-exit(r3)
            return
        L_0x0007:
            r3.mo18552b((android.content.Context) r4)     // Catch:{ all -> 0x0115 }
            android.content.Context r4 = r3.f8761e     // Catch:{ all -> 0x0115 }
            r0 = 1
            r1 = 0
            if (r4 == 0) goto L_0x0012
            r4 = 1
            goto L_0x0013
        L_0x0012:
            r4 = 0
        L_0x0013:
            java.lang.String r2 = "The given context was null"
            boolean r4 = com.tapjoy.internal.C5139gw.m17327a((boolean) r4, (java.lang.String) r2)     // Catch:{ all -> 0x0115 }
            if (r4 != 0) goto L_0x001d
            monitor-exit(r3)
            return
        L_0x001d:
            if (r8 == 0) goto L_0x0031
            int r4 = r8.length()     // Catch:{ all -> 0x0115 }
            r2 = 24
            if (r4 != r2) goto L_0x0031
            java.lang.String r4 = "[0-9a-f]{24}"
            boolean r4 = r8.matches(r4)     // Catch:{ all -> 0x0115 }
            if (r4 == 0) goto L_0x0031
            r4 = 1
            goto L_0x003b
        L_0x0031:
            java.lang.String r4 = "Invalid App ID: {}"
            java.lang.Object[] r2 = new java.lang.Object[r0]     // Catch:{ all -> 0x0115 }
            r2[r1] = r8     // Catch:{ all -> 0x0115 }
            com.tapjoy.internal.C5139gw.m17329b(r4, r2)     // Catch:{ all -> 0x0115 }
            r4 = 0
        L_0x003b:
            if (r4 != 0) goto L_0x003f
            monitor-exit(r3)
            return
        L_0x003f:
            if (r9 == 0) goto L_0x0053
            int r4 = r9.length()     // Catch:{ all -> 0x0115 }
            r2 = 20
            if (r4 != r2) goto L_0x0053
            java.lang.String r4 = "[0-9A-Za-z\\-_]{20}"
            boolean r4 = r9.matches(r4)     // Catch:{ all -> 0x0115 }
            if (r4 == 0) goto L_0x0053
            r4 = 1
            goto L_0x005d
        L_0x0053:
            java.lang.String r4 = "Invalid App Key: {}"
            java.lang.Object[] r2 = new java.lang.Object[r0]     // Catch:{ all -> 0x0115 }
            r2[r1] = r9     // Catch:{ all -> 0x0115 }
            com.tapjoy.internal.C5139gw.m17329b(r4, r2)     // Catch:{ all -> 0x0115 }
            r4 = 0
        L_0x005d:
            if (r4 != 0) goto L_0x0061
            monitor-exit(r3)
            return
        L_0x0061:
            r3.f8768l = r5     // Catch:{ all -> 0x0115 }
            r3.f8769m = r6     // Catch:{ all -> 0x0115 }
            r3.f8775u = r8     // Catch:{ all -> 0x0115 }
            r3.f8776v = r9     // Catch:{ all -> 0x0115 }
            java.net.URL r4 = new java.net.URL     // Catch:{ MalformedURLException -> 0x010e }
            r4.<init>(r7)     // Catch:{ MalformedURLException -> 0x010e }
            java.lang.String r5 = "TapjoySDK"
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x0115 }
            r7.<init>()     // Catch:{ all -> 0x0115 }
            r7.append(r5)     // Catch:{ all -> 0x0115 }
            java.lang.String r5 = " "
            r7.append(r5)     // Catch:{ all -> 0x0115 }
            r7.append(r6)     // Catch:{ all -> 0x0115 }
            java.lang.String r5 = " ("
            r7.append(r5)     // Catch:{ all -> 0x0115 }
            java.lang.String r5 = android.os.Build.MODEL     // Catch:{ all -> 0x0115 }
            r7.append(r5)     // Catch:{ all -> 0x0115 }
            java.lang.String r5 = "; Android "
            r7.append(r5)     // Catch:{ all -> 0x0115 }
            java.lang.String r5 = android.os.Build.VERSION.RELEASE     // Catch:{ all -> 0x0115 }
            r7.append(r5)     // Catch:{ all -> 0x0115 }
            java.lang.String r5 = "; "
            r7.append(r5)     // Catch:{ all -> 0x0115 }
            java.util.Locale r5 = java.util.Locale.getDefault()     // Catch:{ all -> 0x0115 }
            r7.append(r5)     // Catch:{ all -> 0x0115 }
            java.lang.String r5 = ")"
            r7.append(r5)     // Catch:{ all -> 0x0115 }
            java.lang.String r5 = r7.toString()     // Catch:{ all -> 0x0115 }
            com.tapjoy.internal.ce r6 = new com.tapjoy.internal.ce     // Catch:{ all -> 0x0115 }
            r6.<init>(r5, r4)     // Catch:{ all -> 0x0115 }
            com.tapjoy.internal.C3131ca.f8718b = r6     // Catch:{ all -> 0x0115 }
            java.util.concurrent.ExecutorService r4 = java.util.concurrent.Executors.newCachedThreadPool()     // Catch:{ all -> 0x0115 }
            com.tapjoy.internal.C3131ca.f8717a = r4     // Catch:{ all -> 0x0115 }
            com.tapjoy.internal.gx r4 = r3.f8765i     // Catch:{ all -> 0x0115 }
            r4.f14057b = r6     // Catch:{ all -> 0x0115 }
            r4.mo31316a()     // Catch:{ all -> 0x0115 }
            r3.f8767k = r0     // Catch:{ all -> 0x0115 }
            com.tapjoy.internal.hd r4 = new com.tapjoy.internal.hd     // Catch:{ all -> 0x0115 }
            android.content.Context r5 = r3.f8761e     // Catch:{ all -> 0x0115 }
            java.io.File r5 = m10327d((android.content.Context) r5)     // Catch:{ all -> 0x0115 }
            r4.<init>(r5)     // Catch:{ all -> 0x0115 }
            java.lang.String r5 = r4.mo18597b()     // Catch:{ all -> 0x0115 }
            if (r5 == 0) goto L_0x00d1
            goto L_0x00d2
        L_0x00d1:
            r0 = 0
        L_0x00d2:
            if (r0 != 0) goto L_0x00e7
            boolean r4 = r4.mo18596a()     // Catch:{ all -> 0x0115 }
            if (r4 == 0) goto L_0x00e7
            com.tapjoy.internal.gy r4 = r3.f8763g     // Catch:{ all -> 0x0115 }
            com.tapjoy.internal.ey r5 = com.tapjoy.internal.C5050ey.APP     // Catch:{ all -> 0x0115 }
            java.lang.String r6 = "install"
            com.tapjoy.internal.ev$a r5 = r4.mo18538a(r5, r6)     // Catch:{ all -> 0x0115 }
            r4.mo18539a(r5)     // Catch:{ all -> 0x0115 }
        L_0x00e7:
            com.tapjoy.internal.hc r4 = r3.f8762f     // Catch:{ all -> 0x0115 }
            boolean r5 = com.tapjoy.internal.C3166jq.m10436c(r8)     // Catch:{ all -> 0x0115 }
            if (r5 != 0) goto L_0x0109
            com.tapjoy.internal.hj r5 = r4.f8783c     // Catch:{ all -> 0x0115 }
            com.tapjoy.internal.o r5 = r5.f14112D     // Catch:{ all -> 0x0115 }
            java.lang.String r5 = r5.mo31485a()     // Catch:{ all -> 0x0115 }
            boolean r5 = r8.equals(r5)     // Catch:{ all -> 0x0115 }
            if (r5 != 0) goto L_0x0109
            com.tapjoy.internal.hj r5 = r4.f8783c     // Catch:{ all -> 0x0115 }
            com.tapjoy.internal.o r5 = r5.f14112D     // Catch:{ all -> 0x0115 }
            r5.mo31486a(r8)     // Catch:{ all -> 0x0115 }
            com.tapjoy.internal.hj r4 = r4.f8783c     // Catch:{ all -> 0x0115 }
            r4.mo31335a((boolean) r1)     // Catch:{ all -> 0x0115 }
        L_0x0109:
            r3.mo18551b()     // Catch:{ all -> 0x0115 }
            monitor-exit(r3)
            return
        L_0x010e:
            r4 = move-exception
            java.lang.IllegalArgumentException r5 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x0115 }
            r5.<init>(r4)     // Catch:{ all -> 0x0115 }
            throw r5     // Catch:{ all -> 0x0115 }
        L_0x0115:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tapjoy.internal.C3145gz.mo18544a(android.content.Context, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String):void");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo18546a(Map map) {
        C3144gy gyVar = this.f8763g;
        C5041ev.C5042a a = gyVar.mo18538a(C5050ey.CAMPAIGN, "impression");
        if (map != null) {
            a.f13709r = C4910bh.m16696a((Object) map);
        }
        gyVar.mo18539a(a);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo18547a(Map map, long j) {
        C3144gy gyVar = this.f8763g;
        C5041ev.C5042a a = gyVar.mo18538a(C5050ey.CAMPAIGN, ViewHierarchyConstants.VIEW_KEY);
        a.f13700i = Long.valueOf(j);
        if (map != null) {
            a.f13709r = C4910bh.m16696a((Object) map);
        }
        gyVar.mo18539a(a);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo18548a(Map map, String str) {
        C3144gy gyVar = this.f8763g;
        C5041ev.C5042a a = gyVar.mo18538a(C5050ey.CAMPAIGN, TJAdUnitConstants.String.CLICK);
        LinkedHashMap linkedHashMap = new LinkedHashMap(map);
        linkedHashMap.put("region", str);
        a.f13709r = C4910bh.m16696a((Object) linkedHashMap);
        gyVar.mo18539a(a);
    }

    /* renamed from: a */
    public static synchronized void m10325a(Runnable runnable) {
        synchronized (C3145gz.class) {
            if (f8755w == null) {
                f8755w = new Handler(Looper.getMainLooper());
            }
            f8755w.post(runnable);
        }
    }

    /* renamed from: a */
    public static String m10323a(Context context, Intent intent) {
        String a = C3133d.m10275a(intent);
        if (a != null) {
            C3145gz gzVar = f8754r;
            gzVar.mo18552b(context);
            if (C3166jq.m10436c(gzVar.f8762f.mo18591c()) || intent.getBooleanExtra("fiverocks:force", false)) {
                C3149hc hcVar = gzVar.f8762f;
                synchronized (hcVar) {
                    hcVar.f8783c.f14116d.mo31486a(a);
                    hcVar.f8782b.f13891d = a;
                }
                if (a.length() > 0) {
                    C3144gy gyVar = gzVar.f8763g;
                    gyVar.mo18539a(gyVar.mo18538a(C5050ey.APP, TapjoyConstants.TJC_REFERRER));
                }
            }
        }
        return a;
    }

    /* renamed from: a */
    public static C3145gz m10322a(Context context) {
        C3145gz gzVar = f8754r;
        gzVar.mo18552b(context);
        return gzVar;
    }
}
