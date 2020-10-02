package com.google.android.gms.internal.games;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.multiplayer.InvitationBuffer;
import com.google.android.gms.games.multiplayer.Invitations;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
final class zzax implements Invitations.LoadInvitationsResult {
    private final /* synthetic */ Status zzba;

    zzax(zzay zzay, Status status) {
        this.zzba = status;
    }

    public final InvitationBuffer getInvitations() {
        return new InvitationBuffer(DataHolder.empty(14));
    }

    public final Status getStatus() {
        return this.zzba;
    }

    public final void release() {
    }
}
