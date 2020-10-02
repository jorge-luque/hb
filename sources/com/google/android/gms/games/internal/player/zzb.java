package com.google.android.gms.games.internal.player;

import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.data.DataBufferRef;
import com.google.android.gms.common.data.DataHolder;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
public final class zzb extends DataBufferRef implements zza {
    private final zzd zzcz;

    public zzb(DataHolder dataHolder, int i, zzd zzd) {
        super(dataHolder, i);
        this.zzcz = zzd;
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        return MostRecentGameInfoEntity.zza(this, obj);
    }

    public final /* synthetic */ Object freeze() {
        return new MostRecentGameInfoEntity(this);
    }

    public final int hashCode() {
        return MostRecentGameInfoEntity.zza(this);
    }

    public final String toString() {
        return MostRecentGameInfoEntity.zzb(this);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        ((MostRecentGameInfoEntity) ((zza) freeze())).writeToParcel(parcel, i);
    }

    public final String zzdd() {
        return getString(this.zzcz.zzna);
    }

    public final String zzde() {
        return getString(this.zzcz.zznb);
    }

    public final long zzdf() {
        return getLong(this.zzcz.zznc);
    }

    public final Uri zzdg() {
        return parseUri(this.zzcz.zznd);
    }

    public final Uri zzdh() {
        return parseUri(this.zzcz.zzne);
    }

    public final Uri zzdi() {
        return parseUri(this.zzcz.zznf);
    }
}
