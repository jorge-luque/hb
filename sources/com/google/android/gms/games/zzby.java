package com.google.android.gms.games;

import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.ApiExceptionUtil;
import com.google.android.gms.games.SnapshotsClient;
import com.google.android.gms.games.internal.zzbg;
import com.google.android.gms.games.snapshot.SnapshotMetadata;
import com.google.android.gms.games.snapshot.Snapshots;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
final class zzby implements zzbg<Snapshots.OpenSnapshotResult> {
    zzby() {
    }

    public final /* synthetic */ ApiException zza(Status status, Object obj) {
        Snapshots.OpenSnapshotResult openSnapshotResult = (Snapshots.OpenSnapshotResult) obj;
        if (status.getStatusCode() != 26572 || openSnapshotResult.getSnapshot() == null || openSnapshotResult.getSnapshot().getMetadata() == null) {
            return ApiExceptionUtil.fromStatus(status);
        }
        return new SnapshotsClient.SnapshotContentUnavailableApiException(status, (SnapshotMetadata) openSnapshotResult.getSnapshot().getMetadata().freeze());
    }
}
