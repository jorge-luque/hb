package com.google.android.gms.games;

import android.os.RemoteException;
import com.google.android.gms.games.internal.zzg;
import com.google.android.gms.internal.games.zzar;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
final class zza extends zzar<Void> {
    private final /* synthetic */ String zzf;
    private final /* synthetic */ int zzg;

    zza(EventsClient eventsClient, String str, int i) {
        this.zzf = str;
        this.zzg = i;
    }

    /* access modifiers changed from: protected */
    public final void zza(zzg zzg2, TaskCompletionSource<Void> taskCompletionSource) throws RemoteException {
        zzg2.zza(this.zzf, this.zzg);
    }
}
