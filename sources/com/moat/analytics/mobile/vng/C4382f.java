package com.moat.analytics.mobile.vng;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import com.google.android.gms.ads.AdActivity;
import com.moat.analytics.mobile.vng.C4424w;
import com.moat.analytics.mobile.vng.p156a.p158b.C4374a;
import java.lang.ref.WeakReference;

/* renamed from: com.moat.analytics.mobile.vng.f */
class C4382f {

    /* renamed from: a */
    private static WebAdTracker f11743a;

    /* renamed from: b */
    private static WeakReference<Activity> f11744b = new WeakReference<>((Object) null);

    C4382f() {
    }

    /* renamed from: a */
    private static void m14663a() {
        if (f11743a != null) {
            C4409p.m14772a(3, "GMAInterstitialHelper", f11744b.get(), "Stopping to track GMA interstitial");
            f11743a.stopTracking();
            f11743a = null;
        }
    }

    /* renamed from: a */
    static void m14664a(Activity activity) {
        try {
            if (C4424w.m14808a().f11856a != C4424w.C4432d.OFF) {
                if (!m14666b(activity)) {
                    m14663a();
                    f11744b = new WeakReference<>((Object) null);
                } else if (f11744b.get() == null || f11744b.get() != activity) {
                    View decorView = activity.getWindow().getDecorView();
                    if (decorView instanceof ViewGroup) {
                        C4374a<WebView> a = C4376ab.m14631a((ViewGroup) decorView, true);
                        if (a.mo29253c()) {
                            f11744b = new WeakReference<>(activity);
                            m14665a(a.mo29251b());
                            return;
                        }
                        C4409p.m14772a(3, "GMAInterstitialHelper", (Object) activity, "Sorry, no WebView in this activity");
                    }
                }
            }
        } catch (Exception e) {
            C4403n.m14758a(e);
        }
    }

    /* renamed from: a */
    private static void m14665a(WebView webView) {
        C4409p.m14772a(3, "GMAInterstitialHelper", f11744b.get(), "Starting to track GMA interstitial");
        WebAdTracker createWebAdTracker = MoatFactory.create().createWebAdTracker(webView);
        f11743a = createWebAdTracker;
        createWebAdTracker.startTracking();
    }

    /* renamed from: b */
    private static boolean m14666b(Activity activity) {
        String name = activity.getClass().getName();
        C4409p.m14772a(3, "GMAInterstitialHelper", (Object) activity, "Activity name: " + name);
        return name.contains(AdActivity.CLASS_NAME);
    }
}
