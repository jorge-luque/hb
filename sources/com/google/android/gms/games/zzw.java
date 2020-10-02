package com.google.android.gms.games;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.internal.PendingResultUtil;
import com.google.android.gms.games.multiplayer.InvitationBuffer;
import com.google.android.gms.games.multiplayer.Invitations;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
final class zzw implements PendingResultUtil.ResultConverter<Invitations.LoadInvitationsResult, InvitationBuffer> {
    zzw() {
    }

    public final /* synthetic */ Object convert(Result result) {
        Invitations.LoadInvitationsResult loadInvitationsResult = (Invitations.LoadInvitationsResult) result;
        if (loadInvitationsResult == null) {
            return null;
        }
        return loadInvitationsResult.getInvitations();
    }
}
