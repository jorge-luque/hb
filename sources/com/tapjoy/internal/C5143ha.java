package com.tapjoy.internal;

import android.os.Handler;
import android.os.Looper;

/* renamed from: com.tapjoy.internal.ha */
public class C5143ha implements C5126go {

    /* renamed from: a */
    private static final C5143ha f14063a = new C5143ha() {
        /* renamed from: a */
        public final void mo30543a(String str) {
        }

        /* renamed from: a */
        public final void mo30544a(String str, C3143gl glVar) {
        }

        /* renamed from: a */
        public final void mo30545a(String str, String str2, C3143gl glVar) {
        }

        /* renamed from: b */
        public final void mo30546b(String str) {
        }

        /* renamed from: c */
        public final void mo30547c(String str) {
        }

        /* renamed from: d */
        public final void mo30548d(String str) {
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final C5126go f14064b;

    /* renamed from: c */
    private final C4904ba f14065c;

    /* synthetic */ C5143ha(byte b) {
        this();
    }

    /* renamed from: b */
    public void mo30546b(final String str) {
        this.f14065c.mo30981a(new Runnable() {
            public final void run() {
                C5143ha.this.f14064b.mo30546b(str);
            }
        });
    }

    /* renamed from: c */
    public void mo30547c(final String str) {
        this.f14065c.mo30981a(new Runnable() {
            public final void run() {
                C5143ha.this.f14064b.mo30547c(str);
            }
        });
    }

    /* renamed from: d */
    public void mo30548d(final String str) {
        this.f14065c.mo30981a(new Runnable() {
            public final void run() {
                C5143ha.this.f14064b.mo30548d(str);
            }
        });
    }

    private C5143ha() {
        this.f14064b = null;
        this.f14065c = null;
    }

    /* renamed from: a */
    public static C5143ha m17337a(C5126go goVar) {
        if (!(!(goVar instanceof C5143ha))) {
            throw new IllegalArgumentException();
        } else if (goVar != null) {
            return new C5143ha(goVar);
        } else {
            return f14063a;
        }
    }

    private C5143ha(C5126go goVar) {
        Handler handler;
        this.f14064b = goVar;
        Looper myLooper = Looper.myLooper();
        if (myLooper != null) {
            C5241jp.m17607a(myLooper);
            handler = myLooper == Looper.getMainLooper() ? C5269u.m17670a() : new Handler(myLooper);
        } else {
            handler = null;
        }
        if (handler != null) {
            this.f14065c = C5269u.m17671a(handler);
            handler.getLooper();
        } else if (Thread.currentThread() == C5129gr.m17304b()) {
            this.f14065c = C5129gr.f14031a;
        } else {
            this.f14065c = C5269u.m17671a(C5269u.m17670a());
        }
    }

    /* renamed from: a */
    public void mo30543a(final String str) {
        this.f14065c.mo30981a(new Runnable() {
            public final void run() {
                C5143ha.this.f14064b.mo30543a(str);
            }
        });
    }

    /* renamed from: a */
    public void mo30544a(final String str, final C3143gl glVar) {
        this.f14065c.mo30981a(new Runnable() {
            public final void run() {
                C5143ha.this.f14064b.mo30544a(str, glVar);
            }
        });
    }

    /* renamed from: a */
    public void mo30545a(final String str, final String str2, final C3143gl glVar) {
        this.f14065c.mo30981a(new Runnable() {
            public final void run() {
                C5143ha.this.f14064b.mo30545a(str, str2, glVar);
            }
        });
    }
}
