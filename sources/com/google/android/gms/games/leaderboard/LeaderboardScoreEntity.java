package com.google.android.gms.games.leaderboard;

import android.database.CharArrayBuffer;
import android.net.Uri;
import com.google.android.apps.common.proguard.UsedByReflection;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.DataUtils;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerEntity;

@UsedByReflection("GamesGmsClientImpl.java")
/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
public final class LeaderboardScoreEntity implements LeaderboardScore {
    private final long rawScore;
    private final String scoreTag;
    private final long zzob;
    private final String zzoc;
    private final String zzod;
    private final long zzoe;
    private final String zzof;
    private final Uri zzog;
    private final Uri zzoh;
    private final PlayerEntity zzoi;
    private final String zzoj;
    private final String zzok;

    public LeaderboardScoreEntity(LeaderboardScore leaderboardScore) {
        PlayerEntity playerEntity;
        this.zzob = leaderboardScore.getRank();
        this.zzoc = (String) Preconditions.checkNotNull(leaderboardScore.getDisplayRank());
        this.zzod = (String) Preconditions.checkNotNull(leaderboardScore.getDisplayScore());
        this.rawScore = leaderboardScore.getRawScore();
        this.zzoe = leaderboardScore.getTimestampMillis();
        this.zzof = leaderboardScore.getScoreHolderDisplayName();
        this.zzog = leaderboardScore.getScoreHolderIconImageUri();
        this.zzoh = leaderboardScore.getScoreHolderHiResImageUri();
        Player scoreHolder = leaderboardScore.getScoreHolder();
        if (scoreHolder == null) {
            playerEntity = null;
        } else {
            playerEntity = (PlayerEntity) scoreHolder.freeze();
        }
        this.zzoi = playerEntity;
        this.scoreTag = leaderboardScore.getScoreTag();
        this.zzoj = leaderboardScore.getScoreHolderIconImageUrl();
        this.zzok = leaderboardScore.getScoreHolderHiResImageUrl();
    }

    static int zza(LeaderboardScore leaderboardScore) {
        return Objects.hashCode(Long.valueOf(leaderboardScore.getRank()), leaderboardScore.getDisplayRank(), Long.valueOf(leaderboardScore.getRawScore()), leaderboardScore.getDisplayScore(), Long.valueOf(leaderboardScore.getTimestampMillis()), leaderboardScore.getScoreHolderDisplayName(), leaderboardScore.getScoreHolderIconImageUri(), leaderboardScore.getScoreHolderHiResImageUri(), leaderboardScore.getScoreHolder());
    }

    static String zzb(LeaderboardScore leaderboardScore) {
        return Objects.toStringHelper(leaderboardScore).add("Rank", Long.valueOf(leaderboardScore.getRank())).add("DisplayRank", leaderboardScore.getDisplayRank()).add("Score", Long.valueOf(leaderboardScore.getRawScore())).add("DisplayScore", leaderboardScore.getDisplayScore()).add("Timestamp", Long.valueOf(leaderboardScore.getTimestampMillis())).add("DisplayName", leaderboardScore.getScoreHolderDisplayName()).add("IconImageUri", leaderboardScore.getScoreHolderIconImageUri()).add("IconImageUrl", leaderboardScore.getScoreHolderIconImageUrl()).add("HiResImageUri", leaderboardScore.getScoreHolderHiResImageUri()).add("HiResImageUrl", leaderboardScore.getScoreHolderHiResImageUrl()).add("Player", leaderboardScore.getScoreHolder() == null ? null : leaderboardScore.getScoreHolder()).add("ScoreTag", leaderboardScore.getScoreTag()).toString();
    }

    public final boolean equals(Object obj) {
        return zza(this, obj);
    }

    public final /* bridge */ /* synthetic */ Object freeze() {
        return this;
    }

    public final String getDisplayRank() {
        return this.zzoc;
    }

    public final String getDisplayScore() {
        return this.zzod;
    }

    public final long getRank() {
        return this.zzob;
    }

    public final long getRawScore() {
        return this.rawScore;
    }

    public final Player getScoreHolder() {
        return this.zzoi;
    }

    public final String getScoreHolderDisplayName() {
        PlayerEntity playerEntity = this.zzoi;
        if (playerEntity == null) {
            return this.zzof;
        }
        return playerEntity.getDisplayName();
    }

    public final Uri getScoreHolderHiResImageUri() {
        PlayerEntity playerEntity = this.zzoi;
        if (playerEntity == null) {
            return this.zzoh;
        }
        return playerEntity.getHiResImageUri();
    }

    public final String getScoreHolderHiResImageUrl() {
        PlayerEntity playerEntity = this.zzoi;
        if (playerEntity == null) {
            return this.zzok;
        }
        return playerEntity.getHiResImageUrl();
    }

    public final Uri getScoreHolderIconImageUri() {
        PlayerEntity playerEntity = this.zzoi;
        if (playerEntity == null) {
            return this.zzog;
        }
        return playerEntity.getIconImageUri();
    }

    public final String getScoreHolderIconImageUrl() {
        PlayerEntity playerEntity = this.zzoi;
        if (playerEntity == null) {
            return this.zzoj;
        }
        return playerEntity.getIconImageUrl();
    }

    public final String getScoreTag() {
        return this.scoreTag;
    }

    public final long getTimestampMillis() {
        return this.zzoe;
    }

    public final int hashCode() {
        return zza(this);
    }

    public final boolean isDataValid() {
        return true;
    }

    public final String toString() {
        return zzb(this);
    }

    public final void getDisplayRank(CharArrayBuffer charArrayBuffer) {
        DataUtils.copyStringToBuffer(this.zzoc, charArrayBuffer);
    }

    public final void getDisplayScore(CharArrayBuffer charArrayBuffer) {
        DataUtils.copyStringToBuffer(this.zzod, charArrayBuffer);
    }

    public final void getScoreHolderDisplayName(CharArrayBuffer charArrayBuffer) {
        PlayerEntity playerEntity = this.zzoi;
        if (playerEntity == null) {
            DataUtils.copyStringToBuffer(this.zzof, charArrayBuffer);
        } else {
            playerEntity.getDisplayName(charArrayBuffer);
        }
    }

    static boolean zza(LeaderboardScore leaderboardScore, Object obj) {
        if (!(obj instanceof LeaderboardScore)) {
            return false;
        }
        if (leaderboardScore == obj) {
            return true;
        }
        LeaderboardScore leaderboardScore2 = (LeaderboardScore) obj;
        return Objects.equal(Long.valueOf(leaderboardScore2.getRank()), Long.valueOf(leaderboardScore.getRank())) && Objects.equal(leaderboardScore2.getDisplayRank(), leaderboardScore.getDisplayRank()) && Objects.equal(Long.valueOf(leaderboardScore2.getRawScore()), Long.valueOf(leaderboardScore.getRawScore())) && Objects.equal(leaderboardScore2.getDisplayScore(), leaderboardScore.getDisplayScore()) && Objects.equal(Long.valueOf(leaderboardScore2.getTimestampMillis()), Long.valueOf(leaderboardScore.getTimestampMillis())) && Objects.equal(leaderboardScore2.getScoreHolderDisplayName(), leaderboardScore.getScoreHolderDisplayName()) && Objects.equal(leaderboardScore2.getScoreHolderIconImageUri(), leaderboardScore.getScoreHolderIconImageUri()) && Objects.equal(leaderboardScore2.getScoreHolderHiResImageUri(), leaderboardScore.getScoreHolderHiResImageUri()) && Objects.equal(leaderboardScore2.getScoreHolder(), leaderboardScore.getScoreHolder()) && Objects.equal(leaderboardScore2.getScoreTag(), leaderboardScore.getScoreTag());
    }
}
