package com.google.android.gms.games.internal;

import com.google.android.gms.games.internal.zzg;
import com.google.android.gms.games.multiplayer.turnbased.OnTurnBasedMatchUpdateReceivedListener;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
final /* synthetic */ class zzag implements zzg.zzao {
    private final String zzhy;

    zzag(String str) {
        this.zzhy = str;
    }

    public final void accept(Object obj) {
        ((OnTurnBasedMatchUpdateReceivedListener) obj).onTurnBasedMatchRemoved(this.zzhy);
    }
}
