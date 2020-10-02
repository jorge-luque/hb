package androidx.core.app;

import android.app.Activity;
import android.app.Application;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.util.Log;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

/* renamed from: androidx.core.app.b */
/* compiled from: ActivityRecreator */
final class C0703b {

    /* renamed from: a */
    protected static final Class<?> f1761a = m2202a();

    /* renamed from: b */
    protected static final Field f1762b = m2206b();

    /* renamed from: c */
    protected static final Field f1763c = m2208c();

    /* renamed from: d */
    protected static final Method f1764d = m2207b(f1761a);

    /* renamed from: e */
    protected static final Method f1765e = m2203a(f1761a);

    /* renamed from: f */
    protected static final Method f1766f = m2209c(f1761a);

    /* renamed from: g */
    private static final Handler f1767g = new Handler(Looper.getMainLooper());

    /* renamed from: androidx.core.app.b$a */
    /* compiled from: ActivityRecreator */
    static class C0704a implements Runnable {

        /* renamed from: a */
        final /* synthetic */ C0707d f1768a;

        /* renamed from: b */
        final /* synthetic */ Object f1769b;

        C0704a(C0707d dVar, Object obj) {
            this.f1768a = dVar;
            this.f1769b = obj;
        }

        public void run() {
            this.f1768a.f1774a = this.f1769b;
        }
    }

    /* renamed from: androidx.core.app.b$b */
    /* compiled from: ActivityRecreator */
    static class C0705b implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Application f1770a;

        /* renamed from: b */
        final /* synthetic */ C0707d f1771b;

        C0705b(Application application, C0707d dVar) {
            this.f1770a = application;
            this.f1771b = dVar;
        }

        public void run() {
            this.f1770a.unregisterActivityLifecycleCallbacks(this.f1771b);
        }
    }

    /* renamed from: androidx.core.app.b$c */
    /* compiled from: ActivityRecreator */
    static class C0706c implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Object f1772a;

        /* renamed from: b */
        final /* synthetic */ Object f1773b;

        C0706c(Object obj, Object obj2) {
            this.f1772a = obj;
            this.f1773b = obj2;
        }

        public void run() {
            try {
                if (C0703b.f1764d != null) {
                    C0703b.f1764d.invoke(this.f1772a, new Object[]{this.f1773b, false, "AppCompat recreation"});
                    return;
                }
                C0703b.f1765e.invoke(this.f1772a, new Object[]{this.f1773b, false});
            } catch (RuntimeException e) {
                if (e.getClass() == RuntimeException.class && e.getMessage() != null && e.getMessage().startsWith("Unable to stop")) {
                    throw e;
                }
            } catch (Throwable th) {
                Log.e("ActivityRecreator", "Exception while invoking performStopActivity", th);
            }
        }
    }

    /* renamed from: androidx.core.app.b$d */
    /* compiled from: ActivityRecreator */
    private static final class C0707d implements Application.ActivityLifecycleCallbacks {

        /* renamed from: a */
        Object f1774a;

        /* renamed from: b */
        private Activity f1775b;

        /* renamed from: c */
        private boolean f1776c = false;

        /* renamed from: d */
        private boolean f1777d = false;

        /* renamed from: e */
        private boolean f1778e = false;

        C0707d(Activity activity) {
            this.f1775b = activity;
        }

        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        public void onActivityDestroyed(Activity activity) {
            if (this.f1775b == activity) {
                this.f1775b = null;
                this.f1777d = true;
            }
        }

        public void onActivityPaused(Activity activity) {
            if (this.f1777d && !this.f1778e && !this.f1776c && C0703b.m2205a(this.f1774a, activity)) {
                this.f1778e = true;
                this.f1774a = null;
            }
        }

        public void onActivityResumed(Activity activity) {
        }

        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        public void onActivityStarted(Activity activity) {
            if (this.f1775b == activity) {
                this.f1776c = true;
            }
        }

        public void onActivityStopped(Activity activity) {
        }
    }

    /* renamed from: a */
    static boolean m2204a(Activity activity) {
        Object obj;
        Application application;
        C0707d dVar;
        if (Build.VERSION.SDK_INT >= 28) {
            activity.recreate();
            return true;
        } else if (m2210d() && f1766f == null) {
            return false;
        } else {
            if (f1765e == null && f1764d == null) {
                return false;
            }
            try {
                Object obj2 = f1763c.get(activity);
                if (obj2 == null || (obj = f1762b.get(activity)) == null) {
                    return false;
                }
                application = activity.getApplication();
                dVar = new C0707d(activity);
                application.registerActivityLifecycleCallbacks(dVar);
                f1767g.post(new C0704a(dVar, obj2));
                if (m2210d()) {
                    f1766f.invoke(obj, new Object[]{obj2, null, null, 0, false, null, null, false, false});
                } else {
                    activity.recreate();
                }
                f1767g.post(new C0705b(application, dVar));
                return true;
            } catch (Throwable unused) {
                return false;
            }
        }
    }

    /* renamed from: b */
    private static Method m2207b(Class<?> cls) {
        if (cls == null) {
            return null;
        }
        try {
            Method declaredMethod = cls.getDeclaredMethod("performStopActivity", new Class[]{IBinder.class, Boolean.TYPE, String.class});
            declaredMethod.setAccessible(true);
            return declaredMethod;
        } catch (Throwable unused) {
            return null;
        }
    }

    /* renamed from: c */
    private static Method m2209c(Class<?> cls) {
        if (m2210d() && cls != null) {
            try {
                Method declaredMethod = cls.getDeclaredMethod("requestRelaunchActivity", new Class[]{IBinder.class, List.class, List.class, Integer.TYPE, Boolean.TYPE, Configuration.class, Configuration.class, Boolean.TYPE, Boolean.TYPE});
                declaredMethod.setAccessible(true);
                return declaredMethod;
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    /* renamed from: d */
    private static boolean m2210d() {
        int i = Build.VERSION.SDK_INT;
        return i == 26 || i == 27;
    }

    /* renamed from: b */
    private static Field m2206b() {
        try {
            Field declaredField = Activity.class.getDeclaredField("mMainThread");
            declaredField.setAccessible(true);
            return declaredField;
        } catch (Throwable unused) {
            return null;
        }
    }

    /* renamed from: c */
    private static Field m2208c() {
        try {
            Field declaredField = Activity.class.getDeclaredField("mToken");
            declaredField.setAccessible(true);
            return declaredField;
        } catch (Throwable unused) {
            return null;
        }
    }

    /* renamed from: a */
    protected static boolean m2205a(Object obj, Activity activity) {
        try {
            Object obj2 = f1763c.get(activity);
            if (obj2 != obj) {
                return false;
            }
            f1767g.postAtFrontOfQueue(new C0706c(f1762b.get(activity), obj2));
            return true;
        } catch (Throwable th) {
            Log.e("ActivityRecreator", "Exception while fetching field values", th);
            return false;
        }
    }

    /* renamed from: a */
    private static Method m2203a(Class<?> cls) {
        if (cls == null) {
            return null;
        }
        try {
            Method declaredMethod = cls.getDeclaredMethod("performStopActivity", new Class[]{IBinder.class, Boolean.TYPE});
            declaredMethod.setAccessible(true);
            return declaredMethod;
        } catch (Throwable unused) {
            return null;
        }
    }

    /* renamed from: a */
    private static Class<?> m2202a() {
        try {
            return Class.forName("android.app.ActivityThread");
        } catch (Throwable unused) {
            return null;
        }
    }
}
