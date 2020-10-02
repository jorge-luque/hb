package com.google.android.gms.games;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.games.internal.zzc;

@SafeParcelable.Class(creator = "PlayerLevelCreator")
@SafeParcelable.Reserved({1000})
/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
public final class PlayerLevel extends zzc {
    public static final Parcelable.Creator<PlayerLevel> CREATOR = new zzam();
    @SafeParcelable.Field(getter = "getLevelNumber", mo15196id = 1)
    private final int zzcp;
    @SafeParcelable.Field(getter = "getMinXp", mo15196id = 2)
    private final long zzcq;
    @SafeParcelable.Field(getter = "getMaxXp", mo15196id = 3)
    private final long zzcr;

    @SafeParcelable.Constructor
    public PlayerLevel(@SafeParcelable.Param(mo15199id = 1) int i, @SafeParcelable.Param(mo15199id = 2) long j, @SafeParcelable.Param(mo15199id = 3) long j2) {
        boolean z = true;
        Preconditions.checkState(j >= 0, "Min XP must be positive!");
        Preconditions.checkState(j2 <= j ? false : z, "Max XP must be more than min XP!");
        this.zzcp = i;
        this.zzcq = j;
        this.zzcr = j2;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof PlayerLevel)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        PlayerLevel playerLevel = (PlayerLevel) obj;
        return Objects.equal(Integer.valueOf(playerLevel.getLevelNumber()), Integer.valueOf(getLevelNumber())) && Objects.equal(Long.valueOf(playerLevel.getMinXp()), Long.valueOf(getMinXp())) && Objects.equal(Long.valueOf(playerLevel.getMaxXp()), Long.valueOf(getMaxXp()));
    }

    public final int getLevelNumber() {
        return this.zzcp;
    }

    public final long getMaxXp() {
        return this.zzcr;
    }

    public final long getMinXp() {
        return this.zzcq;
    }

    public final int hashCode() {
        return Objects.hashCode(Integer.valueOf(this.zzcp), Long.valueOf(this.zzcq), Long.valueOf(this.zzcr));
    }

    public final String toString() {
        return Objects.toStringHelper(this).add("LevelNumber", Integer.valueOf(getLevelNumber())).add("MinXp", Long.valueOf(getMinXp())).add("MaxXp", Long.valueOf(getMaxXp())).toString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, getLevelNumber());
        SafeParcelWriter.writeLong(parcel, 2, getMinXp());
        SafeParcelWriter.writeLong(parcel, 3, getMaxXp());
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
