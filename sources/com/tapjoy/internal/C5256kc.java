package com.tapjoy.internal;

import com.tapjoy.internal.C5260kf;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.locks.ReentrantLock;

/* renamed from: com.tapjoy.internal.kc */
public abstract class C5256kc implements C5260kf {

    /* renamed from: a */
    private final ReentrantLock f14436a = new ReentrantLock();

    /* renamed from: b */
    private final C5257a f14437b = new C5257a(this, (byte) 0);

    /* renamed from: c */
    private final C5257a f14438c = new C5257a(this, (byte) 0);

    /* renamed from: d */
    private C5260kf.C5261a f14439d = C5260kf.C5261a.NEW;

    /* renamed from: e */
    private boolean f14440e = false;

    /* renamed from: com.tapjoy.internal.kc$a */
    class C5257a extends C3169kb {
        private C5257a() {
        }

        /* access modifiers changed from: private */
        /* renamed from: a */
        public C5260kf.C5261a get(long j, TimeUnit timeUnit) {
            try {
                return (C5260kf.C5261a) super.get(j, timeUnit);
            } catch (TimeoutException unused) {
                throw new TimeoutException(C5256kc.this.toString());
            }
        }

        /* synthetic */ C5257a(C5256kc kcVar, byte b) {
            this();
        }
    }

    /* renamed from: g */
    private C3171ke m17630g() {
        this.f14436a.lock();
        try {
            if (this.f14439d == C5260kf.C5261a.NEW) {
                this.f14439d = C5260kf.C5261a.TERMINATED;
                this.f14437b.mo18620a((Object) C5260kf.C5261a.TERMINATED);
                this.f14438c.mo18620a((Object) C5260kf.C5261a.TERMINATED);
            } else if (this.f14439d == C5260kf.C5261a.STARTING) {
                this.f14440e = true;
                this.f14437b.mo18620a((Object) C5260kf.C5261a.STOPPING);
            } else if (this.f14439d == C5260kf.C5261a.RUNNING) {
                this.f14439d = C5260kf.C5261a.STOPPING;
                mo31471b();
            }
        } catch (Throwable th) {
            this.f14436a.unlock();
            throw th;
        }
        this.f14436a.unlock();
        return this.f14438c;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract void mo31470a();

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo31474a(Throwable th) {
        C5241jp.m17607a(th);
        this.f14436a.lock();
        try {
            if (this.f14439d == C5260kf.C5261a.STARTING) {
                this.f14437b.mo18621a(th);
                this.f14438c.mo18621a((Throwable) new Exception("Service failed to start.", th));
            } else if (this.f14439d == C5260kf.C5261a.STOPPING) {
                this.f14438c.mo18621a(th);
            } else if (this.f14439d == C5260kf.C5261a.RUNNING) {
                this.f14438c.mo18621a((Throwable) new Exception("Service failed while running", th));
            } else if (this.f14439d == C5260kf.C5261a.NEW || this.f14439d == C5260kf.C5261a.TERMINATED) {
                throw new IllegalStateException("Failed while in state:" + this.f14439d, th);
            }
            this.f14439d = C5260kf.C5261a.FAILED;
        } finally {
            this.f14436a.unlock();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public abstract void mo31471b();

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public final void mo31475c() {
        this.f14436a.lock();
        try {
            if (this.f14439d == C5260kf.C5261a.STARTING) {
                this.f14439d = C5260kf.C5261a.RUNNING;
                if (this.f14440e) {
                    m17630g();
                } else {
                    this.f14437b.mo18620a((Object) C5260kf.C5261a.RUNNING);
                }
                return;
            }
            IllegalStateException illegalStateException = new IllegalStateException("Cannot notifyStarted() when the service is " + this.f14439d);
            mo31474a(illegalStateException);
            throw illegalStateException;
        } finally {
            this.f14436a.unlock();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public final void mo31476d() {
        this.f14436a.lock();
        try {
            if (this.f14439d != C5260kf.C5261a.STOPPING) {
                if (this.f14439d != C5260kf.C5261a.RUNNING) {
                    IllegalStateException illegalStateException = new IllegalStateException("Cannot notifyStopped() when the service is " + this.f14439d);
                    mo31474a(illegalStateException);
                    throw illegalStateException;
                }
            }
            this.f14439d = C5260kf.C5261a.TERMINATED;
            this.f14438c.mo18620a((Object) C5260kf.C5261a.TERMINATED);
        } finally {
            this.f14436a.unlock();
        }
    }

    /* renamed from: e */
    public final C3171ke mo31467e() {
        this.f14436a.lock();
        try {
            if (this.f14439d == C5260kf.C5261a.NEW) {
                this.f14439d = C5260kf.C5261a.STARTING;
                mo31470a();
            }
        } catch (Throwable th) {
            this.f14436a.unlock();
            throw th;
        }
        this.f14436a.unlock();
        return this.f14437b;
    }

    /* renamed from: f */
    public final C5260kf.C5261a mo31468f() {
        C5260kf.C5261a aVar;
        this.f14436a.lock();
        try {
            if (!this.f14440e || this.f14439d != C5260kf.C5261a.STARTING) {
                aVar = this.f14439d;
            } else {
                aVar = C5260kf.C5261a.STOPPING;
            }
            return aVar;
        } finally {
            this.f14436a.unlock();
        }
    }

    public String toString() {
        return getClass().getSimpleName() + " [" + mo31468f() + "]";
    }
}
