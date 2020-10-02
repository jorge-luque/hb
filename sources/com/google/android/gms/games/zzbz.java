package com.google.android.gms.games;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.internal.PendingResultUtil;
import com.google.android.gms.games.snapshot.Snapshots;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
final class zzbz implements PendingResultUtil.ResultConverter<Snapshots.OpenSnapshotResult, Snapshots.OpenSnapshotResult> {
    zzbz() {
    }

    public final /* synthetic */ Object convert(Result result) {
        return (Snapshots.OpenSnapshotResult) result;
    }
}
