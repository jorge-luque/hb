package com.google.android.gms.games.event;

import com.google.android.gms.common.data.AbstractDataBuffer;
import com.google.android.gms.common.data.DataHolder;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
public final class EventBuffer extends AbstractDataBuffer<Event> {
    public EventBuffer(DataHolder dataHolder) {
        super(dataHolder);
    }

    public final Event get(int i) {
        return new EventRef(this.mDataHolder, i);
    }
}
