package com.moat.analytics.mobile.ogury;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import com.google.android.gms.ads.AdActivity;
import com.moat.analytics.mobile.ogury.C4315e;
import com.moat.analytics.mobile.ogury.C4346q;
import com.moat.analytics.mobile.ogury.base.functional.Optional;
import java.lang.ref.WeakReference;

/* renamed from: com.moat.analytics.mobile.ogury.b */
final class C4309b {

    /* renamed from: ˊ */
    private static WeakReference<Activity> f11488 = new WeakReference<>((Object) null);

    /* renamed from: ˏ */
    private static WebAdTracker f11489;

    C4309b() {
    }

    /* renamed from: ˋ */
    static void m14413(Activity activity) {
        try {
            if (C4346q.m14542().f11640 != C4346q.C4354e.f11656) {
                String name = activity.getClass().getName();
                C4315e.C43161.m14442(3, "GMAInterstitialHelper", activity, "Activity name: ".concat(String.valueOf(name)));
                if (!name.contains(AdActivity.CLASS_NAME)) {
                    if (f11489 != null) {
                        C4315e.C43161.m14442(3, "GMAInterstitialHelper", f11488.get(), "Stopping to track GMA interstitial");
                        f11489.stopTracking();
                        f11489 = null;
                    }
                    f11488 = new WeakReference<>((Object) null);
                } else if (f11488.get() == null || f11488.get() != activity) {
                    View decorView = activity.getWindow().getDecorView();
                    if (decorView instanceof ViewGroup) {
                        Optional<WebView> r1 = C4361u.m14587((ViewGroup) decorView, true);
                        if (r1.isPresent()) {
                            f11488 = new WeakReference<>(activity);
                            C4315e.C43161.m14442(3, "GMAInterstitialHelper", f11488.get(), "Starting to track GMA interstitial");
                            WebAdTracker createWebAdTracker = MoatFactory.create().createWebAdTracker(r1.get());
                            f11489 = createWebAdTracker;
                            createWebAdTracker.startTracking();
                            return;
                        }
                        C4315e.C43161.m14442(3, "GMAInterstitialHelper", activity, "Sorry, no WebView in this activity");
                    }
                }
            }
        } catch (Exception e) {
            C4332l.m14509(e);
        }
    }
}
