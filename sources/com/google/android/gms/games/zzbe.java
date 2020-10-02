package com.google.android.gms.games;

import android.os.RemoteException;
import com.google.android.gms.games.internal.zzg;
import com.google.android.gms.internal.games.zzar;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
final class zzbe extends zzar<Void> {
    private final /* synthetic */ String zzdn;

    zzbe(RealTimeMultiplayerClient realTimeMultiplayerClient, String str) {
        this.zzdn = str;
    }

    /* access modifiers changed from: protected */
    public final void zza(zzg zzg, TaskCompletionSource<Void> taskCompletionSource) throws RemoteException {
        zzg.zzd(this.zzdn, 0);
        taskCompletionSource.setResult(null);
    }
}
