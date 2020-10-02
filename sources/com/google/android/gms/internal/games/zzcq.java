package com.google.android.gms.internal.games;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.snapshot.SnapshotMetadataBuffer;
import com.google.android.gms.games.snapshot.Snapshots;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
final class zzcq implements Snapshots.LoadSnapshotsResult {
    private final /* synthetic */ Status zzba;

    zzcq(zzcn zzcn, Status status) {
        this.zzba = status;
    }

    public final SnapshotMetadataBuffer getSnapshots() {
        return new SnapshotMetadataBuffer(DataHolder.empty(14));
    }

    public final Status getStatus() {
        return this.zzba;
    }

    public final void release() {
    }
}
