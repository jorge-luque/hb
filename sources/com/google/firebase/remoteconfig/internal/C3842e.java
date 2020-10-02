package com.google.firebase.remoteconfig.internal;

import com.google.android.gms.tasks.OnCanceledListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* renamed from: com.google.firebase.remoteconfig.internal.e */
/* compiled from: com.google.firebase:firebase-config@@19.1.4 */
public class C3842e {

    /* renamed from: d */
    private static final Map<String, C3842e> f10613d = new HashMap();

    /* renamed from: e */
    private static final Executor f10614e = C3841d.m12988a();

    /* renamed from: a */
    private final ExecutorService f10615a;

    /* renamed from: b */
    private final C3101n f10616b;

    /* renamed from: c */
    private Task<C3845f> f10617c = null;

    /* renamed from: com.google.firebase.remoteconfig.internal.e$b */
    /* compiled from: com.google.firebase:firebase-config@@19.1.4 */
    private static class C3844b<TResult> implements OnSuccessListener<TResult>, OnFailureListener, OnCanceledListener {

        /* renamed from: a */
        private final CountDownLatch f10618a;

        private C3844b() {
            this.f10618a = new CountDownLatch(1);
        }

        /* renamed from: a */
        public boolean mo27567a(long j, TimeUnit timeUnit) throws InterruptedException {
            return this.f10618a.await(j, timeUnit);
        }

        public void onCanceled() {
            this.f10618a.countDown();
        }

        public void onFailure(Exception exc) {
            this.f10618a.countDown();
        }

        public void onSuccess(TResult tresult) {
            this.f10618a.countDown();
        }
    }

    private C3842e(ExecutorService executorService, C3101n nVar) {
        this.f10615a = executorService;
        this.f10616b = nVar;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0024, code lost:
        return (com.google.firebase.remoteconfig.internal.C3845f) m12991a(mo27565b(), r3, java.util.concurrent.TimeUnit.SECONDS);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0025, code lost:
        return null;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.google.firebase.remoteconfig.internal.C3845f mo27563a(long r3) {
        /*
            r2 = this;
            monitor-enter(r2)
            com.google.android.gms.tasks.Task<com.google.firebase.remoteconfig.internal.f> r0 = r2.f10617c     // Catch:{ all -> 0x0027 }
            if (r0 == 0) goto L_0x0017
            com.google.android.gms.tasks.Task<com.google.firebase.remoteconfig.internal.f> r0 = r2.f10617c     // Catch:{ all -> 0x0027 }
            boolean r0 = r0.isSuccessful()     // Catch:{ all -> 0x0027 }
            if (r0 == 0) goto L_0x0017
            com.google.android.gms.tasks.Task<com.google.firebase.remoteconfig.internal.f> r3 = r2.f10617c     // Catch:{ all -> 0x0027 }
            java.lang.Object r3 = r3.getResult()     // Catch:{ all -> 0x0027 }
            com.google.firebase.remoteconfig.internal.f r3 = (com.google.firebase.remoteconfig.internal.C3845f) r3     // Catch:{ all -> 0x0027 }
            monitor-exit(r2)     // Catch:{ all -> 0x0027 }
            return r3
        L_0x0017:
            monitor-exit(r2)     // Catch:{ all -> 0x0027 }
            com.google.android.gms.tasks.Task r0 = r2.mo27565b()     // Catch:{ InterruptedException | ExecutionException | TimeoutException -> 0x0025 }
            java.util.concurrent.TimeUnit r1 = java.util.concurrent.TimeUnit.SECONDS     // Catch:{ InterruptedException | ExecutionException | TimeoutException -> 0x0025 }
            java.lang.Object r3 = m12991a(r0, r3, r1)     // Catch:{ InterruptedException | ExecutionException | TimeoutException -> 0x0025 }
            com.google.firebase.remoteconfig.internal.f r3 = (com.google.firebase.remoteconfig.internal.C3845f) r3     // Catch:{ InterruptedException | ExecutionException | TimeoutException -> 0x0025 }
            return r3
        L_0x0025:
            r3 = 0
            return r3
        L_0x0027:
            r3 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x0027 }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.remoteconfig.internal.C3842e.mo27563a(long):com.google.firebase.remoteconfig.internal.f");
    }

    /* renamed from: b */
    public synchronized Task<C3845f> mo27565b() {
        if (this.f10617c == null || (this.f10617c.isComplete() && !this.f10617c.isSuccessful())) {
            ExecutorService executorService = this.f10615a;
            C3101n nVar = this.f10616b;
            nVar.getClass();
            this.f10617c = Tasks.call(executorService, C3840c.m12987a(nVar));
        }
        return this.f10617c;
    }

    /* renamed from: c */
    public C3845f mo27566c() {
        return mo27563a(5);
    }

    /* renamed from: b */
    private synchronized void m12993b(C3845f fVar) {
        this.f10617c = Tasks.forResult(fVar);
    }

    /* renamed from: a */
    public Task<C3845f> mo27561a(C3845f fVar) {
        return mo27562a(fVar, true);
    }

    /* renamed from: a */
    public Task<C3845f> mo27562a(C3845f fVar, boolean z) {
        return Tasks.call(this.f10615a, C3838a.m12985a(this, fVar)).onSuccessTask(this.f10615a, C3839b.m12986a(this, z, fVar));
    }

    /* renamed from: a */
    static /* synthetic */ Task m12989a(C3842e eVar, boolean z, C3845f fVar, Void voidR) throws Exception {
        if (z) {
            eVar.m12993b(fVar);
        }
        return Tasks.forResult(fVar);
    }

    /* renamed from: a */
    public void mo27564a() {
        synchronized (this) {
            this.f10617c = Tasks.forResult(null);
        }
        this.f10616b.mo18335a();
    }

    /* renamed from: a */
    public static synchronized C3842e m12990a(ExecutorService executorService, C3101n nVar) {
        C3842e eVar;
        synchronized (C3842e.class) {
            String b = nVar.mo18337b();
            if (!f10613d.containsKey(b)) {
                f10613d.put(b, new C3842e(executorService, nVar));
            }
            eVar = f10613d.get(b);
        }
        return eVar;
    }

    /* renamed from: a */
    private static <TResult> TResult m12991a(Task<TResult> task, long j, TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
        C3844b bVar = new C3844b();
        task.addOnSuccessListener(f10614e, (OnSuccessListener<? super TResult>) bVar);
        task.addOnFailureListener(f10614e, (OnFailureListener) bVar);
        task.addOnCanceledListener(f10614e, (OnCanceledListener) bVar);
        if (!bVar.mo27567a(j, timeUnit)) {
            throw new TimeoutException("Task await timed out.");
        } else if (task.isSuccessful()) {
            return task.getResult();
        } else {
            throw new ExecutionException(task.getException());
        }
    }
}
