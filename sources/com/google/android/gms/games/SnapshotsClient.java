package com.google.android.gms.games;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.PendingResultUtil;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.internal.zzbb;
import com.google.android.gms.games.internal.zzbg;
import com.google.android.gms.games.internal.zzbi;
import com.google.android.gms.games.snapshot.Snapshot;
import com.google.android.gms.games.snapshot.SnapshotContents;
import com.google.android.gms.games.snapshot.SnapshotMetadata;
import com.google.android.gms.games.snapshot.SnapshotMetadataBuffer;
import com.google.android.gms.games.snapshot.SnapshotMetadataChange;
import com.google.android.gms.games.snapshot.Snapshots;
import com.google.android.gms.internal.games.zzad;
import com.google.android.gms.tasks.Task;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
public class SnapshotsClient extends zzad {
    public static final int DISPLAY_LIMIT_NONE = -1;
    public static final String EXTRA_SNAPSHOT_METADATA = "com.google.android.gms.games.SNAPSHOT_METADATA";
    public static final String EXTRA_SNAPSHOT_NEW = "com.google.android.gms.games.SNAPSHOT_NEW";
    public static final int RESOLUTION_POLICY_HIGHEST_PROGRESS = 4;
    public static final int RESOLUTION_POLICY_LAST_KNOWN_GOOD = 2;
    public static final int RESOLUTION_POLICY_LONGEST_PLAYTIME = 1;
    public static final int RESOLUTION_POLICY_MANUAL = -1;
    public static final int RESOLUTION_POLICY_MOST_RECENTLY_MODIFIED = 3;
    private static final zzbg<Snapshots.OpenSnapshotResult> zzdy = new zzby();
    private static final PendingResultUtil.ResultConverter<Snapshots.DeleteSnapshotResult, String> zzdz = new zzbx();
    private static final PendingResultUtil.ResultConverter<Snapshots.CommitSnapshotResult, SnapshotMetadata> zzea = new zzca();
    private static final PendingResultUtil.ResultConverter<Snapshots.OpenSnapshotResult, Snapshots.OpenSnapshotResult> zzeb = new zzbz();
    private static final zzbi zzec = new zzcb();
    private static final PendingResultUtil.ResultConverter<Snapshots.OpenSnapshotResult, DataOrConflict<Snapshot>> zzed = new zzbr();
    private static final PendingResultUtil.ResultConverter<Snapshots.LoadSnapshotsResult, SnapshotMetadataBuffer> zzee = new zzbu();

    /* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
    public static class DataOrConflict<T> {
        private final T data;
        private final SnapshotConflict zzek;

        DataOrConflict(T t, SnapshotConflict snapshotConflict) {
            this.data = t;
            this.zzek = snapshotConflict;
        }

        public SnapshotConflict getConflict() {
            if (isConflict()) {
                return this.zzek;
            }
            throw new IllegalStateException("getConflict called when there is no conflict.");
        }

        public T getData() {
            if (!isConflict()) {
                return this.data;
            }
            throw new IllegalStateException("getData called when there is a conflict.");
        }

        public boolean isConflict() {
            return this.zzek != null;
        }
    }

    /* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
    public static class SnapshotConflict {
        private final Snapshot zzel;
        private final String zzem;
        private final Snapshot zzen;
        private final SnapshotContents zzeo;

        SnapshotConflict(Snapshot snapshot, String str, Snapshot snapshot2, SnapshotContents snapshotContents) {
            this.zzel = snapshot;
            this.zzem = str;
            this.zzen = snapshot2;
            this.zzeo = snapshotContents;
        }

        public String getConflictId() {
            return this.zzem;
        }

        public Snapshot getConflictingSnapshot() {
            return this.zzen;
        }

        public SnapshotContents getResolutionSnapshotContents() {
            return this.zzeo;
        }

        public Snapshot getSnapshot() {
            return this.zzel;
        }
    }

    /* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
    public static class SnapshotContentUnavailableApiException extends ApiException {
        protected final SnapshotMetadata metadata;

        SnapshotContentUnavailableApiException(Status status, SnapshotMetadata snapshotMetadata) {
            super(status);
            this.metadata = snapshotMetadata;
        }

        public SnapshotMetadata getSnapshotMetadata() {
            return this.metadata;
        }
    }

    SnapshotsClient(Context context, Games.GamesOptions gamesOptions) {
        super(context, gamesOptions);
    }

    public static SnapshotMetadata getSnapshotFromBundle(Bundle bundle) {
        return Games.Snapshots.getSnapshotFromBundle(bundle);
    }

    private static Task<DataOrConflict<Snapshot>> zza(PendingResult<Snapshots.OpenSnapshotResult> pendingResult) {
        return zzbb.zza(pendingResult, zzec, zzed, zzeb, zzdy);
    }

    public Task<SnapshotMetadata> commitAndClose(Snapshot snapshot, SnapshotMetadataChange snapshotMetadataChange) {
        return zzbb.toTask(Games.Snapshots.commitAndClose(asGoogleApiClient(), snapshot, snapshotMetadataChange), zzea);
    }

    public Task<String> delete(SnapshotMetadata snapshotMetadata) {
        return zzbb.toTask(Games.Snapshots.delete(asGoogleApiClient(), snapshotMetadata), zzdz);
    }

    public Task<Void> discardAndClose(Snapshot snapshot) {
        return doWrite(new zzbv(this, snapshot));
    }

    public Task<Integer> getMaxCoverImageSize() {
        return doRead(new zzbt(this));
    }

    public Task<Integer> getMaxDataSize() {
        return doRead(new zzbs(this));
    }

    public Task<Intent> getSelectSnapshotIntent(String str, boolean z, boolean z2, int i) {
        return doRead(new zzbw(this, str, z, z2, i));
    }

    public Task<AnnotatedData<SnapshotMetadataBuffer>> load(boolean z) {
        return zzbb.zzb(Games.Snapshots.load(asGoogleApiClient(), z), zzee);
    }

    public Task<DataOrConflict<Snapshot>> open(String str, boolean z) {
        return zza(Games.Snapshots.open(asGoogleApiClient(), str, z));
    }

    public Task<DataOrConflict<Snapshot>> resolveConflict(String str, Snapshot snapshot) {
        return zza(Games.Snapshots.resolveConflict(asGoogleApiClient(), str, snapshot));
    }

    SnapshotsClient(Activity activity, Games.GamesOptions gamesOptions) {
        super(activity, gamesOptions);
    }

    public Task<DataOrConflict<Snapshot>> open(String str, boolean z, int i) {
        return zza(Games.Snapshots.open(asGoogleApiClient(), str, z, i));
    }

    public Task<DataOrConflict<Snapshot>> resolveConflict(String str, String str2, SnapshotMetadataChange snapshotMetadataChange, SnapshotContents snapshotContents) {
        return zza(Games.Snapshots.resolveConflict(asGoogleApiClient(), str, str2, snapshotMetadataChange, snapshotContents));
    }

    public Task<DataOrConflict<Snapshot>> open(SnapshotMetadata snapshotMetadata) {
        return zza(Games.Snapshots.open(asGoogleApiClient(), snapshotMetadata));
    }

    public Task<DataOrConflict<Snapshot>> open(SnapshotMetadata snapshotMetadata, int i) {
        return zza(Games.Snapshots.open(asGoogleApiClient(), snapshotMetadata, i));
    }
}
