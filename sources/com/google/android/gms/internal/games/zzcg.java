package com.google.android.gms.internal.games;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.games.internal.zzg;
import com.google.android.gms.games.snapshot.Snapshots;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
final class zzcg extends zzcn {
    private final /* synthetic */ boolean zzkb;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzcg(zzcd zzcd, GoogleApiClient googleApiClient, boolean z) {
        super(googleApiClient, (zzcg) null);
        this.zzkb = z;
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ void doExecute(Api.AnyClient anyClient) throws RemoteException {
        ((zzg) anyClient).zzf((BaseImplementation.ResultHolder<Snapshots.LoadSnapshotsResult>) this, this.zzkb);
    }
}
