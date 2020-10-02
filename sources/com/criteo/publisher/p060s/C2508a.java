package com.criteo.publisher.p060s;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;

/* renamed from: com.criteo.publisher.s.a */
public class C2508a implements Executor {

    /* renamed from: a */
    private final Handler f8001a = new Handler(Looper.getMainLooper());

    /* renamed from: a */
    public void mo10520a(Runnable runnable) {
        this.f8001a.post(runnable);
    }

    public void execute(Runnable runnable) {
        if (Thread.currentThread() == this.f8001a.getLooper().getThread()) {
            runnable.run();
        } else {
            this.f8001a.post(runnable);
        }
    }
}
