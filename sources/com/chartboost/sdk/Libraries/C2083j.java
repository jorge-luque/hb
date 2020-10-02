package com.chartboost.sdk.Libraries;

import android.app.Activity;
import com.chartboost.sdk.impl.C2166i1;
import java.lang.ref.WeakReference;

/* renamed from: com.chartboost.sdk.Libraries.j */
public final class C2083j extends WeakReference<Activity> {

    /* renamed from: a */
    public final int f6881a;

    public C2083j(Activity activity) {
        super(activity);
        C2166i1.m8610a("WeakActivity.WeakActivity", (Object) activity);
        this.f6881a = activity.hashCode();
    }

    /* renamed from: a */
    public boolean mo9112a(Activity activity) {
        return activity != null && activity.hashCode() == this.f6881a;
    }

    public int hashCode() {
        return this.f6881a;
    }
}
