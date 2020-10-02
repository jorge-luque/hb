package com.google.android.gms.games;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.internal.PendingResultUtil;
import com.google.android.gms.games.snapshot.SnapshotMetadataBuffer;
import com.google.android.gms.games.snapshot.Snapshots;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
final class zzbu implements PendingResultUtil.ResultConverter<Snapshots.LoadSnapshotsResult, SnapshotMetadataBuffer> {
    zzbu() {
    }

    public final /* synthetic */ Object convert(Result result) {
        Snapshots.LoadSnapshotsResult loadSnapshotsResult = (Snapshots.LoadSnapshotsResult) result;
        if (loadSnapshotsResult == null) {
            return null;
        }
        return loadSnapshotsResult.getSnapshots();
    }
}
