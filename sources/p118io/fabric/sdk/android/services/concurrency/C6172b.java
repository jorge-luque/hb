package p118io.fabric.sdk.android.services.concurrency;

import java.util.Collection;

/* renamed from: io.fabric.sdk.android.services.concurrency.b */
/* compiled from: Dependency */
public interface C6172b<T> {
    void addDependency(T t);

    boolean areDependenciesMet();

    Collection<T> getDependencies();
}
