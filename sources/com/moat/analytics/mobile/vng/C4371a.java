package com.moat.analytics.mobile.vng;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import java.lang.ref.WeakReference;

/* renamed from: com.moat.analytics.mobile.vng.a */
class C4371a {

    /* renamed from: a */
    static WeakReference<Activity> f11712a = null;

    /* renamed from: b */
    private static boolean f11713b = false;

    /* renamed from: c */
    private static Application f11714c = null;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public static int f11715d = 0;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public static boolean f11716e = false;

    /* renamed from: com.moat.analytics.mobile.vng.a$a */
    private static class C4372a implements Application.ActivityLifecycleCallbacks {
        C4372a() {
        }

        /* renamed from: a */
        private static void m14622a(boolean z) {
            C4409p.m14772a(3, "ActivityState", (Object) null, z ? "App became visible" : "App became invisible");
        }

        public void onActivityCreated(Activity activity, Bundle bundle) {
            int unused = C4371a.f11715d = 1;
        }

        public void onActivityDestroyed(Activity activity) {
            try {
                if (!(C4371a.f11715d == 3 || C4371a.f11715d == 5)) {
                    if (C4371a.f11716e) {
                        m14622a(false);
                    }
                    boolean unused = C4371a.f11716e = false;
                }
                int unused2 = C4371a.f11715d = 6;
                C4409p.m14772a(3, "ActivityState", (Object) this, "Activity destroyed: " + activity.getClass() + "@" + activity.hashCode());
                if (C4371a.m14620b(activity)) {
                    C4371a.f11712a = new WeakReference<>((Object) null);
                }
            } catch (Exception e) {
                C4403n.m14758a(e);
            }
        }

        public void onActivityPaused(Activity activity) {
            try {
                int unused = C4371a.f11715d = 4;
                if (C4371a.m14620b(activity)) {
                    C4371a.f11712a = new WeakReference<>((Object) null);
                }
                C4409p.m14772a(3, "ActivityState", (Object) this, "Activity paused: " + activity.getClass() + "@" + activity.hashCode());
            } catch (Exception e) {
                C4403n.m14758a(e);
            }
        }

        public void onActivityResumed(Activity activity) {
            try {
                C4371a.f11712a = new WeakReference<>(activity);
                int unused = C4371a.f11715d = 3;
                C4424w.m14808a().mo29341b();
                C4409p.m14772a(3, "ActivityState", (Object) this, "Activity resumed: " + activity.getClass() + "@" + activity.hashCode());
                if (((C4400k) MoatAnalytics.getInstance()).f11808b) {
                    C4382f.m14664a(activity);
                }
            } catch (Exception e) {
                C4403n.m14758a(e);
            }
        }

        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        public void onActivityStarted(Activity activity) {
            try {
                C4371a.f11712a = new WeakReference<>(activity);
                int unused = C4371a.f11715d = 2;
                if (!C4371a.f11716e) {
                    m14622a(true);
                }
                boolean unused2 = C4371a.f11716e = true;
                C4409p.m14772a(3, "ActivityState", (Object) this, "Activity started: " + activity.getClass() + "@" + activity.hashCode());
            } catch (Exception e) {
                C4403n.m14758a(e);
            }
        }

        public void onActivityStopped(Activity activity) {
            try {
                if (C4371a.f11715d != 3) {
                    boolean unused = C4371a.f11716e = false;
                    m14622a(false);
                }
                int unused2 = C4371a.f11715d = 5;
                if (C4371a.m14620b(activity)) {
                    C4371a.f11712a = new WeakReference<>((Object) null);
                }
                C4409p.m14772a(3, "ActivityState", (Object) this, "Activity stopped: " + activity.getClass() + "@" + activity.hashCode());
            } catch (Exception e) {
                C4403n.m14758a(e);
            }
        }
    }

    C4371a() {
    }

    /* renamed from: a */
    static Application m14615a() {
        return f11714c;
    }

    /* renamed from: a */
    static void m14616a(Application application) {
        f11714c = application;
        if (!f11713b) {
            f11713b = true;
            application.registerActivityLifecycleCallbacks(new C4372a());
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static boolean m14620b(Activity activity) {
        WeakReference<Activity> weakReference = f11712a;
        return weakReference != null && weakReference.get() == activity;
    }
}
