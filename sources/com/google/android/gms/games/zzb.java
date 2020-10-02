package com.google.android.gms.games;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.internal.PendingResultUtil;
import com.google.android.gms.games.event.C3093Events;
import com.google.android.gms.games.event.EventBuffer;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
final class zzb implements PendingResultUtil.ResultConverter<C3093Events.LoadEventsResult, EventBuffer> {
    zzb() {
    }

    public final /* synthetic */ Object convert(Result result) {
        C3093Events.LoadEventsResult loadEventsResult = (C3093Events.LoadEventsResult) result;
        if (loadEventsResult == null) {
            return null;
        }
        return loadEventsResult.getEvents();
    }
}
