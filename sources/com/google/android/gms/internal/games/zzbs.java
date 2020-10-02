package com.google.android.gms.internal.games;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.games.AnnotatedData;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.PlayerStatsClient;
import com.google.android.gms.games.stats.PlayerStats;
import com.google.android.gms.tasks.Task;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
public final class zzbs extends PlayerStatsClient {
    public zzbs(Context context, Games.GamesOptions gamesOptions) {
        super(context, gamesOptions);
    }

    public final Task<AnnotatedData<PlayerStats>> loadPlayerStats(boolean z) {
        return doRead(TaskApiCall.builder().run(new zzag(new zzbr(z))).build());
    }

    public zzbs(Activity activity, Games.GamesOptions gamesOptions) {
        super(activity, gamesOptions);
    }
}
