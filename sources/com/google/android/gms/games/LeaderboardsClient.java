package com.google.android.gms.games;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.internal.PendingResultUtil;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.internal.zzbb;
import com.google.android.gms.games.internal.zzbi;
import com.google.android.gms.games.internal.zzbj;
import com.google.android.gms.games.leaderboard.Leaderboard;
import com.google.android.gms.games.leaderboard.LeaderboardBuffer;
import com.google.android.gms.games.leaderboard.LeaderboardScore;
import com.google.android.gms.games.leaderboard.LeaderboardScoreBuffer;
import com.google.android.gms.games.leaderboard.Leaderboards;
import com.google.android.gms.games.leaderboard.ScoreSubmissionData;
import com.google.android.gms.internal.games.zzad;
import com.google.android.gms.tasks.Task;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
public class LeaderboardsClient extends zzad {
    private static final PendingResultUtil.ResultConverter<Leaderboards.LeaderboardMetadataResult, LeaderboardBuffer> zzbh = new zzai();
    private static final PendingResultUtil.ResultConverter<Leaderboards.LeaderboardMetadataResult, Leaderboard> zzbi = new zzah();
    private static final zzbj<Leaderboards.LeaderboardMetadataResult> zzbj = new zzaj();
    private static final PendingResultUtil.ResultConverter<Leaderboards.LoadPlayerScoreResult, LeaderboardScore> zzbk = new zzx();
    private static final zzbi zzbl = new zzaa();
    private static final PendingResultUtil.ResultConverter<Leaderboards.SubmitScoreResult, ScoreSubmissionData> zzbm = new zzz();
    private static final PendingResultUtil.ResultConverter<Leaderboards.LoadScoresResult, LeaderboardScores> zzbn = new zzac();

    /* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
    public static class LeaderboardScores implements Releasable {
        private final Leaderboard zzbt;
        private final LeaderboardScoreBuffer zzbu;

        public LeaderboardScores(Leaderboard leaderboard, LeaderboardScoreBuffer leaderboardScoreBuffer) {
            this.zzbt = leaderboard;
            this.zzbu = leaderboardScoreBuffer;
        }

        public Leaderboard getLeaderboard() {
            return this.zzbt;
        }

        public LeaderboardScoreBuffer getScores() {
            return this.zzbu;
        }

        public void release() {
            LeaderboardScoreBuffer leaderboardScoreBuffer = this.zzbu;
            if (leaderboardScoreBuffer != null) {
                leaderboardScoreBuffer.release();
            }
        }
    }

    LeaderboardsClient(Context context, Games.GamesOptions gamesOptions) {
        super(context, gamesOptions);
    }

    public Task<Intent> getAllLeaderboardsIntent() {
        return doRead(new zzy(this));
    }

    public Task<Intent> getLeaderboardIntent(String str) {
        return doRead(new zzab(this, str));
    }

    public Task<AnnotatedData<LeaderboardScore>> loadCurrentPlayerLeaderboardScore(String str, int i, int i2) {
        return zzbb.zza(Games.Leaderboards.loadCurrentPlayerLeaderboardScore(asGoogleApiClient(), str, i, i2), zzbk);
    }

    public Task<AnnotatedData<LeaderboardBuffer>> loadLeaderboardMetadata(boolean z) {
        return zzbb.zzb(Games.Leaderboards.loadLeaderboardMetadata(asGoogleApiClient(), z), zzbh);
    }

    public Task<AnnotatedData<LeaderboardScores>> loadMoreScores(LeaderboardScoreBuffer leaderboardScoreBuffer, int i, int i2) {
        return zzbb.zzb(Games.Leaderboards.loadMoreScores(asGoogleApiClient(), leaderboardScoreBuffer, i, i2), zzbn);
    }

    public Task<AnnotatedData<LeaderboardScores>> loadPlayerCenteredScores(String str, int i, int i2, int i3) {
        return zzbb.zzb(Games.Leaderboards.loadPlayerCenteredScores(asGoogleApiClient(), str, i, i2, i3), zzbn);
    }

    public Task<AnnotatedData<LeaderboardScores>> loadTopScores(String str, int i, int i2, int i3) {
        return zzbb.zzb(Games.Leaderboards.loadTopScores(asGoogleApiClient(), str, i, i2, i3), zzbn);
    }

    public void submitScore(String str, long j) {
        doWrite(new zzag(this, str, j));
    }

    public Task<ScoreSubmissionData> submitScoreImmediate(String str, long j) {
        return zzbb.zza(Games.Leaderboards.submitScoreImmediate(asGoogleApiClient(), str, j), zzbl, zzbm);
    }

    LeaderboardsClient(Activity activity, Games.GamesOptions gamesOptions) {
        super(activity, gamesOptions);
    }

    public Task<Intent> getLeaderboardIntent(String str, int i) {
        return doRead(new zzae(this, str, i));
    }

    public void submitScore(String str, long j, String str2) {
        doWrite(new zzaf(this, str, j, str2));
    }

    public Task<Intent> getLeaderboardIntent(String str, int i, int i2) {
        return doRead(new zzad(this, str, i, i2));
    }

    public Task<AnnotatedData<Leaderboard>> loadLeaderboardMetadata(String str, boolean z) {
        return zzbb.zza(Games.Leaderboards.loadLeaderboardMetadata(asGoogleApiClient(), str, z), zzbi, zzbj);
    }

    public Task<ScoreSubmissionData> submitScoreImmediate(String str, long j, String str2) {
        return zzbb.zza(Games.Leaderboards.submitScoreImmediate(asGoogleApiClient(), str, j, str2), zzbl, zzbm);
    }

    public Task<AnnotatedData<LeaderboardScores>> loadPlayerCenteredScores(String str, int i, int i2, int i3, boolean z) {
        return zzbb.zzb(Games.Leaderboards.loadPlayerCenteredScores(asGoogleApiClient(), str, i, i2, i3, z), zzbn);
    }

    public Task<AnnotatedData<LeaderboardScores>> loadTopScores(String str, int i, int i2, int i3, boolean z) {
        return zzbb.zzb(Games.Leaderboards.loadTopScores(asGoogleApiClient(), str, i, i2, i3, z), zzbn);
    }
}
