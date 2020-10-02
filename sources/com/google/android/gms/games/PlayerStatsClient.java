package com.google.android.gms.games;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.stats.PlayerStats;
import com.google.android.gms.internal.games.zzad;
import com.google.android.gms.tasks.Task;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
public abstract class PlayerStatsClient extends zzad {
    protected PlayerStatsClient(Context context, Games.GamesOptions gamesOptions) {
        super(context, gamesOptions);
    }

    public abstract Task<AnnotatedData<PlayerStats>> loadPlayerStats(boolean z);

    protected PlayerStatsClient(Activity activity, Games.GamesOptions gamesOptions) {
        super(activity, gamesOptions);
    }
}
