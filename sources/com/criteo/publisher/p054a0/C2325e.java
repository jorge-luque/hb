package com.criteo.publisher.p054a0;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.criteo.publisher.C2376b;
import com.criteo.publisher.p053a.C2320a;

/* renamed from: com.criteo.publisher.a0.e */
public class C2325e implements Application.ActivityLifecycleCallbacks {

    /* renamed from: a */
    private final C2320a f7676a;

    /* renamed from: b */
    private final C2376b f7677b;

    /* renamed from: c */
    private int f7678c = 0;

    /* renamed from: d */
    private int f7679d = 0;

    /* renamed from: e */
    private boolean f7680e = false;

    /* renamed from: f */
    private boolean f7681f = false;

    public C2325e(C2320a aVar, C2376b bVar) {
        this.f7676a = aVar;
        this.f7677b = bVar;
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
        if (!this.f7681f) {
            this.f7681f = true;
            this.f7676a.mo10114d();
        }
    }

    public void onActivityDestroyed(Activity activity) {
    }

    public void onActivityPaused(Activity activity) {
        this.f7680e = true;
        this.f7679d--;
    }

    public void onActivityResumed(Activity activity) {
        if (this.f7679d == 0 && !this.f7680e) {
            this.f7676a.mo10112b();
        }
        this.f7680e = false;
        this.f7679d++;
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public void onActivityStarted(Activity activity) {
        this.f7678c++;
    }

    public void onActivityStopped(Activity activity) {
        if (this.f7678c == 1) {
            if (this.f7680e && this.f7679d == 0) {
                this.f7676a.mo10113c();
            }
            this.f7676a.mo10110a();
            this.f7677b.mo10233a();
        }
        this.f7680e = false;
        this.f7678c--;
    }
}
