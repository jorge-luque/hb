package p118io.presage.core;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/* renamed from: io.presage.core.IIllllII */
public class IIllllII extends IIlllIll implements ExecutorService {
    public IIllllII(ExecutorService executorService) {
        super(executorService);
    }

    public boolean awaitTermination(long j, TimeUnit timeUnit) {
        return this.IIIIIIII.awaitTermination(j, timeUnit);
    }

    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> collection) {
        return this.IIIIIIII.invokeAll(collection);
    }

    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> collection, long j, TimeUnit timeUnit) {
        return this.IIIIIIII.invokeAll(collection, j, timeUnit);
    }

    public <T> T invokeAny(Collection<? extends Callable<T>> collection) {
        return this.IIIIIIII.invokeAny(collection);
    }

    public <T> T invokeAny(Collection<? extends Callable<T>> collection, long j, TimeUnit timeUnit) {
        return this.IIIIIIII.invokeAny(collection, j, timeUnit);
    }

    public boolean isShutdown() {
        return this.IIIIIIII.isShutdown();
    }

    public boolean isTerminated() {
        return this.IIIIIIII.isTerminated();
    }

    public List<Runnable> shutdownNow() {
        return this.IIIIIIII.shutdownNow();
    }

    public Future<?> submit(Runnable runnable) {
        return this.IIIIIIII.submit(runnable);
    }

    public <T> Future<T> submit(Runnable runnable, T t) {
        return this.IIIIIIII.submit(runnable, t);
    }

    public <T> Future<T> submit(Callable<T> callable) {
        return this.IIIIIIII.submit(callable);
    }
}
