package com.google.android.gms.games.multiplayer;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
public abstract class InvitationCallback implements OnInvitationReceivedListener {
    public abstract void onInvitationReceived(Invitation invitation);

    public abstract void onInvitationRemoved(String str);
}
