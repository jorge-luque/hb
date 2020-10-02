package com.google.android.gms.games;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.internal.PendingResultUtil;
import com.google.android.gms.games.GamesMetadata;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
final class zzq implements PendingResultUtil.ResultConverter<GamesMetadata.LoadGamesResult, Game> {
    zzq() {
    }

    private static Game zza(GamesMetadata.LoadGamesResult loadGamesResult) {
        GameBuffer games;
        if (loadGamesResult == null || (games = loadGamesResult.getGames()) == null) {
            return null;
        }
        try {
            if (games.getCount() > 0) {
                return (Game) ((Game) games.get(0)).freeze();
            }
            games.release();
            return null;
        } finally {
            games.release();
        }
    }

    public final /* synthetic */ Object convert(Result result) {
        return zza((GamesMetadata.LoadGamesResult) result);
    }
}
