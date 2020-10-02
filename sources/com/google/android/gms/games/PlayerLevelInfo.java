package com.google.android.gms.games;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.games.internal.zzc;

@SafeParcelable.Class(creator = "PlayerLevelInfoCreator")
@SafeParcelable.Reserved({1000})
/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
public final class PlayerLevelInfo extends zzc {
    public static final Parcelable.Creator<PlayerLevelInfo> CREATOR = new zzan();
    @SafeParcelable.Field(getter = "getCurrentXpTotal", mo15196id = 1)
    private final long zzcs;
    @SafeParcelable.Field(getter = "getLastLevelUpTimestamp", mo15196id = 2)
    private final long zzct;
    @SafeParcelable.Field(getter = "getCurrentLevel", mo15196id = 3)
    private final PlayerLevel zzcu;
    @SafeParcelable.Field(getter = "getNextLevel", mo15196id = 4)
    private final PlayerLevel zzcv;

    @SafeParcelable.Constructor
    public PlayerLevelInfo(@SafeParcelable.Param(mo15199id = 1) long j, @SafeParcelable.Param(mo15199id = 2) long j2, @SafeParcelable.Param(mo15199id = 3) PlayerLevel playerLevel, @SafeParcelable.Param(mo15199id = 4) PlayerLevel playerLevel2) {
        Preconditions.checkState(j != -1);
        Preconditions.checkNotNull(playerLevel);
        Preconditions.checkNotNull(playerLevel2);
        this.zzcs = j;
        this.zzct = j2;
        this.zzcu = playerLevel;
        this.zzcv = playerLevel2;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof PlayerLevelInfo)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        PlayerLevelInfo playerLevelInfo = (PlayerLevelInfo) obj;
        return Objects.equal(Long.valueOf(this.zzcs), Long.valueOf(playerLevelInfo.zzcs)) && Objects.equal(Long.valueOf(this.zzct), Long.valueOf(playerLevelInfo.zzct)) && Objects.equal(this.zzcu, playerLevelInfo.zzcu) && Objects.equal(this.zzcv, playerLevelInfo.zzcv);
    }

    public final PlayerLevel getCurrentLevel() {
        return this.zzcu;
    }

    public final long getCurrentXpTotal() {
        return this.zzcs;
    }

    public final long getLastLevelUpTimestamp() {
        return this.zzct;
    }

    public final PlayerLevel getNextLevel() {
        return this.zzcv;
    }

    public final int hashCode() {
        return Objects.hashCode(Long.valueOf(this.zzcs), Long.valueOf(this.zzct), this.zzcu, this.zzcv);
    }

    public final boolean isMaxLevel() {
        return this.zzcu.equals(this.zzcv);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeLong(parcel, 1, getCurrentXpTotal());
        SafeParcelWriter.writeLong(parcel, 2, getLastLevelUpTimestamp());
        SafeParcelWriter.writeParcelable(parcel, 3, getCurrentLevel(), i, false);
        SafeParcelWriter.writeParcelable(parcel, 4, getNextLevel(), i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
