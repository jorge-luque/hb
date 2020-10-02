package p118io.fabric.sdk.android.services.concurrency;

import java.util.Collection;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import p118io.fabric.sdk.android.services.concurrency.C6161a;

/* renamed from: io.fabric.sdk.android.services.concurrency.f */
/* compiled from: PriorityAsyncTask */
public abstract class C6175f<Params, Progress, Result> extends C6161a<Params, Progress, Result> implements C6172b<C6184l>, C6180i, C6184l {

    /* renamed from: n */
    private final C6181j f16225n = new C6181j();

    /* renamed from: io.fabric.sdk.android.services.concurrency.f$a */
    /* compiled from: PriorityAsyncTask */
    private static class C6176a<Result> implements Executor {

        /* renamed from: a */
        private final Executor f16226a;
        /* access modifiers changed from: private */

        /* renamed from: b */
        public final C6175f f16227b;

        /* renamed from: io.fabric.sdk.android.services.concurrency.f$a$a */
        /* compiled from: PriorityAsyncTask */
        class C6177a extends C6179h<Result> {
            C6177a(Runnable runnable, Object obj) {
                super(runnable, obj);
            }

            /* renamed from: a */
            public <T extends C6172b<C6184l> & C6180i & C6184l> T mo34306a() {
                return C6176a.this.f16227b;
            }
        }

        public C6176a(Executor executor, C6175f fVar) {
            this.f16226a = executor;
            this.f16227b = fVar;
        }

        public void execute(Runnable runnable) {
            this.f16226a.execute(new C6177a(runnable, (Object) null));
        }
    }

    /* renamed from: a */
    public final void mo34299a(ExecutorService executorService, Params... paramsArr) {
        super.mo34265a((Executor) new C6176a(executorService, this), paramsArr);
    }

    public boolean areDependenciesMet() {
        return ((C6172b) ((C6180i) mo34301d())).areDependenciesMet();
    }

    public int compareTo(Object obj) {
        return C6174e.m19938a(this, obj);
    }

    /* renamed from: d */
    public <T extends C6172b<C6184l> & C6180i & C6184l> T mo34301d() {
        return this.f16225n;
    }

    public Collection<C6184l> getDependencies() {
        return ((C6172b) ((C6180i) mo34301d())).getDependencies();
    }

    public boolean isFinished() {
        return ((C6184l) ((C6180i) mo34301d())).isFinished();
    }

    public void setError(Throwable th) {
        ((C6184l) ((C6180i) mo34301d())).setError(th);
    }

    public void setFinished(boolean z) {
        ((C6184l) ((C6180i) mo34301d())).setFinished(z);
    }

    /* renamed from: a */
    public void addDependency(C6184l lVar) {
        if (mo34264a() == C6161a.C6170h.PENDING) {
            ((C6172b) ((C6180i) mo34301d())).addDependency(lVar);
            return;
        }
        throw new IllegalStateException("Must not add Dependency after task is running");
    }
}
