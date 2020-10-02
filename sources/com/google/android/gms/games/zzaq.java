package com.google.android.gms.games;

import android.annotation.SuppressLint;
import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.internal.player.zzd;

@SuppressLint({"ParcelCreator"})
/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
public final class zzaq extends zzp implements zzap {
    private final zzd zzcz;

    public zzaq(DataHolder dataHolder, int i, zzd zzd) {
        super(dataHolder, i);
        this.zzcz = zzd;
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        return zzao.zza(this, obj);
    }

    public final /* synthetic */ Object freeze() {
        return new zzao(this);
    }

    public final int hashCode() {
        return zzao.zza(this);
    }

    public final String toString() {
        return zzao.zzb(this);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        new zzao(this).writeToParcel(parcel, i);
    }

    public final int zzq() {
        String str = this.zzcz.zznp;
        if (!hasColumn(str) || hasNull(str)) {
            return -1;
        }
        return getInteger(str);
    }

    public final String zzr() {
        return zza(this.zzcz.zznq, (String) null);
    }

    public final String zzs() {
        return zza(this.zzcz.zznr, (String) null);
    }

    public final boolean zzt() {
        return (zzq() == -1 && zzr() == null && zzs() == null) ? false : true;
    }
}
