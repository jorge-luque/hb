package com.google.android.gms.internal.games;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.event.C3093Events;
import com.google.android.gms.games.event.EventBuffer;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
final class zzam implements C3093Events.LoadEventsResult {
    private final /* synthetic */ Status zzba;

    zzam(zzaj zzaj, Status status) {
        this.zzba = status;
    }

    public final EventBuffer getEvents() {
        return new EventBuffer(DataHolder.empty(14));
    }

    public final Status getStatus() {
        return this.zzba;
    }

    public final void release() {
    }
}
