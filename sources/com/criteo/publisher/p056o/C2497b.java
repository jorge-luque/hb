package com.criteo.publisher.p056o;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import com.criteo.publisher.p054a0.C2341p;
import java.lang.ref.WeakReference;
import java.util.List;

/* renamed from: com.criteo.publisher.o.b */
public class C2497b {

    /* renamed from: a */
    private final Context f7986a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public WeakReference<Activity> f7987b = new WeakReference<>((Object) null);

    /* renamed from: com.criteo.publisher.o.b$a */
    class C2498a extends C2496a {
        C2498a() {
        }

        public void onActivityPaused(Activity activity) {
            if (activity.equals(C2497b.this.f7987b.get())) {
                WeakReference unused = C2497b.this.f7987b = new WeakReference((Object) null);
            }
        }

        public void onActivityResumed(Activity activity) {
            WeakReference unused = C2497b.this.f7987b = new WeakReference(activity);
        }
    }

    public C2497b(Context context) {
        this.f7986a = context;
    }

    /* renamed from: a */
    public ComponentName mo10503a() {
        Activity activity = (Activity) this.f7987b.get();
        if (activity != null) {
            return activity.getComponentName();
        }
        ActivityManager activityManager = (ActivityManager) this.f7986a.getSystemService("activity");
        if (!C2341p.m8997a((Object) activityManager)) {
            return null;
        }
        try {
            List<ActivityManager.RunningTaskInfo> runningTasks = activityManager.getRunningTasks(1);
            if (runningTasks.isEmpty()) {
                return null;
            }
            ComponentName componentName = runningTasks.get(0).topActivity;
            if (componentName.getPackageName().startsWith(this.f7986a.getPackageName())) {
                return componentName;
            }
            return null;
        } catch (SecurityException e) {
            C2341p.m8996a((Throwable) e);
            return null;
        }
    }

    /* renamed from: a */
    public void mo10504a(Application application) {
        application.registerActivityLifecycleCallbacks(new C2498a());
    }
}
