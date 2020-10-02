package com.google.android.gms.games.leaderboard;

import com.google.android.gms.common.data.DataBufferRef;
import com.google.android.gms.common.data.DataHolder;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
public final class zzb extends DataBufferRef implements LeaderboardVariant {
    zzb(DataHolder dataHolder, int i) {
        super(dataHolder, i);
    }

    public final boolean equals(Object obj) {
        return LeaderboardVariantEntity.zza(this, obj);
    }

    public final /* synthetic */ Object freeze() {
        return new LeaderboardVariantEntity(this);
    }

    public final int getCollection() {
        return getInteger("collection");
    }

    public final String getDisplayPlayerRank() {
        return getString("player_display_rank");
    }

    public final String getDisplayPlayerScore() {
        return getString("player_display_score");
    }

    public final long getNumScores() {
        if (hasNull("total_scores")) {
            return -1;
        }
        return getLong("total_scores");
    }

    public final long getPlayerRank() {
        if (hasNull("player_rank")) {
            return -1;
        }
        return getLong("player_rank");
    }

    public final String getPlayerScoreTag() {
        return getString("player_score_tag");
    }

    public final long getRawPlayerScore() {
        if (hasNull("player_raw_score")) {
            return -1;
        }
        return getLong("player_raw_score");
    }

    public final int getTimeSpan() {
        return getInteger("timespan");
    }

    public final boolean hasPlayerInfo() {
        return !hasNull("player_raw_score");
    }

    public final int hashCode() {
        return LeaderboardVariantEntity.zza(this);
    }

    public final String toString() {
        return LeaderboardVariantEntity.zzb(this);
    }

    public final String zzdl() {
        return getString("top_page_token_next");
    }

    public final String zzdm() {
        return getString("window_page_token_prev");
    }

    public final String zzdn() {
        return getString("window_page_token_next");
    }
}
