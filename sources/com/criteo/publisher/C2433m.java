package com.criteo.publisher;

import com.criteo.publisher.p054a0.C2341p;
import com.criteo.publisher.p064w.C2571a;
import com.criteo.publisher.p064w.C2572b;
import java.util.concurrent.ExecutionException;

/* renamed from: com.criteo.publisher.m */
public abstract class C2433m implements Runnable {

    /* renamed from: a */
    private final C2571a f7844a = C2572b.m9650b(C2433m.class);

    /* renamed from: b */
    private final StackTraceElement[] f7845b = Thread.currentThread().getStackTrace();

    /* renamed from: a */
    public abstract void mo10204a() throws Throwable;

    public void run() {
        try {
            mo10204a();
        } catch (Throwable th) {
            ExecutionException executionException = new ExecutionException(th);
            executionException.setStackTrace(this.f7845b);
            if (th instanceof RuntimeException) {
                C2341p.m8996a((Throwable) executionException);
            } else {
                this.f7844a.mo10612a((Throwable) executionException);
            }
        }
    }
}
