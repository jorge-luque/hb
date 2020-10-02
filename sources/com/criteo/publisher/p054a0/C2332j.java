package com.criteo.publisher.p054a0;

import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: com.criteo.publisher.a0.j */
public class C2332j<T> implements Future<T> {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final AtomicReference<C2335c<T>> f7695a = new AtomicReference<>();
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final CountDownLatch f7696b = new CountDownLatch(1);

    /* renamed from: c */
    private final FutureTask<T> f7697c = new FutureTask<>(new C2334b());

    /* renamed from: com.criteo.publisher.a0.j$b */
    private class C2334b implements Callable<T> {
        private C2334b() {
        }

        public T call() throws Exception {
            C2332j.this.f7696b.await();
            return ((C2335c) C2332j.this.f7695a.get()).mo10152a();
        }
    }

    /* renamed from: com.criteo.publisher.a0.j$c */
    private static final class C2335c<T> {

        /* renamed from: a */
        private final T f7699a;

        /* renamed from: b */
        private final Exception f7700b = null;

        C2335c(T t) {
            this.f7699a = t;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public T mo10152a() throws Exception {
            Exception exc = this.f7700b;
            if (exc == null) {
                return this.f7699a;
            }
            throw exc;
        }
    }

    public boolean cancel(boolean z) {
        return this.f7697c.cancel(z);
    }

    public T get() throws InterruptedException, ExecutionException {
        this.f7697c.run();
        return this.f7697c.get();
    }

    public boolean isCancelled() {
        return this.f7697c.isCancelled();
    }

    public boolean isDone() {
        return this.f7697c.isDone();
    }

    /* renamed from: b */
    public static <T> C2332j<T> m8977b(T t) {
        C2332j<T> jVar = new C2332j<>();
        jVar.mo10145a(t);
        return jVar;
    }

    /* renamed from: a */
    public void mo10145a(T t) {
        this.f7695a.compareAndSet((Object) null, new C2335c(t));
        this.f7696b.countDown();
    }

    public T get(long j, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        this.f7697c.run();
        return this.f7697c.get(j, timeUnit);
    }
}
