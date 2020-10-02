package com.google.android.gms.games;

import android.content.Intent;
import android.os.RemoteException;
import com.google.android.gms.games.internal.zzg;
import com.google.android.gms.internal.games.zzar;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
final class zzbw extends zzar<Intent> {
    private final /* synthetic */ String zzeg;
    private final /* synthetic */ boolean zzeh;
    private final /* synthetic */ boolean zzei;
    private final /* synthetic */ int zzej;

    zzbw(SnapshotsClient snapshotsClient, String str, boolean z, boolean z2, int i) {
        this.zzeg = str;
        this.zzeh = z;
        this.zzei = z2;
        this.zzej = i;
    }

    /* access modifiers changed from: protected */
    public final void zza(zzg zzg, TaskCompletionSource<Intent> taskCompletionSource) throws RemoteException {
        taskCompletionSource.setResult(zzg.zza(this.zzeg, this.zzeh, this.zzei, this.zzej));
    }
}
