package com.google.android.gms.measurement;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.measurement.internal.zzfp;
import com.google.android.gms.measurement.internal.zzfs;
import p075d.p088f.p089a.C3217a;

/* compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
public final class AppMeasurementReceiver extends C3217a implements zzfs {
    private zzfp zza;

    public final BroadcastReceiver.PendingResult doGoAsync() {
        return goAsync();
    }

    public final void doStartService(Context context, Intent intent) {
        C3217a.startWakefulService(context, intent);
    }

    public final void onReceive(Context context, Intent intent) {
        if (this.zza == null) {
            this.zza = new zzfp(this);
        }
        this.zza.zza(context, intent);
    }
}
