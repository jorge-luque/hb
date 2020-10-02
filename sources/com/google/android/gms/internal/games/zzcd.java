package com.google.android.gms.internal.games;

import android.content.Intent;
import android.os.Bundle;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.snapshot.Snapshot;
import com.google.android.gms.games.snapshot.SnapshotContents;
import com.google.android.gms.games.snapshot.SnapshotMetadata;
import com.google.android.gms.games.snapshot.SnapshotMetadataChange;
import com.google.android.gms.games.snapshot.Snapshots;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
public final class zzcd implements Snapshots {
    public final PendingResult<Snapshots.CommitSnapshotResult> commitAndClose(GoogleApiClient googleApiClient, Snapshot snapshot, SnapshotMetadataChange snapshotMetadataChange) {
        return googleApiClient.execute(new zzci(this, googleApiClient, snapshot, snapshotMetadataChange));
    }

    public final PendingResult<Snapshots.DeleteSnapshotResult> delete(GoogleApiClient googleApiClient, SnapshotMetadata snapshotMetadata) {
        return googleApiClient.execute(new zzch(this, googleApiClient, snapshotMetadata));
    }

    public final void discardAndClose(GoogleApiClient googleApiClient, Snapshot snapshot) {
        Games.zza(googleApiClient).zzb(snapshot);
    }

    public final int getMaxCoverImageSize(GoogleApiClient googleApiClient) {
        return Games.zza(googleApiClient).zzce();
    }

    public final int getMaxDataSize(GoogleApiClient googleApiClient) {
        return Games.zza(googleApiClient).zzcc();
    }

    public final Intent getSelectSnapshotIntent(GoogleApiClient googleApiClient, String str, boolean z, boolean z2, int i) {
        return Games.zza(googleApiClient).zzb(str, z, z2, i);
    }

    public final SnapshotMetadata getSnapshotFromBundle(Bundle bundle) {
        if (bundle == null || !bundle.containsKey("com.google.android.gms.games.SNAPSHOT_METADATA")) {
            return null;
        }
        return (SnapshotMetadata) bundle.getParcelable("com.google.android.gms.games.SNAPSHOT_METADATA");
    }

    public final PendingResult<Snapshots.LoadSnapshotsResult> load(GoogleApiClient googleApiClient, boolean z) {
        return googleApiClient.enqueue(new zzcg(this, googleApiClient, z));
    }

    public final PendingResult<Snapshots.OpenSnapshotResult> open(GoogleApiClient googleApiClient, SnapshotMetadata snapshotMetadata) {
        return open(googleApiClient, snapshotMetadata.getUniqueName(), false);
    }

    public final PendingResult<Snapshots.OpenSnapshotResult> resolveConflict(GoogleApiClient googleApiClient, String str, Snapshot snapshot) {
        SnapshotMetadata metadata = snapshot.getMetadata();
        return resolveConflict(googleApiClient, str, metadata.getSnapshotId(), new SnapshotMetadataChange.Builder().fromMetadata(metadata).build(), snapshot.getSnapshotContents());
    }

    public final PendingResult<Snapshots.OpenSnapshotResult> open(GoogleApiClient googleApiClient, SnapshotMetadata snapshotMetadata, int i) {
        return open(googleApiClient, snapshotMetadata.getUniqueName(), false, i);
    }

    public final PendingResult<Snapshots.OpenSnapshotResult> open(GoogleApiClient googleApiClient, String str, boolean z) {
        return open(googleApiClient, str, z, -1);
    }

    public final PendingResult<Snapshots.OpenSnapshotResult> open(GoogleApiClient googleApiClient, String str, boolean z, int i) {
        return googleApiClient.execute(new zzcf(this, googleApiClient, str, z, i));
    }

    public final PendingResult<Snapshots.OpenSnapshotResult> resolveConflict(GoogleApiClient googleApiClient, String str, String str2, SnapshotMetadataChange snapshotMetadataChange, SnapshotContents snapshotContents) {
        return googleApiClient.execute(new zzck(this, googleApiClient, str, str2, snapshotMetadataChange, snapshotContents));
    }
}
