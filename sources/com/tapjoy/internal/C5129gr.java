package com.tapjoy.internal;

import android.app.Activity;
import android.opengl.GLSurfaceView;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
/* renamed from: com.tapjoy.internal.gr */
public final class C5129gr {

    /* renamed from: a */
    public static final C4904ba f14031a = new C4904ba() {
        /* renamed from: a */
        public final boolean mo30981a(Runnable runnable) {
            GLSurfaceView gLSurfaceView = (GLSurfaceView) C5129gr.f14033c.mo31018a();
            if (gLSurfaceView == null) {
                return false;
            }
            gLSurfaceView.queueEvent(runnable);
            return true;
        }
    };

    /* renamed from: b */
    private static Activity f14032b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public static final C4930by f14033c = new C4930by();
    /* access modifiers changed from: private */

    /* renamed from: d */
    public static final C4930by f14034d = new C4930by();

    /* renamed from: a */
    static void m17303a(GLSurfaceView gLSurfaceView) {
        f14033c.mo31019a(gLSurfaceView);
        gLSurfaceView.queueEvent(new Runnable() {
            public final void run() {
                C5129gr.f14034d.mo31019a(Thread.currentThread());
            }
        });
    }

    /* renamed from: b */
    public static Thread m17304b() {
        return (Thread) f14034d.mo31018a();
    }

    /* renamed from: a */
    public static Activity m17302a() {
        Activity activity = f14032b;
        return activity == null ? C3123b.m10217a() : activity;
    }
}
