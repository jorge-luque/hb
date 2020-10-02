package com.google.android.gms.internal.games;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.snapshot.SnapshotMetadata;
import com.google.android.gms.games.snapshot.Snapshots;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
final class zzcm implements Snapshots.CommitSnapshotResult {
    private final /* synthetic */ Status zzba;

    zzcm(zzcj zzcj, Status status) {
        this.zzba = status;
    }

    public final SnapshotMetadata getSnapshotMetadata() {
        return null;
    }

    public final Status getStatus() {
        return this.zzba;
    }
}
