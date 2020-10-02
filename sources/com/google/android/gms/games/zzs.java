package com.google.android.gms.games;

import com.google.android.gms.games.GamesMetadata;
import com.google.android.gms.games.internal.zzbj;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
final class zzs implements zzbj<GamesMetadata.LoadGamesResult> {
    zzs() {
    }

    public final /* synthetic */ void zza(Object obj) {
        GamesMetadata.LoadGamesResult loadGamesResult = (GamesMetadata.LoadGamesResult) obj;
        if (loadGamesResult.getGames() != null) {
            loadGamesResult.getGames().release();
        }
    }
}
