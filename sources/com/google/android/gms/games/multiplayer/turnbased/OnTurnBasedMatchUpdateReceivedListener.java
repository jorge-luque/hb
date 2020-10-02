package com.google.android.gms.games.multiplayer.turnbased;

@Deprecated
/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
public interface OnTurnBasedMatchUpdateReceivedListener {
    void onTurnBasedMatchReceived(TurnBasedMatch turnBasedMatch);

    void onTurnBasedMatchRemoved(String str);
}
