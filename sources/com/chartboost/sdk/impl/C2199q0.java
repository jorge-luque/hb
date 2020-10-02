package com.chartboost.sdk.impl;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.chartboost.sdk.impl.q0 */
public final class C2199q0 {

    /* renamed from: com.chartboost.sdk.impl.q0$a */
    static class C2200a implements ThreadFactory {

        /* renamed from: a */
        private final AtomicInteger f7429a = new AtomicInteger(1);

        C2200a() {
        }

        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "Chartboost Thread #" + this.f7429a.getAndIncrement());
        }
    }

    /* renamed from: a */
    public static ScheduledExecutorService m8753a() {
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(2, new C2200a());
        scheduledThreadPoolExecutor.prestartAllCoreThreads();
        return scheduledThreadPoolExecutor;
    }

    /* renamed from: a */
    public static ExecutorService m8752a(int i) {
        int i2 = i;
        int i3 = i;
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(i2, i3, 10, TimeUnit.SECONDS, new PriorityBlockingQueue());
        threadPoolExecutor.prestartAllCoreThreads();
        return threadPoolExecutor;
    }
}
