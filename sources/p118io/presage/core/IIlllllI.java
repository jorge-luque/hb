package p118io.presage.core;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* renamed from: io.presage.core.IIlllllI */
public class IIlllllI extends IIlllIll implements ScheduledExecutorService {
    public IIlllllI(ScheduledExecutorService scheduledExecutorService) {
        super(scheduledExecutorService);
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

    public ScheduledFuture<?> schedule(Runnable runnable, long j, TimeUnit timeUnit) {
        this.IIIIIIlI.incrementAndGet();
        this.IIIIIIlI.intValue();
        try {
            return ((ScheduledExecutorService) this.IIIIIIII).schedule(runnable, j, timeUnit);
        } catch (Exception unused) {
            this.IIIIIIlI.decrementAndGet();
            return null;
        }
    }

    public <V> ScheduledFuture<V> schedule(Callable<V> callable, long j, TimeUnit timeUnit) {
        this.IIIIIIlI.incrementAndGet();
        try {
            return ((ScheduledExecutorService) this.IIIIIIII).schedule(callable, j, timeUnit);
        } catch (Exception unused) {
            this.IIIIIIlI.decrementAndGet();
            return null;
        }
    }

    public ScheduledFuture<?> scheduleAtFixedRate(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        this.IIIIIIlI.incrementAndGet();
        try {
            return ((ScheduledExecutorService) this.IIIIIIII).scheduleAtFixedRate(runnable, j, j2, timeUnit);
        } catch (Exception unused) {
            this.IIIIIIlI.decrementAndGet();
            return null;
        }
    }

    public ScheduledFuture<?> scheduleWithFixedDelay(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        this.IIIIIIlI.incrementAndGet();
        try {
            return ((ScheduledExecutorService) this.IIIIIIII).scheduleWithFixedDelay(runnable, j, j2, timeUnit);
        } catch (Exception unused) {
            this.IIIIIIlI.decrementAndGet();
            return null;
        }
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
