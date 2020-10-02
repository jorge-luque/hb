package com.google.android.gms.games;

import com.google.android.gms.common.data.AbstractDataBuffer;
import com.google.android.gms.common.data.DataHolder;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
public class PlayerBuffer extends AbstractDataBuffer<Player> {
    public PlayerBuffer(DataHolder dataHolder) {
        super(dataHolder);
    }

    public Player get(int i) {
        return new PlayerRef(this.mDataHolder, i);
    }
}
