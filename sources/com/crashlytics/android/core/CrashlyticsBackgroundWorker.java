package com.crashlytics.android.core;

import android.os.Looper;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import p118io.fabric.sdk.android.C6059c;

class CrashlyticsBackgroundWorker {
    private final ExecutorService executorService;

    public CrashlyticsBackgroundWorker(ExecutorService executorService2) {
        this.executorService = executorService2;
    }

    /* access modifiers changed from: package-private */
    public Future<?> submit(final Runnable runnable) {
        try {
            return this.executorService.submit(new Runnable() {
                public void run() {
                    try {
                        runnable.run();
                    } catch (Exception e) {
                        C6059c.m19630f().mo34090b(CrashlyticsCore.TAG, "Failed to execute task.", e);
                    }
                }
            });
        } catch (RejectedExecutionException unused) {
            C6059c.m19630f().mo34093d(CrashlyticsCore.TAG, "Executor is shut down because we're handling a fatal crash.");
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public <T> T submitAndWait(Callable<T> callable) {
        try {
            if (Looper.getMainLooper() == Looper.myLooper()) {
                return this.executorService.submit(callable).get(4, TimeUnit.SECONDS);
            }
            return this.executorService.submit(callable).get();
        } catch (RejectedExecutionException unused) {
            C6059c.m19630f().mo34093d(CrashlyticsCore.TAG, "Executor is shut down because we're handling a fatal crash.");
            return null;
        } catch (Exception e) {
            C6059c.m19630f().mo34090b(CrashlyticsCore.TAG, "Failed to execute task.", e);
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public <T> Future<T> submit(final Callable<T> callable) {
        try {
            return this.executorService.submit(new Callable<T>() {
                public T call() throws Exception {
                    try {
                        return callable.call();
                    } catch (Exception e) {
                        C6059c.m19630f().mo34090b(CrashlyticsCore.TAG, "Failed to execute task.", e);
                        return null;
                    }
                }
            });
        } catch (RejectedExecutionException unused) {
            C6059c.m19630f().mo34093d(CrashlyticsCore.TAG, "Executor is shut down because we're handling a fatal crash.");
            return null;
        }
    }
}
