package com.google.android.gms.games.internal.experience;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.apps.common.proguard.UsedByReflection;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.internal.zzc;

@UsedByReflection("GamesGmsClientImpl.java")
@SafeParcelable.Class(creator = "ExperienceEventEntityCreator")
@SafeParcelable.Reserved({1000})
/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
public final class ExperienceEventEntity extends zzc implements ExperienceEvent {
    public static final Parcelable.Creator<ExperienceEventEntity> CREATOR = new zza();
    @SafeParcelable.Field(getter = "getType", mo15196id = 10)
    private final int type;
    @SafeParcelable.Field(getter = "getExperienceId", mo15196id = 1)
    private final String zzll;
    @SafeParcelable.Field(getter = "getGame", mo15196id = 2)
    private final GameEntity zzlm;
    @SafeParcelable.Field(getter = "getDisplayTitle", mo15196id = 3)
    private final String zzln;
    @SafeParcelable.Field(getter = "getDisplayDescription", mo15196id = 4)
    private final String zzlo;
    @SafeParcelable.Field(getter = "getCreatedTimestamp", mo15196id = 7)
    private final long zzlp;
    @SafeParcelable.Field(getter = "getXpEarned", mo15196id = 8)
    private final long zzlq;
    @SafeParcelable.Field(getter = "getCurrentXp", mo15196id = 9)
    private final long zzlr;
    @SafeParcelable.Field(getter = "getNewLevel", mo15196id = 11)
    private final int zzls;
    @SafeParcelable.Field(getter = "getIconImageUri", mo15196id = 6)
    private final Uri zzn;
    @SafeParcelable.Field(getter = "getIconImageUrl", mo15196id = 5)
    private final String zzy;

    @SafeParcelable.Constructor
    ExperienceEventEntity(@SafeParcelable.Param(mo15199id = 1) String str, @SafeParcelable.Param(mo15199id = 2) GameEntity gameEntity, @SafeParcelable.Param(mo15199id = 3) String str2, @SafeParcelable.Param(mo15199id = 4) String str3, @SafeParcelable.Param(mo15199id = 5) String str4, @SafeParcelable.Param(mo15199id = 6) Uri uri, @SafeParcelable.Param(mo15199id = 7) long j, @SafeParcelable.Param(mo15199id = 8) long j2, @SafeParcelable.Param(mo15199id = 9) long j3, @SafeParcelable.Param(mo15199id = 10) int i, @SafeParcelable.Param(mo15199id = 11) int i2) {
        this.zzll = str;
        this.zzlm = gameEntity;
        this.zzln = str2;
        this.zzlo = str3;
        this.zzy = str4;
        this.zzn = uri;
        this.zzlp = j;
        this.zzlq = j2;
        this.zzlr = j3;
        this.type = i;
        this.zzls = i2;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof ExperienceEvent)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        ExperienceEvent experienceEvent = (ExperienceEvent) obj;
        if (!Objects.equal(experienceEvent.zzcw(), zzcw()) || !Objects.equal(experienceEvent.getGame(), getGame()) || !Objects.equal(experienceEvent.zzcx(), zzcx()) || !Objects.equal(experienceEvent.zzcy(), zzcy()) || !Objects.equal(experienceEvent.getIconImageUrl(), getIconImageUrl()) || !Objects.equal(experienceEvent.getIconImageUri(), getIconImageUri()) || !Objects.equal(Long.valueOf(experienceEvent.zzcz()), Long.valueOf(zzcz())) || !Objects.equal(Long.valueOf(experienceEvent.zzda()), Long.valueOf(zzda())) || !Objects.equal(Long.valueOf(experienceEvent.zzdb()), Long.valueOf(zzdb())) || !Objects.equal(Integer.valueOf(experienceEvent.getType()), Integer.valueOf(getType())) || !Objects.equal(Integer.valueOf(experienceEvent.zzdc()), Integer.valueOf(zzdc()))) {
            return false;
        }
        return true;
    }

    public final /* bridge */ /* synthetic */ Object freeze() {
        return this;
    }

    public final Game getGame() {
        return this.zzlm;
    }

    public final Uri getIconImageUri() {
        return this.zzn;
    }

    public final String getIconImageUrl() {
        return this.zzy;
    }

    public final int getType() {
        return this.type;
    }

    public final int hashCode() {
        return Objects.hashCode(zzcw(), getGame(), zzcx(), zzcy(), getIconImageUrl(), getIconImageUri(), Long.valueOf(zzcz()), Long.valueOf(zzda()), Long.valueOf(zzdb()), Integer.valueOf(getType()), Integer.valueOf(zzdc()));
    }

    public final boolean isDataValid() {
        return true;
    }

    public final String toString() {
        return Objects.toStringHelper(this).add("ExperienceId", zzcw()).add("Game", getGame()).add("DisplayTitle", zzcx()).add("DisplayDescription", zzcy()).add("IconImageUrl", getIconImageUrl()).add("IconImageUri", getIconImageUri()).add("CreatedTimestamp", Long.valueOf(zzcz())).add("XpEarned", Long.valueOf(zzda())).add("CurrentXp", Long.valueOf(zzdb())).add("Type", Integer.valueOf(getType())).add("NewLevel", Integer.valueOf(zzdc())).toString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.zzll, false);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zzlm, i, false);
        SafeParcelWriter.writeString(parcel, 3, this.zzln, false);
        SafeParcelWriter.writeString(parcel, 4, this.zzlo, false);
        SafeParcelWriter.writeString(parcel, 5, getIconImageUrl(), false);
        SafeParcelWriter.writeParcelable(parcel, 6, this.zzn, i, false);
        SafeParcelWriter.writeLong(parcel, 7, this.zzlp);
        SafeParcelWriter.writeLong(parcel, 8, this.zzlq);
        SafeParcelWriter.writeLong(parcel, 9, this.zzlr);
        SafeParcelWriter.writeInt(parcel, 10, this.type);
        SafeParcelWriter.writeInt(parcel, 11, this.zzls);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final String zzcw() {
        return this.zzll;
    }

    public final String zzcx() {
        return this.zzln;
    }

    public final String zzcy() {
        return this.zzlo;
    }

    public final long zzcz() {
        return this.zzlp;
    }

    public final long zzda() {
        return this.zzlq;
    }

    public final long zzdb() {
        return this.zzlr;
    }

    public final int zzdc() {
        return this.zzls;
    }
}
