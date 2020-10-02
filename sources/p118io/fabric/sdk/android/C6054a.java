package p118io.fabric.sdk.android;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import java.util.HashSet;
import java.util.Set;

/* renamed from: io.fabric.sdk.android.a */
/* compiled from: ActivityLifecycleManager */
public class C6054a {

    /* renamed from: a */
    private final Application f15953a;

    /* renamed from: b */
    private C6055a f15954b;

    /* renamed from: io.fabric.sdk.android.a$b */
    /* compiled from: ActivityLifecycleManager */
    public static abstract class C6057b {
        public abstract void onActivityCreated(Activity activity, Bundle bundle);

        public void onActivityDestroyed(Activity activity) {
        }

        public void onActivityPaused(Activity activity) {
        }

        public abstract void onActivityResumed(Activity activity);

        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        public abstract void onActivityStarted(Activity activity);

        public void onActivityStopped(Activity activity) {
        }
    }

    public C6054a(Context context) {
        Application application = (Application) context.getApplicationContext();
        this.f15953a = application;
        if (Build.VERSION.SDK_INT >= 14) {
            this.f15954b = new C6055a(application);
        }
    }

    /* renamed from: a */
    public boolean mo34076a(C6057b bVar) {
        C6055a aVar = this.f15954b;
        return aVar != null && aVar.m19606a(bVar);
    }

    /* renamed from: io.fabric.sdk.android.a$a */
    /* compiled from: ActivityLifecycleManager */
    private static class C6055a {

        /* renamed from: a */
        private final Set<Application.ActivityLifecycleCallbacks> f15955a = new HashSet();

        /* renamed from: b */
        private final Application f15956b;

        /* renamed from: io.fabric.sdk.android.a$a$a */
        /* compiled from: ActivityLifecycleManager */
        class C6056a implements Application.ActivityLifecycleCallbacks {

            /* renamed from: a */
            final /* synthetic */ C6057b f15957a;

            C6056a(C6055a aVar, C6057b bVar) {
                this.f15957a = bVar;
            }

            public void onActivityCreated(Activity activity, Bundle bundle) {
                this.f15957a.onActivityCreated(activity, bundle);
            }

            public void onActivityDestroyed(Activity activity) {
                this.f15957a.onActivityDestroyed(activity);
            }

            public void onActivityPaused(Activity activity) {
                this.f15957a.onActivityPaused(activity);
            }

            public void onActivityResumed(Activity activity) {
                this.f15957a.onActivityResumed(activity);
            }

            public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
                this.f15957a.onActivitySaveInstanceState(activity, bundle);
            }

            public void onActivityStarted(Activity activity) {
                this.f15957a.onActivityStarted(activity);
            }

            public void onActivityStopped(Activity activity) {
                this.f15957a.onActivityStopped(activity);
            }
        }

        C6055a(Application application) {
            this.f15956b = application;
        }

        /* access modifiers changed from: private */
        @TargetApi(14)
        /* renamed from: a */
        public void m19603a() {
            for (Application.ActivityLifecycleCallbacks unregisterActivityLifecycleCallbacks : this.f15955a) {
                this.f15956b.unregisterActivityLifecycleCallbacks(unregisterActivityLifecycleCallbacks);
            }
        }

        /* access modifiers changed from: private */
        @TargetApi(14)
        /* renamed from: a */
        public boolean m19606a(C6057b bVar) {
            if (this.f15956b == null) {
                return false;
            }
            C6056a aVar = new C6056a(this, bVar);
            this.f15956b.registerActivityLifecycleCallbacks(aVar);
            this.f15955a.add(aVar);
            return true;
        }
    }

    /* renamed from: a */
    public void mo34075a() {
        C6055a aVar = this.f15954b;
        if (aVar != null) {
            aVar.m19603a();
        }
    }
}
