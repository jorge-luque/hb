package com.google.android.gms.internal.games;

import android.content.Intent;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.internal.zzaz;
import com.google.android.gms.games.internal.zzg;
import com.google.android.gms.games.leaderboard.LeaderboardScoreBuffer;
import com.google.android.gms.games.leaderboard.Leaderboards;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
public final class zzba implements Leaderboards {
    public final Intent getAllLeaderboardsIntent(GoogleApiClient googleApiClient) {
        return Games.zza(googleApiClient).zzbj();
    }

    public final Intent getLeaderboardIntent(GoogleApiClient googleApiClient, String str) {
        return getLeaderboardIntent(googleApiClient, str, -1);
    }

    public final PendingResult<Leaderboards.LoadPlayerScoreResult> loadCurrentPlayerLeaderboardScore(GoogleApiClient googleApiClient, String str, int i, int i2) {
        return googleApiClient.enqueue(new zzbb(this, googleApiClient, str, i, i2));
    }

    public final PendingResult<Leaderboards.LeaderboardMetadataResult> loadLeaderboardMetadata(GoogleApiClient googleApiClient, boolean z) {
        return googleApiClient.enqueue(new zzaz(this, googleApiClient, z));
    }

    public final PendingResult<Leaderboards.LoadScoresResult> loadMoreScores(GoogleApiClient googleApiClient, LeaderboardScoreBuffer leaderboardScoreBuffer, int i, int i2) {
        return googleApiClient.enqueue(new zzbg(this, googleApiClient, leaderboardScoreBuffer, i, i2));
    }

    public final PendingResult<Leaderboards.LoadScoresResult> loadPlayerCenteredScores(GoogleApiClient googleApiClient, String str, int i, int i2, int i3) {
        return loadPlayerCenteredScores(googleApiClient, str, i, i2, i3, false);
    }

    public final PendingResult<Leaderboards.LoadScoresResult> loadTopScores(GoogleApiClient googleApiClient, String str, int i, int i2, int i3) {
        return loadTopScores(googleApiClient, str, i, i2, i3, false);
    }

    public final void submitScore(GoogleApiClient googleApiClient, String str, long j) {
        submitScore(googleApiClient, str, j, (String) null);
    }

    public final PendingResult<Leaderboards.SubmitScoreResult> submitScoreImmediate(GoogleApiClient googleApiClient, String str, long j) {
        return submitScoreImmediate(googleApiClient, str, j, (String) null);
    }

    public final Intent getLeaderboardIntent(GoogleApiClient googleApiClient, String str, int i) {
        return getLeaderboardIntent(googleApiClient, str, i, -1);
    }

    public final PendingResult<Leaderboards.LeaderboardMetadataResult> loadLeaderboardMetadata(GoogleApiClient googleApiClient, String str, boolean z) {
        return googleApiClient.enqueue(new zzbc(this, googleApiClient, str, z));
    }

    public final PendingResult<Leaderboards.LoadScoresResult> loadPlayerCenteredScores(GoogleApiClient googleApiClient, String str, int i, int i2, int i3, boolean z) {
        return googleApiClient.enqueue(new zzbd(this, googleApiClient, str, i, i2, i3, z));
    }

    public final PendingResult<Leaderboards.LoadScoresResult> loadTopScores(GoogleApiClient googleApiClient, String str, int i, int i2, int i3, boolean z) {
        return googleApiClient.enqueue(new zzbe(this, googleApiClient, str, i, i2, i3, z));
    }

    public final void submitScore(GoogleApiClient googleApiClient, String str, long j, String str2) {
        zzg zza = Games.zza(googleApiClient, false);
        if (zza != null) {
            try {
                zza.zza((BaseImplementation.ResultHolder<Leaderboards.SubmitScoreResult>) null, str, j, str2);
            } catch (RemoteException unused) {
                zzaz.m10159w("LeaderboardsImpl", "service died");
            }
        }
    }

    public final PendingResult<Leaderboards.SubmitScoreResult> submitScoreImmediate(GoogleApiClient googleApiClient, String str, long j, String str2) {
        return googleApiClient.execute(new zzbf(this, googleApiClient, str, j, str2));
    }

    public final Intent getLeaderboardIntent(GoogleApiClient googleApiClient, String str, int i, int i2) {
        return Games.zza(googleApiClient).zza(str, i, i2);
    }
}
