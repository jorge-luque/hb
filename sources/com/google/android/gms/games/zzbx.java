package com.google.android.gms.games;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.internal.PendingResultUtil;
import com.google.android.gms.games.snapshot.Snapshots;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
final class zzbx implements PendingResultUtil.ResultConverter<Snapshots.DeleteSnapshotResult, String> {
    zzbx() {
    }

    public final /* synthetic */ Object convert(Result result) {
        Snapshots.DeleteSnapshotResult deleteSnapshotResult = (Snapshots.DeleteSnapshotResult) result;
        if (deleteSnapshotResult == null) {
            return null;
        }
        return deleteSnapshotResult.getSnapshotId();
    }
}
