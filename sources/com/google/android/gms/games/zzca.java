package com.google.android.gms.games;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.internal.PendingResultUtil;
import com.google.android.gms.games.snapshot.SnapshotMetadata;
import com.google.android.gms.games.snapshot.Snapshots;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
final class zzca implements PendingResultUtil.ResultConverter<Snapshots.CommitSnapshotResult, SnapshotMetadata> {
    zzca() {
    }

    public final /* synthetic */ Object convert(Result result) {
        SnapshotMetadata snapshotMetadata;
        Snapshots.CommitSnapshotResult commitSnapshotResult = (Snapshots.CommitSnapshotResult) result;
        if (commitSnapshotResult == null || (snapshotMetadata = commitSnapshotResult.getSnapshotMetadata()) == null) {
            return null;
        }
        return (SnapshotMetadata) snapshotMetadata.freeze();
    }
}
