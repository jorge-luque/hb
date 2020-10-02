package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
final class zzqi implements zzqk {
    private final /* synthetic */ Activity val$activity;
    private final /* synthetic */ Bundle zzxu;

    zzqi(zzqc zzqc, Activity activity, Bundle bundle) {
        this.val$activity = activity;
        this.zzxu = bundle;
    }

    public final void zza(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        activityLifecycleCallbacks.onActivitySaveInstanceState(this.val$activity, this.zzxu);
    }
}
