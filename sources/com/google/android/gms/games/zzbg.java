package com.google.android.gms.games;

import android.os.RemoteException;
import com.google.android.gms.games.internal.zzbn;
import com.google.android.gms.games.internal.zzbr;
import com.google.android.gms.games.internal.zzg;
import com.google.android.gms.internal.games.zzar;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
final class zzbg extends zzar<String> {
    private final /* synthetic */ String zzdi;

    zzbg(RealTimeMultiplayerClient realTimeMultiplayerClient, String str) {
        this.zzdi = str;
    }

    /* access modifiers changed from: protected */
    public final void zza(zzg zzg, TaskCompletionSource<String> taskCompletionSource) throws RemoteException {
        ((zzbr) zzg.getService()).zza((zzbn) new zzbf(this, taskCompletionSource), this.zzdi);
    }
}
