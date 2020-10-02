package com.google.android.gms.games.achievement;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.apps.common.proguard.UsedByReflection;
import com.google.android.gms.common.internal.Asserts;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.util.DataUtils;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.games.internal.zzc;

@UsedByReflection("GamesGmsClientImpl.java")
@SafeParcelable.Class(creator = "AchievementEntityCreator")
@SafeParcelable.Reserved({1000})
/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
public final class AchievementEntity extends zzc implements Achievement {
    public static final Parcelable.Creator<AchievementEntity> CREATOR = new zza();
    @SafeParcelable.Field(getter = "getDescription", mo15196id = 4)
    private final String description;
    @SafeParcelable.Field(getter = "getName", mo15196id = 3)
    private final String name;
    @SafeParcelable.Field(getter = "getState", mo15196id = 12)
    private final int state;
    @SafeParcelable.Field(getter = "getType", mo15196id = 2)
    private final int type;
    @SafeParcelable.Field(getter = "getAchievementId", mo15196id = 1)
    private final String zzfe;
    @SafeParcelable.Field(getter = "getUnlockedImageUri", mo15196id = 5)
    private final Uri zzff;
    @SafeParcelable.Field(getter = "getUnlockedImageUrl", mo15196id = 6)
    private final String zzfg;
    @SafeParcelable.Field(getter = "getRevealedImageUri", mo15196id = 7)
    private final Uri zzfh;
    @SafeParcelable.Field(getter = "getRevealedImageUrl", mo15196id = 8)
    private final String zzfi;
    @SafeParcelable.Field(getter = "getTotalStepsRaw", mo15196id = 9)
    private final int zzfj;
    @SafeParcelable.Field(getter = "getFormattedTotalStepsRaw", mo15196id = 10)
    private final String zzfk;
    @SafeParcelable.Field(getter = "getPlayerInternal", mo15196id = 11)
    private final PlayerEntity zzfl;
    @SafeParcelable.Field(getter = "getCurrentStepsRaw", mo15196id = 13)
    private final int zzfm;
    @SafeParcelable.Field(getter = "getFormattedCurrentStepsRaw", mo15196id = 14)
    private final String zzfn;
    @SafeParcelable.Field(getter = "getLastUpdatedTimestamp", mo15196id = 15)
    private final long zzfo;
    @SafeParcelable.Field(getter = "getXpValue", mo15196id = 16)
    private final long zzfp;
    @SafeParcelable.Field(defaultValue = "-1.0f", getter = "getRarityPercent", mo15196id = 17)
    private final float zzfq;
    @SafeParcelable.Field(getter = "getApplicationId", mo15196id = 18)
    private final String zzi;

    public AchievementEntity(Achievement achievement) {
        this.zzfe = achievement.getAchievementId();
        this.type = achievement.getType();
        this.name = achievement.getName();
        this.description = achievement.getDescription();
        this.zzff = achievement.getUnlockedImageUri();
        this.zzfg = achievement.getUnlockedImageUrl();
        this.zzfh = achievement.getRevealedImageUri();
        this.zzfi = achievement.getRevealedImageUrl();
        if (achievement.zzad() != null) {
            this.zzfl = (PlayerEntity) achievement.zzad().freeze();
        } else {
            this.zzfl = null;
        }
        this.state = achievement.getState();
        this.zzfo = achievement.getLastUpdatedTimestamp();
        this.zzfp = achievement.getXpValue();
        this.zzfq = achievement.zzae();
        this.zzi = achievement.getApplicationId();
        if (achievement.getType() == 1) {
            this.zzfj = achievement.getTotalSteps();
            this.zzfk = achievement.getFormattedTotalSteps();
            this.zzfm = achievement.getCurrentSteps();
            this.zzfn = achievement.getFormattedCurrentSteps();
        } else {
            this.zzfj = 0;
            this.zzfk = null;
            this.zzfm = 0;
            this.zzfn = null;
        }
        Asserts.checkNotNull(this.zzfe);
        Asserts.checkNotNull(this.description);
    }

    static int zza(Achievement achievement) {
        int i;
        int i2;
        if (achievement.getType() == 1) {
            i2 = achievement.getCurrentSteps();
            i = achievement.getTotalSteps();
        } else {
            i2 = 0;
            i = 0;
        }
        return Objects.hashCode(achievement.getAchievementId(), achievement.getApplicationId(), achievement.getName(), Integer.valueOf(achievement.getType()), achievement.getDescription(), Long.valueOf(achievement.getXpValue()), Integer.valueOf(achievement.getState()), Long.valueOf(achievement.getLastUpdatedTimestamp()), achievement.zzad(), Integer.valueOf(i2), Integer.valueOf(i));
    }

    static String zzb(Achievement achievement) {
        Objects.ToStringHelper add = Objects.toStringHelper(achievement).add("Id", achievement.getAchievementId()).add("Game Id", achievement.getApplicationId()).add("Type", Integer.valueOf(achievement.getType())).add("Name", achievement.getName()).add("Description", achievement.getDescription()).add("Player", achievement.zzad()).add("State", Integer.valueOf(achievement.getState())).add("Rarity Percent", Float.valueOf(achievement.zzae()));
        if (achievement.getType() == 1) {
            add.add("CurrentSteps", Integer.valueOf(achievement.getCurrentSteps()));
            add.add("TotalSteps", Integer.valueOf(achievement.getTotalSteps()));
        }
        return add.toString();
    }

    public final boolean equals(Object obj) {
        return zza(this, obj);
    }

    public final Achievement freeze() {
        return this;
    }

    public final String getAchievementId() {
        return this.zzfe;
    }

    public final String getApplicationId() {
        return this.zzi;
    }

    public final int getCurrentSteps() {
        boolean z = true;
        if (getType() != 1) {
            z = false;
        }
        Asserts.checkState(z);
        return this.zzfm;
    }

    public final String getDescription() {
        return this.description;
    }

    public final String getFormattedCurrentSteps() {
        boolean z = true;
        if (getType() != 1) {
            z = false;
        }
        Asserts.checkState(z);
        return this.zzfn;
    }

    public final String getFormattedTotalSteps() {
        boolean z = true;
        if (getType() != 1) {
            z = false;
        }
        Asserts.checkState(z);
        return this.zzfk;
    }

    public final long getLastUpdatedTimestamp() {
        return this.zzfo;
    }

    public final String getName() {
        return this.name;
    }

    public final Player getPlayer() {
        return (Player) Preconditions.checkNotNull(this.zzfl);
    }

    public final Uri getRevealedImageUri() {
        return this.zzfh;
    }

    public final String getRevealedImageUrl() {
        return this.zzfi;
    }

    public final int getState() {
        return this.state;
    }

    public final int getTotalSteps() {
        boolean z = true;
        if (getType() != 1) {
            z = false;
        }
        Asserts.checkState(z);
        return this.zzfj;
    }

    public final int getType() {
        return this.type;
    }

    public final Uri getUnlockedImageUri() {
        return this.zzff;
    }

    public final String getUnlockedImageUrl() {
        return this.zzfg;
    }

    public final long getXpValue() {
        return this.zzfp;
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

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, getAchievementId(), false);
        SafeParcelWriter.writeInt(parcel, 2, getType());
        SafeParcelWriter.writeString(parcel, 3, getName(), false);
        SafeParcelWriter.writeString(parcel, 4, getDescription(), false);
        SafeParcelWriter.writeParcelable(parcel, 5, getUnlockedImageUri(), i, false);
        SafeParcelWriter.writeString(parcel, 6, getUnlockedImageUrl(), false);
        SafeParcelWriter.writeParcelable(parcel, 7, getRevealedImageUri(), i, false);
        SafeParcelWriter.writeString(parcel, 8, getRevealedImageUrl(), false);
        SafeParcelWriter.writeInt(parcel, 9, this.zzfj);
        SafeParcelWriter.writeString(parcel, 10, this.zzfk, false);
        SafeParcelWriter.writeParcelable(parcel, 11, this.zzfl, i, false);
        SafeParcelWriter.writeInt(parcel, 12, getState());
        SafeParcelWriter.writeInt(parcel, 13, this.zzfm);
        SafeParcelWriter.writeString(parcel, 14, this.zzfn, false);
        SafeParcelWriter.writeLong(parcel, 15, getLastUpdatedTimestamp());
        SafeParcelWriter.writeLong(parcel, 16, getXpValue());
        SafeParcelWriter.writeFloat(parcel, 17, this.zzfq);
        SafeParcelWriter.writeString(parcel, 18, this.zzi, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final Player zzad() {
        return this.zzfl;
    }

    public final float zzae() {
        return this.zzfq;
    }

    public final void getDescription(CharArrayBuffer charArrayBuffer) {
        DataUtils.copyStringToBuffer(this.description, charArrayBuffer);
    }

    public final void getName(CharArrayBuffer charArrayBuffer) {
        DataUtils.copyStringToBuffer(this.name, charArrayBuffer);
    }

    public final void getFormattedCurrentSteps(CharArrayBuffer charArrayBuffer) {
        boolean z = true;
        if (getType() != 1) {
            z = false;
        }
        Asserts.checkState(z);
        DataUtils.copyStringToBuffer(this.zzfn, charArrayBuffer);
    }

    public final void getFormattedTotalSteps(CharArrayBuffer charArrayBuffer) {
        boolean z = true;
        if (getType() != 1) {
            z = false;
        }
        Asserts.checkState(z);
        DataUtils.copyStringToBuffer(this.zzfk, charArrayBuffer);
    }

    static boolean zza(Achievement achievement, Object obj) {
        if (!(obj instanceof Achievement)) {
            return false;
        }
        if (achievement == obj) {
            return true;
        }
        Achievement achievement2 = (Achievement) obj;
        if (achievement2.getType() != achievement.getType()) {
            return false;
        }
        return (achievement.getType() != 1 || (achievement2.getCurrentSteps() == achievement.getCurrentSteps() && achievement2.getTotalSteps() == achievement.getTotalSteps())) && achievement2.getXpValue() == achievement.getXpValue() && achievement2.getState() == achievement.getState() && achievement2.getLastUpdatedTimestamp() == achievement.getLastUpdatedTimestamp() && Objects.equal(achievement2.getAchievementId(), achievement.getAchievementId()) && Objects.equal(achievement2.getApplicationId(), achievement.getApplicationId()) && Objects.equal(achievement2.getName(), achievement.getName()) && Objects.equal(achievement2.getDescription(), achievement.getDescription()) && Objects.equal(achievement2.zzad(), achievement.zzad()) && achievement2.zzae() == achievement.zzae();
    }

    @SafeParcelable.Constructor
    AchievementEntity(@SafeParcelable.Param(mo15199id = 1) String str, @SafeParcelable.Param(mo15199id = 2) int i, @SafeParcelable.Param(mo15199id = 3) String str2, @SafeParcelable.Param(mo15199id = 4) String str3, @SafeParcelable.Param(mo15199id = 5) Uri uri, @SafeParcelable.Param(mo15199id = 6) String str4, @SafeParcelable.Param(mo15199id = 7) Uri uri2, @SafeParcelable.Param(mo15199id = 8) String str5, @SafeParcelable.Param(mo15199id = 9) int i2, @SafeParcelable.Param(mo15199id = 10) String str6, @SafeParcelable.Param(mo15199id = 11) PlayerEntity playerEntity, @SafeParcelable.Param(mo15199id = 12) int i3, @SafeParcelable.Param(mo15199id = 13) int i4, @SafeParcelable.Param(mo15199id = 14) String str7, @SafeParcelable.Param(mo15199id = 15) long j, @SafeParcelable.Param(mo15199id = 16) long j2, @SafeParcelable.Param(mo15199id = 17) float f, @SafeParcelable.Param(mo15199id = 18) String str8) {
        this.zzfe = str;
        this.type = i;
        this.name = str2;
        this.description = str3;
        this.zzff = uri;
        this.zzfg = str4;
        this.zzfh = uri2;
        this.zzfi = str5;
        this.zzfj = i2;
        this.zzfk = str6;
        this.zzfl = playerEntity;
        this.state = i3;
        this.zzfm = i4;
        this.zzfn = str7;
        this.zzfo = j;
        this.zzfp = j2;
        this.zzfq = f;
        this.zzi = str8;
    }
}
