package p118io.presage.core;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import java.util.List;

/* renamed from: io.presage.core.IlIIlIlI */
public class IlIIlIlI extends IIllllll {
    public static final String IIIlIIlI = lllllIlI.IIIIIIII;
    public static final String IIIlIIll = lllllIlI.IIIIIIIl;
    public static final String IIIlIlII = lllllIlI.IIIIIIlI;
    public static final String IIIlIlIl = lllllIlI.IIIIIIll;
    public static final String IIIlIllI = lllllIlI.IIIIIlII;
    public static final String IIIlIlll = lllllIlI.IIIIIlIl;
    public static final String IIIllIII = C6347r.IIIIIIlI;
    public final Application.ActivityLifecycleCallbacks IIIIlllI = new IIIIIIII();
    public boolean IIIIllll = false;
    public long IIIlIIII;
    public String IIIlIIIl;

    /* renamed from: io.presage.core.IlIIlIlI$IIIIIIII */
    public class IIIIIIII implements Application.ActivityLifecycleCallbacks {
        public IIIIIIII() {
        }

        public void onActivityCreated(Activity activity, Bundle bundle) {
            IlIIlIlI.this.IIIIIIII(new IIIlIlIl(System.currentTimeMillis(), IlIIlIlI.IIIlIlIl, IlIIlIlI.this.IIIIIIII(activity.getComponentName())));
        }

        public void onActivityDestroyed(Activity activity) {
            IlIIlIlI.this.IIIIIIII(new IIIlIlIl(System.currentTimeMillis(), IlIIlIlI.IIIlIlll, IlIIlIlI.this.IIIIIIII(activity.getComponentName())));
        }

        public void onActivityPaused(Activity activity) {
            IlIIlIlI ilIIlIlI = IlIIlIlI.this;
            if (ilIIlIlI.IIIIllll) {
                boolean unused = ilIIlIlI.IIIIllll = false;
                IlIIlIlI ilIIlIlI2 = IlIIlIlI.this;
                ilIIlIlI2.IIIIIIII(new IIIlIlIl(ilIIlIlI2.IIIlIIII, IlIIlIlI.IIIlIlII, ilIIlIlI2.IIIlIIIl));
                IlIIlIlI ilIIlIlI3 = IlIIlIlI.this;
                ilIIlIlI3.IIIIIIII(new IIIlIlIl(ilIIlIlI3.IIIlIIII, IlIIlIlI.IIIlIIlI, ilIIlIlI3.IIIlIIIl));
            }
            IlIIlIlI.this.IIIIIIII(new IIIlIlIl(System.currentTimeMillis(), IlIIlIlI.IIIlIIll, IlIIlIlI.this.IIIIIIII(activity.getComponentName())));
        }

        public void onActivityResumed(Activity activity) {
            IlIIlIlI.this.IIIIIIII(new IIIlIlIl(System.currentTimeMillis(), IlIIlIlI.IIIlIIlI, IlIIlIlI.this.IIIIIIII(activity.getComponentName())));
        }

        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        public void onActivityStarted(Activity activity) {
            boolean unused = IlIIlIlI.this.IIIIllll = false;
            IlIIlIlI.this.IIIIIIII(new IIIlIlIl(System.currentTimeMillis(), IlIIlIlI.IIIlIlII, IlIIlIlI.this.IIIIIIII(activity.getComponentName())));
        }

        public void onActivityStopped(Activity activity) {
            IlIIlIlI.this.IIIIIIII(new IIIlIlIl(System.currentTimeMillis(), IlIIlIlI.IIIlIllI, IlIIlIlI.this.IIIIIIII(activity.getComponentName())));
        }
    }

    /* renamed from: io.presage.core.IlIIlIlI$IIIIIIIl */
    public class IIIIIIIl implements Runnable {
        public final /* synthetic */ IIIlIlIl IIIIIIII;

        public IIIIIIIl(IIIlIlIl iIIlIlIl) {
            this.IIIIIIII = iIIlIlIl;
        }

        public void run() {
            IlIIlIlI.this.IIIIIIII((IIIlIIlI) this.IIIIIIII);
        }
    }

    public IlIIlIlI(Context context, int i, long j, long j2) {
        super(context, i, j, j2);
    }

    public int IIIIIIII() {
        return 20;
    }

    public final String IIIIIIII(ComponentName componentName) {
        return componentName.getPackageName() + IIIllIII + componentName.getClassName();
    }

    public final void IIIIIIII(IIIlIlIl iIIlIlIl) {
        IIIIIIII((Runnable) new IIIIIIIl(iIIlIlIl));
    }

    public Object IIIIIIll() {
        return IlIIlIlI.class;
    }

    public void IIIIIlIl() {
        ActivityManager activityManager;
        List<ActivityManager.RunningTaskInfo> runningTasks;
        if (!((Build.VERSION.SDK_INT < 21 && !IIIIlIll.IIIIIIII(this.IIIIIIlI, "android.permission.GET_TASKS")) || (activityManager = (ActivityManager) this.IIIIIIlI.getSystemService("activity")) == null || (runningTasks = activityManager.getRunningTasks(Integer.MAX_VALUE)) == null || runningTasks.isEmpty() || runningTasks.get(0) == null || runningTasks.get(0).topActivity == null || runningTasks.get(0).topActivity.getPackageName() == null || !runningTasks.get(0).topActivity.getPackageName().equals(this.IIIIIIlI.getPackageName()))) {
            this.IIIIllll = true;
            this.IIIlIIII = System.currentTimeMillis();
            String packageName = runningTasks.get(0).topActivity.getPackageName();
            String className = runningTasks.get(0).topActivity.getClassName();
            this.IIIlIIIl = packageName + IIIllIII + className;
        }
        ((Application) this.IIIIIIlI.getApplicationContext()).registerActivityLifecycleCallbacks(this.IIIIlllI);
    }

    public void IIIIIllI() {
        ((Application) this.IIIIIIlI.getApplicationContext()).unregisterActivityLifecycleCallbacks(this.IIIIlllI);
    }
}
