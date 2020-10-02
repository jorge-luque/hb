package com.google.android.gms.games.multiplayer;

import com.google.android.gms.common.data.AbstractDataBuffer;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
public final class ParticipantBuffer extends AbstractDataBuffer<Participant> {
    public final Participant get(int i) {
        return new ParticipantRef(this.mDataHolder, i);
    }
}
