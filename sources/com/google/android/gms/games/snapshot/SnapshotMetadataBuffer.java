package com.google.android.gms.games.snapshot;

import com.google.android.gms.common.data.AbstractDataBuffer;
import com.google.android.gms.common.data.DataHolder;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
public final class SnapshotMetadataBuffer extends AbstractDataBuffer<SnapshotMetadata> {
    public SnapshotMetadataBuffer(DataHolder dataHolder) {
        super(dataHolder);
    }

    public final SnapshotMetadata get(int i) {
        return new SnapshotMetadataRef(this.mDataHolder, i);
    }
}
