package com.google.android.gms.internal.games;

import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.games.AnnotatedData;
import com.google.android.gms.games.internal.zzg;
import com.google.android.gms.games.stats.PlayerStats;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
final /* synthetic */ class zzbr implements RemoteCall {
    private final boolean zzjz;

    zzbr(boolean z) {
        this.zzjz = z;
    }

    public final void accept(Object obj, Object obj2) {
        ((zzg) obj).zzb((TaskCompletionSource<AnnotatedData<PlayerStats>>) (TaskCompletionSource) obj2, this.zzjz);
    }
}
