package com.google.android.gms.internal.games;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.games.internal.zzg;
import com.google.android.gms.games.snapshot.Snapshot;
import com.google.android.gms.games.snapshot.SnapshotMetadataChange;
import com.google.android.gms.games.snapshot.Snapshots;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
final class zzci extends zzcj {
    private final /* synthetic */ Snapshot zzef;
    private final /* synthetic */ SnapshotMetadataChange zzks;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzci(zzcd zzcd, GoogleApiClient googleApiClient, Snapshot snapshot, SnapshotMetadataChange snapshotMetadataChange) {
        super(googleApiClient, (zzcg) null);
        this.zzef = snapshot;
        this.zzks = snapshotMetadataChange;
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ void doExecute(Api.AnyClient anyClient) throws RemoteException {
        ((zzg) anyClient).zza((BaseImplementation.ResultHolder<Snapshots.CommitSnapshotResult>) this, this.zzef, this.zzks);
    }
}
