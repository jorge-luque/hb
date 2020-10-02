package com.moat.analytics.mobile.vng;

import android.app.Application;
import com.moat.analytics.mobile.vng.C4418v;

public abstract class MoatAnalytics {

    /* renamed from: a */
    private static MoatAnalytics f11709a;

    public static synchronized MoatAnalytics getInstance() {
        MoatAnalytics moatAnalytics;
        synchronized (MoatAnalytics.class) {
            if (f11709a == null) {
                try {
                    f11709a = new C4400k();
                } catch (Exception e) {
                    C4403n.m14758a(e);
                    f11709a = new C4418v.C4419a();
                }
            }
            moatAnalytics = f11709a;
        }
        return moatAnalytics;
    }

    public abstract void prepareNativeDisplayTracking(String str);

    public abstract void start(Application application);

    public abstract void start(MoatOptions moatOptions, Application application);
}
