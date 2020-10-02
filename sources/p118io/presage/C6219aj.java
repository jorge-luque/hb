package p118io.presage;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import java.lang.ref.WeakReference;

/* renamed from: io.presage.aj */
public final class C6219aj {

    /* renamed from: a */
    public static final C6219aj f16747a = new C6219aj();
    /* access modifiers changed from: private */

    /* renamed from: b */
    public static WeakReference<Activity> f16748b = new WeakReference<>((Object) null);

    /* renamed from: c */
    private static boolean f16749c;

    /* renamed from: io.presage.aj$CamembertauCalvados */
    public static final class CamembertauCalvados extends GrandMunster {
        CamembertauCalvados() {
        }

        public final void onActivityResumed(Activity activity) {
            C6219aj ajVar = C6219aj.f16747a;
            C6219aj.f16748b = new WeakReference(activity);
        }
    }

    private C6219aj() {
    }

    /* renamed from: a */
    public static Activity m20783a() {
        return (Activity) f16748b.get();
    }

    /* renamed from: a */
    public final synchronized void mo34731a(Context context) {
        if (!f16749c) {
            Context applicationContext = context.getApplicationContext();
            if (!(applicationContext instanceof Application)) {
                applicationContext = null;
            }
            Application application = (Application) applicationContext;
            if (application != null) {
                f16749c = true;
                application.registerActivityLifecycleCallbacks(new CamembertauCalvados());
            }
        }
    }
}
