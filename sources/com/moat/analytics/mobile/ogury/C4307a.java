package com.moat.analytics.mobile.ogury;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.moat.analytics.mobile.ogury.C4315e;
import com.moat.analytics.mobile.ogury.C4346q;
import java.lang.ref.WeakReference;

/* renamed from: com.moat.analytics.mobile.ogury.a */
final class C4307a {

    /* renamed from: ˊ */
    private static Application f11483 = null;

    /* renamed from: ˋ */
    private static boolean f11484 = false;

    /* renamed from: ˎ */
    static WeakReference<Activity> f11485 = null;
    /* access modifiers changed from: private */

    /* renamed from: ˏ */
    public static int f11486 = 0;
    /* access modifiers changed from: private */

    /* renamed from: ॱ */
    public static boolean f11487 = false;

    /* renamed from: com.moat.analytics.mobile.ogury.a$a */
    static class C4308a implements Application.ActivityLifecycleCallbacks {
        C4308a() {
        }

        /* renamed from: ˎ */
        private static void m14412(boolean z) {
            if (z) {
                C4315e.C43161.m14442(3, "ActivityState", (Object) null, "App became visible");
                if (C4346q.m14542().f11640 == C4346q.C4354e.f11657 && !((C4328i) MoatAnalytics.getInstance()).f11580) {
                    C4333m.m14517().mo29175();
                    return;
                }
                return;
            }
            C4315e.C43161.m14442(3, "ActivityState", (Object) null, "App became invisible");
            if (C4346q.m14542().f11640 == C4346q.C4354e.f11657 && !((C4328i) MoatAnalytics.getInstance()).f11580) {
                C4333m.m14517().mo29176();
            }
        }

        public final void onActivityCreated(Activity activity, Bundle bundle) {
            int unused = C4307a.f11486 = 1;
        }

        public final void onActivityDestroyed(Activity activity) {
            try {
                if (!(C4307a.f11486 == 3 || C4307a.f11486 == 5)) {
                    if (C4307a.f11487) {
                        m14412(false);
                    }
                    boolean unused = C4307a.f11487 = false;
                }
                int unused2 = C4307a.f11486 = 6;
                StringBuilder sb = new StringBuilder("Activity destroyed: ");
                sb.append(activity.getClass());
                sb.append("@");
                sb.append(activity.hashCode());
                C4315e.C43161.m14442(3, "ActivityState", this, sb.toString());
                if (C4307a.m14411(activity)) {
                    C4307a.f11485 = new WeakReference<>((Object) null);
                }
            } catch (Exception e) {
                C4332l.m14509(e);
            }
        }

        public final void onActivityPaused(Activity activity) {
            try {
                int unused = C4307a.f11486 = 4;
                if (C4307a.m14411(activity)) {
                    C4307a.f11485 = new WeakReference<>((Object) null);
                }
                StringBuilder sb = new StringBuilder("Activity paused: ");
                sb.append(activity.getClass());
                sb.append("@");
                sb.append(activity.hashCode());
                C4315e.C43161.m14442(3, "ActivityState", this, sb.toString());
            } catch (Exception e) {
                C4332l.m14509(e);
            }
        }

        public final void onActivityResumed(Activity activity) {
            try {
                C4307a.f11485 = new WeakReference<>(activity);
                int unused = C4307a.f11486 = 3;
                C4346q.m14542().mo29182();
                StringBuilder sb = new StringBuilder("Activity resumed: ");
                sb.append(activity.getClass());
                sb.append("@");
                sb.append(activity.hashCode());
                C4315e.C43161.m14442(3, "ActivityState", this, sb.toString());
                if (((C4328i) MoatAnalytics.getInstance()).f11583) {
                    C4309b.m14413(activity);
                }
            } catch (Exception e) {
                C4332l.m14509(e);
            }
        }

        public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        public final void onActivityStarted(Activity activity) {
            try {
                C4307a.f11485 = new WeakReference<>(activity);
                int unused = C4307a.f11486 = 2;
                if (!C4307a.f11487) {
                    m14412(true);
                }
                boolean unused2 = C4307a.f11487 = true;
                StringBuilder sb = new StringBuilder("Activity started: ");
                sb.append(activity.getClass());
                sb.append("@");
                sb.append(activity.hashCode());
                C4315e.C43161.m14442(3, "ActivityState", this, sb.toString());
            } catch (Exception e) {
                C4332l.m14509(e);
            }
        }

        public final void onActivityStopped(Activity activity) {
            try {
                if (C4307a.f11486 != 3) {
                    boolean unused = C4307a.f11487 = false;
                    m14412(false);
                }
                int unused2 = C4307a.f11486 = 5;
                if (C4307a.m14411(activity)) {
                    C4307a.f11485 = new WeakReference<>((Object) null);
                }
                StringBuilder sb = new StringBuilder("Activity stopped: ");
                sb.append(activity.getClass());
                sb.append("@");
                sb.append(activity.hashCode());
                C4315e.C43161.m14442(3, "ActivityState", this, sb.toString());
            } catch (Exception e) {
                C4332l.m14509(e);
            }
        }
    }

    C4307a() {
    }

    /* renamed from: ˋ */
    static void m14405(Application application) {
        f11483 = application;
        if (!f11484) {
            f11484 = true;
            application.registerActivityLifecycleCallbacks(new C4308a());
        }
    }

    /* renamed from: ˏ */
    static Application m14408() {
        return f11483;
    }

    /* renamed from: ॱ */
    static /* synthetic */ boolean m14411(Activity activity) {
        WeakReference<Activity> weakReference = f11485;
        return weakReference != null && weakReference.get() == activity;
    }
}
