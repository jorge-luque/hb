package com.onesignal;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.view.ViewTreeObserver;
import com.ogury.p159cm.OguryChoiceManager;
import com.onesignal.C4516h1;
import com.onesignal.C4564n1;
import com.vungle.warren.AdLoader;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.onesignal.a */
/* compiled from: ActivityLifecycleHandler */
class C4461a {

    /* renamed from: a */
    static boolean f12255a;

    /* renamed from: b */
    private static Map<String, C4463b> f12256b = new ConcurrentHashMap();

    /* renamed from: c */
    private static Map<String, C4516h1.C4518b> f12257c = new ConcurrentHashMap();

    /* renamed from: d */
    private static Map<String, C4466e> f12258d = new ConcurrentHashMap();

    /* renamed from: e */
    static C4465d f12259e = new C4465d();
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: f */
    static Activity f12260f;

    /* renamed from: com.onesignal.a$b */
    /* compiled from: ActivityLifecycleHandler */
    static abstract class C4463b {
        C4463b() {
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo29683a(Activity activity) {
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo29690a(WeakReference<Activity> weakReference) {
        }
    }

    /* renamed from: com.onesignal.a$c */
    /* compiled from: ActivityLifecycleHandler */
    private static class C4464c implements Runnable {
        /* access modifiers changed from: private */

        /* renamed from: a */
        public boolean f12261a;
        /* access modifiers changed from: private */

        /* renamed from: b */
        public boolean f12262b;

        private C4464c() {
        }

        public void run() {
            if (C4461a.f12260f == null) {
                this.f12261a = true;
                C4564n1.m15808a0();
                this.f12262b = true;
            }
        }
    }

    /* renamed from: com.onesignal.a$e */
    /* compiled from: ActivityLifecycleHandler */
    private static class C4466e implements ViewTreeObserver.OnGlobalLayoutListener {

        /* renamed from: a */
        private final C4516h1.C4518b f12265a;

        /* renamed from: b */
        private final String f12266b;

        public void onGlobalLayout() {
            if (!C4543l1.m15665a((WeakReference<Activity>) new WeakReference(C4461a.f12260f))) {
                Activity activity = C4461a.f12260f;
                if (activity != null) {
                    ViewTreeObserver viewTreeObserver = activity.getWindow().getDecorView().getViewTreeObserver();
                    if (Build.VERSION.SDK_INT < 16) {
                        viewTreeObserver.removeGlobalOnLayoutListener(this);
                    } else {
                        viewTreeObserver.removeOnGlobalLayoutListener(this);
                    }
                }
                C4461a.m15380b(this.f12266b);
                this.f12265a.mo29782b();
            }
        }

        private C4466e(C4516h1.C4518b bVar, String str) {
            this.f12265a = bVar;
            this.f12266b = str;
        }
    }

    /* renamed from: a */
    static void m15373a(Activity activity) {
    }

    /* renamed from: a */
    static void m15377a(String str, C4516h1.C4518b bVar) {
        Activity activity = f12260f;
        if (activity != null) {
            ViewTreeObserver viewTreeObserver = activity.getWindow().getDecorView().getViewTreeObserver();
            C4466e eVar = new C4466e(bVar, str);
            viewTreeObserver.addOnGlobalLayoutListener(eVar);
            f12258d.put(str, eVar);
        }
        f12257c.put(str, bVar);
    }

    /* renamed from: b */
    static void m15380b(String str) {
        f12258d.remove(str);
        f12257c.remove(str);
    }

    /* renamed from: c */
    static void m15382c(Activity activity) {
        if (activity == f12260f) {
            f12260f = null;
            m15378b();
        }
        m15381c();
    }

    /* renamed from: d */
    static void m15384d(Activity activity) {
        m15387g(activity);
        m15381c();
        m15371a();
    }

    /* renamed from: e */
    static void m15385e(Activity activity) {
    }

    /* renamed from: f */
    static void m15386f(Activity activity) {
        C4564n1.C4566a0 a0Var = C4564n1.C4566a0.DEBUG;
        C4564n1.m15789a(a0Var, "onActivityStopped: " + activity);
        if (activity == f12260f) {
            f12260f = null;
            m15378b();
        }
        for (Map.Entry<String, C4463b> value : f12256b.entrySet()) {
            ((C4463b) value.getValue()).mo29690a((WeakReference<Activity>) new WeakReference(activity));
        }
        m15381c();
    }

    /* renamed from: g */
    private static void m15387g(Activity activity) {
        f12260f = activity;
        for (Map.Entry<String, C4463b> value : f12256b.entrySet()) {
            ((C4463b) value.getValue()).mo29683a(f12260f);
        }
        try {
            ViewTreeObserver viewTreeObserver = f12260f.getWindow().getDecorView().getViewTreeObserver();
            for (Map.Entry next : f12257c.entrySet()) {
                C4466e eVar = new C4466e((C4516h1.C4518b) next.getValue(), (String) next.getKey());
                viewTreeObserver.addOnGlobalLayoutListener(eVar);
                f12258d.put(next.getKey(), eVar);
            }
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
    }

    /* renamed from: b */
    static void m15379b(Activity activity) {
        C4564n1.C4566a0 a0Var = C4564n1.C4566a0.DEBUG;
        C4564n1.m15789a(a0Var, "onActivityDestroyed: " + activity);
        f12258d.clear();
        if (activity == f12260f) {
            f12260f = null;
            m15378b();
        }
        m15381c();
    }

    /* renamed from: com.onesignal.a$d */
    /* compiled from: ActivityLifecycleHandler */
    static class C4465d extends HandlerThread {

        /* renamed from: a */
        private Handler f12263a = new Handler(getLooper());

        /* renamed from: b */
        private C4464c f12264b;

        C4465d() {
            super("FocusHandlerThread");
            start();
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo29692a(C4464c cVar) {
            C4464c cVar2 = this.f12264b;
            if (cVar2 == null || !cVar2.f12261a || this.f12264b.f12262b) {
                this.f12264b = cVar;
                this.f12263a.removeCallbacksAndMessages((Object) null);
                this.f12263a.postDelayed(cVar, AdLoader.RETRY_DELAY);
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public void mo29694b() {
            C4464c cVar = this.f12264b;
            if (cVar != null) {
                boolean unused = cVar.f12261a = false;
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: c */
        public void mo29695c() {
            this.f12263a.removeCallbacksAndMessages((Object) null);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public boolean mo29693a() {
            C4464c cVar = this.f12264b;
            return cVar != null && cVar.f12261a;
        }
    }

    /* renamed from: d */
    private static void m15383d() {
        m15378b();
        for (Map.Entry<String, C4463b> value : f12256b.entrySet()) {
            ((C4463b) value.getValue()).mo29690a((WeakReference<Activity>) new WeakReference(f12260f));
        }
        for (Map.Entry<String, C4463b> value2 : f12256b.entrySet()) {
            ((C4463b) value2.getValue()).mo29683a(f12260f);
        }
        ViewTreeObserver viewTreeObserver = f12260f.getWindow().getDecorView().getViewTreeObserver();
        for (Map.Entry next : f12257c.entrySet()) {
            C4466e eVar = new C4466e((C4516h1.C4518b) next.getValue(), (String) next.getKey());
            viewTreeObserver.addOnGlobalLayoutListener(eVar);
            f12258d.put(next.getKey(), eVar);
        }
        m15371a();
    }

    /* renamed from: c */
    private static void m15381c() {
        String str;
        C4564n1.C4566a0 a0Var = C4564n1.C4566a0.DEBUG;
        StringBuilder sb = new StringBuilder();
        sb.append("curActivity is NOW: ");
        if (f12260f != null) {
            str = "" + f12260f.getClass().getName() + ":" + f12260f;
        } else {
            str = "null";
        }
        sb.append(str);
        C4564n1.m15789a(a0Var, sb.toString());
    }

    /* renamed from: a */
    static void m15376a(String str, C4463b bVar) {
        f12256b.put(str, bVar);
        Activity activity = f12260f;
        if (activity != null) {
            bVar.mo29683a(activity);
        }
    }

    /* renamed from: b */
    private static void m15378b() {
        f12259e.mo29692a(new C4464c());
    }

    /* renamed from: a */
    static void m15375a(String str) {
        f12256b.remove(str);
    }

    /* renamed from: a */
    static void m15374a(Configuration configuration) {
        Activity activity = f12260f;
        if (activity != null && C4536k1.m15625a(activity, (int) OguryChoiceManager.TcfV2.Purpose.MEASURE_AD_PERFORMANCE)) {
            m15372a(configuration.orientation);
            m15383d();
        }
    }

    /* renamed from: a */
    private static void m15372a(int i) {
        if (i == 2) {
            C4564n1.C4566a0 a0Var = C4564n1.C4566a0.DEBUG;
            C4564n1.m15815b(a0Var, "Configuration Orientation Change: LANDSCAPE (" + i + ")");
        } else if (i == 1) {
            C4564n1.C4566a0 a0Var2 = C4564n1.C4566a0.DEBUG;
            C4564n1.m15815b(a0Var2, "Configuration Orientation Change: PORTRAIT (" + i + ")");
        }
    }

    /* renamed from: a */
    private static void m15371a() {
        if (f12259e.mo29693a() || f12255a) {
            f12255a = false;
            f12259e.mo29694b();
            C4564n1.m15776Z();
            return;
        }
        f12259e.mo29695c();
    }
}
