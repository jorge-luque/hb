package com.google.android.gms.games;

import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.games.internal.zzg;
import com.google.android.gms.internal.games.zzar;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
final class zzi extends zzar<Void> {
    private final /* synthetic */ View zzbb;

    zzi(GamesClient gamesClient, View view) {
        this.zzbb = view;
    }

    /* access modifiers changed from: protected */
    public final void zza(zzg zzg, TaskCompletionSource<Void> taskCompletionSource) throws RemoteException {
        zzg.zza(this.zzbb);
        taskCompletionSource.setResult(null);
    }
}
