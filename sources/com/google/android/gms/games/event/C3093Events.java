package com.google.android.gms.games.event;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.util.VisibleForTesting;

@Deprecated
@VisibleForTesting
/* renamed from: com.google.android.gms.games.event.Events */
/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
public interface C3093Events {

    @Deprecated
    /* renamed from: com.google.android.gms.games.event.Events$LoadEventsResult */
    /* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
    public interface LoadEventsResult extends Releasable, Result {
        EventBuffer getEvents();
    }

    void increment(GoogleApiClient googleApiClient, String str, int i);

    PendingResult<LoadEventsResult> load(GoogleApiClient googleApiClient, boolean z);

    PendingResult<LoadEventsResult> loadByIds(GoogleApiClient googleApiClient, boolean z, String... strArr);
}
