package com.google.android.gms.games;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.common.internal.PendingResultUtil;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.event.C3093Events;
import com.google.android.gms.games.event.EventBuffer;
import com.google.android.gms.games.internal.zzbb;
import com.google.android.gms.internal.games.zzad;
import com.google.android.gms.tasks.Task;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
public class EventsClient extends zzad {
    private static final PendingResultUtil.ResultConverter<C3093Events.LoadEventsResult, EventBuffer> zzh = new zzb();

    EventsClient(Context context, Games.GamesOptions gamesOptions) {
        super(context, gamesOptions);
    }

    public void increment(String str, int i) {
        doWrite(new zza(this, str, i));
    }

    public Task<AnnotatedData<EventBuffer>> load(boolean z) {
        return zzbb.zzb(Games.Events.load(asGoogleApiClient(), z), zzh);
    }

    public Task<AnnotatedData<EventBuffer>> loadByIds(boolean z, String... strArr) {
        return zzbb.zzb(Games.Events.loadByIds(asGoogleApiClient(), z, strArr), zzh);
    }

    EventsClient(Activity activity, Games.GamesOptions gamesOptions) {
        super(activity, gamesOptions);
    }
}
