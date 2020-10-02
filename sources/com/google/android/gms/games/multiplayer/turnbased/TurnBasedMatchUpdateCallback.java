package com.google.android.gms.games.multiplayer.turnbased;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
public abstract class TurnBasedMatchUpdateCallback implements OnTurnBasedMatchUpdateReceivedListener {
    public abstract void onTurnBasedMatchReceived(TurnBasedMatch turnBasedMatch);

    public abstract void onTurnBasedMatchRemoved(String str);
}
