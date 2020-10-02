package com.google.android.gms.games;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.api.internal.ListenerHolders;
import com.google.android.gms.common.internal.PendingResultUtil;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.internal.zzbb;
import com.google.android.gms.games.multiplayer.InvitationBuffer;
import com.google.android.gms.games.multiplayer.InvitationCallback;
import com.google.android.gms.games.multiplayer.Invitations;
import com.google.android.gms.internal.games.zzad;
import com.google.android.gms.tasks.Task;

@Deprecated
/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
public class InvitationsClient extends zzad {
    private static final PendingResultUtil.ResultConverter<Invitations.LoadInvitationsResult, InvitationBuffer> zzbf = new zzw();

    InvitationsClient(Context context, Games.GamesOptions gamesOptions) {
        super(context, gamesOptions);
    }

    public Task<Intent> getInvitationInboxIntent() {
        return doRead(new zzt(this));
    }

    public Task<AnnotatedData<InvitationBuffer>> loadInvitations() {
        return loadInvitations(0);
    }

    public Task<Void> registerInvitationCallback(InvitationCallback invitationCallback) {
        ListenerHolder registerListener = registerListener(invitationCallback, InvitationCallback.class.getSimpleName());
        return doRegisterEventListener(new zzv(this, registerListener, registerListener), new zzu(this, registerListener.getListenerKey()));
    }

    public Task<Boolean> unregisterInvitationCallback(InvitationCallback invitationCallback) {
        return doUnregisterEventListener(ListenerHolders.createListenerKey(invitationCallback, InvitationCallback.class.getSimpleName()));
    }

    InvitationsClient(Activity activity, Games.GamesOptions gamesOptions) {
        super(activity, gamesOptions);
    }

    public Task<AnnotatedData<InvitationBuffer>> loadInvitations(int i) {
        return zzbb.zzb(Games.Invitations.loadInvitations(asGoogleApiClient(), i), zzbf);
    }
}
