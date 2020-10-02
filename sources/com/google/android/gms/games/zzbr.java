package com.google.android.gms.games;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.internal.PendingResultUtil;
import com.google.android.gms.games.SnapshotsClient;
import com.google.android.gms.games.snapshot.Snapshot;
import com.google.android.gms.games.snapshot.Snapshots;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
final class zzbr implements PendingResultUtil.ResultConverter<Snapshots.OpenSnapshotResult, SnapshotsClient.DataOrConflict<Snapshot>> {
    zzbr() {
    }

    public final /* synthetic */ Object convert(Result result) {
        Snapshots.OpenSnapshotResult openSnapshotResult = (Snapshots.OpenSnapshotResult) result;
        if (openSnapshotResult != null) {
            Snapshot snapshot = openSnapshotResult.getSnapshot() != null ? (Snapshot) openSnapshotResult.getSnapshot().freeze() : null;
            if (openSnapshotResult.getStatus().getStatusCode() == 0) {
                return new SnapshotsClient.DataOrConflict(snapshot, (SnapshotsClient.SnapshotConflict) null);
            }
            if (openSnapshotResult.getStatus().getStatusCode() == 4004) {
                SnapshotsClient.SnapshotConflict snapshotConflict = (snapshot == null || openSnapshotResult.getConflictId() == null || openSnapshotResult.getConflictingSnapshot() == null || openSnapshotResult.getResolutionSnapshotContents() == null) ? null : new SnapshotsClient.SnapshotConflict(snapshot, openSnapshotResult.getConflictId(), (Snapshot) openSnapshotResult.getConflictingSnapshot().freeze(), openSnapshotResult.getResolutionSnapshotContents());
                if (snapshotConflict != null) {
                    return new SnapshotsClient.DataOrConflict(null, snapshotConflict);
                }
            }
        }
        return null;
    }
}
