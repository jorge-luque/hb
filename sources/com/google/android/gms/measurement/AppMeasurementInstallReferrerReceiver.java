package com.google.android.gms.measurement;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.internal.measurement.zzac;

@KeepForSdk
@Deprecated
/* compiled from: com.google.android.gms:play-services-measurement-api@@17.4.1 */
public final class AppMeasurementInstallReferrerReceiver extends BroadcastReceiver {
    public final BroadcastReceiver.PendingResult doGoAsync() {
        return goAsync();
    }

    public final void doStartService(Context context, Intent intent) {
    }

    public final void onReceive(Context context, Intent intent) {
        if (zzac.zzb(context)) {
            zzac.zza(context).zza(5, "Install Referrer Broadcast deprecated", (Object) null, (Object) null, (Object) null);
        } else {
            Log.w("FA", "Install Referrer Broadcast deprecated");
        }
    }
}
