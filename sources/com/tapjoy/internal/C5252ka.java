package com.tapjoy.internal;

import com.tapjoy.internal.C5260kf;
import java.util.concurrent.Executor;
import java.util.logging.Logger;

/* renamed from: com.tapjoy.internal.ka */
public abstract class C5252ka implements C5260kf {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static final Logger f14431a = Logger.getLogger(C5252ka.class.getName());

    /* renamed from: b */
    private final C5260kf f14432b = new C5256kc() {
        /* access modifiers changed from: protected */
        /* renamed from: a */
        public final void mo31470a() {
            new Executor() {
                public final void execute(Runnable runnable) {
                    new Thread(runnable, C5252ka.this.getClass().getSimpleName()).start();
                }
            }.execute(new Runnable() {
                public final void run() {
                    try {
                        C5252ka.this.mo31290b();
                        C52531.this.mo31475c();
                        if (C52531.this.mo31468f() == C5260kf.C5261a.RUNNING) {
                            C5252ka.this.mo31292d();
                        }
                        C5252ka.this.mo31291c();
                        C52531.this.mo31476d();
                    } catch (Throwable th) {
                        C52531.this.mo31474a(th);
                        throw C3167jr.m10437a(th);
                    }
                }
            });
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public final void mo31471b() {
            C5252ka.this.mo31289a();
        }
    };

    /* renamed from: a */
    public void mo31289a() {
    }

    /* renamed from: b */
    public void mo31290b() {
    }

    /* renamed from: c */
    public void mo31291c() {
    }

    /* renamed from: d */
    public abstract void mo31292d();

    /* renamed from: e */
    public final C3171ke mo31467e() {
        return this.f14432b.mo31467e();
    }

    /* renamed from: f */
    public final C5260kf.C5261a mo31468f() {
        return this.f14432b.mo31468f();
    }

    public String toString() {
        return getClass().getSimpleName() + " [" + mo31468f() + "]";
    }
}
