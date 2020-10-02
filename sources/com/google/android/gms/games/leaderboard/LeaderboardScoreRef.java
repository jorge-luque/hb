package com.google.android.gms.games.leaderboard;

import android.database.CharArrayBuffer;
import android.net.Uri;
import com.google.android.gms.common.data.DataBufferRef;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerRef;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
public final class LeaderboardScoreRef extends DataBufferRef implements LeaderboardScore {
    private final PlayerRef zzoa;

    LeaderboardScoreRef(DataHolder dataHolder, int i) {
        super(dataHolder, i);
        this.zzoa = new PlayerRef(dataHolder, i);
    }

    public final boolean equals(Object obj) {
        return LeaderboardScoreEntity.zza(this, obj);
    }

    public final /* synthetic */ Object freeze() {
        return new LeaderboardScoreEntity(this);
    }

    public final String getDisplayRank() {
        return getString("display_rank");
    }

    public final String getDisplayScore() {
        return getString("display_score");
    }

    public final long getRank() {
        return getLong("rank");
    }

    public final long getRawScore() {
        return getLong("raw_score");
    }

    public final Player getScoreHolder() {
        if (hasNull("external_player_id")) {
            return null;
        }
        return this.zzoa;
    }

    public final String getScoreHolderDisplayName() {
        if (hasNull("external_player_id")) {
            return getString("default_display_name");
        }
        return this.zzoa.getDisplayName();
    }

    public final Uri getScoreHolderHiResImageUri() {
        if (hasNull("external_player_id")) {
            return null;
        }
        return this.zzoa.getHiResImageUri();
    }

    public final String getScoreHolderHiResImageUrl() {
        if (hasNull("external_player_id")) {
            return null;
        }
        return this.zzoa.getHiResImageUrl();
    }

    public final Uri getScoreHolderIconImageUri() {
        if (hasNull("external_player_id")) {
            return parseUri("default_display_image_uri");
        }
        return this.zzoa.getIconImageUri();
    }

    public final String getScoreHolderIconImageUrl() {
        if (hasNull("external_player_id")) {
            return getString("default_display_image_url");
        }
        return this.zzoa.getIconImageUrl();
    }

    public final String getScoreTag() {
        return getString("score_tag");
    }

    public final long getTimestampMillis() {
        return getLong("achieved_timestamp");
    }

    public final int hashCode() {
        return LeaderboardScoreEntity.zza(this);
    }

    public final String toString() {
        return LeaderboardScoreEntity.zzb(this);
    }

    public final void getDisplayRank(CharArrayBuffer charArrayBuffer) {
        copyToBuffer("display_rank", charArrayBuffer);
    }

    public final void getDisplayScore(CharArrayBuffer charArrayBuffer) {
        copyToBuffer("display_score", charArrayBuffer);
    }

    public final void getScoreHolderDisplayName(CharArrayBuffer charArrayBuffer) {
        if (hasNull("external_player_id")) {
            copyToBuffer("default_display_name", charArrayBuffer);
        } else {
            this.zzoa.getDisplayName(charArrayBuffer);
        }
    }
}
