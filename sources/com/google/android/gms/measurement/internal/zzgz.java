package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.measurement.zzaa;

@VisibleForTesting
/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
public final class zzgz {
    final Context zza;
    String zzb;
    String zzc;
    String zzd;
    Boolean zze;
    long zzf;
    zzaa zzg;
    boolean zzh = true;
    Long zzi;

    @VisibleForTesting
    public zzgz(Context context, zzaa zzaa, Long l) {
        Preconditions.checkNotNull(context);
        Context applicationContext = context.getApplicationContext();
        Preconditions.checkNotNull(applicationContext);
        this.zza = applicationContext;
        this.zzi = l;
        if (zzaa != null) {
            this.zzg = zzaa;
            this.zzb = zzaa.zzf;
            this.zzc = zzaa.zze;
            this.zzd = zzaa.zzd;
            this.zzh = zzaa.zzc;
            this.zzf = zzaa.zzb;
            Bundle bundle = zzaa.zzg;
            if (bundle != null) {
                this.zze = Boolean.valueOf(bundle.getBoolean("dataCollectionDefaultEnabled", true));
            }
        }
    }
}
