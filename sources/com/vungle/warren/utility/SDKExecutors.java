package com.vungle.warren.utility;

import android.os.Handler;
import android.os.Looper;
import java.util.List;
import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class SDKExecutors implements Executors {
    private static final ThreadPoolExecutor API_EXECUTOR;
    private static final ExecutorService BACKGROUND_EXECUTOR;
    private static final ExecutorService IO_EXECUTOR;
    private static final int IO_KEEP_ALIVE_TIME_SECONDS = 5;
    private static final int JOBS_KEEP_ALIVE_TIME_SECONDS = 1;
    private static final ExecutorService JOB_EXECUTOR;
    private static int NUMBER_OF_CORES = Runtime.getRuntime().availableProcessors();
    private static final int SINGLE_CORE_POOL_SIZE = 1;
    private static final ExecutorService UI_EXECUTOR;
    private static final int VUNGLE_KEEP_ALIVE_TIME_SECONDS = 10;

    private static class NamedThreadFactory implements ThreadFactory {
        private AtomicInteger atomicInteger = new AtomicInteger(0);
        private final String name;
        private ThreadFactory threadFactory = Executors.defaultThreadFactory();

        public NamedThreadFactory(String str) {
            this.name = str;
        }

        public Thread newThread(Runnable runnable) {
            Thread newThread = this.threadFactory.newThread(runnable);
            newThread.setName(this.name + "-th-" + this.atomicInteger.incrementAndGet());
            return newThread;
        }
    }

    static {
        C55441 r0 = new AbstractExecutorService() {
            private final Handler UIHandler = new Handler(Looper.getMainLooper());

            public boolean awaitTermination(long j, TimeUnit timeUnit) {
                return false;
            }

            public void execute(Runnable runnable) {
                this.UIHandler.post(runnable);
            }

            public boolean isShutdown() {
                return false;
            }

            public boolean isTerminated() {
                return false;
            }

            public void shutdown() {
            }

            public List<Runnable> shutdownNow() {
                return null;
            }
        };
        int i = NUMBER_OF_CORES;
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(i, i, 1, TimeUnit.SECONDS, new PriorityBlockingQueue(), new NamedThreadFactory("vng_jr"));
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        ThreadPoolExecutor threadPoolExecutor2 = new ThreadPoolExecutor(1, 1, 5, TimeUnit.SECONDS, new LinkedBlockingQueue(), new NamedThreadFactory("vng_io"));
        threadPoolExecutor2.allowCoreThreadTimeOut(true);
        ThreadPoolExecutor threadPoolExecutor3 = new ThreadPoolExecutor(1, 1, 10, TimeUnit.SECONDS, new LinkedBlockingQueue(), new NamedThreadFactory("vng_background"));
        threadPoolExecutor3.allowCoreThreadTimeOut(true);
        ThreadPoolExecutor threadPoolExecutor4 = new ThreadPoolExecutor(1, 1, 10, TimeUnit.SECONDS, new LinkedBlockingQueue(), new NamedThreadFactory("vng_api"));
        threadPoolExecutor4.allowCoreThreadTimeOut(true);
        UI_EXECUTOR = r0;
        JOB_EXECUTOR = threadPoolExecutor;
        IO_EXECUTOR = threadPoolExecutor2;
        BACKGROUND_EXECUTOR = threadPoolExecutor3;
        API_EXECUTOR = threadPoolExecutor4;
    }

    public ExecutorService getApiExecutor() {
        return API_EXECUTOR;
    }

    public ExecutorService getBackgroundExecutor() {
        return BACKGROUND_EXECUTOR;
    }

    public ExecutorService getIOExecutor() {
        return IO_EXECUTOR;
    }

    public ExecutorService getJobExecutor() {
        return JOB_EXECUTOR;
    }

    public ExecutorService getUIExecutor() {
        return UI_EXECUTOR;
    }
}
