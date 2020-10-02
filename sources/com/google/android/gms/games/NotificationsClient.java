package com.google.android.gms.games;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.games.Games;
import com.google.android.gms.internal.games.zzad;
import com.google.android.gms.tasks.Task;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
public class NotificationsClient extends zzad {
    public static final int NOTIFICATION_TYPES_ALL = 19;
    public static final int NOTIFICATION_TYPES_MULTIPLAYER = 3;
    public static final int NOTIFICATION_TYPE_INVITATION = 1;
    public static final int NOTIFICATION_TYPE_LEVEL_UP = 16;
    public static final int NOTIFICATION_TYPE_MATCH_UPDATE = 2;

    NotificationsClient(Context context, Games.GamesOptions gamesOptions) {
        super(context, gamesOptions);
    }

    public Task<Void> clear(int i) {
        return doWrite(new zzak(this, i));
    }

    public Task<Void> clearAll() {
        return clear(19);
    }

    NotificationsClient(Activity activity, Games.GamesOptions gamesOptions) {
        super(activity, gamesOptions);
    }
}
