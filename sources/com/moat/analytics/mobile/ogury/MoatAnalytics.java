package com.moat.analytics.mobile.ogury;

import android.app.Application;
import com.moat.analytics.mobile.ogury.NoOp;

public abstract class MoatAnalytics {

    /* renamed from: ॱ */
    private static MoatAnalytics f11479;

    public static synchronized MoatAnalytics getInstance() {
        MoatAnalytics moatAnalytics;
        synchronized (MoatAnalytics.class) {
            if (f11479 == null) {
                try {
                    f11479 = new C4328i();
                } catch (Exception e) {
                    C4332l.m14509(e);
                    f11479 = new NoOp.MoatAnalytics();
                }
            }
            moatAnalytics = f11479;
        }
        return moatAnalytics;
    }

    public abstract void prepareNativeDisplayTracking(String str);

    public abstract void start(Application application);

    public abstract void start(MoatOptions moatOptions, Application application);
}
