package com.adcolony.sdk;

import android.util.Log;
import com.adcolony.sdk.C1441v;
import com.applovin.sdk.AppLovinEventTypes;
import com.tapjoy.TapjoyConstants;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.adcolony.sdk.e0 */
class C1282e0 {

    /* renamed from: h */
    static final String f4042h = "adcolony_android";

    /* renamed from: i */
    static final String f4043i = "adcolony_fatal_reports";

    /* renamed from: a */
    C1438t f4044a;

    /* renamed from: b */
    ScheduledExecutorService f4045b;

    /* renamed from: c */
    List<C1441v> f4046c = new ArrayList();

    /* renamed from: d */
    List<C1441v> f4047d = new ArrayList();

    /* renamed from: e */
    HashMap<String, Object> f4048e;

    /* renamed from: f */
    private C1436r f4049f = new C1436r(f4042h, "4.2.0", "Production");

    /* renamed from: g */
    private C1436r f4050g = new C1436r(f4043i, "4.2.0", "Production");

    /* renamed from: com.adcolony.sdk.e0$a */
    class C1283a implements Runnable {
        C1283a() {
        }

        public void run() {
            C1282e0.this.mo6477a();
        }
    }

    /* renamed from: com.adcolony.sdk.e0$b */
    class C1284b implements Runnable {

        /* renamed from: a */
        final /* synthetic */ C1441v f4052a;

        C1284b(C1441v vVar) {
            this.f4052a = vVar;
        }

        public void run() {
            C1282e0.this.f4046c.add(this.f4052a);
        }
    }

    C1282e0(C1438t tVar, ScheduledExecutorService scheduledExecutorService, HashMap<String, Object> hashMap) {
        this.f4044a = tVar;
        this.f4045b = scheduledExecutorService;
        this.f4048e = hashMap;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public synchronized void mo6478a(long j, TimeUnit timeUnit) {
        try {
            if (!this.f4045b.isShutdown() && !this.f4045b.isTerminated()) {
                this.f4045b.scheduleAtFixedRate(new C1283a(), j, j, timeUnit);
            }
        } catch (RuntimeException unused) {
            Log.e("ADCLogError", "Internal error when submitting remote log to executor service");
        }
        return;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Can't wrap try/catch for region: R(2:9|10) */
    /* JADX WARNING: Code restructure failed: missing block: B:10:?, code lost:
        r4.f4045b.shutdownNow();
        java.lang.Thread.currentThread().interrupt();
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0045 */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void mo6482b() {
        /*
            r4 = this;
            monitor-enter(r4)
            java.util.concurrent.ScheduledExecutorService r0 = r4.f4045b     // Catch:{ all -> 0x0053 }
            r0.shutdown()     // Catch:{ all -> 0x0053 }
            java.util.concurrent.ScheduledExecutorService r0 = r4.f4045b     // Catch:{ InterruptedException -> 0x0045 }
            java.util.concurrent.TimeUnit r1 = java.util.concurrent.TimeUnit.SECONDS     // Catch:{ InterruptedException -> 0x0045 }
            r2 = 1
            boolean r0 = r0.awaitTermination(r2, r1)     // Catch:{ InterruptedException -> 0x0045 }
            if (r0 != 0) goto L_0x0051
            java.util.concurrent.ScheduledExecutorService r0 = r4.f4045b     // Catch:{ InterruptedException -> 0x0045 }
            r0.shutdownNow()     // Catch:{ InterruptedException -> 0x0045 }
            java.util.concurrent.ScheduledExecutorService r0 = r4.f4045b     // Catch:{ InterruptedException -> 0x0045 }
            java.util.concurrent.TimeUnit r1 = java.util.concurrent.TimeUnit.SECONDS     // Catch:{ InterruptedException -> 0x0045 }
            boolean r0 = r0.awaitTermination(r2, r1)     // Catch:{ InterruptedException -> 0x0045 }
            if (r0 != 0) goto L_0x0051
            java.io.PrintStream r0 = java.lang.System.err     // Catch:{ InterruptedException -> 0x0045 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ InterruptedException -> 0x0045 }
            r1.<init>()     // Catch:{ InterruptedException -> 0x0045 }
            java.lang.Class r2 = r4.getClass()     // Catch:{ InterruptedException -> 0x0045 }
            java.lang.String r2 = r2.getSimpleName()     // Catch:{ InterruptedException -> 0x0045 }
            r1.append(r2)     // Catch:{ InterruptedException -> 0x0045 }
            java.lang.String r2 = ": ScheduledExecutorService "
            r1.append(r2)     // Catch:{ InterruptedException -> 0x0045 }
            java.lang.String r2 = "did not terminate"
            r1.append(r2)     // Catch:{ InterruptedException -> 0x0045 }
            java.lang.String r1 = r1.toString()     // Catch:{ InterruptedException -> 0x0045 }
            r0.println(r1)     // Catch:{ InterruptedException -> 0x0045 }
            goto L_0x0051
        L_0x0045:
            java.util.concurrent.ScheduledExecutorService r0 = r4.f4045b     // Catch:{ all -> 0x0053 }
            r0.shutdownNow()     // Catch:{ all -> 0x0053 }
            java.lang.Thread r0 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x0053 }
            r0.interrupt()     // Catch:{ all -> 0x0053 }
        L_0x0051:
            monitor-exit(r4)
            return
        L_0x0053:
            r0 = move-exception
            monitor-exit(r4)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adcolony.sdk.C1282e0.mo6482b():void");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public synchronized void mo6485c(String str) {
        mo6483b(new C1441v.C1442a().mo6812a(2).mo6813a(this.f4049f).mo6814a(str).mo6815a());
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public synchronized void mo6486d(String str) {
        mo6483b(new C1441v.C1442a().mo6812a(1).mo6813a(this.f4049f).mo6814a(str).mo6815a());
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public synchronized void mo6487e(String str) {
        this.f4048e.put("controllerVersion", str);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public synchronized void mo6488f(String str) {
        this.f4048e.put("sessionId", str);
    }

    /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
        java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
        	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
        	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
        	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:248)
        	at java.base/java.util.Objects.checkIndex(Objects.java:372)
        	at java.base/java.util.ArrayList.get(ArrayList.java:458)
        	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:598)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
        */
    /* renamed from: a */
    synchronized void mo6477a() {
        /*
            r2 = this;
            monitor-enter(r2)
            monitor-enter(r2)     // Catch:{ all -> 0x0049 }
            java.util.List<com.adcolony.sdk.v> r0 = r2.f4046c     // Catch:{ IOException -> 0x003f, JSONException -> 0x0039 }
            int r0 = r0.size()     // Catch:{ IOException -> 0x003f, JSONException -> 0x0039 }
            if (r0 <= 0) goto L_0x001c
            com.adcolony.sdk.r r0 = r2.f4049f     // Catch:{ IOException -> 0x003f, JSONException -> 0x0039 }
            java.util.List<com.adcolony.sdk.v> r1 = r2.f4046c     // Catch:{ IOException -> 0x003f, JSONException -> 0x0039 }
            java.lang.String r0 = r2.mo6476a((com.adcolony.sdk.C1436r) r0, (java.util.List<com.adcolony.sdk.C1441v>) r1)     // Catch:{ IOException -> 0x003f, JSONException -> 0x0039 }
            com.adcolony.sdk.t r1 = r2.f4044a     // Catch:{ IOException -> 0x003f, JSONException -> 0x0039 }
            r1.mo6796a(r0)     // Catch:{ IOException -> 0x003f, JSONException -> 0x0039 }
            java.util.List<com.adcolony.sdk.v> r0 = r2.f4046c     // Catch:{ IOException -> 0x003f, JSONException -> 0x0039 }
            r0.clear()     // Catch:{ IOException -> 0x003f, JSONException -> 0x0039 }
        L_0x001c:
            java.util.List<com.adcolony.sdk.v> r0 = r2.f4047d     // Catch:{ IOException -> 0x003f, JSONException -> 0x0039 }
            int r0 = r0.size()     // Catch:{ IOException -> 0x003f, JSONException -> 0x0039 }
            if (r0 <= 0) goto L_0x0044
            com.adcolony.sdk.r r0 = r2.f4050g     // Catch:{ IOException -> 0x003f, JSONException -> 0x0039 }
            java.util.List<com.adcolony.sdk.v> r1 = r2.f4047d     // Catch:{ IOException -> 0x003f, JSONException -> 0x0039 }
            java.lang.String r0 = r2.mo6476a((com.adcolony.sdk.C1436r) r0, (java.util.List<com.adcolony.sdk.C1441v>) r1)     // Catch:{ IOException -> 0x003f, JSONException -> 0x0039 }
            com.adcolony.sdk.t r1 = r2.f4044a     // Catch:{ IOException -> 0x003f, JSONException -> 0x0039 }
            r1.mo6796a(r0)     // Catch:{ IOException -> 0x003f, JSONException -> 0x0039 }
            java.util.List<com.adcolony.sdk.v> r0 = r2.f4047d     // Catch:{ IOException -> 0x003f, JSONException -> 0x0039 }
            r0.clear()     // Catch:{ IOException -> 0x003f, JSONException -> 0x0039 }
            goto L_0x0044
        L_0x0037:
            r0 = move-exception
            goto L_0x0047
        L_0x0039:
            java.util.List<com.adcolony.sdk.v> r0 = r2.f4046c     // Catch:{ all -> 0x0037 }
            r0.clear()     // Catch:{ all -> 0x0037 }
            goto L_0x0044
        L_0x003f:
            java.util.List<com.adcolony.sdk.v> r0 = r2.f4046c     // Catch:{ all -> 0x0037 }
            r0.clear()     // Catch:{ all -> 0x0037 }
        L_0x0044:
            monitor-exit(r2)     // Catch:{ all -> 0x0037 }
            monitor-exit(r2)
            return
        L_0x0047:
            monitor-exit(r2)     // Catch:{ all -> 0x0037 }
            throw r0     // Catch:{ all -> 0x0049 }
        L_0x0049:
            r0 = move-exception
            monitor-exit(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adcolony.sdk.C1282e0.mo6477a():void");
    }

    /* renamed from: c */
    private synchronized JSONObject m5027c(C1441v vVar) throws JSONException {
        JSONObject jSONObject;
        jSONObject = new JSONObject(this.f4048e);
        jSONObject.put("environment", vVar.mo6804a().mo6792a());
        jSONObject.put(AppLovinEventTypes.USER_COMPLETED_LEVEL, vVar.mo6808c());
        jSONObject.put("message", vVar.mo6809d());
        jSONObject.put("clientTimestamp", vVar.mo6810e());
        JSONObject mediationInfo = C1199a.m4880c().mo6552r().getMediationInfo();
        JSONObject pluginInfo = C1199a.m4880c().mo6552r().getPluginInfo();
        double g = C1199a.m4880c().mo6542h().mo6623g();
        jSONObject.put("mediation_network", C1437s.m5613h(mediationInfo, "name"));
        jSONObject.put("mediation_network_version", C1437s.m5613h(mediationInfo, "version"));
        jSONObject.put(TapjoyConstants.TJC_PLUGIN, C1437s.m5613h(pluginInfo, "name"));
        jSONObject.put("plugin_version", C1437s.m5613h(pluginInfo, "version"));
        jSONObject.put("batteryInfo", g);
        if (vVar instanceof C1408o) {
            jSONObject = C1437s.m5585a(jSONObject, ((C1408o) vVar).mo6774f());
            jSONObject.put(TapjoyConstants.TJC_PLATFORM, "android");
        }
        return jSONObject;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public synchronized void mo6484b(String str) {
        mo6483b(new C1441v.C1442a().mo6812a(0).mo6813a(this.f4049f).mo6814a(str).mo6815a());
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public synchronized void mo6483b(C1441v vVar) {
        try {
            if (!this.f4045b.isShutdown() && !this.f4045b.isTerminated()) {
                this.f4045b.submit(new C1284b(vVar));
            }
        } catch (RejectedExecutionException unused) {
            Log.e("ADCLogError", "Internal error when submitting remote log to executor service");
        }
        return;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public synchronized void mo6481a(String str) {
        mo6483b(new C1441v.C1442a().mo6812a(3).mo6813a(this.f4049f).mo6814a(str).mo6815a());
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo6479a(C1408o oVar) {
        oVar.mo6806a(this.f4050g);
        oVar.mo6805a(-1);
        mo6480a((C1441v) oVar);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public synchronized void mo6480a(C1441v vVar) {
        this.f4047d.add(vVar);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public String mo6476a(C1436r rVar, List<C1441v> list) throws IOException, JSONException {
        String b = C1199a.m4880c().mo6542h().mo6615b();
        String str = this.f4048e.get("advertiserId") != null ? (String) this.f4048e.get("advertiserId") : "unknown";
        if (b != null && b.length() > 0 && !b.equals(str)) {
            this.f4048e.put("advertiserId", b);
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("index", rVar.mo6794c());
        jSONObject.put("environment", rVar.mo6792a());
        jSONObject.put("version", rVar.mo6795d());
        JSONArray jSONArray = new JSONArray();
        for (C1441v c : list) {
            jSONArray.put(m5027c(c));
        }
        jSONObject.put("logs", jSONArray);
        return jSONObject.toString();
    }
}
