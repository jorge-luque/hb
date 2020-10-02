package com.google.android.gms.games.internal.game;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.apps.common.proguard.UsedByReflection;
import com.google.android.gms.common.internal.DowngradeableSafeParcel;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.games.internal.GamesDowngradeableSafeParcel;

@UsedByReflection("GamesGmsClientImpl.java")
@SafeParcelable.Class(creator = "GameBadgeEntityCreator")
@SafeParcelable.Reserved({1000})
/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
public final class GameBadgeEntity extends GamesDowngradeableSafeParcel implements zza {
    public static final Parcelable.Creator<GameBadgeEntity> CREATOR = new zza();
    @SafeParcelable.Field(getter = "getDescription", mo15196id = 3)
    private String description;
    @SafeParcelable.Field(getter = "getType", mo15196id = 1)
    private int type;
    @SafeParcelable.Field(getter = "getTitle", mo15196id = 2)
    private String zzca;
    @SafeParcelable.Field(getter = "getIconImageUri", mo15196id = 4)
    private Uri zzn;

    /* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
    static final class zza extends zzb {
        zza() {
        }

        /* renamed from: zzd */
        public final GameBadgeEntity createFromParcel(Parcel parcel) {
            Uri uri;
            if (GamesDowngradeableSafeParcel.zzb(DowngradeableSafeParcel.getUnparcelClientVersion()) || DowngradeableSafeParcel.canUnparcelSafely(GameBadgeEntity.class.getCanonicalName())) {
                return super.createFromParcel(parcel);
            }
            int readInt = parcel.readInt();
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            String readString3 = parcel.readString();
            if (readString3 == null) {
                uri = null;
            } else {
                uri = Uri.parse(readString3);
            }
            return new GameBadgeEntity(readInt, readString, readString2, uri);
        }
    }

    @SafeParcelable.Constructor
    GameBadgeEntity(@SafeParcelable.Param(mo15199id = 1) int i, @SafeParcelable.Param(mo15199id = 2) String str, @SafeParcelable.Param(mo15199id = 3) String str2, @SafeParcelable.Param(mo15199id = 4) Uri uri) {
        this.type = i;
        this.zzca = str;
        this.description = str2;
        this.zzn = uri;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zza)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        zza zza2 = (zza) obj;
        if (!Objects.equal(Integer.valueOf(zza2.getType()), getTitle()) || !Objects.equal(zza2.getDescription(), getIconImageUri())) {
            return false;
        }
        return true;
    }

    public final /* bridge */ /* synthetic */ Object freeze() {
        return this;
    }

    public final String getDescription() {
        return this.description;
    }

    public final Uri getIconImageUri() {
        return this.zzn;
    }

    public final String getTitle() {
        return this.zzca;
    }

    public final int getType() {
        return this.type;
    }

    public final int hashCode() {
        return Objects.hashCode(Integer.valueOf(getType()), getTitle(), getDescription(), getIconImageUri());
    }

    public final boolean isDataValid() {
        return true;
    }

    public final String toString() {
        return Objects.toStringHelper(this).add("Type", Integer.valueOf(getType())).add("Title", getTitle()).add("Description", getDescription()).add("IconImageUri", getIconImageUri()).toString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        if (!shouldDowngrade()) {
            int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
            SafeParcelWriter.writeInt(parcel, 1, this.type);
            SafeParcelWriter.writeString(parcel, 2, this.zzca, false);
            SafeParcelWriter.writeString(parcel, 3, this.description, false);
            SafeParcelWriter.writeParcelable(parcel, 4, this.zzn, i, false);
            SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
            return;
        }
        parcel.writeInt(this.type);
        parcel.writeString(this.zzca);
        parcel.writeString(this.description);
        Uri uri = this.zzn;
        parcel.writeString(uri == null ? null : uri.toString());
    }
}
