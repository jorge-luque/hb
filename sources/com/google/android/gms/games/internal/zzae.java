package com.google.android.gms.games.internal;

import com.google.android.gms.games.internal.zzg;
import com.google.android.gms.games.multiplayer.Invitation;
import com.google.android.gms.games.multiplayer.OnInvitationReceivedListener;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
final /* synthetic */ class zzae implements zzg.zzao {
    private final Invitation zzhz;

    zzae(Invitation invitation) {
        this.zzhz = invitation;
    }

    public final void accept(Object obj) {
        ((OnInvitationReceivedListener) obj).onInvitationReceived(this.zzhz);
    }
}
