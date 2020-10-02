package p118io.fabric.sdk.android.services.concurrency;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: io.fabric.sdk.android.services.concurrency.j */
/* compiled from: PriorityTask */
public class C6181j implements C6172b<C6184l>, C6180i, C6184l {
    private final List<C6184l> dependencies = new ArrayList();
    private final AtomicBoolean hasRun = new AtomicBoolean(false);
    private final AtomicReference<Throwable> throwable = new AtomicReference<>((Object) null);

    public static boolean isProperDelegate(Object obj) {
        try {
            C6172b bVar = (C6172b) obj;
            C6184l lVar = (C6184l) obj;
            C6180i iVar = (C6180i) obj;
            if (bVar == null || lVar == null || iVar == null) {
                return false;
            }
            return true;
        } catch (ClassCastException unused) {
            return false;
        }
    }

    public boolean areDependenciesMet() {
        for (C6184l isFinished : getDependencies()) {
            if (!isFinished.isFinished()) {
                return false;
            }
        }
        return true;
    }

    public int compareTo(Object obj) {
        return C6174e.m19938a(this, obj);
    }

    public synchronized Collection<C6184l> getDependencies() {
        return Collections.unmodifiableCollection(this.dependencies);
    }

    public Throwable getError() {
        return this.throwable.get();
    }

    public C6174e getPriority() {
        return C6174e.NORMAL;
    }

    public boolean isFinished() {
        return this.hasRun.get();
    }

    public void setError(Throwable th) {
        this.throwable.set(th);
    }

    public synchronized void setFinished(boolean z) {
        this.hasRun.set(z);
    }

    public synchronized void addDependency(C6184l lVar) {
        this.dependencies.add(lVar);
    }
}
