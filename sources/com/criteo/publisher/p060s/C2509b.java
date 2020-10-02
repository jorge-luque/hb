package com.criteo.publisher.p060s;

import com.criteo.publisher.C2387i;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* renamed from: com.criteo.publisher.s.b */
public class C2509b implements C2387i.C2413m0<ThreadPoolExecutor> {

    /* renamed from: com.criteo.publisher.s.b$b */
    private static class C2511b implements RejectedExecutionHandler {

        /* renamed from: a */
        private ThreadPoolExecutor f8002a;

        private C2511b() {
        }

        public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
            synchronized (this) {
                if (this.f8002a == null) {
                    this.f8002a = new ThreadPoolExecutor(5, 5, 3, TimeUnit.SECONDS, new LinkedBlockingQueue(), Executors.defaultThreadFactory());
                }
            }
            this.f8002a.execute(runnable);
        }
    }

    /* renamed from: a */
    public ThreadPoolExecutor m9462a() {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 20, 3, TimeUnit.SECONDS, new SynchronousQueue(), Executors.defaultThreadFactory());
        threadPoolExecutor.setRejectedExecutionHandler(new C2511b());
        return threadPoolExecutor;
    }
}
