package p118io.fabric.sdk.android.services.concurrency;

import java.util.Collection;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/* renamed from: io.fabric.sdk.android.services.concurrency.h */
/* compiled from: PriorityFutureTask */
public class C6179h<V> extends FutureTask<V> implements C6172b<C6184l>, C6180i, C6184l {

    /* renamed from: a */
    final Object f16229a;

    public C6179h(Callable<V> callable) {
        super(callable);
        this.f16229a = mo34307a((Object) callable);
    }

    /* renamed from: a */
    public void addDependency(C6184l lVar) {
        ((C6172b) ((C6180i) mo34306a())).addDependency(lVar);
    }

    public boolean areDependenciesMet() {
        return ((C6172b) ((C6180i) mo34306a())).areDependenciesMet();
    }

    public int compareTo(Object obj) {
        return ((C6180i) mo34306a()).compareTo(obj);
    }

    public Collection<C6184l> getDependencies() {
        return ((C6172b) ((C6180i) mo34306a())).getDependencies();
    }

    public C6174e getPriority() {
        return ((C6180i) mo34306a()).getPriority();
    }

    public boolean isFinished() {
        return ((C6184l) ((C6180i) mo34306a())).isFinished();
    }

    public void setError(Throwable th) {
        ((C6184l) ((C6180i) mo34306a())).setError(th);
    }

    public void setFinished(boolean z) {
        ((C6184l) ((C6180i) mo34306a())).setFinished(z);
    }

    /* renamed from: a */
    public <T extends C6172b<C6184l> & C6180i & C6184l> T mo34306a() {
        return (C6172b) this.f16229a;
    }

    public C6179h(Runnable runnable, V v) {
        super(runnable, v);
        this.f16229a = mo34307a((Object) runnable);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public <T extends C6172b<C6184l> & C6180i & C6184l> T mo34307a(Object obj) {
        if (C6181j.isProperDelegate(obj)) {
            return (C6172b) obj;
        }
        return new C6181j();
    }
}
