package com.tapjoy.internal;

import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import javax.annotation.Nullable;

/* renamed from: com.tapjoy.internal.kb */
public abstract class C3169kb implements C3171ke {

    /* renamed from: a */
    private final C3170a f8845a = new C3170a();

    /* renamed from: b */
    private final C5258kd f8846b = new C5258kd();

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final boolean mo18620a(@Nullable Object obj) {
        boolean a = this.f8845a.mo18628a(obj, (Throwable) null, 2);
        if (a) {
            this.f8846b.mo31478a();
        }
        return a;
    }

    public boolean cancel(boolean z) {
        if (!this.f8845a.mo18628a((Object) null, (Throwable) null, 4)) {
            return false;
        }
        this.f8846b.mo31478a();
        return true;
    }

    public Object get(long j, TimeUnit timeUnit) {
        C3170a aVar = this.f8845a;
        if (aVar.tryAcquireSharedNanos(-1, timeUnit.toNanos(j))) {
            return aVar.mo18627a();
        }
        throw new TimeoutException("Timeout waiting for task.");
    }

    public boolean isCancelled() {
        return this.f8845a.mo18630c();
    }

    public boolean isDone() {
        return this.f8845a.mo18629b();
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final boolean mo18621a(Throwable th) {
        boolean a = this.f8845a.mo18628a((Object) null, (Throwable) C5241jp.m17607a(th), 2);
        if (a) {
            this.f8846b.mo31478a();
        }
        if (!(th instanceof Error)) {
            return a;
        }
        throw ((Error) th);
    }

    public Object get() {
        C3170a aVar = this.f8845a;
        aVar.acquireSharedInterruptibly(-1);
        return aVar.mo18627a();
    }

    /* renamed from: com.tapjoy.internal.kb$a */
    static final class C3170a extends AbstractQueuedSynchronizer {

        /* renamed from: a */
        private Object f8847a;

        /* renamed from: b */
        private Throwable f8848b;

        C3170a() {
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public final Object mo18627a() {
            int state = getState();
            if (state != 2) {
                if (state != 4) {
                    throw new IllegalStateException("Error, synchronizer in invalid state: " + state);
                }
                throw new CancellationException("Task was cancelled.");
            } else if (this.f8848b == null) {
                return this.f8847a;
            } else {
                throw new ExecutionException(this.f8848b);
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public final boolean mo18629b() {
            return (getState() & 6) != 0;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: c */
        public final boolean mo18630c() {
            return getState() == 4;
        }

        /* access modifiers changed from: protected */
        public final int tryAcquireShared(int i) {
            return mo18629b() ? 1 : -1;
        }

        /* access modifiers changed from: protected */
        public final boolean tryReleaseShared(int i) {
            setState(i);
            return true;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public final boolean mo18628a(@Nullable Object obj, @Nullable Throwable th, int i) {
            boolean compareAndSetState = compareAndSetState(0, 1);
            if (compareAndSetState) {
                this.f8847a = obj;
                this.f8848b = th;
                releaseShared(i);
            } else if (getState() == 1) {
                acquireShared(-1);
            }
            return compareAndSetState;
        }
    }
}
