package com.google.android.gms.games;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.common.internal.PendingResultUtil;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.GamesMetadata;
import com.google.android.gms.games.internal.zzbb;
import com.google.android.gms.games.internal.zzbj;
import com.google.android.gms.internal.games.zzad;
import com.google.android.gms.tasks.Task;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
public class GamesMetadataClient extends zzad {
    private static final PendingResultUtil.ResultConverter<GamesMetadata.LoadGamesResult, Game> zzbd = new zzq();
    private static final zzbj<GamesMetadata.LoadGamesResult> zzbe = new zzs();

    GamesMetadataClient(Context context, Games.GamesOptions gamesOptions) {
        super(context, gamesOptions);
    }

    public Task<Game> getCurrentGame() {
        return doRead(new zzr(this));
    }

    public Task<AnnotatedData<Game>> loadGame() {
        return zzbb.zza(Games.GamesMetadata.loadGame(asGoogleApiClient()), zzbd, zzbe);
    }

    GamesMetadataClient(Activity activity, Games.GamesOptions gamesOptions) {
        super(activity, gamesOptions);
    }
}
