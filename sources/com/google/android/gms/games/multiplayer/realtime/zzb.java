package com.google.android.gms.games.multiplayer.realtime;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.EntityBuffer;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
public final class zzb extends EntityBuffer<Room> {
    public zzb(DataHolder dataHolder) {
        super(dataHolder);
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ Object getEntry(int i, int i2) {
        return new zze(this.mDataHolder, i, i2);
    }

    /* access modifiers changed from: protected */
    public final String getPrimaryDataMarkerColumn() {
        return "external_match_id";
    }
}
