package com.google.android.gms.games;

import com.google.android.gms.games.Games;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
final class zzd extends Games.zza {
    zzd() {
        super((zze) null);
    }

    public final /* synthetic */ List getImpliedScopes(Object obj) {
        Games.GamesOptions gamesOptions = (Games.GamesOptions) obj;
        return Collections.singletonList(Games.zzai);
    }
}
