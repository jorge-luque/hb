package p075d.p076a.p077a.p078a;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: d.a.a.a.b */
/* compiled from: DefaultTaskExecutor */
public class C3180b extends C3182c {

    /* renamed from: a */
    private final Object f8857a = new Object();

    /* renamed from: b */
    private final ExecutorService f8858b = Executors.newFixedThreadPool(2, new C3181a(this));

    /* renamed from: c */
    private volatile Handler f8859c;

    /* renamed from: d.a.a.a.b$a */
    /* compiled from: DefaultTaskExecutor */
    class C3181a implements ThreadFactory {

        /* renamed from: a */
        private final AtomicInteger f8860a = new AtomicInteger(0);

        C3181a(C3180b bVar) {
        }

        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable);
            thread.setName(String.format("arch_disk_io_%d", new Object[]{Integer.valueOf(this.f8860a.getAndIncrement())}));
            return thread;
        }
    }

    /* renamed from: a */
    public void mo18638a(Runnable runnable) {
        this.f8858b.execute(runnable);
    }

    /* renamed from: b */
    public void mo18640b(Runnable runnable) {
        if (this.f8859c == null) {
            synchronized (this.f8857a) {
                if (this.f8859c == null) {
                    this.f8859c = new Handler(Looper.getMainLooper());
                }
            }
        }
        this.f8859c.post(runnable);
    }

    /* renamed from: a */
    public boolean mo18639a() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }
}
