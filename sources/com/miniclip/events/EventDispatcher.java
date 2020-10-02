package com.miniclip.events;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.content.ComponentCallbacks2;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import com.miniclip.framework.AbstractActivityListener;
import com.miniclip.framework.Miniclip;
import com.miniclip.framework.ThreadingContext;
import java.util.HashSet;
import java.util.Set;

public class EventDispatcher extends AbstractActivityListener {
    private static EventDispatcher instance = new EventDispatcher();

    /* renamed from: com.miniclip.events.EventDispatcher$a */
    static class C4268a implements ComponentCallbacks2 {

        /* renamed from: com.miniclip.events.EventDispatcher$a$a */
        class C4269a implements Runnable {

            /* renamed from: a */
            final /* synthetic */ int f11429a;

            C4269a(C4268a aVar, int i) {
                this.f11429a = i;
            }

            public void run() {
                EventDispatcher.onTrimMemoryNative(this.f11429a);
            }
        }

        C4268a() {
        }

        public void onConfigurationChanged(Configuration configuration) {
        }

        public void onLowMemory() {
        }

        public void onTrimMemory(int i) {
            "LOW MEMORY - onTrimMemory level " + i;
            Miniclip.queueEvent(ThreadingContext.Main, new C4269a(this, i));
        }
    }

    @TargetApi(14)
    /* renamed from: com.miniclip.events.EventDispatcher$b */
    private class C4270b implements Application.ActivityLifecycleCallbacks {

        /* renamed from: a */
        private Set<Activity> f11430a;

        C4270b(EventDispatcher eventDispatcher) {
            HashSet hashSet = new HashSet();
            this.f11430a = hashSet;
            hashSet.add(Miniclip.getActivity());
        }

        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        public void onActivityDestroyed(Activity activity) {
        }

        public void onActivityPaused(Activity activity) {
        }

        public void onActivityResumed(Activity activity) {
        }

        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        public void onActivityStarted(Activity activity) {
            if (this.f11430a.size() == 0) {
                EventDispatcher.onAppEnterForegroundNative();
            }
            this.f11430a.add(activity);
        }

        public void onActivityStopped(Activity activity) {
            this.f11430a.remove(activity);
            if (this.f11430a.size() == 0) {
                EventDispatcher.onAppEnterBackgroundNative();
            }
        }
    }

    private EventDispatcher() {
    }

    /* access modifiers changed from: private */
    public static native void onAppEnterBackgroundNative();

    /* access modifiers changed from: private */
    public static native void onAppEnterForegroundNative();

    private static native void onPauseNative();

    private static native void onResumeNative();

    private static native void onStartNative();

    private static native void onStopNative();

    /* access modifiers changed from: private */
    public static native void onTrimMemoryNative(int i);

    public static void registerForApplicationEvents() {
        Miniclip.addListener(instance);
        if (Build.VERSION.SDK_INT >= 14) {
            Application application = Miniclip.getActivity().getApplication();
            EventDispatcher eventDispatcher = instance;
            eventDispatcher.getClass();
            application.registerActivityLifecycleCallbacks(new C4270b(eventDispatcher));
            application.registerComponentCallbacks(new C4268a());
        }
    }

    public void onPause() {
        onPauseNative();
    }

    public void onResume() {
        onResumeNative();
    }

    public void onStart() {
        onStartNative();
    }

    public void onStop() {
        onStopNative();
    }
}
