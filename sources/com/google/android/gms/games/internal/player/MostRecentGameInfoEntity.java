package com.google.android.gms.games.internal.player;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.apps.common.proguard.UsedByReflection;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.games.internal.zzc;

@UsedByReflection("GamesGmsClientImpl.java")
@SafeParcelable.Class(creator = "MostRecentGameInfoEntityCreator")
@SafeParcelable.Reserved({1000})
/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
public final class MostRecentGameInfoEntity extends zzc implements zza {
    public static final Parcelable.Creator<MostRecentGameInfoEntity> CREATOR = new zzc();
    @SafeParcelable.Field(getter = "getGameId", mo15196id = 1)
    private final String zzlt;
    @SafeParcelable.Field(getter = "getGameName", mo15196id = 2)
    private final String zzlu;
    @SafeParcelable.Field(getter = "getActivityTimestampMillis", mo15196id = 3)
    private final long zzlv;
    @SafeParcelable.Field(getter = "getGameIconImageUri", mo15196id = 4)
    private final Uri zzlw;
    @SafeParcelable.Field(getter = "getGameHiResImageUri", mo15196id = 5)
    private final Uri zzlx;
    @SafeParcelable.Field(getter = "getGameFeaturedImageUri", mo15196id = 6)
    private final Uri zzly;

    public MostRecentGameInfoEntity(zza zza) {
        this.zzlt = zza.zzdd();
        this.zzlu = zza.zzde();
        this.zzlv = zza.zzdf();
        this.zzlw = zza.zzdg();
        this.zzlx = zza.zzdh();
        this.zzly = zza.zzdi();
    }

    static int zza(zza zza) {
        return Objects.hashCode(zza.zzdd(), zza.zzde(), Long.valueOf(zza.zzdf()), zza.zzdg(), zza.zzdh(), zza.zzdi());
    }

    static String zzb(zza zza) {
        return Objects.toStringHelper(zza).add("GameId", zza.zzdd()).add("GameName", zza.zzde()).add("ActivityTimestampMillis", Long.valueOf(zza.zzdf())).add("GameIconUri", zza.zzdg()).add("GameHiResUri", zza.zzdh()).add("GameFeaturedUri", zza.zzdi()).toString();
    }

    public final boolean equals(Object obj) {
        return zza(this, obj);
    }

    public final /* bridge */ /* synthetic */ Object freeze() {
        return this;
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
        SafeParcelWriter.writeString(parcel, 1, this.zzlt, false);
        SafeParcelWriter.writeString(parcel, 2, this.zzlu, false);
        SafeParcelWriter.writeLong(parcel, 3, this.zzlv);
        SafeParcelWriter.writeParcelable(parcel, 4, this.zzlw, i, false);
        SafeParcelWriter.writeParcelable(parcel, 5, this.zzlx, i, false);
        SafeParcelWriter.writeParcelable(parcel, 6, this.zzly, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final String zzdd() {
        return this.zzlt;
    }

    public final String zzde() {
        return this.zzlu;
    }

    public final long zzdf() {
        return this.zzlv;
    }

    public final Uri zzdg() {
        return this.zzlw;
    }

    public final Uri zzdh() {
        return this.zzlx;
    }

    public final Uri zzdi() {
        return this.zzly;
    }

    @SafeParcelable.Constructor
    MostRecentGameInfoEntity(@SafeParcelable.Param(mo15199id = 1) String str, @SafeParcelable.Param(mo15199id = 2) String str2, @SafeParcelable.Param(mo15199id = 3) long j, @SafeParcelable.Param(mo15199id = 4) Uri uri, @SafeParcelable.Param(mo15199id = 5) Uri uri2, @SafeParcelable.Param(mo15199id = 6) Uri uri3) {
        this.zzlt = str;
        this.zzlu = str2;
        this.zzlv = j;
        this.zzlw = uri;
        this.zzlx = uri2;
        this.zzly = uri3;
    }

    static boolean zza(zza zza, Object obj) {
        if (!(obj instanceof zza)) {
            return false;
        }
        if (zza == obj) {
            return true;
        }
        zza zza2 = (zza) obj;
        return Objects.equal(zza2.zzdd(), zza.zzdd()) && Objects.equal(zza2.zzde(), zza.zzde()) && Objects.equal(Long.valueOf(zza2.zzdf()), Long.valueOf(zza.zzdf())) && Objects.equal(zza2.zzdg(), zza.zzdg()) && Objects.equal(zza2.zzdh(), zza.zzdh()) && Objects.equal(zza2.zzdi(), zza.zzdi());
    }
}
