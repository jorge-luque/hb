package com.moat.analytics.mobile.ogury;

import android.content.Context;
import android.content.Intent;
import com.moat.analytics.mobile.ogury.C4315e;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import p075d.p090g.p091a.C3218a;

/* renamed from: com.moat.analytics.mobile.ogury.g */
final class C4322g {

    /* renamed from: ˋ */
    private static final C4322g f11554 = new C4322g();

    /* renamed from: ˊ */
    private final ScheduledExecutorService f11555 = Executors.newScheduledThreadPool(1);
    /* access modifiers changed from: private */

    /* renamed from: ˎ */
    public final Map<C4317f, String> f11556 = new WeakHashMap();
    /* access modifiers changed from: private */

    /* renamed from: ˏ */
    public final Map<C4310c, String> f11557 = new WeakHashMap();
    /* access modifiers changed from: private */

    /* renamed from: ॱ */
    public ScheduledFuture<?> f11558;
    /* access modifiers changed from: private */

    /* renamed from: ᐝ */
    public ScheduledFuture<?> f11559;

    private C4322g() {
    }

    /* renamed from: ˋ */
    static C4322g m14476() {
        return f11554;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ˊ */
    public final void mo29150(C4317f fVar) {
        StringBuilder sb = new StringBuilder("removeSetupNeededBridge");
        sb.append(fVar.hashCode());
        C4315e.C43161.m14442(3, "JSUpdateLooper", this, sb.toString());
        this.f11556.remove(fVar);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ˋ */
    public final void mo29152(final Context context, C4317f fVar) {
        this.f11556.put(fVar, "");
        ScheduledFuture<?> scheduledFuture = this.f11559;
        if (scheduledFuture == null || scheduledFuture.isDone()) {
            C4315e.C43161.m14442(3, "JSUpdateLooper", this, "Starting metadata reporting loop");
            this.f11559 = this.f11555.scheduleWithFixedDelay(new Runnable() {
                public final void run() {
                    try {
                        C3218a.m10641a(context.getApplicationContext()).mo18872a(new Intent("UPDATE_METADATA"));
                        if (C4322g.this.f11556.isEmpty()) {
                            C4322g.this.f11559.cancel(true);
                        }
                    } catch (Exception e) {
                        C4332l.m14509(e);
                    }
                }
            }, 0, 50, TimeUnit.MILLISECONDS);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ˎ */
    public final void mo29153(C4310c cVar) {
        if (cVar != null) {
            StringBuilder sb = new StringBuilder("removeActiveTracker");
            sb.append(cVar.hashCode());
            C4315e.C43161.m14442(3, "JSUpdateLooper", this, sb.toString());
            this.f11557.remove(cVar);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ˋ */
    public final void mo29151(final Context context, C4310c cVar) {
        if (cVar != null) {
            StringBuilder sb = new StringBuilder("addActiveTracker");
            sb.append(cVar.hashCode());
            C4315e.C43161.m14442(3, "JSUpdateLooper", this, sb.toString());
            if (!this.f11557.containsKey(cVar)) {
                this.f11557.put(cVar, "");
                ScheduledFuture<?> scheduledFuture = this.f11558;
                if (scheduledFuture == null || scheduledFuture.isDone()) {
                    C4315e.C43161.m14442(3, "JSUpdateLooper", this, "Starting view update loop");
                    this.f11558 = this.f11555.scheduleWithFixedDelay(new Runnable() {
                        public final void run() {
                            try {
                                C3218a.m10641a(context.getApplicationContext()).mo18872a(new Intent("UPDATE_VIEW_INFO"));
                                if (C4322g.this.f11557.isEmpty()) {
                                    C4315e.C43161.m14442(3, "JSUpdateLooper", C4322g.this, "No more active trackers");
                                    C4322g.this.f11558.cancel(true);
                                }
                            } catch (Exception e) {
                                C4332l.m14509(e);
                            }
                        }
                    }, 0, (long) C4346q.m14542().f11635, TimeUnit.MILLISECONDS);
                }
            }
        }
    }
}
