package com.google.android.gms.games;

import android.os.RemoteException;
import com.google.android.gms.games.internal.zzg;
import com.google.android.gms.internal.games.zzar;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
final class zzcv extends zzar<Boolean> {
    zzcv(VideosClient videosClient) {
    }

    /* access modifiers changed from: protected */
    public final void zza(zzg zzg, TaskCompletionSource<Boolean> taskCompletionSource) throws RemoteException {
        taskCompletionSource.setResult(Boolean.valueOf(zzg.zzch()));
    }
}
