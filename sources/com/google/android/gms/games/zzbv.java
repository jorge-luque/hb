package com.google.android.gms.games;

import android.os.RemoteException;
import com.google.android.gms.games.internal.zzg;
import com.google.android.gms.games.snapshot.Snapshot;
import com.google.android.gms.internal.games.zzar;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
final class zzbv extends zzar<Void> {
    private final /* synthetic */ Snapshot zzef;

    zzbv(SnapshotsClient snapshotsClient, Snapshot snapshot) {
        this.zzef = snapshot;
    }

    /* access modifiers changed from: protected */
    public final void zza(zzg zzg, TaskCompletionSource<Void> taskCompletionSource) throws RemoteException {
        zzg.zza(this.zzef);
        taskCompletionSource.setResult(null);
    }
}
