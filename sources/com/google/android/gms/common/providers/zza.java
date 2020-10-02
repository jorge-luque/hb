package com.google.android.gms.common.providers;

import com.google.android.gms.common.providers.PooledExecutorsProvider;
import com.google.android.gms.internal.common.zze;
import com.google.android.gms.internal.common.zzj;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-basement@@17.2.0 */
final class zza implements PooledExecutorsProvider.PooledExecutorFactory {
    zza() {
    }

    public final ScheduledExecutorService newSingleThreadScheduledExecutor() {
        return zze.zzak().zza(1, zzj.zzjn);
    }
}
