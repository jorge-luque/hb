package com.google.android.gms.internal.games;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.snapshot.Snapshots;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
final class zzco implements Snapshots.DeleteSnapshotResult {
    private final /* synthetic */ Status zzba;

    zzco(zzcl zzcl, Status status) {
        this.zzba = status;
    }

    public final String getSnapshotId() {
        return null;
    }

    public final Status getStatus() {
        return this.zzba;
    }
}
