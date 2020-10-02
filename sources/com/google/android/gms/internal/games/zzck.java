package com.google.android.gms.internal.games;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.games.internal.zzg;
import com.google.android.gms.games.snapshot.SnapshotContents;
import com.google.android.gms.games.snapshot.SnapshotMetadataChange;
import com.google.android.gms.games.snapshot.Snapshots;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
final class zzck extends zzcp {
    private final /* synthetic */ SnapshotMetadataChange zzks;
    private final /* synthetic */ String zzkt;
    private final /* synthetic */ String zzku;
    private final /* synthetic */ SnapshotContents zzkv;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzck(zzcd zzcd, GoogleApiClient googleApiClient, String str, String str2, SnapshotMetadataChange snapshotMetadataChange, SnapshotContents snapshotContents) {
        super(googleApiClient, (zzcg) null);
        this.zzkt = str;
        this.zzku = str2;
        this.zzks = snapshotMetadataChange;
        this.zzkv = snapshotContents;
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ void doExecute(Api.AnyClient anyClient) throws RemoteException {
        ((zzg) anyClient).zza((BaseImplementation.ResultHolder<Snapshots.OpenSnapshotResult>) this, this.zzkt, this.zzku, this.zzks, this.zzkv);
    }
}
