package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.google.android.datatransport.runtime.backends.C2994e;
import com.google.android.datatransport.runtime.backends.C2995f;
import com.google.android.datatransport.runtime.backends.C2997g;
import com.google.android.datatransport.runtime.backends.C3005m;
import com.google.android.datatransport.runtime.synchronization.C3031a;
import java.util.ArrayList;
import java.util.concurrent.Executor;
import p093e.p101c.p102a.p103a.p104i.C3400h;
import p093e.p101c.p102a.p103a.p104i.C3406l;
import p093e.p101c.p102a.p103a.p104i.p105t.C3416a;
import p093e.p101c.p102a.p103a.p104i.p107v.p108j.C3435c;
import p093e.p101c.p102a.p103a.p104i.p107v.p108j.C3446h;
import p093e.p101c.p102a.p103a.p104i.p109w.C3469a;

/* renamed from: com.google.android.datatransport.runtime.scheduling.jobscheduling.m */
/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
public class C3024m {

    /* renamed from: a */
    private final Context f8405a;

    /* renamed from: b */
    private final C2994e f8406b;

    /* renamed from: c */
    private final C3435c f8407c;

    /* renamed from: d */
    private final C3030s f8408d;

    /* renamed from: e */
    private final Executor f8409e;

    /* renamed from: f */
    private final C3031a f8410f;

    /* renamed from: g */
    private final C3469a f8411g;

    public C3024m(Context context, C2994e eVar, C3435c cVar, C3030s sVar, Executor executor, C3031a aVar, C3469a aVar2) {
        this.f8405a = context;
        this.f8406b = eVar;
        this.f8407c = cVar;
        this.f8408d = sVar;
        this.f8409e = executor;
        this.f8410f = aVar;
        this.f8411g = aVar2;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo13003a() {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.f8405a.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    /* renamed from: a */
    public void mo13002a(C3406l lVar, int i, Runnable runnable) {
        this.f8409e.execute(C3019h.m9924a(this, lVar, i, runnable));
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(2:6|7) */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x002f, code lost:
        r5.run();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0032, code lost:
        throw r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0022, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
        r2.f8408d.mo12974a(r3, r4 + 1);
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:6:0x0024 */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ void m9932a(com.google.android.datatransport.runtime.scheduling.jobscheduling.C3024m r2, p093e.p101c.p102a.p103a.p104i.C3406l r3, int r4, java.lang.Runnable r5) {
        /*
            com.google.android.datatransport.runtime.synchronization.a r0 = r2.f8410f     // Catch:{ SynchronizationException -> 0x0024 }
            e.c.a.a.i.v.j.c r1 = r2.f8407c     // Catch:{ SynchronizationException -> 0x0024 }
            r1.getClass()     // Catch:{ SynchronizationException -> 0x0024 }
            com.google.android.datatransport.runtime.synchronization.a$a r1 = com.google.android.datatransport.runtime.scheduling.jobscheduling.C3022k.m9927a(r1)     // Catch:{ SynchronizationException -> 0x0024 }
            r0.mo13006a(r1)     // Catch:{ SynchronizationException -> 0x0024 }
            boolean r0 = r2.mo13003a()     // Catch:{ SynchronizationException -> 0x0024 }
            if (r0 != 0) goto L_0x001e
            com.google.android.datatransport.runtime.synchronization.a r0 = r2.f8410f     // Catch:{ SynchronizationException -> 0x0024 }
            com.google.android.datatransport.runtime.synchronization.a$a r1 = com.google.android.datatransport.runtime.scheduling.jobscheduling.C3023l.m9928a(r2, r3, r4)     // Catch:{ SynchronizationException -> 0x0024 }
            r0.mo13006a(r1)     // Catch:{ SynchronizationException -> 0x0024 }
            goto L_0x002b
        L_0x001e:
            r2.mo13001a((p093e.p101c.p102a.p103a.p104i.C3406l) r3, (int) r4)     // Catch:{ SynchronizationException -> 0x0024 }
            goto L_0x002b
        L_0x0022:
            r2 = move-exception
            goto L_0x002f
        L_0x0024:
            com.google.android.datatransport.runtime.scheduling.jobscheduling.s r2 = r2.f8408d     // Catch:{ all -> 0x0022 }
            int r4 = r4 + 1
            r2.mo12974a(r3, r4)     // Catch:{ all -> 0x0022 }
        L_0x002b:
            r5.run()
            return
        L_0x002f:
            r5.run()
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.datatransport.runtime.scheduling.jobscheduling.C3024m.m9932a(com.google.android.datatransport.runtime.scheduling.jobscheduling.m, e.c.a.a.i.l, int, java.lang.Runnable):void");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo13001a(C3406l lVar, int i) {
        C2997g gVar;
        C3005m mVar = this.f8406b.get(lVar.mo19184a());
        Iterable<C3446h> iterable = (Iterable) this.f8410f.mo13006a(C3020i.m9925a(this, lVar));
        if (iterable.iterator().hasNext()) {
            if (mVar == null) {
                C3416a.m11379a("Uploader", "Unknown backend for %s, deleting event batch for it...", (Object) lVar);
                gVar = C2997g.m9868c();
            } else {
                ArrayList arrayList = new ArrayList();
                for (C3446h a : iterable) {
                    arrayList.add(a.mo19232a());
                }
                C2995f.C2996a c = C2995f.m9861c();
                c.mo12952a((Iterable<C3400h>) arrayList);
                c.mo12953a(lVar.mo19185b());
                gVar = mVar.mo12943a(c.mo12954a());
            }
            this.f8410f.mo13006a(C3021j.m9926a(this, gVar, iterable, lVar, i));
        }
    }

    /* renamed from: a */
    static /* synthetic */ Object m9930a(C3024m mVar, C2997g gVar, Iterable iterable, C3406l lVar, int i) {
        if (gVar.mo12956b() == C2997g.C2998a.TRANSIENT_ERROR) {
            mVar.f8407c.mo19246b((Iterable<C3446h>) iterable);
            mVar.f8408d.mo12974a(lVar, i + 1);
            return null;
        }
        mVar.f8407c.mo19244a((Iterable<C3446h>) iterable);
        if (gVar.mo12956b() == C2997g.C2998a.OK) {
            mVar.f8407c.mo19243a(lVar, mVar.f8411g.mo19256a() + gVar.mo12955a());
        }
        if (!mVar.f8407c.mo19247c(lVar)) {
            return null;
        }
        mVar.f8408d.mo12974a(lVar, 1);
        return null;
    }
}
