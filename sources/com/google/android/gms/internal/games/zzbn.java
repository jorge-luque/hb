package com.google.android.gms.internal.games;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.leaderboard.Leaderboards;
import com.google.android.gms.games.leaderboard.ScoreSubmissionData;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
final class zzbn implements Leaderboards.SubmitScoreResult {
    private final /* synthetic */ Status zzba;

    zzbn(zzbo zzbo, Status status) {
        this.zzba = status;
    }

    public final ScoreSubmissionData getScoreData() {
        return new ScoreSubmissionData(DataHolder.empty(14));
    }

    public final Status getStatus() {
        return this.zzba;
    }

    public final void release() {
    }
}
