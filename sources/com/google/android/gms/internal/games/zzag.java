package com.google.android.gms.internal.games;

import android.os.RemoteException;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.games.internal.zzg;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
final /* synthetic */ class zzag implements RemoteCall {
    private final RemoteCall zzke;

    zzag(RemoteCall remoteCall) {
        this.zzke = remoteCall;
    }

    public final void accept(Object obj, Object obj2) {
        TaskCompletionSource taskCompletionSource = (TaskCompletionSource) obj2;
        try {
            this.zzke.accept((zzg) obj, taskCompletionSource);
        } catch (RemoteException | SecurityException e) {
            taskCompletionSource.trySetException(e);
        }
    }
}
