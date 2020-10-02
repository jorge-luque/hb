package com.google.android.gms.games;

import com.google.android.gms.games.internal.zzbj;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
final class zzcd implements zzbj<TurnBasedMultiplayer.LoadMatchesResult> {
    zzcd() {
    }

    public final /* synthetic */ void zza(Object obj) {
        TurnBasedMultiplayer.LoadMatchesResult loadMatchesResult = (TurnBasedMultiplayer.LoadMatchesResult) obj;
        if (loadMatchesResult.getMatches() != null) {
            loadMatchesResult.getMatches().release();
        }
    }
}
