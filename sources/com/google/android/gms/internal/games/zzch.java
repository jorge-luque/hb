package com.google.android.gms.internal.games;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.games.internal.zzg;
import com.google.android.gms.games.snapshot.SnapshotMetadata;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
final class zzch extends zzcl {
    private final /* synthetic */ SnapshotMetadata zzkr;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzch(zzcd zzcd, GoogleApiClient googleApiClient, SnapshotMetadata snapshotMetadata) {
        super(googleApiClient, (zzcg) null);
        this.zzkr = snapshotMetadata;
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ void doExecute(Api.AnyClient anyClient) throws RemoteException {
        ((zzg) anyClient).zzh(this, this.zzkr.getSnapshotId());
    }
}
