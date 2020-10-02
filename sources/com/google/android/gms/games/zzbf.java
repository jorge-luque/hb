package com.google.android.gms.games;

import com.google.android.gms.common.api.internal.TaskUtil;
import com.google.android.gms.games.internal.zzb;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
final class zzbf extends zzb {
    private final /* synthetic */ TaskCompletionSource zzdo;

    zzbf(zzbg zzbg, TaskCompletionSource taskCompletionSource) {
        this.zzdo = taskCompletionSource;
    }

    public final void onLeftRoom(int i, String str) {
        TaskUtil.setResultOrApiException(GamesClientStatusCodes.zza(GamesClientStatusCodes.zzb(i)), str, this.zzdo);
    }
}
