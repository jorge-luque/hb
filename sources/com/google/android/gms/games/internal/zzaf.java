package com.google.android.gms.games.internal;

import com.google.android.gms.games.internal.zzg;
import com.google.android.gms.games.multiplayer.turnbased.OnTurnBasedMatchUpdateReceivedListener;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatch;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
final /* synthetic */ class zzaf implements zzg.zzao {
    private final TurnBasedMatch zzim;

    zzaf(TurnBasedMatch turnBasedMatch) {
        this.zzim = turnBasedMatch;
    }

    public final void accept(Object obj) {
        ((OnTurnBasedMatchUpdateReceivedListener) obj).onTurnBasedMatchReceived(this.zzim);
    }
}
