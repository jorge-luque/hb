package com.google.android.gms.games.internal;

import com.google.android.gms.games.internal.zzg;
import com.google.android.gms.games.multiplayer.OnInvitationReceivedListener;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
final /* synthetic */ class zzad implements zzg.zzao {
    private final String zzhy;

    zzad(String str) {
        this.zzhy = str;
    }

    public final void accept(Object obj) {
        ((OnInvitationReceivedListener) obj).onInvitationRemoved(this.zzhy);
    }
}
