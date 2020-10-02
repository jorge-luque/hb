package com.google.android.gms.games.internal.player;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.apps.common.proguard.UsedByReflection;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.games.Players;
import com.google.android.gms.games.internal.zzc;

@UsedByReflection("GamesGmsClientImpl.java")
@SafeParcelable.Class(creator = "ProfileSettingsEntityCreator")
@SafeParcelable.Reserved({1000})
/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
public class ProfileSettingsEntity extends zzc implements Players.zza {
    public static final Parcelable.Creator<ProfileSettingsEntity> CREATOR = new zze();
    @SafeParcelable.Field(getter = "isProfileVisible", mo15196id = 4)
    private final boolean zzcd;
    @SafeParcelable.Field(getter = "getGamerTag", mo15196id = 2)
    private final String zzcf;
    @SafeParcelable.Field(getter = "getStatus", mo15196id = 1)
    private final Status zzhq;
    @SafeParcelable.Field(getter = "isGamerTagExplicitlySet", mo15196id = 3)
    private final boolean zzlz;
    @SafeParcelable.Field(getter = "isVisibilityExplicitlySet", mo15196id = 5)
    private final boolean zzma;
    @SafeParcelable.Field(getter = "getStockProfileImage", mo15196id = 6)
    private final StockProfileImageEntity zzmb;
    @SafeParcelable.Field(getter = "isProfileDiscoverable", mo15196id = 7)
    private final boolean zzmc;
    @SafeParcelable.Field(getter = "isAutoSignInEnabled", mo15196id = 8)
    private final boolean zzmd;
    @SafeParcelable.Field(getter = "getHttpErrorCode", mo15196id = 9)
    private final int zzme;
    @SafeParcelable.Field(getter = "isSettingsChangesProhibited", mo15196id = 10)
    private final boolean zzmf;
    @SafeParcelable.Field(getter = "allowFriendInvites", mo15196id = 11)
    private final boolean zzmg;
    @SafeParcelable.Field(getter = "getProfileVisibility", mo15196id = 12)
    private final int zzmh;

    @SafeParcelable.Constructor
    ProfileSettingsEntity(@SafeParcelable.Param(mo15199id = 1) Status status, @SafeParcelable.Param(mo15199id = 2) String str, @SafeParcelable.Param(mo15199id = 3) boolean z, @SafeParcelable.Param(mo15199id = 4) boolean z2, @SafeParcelable.Param(mo15199id = 5) boolean z3, @SafeParcelable.Param(mo15199id = 6) StockProfileImageEntity stockProfileImageEntity, @SafeParcelable.Param(mo15199id = 7) boolean z4, @SafeParcelable.Param(mo15199id = 8) boolean z5, @SafeParcelable.Param(mo15199id = 9) int i, @SafeParcelable.Param(mo15199id = 10) boolean z6, @SafeParcelable.Param(mo15199id = 11) boolean z7, @SafeParcelable.Param(mo15199id = 12) int i2) {
        this.zzhq = status;
        this.zzcf = str;
        this.zzlz = z;
        this.zzcd = z2;
        this.zzma = z3;
        this.zzmb = stockProfileImageEntity;
        this.zzmc = z4;
        this.zzmd = z5;
        this.zzme = i;
        this.zzmf = z6;
        this.zzmg = z7;
        this.zzmh = i2;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Players.zza)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        Players.zza zza = (Players.zza) obj;
        return Objects.equal(this.zzcf, zza.zzh()) && Objects.equal(Boolean.valueOf(this.zzlz), Boolean.valueOf(zza.zzw())) && Objects.equal(Boolean.valueOf(this.zzcd), Boolean.valueOf(zza.zzk())) && Objects.equal(Boolean.valueOf(this.zzma), Boolean.valueOf(zza.zzu())) && Objects.equal(this.zzhq, zza.getStatus()) && Objects.equal(this.zzmb, zza.zzv()) && Objects.equal(Boolean.valueOf(this.zzmc), Boolean.valueOf(zza.zzx())) && Objects.equal(Boolean.valueOf(this.zzmd), Boolean.valueOf(zza.zzy())) && this.zzme == zza.zzab() && this.zzmf == zza.zzz() && this.zzmg == zza.zzaa() && this.zzmh == zza.zzac();
    }

    public Status getStatus() {
        return this.zzhq;
    }

    public int hashCode() {
        return Objects.hashCode(this.zzcf, Boolean.valueOf(this.zzlz), Boolean.valueOf(this.zzcd), Boolean.valueOf(this.zzma), this.zzhq, this.zzmb, Boolean.valueOf(this.zzmc), Boolean.valueOf(this.zzmd), Integer.valueOf(this.zzme), Boolean.valueOf(this.zzmf), Boolean.valueOf(this.zzmg), Integer.valueOf(this.zzmh));
    }

    public String toString() {
        Objects.ToStringHelper add = Objects.toStringHelper(this).add("GamerTag", this.zzcf).add("IsGamerTagExplicitlySet", Boolean.valueOf(this.zzlz)).add("IsProfileVisible", Boolean.valueOf(this.zzcd)).add("IsVisibilityExplicitlySet", Boolean.valueOf(this.zzma)).add("Status", this.zzhq).add("StockProfileImage", this.zzmb).add("IsProfileDiscoverable", Boolean.valueOf(this.zzmc)).add("AutoSignIn", Boolean.valueOf(this.zzmd)).add("httpErrorCode", Integer.valueOf(this.zzme)).add("IsSettingsChangesProhibited", Boolean.valueOf(this.zzmf));
        char[] cArr = {128, 171, 171, 174, 182, 133, 177, 168, 164, 173, 163, 136, 173, 181, 168, 179, 164, 178};
        for (int i = 0; i < 18; i++) {
            cArr[i] = (char) (cArr[i] - '?');
        }
        return add.add(new String(cArr), Boolean.valueOf(this.zzmg)).add("ProfileVisibility", Integer.valueOf(this.zzmh)).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, getStatus(), i, false);
        SafeParcelWriter.writeString(parcel, 2, this.zzcf, false);
        SafeParcelWriter.writeBoolean(parcel, 3, this.zzlz);
        SafeParcelWriter.writeBoolean(parcel, 4, this.zzcd);
        SafeParcelWriter.writeBoolean(parcel, 5, this.zzma);
        SafeParcelWriter.writeParcelable(parcel, 6, this.zzmb, i, false);
        SafeParcelWriter.writeBoolean(parcel, 7, this.zzmc);
        SafeParcelWriter.writeBoolean(parcel, 8, this.zzmd);
        SafeParcelWriter.writeInt(parcel, 9, this.zzme);
        SafeParcelWriter.writeBoolean(parcel, 10, this.zzmf);
        SafeParcelWriter.writeBoolean(parcel, 11, this.zzmg);
        SafeParcelWriter.writeInt(parcel, 12, this.zzmh);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final boolean zzaa() {
        return this.zzmg;
    }

    public final int zzab() {
        return this.zzme;
    }

    public final int zzac() {
        return this.zzmh;
    }

    public final String zzh() {
        return this.zzcf;
    }

    public final boolean zzk() {
        return this.zzcd;
    }

    public final boolean zzu() {
        return this.zzma;
    }

    public final StockProfileImage zzv() {
        return this.zzmb;
    }

    public final boolean zzw() {
        return this.zzlz;
    }

    public final boolean zzx() {
        return this.zzmc;
    }

    public final boolean zzy() {
        return this.zzmd;
    }

    public final boolean zzz() {
        return this.zzmf;
    }
}
