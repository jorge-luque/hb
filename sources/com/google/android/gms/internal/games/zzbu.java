package com.google.android.gms.internal.games;

import android.content.Intent;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.games.Players;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
public final class zzbu implements Players {
    public final Intent getCompareProfileIntent(GoogleApiClient googleApiClient, Player player) {
        return Games.zza(googleApiClient).zzb(new PlayerEntity(player));
    }

    public final Player getCurrentPlayer(GoogleApiClient googleApiClient) {
        return Games.zza(googleApiClient).zzbf();
    }

    public final String getCurrentPlayerId(GoogleApiClient googleApiClient) {
        return Games.zza(googleApiClient).zzb(true);
    }

    public final Intent getPlayerSearchIntent(GoogleApiClient googleApiClient) {
        return Games.zza(googleApiClient).zzbs();
    }

    public final PendingResult<Players.LoadPlayersResult> loadConnectedPlayers(GoogleApiClient googleApiClient, boolean z) {
        return googleApiClient.enqueue(new zzbz(this, googleApiClient, z));
    }

    public final PendingResult<Players.LoadPlayersResult> loadInvitablePlayers(GoogleApiClient googleApiClient, int i, boolean z) {
        return googleApiClient.enqueue(new zzbv(this, googleApiClient, i, z));
    }

    public final PendingResult<Players.LoadPlayersResult> loadMoreInvitablePlayers(GoogleApiClient googleApiClient, int i) {
        return googleApiClient.enqueue(new zzby(this, googleApiClient, i));
    }

    public final PendingResult<Players.LoadPlayersResult> loadMoreRecentlyPlayedWithPlayers(GoogleApiClient googleApiClient, int i) {
        return googleApiClient.enqueue(new zzca(this, googleApiClient, i));
    }

    public final PendingResult<Players.LoadPlayersResult> loadPlayer(GoogleApiClient googleApiClient, String str) {
        return googleApiClient.enqueue(new zzbt(this, googleApiClient, str));
    }

    public final PendingResult<Players.LoadPlayersResult> loadRecentlyPlayedWithPlayers(GoogleApiClient googleApiClient, int i, boolean z) {
        return googleApiClient.enqueue(new zzbx(this, googleApiClient, i, z));
    }

    public final PendingResult<Players.LoadPlayersResult> loadPlayer(GoogleApiClient googleApiClient, String str, boolean z) {
        return googleApiClient.enqueue(new zzbw(this, googleApiClient, str, z));
    }
}
