package com.google.android.gms.games;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.internal.PendingResultUtil;
import com.google.android.gms.games.leaderboard.Leaderboards;
import com.google.android.gms.games.leaderboard.ScoreSubmissionData;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
final class zzz implements PendingResultUtil.ResultConverter<Leaderboards.SubmitScoreResult, ScoreSubmissionData> {
    zzz() {
    }

    public final /* synthetic */ Object convert(Result result) {
        Leaderboards.SubmitScoreResult submitScoreResult = (Leaderboards.SubmitScoreResult) result;
        if (submitScoreResult == null) {
            return null;
        }
        return submitScoreResult.getScoreData();
    }
}
