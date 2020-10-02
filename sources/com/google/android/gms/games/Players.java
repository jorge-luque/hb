package com.google.android.gms.games;

import android.content.Intent;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.games.internal.player.StockProfileImage;

@Deprecated
@VisibleForTesting
/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
public interface Players {
    public static final String EXTRA_PLAYER_SEARCH_RESULTS = "player_search_results";

    @Deprecated
    /* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
    public interface LoadPlayersResult extends Releasable, Result {
        PlayerBuffer getPlayers();
    }

    @ShowFirstParty
    /* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
    public interface zza extends Result {
        boolean zzaa();

        int zzab();

        int zzac();

        String zzh();

        boolean zzk();

        boolean zzu();

        StockProfileImage zzv();

        boolean zzw();

        boolean zzx();

        boolean zzy();

        boolean zzz();
    }

    Intent getCompareProfileIntent(GoogleApiClient googleApiClient, Player player);

    Player getCurrentPlayer(GoogleApiClient googleApiClient);

    String getCurrentPlayerId(GoogleApiClient googleApiClient);

    Intent getPlayerSearchIntent(GoogleApiClient googleApiClient);

    @Deprecated
    PendingResult<LoadPlayersResult> loadConnectedPlayers(GoogleApiClient googleApiClient, boolean z);

    @Deprecated
    PendingResult<LoadPlayersResult> loadInvitablePlayers(GoogleApiClient googleApiClient, int i, boolean z);

    @Deprecated
    PendingResult<LoadPlayersResult> loadMoreInvitablePlayers(GoogleApiClient googleApiClient, int i);

    PendingResult<LoadPlayersResult> loadMoreRecentlyPlayedWithPlayers(GoogleApiClient googleApiClient, int i);

    PendingResult<LoadPlayersResult> loadPlayer(GoogleApiClient googleApiClient, String str);

    PendingResult<LoadPlayersResult> loadPlayer(GoogleApiClient googleApiClient, String str, boolean z);

    PendingResult<LoadPlayersResult> loadRecentlyPlayedWithPlayers(GoogleApiClient googleApiClient, int i, boolean z);
}
