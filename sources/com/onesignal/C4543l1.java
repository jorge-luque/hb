package com.onesignal;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.Window;
import android.view.WindowInsets;
import com.onesignal.C4461a;
import java.lang.ref.WeakReference;

/* renamed from: com.onesignal.l1 */
/* compiled from: OSViewUtils */
class C4543l1 {

    /* renamed from: a */
    private static final int f12423a = m15662a(24);

    /* renamed from: com.onesignal.l1$a */
    /* compiled from: OSViewUtils */
    static class C4544a implements Runnable {

        /* renamed from: a */
        final /* synthetic */ String f12424a;

        /* renamed from: b */
        final /* synthetic */ Runnable f12425b;

        /* renamed from: com.onesignal.l1$a$a */
        /* compiled from: OSViewUtils */
        class C4545a extends C4461a.C4463b {
            C4545a() {
            }

            /* access modifiers changed from: package-private */
            /* renamed from: a */
            public void mo29683a(Activity activity) {
                C4461a.m15375a(C4544a.this.f12424a);
                if (C4543l1.m15671g(activity)) {
                    C4544a.this.f12425b.run();
                } else {
                    C4543l1.m15664a(activity, C4544a.this.f12425b);
                }
            }
        }

        C4544a(String str, Runnable runnable) {
            this.f12424a = str;
            this.f12425b = runnable;
        }

        public void run() {
            C4461a.m15376a(this.f12424a, (C4461a.C4463b) new C4545a());
        }
    }

    /* renamed from: a */
    static boolean m15665a(WeakReference<Activity> weakReference) {
        View view;
        DisplayMetrics displayMetrics = new DisplayMetrics();
        Rect rect = new Rect();
        if (weakReference.get() != null) {
            Window window = ((Activity) weakReference.get()).getWindow();
            view = window.getDecorView();
            view.getWindowVisibleDisplayFrame(rect);
            window.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        } else {
            view = null;
        }
        if (view == null || displayMetrics.heightPixels - rect.bottom <= f12423a) {
            return false;
        }
        return true;
    }

    /* renamed from: b */
    static int m15666b(Activity activity) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 23) {
            return m15667c(activity);
        }
        if (i >= 21) {
            return m15668d(activity);
        }
        return m15663a(activity);
    }

    @TargetApi(23)
    /* renamed from: c */
    private static int m15667c(Activity activity) {
        View decorView = activity.getWindow().getDecorView();
        WindowInsets rootWindowInsets = decorView.getRootWindowInsets();
        if (rootWindowInsets == null) {
            return decorView.getHeight();
        }
        return (decorView.getHeight() - rootWindowInsets.getStableInsetBottom()) - rootWindowInsets.getStableInsetTop();
    }

    /* renamed from: d */
    private static int m15668d(Activity activity) {
        if (activity.getResources().getConfiguration().orientation == 2) {
            return m15669e(activity).height();
        }
        return m15663a(activity);
    }

    /* renamed from: e */
    private static Rect m15669e(Activity activity) {
        Rect rect = new Rect();
        activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
        return rect;
    }

    /* renamed from: f */
    static int m15670f(Activity activity) {
        return m15669e(activity).width();
    }

    /* renamed from: g */
    static boolean m15671g(Activity activity) {
        boolean z = activity.getWindow().getDecorView().getApplicationWindowToken() != null;
        if (Build.VERSION.SDK_INT < 23) {
            return z;
        }
        boolean z2 = activity.getWindow().getDecorView().getRootWindowInsets() != null;
        if (!z || !z2) {
            return false;
        }
        return true;
    }

    /* renamed from: a */
    static void m15664a(Activity activity, Runnable runnable) {
        activity.getWindow().getDecorView().post(new C4544a("decorViewReady:" + runnable, runnable));
    }

    /* renamed from: a */
    private static int m15663a(Activity activity) {
        Point point = new Point();
        activity.getWindowManager().getDefaultDisplay().getSize(point);
        return point.y;
    }

    /* renamed from: a */
    static int m15662a(int i) {
        return (int) (((float) i) * Resources.getSystem().getDisplayMetrics().density);
    }
}
