package com.google.android.gms.games.stats;

import com.google.android.gms.common.data.AbstractDataBuffer;
import com.google.android.gms.common.data.DataHolder;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
public final class PlayerStatsBuffer extends AbstractDataBuffer<PlayerStats> {
    public PlayerStatsBuffer(DataHolder dataHolder) {
        super(dataHolder);
    }

    public final /* synthetic */ Object get(int i) {
        return new zzb(this.mDataHolder, i);
    }
}
