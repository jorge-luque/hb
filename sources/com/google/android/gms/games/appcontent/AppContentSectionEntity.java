package com.google.android.gms.games.appcontent;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.apps.common.proguard.UsedByReflection;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.games.internal.zzc;
import com.google.android.gms.games.internal.zzd;
import java.util.ArrayList;
import java.util.List;

@UsedByReflection("GamesGmsClientImpl.java")
@SafeParcelable.Class(creator = "AppContentSectionEntityCreator")
@SafeParcelable.Reserved({1000})
/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
public final class AppContentSectionEntity extends zzc implements zzi {
    public static final Parcelable.Creator<AppContentSectionEntity> CREATOR = new zzk();
    @SafeParcelable.Field(getter = "getExtras", mo15196id = 5)
    private final Bundle extras;
    @SafeParcelable.Field(getter = "getType", mo15196id = 8)
    private final String type;
    @SafeParcelable.Field(getter = "getTitle", mo15196id = 7)
    private final String zzca;
    @SafeParcelable.Field(getter = "getContentDescription", mo15196id = 4)
    private final String zzfs;
    @SafeParcelable.Field(getter = "getId", mo15196id = 9)
    private final String zzft;
    @SafeParcelable.Field(getter = "getActions", mo15196id = 1)
    private final ArrayList<AppContentActionEntity> zzgc;
    @SafeParcelable.Field(getter = "getAnnotations", mo15196id = 14)
    private final ArrayList<AppContentAnnotationEntity> zzgd;
    @SafeParcelable.Field(getter = "getSubtitle", mo15196id = 6)
    private final String zzgf;
    @SafeParcelable.Field(getter = "getCards", mo15196id = 3)
    private final ArrayList<AppContentCardEntity> zzgl;
    @SafeParcelable.Field(getter = "getCardType", mo15196id = 10)
    private final String zzgm;

    @SafeParcelable.Constructor
    AppContentSectionEntity(@SafeParcelable.Param(mo15199id = 1) ArrayList<AppContentActionEntity> arrayList, @SafeParcelable.Param(mo15199id = 3) ArrayList<AppContentCardEntity> arrayList2, @SafeParcelable.Param(mo15199id = 4) String str, @SafeParcelable.Param(mo15199id = 5) Bundle bundle, @SafeParcelable.Param(mo15199id = 6) String str2, @SafeParcelable.Param(mo15199id = 7) String str3, @SafeParcelable.Param(mo15199id = 8) String str4, @SafeParcelable.Param(mo15199id = 9) String str5, @SafeParcelable.Param(mo15199id = 10) String str6, @SafeParcelable.Param(mo15199id = 14) ArrayList<AppContentAnnotationEntity> arrayList3) {
        this.zzgc = arrayList;
        this.zzgd = arrayList3;
        this.zzgl = arrayList2;
        this.zzgm = str6;
        this.zzfs = str;
        this.extras = bundle;
        this.zzft = str5;
        this.zzgf = str2;
        this.zzca = str3;
        this.type = str4;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzi)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        zzi zzi = (zzi) obj;
        if (!Objects.equal(zzi.getActions(), getActions()) || !Objects.equal(zzi.zzap(), zzap()) || !Objects.equal(zzi.zzax(), zzax()) || !Objects.equal(zzi.zzay(), zzay()) || !Objects.equal(zzi.zzah(), zzah()) || !zzd.zza(zzi.getExtras(), getExtras()) || !Objects.equal(zzi.getId(), getId()) || !Objects.equal(zzi.zzar(), zzar()) || !Objects.equal(zzi.getTitle(), getTitle()) || !Objects.equal(zzi.getType(), getType())) {
            return false;
        }
        return true;
    }

    public final /* bridge */ /* synthetic */ Object freeze() {
        return this;
    }

    public final List<zza> getActions() {
        return new ArrayList(this.zzgc);
    }

    public final Bundle getExtras() {
        return this.extras;
    }

    public final String getId() {
        return this.zzft;
    }

    public final String getTitle() {
        return this.zzca;
    }

    public final String getType() {
        return this.type;
    }

    public final int hashCode() {
        return Objects.hashCode(getActions(), zzap(), zzax(), zzay(), zzah(), Integer.valueOf(zzd.zza(getExtras())), getId(), zzar(), getTitle(), getType());
    }

    public final boolean isDataValid() {
        return true;
    }

    public final String toString() {
        return Objects.toStringHelper(this).add("Actions", getActions()).add("Annotations", zzap()).add("Cards", zzax()).add("CardType", zzay()).add("ContentDescription", zzah()).add("Extras", getExtras()).add("Id", getId()).add("Subtitle", zzar()).add("Title", getTitle()).add("Type", getType()).toString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeTypedList(parcel, 1, getActions(), false);
        SafeParcelWriter.writeTypedList(parcel, 3, zzax(), false);
        SafeParcelWriter.writeString(parcel, 4, this.zzfs, false);
        SafeParcelWriter.writeBundle(parcel, 5, this.extras, false);
        SafeParcelWriter.writeString(parcel, 6, this.zzgf, false);
        SafeParcelWriter.writeString(parcel, 7, this.zzca, false);
        SafeParcelWriter.writeString(parcel, 8, this.type, false);
        SafeParcelWriter.writeString(parcel, 9, this.zzft, false);
        SafeParcelWriter.writeString(parcel, 10, this.zzgm, false);
        SafeParcelWriter.writeTypedList(parcel, 14, zzap(), false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final String zzah() {
        return this.zzfs;
    }

    public final List<zzb> zzap() {
        return new ArrayList(this.zzgd);
    }

    public final String zzar() {
        return this.zzgf;
    }

    public final List<zze> zzax() {
        return new ArrayList(this.zzgl);
    }

    public final String zzay() {
        return this.zzgm;
    }
}
