package com.onesignal;

import android.app.Activity;
import android.app.Application;
import android.content.ComponentCallbacks;
import android.content.res.Configuration;
import android.os.Bundle;

/* renamed from: com.onesignal.b */
/* compiled from: ActivityLifecycleListener */
class C4474b implements Application.ActivityLifecycleCallbacks {

    /* renamed from: a */
    private static C4474b f12288a;

    /* renamed from: b */
    private static ComponentCallbacks f12289b;

    /* renamed from: com.onesignal.b$a */
    /* compiled from: ActivityLifecycleListener */
    static class C4475a implements ComponentCallbacks {
        C4475a() {
        }

        public void onConfigurationChanged(Configuration configuration) {
            C4461a.m15374a(configuration);
        }

        public void onLowMemory() {
        }
    }

    C4474b() {
    }

    /* renamed from: a */
    static void m15422a(Application application) {
        if (f12288a == null) {
            C4474b bVar = new C4474b();
            f12288a = bVar;
            application.registerActivityLifecycleCallbacks(bVar);
        }
        if (f12289b == null) {
            C4475a aVar = new C4475a();
            f12289b = aVar;
            application.registerComponentCallbacks(aVar);
        }
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
        C4461a.m15373a(activity);
    }

    public void onActivityDestroyed(Activity activity) {
        C4461a.m15379b(activity);
    }

    public void onActivityPaused(Activity activity) {
        C4461a.m15382c(activity);
    }

    public void onActivityResumed(Activity activity) {
        C4461a.m15384d(activity);
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public void onActivityStarted(Activity activity) {
        C4461a.m15385e(activity);
    }

    public void onActivityStopped(Activity activity) {
        C4461a.m15386f(activity);
    }
}
