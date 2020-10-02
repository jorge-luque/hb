package com.google.android.gms.internal.games;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.snapshot.Snapshot;
import com.google.android.gms.games.snapshot.SnapshotContents;
import com.google.android.gms.games.snapshot.Snapshots;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
final class zzcs implements Snapshots.OpenSnapshotResult {
    private final /* synthetic */ Status zzba;

    zzcs(zzcp zzcp, Status status) {
        this.zzba = status;
    }

    public final String getConflictId() {
        return null;
    }

    public final Snapshot getConflictingSnapshot() {
        return null;
    }

    public final SnapshotContents getResolutionSnapshotContents() {
        return null;
    }

    public final Snapshot getSnapshot() {
        return null;
    }

    public final Status getStatus() {
        return this.zzba;
    }
}
