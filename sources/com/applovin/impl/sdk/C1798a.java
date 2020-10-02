package com.applovin.impl.sdk;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import com.applovin.impl.sdk.utils.C1984a;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* renamed from: com.applovin.impl.sdk.a */
public class C1798a implements Application.ActivityLifecycleCallbacks {

    /* renamed from: a */
    private final List<C1984a> f5566a = Collections.synchronizedList(new ArrayList());

    /* renamed from: b */
    private WeakReference<Activity> f5567b = new WeakReference<>((Object) null);

    /* renamed from: c */
    private WeakReference<Activity> f5568c = new WeakReference<>((Object) null);

    public C1798a(Context context) {
        if (context instanceof Activity) {
            this.f5567b = new WeakReference<>((Activity) context);
        }
        ((Application) context.getApplicationContext()).registerActivityLifecycleCallbacks(this);
    }

    /* renamed from: a */
    public Activity mo8070a() {
        return (Activity) this.f5567b.get();
    }

    /* renamed from: a */
    public void mo8071a(C1984a aVar) {
        this.f5566a.add(aVar);
    }

    /* renamed from: b */
    public Activity mo8072b() {
        return (Activity) this.f5568c.get();
    }

    /* renamed from: b */
    public void mo8073b(C1984a aVar) {
        this.f5566a.remove(aVar);
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
        for (C1984a onActivityCreated : new ArrayList(this.f5566a)) {
            onActivityCreated.onActivityCreated(activity, bundle);
        }
    }

    public void onActivityDestroyed(Activity activity) {
        for (C1984a onActivityDestroyed : new ArrayList(this.f5566a)) {
            onActivityDestroyed.onActivityDestroyed(activity);
        }
    }

    public void onActivityPaused(Activity activity) {
        this.f5568c = new WeakReference<>((Object) null);
        for (C1984a onActivityPaused : new ArrayList(this.f5566a)) {
            onActivityPaused.onActivityPaused(activity);
        }
    }

    public void onActivityResumed(Activity activity) {
        WeakReference<Activity> weakReference = new WeakReference<>(activity);
        this.f5567b = weakReference;
        this.f5568c = weakReference;
        for (C1984a onActivityResumed : new ArrayList(this.f5566a)) {
            onActivityResumed.onActivityResumed(activity);
        }
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        for (C1984a onActivitySaveInstanceState : new ArrayList(this.f5566a)) {
            onActivitySaveInstanceState.onActivitySaveInstanceState(activity, bundle);
        }
    }

    public void onActivityStarted(Activity activity) {
        for (C1984a onActivityStarted : new ArrayList(this.f5566a)) {
            onActivityStarted.onActivityStarted(activity);
        }
    }

    public void onActivityStopped(Activity activity) {
        for (C1984a onActivityStopped : new ArrayList(this.f5566a)) {
            onActivityStopped.onActivityStopped(activity);
        }
    }
}
