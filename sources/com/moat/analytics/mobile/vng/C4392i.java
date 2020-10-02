package com.moat.analytics.mobile.vng;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* renamed from: com.moat.analytics.mobile.vng.i */
class C4392i {

    /* renamed from: a */
    private static final C4392i f11772a = new C4392i();

    /* renamed from: b */
    private Class<?> f11773b = null;

    /* renamed from: c */
    private Object f11774c = null;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final Map<C4395j, String> f11775d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public final Map<C4377b, String> f11776e;

    /* renamed from: f */
    private final ScheduledExecutorService f11777f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public ScheduledFuture<?> f11778g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public ScheduledFuture<?> f11779h;

    private C4392i() {
        m14694c();
        this.f11777f = Executors.newScheduledThreadPool(1);
        this.f11775d = new WeakHashMap();
        this.f11776e = new WeakHashMap();
    }

    /* renamed from: a */
    static C4392i m14686a() {
        return f11772a;
    }

    /* renamed from: a */
    private void m14688a(Context context) {
        try {
            if (this.f11774c != null) {
                return;
            }
            if (this.f11773b != null) {
                this.f11774c = this.f11773b.getMethod("getInstance", new Class[]{Context.class}).invoke((Object) null, new Object[]{context});
            }
        } catch (NoSuchMethodException e) {
            C4409p.m14774a("JSUpdateLooper", (Object) C4412s.class, "NoSuchMethodException while getting LocalBroadcastManager instance", (Throwable) e);
        } catch (Exception e2) {
            C4403n.m14758a(e2);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m14689a(Context context, Intent intent) {
        try {
            m14688a(context);
            if (this.f11773b == null) {
                return;
            }
            if (this.f11774c != null) {
                this.f11773b.getMethod("sendBroadcast", new Class[]{Intent.class}).invoke(this.f11774c, new Object[]{intent});
            }
        } catch (NoSuchMethodException e) {
            C4409p.m14774a("JSUpdateLooper", (Object) C4412s.class, "NoSuchMethodException calling LocalBroadcastManager sendBroadcast", (Throwable) e);
        } catch (Exception e2) {
            C4403n.m14758a(e2);
        }
    }

    /* renamed from: b */
    private void m14692b(final Context context) {
        ScheduledFuture<?> scheduledFuture = this.f11779h;
        if (scheduledFuture == null || scheduledFuture.isDone()) {
            C4409p.m14772a(3, "JSUpdateLooper", (Object) this, "Starting metadata reporting loop");
            this.f11779h = this.f11777f.scheduleWithFixedDelay(new Runnable() {
                public void run() {
                    try {
                        C4392i.this.m14689a(context.getApplicationContext(), new Intent("UPDATE_METADATA"));
                        if (C4392i.this.f11775d.isEmpty()) {
                            C4392i.this.f11779h.cancel(true);
                        }
                    } catch (Exception e) {
                        C4403n.m14758a(e);
                    }
                }
            }, 0, 50, TimeUnit.MILLISECONDS);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0020, code lost:
        com.moat.analytics.mobile.vng.C4409p.m14774a("JSUpdateLooper", (java.lang.Object) r4, "ClassNotFoundException while retrieving LocalBroadcastManager androidx class", (java.lang.Throwable) r0);
        com.moat.analytics.mobile.vng.C4409p.m14774a("JSUpdateLooper", (java.lang.Object) r4, "No LocalBroadcastManager class was found.", (java.lang.Throwable) r1);
        com.moat.analytics.mobile.vng.C4409p.m14775a("[ERROR] ", "No LocalBroadcastManager class was found.");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0009, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001f, code lost:
        r0 = e;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:3:0x0009 A[ExcHandler: Exception (e java.lang.Exception), Splitter:B:1:0x0002] */
    /* renamed from: c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m14694c() {
        /*
            r4 = this;
            java.lang.String r0 = "d.g.a.a"
            java.lang.Class r1 = java.lang.Class.forName(r0)     // Catch:{ ClassNotFoundException -> 0x000b, Exception -> 0x0009 }
            r4.f11773b = r1     // Catch:{ ClassNotFoundException -> 0x000b, Exception -> 0x0009 }
            goto L_0x0030
        L_0x0009:
            r0 = move-exception
            goto L_0x000d
        L_0x000b:
            r1 = move-exception
            goto L_0x0011
        L_0x000d:
            com.moat.analytics.mobile.vng.C4403n.m14758a(r0)
            goto L_0x0030
        L_0x0011:
            java.lang.String r2 = "JSUpdateLooper"
            java.lang.String r3 = "ClassNotFoundException while retrieving LocalBroadcastManager support class"
            com.moat.analytics.mobile.vng.C4409p.m14774a((java.lang.String) r2, (java.lang.Object) r4, (java.lang.String) r3, (java.lang.Throwable) r1)
            java.lang.Class r0 = java.lang.Class.forName(r0)     // Catch:{ ClassNotFoundException -> 0x001f, Exception -> 0x0009 }
            r4.f11773b = r0     // Catch:{ ClassNotFoundException -> 0x001f, Exception -> 0x0009 }
            goto L_0x0030
        L_0x001f:
            r0 = move-exception
            java.lang.String r3 = "ClassNotFoundException while retrieving LocalBroadcastManager androidx class"
            com.moat.analytics.mobile.vng.C4409p.m14774a((java.lang.String) r2, (java.lang.Object) r4, (java.lang.String) r3, (java.lang.Throwable) r0)
            java.lang.String r3 = "No LocalBroadcastManager class was found."
            com.moat.analytics.mobile.vng.C4409p.m14774a((java.lang.String) r2, (java.lang.Object) r4, (java.lang.String) r3, (java.lang.Throwable) r1)
            java.lang.String r1 = "[ERROR] "
            com.moat.analytics.mobile.vng.C4409p.m14775a(r1, r3)
            goto L_0x000d
        L_0x0030:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.moat.analytics.mobile.vng.C4392i.m14694c():void");
    }

    /* renamed from: c */
    private void m14695c(final Context context) {
        ScheduledFuture<?> scheduledFuture = this.f11778g;
        if (scheduledFuture == null || scheduledFuture.isDone()) {
            C4409p.m14772a(3, "JSUpdateLooper", (Object) this, "Starting view update loop");
            this.f11778g = this.f11777f.scheduleWithFixedDelay(new Runnable() {
                public void run() {
                    try {
                        C4392i.this.m14689a(context.getApplicationContext(), new Intent("UPDATE_VIEW_INFO"));
                        if (C4392i.this.f11776e.isEmpty()) {
                            C4409p.m14772a(3, "JSUpdateLooper", (Object) C4392i.this, "No more active trackers");
                            C4392i.this.f11778g.cancel(true);
                        }
                    } catch (Exception e) {
                        C4403n.m14758a(e);
                    }
                }
            }, 0, (long) C4424w.m14808a().f11859d, TimeUnit.MILLISECONDS);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo29303a(Context context, BroadcastReceiver broadcastReceiver) {
        try {
            m14688a(context);
            if (this.f11773b == null) {
                return;
            }
            if (this.f11774c != null) {
                this.f11773b.getMethod("unregisterReceiver", new Class[]{BroadcastReceiver.class}).invoke(this.f11774c, new Object[]{broadcastReceiver});
            }
        } catch (NoSuchMethodException e) {
            C4409p.m14774a("JSUpdateLooper", (Object) C4412s.class, "NoSuchMethodException while calling LocalBroadcastManager unregisterReceiver", (Throwable) e);
        } catch (Exception e2) {
            C4403n.m14758a(e2);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo29304a(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        try {
            m14688a(context);
            if (this.f11773b == null) {
                return;
            }
            if (this.f11774c != null) {
                this.f11773b.getMethod("registerReceiver", new Class[]{BroadcastReceiver.class, IntentFilter.class}).invoke(this.f11774c, new Object[]{broadcastReceiver, intentFilter});
            }
        } catch (NoSuchMethodException e) {
            C4409p.m14774a("JSUpdateLooper", (Object) C4412s.class, "NoSuchMethodException while calling LocalBroadcastManager registerReceiver", (Throwable) e);
        } catch (Exception e2) {
            C4403n.m14758a(e2);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo29305a(Context context, C4377b bVar) {
        if (bVar != null) {
            C4409p.m14772a(3, "JSUpdateLooper", (Object) this, "addActiveTracker" + bVar.hashCode());
            Map<C4377b, String> map = this.f11776e;
            if (map != null && !map.containsKey(bVar)) {
                this.f11776e.put(bVar, "");
                m14695c(context);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo29306a(Context context, C4395j jVar) {
        Map<C4395j, String> map = this.f11775d;
        if (map != null && jVar != null) {
            map.put(jVar, "");
            m14692b(context);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo29307a(C4377b bVar) {
        if (bVar != null) {
            C4409p.m14772a(3, "JSUpdateLooper", (Object) this, "removeActiveTracker" + bVar.hashCode());
            Map<C4377b, String> map = this.f11776e;
            if (map != null) {
                map.remove(bVar);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo29308a(C4395j jVar) {
        if (jVar != null) {
            C4409p.m14772a(3, "JSUpdateLooper", (Object) this, "removeSetupNeededBridge" + jVar.hashCode());
            Map<C4395j, String> map = this.f11775d;
            if (map != null) {
                map.remove(jVar);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public boolean mo29309b() {
        return this.f11773b != null;
    }
}
