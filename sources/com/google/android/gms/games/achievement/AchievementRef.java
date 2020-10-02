package com.google.android.gms.games.achievement;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.data.DataBufferRef;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.Asserts;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerRef;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
public final class AchievementRef extends DataBufferRef implements Achievement {
    AchievementRef(DataHolder dataHolder, int i) {
        super(dataHolder, i);
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        return AchievementEntity.zza(this, obj);
    }

    public final /* synthetic */ Object freeze() {
        return new AchievementEntity(this);
    }

    public final String getAchievementId() {
        return getString("external_achievement_id");
    }

    public final String getApplicationId() {
        return getString("external_game_id");
    }

    public final int getCurrentSteps() {
        boolean z = true;
        if (getType() != 1) {
            z = false;
        }
        Asserts.checkState(z);
        return getInteger("current_steps");
    }

    public final String getDescription() {
        return getString("description");
    }

    public final String getFormattedCurrentSteps() {
        boolean z = true;
        if (getType() != 1) {
            z = false;
        }
        Asserts.checkState(z);
        return getString("formatted_current_steps");
    }

    public final String getFormattedTotalSteps() {
        boolean z = true;
        if (getType() != 1) {
            z = false;
        }
        Asserts.checkState(z);
        return getString("formatted_total_steps");
    }

    public final long getLastUpdatedTimestamp() {
        return getLong("last_updated_timestamp");
    }

    public final String getName() {
        return getString("name");
    }

    public final Player getPlayer() {
        return (Player) Preconditions.checkNotNull(zzad());
    }

    public final Uri getRevealedImageUri() {
        return parseUri("revealed_icon_image_uri");
    }

    public final String getRevealedImageUrl() {
        return getString("revealed_icon_image_url");
    }

    public final int getState() {
        return getInteger("state");
    }

    public final int getTotalSteps() {
        boolean z = true;
        if (getType() != 1) {
            z = false;
        }
        Asserts.checkState(z);
        return getInteger("total_steps");
    }

    public final int getType() {
        return getInteger("type");
    }

    public final Uri getUnlockedImageUri() {
        return parseUri("unlocked_icon_image_uri");
    }

    public final String getUnlockedImageUrl() {
        return getString("unlocked_icon_image_url");
    }

    public final long getXpValue() {
        if (!hasColumn("instance_xp_value") || hasNull("instance_xp_value")) {
            return getLong("definition_xp_value");
        }
        return getLong("instance_xp_value");
    }

    public final int hashCode() {
        return AchievementEntity.zza(this);
    }

    public final String toString() {
        return AchievementEntity.zzb(this);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        ((AchievementEntity) ((Achievement) freeze())).writeToParcel(parcel, i);
    }

    public final Player zzad() {
        if (hasNull("external_player_id")) {
            return null;
        }
        return new PlayerRef(this.mDataHolder, this.mDataRow);
    }

    public final float zzae() {
        if (!hasColumn("rarity_percent") || hasNull("rarity_percent")) {
            return -1.0f;
        }
        return getFloat("rarity_percent");
    }

    public final void getDescription(CharArrayBuffer charArrayBuffer) {
        copyToBuffer("description", charArrayBuffer);
    }

    public final void getName(CharArrayBuffer charArrayBuffer) {
        copyToBuffer("name", charArrayBuffer);
    }

    public final void getFormattedCurrentSteps(CharArrayBuffer charArrayBuffer) {
        boolean z = true;
        if (getType() != 1) {
            z = false;
        }
        Asserts.checkState(z);
        copyToBuffer("formatted_current_steps", charArrayBuffer);
    }

    public final void getFormattedTotalSteps(CharArrayBuffer charArrayBuffer) {
        boolean z = true;
        if (getType() != 1) {
            z = false;
        }
        Asserts.checkState(z);
        copyToBuffer("formatted_total_steps", charArrayBuffer);
    }
}
